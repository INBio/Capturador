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

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.util.BundleHelper;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListSpecimen.java
 * @version Created on 02/07/2009, 05:14:41 PM
 * @author esmata
 */
public class ListSpecimen extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Bindings para la tabla que se utiliza para listar los especimenes
    private Table specimenTable = new Table();
    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;
    //Componentes graficos utilizados para las busquedas de especimenes
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private HtmlInputText txSearch = new HtmlInputText();
    private HtmlCommandButton btnSeach = new HtmlCommandButton();
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton();
    private TextField txCatalogNumber = new TextField();
    private DropDown ddInstitutionCode = new DropDown();
    private TextField txTaxonName = new TextField();
    private TextField txLocality = new TextField();
    private TextField txLatitudeShort = new TextField();
    private TextField txLongitudeShort = new TextField();
    private TextField txRadio = new TextField();
    private DropDown ddCountry = new DropDown();
    private DropDown ddProvince = new DropDown();
    private TextField txResponsible = new TextField();
    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTableSpecimens = new HtmlDataTable();
    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    //En esta variable se setearan los datos del drop down de instituciones
    private SingleSelectOptionsList institutionsData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de paises
    private SingleSelectOptionsList countriesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListSpecimen() {
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
            log("ListSpecimen Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
        System.out.println("-- HIZO PRERENDER --");
        SpecimenSessionBean ssb = getinventory$SpecimenSessionBean();
        //------------------------------ Control de GUI -------------------------------
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(ssb.isAdvancedSearch()){
            this.gridpAdvancedSearch.setRendered(true);//Muestra el panel de busqueda avanzada
            this.SetInstitutionDropDownData(); //Cargar valores del DD de instituciones
            this.SetCountryDropDownData(); //Cargar valores del DD de paises
            this.SetProvincesDropDownData();//Cargar valores del DD de proviencias            
        }
        //-------------------------- Control de Paginador ------------------------------
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (ssb.getPagination()==null) {
            ssb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
        {
            System.out.println("Inicio el refresh");
            if(ssb.getPagination().isReloadVariables())
            {
                ssb.getPagination().refreshList();
            }
            
                
                        
            System.out.println("Finalizo el refresh");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }


    /**
     * Action del boton de editar espécimen
     * @return
     */
    public String btn_edit_action() {
        System.out.println("--- LIST SPECIMEN: BTN EDIT ACTION ---");
        this.getinventory$SpecimenSessionBean().setAdvancedSearch(false); //Ojo: esto es para que cuando el usuario presione volver, el boton de busqueda avanzada funcione correctamente
        int n = this.getDataTableSpecimens().getRowCount();        
        ArrayList<SpecimenDTO> selectedSpecimens = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSpecimens().setRowIndex(i);
            SpecimenDTO thisSpecimen = (SpecimenDTO) this.getDataTableSpecimens().getRowData();
            System.out.println("dateTime = "+thisSpecimen.getDateTime());
            if (thisSpecimen.isSelected()) {
                selectedSpecimens.add(thisSpecimen);
            }
        }
        if(selectedSpecimens == null || selectedSpecimens.size() == 0){ //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedSpecimens.size() == 1){ //En caso de que solo se seleccione un elemento
            this.getinventory$SpecimenSessionBean().setCurrentSpecimenDTO(selectedSpecimens.get(0));
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
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
     * Accion del boton de buscar que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnBuscar_action() {
        //Crear el specimenDTO para la consulta
        SpecimenDTO consulta = new SpecimenDTO();
        String catalog = (String) this.getTxCatalogNumber().getText();
        String taxon = (String) this.getTxTaxonName().getText();
        String locality = (String) this.getTxLocality().getText();
        String responsible = (String) this.getTxResponsible().getText();
        if(catalog!=null)
            consulta.setCatalogNumber(catalog);
        if(taxon!=null)
            consulta.setTaxonName(taxon);
        if(locality!=null)
            consulta.setLocalityDescription(locality);
        if(responsible!=null){
            consulta.setResponsibleName(responsible);
        }
        Double latitude_short = null;
        Double longitude_short = null;
        Integer radio = null;
        try{
            latitude_short = Double.valueOf(this.getTxLatitudeShort().getText().toString());
            longitude_short = Double.valueOf(this.getTxLongitudeShort().getText().toString());
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
        Object institution = this.getDdInstitutionCode().getSelected();
        Object country = this.getDdCountry().getSelected();
        Object province = this.getDdProvince().getSelected();
        if(institution!=null){
            consulta.setInstitutionId((Long)institution);
        }
        if(country!=null){
            consulta.setCountryId((Long)country);
        }
        if(province!=null){
            consulta.setProvinceId((Long)province);
        }
        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        consulta.setCollectionId(currentCollection);

        //Setear el SpecimenDTO del SessionBean utilizado para realizar la consulta
        this.getinventory$SpecimenSessionBean().setQuerySpecimenDTO(consulta);
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getinventory$SpecimenSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getinventory$SpecimenSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getinventory$SpecimenSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");
        return null;
    }

    /**
     * Accion del boton de busqueda simple
     * @return
     */
    public String btnSpecimenSearch_action() {
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
            userInput = this.getTxSearch().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getinventory$SpecimenSessionBean().setQueryModeSimple(false);
            this.getinventory$SpecimenSessionBean().setQueryMode(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getinventory$SpecimenSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getinventory$SpecimenSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getinventory$SpecimenSessionBean().setQueryMode(false);
        }
        this.getinventory$SpecimenSessionBean().getPagination().firstResults(); 
        return null;
    }

    /**
     * Accion del boton que habilita y deshabilita el panel de busqueda avanzada
     * @return
     */
    public String btnAdvSpecimenSearc_action() {
        boolean advanced = getinventory$SpecimenSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getinventory$SpecimenSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSeach().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getinventory$SpecimenSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSeach().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen",getMyLocale()));
            //Reestablecer los valores por defecto de los drop downs
            this.getinventory$SpecimenSessionBean().setSelectedInstitution(null);
            this.getinventory$SpecimenSessionBean().setSelectedCountry(null);
            this.getinventory$SpecimenSessionBean().setSelectedProvince(null);
            //Reestablecer los valores por defecto de los textfields
            this.getTxCatalogNumber().setText(null);
            this.getTxLatitudeShort().setText(null);
            this.getTxLongitudeShort().setText(null);
            this.getTxRadio().setText(null);
            this.getTxLocality().setText(null);
            this.getTxResponsible().setText(null);
            this.getTxTaxonName().setText(null);
        }
        return null;
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public void SetInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.getinventory$SpecimenSessionBean().SetInstitutionDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO instDTO : instDTOList){
            option = new Option(instDTO.getInstitutionId(), instDTO.getInstitutionName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getInstitutionsData().setOptions(allOptions.toArray(allOptionsInArray));
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public void SetProvincesDropDownData(){
        List<GeographicLayerDTO> geoDTOList = this.getinventory$SpecimenSessionBean().SetProvincesDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        
        if(geoDTOList!=null){
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
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
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
            allOptions.add(option);
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            this.getProvincesData().setOptions(allOptions.toArray(allOptionsInArray));
        }
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public void SetCountryDropDownData(){
        List<GeographicLayerDTO> geoDTOList = this.getinventory$SpecimenSessionBean().SetCountryDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(GeographicLayerDTO geoDTO : geoDTOList){
            option = new Option(geoDTO.getGeographicalLayerKey(), geoDTO.getName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getCountriesData().setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * @return the specimenTable
     */
    public Table getSpecimenTable() {
        return specimenTable;
    }

    /**
     * @param specimenTable the specimenTable to set
     */
    public void setSpecimenTable(Table specimenTable) {
        this.specimenTable = specimenTable;
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
     * @return the txCatalogNumber
     */
    public TextField getTxCatalogNumber() {
        return txCatalogNumber;
    }

    /**
     * @param txCatalogNumber the txCatalogNumber to set
     */
    public void setTxCatalogNumber(TextField txCatalogNumber) {
        this.txCatalogNumber = txCatalogNumber;
    }

    /**
     * @return the ddInstitutionCode
     */
    public DropDown getDdInstitutionCode() {
        return ddInstitutionCode;
    }

    /**
     * @param ddInstitutionCode the ddInstitutionCode to set
     */
    public void setDdInstitutionCode(DropDown ddInstitutionCode) {
        this.ddInstitutionCode = ddInstitutionCode;
    }

    /**
     * @return the txTaxonName
     */
    public TextField getTxTaxonName() {
        return txTaxonName;
    }

    /**
     * @param txTaxonName the txTaxonName to set
     */
    public void setTxTaxonName(TextField txTaxonName) {
        this.txTaxonName = txTaxonName;
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
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
     * @return the dataTableSpecimens
     */
    public HtmlDataTable getDataTableSpecimens() {
        return dataTableSpecimens;
    }

    /**
     * @param dataTableSpecimens the dataTableSpecimens to set
     */
    public void setDataTableSpecimens(HtmlDataTable dataTableSpecimens) {
        this.dataTableSpecimens = dataTableSpecimens;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getinventory$SpecimenSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the institutionsData
     */
    public SingleSelectOptionsList getInstitutionsData() {
        return institutionsData;
    }

    /**
     * @param institutionsData the institutionsData to set
     */
    public void setInstitutionsData(SingleSelectOptionsList institutionsData) {
        this.institutionsData = institutionsData;
    }

    /**
     * @return the countriesData
     */
    public SingleSelectOptionsList getCountriesData() {
        return countriesData;
    }

    /**
     * @param countriesData the countriesData to set
     */
    public void setCountriesData(SingleSelectOptionsList countriesData) {
        this.countriesData = countriesData;
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
}
