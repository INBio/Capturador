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
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.util.PaginationController;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version AudienceSessionBean.java
 * @version Created on 05/10/2009, 10:29:11 AM
 * @author esmata
 */

public class AudienceSessionBean extends AbstractSessionBean implements Serializable, PaginationCoreInterface{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injections
    @EJB
    private AdminFacadeRemote adminFacade;

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos

    //Audience DTO para edicion
    private AudienceDTO currentAudienceDTO = new AudienceDTO();

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public AudienceSessionBean() {
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
            log("AudienceSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
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
    @Override
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
    @Override
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
    @Override
    public void destroy() {
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
     * Metodo para eliminar Audiencias por su id
     * @param Id
     */
    public void deleteAudience(Long Id){
        this.adminFacade.deleteAudience(Id);
    }

    /**
     * Metodo para persistir una nueva Audiencia
     */
    public void saveAudience(AudienceDTO adto){
        this.adminFacade.saveAudience(adto);
    }

    /**
     * Metodo para hacer update de una Audiencia
     */
    public void updateAudience(AudienceDTO dto){
        this.adminFacade.updateAudience(dto);
    }

    

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Inicializar el data provider
     */
    public void initDataProvider() {
        setPagination(new PaginationControllerRemix(this.getAdminFacade().countAudiences().intValue(), getQuantity(), this));
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

    /**
     * @return the currentAudienceDTO
     */
    public AudienceDTO getCurrentAudienceDTO() {
        this.currentAudienceDTO.setUserName(this.getAraSessionBean().getGlobalUserName());
        return currentAudienceDTO;
    }

    /**
     * @param currentAudienceDTO the currentAudienceDTO to set
     */
    public void setCurrentAudienceDTO(AudienceDTO currentAudienceDTO) {
        this.currentAudienceDTO = currentAudienceDTO;
    }

    public List getResults(int firstResult, int maxResults) {
        return adminFacade.getAllAudiencesPaginated(firstResult, maxResults);
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

    
}
