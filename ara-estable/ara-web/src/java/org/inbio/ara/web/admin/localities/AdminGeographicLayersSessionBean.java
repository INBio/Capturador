/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.admin.localities;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.GeographicLayerDTO;
import org.inbio.ara.dto.GeographicLayerValueDTO;
import org.inbio.ara.manager.SiteManagerRemote;
import org.inbio.ara.web.util.ValidatorHelper;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.AraApplicationBean;

/**
 *
 * Idealmente se intentará poner acá toda la funcionalidad que necesiten
 * los JSP's y que sea referente al manejo de listas de seleccion. Esta clase
 * sería el convertidor entre el mundo del modelo y el mundo de lo que necesiten los jsp's
 * para funcionar.
 *
 * @author jgutierrez
 */
public class AdminGeographicLayersSessionBean extends AbstractSessionBean {

    /**
     * Managers
     */
    @EJB
    private SiteManagerRemote siteManager;


    /**
     * Variables
     */

    /** Datos del DropDown que para los efectos de este codigo seran siempre paises! **/
    private SingleSelectOptionsList geographicLayers = new SingleSelectOptionsList();

    /** Datos del DropDown que para los efectos de este codigo seran siempre paises! **/
    private SingleSelectOptionsList geographicLayerValues = new SingleSelectOptionsList();

    /** Optional filter by: ancestor geographic Layer Values**/
    private SingleSelectOptionsList ancestorGeographicLayerValues = new SingleSelectOptionsList();

    /** Para los efectos de este codigo sera selectedCountryId**/
    private Long INVALID_VALUE_ID = new Long(-1);
    private Long NEW_VALUE_ID = new Long(-2);
    //private Long EDIT_VALUE_ID = new Long(-3);
    
    private GeographicLayerDTO selectedGeographicLayerDTO;
    private GeographicLayerValueDTO selectedGeographicLayerValueDTO;
    private GeographicLayerValueDTO editingGeographicLayerValueDTO;

    private Long selectedFilterAncestorGeographicLayerId = INVALID_VALUE_ID;


    private boolean hasAncestor;
    private boolean isEditingValue;

    /* Lista de Seleccion que se está mostrando*/
    //private ListTable actualSelectionList = null;


    /**
     * <p>Construct a new session data bean instance.</p>admi
     */
    public AdminGeographicLayersSessionBean() {
      
    }



   /**
     * Carga todos los layers en el dropdown y deja alguno como el seleccionado.
     */
    public void setGeographicalLayersDropDownData(){

        List<GeographicLayerDTO> gsDTOList = getSiteManager().getAllGeographicalLayers();

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        for(GeographicLayerDTO gsDTO : gsDTOList){
            option = new Option(gsDTO.getGeographicalLayerKey(), gsDTO.getName());
            allOptions.add(option);
        }

        //define el selected value por el valor de la variable de clase actualSelectionListId
        if(selectedGeographicLayerDTO.getGeographicalLayerKey().equals(INVALID_VALUE_ID)){
           if(gsDTOList.size() > 0)
               selectedGeographicLayerDTO = gsDTOList.get(0);
        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.getGeographicLayers().setOptions(allOptions.toArray(allOptionsInArray));

    }


    /**
     * Se mofico la capa seleccionada
     * En el dropdown: geographicLayer
     */
    public void onGeographicLayerChange(){
        Long actualSelectedId = selectedGeographicLayerDTO.getGeographicalLayerKey();
        selectedGeographicLayerDTO = siteManager.getAllGeographicalLayer(actualSelectedId);

        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO(INVALID_VALUE_ID,INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        if(selectedGeographicLayerDTO.getAncestorKey() == null)
            hasAncestor = false;
        else
            hasAncestor = true;

        isEditingValue = false;
        updateGeographicLayersValuesDropDownData();

        selectedFilterAncestorGeographicLayerId = INVALID_VALUE_ID;
        updateAncestorGeographicLayerValuesDropDownData();
    }

    /**
     * Se modifico el valor de la capa seleccionada
     * En el dropdown: geographicLayerValues
     */
    public void onGeographicLayerValueChange(){
        Long actualSelectedValueId = selectedGeographicLayerValueDTO.getGeographicLayerValueKey();
        selectedGeographicLayerValueDTO = siteManager.getAllGeographicalLayerValueForGeographicLayerAndId(selectedGeographicLayerDTO.getGeographicalLayerKey(), actualSelectedValueId);
        selectedFilterAncestorGeographicLayerId = INVALID_VALUE_ID;
        isEditingValue = false;
    }

    /**
     * Se modifico el valor del layer que filtra que values se muestran
     * En el dropdown: ancestorGeographicLayerValues
     */
    public void onAncestorGeographicLayerValueChange(){
        //selectedGeographicLayerDTO
        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO(INVALID_VALUE_ID, INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        updateGeographicLayersValuesDropDownData();
        isEditingValue = false;
    }

    public void newGeographicLayerValue(){
        isEditingValue = true;
        editingGeographicLayerValueDTO = new GeographicLayerValueDTO(selectedGeographicLayerDTO.getGeographicalLayerKey(),NEW_VALUE_ID, "", selectedFilterAncestorGeographicLayerId, "");
    }

    public void editGeographicLayerValue(){
        isEditingValue = true;
        Long actualSelectedValueId = selectedGeographicLayerValueDTO.getGeographicLayerValueKey();
        selectedGeographicLayerValueDTO = siteManager.getAllGeographicalLayerValueForGeographicLayerAndId(selectedGeographicLayerDTO.getGeographicalLayerKey(), actualSelectedValueId);
        editingGeographicLayerValueDTO = selectedGeographicLayerValueDTO;


    }

    public void saveGeographicLayerValue(){

        if(editingGeographicLayerValueDTO.getGeographicLayerValueKey().equals(NEW_VALUE_ID))
            editingGeographicLayerValueDTO.setGeographicLayerValueKey(null);

        siteManager.saveOrUpdateGeographicLayerValue(editingGeographicLayerValueDTO);
        isEditingValue = false;

        updateGeographicLayersValuesDropDownData();
    }

    /**
     * Carga todos los layers en el dropdown y deja alguno como el seleccionado.
     */
    public void updateGeographicLayersValuesDropDownData(){

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        List<GeographicLayerValueDTO> glvDTOList = null;

         if(!selectedGeographicLayerDTO.getGeographicalLayerKey().equals(INVALID_VALUE_ID)){

            if(!selectedFilterAncestorGeographicLayerId.equals(INVALID_VALUE_ID))
                glvDTOList = getSiteManager().getAllGeographicalLayerValuesForGeographicLayerAndAncestor(selectedGeographicLayerDTO.getGeographicalLayerKey(),selectedFilterAncestorGeographicLayerId);
            else
                glvDTOList = getSiteManager().getAllGeographicalLayerValuesForGeographicLayer(selectedGeographicLayerDTO.getGeographicalLayerKey());

            if(glvDTOList != null){
                for(GeographicLayerValueDTO glvDTO : glvDTOList){
                    option = new Option(glvDTO.getGeographicLayerValueKey(), glvDTO.getName());
                    allOptions.add(option);
                }
            }
                
        } else {
            option = new Option(INVALID_VALUE_ID, "");
            allOptions.add(option);

        }

        //define el selected value por el valor de la variable de clase actualSelectionListId
        //    if(glvDTOList != null){
        //        if(glvDTOList.size() > 0)
        //            selectedGeographicLayerValueDTO = glvDTOList.get(0);
        //     }
        

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.getGeographicLayerValues().setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     *
     */
    public void updateAncestorGeographicLayerValuesDropDownData(){
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        allOptions.add(new Option(INVALID_VALUE_ID, ""));

        if(hasAncestor){

            List<GeographicLayerValueDTO> glvDTOList = getSiteManager().getAllGeographicalLayerValuesForGeographicLayer(selectedGeographicLayerDTO.getAncestorKey());

            for(GeographicLayerValueDTO glvDTO : glvDTOList){
                option = new Option(glvDTO.getGeographicLayerValueKey(), glvDTO.getName());
                allOptions.add(option);
            }

        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.getAncestorGeographicLayerValues().setOptions(allOptions.toArray(allOptionsInArray));
    }



 /**
     * <p>This method is called when this bean is initially added to
     * request scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * request scope.</p>
     *
     * <p>You may customize this method to allocate resources that are required
     * for the lifetime of the current request.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        selectedGeographicLayerDTO = new GeographicLayerDTO(INVALID_VALUE_ID, "", "", INVALID_VALUE_ID, "");
        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO(INVALID_VALUE_ID,INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        editingGeographicLayerValueDTO = new GeographicLayerValueDTO();
        selectedFilterAncestorGeographicLayerId = INVALID_VALUE_ID;
        setGeographicalLayersDropDownData();
        onGeographicLayerChange();


// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }



    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }




    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ValidatorHelper getutil$ValidatorHelper() {
        return (ValidatorHelper) getBean("util$ValidatorHelper");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * @return the siteManager
     */
    public SiteManagerRemote getSiteManager() {
        return siteManager;
    }

    /**
     * @param siteManager the siteManager to set
     */
    public void setSiteManager(SiteManagerRemote siteManager) {
        this.siteManager = siteManager;
    }
    /**
     * @return the geographicLayers
     */
    public SingleSelectOptionsList getGeographicLayers() {
        return geographicLayers;
    }

    /**
     * @param geographicLayers the geographicLayers to set
     */
    public void setGeographicLayers(SingleSelectOptionsList geographicLayers) {
        this.geographicLayers = geographicLayers;
    }

    /**
     * @return the geographicLayerValues
     */
    public SingleSelectOptionsList getGeographicLayerValues() {
        return geographicLayerValues;
    }

    /**
     * @param geographicLayerValues the geographicLayerValues to set
     */
    public void setGeographicLayerValues(SingleSelectOptionsList geographicLayerValues) {
        this.geographicLayerValues = geographicLayerValues;
    }

    /**
     * @return the ancestorGeographicLayerValues
     */
    public SingleSelectOptionsList getAncestorGeographicLayerValues() {
        return ancestorGeographicLayerValues;
    }

    /**
     * @param ancestorGeographicLayerValues the ancestorGeographicLayerValues to set
     */
    public void setAncestorGeographicLayerValues(SingleSelectOptionsList ancestorGeographicLayerValues) {
        this.ancestorGeographicLayerValues = ancestorGeographicLayerValues;
    }

    /**
     * @return the selectedGeographicLayerDTO
     */
    public GeographicLayerDTO getSelectedGeographicLayerDTO() {
        return selectedGeographicLayerDTO;
    }

    /**
     * @param selectedGeographicLayerDTO the selectedGeographicLayerDTO to set
     */
    public void setSelectedGeographicLayerDTO(GeographicLayerDTO selectedGeographicLayerDTO) {
        this.selectedGeographicLayerDTO = selectedGeographicLayerDTO;
    }

    /**
     * @return the selectedGeographicLayerValueDTO
     */
    public GeographicLayerValueDTO getSelectedGeographicLayerValueDTO() {
        return selectedGeographicLayerValueDTO;
    }

    /**
     * @param selectedGeographicLayerValueDTO the selectedGeographicLayerValueDTO to set
     */
    public void setSelectedGeographicLayerValueDTO(GeographicLayerValueDTO selectedGeographicLayerValueDTO) {
        this.selectedGeographicLayerValueDTO = selectedGeographicLayerValueDTO;
    }

    /**
     * @return the hasAncestor
     */
    public boolean isHasAncestor() {
        return hasAncestor;
    }

    /**
     * @param hasAncestor the hasAncestor to set
     */
    public void setHasAncestor(boolean hasAncestor) {
        this.hasAncestor = hasAncestor;
    }

    /**
     * @return the selectedFilterAncestorGeographicLayerId
     */
    public Long getSelectedFilterAncestorGeographicLayerId() {
        return selectedFilterAncestorGeographicLayerId;
    }

    /**
     * @param selectedFilterAncestorGeographicLayerId the selectedFilterAncestorGeographicLayerId to set
     */
    public void setSelectedFilterAncestorGeographicLayerId(Long selectedFilterAncestorGeographicLayerId) {
        this.selectedFilterAncestorGeographicLayerId = selectedFilterAncestorGeographicLayerId;
    }

    /**
     * @return the isEditingValue
     */
    public boolean isIsEditingValue() {
        return isEditingValue;
    }

    /**
     * @param isEditingValue the isEditingValue to set
     */
    public void setIsEditingValue(boolean isEditingValue) {
        this.isEditingValue = isEditingValue;
    }

    /**
     * @return the editingGeographicLayerValueDTO
     */
    public GeographicLayerValueDTO getEditingGeographicLayerValueDTO() {
        return editingGeographicLayerValueDTO;
    }

    /**
     * @param editingGeographicLayerValueDTO the editingGeographicLayerValueDTO to set
     */
    public void setEditingGeographicLayerValueDTO(GeographicLayerValueDTO editingGeographicLayerValueDTO) {
        this.editingGeographicLayerValueDTO = editingGeographicLayerValueDTO;
    }

}
