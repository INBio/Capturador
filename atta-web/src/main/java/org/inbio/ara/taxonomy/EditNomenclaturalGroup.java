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
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.taxonomy.RegionDTO;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditNomenclaturalGroup.java
 * @version Created on 23/11/2009, 06:07:19 PM
 * @author esmata
 */

public class EditNomenclaturalGroup extends AbstractPageBean {
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
    private TextArea txaDescription = new TextArea();
    private TextField txName = new TextField();
    private TextArea txaNotes = new TextArea();
    private DropDown ddCollection = new DropDown();
    private DropDown ddCommonName = new DropDown();
    private DropDown ddCertifier = new DropDown();
    private TextField txTemporality = new TextField();

    //Opciones de los distintos drop downs
    private SingleSelectOptionsList collectionDataEdit = new SingleSelectOptionsList();
    private SingleSelectOptionsList commonNameDataEdit = new SingleSelectOptionsList();
    private SingleSelectOptionsList certifierDataEdit = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditNomenclaturalGroup() {
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
            log("EditNomenclaturalGroup Initialization Failure", e);
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
        this.collectionDataEdit.setOptions(this.getCollectionsDropDownData());
        this.certifierDataEdit.setOptions(this.getCertifierDropDownData());
        this.commonNameDataEdit.setOptions(this.getCommonNameDropDownData());
        this.loadAddRemoveData();

        //Metodo se ejecuta solamente la primer ves para cargar datos
        if(this.gettaxonomy$NomenclaturalGroupSessionBean().isFirstTime()){
            this.loadAddRemoveSelectedData();
            this.loadTextFields();
            this.gettaxonomy$NomenclaturalGroupSessionBean().setFirstTime(false);
        }

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
     * Obtener los datos del drop down de collections
     */
    public Option[] getCollectionsDropDownData(){
        List<CollectionDTO> DTOList =
                this.gettaxonomy$NomenclaturalGroupSessionBean().
                getTaxonomyFacadeImpl().getAllCollections();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(CollectionDTO myDTO : DTOList){
            option = new Option(myDTO.getCollectionId(),
                    myDTO.getCollectionName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de certificadores
     */
    public Option[] getCertifierDropDownData(){
        List<PersonDTO> DTOList =
                this.gettaxonomy$NomenclaturalGroupSessionBean().
                getTaxonomyFacadeImpl().getAllCertifiers();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO myDTO : DTOList){
            option = new Option(myDTO.getPersonKey(),
                    myDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de CommonName
     */
    public Option[] getCommonNameDropDownData(){
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        option = new Option(new Character('y'),BundleHelper.getDefaultBundleValue
                ("yes",getMyLocale()));
        allOptions.add(option);
        option = new Option(new Character('n'),BundleHelper.getDefaultBundleValue
                ("no",getMyLocale()));
        allOptions.add(option);
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }
    
    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nuevo nomenclatural group
     */
    private void loadAddRemoveData() {
        NomenclaturalGroupSessionBean nsb =
                this.gettaxonomy$NomenclaturalGroupSessionBean();
        //Cargar datos del add remove de taxones
        if (nsb.getArTaxonsEdit().getAvailableOptions() == null ||
                nsb.getArTaxonsEdit().getAvailableOptions().length == 0) {

            List<TaxonDTO> taxonList = nsb.getTaxonomyFacadeImpl().getAllTaxon();
            List<Option> list = new ArrayList<Option>();

            for (TaxonDTO tax : taxonList) {
                list.add(new Option(tax.getTaxonKey(), tax.getDefaultName()));
            }
            nsb.getArTaxonsEdit().setAvailableOptions
                    (list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de regiones
        if (nsb.getArRegionsEdit().getAvailableOptions() == null ||
                nsb.getArRegionsEdit().getAvailableOptions().length == 0) {

            List<RegionDTO> regionsList =
                    nsb.getTaxonomyFacadeImpl().getAllRegions();
            List<Option> list = new ArrayList<Option>();

            for (RegionDTO reg : regionsList) {
                list.add(new Option(reg.getRegionId(), reg.getName()));
            }
            nsb.getArRegionsEdit().setAvailableOptions
                    (list.toArray(new Option[list.size()]));
        }
        //Setea los labels del componente add remove
        nsb.getArTaxonsEdit().setLbTitle(BundleHelper.getDefaultBundleValue
                ("menuModuleTaxa", this.getMyLocale()));
        nsb.getArTaxonsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        nsb.getArTaxonsEdit().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));

        nsb.getArRegionsEdit().setLbTitle(BundleHelper.getDefaultBundleValue
                ("regions", this.getMyLocale()));
        nsb.getArRegionsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        nsb.getArRegionsEdit().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de edit NG, carga los seleccionados segun el
     * currenNomenclaturalDTO para edicion
     */
    private void loadAddRemoveSelectedData(){
        NomenclaturalGroupSessionBean nsb =
                this.gettaxonomy$NomenclaturalGroupSessionBean();
        //Cargar datos del add remove de taxones (Seleccionados)
        List<TaxonDTO> taxonsList = nsb.getTaxonomyFacadeImpl().
                getTaxonsByNomenclaturalGroup
                (nsb.getCurrentNomenclaturalGroupDTO().getNomenclaturalGroupId());
        List<Long> list = new ArrayList<Long>();
        for (TaxonDTO coll : taxonsList) {
              list.add(coll.getTaxonKey());
         }
        nsb.getArTaxonsEdit().setSelectedOptions
                (list.toArray(new Long[list.size()]));

		//Cargar los datos del add remove de regiones (Seleccionados)
        List<RegionDTO> regionsList = nsb.getTaxonomyFacadeImpl().
                getRegionsByNomenclaturalGroup
                (nsb.getCurrentNomenclaturalGroupDTO().getNomenclaturalGroupId());
        List<Long> listP = new ArrayList<Long>();
        for (RegionDTO reg : regionsList) {
            listP.add(reg.getRegionId());
         }
        nsb.getArRegionsEdit().
                setSelectedOptions(listP.toArray(new Long[listP.size()]));
    }

    /**
     * Metodo encargado de cargar los textos para los textFields de edicion
     */
    private void loadTextFields(){
        NomenclaturalGroupSessionBean nsb =
                this.gettaxonomy$NomenclaturalGroupSessionBean();
       String name = nsb.getCurrentNomenclaturalGroupDTO().getName();
       String description = nsb.getCurrentNomenclaturalGroupDTO().getDescription();
       String notes = nsb.getCurrentNomenclaturalGroupDTO().getNotes();
       String temporality = nsb.getCurrentNomenclaturalGroupDTO().getTemporality();
       this.getTxName().setText(name);
       this.getTxTemporality().setText(temporality);
       this.getTxaDescription().setText(description);
       this.getTxaNotes().setText(notes);
    }

    /**
     * Metodo ejecutado por el boton de editar un grupo nomenclatural
     */
    public String btnEditNomenclaturalGroup_action() {
        NomenclaturalGroupSessionBean nsb =
                this.gettaxonomy$NomenclaturalGroupSessionBean();

        //Capturar los valores introducidos por el usuario
        String name = null, description = null,notes = null, temporality = null;
        name = (String)this.getTxName().getText();
        description = (String)this.getTxaDescription().getText();
        notes = (String)this.getTxaNotes().getText();
        temporality = (String)this.getTxTemporality().getText();

        //Asignar dichos valores al current DTO
        nsb.getCurrentNomenclaturalGroupDTO().setName(name);
        nsb.getCurrentNomenclaturalGroupDTO().setDescription(description);
        nsb.getCurrentNomenclaturalGroupDTO().setNotes(notes);
        nsb.getCurrentNomenclaturalGroupDTO().setTemporality(temporality);

        //Mandar a persistir el DTO
        try{
            //Llamar metodo que persiste el DTO
            this.gettaxonomy$NomenclaturalGroupSessionBean().
                    getTaxonomyFacadeImpl().updateNomenclaturalGroup
                    (nsb.getCurrentNomenclaturalGroupDTO(),
                    nsb.getArRegionsEdit().getSelectedOptions(),
                    nsb.getArTaxonsEdit().getSelectedOptions());
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar la lista del paginador
        nsb.getPagination().refreshList();

        //Notoficar al usuario
        MessageBean.setSuccessMessageFromBundle
                ("update_nomenclatural_succes", this.getMyLocale());

        return null;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
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
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
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
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
     * @return the txaDescription
     */
    public TextArea getTxaDescription() {
        return txaDescription;
    }

    /**
     * @param txaDescription the txaDescription to set
     */
    public void setTxaDescription(TextArea txaDescription) {
        this.txaDescription = txaDescription;
    }

    /**
     * @return the txName
     */
    public TextField getTxName() {
        return txName;
    }

    /**
     * @param txName the txName to set
     */
    public void setTxName(TextField txName) {
        this.txName = txName;
    }

    /**
     * @return the txaNotes
     */
    public TextArea getTxaNotes() {
        return txaNotes;
    }

    /**
     * @param txaNotes the txaNotes to set
     */
    public void setTxaNotes(TextArea txaNotes) {
        this.txaNotes = txaNotes;
    }

    /**
     * @return the ddCollection
     */
    public DropDown getDdCollection() {
        return ddCollection;
    }

    /**
     * @param ddCollection the ddCollection to set
     */
    public void setDdCollection(DropDown ddCollection) {
        this.ddCollection = ddCollection;
    }

    /**
     * @return the ddCommonName
     */
    public DropDown getDdCommonName() {
        return ddCommonName;
    }

    /**
     * @param ddCommonName the ddCommonName to set
     */
    public void setDdCommonName(DropDown ddCommonName) {
        this.ddCommonName = ddCommonName;
    }

    /**
     * @return the ddCertifier
     */
    public DropDown getDdCertifier() {
        return ddCertifier;
    }

    /**
     * @param ddCertifier the ddCertifier to set
     */
    public void setDdCertifier(DropDown ddCertifier) {
        this.ddCertifier = ddCertifier;
    }

    /**
     * @return the txTemporality
     */
    public TextField getTxTemporality() {
        return txTemporality;
    }

    /**
     * @param txTemporality the txTemporality to set
     */
    public void setTxTemporality(TextField txTemporality) {
        this.txTemporality = txTemporality;
    }

    /**
     * @return the collectionDataEdit
     */
    public SingleSelectOptionsList getCollectionDataEdit() {
        return collectionDataEdit;
    }

    /**
     * @param collectionDataEdit the collectionDataEdit to set
     */
    public void setCollectionDataEdit(SingleSelectOptionsList collectionDataEdit) {
        this.collectionDataEdit = collectionDataEdit;
    }

    /**
     * @return the commonNameDataEdit
     */
    public SingleSelectOptionsList getCommonNameDataEdit() {
        return commonNameDataEdit;
    }

    /**
     * @param commonNameDataEdit the commonNameDataEdit to set
     */
    public void setCommonNameDataEdit(SingleSelectOptionsList commonNameDataEdit) {
        this.commonNameDataEdit = commonNameDataEdit;
    }

    /**
     * @return the certifierDataEdit
     */
    public SingleSelectOptionsList getCertifierDataEdit() {
        return certifierDataEdit;
    }

    /**
     * @param certifierDataEdit the certifierDataEdit to set
     */
    public void setCertifierDataEdit(SingleSelectOptionsList certifierDataEdit) {
        this.certifierDataEdit = certifierDataEdit;
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
    protected TaxonomySessionBean gettaxonomy$TaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
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
    protected AdminGeographicLayersSessionBean getadmin$AdminGeographicLayersSessionBean() {
        return (AdminGeographicLayersSessionBean) getBean("admin$AdminGeographicLayersSessionBean");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }    
}

