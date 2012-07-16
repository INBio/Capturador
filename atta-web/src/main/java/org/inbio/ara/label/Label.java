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

package org.inbio.ara.label;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.component.html.HtmlInputTextarea;
import com.sun.webui.jsf.component.TextField;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version label.java
 * @version Created on 25/01/2010, 09:39:45 AM
 * @author  pcorrales
 */

public class Label extends AbstractPageBean {


    //Contexto utilizado para obtener el current locale
     private FacesContext context;
     private Locale myLocale;


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }


    //Binding de los componenetes graficos
    private TextField txSpecimen = new TextField();
    private HtmlInputTextarea txaLabelFormat = new HtmlInputTextarea();


    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Label() {
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
            log("label Initialization Failure", e);
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getgis$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReportsSessionBean getreports$ReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected TaxonomySessionBean gettaxonomy$TaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
    protected SnapshotSessionBean getreports$SnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
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
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AdminGeographicLayersSessionBean getadmin$AdminGeographicLayersSessionBean() {
        return (AdminGeographicLayersSessionBean) getBean("admin$AdminGeographicLayersSessionBean");
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
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected InstitutionSessionBean getadmin$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
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
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
    }


 /**
  *
  * @return
  */
    public String  btnSearch_action() {

        try
        {
               long idSpecimen  = Long.parseLong(getTxSpecimen().getText().toString());
               //this.getlabel$LabelSessionBean().setSpecimenDTO(this.getlabel$LabelSessionBean().findById(idSpecimen));

        }
        catch( Exception e)
        {
             MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
             return null;
        }

         return null;
    }

    /**
     *
     * @return
     */
     public String  btnGenerationLabel_action() {

        try
        {
             /*String contenido = this.getlabel$LabelSessionBean().getSpecimenDTO().toString();
            this.getlabel$LabelSessionBean().getOriginalLabelDTO().setContents(contenido);
            this.getlabel$LabelSessionBean().getOriginalLabelDTO().setUserName(this.getAraSessionBean().getGlobalUserName());
            this.getlabel$LabelSessionBean().createOriginalLabel();   **/

            //this.getTxaLabelFormat().setValue(contenido);
        }
        catch( Exception e)
        {
             MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
             return null;
        }

         return null;

    }

    /**
     * @return the context
     */
    public FacesContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(FacesContext context) {
        this.context = context;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return myLocale;
    }

    /**
     * @param myLocale the myLocale to set
     */
    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    /**
     * @return the txSpecimen
     */
    public TextField getTxSpecimen() {
        return txSpecimen;
    }

    /**
     * @param txSpecimen the txSpecimen to set
     */
    public void setTxSpecimen(TextField txSpecimen) {
        this.txSpecimen = txSpecimen;
    }

    /**
     * @return the txaLabelFormat
     */
    public HtmlInputTextarea getTxaLabelFormat() {
        return txaLabelFormat;
    }

    /**
     * @param txaLabelFormat the txaLabelFormat to set
     */
    public void setTxaLabelFormat(HtmlInputTextarea txaLabelFormat) {
        this.txaLabelFormat = txaLabelFormat;
    }

}
