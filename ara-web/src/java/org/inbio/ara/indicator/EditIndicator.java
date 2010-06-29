/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.indicator;

import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditIndicator.java
 * @version Created on 15/04/2010, 12:55:20 PM
 * @author gsulca
 */

public class EditIndicator extends AbstractPageBean {
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
    //Contiene la localidad para el idioma
    private Locale myLocale;
    //contiene el String con las cantidades mostrado para la paginación
    private String quantityTotal = new String();
    //
    private String selected = new String();

    private RadioButtonGroup radioButtonGroup = new RadioButtonGroup();
    private SingleSelectOptionsList radioData = new SingleSelectOptionsList();


    private Long selectedRadioButton = 1L;


    private HtmlPanelGrid gridIndicator = new HtmlPanelGrid();
    private HtmlPanelGrid indicator = new HtmlPanelGrid();
    private TextField txIndicatorName = new TextField();
    private TextArea txaIndicatorDescription = new TextArea();
    private HtmlInputHidden hiddenNodeId = new HtmlInputHidden();
    private HtmlInputHidden hiddenPathNode = new HtmlInputHidden();
    private HtmlInputHidden hiddenAncestorNodeId = new HtmlInputHidden();
    private DefaultSelectItemsArray radioButtonList1DefaultItems = new DefaultSelectItemsArray();


    private HtmlPanelGrid gridDublinCore = new HtmlPanelGrid();
    private HtmlInputText txSearch = new HtmlInputText();

    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();

    private TextField txTitle = new TextField();

    private TextField txYear = new TextField();

    private TextField txIdentifier = new TextField();

    private TextField txCreator = new TextField();

    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton();
    private HtmlDataTable dataTableDublinCore = new HtmlDataTable();
    
    

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditIndicator() {
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
            log("EditIndicator Initialization Failure", e);
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

        System.out.println("===================== PRERENDER =====================");
        System.out.println("QuantityTotal = "+ quantityTotal);
        System.out.println("nodeId = "+this.getindicator$IndicatorSessionBean().getNodeId());
        System.out.println("hiddenNodeId = "+hiddenNodeId.getValue());

        
        if(hiddenNodeId.getValue() == null)
        {
            System.out.println("inicializar los hidden porque estan nulos");
            hiddenNodeId.setValue(this. getindicator$IndicatorSessionBean().getNodeId());
            hiddenPathNode.setValue(this.getindicator$IndicatorSessionBean().getPathNode());
            hiddenAncestorNodeId.setValue(this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().getIndicatorAncestorId());
        }
        

        
       if (this.getindicator$IndicatorSessionBean().getPagination()!=null)
        {
            System.out.println("--> entra al if donde el paginador no es nulo");
           
            if(!(this.getindicator$IndicatorSessionBean().getNodeId()).equals(hiddenNodeId.getValue()))
            {
                System.out.println("se debe recalcular las referencias por el cambio de nodo y actualizar los valores del nodeId en el session");
                this.getindicator$IndicatorSessionBean().setNodeId(hiddenNodeId.getValue().toString());
                this.getindicator$IndicatorSessionBean().setEditMode(true);
                this.getindicator$IndicatorSessionBean().setSelectedResourcesId(new HashMap<String,ReferenceDTO>());
                this.getindicator$IndicatorSessionBean().initEditDataProvider(new Long(hiddenNodeId.getValue().toString()));
                

            }
            else
            {

                getSelectedResourceIds(this.getDataTableDublinCore(), this.getindicator$IndicatorSessionBean().getSelectedResourcesId());
                Collection<ReferenceDTO> references = this.getindicator$IndicatorSessionBean().getSelectedResourcesId().values();
                for(ReferenceDTO reference: references)
                {
                    selected += reference.getTitle() + "; ";
                }
            }
        
        }
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(this.getindicator$IndicatorSessionBean().isAdvancedSearch()){
            System.out.println("--> entra al if de busqueda avanzada");
        //    System.out.println("Entro a la búsqueda avanzada");
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (this.getindicator$IndicatorSessionBean().getPagination()==null) {
            System.out.println("--> entra al if donde el paginador es nulo");
            this.getindicator$IndicatorSessionBean().setEditMode(true);
            this.getindicator$IndicatorSessionBean().setSelectedResourcesId(new HashMap<String,ReferenceDTO>());
            this.getindicator$IndicatorSessionBean().initEditDataProvider(new Long(hiddenNodeId.getValue().toString()));           
        
        }
               

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


    public String btnSimpleSearch_action() {
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
        {
            userInput = this.getTxSearch().getValue().toString();
        }
        userInput = userInput.trim();

        if(!this.getindicator$IndicatorSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getindicator$IndicatorSessionBean().getSelectedResourcesId());
        }

        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getindicator$IndicatorSessionBean().setQueryModeSimple(false);
            this.getindicator$IndicatorSessionBean().setQueryMode(false);
            
            //Actualiza el data provider del paginador con los datos por default
            this.getindicator$IndicatorSessionBean().getPagination().setTotalResults
                    (getindicator$IndicatorSessionBean().getDublinCoreFacade().countResourceByTypeId(ResourceTypeEnum.REFERENCE.getId()).intValue());
        }
        else{
            //Actualizar el valor del string para consulta simple del SessionBean
            this.getindicator$IndicatorSessionBean().setSimpleConsult(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getindicator$IndicatorSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getindicator$IndicatorSessionBean().setQueryMode(false);
            //Finalmente se inicializa el Total Results del data provider del paginador con la cantidad de resultados de la consulta
            this.getindicator$IndicatorSessionBean().getPagination().setTotalResults
                    (getindicator$IndicatorSessionBean().getDublinCoreFacade().countSimpleSearch(userInput).intValue());
        }
        //set the first result of the query
        this.getindicator$IndicatorSessionBean().getPagination().firstResults();

        return null;
    }

    public String btnAdvSearch_action() {

        if(!this.getindicator$IndicatorSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getindicator$IndicatorSessionBean().getSelectedResourcesId());
        }

        boolean advanced = this.getindicator$IndicatorSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            this.getindicator$IndicatorSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSearch().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getindicator$IndicatorSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSearch().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

            //Reestablecer los valores por defecto de los textfields
            //getgermplasm$SementalSessionBean().setQuerySementalDTO(new SementalDTO());
        }
        this.getindicator$IndicatorSessionBean().getPagination().refreshList();
        return null;
    }

    public String btnProceedSearch_action() {

        if(!this.getindicator$IndicatorSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getindicator$IndicatorSessionBean().getSelectedResourcesId());
        }
      
        /*
         * ARMAR EL DTO PARA REALIZAR LA BUSQUEDA
         */

        this.getindicator$IndicatorSessionBean().setQueryDublinCoreDTO(new DublinCoreDTO());
        //System.out.println("DublinCoreDTO del SessionBean = "+this.getindicator$IndicatorSessionBean().getQueryDublinCoreDTO().toString());

        if(this.getTxTitle().getText() != null && this.getTxTitle().getText() != "")
        {
            System.out.println("TxTitle = "+(String)this.getTxTitle().getText());
            this.getindicator$IndicatorSessionBean().getQueryDublinCoreDTO().addElement("title",
                                                                                    this.getTxTitle().getText().toString(), "Español");
        }

        if(this.getTxCreator().getText() != null && this.getTxCreator().getText() != "")
        {

            System.out.println("TxCreator = "+(String)this.getTxCreator().getText());
            this.getindicator$IndicatorSessionBean().getQueryDublinCoreDTO().addElement("creator",
                                                                                    this.getTxCreator().getText().toString(), null);
        }

        if(this.getTxIdentifier().getText() != null && this.getTxIdentifier().getText() != "")
        {
            System.out.println("TxIdentifier = "+(String)this.getTxIdentifier().getText());
            this.getindicator$IndicatorSessionBean().getQueryDublinCoreDTO().addElement("identifier",
                                                                                    this.getTxIdentifier().getText().toString(), null);
        }


       if(this.getTxYear().getText() != null && this.getTxYear().getText() != "")
       {
           System.out.println("TxDate = "+(String)this.getTxYear().getText());
            this.getindicator$IndicatorSessionBean().getQueryDublinCoreDTO().addElement("date",
                                                                                    this.getTxYear().getText().toString(), null);
       }

         //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getindicator$IndicatorSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getindicator$IndicatorSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getindicator$IndicatorSessionBean().getPagination().setTotalResults(
                this.getindicator$IndicatorSessionBean().
                getDublinCoreFacade().
                countDublinCoreAdvancedSearch(
                getindicator$IndicatorSessionBean().
                getQueryDublinCoreDTO()).intValue());

        this.getindicator$IndicatorSessionBean().getPagination().firstResults();
        this.getindicator$IndicatorSessionBean().getPagination().refreshList();

        this.getTxSearch().setValue("");

        return null;


    }

    
     /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }


    protected IndicatorSessionBean getindicator$IndicatorSessionBean() {
        return (IndicatorSessionBean) getBean("indicator$IndicatorSessionBean");
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
     * @return the radioButtonGroup
     */
    public RadioButtonGroup getRadioButtonGroup() {
        return radioButtonGroup;
    }

    /**
     * @param radioButtonGroup the radioButtonGroup to set
     */
    public void setRadioButtonGroup(RadioButtonGroup radioButtonGroup) {
        this.radioButtonGroup = radioButtonGroup;
    }

    public String btnSaveIndicator_action() {
       

        try{
            Long ancestorId = new Long(this.hiddenAncestorNodeId.getValue().toString());
            this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().setUserName(getAraSessionBean().getGlobalUserName());            
            this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().setIndicatorAncestorId(ancestorId);
            this.getindicator$IndicatorSessionBean().updateIndicator();
            this.getindicator$IndicatorSessionBean().setNodeId(this.hiddenNodeId.getValue().toString());
            this.getindicator$IndicatorSessionBean().setPathNode(this.hiddenPathNode.getValue().toString());
            //System.out.println("****************** -nodeId (Edit) = "+this.getindicator$IndicatorSessionBean().getNodeId());
            //System.out.println("****************** -pathNodeId (Edit) = "+this.getindicator$IndicatorSessionBean().getPathNode());
            System.out.println("****************** -applyToParts (Edit) = "+this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().getAppliesToParts());
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }
                
        return "back";
        }



    /**
     * @return the radioData
     */
    public SingleSelectOptionsList getRadioData() {
        return radioData;
    }

    /**
     * @param radioData the radioData to set
     */
    public void setRadioData(SingleSelectOptionsList radioData) {
        this.radioData = radioData;
    }




    public HtmlPanelGrid getGridIndicator() {
        return gridIndicator;
    }

    public void setGridIndicator(HtmlPanelGrid hpg) {
        this.gridIndicator = hpg;
    }




    public HtmlPanelGrid getIndicator() {
        return indicator;
    }

    public void setIndicator(HtmlPanelGrid hpg) {
        this.indicator = hpg;
    }




    public TextField getTxIndicatorName() {
        return txIndicatorName;
    }

    public void setTxIndicatorName(TextField tf) {
        this.txIndicatorName = tf;
    }




    public TextArea getTxaIndicatorDescription() {
        return txaIndicatorDescription;
    }

    public void setTxaIndicatorDescription(TextArea ta) {
        this.txaIndicatorDescription = ta;
    }



    public HtmlInputHidden getHiddenNodeId() {
        return hiddenNodeId;
    }

    public void setHiddenNodeId(HtmlInputHidden hdn) {
        this.hiddenNodeId = hdn;
    }




    public HtmlInputHidden getHiddenPathNode() {
        return hiddenPathNode;
    }

    public void setHiddenPathNode(HtmlInputHidden hdn) {
        this.hiddenPathNode = hdn;
    }



    public HtmlInputHidden gethiddenAncestorNodeId() {
        return hiddenAncestorNodeId;
    }

    public void sethiddenAncestorNodeId(HtmlInputHidden hdn) {
        this.hiddenAncestorNodeId = hdn;
    }


    public DefaultSelectItemsArray getRadioButtonList1DefaultItems() {
        return radioButtonList1DefaultItems;
    }

    public void setRadioButtonList1DefaultItems(DefaultSelectItemsArray dsia) {
        this.radioButtonList1DefaultItems = dsia;
    }

    /**
     * @return the selectedRadioButton
     */
    public Long getSelectedRadioButton() {
        return selectedRadioButton;
    }

    /**
     * @param selectedRadioButton the selectedRadioButton to set
     */
    public void setSelectedRadioButton(Long selectedRadioButton) {
        this.selectedRadioButton = selectedRadioButton;
    }

     /**
     * @return the gridDublinCore
     */
    public HtmlPanelGrid getGridDublinCore() {
        return gridDublinCore;
    }

    /**
     * @param hpg the gridDublinCore to set
     */
    public void setGridDublinCore(HtmlPanelGrid hpg) {
        this.gridDublinCore = hpg;
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal= this.getindicator$IndicatorSessionBean().getQuantityTotal();
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
     * @return the dataTablePassport
     */
    public HtmlDataTable getDataTableDublinCore() {
        return dataTableDublinCore;
    }

    /**
     * @param dataTablePassport the dataTablePassport to set
     */
    public void setDataTableDublinCore(HtmlDataTable dataTableDublinCore) {
        this.dataTableDublinCore = dataTableDublinCore;
    }


    
}

