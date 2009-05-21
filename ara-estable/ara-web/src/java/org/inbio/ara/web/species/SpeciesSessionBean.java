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
 * AraSessionBean.java
 *
 * Created on June 7, 2007, 9:58 AM
 * Copyright jgutierrez
 */
package org.inbio.ara.web.species;


import com.sun.data.provider.RowKey;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import org.inbio.ara.facade.PredefinedValuesRemote;
//import org.inbio.ara.facade.person.PersonLocal;
import org.inbio.ara.facade.person.PersonRemote;
import org.inbio.ara.facade.reference.ReferenceRemote;
import org.inbio.ara.facade.species.AudienceRemote;
import org.inbio.ara.facade.util.LanguageRemote;

import org.inbio.ara.facade.species.TaxonDescriptionRecordRemote;
import org.inbio.ara.facade.species.TaxonDescriptionRemote;
import org.inbio.ara.facade.taxonomy.TaxonDescriptionElementRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.person.Person;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.inbio.ara.facade.TaxonDescriptionCategoryFacadeRemote;
import org.inbio.ara.persistence.species.TaxonDescriptionRow;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;
import org.inbio.ara.persistence.util.Language;
import org.inbio.ara.taxon.service.TaxonServiceRemote;
import org.inbio.ara.web.*;
import org.inbio.ara.web.util.MessageBean;

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
public class SpeciesSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    
    private Long[] selectedAudience = new Long[]{};
    private Long[] selectedSpeciesAuthor = new Long[]{};
    private Long[] selectedInstitution = new Long[]{};
    private Long[] selectedReference = new Long[]{};
    private Long selectedLanguage;
    private Long selectedNewStage;
    public TaxonDescriptionRowDataProvider taxonDescriptionRowDataProvider;
    private List hierarchy;
    private int currentTaxonDescriptionCategoryId;
    private boolean isDynamicFormPanelActive = false;
    String ejbMessage;
    private String selectTaxonDescriptionSequence;
    private boolean categoryRepeatable = false;
    private boolean filtered = false;
    private Long selectedTaxonDescriptionRecordSequence;
    private Long selectedTaxonId;
    private TaxonDescriptionDataProvider taxonDescriptionDataProvider = new TaxonDescriptionDataProvider();    
    private long selectedStage;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //personRowSet.setDataSourceName("java:comp/env/jdbc/dataSource");
        //personRowSet.setCommand("SELECT * FROM public.person");
        //personRowSet.setTableName("person");
    }
    
    /*
     
    private CachedRowSet personRowSet = new CachedRowSetImpl();
     
    public CachedRowSet  getPersonRowSet() {
        return personRowSet;
    }
     
    public void setPersonRowSet(CachedRowSet  crsxi) {
        this.personRowSet = crsxi;
    }
     *
     */
    
    private ReferenceRemote referenceRemote = this.lookupReferenceBean();
    
    public ReferenceRemote getReferenceRemote() {
        return referenceRemote;
    }
    
    public void setReferenceRemote(ReferenceRemote referenceRemote) {
        this.referenceRemote = referenceRemote;
    }
    
    private MultipleSelectOptionsList referencesOptions =
            new MultipleSelectOptionsList();
    
    public MultipleSelectOptionsList getReferencesOptions() {
        return referencesOptions;
    }
    
    public void setReferencesOptions(MultipleSelectOptionsList referencesOptions) {
        this.referencesOptions = referencesOptions;
    }
    
    // </editor-fold>
    
    
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SpeciesSessionBean() {
        //setTaxonInfo();
        
        //This code set the references information
        /*
        List<Reference> referencias = getReferenceRemote().findAll();
        Option[] options = new Option[referencias.size()];
        for(int i = 0; i < referencias.size(); i++){
            Reference referencia = referencias.get(i);
            options[i] = new Option(referencia.getId(), referencia.getTextualReference());
        }
        getReferencesOptions().setOptions(options);
        getReferencesOptions().setSelectedValue(new Long[options.length]);
         */
        //This code loads de URL UBI
        //final Long URL_ELEMENT_ID = 3L;
        //setURLUBI(this.getTDR().getTaxonDescriptionRecordByTaxonDescription(this.getCurrentTaxon().getTaxonId(),
        //this.getCurrentTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence(),
        //URL_ELEMENT_ID).getContentsText());
    }
    
    private void setTaxonInfo(){
        currentTaxon.setTaxonId(52160L);
        currentTaxon.setCurrentName("ambigua");
        currentTaxon.setDefaultName("Ara Ambigua");
        this.SRR = this.lookupTaxonDescriptionBean();
        this.currentTaxonDescription = SRR.find(52160L, 1L);
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
            log("SessionBean1 Initialization Failure", e);
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }
    
    /*private ReferencesDP referencesdp = new ReferencesDP();
     
    public ReferencesDP getReferencesdp() {
        return referencesdp;
    }
     
    public void setReferencesdp(ReferencesDP pdp) {
        this.referencesdp = pdp;
    }*/
    
    
    private TaxonDataProvider taxonDataProvider = new TaxonDataProvider();
    private Taxon currentTaxon = new Taxon();
    
    //private SpeciesRecord currentSpeciesRecord = new SpeciesRecord();
    private TaxonDescription currentTaxonDescription = new TaxonDescription();
    //private TaxonDescription currentTaxonDescription;
    private TaxonDescriptionRecord currentTaxonDescriptionRecord;
    //private SpeciesRecordRemote SRR;
    private TaxonDescriptionRemote SRR;
    
    private LanguageRemote LR;
    
    
    
    private List<TaxonDescription> taxonDescriptionList;
    
    private List<Person> taxonDescriptionAuthorList;
    @EJB
    private PredefinedValuesRemote PVR; //= this.lookupPredefinedValuesBean();
    @EJB
    private TaxonDescriptionRecordRemote TDRR = this.lookupTaxonDescriptionRecordBean();
    // = this.lookupTaxonDescriptionBean();
    
    
    private TaxonDescriptionElementRemote TDER;
    
    public PredefinedValuesRemote getPVR() {
        //return PVR;
        return this.lookupPredefinedValuesBean();
    }
    
    public void setPVR(PredefinedValuesRemote PVR) {
        this.PVR = PVR;
    }
    
    
    /*public TaxonDataProvider getTaxondp() {
        return getTaxonDataProvider();
    }
     
    public void setTaxondp(TaxonDataProvider taxondp) {
        this.setTaxonDataProvider(taxondp);
    }*/
    
    private String URLUBI = "";
    
    //private TaxonDataProvider taxonDataProvider = new TaxonDataProvider();
    
    /*public TaxonDataProvider getTaxondp() {
        return taxonDataProvider;
    }
     
    public void setTaxondp(TaxonDataProvider taxonDataProvider) {
        this.taxonDataProvider = taxonDataProvider;
    }*/
    
    /*private EjbTableSorter ejbTableSorter = new EjbTableSorter();
     
    public EjbTableSorter getEjbTableSorter() {
        return ejbTableSorter;
    }
     
    public void setEjbTableSorter(EjbTableSorter ejbTableSorter) {
        this.ejbTableSorter = ejbTableSorter;
    }*/
    
    private TableSelectPhaseListener tablePhaseListener = new TableSelectPhaseListener();
    
    public TableSelectPhaseListener getTablePhaseListener() {
        return tablePhaseListener;
    }
    
    public void setTablePhaseListener(TableSelectPhaseListener tablePhaseListener) {
        this.tablePhaseListener = tablePhaseListener;
    }
    
    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        String dummy = (String) getValue("#{currentRow.value['taxonId']}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }
    
    private PersonRemote lookupPersonBean() {
        try {
            Context c = new InitialContext();
            return (PersonRemote) c.lookup("PersonBeanRemote");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private TaxonDescriptionRecordRemote lookupTaxonDescriptionRecordBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionRecordRemote) c.lookup("TaxonDescriptionRecordBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private TaxonDescriptionCategoryFacadeRemote lookupTaxonDescriptionCategoryFacade() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionCategoryFacadeRemote) c.lookup("TaxonDescriptionCategoryFacade");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private PredefinedValuesRemote lookupPredefinedValuesBean() {
        try {
            Context c = new InitialContext();
            return (PredefinedValuesRemote) c.lookup("PredefinedValuesBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Taxon getCurrentTaxon() {
        return currentTaxon;
    }
    
    public void setCurrentTaxon(Taxon currentTaxon) {
        this.currentTaxon = currentTaxon;
    }
    
    public List<TaxonDescription> getTaxonDescriptionList() {
        return taxonDescriptionList;
    }
    
    public void setTaxonDescriptionList(List<TaxonDescription> taxonDescriptionList) {
        this.taxonDescriptionList = taxonDescriptionList;
    }
    
    public TaxonDescriptionRecord getCurrentTaxonDescriptionRecord() {
        return currentTaxonDescriptionRecord;
    }
    
    public void setCurrentTaxonDescriptionRecord(TaxonDescriptionRecord currentTaxonDescriptionRecord) {
        this.currentTaxonDescriptionRecord = currentTaxonDescriptionRecord;
    }
    
    public List<Person> getTaxonDescriptionAuthorList() {
        return taxonDescriptionAuthorList;
    }
    
    public void setTaxonDescriptionAuthorList(List<Person> taxonDescriptionAuthorList) {
        this.taxonDescriptionAuthorList = taxonDescriptionAuthorList;
    }
    
    public TaxonDescriptionRecordRemote getTDR() {
        return TDRR;
        //return this.lookupTaxonDescriptionRecordBean();
    }
    
    public void setTDR(TaxonDescriptionRecordRemote TDR) {
        this.TDRR = TDR;
    }
    
    /**
     * Guarda los registro
     */
    
    public void saveTaxonDescriptionRecordRow(ArrayList<TaxonDescriptionRecord> TDRToSave) {
        
    }
    
    public boolean saveTaxonDescriptionRecord(TaxonDescriptionRecord taxonDescriptionRecord) {
        boolean created = false;
        
        if (this.lookupTaxonDescriptionRecordBean().create(taxonDescriptionRecord, this.getSelectedReference())) {
            return true;
        } else {
            System.out.println(lookupTaxonDescriptionBean().getMessage());
            this.getutil$MessageBean().addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            //this.addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            return false;
        }
    }
    
    public void saveTaxonDescriptionRecords(ArrayList<TaxonDescriptionRecord> TDRToSave) throws RollbackException {
        try {
            this.TDRR = this.lookupTaxonDescriptionRecordBean();
            for(TaxonDescriptionRecord tdr : TDRToSave){
                //Si se debe crear un Taxon Description NUEVO
                if(tdr.getId() == null){
                    if(TDRR.create(tdr)){
                        System.out.println("success_create");
                    } else{
                        System.out.println("fail_create: " + TDRR.getMessage());
                        throw new RollbackException();
                    }
                }
                //Si se debe modificar un Taxon Description EXISTENTE
                else{
                    if(TDRR.update(tdr)){
                        System.out.println("success_update");
                    } else{
                        System.out.println("fail_update: " + TDRR.getMessage());
                        throw new RollbackException();
                    }
                }
            }
        } catch (Throwable ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    public TaxonDescription getCurrentTaxonDescription() {
        return currentTaxonDescription;
    }
    
    public void setCurrentTaxonDescription(TaxonDescription currentTaxonDescription) {
        this.currentTaxonDescription = currentTaxonDescription;
    }
    
    private TaxonDescriptionRemote lookupTaxonDescriptionBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionRemote) c.lookup("TaxonDescriptionBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private TaxonDescriptionElementRemote lookupTaxonDescriptionElementBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionElementRemote) c.lookup("TaxonDescriptionElementBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public TaxonDescriptionElementRemote getTDER() {
        return this.lookupTaxonDescriptionElementBean();
    }
    
    public void setTDER(TaxonDescriptionElementRemote TDER) {
        this.TDER = TDER;
    }
    
    private LanguageRemote lookupLanguageBean() {
        try {
            Context c = new InitialContext();
            return (LanguageRemote) c.lookup("LanguageBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public LanguageRemote getLR() {
        return this.lookupLanguageBean();
    }
    
    public void setLR(LanguageRemote LR) {
        this.LR = LR;
    }
    
    private ReferenceRemote lookupReferenceBean() {
        try {
            Context c = new InitialContext();
            return (ReferenceRemote) c.lookup("ReferenceBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public String getURLUBI() {
        return URLUBI;
    }
    
    public void setURLUBI(String URLUBI) {
        this.URLUBI = URLUBI;
    }
    
    public TaxonDataProvider getTaxonDataProvider() {
        return taxonDataProvider;
    }
    
    public void setTaxonDataProvider(TaxonDataProvider taxonDataProvider) {
        this.taxonDataProvider = taxonDataProvider;
    }
    
    public void populateList() {
        this.setSelectedAudience(this.getSelectedAudiences());
        this.setSelectedSpeciesAuthor(this.lookupSelectionListManagerBean().getSpeciesAuthor(this.currentTaxonDescription.getTaxonDescriptionPK()));
        this.setSelectedInstitution(this.lookupSelectionListManagerBean().getSpeciesInstitution(this.currentTaxonDescription.getTaxonDescriptionPK()));
        this.setSelectedLanguage(this.getCurrentTaxonDescription().getLanguage().getLanguageId());
        //this.setAvailableStages(this.lookupSelectionListManagerBean().getAvailableStages(this.getCurrentTaxonDescription().getTaxonDescriptionStage().getId()));
        this.setHierarchy(this.lookupTaxonServiceBean().getTaxonHierarchy(currentTaxon.getTaxonId()));
    }
    
    public Option[] getAudience() {
        return this.lookupSelectionListManagerBean().getAudience();
    }
    
    public Option[] getAuthor() {
        return this.lookupSelectionListManagerBean().getSpeciesAuthor();
    }
    
    public Option[] getInstitution() {
        return this.lookupSelectionListManagerBean().getSpeciesInstitution();
    }
    
    public Option[] getAvailableStage() {
        return this.lookupSelectionListManagerBean().getAvailableStages(this.getCurrentTaxonDescription().getTaxonDescriptionStage().getId());
    }
    
    public Option[] getLanguage() {
        return this.lookupSelectionListManagerBean().getLanguage();
    }
    
    public Option[] getReference() {
        return this.lookupSelectionListManagerBean().getReference();
    }
    
    public Option[] getSpecies() {
        return this.lookupSelectionListManagerBean().getSpecies();
    }
    
    public Language getLanguage(Long id) {
        return this.lookupSelectionListManagerBean().getLanguage(id);
    }
    
    public Taxon getTaxon(Long id) {
        return this.lookupSelectionListManagerBean().getTaxon(id);
    }
    
    public TaxonDescriptionStage getStage(Long id) {
        return this.lookupSelectionListManagerBean().getTaxonDescriptionStage(id);
    }
    
    public Option[] getTaxonHierarchy() {
        return this.lookupSelectionListManagerBean().getTaxonHierarchy(this.getCurrentTaxon().getTaxonId());
    }
    
    private SelectionListManagerRemote lookupSelectionListManagerBean() {
        try {
            Context c = new InitialContext();
            return (SelectionListManagerRemote) c.lookup("SelectionListManagerBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Long[] getSelectedAudience() {
        return selectedAudience;
    }
    
    public void setSelectedAudience(Long[] selectedAudience) {
        this.selectedAudience = selectedAudience;
    }
    
    private AudienceRemote lookupAudienceBean() {
        try {
            Context c = new InitialContext();
            return (AudienceRemote) c.lookup("AudienceBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Long[] getSelectedAudiences() {
        /*
        Long[] tList;
        tList = this.lookupTaxonDescriptionBean().getSelectedAudience(this.currentTaxonDescription.getTaxonDescriptionPK());
        if (tList == null) {
            this.setEjbMessage(this.lookupTaxonDescriptionBean().getMessage());
        }
        System.out.println("Cantidad de audiencias seleccionadas: " + tList.length);
        return tList;
         */
        return this.lookupSelectionListManagerBean().getSelectedAudience(this.currentTaxonDescription.getTaxonDescriptionPK());
    }
    
    public String getEjbMessage() {
        return ejbMessage;
    }
    
    public void setEjbMessage(String ejbMessage) {
        this.ejbMessage = ejbMessage;
    }
    
    public Long[] getSelectedSpeciesAuthor() {
        return selectedSpeciesAuthor;
    }
    
    public void setSelectedSpeciesAuthor(Long[] selectedSpeciesAuthor) {
        this.selectedSpeciesAuthor = selectedSpeciesAuthor;
    }
    
    public Long[] getSelectedInstitution() {
        return selectedInstitution;
    }
    
    public void setSelectedInstitution(Long[] selectedInstitution) {
        this.selectedInstitution = selectedInstitution;
    }
    
    public Long getSelectedLanguage() {
        return selectedLanguage;
    }
    
    public void setSelectedLanguage(Long selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
    
    public TaxonDescriptionCategory getTaxonDescriptionCategory(Long id) {
        return this.lookupTaxonDescriptionCategoryFacade().getTaxonDescriptionCategory(id);
    }
    
    
    /*
     * To manage taxa list for the taxonomy tree
     */
    
    // this is just for testing...
    
    private ArrayList dummyList = new ArrayList();
    
    public TaxonDescriptionRowDataProvider getTaxonDescriptionRowDataProvider() {
        return taxonDescriptionRowDataProvider;
    }
    
    public TaxonDescriptionRowDataProvider getTaxonDescriptionRowDataProvider(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        setTaxonDescriptionRowDataProvider(new TaxonDescriptionRowDataProvider(categoryId,taxonId, taxonDescriptionSequence));
        return getTaxonDescriptionRowDataProvider();
    }
    
    public void setTaxonDescriptionRowDataProvider(TaxonDescriptionRowDataProvider taxonDescriptionRowDataProvider) {
        this.taxonDescriptionRowDataProvider = taxonDescriptionRowDataProvider;
    }
    
    public void initTaxonDescriptionRowDataProvider(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        setTaxonDescriptionRowDataProvider(new TaxonDescriptionRowDataProvider(categoryId,taxonId, taxonDescriptionSequence));
    }
    
    
    private TaxonServiceRemote lookupTaxonServiceBean() {
        try {
            Context c = new InitialContext();
            return (TaxonServiceRemote) c.lookup("TaxonServiceBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List getHierarchy() {
        return hierarchy;
    }
    
    public void setHierarchy(List hierarchy) {
        this.hierarchy = hierarchy;
    }
    
    /*
    public static void addErrorMessage(String msg) {
        System.out.println(msg);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("errorMessage", facesMsg);
    }
    
    public static void addSuccessMessage(String msg) {
        System.out.println(msg);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }
     */
    
    public boolean create(TaxonDescription taxonDescription) {
        boolean created = false;
        
        if (this.lookupTaxonDescriptionBean().create(taxonDescription)) {
            this.taxonDescriptionDataProvider.refreshDataList();
            this.setCurrentTaxonDescription(this.lookupTaxonDescriptionBean().getTaxonDescription());
            this.populateList();
            this.setCurrentTaxonDescriptionCategoryId(-1);
            this.getutil$MessageBean().addSuccessMessage("El nuevo registro de especies ha sido creado con éxito.");
            //this.addSuccessMessage("El nuevo registro de especies ha sido creado con ï¿½xito.");
            created = true;
        } else {
            this.getutil$MessageBean().addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            //this.addErrorMessage(lookupTaxonDescriptionBean().getMessage());
        }
        return created;
    }
    
    public boolean update(TaxonDescription taxonDescription) {
        boolean modified = false;
        
        //if (this.lookupTaxonDescriptionBean().update(taxonDescription)) {
        if (this.lookupTaxonDescriptionBean().update(taxonDescription, this.getSelectedAudience(), this.getSelectedSpeciesAuthor(), this.getSelectedInstitution())) {
            this.setCurrentTaxonDescription(this.lookupTaxonDescriptionBean().getTaxonDescription());
            this.getutil$MessageBean().addSuccessMessage("El registro de especies ha sido modificado con éxito.");
            //this.addSuccessMessage("El registro de especies ha sido modificado con ï¿½xito.");
            modified = true;
        } else {
            this.getutil$MessageBean().addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            //this.addErrorMessage(lookupTaxonDescriptionBean().getMessage());
        }
        return modified;
    }
    
    public int getCurrentTaxonDescriptionCategoryId() {
        return currentTaxonDescriptionCategoryId;
    }
    
    public void setCurrentTaxonDescriptionCategoryId(int currentTaxonDescriptionCategoryId) {
        this.currentTaxonDescriptionCategoryId = currentTaxonDescriptionCategoryId;
    }
    
    public ArrayList getDummyList() {
        return dummyList;
    }
    
    public void setDummyList(ArrayList dummyList) {
        this.dummyList = dummyList;
    }
    
    public void addToDummyList(Object o) {
        getDummyList().add(o);
    }
    
    public int getDummyListSize() {
        return getDummyList().size();
    }
    
    
    // now, this is the real thing...
    
    private List taxaList = new ArrayList();
    
    public List getTaxaList() {
        return taxaList;
    }
    
    public void setTaxaList(List taxaList) {
        this.taxaList = taxaList;
    }
    
    public void addToTaxaList(Object o) {
        getTaxaList().add(o);
    }
    
    public int getTaxaListSize() {
        return getTaxaList().size();
    }
    
    public void clearTaxaList() {
        taxaList.clear();
    }
    
    public Object getTaxaListElement(int i) {
        return taxaList.get(i);
    }
    
    public void initDataProvider() {
        if (!filtered) {
            //this.taxonDataProvider.clearObjectList();
            //this.taxonDataProvider.refreshDP();
            this.taxonDescriptionDataProvider.clearObjectList();
            this.taxonDescriptionDataProvider.refreshDataList();
        }
    }
    
    public boolean isFiltered() {
        return filtered;
    }
    
    public void setFiltered(boolean isFiltered) {
        this.filtered = isFiltered;
    }
    
    public Long getSelectedNewStage() {
        return selectedNewStage;
    }
    
    public void setSelectedNewStage(Long selectedNewStage) {
        this.selectedNewStage = selectedNewStage;
    }

    public boolean isIsDynamicFormPanelActive() {
        return isDynamicFormPanelActive;
    }

    public void setIsDynamicFormPanelActive(boolean isDynamicFormPanelActive) {
        this.isDynamicFormPanelActive = isDynamicFormPanelActive;
    }
    
    public Long getNextSequence() {
        Long sequence = 0L;
        Long taxonId = this.currentTaxonDescription.getTaxonDescriptionPK().getTaxonId();
        Long taxonDescriptionSequence = this.currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();        
        sequence = this.lookupTaxonDescriptionRecordBean().getNextTaxonDescriptionRecordSequence(taxonDescriptionSequence, taxonId);        
        return sequence;
    }
    
    public boolean deleteTaxonDescriptionRecordRow(Long rowId) {
        Long taxonDescriptionSequence = this.currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();
        Long taxonId = this.currentTaxonDescription.getTaxonDescriptionPK().getTaxonId();
        if (this.lookupTaxonDescriptionRecordBean().deleteTaxonDescriptionRecordRow(taxonDescriptionSequence, taxonId, rowId)) {
            this.getutil$MessageBean().addSuccessMessage("Descripciones borradas con éxito");
            //this.addSuccessMessage("Descripciones borradas con ï¿½xito");
            return true;
        } else {
            this.setEjbMessage(lookupTaxonDescriptionRecordBean().getMessage());
            this.getutil$MessageBean().addErrorMessage(this.getEjbMessage());
            //this.addErrorMessage("Error al borrar descripciones: " + this.getEjbMessage());
            return false;
        }
    }
    
    public boolean deleteTaxonDescriptionRecordRow(RowKey rowKey) {
        System.out.println("AraSessionBean:deleteTaxonDescriptionRecordRow");
        if (rowKey != null) {
            //setPerson((Person)personDataProvider.getObject(rowKey));
            TaxonDescriptionRow rowObj = (TaxonDescriptionRow)this.taxonDescriptionRowDataProvider.getObject(rowKey);
            Long rowId = rowObj.getRowId();
            if (deleteTaxonDescriptionRecordRow(rowId)) {
                System.out.println("Row Borrado");
                return true;
            } else {
                System.out.println("Row No NoBorrado");
                return false;
            }
        } else {
            System.out.println("rowKey es nulo.");
            return false;
        }
    }

    public String getSelectTaxonDescriptionSequence() {
        return selectTaxonDescriptionSequence;
    }

    public void setSelectTaxonDescriptionSequence(String selectTaxonDescriptionSequence) {
        this.selectTaxonDescriptionSequence = selectTaxonDescriptionSequence;
    }   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1)getBean("ApplicationBean1");
    }
    
    public void remove(Long taxonId, Long taxonDescriptionSequence) {
        if (this.lookupTaxonDescriptionBean().remove(taxonId, taxonDescriptionSequence)) {
            this.getutil$MessageBean().addSuccessMessage("Registro borrado con éxito.");
            //this.addSuccessMessage("Registro borrado con éxito.");
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupTaxonDescriptionBean().getMessage());
           //this.addErrorMessage(this.lookupTaxonDescriptionBean().getMessage()); 
        }
    }

    public Long[] getSelectedReference() {
        return selectedReference;
    }

    public void setSelectedReference(Long[] selectedReference) {
        this.selectedReference = selectedReference;
    }
    
    public void getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId) {
        this.setSelectedReference(this.lookupSelectionListManagerBean().getTaxonDescriptionRecordReference(taxonDescriptionRecordId));
    }

    public boolean isCategoryRepeatable() {
        return categoryRepeatable;
    }

    public void setCategoryRepeatable(boolean categoryRepeatable) {
        this.categoryRepeatable = categoryRepeatable;
    }

    public Long getSelectedTaxonDescriptionRecordSequence() {
        return selectedTaxonDescriptionRecordSequence;
    }

    public void setSelectedTaxonDescriptionRecordSequence(Long selectedTaxonDescriptionRecordSequence) {
        this.selectedTaxonDescriptionRecordSequence = selectedTaxonDescriptionRecordSequence;
    }
    
    public void setSelectedTaxonDescriptionRecordRowKey(RowKey rowKey){
        if (rowKey != null) {
            TaxonDescriptionRecord tmp = (TaxonDescriptionRecord)taxonDescriptionRowDataProvider.getObject(rowKey);
            Long sequence = tmp.getSequence();
            setSelectedTaxonDescriptionRecordSequence(sequence);
        } else {
            System.out.println("rowKey es nulo.");
        }
    }

    public Long getSelectedTaxonId() {
        return selectedTaxonId;
    }

    public void setSelectedTaxonId(Long selectedTaxonId) {
        this.selectedTaxonId = selectedTaxonId;
    }

    public TaxonDescriptionDataProvider getTaxonDescriptionDataProvider() {
        return taxonDescriptionDataProvider;
    }

    public void setTaxonDescriptionDataProvider(TaxonDescriptionDataProvider taxonDescriptionDataProvider) {
        this.taxonDescriptionDataProvider = taxonDescriptionDataProvider;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    public long getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(long selectedStage) {
        this.selectedStage = selectedStage;
    }
}