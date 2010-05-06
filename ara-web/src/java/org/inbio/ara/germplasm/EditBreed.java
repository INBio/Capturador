/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditBreed.java
 * @version Created on 08/04/2010, 09:28:47 AM
 * @author dasolano
 */

public class EditBreed extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private SingleSelectOptionsList scientificName = new SingleSelectOptionsList();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditBreed() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("EditBreed Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        getScientificName().setOptions(updateTaxonListAction(new Long (18)));
    }

    /**
     * Return the taxon list for germplasm
     * @param taxonList
     * @return
     */
    private Option[] setTaxonListOptions(List<TaxonDTO> taxonList)
    {

        Option[] allOptionsInArray = null;
        Option option = null;
        ArrayList<Option> allOptions = new ArrayList<Option>();
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        if(taxonList != null)
        {
            for (TaxonDTO taxon : taxonList) {
                //System.out.println(taxon.getDefaultName());
                option = new Option(taxon.getTaxonKey(), taxon.getDefaultName());
                allOptions.add(option);

            }

        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Update the taxon drop down
     * @return
     */
    public Option[] updateTaxonListAction(Long taxonomicLevel) {

        List<TaxonDTO> taxonList = getgermplasm$BreedSessionBean().
                getGermplasmFacadeRemote().
                getAllTaxonsByCollectionIdAndTaxonomicalRangeId(
                getAraSessionBean().getGlobalCollectionId(), taxonomicLevel);

            return this.setTaxonListOptions(taxonList);

    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * Performed the update action
     * @return
     */
    public String updateBreed()
    {
        try
        {
            getgermplasm$BreedSessionBean().getBreedDTO().setUserName(
                    getAraSessionBean().getGlobalUserName());
            getgermplasm$BreedSessionBean().getGermplasmFacadeRemote().updateBreed(
                    getgermplasm$BreedSessionBean().getBreedDTO());
            getgermplasm$BreedSessionBean().getPagination().refreshList();
            MessageBean.setSuccessMessageFromBundle("update_breed_success", this.getMyLocale());
        }
        catch(Exception e)
        {
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
        }
        return null;
    }

     /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected BreedSessionBean getgermplasm$BreedSessionBean() {
        return (BreedSessionBean) getBean("germplasm$BreedSessionBean");
    }

    /**
     * @return the scientificName
     */
    public SingleSelectOptionsList getScientificName() {
        return scientificName;
    }

    /**
     * @param scientificName the scientificName to set
     */
    public void setScientificName(SingleSelectOptionsList scientificName) {
        this.scientificName = scientificName;
    }
    
}

