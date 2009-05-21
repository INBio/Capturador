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
 * generatedSpecimenDataProvider.java
 *
 * Created on August 1, 2008, 12:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.gathering;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.SpecimenIdentificationGeneratorRemote;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author roaguilar
 */
public class GeneratedSpecimenDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of generatedSpecimenDataProvider */
    public GeneratedSpecimenDataProvider() {
        this.setObjectType(Specimen.class);
    }
    
    public void refreshList() {
        this.setList(this.lookupSpecimenIdentificationGeneratorBean().getSpecimenList());
    }

    private SpecimenIdentificationGeneratorRemote lookupSpecimenIdentificationGeneratorBean() {
        try {
            Context c = new InitialContext();
            return (SpecimenIdentificationGeneratorRemote) c.lookup("SpecimenIdentificationGeneratorBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
}
