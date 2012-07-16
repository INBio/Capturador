/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.AutoComplete;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.persistence.person.ProfileEntity;

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
 * @version PersonAutoCompleteSessionBean.java
 * @version Created on 06/04/2011, 02:49:40 PM
 * @author gsulca
 */

public class PersonAutoCompleteSessionBean extends OptionsList implements AutoComplete {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

 //EJB Dependencies Injection
    @EJB
    private InventoryFacadeRemote inventoryFacade;

    //Maximun number of results
    public final int MAX_RESULTS= 5;
    //Result list
    Option[] options = new Option[0];
    private Long profileId;

    private String text = "";

    private Map<String, Long> optionHash = new HashMap<String, Long>();


    //Constructor
    public PersonAutoCompleteSessionBean() {

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

    public Long getIdSelected()
    {
       return this.optionHash.get(text);
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
        List<PersonDTO> personDTOs =
                this.getInventoryFacade().getPersonByFilterProfile(profileId,filter);
        int size = personDTOs.size();
        options = new Option[size];
        for(int i=0;i<size;i++){
            PersonDTO aux = personDTOs.get(i);
            options[i] = new Option(aux.getNaturalLongName(),aux.getNaturalLongName());
            optionHash.put(aux.getNaturalLongName(), aux.getPersonKey());
        }
        System.out.println("Cantidad de opciones = "+ options.length);
        return true;
    }

    /**
     * @return the taxonomyFacade
     */
    public InventoryFacadeRemote getInventoryFacade() {
        return inventoryFacade;
    }

    /**
     * @param taxonomyFacade the taxonomyFacade to set
     */
    public void setInventoryFacade(InventoryFacadeRemote inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
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

    /**
     * @return the profileId
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
