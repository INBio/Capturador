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
 * NomenclaturalGroupDataProvider.java
 *
 * Created on June 28, 2008, 1:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.nomenclaturalgroup;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.taxonomy.NomenclaturalGroupRemote;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;

/**
 *
 * @author roaguilar
 */
public class NomenclaturalGroupDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of NomenclaturalGroupDataProvider */
    public NomenclaturalGroupDataProvider() {
        this.setObjectType(NomenclaturalGroup.class);
    }
    
    public void refreshList() {
        this.setList(lookupNomenclaturalGroupBean().getNomenclaturalGroup());
    }

    private NomenclaturalGroupRemote lookupNomenclaturalGroupBean() {
        try {
            Context c = new InitialContext();
            return (NomenclaturalGroupRemote) c.lookup("NomenclaturalGroupBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}
