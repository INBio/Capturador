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

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.security.SystemUserDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.security.SecurityFacadeRemote;
import org.inbio.ara.util.AddRemoveList;
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
 * @version SystemUserSessionBean.java
 * @version Created on 23/09/2009, 04:03:42 PM
 * @author esmata
 */

public class SystemUserSessionBean extends AbstractSessionBean implements PaginationCoreInterface {
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
    private SecurityFacadeRemote securityFacade;
    @EJB
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;

    

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;
    
    //Cantidad de usuarios por pagina
    private int quantity = 10;

    //Curret userDTO, para la pantalla de edit
    private SystemUserDTO currentUser = new SystemUserDTO();

    //Objeto AddRemoveList para los taxones de usuarios
    private AddRemoveList arTaxonsEdit = new AddRemoveList();
    //Objeto AddRemoveList para los grupos nomenclaturales de usuarios
    private AddRemoveList arNomenclaturalsEdit = new AddRemoveList();

    /**
     * Bandera muy importante para el correcto funcionamiento de los
     * AddRemove components de la pantalla de editar
     * Le indica al prerender de la pantalla de edit que cargue los
     * datos seleccionados de los AddRemove solamnete UNA vez
     * true = cargar datos
     * false = ignorar la carga de datos seleccionados
     */
    private boolean firstTime = true;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SystemUserSessionBean() {
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
            log("UserSessionBean Initialization Failure", e);
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
     * Metodo para persistir un nuevo usuario
     * @param uDTO
     * @return
     */
    public SystemUserDTO saveNewSystemUser(SystemUserDTO uDTO){
        return this.securityFacade.saveNewSystemUser(uDTO);
    }

    /**
     * Persiste el currentDTO
     */
    public void updateSystemUser(){
        this.securityFacade.updateSystemUser(this.getCurrentUser());
    }

    /**
     * Metodo para eliminar una entidad usuario
     */
    public void deleteSystemUser(SystemUserDTO dto){
        this.securityFacade.deleteSystemUser(dto);
    }

    /**
     * Metodo para eliminar las entidades user_taxon
     */
    public void deleteUserTaxonsByUser(Long userId){
        this.securityFacade.deleteUserTaxonsByUser(userId);
    }

    /**
     * Metodo para eliminar las entidades user_nomenclatural_group
     */
    public void deleteNomenclaturalGroupsByUser(Long userId){
        this.securityFacade.deleteNomenclaturalGroupsByUser(userId);
    }

    /**
     * Metodo para averiguar si el usuario es administrador o no lo es.
     */
    public boolean isAdmin(Long userId){
        return this.securityFacade.isAdmin(userId);
    }

     /**
     * Obtener los datos para el add remove de taxones
     */
    public List<TaxonDTO> getTaxonsData(){
        //return this.inventoryFacade.getAllTaxon();
        return this.inventoryFacade.getTaxonCollections();
    }

    /**
     * Obtener la lista completa de grupos nomenclaturales
     */
    public List<NomenclaturalGroupDTO> getAllNomenclaturalGroup(){
        return this.securityFacade.getAllNomenclaturalGroup();
    }

    /**
     * Obtener la lista de grupos nomenclaturales por usuario
     */
    public List<NomenclaturalGroupDTO> getNomenclaturalGroupListByUser(Long userId){
        return this.securityFacade.getNomenclaturalGroupList(userId);
    }

     /**
     * Obtener la lista de taxones por usuario
     */
    public List<TaxonDTO> getTaxonListByUser(Long userId){
        return this.adminFacade.getUserTaxonList(userId);
    }

    /**
     * Persistir un nuevo userTaxon
     * @param taxonId
     * @param userId
     * @param secuence
     */
    public void saveUserTaxon(Long taxonId,Long userId,Long secuence){
        this.securityFacade.saveUserTaxon(taxonId, userId, secuence);
    }

     /**
     * Persistir un nuevo UserNomenclaturalGroup
     */
    public void saveUserNomenclaturalGroup(Long groupId,Long userId,Long secuence){
        this.securityFacade.saveUserNomenclaturalGroup(groupId, userId, secuence);
    }

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        this.setPagination(new PaginationControllerRemix(this.securityFacade.countUsers().intValue(), getQuantity(), this));
        this.getPagination().firstResults();
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
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  | "+totalResults+"  ";
    }

    /**
     * @return the currentUser
     */
    public SystemUserDTO getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(SystemUserDTO currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return the arTaxonsEdit
     */
    public AddRemoveList getArTaxonsEdit() {
        return arTaxonsEdit;
    }

    /**
     * @param arTaxonsEdit the arTaxonsEdit to set
     */
    public void setArTaxonsEdit(AddRemoveList arTaxonsEdit) {
        this.arTaxonsEdit = arTaxonsEdit;
    }

    /**
     * @return the arNomenclaturalsEdit
     */
    public AddRemoveList getArNomenclaturalsEdit() {
        return arNomenclaturalsEdit;
    }

    /**
     * @param arNomenclaturalsEdit the arNomenclaturalsEdit to set
     */
    public void setArNomenclaturalsEdit(AddRemoveList arNomenclaturalsEdit) {
        this.arNomenclaturalsEdit = arNomenclaturalsEdit;
    }

    /**
     * @return the firstTime
     */
    public boolean isFirstTime() {
        return firstTime;
    }

    /**
     * @param firstTime the firstTime to set
     */
    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
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

    public List getResults(int firstResult, int maxResults) {
        this.getPagination().setTotalResults(this.securityFacade.countUsers().intValue());
        return securityFacade.getAllUsersPaginated(firstResult, maxResults);
    }

  
    
}
