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
package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.util.AddRemoveList;

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
 * @version SpecimenGenerationSessionBean.java
 * @version Created on 17/09/2009, 03:30:10 PM
 * @author esmata
 */
public class SpecimenGenerationSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    //Injections
    @EJB
    private InventoryFacadeRemote inventoryFacade;

    //Cantidad de especimenes a generar
    private Long specimenQuantity = new Long(0);
    //Specimen DTO que contiene la informacion relacionada a especimen
    private SpecimenDTO specimenDTO = new SpecimenDTO();
    //Identification DTO que contiene la informacion relacionada a la identificacion
    private IdentificationDTO identificationDTO = new IdentificationDTO();
    //List<Long> correspondiente a las id's de formas de vida
    private List<Long> lifeFormList = new ArrayList<Long>();
    //GatheringObservationID
    private Long gatheringObservationId = null;
    private Long gatheringObservationDetailId = null;
    //Objetos para los AddRemoveList
    private AddRemoveList arTaxonList = new AddRemoveList();
    private AddRemoveList arIdentifierList = new AddRemoveList();
    private AddRemoveList arLifeFormList = new AddRemoveList();
    //Indica si los distintos DTO's estan listos para ser persistidos
    private boolean readyToSave = true;
    //Binding para la hora exacta en observaciones
    private Long selectedHour = null;
    private Long selectedMinute = null;
    private Long selectedTaxonomicLevel = null; //taxonomical range
    private Long selecctedValidator = null; //valuer person

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SpecimenGenerationSessionBean() {
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

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("GenerationSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
     * @return the specimenDTO
     */
    public SpecimenDTO getSpecimenDTO() {
        return specimenDTO;
    }

    /**
     * @param specimenDTO the specimenDTO to set
     */
    public void setSpecimenDTO(SpecimenDTO specimenDTO) {
        this.specimenDTO = specimenDTO;
    }

    /**
     * @return the arTaxonList
     */
    public AddRemoveList getArTaxonList() {
        return arTaxonList;
    }

    /**
     * @param arTaxonList the arTaxonList to set
     */
    public void setArTaxonList(AddRemoveList arTaxonList) {
        this.arTaxonList = arTaxonList;
    }

    /**
     * @return the arIdentifierList
     */
    public AddRemoveList getArIdentifierList() {
        return arIdentifierList;
    }

    /**
     * @param arIdentifierList the arIdentifierList to set
     */
    public void setArIdentifierList(AddRemoveList arIdentifierList) {
        this.arIdentifierList = arIdentifierList;
    }

    public List<TaxonDTO> getAllTaxonByTaxonomicalRange(Long taxonomicalRangeId) {
        return this.inventoryFacade.getAllTaxonByTaxononimcalRange(taxonomicalRangeId);
    }

    public List<PersonDTO> getIdentifiersList() {
        return this.inventoryFacade.getAllIdentifiers();
    }

    public List<PersonDTO> getValidatorsList() {
        return this.inventoryFacade.getAllValidators();
    }

    public List<TaxonCategoryDTO> getTaxonCategories() {
        return this.inventoryFacade.getAllTaxonCategories();
    }

    /**
     * @return the arLifeFormList
     */
    public AddRemoveList getArLifeFormList() {
        return arLifeFormList;
    }

    /**
     * @param arLifeFormList the arLifeFormList to set
     */
    public void setArLifeFormList(AddRemoveList arLifeFormList) {
        this.arLifeFormList = arLifeFormList;
    }

    /**
     * @return the identificationDTO
     */
    public IdentificationDTO getIdentificationDTO() {
        return identificationDTO;
    }

    /**
     * @param identificationDTO the identificationDTO to set
     */
    public void setIdentificationDTO(IdentificationDTO identificationDTO) {
        this.identificationDTO = identificationDTO;
    }

    /**
     * @return the readyToSave
     */
    public boolean isReadyToSave() {
        return readyToSave;
    }

    /**
     * @param readyToSave the readyToSave to set
     */
    public void setReadyToSave(boolean readyToSave) {
        this.readyToSave = readyToSave;
    }

    /**
     * @return the specimenQuantity
     */
    public Long getSpecimenQuantity() {
        return specimenQuantity;
    }

    /**
     * @param specimenQuantity the specimenQuantity to set
     */
    public void setSpecimenQuantity(Long specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    /**
     * @return the selectedHour
     */
    public Long getSelectedHour() {
        return selectedHour;
    }

    /**
     * @param selectedHour the selectedHour to set
     */
    public void setSelectedHour(Long selectedHour) {
        this.selectedHour = selectedHour;
    }

    /**
     * @return the selectedMinute
     */
    public Long getSelectedMinute() {
        return selectedMinute;
    }

    /**
     * @param selectedMinute the selectedMinute to set
     */
    public void setSelectedMinute(Long selectedMinute) {
        this.selectedMinute = selectedMinute;
    }

    /**
     * @return the gatheringObservationId
     */
    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    /**
     * @param gatheringObservationId the gatheringObservationId to set
     */
    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    /**
     * @return the gatheringObservationDetailId
     */
    public Long getGatheringDetailObservationId() {
        return gatheringObservationDetailId;
    }

    /**
     * @param gatheringObservationDetailId the gatheringObservationDetailId to set
     */
    public void setGatheringDetailObservationId(Long gatheringDetailObservationId) {
        this.gatheringObservationDetailId = gatheringDetailObservationId;
    }

    /**
     * @return the lifeFormList
     */
    public List<Long> getLifeFormList() {
        return lifeFormList;
    }

    /**
     * @param lifeFormList the lifeFormList to set
     */
    public void setLifeFormList(List<Long> lifeFormList) {
        this.lifeFormList = lifeFormList;
    }

    /**
     * @return the selectedTaxonomicLevel
     */
    public Long getSelectedTaxonomicLevel() {
        return selectedTaxonomicLevel;
    }

    /**
     * @param selectedTaxonomicLevel the selectedTaxonomicLevel to set
     */
    public void setSelectedTaxonomicLevel(Long selectedTaxonomicLevel) {
        this.selectedTaxonomicLevel = selectedTaxonomicLevel;
    }

    /**
     * @return the selecctedValidator
     */
    public Long getSelecctedValidator() {
        return selecctedValidator;
    }

    /**
     * @param selecctedValidator the selecctedValidator to set
     */
    public void setSelecctedValidator(Long selecctedValidator) {
        this.selecctedValidator = selecctedValidator;
    }

    public void generateSpecimens() {
        inventoryFacade.specimenGenerator(specimenDTO, identificationDTO,
                lifeFormList, getSpecimenQuantity().intValue());
    }
}
