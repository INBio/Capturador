/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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
import com.sun.webui.jsf.component.Calendar;
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
import com.sun.webui.jsf.model.OptionTitle;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import java.util.GregorianCalendar;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.util.TaxonomicalRange;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version GenerationLabels.java
 * @version Created on 26/03/2010, 08:48:56 AM
 * @author paulacorrales
 */

public class ListLabels extends AbstractPageBean {

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
    private HtmlInputText txSearch = new HtmlInputText();
  
    private TextField txCatalogNumberEnd = new TextField();
    private TextField txCatalogNumberFirst = new TextField();
    private TextField txTaxonName = new TextField();
    private TextField txLocality = new TextField();
    private TextField txLatitudeShort = new TextField();
    private TextField txLongitudeShort = new TextField();
    private TextField txRadio = new TextField();
    private TextField txGatheringDetailNumberFirst  = new TextField();
    private TextField txGatheringDetailNumberEnd  = new TextField();
    private TextField txGatheringObservationFirst = new TextField();
    private TextField txGatheringObservationEnd  = new TextField();
    private DropDown ddCountry = new DropDown();
    private DropDown ddProvince = new DropDown();
    private DropDown ddResponsible = new DropDown();
    private DropDown ddInstitutionCode = new DropDown();
    private DropDown ddPerson = new DropDown();
    private DropDown ddIdentificator = new DropDown();
    private DropDown ddTaxonomicalRange = new DropDown();
    private HtmlCommandButton btnSeach = new HtmlCommandButton();
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton();
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();


   
    private HtmlDataTable dataTableSpecimens;

    //Bindings para la tabla que se utiliza para listar los especimenes
    private Table specimenTable = new Table();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();


    //En esta variable se setearan los datos del drop down de instituciones
    private SingleSelectOptionsList institutionsData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de paises
    private SingleSelectOptionsList countriesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();
     //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList personData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de responsables
    private SingleSelectOptionsList responsibleData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de responsables
    private SingleSelectOptionsList identificatorData = new SingleSelectOptionsList();
    //Datos de la lista
    private SingleSelectOptionsList ddTaxonomicalRangeData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListLabels() {
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
    public void prerender()
    {

        /**
         * This class uses two pagers, a first manage the DTO  of   (Historical or Correction) or DTO Specimen.
         */

       if(this.getlabel$LabelSessionBean().getPagination() == null || this.getlabel$LabelSessionBean().isVisualizeHistoryLabel() == true  ||  this.getlabel$LabelSessionBean().isVisualizeCorrectionLabel() == true)
       {
           this.getlabel$LabelSessionBean().setBanderaInit(true);
           this.getlabel$LabelSessionBean().setVisualizeHistoryLabel(false);
           this.getlabel$LabelSessionBean().setVisualizeCorrectionLabel(false);
           
           this.getlabel$LabelSessionBean().initDataProvider();
       }
       
        
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getlabel$LabelSessionBean().isAdvancedSearch()){
            this.gridpAdvancedSearch.setRendered(true);//Muestra el panel de busqueda avanzada

            this.SetInstitutionDropDownData(); //Cargar valores del DD de instituciones
            this.SetCountryDropDownData(); //Cargar valores del DD de paises
            this.SetProvincesDropDownData();//Cargar valores del DD de provicias
            this.SetResponsibleDropDownData(); //Cargar valores del DD responsables de colecciones
            this.SetTaxonomicLevelData();

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
    protected IdentificationSessionBean getIdentificationSessionBean() {
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
        try
           {
              quantityTotal = this.getlabel$LabelSessionBean().getQuantityTotal();
              return quantityTotal;
           }
        catch(Exception e)
        {
            return null;
        }
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

    /**
     * @return the ddPerson
     */
    public DropDown getDdPerson() {
        return ddPerson;
    }

    /**
     * @param ddPerson the ddPerson to set
     */
    public void setDdPerson(DropDown ddPerson) {
        this.ddPerson = ddPerson;
    }

    /**
     * @return the personData
     */
    public SingleSelectOptionsList getPersonData() {
        return personData;
    }

    /**
     * @param personData the personData to set
     */
    public void setPersonData(SingleSelectOptionsList personData) {
        this.personData = personData;
    }

    public SingleSelectOptionsList getDdTaxonomicalRangeData() {
        return ddTaxonomicalRangeData;
    }

    public void setDdTaxonomicalRangeData(SingleSelectOptionsList ddTaxonomicalRangeData) {
        this.ddTaxonomicalRangeData = ddTaxonomicalRangeData;
    }

    public DropDown getDdTaxonomicalRange() {
        return ddTaxonomicalRange;
    }

    public void setDdTaxonomicalRange(DropDown ddTaxonomicalRange) {
        this.ddTaxonomicalRange = ddTaxonomicalRange;
    }

 

    /*
     * Action del boton de editar espécimen
     * @return
     */
    public String btn_edit_action() {

        this.getlabel$LabelSessionBean().setAdvancedSearch(false); //Ojo: esto es para que cuando el usuario presione volver, el boton de busqueda avanzada funcione correctamente
        int n = this.getDataTableSpecimens().getRowCount();
        ArrayList<SpecimenDTO> selectedSpecimens = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSpecimens().setRowIndex(i);
            SpecimenDTO thisSpecimen = (SpecimenDTO) this.getDataTableSpecimens().getRowData();
            if (thisSpecimen.isSelected()) {
                selectedSpecimens.add(thisSpecimen);
            }
        }
        if(selectedSpecimens == null || selectedSpecimens.size() == 0){ //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedSpecimens.size() == 1 ){ //En caso de que solo se seleccione un elemento
            this.getlabel$LabelSessionBean().setCurrentSpecimenDTO(selectedSpecimens.get(0));

            if(selectedSpecimens.get(0).getLabelId() != null)
            {
                this.getlabel$LabelSessionBean().setVisualizeHistoryLabel(true);
                this.getlabel$LabelSessionBean().setBanderaInit(false);
                this.getlabel$LabelSessionBean().setCurrentSpecimenDTO(selectedSpecimens.get(0));

                return "edit";
                
            }
            else
            {
               MessageBean.setErrorMessageFromBundle("errorNotLabelAsociated", this.getMyLocale());
               return null;
            }
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }


     /*
     * Action del boton de editar espécimen
     * @return
     */
    public String btn_generation_action() {

        
        this.getlabel$LabelSessionBean().setAdvancedSearch(false); //Ojo: esto es para que cuando el usuario presione volver, el boton de busqueda avanzada funcione correctamente
        int n = this.getDataTableSpecimens().getRowCount();

        //arrays of selectedSpecimen
        ArrayList<SpecimenDTO> selectedSpecimens = new ArrayList();
        
        for (int i = 0; i < n; i++) { //get selected specimen
            this.getDataTableSpecimens().setRowIndex(i);
            SpecimenDTO thisSpecimen = (SpecimenDTO) this.getDataTableSpecimens().getRowData();
            if (thisSpecimen.isSelected()) {
                selectedSpecimens.add(thisSpecimen);
            }
        }
        if(selectedSpecimens == null || selectedSpecimens.size() == 0){ //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
          
            System.out.println("..........ltipleusize m......");
            this.getlabel$LabelSessionBean().setCurrenSpecimensDTOList(selectedSpecimens);
            this.getlabel$LabelSessionBean().setBanderaInit(false);
            System.out.println("..........ltipleusize m......");
            return "generate";
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
    public String btnCleanForm() {

         //Reestablecer los valores por defecto de los drop downs
           this.getlabel$LabelSessionBean().setSelectedInstitution(null);
           this.getlabel$LabelSessionBean().setSelectedCountry(null);
           this.getlabel$LabelSessionBean().setSelectedProvince(null);
           this.getlabel$LabelSessionBean().setSelectedResponsableName(null);
           this.getlabel$LabelSessionBean().setSelectedIdentificator(null);
           this.getlabel$LabelSessionBean().setSelectedIdentificator(null);
           this.getlabel$LabelSessionBean().setSelectedResponsible(null);
           this.getlabel$LabelSessionBean().setSelectedTaxonomicalRange(null);

          
         //Reestablecer los valores por defecto de los textfields
           this.getTxCatalogNumberFirst().setText(null);
           this.getTxCatalogNumberEnd().setText(null);
           this.getTxGatheringDetailNumberEnd().setText(null);
           this.getTxGatheringDetailNumberFirst().setText(null);
           this.getTxGatheringObservationEnd().setText(null);
           this.getTxGatheringObservationFirst().setText(null);
           this.getTxLatitudeShort().setText(null);
           this.getTxLongitudeShort().setText(null);
           this.getTxRadio().setText(null);
           this.getTxLocality().setText(null);

           
           this.getTxTaxonName().setText(null);


        return null;
    }

    /**
     * Accion del boton de buscar que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnSpecimenSearchAdv() {

        
        //Crear el specimenDTO para la consulta
        SpecimenDTO consulta = new SpecimenDTO();

        //values of latitude and longitude
        Double latitude_short = null;
        Double longitude_short = null;
        Integer radio = null;
        //level taxonomic
        String  taxonLevel = null;


        Long initialGathObserDetail = null;
        Long finalGathObserDetail = null;
        Long initialGathObser = null;
        Long finalGathObser = null;
        Long valuerPersonId = null;





        //campos de texto
        String catalogFirst = (String) this.getTxCatalogNumberFirst().getText();
        String catalogEnd = (String) this.getTxCatalogNumberEnd().getText();
        String gathObsrDetailFirst = (String) this.getTxGatheringDetailNumberFirst().getText();
        String gathObsrDetailEnd=  (String) this.getTxGatheringDetailNumberEnd().getText();

        String gathObsrFirst  = (String) this.getTxGatheringObservationFirst().getText();
        String gathObsrEnd  =  (String) this.getTxGatheringObservationEnd().getText();

        String taxon = (String) this.getTxTaxonName().getText();
        String locality = (String) this.getTxLocality().getText();

       


        // dd
        Object institution = this.getDdInstitutionCode().getSelected();
        Object country = this.getDdCountry().getSelected();
        Object province = this.getDdProvince().getSelected();
        Object responsible = this.getDdResponsible().getSelected();
        Object valuerPerson = this.getDdIdentificator().getSelected();
        Object taxonomicalLevel = this.getDdTaxonomicalRange().getSelected();


        GregorianCalendar iniCal = new GregorianCalendar();
        GregorianCalendar finCal = new GregorianCalendar();
        Date iniDate = this.getInitial_date().getSelectedDate();
        Date finDate = this.getFinal_date().getSelectedDate();

        if(iniDate!=null){
            iniCal.setTime(iniDate);
            this.getlabel$LabelSessionBean().setInitialDate(iniCal);
        }
        else
        {
            iniCal = null;
            this.getlabel$LabelSessionBean().setInitialDate(null);
        }
        
        if(finDate!=null){
            finCal.setTime(finDate);
            this.getlabel$LabelSessionBean().setFinalDate(finCal);
        }
        {
            finCal = null;
            this.getlabel$LabelSessionBean().setFinalDate(null);
        }

     
            
   
       
        //verificaciones

        if(catalogFirst!=null)
            consulta.setCatalogNumber(catalogFirst);
        
        if(catalogEnd != null)
               this.getlabel$LabelSessionBean().setCatalogNumberEnd(catalogEnd);
        
        if(locality!=null)
            consulta.setLocalityDescription(locality);

        if(institution!=null)
            consulta.setInstitutionId((Long)institution);

        if(country!=null)
            consulta.setCountryId((Long)country);

        if(province!=null)
            consulta.setProvinceId((Long)province);

        if(responsible!=null)
        {
           consulta.setResponsibleId((Long)responsible);

            try
            {

               if(gathObsrDetailFirst != null)
               {
                initialGathObserDetail =  Long.parseLong(gathObsrDetailFirst);
                this.getlabel$LabelSessionBean().setInitialGathObserDetail(initialGathObserDetail);
               }

               if(gathObsrDetailEnd != null)
               {
                 finalGathObserDetail =  Long.parseLong(gathObsrDetailEnd);
                 this.getlabel$LabelSessionBean().setFinalGathObserDetail(finalGathObserDetail);
               }

          }
          catch(Exception e)
          {

             MessageBean.setErrorMessageFromBundle("error_coordinates_search", this.getMyLocale());
          }

        }

        if(valuerPerson != null)
        {
            valuerPersonId  = (Long) valuerPerson;
            this.getlabel$LabelSessionBean().setIdentificatorSpecimenId(valuerPersonId);
        }


        if(taxonomicalLevel!=null  &&  taxon!=null)
        {
                taxonLevel =   (String) taxonomicalLevel;
                consulta.setTaxonName(taxon);
                this.getlabel$LabelSessionBean().setTaxonomicalLevel(taxonLevel);
        }
        
        if(gathObsrFirst != null)
        {
            initialGathObser  =  Long.parseLong(gathObsrFirst);

            this.getlabel$LabelSessionBean().setInitialGathObser(initialGathObser);
            if(gathObsrEnd != null)
            {
               finalGathObser =  Long.parseLong(gathObsrEnd);
               this.getlabel$LabelSessionBean().setFinalGathObser(finalGathObser);
            }    
        }

        // evalue information 
        try
        {

            latitude_short = Double.valueOf(this.getTxLatitudeShort().getText().toString());
            longitude_short = Double.valueOf(this.getTxLongitudeShort().getText().toString());
            radio = Integer.valueOf(this.getTxRadio().getText().toString());
        }
        catch(Exception e){
            
             //MessageBean.setErrorMessageFromBundle("error_coordinates_search", this.getMyLocale());
        }

        

        if(latitude_short!=null&&longitude_short!=null&&radio!=null)
        {
            consulta.setLatitude(latitude_short);
            consulta.setLongitude(longitude_short);
            consulta.setRadio(radio);
        }

       

   
        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        consulta.setCollectionId(currentCollection);
        

        //Setear el SpecimenDTO del SessionBean utilizado para realizar la consulta
        this.getlabel$LabelSessionBean().setQuerySpecimenDTO(consulta);
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getlabel$LabelSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getlabel$LabelSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta

        System.out.println(iniCal  +  "fecha inicial ");
        System.out.println(finCal  +  "fecha final ");
        this.getlabel$LabelSessionBean().getPagination().setTotalResults(this.getlabel$LabelSessionBean().getSearchFacade().countSpecimensByCriteria(consulta, taxonLevel, catalogEnd, initialGathObserDetail, finalGathObserDetail, initialGathObser, finalGathObser, iniCal,finCal,valuerPersonId).intValue());
        this.getlabel$LabelSessionBean().getPagination().firstResults();
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
            this.getlabel$LabelSessionBean().setQueryModeSimple(false);
            this.getlabel$LabelSessionBean().setQueryMode(false);
            //Finalmente se setea el data provider del paginador con los datos por default
            this.getlabel$LabelSessionBean().getPagination().setTotalResults(this.getlabel$LabelSessionBean().getInventoryFacade().countSpecimens().intValue());
        }
        else
         {
            //Setear el string para consulta simple del SessionBean
            this.getlabel$LabelSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getlabel$LabelSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getlabel$LabelSessionBean().setQueryMode(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            this.getlabel$LabelSessionBean().getPagination().setTotalResults(this.getinventory$SpecimenSessionBean().getSearchFacade().countSpecimensByCriteria(userInput).intValue());
        }
        this.getlabel$LabelSessionBean().getPagination().firstResults();
        return null;
    }

    /**
     * Accion del boton que habilita y deshabilita el panel de busqueda avanzada
     * @return
     */
    
    public String btnAdvSpecimenSearc_action() {
        boolean advanced = getlabel$LabelSessionBean().isAdvancedSearch();

        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getlabel$LabelSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSeach().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getlabel$LabelSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSeach().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen",getMyLocale()));
             
            //Reestablecer los valores por defecto de los drop downs
            this.getlabel$LabelSessionBean().setSelectedInstitution(null);
            this.getlabel$LabelSessionBean().setSelectedCountry(null);
            this.getlabel$LabelSessionBean().setSelectedProvince(null);
            //Reestablecer los valores por defecto de los textfields
            this.getTxCatalogNumberFirst().setText(null);
            this.getTxLatitudeShort().setText(null);
            this.getTxLongitudeShort().setText(null);
            this.getTxRadio().setText(null);
            this.getTxLocality().setText(null);
            //this.getTxResponsible().setText(null);
            this.getTxTaxonName().setText(null);
        }
        return null;
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public void SetInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.getlabel$LabelSessionBean().SetInstitutionDropDownData();
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
        List<GeographicLayerDTO> geoDTOList = this.getlabel$LabelSessionBean().SetProvincesDropDownData();
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
        List<GeographicLayerDTO> geoDTOList = this.getlabel$LabelSessionBean().SetCountryDropDownData();
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
     * 
     */
     public void SetTaxonomicLevelData() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        Option[] allOptionsInArray = null;
        String optionTitle = null;
        Option option = null;

        List<TaxonomicalRangeDTO> aTRList = isb.getTaxonomicalRangeList();



        ArrayList<Option> allOptions = new ArrayList<Option>();

        optionTitle = BundleHelper.getDefaultBundleValue("drop_down_default",
                                                         getMyLocale());

        //Crear opcion titulo
        option = new OptionTitle(optionTitle);

        allOptions.add(option);

        //Crear todas las opciones del drop down
        for (TaxonomicalRange ta : TaxonomicalRange.values()) {
            option = new Option(ta.getKey(),ta.getTaxomicalRange());
           
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.ddTaxonomicalRangeData.setOptions(allOptions.toArray(allOptionsInArray));

    }

       /**
     * Obtener los datos del drop down de responsables  de las coletcas
     *
     */
    public void  SetResponsibleDropDownData(){
        List<PersonDTO> instDTOList = this.getlabel$LabelSessionBean().SetResponsibleDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : instDTOList){
            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];

        this.getResponsibleData().setOptions(allOptions.toArray(allOptionsInArray));
        this.getIdentificatorData().setOptions(allOptions.toArray(allOptionsInArray));
    }


    /**
     * @return the ddResponsible
     */
    public DropDown getDdResponsible() {
        return ddResponsible;
    }

    /**
     * @param ddResponsible the ddResponsible to set
     */
    public void setDdResponsible(DropDown ddResponsible) {
        this.ddResponsible = ddResponsible;
    }

    /**
     * @return the responsibleData
     */
    public SingleSelectOptionsList getResponsibleData() {
        return responsibleData;
    }

    /**
     * @param responsibleData the responsibleData to set
     */
    public void setResponsibleData(SingleSelectOptionsList responsibleData) {
        this.responsibleData = responsibleData;
    }

     /**
     * @return the txGatheringDetailNumberFirst
     */
    public TextField getTxGatheringDetailNumberFirst() {
        return txGatheringDetailNumberFirst;
    }

    /**
     * @param txGatheringDetailNumberFirst the txGatheringDetailNumberFirst to set
     */
    public void setTxGatheringDetailNumberFirst(TextField txGatheringDetailNumberFirst) {
        this.txGatheringDetailNumberFirst = txGatheringDetailNumberFirst;
    }


    /**
     * @param txGatheringDetailNumberEnd the txGatheringDetailNumberEnd to set
     */
    public void setTxGatheringDetailNumberEnd(TextField txGatheringDetailNumberEnd) {
        this.txGatheringDetailNumberEnd = txGatheringDetailNumberEnd;
    }

    /**
     * @param txGatheringObservationFirst the txGatheringObservationFirst to set
     */
    public void setTxGatheringObservationFirst(TextField txGatheringObservationFirst) {
        this.txGatheringObservationFirst = txGatheringObservationFirst;
    }

    /**
     * @param txGatheringObservationEnd the txGatheringObservationEnd to set
     */
    public void setTxGatheringObservationEnd(TextField txGatheringObservationEnd) {
        this.txGatheringObservationEnd = txGatheringObservationEnd;
    }

    /**
     * @return the txGatheringDetailNumberEnd
     */
    public TextField getTxGatheringDetailNumberEnd() {
        return txGatheringDetailNumberEnd;
    }

    /**
     * @return the txGatheringObservationFirst
     */
    public TextField getTxGatheringObservationFirst() {
        return txGatheringObservationFirst;
    }

    /**
     * @return the txGatheringObservationEnd
     */
    public TextField getTxGatheringObservationEnd() {
        return txGatheringObservationEnd;
    }

    /**
     * @return the txCatalogNumberEnd
     */
    public TextField getTxCatalogNumberEnd() {
        return txCatalogNumberEnd;
    }

    /**
     * @param txCatalogNumberEnd the txCatalogNumberEnd to set
     */
    public void setTxCatalogNumberEnd(TextField txCatalogNumberEnd) {
        this.txCatalogNumberEnd = txCatalogNumberEnd;
    }

    /**
     * @return the txCatalogNumberFirst
     */
    public TextField getTxCatalogNumberFirst() {
        return txCatalogNumberFirst;
    }

    /**
     * @param txCatalogNumberFirst the txCatalogNumberFirst to set
     */
    public void setTxCatalogNumberFirst(TextField txCatalogNumberFirst) {
        this.txCatalogNumberFirst = txCatalogNumberFirst;
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
     * @return the ddIdentificator
     */
    public DropDown getDdIdentificator() {
        return ddIdentificator;
    }

    /**
     * @param ddIdentificator the ddIdentificator to set
     */
    public void setDdIdentificator(DropDown ddIdentificator) {
        this.ddIdentificator = ddIdentificator;
    }

    /**
     * @return the identificatorData
     */
    public SingleSelectOptionsList getIdentificatorData() {
        return identificatorData;
    }

    /**
     * @param identificatorData the identificatorData to set
     */
    public void setIdentificatorData(SingleSelectOptionsList identificatorData) {
        this.identificatorData = identificatorData;
    }

}
