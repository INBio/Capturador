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

package org.inbio.ara.web.admin.collection;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.PanelLayout;

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
 * @version AdminCollections.java
 * @version Created on Mar 16, 2009, 11:14:23 AM
 * @author jgutierrez
 */

public class adminCollections extends AbstractPageBean {


    private PanelLayout editCollectionPanel;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public adminCollections() {
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
            log("AdminCollections Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }



    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getMessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

   /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    private AdminCollectionSessionBean getAdminCollectionSessionBean() {
        return (AdminCollectionSessionBean)getBean("admin$collection$AdminCollectionSessionBean");
    }

    /**
     * netbeans es tan estupido para hacer las cosas, que a cada rato se volaba
     * mis lineas del metodo init(). harto de eso las paso a este método entonces
     * en caso de que el maldito IDE se las vuelva a volar es solo volver a invocar
     * el metodo miInit()
     *
     */
    private void miInit(){
        //shows the table with the collections
        this.getAdminCollectionSessionBean().setAllCollections();

    }

    /**
     *  Esto ocurre cuando se desea editar un valor de una lista de seleccion
     *
     * responde al action de: btn_editCollection
     */
    public void editActualCollection() {
         this.updateActualCollection();
         this.getAdminCollectionSessionBean().setNewCollection(false);
         this.editCollectionPanel.setVisible(true);
    }

    /**
     * usado por editActualCollection y deleteCollection
     *
     */
    private void updateActualCollection(){
        String actualCollectionId = (String) this.getAdminCollectionSessionBean().getCollectionsRadioButtonGroup().getSelectedValue();
         this.getAdminCollectionSessionBean().setActualCollectionById(Long.valueOf(actualCollectionId));
    }

    /**
     *  Esto ocurre cuando se desea crear una nuva coleccion
     *
     * responde al action de: btn_newCollection
     */
    public void newCollection() {

        String newName = this.getMessageBean().getMessageFromBundle("new_selection_list_value_name");
        this.getAdminCollectionSessionBean().getActualCollection().setName(newName);
        String newDescription = this.getMessageBean().getMessageFromBundle("new_selection_list_value_description");
        this.getAdminCollectionSessionBean().getActualCollection().setDescription(newDescription);
        this.getAdminCollectionSessionBean().setNewCollection(true);

         this.editCollectionPanel.setVisible(true);
    }

    /**
     * responde al boton btn_deleteCollection
     */
    public void deleteCollection() {
        this.updateActualCollection();
        try {
            this.getAdminCollectionSessionBean().deleteCollection();
            MessageBean.setSuccessMessageFromBundle("delete_collection_success");
        } catch (IllegalArgumentException iae) {
            MessageBean.setErrorMessageFromBundle("delete_collection_error");
        }
    }

    /**
     * Este método manda a guardar los parametros del selectionListValue
     * como un nuevo value para la lista actual.
     *
     * responde al action de: btn_saveCollection
     */
    public void saveCollection () {
        this.getAdminCollectionSessionBean().saveCollection();
        this.editCollectionPanel.setVisible(false);
        MessageBean.setSuccessMessageFromBundle("save_collection_success");
    }

    /**
     * Este método cancela visualmente la opcion de agregar o editar
     * collecciones.
     *
     * responde al action de: btn_cancelEditCollection
     */
    public void cancelEdtiCollection() {
        this.editCollectionPanel.setVisible(false);
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
     * @return the editCollectionPanel
     */
    public PanelLayout getEditCollectionPanel() {
        return editCollectionPanel;
    }

    /**
     * @param editCollectionPanel the editCollectionPanel to set
     */
    public void setEditCollectionPanel(PanelLayout editCollectionPanel) {
        this.editCollectionPanel = editCollectionPanel;
    }
}

