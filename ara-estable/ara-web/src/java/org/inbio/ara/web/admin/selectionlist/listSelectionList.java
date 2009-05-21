/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.web.admin.selectionlist;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

import javax.faces.event.ValueChangeEvent;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.util.MessageBean;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version listSelectionList.java
 * @version Created on Feb 24, 2009, 9:49:20 AM
 * @author jgutierrez
 */

public class listSelectionList extends AbstractPageBean {


    private boolean showEditSelectionListValuePanel = false;

    private boolean showSelectionListValuePanel= true;

    private boolean showCollectionsPanel = false;

    private boolean requieredSelectedSelectionListValue = false;


    /**
     * Este método es el que se invoca cuando se da clic en el botón "nuevo valor"
     * que debería de estar en el header de la tabla en la GUI.
     *
     * Associated with the addValueToSelectionListButton
     *
     *
     * @return
     */
    public String addValueToSelectionList() {
       if (this.getSessionManager().canAdd() != null) {
            return this.getSessionManager().canAdd();
        } else {
           MessageBean.setErrorMessageFromBundle("cant_add_registries");
            //this.getMessageBean().addCantAddMessage();
            return null;
       }
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public listSelectionList() {
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
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
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
     * netbeans es tan estupido para hacer las cosas, que a cada rato se volaba
     * mis lineas del metodo init(). harto de eso las paso a este método entonces
     * en caso de que el maldito IDE se las vuelva a volar es solo volver a invocar
     * el metodo miInit()
     *
     */
    private void miInit(){
        //add the selectionlist to the drop down GUI element
        this.getSelectionListSessionBean().setAllSelectionListsOptions();


        //shows the table with the appropiate values of the selected 'Selection List'
        this.getSelectionListSessionBean().setAllSelectionListValues();

        if(this.getSelectionListSessionBean().getActualSelectionListValue().getId() != null){
            //muestra la tabla de selectionListValue's
            this.getSelectionListSessionBean().setCollectionsBySelectionListValue();
            this.requieredSelectedSelectionListValue = true;
            this.showCollectionsPanel= true;
            //this.collectionsPanel.setVisible(true);
        } else {
            //this.collectionsPanel.setVisible(false);
            this.showCollectionsPanel= false;
            this.requieredSelectedSelectionListValue = false;
        }

    }



    /**
     *  Esto se dispara cuando cambia el valor del DropDown con las listas de seleccion
     *
     * responde al action de: btn_updateSelectionListValues
     */
    public void selectionListChangeHandler() {
        String selectionListId = (String) this.getSelectionListSessionBean().getSelectionListDropDownData().getSelectedValue();
        this.getSelectionListSessionBean().setEntitiesById(new Long(selectionListId),null);

    }


    /**
     *  Actualiza los valores para el selectionListValuedId
     *
     * responde al action de: btn_showCollections
     */
    public void refreshValues() {
        String selectionListValueId = (String) this.getSelectionListSessionBean().getSelectionListValuesRadioButtonGroup().getSelectedValue();
        Long selectionListId = this.getSelectionListSessionBean().getActualSelectionList().getId();
        this.getSelectionListSessionBean().setEntitiesById(selectionListId, new Long(selectionListValueId));
    }

    /**
     * Este método manda a guardar los parametros del selectionListValue
     * como un nuevo value para la lista actual.
     *
     * responde al action de: btn_saveSelectionListValue
     */
    public void saveNewSelectionListValue () {
        this.getSelectionListSessionBean().saveSelectionListValue();
        this.showEditSelectionListValuePanel=false;
        MessageBean.setSuccessMessageFromBundle("save_selection_list_value_success");
    }

    /**
     * 
     */
    public void deleteSelectionListValue() {
        try {
            this.getSelectionListSessionBean().deleteSelectionListValue();
            MessageBean.setSuccessMessageFromBundle("delete_selection_list_value_success");
        } catch (IllegalArgumentException iae) {
            MessageBean.setErrorMessageFromBundle("delete_selection_list_value_error");
        }
    }

    /**
     * Este método cancela visualmente la opcion de agregar o editar
     * alguna valor a la lista de selccion.
     *
     * responde al action de: 
     */
    public void cancelNewSelectionListValue() {
        this.showEditSelectionListValuePanel=false;
    }


    /**
     *  Esto ocurre cuando se desea editar un valor de una lista de seleccion
     *
     * responde al action de: btn_editSelecionListValue
     */
    public void editActualSelectionListValue() {
         refreshValues();
         this.getSelectionListSessionBean().setNewSelectionListValue(false);
         this.showEditSelectionListValuePanel=true;
    }

    /**
     *  Esto ocurre cuando se desea crear un valor de una lista de seleccion
     *
     * responde al action de: btn_newSelectionListValue
     */
    public void newSelectionListValue() {

        String newName = MessageBean.getMessageFromBundle("new_selection_list_value_name");
        this.getSelectionListSessionBean().getActualSelectionListValue().setName(newName);
        //TODO: -> debería ser esto en vez del texto alambrado
        String newDescription = MessageBean.getMessageFromBundle("new_selection_list_value_description");
        this.getSelectionListSessionBean().getActualSelectionListValue().setDescription(newDescription);
        this.getSelectionListSessionBean().setNewSelectionListValue(true);

         this.showEditSelectionListValuePanel=true;
         this.showCollectionsPanel=false;
    }

    /**
     *
     * responde al boton:
     */
    public void saveAssociatedCollections(){
        this.getSelectionListSessionBean().saveAssociatedCollections();
        MessageBean.setSuccessMessageFromBundle("save_collection_selection_list_value_association_sucess");
    }




    /**
     * Prueba
     *
     * @param vce
     */
    public void radioButtonGroup1_processValueChange(ValueChangeEvent vce) {
        System.out.println("\n\n\t cambio el radio button");
    }

    /**
     * Prueba
     *
     * @param event
     */
    public void selectionListDropDown_processValueChange(ValueChangeEvent event) {
            System.out.println("\n\n\t cambio el drop down");
    }


    /*
    public String btn_edit_action() {
        if (this.getSessionManager().canModify()!=null) {
            RowKey rowKey = this.tableRowGroup1.getRowKey();
            this.getreferences$ReferenceSessionBean().setSelectedReference(rowKey);
            this.getreferences$ReferenceSessionBean().populateList();
            return this.getSessionManager().canModify();
        } else {
            this.getutil$MessageBean().addCantModifyMessage();
            return null;
        }

    }
     * /


    /*******************
     *  Beans o varas de esas
     *
     */

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListSessionBean getSelectionListSessionBean() {
        return (SelectionListSessionBean)getBean("admin$selectionlist$SelectionListSessionBean");
    }


    /*****
     *  gets & sets
     */


    /**
     *  Basura que pone netbeans
     */
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
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
        miInit();
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

    /**
     * @return the showSelectionListValuePanel
     */
    public boolean isShowSelectionListValuePanel() {
        return showSelectionListValuePanel;
    }

    /**
     * @param showSelectionListValuePanel the showSelectionListValuePanel to set
     */
    public void setShowSelectionListValuePanel(boolean showSelectionListValuePanel) {
        this.showSelectionListValuePanel = showSelectionListValuePanel;
    }

    /**
     * @return the showCollectionsPanel
     */
    public boolean isShowCollectionsPanel() {
        return showCollectionsPanel;
    }

    /**
     * @param showCollectionsPanel the showCollectionsPanel to set
     */
    public void setShowCollectionsPanel(boolean showCollectionsPanel) {
        this.showCollectionsPanel = showCollectionsPanel;
    }

    /**
     * @return the showEditSelectionListValuePanel
     */
    public boolean isShowEditSelectionListValuePanel() {
        return showEditSelectionListValuePanel;
    }

    /**
     * @param showEditSelectionListValuePanel the showEditSelectionListValuePanel to set
     */
    public void setShowEditSelectionListValuePanel(boolean showEditSelectionListValuePanel) {
        this.showEditSelectionListValuePanel = showEditSelectionListValuePanel;
    }

    /**
     * @return the requieredSelectedSelectionListValue
     */
    public boolean isRequieredSelectedSelectionListValue() {
        return requieredSelectedSelectionListValue;
    }

    /**
     * @param requieredSelectedSelectionListValue the requieredSelectedSelectionListValue to set
     */
    public void setRequieredSelectedSelectionListValue(boolean requieredSelectedSelectionListValue) {
        this.requieredSelectedSelectionListValue = requieredSelectedSelectionListValue;
    }
}

