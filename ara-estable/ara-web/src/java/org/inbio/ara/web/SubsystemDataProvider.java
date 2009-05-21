/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */ 
/*
 * SubsystemDataProvider.java
 *
 * Created on May 13, 2008, 4:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.security.UserBeanV2Remote;
import org.inbio.ara.persistence.security.SimpleSubsystem;

/**
 *
 * @author roaguilar
 */
public class SubsystemDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of SubsystemDataProvider */
    public SubsystemDataProvider(Long groupId) {
        this.setObjectType(SimpleSubsystem.class);
        refreshDataList(groupId);
    }
    
    private void refreshDataList(Long groupId) {
        this.setList(this.lookupUserBean().getGroupSubsystems(groupId));
    }

    private UserBeanV2Remote lookupUserBean() {
        try {
            Context c = new InitialContext();
            return (UserBeanV2Remote) c.lookup("UserBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
}
