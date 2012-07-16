/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara;

import com.sun.webui.jsf.model.AutoComplete;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.facade.search.SearchFacadeRemote;

/**
 * @version AutoCompleteBean.java
 * @version Created on Jan 21, 2011, 9:54:26 AM
 * @author esmata
 */

public class AutoCompleteSessionBean extends OptionsList implements AutoComplete {

    //EJB Dependencies Injection
    @EJB
    private SearchFacadeRemote searchFacade;

    //Maximun number of results
    public final int MAX_RESULTS= 5;
    //Result list
    Option[] options = new Option[0];


    //Constructor
    public AutoCompleteSessionBean() {
    }

    //Extends OptionsList
    @Override
    public void setOptions(Option[] o) {
        this.options = o;
    }

    //Implements AutoComplete
    public Option[] getOptions(String filter) {
        this.filter(filter);
        return this.options;
    }

    //Method that retrive the corresponding results
    public boolean filter(String filter) {
        // If null, do nothing
        if(filter == null || filter.length() < 3){
            return false;
        }
        /*else{ //If not null, convert the string into lowercase
            filter = filter.toLowerCase();
        }*/
        //Make query with filter parameter
        List<SiteDTO> localities =
                this.getSearchFacade().searchSiteByCriteria(filter, 0, MAX_RESULTS);
        int size = localities.size();
        options = new Option[size];
        for(int i=0;i<size;i++){
            SiteDTO aux = localities.get(i);
            options[i] = new Option(aux.getSiteId(),aux.getDescription().trim());
        }        
        return true;
    }

    /**
     * @return the searchFacade
     */
    public SearchFacadeRemote getSearchFacade() {
        return searchFacade;
    }

    /**
     * @param searchFacade the searchFacade to set
     */
    public void setSearchFacade(SearchFacadeRemote searchFacade) {
        this.searchFacade = searchFacade;
    }
}