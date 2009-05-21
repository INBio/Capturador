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
 * newTaxonDescriptionRecord.java
 *
 * Created on February 18, 2008, 11:17 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.species;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.StaticText;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;
import org.inbio.ara.persistence.util.Language;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.MathUtils;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.person.searchPerson;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.uimanagers.DynamicPanelForm;
import static org.inbio.ara.web.uimanagers.Components.*;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class newTaxonDescriptionRecord extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }

    private StaticText st_CategoryName1 = new StaticText();

    public StaticText getSt_CategoryName1() {
        return st_CategoryName1;
    }

    public void setSt_CategoryName1(StaticText st) {
        this.st_CategoryName1 = st;
    }

    private DynamicPanelForm dynamicPanelForm = new DynamicPanelForm();

    public HtmlPanelGrid getDynamicPanelForm() {
        return dynamicPanelForm.getPanel();
    }
    
    public void setDynamicPanelForm(HtmlPanelGrid panel) {
        this.dynamicPanelForm.setPanel(panel);
    }

    private Button saveRecordDataButton = new Button();

    public Button getSaveRecordDataButton() {
        return saveRecordDataButton;
    }

    public void setSaveRecordDataButton(Button b) {
        this.saveRecordDataButton = b;
    }

    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public newTaxonDescriptionRecord() {
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
            log("Module newTaxonDescriptionRecord Initialization Failure", e);
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
    public void prerender() {
        this.createDynamicForm();
    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean)getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean)getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean)getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
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
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean)getBean("audience$AudienceSessionBean");
    }
    
    private void createDynamicForm() {
        int category = this.getspecies$SpeciesSessionBean().getCurrentTaxonDescriptionCategoryId();
        final Long taxonId = getspecies$SpeciesSessionBean().getCurrentTaxon().getTaxonId();
        List<TaxonDescriptionElement> list = getspecies$SpeciesSessionBean().getPVR().getElements(category);
        
        //Establece las columnas, lineas, espacios y borde
        this.setPanelProperties();
        
        //En este for se realiza la construccion del panel
        for(TaxonDescriptionElement tde : list){
            TaxonDescriptionRecord taxonDescriptionRecord;
            Long TDEId = tde.getId();
            Long contentNumber = 0L;
            String elementName = tde.getName();
            
            TaxonDescription currentTaxonDescription =getspecies$SpeciesSessionBean().getCurrentTaxonDescription();
            //taxonDescriptionRecord = getAraSessionBean().getTDR().getTaxonDescriptionRecordByTaxonDescription(taxonId,currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(),TDEId);
            taxonDescriptionRecord = null;
            
            if(taxonDescriptionRecord != null){
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(taxonDescriptionRecord.getId()));
                contentNumber = taxonDescriptionRecord.getContentsNumeric();
            }else{  //si hay un 0 en el hiddenField el TaxonDescr no existe
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(0));
            }
            
            //Coloca el TaxonDescriptionElement Id
            dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(tde.getId()));
            //Coloca el label
            this.setLabel(elementName);
            
            //Aqui se debe cargar el hash con las propiedades de los componentes
            //Si NO es nulo el tableName de la instancia TDE
            if (tde.getTableName() != null) {
                String tableName = tde.getTableName();
                setComponentWithPredifinedInfo(tde, contentNumber);
            } else{ //buscar info en taxon_description
                Long componentId = tde.getTaxonDescriptionDataType().getId();
                if(taxonDescriptionRecord != null){
                    dynamicPanelForm.setComponent(componentId,
                            setValueProperty(taxonDescriptionRecord.getContentsText()));
                } else{
                    dynamicPanelForm.setComponent(componentId, setValueProperty("-"));
                }
            }
        }//Fin de la construccion del panel
    }
    
    private HashMap setValueProperty(Object value){
        HashMap hashMap = new HashMap();
        hashMap.put("value", value);
        return hashMap;
    }
    
    private void setLabel(String text) {
        HashMap hash = new HashMap();
        try{
            hash.put("value", ResourceBundle.getBundle("org/inbio/ara/Bundle").
                getString(text));
        }catch (Exception e) {
            hash.put("value", text);
        }
        dynamicPanelForm.setComponent(LABEL, hash);
        hash.clear();
    }
    
    private void setPanelProperties() {
        dynamicPanelForm.getPanel().getChildren().clear();
        //1) hiddenField_Tid 2) hiddenField_TDEid 3) label 4) graphicalComponent
        dynamicPanelForm.getPanel().setColumns(4);
        dynamicPanelForm.getPanel().setBorder(1);
        dynamicPanelForm.getPanel().setRules("rows");
        dynamicPanelForm.getPanel().setCellspacing("5");
        dynamicPanelForm.getPanel().setCellpadding("5");
    }

   
    
    private void setComponentWithPredifinedInfo(TaxonDescriptionElement tde,Long contentNumber) {
        HashMap hash = new HashMap();
        Long componentId = tde.getTaxonDescriptionDataType().getId();
        
        if(MathUtils.isOdd(componentId)){
            HashMap options = getspecies$SpeciesSessionBean().getPVR().hashMapListBox(tde.getTableName(),tde.getKeyField(), tde.getMainFieldName());
            hash.clear();
            System.out.println("Cont Number " + contentNumber);
            hash.put("value", contentNumber);
            dynamicPanelForm.setComponent(componentId, hash, UI_SELECT_ITEMS, options);
        } else{
            System.err.println("Error en el datatypeId de un TDE");
        }
    }    

    public String saveRecordData_action() {
        ArrayList<TaxonDescriptionRecord> TDRsToSave = new ArrayList();
        List<UIComponent> graphicalComponents = dynamicPanelForm.getPanel().getChildren();
        Language language = new Language();
        language.setLanguageId(1L);
        //
        //*Por cada TaxonDescription se imprime 1) Tid 2) TDE id 3) etiqueta (omitir)
        //*4) el valor del textfield
        //*Se deben conservar el valor del 1 y el 3 para crear un nuevo taxonDesc
        //*o para modificar uno ya existente.
        //
        for(int i = 0; i < graphicalComponents.size(); i++){
            UIComponent c = graphicalComponents.get(i);
            if ( (i % 4) == 0 ){
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);
                
                //Si el id del TDR es 0 significa q es uno nuevo!
                if(taxonDescriptionRecordId.toString().equals("0")){
                    TaxonDescriptionRecord TDR = new TaxonDescriptionRecord();
                    TaxonDescriptionElement TDE;
                    try {
                    TDR.setCreatedBy(this.getSessionManager().getUser().getUserName());
                    TDR.setLastModificationBy(this.getSessionManager().getUser().getUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }
                    TDR.setSequence(this.getspecies$SpeciesSessionBean().getNextSequence());
                    TDR.setTaxonomicalTimestamp(new Date());
                    TDR.setTaxonDescription(getspecies$SpeciesSessionBean().getCurrentTaxonDescription());
                    i++;
                    c = graphicalComponents.get(i);
                    
                    Long tdeId = getIdFromGUIComponent(c);
                    if(tdeId != null){
                        TDE = getspecies$SpeciesSessionBean().getTDER().find(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try{
                            TDR.setTaxonDescriptionElement(TDE);
                            if (TDE.getTableName() == null) {
                                TDR.setContentsNumeric(0L);
                                TDR.setContentsText(c.getAttributes().get("value").toString());
                                TDRsToSave.add(TDR);
                            } else {
                                Long foreignId = getIdFromGUIComponent(c);
                                if(foreignId != null){
                                    TDR.setContentsNumeric(foreignId);
                                    TDRsToSave.add(TDR);
                                }
                            }
                        } catch(Exception e){
                            System.err.println("Error -> " + e.toString() + " " + e.getLocalizedMessage() + " " + e.getMessage());
                        }
                    }
                } else{  //Guardar un TaxonDescription que ya existe -> EDITAR
                    TaxonDescriptionRecord TDR;
                    TaxonDescriptionElement tde = new TaxonDescriptionElement();
                    
                    TDR = getspecies$SpeciesSessionBean().getTDR().find(taxonDescriptionRecordId);
                    if(TDR != null){
                        System.out.println(TDR.getId());
                    } else{
                        System.err.println("No recupere el TD");
                    }
                    i += 3;
                    c = graphicalComponents.get(i);
                    if(TDR.getContentsNumeric() == 0L){
                        String modifiedValue =
                                c.getAttributes().get("value").toString();
                        TDR.setContentsText(modifiedValue);
                        TDRsToSave.add(TDR);
                    } else{
                        Long foreignId = getIdFromGUIComponent(c);
                        if(foreignId != null){
                            TDR.setContentsNumeric(foreignId);
                            TDRsToSave.add(TDR);
                        }
                    }
                }
            }
        }
        
        try {
            this.getspecies$SpeciesSessionBean().saveTaxonDescriptionRecords(TDRsToSave);
            this.getspecies$SpeciesSessionBean().setCurrentTaxonDescriptionCategoryId(-1);
        } catch (Exception e) {
            //
        }        
        return "case1";
    }
    
    private Long getIdFromGUIComponent(UIComponent comp){
        try{
            return Long.parseLong(comp.getAttributes().get("value").toString());
        } catch (NumberFormatException e){
            System.err.println("ID invalido: " + e.getLocalizedMessage());
        } catch (Exception e){ }
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected searchPerson getadmin$person$searchPerson() {
        return (searchPerson)getBean("admin$person$searchPerson");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.RequestBean1 getRequestBean1() {
        return (org.inbio.ara.web.RequestBean1)getBean("RequestBean1");
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
    protected org.inbio.ara.web.util.SelectionListBean getutil$SelectionListBean() {
        return (org.inbio.ara.web.util.SelectionListBean)getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (org.inbio.ara.web.gathering.GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (org.inbio.ara.web.gathering.SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.site.SiteSessionBean getsite$SiteSessionBean() {
        return (org.inbio.ara.web.site.SiteSessionBean)getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean)getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean)getBean("identification$IdentificationSearchSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean)getBean("specimen$SpecimenSessionBean");
    }
}
