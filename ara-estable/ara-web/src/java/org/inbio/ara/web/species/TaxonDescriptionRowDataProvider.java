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
 * TaxonDescriptionRowDataProvider.java
 *
 * Created on February 5, 2008, 11:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.species;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.species.TaxonDescriptionRecordRemote;
import org.inbio.ara.persistence.species.TaxonDescriptionRow;


/**
 *
 * @author roaguilar
 */
public class TaxonDescriptionRowDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of TaxonDescriptionRowDataProvider */
    public TaxonDescriptionRowDataProvider() {
        this.setObjectType(TaxonDescriptionRow.class);
        refreshDataList(0L, 0L, 0L);
    }
    
    public TaxonDescriptionRowDataProvider(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        this.setObjectType(TaxonDescriptionRow.class);
        refreshDataList(categoryId, taxonId, taxonDescriptionSequence);
    }
    
    public void refreshDataList(Long categoryId, Long taxonId, Long taxonDescriptionSequenceId) {
        this.setList(this.lookupTaxonDescriptionRecordBean().getTaxonDescriptionRowList(categoryId, taxonId, taxonDescriptionSequenceId));
    }

    private TaxonDescriptionRecordRemote lookupTaxonDescriptionRecordBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionRecordRemote) c.lookup("TaxonDescriptionRecordBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}
