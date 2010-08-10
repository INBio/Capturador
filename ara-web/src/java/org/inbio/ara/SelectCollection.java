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

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import com.sun.webui.jsf.component.Listbox;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SelectCollection.java
 * @version Created on 22/09/2009, 04:33:55 PM
 * @author esmata
 */

public class SelectCollection extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultOptionsList listbTaxonsDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListbTaxonsDefaultOptions() {
        return listbTaxonsDefaultOptions;
    }

    public void setListbTaxonsDefaultOptions(DefaultOptionsList dol) {
        this.listbTaxonsDefaultOptions = dol;
    }
    private DefaultOptionsList listbNomenclaturalDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListbNomenclaturalDefaultOptions() {
        return listbNomenclaturalDefaultOptions;
    }

    public void setListbNomenclaturalDefaultOptions(DefaultOptionsList dol) {
        this.listbNomenclaturalDefaultOptions = dol;
    }

    // </editor-fold>

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

    //Binding de componentes graficos
    private Listbox collectionList = new Listbox();
    private Listbox nomenclaturalList = new Listbox();

    private Long selectedCollection = null;
    private Long selectedNomenclatural = null;

    //En esta variable se setearan los datos de la lista de colecciones a escoger
    private SingleSelectOptionsList taxonUserData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos de la lista de grupos nomenclaturales a escoger
    private SingleSelectOptionsList nomenclaturalGroupData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SelectCollection() {
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
            log("SelectCollection Initialization Failure", e);
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
        this.taxonUserData.setOptions(getTaxonUserListData());
        this.nomenclaturalGroupData.setOptions(getNomenclaturalUserListData());
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
     * Obtener los datos de la lista de taxonUser (collecciones)
     */
    public Option[] getTaxonUserListData(){
        Long userId = this.getAraSessionBean().getGlobalUserNameId();
        List<TaxonDTO> DTOList = this.getSessionManager().getUserTaxonList(userId);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear las opciones del list
        for(TaxonDTO myDTO : DTOList){
            option = new Option(myDTO.getCollectionId(),myDTO.getCurrentName());            
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Obtener los datos de la lista de nomenclatural groups
     */
    public Option[] getNomenclaturalUserListData(){
        Long userId = this.getAraSessionBean().getGlobalUserNameId();
        List<NomenclaturalGroupDTO> DTOList = this.getSessionManager().getNomenclaturalGroupList(userId);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear las opciones del list
        for(NomenclaturalGroupDTO myDTO : DTOList){
            //option = new Option(myDTO.getCollectionId(),myDTO.getName());
            option = new Option(myDTO.getNomenclaturalGroupId(),myDTO.getName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * @return the taxonUserData
     */
    public SingleSelectOptionsList getTaxonUserData() {
        return taxonUserData;
    }

    /**
     * @param taxonUserData the taxonUserData to set
     */
    public void setTaxonUserData(SingleSelectOptionsList taxonUserData) {
        this.taxonUserData = taxonUserData;
    }

    /**
     * @return the nomenclaturalGroupData
     */
    public SingleSelectOptionsList getNomenclaturalGroupData() {
        return nomenclaturalGroupData;
    }

    /**
     * @param nomenclaturalGroupData the nomenclaturalGroupData to set
     */
    public void setNomenclaturalGroupData(SingleSelectOptionsList nomenclaturalGroupData) {
        this.nomenclaturalGroupData = nomenclaturalGroupData;
    }

    /**
     * Metodo ejecutado por el boton de seleccionar coleccion o grupo nomenclatural
     * @return
     */
    public String btnSelectCollection_action() {

        Long collection = this.getSelectedCollection();
        Long nomenclatural = this.getSelectedNomenclatural();
        
        if(collection==null&&nomenclatural==null){
            MessageBean.setErrorMessageFromBundle("no_selected_option", this.getMyLocale());
            return null;
        }
        else if(collection!=null){
            
            this.getAraSessionBean().setGlobalCollectionId(collection);
            return "next";
        }
        else if(nomenclatural!=null){
            
            //this.getAraSessionBean().setGlobalCollectionId(nomenclatural);
            this.getAraSessionBean().setGlobalNomenclaturalGroupId(nomenclatural);
            return "next";
        }
        else
            return null;
    }

    /**
     * @return the collectionList
     */
    public Listbox getCollectionList() {
        return collectionList;
    }

    /**
     * @param collectionList the collectionList to set
     */
    public void setCollectionList(Listbox collectionList) {
        this.collectionList = collectionList;
    }

    /**
     * @return the nomenclaturalList
     */
    public Listbox getNomenclaturalList() {
        return nomenclaturalList;
    }

    /**
     * @param nomenclaturalList the nomenclaturalList to set
     */
    public void setNomenclaturalList(Listbox nomenclaturalList) {
        this.nomenclaturalList = nomenclaturalList;
    }


    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the selectedCollection
     */
    public Long getSelectedCollection() {
        return selectedCollection;
    }

    /**
     * @param selectedCollection the selectedCollection to set
     */
    public void setSelectedCollection(Long selectedCollection) {
        this.selectedCollection = selectedCollection;
    }

    /**
     * @return the selectedNomenclatural
     */
    public Long getSelectedNomenclatural() {
        return selectedNomenclatural;
    }

    /**
     * @param selectedNomenclatural the selectedNomenclatural to set
     */
    public void setSelectedNomenclatural(Long selectedNomenclatural) {
        this.selectedNomenclatural = selectedNomenclatural;
    }

    public String btnExit_action() {
        return "exit";
    }
    
}

