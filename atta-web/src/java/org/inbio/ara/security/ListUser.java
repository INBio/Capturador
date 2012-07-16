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

package org.inbio.ara.security;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.security.SystemUserDTO;
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
 * @version ListUser.java
 * @version Created on 23/09/2009, 04:03:15 PM
 * @author esmata
 */

public class ListUser extends AbstractPageBean {
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
    private Locale myLocale;

    //Bindings de componentes graficos
    private HtmlDataTable dataTableUser = new HtmlDataTable();
    private HtmlInputHidden deleteConfirmationText = new HtmlInputHidden();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListUser() {
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
            log("ListUser Initialization Failure", e);
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
        //Setting the confirmation text for deleting option
        this.deleteConfirmationText.setValue(BundleHelper.getDefaultBundleValue
                    ("delete_confirmation", this.getMyLocale()));

        SystemUserSessionBean susb = this.getUserSessionBean();
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (susb.getPagination()==null) {
            susb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            susb.getPagination().refreshList();

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

    protected SystemUserSessionBean getUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getUserSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * Metodo ejecutado por los botones de editar usuarios
     * @return
     */
    public String btnUserEdit(){
        int n = this.getDataTableUser().getRowCount();
        ArrayList<SystemUserDTO> selectedUsers = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableUser().setRowIndex(i);
            SystemUserDTO aux = (SystemUserDTO) this.getDataTableUser().getRowData();
            if (aux.isSelected()) {
                selectedUsers.add(aux);
            }
        }
        if(selectedUsers == null || selectedUsers.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedUsers.size() == 1){ //En caso de que solo se seleccione un elemento

            //Setear el currentUser con los datos del usuario seleccionado
            SystemUserDTO selected = selectedUsers.get(0);
            this.getUserSessionBean().setCurrentUser(selected);
            //Setear los addremove components
            this.getUserSessionBean().setArNomenclaturalsEdit(new AddRemoveList());
            this.getUserSessionBean().setArTaxonsEdit(new AddRemoveList());
            /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
            seleccionados de los AddRemove*/
            this.getUserSessionBean().setFirstTime(true);
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton de crear usuario
     * @return
     */
    public String btnUserNew(){
        //Setear el currentUser
        this.getUserSessionBean().setCurrentUser(new SystemUserDTO());
        return "new";
    }
    
    /**
     * Metodo ejecutado por los botones de eliminar usuarios
     * @return
     */
    public String btnUserDelete(){
        int n = this.getDataTableUser().getRowCount();
        ArrayList<SystemUserDTO> selectedUsers = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableUser().setRowIndex(i);
            SystemUserDTO aux = (SystemUserDTO) this.getDataTableUser().getRowData();
            if (aux.isSelected()) {
                selectedUsers.add(aux);
            }
        }
        if(selectedUsers == null || selectedUsers.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedUsers.size() == 1){ //En caso de que solo se seleccione un elemento

            SystemUserDTO selected = selectedUsers.get(0);

            try{
                //Verify if user is administrator
                if(this.getUserSessionBean().isAdmin(selected.getUserId())){
                    MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                    return null;
                }

                //Mandar a eliminar las entradas en user_taxon
                this.getUserSessionBean().deleteUserTaxonsByUser(selected.getUserId());
                //Mandar a eliminar las entradas de user_nomenclatural_group
                this.getUserSessionBean().deleteNomenclaturalGroupsByUser(selected.getUserId());
                //Mandar a eliminar la entidad correspondiente al dto
                this.getUserSessionBean().deleteSystemUser(selected);
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                System.out.print("mata"+e);
                return null;
            }
            
            //Refresccar la lista
            this.getUserSessionBean().getPagination().refreshList();

            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_user_success", this.getMyLocale());
            return null;

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }
    
    /**
     * Metodo ejecutado por los botones de cambiar contrasenas
     * @return
     */
    public String btnUserChangePassword(){
        int n = this.getDataTableUser().getRowCount();
        ArrayList<SystemUserDTO> selectedUsers = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableUser().setRowIndex(i);
            SystemUserDTO aux = (SystemUserDTO) this.getDataTableUser().getRowData();
            if (aux.isSelected()) {
                selectedUsers.add(aux);
            }
        }
        if(selectedUsers == null || selectedUsers.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedUsers.size() == 1){ //En caso de que solo se seleccione un elemento

            //Setear el currentUser con los datos del usuario seleccionado
            SystemUserDTO selected = selectedUsers.get(0);
            this.getUserSessionBean().setCurrentUser(selected);
            return "changePass";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }


    /**
     * @return the dataTableUser
     */
    public HtmlDataTable getDataTableUser() {
        return dataTableUser;
    }

    /**
     * @param dataTableUser the dataTableUser to set
     */
    public void setDataTableUser(HtmlDataTable dataTableUser) {
        this.dataTableUser = dataTableUser;
    }


    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the deleteConfirmationText
     */
    public HtmlInputHidden getDeleteConfirmationText() {
        return deleteConfirmationText;
    }

    /**
     * @param deleteConfirmationText the deleteConfirmationText to set
     */
    public void setDeleteConfirmationText(HtmlInputHidden deleteConfirmationText) {
        this.deleteConfirmationText = deleteConfirmationText;
    }

}

