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

package org.inbio.ara;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.ImageComponent;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.FacesContext;
import org.inbio.ara.util.MessageBean;

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
    @Override
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
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    public String englishLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        this.getSessionManager().setLocale(Locale.ENGLISH);
        return null;
    }

    public String spanishLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("ES");
        context.getViewRoot().setLocale(l);
        this.getSessionManager().setLocale(l);
        return null;
    }

	public String frenchLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("FR");
        context.getViewRoot().setLocale(l);
        this.getSessionManager().setLocale(l);
        return null;
    }

    /**
     * Method to close the HTML session
     * @return
     */
    public String closeSession(){
        this.getSessionManager().doLogoff();
        return "exit";
    }

    //Menú taxonomía
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
        //return "editTaxonomy";
        return "listTaxonomy";
    }

    //Menú inventario
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

    //Módulo de transacciones
    public String menuModuleTransactions_action() {
        this.getSessionManager().setCurrentModuleId(new Long(29));
        return "listTransaction";
    }

    //Menú informacion geografica
    public String menuModuleLocations_action() {
        this.getSessionManager().setCurrentModuleId(new Long(5));
        return "listSite";
    }

    //Menú administracion
    public String menuModuleAdminCollections_action() {
        this.getSessionManager().setCurrentModuleId(new Long(21));
        return "listCollection";
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

    public String menuModuleIndicator_action() {
        this.getSessionManager().setCurrentModuleId(new Long(30));
        return "listIndicator";
    }

    //Menú seguridad
    public String menuModuleGroups_action() {
        this.getSessionManager().setCurrentModuleId(new Long(10));
        return "listGroup";
    }

    public String menuModuleUsers_action() {
        this.getSessionManager().setCurrentModuleId(new Long(9));
        return "listUser";
    }

    //Menú reportes
    public String menuModuleReportsSpecimen_action() {
        this.getSessionManager().setCurrentModuleId(new Long(22));
        return "reportSpecimen";
    }
    public String menuShare_action() {
        this.getSessionManager().setCurrentModuleId(new Long(23));
        return "snapshots";
    }

    //Menú germoplasma -> Entrada a Administracion de Pasaportes
    public String menuModuleGermPlasmPassport_action() {
        this.getSessionManager().setCurrentModuleId(new Long(25));
        return "passports";
    }

    //Menú germoplasma -> Entrada a Administracion de Accessiones
    public String menuModuleGermPlasmAccession_action() {
        this.getSessionManager().setCurrentModuleId(new Long(26));
        return "accessions";
    }

    //Menú germoplasma -> Entrada a Administracion de Accessiones
    public String menuModuleGermPlasmBreeds_action() {
        this.getSessionManager().setCurrentModuleId(new Long(27));
        return "breeds";
    }

    //Menú germoplasma -> Entrada a Administracion de Accessiones
    public String menuModuleGermPlasmSemental_action() {
        this.getSessionManager().setCurrentModuleId(new Long(28));
        return "sementals";
    }

    public String menuModuleDublinCore_action(){
        this.getSessionManager().setCurrentModuleId(new Long(31));
        return "dublincore";
    }
    /**
     * OBLIGATORIO:
     * ESTE NUMERO A CONTINUACIÓN SE DEBE DE ACTUALIZAR CADA VEZ QUE SE INGRESE
     * UNA NUEVA SECCION
     * El numero representa el ultimo numero asociado para el los modulos
     * ULTIMO ID DE MODULO INGRESADO = 31
     */
}
