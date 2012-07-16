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

package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListInstitution.java
 * @version Created on 28/09/2009, 10:08:12 AM
 * @author esmata
 */

public class ListInstitution extends AbstractPageBean {
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

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTable = new HtmlDataTable();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListInstitution() {
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
            log("ListInstitution Initialization Failure", e);
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
        InstitutionSessionBean isb = this.getInstitutionSessionBean();
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (isb.getPagination()==null) {
            isb.initDataProvider();
        }
        //Actualizar los datos del paginador si no es nula ni es ninguna búsqueda (osea, listado base)
        //Actualizar los datos del paginador
        else
            isb.getPagination().refreshList();
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
     * Metodo ejecutado por el boton de editar una institucion
     * @return
     */
    public String btnInstitutionEdit(){
        int n = this.getDataTable().getRowCount();
        ArrayList<InstitutionDTO> selectedInstitutions = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTable().setRowIndex(i);
            InstitutionDTO aux = (InstitutionDTO) this.getDataTable().getRowData();
            if (aux.isSelected()) {
                selectedInstitutions.add(aux);
            }
        }
        if(selectedInstitutions == null || selectedInstitutions.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedInstitutions.size() == 1){ //En caso de que solo se seleccione un elemento
            this.getInstitutionSessionBean().setCurrentInstitution
                    (selectedInstitutions.get(0));
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton de eliminar una institucion
     * @return
     */
    public String btnInstitutionDelete(){
        int n = this.getDataTable().getRowCount();
        ArrayList<InstitutionDTO> selectedInstitutions = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTable().setRowIndex(i);
            InstitutionDTO aux = (InstitutionDTO) this.getDataTable().getRowData();
            if (aux.isSelected()) {
                selectedInstitutions.add(aux);
            }
        }
        if(selectedInstitutions == null || selectedInstitutions.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedInstitutions.size() == 1){ //En caso de que solo se seleccione un elemento
            //Obtener la institucion
            InstitutionDTO aux = selectedInstitutions.get(0);

            //Verificar si tiene especimenes asociados
            if(!isDeletable(aux.getInstitutionId())){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                return null;
            }
            //Mandar a borrar la institucion
            this.getInstitutionSessionBean().deleteInstitution(aux.getInstitutionId());

            //Refrescar la lista de instituciones
            this.getInstitutionSessionBean().getPagination().refreshList();
            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Para conocer si la institucion se puede eliminar
     * @param institutionId
     * @return
     */
    private boolean isDeletable(Long institutionId){
        int asociatedSpecimens = this.getInstitutionSessionBean().findSpecimensByInstitutionId(institutionId);
        if(asociatedSpecimens==0){
            return true;
        }
        else
            return false;
    }

    /**
     * Metodo ejecutado por el boton de crear instituciones
     * @return
     */
    public String btnInstitutionNew(){
        //Limpiar el current dto
        this.getInstitutionSessionBean().setCurrentInstitution(new InstitutionDTO());
        return "new";
    }

     protected InstitutionSessionBean getInstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
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
        quantityTotal = this.getInstitutionSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the dataTable
     */
    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }    
}

