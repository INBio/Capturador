/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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
package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Label;
//import com.sun.webui.jsf.component.TextArea;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlInputTextarea;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionAudienceDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionInstitutionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionPersonProfileDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO;
import org.inbio.ara.guimanagers.Components;
import org.inbio.ara.guimanagers.DynamicPanelForm;
import org.inbio.ara.statistics.StatisticsSessionBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version PreviewSpecies.java
 * @version Created on 02/11/2009, 04:04:32 PM
 * @author esmata
 */

public class PreviewSpecies extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Bindings de los componentes graficos
    private HtmlInputTextarea abstractText = new HtmlInputTextarea();
    private Label descriptionsLabel = new Label();
    private DynamicPanelForm descriptionsDynamicPanel = new DynamicPanelForm();
    private Label audiencesLabel = new Label();
    private DynamicPanelForm audiencesDynamicPanel = new DynamicPanelForm();
    private Label authorsLabel = new Label();
    private DynamicPanelForm authorDynamicPanel = new DynamicPanelForm();
    private Label institutionsLabel = new Label();
    private DynamicPanelForm institutionsDynamicPanel = new DynamicPanelForm();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PreviewSpecies() {
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
            log("PreviewSpecies Initialization Failure", e);
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
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        Long taxonId = ssb.getCurrentTaxDescripDTO().getTaxonId();
        Long taxonDescriptionSequence = ssb.getCurrentTaxDescripDTO().
                getTaxonDescriptionSequence();
        //Panel de descripciones
        setPanelProperties(this.descriptionsDynamicPanel, 3);
        List<TaxonDescriptionRecordDTO> TDRList =
                ssb.getTaxonomyFacadeImpl().getTaxonDescriptionRecordsByTaxonDescription
                (taxonId, taxonDescriptionSequence);
        writeDescriptions(TDRList);
        //Panel de audiencias
        setPanelProperties(audiencesDynamicPanel, 1);
        List<TaxonDescriptionAudienceDTO> TDAList =
                ssb.getTaxonomyFacadeImpl().getTDAudiencesByTaxonDescription
                (taxonId, taxonDescriptionSequence);
        writeAudiences(TDAList);
        //Panel de autores
        setPanelProperties(authorDynamicPanel, 1);
        List<TaxonDescriptionPersonProfileDTO> authorList =
                ssb.getTaxonomyFacadeImpl().getAuthorsByTaxonDescription
                (taxonId, taxonDescriptionSequence);
        writeAuthors(authorList);
        //Finalmente el panel de instituciones relacionadas
        setPanelProperties(institutionsDynamicPanel, 1);
        List<TaxonDescriptionInstitutionDTO> institutionsList =
                ssb.getTaxonomyFacadeImpl().getTDInstitutionsByTaxonDescription
                (taxonId, taxonDescriptionSequence);
        writeInstitutions(institutionsList);
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

    private void setPanelProperties(DynamicPanelForm panel, int cols) {
        HashMap p = new HashMap();
        panel.getPanel().getChildren().clear();
        p.put("columns", cols);
        p.put("border", 1);
        p.put("rules", "all");
        p.put("rowClasses", "list-row-even,list-row-odd");        
        panel.setPanelProperties(p);
    }

    private void writeDescriptions(List<TaxonDescriptionRecordDTO> data) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        if(data.isEmpty())
            this.descriptionsLabel.setVisible(false);
        for(TaxonDescriptionRecordDTO TDR : data){
            HashMap info = new HashMap();
            //Si es un valor textual esta directamente disponible
            if (TDR.getContentsNumeric() == 0) {
                //76 es el abstract
                if (TDR.getTaxonDescriptionElementId() == 76L) {
                    this.abstractText.setValue(TDR.getContentsText());
                } else {
                    TaxonDescriptionElementDTO tde = ssb.getTaxonomyFacadeImpl().
                            getElementById(TDR.getTaxonDescriptionElementId());
                    TaxonDescriptionCategoryDTO tdc = ssb.getTaxonomyFacadeImpl().
                            getCategoryById(tde.getTaxonDescriptionCategoryId());
                    info.put("value", tdc.getName());
                    this.descriptionsDynamicPanel.setComponent(Components.LABEL, info);
                    info.put("value", tde.getName());
                    this.descriptionsDynamicPanel.setComponent(Components.LABEL, info);
                    info.put("value", TDR.getContentsText());
                    this.descriptionsDynamicPanel.setComponent(Components.TEXT_AREA, info);
                }
            } else {
                TaxonDescriptionElementDTO tde = ssb.getTaxonomyFacadeImpl().
                        getElementById(TDR.getTaxonDescriptionElementId());
                TaxonDescriptionCategoryDTO tdc = ssb.getTaxonomyFacadeImpl().
                        getCategoryById(tde.getTaxonDescriptionCategoryId());

                Long contentsNumeric = TDR.getContentsNumeric();
                String tableName = tde.getTableName();
                String keyField = tde.getKeyField();
                String tableField =tde.getMainFieldName();
                String textualValue =
                        ssb.getTaxonomyFacadeImpl().getFieldContent
                        (contentsNumeric, tableName, keyField, tableField);
                info.put("value", tdc.getName());
                this.descriptionsDynamicPanel.setComponent(Components.LABEL, info);
                info.put("value", tde.getName());
                this.descriptionsDynamicPanel.setComponent(Components.LABEL, info);
                info.put("value", textualValue);
                this.descriptionsDynamicPanel.setComponent(Components.TEXT_AREA, info);
            }

        }
    }

    private void writeAudiences(List<TaxonDescriptionAudienceDTO> TDAList) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        if(TDAList!=null){
            if(TDAList.size() == 0)
                this.audiencesLabel.setVisible(false);
            for (TaxonDescriptionAudienceDTO tdaDTO :TDAList) {
                HashMap info = new HashMap();
                AudienceDTO a = ssb.getTaxonomyFacadeImpl().getAudienceById(tdaDTO.getAudienceId());
                info.put("value", a.getName());
                this.audiencesDynamicPanel.setComponent(0L, info);
            }
        }
    }

    private void writeAuthors(List<TaxonDescriptionPersonProfileDTO> authorList) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        if (authorList!=null){
            if(authorList.size() == 0)
                this.authorsLabel.setVisible(false);
            for (TaxonDescriptionPersonProfileDTO tdppDTO :authorList) {
                HashMap info = new HashMap();
                PersonDTO p = ssb.getTaxonomyFacadeImpl().getPersonById(tdppDTO.getPersonId());
                info.put("value", p.getNaturalLongName());
                this.authorDynamicPanel.setComponent(0L, info);
            }
        }
    }

    private void writeInstitutions(List<TaxonDescriptionInstitutionDTO>
            institutionsList) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        if(institutionsList!=null){
            if(institutionsList.size() == 0)
                this.institutionsLabel.setVisible(false);
            for (TaxonDescriptionInstitutionDTO tdi :institutionsList) {
                HashMap info = new HashMap();
                InstitutionDTO iDTO = ssb.getTaxonomyFacadeImpl().getInstitutionById
                        (tdi.getInstitutionId());
                info.put("value", iDTO.getInstitutionName());
                this.institutionsDynamicPanel.setComponent(0L, info);
            }
        }
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
    protected ProfileSessionBean getadmin$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean gettaxonomy$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("taxonomy$SpeciesSessionBean");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * @return the abstractText
     */
    public HtmlInputTextarea getAbstractText() {
        return abstractText;
    }

    /**
     * @param abstractText the abstractText to set
     */
    public void setAbstractText(HtmlInputTextarea abstractText) {
        this.abstractText = abstractText;
    }

    /**
     * @return the descriptionsLabel
     */
    public Label getDescriptionsLabel() {
        return descriptionsLabel;
    }

    /**
     * @param descriptionsLabel the descriptionsLabel to set
     */
    public void setDescriptionsLabel(Label descriptionsLabel) {
        this.descriptionsLabel = descriptionsLabel;
    }

    /**
     * @return the descriptionsDynamicPanel
     */
    public HtmlPanelGrid getDescriptionsDynamicPanel() {
        return descriptionsDynamicPanel.getPanel();
    }

    /**
     * @param descriptionsDynamicPanel the descriptionsDynamicPanel to set
     */
    public void setDescriptionsDynamicPanel(HtmlPanelGrid descriptionsDynamicPanel) {
        this.descriptionsDynamicPanel.setPanel(descriptionsDynamicPanel);
    }

    /**
     * @return the audiencesLabel
     */
    public Label getAudiencesLabel() {
        return audiencesLabel;
    }

    /**
     * @param audiencesLabel the audiencesLabel to set
     */
    public void setAudiencesLabel(Label audiencesLabel) {
        this.audiencesLabel = audiencesLabel;
    }

    /**
     * @return the audiencesDynamicPanel
     */
    public HtmlPanelGrid getAudiencesDynamicPanel() {
        return audiencesDynamicPanel.getPanel();
    }

    /**
     * @param audiencesDynamicPanel the audiencesDynamicPanel to set
     */
    public void setAudiencesDynamicPanel(HtmlPanelGrid audiencesDynamicPanel) {
        this.audiencesDynamicPanel.setPanel(audiencesDynamicPanel);
    }

    /**
     * @return the authorsLabel
     */
    public Label getAuthorsLabel() {
        return authorsLabel;
    }

    /**
     * @param authorsLabel the authorsLabel to set
     */
    public void setAuthorsLabel(Label authorsLabel) {
        this.authorsLabel = authorsLabel;
    }

    /**
     * @return the authorDynamicPanel
     */
    public HtmlPanelGrid getAuthorDynamicPanel() {
        return authorDynamicPanel.getPanel();
    }

    /**
     * @param authorDynamicPanel the authorDynamicPanel to set
     */
    public void setAuthorDynamicPanel(HtmlPanelGrid authorDynamicPanel) {
        this.authorDynamicPanel.setPanel(authorDynamicPanel);
    }

    /**
     * @return the institutionsLabel
     */
    public Label getInstitutionsLabel() {
        return institutionsLabel;
    }

    /**
     * @param institutionsLabel the institutionsLabel to set
     */
    public void setInstitutionsLabel(Label institutionsLabel) {
        this.institutionsLabel = institutionsLabel;
    }

    /**
     * @return the institutionsDynamicPanel
     */
    public HtmlPanelGrid getInstitutionsDynamicPanel() {
        return institutionsDynamicPanel.getPanel();
    }

    /**
     * @param institutionsDynamicPanel the institutionsDynamicPanel to set
     */
    public void setInstitutionsDynamicPanel(HtmlPanelGrid institutionsDynamicPanel) {
        this.institutionsDynamicPanel.setPanel(institutionsDynamicPanel);
    }
    
}

