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
 * TaxonDescriptionDataProvider.java
 *
 * Created on March 31, 2008, 5:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.species;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.species.TaxonDescriptionRemote;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.web.SmallSpecies;

/**
 *
 * @author mvargas
 */
public class TaxonDescriptionDataProvider  extends ObjectListDataProvider {
    
    private List smallSpeciesList = new ArrayList();
    
    
    /** Creates a new instance of TaxonDescriptionDataProvider */
    public TaxonDescriptionDataProvider() {
        this.setObjectType(SmallSpecies.class);
        setSmallSpeciesList();
        refreshDataList();        
    }

    
    public void refreshDataList() {
        clearObjectList();
        setSmallSpeciesList();//herson
        setList(getSmallSpeciesList());
    }
    
    
    private void setSmallSpeciesList() {
        List speciesList = lookupTaxonDescriptionBean().findAll();
        System.out.println(speciesList.size());
        
        for (int i=0, n=speciesList.size(); i < n; i++) {
            TaxonDescription taxonDescription = (TaxonDescription) speciesList.get(i);
            
            Long   taxonId     = taxonDescription.getTaxon().getTaxonId();
            String defaultName = taxonDescription.getTaxon().getDefaultName();
            String family      = taxonDescription.getTaxon().getFamilyTaxon().getDefaultName();
            String kingdom     = taxonDescription.getTaxon().getKingdomTaxon().getDefaultName();
            Long   sequence    = taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();
            
            smallSpeciesList.add(new SmallSpecies(taxonId, defaultName, family, kingdom, sequence));
        }
    }
    
    
    public List getSmallSpeciesList() {
        return smallSpeciesList;
    }    
    
    
    private TaxonDescriptionRemote lookupTaxonDescriptionBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionRemote) c.lookup("TaxonDescriptionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }    
    
}