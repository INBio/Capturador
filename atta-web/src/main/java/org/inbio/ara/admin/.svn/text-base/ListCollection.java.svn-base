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
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.util.MessageBean;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;


/*
 *
 * @author jgutierrez
 */
public class ListCollection extends AbstractPageBean {


    //Componentes graficos utilizados para las busquedas de especimenes
    private HtmlPanelGrid gridEditOrNew = new HtmlPanelGrid();
    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

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
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
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
        CollectionSessionBean csb = this.getAdminCollectionSessionBean();

        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        if (csb.getPagination() == null) {
            csb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            csb.getPagination().refreshList();

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
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }


    /**
     *
     * @return
     */
    public String btn_new_action(){
        this.gridEditOrNew.setRendered(true);
        this.getAdminCollectionSessionBean().
                setActualCollectionDTO(new CollectionDTO());
        return null;
    }

    /**
     * Solo puede editarse una colección por tiro!
     *
     * Action del boton de editar espécimen
     * @return
     */
    public String btn_edit_action() {
        if(getValidatedCollectionDTO() != null){
            this.getAdminCollectionSessionBean().
                    setActualCollectionDTO(getValidatedCollectionDTO());
            this.gridEditOrNew.setRendered(true);
        }
        return null;
    }

    public String btn_delete_action() {
        if (getValidatedCollectionDTO() != null) {
            this.getAdminCollectionSessionBean().
                    setActualCollectionDTO(getValidatedCollectionDTO());
            try {
                this.getAdminCollectionSessionBean().getAdminFacade().
                        deleteCollection(this.getAdminCollectionSessionBean().
                        getActualCollectionDTO());
                MessageBean.setSuccessMessageFromBundle
                        ("delete_collection_sucess", this.getMyLocale());
            } catch (Exception e) {
                MessageBean.setErrorMessageFromBundle
                        ("delete_collection_error", this.getMyLocale());
            }
            this.getAdminCollectionSessionBean().getPagination().refreshList();
            this.gridEditOrNew.setRendered(false);
        }

        return null;
    }

    public String btn_save_action() {
        int val = this.getAdminCollectionSessionBean().getAdminFacade().
                saveOrUpdateCollection(this.getAdminCollectionSessionBean().
                getActualCollectionDTO());
        this.gridEditOrNew.setRendered(false);

        this.getAdminCollectionSessionBean().getPagination().refreshList();

        MessageBean.setSuccessMessageFromBundle("save_collection_success",
                this.getMyLocale());
        return null;
    }

    
    /**
     * @return
     */
    public String btn_cancel_action(){
        this.gridEditOrNew.setRendered(false);
        this.getAdminCollectionSessionBean().setActualCollectionDTO
                (new CollectionDTO());
        return null;
    }

    /**
     * Verifica que solo puede seleccionarse una colección o tira un error
     *
     * @return
     */
    private CollectionDTO getValidatedCollectionDTO(){

        List<CollectionDTO> selectedCollections =
                getAdminCollectionSessionBean().getSelectedCollection();

        if(selectedCollections == null || selectedCollections.size() == 0) { //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle
                    ("not_selected", this.getMyLocale());
        }
        //En caso de que solo se seleccione un elemento
        else if(selectedCollections.size() == 1) { 
            return selectedCollections.get(0);
        }
        else { //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle
                    ("not_yet", this.getMyLocale());
        }

        return null;
    }

    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionSessionBean getAdminCollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        this.quantityTotal = this.getAdminCollectionSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }
}
