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

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.GregorianCalendar;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.persistence.gathering.CollectionProtocolValuesEntity;
import org.inbio.ara.persistence.gathering.ProtocolAtributeEntity;
import org.inbio.ara.persistence.person.ProfileEntity;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListGathering.java
 * @version Created on 17/08/2009, 05:15:14 PM
 * @author esmata
 */

public class ListGathering extends AbstractPageBean {
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
    //Componentes graficos utilizados para las busquedas de especimenes
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private TextField txGatheringId = new TextField();
    private TextField txResponsible = new TextField();
    private TextField txCollector = new TextField();
    private TextField txLocality = new TextField();
    private TextField txLatitudeShort = new TextField();
    private TextField txLongitudeShort = new TextField();
    private HtmlInputText txSearch = new HtmlInputText(); //Input text de busqueda simple
    private TextField txRadio = new TextField();
    private DropDown ddCountry = new DropDown();
    private DropDown ddProvince = new DropDown();
    private HtmlCommandButton btnSeach = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton(); //Boton busqueda avanzada
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();
    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTableGathering = new HtmlDataTable();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    //En esta variable se setearan los datos del drop down de psises
    private SingleSelectOptionsList countryData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListGathering() {
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
            log("ListGathering Initialization Failure", e);
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
        GatheringSessionBean gsb = getinventory$GatheringSessionBean();
        //------------------------------ Control de GUI -------------------------------
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(gsb.isAdvancedSearch()){
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
            //Carga los datos de los dropdowns de pais y provincia
            this.SetCountryDropDownData(); //Cargar valores del DD de paises
            this.SetProvincesDropDownData();//Cargar valores del DD de provincias
        }
        //-------------------------- Control de Paginador ------------------------------
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (gsb.getPagination()==null) {
            gsb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            gsb.getPagination().refreshList();
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
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvGatheringSearch_action() {
        boolean advanced = getinventory$GatheringSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getinventory$GatheringSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSeach().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getinventory$GatheringSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSeach().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));
            //Reestablecer los valores por defecto de los drop downs
            Long auxDefault = new Long(-1);
            this.getinventory$GatheringSessionBean().setSelectedCountry(auxDefault);
            this.getinventory$GatheringSessionBean().setSelectedProvince(auxDefault);
            //Reestablecer los valores por defecto de los textfields
            this.getTxGatheringId().setText(null);
            this.getTxResponsible().setText(null);
            this.getTxLocality().setText(null);
            this.getTxLatitudeShort().setText(null);
            this.getTxLongitudeShort().setText(null);
            this.getTxRadio().setText(null);
            this.getInitial_date().setText(null);
            this.getFinal_date().setText(null);
        }
        return null;
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnGatheringSearch_action() {
        Long collectionId = getAraSessionBean().getGlobalCollectionId();
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
            userInput = this.getTxSearch().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getinventory$GatheringSessionBean().setQueryModeSimple(false);
            this.getinventory$GatheringSessionBean().setQueryMode(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getinventory$GatheringSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getinventory$GatheringSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getinventory$GatheringSessionBean().setQueryMode(false);
        }
        this.getinventory$GatheringSessionBean().getPagination().firstResults();
        return null;
    }

    /**
     * Metodo ejecutado por el boton de proceder con la busqueda avanzada
     * este boton es el que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnAdvSearchGO_action() {
        Long collectionId = getAraSessionBean().getGlobalCollectionId();
        //Capturar el dato de gatheringId
        Long gatheringId = null;
        String gId = (String)this.getTxGatheringId().getText();
        if(gId!=null){
            gatheringId = Long.parseLong(gId);
        }

        //Crear el DTO para la consulta
        GatheringObservationDTO consulta = new GatheringObservationDTO();
        consulta.setResponsibleName((String)this.getTxResponsible().getText());
        
        List<PersonDTO> collectorsDTO = 
                this.getinventory$GatheringSessionBean().getPersonByFilterProfile
                ( ProfileEntity.RECOLECTOR.getId(),
                (String)this.getTxCollector().getText());
        consulta.setColectorsList(collectorsDTO);
        
        consulta.setLocalityDescription((String)this.getTxLocality().getText());
        consulta.setGatheringObservationId(gatheringId);
        //----------------------------------------------------------------------
        Double latitude_short = null;
        Double longitude_short = null;
        Integer radio = null;
        try{
            latitude_short = Double.valueOf(this.getTxLatitudeShort().getText().
                    toString());
            longitude_short = Double.valueOf(this.getTxLongitudeShort().getText().
                    toString());
            radio = Integer.valueOf(this.getTxRadio().getText().toString());
        }
        catch(Exception e){}
        if(latitude_short!=null&&longitude_short!=null&&radio!=null){
            consulta.setLatitude(latitude_short);
            consulta.setLongitude(longitude_short);
            consulta.setRadio(radio);
        }
        //En caso de que alguno de los tres sea nulo
        if((latitude_short==null||longitude_short==null||radio==null)&&(latitude_short!=null||longitude_short!=null||radio!=null)){
            MessageBean.setErrorMessageFromBundle("error_coordinates_search", this.getMyLocale());
        }
        //----------------------------------------------------------------------
        consulta.setCountryId(this.getinventory$GatheringSessionBean().
                getSelectedCountry());
        consulta.setProvinceId(this.getinventory$GatheringSessionBean().
                getSelectedProvince());
        GregorianCalendar iniCal = new GregorianCalendar();
        GregorianCalendar finCal = new GregorianCalendar();
        Date iniDate = this.getInitial_date().getSelectedDate();
        Date finDate = this.getFinal_date().getSelectedDate();
        if(iniDate!=null){
            iniCal.setTime(iniDate);
            consulta.setInitialDateTime(iniCal);
        }
        if(finDate!=null){
            finCal.setTime(finDate);
            consulta.setFinalDateTime(finCal);
        }
        //Setear el GatheringDTO del SessionBean utilizado para realizar la consulta
        this.getinventory$GatheringSessionBean().setQueryGatheringDTO(consulta);
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getinventory$GatheringSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getinventory$GatheringSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getinventory$GatheringSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");
        return null;
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public void SetCountryDropDownData(){
        List<GeographicLayerDTO> geoDTOList =
                this.getinventory$GatheringSessionBean().SetCountryDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(GeographicLayerDTO geoDTO : geoDTOList){
            option = new Option(geoDTO.getGeographicalLayerKey(), geoDTO.getName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getCountryData().setOptions(allOptions.toArray(allOptionsInArray));
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public void SetProvincesDropDownData(){
        List<GeographicLayerDTO> geoDTOList =
                this.getinventory$GatheringSessionBean().SetProvincesDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        if(geoDTOList!=null){
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                    ("drop_down_default",getMyLocale())+" --");
            allOptions.add(option);
            //Crear todas las opciones del drop down
            for(GeographicLayerDTO geoDTO : geoDTOList){
                option = new Option(geoDTO.getGeographicalLayerKey(), geoDTO.getName());
                allOptions.add(option);
            }
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            this.getProvincesData().setOptions(allOptions.toArray(allOptionsInArray));
        }
        else{
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                    ("drop_down_default",getMyLocale())+" --");
            allOptions.add(option);
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            this.getProvincesData().setOptions(allOptions.toArray(allOptionsInArray));
        }
    }

    /**
     * Metodo ejecutado por los botones de editar gathering
     * @return
     */
    public String btnGatheringEdit() {

        int n = this.getDataTableGathering().getRowCount();
        ArrayList<GatheringObservationDTO> selectedGathering = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableGathering().setRowIndex(i);
            GatheringObservationDTO aux = (GatheringObservationDTO) this.
                    getDataTableGathering().getRowData();
            if (aux.isSelected()) {
                selectedGathering.add(aux);
            }
        }
        if(selectedGathering == null || selectedGathering.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedGathering.size() == 1){ //En caso de que solo se seleccione un elemento

            //Reestablecer el valor default del DTO y de los add remove components
            this.getinventory$GatheringSessionBean().setCurrentGatheringDTO
                    (new GatheringObservationDTO());
            this.getinventory$GatheringSessionBean().setArCollectionsEdit
                    (new AddRemoveList());
            this.getinventory$GatheringSessionBean().setArCollectorsEdit
                    (new AddRemoveList());
            this.getinventory$GatheringSessionBean().setArProjectsEdit
                    (new AddRemoveList());
            /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
            seleccionados de los AddRemove*/
            this.getinventory$GatheringSessionBean().setFirstTime(true);
            //Dependiendo del valor la variable UseDetail, asi se va a renderizar en el editGathering
            Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
            boolean useDetail = this.getinventory$GatheringSessionBean().
                    matchCollectionProtocol(currentCollection,
                    ProtocolAtributeEntity.USE_GATHERING_DETAIL.getId(),
                    CollectionProtocolValuesEntity.TRUE_VALUE.getValue());
            this.getinventory$GatheringSessionBean().setUseDetail(useDetail);
            //Setear en el bean de session los datos correspondientes a la recoleccion seleccionada
            GatheringObservationDTO myDTO = selectedGathering.get(0);
            this.getinventory$GatheringSessionBean().setCurrentGatheringDTO(myDTO);
            //Llamada al jsp encargado de la edicion de recolecciones
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por los botones de eliminar gathering
     * @return
     */
    public String btnGatheringDelete() {
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();

        int n = this.getDataTableGathering().getRowCount();
        ArrayList<GatheringObservationDTO> selectedGathering = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableGathering().setRowIndex(i);
            GatheringObservationDTO aux = (GatheringObservationDTO) this.
                    getDataTableGathering().getRowData();
            if (aux.isSelected()) {
                selectedGathering.add(aux);
            }
        }
        if(selectedGathering == null || selectedGathering.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected",
                    this.getMyLocale());
            return null;
        }
        else if(selectedGathering.size() == 1){ //En caso de que solo se seleccione un elemento
            
            //Obtener el DTO seleccionado
            GatheringObservationDTO myDTO = selectedGathering.get(0);
            //Si no se puede borrar, debido a specimenes asociados
            if(!isDeletable(myDTO.getGatheringObservationId())){
                MessageBean.setErrorMessageFromBundle
                        ("imposible_to_delete", this.getMyLocale());
                return null;
            }
            //Si no se puede borrar, debido a detalles de recoleccion asociados
            if(!isDeletableDetails(myDTO.getGatheringObservationId())){
                MessageBean.setErrorMessageFromBundle
                        ("imposible_to_delete", this.getMyLocale());
                return null;
            }
            /*** else, procedemos a borrar la recoleccion ***/
            //Borrar de la tabla CollectorObserver,GatheringObservationCollection,GatheringObservationProject
            gsb.getInventoryFacade().deleteAsociatedListByGatheringId
                    (myDTO.getGatheringObservationId());
            //Borrar de la tabla gatherinfObservation
            gsb.getInventoryFacade().deleteGatheringById(myDTO.getGatheringObservationId());

            //Refrescar el dataprovider del paginador
            gsb.getPagination().refreshList();
            
            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * True en caso de que la recoleccion se pueda eliminar
     * @return
     */
    private boolean isDeletable(Long gId){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        int specimensByGathering = gsb.getInventoryFacade().findSpecimensByGathObsId(gId);
        if(specimensByGathering==0){
            return true;
        }
        else
            return false;
    }

    /**
     * True en caso de que la recoleccion se pueda eliminar
     * @return
     */
    private boolean isDeletableDetails(Long gId){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        int specimensByGathering = gsb.getInventoryFacade().findDetailsByGathObsId(gId);
        if(specimensByGathering==0){
            return true;
        }
        else
            return false;
    }

    /**
     * Metodo ejecutado por el boton de new gathering
     * @return
     */
    public String btn_new_action() {
        //Reestablecer el valor default del DTO y de los add remove components
        this.getinventory$GatheringSessionBean().setCurrentGatheringDTO
                (new GatheringObservationDTO());
        this.getinventory$GatheringSessionBean().setArCollectionsEdit
                (new AddRemoveList());
        this.getinventory$GatheringSessionBean().setArCollectorsEdit
                (new AddRemoveList());
        this.getinventory$GatheringSessionBean().setArProjectsEdit
                (new AddRemoveList());
        this.getinventory$GatheringSessionBean().setArCollections
                (new AddRemoveList());
        this.getinventory$GatheringSessionBean().setArCollectors
                (new AddRemoveList());
        this.getinventory$GatheringSessionBean().setArProjects
                (new AddRemoveList());
        //Llamada al jsp encargado de la creacion de recolecciones

        


        return "new";
    }



    protected PersonAutoCompleteSessionBean getPersonAutoCompleteSessionBean() {
        return (PersonAutoCompleteSessionBean) getBean("inventory$PersonAutoCompleteBean");
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
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getinventory$GatheringSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the gridpAdvancedSearch
     */
    public HtmlPanelGrid getGridpAdvancedSearch() {
        return gridpAdvancedSearch;
    }

    /**
     * @param gridpAdvancedSearch the gridpAdvancedSearch to set
     */
    public void setGridpAdvancedSearch(HtmlPanelGrid gridpAdvancedSearch) {
        this.gridpAdvancedSearch = gridpAdvancedSearch;
    }

    /**
     * @return the txGatheringId
     */
    public TextField getTxGatheringId() {
        return txGatheringId;
    }

    /**
     * @param txGatheringId the txGatheringId to set
     */
    public void setTxGatheringId(TextField txGatheringId) {
        this.txGatheringId = txGatheringId;
    }

    /**
     * @return the txResponsible
     */
    public TextField getTxResponsible() {
        return txResponsible;
    }

    /**
     * @param txResponsible the txResponsible to set
     */
    public void setTxResponsible(TextField txResponsible) {
        this.txResponsible = txResponsible;
    }

    /**
     * @return the ddCountry
     */
    public DropDown getDdCountry() {
        return ddCountry;
    }

    /**
     * @param ddCountry the ddCountry to set
     */
    public void setDdCountry(DropDown ddCountry) {
        this.ddCountry = ddCountry;
    }

    /**
     * @return the countryData
     */
    public SingleSelectOptionsList getCountryData() {
        return countryData;
    }

    /**
     * @param countryData the countryData to set
     */
    public void setCountryData(SingleSelectOptionsList countryData) {
        this.countryData = countryData;
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public String setProvinces(){
        this.provincesData = new SingleSelectOptionsList();
        this.SetProvincesDropDownData();
        return null;
    }

    /**
     * @return the ddProvince
     */
    public DropDown getDdProvince() {
        return ddProvince;
    }

    /**
     * @param ddProvince the ddProvince to set
     */
    public void setDdProvince(DropDown ddProvince) {
        this.ddProvince = ddProvince;
    }

    /**
     * @return the provincesData
     */
    public SingleSelectOptionsList getProvincesData() {
        return provincesData;
    }

    /**
     * @param provincesData the provincesData to set
     */
    public void setProvincesData(SingleSelectOptionsList provincesData) {
        this.provincesData = provincesData;
    }

    /**
     * @return the txLocality
     */
    public TextField getTxLocality() {
        return txLocality;
    }

    /**
     * @param txLocality the txLocality to set
     */
    public void setTxLocality(TextField txLocality) {
        this.txLocality = txLocality;
    }

    /**
     * @return the txLatitudeShort
     */
    public TextField getTxLatitudeShort() {
        return txLatitudeShort;
    }

    /**
     * @param txLatitudeShort the txLatitudeShort to set
     */
    public void setTxLatitudeShort(TextField txLatitudeShort) {
        this.txLatitudeShort = txLatitudeShort;
    }

    /**
     * @return the txLongitudeShort
     */
    public TextField getTxLongitudeShort() {
        return txLongitudeShort;
    }

    /**
     * @param txLongitudeShort the txLongitudeShort to set
     */
    public void setTxLongitudeShort(TextField txLongitudeShort) {
        this.txLongitudeShort = txLongitudeShort;
    }

    /**
     * @return the txRadio
     */
    public TextField getTxRadio() {
        return txRadio;
    }

    /**
     * @param txRadio the txRadio to set
     */
    public void setTxRadio(TextField txRadio) {
        this.txRadio = txRadio;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the txSearch
     */
    public HtmlInputText getTxSearch() {
        return txSearch;
    }

    /**
     * @param txSearch the txSearch to set
     */
    public void setTxSearch(HtmlInputText txSearch) {
        this.txSearch = txSearch;
    }

    /**
     * @return the btnSeach
     */
    public HtmlCommandButton getBtnSeach() {
        return btnSeach;
    }

    /**
     * @param btnSeach the btnSeach to set
     */
    public void setBtnSeach(HtmlCommandButton btnSeach) {
        this.btnSeach = btnSeach;
    }

    /**
     * @return the btnAdvSeach
     */
    public HtmlCommandButton getBtnAdvSeach() {
        return btnAdvSeach;
    }

    /**
     * @param btnAdvSeach the btnAdvSeach to set
     */
    public void setBtnAdvSeach(HtmlCommandButton btnAdvSeach) {
        this.btnAdvSeach = btnAdvSeach;
    }

    /**
     * @return the initial_date
     */
    public Calendar getInitial_date() {
        return initial_date;
    }

    /**
     * @param initial_date the initial_date to set
     */
    public void setInitial_date(Calendar initial_date) {
        this.initial_date = initial_date;
    }

    /**
     * @return the final_date
     */
    public Calendar getFinal_date() {
        return final_date;
    }

    /**
     * @param final_date the final_date to set
     */
    public void setFinal_date(Calendar final_date) {
        this.final_date = final_date;
    }

    /**
     * @return the dataTableGathering
     */
    public HtmlDataTable getDataTableGathering() {
        return dataTableGathering;
    }

    /**
     * @param dataTableGathering the dataTableGathering to set
     */
    public void setDataTableGathering(HtmlDataTable dataTableGathering) {
        this.dataTableGathering = dataTableGathering;
    }

    /**
     * @return the txCollector
     */
    public TextField getTxCollector() {
        return txCollector;
    }

    /**
     * @param txCollector the txCollector to set
     */
    public void setTxCollector(TextField txCollector) {
        this.txCollector = txCollector;
    }
}

