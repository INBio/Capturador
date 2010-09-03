/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.model.SelectItem;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.indicator.IndicatorSessionBean;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditTaxonomy2.java
 * @version Created on 09/08/2010, 06:34:51 PM
 * @author gsulca
 */

public class EditTaxonomy2 extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    /*
     * Variables para interfaz gráfica
     */
    private HtmlDataTable dataTableTaxonomy = new HtmlDataTable();

    private HtmlPanelGrid gridTaxonomy = new HtmlPanelGrid();

    private HtmlPanelGrid gridIndicatorTaxonomy = new HtmlPanelGrid();

    private HtmlPanelGrid taxonomy = new HtmlPanelGrid();


    /*
     * Elementos de la página web utilizados para almacenar la información del
     * nodo seleccionado en el árbol y así lograr el traspaso de información
     * entre jsp y javascript.
    */
    private HtmlInputHidden hiddenTaxonNodeId = new HtmlInputHidden();

    private HtmlInputHidden hiddenPathTaxonNode = new HtmlInputHidden();

    private HtmlInputHidden hiddenCollecNomenclGroupId = new HtmlInputHidden();
    private HtmlInputHidden hiddenTypeGroup = new HtmlInputHidden();
    
    private HtmlInputHidden hiddenNodeId = new HtmlInputHidden();
    private HtmlInputHidden hiddenPathNode = new HtmlInputHidden();

    private SelectItem[] ddRangeItems;
    private SelectItem[] ddCategoryItems;
    private SelectItem[] ddMonthItems;

    private SelectItem[] ddPruebaRange;
    private String tmpSelected = "";

    private Option[] indicatorRelations;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditTaxonomy2() {
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
            log("EditTaxonomy2 Initialization Failure", e);
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

        //System.out.println("Hizo PRERENDER");
        hiddenTaxonNodeId.setValue(this.getTaxonSessionBean().getTaxonNodeId());
        hiddenPathTaxonNode.setValue(this.getTaxonSessionBean().getPathTaxonNode());
        hiddenCollecNomenclGroupId.setValue(this.getTaxonSessionBean().getCollecNomenclGroupId());
        hiddenTypeGroup.setValue(this.getTaxonSessionBean().getTypeGroup());

        hiddenNodeId.setValue(this.getTaxonSessionBean().getNodeId());
        hiddenPathNode.setValue(this.getTaxonSessionBean().getPathNode());

        if(this.getTaxonSessionBean().getCurrentTaxon().getAuthorFormatParenthesis() == 1)
        {
            this.getTaxonSessionBean().setCheckedParentheses(true);
        }
        /*this.getTaxonSessionBean().setCurrentTaxon(
                this.getTaxonSessionBean().getTaxon(
                    new Long(this.getTaxonSessionBean().getNodeId())));
         * */
        //System.out.println("indicatorRelacions = "+indicatorRelations);
        if(this.getTaxonSessionBean().getIndicatorRelations() == null)
        {
            System.out.println("Entro a indicatorRelation = null");
            this.getTaxonSessionBean().setIndicatorRelations(
                    this.getTaxonSessionBean().getIndicatorByTaxon(this.getTaxonSessionBean().getCurrentTaxon().getTaxonKey()));
            this.getTaxonSessionBean().setDbIndicatorRelations(
                    this.getTaxonSessionBean().getIndicatorByTaxon(this.getTaxonSessionBean().getCurrentTaxon().getTaxonKey()));
            //indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
            //this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        }
        /*else
        {*/
          //  System.out.println("despues del if indicatorRelation = "+this.getTaxonSessionBean().getIndicatorRelations());
            indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
            //System.out.println("indicatorRelacion = "+ indicatorRelations);
            this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);

        //}
        /*
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if((indicatorNodeId == null) || (indicatorNodeId == 0))
        {
            //listbox1DefaultOptions.setOptions(null);
            indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        }
        */
        /*
        if(this.getTaxonSessionBean().getIndicatorRelations().size() > 0)
        {
            indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
            this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        }
         */

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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IndicatorSessionBean getindicator$IndicatorSessionBean() {
        return (IndicatorSessionBean) getBean("indicator$IndicatorSessionBean");
    }

   
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
    }

    /**
     * @return the dataTableTaxonomy
     */
    public HtmlDataTable getDataTableTaxonomy() {
        return dataTableTaxonomy;
    }

    /**
     * @param dataTableTaxonomy the dataTableTaxonomy to set
     */
    public void setDataTableTaxonomy(HtmlDataTable dataTableTaxonomy) {
        this.dataTableTaxonomy = dataTableTaxonomy;
    }

    /**
     * @return the gridTaxonomy
     */
    public HtmlPanelGrid getGridTaxonomy() {
        return gridTaxonomy;
    }

    /**
     * @param gridTaxonomy the gridTaxonomy to set
     */
    public void setGridTaxonomy(HtmlPanelGrid gridTaxonomy) {
        this.gridTaxonomy = gridTaxonomy;
    }

    /**
     * @return the gridIndicatorTaxonomy
     */
    public HtmlPanelGrid getGridIndicatorTaxonomy() {
        return gridIndicatorTaxonomy;
    }

    /**
     * @param gridIndicatorTaxonomy the gridIndicatorTaxonomy to set
     */
    public void setGridIndicatorTaxonomy(HtmlPanelGrid gridIndicatorTaxonomy) {
        this.gridIndicatorTaxonomy = gridIndicatorTaxonomy;
    }

    /**
     * @return the taxonomy
     */
    public HtmlPanelGrid getTaxonomy() {
        return taxonomy;
    }

    /**
     * @param taxonomy the taxonomy to set
     */
    public void setTaxonomy(HtmlPanelGrid taxonomy) {
        this.taxonomy = taxonomy;
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
    public void setHiddenTaxonNodeId(HtmlInputHidden hiddenTaxonNodeId) {
        this.hiddenTaxonNodeId = hiddenTaxonNodeId;
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
    public void setHiddenPathTaxonNode(HtmlInputHidden hiddenPathTaxonNode) {
        this.hiddenPathTaxonNode = hiddenPathTaxonNode;
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

    /**
     * @return the ddRangeItems
     */
    public SelectItem[] getDdRangeItems() {
         String hiddenNodeValue = this.getHiddenTaxonNodeId().getValue().toString();
         List<TaxonomicalRangeDTO> tmpTaxonomicalRange = this.getTaxonSessionBean().getNextLevelsByTaxon(new Long(this.getHiddenTaxonNodeId().getValue().toString()));
        ddRangeItems = new SelectItem[tmpTaxonomicalRange.size()];
        for(int pos = 0; pos < tmpTaxonomicalRange.size(); pos++)
        {
            TaxonomicalRangeDTO tmpRange = tmpTaxonomicalRange.get(pos);
            ddRangeItems[pos] = new SelectItem(tmpRange.getTaxonomicalRangeKey(),tmpRange.getName());
        }
        return ddRangeItems;
    }

    /**
     * @param ddRangeItems the ddRangeItems to set
     */
    public void setDdRangeItems(SelectItem[] ddRangeItems) {
        this.ddRangeItems = ddRangeItems;
    }

    /**
     * @return the ddCategoryItems
     */
    public SelectItem[] getDdCategoryItems() {
         List<TaxonCategoryDTO> tmpTaxonomicalCategory = this.getTaxonSessionBean().getAllTaxonCategory();
        ddCategoryItems = new SelectItem[tmpTaxonomicalCategory.size()];
        for(int pos = 0; pos < tmpTaxonomicalCategory.size(); pos++)
        {
            TaxonCategoryDTO tmpCategory = tmpTaxonomicalCategory.get(pos);
            ddCategoryItems[pos] = new SelectItem(tmpCategory.getTaxonCategoryId(),tmpCategory.getName());
        }
        return ddCategoryItems;
    }

    /**
     * @param ddCategoryItems the ddCategoryItems to set
     */
    public void setDdCategoryItems(SelectItem[] ddCategoryItems) {
        this.ddCategoryItems = ddCategoryItems;
    }

    /**
     * @return the ddMonthItems
     */
    public SelectItem[] getDdMonthItems() {
          ddMonthItems = this.getTaxonSessionBean().getMonths();
        return ddMonthItems;
    }

    /**
     * @param ddMonthItems the ddMonthItems to set
     */
    public void setDdMonthItems(SelectItem[] ddMonthItems) {
        this.ddMonthItems = ddMonthItems;
    }

    /**
     * @return the ddPruebaRange
     */
    public SelectItem[] getDdPruebaRange() {
        return ddPruebaRange;
    }

    /**
     * @param ddPruebaRange the ddPruebaRange to set
     */
    public void setDdPruebaRange(SelectItem[] ddPruebaRange) {
        this.ddPruebaRange = ddPruebaRange;
    }

    /**
     * @return the tmpSelected
     */
    public String getTmpSelected() {
        return tmpSelected;
    }

    /**
     * @param tmpSelected the tmpSelected to set
     */
    public void setTmpSelected(String tmpSelected) {
        this.tmpSelected = tmpSelected;
    }

    public String btnSaveTaxon_action()
    {

        //SAVE TAXON
        TaxonSessionBean TSB = this.getTaxonSessionBean();
        //set userName
         TSB.getCurrentTaxon().setUserName(this.getAraSessionBean().getGlobalUserName());
        //setCurrentPredecessorTimestamp
         TSB.getCurrentTaxon().setCurrentPredecessorTimestamp(TSB.getCurrentTaxon().getCurrentNameTimestamp());
        //setCurrentNameTimestamp
         TSB.getCurrentTaxon().setCurrentNameTimestamp(GregorianCalendar.getInstance());
        //setDefaultName
         String defaultTaxonName ="";
         if(TSB.getCurrentTaxon().getTaxonomicalRangeId() == 18){ // specie
             String[] names = TSB.getCurrentTaxon().getDefaultName().split(" ");
             defaultTaxonName = names[0]+TSB.getCurrentTaxon().getCurrentName();
         }else{
             defaultTaxonName = TSB.getCurrentTaxon().getCurrentName();
         }
         TSB.getCurrentTaxon().setDefaultName(defaultTaxonName);
        //set authorParenthesis
        if(TSB.isCheckedParentheses())
        {
            TSB.getCurrentTaxon().setAuthorFormatParenthesis(new Short("1"));
        }
        else
        {
            TSB.getCurrentTaxon().setAuthorFormatParenthesis(new Short("0"));
        }
        TSB.updateTaxon(TSB.getCurrentTaxon());

        //SAVE TAXON-INDICATOR
        if(this.getTaxonSessionBean().getIndicatorRelations() != null || this.getTaxonSessionBean().getIndicatorRelations().size()>0)
        {
        //Parche feo que luego debo arreglar, al comparar Option no quiere reconocer los que son iguales
            List<String> newIndicatorTaxonIds = new ArrayList<String>();

            System.out.println("Los elementos de la bd son");
            List<String> copiaDb = new ArrayList<String>();
            for(Option p: TSB.getDbIndicatorRelations())
            {
                //System.out.println("Element "+p.getValue()+" - "+p.getLabel());
                copiaDb.add(p.getValue().toString());

            }
            System.out.println("Los elementos de la seleccionados son");
            List<String> copiaSelected = new ArrayList<String>();
            for(Option q: TSB.getIndicatorRelations())
            {
                //System.out.println("Element "+q.getValue()+" - "+q.getLabel());
                copiaSelected.add(q.getValue().toString());

            }

            //System.out.println("Comparacion "+TSB.getIndicatorRelations().toArray()[0].equals(TSB.getDbIndicatorRelations().toArray()[0]));
            //for(Option element: TSB.getIndicatorRelations())
            for(String element: copiaSelected)
            {
                //System.out.println("--- Revisando el elemento "+element.getLabel()+" "+TSB.getDbIndicatorRelations().contains(element));
               /* if(TSB.getDbIndicatorRelations().contains(element))
                {
                    System.out.println("Contiene el elemento "+element.getLabel());
                }*/
                if(copiaDb.contains(element))
                {
                  //  System.out.println("Contiene el elemento "+element.getLabel());
                      System.out.println("Contiene el elemento "+element);
                      copiaDb.remove(element);
                }
                else
                {
                    System.out.println("Agregar elemento nuevo "+element);
                    newIndicatorTaxonIds.add(element);
                }
            }
            TSB.saveTaxonIndicatorIds(TSB.getCurrentTaxon().getTaxonKey(), newIndicatorTaxonIds,this.getAraSessionBean().getGlobalUserName());
            TSB.deleteTaxonIndicatorByIds(TSB.getCurrentTaxon().getTaxonKey(), copiaDb);
        }
        return "back";
    }

    public String btnAddTaxonIndicator_action()
    {
        this.getTaxonSessionBean().setNodeId(this.getHiddenNodeId().getValue().toString());
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if(this.getTaxonSessionBean().isLeaf(indicatorNodeId)){
            IndicatorDTO infoNodo = this.getTaxonSessionBean().getIndicatorDTOByIndicatorId(indicatorNodeId);
            this.getTaxonSessionBean().getIndicatorRelations().add(new Option(indicatorNodeId, infoNodo.getName() ));
            /*
            Option[] tmp2 = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
            this.getTaxonSessionBean().getIndicatorRelations().toArray(tmp2);
            listbox1DefaultOptions.setOptions(tmp2);
             */
            indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
            this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        }
        else
        {
             MessageBean.setErrorMessageFromBundle("error_taxon_indicator",this.getMyLocale());

        }
        return null;
        
    }

    public String btnRemoveTaxonIndicator_action()
    {
        this.getTaxonSessionBean().removeOption(this.getTaxonSessionBean().getElementSelected());
        indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        return null;
    }

    /**
     * @return the indicatorRelations
     */
    public Option[] getIndicatorRelations() {
        return indicatorRelations;
    }

    /**
     * @param indicatorRelations the indicatorRelations to set
     */
    public void setIndicatorRelations(Option[] indicatorRelations) {
        this.indicatorRelations = indicatorRelations;
    }

    /**
     * @return the hiddenNodeId
     */
    public HtmlInputHidden getHiddenNodeId() {
        return hiddenNodeId;
    }

    /**
     * @param hiddenNodeId the hiddenNodeId to set
     */
    public void setHiddenNodeId(HtmlInputHidden hiddenNodeId) {
        this.hiddenNodeId = hiddenNodeId;
    }

    /**
     * @return the hiddenPathNode
     */
    public HtmlInputHidden getHiddenPathNode() {
        return hiddenPathNode;
    }

    /**
     * @param hiddenPathNode the hiddenPathNode to set
     */
    public void setHiddenPathNode(HtmlInputHidden hiddenPathNode) {
        this.hiddenPathNode = hiddenPathNode;
    }

     /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }
    
}

