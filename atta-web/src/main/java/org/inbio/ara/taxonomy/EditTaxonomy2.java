/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.awt.event.ActionEvent;
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
import javax.faces.application.ViewHandler;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.indicator.IndicatorSessionBean;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.dto.taxonomy.SynonymDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTO;
import org.inbio.ara.dto.taxonomy.TaxonCountryDTO;
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

    private HtmlPanelGrid externalData = new HtmlPanelGrid();


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

    private Option[] indicatorRelationsAP = new Option[0];

    private DropDown ddIndicators= new DropDown();

    private DropDown ddIndicatorsComponentPart= new DropDown();



    private String quantityTotal = new String();
    private String selected = new String();

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

    private DropDown ddIndicatorsDublinCore= new DropDown();


    /* Taxon-Author */
    private DropDown ddAuthorType= new DropDown();
    private Option[] taxonAuthors = new Option[0];
    private String authorQuantityTotal = new String("0");
    private HtmlDataTable dataTableAuthors = new HtmlDataTable();
    private DropDown ddConnector = new DropDown();

    private HtmlDataTable dataTableSynonyms = new HtmlDataTable();

    private HtmlDataTable dataTableCountries = new HtmlDataTable();

    private Option[] countries = new Option[0];

    private String urlGBIF = "";
    private String urlEOL = "";
    private String urlWikispecies = "";





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

        
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        TaxonAutoCompleteSessionBean tacb = this.getTaxonAutoCompleteSessionBean();
        SynonymAutoCompleteSessionBean sacb = this.getSynonymAutoCompleteSessionBean();

        //LOAD TAXON
        
        hiddenTaxonNodeId.setValue(tsb.getTaxonNodeId());
        hiddenPathTaxonNode.setValue(tsb.getPathTaxonNode());
        hiddenCollecNomenclGroupId.setValue(tsb.getCollecNomenclGroupId());
        hiddenTypeGroup.setValue(tsb.getTypeGroup());

        hiddenNodeId.setValue(tsb.getNodeId());
        hiddenPathNode.setValue(tsb.getPathNode());

        //set urls
        urlGBIF = "window.open('http://data.gbif.org/ws/rest/taxon/list?scientificname="+this.getTaxonSessionBean().getCurrentTaxon().getCurrentName()+"', 'popupWindowName', 'dependent=yes, menubar=no, toolbar=no'); return false;";
        setUrlEOL("window.open('http://www.eol.org/search?q=" + this.getTaxonSessionBean().getCurrentTaxon().getCurrentName() + "', 'popupWindowName', 'dependent=yes, menubar=no, toolbar=no'); return false;");
        setUrlWikispecies("window.open('http://species.wikimedia.org/wiki/" + this.getTaxonSessionBean().getCurrentTaxon().getCurrentName() + "', 'popupWindowName', 'dependent=yes, menubar=no, toolbar=no'); return false;");

        if(tsb.getCurrentTaxon().getAuthorFormatParenthesis() == 1)
        {
            tsb.setCheckedParentheses(true);
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

                tsb.setEditAuthorList(tsb.getCurrentTaxon().getTaxonKey());

                tsb.loadAllTaxonAuthors();
                tsb.setTaxonAuthors(tsb.getCurrentTaxon().getTaxonKey());
                tsb.loadTaxonAuthorSequence();

                

                tsb.setAuthorTypeSelected((Long)tsb.getTaxonAuthorsMap().keySet().toArray()[0]);
                              
            }



            //set authorSequence
            
            if(tsb.getTaxonAuthorSequence() == -1)
            {
                
                tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected()));
            }
             
            //load taxonAuthors
            taxonAuthors = new Option[tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()).size()];            
            tsb.getTaxonAuthorsMap().get(tsb.getAuthorTypeSelected()).toArray(taxonAuthors);

            

            //load authorList
            if(tsb.getAuthorList() == null || tsb.getAuthorList().size() == 0)
            {
                tsb.setAuthorList(tsb.getAuthorListMap().get(tsb.getAuthorTypeSelected()));

            }

            //set authorsLabel
            tsb.setAuthors(tsb.getAuthorsLabel());

            
        
        }


        //On focus tabTaxonCountry:
        if(tsb.getTaxonTabSelected().equals("tabTaxonCountry"))
        {
          
            //load CountryList
            if(tsb.getCountries().size() == 0)
            {

                //tsb.setEditAuthorList(tsb.getCurrentTaxon().getTaxonKey());
                tsb.setCountryList(tsb.getTaxonCountriesByTaxon(tsb.getCurrentTaxon().getTaxonKey()));

                tsb.loadAllCountries();
                
                tsb.setCountries();

            }

            //load countries
            countries = new Option[tsb.getCountries().size()];
            tsb.getCountries().toArray(countries);

        }


        //On focus tabSynonyms:
        if(tsb.getTaxonTabSelected().equals("tabSynonyms"))
        {
            if(tsb.getSynonymList().size() == 0 )
            {
                tsb.setSynonymList(this.getTaxonSessionBean().getSynonymsByTaxonId(tsb.getCurrentTaxon().getTaxonKey()));
                tsb.setSynonymDBList(this.getTaxonSessionBean().getSynonymsByTaxonId(tsb.getCurrentTaxon().getTaxonKey()));

                tsb.setSynonymListSize(tsb.getSynonymList().size());
            }
        }
        //LOAD TAXON-INDICATOR
        
        if(tsb.getIndicatorRelations() == null)
        {
            
            tsb.setIndicatorRelations(
                    tsb.getIndicatorByTaxon(tsb.getCurrentTaxon().getTaxonKey()));
            tsb.setDbIndicatorRelations(
                    tsb.getIndicatorByTaxon(tsb.getCurrentTaxon().getTaxonKey()));
            tsb.setIndicatorRelationsAP(
                    tsb.getIndicatorAPByTaxon(tsb.getCurrentTaxon().getTaxonKey()));

        
        }
        
        indicatorRelations = new Option[tsb.getIndicatorRelations().size()];

        
        tsb.getIndicatorRelations().toArray(indicatorRelations);

        //Set default indicator value selected
        if(tsb.getDdIndicatorSelected() == null && indicatorRelations.length>0)
        {
            tsb.setDdIndicatorSelected((Long)indicatorRelations[0].getValue());


        }

        
        //LOAD TAXON-INDICATOR-COUNTRY
        //On focus tabTaxonIndicatorCountry:
        if(tsb.getTaxonTabSelected().equals("tabTaxonIndicatorCountry"))
        {
            
            //Load countries
            loadAddRemoveData(false);
            
            if(tsb.getDbIndicatorRelations() == null || tsb.getdBTaxonIndicatorCountriesId().size()<=0)
            {
                for(Option indicatorId: tsb.getIndicatorRelations())
                {
                    Long indicator = new Long(indicatorId.getValue().toString());
                    List<Long> countries = tsb.getCountriesByTaxonIndicatorIds(tsb.getCurrentTaxon().getTaxonKey(), indicator);
                    Option[] countriesOp = new Option[countries.size()];
                    for(int pos = 0; pos < countriesOp.length; pos++)
                    {

                        CountryDTO country = tsb.getCountryByCountryId(countries.get(pos));
                        countriesOp[pos] = new Option(countries.get(pos), country.getValue());
                    }

                    tsb.getSelectedTaxonIndicatorCountriesId().put(indicator, countriesOp);
                    tsb.getdBTaxonIndicatorCountriesId().put(indicator, countriesOp);
                }
                updateRightList();
            }
        }

        setVisibleIndicator();
        if(tsb.getIndicatorRelations().size()>0 && tsb.isAbleTabTaxonIndicator())
        {
            tsb.setAbleTabTaxonIndicatorCountry(true);
            
        }
        else
        {
            tsb.setAbleTabTaxonIndicatorCountry(false);
            
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

            if(tsb.getDbIndicatorRelations() == null || (tsb.getdBTaxonIndicatorComponentPartId() == null || tsb.getdBTaxonIndicatorComponentPartId().size()<=0))
            {

                for(Option indicatorId: tsb.getIndicatorRelationsAP())
                {
                    Long indicator = new Long(indicatorId.getValue().toString());
                    List<Long> componentPart = tsb.getComponentPartByTaxonIndicatorIds(tsb.getCurrentTaxon().getTaxonKey(), indicator);
                    Option[] componentPartOp = new Option[componentPart.size()];
                    for(int pos = 0; pos < componentPartOp.length; pos++)
                    {

                        SelectionListDTO componentPartDTO = tsb.getSelectionListElementById(this.getAraSessionBean().getGlobalCollectionId(),componentPart.get(pos));
                        componentPartOp[pos] = new Option(componentPart.get(pos), componentPartDTO.getValueName());
                    }

                    tsb.getSelectedTaxonIndicatorComponentPartId().put(indicator, componentPartOp);
                    tsb.getdBTaxonIndicatorComponentPartId().put(indicator, componentPartOp);
                }
                updateRightComponentPartList();
            }


        }

        //On focus tabTaxonIndicatorReferences:
        if(tsb.getTaxonTabSelected().equals("tabBibliographicReferences"))
        {

            if(tsb.getdBTaxonIndicatorDublinCoreId() == null)
            {
                loadTaxonIndicatorDublinCore(tsb.getCurrentTaxon().getTaxonKey(), tsb.getIndicatorRelations());
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

            if(tsb.getDdIndicatorDCSelected() == null && indicatorRelations.length>0)
            {
                tsb.setDdIndicatorDCSelected((Long)indicatorRelations[0].getValue());
                updateIndicatorDCSelected();

            }

        }

        if(tsb.getIndicatorRelations().size()>0 && tsb.getCurrentTaxon().getTaxonomicalRangeId().equals
                (TaxonomicalRangeEntity.SPECIES.getId()))
        {
            tsb.setAbleTabTaxonIndicatorCountry(true);
            if(tsb.getIndicatorRelationsAP().size()>0)
            {
                tsb.setAbleTabTaxonIndicatorComponentPart(true);
            }
            else
            {
                tsb.setAbleTabTaxonIndicatorComponentPart(false);
            }
            tsb.setAbleTabTaxonIndicatorDublinCore(true);
        }
        else
        {
            tsb.setAbleTabTaxonIndicatorCountry(false);
            tsb.setAbleTabTaxonIndicatorComponentPart(false);
            tsb.setAbleTabTaxonIndicatorDublinCore(false);
        }

        tacb.setCategoryId(1L);//ACEPTED
        sacb.setCategoryId(1L);//ACEPTED
        
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



    public void loadTaxonIndicatorDublinCore(Long taxonId,Set<Option> indicatorIds)
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.setdBTaxonIndicatorDublinCoreId(new HashMap<Long, Map<String, ReferenceDTO>>());
        tsb.setSelectedTaxonIndicatorDublinCoreId(new HashMap<Long, Map<String, ReferenceDTO>>());
        
        for(Option indicatorOption: indicatorIds)
        {
            Long indicatorId = (Long)indicatorOption.getValue();
            List<Long> dublinCoreIds = tsb.getDublinCoreByTaxonIndicatorIds(taxonId, indicatorId);
            if(dublinCoreIds != null || dublinCoreIds.size()>0)
            {
                tsb.getSelectedTaxonIndicatorDublinCoreId().put(indicatorId, new HashMap<String,ReferenceDTO>());
                tsb.getdBTaxonIndicatorDublinCoreId().put(indicatorId, new HashMap<String,ReferenceDTO>());
                Map selectedDublinCoreMap = tsb.getSelectedTaxonIndicatorDublinCoreId().get(indicatorId);
                Map dbDublinCoreMap = tsb.getdBTaxonIndicatorDublinCoreId().get(indicatorId);
                for(Long dublinCoreId : dublinCoreIds)
                {
                    ReferenceDTO reference = tsb.dublinCoreDTOToReferenceDTO(tsb.getDublinCoreMetadataByResourceId(dublinCoreId));
                    selectedDublinCoreMap.put(dublinCoreId, reference);
                    dbDublinCoreMap.put(dublinCoreId, reference);
                }                
            }
            
           
        }

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



    public String updateIndicatorDCSelected()
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();
        if(tsb.getSelectedTaxonIndicatorDublinCoreId().containsKey(tsb.getDdIndicatorDCSelected()))
        {

            tsb.setSelectedResourcesId( new HashMap<String, ReferenceDTO>());

            Set<Entry<String, ReferenceDTO>> copiaRef = tsb.getSelectedTaxonIndicatorDublinCoreId().get(tsb.getDdIndicatorDCSelected()).entrySet();
            for(Entry element: copiaRef)
            {
                tsb.getSelectedResourcesId().put(element.getKey().toString(),(ReferenceDTO)element.getValue());
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

    public int getPosTaxonAuthor(Long taxonAuthorId, List<TaxonAuthorDTO> taxonAuthor)
    {

        int result = -1;
        for(int pos = 0; pos < taxonAuthor.size(); pos++)
        {
            if(taxonAuthor.get(pos).getTaxonAuthorPersonId().equals(taxonAuthorId))
            {                
                result = pos;
                break;
            }
        }
        return result;
    }

    public String btnSaveTaxon_action()
    {

        //SAVE TAXON
        TaxonSessionBean TSB = this.getTaxonSessionBean();
        TaxonAutoCompleteSessionBean TACSB = this.getTaxonAutoCompleteSessionBean();

        if((TACSB.getIdSelected()!= null && TACSB.getText().length()>0) ||
                (TACSB.getIdSelected() == null && TACSB.getText().length() ==0))
        {
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
                 defaultTaxonName = names[0]+" "+TSB.getCurrentTaxon().getCurrentName();
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

             TSB.getCurrentTaxon().setSynonymTaxonId(TACSB.getIdSelected());
             //UPDATE TAXON
            TSB.updateTaxon(TSB.getCurrentTaxon());

            //PREPARE SYNONYMS

            //System.out.println("SynonymList Size = "+TSB.getSynonymList().size());
            //System.out.println("SynonymDBList Size = "+TSB.getSynonymDBList().size());
            if(TSB.getSynonymList().size() > 0)
            {
                if(TSB.getSynonymDBList().size() > 0)
                {

                    //Convert database
                    List<Long> dbSynonyms = new ArrayList<Long>();
                    for(SynonymDTO dbSynonym: TSB.getSynonymDBList())
                    {
                        dbSynonyms.add(dbSynonym.getTaxonKey());
                    }
                    System.out.println(dbSynonyms.toString());
                    //Convert selected 
                    List<Long> selectedSynonyms = new ArrayList<Long>();
                    for(SynonymDTO selectedSynonym: TSB.getSynonymList())
                    {
                        selectedSynonyms.add(selectedSynonym.getTaxonKey());
                    }
                    System.out.println(selectedSynonyms.toString());
                    //Filter new relation and delet relations
                    List<Long> newSynonymList = new ArrayList<Long>();
                    for(Long  synonym: selectedSynonyms)
                    {
                        if(dbSynonyms.contains(synonym))//not changes on relacion, exist
                        {

                              dbSynonyms.remove(synonym);
                        }
                        else
                        {

                            newSynonymList.add(synonym);
                        }
                    }

                    if(newSynonymList.size()>0)
                    {
                        //System.out.println("Mando a salvar");
                        TSB.saveSynonyms(TSB.getCurrentTaxon().getTaxonKey(), newSynonymList);
                    }

                    if(dbSynonyms.size()>0)
                    {
                        //System.out.println("Mando a borrar");
                        TSB.deleteSynonyms(TSB.getCurrentTaxon().getTaxonKey(), dbSynonyms);
                    }
                    
                }
                else
                {

                    //Prepare all new relation from a new taxon-indicator
                    List<Long> tmp  = new ArrayList<Long>();
                    for(SynonymDTO tmpSynonym :TSB.getSynonymList())
                    {
                        tmp.add(tmpSynonym.getTaxonKey());
                    }
                    //newTaxonIndicatorComponentPart.put(indicatorId, tmp);

                }
            }




            //PREPARE TAXON-AUTHOR
            Map<Long, List<TaxonAuthorDTO>> newAuthorListMap = new HashMap<Long, List<TaxonAuthorDTO>>();
            Map<Long, List<TaxonAuthorDTO>> deleteAuthorListMap = new HashMap<Long, List<TaxonAuthorDTO>>();
            Map<Long, List<TaxonAuthorDTO>> updateAuthorListMap = new HashMap<Long, List<TaxonAuthorDTO>>();

            TSB.getAuthorListMap().put(TSB.getAuthorTypeSelected(), TSB.getAuthorList());

            TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
            if(TSB.getDbAuthorListMap() != null || TSB.getDbAuthorListMap().size() > 0)
            {
                for(int pos = 0; pos < tap.length; pos++)
                {
                    Long authorType = tap[pos].getId();
                    //si contiene el tipo de autor
                    if(TSB.getAuthorListMap().containsKey(authorType))
                    {
                        List<TaxonAuthorDTO> taxonAuthorDTOs = TSB.getAuthorListMap().get(authorType);
                        //si el respaldo de la bd contiene relaciones autor-taxon
                        if(TSB.getDbAuthorListMap().containsKey(authorType))
                        {
                            List<TaxonAuthorDTO> newTaxonAuthorDTOs = new ArrayList<TaxonAuthorDTO>();
                            List<TaxonAuthorDTO> updateTaxonAuthorDTOs = new ArrayList<TaxonAuthorDTO>();
                            List<TaxonAuthorDTO> deleteTaxonAuthorDTOs = new ArrayList<TaxonAuthorDTO>();


                            List<TaxonAuthorDTO> dbTaxonAuthorDTOs = TSB.getDbAuthorListMap().get(authorType);


                            int listSize = 0;
                            boolean delete = false;

                            if(taxonAuthorDTOs.size() < dbTaxonAuthorDTOs.size())
                            {
                                listSize = taxonAuthorDTOs.size();
                                delete = true;
                            }
                            else
                            {
                                listSize = dbTaxonAuthorDTOs.size();
                                delete = false;
                            }

                            for(int posList = 0; posList < listSize; posList++)
                            {
                                if(!taxonAuthorDTOs.get(posList).getTaxonAuthorPersonId().equals(dbTaxonAuthorDTOs.get(posList).getTaxonAuthorPersonId()))                           {

                                    updateTaxonAuthorDTOs.add(taxonAuthorDTOs.get(posList));
                                }
                                else
                                {
                                     if((dbTaxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() != null &&
                                                taxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() == null) ||
                                                (dbTaxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() == null &&
                                                    taxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() != null))
                                        {
                                            updateTaxonAuthorDTOs.add(taxonAuthorDTOs.get(posList));
                                        }
                                        else
                                        {
                                             if(((dbTaxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() != null && taxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId() != null)
                                                     && !(dbTaxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId().equals(taxonAuthorDTOs.get(posList).getTaxonAuthorConnectorId()))))                                        {

                                                    updateTaxonAuthorDTOs.add(taxonAuthorDTOs.get(posList));
                                             }
                                        }
                                }


                            }
                            if(delete)
                            {
                                deleteTaxonAuthorDTOs.addAll(dbTaxonAuthorDTOs.subList(taxonAuthorDTOs.size(),dbTaxonAuthorDTOs.size()));
                            }
                            else
                            {
                                newTaxonAuthorDTOs.addAll(taxonAuthorDTOs.subList(dbTaxonAuthorDTOs.size(), taxonAuthorDTOs.size()));
                            }


                            if(newTaxonAuthorDTOs.size() > 0)
                            {
                                TSB.saveTaxonAuthorDTOs(TSB.getCurrentTaxon().getTaxonKey(), newTaxonAuthorDTOs, this.getAraSessionBean().getGlobalUserName());
                            }
                            if(deleteTaxonAuthorDTOs.size() > 0)
                            {
                                TSB.deleteTaxonAuthorByTaxonAuthorIds(deleteTaxonAuthorDTOs);
                            }
                            if(updateTaxonAuthorDTOs.size() > 0)
                            {
                                TSB.updateTaxonAuthors(updateTaxonAuthorDTOs);
                            }
                        }
                        //todos son relaciones nuevas
                        else
                        {
                            TSB.saveTaxonAuthorDTOs(TSB.getCurrentTaxon().getTaxonKey(), taxonAuthorDTOs, this.getAraSessionBean().getGlobalUserName());
                        }
                    }
                }
            }


            //PREPARE TAXON-COUNTRY
           


            //TSB.getAuthorListMap().put(TSB.getAuthorTypeSelected(), TSB.getAuthorList());

            //TaxonAuthorProfile[] tap = TaxonAuthorProfile.values();
            if(TSB.getCountryDBList() != null || TSB.getCountryDBList().size() > 0)
            {

                //List<TaxonCountryDTO> taxonCountryDTOs = TSB.getCountryList();
                if(TSB.getCountryList() != null || TSB.getCountryList().size() > 0)
                {
                    //si el respaldo de la bd contiene relaciones autor-taxon
                    List<TaxonCountryDTO> newTaxonCountryDTOs = new ArrayList<TaxonCountryDTO>();
                    List<TaxonCountryDTO> updateTaxonCountryDTOs = new ArrayList<TaxonCountryDTO>();
                    //List<TaxonCountryDTO> deleteTaxonCountryDTOs = new ArrayList<TaxonCountryDTO>();


                    //List<TaxonCountryDTO> dbTaxonCountryDTOs = TSB.getCountryDBList();

                    for(TaxonCountryDTO taxonCountryDto : TSB.getCountryList())
                    {
                        int posTaxonCountry = TSB.findTaxonCountry(taxonCountryDto.getCountryId(), TSB.getCountryDBList());
                        if(posTaxonCountry >= 0)
                        {
                            if(!TSB.getCountryList().get(posTaxonCountry).getDescription().equals(taxonCountryDto.getDescription()))
                            {
                                updateTaxonCountryDTOs.add(taxonCountryDto);
                            }
                            TSB.getCountryDBList().remove(posTaxonCountry);
                        }
                        else
                        {
                            newTaxonCountryDTOs.add(taxonCountryDto);
                        }
                    }
                    
                    //SAVE TAXON-COUNTRY
                    if(newTaxonCountryDTOs.size() > 0)
                    {
                        System.out.println("NEW TAXON-COUNTRY");

                        for(TaxonCountryDTO tc : newTaxonCountryDTOs)
                        {
                            System.out.println("\t"+tc.getCountryName());
                        }
                        TSB.saveTaxonCountryDTOs(TSB.getCurrentTaxon().getTaxonKey(), newTaxonCountryDTOs, this.getAraSessionBean().getGlobalUserName());
                    }
                    if(TSB.getCountryDBList().size() > 0)
                    {
                        System.out.println("DELETE TAXON-COUNTRY");

                        for(TaxonCountryDTO tc : TSB.getCountryDBList())
                        {
                            System.out.println("\t"+tc.getCountryName());
                        }
                        TSB.deleteTaxonCountryByTaxonCountryIds(TSB.getCountryDBList());
                    }
                    if(updateTaxonCountryDTOs.size() > 0)
                    {
                        System.out.println("UPDATE TAXON-COUNTRY");

                        for(TaxonCountryDTO tc : updateTaxonCountryDTOs)
                        {
                            System.out.println("\t"+tc.getCountryName());
                        }
                        TSB.updateTaxonCountries(updateTaxonCountryDTOs);
                    }
                }
                
                //todos son relaciones nuevas
                else
                {
                    TSB.saveTaxonCountryDTOs(TSB.getCurrentTaxon().getTaxonKey(), TSB.getCountryList(), this.getAraSessionBean().getGlobalUserName());
                }
                
                
            }



            //PREPARE TAXON-INDICATOR-COUTRY
            Map<Long,List<Long>> newTaxonIndicatorCountry = new HashMap<Long, List<Long>>();
            Map<Long,List<Long>> deleteTaxonIndicatorCountry = new HashMap<Long, List<Long>>();

            if(TSB.getIndicatorRelations().size()>0)
            {
                for(Option indicatorOption: TSB.getIndicatorRelations())
                {

                    Long indicatorId = new Long(indicatorOption.getValue().toString());

                    //si contiene relaciones taxon-indicator-country
                    if(TSB.getSelectedTaxonIndicatorCountriesId().containsKey(indicatorId))
                    {
                        if(TSB.getdBTaxonIndicatorCountriesId().containsKey(indicatorId))
                        {

                            //Convert database country relations
                            List<Long> dbCountries = new ArrayList<Long>();
                            for(Option dbCountry: TSB.getdBTaxonIndicatorCountriesId().get(indicatorId))
                            {
                                dbCountries.add((Long)dbCountry.getValue());
                            }
                            //Convert selected country relations
                            List<Long> selectedCountries = new ArrayList<Long>();
                            for(Option sCountry: TSB.getSelectedTaxonIndicatorCountriesId().get(indicatorId))
                            {
                                selectedCountries.add((Long)sCountry.getValue());
                            }

                            //Filter new relation and delet relations
                            List<Long> newCountries = new ArrayList<Long>();
                            for(Long  country: selectedCountries)
                            {
                                if(dbCountries.contains(country))//not changes on relacion, exist
                                {

                                      dbCountries.remove(country);
                                }
                                else
                                {

                                    newCountries.add(country);
                                }
                            }
                            newTaxonIndicatorCountry.put(indicatorId,newCountries);
                            deleteTaxonIndicatorCountry.put(indicatorId,dbCountries);
                        }
                        else
                        {

                            //Prepare all new relation from a new taxon-indicator
                            List<Long> tmp  = new ArrayList<Long>();
                            for(Option tmpCountry :TSB.getSelectedTaxonIndicatorCountriesId().get(indicatorId))
                            {
                                tmp.add(new Long(tmpCountry.getValue().toString()));
                            }
                            newTaxonIndicatorCountry.put(indicatorId, tmp);

                        }
                    }


                }

            }


            //PREPARE TAXON-INDICATOR-COMPONENT_PART
            Map<Long,List<Long>> newTaxonIndicatorComponentPart = new HashMap<Long, List<Long>>();
            Map<Long,List<Long>> deleteTaxonIndicatorComponentPart = new HashMap<Long, List<Long>>();

            if(TSB.getIndicatorRelationsAP().size()>0)
            {
                for(Option indicatorOption: TSB.getIndicatorRelationsAP())
                {

                    Long indicatorId = new Long(indicatorOption.getValue().toString());

                    //si contiene relaciones taxon-indicator-country
                    if(TSB.getSelectedTaxonIndicatorComponentPartId().containsKey(indicatorId))
                    {
                        if(TSB.getdBTaxonIndicatorComponentPartId().containsKey(indicatorId))
                        {

                            //Convert database country relations
                            List<Long> dbComponentParts = new ArrayList<Long>();
                            for(Option dbComponentPart: TSB.getdBTaxonIndicatorComponentPartId().get(indicatorId))
                            {
                                dbComponentParts.add((Long)dbComponentPart.getValue());
                            }
                            //Convert selected country relations
                            List<Long> selectedComponentParts = new ArrayList<Long>();
                            for(Option sComponentPart: TSB.getSelectedTaxonIndicatorComponentPartId().get(indicatorId))
                            {
                                selectedComponentParts.add((Long)sComponentPart.getValue());
                            }

                            //Filter new relation and delet relations
                            List<Long> newComponentPart = new ArrayList<Long>();
                            for(Long  componentPart: selectedComponentParts)
                            {
                                if(dbComponentParts.contains(componentPart))//not changes on relacion, exist
                                {

                                      dbComponentParts.remove(componentPart);
                                }
                                else
                                {

                                    newComponentPart.add(componentPart);
                                }
                            }
                            newTaxonIndicatorComponentPart.put(indicatorId,newComponentPart);
                            deleteTaxonIndicatorComponentPart.put(indicatorId,dbComponentParts);
                        }
                        else
                        {

                            //Prepare all new relation from a new taxon-indicator
                            List<Long> tmp  = new ArrayList<Long>();
                            for(Option tmpComponentPart :TSB.getSelectedTaxonIndicatorComponentPartId().get(indicatorId))
                            {
                                tmp.add(new Long(tmpComponentPart.getValue().toString()));
                            }
                            newTaxonIndicatorComponentPart.put(indicatorId, tmp);

                        }
                    }

                }
            }


            //PREPARE TAXON-INDICATOR-DUBLIN_CORE
            Map<Long,List<String>> newTaxonIndicatorDublinCore = new HashMap<Long, List<String>>();
            Map<Long,List<String>> deleteTaxonIndicatorDublinCore = new HashMap<Long, List<String>>();

            if(TSB.getIndicatorRelations().size()>0)
            {
                for(Option indicatorOption: TSB.getIndicatorRelations())
                {
                    Long indicatorId = new Long(indicatorOption.getValue().toString());
                    //si contiene relaciones taxon-indicator-country
                    if(TSB.getSelectedTaxonIndicatorDublinCoreId() != null && TSB.getSelectedTaxonIndicatorDublinCoreId().containsKey(indicatorId))
                    {
                        if(TSB.getdBTaxonIndicatorDublinCoreId().containsKey(indicatorId))
                        {
                            //Convert data base country relations
                            List<String> dbDublinCore = new ArrayList<String>();
                            Collection<ReferenceDTO> copydbDC = (TSB.getdBTaxonIndicatorDublinCoreId().get(indicatorId)).values();
                            for(ReferenceDTO dataBaseDublinCoreId: copydbDC)
                            {
                                dbDublinCore.add(dataBaseDublinCoreId.getKey());
                            }

                            //Convert selected country relations
                            List<String> selectedDublinCore = new ArrayList<String>();
                            Collection<ReferenceDTO> copySelectedDC = TSB.getSelectedTaxonIndicatorDublinCoreId().get(indicatorId).values();
                            for(ReferenceDTO sDublinCoreId: copySelectedDC)
                            {
                                selectedDublinCore.add(sDublinCoreId.getKey());
                            }

                            //Filter new relation and delet relations
                            List<String> newDublinCore = new ArrayList<String>();
                            for(String  dublinCore: selectedDublinCore)
                            {
                                if(dbDublinCore.contains(dublinCore))//not changes on relacion, exist
                                {
                                      dbDublinCore.remove(dublinCore);
                                }
                                else
                                {
                                    newDublinCore.add(dublinCore);
                                }
                            }
                            newTaxonIndicatorDublinCore.put(indicatorId,newDublinCore);
                            deleteTaxonIndicatorDublinCore.put(indicatorId,dbDublinCore);
                        }
                        else
                        {
                            //Prepare all new relation from a new taxon-indicator
                            List<String> tmp  = new ArrayList<String>();
                            Set<String> slDublinCore = TSB.getSelectedTaxonIndicatorDublinCoreId().get(indicatorId).keySet();
                            for(String tmpDublinCore: slDublinCore)
                            {
                                tmp.add(tmpDublinCore);
                            }
                            newTaxonIndicatorDublinCore.put(indicatorId, tmp);
                        }
                    }
                }

            }



            //PREPARE TAXON-INDICATOR
            if(this.getTaxonSessionBean().getIndicatorRelations() != null || this.getTaxonSessionBean().getIndicatorRelations().size()>0)
            {
                //Parche feo que luego debo arreglar, al comparar Option no quiere reconocer los que son iguales
                List<String> newIndicatorTaxonIds = new ArrayList<String>();
                List<String> dbIndicatorTaxonIds = new  ArrayList<String>();


                List<String> copiaDb = new ArrayList<String>();
                //Copia los Id de la Base de datos a una lista copiaDb
                for(Option p: TSB.getDbIndicatorRelations())
                {
                    copiaDb.add(p.getValue().toString());

                }

                //Copia los Id seleccionadas a una lista copiaSelected
                List<String> copiaSelected = new ArrayList<String>();
                for(Option q: TSB.getIndicatorRelations())
                {
                    copiaSelected.add(q.getValue().toString());

                }

                //Obtiene la lista de nuevas relaciones y de las relaciones que se deben eliminar
                for(String element: copiaSelected)
                {
                    if(copiaDb.contains(element))
                    {

                          dbIndicatorTaxonIds.add(element);
                          copiaDb.remove(element);
                    }
                    else
                    {
                        newIndicatorTaxonIds.add(element);
                    }
                }

                //Salva las nuevas relaciones
                Long taxonId = TSB.getCurrentTaxon().getTaxonKey();
                for(String newIndicator: newIndicatorTaxonIds)
                {   Long indicatorId = new Long(newIndicator);
                    TSB.saveTaxonIndicatorId(taxonId, newIndicator, this.getAraSessionBean().getGlobalUserName());
                    if(newTaxonIndicatorCountry.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorCountries(taxonId, indicatorId, newTaxonIndicatorCountry.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                    if(newTaxonIndicatorComponentPart.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorComponentPartIds(taxonId, indicatorId, newTaxonIndicatorComponentPart.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                    if(newTaxonIndicatorDublinCore.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorDublinCoreIds(taxonId, indicatorId, newTaxonIndicatorDublinCore.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                }
                //Update relations
                for(String dbIndicator: dbIndicatorTaxonIds)
                {   Long indicatorId = new Long(dbIndicator);
                    if(newTaxonIndicatorCountry.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorCountries(taxonId, indicatorId, newTaxonIndicatorCountry.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                    if(newTaxonIndicatorComponentPart.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorComponentPartIds(taxonId, indicatorId, newTaxonIndicatorComponentPart.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                    if(newTaxonIndicatorDublinCore.containsKey(indicatorId))
                    {
                        TSB.saveTaxonIndicatorDublinCoreIds(taxonId, indicatorId, newTaxonIndicatorDublinCore.get(indicatorId) , this.getAraSessionBean().getGlobalUserName());
                    }
                    if(deleteTaxonIndicatorCountry.containsKey(indicatorId))
                    {
                        TSB.deleteTaxonIndicatorCountryByIds(taxonId, indicatorId, deleteTaxonIndicatorCountry.get(indicatorId) );
                    }
                    if(deleteTaxonIndicatorComponentPart.containsKey(indicatorId))
                    {
                        TSB.deleteTaxonIndicatorComponentPartIds(taxonId, indicatorId, deleteTaxonIndicatorComponentPart.get(indicatorId) );
                    }
                    if(deleteTaxonIndicatorDublinCore.containsKey(indicatorId))
                    {
                        TSB.deleteTaxonIndicatorDublinCoreIds(taxonId, indicatorId, deleteTaxonIndicatorDublinCore.get(indicatorId));
                    }
                }

                //Elminina las relaciones deseleccionadas
                for(String deleteIndicator: copiaDb)
                {   Long indicatorId = new Long(deleteIndicator);

                    TSB.deleteTaxonIndicatorCountryByTaxonIndicator(taxonId, indicatorId);
                    TSB.deleteTaxonIndicatorComponentPartByTaxonIndicator(taxonId, indicatorId);
                    TSB.deleteTaxonIndicatorDublinCoreByTaxonIndicator(taxonId, indicatorId);
                    TSB.deleteTaxonIndicatorById(taxonId, indicatorId.toString());
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
           TSB.setElementSelected(null);

           //Taxon-Indicator-Country
           TSB.setSelectedTaxonIndicatorCountriesId(null);
           TSB.setdBTaxonIndicatorCountriesId(null);

           TSB.setArContries(null);
           TSB.setDdIndicatorSelected(null);
           TSB.setIndicatorRelations(null);
           TSB.getIndicatorRelationIds().clear();
           TSB.setIndicatorRelationsAP(null);
           TSB.setElementSelected(null);

           //Dublin Core
           TSB.setSelectedTaxonIndicatorDublinCoreId(null);
           TSB.setdBTaxonIndicatorDublinCoreId(null);
           TSB.setDdIndicatorDCSelected(null);

           //Component Part
            TSB.setdBTaxonIndicatorComponentPartId(null);
            TSB.setSelectedTaxonIndicatorComponentPartId(null);
            TSB.setArComponentPart(null);
            TSB.setDdIndicatorCPSelected(null);
            TSB.setIndicatorRelationsAP(null);

            


           return "back";
        }
        else
        {
            MessageBean.setErrorMessageFromBundle("error_synonym",this.getMyLocale());
            return null;
        }
    }

    public String btnAddTaxonIndicator_action()
    {
        this.getTaxonSessionBean().setNodeId(this.getHiddenNodeId().getValue().toString());
        Long indicatorNodeId = new Long(this.getHiddenNodeId().getValue().toString());
        if(this.getTaxonSessionBean().isLeaf(indicatorNodeId)){
            if(!this.getTaxonSessionBean().getIndicatorRelationIds().contains(indicatorNodeId))
            {
                IndicatorDTO infoNodo = this.getTaxonSessionBean().getIndicatorDTOByIndicatorId(indicatorNodeId);
                this.getTaxonSessionBean().getIndicatorRelations().add(new Option(indicatorNodeId, infoNodo.getName() ));
                this.getTaxonSessionBean().getIndicatorRelationIds().add(indicatorNodeId);

                
                if(infoNodo.getAppliesToParts() == 1)
                {
                    this.getTaxonSessionBean().getIndicatorRelationsAP().add(new Option(indicatorNodeId, infoNodo.getName() ));
                }

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
        this.getTaxonSessionBean().removeIndicatorOption(this.getTaxonSessionBean().getElementSelected(), this.getTaxonSessionBean().getIndicatorRelations());
        indicatorRelations = new Option[this.getTaxonSessionBean().getIndicatorRelations().size()];
        this.getTaxonSessionBean().getIndicatorRelations().toArray(indicatorRelations);
        return null;
    }

    public String btnAssociateCountries_action()
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.getSelectedTaxonIndicatorCountriesId().put(tsb.getDdIndicatorSelected(), tsb.getArContries().getRightOptions());
        return null;
    }

    protected TaxonAutoCompleteSessionBean getTaxonAutoCompleteSessionBean() {
        return (TaxonAutoCompleteSessionBean) getBean("taxonomy$TaxonAutoCompleteBean");
    }

    protected SynonymAutoCompleteSessionBean getSynonymAutoCompleteSessionBean() {
        return (SynonymAutoCompleteSessionBean) getBean("taxonomy$SynonymAutoCompleteBean");
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


    public String btnAssociateComponentPart_action()
    {


        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.getSelectedTaxonIndicatorComponentPartId().put(tsb.getDdIndicatorCPSelected(), tsb.getArComponentPart().getRightOptions());


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





    public void getSelectedResourceIds (HtmlDataTable selectedResources, Map<String, ReferenceDTO> selectedResourcesId)
    {


        int n = selectedResources.getRowCount();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            selectedResources.setRowIndex(i);
            ReferenceDTO aux = (ReferenceDTO) selectedResources.getRowData();

            if (aux.isSelected() && (!selectedResourcesId.containsKey(aux.getKey()))) {
                
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


    public String setVisibleIndicator()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        if(tsb.getCurrentTaxon().getTaxonomicalRangeId().equals
                (TaxonomicalRangeEntity.SPECIES.getId()))
        {
            tsb.setAbleTabTaxonIndicator(true);
        }
        else
        {
            tsb.setAbleTabTaxonIndicator(false);
            tsb.setAbleTabTaxonIndicatorCountry(false);            
        }
        return null;
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


    /* TAXON - AUTHOR */

    public String setAuthorList()
    {
        
        TaxonSessionBean tsb = this.getTaxonSessionBean();        
        if(tsb.getAuthorTypeSelected().equals(TaxonAuthorProfile.ORIGINALS.getId()))
        {            
            //set taxonAuthor
            setTaxonAuthors(new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).size()]);
            tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.ORIGINALS.getId()).toArray(getTaxonAuthors());

            //switch authorList           
            tsb.getAuthorListMap().put(TaxonAuthorProfile.MODIFICATORS.getId(),tsb.getAuthorList());            
            tsb.setAuthorList(tsb.getAuthorListMap().get(TaxonAuthorProfile.ORIGINALS.getId()));

            //switch taxonAuthorSequence
            tsb.getTaxonAuthorSequenceMap().put(TaxonAuthorProfile.MODIFICATORS.getId(),tsb.getTaxonAuthorSequence());
            tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(TaxonAuthorProfile.ORIGINALS.getId()));

        }
        else
        {       
            setTaxonAuthors(new Option[tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).size()]);
            tsb.getTaxonAuthorsMap().get(TaxonAuthorProfile.MODIFICATORS.getId()).toArray(getTaxonAuthors());

            //switch authorList            
            tsb.getAuthorListMap().put(TaxonAuthorProfile.ORIGINALS.getId(),tsb.getAuthorList());            
            tsb.setAuthorList(tsb.getAuthorListMap().get(TaxonAuthorProfile.MODIFICATORS.getId()));

            //switch taxonAuthorSequence
            tsb.getTaxonAuthorSequenceMap().put(TaxonAuthorProfile.ORIGINALS.getId(),tsb.getTaxonAuthorSequence());
            tsb.setTaxonAuthorSequence(tsb.getTaxonAuthorSequenceMap().get(TaxonAuthorProfile.MODIFICATORS.getId()));
        }

        return null;
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

    public String btnAddAuthor_action()
    {

        
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        
        btnCancelAuthor_action();


        tsb.setNewAuthorAction(true);

        if(tsb.getAuthorSelected() != null)
        {
            //Create new TaxonAuthorDTO
            tsb.setNewAuthor(new TaxonAuthorDTO());        
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
            if(tsb.getCountTaxonAuthorSelected() == 1)
            {
                tsb.setTaxonAuthorSequence(tsb.getNewAuthor().getTaxonAuthorSequence());
                tsb.setTaxonAuthorName(tsb.getNewAuthor().getTaxonAuthorName());
                
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

        TaxonSessionBean tsb = this.getTaxonSessionBean();

        TaxonAuthorDTO taxonAuthorSelected = tsb.getTaxonAuthorSelected();

        if(tsb.getCountTaxonAuthorSelected() >= 0)
        {
            if(tsb.getCountTaxonAuthorSelected() == 1)
            {
                tsb.removeTaxonAuthorSelected();
                tsb.addOptionToTaxonAuthors(taxonAuthorSelected);
                Long newSequence = tsb.getTaxonAuthorSequenceMap().get(tsb.getAuthorTypeSelected())-1L;             
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

            //set TaxonId
            tsb.getNewAuthor().setTaxonId(tsb.getCurrentTaxon().getTaxonKey());

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

                //Set connector
                if(tsb.getConnectorSelected() >= 0)
                {
                    tsb.getNewAuthor().setTaxonAuthorConnectorId(tsb.getConnectorSelected());
                    tsb.getNewAuthor().setTaxonAuthorConnector(tsb.getLabelConnector(tsb.getConnectorSelected()));

                }
                else
                {
                    //set default connector
                    tsb.getNewAuthor().setTaxonAuthorConnectorId(null);
                    tsb.getNewAuthor().setTaxonAuthorConnector(",");
                }
                tsb.getNewAuthor().setTaxonAuthorSequence(tsb.getTaxonAuthorSequence());
                
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
             tsb.addOptionToTaxonAuthors(tsb.getNewAuthor());
         }

         //Clean
         tsb.setTaxonAuthorSequence(-1L);
         tsb.setConnectorSelected(-1L);
         tsb.setVisiblePanelAuthorAction(false);         
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
           
         }
         
         if(tsb.getAuthorList().get(position).getTaxonAuthorConnectorId() == null && tsb.getAuthorList().size() > 1)
         {
             tsb.getAuthorList().get(position).setTaxonAuthorConnector("&");
             if(position > 0 && tsb.getAuthorList().get(position-1).getTaxonAuthorConnectorId() == null)
             {
                 tsb.getAuthorList().get(position-1).setTaxonAuthorConnector(",");
             }
         }
         if(tsb.getAuthorList().get(lastPosition).getTaxonAuthorConnectorId() == null)
         {
             tsb.getAuthorList().get(lastPosition).setTaxonAuthorConnector(",");
         }
     }


     public String btn_newSynonym_action()
     {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         SynonymAutoCompleteSessionBean sacsb = this.getSynonymAutoCompleteSessionBean();
         tsb.setNewSynonym(new SynonymDTO());
         tsb.setVisiblePanelSynonymAction(true);
         tsb.setNewSynonymAction(true);

         //btnCancelSynonym_action();

         return null;
     }


      public String btn_editSynonym_action()
     {
         /*TaxonSessionBean tsb = this.getTaxonSessionBean();
         
         tsb.setVisiblePanelSynonymAction(true);
         return null;*/


        TaxonSessionBean tsb = this.getTaxonSessionBean();
        SynonymAutoCompleteSessionBean sacsb = this.getSynonymAutoCompleteSessionBean();
        tsb.setCountSynonymSelected(0);

        //return author selected to taxonAuthors
        btnCancelSynonym_action();

        tsb.setNewSynonymAction(false);

        tsb.setPositionSynonymSelected(tsb.getPosSynonymSelected());
        System.out.println("PositionSynonymSelected = "+tsb.getPositionSynonymSelected());
        if(tsb.getPositionSynonymSelected() >=0)
        {
            tsb.setNewSynonym(tsb.getSynonymList().get(tsb.getPositionSynonymSelected()));
            System.out.println("CountSynonymSelected() = "+tsb.getCountSynonymSelected());
            if(tsb.getCountSynonymSelected() == 1)
            {
                //tsb.setTaxon(tsb.getNewSynonym().getCountryName());

                //tsb.setCountryDescription(tsb.getNewCountry().getDescription());
                String text =  tsb.getNewSynonym().getDefaultName();
                Long[] tmpArray = {tsb.getNewSynonym().getTaxonKey(), 0L};
                sacsb.getOptionHash().put(text, tmpArray);
                System.out.println("text = "+sacsb.getText());
                sacsb.setText(text);
                
                tsb.setVisiblePanelSynonymAction(true);

            }
            else
            {
                //************************
                //CAMBIAR MENSAJE DE ERROR
                //************************

                 MessageBean.setErrorMessageFromBundle("error_edit_one_author",this.getMyLocale());

            }
         }
        else
        {
            //************************
            //CAMBIAR MENSAJE DE ERROR
            //************************
            MessageBean.setErrorMessageFromBundle("error_edit_author_not_selected",this.getMyLocale());


        }
        return null;



     }


     public String btn_deleteSynonym_action()
     {
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        SynonymDTO synonymSelected = tsb.getSynonymSelected();
        //System.out.println("** TaxonCountrySelected = "+taxonCountrySelected.getCountryName());

        if(tsb.getCountSynonymSelected() >= 0)
        {
            if(tsb.getCountSynonymSelected() == 1)
            {
                tsb.removeSynonymSelected();
                //tsb.addOptionToTaxonAuthors(taxonAuthorSelected);
                //tsb.getCountries().add(new Option(taxonCountrySelected.getCountryId(),taxonCountrySelected.getCountryName()));

                tsb.setCountSynonymSelected(0);
            }
            else
            {
                //************************
                //CAMBIAR MENSAJE DE ERROR
                //************************

                 MessageBean.setErrorMessageFromBundle("error_delete_one_author",this.getMyLocale());

            }
        }
        else
        {
            //************************
            //CAMBIAR MENSAJE DE ERROR
            //************************

             MessageBean.setErrorMessageFromBundle("error_delete_author_not_selected",this.getMyLocale());

        }
        return null;

//         return null;
     }

    public String btnAceptSynonym_action()
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();
        SynonymAutoCompleteSessionBean sacs = this.getSynonymAutoCompleteSessionBean();
      
      
        if(sacs.getText().length() >0)
        {
            tsb.getNewSynonym().setTaxonKey(sacs.getIdSelected());
            System.out.println("TaxonKey = "+sacs.getIdSelected());
            //set name
            tsb.getNewSynonym().setDefaultName(sacs.getText());
            System.out.println("DefautName = "+sacs.getText());
           //NEW MODE
            if(tsb.isNewSynonymAction())
            {
                tsb.getSynonymList().add(tsb.getNewSynonym());
            }
            else
            {
                tsb.getSynonymList().set(tsb.getPosSynonymSelected(), tsb.getNewSynonym());
                //tsb.getSynonymList().remove(tsb.getPosSynonymSelected());
               // tsb.getSynonymList().add(tsb.getPosSynonymSelected(), tsb.getNewSynonym());
            }
        }
        else
         {
            //CAMBIAR EL MENSAJE DE ERROR
             MessageBean.setErrorMessageFromBundle("error_taxon_indicator",this.getMyLocale());
         }

         //Clean
        tsb.setNewSynonym(null);
        sacs.setText("");
        sacs.setOptionHash(new HashMap<String, Long[]>());
        tsb.setVisiblePanelSynonymAction(false);


        //System.out.println("SynonymList size ="+tsb.getSynonymList().size());
        //System.out.println("SynonymElement = "+tsb.getSynonymList().get(0).getDefaultName());
        //System.out.println("SynonymList size = "+tsb.getSynonymListSize());

        
        return null;
    }

    public String btnCancelSynonym_action()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();
        
        SynonymAutoCompleteSessionBean sacs = this.getSynonymAutoCompleteSessionBean();
        sacs.setOptionHash(new HashMap<String, Long[]>());
        sacs.setText("");

        tsb.setVisiblePanelSynonymAction(false);
        return null;
    }

    /**
     * @return the dataTableSynonyms
     */
    public HtmlDataTable getDataTableSynonyms() {
        return dataTableSynonyms;
    }

    /**
     * @param dataTableSynonyms the dataTableSynonyms to set
     */
    public void setDataTableSynonyms(HtmlDataTable dataTableSynonyms) {
        this.dataTableSynonyms = dataTableSynonyms;
    }

    /**
     * @return the dataTableCountries
     */
    public HtmlDataTable getDataTableCountries() {
        return dataTableCountries;
    }

    /**
     * @param dataTableCountries the dataTableCountries to set
     */
    public void setDataTableCountries(HtmlDataTable dataTableCountries) {
        this.dataTableCountries = dataTableCountries;
    }

    /**
     * @return the countries
     */
    public Option[] getCountries() {
        return countries;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(Option[] countries) {
        this.countries = countries;
    }



    public String btnAddCountry_action()
    {

        System.out.println("Entro a btnAddCountry");
        TaxonSessionBean tsb = this.getTaxonSessionBean();
      

        btnCancelCountry_action();


        tsb.setNewCountryAction(true);

        if(tsb.getCountrySelected() != null)
        {
            System.out.println("CountrySelected != null");
            //Create new TaxonAuthorDTO
            tsb.setNewCountry(new TaxonCountryDTO());
            //System.out.println(tsb.getAuthorSelected());
            Option selected;
            /*selected*/
            selected = tsb.removeOption(tsb.getCountrySelected(), tsb.getCountries());

            //Set<Option> tmp = tsb.getCountries();

            tsb.setTaxonCountryName(selected.getLabel());


            tsb.getNewCountry().setCountryName(selected.getLabel());
            tsb.getNewCountry().setCountryId((Long)selected.getValue());




            tsb.setVisiblePanelCountryAction(true);
        }
        else
        {
            //************************
            //CAMBIAR MENSAJE DE ERROR
            //************************
             MessageBean.setErrorMessageFromBundle("error_author_not_selected",this.getMyLocale());

        }

        return null;
    }


     public String btnEditCountry_action()
    {
        TaxonSessionBean tsb = this.getTaxonSessionBean();

        tsb.setCountTaxonCountrySelected(0);

        //return author selected to taxonAuthors
        btnCancelCountry_action();

        tsb.setNewCountryAction(false);

        tsb.setPositionTaxonCountrySelected(tsb.getPosTaxonCountrySelected());
        if(tsb.getPositionTaxonCountrySelected() >=0)
        {
            tsb.setNewCountry(tsb.getCountryList().get(tsb.getPositionTaxonCountrySelected()));
            //set default value to connectorId
            
            if(tsb.getCountTaxonCountrySelected() == 1)
            {
                tsb.setTaxonCountryName(tsb.getNewCountry().getCountryName());

                tsb.setCountryDescription(tsb.getNewCountry().getDescription());


                tsb.setVisiblePanelCountryAction(true);

            }
            else
            {
                //************************
                //CAMBIAR MENSAJE DE ERROR
                //************************

                 MessageBean.setErrorMessageFromBundle("error_edit_one_author",this.getMyLocale());

            }
         }
        else
        {
            //************************
            //CAMBIAR MENSAJE DE ERROR
            //************************
            MessageBean.setErrorMessageFromBundle("error_edit_author_not_selected",this.getMyLocale());


        }
        return null;
    }

    public String btnRemoveCountry_action()
    {

        TaxonSessionBean tsb = this.getTaxonSessionBean();

        TaxonCountryDTO taxonCountrySelected = tsb.getTaxonCountrySelected();
        System.out.println("** TaxonCountrySelected = "+taxonCountrySelected.getCountryName());

        if(tsb.getCountTaxonCountrySelected() >= 0)
        {
            if(tsb.getCountTaxonCountrySelected() == 1)
            {
                tsb.removeTaxonCountrySelected();
                //tsb.addOptionToTaxonAuthors(taxonAuthorSelected);
                tsb.getCountries().add(new Option(taxonCountrySelected.getCountryId(),taxonCountrySelected.getCountryName()));

                tsb.setCountTaxonCountrySelected(0);
            }
            else
            {
                //************************
                //CAMBIAR MENSAJE DE ERROR
                //************************

                 MessageBean.setErrorMessageFromBundle("error_delete_one_author",this.getMyLocale());

            }
        }
        else
        {
            //************************
            //CAMBIAR MENSAJE DE ERROR
            //************************

             MessageBean.setErrorMessageFromBundle("error_delete_author_not_selected",this.getMyLocale());

        }
        return null;
    }


    public String btnAceptCountry_action()
    {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         tsb.getNewCountry().setDescription(tsb.getCountryDescription());
         //NEW MODE
         if(tsb.isNewCountryAction())
         {


                tsb.getCountryList().add(tsb.getNewCountry());

         }

         //Clean
        tsb.setNewCountry(null);
        tsb.setCountryDescription(null);

        tsb.setVisiblePanelCountryAction(false);

        return null;
    }

     public String btnCancelCountry_action()
    {
         TaxonSessionBean tsb = this.getTaxonSessionBean();
         if(tsb.isNewCountryAction() && tsb.getNewCountry() != null)
         {
            tsb.getCountries().add(new Option(tsb.getNewCountry().getCountryId(), tsb.getNewCountry().getCountryName()));
         }

         //Clean

         tsb.setVisiblePanelCountryAction(false);
         tsb.setNewCountry(null);
         tsb.setCountryDescription(null);

        return null;
    }

    /**
     * @return the externalData
     */
    public HtmlPanelGrid getExternalData() {
        return externalData;
    }

    /**
     * @param externalData the externalData to set
     */
    public void setExternalData(HtmlPanelGrid externalData) {
        this.externalData = externalData;
    }

    /**
     * @return the urlGBIF
     */
    public String getUrlGBIF() {
        return urlGBIF;
    }

    /**
     * @param urlGBIF the urlGBIF to set
     */
    public void setUrlGBIF(String urlGBIF) {
        this.urlGBIF = urlGBIF;
    }

    /**
     * @return the urlEOL
     */
    public String getUrlEOL() {
        return urlEOL;
    }

    /**
     * @param urlEOL the urlEOL to set
     */
    public void setUrlEOL(String urlEOL) {
        this.urlEOL = urlEOL;
    }

    /**
     * @return the urlWikispecies
     */
    public String getUrlWikispecies() {
        return urlWikispecies;
    }

    /**
     * @param urlWikispecies the urlWikispecies to set
     */
    public void setUrlWikispecies(String urlWikispecies) {
        this.urlWikispecies = urlWikispecies;
    }




}

