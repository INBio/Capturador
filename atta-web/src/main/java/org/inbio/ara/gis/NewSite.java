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
import com.sun.webui.jsf.component.*;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.component.html.HtmlSelectOneRadio;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.gis.FeatureTypeDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.ProjectionDTO;
import org.inbio.ara.dto.gis.ProvinceDTO;
import org.inbio.ara.dto.gis.SiteCalculationMethodDTO;
import org.inbio.ara.dto.gis.SiteCoordinateDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.persistence.gis.FeatureTypeEnum;
import org.inbio.ara.persistence.gis.ProjectionEntity;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewSite.java
 * @version Created on 18/11/2009, 09:16:37 AM
 * @author esmata
 */

public class NewSite extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Binding de los componetes graficos
    private TextArea txaDescription = new TextArea();
    private DropDown ddType = new DropDown();
    private DropDown ddBaseProjection = new DropDown();
    private DropDown ddDetermination = new DropDown();
    private DropDown ddOrigProjection = new DropDown();
    private DropDown ddProjection = new DropDown();
    private DropDown ddWgs84Format = new DropDown();

    private TextField txPresition = new TextField();
    private TextField txDatum = new TextField();
    private TextField txLongitudeDegrees = new TextField();
    private TextField txLatitudeDegrees = new TextField();
    //Binding de la tabla de coordenadas
    private HtmlDataTable dataTableCoordinates = new HtmlDataTable();
    private TextField txLongitudeMinutes = new TextField();
    private TextField txLongitudeSeconds = new TextField();
    private TextField txLatitudeMinutes = new TextField();
    private TextField txLatitudeSeconds = new TextField();
    private TextField txLongitude = new TextField();
    private TextField txLatitude = new TextField();
    
    private TextField txVerbatimLongitude = new TextField();
    private TextField txVerbatimLatitude = new TextField();
    
    private Label lbWgs84Format = new Label();

    //private HtmlSelectOneRadio rbWgs84Format = new HtmlSelectOneRadio();
    private RadioButtonGroup rbWgs84Format = new RadioButtonGroup();
    
    
    private PanelLayout panelWGS84Projection = new PanelLayout();
    private PanelLayout panelGeneralProjection = new PanelLayout();
    private PanelLayout panelVerbatimCoordinates = new PanelLayout();

    //Constantes
	private final String INVALID_LATITUDE = "invalid_latitude";
	private final String INVALID_LATITUDE_RANGE = "invalid_latitude_range";
	private final String INVALID_LONGITUDE = "invalid_longitude";
	private final String INVALID_LONGITUDE_RANGE = "invalid_longitude_range";
	private final String NOT_APPLY = "not_apply";
	private final String DUPLICATED_COORDINATES = "duplicated_coordinates";
        private final String ERROR_NULL_COORDINATES = "error_null_coordinate";
	private final String EMPTY_COORIDNATES = "empty_cooridnates";
	private final String EMPTY_DESCRIPTION = "empty_description";
	private final String EMPTY_METHOD = "empty_method";
	private final String EMPTY_ORIGINAL_PROYECTION = "empty_original_proyection";
	private final String EMPTY_PROYECTION = "empty_proyection";
	private final String EMPTY_TYPE = "empty_type";
	private final String ONLY_ONE_COORDINATE_ALLOWED = "only_one_coordinate_allowed";
	private final String THREE_COORDINATES_REQUIRED = "three_coordinates_required";
	private final String TWO_COORIDNATES_REQUIRED = "two_cooridnates_required";
    private Long INVALID_VALUE_ID = new Long(-1);

    //En esta variable se setearan los datos del drop down de feature type
    private SingleSelectOptionsList typeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down proyeccion base
    private SingleSelectOptionsList baseProjectionData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de metodo de determinacion
    private SingleSelectOptionsList determinationMethodData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down proyeccion original
    private SingleSelectOptionsList originProjectionData = new SingleSelectOptionsList();

    //En esta variable se setearan los datos del drop down proyeccion original
    private SingleSelectOptionsList countriesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down proyeccion original
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();
    //En esta variable se almacenan los datos del drop dows projecciones
    private SingleSelectOptionsList projectionData = new SingleSelectOptionsList();
    
    private SingleSelectOptionsList wgs84FormatData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewSite() {
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
            log("NewSite Initialization Failure", e);
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
        System.out.println("HIZO PRERENDER");
        this.baseProjectionData.setOptions(this.getProjectionsDropDownData());
        this.determinationMethodData.setOptions(this.getCalculationMethodDropDownData());
        this.originProjectionData.setOptions(this.getProjectionsDropDownData());
        this.typeData.setOptions(this.getFeatureTypeDropDownData());
        
        this.projectionData.setOptions(this.getProjectionsUsedDropDownData());
        

        this.setActualPoliticValuesToDropDowns(null);
        this.setCountriesDropDownData();
        this.setProvincesDropDownData();

        Option op1 = new Option(0,BundleHelper.getDefaultBundleValue
                ("sexahecimal",this.getMyLocale()));
        Option op2 = new Option(1,BundleHelper.getDefaultBundleValue
                ("decimal",this.getMyLocale()));
        Option options[] = {op1,op2};
        this.wgs84FormatData.setOptions(options);
        
        if(this.getSiteSessionBean().getSelectedProjection() == null )
        {
            
            this.getSiteSessionBean().setSelectedProjection(ProjectionEntity.WGS_84.getId());
            this.getPanelWGS84Projection().setVisible(true);
            this.getPanelGeneralProjection().setVisible(false);
            this.getSiteSessionBean().setWgs84Projection(true);
            this.getSiteSessionBean().setSelectedWgs84Format(0);
            
            
        }

        //se agrega para que se actualice correctamente en caso de campos requeridos incompletos
        this.getDdProjection().setSelected(this.getSiteSessionBean().getSelectedProjection());
        this.getDdWgs84Format().setSelected(this.getSiteSessionBean().getSelectedWgs84Format());
        System.out.println("VALORES PARA = "+this.getSiteSessionBean().getSelectedProjection());
        System.out.println("Longitude = "+this.getTxLongitude().getText());
        System.out.println("Latitude = "+this.getTxLatitude().getText());
        //this.setProjections();
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
     * Obtener los datos del drop down de las proyecciones utilizadas por el sistema
     */
    public Option[] getProjectionsUsedDropDownData(){
        ProjectionEntity[] all = ProjectionEntity.values();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        /*
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
         */
        //Crear todas las opciones del drop down
        for(ProjectionEntity myProjection : all){
            option = new Option(myProjection.getId(), myProjection.getName().trim());
            allOptions.add(option);
            //System.out.println(""+myProjection.getId()+" - "+ myProjection.getName().trim());
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de feature type
     */
    public Option[] getFeatureTypeDropDownData(){
        List<FeatureTypeDTO> DTOList = this.getSiteSessionBean().
                getGisFacade().getAllFeatureType();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(FeatureTypeDTO myDTO : DTOList){
            option = new Option(myDTO.getFeatureTypeId(), myDTO.getName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de projections
     */
    public Option[] getProjectionsDropDownData(){
        List<ProjectionDTO> DTOList = this.getSiteSessionBean().
                getGisFacade().getAllProjection();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
         
        //Crear todas las opciones del drop down
        for(ProjectionDTO myDTO : DTOList){
            option = new Option(myDTO.getProjectionId(), myDTO.getName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de site calculation method
     */
    public Option[] getCalculationMethodDropDownData(){
        List<SiteCalculationMethodDTO> DTOList = this.getSiteSessionBean().
                getGisFacade().getAllSiteCalculationMethods();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SiteCalculationMethodDTO myDTO : DTOList){
            option = new Option(myDTO.getSiteCalculationMethodId(), myDTO.getName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Carga todos los paises en el dropdown y si country no es nulo
     * entonces pone como pais seleccionado el que este en la variable
     * contry
     */
    public void setCountriesDropDownData(){
        SiteSessionBean ssb = this.getSiteSessionBean();

        List<CountryDTO> countriesLists = ssb.getGisFacade().findAllCountries();

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        allOptions.add(new Option(INVALID_VALUE_ID, " -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --"));
        for(CountryDTO c : countriesLists){
            option = new Option(c.getCountryId(), c.getValue());
            allOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.countriesData.setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Carga todas las provincias en el dropdown y si province no es nulo
     * entonces pone como province seleccionado ese
     */
    public void setProvincesDropDownData(){
        SiteSessionBean ssb = this.getSiteSessionBean();

        List<ProvinceDTO> provincessLists;
        if(ssb.getSelectedCountryId() != null && !ssb.getSelectedCountryId().
                equals(INVALID_VALUE_ID))
            provincessLists = ssb.getGisFacade().getAllProvincesForContry
                    (ssb.getSelectedCountryId());
        else
            provincessLists = new ArrayList<ProvinceDTO>();

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        allOptions.add(new Option(INVALID_VALUE_ID, " -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --"));
        for(ProvinceDTO p : provincessLists){
            option = new Option(p.getProvinceId(), p.getValue());
            allOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.provincesData.setOptions(allOptions.toArray(allOptionsInArray));
    }

    public void onCountryChange(){
        System.out.println("Cambia de pais");
        SiteSessionBean ssb = this.getSiteSessionBean();
        if (ssb.getSelectedCountryId().equals(INVALID_VALUE_ID)){
            updateProvincesDropDownData(null);
        } else{
            updateProvincesDropDownData(ssb.getSelectedCountryId());
        }
    }

    /**
     * Actualiza los datos del dropdown
     * @param countryId
     */
    public void updateProvincesDropDownData(Long countryId){
        SiteSessionBean ssb = this.getSiteSessionBean();

        List<GeographicLayerDTO> provincessLists = ssb.getGisFacade().
                getProvincesByCountry(countryId);

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        allOptions.add(new Option(INVALID_VALUE_ID, " -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --"));
        for(GeographicLayerDTO p : provincessLists){
            option = new Option(p.getGeographicalLayerKey(), p.getName());
            allOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.provincesData.setOptions(allOptionsInArray);
    }

   
    public void setActualPoliticValuesToDropDowns(Long siteId){
        SiteSessionBean ssb = this.getSiteSessionBean();

        //Caso de los paises
        if(ssb.getSelectedCountryId() == null){
            if(siteId != null){
                CountryDTO country = ssb.getGisFacade().getCountryForSite(siteId);
                if(country!=null){
                    //System.out.println("Actual country: "+country.getValue());
                    ssb.setSelectedCountryId(country.getCountryId());
                } else
                    ssb.setSelectedCountryId(INVALID_VALUE_ID);
            } else
                ssb.setSelectedCountryId(INVALID_VALUE_ID);
        }

        //Caso de las provincias
        if(ssb.getSelectedProvinceId() == null ) {
            if(siteId != null){
                ProvinceDTO province = ssb.getGisFacade().getProvinceForSite(siteId);
                if(province!=null){
                    //System.out.println("Actual province: "+province.getValue());
                    ssb.setSelectedProvinceId(province.getProvinceId());
                } else
                    ssb.setSelectedProvinceId(INVALID_VALUE_ID);
            } else
                ssb.setSelectedProvinceId(INVALID_VALUE_ID);
        }
    }

    /**
     * Boton guardar nuevo sitio
     * @return
     */
    public String btnNewSite_action() {
        SiteSessionBean ssb = this.getSiteSessionBean();

        boolean validation = validateCoordinates();
        if(!validation){
            return null;
        }

        //Obtener datos introducidos por el usuario
        String description = (String)this.getTxaDescription().getText();
        Long presition=null,datum=null;
        String paux = (String)this.getTxPresition().getText();
        if(paux!=null){
            presition = Long.valueOf(paux);
        }
        String daux = (String)this.getTxDatum().getText();
        if(daux!=null){
            datum = Long.valueOf(daux);
        }

        //Setear datos al currentDTO
        ssb.getCurrentSiteDTO().setDescription(description);
        ssb.getCurrentSiteDTO().setPrecision(presition);
        ssb.getCurrentSiteDTO().setGeodeticDatum(datum);
        ssb.getCurrentSiteDTO().setFeatureTypeId(ssb.getSelectedType());
       /* ssb.getCurrentSiteDTO().setBaseProjectionId
                (ssb.getSelectedBaseProjection());
                
        */
        // La proyección almacenada siempre será WGS84
        ssb.getCurrentSiteDTO().setBaseProjectionId
                (ProjectionEntity.WGS_84.getId());
        
        ssb.getCurrentSiteDTO().setSiteCalculationMethodId
                (ssb.getSelectedDeterminationMethod());
        /*
        ssb.getCurrentSiteDTO().setOriginalProjectionId
                (ssb.getSelectedOriginProjection());
        */
        ssb.getCurrentSiteDTO().setOriginalProjectionId
                (ssb.getSelectedProjection());
        ssb.getCurrentSiteDTO().setName(BundleHelper.getDefaultBundleValue
                (NOT_APPLY, this.getMyLocale()));

        //Mandar a persistir el nuevo sitio
        try{
            ssb.getCurrentSiteDTO().setUserName(this.getAraSessionBean().getGlobalUserName());
            this.getSiteSessionBean().saveNewSite();
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Limpiar la pantalla, el DTO y los selected items y la lista de coordenadas
        ssb.setCurrentSiteDTO(new SiteDTO());
        ssb.setSelectedBaseProjection(null);
        ssb.setSelectedDeterminationMethod(null);
        ssb.setSelectedOriginProjection(null);
        ssb.setSelectedType(null);
        ssb.setSelectedCountryId(INVALID_VALUE_ID);
        ssb.setSelectedProvinceId(INVALID_VALUE_ID);
        this.getTxaDescription().setText(null);
        this.getTxPresition().setText(null);
        this.getTxDatum().setText(null);
        ssb.setCoordinateDataProvider(new ArrayList<SiteCoordinateDTO>());

        //Actualizar el paginador de sitios
        ssb.getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("create_site_succes",
                this.getMyLocale());

        return null;
    }

    private boolean validateCoordinates() {
        if (this.getSiteSessionBean().getSelectedType().equals
                (FeatureTypeEnum.LINE.getId())) {
            if (this.getSiteSessionBean().getCoordinateDataProvider().size() < 2) {
                MessageBean.setErrorMessageFromBundle
                        (TWO_COORIDNATES_REQUIRED, this.getMyLocale());
                return false;
            }
        }

        if (this.getSiteSessionBean().getSelectedType().equals
                (FeatureTypeEnum.POLYGON.getId())) {
            if (this.getSiteSessionBean().getCoordinateDataProvider().size() < 3) {
                MessageBean.setErrorMessageFromBundle
                        (THREE_COORDINATES_REQUIRED, this.getMyLocale());
                return false;
            }
        }

        return true;
    }
    
    /**
     * Boton para agregar coordenada
     */
    public String btnAddCoordinate_action() {
        Long projection = this.getSiteSessionBean().getSelectedProjection();
        String original_X = null; 
        String original_Y = null;
        String lon_result = null;
        String lat_result = null;
        if (canAddCoordinate())
        {         
           if(projection.equals(ProjectionEntity.WGS_84.getId()) && this.getSiteSessionBean().getSelectedWgs84Format() == 0)
           {
               Object lon_degrees = this.getTxLongitudeDegrees().getValue();
               Object lon_seconds = this.getTxLongitudeSeconds().getValue();
               Object lon_minutes = this.getTxLongitudeMinutes().getValue();
               Object lat_degrees = this.getTxLatitudeDegrees().getValue();
               Object lat_minutes = this.getTxLatitudeMinutes().getValue();
               Object lat_seconds = this.getTxLatitudeSeconds().getValue();
               
               if (validateLongitude()) {
                if (validateLatitude()) {
                    //All data (degrees, minutes and seconds)
                    if(validateMandS(lon_minutes) && validateMandS(lon_seconds)
                            && validateMandS(lat_minutes) && validateMandS(lat_seconds)){
                        //Translate from sexagecimal to decimal notation
                        lon_result = translateCoor(lon_degrees.toString(),
                                lon_minutes.toString(),lon_seconds.toString());
                        lat_result = translateCoor(lat_degrees.toString(),
                                lat_minutes.toString(),lat_seconds.toString());  
                       original_X = lon_result;
                       original_Y= lat_result;
               
                   }
                }
               }
           }
           if(projection.equals(ProjectionEntity.WGS_84.getId()) && this.getSiteSessionBean().getSelectedWgs84Format() == 1)
           {   if (this.txLongitude.getText() != null && validateLonLatGeneric(this.txLongitude.getText().toString())) { //envian mensaje de error en caso de que no cumplan con el estandar
                if (this.txLatitude.getText() != null && validateLonLatGeneric(this.txLatitude.getText().toString())) {            
                    lon_result = this.txLongitude.getText().toString();

                    lat_result = this.txLatitude.getText().toString();
                    original_X = "0";
                    original_Y= "0";
                }
               }
           }
           else
           {
               System.out.println(this.txLongitude.getText());
              if (this.txLongitude.getText() != null && validateLonLatGeneric(this.txLongitude.getText().toString())) { //envian mensaje de error en caso de que no cumplan con el estandar
                if (this.txLatitude.getText() != null && validateLonLatGeneric(this.txLatitude.getText().toString())) {     
                    float x = Float.parseFloat(this.txLongitude.getText().toString());
                    float y = Float.parseFloat(this.txLatitude.getText().toString());
                    String lonlat[] =this.getSiteSessionBean().getReprojection(x, y, this.getSiteSessionBean().getSelectedProjection(), ProjectionEntity.WGS_84.getId());
                    if(lonlat!=null)
                    {
                        lon_result = lonlat[0];
                        lat_result = lonlat[1];
                       original_X = this.txLongitude.getText().toString();
                       original_Y= this.txLatitude.getText().toString();
                    }
                    else
                    {
                        MessageBean.setErrorMessageFromBundle(DUPLICATED_COORDINATES,
                            this.getMyLocale());                    
                    }
                }
               }
           }
           if(lon_result != null && lat_result != null)
           {
            SiteCoordinateDTO coord = new SiteCoordinateDTO();
            coord.setLongitude(getDoubleValue(lon_result));
            coord.setLatitude(getDoubleValue(lat_result));
            coord.setOriginalX(original_X);
            coord.setOriginalY(original_Y);
            coord.setVerbatimLongitude(this.txVerbatimLongitude.getValue().toString());
            coord.setVerbatimLatitude(this.txVerbatimLatitude.getValue().toString());
            coord.setUserName(this.getAraSessionBean().getGlobalUserName());
            this.ddProjection.setDisabled(true);
                if (!this.getSiteSessionBean().addElement(coord)) {
                MessageBean.setErrorMessageFromBundle(DUPLICATED_COORDINATES,
                        this.getMyLocale());
                        if(this.getSiteSessionBean().getCoordinateDataProvider().isEmpty())
                        {
                            this.ddProjection.setDisabled(false);
                        }
                    
                /*
            this.txLongitudeDegrees.setValue("0");
            this.txLongitudeMinutes.setValue("0");
            this.txLongitudeSeconds.setValue("0");
            this.txLatitudeDegrees.setValue("");
            this.txLatitudeMinutes.setValue("0");
            this.txLatitudeSeconds.setValue("0");*/
                }
            this.txLongitudeDegrees.setValue("0");
            this.txLongitudeMinutes.setValue("0");
            this.txLongitudeSeconds.setValue("0");
            this.txLatitudeDegrees.setValue("0");
            this.txLatitudeMinutes.setValue("0");
            this.txLatitudeSeconds.setValue("0");
            this.txLongitude.setValue("0");
            this.txLatitude.setValue("0");
            this.txVerbatimLongitude.setValue("0");
            this.txVerbatimLatitude.setValue("0");
            }
           else
           {
               MessageBean.setErrorMessageFromBundle(ERROR_NULL_COORDINATES,
                        this.getMyLocale());
           }

        }
        
        return null;
    }

    private boolean canAddCoordinate() {
        if (this.getSiteSessionBean().getSelectedType().equals(1L)) {
            if (this.getSiteSessionBean().getCoordinateDataProvider().size() == 1) {
                MessageBean.setErrorMessageFromBundle(ONLY_ONE_COORDINATE_ALLOWED,
                        this.getMyLocale());
                return false;
            }
        }
        return true;
    }

    private boolean validateLongitude() {
        Float tmp;
        String coordinate;
        if (this.txLongitudeDegrees.getValue() == null) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }
        coordinate = this.txLongitudeDegrees.getValue().toString();
        if (coordinate.length() <= 0) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }
        try {
            tmp = Float.parseFloat(coordinate);
            if ((tmp >= -180) & (tmp <= 180)) {
                return true;
            } else {
                MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE_RANGE,
                    this.getMyLocale());
                return false;
            }
        } catch (NumberFormatException ex) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }
    }

    
     private boolean validateLonLatGeneric(String lonlat) {
        Float tmp;
        String coordinate =lonlat;
        System.out.println(coordinate);
        if (coordinate == null) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }        
        if (coordinate.length() <= 0) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }
        try {
            tmp = Float.parseFloat(coordinate);  
            return true;
        } catch (NumberFormatException ex) {
            MessageBean.setErrorMessageFromBundle(INVALID_LONGITUDE,
                    this.getMyLocale());
            return false;
        }
    }
    
    private boolean validateLatitude() {
        Float tmp;
        String coordinate;
        if (this.txLatitudeDegrees.getValue() == null) {
            MessageBean.setErrorMessageFromBundle(INVALID_LATITUDE,
                    this.getMyLocale());
            return false;
        }
        coordinate = this.txLatitudeDegrees.getValue().toString();
        if (coordinate.length() <= 0) {
            MessageBean.setErrorMessageFromBundle(INVALID_LATITUDE,
                    this.getMyLocale());
            return false;
        }
        try {
            tmp = Float.parseFloat(coordinate);
            if ((tmp >= -90) & (tmp <= 90)) {
                return true;
            } else {
                MessageBean.setErrorMessageFromBundle(INVALID_LATITUDE_RANGE,
                    this.getMyLocale());
                return false;
            }
        } catch (NumberFormatException ex) {
            MessageBean.setErrorMessageFromBundle(INVALID_LATITUDE,
                    this.getMyLocale());
            return false;
        }
    }

    //Validate minutes and seconds (MandS)
    private boolean validateMandS(Object in) {
        Float tmp;
        String time;
        if (in == null) {
            MessageBean.setErrorMessageFromBundle("invalid_coor_ms",
                    this.getMyLocale());
            return false;
        }
        time = in.toString();
        try {
            tmp = Float.parseFloat(time);
            if ((tmp >= 0) && (tmp < 60)) {
                return true;
            } else {
                MessageBean.setErrorMessageFromBundle("invalid_coor_ms",
                        this.getMyLocale());
                return false;
            }
        } catch (NumberFormatException ex) {
            MessageBean.setErrorMessageFromBundle("invalid_coor_ms",
                    this.getMyLocale());
            return false;
        }
    }

    //Method to translate from sexagecimal to decimal notation
    public String translateCoor(String degrees,String minutes,String seconds){
        Float d,m,s,result;
        boolean positive = true;
        try{
            //Get float values
            if(degrees.startsWith("-"))
            {
                positive = false;
            }
            d = Float.parseFloat(degrees);
            m = Float.parseFloat(minutes);
            s = Float.parseFloat(seconds);
            result = Math.abs(d)+Math.abs((m*60)/3600)+Math.abs(s/3600);
            if(d>=0 && positive)
                return result.toString();
            else{
                result = result * -1;
                return result.toString();
            }
        }
        catch(NumberFormatException e){return "";}
    }

    private Double getDoubleValue(String value) {
        try {
            Double tmp = Double.parseDouble(value);
            return tmp;
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /**
     * Boton para eliminar coordenadas
     */
    public String btnRemoveCoord_action() {
        // Se elimina el ultimo sexo y estadio ingresado
        int elements = this.getSiteSessionBean().getCoordinateDataProvider().size();
        //No se puede eliminar un elemento si no hay nada que borrar
        if(elements==0){
            
            MessageBean.setErrorMessageFromBundle("error_delete_generic",
                    this.getMyLocale());
            return null;
        }
        else{
            this.getSiteSessionBean().getCoordinateDataProvider().remove(elements-1);
            if(this.getSiteSessionBean().getCoordinateDataProvider().isEmpty())
            {
                this.ddProjection.setDisabled(false);
            }
            return null;
        }
    }


    public String onChangeProjection_action() {

        System.out.println("Proyeccion seleccionada = "+this.getSiteSessionBean().getSelectedProjection());

        if(this.getSiteSessionBean().getSelectedProjection().equals(ProjectionEntity.WGS_84.getId()))
        {
            this.getDdWgs84Format().setVisible(true);
            this.getLbWgs84Format().setVisible(true);
            this.getSiteSessionBean().setWgs84Projection(true);
            this.getPanelWGS84Projection().setVisible(true);
            this.getPanelGeneralProjection().setVisible(false);
        }
        else
        {
            this.getDdWgs84Format().setVisible(false);
            this.getLbWgs84Format().setVisible(false);
            this.getSiteSessionBean().setWgs84Projection(false);
            this.getPanelWGS84Projection().setVisible(false);
            this.getPanelGeneralProjection().setVisible(true);
        }
        System.out.println("Proyeccion seleccionada antes de salir de OnChangeProjection= "+this.getSiteSessionBean().getSelectedProjection());
        return null;
    }
    
    public String onChangeWGS84Format_action( ) {
        System.out.println("Entro al cambio de formato");

        if(this.getSiteSessionBean().getSelectedProjection().equals(ProjectionEntity.WGS_84.getId()) && 
                this.getSiteSessionBean().getSelectedWgs84Format() == 0)
        {
            //this.getSiteSessionBean().setWgs84Projection(true);
            this.getPanelWGS84Projection().setVisible(true);
            this.getPanelGeneralProjection().setVisible(false);
        }
        else
        {
            //this.getSiteSessionBean().setWgs84Projection(false);
            this.getPanelWGS84Projection().setVisible(false);
            this.getPanelGeneralProjection().setVisible(true);
        }
        System.out.println("Proyeccion seleccionada antes de salir de OnChangeProjection= "+this.getSiteSessionBean().getSelectedProjection());
        
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
    protected SiteSessionBean getSiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
     * @return the ddType
     */
    public DropDown getDdType() {
        return ddType;
    }

    /**
     * @param ddType the ddType to set
     */
    public void setDdType(DropDown ddType) {
        this.ddType = ddType;
    }

    /**
     * @return the ddBaseProjection
     */
    public DropDown getDdBaseProjection() {
        return ddBaseProjection;
    }

    /**
     * @param ddBaseProjection the ddBaseProjection to set
     */
    public void setDdBaseProjection(DropDown ddBaseProjection) {
        this.ddBaseProjection = ddBaseProjection;
    }

    /**
     * @return the ddDetermination
     */
    public DropDown getDdDetermination() {
        return ddDetermination;
    }

    /**
     * @param ddDetermination the ddDetermination to set
     */
    public void setDdDetermination(DropDown ddDetermination) {
        this.ddDetermination = ddDetermination;
    }

    /**
     * @return the ddOrigProjection
     */
    public DropDown getDdOrigProjection() {
        return ddOrigProjection;
    }

    /**
     * @param ddOrigProjection the ddOrigProjection to set
     */
    public void setDdOrigProjection(DropDown ddOrigProjection) {
        this.ddOrigProjection = ddOrigProjection;
    }

    /**
     * @return the txPresition
     */
    public TextField getTxPresition() {
        return txPresition;
    }

    /**
     * @param txPresition the txPresition to set
     */
    public void setTxPresition(TextField txPresition) {
        this.txPresition = txPresition;
    }

    /**
     * @return the txDatum
     */
    public TextField getTxDatum() {
        return txDatum;
    }

    /**
     * @param txDatum the txDatum to set
     */
    public void setTxDatum(TextField txDatum) {
        this.txDatum = txDatum;
    }

    /**
     * @return the typeData
     */
    public SingleSelectOptionsList getTypeData() {
        return typeData;
    }

    /**
     * @param typeData the typeData to set
     */
    public void setTypeData(SingleSelectOptionsList typeData) {
        this.typeData = typeData;
    }

    /**
     * @return the baseProjectionData
     */
    public SingleSelectOptionsList getBaseProjectionData() {
        return baseProjectionData;
    }

    /**
     * @param baseProjectionData the baseProjectionData to set
     */
    public void setBaseProjectionData(SingleSelectOptionsList baseProjectionData) {
        this.baseProjectionData = baseProjectionData;
    }

    /**
     * @return the determinationMethodData
     */
    public SingleSelectOptionsList getDeterminationMethodData() {
        return determinationMethodData;
    }

    /**
     * @param determinationMethodData the determinationMethodData to set
     */
    public void setDeterminationMethodData(SingleSelectOptionsList determinationMethodData) {
        this.determinationMethodData = determinationMethodData;
    }

    /**
     * @return the originProjectionData
     */
    public SingleSelectOptionsList getOriginProjectionData() {
        return originProjectionData;
    }

    /**
     * @param originProjectionData the originProjectionData to set
     */
    public void setOriginProjectionData(SingleSelectOptionsList originProjectionData) {
        this.originProjectionData = originProjectionData;
    }

    /**
     * @return the txLongitudeDegrees
     */
    public TextField getTxLongitudeDegrees() {
        return txLongitudeDegrees;
    }

    /**
     * @param txLongitudeDegrees the txLongitudeDegrees to set
     */
    public void setTxLongitudeDegrees(TextField txLongitudeDegrees) {
        this.txLongitudeDegrees = txLongitudeDegrees;
    }

    /**
     * @return the txLatitudeDegrees
     */
    public TextField getTxLatitudeDegrees() {
        return txLatitudeDegrees;
    }

    /**
     * @param txLatitudeDegrees the txLatitudeDegrees to set
     */
    public void setTxLatitudeDegrees(TextField txLatitudeDegrees) {
        this.txLatitudeDegrees = txLatitudeDegrees;
    }

    /**
     * @return the dataTableCoordinates
     */
    public HtmlDataTable getDataTableCoordinates() {
        return dataTableCoordinates;
    }

    /**
     * @param dataTableCoordinates the dataTableCoordinates to set
     */
    public void setDataTableCoordinates(HtmlDataTable dataTableCoordinates) {
        this.dataTableCoordinates = dataTableCoordinates;
    }

    /**
     * @return the txLongitudeMinutes
     */
    public TextField getTxLongitudeMinutes() {
        return txLongitudeMinutes;
    }

    /**
     * @param txLongitudeMinutes the txLongitudeMinutes to set
     */
    public void setTxLongitudeMinutes(TextField txLongitudeMinutes) {
        this.txLongitudeMinutes = txLongitudeMinutes;
    }

    /**
     * @return the txLongitudeSeconds
     */
    public TextField getTxLongitudeSeconds() {
        return txLongitudeSeconds;
    }

    /**
     * @param txLongitudeSeconds the txLongitudeSeconds to set
     */
    public void setTxLongitudeSeconds(TextField txLongitudeSeconds) {
        this.txLongitudeSeconds = txLongitudeSeconds;
    }

    /**
     * @return the txLatitudeMinutes
     */
    public TextField getTxLatitudeMinutes() {
        return txLatitudeMinutes;
    }

    /**
     * @param txLatitudeMinutes the txLatitudeMinutes to set
     */
    public void setTxLatitudeMinutes(TextField txLatitudeMinutes) {
        this.txLatitudeMinutes = txLatitudeMinutes;
    }

    /**
     * @return the txLatitudeSeconds
     */
    public TextField getTxLatitudeSeconds() {
        return txLatitudeSeconds;
    }

    /**
     * @param txLatitudeSeconds the txLatitudeSeconds to set
     */
    public void setTxLatitudeSeconds(TextField txLatitudeSeconds) {
        this.txLatitudeSeconds = txLatitudeSeconds;
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
     * @return the ddProjection
     */
    public DropDown getDdProjection() {
        return ddProjection;
    }

    /**
     * @param ddProjection the ddProjection to set
     */
    public void setDdProjection(DropDown ddProjection) {
        this.ddProjection = ddProjection;
    }

    /**
     * @return the txLongitude
     */
    public TextField getTxLongitude() {
        return txLongitude;
    }

    /**
     * @param txLongitude the txLongitude to set
     */
    public void setTxLongitude(TextField txLongitude) {
        this.txLongitude = txLongitude;
    }

    /**
     * @return the txLatitude
     */
    public TextField getTxLatitude() {
        return txLatitude;
    }

    /**
     * @param txLatitude the txLatitude to set
     */
    public void setTxLatitude(TextField txLatitude) {
        this.txLatitude = txLatitude;
    }

    /**
     * @return the projectionData
     */
    public SingleSelectOptionsList getProjectionData() {
        return projectionData;
    }

    /**
     * @param projectionData the projectionData to set
     */
    public void setProjectionData(SingleSelectOptionsList projectionData) {
        this.projectionData = projectionData;
    }

    /**
     * @return the panelWGS84Projection
     */
    public PanelLayout getPanelWGS84Projection() {
        return panelWGS84Projection;
    }

    /**
     * @param panelWGS84Projection the panelWGS84Projection to set
     */
    public void setPanelWGS84Projection(PanelLayout panelWGS84Projection) {
        this.panelWGS84Projection = panelWGS84Projection;
    }

    /**
     * @return the panelGeneralProjection
     */
    public PanelLayout getPanelGeneralProjection() {
        return panelGeneralProjection;
    }

    /**
     * @param panelGeneralProjection the panelGeneralProjection to set
     */
    public void setPanelGeneralProjection(PanelLayout panelGeneralProjection) {
        this.panelGeneralProjection = panelGeneralProjection;
    }

    public void ddProjection_processValueChange(ValueChangeEvent event) {
        System.out.println("Entro a la accion ValueChange");
    }

    /**
     * @return the rbWgs84Format
     */
    public RadioButtonGroup getRbWgs84Format() {
        return rbWgs84Format;
    }

    /**
     * @param rbWgs84Format the rbWgs84Format to set
     */
    public void setRbWgs84Format(RadioButtonGroup rbWgs84Format) {
        this.rbWgs84Format = rbWgs84Format;
    }

    /**
     * @return the wgs84FormatData
     */
    public SingleSelectOptionsList getWgs84FormatData() {
        return wgs84FormatData;
    }

    /**
     * @param wgs84FormatData the wgs84FormatData to set
     */
    public void setWgs84FormatData(SingleSelectOptionsList wgs84FormatData) {
        this.wgs84FormatData = wgs84FormatData;
    }

    /**
     * @return the ddWgs84Format
     */
    public DropDown getDdWgs84Format() {
        return ddWgs84Format;
    }

    /**
     * @param ddWgs84Format the ddWgs84Format to set
     */
    public void setDdWgs84Format(DropDown ddWgs84Format) {
        this.ddWgs84Format = ddWgs84Format;
    }

    /**
     * @return the lbWgs84Format
     */
    public Label getLbWgs84Format() {
        return lbWgs84Format;
    }

    /**
     * @param lbWgs84Format the lbWgs84Format to set
     */
    public void setLbWgs84Format(Label lbWgs84Format) {
        this.lbWgs84Format = lbWgs84Format;
    }

    /**
     * @return the panelVerbatimCoordinates
     */
    public PanelLayout getPanelVerbatimCoordinates() {
        return panelVerbatimCoordinates;
    }

    /**
     * @param panelVerbatimCoordinates the panelVerbatimCoordinates to set
     */
    public void setPanelVerbatimCoordinates(PanelLayout panelVerbatimCoordinates) {
        this.panelVerbatimCoordinates = panelVerbatimCoordinates;
    }

    /**
     * @return the txVerbatimLongitude
     */
    public TextField getTxVerbatimLongitude() {
        return txVerbatimLongitude;
    }

    /**
     * @param txVerbatimLongitude the txVerbatimLongitude to set
     */
    public void setTxVerbatimLongitude(TextField txVerbatimLongitude) {
        this.txVerbatimLongitude = txVerbatimLongitude;
    }

    /**
     * @return the txVerbatimLatitude
     */
    public TextField getTxVerbatimLatitude() {
        return txVerbatimLatitude;
    }

    /**
     * @param txVerbatimLatitude the txVerbatimLatitude to set
     */
    public void setTxVerbatimLatitude(TextField txVerbatimLatitude) {
        this.txVerbatimLatitude = txVerbatimLatitude;
    }

   
}

