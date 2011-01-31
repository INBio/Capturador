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

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import javax.faces.component.html.HtmlDataTable;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;
/**
 *
 * @author jgutierrez
 */
public class CollectionSessionBean extends AbstractSessionBean implements Serializable, PaginationCoreInterface{

    //Injections
    @EJB
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;

    //Data table binding para la tabla que muetra las collecciones
    private HtmlDataTable dataTableCollections = new HtmlDataTable();

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Actual CollectionDTO should be being edited or created.
    private CollectionDTO actualCollectionDTO = new CollectionDTO();
    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();


        /**
     * @return the quantity
     */
    public //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    void initDataProvider() {
        setPagination(new PaginationControllerRemix(this.inventoryFacade.countCollections().intValue(), getQuantity(), this));
    }

    /**
     * @return the dataTableCollections
     */
    public HtmlDataTable getDataTableCollections() {
        return dataTableCollections;
    }

    /**
     * @param dataTableCollections the dataTableCollections to set
     */
    public void setDataTableCollections(HtmlDataTable dataTableCollections) {
        this.dataTableCollections = dataTableCollections;
    }

    /**
     * @return the adminFacade
     */
    public AdminFacadeRemote getAdminFacade() {
        return adminFacade;
    }

    /**
     * @param adminFacade the adminFacade to set
     */
    public void setAdminFacade(AdminFacadeRemote adminFacade) {
        this.adminFacade = adminFacade;
    }

    public List getResults(int firstResult, int maxResults) {
        return inventoryFacade.getAllCollectionPaginated(firstResult, maxResults);
    }

    /**
     * @return the pagination
     */
    public PaginationControllerRemix getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(PaginationControllerRemix pagination) {
        this.pagination = pagination;
    }
    
    /**
     *
     * @return
     */
    public List<CollectionDTO> getSelectedCollection() {
        
        int n = this.getDataTableCollections().getRowCount();
        List<CollectionDTO> selectedCollections = new ArrayList();

        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableCollections().setRowIndex(i);
            CollectionDTO thisCollection = (CollectionDTO) this.getDataTableCollections().getRowData();
            if (thisCollection.isSelected()) {
                selectedCollections.add(thisCollection);
                System.out.println(thisCollection.toString());
            }
        }

        return selectedCollections;
    }
    
    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
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
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
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
     * @return the actualCollectionDTO
     */
    public CollectionDTO getActualCollectionDTO() {
        this.actualCollectionDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
        return actualCollectionDTO;
    }

    /**
     * @param actualCollectionDTO the actualCollectionDTO to set
     */
    public void setActualCollectionDTO(CollectionDTO actualCollectionDTO) {
        this.actualCollectionDTO = actualCollectionDTO;
    }


    /**
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  | "+totalResults+"  ";
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

        /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

}
