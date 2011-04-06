/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.gis;

import com.sun.webui.jsf.model.AutoComplete;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.facade.gis.GisFacadeRemote;

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
 * @version SiteAutoCompleteSessionBean.java
 * @version Created on 05/04/2011, 09:51:09 AM
 * @author dasolano
 */

public class SiteAutoCompleteSessionBean extends OptionsList implements AutoComplete {
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
    private GisFacadeRemote gisFacadeRemote;

    //Maximun number of results
    public final int MAX_RESULTS= 5;
    //Result list
    private Option[] options = new Option[0];
    private String text = "";

    private Map<String, Long> optionHash = new HashMap<String, Long>();
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SiteAutoCompleteSessionBean() {
    }

    //Extends OptionsList
    @Override
    public void setOptions(Option[] o) {
        this.options = o;
    }
    
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
        List<SiteDTO> siteDTOs =
                this.getGisFacadeRemote().getSiteByDescription(filter, 0, MAX_RESULTS);
        int size = siteDTOs.size();
        setOptions(new Option[siteDTOs.size()]);
        SiteDTO aux;
        for(int i=0;i<size;i++){
            aux = siteDTOs.get(i);
            //options[i] = new Option(aux.getTaxonKey(),aux.getDefaultName().trim());
            options[i] = new Option(aux.getDescription().trim(),aux.getDescription().trim());
            optionHash.put(aux.getDescription().trim(), aux.getSiteId());
        }
        return true;
    }
    
    /**
     * @return the gisFacadeRemote
     */
    public GisFacadeRemote getGisFacadeRemote() {
        return gisFacadeRemote;
    }

    /**
     * @param gisFacadeRemote the gisFacadeRemote to set
     */
    public void setGisFacadeRemote(GisFacadeRemote gisFacadeRemote) {
        this.gisFacadeRemote = gisFacadeRemote;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
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

    public Long getIdSelected()
    {
       return this.optionHash.get(text);
    }
    
    
}
