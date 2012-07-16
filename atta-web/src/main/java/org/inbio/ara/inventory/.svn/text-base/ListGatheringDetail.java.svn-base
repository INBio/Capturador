/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.GatheringObservationDetailDTO;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListGatheringDetail.java
 * @version Created on 02/09/2009, 09:07:16 AM
 * @author esmata
 */

public class ListGatheringDetail extends AbstractPageBean {
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
    private HtmlDataTable dataTableGathering = new HtmlDataTable();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListGatheringDetail() {
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
            log("ListGatheringDetail Initialization Failure", e);
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
        //Inicializar el dataprovider si la paginacion es nula
        if (getinventory$GatheringDetailSessionBean().getPagination()==null) {
            getinventory$GatheringDetailSessionBean().initDataProvider();
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
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
        quantityTotal = this.getinventory$GatheringDetailSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * Metodo ejecutado por el boton para crear un nuevo detalle
     * @return
     */
    public String btnNewDetail_action() {
        this.getinventory$GatheringDetailSessionBean().setCurrentDetail(new GatheringObservationDetailDTO());
        return "new";
    }

    /**
     * Metodo ejecutado por los botones de borrar detalle de recoleccion
     * @return
     */
    public String btnDeleteDetail_action() {
        GatheringDetailSessionBean gsb = this.getinventory$GatheringDetailSessionBean();

        int n = this.getDataTableGathering().getRowCount();
        ArrayList<GatheringObservationDetailDTO> selectedDetails = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableGathering().setRowIndex(i);
            GatheringObservationDetailDTO aux = (GatheringObservationDetailDTO)
                    this.getDataTableGathering().getRowData();
            if (aux.isSelected()) {
                selectedDetails.add(aux);
            }
        }
        if(selectedDetails == null || selectedDetails.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedDetails.size() == 1){ //En caso de que solo se seleccione un elemento
            GatheringObservationDetailDTO myDTO = selectedDetails.get(0);
            //Si no se puede borrar, retorno null
            if (!isDeletable(myDTO.getGatheringObservationDetailId())) {
                MessageBean.setErrorMessageFromBundle("imposible_to_delete",
                        this.getMyLocale());
                return null;
            } //Sino, procedemos a borrar el detalle de recoleccion
            //Borrar de la tabla gatheringObservationDetail
            gsb.getInventoryFacade().deleteGatheringDetailById(myDTO.getGatheringObservationDetailId());
            //Refrescar el dataprovider del paginador
            gsb.getPagination().deleteItem();
            gsb.getPagination().refreshList();
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
     * True en caso de que la recoleccion se pueda eliminar
     * @return
     */
    private boolean isDeletable(Long gId) {
        GatheringDetailSessionBean gsb = this.getinventory$GatheringDetailSessionBean();
        int specimensByGatheringDetail = gsb.getInventoryFacade().findSpecimensByGathObsDetailId(gId);
        if (specimensByGatheringDetail == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo ejecutado por los botones de edit (los de cada fila de la tabla de detalles)
     * @return
     */
    public String btnEditDetail_action() {
        int n = this.getDataTableGathering().getRowCount();
        ArrayList<GatheringObservationDetailDTO> selectedDetails = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableGathering().setRowIndex(i);
            GatheringObservationDetailDTO aux = (GatheringObservationDetailDTO)
                    this.getDataTableGathering().getRowData();
            if (aux.isSelected()) {
                selectedDetails.add(aux);
            }
        }
        if(selectedDetails == null || selectedDetails.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedDetails.size() == 1){ //En caso de que solo se seleccione un elemento
            GatheringObservationDetailDTO myDTO = selectedDetails.get(0);
            this.getinventory$GatheringDetailSessionBean().setCurrentDetail(myDTO);
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * @return the dataTableGathering
     */
    public HtmlDataTable getDataTableGathering() {
        return dataTableGathering;
    }

    /**
     * @param dataTableGathering the dataTableGathering to set
     */
    public void setDataTableGathering(HtmlDataTable dataTableGathering) {
        this.dataTableGathering = dataTableGathering;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

}

