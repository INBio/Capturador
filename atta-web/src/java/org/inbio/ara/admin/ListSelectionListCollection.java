/** Ara - capture species and specimen data
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

package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import java.util.Locale;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntityDTO;
import org.inbio.ara.util.BundleHelper;


/*
 *
 * @author jgutierrez
 */
public class ListSelectionListCollection extends AbstractPageBean {


    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    //
    private Locale myLocale;

    private HtmlPanelGrid actionTable = new HtmlPanelGrid();

    private HtmlPanelGrid selectionListValuePanel = new HtmlPanelGrid();


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
// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
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

        //System.out.println("en el prerender del listSelectionListCollection");
        //System.out.println("SelectedSelectionListEntityId: "+getAdminSelectionListSessionBean().getSelectedSelectionListEntityId());
        //System.out.println("SelectedSelectionListValueId: "+getAdminSelectionListSessionBean().getSelectedSelectionListValueId());

        this.getAdminSelectionListSessionBean().setSelectionListDropDownData(); //Cargar valores del DD de listas de seleccion
        if(getAdminSelectionListSessionBean().getSelectedSelectionListEntityId() == null){
             this.getAdminSelectionListSessionBean().setSelectedSelectionListValueId(null);
             this.selectionListValuePanel.setRendered(false);
        } else{
            this.selectionListValuePanel.setRendered(true);
            this.setSelectionListValuesDropDownData();
        }
            

        if(this.getAdminSelectionListSessionBean().getSelectedSelectionListValueId() != null){
            this.getAdminSelectionListSessionBean().setCollectionsBySelectionListValue();
            this.actionTable.setRendered(true);
        } else{
            this.actionTable.setRendered(false);
        }

    }


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }


   /**
     * Obtener los datos del drop down de las listas de seleccion
     */
    public void setSelectionListDropDownData(){
        
        List<SelectionListEntityDTO> sleDTOList = this.getAdminSelectionListSessionBean().getAdminFacade().getAllSelectionListEntities();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        String selectionListName;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SelectionListEntityDTO sleDTO : sleDTOList){
            selectionListName = BundleHelper.getDefaultBundleValue(sleDTO.getCodeName(), getMyLocale());
            option = new Option(sleDTO.getSelectionListEntityId(), selectionListName);
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getAdminSelectionListSessionBean().getSelectionListData().setOptions(allOptions.toArray(allOptionsInArray));
    }

   /**
     * Obtener los datos del drop down de las listas de seleccion
     */
    public void setSelectionListValuesDropDownData(){
        Long selectionListEntityId = getAdminSelectionListSessionBean().getSelectedSelectionListEntityId();
        List<SelectionListDTO> slDTOList = this.getAdminSelectionListSessionBean().getInventoryFacade().getAllSelectionListElements(selectionListEntityId);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SelectionListDTO slDTO : slDTOList){
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getAdminSelectionListSessionBean().getSelectionListValueData().setOptions(allOptions.toArray(allOptionsInArray));
    }
   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getAdminSelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
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
     * When the drop down change get a change in the selected value
     */
    public void onSelectionListChange(){
        //setSelectionListValuesDropDownData();
    }

        /**
     * When the drop down change get a change in the selected value
     */
    public void onSelectionListValueChange(){
        //if(this.getAdminSelectionListSessionBean().getSelectedSelectionListValueId() != null){
        //    this.getAdminSelectionListSessionBean().setCollectionsBySelectionListValue();
        //    this.getActionTable().setRendered(true);
        //}
        
    }

    /**
     *
     * @return
     */
    public String btn_save_action(){

        Object[] selectedIdsAsString = (Object[]) this.getAdminSelectionListSessionBean().getAssociatedCollections().getSelectedValue();
        List<Long> newAssociatedCollections = new ArrayList<Long>();

        for(Object o : selectedIdsAsString){
            newAssociatedCollections.add(Long.valueOf((String)o));
        }

        Long selectedSelectionListEntityId = this.getAdminSelectionListSessionBean().getSelectedSelectionListEntityId();
        Long delectedSelectionListValueId = this.getAdminSelectionListSessionBean().getSelectedSelectionListValueId();
        this.getAdminSelectionListSessionBean().getAdminFacade().saveOrUpdateCollectionsBySelectionListValue(selectedSelectionListEntityId, delectedSelectionListValueId, newAssociatedCollections);

        return null;
    }

    
    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }


    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }


    /**
     * @return the actionTable
     */
    public HtmlPanelGrid getActionTable() {
        return actionTable;
    }

    /**
     * @param actionTable the actionTable to set
     */
    public void setActionTable(HtmlPanelGrid actionTable) {
        this.actionTable = actionTable;
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    /**
     * @return the selectionListValuePanel
     */
    public HtmlPanelGrid getSelectionListValuePanel() {
        return selectionListValuePanel;
    }

    /**
     * @param selectionListValuePanel the selectionListValuePanel to set
     */
    public void setSelectionListValuePanel(HtmlPanelGrid selectionListValuePanel) {
        this.selectionListValuePanel = selectionListValuePanel;
    }
}
