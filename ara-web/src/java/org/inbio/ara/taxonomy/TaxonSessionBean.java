/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.indicator.IndicatorFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.util.AddRemoveList;

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

public class TaxonSessionBean extends AbstractSessionBean {
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

    private Long taxonomicalRangeSelected;
    private Long taxonomicalCategorySelected;
    private Long monthSelected = 1L;
    private boolean checkedParentheses;

    private String taxonName;
    private String basionymName;
    private Long year;
    private String taxonomicalRangeName = "";


    private Set<Option> indicatorRelations = new HashSet<Option>();
    private Set<Option> dbIndicatorRelations = new HashSet<Option>();
    private Long elementSelected;

    private Long ddIndicatorSelected = null;
    
    private String taxonTabSelected = "tabNewTaxonomy";

    private AddRemoveList arContries = new AddRemoveList();
    
    
    private Map<Long, Option[]> selectedTaxonIndicatorCountriesId = new HashMap<Long, Option[]>();




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
        //System.out.println("SET = "+taxonomicalRangeSelected);
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

   /*
     * Send to persis a TaxonDTO to the database
     * @param aDTO
     */
    public void saveTaxon(TaxonDTO aDTO){
        currentTaxon = this.taxonomyFacade.saveTaxon(aDTO);
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

    public void  removeOption(Long elementDeleted)
    {
        for(Option element: indicatorRelations)
        {
            Long idElement = new Long(element.getValue().toString());
            System.out.println("*** el id del elemento evaluado es "+element.getValue());
            if(idElement.equals(elementDeleted))
            {
                System.out.println("*** Elemento eliminado "+element.getValue()+" -> "+element.getLabel());
                indicatorRelations.remove(element);
                break;
            }

        }
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


    public void saveTaxonIndicatorIds (Long taxonId, List<String> indicatorIds, String userName)
    {
        this.getTaxonomyFacade().saveTaxonIndicators(taxonId, indicatorIds, userName);
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
        System.out.println("GET_INDICATOR_BY_TAXON -> taxonId ="+taxonId);
        Set <Option> result = new HashSet<Option>();
        List<Long> indicatorIds = taxonomyFacade.getIndicatorIdsByTaxon(taxonId);
        System.out.println("GET_INDICATOR_BY_TAXON -> indicatorIds ="+indicatorIds.size());
        for(Long indicatorId: indicatorIds)
        {
            IndicatorDTO indicator = indicatorFacade.getIndicatorByIndicatorId(indicatorId);
            result.add(new Option(indicatorId,indicator.getName()));
        }

        System.out.println("GET_INDICATOR_BY_TAXON -> result ="+result.size());
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

}
