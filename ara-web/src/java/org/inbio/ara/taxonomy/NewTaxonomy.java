/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;


import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.model.SelectItem;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTO;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorProfile;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRangeEntity;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;

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

    private String quantityTotal = new String();
    private String selected = new String();

    private String authorQuantityTotal = new String("0");
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
    private DropDown ddRanges= new DropDown();
    private DropDown ddAuthorType= new DropDown();
    private DropDown ddIndicatorsDublinCore= new DropDown();
    private DropDown ddIndicatorsComponentPart= new DropDown();
    private DropDown ddConnector = new DropDown();

    private TabSet taxonTabs= new TabSet();

    private SelectItem[] ddRangeItems;
    private SelectItem[] ddCategoryItems;
    private SelectItem[] ddMonthItems;
   
    private SelectItem[] ddPruebaRange;
    private String tmpSelected = "";

    private Option[] indicatorRelations = new Option[0];

    private Option[] indicatorRelationsAP = new Option[0];

    private Option[] taxonAuthors = new Option[0];

    private DefaultOptionsList listbox1DefaultOptions = new DefaultOptionsList();

    private HtmlPanelGrid gridDublinCore = new HtmlPanelGrid();

    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();

    private HtmlInputText txSearch = new HtmlInputText();

    private TextField txTitle = new TextField();

    private TextField txYear = new TextField();

    private TextField txIdentifier = new TextField();

    private TextField txCreator = new TextField();

    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton();

    private HtmlDataTable dataTableDublinCore = new HtmlDataTable();

    private HtmlDataTable dataTableAuthors = new HtmlDataTable();


    

   

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
        //System.out.println("Hizo prerender");
         
        //Set hidden value from session bean
        hiddenTaxonNodeId.setValue(tsb.getTaxonNodeId());
        hiddenPathTaxonNode.setValue(tsb.getPathTaxonNode());
        hiddenCollecNomenclGroupId.setValue(tsb.getCollecNomenclGroupId());
        hiddenTypeGroup.setValue(tsb.getTypeGroup());     
        hiddenNodeId.setValue(tsb.getNodeId());
        hiddenPathNode.setValue(tsb.getPathNode());

        List<TaxonomicalRangeDTO> tmpTaxonomicalRange = this.getTaxonSessionBean().getNextLevelsByTaxon(new Long(this.getHiddenTaxonNodeId().getValue().toString()));
        
        tsb.setDbRanges(new HashSet<Option>());
        for(int pos = 0; pos < tmpTaxonomicalRange.size(); pos++)
        {
            TaxonomicalRangeDTO tmpRange = tmpTaxonomicalRange.get(pos);
            tsb.getDbRanges().add(new Option(tmpRange.getTaxonomicalRangeKey(),tmpRange.getName()));
        }
       

       if(tsb.getTaxonomicalRangeSelected() == null)
       {
           tsb.setTaxonomicalRangeSelected((Long)((Option)tsb.getDbRanges().toArray()[0]).getValue());
           setVisibleIndicator();
       }


        //Clear Indicator ListBox
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if((indicatorNodeId == null) || (indicatorNodeId == 0))
        {
            listbox1DefaultOptions.setOptions(null);
        }
       
        //Set Taxon-Indicator relations
        if(tsb.getIndicatorRelations().size() > 0)
        {
            indicatorRelations = new Option[tsb.getIndicatorRelations().size()];
            tsb.getIndicatorRelations().toArray(indicatorRelations);
            indicatorRelationsAP = new Option[tsb.getIndicatorRelationsAP().size()];
            tsb.getIndicatorRelationsAP().toArray(indicatorRelationsAP);
        }

        //On focus tabTaxonAuthor:
        if(tsb.getTaxonTabSelected().equals("tabTaxonAuthor"))
        {

            //load AuthorProfileType
            tsb.setTaxonAuthorProfileDropDownData();
            //load Connectors
            Set<Option> connectors = new HashSet<Option>();
            connectors.add(new Option(-1L, " -- " + BundleHelper.getDefaultBundleValue
                                    ("drop_down_default", getMyLocale()) + " --"));
            connectors.addAll(tsb.getSelectionListDropDownData(
                                SelectionListEntity.TAXON_AUTHOR_CONNECTOR.getId()));
            tsb.setConnectors(connectors);

            //load AuthorList
            if(tsb.getTaxonAuthorsMap().size() == 0)
            {
                //System.out.println("=== taxonAuthorMap esta vacio");
                //System.out.print("-> AuthorList size:"+tsb.getTaxonAuthorsMap().size());
                tsb.setAuthorList();
                tsb.initTaxonAuthorSequence();
                tsb.initAuthorList();
                //System.out.println("-> AuthorTypeSelected:"+tsb.getAuthorTypeSelected());
                
                
             
            }
            //set authorSequence
            if(tsb.getTaxonAuthorSequence() == -1)
            {
                tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected()));
            }
            //System.out.print("TaxonAuthorSequence-> :"+tsb.getTaxonAuthorSequence());
            /*
            taxonAuthors = new Option[tsb.getTaxonAuthors().size()];
            tsb.getTaxonAuthors().toArray(taxonAuthors);
            */
            /*
            if(tsb.getAuthorTypeSelected() == TaxonAuthorProfile.ORIGINALS.getId())
            {
                //taxonAuthors = tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId());
                taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).size()];
                tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).toArray(taxonAuthors);
            }
            else
            {
                //taxonAuthors = tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId());
                taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).size()];
                tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).toArray(taxonAuthors);
            }
            */
            //taxonAuthors = new Option[];
            taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()).size()];
            tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()).toArray(taxonAuthors);
        }
        //On focus tabTaxonIndicatorCountry:
        if(tsb.getTaxonTabSelected().equals("tabTaxonIndicatorCountry"))
        {
            //Load countries
            loadAddRemoveData(false);
            //Set default indicator value selected
            if(tsb.getDdIndicatorSelected() == null && indicatorRelations.length>0)
            {
                tsb.setDdIndicatorSelected((Long)indicatorRelations[0].getValue());
            
            }


        }

        //On focus tabTaxonIndicatorComponentPart:
        if(tsb.getTaxonTabSelected().equals("tabTaxonIndicatorComponentPart"))
        {
            //Load componentPart
            loadAddRemoveComponentPartData(false);
            //Set default indicator value selected
            if(tsb.getDdIndicatorCPSelected() == null && indicatorRelations.length>0)
            {
                tsb.setDdIndicatorCPSelected((Long)indicatorRelations[0].getValue());

            }


        }

        //On focus tabTaxonIndicatorReferences:
        if(tsb.getTaxonTabSelected().equals("tabBibliographicReferences"))
        {

           if(tsb.getDdIndicatorDCSelected() == null && indicatorRelations.length>0)
            {
                tsb.setDdIndicatorDCSelected((Long)indicatorRelations[0].getValue());

            }
            if (this.getTaxonSessionBean().getPagination()!=null)
            {

                getSelectedResourceIds(this.getDataTableDublinCore(), this.getTaxonSessionBean().getSelectedResourcesId());
                Collection<ReferenceDTO> references = this.getTaxonSessionBean().getSelectedResourcesId().values();
                for(ReferenceDTO reference: references)
                {
                    setSelected(getSelected() + reference.getTitle() + "; ");
                }

            }
            //Preguntar si la bandera de busqueda avanzada esta prendida
            if(this.getTaxonSessionBean().isAdvancedSearch()){
                this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
            }
            //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
            else if (this.getTaxonSessionBean().getPagination()==null) {
                   this.getTaxonSessionBean().initDataProvider();
                   this.getTaxonSessionBean().setSelectedResourcesId(new HashMap<String, ReferenceDTO>());
            }
       
        }

        if(tsb.getIndicatorRelations().size()>0)
        {
            tsb.setAbleTabTaxonIndicatorCountry(true);
            tsb.setAbleTabTaxonIndicatorDublinCore(true);
            if(tsb.getIndicatorRelationsAP().size()>0)
            {
                tsb.setAbleTabTaxonIndicatorComponentPart(true);
            }
            else
            {
                tsb.setAbleTabTaxonIndicatorComponentPart(false);
            }
            
        }
        else
        {
            tsb.setAbleTabTaxonIndicatorCountry(false);
            tsb.setAbleTabTaxonIndicatorComponentPart(false);
            tsb.setAbleTabTaxonIndicatorDublinCore(false);
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


    public void loadAddRemoveComponentPartData(boolean reset) {

        List<SelectionListDTO> componentPartList = null;

        TaxonSessionBean tsb = this.getTaxonSessionBean();

        if (reset) {
            tsb.getArComponentPart().setAvailableOptions(new Option[0]);
            tsb.getArComponentPart().setSelectedOptions(new Long[0]);
        }

        // AddRemove de Countries
        if (tsb.getArComponentPart() == null || tsb.getArComponentPart().getAvailableOptions().length == 0) {

            componentPartList = tsb.getAllComponetPartByCollectionId(this.getAraSessionBean().getGlobalCollectionId());
            this.setComponentPartListOptions(componentPartList);
        }

        // Configura los títulos
        tsb.getArComponentPart().setLbTitle(
            BundleHelper.getDefaultBundleValue("sle_component_part", this.getMyLocale()));

        tsb.getArComponentPart().setLbAvailable(
            BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));

        tsb.getArComponentPart().setLbSelected(
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

    private void setComponentPartListOptions(List<SelectionListDTO> componentPartList)
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();
        List<Option> list = new ArrayList<Option>();
        AddRemoveList arComponentPart = tsb.getArComponentPart();

        for (SelectionListDTO componentPart : componentPartList) {
            list.add(new Option(componentPart.getValueId(), componentPart.getValueName()));
        }

        arComponentPart.setAvailableOptions(list.toArray(new Option[list.size()]));
    }




  
    public String btnSaveTaxon_action() {

        String message ="";

        /*CREATE NEW TAXON*/

        
        TaxonSessionBean TSB = this.getTaxonSessionBean();    
        
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

           /* CREATE NEW TAXON-AUTHOR RELATIONS*/
           TSB.getAuthorListMap().put(TSB.getAuthorTypeSelected(), TSB.getAuthorList());

           TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
           for(int pos = 0; pos < tap.length; pos++)
            {
             //   taxonAuthorSequenceMap.put(tap[pos].getId(), 1L);
               List<TaxonAuthorDTO> tmpList = TSB.getAuthorListMap().get(tap[pos].getId());
               if(tmpList != null && tmpList.size()>0)
               {
                   TSB.saveTaxonAuthorDTOs(TSB.getCurrentTaxon().getTaxonKey(), tmpList, this.getAraSessionBean().getGlobalUserName());
               }

            }
           
          
             

           /* CREATE NEW TAXON-INDICATOR RELATIONS*/

           List<String> indicatorIds = new ArrayList<String>();
           for(Option elementIndicator: TSB.getIndicatorRelations())
           {
               indicatorIds.add(elementIndicator.getValue().toString());
          
               try{
                   Long indicatorId = new Long(elementIndicator.getValue().toString());
                    //new relation taxon-indicator
                    TSB.saveTaxonIndicatorId(TSB.getCurrentTaxon().getTaxonKey(), elementIndicator.getValue().toString(), this.getAraSessionBean().getGlobalUserName());
                    if(TSB.getSelectedTaxonIndicatorCountriesId().containsKey(indicatorId))
                    {
                        List<Long> countryIds = new ArrayList<Long>();
                        Option[] countriesSelected = TSB.getSelectedTaxonIndicatorCountriesId().get(indicatorId);
                        for(int pos = 0; pos < countriesSelected.length;pos++)
                        {
                            countryIds.add((Long)countriesSelected[pos].getValue());
                        }

                        TSB.saveTaxonIndicatorCountries(TSB.getCurrentTaxon().getTaxonKey(), indicatorId, countryIds, this.getAraSessionBean().getGlobalUserName());
                    }

                    if(TSB.getSelectedTaxonIndicatorDublinCoreId().containsKey(indicatorId))
                    {
          
                        Map<String, ReferenceDTO> tmpRef = TSB.getSelectedTaxonIndicatorDublinCoreId().get(indicatorId);
                        Set<String> referenceIds = tmpRef.keySet();
                        List<String> newReferences = new ArrayList<String>();
                        for(String referenceId:referenceIds)
                        {
          
                            newReferences.add(referenceId);
                        }
                        TSB.saveTaxonIndicatorDublinCoreIds(TSB.getCurrentTaxon().getTaxonKey(), indicatorId ,newReferences, this.getAraSessionBean().getGlobalUserName());
                    }

                    if(TSB.getSelectedTaxonIndicatorComponentPartId().containsKey(indicatorId))
                    {
                        List<Long> componentPartIds = new ArrayList<Long>();
                        Option[] componentPartSelected = TSB.getSelectedTaxonIndicatorComponentPartId().get(indicatorId);
                        for(int pos = 0; pos < componentPartSelected.length;pos++)
                        {
                            componentPartIds.add((Long)componentPartSelected[pos].getValue());
                        }

                        TSB.saveTaxonIndicatorComponentPartIds(TSB.getCurrentTaxon().getTaxonKey(), indicatorId, componentPartIds, this.getAraSessionBean().getGlobalUserName());
                    }



               }
               catch(Exception e)
               {
                   message += elementIndicator.getLabel()+"\n";
                   
               }
           }
          

        }


       /* CLEAR */
        //Taxon
       TSB.setCurrentTaxon(null);
       TSB.setBasionymName(null);
       TSB.setCheckedParentheses(false);
       TSB.setMonthSelected(null);
       TSB.setTaxonName(null);
       TSB.setTaxonomicalCategorySelected(null);
       TSB.setTaxonomicalRangeSelected(null);
       TSB.setYear(null);

       //Taxon-Indicator
       TSB.getIndicatorRelations().clear();
       TSB.getIndicatorRelationIds().clear();
       TSB.setElementSelected(null);

       //Taxon-Indicator-Conutry
       TSB.setSelectedTaxonIndicatorCountriesId(null);
       TSB.setArContries(null);
       TSB.setDdIndicatorSelected(null);
       TSB.setIndicatorRelations(null);
       TSB.setElementSelected(null);



        return "back";
    }


    public String btnAddTaxonIndicator_action()
    {
        
        this.getTaxonSessionBean().setNodeId(this.getHiddenNodeId().getValue().toString());
        this.getTaxonSessionBean().setPathNode(this.getHiddenPathNode().getValue().toString());
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if(this.getTaxonSessionBean().isLeaf(indicatorNodeId)){
            if(!this.getTaxonSessionBean().getIndicatorRelationIds().contains(indicatorNodeId))
            {
                //agrega el indicatorId a una lista para llevar el control de elementos repetidos con el long
                this.getTaxonSessionBean().getIndicatorRelationIds().add(indicatorNodeId);
                //obtiene la informacion del nodo seleccionado
                IndicatorDTO infoNodo = this.getTaxonSessionBean().getIndicatorDTOByIndicatorId(indicatorNodeId);
                
                //agrega el indicator seleccionado a la lista de indicadores del session bean
                this.getTaxonSessionBean().getIndicatorRelations().add(new Option(indicatorNodeId, infoNodo.getName() ));

                if(infoNodo.getAppliesToParts() == 1)
                {
                    this.getTaxonSessionBean().getIndicatorRelationsAP().add(new Option(indicatorNodeId, infoNodo.getName() ));
                }
                //asigna la lista de indicadores al elemento grafico drop down
                indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
                this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
                //asigna la lista de indicadores que aplican a partes de componentes al elemento grafico drop down
                indicatorRelationsAP = new Option[this.getTaxonSessionBean().getIndicatorRelationsAP().size()];
                this.getTaxonSessionBean().getIndicatorRelationsAP().toArray(indicatorRelationsAP);
            }

            else
            {
                MessageBean.setErrorMessageFromBundle("error_taxon_indicator_exist",this.getMyLocale());
            }
        }
        else
        {
             MessageBean.setErrorMessageFromBundle("error_taxon_indicator",this.getMyLocale());

        }


        return null;
    }

    public String btnRemoveTaxonIndicator_action()
    {
        
        //elmimnar de el elemento de la lista de indicadores
        this.getTaxonSessionBean().removeIndicatorOption(this.getTaxonSessionBean().getElementSelected(), this.getTaxonSessionBean().getIndicatorRelations());
        //elmimnar de el elemento de la lista de indicadores que aplican a partes de componente
        this.getTaxonSessionBean().removeIndicatorOption(this.getTaxonSessionBean().getElementSelected(), this.getTaxonSessionBean().getIndicatorRelationsAP());
        //asignar de nuevo la lista al elemento grafico
        indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        //asignar de nuevo la lista al elemento grafico
        indicatorRelationsAP = new Option[this.getTaxonSessionBean().getIndicatorRelationsAP().size()];
        this.getTaxonSessionBean().getIndicatorRelationsAP().toArray(indicatorRelationsAP);

        return null;
    }

    public String btnAssociateCountries_action()
    {


        TaxonSessionBean tsb = this.getTaxonSessionBean();
        
        tsb.getSelectedTaxonIndicatorCountriesId().put(tsb.getDdIndicatorSelected(), tsb.getArContries().getRightOptions());
        
            
        return null;
    }

    public String btnAssociateComponentPart_action()
    {


        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.getSelectedTaxonIndicatorComponentPartId().put(tsb.getDdIndicatorCPSelected(), tsb.getArComponentPart().getRightOptions());


        return null;
    }

    public String btnAssociateDublinCore_action()
    {
        
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        
        getSelectedResourceIds(this.getDataTableDublinCore(), tsb.getSelectedResourcesId());
        tsb.getSelectedTaxonIndicatorDublinCoreId().put(tsb.getDdIndicatorDCSelected(), new HashMap<String, ReferenceDTO>());
        Map<String, ReferenceDTO> ref = tsb.getSelectedTaxonIndicatorDublinCoreId().get(tsb.getDdIndicatorDCSelected());
        
        Set<Entry<String, ReferenceDTO>> copiaRef = tsb.getSelectedResourcesId().entrySet();
        for(Entry element: copiaRef)
        {
            ref.put((String)element.getKey(),(ReferenceDTO)element.getValue());
        }

        

         return null;
     }


    /**
     * <p>Acción que se realiza al presionar el botón de búsqueda simple</p>
     *
     * @return String
     */
    public String btnSimpleSearch_action() {

        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
        {
            userInput = this.getTxSearch().getValue().toString();
        }
        userInput = userInput.trim();

        if(!this.getTaxonSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getTaxonSessionBean().getSelectedResourcesId());
        }

        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getTaxonSessionBean().setQueryModeSimple(false);
            this.getTaxonSessionBean().setQueryMode(false);

            //Actualiza el data provider del paginador con los datos por default
            this.getTaxonSessionBean().getPagination().setTotalResults
                    (getTaxonSessionBean().getDublinCoreFacade().countResourceByTypeId(ResourceTypeEnum.REFERENCE.getId()).intValue());
        }
        else{
            //Actualizar el valor del string para consulta simple del SessionBean
            this.getTaxonSessionBean().setSimpleConsult(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getTaxonSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getTaxonSessionBean().setQueryMode(false);
            //Finalmente se inicializa el Total Results del data provider del paginador con la cantidad de resultados de la consulta
            this.getTaxonSessionBean().getPagination().setTotalResults
                    (getTaxonSessionBean().getDublinCoreFacade().countSimpleSearch(userInput).intValue());
        }
        //set the first result of the query
        this.getTaxonSessionBean().getPagination().firstResults();

        return null;
    }

    public String btnAdvSearch_action() {

        if(!this.getTaxonSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getTaxonSessionBean().getSelectedResourcesId());
        }

        boolean advanced = this.getTaxonSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            this.getTaxonSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSearch().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getTaxonSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSearch().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

        }
        this.getTaxonSessionBean().getPagination().refreshList();
        return null;
    }

    public String btnProceedSearch_action() {


        if(!this.getTaxonSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getTaxonSessionBean().getSelectedResourcesId());
        }

        /*
         * ARMAR EL DTO PARA REALIZAR LA BUSQUEDA
         */

        this.getTaxonSessionBean().setQueryDublinCoreDTO(new DublinCoreDTO());

        if(this.getTxTitle().getText() != null && this.getTxTitle().getText() != "")
        {

            this.getTaxonSessionBean().getQueryDublinCoreDTO().addElement("title",
                                                                                    this.getTxTitle().getText().toString(), "Español");
        }

        if(this.getTxCreator().getText() != null && this.getTxCreator().getText() != "")
        {


            this.getTaxonSessionBean().getQueryDublinCoreDTO().addElement("creator",
                                                                                    this.getTxCreator().getText().toString(), null);
        }

        if(this.getTxIdentifier().getText() != null && this.getTxIdentifier().getText() != "")
        {

            this.getTaxonSessionBean().getQueryDublinCoreDTO().addElement("identifier",
                                                                                    this.getTxIdentifier().getText().toString(), null);
        }


       if(this.getTxYear().getText() != null && this.getTxYear().getText() != "")
       {

            this.getTaxonSessionBean().getQueryDublinCoreDTO().addElement("date",
                                                                                    this.getTxYear().getText().toString(), null);
       }

         //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getTaxonSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getTaxonSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getTaxonSessionBean().getPagination().setTotalResults(
                this.getTaxonSessionBean().
                getDublinCoreFacade().
                countDublinCoreAdvancedSearch(
                getTaxonSessionBean().
                getQueryDublinCoreDTO()).intValue());

        this.getTaxonSessionBean().getPagination().firstResults();
        this.getTaxonSessionBean().getPagination().refreshList();

        this.getTxSearch().setValue("");

        return null;
    }

    public String btnAddAuthor_action()
    {

        //System.out.println("ENTRO A AGREGAR UN AUTOR");
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        //tsb.setVisiblePanelAuthorAction(false);

        btnCancelAuthor_action();
        

        tsb.setNewAuthorAction(true);

        if(tsb.getAuthorSelected() != null)
        {
            //Create new TaxonAuthorDTO
            tsb.setNewAuthor(new TaxonAuthorDTO());
            //System.out.println(tsb.getAuthorSelected());
            Option selected;
            /*selected*/
            selected = tsb.removeOption(tsb.getAuthorSelected(), tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()));
            
            Set<Option> tmp = tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected());

            tsb.setTaxonAuthorName(selected.getLabel());
            
            tsb.getNewAuthor().setTaxonAuthorName(selected.getLabel());
            tsb.getNewAuthor().setTaxonAuthorPersonId((Long)selected.getValue());

            tsb.getNewAuthor().setCategory(TaxonAuthorProfile.values()[(tsb.getAuthorTypeSelected()).intValue()].getIdentifier());

            
            tsb.setVisiblePanelAuthorAction(true);
        }
        else
        {
            
             MessageBean.setErrorMessageFromBundle("error_author_not_selected",this.getMyLocale());

        }
        
        return null;
    }

    
     public String btnEditAuthor_action()
    {


         //System.out.println("=== Entra al Editar Author ===");
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.setCountTaxonAuthorSelected(0);

        //return author selected to taxonAuthors
        btnCancelAuthor_action();

        tsb.setNewAuthorAction(false);
        
        tsb.setPositionTaxonAuthorSelected(tsb.getPosTaxonAuthorSelected());
        if(tsb.getPositionTaxonAuthorSelected() >=0)
        {
            tsb.setNewAuthor(tsb.getAuthorList().get(tsb.getPositionTaxonAuthorSelected()));
            //set default value to connectorId
            Long connectorId = -1L;
            //System.out.println("Cantidad de autores seleccionados = "+tsb.getCountTaxonAuthorSelected());
            if(tsb.getCountTaxonAuthorSelected() == 1)
            {

                tsb.setTaxonAuthorSequence(tsb.getNewAuthor().getTaxonAuthorSequence());


                tsb.setTaxonAuthorName(tsb.getNewAuthor().getTaxonAuthorName());
                //System.out.println("--> ConnectorId = "+taxonAuthorSelected.getTaxonAuthorConnectorId());

                if(tsb.getNewAuthor().getTaxonAuthorConnectorId() != null)
                {

                    connectorId = tsb.getNewAuthor().getTaxonAuthorConnectorId();
                }


                tsb.setConnectorSelected(connectorId);
                tsb.setVisiblePanelAuthorAction(true);

            }
            else
            {
                
                 MessageBean.setErrorMessageFromBundle("error_edit_one_author",this.getMyLocale());

            }
         }
        else
        {            
            MessageBean.setErrorMessageFromBundle("error_edit_author_not_selected",this.getMyLocale());

            
        }
        return null;
    }

    public String btnRemoveAuthor_action()
    {

        //System.out.println("=== Entra al Eliminar Author ===");
        TaxonSessionBean tsb = this.getTaxonSessionBean();


        TaxonAuthorDTO taxonAuthorSelected = tsb.getTaxonAuthorSelected();

        if(tsb.getCountTaxonAuthorSelected() >= 0)
        {
            if(tsb.getCountTaxonAuthorSelected() == 1)
            {
                //tsb.setTaxonAuthorSequence(taxonAuthorSelected.getTaxonAuthorSequence());
                tsb.removeTaxonAuthorSelected();
                tsb.addOptionToTaxonAuthors(taxonAuthorSelected);
                Long newSequence = tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected())-1L;
                //System.out.println("Editando sequence FINAL => sequence = "+tsb.getTaxonAuthorSequence() +" , new sequence = "+newSequence);
                //tsb.setTaxonAuthorSequence(newSequence);
                tsb.getTaxonAuthorSequenceMap().put(tsb.getAuthorTypeSelected(), newSequence);
                tsb.setCountTaxonAuthorSelected(0);

            }
            else
            {
            
                 MessageBean.setErrorMessageFromBundle("error_delete_one_author",this.getMyLocale());

            }
        }
        else
        {
            
             MessageBean.setErrorMessageFromBundle("error_delete_author_not_selected",this.getMyLocale());

        }
        return null;
    }

     public String btnAceptAuthor_action()
    {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         //NEW MODE
         if(tsb.isNewAuthorAction())
         {
            //set Connector
            if(tsb.getConnectorSelected() == -1)
            {   
                tsb.getNewAuthor().setTaxonAuthorConnector(",");
                tsb.getNewAuthor().setTaxonAuthorConnectorId(null);
            }
            else
            {
                tsb.getNewAuthor().setTaxonAuthorConnector(tsb.getLabelConnector(tsb.getConnectorSelected()));
                tsb.getNewAuthor().setTaxonAuthorConnectorId(tsb.getConnectorSelected());
            }

            //set sequence
            tsb.getNewAuthor().setTaxonAuthorSequence(tsb.getTaxonAuthorSequence());

            //reorder list
            if(tsb.getNewAuthor().getTaxonAuthorSequence() != tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected()))
            {
                tsb.setAuthorList(tsb.reorderSequence(tsb.getNewAuthor(), tsb.getAuthorList()));
            }
            else
            {
                tsb.getAuthorList().add(tsb.getNewAuthor());
            }

            //New sequence
            Long sequence =tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected())+1;
            tsb.getTaxonAuthorSequenceMap().put(tsb.getAuthorTypeSelected(), sequence);

            //Set & and , connectors
            setDefaultConnector();
           
         }
         //EDIT MODE
         else
         {
             if(tsb.getTaxonAuthorSequence()>0 && tsb.getTaxonAuthorSequence() < tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected()))
             {
                
                //if(tsb.getConnectorSelected() != null && tsb.getConnectorSelected() >= 0)
                if(tsb.getConnectorSelected() >= 0)
                {
                    tsb.getNewAuthor().setTaxonAuthorConnectorId(tsb.getConnectorSelected());
                    tsb.getNewAuthor().setTaxonAuthorConnector(tsb.getLabelConnector(tsb.getConnectorSelected()));

                }
                else
                {
                    tsb.getNewAuthor().setTaxonAuthorConnectorId(null);
                    tsb.getNewAuthor().setTaxonAuthorConnector(",");
                }
                tsb.getNewAuthor().setTaxonAuthorSequence(tsb.getTaxonAuthorSequence());
                //tsb.getAuthorList().set(tsb.getPositionTaxonAuthorSelected(), tsb.getNewAuthor());
                tsb.editSequence(tsb.getNewAuthor(), tsb.getAuthorList());
                //Set & and , connectors
                setDefaultConnector();
             }
             else
             {
                //CAMBIAR EL MENSAJE DE ERROR
                 MessageBean.setErrorMessageFromBundle("error_taxon_indicator",this.getMyLocale());
             }
         }


         //Clean
        tsb.setNewAuthor(null);
        tsb.setTaxonAuthorSequence(-1L);
        tsb.setConnectorSelected(-1L);
        tsb.setVisiblePanelAuthorAction(false);
        
        return null;
    }

     public String btnCancelAuthor_action()
    {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         if(tsb.isNewAuthorAction() && tsb.getNewAuthor() != null)
         {
             //tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()).add(tsb.getAuthorRemove());
             tsb.addOptionToTaxonAuthors(tsb.getNewAuthor());
         }

         //Clean
         tsb.setTaxonAuthorSequence(-1L);
         tsb.setConnectorSelected(-1L);
         tsb.setVisiblePanelAuthorAction(false);
         //tsb.setAuthorRemove(null);
         tsb.setNewAuthor(null);

        return null;
    }


     public void setDefaultConnector()
     {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         int position = 0;
         int lastPosition = tsb.getAuthorList().size() - 1;
         if(tsb.getAuthorList().size() > 2)
         {             
             position = tsb.getAuthorList().size() - 2;
           //  System.out.println("** Entro a calcular la posicion = "+position);
         }
         //System.out.println("*** \tConnectorId = "+tsb.getAuthorList().get(position).getTaxonAuthorConnectorId());
         //System.out.println("*** \tAuthorList.size() =  "+tsb.getAuthorList().size());
         if(tsb.getAuthorList().get(position).getTaxonAuthorConnectorId() == null && tsb.getAuthorList().size() > 1)
         {
             //System.out.println("** Entro a asignar el & y corregir el , ");
             tsb.getAuthorList().get(position).setTaxonAuthorConnector("&");
             if(position > 0 && tsb.getAuthorList().get(position-1).getTaxonAuthorConnectorId() == null)
             {
                 tsb.getAuthorList().get(position-1).setTaxonAuthorConnector(",");
             }
         }
         if(tsb.getAuthorList().get(lastPosition).getTaxonAuthorConnectorId() == null)
         {
             //System.out.println("** Entro a asignar , al ultimo elemento ");
             tsb.getAuthorList().get(lastPosition).setTaxonAuthorConnector(",");
         }
     }



    public void getSelectedResourceIds (HtmlDataTable selectedResources, Map<String, ReferenceDTO> selectedResourcesId)
    {

        int n = selectedResources.getRowCount();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            selectedResources.setRowIndex(i);
            ReferenceDTO aux = (ReferenceDTO) selectedResources.getRowData();

            if (aux.isSelected() && (!selectedResourcesId.containsKey(aux.getKey()))) {
                //System.out.println("Seleccionado "+ aux.getTitle());
                selectedResourcesId.put(aux.getKey(), aux);

            }
            else
            {
                if((!aux.isSelected()) && selectedResourcesId.containsKey(aux.getKey()))
                {

                    selectedResourcesId.remove(aux.getKey());
                }
            }
        }

    }

    public String setVisibleIndicator()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        if(tsb.getTaxonomicalRangeSelected().equals
                (TaxonomicalRangeEntity.SPECIES.getId()))
        {
            tsb.setAbleTabTaxonIndicator(true);
        }
        else
        {
            tsb.setAbleTabTaxonIndicator(false);
            tsb.setAbleTabTaxonIndicatorCountry(false);
            tsb.setAbleTabTaxonIndicatorComponentPart(false);
            tsb.setAbleTabTaxonIndicatorDublinCore(false);
        }
        return null;
    }


    public String setAuthorList()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        System.out.println("\t\t\ttsb.getAuthorTypeSelected() = "+tsb.getAuthorTypeSelected());
        System.out.println("\t\t\tTaxonAuthorProfile.ORIGINALS.getId() = "+TaxonAuthorProfile.ORIGINALS.getId());
        if(tsb.getAuthorTypeSelected().equals(TaxonAuthorProfile.ORIGINALS.getId()))
        {
            System.out.println("--> Cambiar la lista a ORIGINALS");
            //set taxonAuthor
            taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).size()];
            tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).toArray(taxonAuthors);

            //switch authorList
           // List<TaxonAuthorDTO> tmpList = tsb.getAuthorList();
            tsb.getAuthorListMap().put(TaxonAuthorProfile.MODIFICATORS.getId(),tsb.getAuthorList());
            //Collection<Object> tmpArray = tsb.getAuthorListMap().get(TaxonAuthorProfile.ORIGINALS.getId()).toArray();
            //tsb.setAuthorList(new ArrayList<TaxonAuthorDTO>());
           /* tsb.getAuthorListMap().put(TaxonAuthorProfile.MODIFICATORS.getId(),
                   (List<TaxonAuthorDTO>)tsb.deepCopy(tsb.getAuthorList()));
            */
            tsb.setAuthorList(tsb.getAuthorListMap().get(TaxonAuthorProfile.ORIGINALS.getId()));

            //switch taxonAuthorSequence
            tsb.getTaxonAuthorSequenceMap().put(TaxonAuthorProfile.MODIFICATORS.getId(),tsb.getTaxonAuthorSequence());
            tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(TaxonAuthorProfile.ORIGINALS.getId()));

        }
        else
        {
            System.out.println("--> Cambiar la lista a MODIFICATORS");
                //taxonAuthors = tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId());
            taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).size()];
            tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).toArray(taxonAuthors);

            //switch authorList
            //List<TaxonAuthorDTO> tmpList = tsb.getAuthorList();
            tsb.getAuthorListMap().put(TaxonAuthorProfile.ORIGINALS.getId(),tsb.getAuthorList());
            //tsb.setAuthorList(new ArrayList<TaxonAuthorDTO>());
            /*
            tsb.getAuthorListMap().put(TaxonAuthorProfile.ORIGINALS.getId(),
                   (List<TaxonAuthorDTO>)tsb.deepCopy(tsb.getAuthorList()));
             */
            tsb.setAuthorList(tsb.getAuthorListMap().get(TaxonAuthorProfile.MODIFICATORS.getId()));

            //switch taxonAuthorSequence
            tsb.getTaxonAuthorSequenceMap().put(TaxonAuthorProfile.ORIGINALS.getId(),tsb.getTaxonAuthorSequence());
            tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(TaxonAuthorProfile.MODIFICATORS.getId()));
        }

        return null;
    }

    public String updateIndicatorDCSelected()
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();       
        if(tsb.getSelectedTaxonIndicatorDublinCoreId().containsKey(tsb.getDdIndicatorDCSelected()))
        {

            tsb.setSelectedResourcesId( new HashMap<String, ReferenceDTO>());
          
            Set<Entry<String, ReferenceDTO>> copiaRef = tsb.getSelectedTaxonIndicatorDublinCoreId().get(tsb.getDdIndicatorDCSelected()).entrySet();
            for(Entry element: copiaRef)
            {
                tsb.getSelectedResourcesId().put((String)element.getKey(),(ReferenceDTO)element.getValue());
            }

            tsb.deselectedResources(tsb.getPagination().getDataProvider().getList());
            tsb.setSelectedResources(tsb.getPagination().getDataProvider().getList(), tsb.getSelectedResourcesId());
        }
        else
        {
            tsb.setSelectedResourcesId(new HashMap<String, ReferenceDTO>());
            tsb.deselectedResources(tsb.getPagination().getDataProvider().getList());

        }


        return null;
    }


    public String updateRightList()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        //move elements to left
        int size = tsb.getArContries().getRightOptions().length;
        Long[] optionsSelected = new Long[size];
        for(int pos = 0; pos < size; pos++)
        {
            optionsSelected[pos]=(Long)tsb.getArContries().getRightOptions()[pos].getValue();
        }
        tsb.getArContries().setRightSelected(optionsSelected);
        tsb.getArContries().removeSelectedOptions();

        //move elements to right
        if(tsb.getSelectedTaxonIndicatorCountriesId().containsKey(tsb.getDdIndicatorSelected()))
        {            
            Option[] elements = tsb.getSelectedTaxonIndicatorCountriesId().get(tsb.getDdIndicatorSelected());
            
            tsb.getArContries().setRightOptions(new Option[0]);


            int arraySize = elements.length;
            Long[] arrayOptionsSelected = new Long[arraySize];
            for(int pos = 0; pos < arraySize; pos++)
            {
                arrayOptionsSelected[pos]=(Long)elements[pos].getValue();
            }
            tsb.getArContries().setLeftSelected(arrayOptionsSelected);
            tsb.getArContries().addSelectedOptions();
            
        }

      
        return null;
    }


    public String updateRightComponentPartList()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        //move elements to left
        int size = tsb.getArComponentPart().getRightOptions().length;
        Long[] optionsSelected = new Long[size];
        for(int pos = 0; pos < size; pos++)
        {
            optionsSelected[pos]=(Long)tsb.getArComponentPart().getRightOptions()[pos].getValue();
        }
        tsb.getArComponentPart().setRightSelected(optionsSelected);
        tsb.getArComponentPart().removeSelectedOptions();

        //move elements to right
        if(tsb.getSelectedTaxonIndicatorComponentPartId().containsKey(tsb.getDdIndicatorCPSelected()))
        {
            Option[] elements = tsb.getSelectedTaxonIndicatorComponentPartId().get(tsb.getDdIndicatorCPSelected());

            tsb.getArComponentPart().setRightOptions(new Option[0]);


            int arraySize = elements.length;
            Long[] arrayOptionsSelected = new Long[arraySize];
            for(int pos = 0; pos < arraySize; pos++)
            {
                arrayOptionsSelected[pos]=(Long)elements[pos].getValue();
            }
            tsb.getArComponentPart().setLeftSelected(arrayOptionsSelected);
            tsb.getArComponentPart().addSelectedOptions();

        }


        return null;
    }

    /**
     * @return the ddRangeItems
     */
    public SelectItem[] getDdRangeItems() 
    {        
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

    /**
     * @return the gridDublinCore
     */
    public HtmlPanelGrid getGridDublinCore() {
        return gridDublinCore;
    }

    /**
     * @param gridDublinCore the gridDublinCore to set
     */
    public void setGridDublinCore(HtmlPanelGrid gridDublinCore) {
        this.gridDublinCore = gridDublinCore;
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
     * @return the txTitle
     */
    public TextField getTxTitle() {
        return txTitle;
    }

    /**
     * @param txTitle the txTitle to set
     */
    public void setTxTitle(TextField txTitle) {
        this.txTitle = txTitle;
    }

    /**
     * @return the txYear
     */
    public TextField getTxYear() {
        return txYear;
    }

    /**
     * @param txYear the txYear to set
     */
    public void setTxYear(TextField txYear) {
        this.txYear = txYear;
    }

    /**
     * @return the txIdentifier
     */
    public TextField getTxIdentifier() {
        return txIdentifier;
    }

    /**
     * @param txIdentifier the txIdentifier to set
     */
    public void setTxIdentifier(TextField txIdentifier) {
        this.txIdentifier = txIdentifier;
    }

    /**
     * @return the txCreator
     */
    public TextField getTxCreator() {
        return txCreator;
    }

    /**
     * @param txCreator the txCreator to set
     */
    public void setTxCreator(TextField txCreator) {
        this.txCreator = txCreator;
    }

    /**
     * @return the btnSearch
     */
    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @param btnSearch the btnSearch to set
     */
    public void setBtnSearch(HtmlCommandButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    /**
     * @return the btnAdvSearch
     */
    public HtmlCommandButton getBtnAdvSearch() {
        return btnAdvSearch;
    }

    /**
     * @param btnAdvSearch the btnAdvSearch to set
     */
    public void setBtnAdvSearch(HtmlCommandButton btnAdvSearch) {
        this.btnAdvSearch = btnAdvSearch;
    }

    /**
     * @return the dataTableDublinCore
     */
    public HtmlDataTable getDataTableDublinCore() {
        return dataTableDublinCore;
    }

    /**
     * @param dataTableDublinCore the dataTableDublinCore to set
     */
    public void setDataTableDublinCore(HtmlDataTable dataTableDublinCore) {
        this.dataTableDublinCore = dataTableDublinCore;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the selected
     */
    public String getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(String selected) {
        this.selected = selected;
    }

    /**
     * @return the ddIndicatorsDublinCore
     */
    public DropDown getDdIndicatorsDublinCore() {
        return ddIndicatorsDublinCore;
    }

    /**
     * @param ddIndicatorsDublinCore the ddIndicatorsDublinCore to set
     */
    public void setDdIndicatorsDublinCore(DropDown ddIndicatorsDublinCore) {
        this.ddIndicatorsDublinCore = ddIndicatorsDublinCore;
    }

    /**
     * @return the ddRanges
     */
    public DropDown getDdRanges() {
        return ddRanges;
    }

    /**
     * @param ddRanges the ddRanges to set
     */
    public void setDdRanges(DropDown ddRanges) {
        this.ddRanges = ddRanges;
    }

    /**
     * @return the ddIndicatorsComponentPart
     */
    public DropDown getDdIndicatorsComponentPart() {
        return ddIndicatorsComponentPart;
    }

    /**
     * @param ddIndicatorsComponentPart the ddIndicatorsComponentPart to set
     */
    public void setDdIndicatorsComponentPart(DropDown ddIndicatorsComponentPart) {
        this.ddIndicatorsComponentPart = ddIndicatorsComponentPart;
    }

    /**
     * @return the indicatorRelationsAP
     */
    public Option[] getIndicatorRelationsAP() {
        return indicatorRelationsAP;
    }

    /**
     * @param indicatorRelationsAP the indicatorRelationsAP to set
     */
    public void setIndicatorRelationsAP(Option[] indicatorRelationsAP) {
        this.indicatorRelationsAP = indicatorRelationsAP;
    }

    /**
     * @return the ddAuthorType
     */
    public DropDown getDdAuthorType() {
        return ddAuthorType;
    }

    /**
     * @param ddAuthorType the ddAuthorType to set
     */
    public void setDdAuthorType(DropDown ddAuthorType) {
        this.ddAuthorType = ddAuthorType;
    }

  

    /**
     * @return the taxonAuthors
     */
    public Option[] getTaxonAuthors() {
        return taxonAuthors;
    }

    /**
     * @param taxonAuthors the taxonAuthors to set
     */
    public void setTaxonAuthors(Option[] taxonAuthors) {
        this.taxonAuthors = taxonAuthors;
    }

    /**
     * @return the authorQuantityTotal
     */
    public String getAuthorQuantityTotal() {
        return authorQuantityTotal;
    }

    /**
     * @param authorQuantityTotal the authorQuantityTotal to set
     */
    public void setAuthorQuantityTotal(String authorQuantityTotal) {
        this.authorQuantityTotal = authorQuantityTotal;
    }

    /**
     * @return the dataTableAuthors
     */
    public HtmlDataTable getDataTableAuthors() {
        return dataTableAuthors;
    }

    /**
     * @param dataTableAuthors the dataTableAuthors to set
     */
    public void setDataTableAuthors(HtmlDataTable dataTableAuthors) {
        this.dataTableAuthors = dataTableAuthors;
    }

    /**
     * @return the ddConnector
     */
    public DropDown getDdConnector() {
        return ddConnector;
    }

    /**
     * @param ddConnector the ddConnector to set
     */
    public void setDdConnector(DropDown ddConnector) {
        this.ddConnector = ddConnector;
    }

   

    
}

