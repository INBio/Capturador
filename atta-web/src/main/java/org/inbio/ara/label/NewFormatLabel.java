/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.label;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlInputTextarea;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewFormatLabel.java
 * @version Created on 04/03/2010, 03:03:58 PM
 * @author paulacorrales
 */

public class NewFormatLabel extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }


    // area de
    private HtmlInputTextarea abstractText = new HtmlInputTextarea();
    //Objeto AddRemoveList para manejar los valores del tab de colectores (ventana new gathering)
   

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewFormatLabel() {
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
            log("NewFormatLabel Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here


        this.getAbstractText().setValue("que pasa");
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
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
    }

    /**
     *
     * @return
     */
    public String btnSaveFormatLabel_action(){

         System.out.print("entra");
        /** this.getlabel$LabelSessionBean().getOriginalLabelDTO().setUserName(this.getAraSessionBean().getGlobalUserName());
         this.getlabel$LabelSessionBean().getOriginalLabelDTO().setContents(this.getAbstractText().getValue().toString());
          System.out.print("---------------------");
          System.out.print(this.getAbstractText().getValue());
          System.out.print(this.getlabel$LabelSessionBean().getOriginalLabelDTO().getContents());
          System.out.print("---------------------");  **/

         return null;
     }

    
      public String btnCancelFormatLabel_action(){

         System.out.print("entra");
         /**this.getlabel$LabelSessionBean().getOriginalLabelDTO().setUserName(this.getAraSessionBean().getGlobalUserName());
         this.getlabel$LabelSessionBean().getOriginalLabelDTO().setContents(this.getAbstractText().getValue().toString());
          System.out.print("---------------------");
          System.out.print(this.getAbstractText().getValue());
          System.out.print(this.getlabel$LabelSessionBean().getOriginalLabelDTO().getContents());
          System.out.print("---------------------");  */

         return null;
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
    protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
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
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva recoleccion, carga los disponibles
     */
    /*private void loadAddRemoveData(){
        
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();

        //Cargar datos del add remove de colecciones (Disponibles)
        if (gsb.getArCollectionsEdit().getAvailableOptions() == null ||
                gsb.getArCollectionsEdit().getAvailableOptions().length == 0) {

            List<CollectionDTO> collectionsList = gsb.SetCollectionDropDownData();
            List<Option> list = new ArrayList<Option>();
            for (CollectionDTO coll : collectionsList) {
                list.add(new Option(coll.getCollectionId(), coll.getCollectionName()));
            }
            gsb.getArCollectionsEdit().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de colectores (Disponibles)
        if (gsb.getArCollectorsEdit().getAvailableOptions() == null ||
                gsb.getArCollectorsEdit().getAvailableOptions().length == 0) {

            List<PersonDTO> collectorsList = gsb.SetColectorsDropDownData();
            List<Option> list = new ArrayList<Option>();
            for (PersonDTO per : collectorsList) {
                list.add(new Option(per.getPersonKey(), per.getNaturalLongName()));
            }
            gsb.getArCollectorsEdit().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de proyectos (Disponibles)
        if (gsb.getArProjectsEdit().getAvailableOptions() == null ||
                gsb.getArProjectsEdit().getAvailableOptions().length == 0) {

            List<ProjectDTO> proList = gsb.SetProjectsDropDownData();
            List<Option> list = new ArrayList<Option>();
            for (ProjectDTO pro : proList) {
                list.add(new Option(pro.getProjectId(), pro.getDescription()));
            }
            gsb.getArProjectsEdit().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Setea los labels del componente add remove
        gsb.getArCollectionsEdit().setLbTitle(BundleHelper.getDefaultBundleValue("associated_collections", this.getMyLocale()));
        gsb.getArCollectionsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArCollectionsEdit().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

        gsb.getArCollectorsEdit().setLbTitle(BundleHelper.getDefaultBundleValue("collectors_list", this.getMyLocale()));
        gsb.getArCollectorsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArCollectorsEdit().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

        gsb.getArProjectsEdit().setLbTitle(BundleHelper.getDefaultBundleValue("projects_list", this.getMyLocale()));
        gsb.getArProjectsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArProjectsEdit().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva recoleccion, carga los seleccionados segun el
     * currenGatheringObservationDTO para edicion
     
    private void loadAddRemoveSelectedData(){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        //Cargar datos del add remove de colecciones (Seleccionados)
        List<CollectionDTO> collectionsList = gsb.getCurrentGatheringDTO().getCollectionsList();
        List<Long> list = new ArrayList<Long>();
        for (CollectionDTO coll : collectionsList) {
              list.add(coll.getCollectionId());
         }
        gsb.getArCollectionsEdit().setSelectedOptions(list.toArray(new Long[list.size()]));

		//Cargar los datos del add remove de colectores (Seleccionados)
        List<PersonDTO> collectorsList = gsb.getCurrentGatheringDTO().getColectorsList();
        List<Long> listP = new ArrayList<Long>();
        for (PersonDTO per : collectorsList) {
            listP.add(per.getPersonKey());
         }
        gsb.getArCollectorsEdit().setSelectedOptions(listP.toArray(new Long[listP.size()]));

		//Cargar los datos del add remove de proyectos (Seleccionados)
        List<ProjectDTO> proList = gsb.getCurrentGatheringDTO().getProjectsList();
        List<Long> listProy = new ArrayList<Long>();
        for (ProjectDTO pro : proList) {
            listProy.add(pro.getProjectId());
        }
        gsb.getArProjectsEdit().setSelectedOptions(listProy.toArray(new Long[listProy.size()]));
    }*/

    /**
     * Metodo encargado de cargar los textos para los textFields de edicion
     */
}

