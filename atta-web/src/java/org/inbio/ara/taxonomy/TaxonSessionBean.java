/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.dto.taxonomy.PersonAuthorDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorProfileDTO;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.indicator.IndicatorFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.persistence.person.AuthorNameEntity;
import org.inbio.ara.persistence.person.ProfileEntity;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorProfile;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.facade.ara.DublinCoreFacadeRemote;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;
import org.inbio.ara.persistence.person.ProfileEntity;

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
 * @version TaxonSessionBean.java
 * @version Created on 22/07/2010, 11:13:29 AM
 * @author gsulca
 */

public class TaxonSessionBean extends AbstractSessionBean implements PaginationCoreInterface {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injections
      //Injections
    @EJB
    private IndicatorFacadeRemote indicatorFacade;
    @EJB
    private TaxonomyFacadeRemote taxonomyFacade;
    @EJB
    private GisFacadeRemote gisFacade;
    @EJB
    private DublinCoreFacadeRemote dublinCoreFacade;
    @EJB
    private InventoryFacadeRemote inventoryFacade;

    //Objeto que controla la paginacion de las referencias
    private PaginationControllerRemix pagination = null;

    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //Bandera para indicar al paginador que trabaje solo con las relaciones existentes en la BD
    private boolean editMode = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String simpleConsult = new String("");
    //Objeto usado para la consulta del usuario en la búsqueda avanzada
    private DublinCoreDTO queryDublinCoreDTO = new DublinCoreDTO();

    //contiene las referencias seleccionadas por el usuario
    private Map<String, ReferenceDTO> selectedResourcesId = new HashMap<String, ReferenceDTO>();

    /*
     * Map contiene las relaciones existentes en la bd, se carga al cambiar de indicador
     */
    private Map<String, ReferenceDTO> dbRelationsDublinCore = new HashMap<String, ReferenceDTO>();

    private final int DATA_BASE = 0;



    private TaxonDTO currentTaxon = null;

        
    //Nodo actual sobre el que se efectua la acción
    private String taxonNodeId = "0"; //
    //Ruta para llegar al nodo actual desde la raíz
    private String pathTaxonNode = "0"; //

    private String taxonNodeName="";

    //Nodo actual sobre el que se efectua la acción
    private String nodeId = "0"; //
    //Ruta para llegar al nodo actual desde la raíz
    private String pathNode = "0"; //




    private String collecNomenclGroupId = "0";
    private String typeGroup = "0";

    private SelectItem[] months = {new SelectItem(1L),
                                    new SelectItem(2L),
                                    new SelectItem(3L),
                                    new SelectItem(4L),
                                    new SelectItem(5L),
                                    new SelectItem(6L),
                                    new SelectItem(7L),
                                    new SelectItem(8L),
                                    new SelectItem(9L),
                                    new SelectItem(10L),
                                    new SelectItem(11L),
                                    new SelectItem(12L)
                                    };

    /*private Option[] authorType = {new Option(0,"Originales"),
                                    new Option(1,"Modificadores")};
*/
    private Option[] authorType;
    private Long taxonomicalRangeSelected;
    private Long taxonomicalCategorySelected;
    private Long authorTypeSelected = 0L;
    private Long monthSelected = 1L;
    private boolean checkedParentheses;
    private Long authorSelected;

    private String taxonName;
    private String basionymName;
    private Long year;
    private String taxonomicalRangeName = "";
    private int authorListSize = 0;


    private Set<Option> indicatorRelations = new HashSet<Option>();
    private Set<Option> indicatorRelationsAP = new HashSet<Option>();
    private Set<Long> indicatorRelationIds = new HashSet<Long>();
    private Set<Option> dbIndicatorRelations = new HashSet<Option>();
    private Set<Option> dbRanges = new HashSet<Option>();
    private Set<Option> connectors = new HashSet<Option>();
    private Set<Option> taxonAuthors = new HashSet<Option>();


    private Long elementSelected;

    private Long ddIndicatorSelected = null;
    private Long ddIndicatorDCSelected = null;
    private Long ddIndicatorCPSelected = null;
    
    private String taxonTabSelected = "tabNewTaxonomy";

    private AddRemoveList arContries = new AddRemoveList();
    private AddRemoveList arComponentPart = new AddRemoveList();
    
    //Country
    private Map<Long, Option[]> selectedTaxonIndicatorCountriesId = new HashMap<Long, Option[]>();
    private Map<Long, Option[]> dBTaxonIndicatorCountriesId = new HashMap<Long, Option[]>();
    //Component Part
    private Map<Long, Option[]> selectedTaxonIndicatorComponentPartId = new HashMap<Long, Option[]>();
    private Map<Long, Option[]> dBTaxonIndicatorComponentPartId = new HashMap<Long, Option[]>();

    //Dublin Core
    private Map<Long, Map<String,ReferenceDTO>> selectedTaxonIndicatorDublinCoreId = new HashMap<Long, Map<String,ReferenceDTO>>();
    private Map<Long, Map<String,ReferenceDTO>> dBTaxonIndicatorDublinCoreId = new HashMap<Long, Map<String,ReferenceDTO>>();

    private List<TaxonAuthorDTO> authorList = new ArrayList<TaxonAuthorDTO>();


    private boolean ableTabTaxonIndicator = false;
    private boolean ableTabTaxonIndicatorCountry = false;
    private boolean ableTabTaxonIndicatorDublinCore = false;
    private boolean ableTabTaxonIndicatorComponentPart = false;


    //Taxon Author
    private Long taxonAuthorSequence = -1L;
    private String taxonAuthorName;
    private Long connectorSelected = -1L;

    private Long authorOriginalSequence = 0L;
    private Long authorModificatorSequence = 0L;
    private boolean visiblePanelAuthorAction = false;
    private boolean readOnlySequence = false;


    private Map<Long, Set<Option>> taxonAuthorsMap = new HashMap<Long, Set<Option>>();
    private Map<Long, Long> taxonAuthorSequenceMap = new HashMap<Long, Long>();
    private Map<Long, List<TaxonAuthorDTO>> authorListMap = new HashMap<Long, List<TaxonAuthorDTO>>();
    private Map<Long, List<TaxonAuthorDTO>> dbAuthorListMap = new HashMap<Long, List<TaxonAuthorDTO>>();

    private int countTaxonAuthorSelected = 0;

    private boolean newAuthorAction = true;

    private Option authorRemove = null;

    private TaxonAuthorDTO newAuthor = null;
    private int positionTaxonAuthorSelected = -1;
    //private Set<Option> allTaxonAuthors = new HashSet<Option>();
    private Map<Long, Option> allTaxonAuthorsDBMap = new HashMap<Long, Option>();

    private String authors = "";


    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public TaxonSessionBean() {
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
            log("TaxonSessionBean Initialization Failure", e);
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
     * @return the taxonomyFacade
     */
    public TaxonomyFacadeRemote getTaxonomyFacade() {
        return taxonomyFacade;
    }

    /**
     * @param taxonomyFacade the taxonomyFacade to set
     */
    public void setTaxonomyFacade(TaxonomyFacadeRemote taxonomyFacade) {
        this.taxonomyFacade = taxonomyFacade;
    }

    /**
     * @return the nodeId
     */
    public String getTaxonNodeId() {
        return taxonNodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setTaxonNodeId(String nodeId) {
        this.taxonNodeId = nodeId;
    }

    /**
     * @return the pathNode
     */
    public String getPathTaxonNode() {
        return pathTaxonNode;
    }

    /**
     * @param pathNode the pathNode to set
     */
    public void setPathTaxonNode(String pathNode) {
        this.pathTaxonNode = pathNode;
    }

    /**
     * @return the collecNomenclGroupId
     */
    public String getCollecNomenclGroupId() {
        return collecNomenclGroupId;
    }

    /**
     * @param collecNomenclGroupId the collecNomenclGroupId to set
     */
    public void setCollecNomenclGroupId(String collecNomenclGroupId) {
        this.collecNomenclGroupId = collecNomenclGroupId;
    }

    /**
     * @return the typeGroup
     */
    public String getTypeGroup() {
        return typeGroup;
    }

    /**
     * @param typeGroup the typeGroup to set
     */
    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }

    /**
     * @return the months
     */
    public SelectItem[] getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(SelectItem[] months) {
        this.months = months;
    }

    public List<TaxonCategoryDTO> getAllTaxonCategory()
    {
        return this.getTaxonomyFacade().getAllTaxonCategory();
    }


    public List<TaxonomicalRangeDTO> getNextLevelsByTaxon(Long taxonId)
    {
        List<TaxonomicalRangeDTO> tmpTaxonomicalRange = this.getTaxonomyFacade().getNextLevelsByTaxonId(taxonId);
      
        return tmpTaxonomicalRange;
    }

    public Long getTaxonomicalRangeIdByTaxonId(Long taxonId)
    {
        return this.getTaxonomyFacade().getTaxonomicalRangeIdByTaxonId(taxonId);
    }

    /**
     * @return the currentTaxon
     */
    public TaxonDTO getCurrentTaxon() {
        return currentTaxon;
    }

    /**
     * @param currentTaxon the currentTaxon to set
     */
    public void setCurrentTaxon(TaxonDTO currentTaxon) {
        this.currentTaxon = currentTaxon;
    }

    /**
     * Returns the taxon information corresponding to the specified taxon.
     * @param taxonId
     * @return TaxonDTO
     */
    public TaxonDTO getTaxon(Long taxonId){
            return taxonomyFacade.getTaxon(taxonId);
    }

    /**
     * @return the taxonomicalRangeSelected
     */
    public Long getTaxonomicalRangeSelected() {
        return taxonomicalRangeSelected;
    }

    /**
     * @param taxonomicalRangeSelected the taxonomicalRangeSelected to set
     */
    public void setTaxonomicalRangeSelected(Long taxonomicalRangeSelected) {
        
        this.taxonomicalRangeSelected = taxonomicalRangeSelected;
    }

    /**
     * @return the taxonomicalCategorySelected
     */
    public Long getTaxonomicalCategorySelected() {
        return taxonomicalCategorySelected;
    }

    /**
     * @param taxonomicalCategorySelected the taxonomicalCategorySelected to set
     */
    public void setTaxonomicalCategorySelected(Long taxonomicalCategorySelected) {
        this.taxonomicalCategorySelected = taxonomicalCategorySelected;
    }

    /**
     * @return the monthSelected
     */
    public Long getMonthSelected() {
        return monthSelected;
    }

    /**
     * @param monthSelected the monthSelected to set
     */
    public void setMonthSelected(Long monthSelected) {
        this.monthSelected = monthSelected;
    }

    /**
     * @return the checkedParentheses
     */
    public boolean isCheckedParentheses() {
        return checkedParentheses;
    }

    /**
     * @param checkedParentheses the checkedParentheses to set
     */
    public void setCheckedParentheses(boolean checkedParentheses) {
        this.checkedParentheses = checkedParentheses;
    }

    /**
     * @return the taxonName
     */
    public String getTaxonName() {
        return taxonName;
    }

    /**
     * @param taxonName the taxonName to set
     */
    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }

    /**
     * @return the basionymName
     */
    public String getBasionymName() {
        return basionymName;
    }

    /**
     * @param basionymName the basionymName to set
     */
    public void setBasionymName(String basionymName) {
        this.basionymName = basionymName;
    }

    /**
     * @return the year
     */
    public Long getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Long year) {
        this.year = year;
    }

    /**
     * Set the apropiate attribute acordind to the taxonomical range
     * @param taxon
     * @return the taxon with the atribute set.
     */
    public TaxonDTO setFullTaxonomicalAttributes(TaxonDTO taxon, Long fatherRangeId){
        TaxonomySessionBean tST = null;

        Long ancestorId = taxon.getAncestorId();
        
        switch(fatherRangeId.intValue()){

            case 23:	// Dominium
                taxon.setDominiumTaxonId(ancestorId);
                break;
            case 20:		//Variety
                taxon.setVarietyTaxonId(ancestorId);
                break;
            case 19:		//Subspecies
                taxon.setSubspeciesTaxonId(ancestorId);
                break;
            case 18:	// Specie
                taxon.setSpeciesTaxonId(ancestorId);
                break;
            case 17:		//Stirps
                taxon.setStirpsTaxonId(ancestorId);
                break;
            case 16:		//Subseccion
                taxon.setSubsectionTaxonId(ancestorId);
                break;
            case 15:		//Section
                taxon.setSectionTaxonId(ancestorId);
                break;
            case 14:		//Subgenus
                taxon.setSubgenusTaxonId(ancestorId);
                break;
            case 13:	// Genus
                taxon.setGenusTaxonId(ancestorId);
                break;
            case 12:		//Subtribe
                taxon.setSubtribeTaxonId(ancestorId);
                break;
            case 11:		//Tribe
                taxon.setTribeTaxonId(ancestorId);
                break;
            case 10:		//Subfamily
                taxon.setSubfamilyTaxonId(ancestorId);
                break;
            case 9:		// Family
                taxon.setFamilyTaxonId(ancestorId);
                break;
            case 8:		//Superfamily
                taxon.setSuperfamilyTaxonId(ancestorId);
                break;
            case 7:		//Suborder
                taxon.setSuborderTaxonId(ancestorId);
                break;
            case 6:		// Order
                taxon.setOrderTaxonId(ancestorId);
                break;
            case 5:		//Subclass
                taxon.setSubclassTaxonId(ancestorId);
                break;
            case 4:		// Class
                taxon.setClassTaxonId(ancestorId);
                break;
            case 3:		//Subphylum or Subdivision
                taxon.setSubphylumSubdivisionTaxonId(ancestorId);
                break;
            case 2:		//Phylum or Division
                taxon.setPhylumDivisionTaxonId(ancestorId);
                break;
            case 1:		// Kingdom
                taxon.setKingdomTaxonId(ancestorId);
                break;
        }

        return taxon;
    }

  

    /**
     * return the taxa number in the next hierarchy level under the taxon
     * specified by taxonId
     * @param taxonId
     * @return
     */
    public Long getTaxonChildrenCount(Long taxonId){
            return taxonomyFacade.getTaxonChildrenCount(taxonId);
    }

    /**
     * Check if a specific taxon has associated nomenclatural groups
     * @param taxonId
     * @return
     */
    public Long getAssociatedNumenclaturalG(Long taxonId){
        Long aux = taxonomyFacade.getAssociatedNumenclaturalG(taxonId);
        if(aux==null)
            return 0L;
        else
            return aux;
    }

    /**
     * Return the number of specimens associated to the selected taxa
     * @return
     */
    public Long getAssociatedSpecimenCount(Long taxonId){
            return taxonomyFacade.getAssociatedSpecimenCount(taxonId);
    }

    /**
     * Delete the taxon identified by taxonId
     * @param taxonId
     */
    public void removeTaxon(Long taxonId){
        this.taxonomyFacade.deleteTaxon(taxonId);
    }

    public TaxonomicalRangeDTO getTaxonRangeName(Long taxonRangeId)
    {
        return this.taxonomyFacade.getTaxonRangeName(taxonRangeId);
    }

    /**
     * @return the taxonomicalRangeName
     */
    public String getTaxonomicalRangeName() {
        return taxonomicalRangeName;
    }

    /**
     * @param taxonomicalRangeName the taxonomicalRangeName to set
     */
    public void setTaxonomicalRangeName(String taxonomicalRangeName) {
        this.taxonomicalRangeName = taxonomicalRangeName;
    }

     /**
     * Send to persis a TaxonDTO to the database
     * @param aDTO
     */
    public void updateTaxon(TaxonDTO aDTO){
        this.taxonomyFacade.updateTaxon(aDTO);
    }

    /**
     * @return the nodeId
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the pathNode
     */
    public String getPathNode() {
        return pathNode;
    }

    /**
     * @param pathNode the pathNode to set
     */
    public void setPathNode(String pathNode) {
        this.pathNode = pathNode;
    }

     /*
     * Obtener los datos de un indicador de acuerdo al id
     */
    public IndicatorDTO getIndicatorDTOByIndicatorId(Long indicatorId)
    {
       return indicatorFacade.getIndicatorByIndicatorId(indicatorId);
    }

    /**
     * @return the indicatorRelations
     */
    public Set<Option> getIndicatorRelations() {
        return indicatorRelations;
    }

    /**
     * @param indicatorRelations the indicatorRelations to set
     */
    public void setIndicatorRelations(Set<Option> indicatorRelations) {
        this.indicatorRelations = indicatorRelations;
    }

    public void  removeIndicatorOption(Long elementDeleted, Set<Option> indicators)
    {
        for(Option element: indicators)
        {
            Long idElement = new Long(element.getValue().toString());
            
            if(idElement.equals(elementDeleted))
            {
            
                indicatorRelations.remove(element);
                break;
            }

        }

        indicatorRelationIds.remove(elementDeleted);
        elementSelected = null;
        
    }

    /**
     * @return the elementSelected
     */
    public Long getElementSelected() {
        return elementSelected;
    }

    /**
     * @param elementSelected the elementSelected to set
     */
    public void setElementSelected(Long elementSelected) {
        this.elementSelected = elementSelected;
    }

     /*
     * Send to persis a TaxonDTO to the database
     * @param aDTO
     */
    public void saveTaxon(TaxonDTO aDTO){
        currentTaxon = this.taxonomyFacade.saveTaxon(aDTO);
    }

    public void saveTaxonIndicatorIds (Long taxonId, List<String> indicatorIds, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicators(taxonId, indicatorIds, userName);
    }


    public void saveTaxonIndicatorId(Long taxonId, String indicatorId, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicator(taxonId, indicatorId, userName);
    }

    public void saveTaxonIndicatorCountries(Long taxonId, Long indicatorId ,List<Long> countryIds, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicatorCountries(taxonId, indicatorId, countryIds, userName);
    }

    public void saveTaxonIndicatorCountry(Long taxonId, Long indicatorId ,Long countryId, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicatorCountry(taxonId, indicatorId, countryId, userName);
    }


    public void saveTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId ,List<String> dublinCoreIds, String userName)
    {
        this.taxonomyFacade.saveTaxonIndicatorDublinCoreIds(taxonId, indicatorId, dublinCoreIds, userName);
    }

    public void deleteTaxonIndicatorById(Long taxonId, String indicatorId)
    {
        this.getTaxonomyFacade().deleteTaxonIndicatorById(taxonId, indicatorId);
    }


    public boolean isLeaf(Long indicatorId)
    {
        boolean result = false;
        if(indicatorFacade.countChildrenByIndicatorId(indicatorId)<=0)
        {
           result = true;
        }
        return result;
    }


    public Set<Option> getIndicatorByTaxon(Long taxonId)
    {
        
        Set <Option> result = new HashSet<Option>();
        List<Long> dbindicatorIds = taxonomyFacade.getIndicatorIdsByTaxon(taxonId);
        
        for(Long indicatorId: dbindicatorIds)
        {
            IndicatorDTO indicator = indicatorFacade.getIndicatorByIndicatorId(indicatorId);
            result.add(new Option(indicatorId,indicator.getName()));
            indicatorRelationIds.add(indicatorId);
        }

        
        return result;
    }

    public Set<Option> getIndicatorAPByTaxon(Long taxonId)
    {
        
        Set <Option> result = new HashSet<Option>();
        List<Long> dbindicatorIds = taxonomyFacade.getIndicatorIdsByTaxon(taxonId);
        
        for(Long indicatorId: dbindicatorIds)
        {
            IndicatorDTO indicator = indicatorFacade.getIndicatorByIndicatorId(indicatorId);
            if(indicator.getAppliesToParts() ==1)
            {
                result.add(new Option(indicatorId,indicator.getName()));                
            }
        }
        
        return result;
    }

    /**
     * @return the dbIndicatorRelations
     */
    public Collection<Option> getDbIndicatorRelations() {
        return dbIndicatorRelations;
    }

    /**
     * @param dbIndicatorRelations the dbIndicatorRelations to set
     */
    public void setDbIndicatorRelations(Set<Option> dbIndicatorRelations) {
        this.dbIndicatorRelations = dbIndicatorRelations;
    }


    public void deleteTaxonIndicatorByIds(Long taxonId, List<String> indicatorIds)
    {
        this.taxonomyFacade.deleteTaxonIndicatorByIds(taxonId, indicatorIds);
    }

    /**
     * @return the taxonNodeName
     */
    public String getTaxonNodeName() {
        return taxonNodeName;
    }

    /**
     * @param taxonNodeName the taxonNodeName to set
     */
    public void setTaxonNodeName(String taxonNodeName) {
        this.taxonNodeName = taxonNodeName;
    }

    /**
     * @return the ddIndicatorSelected
     */
    public Long getDdIndicatorSelected() {
        return ddIndicatorSelected;
    }

    /**
     * @param ddIndicatorSelected the ddIndicatorSelected to set
     */
    public void setDdIndicatorSelected(Long ddIndicatorSelected) {
        this.ddIndicatorSelected = ddIndicatorSelected;
    }

    /**
     * @return the arContries
     */
    public AddRemoveList getArContries() {
        return arContries;
    }

    /**
     * @param arContries the arContries to set
     */
    public void setArContries(AddRemoveList arContries) {
        this.arContries = arContries;
    }


    public List<CountryDTO> getAllCountry()
    {
        return this.gisFacade.findAllCountries();
    }

    /**
     * @return the taxonTabSelected
     */
    public String getTaxonTabSelected() {
        return taxonTabSelected;
    }

    /**
     * @param taxonTabSelected the taxonTabSelected to set
     */
    public void setTaxonTabSelected(String taxonTabSelected) {
        this.taxonTabSelected = taxonTabSelected;
    }

    /**
     * @return the selectedTaxonIndicatorCountriesId
     */
    public Map<Long, Option[]> getSelectedTaxonIndicatorCountriesId() {
        return selectedTaxonIndicatorCountriesId;
    }

    /**
     * @param selectedTaxonIndicatorCountriesId the selectedTaxonIndicatorCountriesId to set
     */
    public void setSelectedTaxonIndicatorCountriesId(Map<Long, Option[]> selectedTaxonIndicatorCountriesId) {
        this.selectedTaxonIndicatorCountriesId = selectedTaxonIndicatorCountriesId;
    }

    public List<Long> getCountriesByTaxonIndicatorIds(Long taxon, Long indicator)
    {
        return this.taxonomyFacade.getCountriesByTaxonIndicatorIds(taxon, indicator);
    }

    /**
     * @return the dBTaxonIndicatorCountriesId
     */
    public Map<Long, Option[]> getdBTaxonIndicatorCountriesId() {
        return dBTaxonIndicatorCountriesId;
    }

    /**
     * @param dBTaxonIndicatorCountriesId the dBTaxonIndicatorCountriesId to set
     */
    public void setdBTaxonIndicatorCountriesId(Map<Long, Option[]> dBTaxonIndicatorCountriesId) {
        this.dBTaxonIndicatorCountriesId = dBTaxonIndicatorCountriesId;
    }


    public CountryDTO getCountryByCountryId(Long countryId)
    {
        return this.gisFacade.getCountryByCountryId(countryId);
    }

    public void deleteTaxonIndicatorCountryByIds(Long taxonId, Long indicatorId, List<Long> countryIds)
    {
        this.taxonomyFacade.deleteTaxonIndicatorCountryByIds(taxonId, indicatorId, countryIds);
    }

    /**
     * @return the dublinCoreFacade
     */
    public DublinCoreFacadeRemote getDublinCoreFacade() {
        return dublinCoreFacade;
    }

    /**
     * @param dublinCoreFacade the dublinCoreFacade to set
     */
    public void setDublinCoreFacade(DublinCoreFacadeRemote dublinCoreFacade) {
        this.dublinCoreFacade = dublinCoreFacade;
    }

    /**
     * @return the pagination
     */
    public PaginationControllerRemix getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(PaginationControllerRemix pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the advancedSearch
     */
    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * @return the editMode
     */
    public boolean isEditMode() {
        return editMode;
    }

    /**
     * @param editMode the editMode to set
     */
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    /**
     * @return the simpleConsult
     */
    public String getSimpleConsult() {
        return simpleConsult;
    }

    /**
     * @param simpleConsult the simpleConsult to set
     */
    public void setSimpleConsult(String simpleConsult) {
        this.simpleConsult = simpleConsult;
    }

    /**
     * @return the queryDublinCoreDTO
     */
    public DublinCoreDTO getQueryDublinCoreDTO() {
        return queryDublinCoreDTO;
    }

    /**
     * @param queryDublinCoreDTO the queryDublinCoreDTO to set
     */
    public void setQueryDublinCoreDTO(DublinCoreDTO queryDublinCoreDTO) {
        this.queryDublinCoreDTO = queryDublinCoreDTO;
    }

    /**
     * @return the selectedResourcesId
     */
    public Map<String, ReferenceDTO> getSelectedResourcesId() {
        return selectedResourcesId;
    }

    /**
     * @param selectedResourcesId the selectedResourcesId to set
     */
    public void setSelectedResourcesId(Map<String, ReferenceDTO> selectedResourcesId) {
        this.selectedResourcesId = selectedResourcesId;
    }

    /**
     * @return the dbRelationsDublinCore
     */
    public Map<String, ReferenceDTO> getDbRelationsDublinCore() {
        return dbRelationsDublinCore;
    }

    /**
     * @param dbRelationsDublinCore the dbRelationsDublinCore to set
     */
    public void setDbRelationsDublinCore(Map<String, ReferenceDTO> dbRelationsDublinCore) {
        this.dbRelationsDublinCore = dbRelationsDublinCore;
    }


    /*
     * Calcula el String con la información de paginación
     * registro inicial en la pagina - registro final en la pagina | total de resultado a mostrar
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  " + (actualPage + 1) + " - " + (actualPage + resultsPerPage) + "  | " + totalResults + "  ";
    }




    public void deleteTaxonIndicatorDublinCoreByIds(Long indicatorId, List<String> dublinCoreIds)
    {
        //this.indicatorFacade.deleteIndicatorDublinCoreByIds(indicatorId, dublinCoreIds);
    }

    /*
     * Crea las n relaciones de acuerdo a las n referencias que escogio el usuario
     * y al id del indicador con el que se está trabajando
     */
    /*
    public void saveTaxonIndicatorDublinCoreIds (Long indicatorId, List<String> dublinCoreIds, String userName)
    {
        //this.getIndicatorFacade().saveIndicatorDublinCores(indicatorId, dublinCoreIds, userName);
    }
*/

    /*
     * Obtener los datos de una Referencia en formato dublin core de acuerdo al id del recurso
     */
    public DublinCoreDTO getDublinCoreMetadataByResourceId(Long resuorceId)
    {
       return dublinCoreFacade.getMetadataByResourceKey(resuorceId.toString());
    }

     /**
     * Inicializar el data provider
     */
    public void initDataProvider() {

        setPagination(new PaginationControllerRemix(getDublinCoreFacade().countResourceByTypeId(ResourceTypeEnum.REFERENCE.getId()).intValue(), getQuantity(), this));
    }

     /**
     * Inicializar el data provider para el edit
     */
    public void initEditDataProvider(Long indicatorId) {

        //setPagination(new PaginationControllerRemix(getIndicatorFacade().countDublinCoreByIndicator(indicatorId).intValue(), getQuantity(), this));


    }


    public void initEditReferenceMap()
    {
        dbRelationsDublinCore = new HashMap<String, ReferenceDTO>();

    }

    /*
     * Retorna la lista de elementos que se van a mostrar en la tabla paginada
     */
    public List getResults(int firstResult, int maxResults) {

        //System.out.println("ENTRO AL GET RESULTS DEL PAGINADOR");
        List<ReferenceDTO> auxResult = new ArrayList<ReferenceDTO>();

        //Contiene el resultado de las busquedas
        List<DublinCoreDTO> aListDTO;

        //contiene la lista resultado que será devuelta
        List<ReferenceDTO> results = new ArrayList<ReferenceDTO>();

        if (isQueryMode()) { //En caso de que sea busqueda avanzada
            try {
                //Se realiza la consulta utilizando los datos del query en un DublinCoreDTO
                aListDTO =  myReturn(
                        this.getDublinCoreFacade().getDublinCoreAdvancedSearch
                        (getQueryDublinCoreDTO(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                //Seleccionar los elemento que han sido seleccionados antes en la interfaz
                this.setSelectedResources(results, selectedResourcesId);
                return results;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
            try {
                //Se realiza la consulta utilizando el String que el usuario ingresó
                aListDTO =  myReturn(this.getDublinCoreFacade().getReferenceSimpleSearch(this.getSimpleConsult(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                //Seleccionar los elemento que han sido seleccionados antes en la interfaz
                this.setSelectedResources(results, selectedResourcesId);
                return results;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        } else if(isEditMode()) //En caso de que sean relaciones Dublin Core utilizados para editar un indicador
        {
            try {
                /*
                 * Se realiza la consulta para traer todas las relaciones indicator-dublinCore dado
                 * el nodo indicador actual sobre el cual se está editando
                 */
                List<Long> dublinCoreIds = this.indicatorFacade.getDublinCoreIdsByIndicator(new Long(nodeId));
                //obtener la lista de DublinCoreDTO de acuerdo a la lista de DublinCoreIds
                aListDTO = this.dublinCoreFacade.getDublinCoreDTOsByIds(dublinCoreIds);
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                // Seleccionar en la interfaz todas las relaciones dublin core del indicador
                this.setEditRestults(results, selectedResourcesId);
                // Dejar el modo edit en false para poder hacer búsquedas
                editMode = false;
                return results;
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }

        }
        else//Valores default
        {
            try {
                // Se traen todas las referencias Dublin Core
                aListDTO =  myReturn(this.getDublinCoreFacade().getAllDublinCorePaginated(firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                // Seleccionar en la interfaz todas las relaciones dublin core del indicador
                this.setSelectedResources(results, selectedResourcesId);
                return results;
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
    }


    /*
     * Selecciona en la interfaz las relaciones existentes indicador-dublinCore que se muestran al
     * realizar la edición de datos de un indicador.
     */
    public void setEditRestults(List<ReferenceDTO> indicatorReferences, Map<String,ReferenceDTO> selectedRef)
    {
        initEditReferenceMap();


        for(ReferenceDTO indicatorReference : indicatorReferences)
        {
            selectedRef.put(indicatorReference.getKey(), indicatorReference);
            dbRelationsDublinCore.put(indicatorReference.getKey(), indicatorReference);
            indicatorReference.setSelected(true);
        }
    }

    /*
     * Valida si la lista es nula para o no, para retornar un objeto no nulo
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<DublinCoreDTO>();
        } else {
            return l;
        }
    }

    /*
     * Selecciona en la interfaz los elementos seleccinados por el usuario.
     * Es utilizado cuando se hace un prerender donde se pierden los elementos que habian seleccionados desde
     * la interfaz
     */
    public void setSelectedResources (List<ReferenceDTO> resources, Map<String, ReferenceDTO> selectedResourcesId)
    {
        
        for (ReferenceDTO aux: resources) {

           
            if(selectedResourcesId.containsKey(aux.getKey()))
            {
           
                aux.setSelected(true);
            }

        }
    }

    public void deselectedResources (List<ReferenceDTO> resources)
    {
        for (ReferenceDTO aux: resources) {


                aux.setSelected(false);


        }
    }


 /*
    * Convierte los datos contenido del map en un string
    */
   public String mapToString(Map<String,ReferenceDTO> map)
   {
        String result = "";
        Collection<ReferenceDTO> references = map.values();
        for(ReferenceDTO reference: references)
        {
            result += reference.getKey() +"\t"+reference.getTitle()+"\n";
        }
        return result;
    }


    /**
     * Obtener los datos del drop down de las listas de seleccion
     */
    public void setTaxonAuthorProfileDropDownData(){
   
        List<TaxonAuthorProfileDTO> tapDTOList = this.getTaxonomyFacade().getAllTaxonAuthorProfile();
        
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        //Option option;
        String taxonAuthorProfileName;
        //Crear opcion titulo
        //option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        //allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonAuthorProfileDTO tapDTO : tapDTOList){
            taxonAuthorProfileName = BundleHelper.getDefaultBundleValue(tapDTO.getNameAsProperty(), getMyLocale());
            //option = new Option(sleDTO.getSelectionListEntityId(), selectionListName);
            allOptions.add(new Option(tapDTO.getTaxonAuthorProfileId(), taxonAuthorProfileName));
        }       
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];        
        this.setAuthorType(allOptions.toArray(allOptionsInArray));        
    }

    public void setAuthorList()
    {
                
        List<PersonAuthorDTO> personAuthorDTOs = this.getTaxonomyFacade().getAllPersonsByProfileId(ProfileEntity.TAXONOMIC_AUTHOR.getId(), AuthorNameEntity.PERFIL_FORMAT.getId() , false);

        
        Set<Option> taxonOriginalAuthors = new HashSet<Option>();
        Set<Option> taxonModificatorAuthors = new HashSet<Option>();

        
        for(PersonAuthorDTO personAuthor: personAuthorDTOs)        
        {
            //System.out.println("Option "+personAuthor.getPersonId()+" - "+personAuthor.getName());
            taxonOriginalAuthors.add(new Option(personAuthor.getPersonId(),personAuthor.getName()));
            taxonModificatorAuthors.add(new Option(personAuthor.getPersonId(),personAuthor.getName()));

        }

        
        getTaxonAuthorsMap().put(TaxonAuthorProfile.ORIGINALS.getId(), taxonOriginalAuthors);
        getTaxonAuthorsMap().put(TaxonAuthorProfile.MODIFICATORS.getId(), taxonModificatorAuthors);
       

    }


    public void setEditAuthorList(Long taxonId)
    {
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
        for(int pos = 0; pos < tap.length; pos++)
        {
            authorListMap.put(tap[pos].getId(), getTaxonAuthorsByTaxonCategory(taxonId, tap[pos].getIdentifier()));

            List<TaxonAuthorDTO> tmpImprimir = authorListMap.get(tap[pos].getId());            

        }
    }


    public void initTaxonAuthorSequence()
    {
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
        for(int pos = 0; pos < tap.length; pos++)
        {
            taxonAuthorSequenceMap.put(tap[pos].getId(), 1L);
        }
    }

    public void initAuthorList()
    {
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
        for(int pos = 0; pos < tap.length; pos++)
        {
            authorListMap.put(tap[pos].getId(), new ArrayList<TaxonAuthorDTO>());
        }
    }

    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

     protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * @return the ddIndicatorDCSelected
     */
    public Long getDdIndicatorDCSelected() {
        return ddIndicatorDCSelected;
    }

    /**
     * @param ddIndicatorDCSelected the ddIndicatorDCSelected to set
     */
    public void setDdIndicatorDCSelected(Long ddIndicatorDCSelected) {
        this.ddIndicatorDCSelected = ddIndicatorDCSelected;
    }

    /**
     * @return the selectedTaxonIndicatorDublinCoreId
     */
    public Map<Long, Map<String, ReferenceDTO>> getSelectedTaxonIndicatorDublinCoreId() {
        return selectedTaxonIndicatorDublinCoreId;
    }

    /**
     * @param selectedTaxonIndicatorDublinCoreId the selectedTaxonIndicatorDublinCoreId to set
     */
    public void setSelectedTaxonIndicatorDublinCoreId(Map<Long, Map<String, ReferenceDTO>> selectedTaxonIndicatorDublinCoreId) {
        this.selectedTaxonIndicatorDublinCoreId = selectedTaxonIndicatorDublinCoreId;
    }

    /**
     * @return the dBTaxonIndicatorDublinCoreId
     */
    public Map<Long, Map<String, ReferenceDTO>> getdBTaxonIndicatorDublinCoreId() {
        return dBTaxonIndicatorDublinCoreId;
    }

    /**
     * @param dBTaxonIndicatorDublinCoreId the dBTaxonIndicatorDublinCoreId to set
     */
    public void setdBTaxonIndicatorDublinCoreId(Map<Long, Map<String, ReferenceDTO>> dBTaxonIndicatorDublinCoreId) {
        this.dBTaxonIndicatorDublinCoreId = dBTaxonIndicatorDublinCoreId;
    }

    /**
     * @return the ableTabTaxonIndicatorCountry
     */
    public boolean isAbleTabTaxonIndicatorCountry() {
        return ableTabTaxonIndicatorCountry;
    }

    /**
     * @param ableTabTaxonIndicatorCountry the ableTabTaxonIndicatorCountry to set
     */
    public void setAbleTabTaxonIndicatorCountry(boolean ableTabTaxonIndicatorCountry) {
        this.ableTabTaxonIndicatorCountry = ableTabTaxonIndicatorCountry;
    }

    /**
     * @return the ableTabTaxonIndicatorDublinCore
     */
    public boolean isAbleTabTaxonIndicatorDublinCore() {
        return ableTabTaxonIndicatorDublinCore;
    }

    /**
     * @param ableTabTaxonIndicatorDublinCore the ableTabTaxonIndicatorDublinCore to set
     */
    public void setAbleTabTaxonIndicatorDublinCore(boolean ableTabTaxonIndicatorDublinCore) {
        this.ableTabTaxonIndicatorDublinCore = ableTabTaxonIndicatorDublinCore;
    }

    /**
     * @return the ableTabTaxonIndicator
     */
    public boolean isAbleTabTaxonIndicator() {
        return ableTabTaxonIndicator;
    }

    /**
     * @param ableTabTaxonIndicator the ableTabTaxonIndicator to set
     */
    public void setAbleTabTaxonIndicator(boolean ableTabTaxonIndicator) {
        this.ableTabTaxonIndicator = ableTabTaxonIndicator;
    }

    /**
     * @return the dbRanges
     */
    public Set<Option> getDbRanges() {
        return dbRanges;
    }

    /**
     * @param dbRanges the dbRanges to set
     */
    public void setDbRanges(Set<Option> dbRanges) {
        this.dbRanges = dbRanges;
    }

    /**
     * @return the indicatorRelationIds
     */
    public Set<Long> getIndicatorRelationIds() {
        return indicatorRelationIds;
    }

    /**
     * @param indicatorRelationIds the indicatorRelationIds to set
     */
    public void setIndicatorRelationIds(Set<Long> indicatorRelationIds) {
        this.indicatorRelationIds = indicatorRelationIds;
    }


    public List<Long> getDublinCoreByTaxonIndicatorIds(Long taxonId, Long indicatorId)
    {
        return this.taxonomyFacade.getDublinCoreByTaxonIndicatorIds(taxonId, indicatorId);
    }

    public ReferenceDTO dublinCoreDTOToReferenceDTO(DublinCoreDTO element)
    {
        return dublinCoreFacade.dublinCoreDTOToReferenceDTO(element);
    }


    public void deleteTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId, List<String> dublinCoreIds)
    {
        this.taxonomyFacade.deleteTaxonIndicatorDublinCoreIds(taxonId, indicatorId, dublinCoreIds);
    }


    public void deleteTaxonIndicatorByTaxonId(Long taxonId)
    {
        this.taxonomyFacade.deleteTaxonIndicatorByTaxonId(taxonId);
    }


    public void deleteTaxonIndicatorCountryByTaxonId(Long taxonId)
    {
        this.taxonomyFacade.deleteTaxonIndicatorCountryByTaxonId(taxonId);
    }

    public void deleteTaxonIndicatorDublinCoreByTaxonId(Long taxonId)
    {
        this.taxonomyFacade.deleteTaxonIndicatorDublinCoreByTaxonId(taxonId);
    }


    public void deleteTaxonIndicatorDublinCoreByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        this.taxonomyFacade.deleteTaxonIndicatorDublinCoreByTaxonIndicator(taxonId, indicatorId);
    }

    public void deleteTaxonIndicatorCountryByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        this.taxonomyFacade.deleteTaxonIndicatorCountryByTaxonIndicator(taxonId, indicatorId);
    }


    public List<SelectionListDTO> getAllComponetPartByCollectionId(Long collectionId)
    {
        return this.inventoryFacade.getAllSelectionListElementsByCollection(SelectionListEntity.COMPONENT_PART.getId(), collectionId);
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
     * @return the ableTabTaxonIndicatorComponentPart
     */
    public boolean isAbleTabTaxonIndicatorComponentPart() {
        return ableTabTaxonIndicatorComponentPart;
    }

    /**
     * @param ableTabTaxonIndicatorComponentPart the ableTabTaxonIndicatorComponentPart to set
     */
    public void setAbleTabTaxonIndicatorComponentPart(boolean ableTabTaxonIndicatorComponentPart) {
        this.ableTabTaxonIndicatorComponentPart = ableTabTaxonIndicatorComponentPart;
    }

    /**
     * @return the ddIndicatorCPSelected
     */
    public Long getDdIndicatorCPSelected() {
        return ddIndicatorCPSelected;
    }

    /**
     * @param ddIndicatorCPSelected the ddIndicatorCPSelected to set
     */
    public void setDdIndicatorCPSelected(Long ddIndicatorCPSelected) {
        this.ddIndicatorCPSelected = ddIndicatorCPSelected;
    }

    /**
     * @return the arComponentPart
     */
    public AddRemoveList getArComponentPart() {
        return arComponentPart;
    }

    /**
     * @param arComponentPart the arComponentPart to set
     */
    public void setArComponentPart(AddRemoveList arComponentPart) {
        this.arComponentPart = arComponentPart;
    }

    /**
     * @return the selectedTaxonIndicatorComponentPartId
     */
    public Map<Long, Option[]> getSelectedTaxonIndicatorComponentPartId() {
        return selectedTaxonIndicatorComponentPartId;
    }

    /**
     * @param selectedTaxonIndicatorComponentPartId the selectedTaxonIndicatorComponentPartId to set
     */
    public void setSelectedTaxonIndicatorComponentPartId(Map<Long, Option[]> selectedTaxonIndicatorComponentPartId) {
        this.selectedTaxonIndicatorComponentPartId = selectedTaxonIndicatorComponentPartId;
    }

    /**
     * @return the dBTaxonIndicatorComponentPartId
     */
    public Map<Long, Option[]> getdBTaxonIndicatorComponentPartId() {
        return dBTaxonIndicatorComponentPartId;
    }

    /**
     * @param dBTaxonIndicatorComponentPartId the dBTaxonIndicatorComponentPartId to set
     */
    public void setdBTaxonIndicatorComponentPartId(Map<Long, Option[]> dBTaxonIndicatorComponentPartId) {
        this.dBTaxonIndicatorComponentPartId = dBTaxonIndicatorComponentPartId;
    }

    /**
     * @return the indicatorRelationsAP
     */
    public Set<Option> getIndicatorRelationsAP() {
        return indicatorRelationsAP;
    }

    /**
     * @param indicatorRelationsAP the indicatorRelationsAP to set
     */
    public void setIndicatorRelationsAP(Set<Option> indicatorRelationsAP) {
        this.indicatorRelationsAP = indicatorRelationsAP;
    }


    public List<Long> getComponentPartByTaxonIndicatorIds(Long taxon, Long indicator)
    {
        return this.getTaxonomyFacade().getComponentPartByTaxonIndicatorIds(taxon, indicator);
    }

    public void saveTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId ,List<Long> componentPartIds, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicatorComponentPartIds(taxonId, indicatorId, componentPartIds, userName);
    }

    public void deleteTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId, List<Long> componentPartIds)
    {
        this.getTaxonomyFacade().deleteTaxonIndicatorComponentPartIds(taxonId, indicatorId, componentPartIds);
    }

    public void deleteTaxonIndicatorComponentPartByTaxonId(Long taxonId)
    {
        this.getTaxonomyFacade().deleteTaxonIndicatorComponentPartByTaxonId(taxonId);
    }

    public void deleteTaxonIndicatorComponentPartByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        this.getTaxonomyFacade().deleteTaxonIndicatorComponentPartByTaxonIndicator(taxonId, indicatorId);
    }

    public SelectionListDTO  getSelectionListElementById(Long selectionListEntityId, Long selectionListValueId)
    {
        return this.getInventoryFacade().getSelectionListElementById(selectionListEntityId, selectionListValueId);
    }

    public Set<Option> getSelectionListDropDownData(Long selectionListEntityId) {

        List<SelectionListDTO> DTOList = this.getInventoryFacade().getAllSelectionListElementsByCollection(selectionListEntityId, getAraSessionBean().getGlobalCollectionId());

        Set<Option> allOptions = new HashSet<Option>();
        //Option[] allOptionsInArray;
        Option option;
        /*
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue("drop_down_default", getMyLocale()) + " --");
        allOptions.add(option);
        */
        //Crear todas las opciones del drop down
        for (SelectionListDTO slDTO : DTOList) {
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }
        //allOptionsInArray = new Option[allOptions.size()];
        //return allOptions.toArray(allOptionsInArray);
        return allOptions;
    }

    public void saveTaxonAuthorDTOs(Long taxonId, List<TaxonAuthorDTO> taxonAuthorDTOs, String userName)
    {
        this.getTaxonomyFacade().saveTaxonAuthors(taxonId, taxonAuthorDTOs, userName);
    }


    public void deleteTaxonAuthorsByTaxon(Long taxonId)
    {

        this.getTaxonomyFacade().deleteTaxonAuthorByTaxonId(taxonId);
    }

    /**
     * @return the authorType
     */
    public Option[] getAuthorType() {
        return authorType;
    }

    /**
     * @param authorType the authorType to set
     */
    public void setAuthorType(Option[] authorType) {
        this.authorType = authorType;
    }

    /**
     * @return the authorTypeSelected
     */
    public Long getAuthorTypeSelected() {
        return authorTypeSelected;
    }

    /**
     * @param authorTypeSelected the authorTypeSelected to set
     */
    public void setAuthorTypeSelected(Long authorTypeSelected) {
        this.authorTypeSelected = authorTypeSelected;
    }

    /**
     * @return the authorSelected
     */
    public Long getAuthorSelected() {
        return authorSelected;
    }

    /**
     * @param authorSelected the authorSelected to set
     */
    public void setAuthorSelected(Long authorSelected) {
        this.authorSelected = authorSelected;
    }

    /**
     * @return the authorList
     */
    public List<TaxonAuthorDTO> getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(List<TaxonAuthorDTO> authorList) {
        this.authorList = authorList;
    }

    /**
     * @return the authorListSize
     */
    public int getAuthorListSize() {
        return authorListSize;
    }

    /**
     * @param authorListSize the authorListSize to set
     */
    public void setAuthorListSize(int authorListSize) {
        this.authorListSize = authorListSize;
    }

    /**
     * @return the taxonAuthorSequence
     */
    public Long getTaxonAuthorSequence() {
        return taxonAuthorSequence;
    }

    /**
     * @param taxonAuthorSequence the taxonAuthorSequence to set
     */
    public void setTaxonAuthorSequence(Long taxonAuthorSequence) {
        this.taxonAuthorSequence = taxonAuthorSequence;
    }

    /**
     * @return the taxonAuthorName
     */
    public String getTaxonAuthorName() {
        return taxonAuthorName;
    }

    /**
     * @param taxonAuthorName the taxonAuthorName to set
     */
    public void setTaxonAuthorName(String taxonAuthorName) {
        this.taxonAuthorName = taxonAuthorName;
    }

    /**
     * @return the connectors
     */
    public Set<Option> getConnectors() {
        return connectors;
    }

    /**
     * @param connectors the connectors to set
     */
    public void setConnectors(Set<Option> connectors) {
        this.connectors = connectors;
    }

    /**
     * @return the connectorSelected
     */
    public Long getConnectorSelected() {
        return connectorSelected;
    }

    /**
     * @param connectorSelected the connectorSelected to set
     */
    public void setConnectorSelected(Long connectorSelected) {
        this.connectorSelected = connectorSelected;
    }

    /**
     * @return the taxonAuthors
     */
    public Set<Option> getTaxonAuthors() {
        return taxonAuthors;
    }

    /**
     * @param taxonAuthors the taxonAuthors to set
     */
    public void setTaxonAuthors(Set<Option> taxonAuthors) {
        this.taxonAuthors = taxonAuthors;
    }

    /**
     * @return the visiblePanelAuthorAction
     */
    public boolean isVisiblePanelAuthorAction() {
        return visiblePanelAuthorAction;
    }

    /**
     * @param visiblePanelAuthorAction the visiblePanelAuthorAction to set
     */
    public void setVisiblePanelAuthorAction(boolean visiblePanelAuthorAction) {
        this.visiblePanelAuthorAction = visiblePanelAuthorAction;
    }

    /**
     * @return the authorOriginalSequence
     */
    public Long getAuthorOriginalSequence() {
        return authorOriginalSequence;
    }

    /**
     * @param authorOriginalSequence the authorOriginalSequence to set
     */
    public void setAuthorOriginalSequence(Long authorOriginalSequence) {
        this.authorOriginalSequence = authorOriginalSequence;
    }

    /**
     * @return the authorModificatorSequence
     */
    public Long getAuthorModificatorSequence() {
        return authorModificatorSequence;
    }

    /**
     * @param authorModificatorSequence the authorModificatorSequence to set
     */
    public void setAuthorModificatorSequence(Long authorModificatorSequence) {
        this.authorModificatorSequence = authorModificatorSequence;
    }

    /**
     * @return the taxonAuthorsMap
     */
    public Map<Long, Set<Option>> getTaxonAuthorsMap() {
        return taxonAuthorsMap;
    }

    /**
     * @param taxonAuthorsMap the taxonAuthorsMap to set
     */
    public void setTaxonAuthorsMap(Map<Long, Set<Option>> taxonAuthorsMap) {
        this.taxonAuthorsMap = taxonAuthorsMap;
    }


    public Option  removeOption(Long elementDeleted, Set<Option> set)
    {
        Option result = null;
        for(Option element: set)
        {
            Long idElement = new Long(element.getValue().toString());

            if(idElement.equals(elementDeleted))
            {
                result = element;
                set.remove(element);
                break;
            }

        }
        return result;
    }


    /**
     * @return the taxonAuthorSequenceMap
     */
    public Map<Long, Long> getTaxonAuthorSequenceMap() {
        return taxonAuthorSequenceMap;
    }

    /**
     * @param taxonAuthorSequenceMap the taxonAuthorSequenceMap to set
     */
    public void setTaxonAuthorSequenceMap(Map<Long, Long> taxonAuthorSequenceMap) {
        this.taxonAuthorSequenceMap = taxonAuthorSequenceMap;
    }

    /**
     * @return the readOnlySequence
     */
    public boolean isReadOnlySequence() {
        return readOnlySequence;
    }

    /**
     * @param readOnlySequence the readOnlySequence to set
     */
    public void setReadOnlySequence(boolean readOnlySequence) {
        this.readOnlySequence = readOnlySequence;
    }

    public List<TaxonAuthorDTO> reorderSequence(TaxonAuthorDTO element, List<TaxonAuthorDTO> list )
    {
        
        List<TaxonAuthorDTO> listResult= new ArrayList<TaxonAuthorDTO>();
        List<TaxonAuthorDTO> tmpList = new ArrayList<TaxonAuthorDTO>();

        int size = list.size();

        boolean divide = false;
        for(int pos = 0; pos < size; pos++)
        {                                    
            if(list.get(pos).getTaxonAuthorConnectorId() == null && list.get(pos).getTaxonAuthorConnector().equals("&"))
            {
                list.get(pos).setTaxonAuthorConnector(",");
            }
            
            if(list.get(pos).getTaxonAuthorSequence().equals(element.getTaxonAuthorSequence()) || divide)
            {                
                TaxonAuthorDTO ta = list.get(pos);
                Long sequenceValue =ta.getTaxonAuthorSequence( )+1;
                ta.setTaxonAuthorSequence(sequenceValue);
                tmpList.add(ta);
                
                divide = true;              
            }
            else
            {               
                   listResult.add(list.get(pos));              
            }
        }

        listResult.add(element);      
        listResult.addAll(tmpList);                
        return listResult;
    }

    public void editSequence(TaxonAuthorDTO element, List<TaxonAuthorDTO> list )
    {
        
        int newPos = element.getTaxonAuthorSequence().intValue()-1;        
        list.remove(positionTaxonAuthorSelected);
        list.add(newPos, element);
        Long sequence = 0L;
        if(positionTaxonAuthorSelected < newPos && (newPos - positionTaxonAuthorSelected) > 0)
        {

            for(int pos = positionTaxonAuthorSelected; pos < newPos; pos++)
            {
                sequence = list.get(pos).getTaxonAuthorSequence() - 1L;
                list.get(pos).setTaxonAuthorSequence(sequence);
            }
        }
        
        if(positionTaxonAuthorSelected > newPos && ( positionTaxonAuthorSelected - newPos) > 0)
        {
            for(int pos = newPos+1; pos <= positionTaxonAuthorSelected; pos++)
            {
                sequence = list.get(pos).getTaxonAuthorSequence() + 1L;
                list.get(pos).setTaxonAuthorSequence(sequence);
            }
        }

    }

     public String getLabelConnector(Long idConnector)
     {
         //TaxonSessionBean tsb = this.getTaxonSessionBean();
         String result = "";

         for(Option connector: this.getConnectors())
         {
             if(connector.getValue().equals(idConnector))
             {
                 result = connector.getLabel();
                 break;
             }
         }
         return result;
     }

     public TaxonAuthorDTO getTaxonAuthorSelected()
     {
         TaxonAuthorDTO result = null;
         for(TaxonAuthorDTO taxonAuthor: authorList)
         {
             if(taxonAuthor.isSelected())
             {
                 result = taxonAuthor;
                 countTaxonAuthorSelected++;
             }
         }
         return result;

     }

     public int getPosTaxonAuthorSelected()
     {
         //System.out.println("-- Entro a Contar");
         int result = -1;
         
         for(int pos= 0;pos < authorList.size(); pos++)
         {
             if(authorList.get(pos).isSelected())
             {

                 result = pos;
                 countTaxonAuthorSelected++;
                 //System.out.println("\t\tcountTaxonAuthorSelected = "+countTaxonAuthorSelected);
             }
         }
          
         return result;

     }


     public TaxonAuthorDTO removeTaxonAuthorSelected()
     {
         TaxonAuthorDTO result = null;
         boolean editableSequence = false;
         for(TaxonAuthorDTO taxonAuthor: authorList)
         //int size = authorList.size();
         //for(int pos = 0; pos<size; pos++)
         {

             if(editableSequence)
             {
                 Long newSequence =taxonAuthor.getTaxonAuthorSequence()-1L;
                 //System.out.println("Editando sequence => sequence = "+taxonAuthor.getTaxonAuthorSequence() +" , new sequence = "+newSequence);
                 taxonAuthor.setTaxonAuthorSequence(newSequence);
             }
             if(taxonAuthor.isSelected())
             {
                 result = taxonAuthor;
                
                 editableSequence = true;
                 //countTaxonAuthorSelected++;
             }
             
         }
         authorList.remove(result);
         return result;

     }

    /**
     * @return the countTaxonAuthorSelected
     */
    public int getCountTaxonAuthorSelected() {
        return countTaxonAuthorSelected;
    }

    /**
     * @param countTaxonAuthorSelected the countTaxonAuthorSelected to set
     */
    public void setCountTaxonAuthorSelected(int countTaxonAuthorSelected) {
        this.countTaxonAuthorSelected = countTaxonAuthorSelected;
    }

    /**
     * @return the newAuthorAction
     */
    public boolean isNewAuthorAction() {
        return newAuthorAction;
    }

    /**
     * @param newAuthorAction the newAuthorAction to set
     */
    public void setNewAuthorAction(boolean newAuthorAction) {
        this.newAuthorAction = newAuthorAction;
    }

    /**
     * @return the authorListMap
     */
    public Map<Long, List<TaxonAuthorDTO>> getAuthorListMap() {
        return authorListMap;
    }

    /**
     * @param authorListMap the authorListMap to set
     */
    public void setAuthorListMap(Map<Long, List<TaxonAuthorDTO>> authorListMap) {
        this.authorListMap = authorListMap;
    }

     public static Object deepCopy(Object orig) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }

    /**
     * @return the authorRemove
     */
    public Option getAuthorRemove() {
        return authorRemove;
    }

    /**
     * @param authorRemove the authorRemove to set
     */
    public void setAuthorRemove(Option authorRemove) {
        this.authorRemove = authorRemove;
    }

    public void addOptionToTaxonAuthors(TaxonAuthorDTO element)
    {
        Option tmp = new Option(element.getTaxonAuthorPersonId(),element.getTaxonAuthorName());

        getTaxonAuthorsMap().get(getAuthorTypeSelected()).add(tmp);

    }

    /**
     * @return the newAuthor
     */
    public TaxonAuthorDTO getNewAuthor() {
        return newAuthor;
    }

    /**
     * @param newAuthor the newAuthor to set
     */
    public void setNewAuthor(TaxonAuthorDTO newAuthor) {
        this.newAuthor = newAuthor;
    }

    /**
     * @param positionTaxonAuthorSelected the positionTaxonAuthorSelected to set
     */
    public void setPositionTaxonAuthorSelected(int positionTaxonAuthorSelected) {
        this.positionTaxonAuthorSelected = positionTaxonAuthorSelected;
    }

    /**
     * @return the positionTaxonAuthorSelected
     */
    public int getPositionTaxonAuthorSelected() {
        return positionTaxonAuthorSelected;
    }


    public List<TaxonAuthorDTO> getTaxonAuthorsByTaxonCategory(Long taxonId, String category)
    {
        return taxonomyFacade.getTaxonAuthorsByTaxonCategory(taxonId, category);
    }

    /**
     * @return the allTaxonAuthors
     */
    /*
    public Set<Option> getAllTaxonAuthors() {
        return allTaxonAuthors;
    }
*/
    /**
     * @param allTaxonAuthors the allTaxonAuthors to set
     */
    /*
    public void setAllTaxonAuthors(Set<Option> allTaxonAuthors) {
        this.allTaxonAuthors = allTaxonAuthors;
    }
     * */

    public void loadAllTaxonAuthors()
    {
        List<PersonAuthorDTO> personAuthorDTOs = this.getTaxonomyFacade().getAllPersonsByProfileId(ProfileEntity.TAXONOMIC_AUTHOR.getId(), new Short("0") , false);


        for(PersonAuthorDTO personAuthor: personAuthorDTOs)
        {
//            allTaxonAuthors.add(new Option(personAuthor.getPersonId(),personAuthor.getName()));
            allTaxonAuthorsDBMap.put(personAuthor.getPersonId(), new Option(personAuthor.getPersonId(),
                                                                             personAuthor.getName()));

        }

    }


    public void setTaxonAuthors(Long taxonId)
    {      
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
        for(int pos = 0; pos < tap.length; pos++)
        {
            //authorListMap.put(tap[pos].getId(), getTaxonAuthorsByTaxonCategory(taxonId, tap[pos].getIdentifier()));
            Map allTaxonAuthors = new HashMap();
            allTaxonAuthors.putAll(allTaxonAuthorsDBMap);

            //List<TaxonAuthorDTO> tmpTaxonAuthors = authorListMap.get(tap[pos].getId());
            List<TaxonAuthorDTO> tmpTaxonAuthors = new ArrayList<TaxonAuthorDTO>();
            //List<TaxonAuthorDTO> dbtmpTaxonAuthors = new ArrayList<TaxonAuthorDTO>();
            tmpTaxonAuthors.addAll(authorListMap.get(tap[pos].getId()));
            //dbtmpTaxonAuthors.addAll(authorListMap.get(tap[pos].getId()));
            
            //for(TaxonAuthorDTO taxonAuthor: tmpTaxonAuthors)
            for(int posAuthor = 0; posAuthor < tmpTaxonAuthors.size();posAuthor++)
            {
                //TaxonAuthorDTO taxonAuthor = tmpTaxonAuthors.get(posAuthor);
                Long tmpPersonId = tmpTaxonAuthors.get(posAuthor).getTaxonAuthorPersonId();
                System.out.println("tmpPersonId = "+tmpPersonId);
                System.out.println("se encuentra en el map? "+allTaxonAuthors.containsKey(tmpPersonId));
                if(allTaxonAuthors.containsKey(tmpPersonId))
                {
            
                    Option tmpPersonAuthor = (Option) allTaxonAuthors.get(tmpPersonId);
                    tmpTaxonAuthors.get(posAuthor).setTaxonAuthorName(tmpPersonAuthor.getLabel());
                    //dbtmpTaxonAuthors.get(posAuthor).setTaxonAuthorName(tmpPersonAuthor.getLabel());
                    allTaxonAuthors.remove(tmpPersonId);
                }
                else
                {
                    System.out.println("\t\tNo cumple");
                    //USAR getName del Facade
                    //taxonAuthor.setTaxonAuthorName();
                }

                //set label connector
                if(tmpTaxonAuthors.get(posAuthor).getTaxonAuthorConnectorId() != null)
                {
                    
                    tmpTaxonAuthors.get(posAuthor).setTaxonAuthorConnector(getLabelConnector(tmpTaxonAuthors.get(posAuthor).getTaxonAuthorConnectorId()));
                    //dbtmpTaxonAuthors.get(posAuthor).setTaxonAuthorConnector(getLabelConnector(dbtmpTaxonAuthors.get(posAuthor).getTaxonId()));
                }
                else
                {
                    tmpTaxonAuthors.get(posAuthor).setTaxonAuthorConnector(",");
                    //dbtmpTaxonAuthors.get(posAuthor).setTaxonAuthorConnector(",");
                }
            }

            if(tmpTaxonAuthors.size() >1 && tmpTaxonAuthors.get(tmpTaxonAuthors.size()-2).getTaxonAuthorConnectorId()==null)
            {
                tmpTaxonAuthors.get(tmpTaxonAuthors.size()-2).setTaxonAuthorConnector("&");
            }
            //loadTaxonAuthorLabelConnectors(tmpTaxonAuthors);            
            authorListMap.put(tap[pos].getId(), tmpTaxonAuthors);
            //dbAuthorListMap.put(tap[pos].getId(), tmpTaxonAuthors);
            dbAuthorListMap.put(tap[pos].getId(), (List<TaxonAuthorDTO>)deepCopy(tmpTaxonAuthors));
            Set<Option> tmpOptions = new HashSet<Option>(allTaxonAuthors.values());
            taxonAuthorsMap.put(tap[pos].getId(), tmpOptions);
            
        }        
    }

    /**
     * @return the allTaxonAuthorsDBMap
     */
    public Map<Long, Option> getAllTaxonAuthorsDBMap() {
        return allTaxonAuthorsDBMap;
    }

    /**
     * @param allTaxonAuthorsDBMap the allTaxonAuthorsDBMap to set
     */
    public void setAllTaxonAuthorsDBMap(Map<Long, Option> allTaxonAuthorsDBMap) {
        this.allTaxonAuthorsDBMap = allTaxonAuthorsDBMap;
    }

    public void loadTaxonAuthorSequence()
    {        
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
        for(int pos = 0; pos < tap.length; pos++)
        {
            List<TaxonAuthorDTO> tmpList = new ArrayList<TaxonAuthorDTO>();
            tmpList.addAll(authorListMap.get(tap[pos].getId()));
            if(tmpList.size() != 0)
            {
                TaxonAuthorDTO tmpAuthor = tmpList.get(tmpList.size()-1);
                Long sequence = tmpAuthor.getTaxonAuthorSequence()+1;
                taxonAuthorSequenceMap.put(tap[pos].getId(), sequence);                
            }
            else
            {
                taxonAuthorSequenceMap.put(tap[pos].getId(), 1L);
            }
        }        
    }

    public void loadTaxonAuthorLabelConnectors(List<TaxonAuthorDTO> authors)
    {
        
        for(TaxonAuthorDTO author: authors)
        {
            if(author.getTaxonAuthorConnectorId() != null)
            {
                author.setTaxonAuthorConnector(getLabelConnector(author.getTaxonId()));
            }
            else
            {
                author.setTaxonAuthorConnector(",");
            }
        }

        if(authors.size() >1 && authors.get(authors.size()-1).getTaxonAuthorConnectorId()==null)
        {
            authors.get(authors.size()-1).setTaxonAuthorConnector("&");
        }

        

    }


    public void deleteTaxonAuthorByTaxonAuthorIds(List<TaxonAuthorDTO> taxonAuthorsDTO)
    {        
        this.getTaxonomyFacade().deleteTaxonAuthorByTaxonAuthorIds(taxonAuthorsDTO);
    }

    public void  updateTaxonAuthors(List<TaxonAuthorDTO> taxonAuthorsDTO)
    {        
        for(TaxonAuthorDTO taxonAuthorDTO: taxonAuthorsDTO)
        {
            taxonAuthorDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
            this.getTaxonomyFacade().updateTaxonAuthor(taxonAuthorDTO);
        }
    }

    /**
     * @return the dbAuthorListMap
     */
    public Map<Long, List<TaxonAuthorDTO>> getDbAuthorListMap() {
        return dbAuthorListMap;
    }

    /**
     * @param dbAuthorListMap the dbAuthorListMap to set
     */
    public void setDbAuthorListMap(Map<Long, List<TaxonAuthorDTO>> dbAuthorListMap) {
        this.dbAuthorListMap = dbAuthorListMap;
    }

    public String getAuthorsLabel()
    {
        String result ="";
        TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();

        for(int pos = 0; pos < tap.length; pos++)
        {
            List<TaxonAuthorDTO> tmpList = authorListMap.get(tap[pos].getId());
            for(TaxonAuthorDTO taxonAuthor :tmpList)
            {
                result +=taxonAuthor.getTaxonAuthorName()+" "+taxonAuthor.getTaxonAuthorConnector()+" ";
            }
            
            if(tap[pos].getIdentifier().equals("o") &&
                    (isCheckedParentheses()==true || ((pos+1 < tap.length) && authorListMap.get(tap[pos+1].getId()).size() > 0)))
            {
                result = "( "+result+" ) ";
            }

        }
        result = result.trim();


        return result;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }


   


}
