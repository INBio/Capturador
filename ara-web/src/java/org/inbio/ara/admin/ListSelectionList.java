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
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.util.MessageBean;


/*
 *
 * @author jgutierrez
 */
public class ListSelectionList extends AbstractPageBean {


    //Componentes graficos utilizados para las busquedas de especimenes
    private HtmlPanelGrid gridEditOrNew = new HtmlPanelGrid();

    private HtmlPanelGrid valuesTable = new HtmlPanelGrid();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();


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
        if(getAdminSelectionListSessionBean().getSelectedSelectionListEntityId() == null){
            //Cargar valores del DD de listas de seleccion
             this.getAdminSelectionListSessionBean().
                     setSelectionListDropDownData();
             valuesTable.setRendered(false);
        }
        else{
            getAdminSelectionListSessionBean().getPagination().refreshList();
            valuesTable.setRendered(true);
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getAdminSelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
    }

    /**
     * When the drop down change get a change in the selected value
     */
    public void onSelectionListChange(){
        if (this.getAdminSelectionListSessionBean().getSelectedSelectionListEntityId() != null) {
            this.getAdminSelectionListSessionBean().initDataProvider();
            this.valuesTable.setRendered(true);
        } else {
            this.valuesTable.setRendered(false);
        }
    }

    /**
     * @return
     */
    public String btn_cancel_action(){
        this.gridEditOrNew.setRendered(false);
        this.getAdminSelectionListSessionBean().
                setActualSelectionListElementDTO(new SelectionListDTO());
        return null;
    }

    /**
     *
     * @return
     */
    public String btn_new_action(){
        this.gridEditOrNew.setRendered(true);

        SelectionListDTO slDTO = new SelectionListDTO();
        slDTO.setSelectionListEntityId(this.getAdminSelectionListSessionBean().
                getSelectedSelectionListEntityId());
        this.getAdminSelectionListSessionBean().
                setActualSelectionListElementDTO(slDTO);

        return null;
    }

    /**
     * Solo puede editarse una list de selección por tiro!
     *
     * Action del boton de editar
     * @return
     */
    public String btn_edit_action() {

        if(getValidatedSelectionListElementDTO() != null){
            this.getAdminSelectionListSessionBean().
                    setActualSelectionListElementDTO
                    (getValidatedSelectionListElementDTO());
            this.gridEditOrNew.setRendered(true);
        }
        return null;
    }

    /**
     * @return
     */
    public String btn_save_action(){
        int val = this.getAdminSelectionListSessionBean().getAdminFacade().
                saveOrUpdateSelectionListElement
                (this.getAdminSelectionListSessionBean().
                getActualSelectionListElementDTO());
        this.gridEditOrNew.setRendered(false);

        if(val==0){ //if create
            this.getAdminSelectionListSessionBean().getPagination().addItem();
        }
        this.getAdminSelectionListSessionBean().getPagination().refreshList();

        MessageBean.setSuccessMessageFromBundle
                ("save_selection_list_value_success",
                this.getAdminSelectionListSessionBean().getMyLocale());
        return null;
    }

    /**
     * @return
     */
    public String btn_delete_action(){
        if(getValidatedSelectionListElementDTO() != null){
            this.getAdminSelectionListSessionBean().
                    setActualSelectionListElementDTO
                    (getValidatedSelectionListElementDTO());
            try {
                this.getAdminSelectionListSessionBean().
                        getAdminFacade().deleteSelectionListElement
                        (this.getAdminSelectionListSessionBean().
                        getActualSelectionListElementDTO());
                MessageBean.setSuccessMessageFromBundle
                        ("delete_selection_list_value_sucess",
                        this.getAdminSelectionListSessionBean().getMyLocale());
            } catch(Exception e){
                MessageBean.setErrorMessageFromBundle
                        ("delete_selection_list_value_error",
                        this.getAdminSelectionListSessionBean().getMyLocale());
            }
            this.getAdminSelectionListSessionBean().getPagination().deleteItem();
            this.getAdminSelectionListSessionBean().getPagination().refreshList();
            this.gridEditOrNew.setRendered(false);
        }
        return null;
    }

    /**
     *
     * @return
     */
    public String btn_associate_collection_action(){
        if(getValidatedSelectionListElementDTO() != null){
            this.getAdminSelectionListSessionBean().
                    setActualSelectionListElementDTO
                    (getValidatedSelectionListElementDTO());
            Long selectedSelectionListValueId =
                    this.getAdminSelectionListSessionBean().
                    getActualSelectionListElementDTO().getValueId();
            this.getAdminSelectionListSessionBean().
                    setSelectedSelectionListValueId(selectedSelectionListValueId);
            return "listSelectionListCollection";
        } else{
        return null;
        }
    }

    /**
     * Verifica que solo puede seleccionarse una lista de seleccion o tira un error
     *
     * @return
     */
    private SelectionListDTO getValidatedSelectionListElementDTO(){

        List<SelectionListDTO> selectedSeletionListValues =
                getAdminSelectionListSessionBean().getSelectedValues();

        //En caso de que no se seleccione ningun elemento
        if(selectedSeletionListValues == null ||
                selectedSeletionListValues.size() == 0) {
            MessageBean.setErrorMessageFromBundle
                    ("not_selected",
                    this.getAdminSelectionListSessionBean().getMyLocale());
        }
        //En caso de que solo se seleccione un elemento
        else if(selectedSeletionListValues.size() == 1) {
            return selectedSeletionListValues.get(0);
        }
        else { //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle
                    ("not_yet",
                    this.getAdminSelectionListSessionBean().getMyLocale());
        }

        return null;
    }

    /**
     * @return the gridEditOrNew
     */
    public HtmlPanelGrid getGridEditOrNew() {
        return gridEditOrNew;
    }

    /**
     * @param gridEditOrNew the gridEditOrNew to set
     */
    public void setGridEditOrNew(HtmlPanelGrid gridEditOrNew) {
        this.gridEditOrNew = gridEditOrNew;
    }



    /**
     * @return the valuesTable
     */
    public HtmlPanelGrid getValuesTable() {
        return valuesTable;
    }

    /**
     * @param valuesTable the valuesTable to set
     */
    public void setValuesTable(HtmlPanelGrid valuesTable) {
        this.valuesTable = valuesTable;
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        this.quantityTotal = this.getAdminSelectionListSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }
}
