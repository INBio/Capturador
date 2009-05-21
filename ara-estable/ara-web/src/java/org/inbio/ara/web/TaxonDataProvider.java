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
 * TaxonDataProvider.java
 *
 * Created on September 28, 2007, 7:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web;

import com.sun.data.provider.DataProviderException;
import com.sun.data.provider.SortCriteria;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.species.TaxonDescriptionRemote;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.taxon.service.TaxonServiceRemote;

/**
 *
 * @author mvargas
 */
public class TaxonDataProvider extends ObjectListDataProvider {
    
    private List smallSpeciesList = new ArrayList();

    private TaxonServiceRemote lookupTaxonServiceBean() {
        try {
            Context c = new InitialContext();
            return (TaxonServiceRemote) c.lookup("TaxonServiceBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
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
    
    /** Creates a new instance of TaxonDataProvider */
    public TaxonDataProvider() {
        /* needed by netbeans editor */
        // setObjectType(Taxon.class);
        setObjectType(SmallSpecies.class);
        setSmallSpeciesList();
        refreshDP();
        
        
//        smallSpeciesList.add(new SmallSpecies(new Long(1), "Uno"));
//        smallSpeciesList.add(new SmallSpecies(new Long(2), "Dos"));
//        smallSpeciesList.add(new SmallSpecies(new Long(3), "Tres"));
//        
//        this.setList(smallSpeciesList);        
    }
    
    private void setSmallSpeciesList() {
        // List speciesList = lookupTaxonServiceBean().getSpeciesData();
        List speciesList = lookupTaxonDescriptionBean().findAll();
        System.out.println(speciesList.size());
        
        for (int i=0, n=speciesList.size(); i < n; i++) {
//            Object [] data = (Object[]) speciesList.get(i);
//            
//            Long   id          = (Long) data[0];
//            String defaultName = (String) data[1];
            
            
            TaxonDescription taxonDescription = (TaxonDescription) speciesList.get(i);
            
            Long   taxonId     = taxonDescription.getTaxon().getTaxonId();
            String defaultName = "defaultName";
            Long   sequence    = taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();
            
            //smallSpeciesList.add(new SmallSpecies(taxonId, defaultName, sequence));

        }
        
//        smallSpeciesList.add(new SmallSpecies(new Long(1), "Uno"));
//        smallSpeciesList.add(new SmallSpecies(new Long(2), "Dos"));
//        smallSpeciesList.add(new SmallSpecies(new Long(3), "Tres"));
    }
    
    public List getSmallSpeciesList() {
        return smallSpeciesList;
    }

    /* fetch a fresh list of Taxa from ejb layer*/
    public void refreshDP(){
        clearObjectList();
        // setList(lookupTaxonServiceBean().getTaxa(getStartPosition(),getMaxresults(),null));
        setList(getSmallSpeciesList());
        
        // setList(lookupTaxonServiceBean().getSpeciesData());
        // setList(lookupTaxonServiceBean().getAllSpecies());        
    }

    /* Fetch sorted list of Taxa from ejb layer*/
    public void refreshDP(SortCriteria[] sc){
        clearObjectList();
        setList(lookupTaxonServiceBean().getTaxa(getStartPosition(),getMaxresults(),sc));
    }

    /* find count */
    public int getRowCount() throws DataProviderException {
        if(Beans.isDesignTime()){
            return 10;
        }
        return lookupTaxonServiceBean().getCount();}

    /* controls page size*/
    private int maxresults = 10;
    /* starting row*/

    private int startPosition;

    public int getMaxresults() {
        return maxresults;
    }

    public void setMaxresults(int maxresults) {
        this.maxresults = maxresults;}

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public void setLastPosition() {
        startPosition = (lookupTaxonServiceBean().getCount()/maxresults) * maxresults;
    }

    /*move to next page*/
    public void next(){
        if(startPosition + maxresults <= lookupTaxonServiceBean().getCount()){
            startPosition = startPosition + maxresults;
        }
    }

    public void previous(){
        if(startPosition < lookupTaxonServiceBean().getCount()){
            startPosition = startPosition - maxresults;
        }
        if (startPosition < 0){
            startPosition =0;
        }
    }    
    
    public List getAllTaxa() {
        return lookupTaxonServiceBean().getAllTaxa();
    }
    
    public List getSpecies() {
        return lookupTaxonServiceBean().getSpecies(0, 400);
    }
    
    public List getSpeciesIds() {
        return lookupTaxonServiceBean().getSpeciesIds(0, 3000);
    }    
    
    public List getTaxaNames() {
        return lookupTaxonServiceBean().getSons(1);
    }  
    
    public List getTheTopTaxon(long taxonId) {
        return lookupTaxonServiceBean().getTheTopTaxon(taxonId);
    }
    
    public List getTheSons(long taxonId) {
        return lookupTaxonServiceBean().getTheSons(taxonId);
    }
}
