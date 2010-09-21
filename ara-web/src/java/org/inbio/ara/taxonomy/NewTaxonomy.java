/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;


import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.model.SelectItem;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRangeEntity;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewTaxonomy.java
 * @version Created on 21/07/2010, 06:19:12 PM
 * @author gsulca
 */

public class NewTaxonomy extends AbstractPageBean {
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

    private DropDown ddIndicators= new DropDown();
    private TabSet taxonTabs= new TabSet();

    private SelectItem[] ddRangeItems;
    private SelectItem[] ddCategoryItems;
    private SelectItem[] ddMonthItems;
   
    private SelectItem[] ddPruebaRange;
    private String tmpSelected = "";

    private Option[] indicatorRelations;

    private DefaultOptionsList listbox1DefaultOptions = new DefaultOptionsList();

    

    

   

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewTaxonomy() {
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
            log("NewTaxonomy Initialization Failure", e);
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

        TaxonSessionBean tsb = this.getTaxonSessionBean();
             System.out.println("Hizo prerender");
             //System.out.println("Antes de cambiar hiddenNodeId = "+hiddenTaxonNodeId.getValue());
        //Set hidden value from session bean
        hiddenTaxonNodeId.setValue(tsb.getTaxonNodeId());
        hiddenPathTaxonNode.setValue(tsb.getPathTaxonNode());
        hiddenCollecNomenclGroupId.setValue(tsb.getCollecNomenclGroupId());
        hiddenTypeGroup.setValue(tsb.getTypeGroup());     
        hiddenNodeId.setValue(tsb.getNodeId());
        hiddenPathNode.setValue(tsb.getPathNode());

                
        //Set
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if((indicatorNodeId == null) || (indicatorNodeId == 0))
        {
            listbox1DefaultOptions.setOptions(null);
        }

        if(tsb.getIndicatorRelations().size() > 0)
        {
            indicatorRelations = new Option[tsb.getIndicatorRelations().size()];
            tsb.getIndicatorRelations().toArray(indicatorRelations);
        }

        if(tsb.getTaxonTabSelected().equals("tabTaxonIndicatorCountry"))
        {
            loadAddRemoveData(false);
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


     /*
      * Return the Application bean corresponding to the ara software
      * @return reference to the Ara application bean
      */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    protected TaxonSessionBean getTaxonSessionBean() {
        return (TaxonSessionBean) getBean("taxonomy$TaxonSessionBean");
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


    public void loadAddRemoveData(boolean reset) {

        List<CountryDTO> countryList = null;

        TaxonSessionBean tsb = this.getTaxonSessionBean();

        if (reset) {
            tsb.getArContries().setAvailableOptions(new Option[0]);
            tsb.getArContries().setSelectedOptions(new Long[0]);
        }

        // AddRemove de Countries
        if (tsb.getArContries() == null || tsb.getArContries().getAvailableOptions().length == 0) {

            countryList = tsb.getAllCountry();
            this.setCountryListOptions(countryList);
        }
        
        // Configura los títulos
        tsb.getArContries().setLbTitle(
            BundleHelper.getDefaultBundleValue("country", this.getMyLocale()));

        tsb.getArContries().setLbAvailable(
            BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));

        tsb.getArContries().setLbSelected(
            BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));


    }

    private void setCountryListOptions(List<CountryDTO> taxonList) {

        TaxonSessionBean tsb = this.getTaxonSessionBean();
        List<Option> list = new ArrayList<Option>();
        AddRemoveList arCountry = tsb.getArContries();

        for (CountryDTO country : taxonList) {
            list.add(new Option(country.getCountryId(), country.getValue()));
        }

        arCountry.setAvailableOptions(list.toArray(new Option[list.size()]));
    }





  
    public String btnSaveTaxon_action() {

        /*CREATE NEW TAXON*/

        System.out.println("Al empezar a guardar "+this.getHiddenTaxonNodeId().getValue());
        TaxonSessionBean TSB = this.getTaxonSessionBean();
        /*
      //Validate if the node is an species //CAMBIAR AL NIVEL TAXONOMICO MAS BAJO
        if (TSB.getCurrentTaxon().getTaxonomicalRangeId().equals
                (TaxonomicalRangeEntity.FORM.getId())) {
            MessageBean.setErrorMessageFromBundle("cant_add_taxon_under_this_level",
                    this.getMyLocale());
            return null;
        }

        */
        System.out.println("TaxonomicalRangeSelected = "+TSB.getTaxonomicalRangeSelected());
         // Gets the current taxonDTO
        Long fatherRangeId = -1L;
        Long fatherTaxonId = -1L;        
        
        if(this.getHiddenTaxonNodeId().getValue() != null){
           fatherTaxonId = new Long((String)this.getHiddenTaxonNodeId().getValue());
           //set current Taxon
           TSB.setCurrentTaxon(TSB.getTaxon(fatherTaxonId));
           //backup fatherRangeId
           fatherRangeId = TSB.getCurrentTaxon().getTaxonomicalRangeId();
           //set taxonomicalRangeId
           //TSB.getCurrentTaxon().setTaxonomicalRangeId(new Long(TSB.getTaxonomicalRangeSelected()));
           TSB.getCurrentTaxon().setTaxonomicalRangeId(TSB.getTaxonomicalRangeSelected());
           //set key like antecesor
           TSB.getCurrentTaxon().setAncestorId(TSB.getCurrentTaxon().getTaxonKey());
           //set current key = null
           TSB.getCurrentTaxon().setTaxonKey(null);
           //set user name
           TSB.getCurrentTaxon().setUserName(this.getAraSessionBean().getGlobalUserName());
           //set collection id = null
	   TSB.getCurrentTaxon().setCollectionId(null);
           //set currentPredecessorTimestamp
           TSB.getCurrentTaxon().setCurrentPredecessorTimestamp(
                   TSB.getCurrentTaxon().getCurrentNameTimestamp());
           //set currentNameTimestamp
           TSB.getCurrentTaxon().setCurrentNameTimestamp(GregorianCalendar.getInstance());

           //set basionymName
           TSB.getCurrentTaxon().setBasionym(TSB.getBasionymName());

           //set defaultName
           String defaultTaxonName ="";
           if(TSB.getCurrentTaxon().getTaxonomicalRangeId() == 18){ // specie
               defaultTaxonName = TSB.getCurrentTaxon().getCurrentName()+" "+TSB.getTaxonName();
           }else{
               defaultTaxonName = TSB.getTaxonName();
           }
           TSB.getCurrentTaxon().setDefaultName(defaultTaxonName);
           //set currentName
           TSB.getCurrentTaxon().setCurrentName(TSB.getTaxonName());
          // System.out.println("Current Name "+TSB.getCurrentTaxon().getCurrentName());
           //System.out.println("Default Name "+TSB.getCurrentTaxon().getDefaultName());

           //set taxonCategoryId
           TSB.getCurrentTaxon().setTaxonCategoryId(TSB.getTaxonomicalCategorySelected());

           //set descriptionMonth
           TSB.getCurrentTaxon().setDescriptionMonth(TSB.getMonthSelected());
           //set descriptionYear
           TSB.getCurrentTaxon().setDescriptionYear(TSB.getYear());
           //set authorFormatParenthesis
           if(TSB.isCheckedParentheses())
           {
               TSB.getCurrentTaxon().setAuthorFormatParenthesis(new Short("1"));
           }
           else
           {
               TSB.getCurrentTaxon().setAuthorFormatParenthesis(new Short("0"));
           }

           //set taxomonomy hierarchy
           TSB.setFullTaxonomicalAttributes(TSB.getCurrentTaxon(), fatherRangeId);

           //save new Taxon
           TSB.saveTaxon(TSB.getCurrentTaxon());

           
           
          
             

           /* CREATE NEW TAXON-INDICATOR RELATIONS*/

           List<String> indicatorIds = new ArrayList<String>();
           for(Option elementIndicator: TSB.getIndicatorRelations())
           {
               indicatorIds.add(elementIndicator.getValue().toString());
               System.out.println("--> indicatorId = "+elementIndicator.getValue());
           }
           System.out.println("==> TaxonId = "+TSB.getCurrentTaxon().getTaxonKey());
           TSB.saveTaxonIndicatorIds(TSB.getCurrentTaxon().getTaxonKey(), indicatorIds, this.getAraSessionBean().getGlobalUserName());


        }


       /* CLEAR */
       TSB.setCurrentTaxon(null);
       TSB.setBasionymName(null);
       TSB.setCheckedParentheses(false);
       TSB.setMonthSelected(null);
       TSB.setTaxonName(null);
       TSB.setTaxonomicalCategorySelected(null);
       TSB.setTaxonomicalRangeSelected(null);
       TSB.setYear(null);

       TSB.getIndicatorRelations().clear();
       TSB.setElementSelected(null);

        return "back";
    }


    public String btnAddTaxonIndicator_action()
    {
        //System.out.println("Indicador seleccionado = "+this.getHiddenNodeId().getValue());
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
        //System.out.println("Indicador seleccionado = "+this.getHiddenNodeId().getValue());
       System.out.println("Se debe eliminar = "+this.getTaxonSessionBean().getElementSelected());
        
        this.getTaxonSessionBean().removeOption(this.getTaxonSessionBean().getElementSelected());
        indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        /*
        Option[] tmp2 = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        this.getTaxonSessionBean().getIndicatorRelations().toArray(tmp2);
        listbox1DefaultOptions.setOptions(tmp2);
         */
        return null;
    }

    public String btnAssociateCountries_action()
    {
     
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        
        tsb.getSelectedTaxonIndicatorCountriesId().put(tsb.getDdIndicatorSelected(), tsb.getArContries().getRightOptions());
        System.out.println(tsb.getSelectedTaxonIndicatorCountriesId().get(tsb.getDdIndicatorSelected()).length);
            
        
            
        tsb.getArContries().setSelectedOptions(new Long[0]);
        tsb.getArContries().setRightOptions(new Option[0]);
        tsb.getArContries().setRightSelected(new Long[0]);
        

        return null;
    }

    /**
     * @return the ddRangeItems
     */
    public SelectItem[] getDdRangeItems() 
    {
        System.out.println("Node Id "+ this.getHiddenTaxonNodeId().getValue().toString());
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
        List<TaxonomicalRangeDTO> tmpTaxonomicalRange = this.getTaxonSessionBean().getNextLevelsByTaxon(new Long(this.getTaxonSessionBean().getTaxonNodeId()));
        ddPruebaRange = new SelectItem[tmpTaxonomicalRange.size()];
        for(int pos = 0; pos < tmpTaxonomicalRange.size(); pos++)
        {
            TaxonomicalRangeDTO tmpRange = tmpTaxonomicalRange.get(pos);
            ddPruebaRange[pos] = new SelectItem(tmpRange.getTaxonomicalRangeKey(),tmpRange.getName());            
        }
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


    public DefaultOptionsList getListbox1DefaultOptions() {
        return listbox1DefaultOptions;
    }

    public void setListbox1DefaultOptions(DefaultOptionsList dol) {
        this.listbox1DefaultOptions = dol;
    }

    /**
     * @return the prueba
     */
    public Option[] getIndicatorRelations() {
        return indicatorRelations;
    }

    /**
     * @param prueba the prueba to set
     */
    public void setIndicatorRelations(Option[] prueba) {
        this.indicatorRelations = prueba;
    }


     /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the ddIndicators
     */
    public DropDown getDdIndicators() {
        return ddIndicators;
    }

    /**
     * @param ddIndicators the ddIndicators to set
     */
    public void setDdIndicators(DropDown ddIndicators) {
        this.ddIndicators = ddIndicators;
    }

    /**
     * @return the taxonTabs
     */
    public TabSet getTaxonTabs() {
        return taxonTabs;
    }

    /**
     * @param taxonTabs the taxonTabs to set
     */
    public void setTaxonTabs(TabSet taxonTabs) {
        this.taxonTabs = taxonTabs;
    }

   

    
}

