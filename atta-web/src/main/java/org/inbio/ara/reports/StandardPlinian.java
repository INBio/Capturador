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

package org.inbio.ara.reports;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.gis.MapController;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.util.QueryNode;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version StandardPlinian.java
 * @version Created on 05/11/2009, 11:19:12 AM
 * @author esmata
 */

public class StandardPlinian extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

	//Contexto utilizado para obtener el current locale
	private FacesContext context;
	private Locale myLocale;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public StandardPlinian() {
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
            log("StandardPlinian Initialization Failure", e);
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
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
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
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
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
    protected ProfileSessionBean getadmin$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$ProfileSessionBean");
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
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
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
    protected MapController getgis$MapController() {
        return (MapController) getBean("gis$MapController");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SnapshotSessionBean getSnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * Create snapshot plinian core with all the available information
     * @return
     */
    public String bshareAll_action() {
        //Setear la lista de elementos y la lista de consulta
        getSnapshotSessionBean().setQueryList(new LinkedList<QueryNode>());
        //Con todos los elementos del plinian core
        getSnapshotSessionBean().setElementList(getAllElementsPlic());

        //Crear archivo temporal para guardar el dump de plic_snapshot
        File currentFile = null;
        try {
            // Create temp file.
            currentFile = File.createTempFile("plicSnapshot", ".csv");
            // Delete temp file when program exits.
            currentFile.deleteOnExit();
            currentFile.setWritable(true);
        } catch (Exception e) {}

        //Crear el snapshot
        boolean result1 = getSnapshotSessionBean().createPlicSnapshot(this.getAraSessionBean().getGlobalDataBaseSchema());
        boolean result2 = getSnapshotSessionBean().getReportsFacade().
                exportToPlic(currentFile, this.getAraSessionBean().getGlobalDataBaseSchema(),
                this.getAraSessionBean().getGlobalDataSource());
        if (result1 && result2) {
            //Set to null the query  list (filters)
            getSnapshotSessionBean().setQueryList(new LinkedList<QueryNode>());
            //Descargar el archivo
            downloadFile(currentFile);
        } else {
            MessageBean.setErrorMessageFromBundle("plic_snapshot_error",
                    this.getMyLocale());
        }
        return null;
    }

     //Metodo que trae todos los elementos plinian core en una lista de strings
    public LinkedList<String> getAllElementsPlic(){
        return getSnapshotSessionBean().getReportsFacade().getAllElementsPlic();
    }

    private void downloadFile(File f){
            //Descargar el archivo exportado
            HttpServletResponse response = (HttpServletResponse)
                    getExternalContext().getResponse();
            response.setContentType("text/csv");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + f.getPath() + "\"");
            byte[] buf = new byte[1024];
            try{
              long length = f.length();
              BufferedInputStream in = new BufferedInputStream
                      (new FileInputStream(f));
              ServletOutputStream out = response.getOutputStream();
              response.setContentLength((int)length);
              while ((in != null) && ((length = in.read(buf)) != -1)) {
                out.write(buf, 0, (int)length);
              }
              in.close();
              out.close();
            }catch (Exception exc){
                exc.printStackTrace();
            }
    }

    /**
     * Metodo encargado de recargar el snapshot row del plinian core
     * @return
     */
    public String buttonReload_action() {
        //Individuales, observaciones, agrupados unitaxon
        boolean result = this.getSnapshotSessionBean().
                getReportsFacade().reloadPlinianCoreTable(this.getAraSessionBean().getGlobalDataBaseSchema());
        if(result){
            MessageBean.setSuccessMessageFromBundle("plic_success",
                    this.getMyLocale());
            return null;
        }
        else{
            MessageBean.setErrorMessageFromBundle("error",
                    this.getMyLocale());
            return null;
        }
    }
}

