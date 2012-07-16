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

package org.inbio.ara.gis;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.SiteCoordinateDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListSite.java
 * @version Created on Sep 15, 2009, 3:44:36 PM
 * @author mvargas
 * modified by esmata 2009-10-13
 */

public class ListSite extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

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

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }



    // </editor-fold>

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;
    //Componentes graficos utilizados para las busquedas de sitios
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private TextField txLocality = new TextField();
    private TextField txLatitudeShort = new TextField();
    private TextField txLongitudeShort = new TextField();
    private TextField txRadio = new TextField();
    private TextField txTaxonName = new TextField();
    //Input text de busqueda simple
    private HtmlInputText txSearch = new HtmlInputText(); 
    private DropDown ddCountry = new DropDown();
    private DropDown ddProvince = new DropDown();
    //En esta variable se setearan los datos del drop down de paises
    private SingleSelectOptionsList countriesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();
     //Boton busqueda simple
    private HtmlCommandButton btnSeach = new HtmlCommandButton();
     //Boton busqueda avanzada
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton();
     //Boton para mostrar todas las localidades
    private HtmlCommandButton btnShowAllLocalities = new HtmlCommandButton();

    //Data table binding para la tabla que muetra los sitios
    private HtmlDataTable dataTableSite = new HtmlDataTable();

    //CDontiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    private Long INVALID_VALUE_ID = new Long(-1);

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListSite() {
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
            log("ListSite Initialization Failure", e);
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
        SiteSessionBean ssb = getGis$SiteSessionBean();
        //------------------------------ Control de GUI -------------------------------
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if (ssb.isAdvancedSearch()) {
            //Muestra el panel de busqueda avanzada
            this.getGridpAdvancedSearch().setRendered(true);
            //Cargar valores del DD de paises
            this.SetCountryDropDownData();
            //Cargar valores del DD de provincias
            this.SetProvincesDropDownData();
        }
        //-------------------------- Control de Paginador ------------------------------
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (ssb.getPagination()==null) {
            ssb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            ssb.getPagination().refreshList();
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
    public String btnAdvSiteSearch_action() {
        boolean advanced = getGis$SiteSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getGis$SiteSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSeach().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSeach().setValue(BundleHelper.getDefaultBundleValue
                    ("advanced_search_specimen_back",getMyLocale()));
            return null;
        } else if(advanced==true){
            this.getGis$SiteSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.getGridpAdvancedSearch().setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSeach().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSeach().setValue(BundleHelper.getDefaultBundleValue
                    ("advanced_search",getMyLocale()));
            //Reestablecer los valores por defecto de los drop downs
            Long auxDefault = new Long(-1);
            this.getGis$SiteSessionBean().setSelectedCountry(auxDefault);
            this.getGis$SiteSessionBean().setSelectedProvince(auxDefault);
            //Reestablecer los valores por defecto de los textfields
            this.getTxLocality().setText(null);
            this.getTxTaxonName().setText(null);
            this.getTxLatitudeShort().setText(null);
            this.getTxLongitudeShort().setText(null);
            this.getTxRadio().setText(null);
        }
        return null;
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnSiteSearch_action() {
        String userInput = "";
        if (this.getTxSearch().getValue() != null) {
            userInput = this.getTxSearch().getValue().toString();
        }
        userInput = userInput.trim();
        if (userInput.length() == 0) {
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getGis$SiteSessionBean().setQueryModeSimple(false);
            this.getGis$SiteSessionBean().setQueryMode(false);
        } else {
            //Setear el string para consulta simple del SessionBean
            this.getGis$SiteSessionBean().setConsultaSimple(userInput);
            //Paginador debe "trabajar" en modo busqueda simple
            this.getGis$SiteSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getGis$SiteSessionBean().setQueryMode(false);
        }
        this.getGis$SiteSessionBean().getPagination().firstResults();
        return null;
    }

    /**
     * Metodo ejecutado por el boton de proceder con la busqueda avanzada
     * este boton es el que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnAdvSearchGO_action() {
        //Crear el DTO para la consulta
        SiteDTO consulta = new SiteDTO();
        consulta.setDescription((String)this.getTxLocality().getText());
        consulta.setTaxonName((String)this.getTxTaxonName().getText());
        Double latitude_short = null;
        Double longitude_short = null;
        Integer radio = null;
        try {
            latitude_short = Double.valueOf
                    (this.getTxLatitudeShort().getText().toString());
            longitude_short = Double.valueOf
                    (this.getTxLongitudeShort().getText().toString());
            radio = Integer.valueOf(this.getTxRadio().getText().toString());
        } catch (Exception e) {
        }
        if (latitude_short != null && longitude_short != null && radio != null) {
            consulta.setLatitude(latitude_short);
            consulta.setLongitude(longitude_short);
            consulta.setRadio(radio);
        }
        //En caso de que alguno de los tres sea nulo
        if ((latitude_short == null || longitude_short == null || radio == null) &&
                (latitude_short != null || longitude_short != null || radio != null)) {
            MessageBean.setErrorMessageFromBundle("error_coordinates_search",
                    this.getMyLocale());
        }
        consulta.setCountryId(this.getGis$SiteSessionBean().getSelectedCountry());
        consulta.setProvinceId(this.getGis$SiteSessionBean().getSelectedProvince());

        //Setear el SiteDTO del SessionBean utilizado para realizar la consulta
        this.getGis$SiteSessionBean().setQuerySiteDTO(consulta);
        //Paginador debe "trabajar" en modo busqueda avanzada
        this.getGis$SiteSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getGis$SiteSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el paginador con los resultados de la consulta
        this.getGis$SiteSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");

        return null;
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public void SetProvincesDropDownData(){
        List<GeographicLayerDTO> geoDTOList = this.getGis$SiteSessionBean().
                SetProvincesDropDownData();
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
     * Obtener los datos para el drop down de paises
     */
    public void SetCountryDropDownData(){
        List<GeographicLayerDTO> geoDTOList = this.getGis$SiteSessionBean().
                SetCountryDropDownData();
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
        this.getCountriesData().setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Metodo ejecutado por el boton de new site
     * @return
     */
    public String btn_new_action() {
        //Limpiar el current DTO
        this.getGis$SiteSessionBean().setCurrentSiteDTO(new SiteDTO());
        this.getGis$SiteSessionBean().setSelectedBaseProjection(null);
        this.getGis$SiteSessionBean().setSelectedDeterminationMethod(null);
        this.getGis$SiteSessionBean().setSelectedOriginProjection(null);
        this.getGis$SiteSessionBean().setSelectedType(null);
        this.getGis$SiteSessionBean().setSelectedCountryId(INVALID_VALUE_ID);
        this.getGis$SiteSessionBean().setSelectedProvinceId(INVALID_VALUE_ID);
        this.getGis$SiteSessionBean().setCoordinateDataProvider
                (new ArrayList<SiteCoordinateDTO>());
        this.getGis$SiteSessionBean().setSelectedProjection(null);
        return "new";
    }

    /**
     * Metodo ejecutado por el boton para editar sitios
     * @return
     */
    public String btn_edit_action(){
        int n = this.getDataTableSite().getRowCount();
        ArrayList<SiteDTO> selectedSites = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSite().setRowIndex(i);
            SiteDTO aux = (SiteDTO) this.getDataTableSite().getRowData();
            if (aux.isSelected()) {
                selectedSites.add(aux);
            }
        }
        if(selectedSites == null || selectedSites.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedSites.size() == 1){ //En caso de que solo se seleccione un elemento
            /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
            actuales del dto seleccionado*/
            this.getGis$SiteSessionBean().setFirstTime(true);
            this.getGis$SiteSessionBean().setCurrentSiteDTO(selectedSites.get(0));
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton para eliminar un sitio existente
     * @return
     */
    public String btn_delete_action(){
        int n = this.getDataTableSite().getRowCount();
        ArrayList<SiteDTO> selectedSites = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSite().setRowIndex(i);
            SiteDTO aux = (SiteDTO) this.getDataTableSite().getRowData();
            if (aux.isSelected()) {
                selectedSites.add(aux);
            }
        }
        if(selectedSites == null || selectedSites.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        //En caso de que solo se seleccione un elemento
        else if(selectedSites.size() == 1){
            SiteDTO selected = selectedSites.get(0);
            //Mandar a borrar el sitio
            try{
                this.getGis$SiteSessionBean().deleteSite(selected.getSiteId());
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete",
                        this.getMyLocale());
                return null;
            }

            //Refrescar la lista de sitios
            this.getGis$SiteSessionBean().getPagination().refreshList();

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
     * Mostrar todas las localidades existentes
     * @return
     */
    public String btnShowAllLocalities_action() {
        List<SiteDTO> localities = this.getGis$SiteSessionBean().
                getResults(0, 1000000);
        this.getGis$SiteSessionBean().getPagination().getDataProvider().
                setList(localities);
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getGis$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
     * Metodo ejecutado por el drop down de paises para calcular las provincias
     */
    public String setProvinces(){
        this.provincesData = new SingleSelectOptionsList();
        this.SetProvincesDropDownData();
        return null;
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getGis$SiteSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the dataTableSite
     */
    public HtmlDataTable getDataTableSite() {
        return dataTableSite;
    }

    /**
     * @param dataTableSite the dataTableSite to set
     */
    public void setDataTableSite(HtmlDataTable dataTableSite) {
        this.dataTableSite = dataTableSite;
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
     * @return the btnShowAllLocalities
     */
    public HtmlCommandButton getBtnShowAllLocalities() {
        return btnShowAllLocalities;
    }

    /**
     * @param btnShowAllLocalities the btnShowAllLocalities to set
     */
    public void setBtnShowAllLocalities(HtmlCommandButton btnShowAllLocalities) {
        this.btnShowAllLocalities = btnShowAllLocalities;
    }
    
}

