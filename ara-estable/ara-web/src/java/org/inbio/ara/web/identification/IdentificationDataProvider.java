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
 * IdentificationDataProvider.java
 *
 * Created on June 24, 2008, 11:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.identification;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.IdentificationRemote;
import org.inbio.ara.persistence.specimen.Identification;

/**
 *
 * @author roaguilar
 */
public class IdentificationDataProvider extends ObjectListDataProvider{
    
    private Long collectionId;
    
    /** Creates a new instance of IdentificationDataProvider */
    public IdentificationDataProvider() {
        this.setObjectType(Identification.class);
        refreshList();
    }
    
    public IdentificationDataProvider(Long collectionId) {
        this.collectionId = collectionId;
        this.setObjectType(Identification.class);
        refreshList();
    }
    
    public void refreshList() {
        //this.setList(lookupIdentificationBean().getIdentification());
        this.setList(this.lookupIdentificationBean().getIdentificationByCollection(collectionId));
    }

    private IdentificationRemote lookupIdentificationBean() {
        try {
            Context c = new InitialContext();
            return (IdentificationRemote) c.lookup("IdentificationBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
}
