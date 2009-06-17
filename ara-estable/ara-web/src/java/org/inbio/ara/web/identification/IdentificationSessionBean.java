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
 * IdentificationSessionBean.java
 *
 * Created on June 24, 2008, 11:09 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.identification;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.IdentificationRemote;
import org.inbio.ara.facade.specimen.SpecimenGenParms;
import org.inbio.ara.facade.specimen.SpecimenRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.gathering.LifeStageSimpleDataProvider;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.PaginationController;
import org.inbio.ara.web.util.SelectionListBean;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class IdentificationSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    // private IdentificationDataProvider identificationDataProvider = new IdentificationDataProvider(this.getSessionManager().getCollection().getId());
    private IdentificationDataProvider currentIdentificationDataProvider;
    private Option[] lifeStageOption;
    private Long selectedLifeStage = -1L;
    private Option[] sexOption;
    private Long selectedSex = -1L;
    private Option[] taxonomicalRangeOption;
    private Long selectedTaxonomicalRange = -1L;
    private Option[] taxonCategoryOption;
    private Long selectedTaxonCategory = -1L;
    private Option[] taxonList;
    private Long[] selectedTaxon;
    private Option[] identificationStatusOption;
    private Long selectedIdentificationStatus = -1L;
    private Option[] identificationTypeOption;
    private Long selectedIdentificationType = -1L;
    private Option[] identificationValidatorOption;
    private Long selectedIdentificationValidator = -1L;
    private Option[] identifierOption;
    private Long[] selectedIdentifier;
    private LifeStageSimpleDataProvider lifeStageSexSimpleDataProvider = new LifeStageSimpleDataProvider();
    private LifeStageSimpleDataProvider currentlifeStageSexSimpleDataProvider;
    private SpecimenGenParms genParameters;
    private Option[] specimenList;
    private String gatheringObservationSummary = "";
    private Long selectedSpecimenId = 0L;
    private Date identificationDate;
    private String dataEntryError = "n";
    private Long currentSpecimenCategory = null;
    private String currentSpecimenCategoryName = "";
    private Option[] typeSpecimenTypeOption;
    private Long selectedTypeSpecimenTypeOption = -1L;
    private Option[] institutionOption;
    private Long selectedInstitution = -1L;
    
    private IdentificationFilteredDataProvider identificationFilteredDataProvider = new IdentificationFilteredDataProvider();
    private LifeStageSexFilteredDataProvider lifeStageSexFilteredDataProvider = new LifeStageSexFilteredDataProvider();

    @EJB
    private SearchManagerRemote searchManager;
    //paginacion de la tabla
    private PaginationController pagination = null;
    private Hashtable searchCriteria = null;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public IdentificationSessionBean() {
        selectedTypeSpecimenTypeOption = -1L;
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
            log("IdentificationSessionBean Initialization Failure", e);
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
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

//    public IdentificationDataProvider getIdentificationDataProvider() {
//        return identificationDataProvider;
//    }
//
//    public void setIdentificationDataProvider(IdentificationDataProvider identificationDataProvider) {
//        this.identificationDataProvider = identificationDataProvider;
//    }

    public IdentificationDataProvider getCurrentIdentificationDataProvider() {
        return currentIdentificationDataProvider;
    }

    public void setCurrentIdentificationDataProvider(IdentificationDataProvider currentIdentificationDataProvider) {
        this.currentIdentificationDataProvider = currentIdentificationDataProvider;
    }

    public Option[] getLifeStageOption() {
        return lifeStageOption;
    }

    public void setLifeStageOption(Option[] lifeStageOption) {
        this.lifeStageOption = lifeStageOption;
    }

    public Long getSelectedLifeStage() {
        return selectedLifeStage;
    }

    public void setSelectedLifeStage(Long selectedLifeStage) {
        this.selectedLifeStage = selectedLifeStage;
    }

    public Option[] getSexOption() {
        return sexOption;
    }

    public void setSexOption(Option[] sexOption) {
        this.sexOption = sexOption;
    }

    public Long getSelectedSex() {
        return selectedSex;
    }

    public void setSelectedSex(Long selectedSex) {
        this.selectedSex = selectedSex;
    }

    public Option[] getTaxonomicalRangeOption() {
        return taxonomicalRangeOption;
    }

    public void setTaxonomicalRangeOption(Option[] taxonomicalRangeOption) {
        this.taxonomicalRangeOption = taxonomicalRangeOption;
    }

    public Long getSelectedTaxonomicalRange() {
        return selectedTaxonomicalRange;
    }

    public void setSelectedTaxonomicalRange(Long selectedTaxonomicalRange) {
        this.selectedTaxonomicalRange = selectedTaxonomicalRange;
    }

    public Option[] getTaxonCategoryOption() {
        return taxonCategoryOption;
    }

    public void setTaxonCategoryOption(Option[] taxonCategoryOption) {
        this.taxonCategoryOption = taxonCategoryOption;
    }

    public Long getSelectedTaxonCategory() {
        return selectedTaxonCategory;
    }

    public void setSelectedTaxonCategory(Long selectedTaxonCategory) {
        this.selectedTaxonCategory = selectedTaxonCategory;
    }

    public Option[] getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(Option[] taxonList) {
        this.taxonList = taxonList;
    }

    public Long[] getSelectedTaxon() {
        return selectedTaxon;
    }

    public void setSelectedTaxon(Long[] selectedTaxon) {
        this.selectedTaxon = selectedTaxon;
    }

    public Option[] getIdentificationStatusOption() {
        return identificationStatusOption;
    }

    public void setIdentificationStatusOption(Option[] identificationStatusOption) {
        this.identificationStatusOption = identificationStatusOption;
    }

    public Long getSelectedIdentificationStatus() {
        return selectedIdentificationStatus;
    }

    public void setSelectedIdentificationStatus(Long selectedIdentificationStatus) {
        this.selectedIdentificationStatus = selectedIdentificationStatus;
    }

    public Option[] getIdentificationTypeOption() {
        return identificationTypeOption;
    }

    public void setIdentificationTypeOption(Option[] identificationTypeOption) {
        this.identificationTypeOption = identificationTypeOption;
    }

    public Long getSelectedIdentificationType() {
        return selectedIdentificationType;
    }

    public void setSelectedIdentificationType(Long selectedIdentificationType) {
        this.selectedIdentificationType = selectedIdentificationType;
    }

    public Option[] getIdentificationValidatorOption() {
        return identificationValidatorOption;
    }

    public void setIdentificationValidatorOption(Option[] identificationValidatorOption) {
        this.identificationValidatorOption = identificationValidatorOption;
    }

    public Long getSelectedIdentificationValidator() {
        return selectedIdentificationValidator;
    }

    public void setSelectedIdentificationValidator(Long selectedIdentificationValidator) {
        this.selectedIdentificationValidator = selectedIdentificationValidator;
    }

    public Option[] getIdentifierOption() {
        return identifierOption;
    }

    public void setIdentifierOption(Option[] identifierOption) {
        this.identifierOption = identifierOption;
    }

    public Long[] getSelectedIdentifier() {
        return selectedIdentifier;
    }

    public void setSelectedIdentifier(Long[] selectedIdentifier) {
        this.selectedIdentifier = selectedIdentifier;
    }

    public LifeStageSimpleDataProvider getLifeStageSexSimpleDataProvider() {
        return lifeStageSexSimpleDataProvider;
    }

    public void setLifeStageSexSimpleDataProvider(LifeStageSimpleDataProvider lifeStageSexSimpleDataProvider) {
        this.lifeStageSexSimpleDataProvider = lifeStageSexSimpleDataProvider;
    }

    public SpecimenGenParms getGenParameters() {
        return genParameters;
    }

    public void setGenParameters(SpecimenGenParms genParameters) {
        this.genParameters = genParameters;
    }

    public LifeStageSimpleDataProvider getCurrentlifeStageSexSimpleDataProvider() {
        return currentlifeStageSexSimpleDataProvider;
    }

    public void setCurrentlifeStageSexSimpleDataProvider(LifeStageSimpleDataProvider currentlifeStageSexSimpleDataProvider) {
        this.currentlifeStageSexSimpleDataProvider = currentlifeStageSexSimpleDataProvider;
    }
    
    public void populateOptions() {
        // Estas listas corresponden a la generaci�n de identificaciones
        this.setLifeStageOption(this.getSelectionListBean().getLifeStage());
        this.setSexOption(this.getSelectionListBean().getSex());
        this.setTaxonomicalRangeOption(this.getSelectionListBean().getTaxonomicalRange());
        this.setTaxonCategoryOption(this.getSelectionListBean().getTaxonCategory());
        this.setIdentificationTypeOption(this.getSelectionListBean().getIdentificationType());
        this.setIdentificationValidatorOption(this.getSelectionListBean().getIdentificationValidator());
        this.setIdentifierOption(this.getSelectionListBean().getIdentifier());
        if (this.getSelectedTaxonomicalRange() != -1L) {
            if (this.getSelectedTaxonCategory() != -1L) {
                this.setTaxonList(this.getSelectionListBean().getFilteredTaxonList(this.getSelectedTaxonomicalRange(), this.getSelectedTaxonCategory()));
            }
        }
        this.setIdentificationStatusOption(this.getSelectionListBean().getIdentificationStatus());
        this.setTypeSpecimenTypeOption(this.getSelectionListBean().getTypeSpecimenType());
        this.setInstitutionOption(this.getSelectionListBean().getInstitution());
    }

    public void setSpecimenList(Option[] specimenList) {
        this.specimenList = specimenList;
    }

    public Option[] getSpecimenList() {
        return this.specimenList;
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getSelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }
    
    public boolean canAddSpecimen(String specimenId) {
        try {
            Long newSpecimenId = Long.parseLong(specimenId);
            Long currentSpecimenId;

            Specimen newSpecimen = this.lookupSpecimenBean().find(newSpecimenId);

            // Verificar si el especimen existe
            if (newSpecimen == null) {
                this.getutil$MessageBean().addErrorMessage("No existe espec�men con el id." + newSpecimenId);
                return false;
            }

            // Verificar si pertence a la colecci�n selecionada
            if (!newSpecimen.getCollection().getId().equals(this.getSessionManager().getCollection().getId())) {
                this.getutil$MessageBean().addErrorMessage("El espec�men " + specimenId + " no pertenece a la colecci�n actual: " + this.getSessionManager().getCollection().getName());
                return false;
            }

            // Verificar si tiene la misma categor�a que los especimens ya incluidos en la lista
            if (this.currentSpecimenCategory != null) {
                if (!this.currentSpecimenCategory.equals(newSpecimen.getSpecimenCategory().getId())) {
                    this.getutil$MessageBean().addErrorMessage("La categor�a del espec�men es diferente a la de los espec�menes en lista.");
                    this.getutil$MessageBean().addErrorMessage("El especimen no fu� agregado.");
                    return false;
                }
            }

            // Finalmente verificar si el especimen ya existe en la lista
            if (this.specimenList != null) {
                for (int i=0; i<specimenList.length; i++) {
                    currentSpecimenId = (Long)specimenList[i].getValue();
                    if (newSpecimenId.equals(currentSpecimenId)) {
                        this.getutil$MessageBean().addErrorMessage("El espec�men " + specimenId + " ya est� incluido en la lista");
                        return false;
                    }
                }
            }

            return true;
        } catch (NumberFormatException ex) {
            this.getutil$MessageBean().addErrorMessage("N�mero de espec�men inv�lido");
            return false;
        }
    }
    
    public boolean canAddSpecimenId(String specimenId) {
        Long newSpecimenId = Long.parseLong(specimenId);
        Long currentSpecimenId;
        if (this.specimenList == null) {
            return true;
        } else {
            for (int i=0; i<specimenList.length; i++) {
                currentSpecimenId = (Long)specimenList[i].getValue();
                /*
                Specimen currentSpecimen = this.lookupSpecimenBean().find(currentSpecimenId);

                if (currentSpecimen == null) {
                    this.getutil$MessageBean().addErrorMessage("No existe un espec�men con el id. " + currentSpecimenId);
                    return false;
                }
                
                if (this.currentSpecimenCategory!= null) {
                    if (currentSpecimen.getSpecimenCategory().getId() != this.currentSpecimenCategory) {
                        this.getutil$MessageBean().addErrorMessage("La categor�a del espec�men es diferente a la de los espec�menes en lista.");
                        this.getutil$MessageBean().addErrorMessage("Espec�men no agregado.");
                        return false;
                    }
                } else {
                    this.setCurrentSpecimenCategory(currentSpecimen.getSpecimenCategory().getId());
                    this.setCurrentSpecimenCategoryName(currentSpecimen.getSpecimenCategory().getName());
                }
                */
                
                if (newSpecimenId.equals(currentSpecimenId)) {
                    this.getutil$MessageBean().addErrorMessage("El espec�men " + specimenId + " ya est� incluido en la lista");
                    return false;
                }
            }
            return true;
        }
    }
    
    public boolean addSpecimenId(String specimenId) {
        Option[] tmpList;
        
        //if (this.canAddSpecimenId(specimenId)) {
        if (this.canAddSpecimen(specimenId)){
            if (setSpecimenActualInfo(Long.parseLong(specimenId))) {
                if (this.specimenList==null) {
                    tmpList = new Option[1];
                } else {
                    tmpList = new Option[this.specimenList.length+1];
                }        

                tmpList[0] = new Option(Long.parseLong(specimenId), specimenId);
                for (int i=1; i<tmpList.length;i++) {
                    tmpList[i] = this.specimenList[i-1];
                }
                this.setSpecimenList(tmpList);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean setSpecimenActualInfo(Long specimenId) {
        Specimen specimen = this.lookupSpecimenBean().find(specimenId);
        if (specimen != null) {
            //if (specimen.getCollection().getId().equals(this.getSessionManager().getCollection().getId())) {
                this.setGatheringObservationSummary(specimen.getGatheringObservation().getSummary());
                this.getIdentificationFilteredDataProvider().refreshList(specimenId);
                this.getLifeStageSexFilteredDataProvider().refreshList(specimenId);
                this.setSelectedSpecimenId(specimen.getId());
                this.setCurrentSpecimenCategory(specimen.getSpecimenCategory().getId());
                this.setCurrentSpecimenCategoryName(specimen.getSpecimenCategory().getName());
                return true;
            /*    
            } else {
                this.getutil$MessageBean().addErrorMessage("El espec�men no pertenece a la colecci�n actual.");
                return false;
            }
             */
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupSpecimenBean().getMessage());
            return false;
        }
    }

    private SpecimenRemote lookupSpecimenBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            return (org.inbio.ara.facade.specimen.SpecimenRemote) c.lookup("SpecimenBean");
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public String getGatheringObservationSummary() {
        return gatheringObservationSummary;
    }

    public void setGatheringObservationSummary(String gatheringObservationSummary) {
        this.gatheringObservationSummary = gatheringObservationSummary;
    }

    public IdentificationFilteredDataProvider getIdentificationFilteredDataProvider() {
        return identificationFilteredDataProvider;
    }

    public void setIdentificationFilteredDataProvider(IdentificationFilteredDataProvider identificationFilteredDataProvider) {
        this.identificationFilteredDataProvider = identificationFilteredDataProvider;
    }

    public LifeStageSexFilteredDataProvider getLifeStageSexFilteredDataProvider() {
        return lifeStageSexFilteredDataProvider;
    }

    public void setLifeStageSexFilteredDataProvider(LifeStageSexFilteredDataProvider lifeStageSexFilteredDataProvider) {
        this.lifeStageSexFilteredDataProvider = lifeStageSexFilteredDataProvider;
    }

    public Long getSelectedSpecimenId() {
        return selectedSpecimenId;
    }

    public void setSelectedSpecimenId(Long selectedSpecimenId) {
        this.selectedSpecimenId = selectedSpecimenId;
    }
    
    public void removeSelectedSpecimenId() {
        Option[] tmpOption;
        
        if (this.specimenList!= null) {
            if (this.specimenList.length > 0) {
                // Definir el tama�o del nuevo arreglo
                tmpOption = new Option[specimenList.length-1];
                int z=0;
                Long actualValue;
                for (int i=0; i< specimenList.length;i++) {
                    actualValue = Long.parseLong(specimenList[i].getValue().toString());
                    if (!this.selectedSpecimenId.equals(actualValue)) {
                        tmpOption[z] = specimenList[i];
                        z++;
                    }
                }
                if (tmpOption.length > 0) {
                    this.selectedSpecimenId = Long.parseLong(tmpOption[0].getValue().toString());
                } else {
                    this.selectedSpecimenId = 0L;
                    this.gatheringObservationSummary = "";
                    initDataProviders();
                }                
                this.specimenList = tmpOption;
                if (this.specimenList.length == 0) {
                    this.cleanSpecimenList();
                }
            }
        }
    }
    
    public void cleanSpecimenList() {
        specimenList = new Option[]{};
        selectedSpecimenId = 0L;
        gatheringObservationSummary = "";
        currentSpecimenCategory = null;
        currentSpecimenCategoryName = "";
        initDataProviders();
    }
    
    public void initDataProviders() {
        //*identificationFilteredDataProvider = new IdentificationFilteredDataProvider();
        //*lifeStageSexFilteredDataProvider = new LifeStageSexFilteredDataProvider();
    }

    public void initDataProvider() {
        pagination = new PaginationControllerImpl(searchManager.
                countResult(Identification.class,
                getSearchCriteria()).intValue(), 10);
    }
    
    public boolean reIdentify() {
        Long typeSpecimenTypeId = null;
        Long institutionId = null;
        
        // try {
            if (this.selectedTypeSpecimenTypeOption > -1L) {
                typeSpecimenTypeId = this.selectedTypeSpecimenTypeOption;
                if (this.selectedInstitution != null) {
                    if (this.selectedInstitution > -1L) {
                        institutionId = this.selectedInstitution;
                    }
                }
            }
        // } catch (Exception e) {
        //    this.getutil$MessageBean().addErrorMessage("Nulo");
        // }
        
/*        if (this.lookupIdentificationBean().reIdentify(this.createIdentificationEntity(), this.getSpecimenListArray(), this.getSelectedTaxon(), this.getSelectedIdentifier(), this.lifeStageSexSimpleDataProvider.getList(), typeSpecimenTypeId, institutionId)) {
            this.getutil$MessageBean().addSuccessMessage("Especimenes reidentificados");
            this.getutil$MessageBean().addErrorMessage(lookupIdentificationBean().getMessage());
        } else {
            this.getutil$MessageBean().addErrorMessage(lookupIdentificationBean().getMessage());
        }
 */
        return true;
    }
    
    private Identification createIdentificationEntity() {
        // Construir el objeto Identification
        Identification obj = new Identification();

        // Fecha de la identificaci�n
        obj.setIdentificationDate(this.getIdentificationDate());
        // Tipo de identificaci�n
        if (this.getSelectedIdentificationType()!=null) {
            obj.setIdentificationType(this.getSelectionListBean().getIdentificationTypeById(this.getSelectedIdentificationType()));
        }

        // Estado de la identificaci�n
        obj.setIdentificationStatus(this.getSelectionListBean().getIdentificationStatus(this.getSelectedIdentificationStatus()));

        // Validador de la identificaci�n
        if (this.getSelectedIdentificationValidator() != null) {
            if (this.getSelectedIdentificationValidator() != -1L) {
                obj.setValuerPerson(this.getSelectionListBean().getPerson(this.getSelectedIdentificationValidator()));
            }
        }
        // Info de bitacoria                    
        obj.setCreatedBy(this.getSessionManager().getUser().getUserName());
        obj.setLastModificationBy(this.getSessionManager().getUser().getUserName());
        obj.setDataEntryError(this.getDataEntryError());
        return obj;
    }
    
    private boolean validate() {
        if (this.specimenList == null) {
            this.getutil$MessageBean().addErrorMessage("No hay espec�menes que re-identificar.");
            return false;
        }
        
        if (this.specimenList.length == 0) {
            this.getutil$MessageBean().addErrorMessage("No hay espec�menes que re-identificar.");
            return false;
        }
        
        if (this.taxonList == null) {
            this.getutil$MessageBean().addErrorMessage("No ha seleccionado ning�n tax�n.");
            return false;
        }
        
        if (this.taxonList.length == 0) {
            this.getutil$MessageBean().addErrorMessage("No ha seleccionado ning�n tax�n.");
            return false;
        }
        
        if (this.identificationDate != null) {
            this.getutil$MessageBean().addErrorMessage("Falta la fecha de identificaci�n.");
            return false;
        }
        
        if (this.selectedIdentificationStatus == -1L) {
            this.getutil$MessageBean().addErrorMessage("Falta el status de identificaci�n.");
            return false;
        }
        
        if (this.selectedTypeSpecimenTypeOption > -1L) {
            if (this.selectedInstitution == -1L) {
            this.getutil$MessageBean().addErrorMessage("Falta el depositario del tipo.");
            return false;
            }
        }
        return true;
    }

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Date identificationDate) {
        this.identificationDate = identificationDate;
    }
    
    public Long[] getSpecimenListArray() {
        Long[] array = new Long[this.specimenList.length];
        for (int i=0;i<array.length;i++) {
            array[i] = Long.parseLong(this.specimenList[i].getValue().toString());
        }
        return array;
    }

    private IdentificationRemote lookupIdentificationBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            return (org.inbio.ara.facade.specimen.IdentificationRemote) c.lookup("IdentificationBean");
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void cleanParameters() {
        this.cleanSpecimenList();
        //identificationDataProvider = new IdentificationDataProvider();
        currentIdentificationDataProvider = null;
        lifeStageOption = null;
        selectedLifeStage = -1L;
        sexOption = null;
        selectedSex = -1L;
        taxonomicalRangeOption = null;
        selectedTaxonomicalRange = -1L;
        taxonCategoryOption  = null;
        selectedTaxonCategory = -1L;
        taxonList = null;
        selectedTaxon = null;
        identificationStatusOption = null;
        selectedIdentificationStatus = -1L;
        identificationTypeOption = null;
        selectedIdentificationType = -1L;
        identificationValidatorOption = null;
        selectedIdentificationValidator = -1L;
        identifierOption = null;
        selectedIdentifier = null;
//*        lifeStageSexSimpleDataProvider = new LifeStageSimpleDataProvider();
//*        currentlifeStageSexSimpleDataProvider  = null;
        specimenList = null;
        gatheringObservationSummary = "";
        selectedSpecimenId = 0L;
        identificationDate = null;
        //*identificationFilteredDataProvider = new IdentificationFilteredDataProvider();
        //*lifeStageSexFilteredDataProvider = new LifeStageSexFilteredDataProvider();
        setDataEntryError("n");
        setCurrentSpecimenCategory(null);
        setCurrentSpecimenCategoryName("");
    }
    
    public void delete(RowKey rowKey) {
//        if (rowKey != null) {
//            Identification identification = (Identification)this.getIdentificationDataProvider().getObject(rowKey);
//            if (this.lookupIdentificationBean().delete(identification.getIdentificationPK())) {
//                this.getutil$MessageBean().addSuccessMessage("Registro borrado con �xito");
//            } else {
//                this.getutil$MessageBean().addSuccessMessage("Error al borrar el registro: " + lookupIdentificationBean().getMessage());
//            }
//        } else {
//            System.out.println("rowKey es nulo.");
//        }
    }

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }
    
    public String getSpecimenCount() {
        if (this.getSpecimenList() != null) {
            return "" + this.getSpecimenList().length;
        } else {
            return "0";
        }
    }
    
    public void addSpecimens(Long[] newSpecimenArray) {
        for (int i = 0; i<newSpecimenArray.length;i++) {
            addSpecimenId(newSpecimenArray[i].toString());
        }
    }

    public Long getCurrentSpecimenCategory() {
        return currentSpecimenCategory;
    }

    public void setCurrentSpecimenCategory(Long currentSpecimenCategory) {
        this.currentSpecimenCategory = currentSpecimenCategory;
    }

    public String getCurrentSpecimenCategoryName() {
        return currentSpecimenCategoryName;
    }

    public void setCurrentSpecimenCategoryName(String currentSpecimenCategoryName) {
        this.currentSpecimenCategoryName = currentSpecimenCategoryName;
    }

    public Option[] getTypeSpecimenTypeOption() {
        return typeSpecimenTypeOption;
    }

    public void setTypeSpecimenTypeOption(Option[] typeSpecimenTypeOption) {
        this.typeSpecimenTypeOption = typeSpecimenTypeOption;
    }

    public Long getSelectedTypeSpecimenTypeOption() {
        return selectedTypeSpecimenTypeOption;
    }

    public void setSelectedTypeSpecimenTypeOption(Long selectedTypeSpecimenTypeOption) {
        this.selectedTypeSpecimenTypeOption = selectedTypeSpecimenTypeOption;
    }

    public Option[] getInstitutionOption() {
        return institutionOption;
    }

    public void setInstitutionOption(Option[] institutionOption) {
        this.institutionOption = institutionOption;
    }

    public Long getSelectedInstitution() {
        return selectedInstitution;
    }

    public void setSelectedInstitution(Long selectedInstitution) {
        this.selectedInstitution = selectedInstitution;
    }

    /**
     * @return the searchManager
     */
    public SearchManagerRemote getSearchManager() {
        return searchManager;
    }

    /**
     * @return the searchCriteria
     */
    public Hashtable getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * @param searchCriteria the searchCriteria to set
     */
    public void setSearchCriteria(Hashtable searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * @return the pagination
     */
    public PaginationController getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(PaginationController pagination) {
        this.pagination = pagination;
    }

    private class PaginationControllerImpl extends PaginationController {
        public PaginationControllerImpl(int totalResults, int resultsPerPage) {
            super(totalResults, resultsPerPage);
        }

        @Override
        public List getResults(int firstResult, int maxResults) {
            return searchManager.makePaginatedQuery(firstResult, maxResults, 
                    Identification.class, searchCriteria);
        }
    }
}
