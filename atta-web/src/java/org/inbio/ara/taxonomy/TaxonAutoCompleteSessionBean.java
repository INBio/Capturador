/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.AutoComplete;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version TaxonAutoCompleteSessionBean.java
 * @version Created on 18/03/2011, 11:33:15 AM
 * @author gsulca
 */

public class TaxonAutoCompleteSessionBean extends OptionsList implements AutoComplete {

    //EJB Dependencies Injection
    @EJB
    private TaxonomyFacadeRemote taxonomyFacade;

    //Maximun number of results
    public final int MAX_RESULTS= 5;
    //Result list
    Option[] options = new Option[0];
    private Long kingdomId = new Long(-1L);
    private Long categoryId = new Long(-1L);
    private String text = "";

    private Map<String, Long> optionHash = new HashMap<String, Long>();


    //Constructor
    public TaxonAutoCompleteSessionBean() {

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
        //System.out.println("filter = "+filter);
        //set hash map
        optionHash = new HashMap<String, Long>();
        this.text = filter;
        // If null, do nothing
        if(filter == null || filter.length() < 3){
            return false;
        }       
        //Make query with filter parameter
        List<TaxonDTO> taxonDTOs =
                this.getTaxonomyFacade().getTaxonByName(filter, kingdomId, categoryId,0, MAX_RESULTS);
        int size = taxonDTOs.size();
        options = new Option[size];
        for(int i=0;i<size;i++){
            TaxonDTO aux = taxonDTOs.get(i);
            //options[i] = new Option(aux.getTaxonKey(),aux.getDefaultName().trim());
            options[i] = new Option(aux.getDefaultName().trim(),aux.getDefaultName().trim());
            optionHash.put(aux.getDefaultName().trim(), aux.getTaxonKey());
        }
        System.out.println("Cantidad de opciones = "+ options.length);
        return true;
    }

    /**
     * @return the taxonomyFacade
     */
    public TaxonomyFacadeRemote getTaxonomyFacade() {
        return taxonomyFacade;
    }

    /**
     * @param taxonomyFacade the taxonomyFacade to set
     */
    public void setTaxonomyFacade(TaxonomyFacadeRemote taxonomyFacade) {
        this.taxonomyFacade = taxonomyFacade;
    }

    /**
     * @return the kingdomId
     */
    public Long getKingdomId() {
        return kingdomId;
    }

    /**
     * @param kingdomId the kingdomId to set
     */
    public void setKingdomId(Long kingdomId) {
        this.kingdomId = kingdomId;
    }

    /**
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    /**
     * @return the text
     */
    public String getText() {
        //this.text = this.getSelectedValue().toString();
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String filter) {
        this.text = filter;
    }

    /**
     * @return the optionHash
     */
    public Map<String, Long> getOptionHash() {
        return optionHash;
    }

    /**
     * @param optionHash the optionHash to set
     */
    public void setOptionHash(Map<String, Long> optionHash) {
        this.optionHash = optionHash;
    }
}