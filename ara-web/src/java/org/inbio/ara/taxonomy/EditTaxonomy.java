/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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
import com.sun.webui.jsf.component.Tree;
import com.sun.webui.jsf.component.TreeNode;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRangeEntity;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to EditTaxonomy.jsp.  This
 * class contains component definitions (and initialization code) for
 * all components defined on this page, as well as
 * lifecycle methods and event handlers</p>
 *
 * @version Created on 17/11/2009, 09:53:45 AM
 * @author asanabria
 */

public class EditTaxonomy extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private Tree	 displayTree		  = new Tree();

    // Default Constructor
    public EditTaxonomy() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.</p>
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
            log("EditTaxonomy Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.</p>
     */
    @Override
    public void prerender() {
        this.loadCollections();
        this.loadTree();
    }

    /**
     * <p>Callback method that is called just after rendering takes place.</p>
     */
    @Override
    public void destroy() {
    }


        /**
     * update the selected taxon.
     * @return null
     */
    public String btnUpdateAction(){

        TaxonomySessionBean tST = null;
        TaxonDTO currentTaxon = null;
        String	 clickedNodeId = null;
        String  taxonRangeName = null;

        tST = this.getTaxonomySessionBean();

        // Gets the current selected Tree node item
        clickedNodeId = this.displayTree.getSelected();

        //If there isn't a selected node
        if(clickedNodeId==null){
            MessageBean.setErrorMessageFromBundle("not_selected_node",
                    this.getMyLocale());
            return null;
        }

        // Gets the current taxonDTO
        if(tST.getTaxonId() != null){
            currentTaxon = tST.getTaxon(tST.getTaxonId());

           TreeNode node = this.displayTree.getChildNode(clickedNodeId);
           TreeNode parent = Tree.getParentTreeNode(node);
            
           this.updateTaxon(currentTaxon, parent.getText());

			//Refresh the Tree
            taxonRangeName = tST.getTaxonRangeName(Long.valueOf(currentTaxon.getTaxonomicalRangeId()));

            node.setText(currentTaxon.getCurrentName() + " ("+taxonRangeName+")");
            this.treeItemClickHandler();
        }

        return null;
    }

    /**
     * Add a taxon under the currently selected taxon.
     * @return null
     */
    public String btnAddAction(){

        TaxonomySessionBean tST = null;
        TaxonDTO currentTaxon = null;
        TaxonDTO newTaxon = null;
        String	 clickedNodeId = null;

        tST = this.getTaxonomySessionBean();

        // Gets the current selected Tree node item
        clickedNodeId = this.displayTree.getSelected();

        //If there isn't a selected node
        if(clickedNodeId==null){
            MessageBean.setErrorMessageFromBundle("not_selected_node",
                    this.getMyLocale());
            return null;
        }

        // Gets the current taxonDTO
        if(tST.getTaxonId() != null){
            currentTaxon = tST.getTaxon(tST.getTaxonId());

            //Validate if the node is an species
            if (currentTaxon.getTaxonomicalRangeId().equals
                    (TaxonomicalRangeEntity.SPECIES.getId())) {
                MessageBean.setErrorMessageFromBundle("cant_add_taxon_under_this_level",
                        this.getMyLocale());
                return null;
            }

            newTaxon = this.saveNewTaxon(currentTaxon);

            if(newTaxon == null)
                return null;

			addTreeItems(clickedNodeId);
            this.treeItemClickHandler();
        }

        return null;
    }


    	/**
	 * complete the data necesary to create a new Taxon
	 * @param newTaxon
	 * @return a TaxonDTO
	 */
	private TaxonDTO updateTaxon(TaxonDTO updatedTaxon, String parentNodeName){

		TaxonomySessionBean tST = null;
        String taxonName = null;
        String cleanParentName = null;

		tST = this.getTaxonomySessionBean();

		// create the taxonDTO to create the new TreeNode
		updatedTaxon.setAncestorId(updatedTaxon.getAncestorId());
		updatedTaxon.setTaxonKey(updatedTaxon.getTaxonKey());

        updatedTaxon.setUserName(this.getAraSessionBean().getGlobalUserName());
		updatedTaxon.setCollectionId(tST.getSelectedCollection());

        updatedTaxon.setCurrentPredecessorTimestamp(updatedTaxon.getCurrentNameTimestamp());
        updatedTaxon.setCurrentNameTimestamp(GregorianCalendar.getInstance());

        if(updatedTaxon.getTaxonomicalRangeId() == 18){ // specie
            cleanParentName = parentNodeName.substring(0, parentNodeName.indexOf(' '));
            taxonName = cleanParentName+" "+tST.getTaxonName();
        }else{
            taxonName = tST.getTaxonName();
        }

        updatedTaxon.setDefaultName(taxonName);
        updatedTaxon.setCurrentName(tST.getTaxonName());

        if(updatedTaxon == null){
            MessageBean.setErrorMessageFromBundle("cant_add_taxon_under_this_level", this.getMyLocale());
            return null;
        }

		// save the new taxon into the database.
		tST.updateTaxon(updatedTaxon);

		return updatedTaxon;
	}


	/**
	 * complete the data necesary to create a new Taxon
	 * @param newTaxon
	 * @return a TaxonDTO
	 */
	private TaxonDTO saveNewTaxon(TaxonDTO newTaxon){

		TaxonomySessionBean tST = null;
        String taxonName = null;

		tST = this.getTaxonomySessionBean();

		// create the taxonDTO to create the new TreeNode
		newTaxon.setAncestorId(newTaxon.getTaxonKey());
		newTaxon.setTaxonKey(null);

        newTaxon.setUserName(this.getAraSessionBean().getGlobalUserName());
		newTaxon.setCollectionId(tST.getSelectedCollection());

        newTaxon.setCurrentPredecessorTimestamp(newTaxon.getCurrentNameTimestamp());
        newTaxon.setCurrentNameTimestamp(GregorianCalendar.getInstance());

		newTaxon = this.setFullTaxonomicalAttributes(newTaxon);

        if(newTaxon.getTaxonomicalRangeId() == 18){ // specie
            taxonName = newTaxon.getCurrentName()+" "+tST.getTaxonName();
        }else{
            taxonName = tST.getTaxonName();
        }

        newTaxon.setDefaultName(taxonName);
        newTaxon.setCurrentName(tST.getTaxonName());

        if(newTaxon == null){
            MessageBean.setErrorMessageFromBundle("cant_add_taxon_under_this_level", this.getMyLocale());
            return null;
        }


		// save the new taxon into the database.
		tST.saveTaxon(newTaxon);

		return newTaxon;
	}

    /**
     * Set the apropiate attribute acordind to the taxonomical range
     * @param taxon
     * @return the taxon with the atribute set.
     */
    private TaxonDTO setFullTaxonomicalAttributes(TaxonDTO taxon){
        TaxonomySessionBean tST = null;

        Long taxonomicalRangeId = taxon.getTaxonomicalRangeId();
        Long ancestorId = taxon.getAncestorId();

        //Only Mandatory Levels
        switch(taxonomicalRangeId.intValue()){

            case 23:	// Dominium
                taxon.setDominiumTaxonId(ancestorId);
                break;
            case 18:	// Specie
                taxon.setSpeciesTaxonId(ancestorId);
                break;
            case 13:	// Genus
                taxon.setGenusTaxonId(ancestorId);
                break;
            case 9:		// Family
                taxon.setFamilyTaxonId(ancestorId);
                break;
            case 6:		// Order
                taxon.setOrderTaxonId(ancestorId);
                break;
            case 4:		// Class
                taxon.setClassTaxonId(ancestorId);
                break;
            case 2:		//Phylum or Division
                taxon.setPhylumDivisionTaxonId(ancestorId);
                break;
            case 1:		// Kingdom
                taxon.setKingdomTaxonId(ancestorId);
                break;
        }

		tST = this.getTaxonomySessionBean();

		taxonomicalRangeId =
			tST.getNextMandatoryTaxonomicalLevel(
			taxon.getTaxonomicalRangeId());

        if(taxonomicalRangeId != null)
            taxon.setTaxonomicalRangeId(taxonomicalRangeId);
        else
            taxon = null;

        return taxon;
    }

    /**
     * Delete the selected taxon in the tree component
     * @return null
     */
    public String btnDeleteAction(){

        TaxonomySessionBean tST = null;
        String clickedNodeId = null;
        Long taxonId = null;

        tST = this.getTaxonomySessionBean();
        clickedNodeId = displayTree.getSelected();
        taxonId = tST.getTaxonId();

        //If there isn't a selected node
        if(clickedNodeId==null){
            MessageBean.setErrorMessageFromBundle("not_selected_node",
                    this.getMyLocale());
            return null;
        }

        //The root element canot be deleted
        if (tST.getTaxon(taxonId).getTaxonomicalRangeId().equals
                (TaxonomicalRangeEntity.ROOT.getId())) {
            MessageBean.setErrorMessageFromBundle("cant_delete_root_element",
                    this.getMyLocale());
            return null;
        }

        // Verify that TreeNode doesn't have children
        if (tST.getTaxonChildrenCount(taxonId) <= 0) {

            // Check if taxon has associated nomencalturalgroups
            if(tST.getAssociatedNumenclaturalG(taxonId) > 0L){
                MessageBean.setErrorMessageFromBundle("has_associated_nomenclatural",
                        this.getMyLocale());
                return null;
            }

            // Verify if the taxon doesn't has related specimens
            if (tST.getAssociatedSpecimenCount(taxonId) <= 0) {
                //Proceed to delete the node
                try {
                    tST.removeTaxon(taxonId);
                } catch (Exception e) {
                    MessageBean.setErrorMessageFromBundle("imposible_to_delete",
                            this.getMyLocale());
                    return null;
                }
                //Refresh the Tree
                TreeNode node = this.displayTree.getChildNode(clickedNodeId);
                TreeNode parent = TreeNode.getParentTreeNode(node);
                parent.getChildren().clear();
                this.displayTree.setSelected(parent.getId());
                this.addTreeItems(parent.getId());
                this.treeItemClickHandler();
            } else { //The node has associated specimens
                MessageBean.setErrorMessageFromBundle("has_associated_specimen",
                        this.getMyLocale());
            }
        } else { //The node has children
            MessageBean.setErrorMessageFromBundle("has_children",
                    this.getMyLocale());
        }
        return null;
    }

    /**
     * Load all the available collections in the dropdown of the jsp page.
     */
    private void loadCollections(){

        // convert the list from List<CollectionDTO> to Option[]
        TaxonomySessionBean tST = this.getTaxonomySessionBean();
        List<CollectionDTO> collections = tST.getAllCollections();
        List<Option> temp = new ArrayList<Option>();
        Option anOption = null;

        for( CollectionDTO aCDTO : collections){
            anOption = new Option();
            anOption.setValue(aCDTO.getCollectionId());
            anOption.setLabel(aCDTO.getCollectionName());
            temp.add(anOption);
        }

        // set the available collections
        tST.setAvailableCollections(temp.toArray(new Option[temp.size()]));
    }

    /**
     * Load taxonomical hierarchy data to the taxonomical tree in the jsp page
     */
    private void loadTree(){

        TreeNode newNode = null;
        TaxonomySessionBean tST = null;
        List<TaxonDTO> taxonDTOList = null;
        String treeNodeId = null;

        if(this.displayTree.getChildCount() <= 0){

            tST = this.getTaxonomySessionBean();
            // look for the dominium level taxon
            taxonDTOList = tST.getAllTaxonByRange(0L);

            for(TaxonDTO taxonDTO : taxonDTOList){

                treeNodeId = "i-"+taxonDTO.getTaxonomicalRangeId()
                    +"-"
                    +taxonDTO.getTaxonKey();

                newNode = createNode(treeNodeId, taxonDTO.getCurrentName());
                displayTree.getChildren().add(newNode);

            }
        }
    }

    /**
     * Create a TreeNode Class with the information privided as parameters.
     * @param id	: taxon id.
     * @param name	: taxon name
     * @return TreeNode
     */
    private TreeNode createNode(String id, String name){


        ELContext elContext = null;
        ExpressionFactory expressionFactory = null;
        MethodExpression actionMethod = null;
        TreeNode aNode =  null;


        // create the action method to every node in the tree.
        elContext = FacesContext.getCurrentInstance().getELContext();
        expressionFactory = this.getApplication().getExpressionFactory();

        actionMethod =
            expressionFactory.createMethodExpression(
            elContext
            , "#{taxonomy$EditTaxonomy.treeItemClickHandler}"
            , String.class
            , new Class[] {});

        // Create the note to add
        aNode = new TreeNode();

        aNode.setId(id);
        aNode.setText(name);
        aNode.setActionExpression(actionMethod);
        aNode.setVisible(true);

        return aNode;
    }

    /**
     * Click event handler for the Tree items
     * @return null
     */
    public String treeItemClickHandler(){

        String clickedNodeId = null;

        clickedNodeId = this.displayTree.getSelected();

        if(clickedNodeId != null && !clickedNodeId.isEmpty()){


            // expand the tree item to show the new added nodes
            addTreeItems(clickedNodeId);

            /* sets the data from the selected treeNode to the form display
             * form
             */
            setDisplayData(clickedNodeId);

        }

        return null;
    }

    /**
     * takes the data from the taxon and set it to the from.
     * @param clickedNodeId
     */
    private void setDisplayData(String clickedNodeId){
        TaxonomySessionBean tST = null;
        String[] clickedNodeInfo = null;
        String taxonomicalRangeName = null;
        TaxonDTO taxonDTO = null;

        /**
         * results spected in this order:
         *     [1] hierarchy level
         *     [2] taxon id
         */
        clickedNodeInfo = clickedNodeId.split("-");

        // load the SessionBean to comunicate with the facade
        tST = this.getTaxonomySessionBean();

        // Gets the information
        taxonDTO = tST.getTaxon(Long.valueOf(clickedNodeInfo[2]));

        taxonomicalRangeName = tST.getTaxonRangeName(taxonDTO.getTaxonomicalRangeId());

        // Sets the information
        tST.setTaxonId(taxonDTO.getTaxonKey());
        tST.setTaxonName(taxonDTO.getCurrentName());
        tST.setTaxonomicalLevel(taxonomicalRangeName);
        tST.setSelectedCollection(taxonDTO.getCollectionId());
    }

    /**
     * Expand a TreeItem according to the taxonId
     * @param taxonId
     */
    private void addTreeItems(String clickedNodeId) {

        TaxonomySessionBean tST = null;
        String[] clickedNodeInfo = null;
        List<TaxonDTO> taxonChildren = null;
        TreeNode currentNode = null;

        /**
         * results spected in this order:
         *     [1] hierarchy level
         *     [2] taxon id
         */
        clickedNodeInfo = clickedNodeId.split("-");

        // load the SessionBean to comunicate with the facade
        tST = this.getTaxonomySessionBean();


        // converts the taxon children into TreeNode and append it to the tree
        currentNode = this.displayTree.getChildNode(clickedNodeId);

        /*look for the taxa under the current taxon according to the
         * taxonomical hierarchy
         */
        taxonChildren = tST.getTaxonChildren(Long.valueOf(clickedNodeInfo[2]));

        // add the provided nodes to the current node
        addNewChildList(currentNode, taxonChildren);

    }

    /**
     * Convert a taxon list into TreeNodes and add it at the end of the
     * currentNode children list.
     * @param currentNode
     * @param taxonList
     */
    private void addNewChildList(TreeNode currentNode, List<TaxonDTO> taxonList){

        TaxonomySessionBean tST = null;
        TreeNode newNode = null;

        String treeNodeKey = null;
        String taxonRangeId = null;
        String taxonRangeName = null;
        String treeNodeDisplayName = null;

        // load the SessionBean to comunicate with the facade
        tST = this.getTaxonomySessionBean();
        /*
         * 1. Iterates over the retrieved taxa
         * 2. convert every taxon into a TreeNode Object
         * 3. add the new TreeNode to the displayTree
         */

        for(TaxonDTO currentTaxon : taxonList ){
            newNode = new TreeNode();

            taxonRangeId = currentTaxon.getTaxonomicalRangeId().toString();

            taxonRangeName = tST.getTaxonRangeName(Long.valueOf(taxonRangeId));

            treeNodeDisplayName =
                currentTaxon.getCurrentName() + " ("+taxonRangeName+") ";


            treeNodeKey = "i-"+taxonRangeId
                +"-"
                +currentTaxon.getTaxonKey();

            /* look if the treeNodeKey already exist in the tree
             * if not, creates the newNode an add it to the Tree.
             */
            if(this.displayTree.getChildNode(treeNodeKey) == null){

                newNode = this.createNode(treeNodeKey, treeNodeDisplayName);

                currentNode.getChildren().add(newNode);
            }
        }
    }


    /**
     * Return the Session bean corresponding to this module;
     * @return TaxonomySessionBean
     */
    protected TaxonomySessionBean getTaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
    }

     /*
      * Return the Application bean corresponding to the ara software
      * @return reference to the Ara application bean
      */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }


    /** Getters and Setters */
    public Tree getDisplayTree() {
        return displayTree;
    }

    public void setDisplayTree(Tree displayTree) {
        this.displayTree = displayTree;
    }

}