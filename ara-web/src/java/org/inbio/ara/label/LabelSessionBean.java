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


import javax.ejb.EJB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;
import org.inbio.ara.util.TypeLabels;
import org.inbio.ara.util.PrintLabel;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.label.HistoryLabelDTO;
import org.inbio.ara.inventory.IdentificationSessionBean;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import org.inbio.ara.dto.label.LabelDTO;
import org.inbio.ara.dto.label.OriginalLabelDTO;
import org.inbio.ara.facade.label.LabelFacadeRemote;
import java.util.GregorianCalendar;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.facade.format.FormatFacadeRemote;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SessionBean1.java
 * @version Created on 25/01/2010, 09:27:39 AM
 * @author pcorrales
 */

public class LabelSessionBean extends AbstractSessionBean
implements Serializable,PaginationCoreInterface {


     //Injections
    @EJB
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;
    @EJB
    private GisFacadeRemote gisFacade;
    @EJB
    private SearchFacadeRemote searchFacade;
    @EJB
    private LabelFacadeRemote labelFacade;
    @EJB
    private FormatFacadeRemote formatFacade;

    //Objeto que controla la paginacion de la informacion de specimen
    private PaginationControllerRemix pagination = null;

    private  PrintLabel printLabel =  new PrintLabel();

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //Bandera que indica si el especimen es valido para ser persistido
    private boolean visualizeHistoryLabel = false;
    //Bandera que indica si el especimen es valido para ser persistido
    private boolean visualizeCorrectionLabel = false;
    //Bandera que indica si el especimen es valido para ser persistido
    private boolean specimenValid = true;

    //Value binding para los drop downs
    private Long selectedInstitution = null;
    private Long selectedCountry = null;
    private Long selectedProvince = null;
    private Long selectedDiscarded;
    private Long selectedResponsible = null;
    private Long selectedIdentificator= null;
    private Long selectedTypeLabel = null;
    private Long selectedTypeFormat= null;
    private Long selectedTaxonomicalRange = null;

    
    private Long initialGathObserDetail;
    private Long finalGathObserDetail;

    private Long initialGathObser;
    private Long finalGathObser;

    private Long identificatorSpecimenId;

    private GregorianCalendar initialDate;
    private GregorianCalendar finalDate;

    private String selectedTaxonomicalRangeName;
    private String selectedResponsableName = null;
    
    private String taxonomicalLevel;
    private String catalogNumberEnd;


   private   boolean banderaInit;

    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");
 

    //Specimen DTO seleccionado por el usuario para editar o generar etiquetas
    private SpecimenDTO currentSpecimenDTO = new SpecimenDTO();


    //Specimen DTO seleccionado por el usuario para editar o generar etiquetas
    private LabelDTO currentLabelReviserDTO = new LabelDTO ();


    //Specimen DTO seleccionado por el usuario para editar o generar etiquetas
    private HistoryLabelDTO currentLabelHistoryDTO = new HistoryLabelDTO();


    //Specimen DTO seleccionado por el usuario para editar o generar etiquetas
    private LabelDTO currentOriginalLabelDTO = new LabelDTO ();

   

    //Specimen DTO selected by the user
    private SpecimenDTO querySpecimenDTO = new SpecimenDTO();


    //list of selected specimen
    private ArrayList<SpecimenDTO> currenSpecimensDTOList = new ArrayList();
    private ImageIcon printImage = null;
    private File currentFile = null;




    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */


    private void _init() throws Exception {

         // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
            this.setSelectedDiscarded(new Long(1));
    }
    // </editor-fold>


    
    //list of elements
    private AddRemoveList arDarwinCoreElements = new AddRemoveList();

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public LabelSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }


    /**
     *  This funcion init the data provider
     */
    public void initDataProvider()
    {
        
        // BanderaInit :  this flag control the type of  elements of the pagination control( specimen or label)

        //pagination control  ->specimen
       if(this.isBanderaInit())
        {
            this.setPagination(new PaginationControllerRemix(this.getInventoryFacade().countSpecimens().intValue(),this.getQuantity(), this));
        }

        //pagination control  ->label
        else
        {
           //pagination control of history history label
           if(this.isVisualizeHistoryLabel() == true)
              this.setPagination(new PaginationControllerRemix(this.getLabelFacade().countLabels().intValue(),this.getQuantity(), this));
           //pagination control of  label
           else if(this.isVisualizeCorrectionLabel()== true)
              this.setPagination(new PaginationControllerRemix(this.getLabelFacade().countLabels().intValue(),this.getQuantity(), this));
        }
    }

    /**
     * @return the labelFacade
     */
    public LabelFacadeRemote getLabelFacade() {
        return this.labelFacade;
    }

    /**
     * @param labelFacade the labelFacade to set
     */
    public void setLabelFacade(LabelFacadeRemote labelFacade) {
        this.labelFacade = labelFacade;
    }

 
     /**
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;

    }

    /**
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

  
    /**
     * @return the printImage
     */
    public ImageIcon getPrintImage() {
        return printImage;
    }

    /**
     * @param printImage the printImage to set
     */
    public void setPrintImage(ImageIcon printImage) {
        this.printImage = printImage;
    }

    /**
     * @return the arDarwinCoreElements
     */
    public AddRemoveList getArDarwinCoreElements() {
        return arDarwinCoreElements;
    }


     /**
     *
     * @return String, the containst  the pagunation controler  describe
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  | "+totalResults+"  ";
    }

    /**
     * @return the inventoryFacade
     */
    public InventoryFacadeRemote getInventoryFacade() {
        return inventoryFacade;
    }

    /**
     * @param inventoryFacade the inventoryFacade to set
     */
    public void setInventoryFacade(InventoryFacadeRemote inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
    }

    /**
     * @return the quantity
     */
    public //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the advancedSearch
     */
    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

   /**
     *   get the items  Institutions
     */
    public List<InstitutionDTO> SetInstitutionDropDownData(){
         return this.getAdminFacade().getAllInstitutions();
    }

    /**
     * get the items  of ReportLayout Format
     */
    public List<ReportLayoutDTO> SetReportLayoutDropDownData(){

       //the  labelsFormat is a  funcionality  number1, see  ReportLayourCategorie
       Long funcionality =  new Long(1);

        if(funcionality == 1)
          return  this.getFormatFacade().getAllReportLayout(funcionality);

        else
            return null;
    }


    /**
     *   get the items  of ReportLayout Format
     */
    public List<CollectionDTO> SetCollectionDropDownData(){
         return this.getAdminFacade().getAllCollections();
    }

     /**
     *  This funcionality is  call by the  el drop down dod country, because it need to calculte the province or states of the selected country
     */
    public List<GeographicLayerDTO> SetProvincesDropDownData(){
        if(this.getSelectedCountry()==null){
            return null;
        }
        else{
            Long countryid = new Long(this.getSelectedCountry());
            return this.getGisFacade().getProvincesByCountry(countryid);
        }
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public List<GeographicLayerDTO> SetCountryDropDownData(){
        return this.getGisFacade().getAllCountries();
    }

     /**
     * Obtener los datos para los drop downs de listas de seleccion
     */
    public List<SelectionListDTO> setSelectionListDropDownData(Long selectionListEntityId,Long collection){
        return this.getInventoryFacade().getAllSelectionListElementsByCollection(selectionListEntityId, collection);
    }

    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * @return the adminFacade
     */
    public AdminFacadeRemote getAdminFacade() {
        return adminFacade;
    }

    /**
     * @param adminFacade the adminFacade to set
     */
    public void setAdminFacade(AdminFacadeRemote adminFacade) {
        this.adminFacade = adminFacade;
    }

    /**
     * @return the gisFacade
     */
    public GisFacadeRemote getGisFacade() {
        return gisFacade;
    }

    /**
     * @param gisFacade the gisFacade to set
     */
    public void setGisFacade(GisFacadeRemote gisFacade) {
        this.gisFacade = gisFacade;
    }

    /**
     * @return the selectedInstitution
     */
    public Long getSelectedInstitution() {
        return selectedInstitution;
    }

    /**
     * @param selectedInstitution the selectedInstitution to set
     */
    public void setSelectedInstitution(Long selectedInstitution) {
        this.selectedInstitution = selectedInstitution;
    }

    /**
     * @return the selectedCountry
     */
    public Long getSelectedCountry() {
        return selectedCountry;
    }

    /**
     * @param selectedCountry the selectedCountry to set
     */
    public void setSelectedCountry(Long selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    /**
     * @return the selectedProvince
     */
    public Long getSelectedProvince() {
        return selectedProvince;
    }

    /**
     * @param selectedProvince the selectedProvince to set
     */
    public void setSelectedProvince(Long selectedProvince) {
        this.selectedProvince = selectedProvince;
    }

    /**
     * @return the currentSpecimenDTO
     */
    public SpecimenDTO getCurrentSpecimenDTO() {
        return currentSpecimenDTO;
    }

    /**
     * @param currentSpecimenDTO the currentSpecimenDTO to set
     */
    public void setCurrentSpecimenDTO(SpecimenDTO currentSpecimenDTO) {
        this.currentSpecimenDTO = currentSpecimenDTO;
    }

    /**
     * @return the querySpecimenDTO
     */
    public SpecimenDTO getQuerySpecimenDTO() {
        return querySpecimenDTO;
    }

    /**
     * @param querySpecimenDTO the querySpecimenDTO to set
     */
    public void setQuerySpecimenDTO(SpecimenDTO querySpecimenDTO) {
        this.querySpecimenDTO = querySpecimenDTO;
    }

    /**
     * @return the queryMode
     */
    public boolean isQueryMode() {
        return queryMode;
    }

    /**
     * @param queryMode the queryMode to set
     */
    public void setQueryMode(boolean queryMode) {
        this.queryMode = queryMode;
    }

    /**
     * @return the selectedDiscarded
     */
    public Long getSelectedDiscarded() {
        return selectedDiscarded;
    }

    /**
     * @param selectedDiscarded the selectedDiscarded to set
     */
    public void setSelectedDiscarded(Long selectedDiscarded) {
        this.selectedDiscarded = selectedDiscarded;
    }

    /**
     * @return the queryModeSimple
     */
    public boolean isQueryModeSimple() {
        return queryModeSimple;
    }
    
    /**
     * @param queryModeSimple the queryModeSimple to set
     */
    public void setQueryModeSimple(boolean queryModeSimple) {
        this.queryModeSimple = queryModeSimple;
    }

    /**
     * @return the consultaSimple
     */
    public String getConsultaSimple() {
        return consultaSimple;
    }

    /**
     * @param consultaSimple the consultaSimple to set
     */
    public void setConsultaSimple(String consultaSimple) {
        this.consultaSimple = consultaSimple;
    }

    /**
     * @return the specimenValid
     */
    public boolean isSpecimenValid() {
        return specimenValid;
    }

    /**
     * @param specimenValid the specimenValid to set
     */
    public void setSpecimenValid(boolean specimenValid) {
        this.specimenValid = specimenValid;
    }

    /**
     * @return the searchFacade
     */
    public SearchFacadeRemote getSearchFacade() {
        return searchFacade;
    }

    
    /**
     * @param searchFacade the searchFacade to set
     */
    public void setSearchFacade(SearchFacadeRemote searchFacade) {
        this.searchFacade = searchFacade;
    }

    
    /**
     * @param arDarwinCoreElements the arDarwinCoreElements to set
     */
    public void setArDarwinCoreElements(AddRemoveList arDarwinCoreElements) {
        this.arDarwinCoreElements = arDarwinCoreElements;
    }

       /**
     * @return the selectedTypeLabel
     */
    public Long getSelectedTypeLabel() {
        return selectedTypeLabel;
    }

    /**
     * @param selectedTypeLabel the selectedTypeLabel to set
     */
    public void setSelectedTypeLabel(Long selectedTypeLabel) {
        this.selectedTypeLabel = selectedTypeLabel;
    }

    /**
     * @return the selectedTypeFormat
     */
    public Long getSelectedTypeFormat() {
        
        return selectedTypeFormat;
    }

    /**
     * @param selectedTypeFormat the selectedTypeFormat to set
     */
    public void setSelectedTypeFormat(Long selectedTypeFormat) {
        this.selectedTypeFormat = selectedTypeFormat;
    }

    /**
     * @return the selectedResponsible
     */
    public Long getSelectedResponsible() {
        return selectedResponsible;
    }

    /**
     * @param selectedResponsible the selectedResponsible to set
     */
    public void setSelectedResponsible(Long selectedResponsible) {
        this.selectedResponsible = selectedResponsible;
    }

    /**
     * Obtener los datos para el drop down de responsables
     */
    public List<PersonDTO> SetResponsibleDropDownData() {
        /*if (this.getResponsibleData() == null) {
            this.setResponsibleData(inventoryFacade.getAllResponsibles());
            return this.getResponsibleData();
        } else {
            return this.getResponsibleData();
        }*/
        return inventoryFacade.getAllResponsibles();
    }


    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l){
        if(l==null)
            return new ArrayList<SpecimenDTO>();
        else
            return l;
    }

    /**
     * @return the pagination
     */
    public PaginationControllerRemix getPagination() {
        return pagination;
    }

 
    /**
     * @return the selectedTaxonomicalRange
     */
    public Long getSelectedTaxonomicalRange() {
        return selectedTaxonomicalRange;
    }

    /**
     * @param selectedTaxonomicalRange the selectedTaxonomicalRange to set
     */
    public void setSelectedTaxonomicalRange(Long selectedTaxonomicalRange) {
        this.selectedTaxonomicalRange = selectedTaxonomicalRange;
    }

    /**
     * @return the selectedResponsableName
     */
    public String getSelectedResponsableName() {
        return selectedResponsableName;
    }

    /**
     * @param selectedResponsableName the selectedResponsableName to set
     */
    public void setSelectedResponsableName(String selectedResponsableName) {
        this.selectedResponsableName = selectedResponsableName;
    }


    /**
     * @return the selectedTaxonomicalRangeName
     */
    public String getSelectedTaxonomicalRangeName() {
        return selectedTaxonomicalRangeName;
    }

    /**
     * @param selectedTaxonomicalRangeName the selectedTaxonomicalRangeName to set
     */
    public void setSelectedTaxonomicalRangeName(String selectedTaxonomicalRangeName) {
        this.selectedTaxonomicalRangeName = selectedTaxonomicalRangeName;
    }

    /**
     * @return the currenSpecimensDTOList
     */
    public ArrayList<SpecimenDTO> getCurrenSpecimensDTOList() {
        return currenSpecimensDTOList;
    }

    /**
     * @param currenSpecimensDTOList the currenSpecimensDTOList to set
     */
    public void setCurrenSpecimensDTOList(ArrayList<SpecimenDTO> currenSpecimensDTOList) {
        this.currenSpecimensDTOList = currenSpecimensDTOList;
    }


   /**
    * @param pagination the pagination to set
    */
    public void setPagination(PaginationControllerRemix pagination) {
        this.pagination = pagination;
    }


    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }


    protected IdentificationSessionBean getIdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
    }
    

   /******************************************************************
    * methods of  creation label
    *******************************************************************/


   /**
    * This method calls the methods responsible for communicating with the class label generation
    * who is responsible for generating or print the label where the specimens selected
    * @param   format Id
    *          type of Label
    * @return
    */
   public boolean createLabels(Long formatId, Long typeLabelId,String contents)
    {

        boolean result = false;
        this.setSelectedTypeFormat(formatId);

        //the actual label
        if (typeLabelId.equals(TypeLabels.LABEL.getId()))
        {
              result =  this.createActualLabels();
        }
        //label  type erase,  it's not save only print
        else if (typeLabelId.equals(TypeLabels.ERASE_LABEL.getId()))
        {
             result =   this.createEraserLabel();
        }

       return result;
    }


    /**no Implementado*/
    public  boolean  createEraserLabel()
    {
             return true;
    }


   /**
    * This funcionality  support the create of one or more labels, get all the specimen selected  and invoke the creation of label
    * @return
    */
   public boolean createActualLabels()
   {
       int n = this.getCurrenSpecimensDTOList().size();

       for (int i = 0; i < n; i++)
       {
           this.setCurrentSpecimenDTO(this.getCurrenSpecimensDTOList().get(i));
           
           if(this.getCurrentSpecimenDTO() !=  null)
           {
                // create the individual label
                this.createActualLabel();
           }
       }
       return true;
   }

   
    
   /**
    * Created the  actual label of specimen information and update the history Label
    * and link with the  specimen
    */
    public void createActualLabel()
    {
        try
        {
             // first time generated  the label
            if(this.getCurrentSpecimenDTO().getLabelId() == null)
            {
                //create original and label
                LabelDTO labelDTO = new LabelDTO();

                //parser the format and set the contents
                String contentsLabel =  this.parserReportLayout(this.getSelectedTypeFormat());
                labelDTO.setLabelTypeId(TypeLabels.LABEL.getId());
                labelDTO.setContents(contentsLabel);
                
                //set registered user
                labelDTO.setUserName(this.getAraSessionBean().getGlobalUserName());

                //create the original label
                Long  labeld =  this.getLabelFacade().saveLabel(labelDTO);

                //save the specimen
                this.getCurrentSpecimenDTO().setLabelId(labeld);

                //create and save the specimen
                this.createOriginalLabel(contentsLabel);
            }

            // update the label and created the historyLabel
            else
            {
                this.updateLabel();
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(LabelSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /***
     * This method create a special  type of label,  
     * @param contentsLabel
     */
    public void createOriginalLabel(String contentsLabel)
    {
        //create original and label
        OriginalLabelDTO originalLabelDTO = new OriginalLabelDTO();
        originalLabelDTO.setContents(contentsLabel);


        //set the user who create the labels
        originalLabelDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
       

        //create the original label
        Long  originalLabelId =  this.getLabelFacade().saveOriginalLabel(originalLabelDTO);

        //save the specimen ,  this DTO contains the label ID's original and actual Label
        this.getCurrentSpecimenDTO().setOriginalLabelId(originalLabelId);
        this.getIdentificationSessionBean().getInventoryFacade().saveSpecimen(this.getCurrentSpecimenDTO());
    }
    
    
    /**
     * This method create a special  type of label
     * @param contentsLabel
     */
    public void createCorrectionLabel(String contents)
    {
           //create original and label
           LabelDTO labelDTO = new LabelDTO();

           //parser the format and set the contents
           String contentsLabel =  contents;  //todo ver como parsear y darle un formato
           labelDTO.setLabelTypeId(TypeLabels.CORRECTION_LABEL.getId());
           labelDTO.setContents(contentsLabel);
           labelDTO.setAncestorLabelId(this.getCurrentSpecimenDTO().getLabelId());

            
           //setear  el user registrado
           labelDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
           this.getLabelFacade().saveLabel(labelDTO);
    }


    
   /**
    * created tha  history  label of specimen
    * this method  get all the correct labels
    */
    public void createHistoryLabel(Long labelId)
    {
        try
        {
                       
             LabelDTO  labelDTO =  this.labelFacade.findByLabelId(labelId);
             
             //find the label asocited with teh specimen
             List<Long> listita = this.getLabelFacade().findByLabelTypeId(TypeLabels.CORRECTION_LABEL.getId(),labelDTO.getInitialTimestand(),labelDTO.getFinalTimestand());

             String contents = labelDTO.getContents();

              //geth all the  correct  and add to history label
              for(int x = 0; x  < listita.size();x ++)
              {
                 //get the correct label
                 Long  llave =  listita.get(x);
                 LabelDTO label =  this.labelFacade.findByLabelId(llave);
                 contents += label.getContents();
                 
              }
             //label actual
             HistoryLabelDTO historyLabelDTO = new HistoryLabelDTO();
             historyLabelDTO.setLabelId(labelId);
             historyLabelDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
             historyLabelDTO.setContents(contents);   // reviser contents
                 
             this.getLabelFacade().saveHistoryLabel(historyLabelDTO);
             
        }
        catch (Exception ex)
        {
            Logger.getLogger(LabelSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    


    /**
     * Method responsible to update the contents of specimen Label
     * is used when  reidentificate the specimen
     */
    public void updateLabel()
    {
        
        //find the label asocited with the specimen
        LabelDTO  labelDTO =  this.labelFacade.findByLabelId(this.currentSpecimenDTO.getLabelId());

        //create the historical label
        this.createHistoryLabel(labelDTO.getLabelId());

        //parser the format and set the contents
        String contentsLabelUpdate = this.parserReportLayout(this.getSelectedTypeFormat());
        labelDTO.setContents(contentsLabelUpdate );
        labelDTO.setUserName(this.getAraSessionBean().getGlobalUserName());

        //update the label
        this.getLabelFacade().updateLabel(labelDTO);      
    }


    /***
    * This method communicates with the facade of formats and allows processing of a specific format to generate labels
    * @param formatId
    * @return
    */
   public String  parserReportLayout(Long formatId)
   {
       return this.getFormatFacade().processReportLayout(this.getSelectedTypeFormat(), this.getCurrentSpecimenDTO());
   }
    


   /**
    * get the actual  label where the selected specimen
    * @return
    */
    public LabelDTO findLabelById()
    {
        return this.labelFacade.findByLabelId(this.currentSpecimenDTO.getLabelId());
    }


    /**
     * get the  original label where the selected specimen
     * @return
     */
    public OriginalLabelDTO findOriginalLabelById()
    {
        return this.labelFacade.findByOriginalLabelId(this.currentSpecimenDTO.getOriginalLabelId());
    }



    /**
     * Print the labels of selected specimen in the default printer
     */
    public void PrintLabel ()
    {
          /**get the selected  specimen  and the information of format*/
         
        
          List specimenLabelData = this.getFormatFacade().processReportLayout(this.getSelectedTypeFormat(), this.getCurrenSpecimensDTOList());
          this.getPrintLabel().StartPrinting(specimenLabelData);
    }

   
     
    /**
     * @return the visualizeHistoryLabel
     */
    public boolean isVisualizeHistoryLabel() {
        return visualizeHistoryLabel;
    }

    /**
     * @param visualizeHistoryLabel the visualizeHistoryLabel to set
     */
    public void setVisualizeHistoryLabel(boolean visualizeHistoryLabel) {
        this.visualizeHistoryLabel = visualizeHistoryLabel;
    }


    /**
     * @return the currentLabelReviserDTO
     */
    public LabelDTO getCurrentLabelReviserDTO() {
        return currentLabelReviserDTO;
    }

    /**
     * @param currentLabelReviserDTO the currentLabelReviserDTO to set
     */
    public void setCurrentLabelReviserDTO(LabelDTO currentLabelReviserDTO) {
        this.currentLabelReviserDTO = currentLabelReviserDTO;
    }

    /**
     * @return the currentLabelHistoryDTO
     */
    public HistoryLabelDTO getCurrentLabelHistoryDTO() {
        return currentLabelHistoryDTO;
    }

    /**
     * @param currentLabelHistoryDTO the currentLabelHistoryDTO to set
     */
    public void setCurrentLabelHistoryDTO(HistoryLabelDTO currentLabelHistoryDTO) {
        this.currentLabelHistoryDTO = currentLabelHistoryDTO;
    }

    /**
     * @return the currentOriginalLabelDTO
     */
    public LabelDTO getCurrentOriginalLabelDTO() {
        return currentOriginalLabelDTO;
    }

    /**
     * @param currentOriginalLabelDTO the currentOriginalLabelDTO to set
     */
    public void setCurrentOriginalLabelDTO(LabelDTO currentOriginalLabelDTO) {
        this.currentOriginalLabelDTO = currentOriginalLabelDTO;
    }

    /**
     * @return the taxonomicalLevel
     */
    public String getTaxonomicalLevel() {
        return taxonomicalLevel;
    }

    /**
     * @param taxonomicalLevel the taxonomicalLevel to set
     */
    public void setTaxonomicalLevel(String taxonomicalLevel) {
        this.taxonomicalLevel = taxonomicalLevel;
    }

    /**
     * @return the catalogNumberEnd
     */
    public String getCatalogNumberEnd() {
        return catalogNumberEnd;
    }

    /**
     * @param catalogNumberEnd the catalogNumberEnd to set
     */
    public void setCatalogNumberEnd(String catalogNumberEnd) {
        this.catalogNumberEnd = catalogNumberEnd;
    }

    /**
     * @return the initialGathObserDetail
     */
    public Long getInitialGathObserDetail() {
        return initialGathObserDetail;
    }

    /**
     * @param initialGathObserDetail the initialGathObserDetail to set
     */
    public void setInitialGathObserDetail(Long initialGathObserDetail) {
        this.initialGathObserDetail = initialGathObserDetail;
    }

    /**
     * @return the finalGathObserDetail
     */
    public Long getFinalGathObserDetail() {
        return finalGathObserDetail;
    }

    /**
     * @param finalGathObserDetail the finalGathObserDetail to set
     */
    public void setFinalGathObserDetail(Long finalGathObserDetail) {
        this.finalGathObserDetail = finalGathObserDetail;
    }


    /**
     * @return the initialGathObser
     */
    public Long getInitialGathObser() {
        return initialGathObser;
    }

    /**
     * @param initialGathObser the initialGathObser to set
     */
    public void setInitialGathObser(Long initialGathObser) {
        this.initialGathObser = initialGathObser;
    }

    /**
     * @return the finalGathObser
     */
    public Long getFinalGathObser() {
        return finalGathObser;
    }

    /**
     * @param finalGathObser the finalGathObser to set
     */
    public void setFinalGathObser(Long finalGathObser) {
        this.finalGathObser = finalGathObser;
    }

    /**
     * @return the banderaInit
     */
    public boolean isBanderaInit() {
        return banderaInit;
    }

    /**
     * @param banderaInit the banderaInit to set
     */
    public void setBanderaInit(boolean banderaInit) {
        this.banderaInit = banderaInit;
    }

    /**
     * @return the selectedIdentificator
     */
    public Long getSelectedIdentificator() {
        return selectedIdentificator;
    }

    /**
     * @param selectedIdentificator the selectedIdentificator to set
     */
    public void setSelectedIdentificator(Long selectedIdentificator) {
        this.selectedIdentificator = selectedIdentificator;
    }



    /**
     * @return the identificatorSpecimenId
     */
    public Long getIdentificatorSpecimenId() {
        return identificatorSpecimenId;
    }

    /**
     * @param identificatorSpecimenId the identificatorSpecimenId to set
     */
    public void setIdentificatorSpecimenId(Long identificatorSpecimenId) {
        this.identificatorSpecimenId = identificatorSpecimenId;
    }

    /**
     * @return the initialDate
     */
    public GregorianCalendar getInitialDate() {
        return initialDate;
    }

    /**
     * @param initialDate the initialDate to set
     */
    public void setInitialDate(GregorianCalendar initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * @return the finalDate
     */
    public GregorianCalendar getFinalDate() {
        return finalDate;
    }

    /**
     * @param finalDate the finalDate to set
     */
    public void setFinalDate(GregorianCalendar finalDate) {
        this.finalDate = finalDate;
    }

    /**
     *
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List getResults(int firstResult, int maxResults) {

            Long collectionId = this.getAraSessionBean().getGlobalCollectionId();

            //list of dto
            List<SpecimenDTO> auxResultSpecimen = new ArrayList<SpecimenDTO>();
            List<LabelDTO> auxResultLabel = new ArrayList<LabelDTO>();
            List<HistoryLabelDTO> auxResultHistoryLabel = new ArrayList<HistoryLabelDTO>();

            if(this.isQueryMode()){ //En caso de que sea busqueda avanzada
                //Set the collectionId into the DTO
                //It is a mandatory filter
                SpecimenDTO s = getQuerySpecimenDTO();
                s.setCollectionId(collectionId);

                try
                {
                    return myReturn(searchFacade.searchSpecimenByCriteria(s, this.getTaxonomicalLevel(),this.getCatalogNumberEnd(), this.getInitialGathObserDetail(),this.getFinalGathObserDetail(),this.getInitialGathObser(),this.getFinalGathObser(), this.getInitialDate(), this.getInitialDate(), this.getIdentificatorSpecimenId(),firstResult, maxResults));
                }
                catch(Exception e){return auxResultSpecimen;}
            }
            else if(this.isQueryModeSimple()){ //En caso de que sea busqueda simple
                try
                {
                    return myReturn(searchFacade.searchSpecimenByCriteria
                            (getConsultaSimple(), collectionId, firstResult,
                            maxResults));
                }
                catch(Exception e){return auxResultSpecimen;}
            }
            else if(this.isVisualizeHistoryLabel()){ //En caso de que se dese visualizar las historicas
                try
                {
                    return myReturn(this.getLabelFacade().getAllLabelHistoryPaginated(firstResult, maxResults,this.getCurrentSpecimenDTO().getLabelId(),collectionId));
                }
                catch(Exception e){return auxResultHistoryLabel;}
            }
            else if(this.isVisualizeCorrectionLabel()){ //En caso de que se dese visualizar los correctores de etiquetas
                try
                {
                    return myReturn(this.getLabelFacade().getAllLabelPaginated(firstResult, maxResults, this.getCurrentSpecimenDTO().getLabelId(),collectionId, TypeLabels.CORRECTION_LABEL.getId()));
                }
                catch(Exception e){return auxResultLabel;}
            }
            else { //Valores default
                try{
                    return myReturn(this.inventoryFacade.getAllSpecimenPaginated(firstResult, maxResults, collectionId));
                }
                catch(Exception e){return auxResultSpecimen;}
            }
    }
    

    public ReportLayoutDTO  getFormatLabel(Long formatId)
    {
       //ReportLayoutDTO report  = this.getFormatFacade().getReportLayoutById(formatId);
       //System.out.println(report.getContents());
        return null;
    }

    /**
     * @return the formatFacade
     */
    public FormatFacadeRemote getFormatFacade() {
        return formatFacade;
    }

    /**
     * @param formatFacade the formatFacade to set
     */
    public void setFormatFacade(FormatFacadeRemote formatFacade) {
        this.formatFacade = formatFacade;
    }

 

    /**
     * @return the visualizeCorrectionLabel
     */
    public boolean isVisualizeCorrectionLabel() {
        return visualizeCorrectionLabel;
    }

    /**
     * @param visualizeCorrectionLabel the visualizeCorrectionLabel to set
     */
    public void setVisualizeCorrectionLabel(boolean visualizeCorrectionLabel) {
        this.visualizeCorrectionLabel = visualizeCorrectionLabel;
    }

    /**
     * @return the printLabel
     */
    public PrintLabel getPrintLabel() {
        return printLabel;
    }

    /**
     * @param printLabel the printLabel to set
     */
    public void setPrintLabel(PrintLabel printLabel) {
        this.printLabel = printLabel;
    }    
}    