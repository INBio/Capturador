/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import org.inbio.ara.*;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRangeEntity;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListTaxonomy.java
 * @version Created on 19/07/2010, 04:16:59 PM
 * @author gsulca
 */

public class ListTaxonomy extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    
    private HtmlPanelGrid gridIndicator = new HtmlPanelGrid();
    private HtmlPanelGrid indicator = new HtmlPanelGrid();
    private HtmlInputHidden hiddenTaxonNodeId = new HtmlInputHidden();
    private HtmlInputHidden hiddenPathTaxonNode = new HtmlInputHidden();
    private HtmlInputHidden hiddenCollecNomenclGroupId = new HtmlInputHidden();
    private HtmlInputHidden hiddenTypeGroup = new HtmlInputHidden();
    private HtmlInputHidden hiddenTaxonNodeName = new HtmlInputHidden();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListTaxonomy() {
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
            log("ListTaxonomy Initialization Failure", e);
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
        if(this.getAraSessionBean().getGlobalNomenclaturalGroupId()> -1)
        {
            System.out.println("Es de tipo nomenclatural "+this.getAraSessionBean().getGlobalNomenclaturalGroupId() );
            this.hiddenTypeGroup.setValue(1);
            this.hiddenCollecNomenclGroupId.setValue(this.getAraSessionBean().getGlobalNomenclaturalGroupId());
           
        }
        else
        {
             System.out.println("Es de tipo collection "+this.getAraSessionBean().getGlobalCollectionId() );
            this.hiddenTypeGroup.setValue(0);
            this.hiddenCollecNomenclGroupId.setValue(this.getAraSessionBean().getGlobalCollectionId());

        }
        //Valor default cuando no se puede desplegar el árbol
        this.hiddenTaxonNodeId.setValue(-1);
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



    protected TaxonSessionBean getTaxonSessionBean() {
        return (TaxonSessionBean) getBean("taxonomy$TaxonSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

        
    /**
     * @return the gridIndicator
     */
    public HtmlPanelGrid getGridIndicator() {
        return gridIndicator;
    }

    /**
     * @param gridIndicator the gridIndicator to set
     */
    public void setGridIndicator(HtmlPanelGrid gridIndicator) {
        this.gridIndicator = gridIndicator;
    }

    /**
     * @return the indicator
     */
    public HtmlPanelGrid getIndicator() {
        return indicator;
    }

    /**
     * @param indicator the indicator to set
     */
    public void setIndicator(HtmlPanelGrid indicator) {
        this.indicator = indicator;
    }

    /**
     * @return the hiddenNodeId
     */
    public HtmlInputHidden getHiddenTaxonNodeId() {
        return hiddenTaxonNodeId;
    }

    /**
     * @param hiddenNodeId the hiddenNodeId to set
     */
    public void setHiddenTaxonNodeId(HtmlInputHidden hiddenNodeId) {
        this.hiddenTaxonNodeId = hiddenNodeId;
    }

    /**
     * @return the hiddenPathNode
     */
    public HtmlInputHidden getHiddenPathTaxonNode() {
        return hiddenPathTaxonNode;
    }

    /**
     * @param hiddenPathNode the hiddenPathNode to set
     */
    public void setHiddenPathTaxonNode(HtmlInputHidden hiddenPathNode) {
        this.hiddenPathTaxonNode = hiddenPathNode;
    }

    /**
     * @return the hiddenCollecNomenclGroupId
     */
    public HtmlInputHidden getHiddenCollecNomenclGroupId() {
        return hiddenCollecNomenclGroupId;
    }

    /**
     * @param hiddenCollecNomenclGroupId the hiddenCollecNomenclGroupId to set
     */
    public void setHiddenCollecNomenclGroupId(HtmlInputHidden hiddenCollecNomenclGroupId) {
        this.hiddenCollecNomenclGroupId = hiddenCollecNomenclGroupId;
    }

    /**
     * @return the hiddenTypeGroup
     */
    public HtmlInputHidden getHiddenTypeGroup() {
        return hiddenTypeGroup;
    }

    /**
     * @param hiddenTypeGroup the hiddenTypeGroup to set
     */
    public void setHiddenTypeGroup(HtmlInputHidden hiddenTypeGroup) {
        this.hiddenTypeGroup = hiddenTypeGroup;
    }

    public String btnNewIndicator_action() {
        String result =null;
        TaxonDTO taxon = this.getTaxonSessionBean().getTaxon(new Long(hiddenTaxonNodeId.getValue().toString()));
        //Validate if the node is an species //CAMBIAR AL NIVEL TAXONOMICO MAS BAJO
        if (taxon.getTaxonomicalRangeId().equals
                (TaxonomicalRangeEntity.FORM.getId())) {
            MessageBean.setErrorMessageFromBundle("cant_add_taxon_under_this_level",
                    this.getMyLocale());
            //return null;
        }
        else
        {

            this.getTaxonSessionBean().setCurrentTaxon(null);
            this.getTaxonSessionBean().setBasionymName(null);
            this.getTaxonSessionBean().setCheckedParentheses(false);
            this.getTaxonSessionBean().setMonthSelected(null);
            this.getTaxonSessionBean().setTaxonName(null);
            this.getTaxonSessionBean().setTaxonomicalCategorySelected(null);
            this.getTaxonSessionBean().setTaxonomicalRangeSelected(null);
            this.getTaxonSessionBean().setYear(null);
            this.getTaxonSessionBean().setTaxonNodeId(this.hiddenTaxonNodeId.getValue().toString());
            this.getTaxonSessionBean().setPathTaxonNode(this.hiddenPathTaxonNode.getValue().toString());
            this.getTaxonSessionBean().setTaxonNodeName(this.hiddenTaxonNodeName.getValue().toString());
            this.getTaxonSessionBean().setCollecNomenclGroupId(this.hiddenCollecNomenclGroupId.getValue().toString());
            this.getTaxonSessionBean().setTypeGroup(this.hiddenTypeGroup.getValue().toString());
            //System.out.println(" Almacenado en List Taxonomy ");
            //System.out.println(" \tNodeId "+this.getTaxonSessionBean().getNodeId());
            //System.out.println(" \tPath "+this.getTaxonSessionBean().getPathNode());
            result = "new";
        }

        return result;
    }

    public String btnDeleteIndicator_action() {

        TaxonSessionBean TSB = this.getTaxonSessionBean();

        Long taxonId = new Long(this.hiddenTaxonNodeId.getValue().toString());
        //If there isn't a selected node
        if(hiddenTaxonNodeId.getValue()==null){
            MessageBean.setErrorMessageFromBundle("not_selected_node",
                    this.getMyLocale());
            return null;
        }
        
        // Verify that TreeNode doesn't have children
        if (TSB.getTaxonChildrenCount(taxonId) <= 0) {

            // Check if taxon has associated nomencalturalgroups
            if(TSB.getAssociatedNumenclaturalG(taxonId) > 0L){
                MessageBean.setErrorMessageFromBundle("has_associated_nomenclatural",
                        this.getMyLocale());
                return null;
            }

            // Verify if the taxon doesn't has related specimens
            if (TSB.getAssociatedSpecimenCount(taxonId) <= 0) {
                //Proceed to delete the node
                try {
                    TSB.removeTaxon(taxonId);
                } catch (Exception e) {
                    MessageBean.setErrorMessageFromBundle("imposible_to_delete",
                            this.getMyLocale());
                    return null;
                }
                
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

    public String btnEditIndicator_action() {

        this.getTaxonSessionBean().setCurrentTaxon(null);
        this.getTaxonSessionBean().setBasionymName(null);
        this.getTaxonSessionBean().setCheckedParentheses(false);
        //this.getTaxonSessionBean().setMonthSelected(null);
        this.getTaxonSessionBean().setTaxonName(null);
        //this.getTaxonSessionBean().setTaxonomicalCategorySelected(null);
        //this.getTaxonSessionBean().setTaxonomicalRangeSelected(null);
        this.getTaxonSessionBean().setYear(null);
        this.getTaxonSessionBean().setTaxonNodeId(this.hiddenTaxonNodeId.getValue().toString());
        this.getTaxonSessionBean().setPathTaxonNode(this.hiddenPathTaxonNode.getValue().toString());
        this.getTaxonSessionBean().setTaxonNodeName(this.hiddenTaxonNodeName.getValue().toString());
        this.getTaxonSessionBean().setCollecNomenclGroupId(this.hiddenCollecNomenclGroupId.getValue().toString());
        this.getTaxonSessionBean().setTypeGroup(this.hiddenTypeGroup.getValue().toString());
        this.getTaxonSessionBean().setCurrentTaxon(
                this.getTaxonSessionBean().getTaxon(
                    new Long(this.getTaxonSessionBean().getTaxonNodeId())));
        this.getTaxonSessionBean().setTaxonomicalRangeName(
                this.getTaxonSessionBean().getTaxonRangeName(
                    this.getTaxonSessionBean().getCurrentTaxon().getTaxonomicalRangeId()).getName());

        this.getTaxonSessionBean().setNodeId("0");
        this.getTaxonSessionBean().setPathNode("");
        this.getTaxonSessionBean().setIndicatorRelations(null);
        return "edit";
    }

    /**
     * @return the hiddenTaxonNodeName
     */
    public HtmlInputHidden getHiddenTaxonNodeName() {
        return hiddenTaxonNodeName;
    }

    /**
     * @param hiddenTaxonNodeName the hiddenTaxonNodeName to set
     */
    public void setHiddenTaxonNodeName(HtmlInputHidden hiddenTaxonNodeName) {
        this.hiddenTaxonNodeName = hiddenTaxonNodeName;
    }
    
}

