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

package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.GeographicLayerValueDTO;
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
 * @version AdminGeographicLayersSessionBean.java
 * @version Created on 16/11/2009, 04:08:22 PM
 * @author esmata
 */

public class AdminGeographicLayersSessionBean extends AbstractSessionBean
        implements Serializable{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injection
    @EJB
    private GisFacadeRemote gisFacadeImpl;

    //Constants
    private Long INVALID_VALUE_ID = new Long(-1);
    private Long NEW_VALUE_ID = new Long(-2);

    /** Datos del DropDown que para los efectos de este codigo seran siempre paises! **/
    private SingleSelectOptionsList geographicLayers = new SingleSelectOptionsList();

    /** Datos del DropDown que para los efectos de este codigo seran siempre paises! **/
    private SingleSelectOptionsList geographicLayerValues = new SingleSelectOptionsList();

    /** Optional filter by: ancestor geographic Layer Values**/
    private SingleSelectOptionsList ancestorGeographicLayerValues = new SingleSelectOptionsList();

    //Current geographical layer
    private GeographicLayerDTO selectedGeographicLayerDTO;

    private GeographicLayerValueDTO selectedGeographicLayerValueDTO;
    private Long selectedFilterAncestorGeographicLayerId = INVALID_VALUE_ID;
    private GeographicLayerValueDTO editingGeographicLayerValueDTO;

    private boolean hasAncestor;
    private boolean isEditingValue;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public AdminGeographicLayersSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        selectedGeographicLayerDTO = new GeographicLayerDTO
                (INVALID_VALUE_ID, "", "", INVALID_VALUE_ID, "");
        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO
                (INVALID_VALUE_ID,INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        setEditingGeographicLayerValueDTO(new GeographicLayerValueDTO());
        setSelectedFilterAncestorGeographicLayerId(INVALID_VALUE_ID);
        setGeographicalLayersDropDownData();
        onGeographicLayerChange();
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("AdminGeographicLayersSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
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
    @Override
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
    @Override
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
    @Override
    public void destroy() {
    }

   /**
     * Carga todos los layers en el dropdown y deja alguno como el seleccionado.
     */
    public void setGeographicalLayersDropDownData(){

        List<GeographicLayerDTO> gsDTOList = gisFacadeImpl.getAllGeographicalLayers();

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
     * Se modifico la capa seleccionada
     * En el dropdown: geographicLayer
     */
    public void onGeographicLayerChange(){
        Long actualSelectedId = selectedGeographicLayerDTO.getGeographicalLayerKey();
        selectedGeographicLayerDTO = gisFacadeImpl.getAllGeographicalLayer(actualSelectedId);

        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO
                (INVALID_VALUE_ID,INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        if(selectedGeographicLayerDTO.getAncestorKey() == null)
            setHasAncestor(false);
        else
            setHasAncestor(true);

        setIsEditingValue(false);
        updateGeographicLayersValuesDropDownData();

        setSelectedFilterAncestorGeographicLayerId(INVALID_VALUE_ID);
        updateAncestorGeographicLayerValuesDropDownData();
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
                glvDTOList = gisFacadeImpl.
                        getAllGeographicalLayerValuesForGeographicLayerAndAncestor
                        (selectedGeographicLayerDTO.getGeographicalLayerKey(),getSelectedFilterAncestorGeographicLayerId());
            else
                glvDTOList = gisFacadeImpl.
                        getAllGeographicalLayerValuesForGeographicLayer
                        (selectedGeographicLayerDTO.getGeographicalLayerKey());

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

        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.getGeographicLayerValues().setOptions(allOptions.toArray(allOptionsInArray));
    }

    public void updateAncestorGeographicLayerValuesDropDownData(){
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        allOptions.add(new Option(INVALID_VALUE_ID, ""));

        if(hasAncestor){

            List<GeographicLayerValueDTO> glvDTOList = gisFacadeImpl.
                    getAllGeographicalLayerValuesForGeographicLayer
                    (selectedGeographicLayerDTO.getAncestorKey());

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
     * Se modifico el valor de la capa seleccionada
     * En el dropdown: geographicLayerValues
     */
    public void onGeographicLayerValueChange(){
        Long actualSelectedValueId =
                selectedGeographicLayerValueDTO.getGeographicLayerValueKey();
        selectedGeographicLayerValueDTO = gisFacadeImpl.
                getAllGeographicalLayerValueForGeographicLayerAndId
                (selectedGeographicLayerDTO.getGeographicalLayerKey(), actualSelectedValueId);
        setSelectedFilterAncestorGeographicLayerId(INVALID_VALUE_ID);
        isEditingValue = false;
    }

    /**
     * Se modifico el valor del layer que filtra que values se muestran
     * En el dropdown: ancestorGeographicLayerValues
     */
    public void onAncestorGeographicLayerValueChange(){
        //selectedGeographicLayerDTO
        selectedGeographicLayerValueDTO = new GeographicLayerValueDTO
                (INVALID_VALUE_ID, INVALID_VALUE_ID, "", INVALID_VALUE_ID, "");
        updateGeographicLayersValuesDropDownData();
        isEditingValue = false;
    }

    public boolean saveGeographicLayerValue(){

        if(editingGeographicLayerValueDTO.getGeographicLayerValueKey().equals(NEW_VALUE_ID))
            editingGeographicLayerValueDTO.setGeographicLayerValueKey(null);

        boolean result = gisFacadeImpl.
                saveOrUpdateGeographicLayerValue(editingGeographicLayerValueDTO);

        isEditingValue = false;
        updateGeographicLayersValuesDropDownData();

        return result;

    }

    public void newGeographicLayerValue(){
        isEditingValue = true;
        editingGeographicLayerValueDTO =
                new GeographicLayerValueDTO
                (selectedGeographicLayerDTO.getGeographicalLayerKey(),
                NEW_VALUE_ID, "", selectedFilterAncestorGeographicLayerId, "");
    }

    public void editGeographicLayerValue(){
        isEditingValue = true;
        Long actualSelectedValueId = selectedGeographicLayerValueDTO.getGeographicLayerValueKey();
        selectedGeographicLayerValueDTO =
                gisFacadeImpl.getAllGeographicalLayerValueForGeographicLayerAndId
                (selectedGeographicLayerDTO.getGeographicalLayerKey(), actualSelectedValueId);
        editingGeographicLayerValueDTO = selectedGeographicLayerValueDTO;
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
    
}
