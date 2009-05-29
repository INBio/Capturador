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
 * Header.java
 *
 * Created on October 3, 2007, 3:05 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.FacesContext;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
//import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
//import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
//import org.inbio.ara.web.species.newTaxonDescriptionRecord;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Header extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private ImageComponent image1 = new ImageComponent();

    public ImageComponent getImage1() {
        return image1;
    }

    public void setImage1(ImageComponent ic) {
        this.image1 = ic;
    }
    private HtmlOutputLink hyperlink1 = new HtmlOutputLink();

    public HtmlOutputLink getHyperlink1() {
        return hyperlink1;
    }

    public void setHyperlink1(HtmlOutputLink hol) {
        this.hyperlink1 = hol;
    }
    // </editor-fold>

    public Header() {
    }

    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Module page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(getSessionManager().getLocale());
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean) getBean("user$UserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    public String hlink_species_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return "case3";
    }

    public String hlink_user_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return "case2";
    }

    public String hlink_person_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return "case2";
    }

    public String hlink_profile_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String hlink_institution_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String hlink_changePwd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return "case1";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.AraRequestBean getAraRequestBean() {
        return (org.inbio.ara.web.AraRequestBean) getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.species.SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (org.inbio.ara.web.species.SpeciesSessionBean) getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.AraApplicationBean getAraApplicationBean() {
        return (org.inbio.ara.web.AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.admin.institution.InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (org.inbio.ara.web.admin.institution.InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean) getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.references.ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (org.inbio.ara.web.references.ReferenceSessionBean) getBean("references$ReferenceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.SessionBean1 getSessionBean1() {
        return (org.inbio.ara.web.SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.RequestBean1 getRequestBean1() {
        return (org.inbio.ara.web.RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.util.SelectionListBean getutil$SelectionListBean() {
        return (org.inbio.ara.web.util.SelectionListBean) getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (org.inbio.ara.web.gathering.GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.site.SiteSessionBean getsite$SiteSessionBean() {
        return (org.inbio.ara.web.site.SiteSessionBean) getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
    }
    private Hyperlink spanishLink1 = new Hyperlink();

    public Hyperlink getSpanishLink1() {
        return spanishLink1;
    }

    public void setSpanishLink1(Hyperlink h) {
        this.spanishLink1 = h;
    }
    private Hyperlink englishLink1 = new Hyperlink();

    public Hyperlink getEnglishLink1() {
        return englishLink1;
    }

    public void setEnglishLink1(Hyperlink h) {
        this.englishLink1 = h;
    }

    public String englishLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        getSessionManager().setLocale(Locale.ENGLISH);
        System.out.println("--------->>>" + getSessionManager().getLocale().toString());
        return null;
    }

    public String spanishLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("ES");
        context.getViewRoot().setLocale(l);
        getSessionManager().setLocale(l);
        System.out.println("--------->>>" + getSessionManager().getLocale().toString());
        return null;
    }

	public String frenchLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("FR");
        context.getViewRoot().setLocale(l);
        getSessionManager().setLocale(l);
        System.out.println("--------->>>" + getSessionManager().getLocale().toString());
        return null;
    }

    //todo: alambrado
    //taxonomia
    public String menuModuleNomenclaturalGroups_action() {
        this.getSessionManager().setCurrentModuleId(new Long(7));
        return "listNomenclaturalGroup";
    }

    public String menuModuleSpecies_action() {
        this.getSessionManager().setCurrentModuleId(new Long(8));
        return "listSpecies";
    }

    public String menuModuleTaxa_action() {
        this.getSessionManager().setCurrentModuleId(new Long(6));
        return "listTaxon";
    }

    //inventario
    public String menuModuleGatheringsObservations_action() {
        this.getSessionManager().setCurrentModuleId(new Long(1));
        return "listGathering";
    }

    public String menuModuleIdentifications_action() {
        this.getSessionManager().setCurrentModuleId(new Long(3));
        return "listIdentification";
    }

    public String menuModuleSpecimens_action() {
        this.getSessionManager().setCurrentModuleId(new Long(2));
        return "listSpecimen";
    }

    //menu informacion geografica
    public String menuModuleLocations_action() {
        this.getSessionManager().setCurrentModuleId(new Long(5));
        return "listSite";
    }

    //menu administracion
    public String menuModuleAdminCollections_action() {
        this.getSessionManager().setCurrentModuleId(new Long(21));
        return "adminCollections";
    }

    public String menuModuleAudiences_action() {
        this.getSessionManager().setCurrentModuleId(new Long(19));
        return "listAudience";
    }

    public String menuModuleChangePassword_action() {
        this.getSessionManager().setCurrentModuleId(new Long(17));
        return "changePassword";
    }

    public String menuModuleInstitutions_action() {
        this.getSessionManager().setCurrentModuleId(new Long(14));
        return "listInstitution";
    }

    public String menuModulePeople_action() {
        this.getSessionManager().setCurrentModuleId(new Long(13));
        return "listPerson";
    }

    public String menuModuleProfiles_action() {
        this.getSessionManager().setCurrentModuleId(new Long(16));
        return "listProfile";
    }

    public String menuModuleReferences_action() {
        this.getSessionManager().setCurrentModuleId(new Long(18));
        return "listReference";
    }

    public String menuModuleSelectionLists_action() {
        this.getSessionManager().setCurrentModuleId(new Long(20));
        return "listSelectionList";
    }

    public String menuModuleStages_action() {
        this.getSessionManager().setCurrentModuleId(new Long(15));
        return "listStage";
    }

    public String menuModuleGeographicalLayers_action() {
        this.getSessionManager().setCurrentModuleId(new Long(23));
        return "adminGeographicalLayers";
    }

    //menu seguridad
    public String menuModuleGroups_action() {
        this.getSessionManager().setCurrentModuleId(new Long(10));
        return "listGroup";
    }

    public String menuModuleUsers_action() {
        this.getSessionManager().setCurrentModuleId(new Long(9));
        return "listUser";
    }

    //menu reportes
    public String menuModuleReportsSpecimen_action() {
        this.getSessionManager().setCurrentModuleId(new Long(22));
        return "reportSpecimen";
    }
    public String menuShare_action() {
        this.getSessionManager().setCurrentModuleId(new Long(23));
        return "share";
    }
}
