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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.agent.ProfileDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
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
 * @version PersonSessionBean.java
 * @version Created on 06/10/2009, 02:33:32 PM
 * @author esmata
 */

public class PersonSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
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
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;

    
    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos

    //Current DTO para la edicion de personas
    private PersonDTO currentPerson = new PersonDTO();

    //Objeto AddRemoveList para los perfiles asociados (pantalla new person)
    private AddRemoveList arProfilesNew = new AddRemoveList();
    //Objeto AddRemoveList para las instituciones asociadas (pantalla new person)
    private AddRemoveList arInstitutionesNew = new AddRemoveList();

    //Objeto AddRemoveList para los perfiles asociados (pantalla edit person)
    private AddRemoveList arProfilesEdit = new AddRemoveList();
    //Objeto AddRemoveList para las instituciones asociadas (pantalla edit person)
    private AddRemoveList arInstitutionesEdit = new AddRemoveList();

    /**
     * Bandera muy importante para el correcto funcionamiento de los
     * AddRemove components de la pantalla de editar
     * Le indica al prerender de la pantalla de edit que cargue los
     * datos seleccionados de los AddRemove solamnete UNA vez
     * true = cargar datos
     * false = ignorar la carga de datos seleccionados
     */
    private boolean firstTime = true;


    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;

    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public PersonSessionBean() {
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
            log("PersonSessionBean Initialization Failure", e);
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
     * Obtener los datos para el drop down de perfiles
     */
    public List<ProfileDTO> getprofilesData(){
            return getAdminFacade().getAllProfiles();
    }

     /**
     * Obtener los datos para el drop down de instituciones
     */
    public List<InstitutionDTO> getinstitutionsData(){
            return getAdminFacade().getAllInstitutions();
    }

    /**
     * Metodo para eliminar Personas por su id
     * @param Id
     */
    public void deletePerson(Long Id){
        this.adminFacade.deletePerson(Id);
    }

    /**
     * Persiste una nueva persona
     */
    public PersonDTO savePerson(){
        return this.adminFacade.savePerson(this.getCurrentPerson());
    }

    /**
     * Actualiza una persona
     */
    public void updatePerson(PersonDTO dto){
        this.adminFacade.updatePerson(dto);
    }

    /**
     * Persiste la lista de instituciones asociadas y la lista de perfiles
     * asociados al currentDTO (utilizado en el new perosn)
     */
    public void savePersonInstitutionsAndProfiles(){
        List<Long> institutions = new ArrayList<Long>();
        List<Long> profiles = new ArrayList<Long>();
		int arrayLength = 0;

        Long[] iaux = this.getArInstitutionesNew().getSelectedOptions();

		if(iaux != null){
			arrayLength = iaux.length;
			for(int i = 0; i< arrayLength; i++){
				institutions.add(iaux[i]);
			}
		}
                
		Long[] paux = this.getArProfilesNew().getSelectedOptions();

		if(paux != null){
			arrayLength = paux.length;
			for(int i = 0; i< arrayLength; i++){
				profiles.add(paux[i]);
			}
		}

		//Save institutions
        this.getAdminFacade().savePersonInstitutions
                (this.getCurrentPerson(), institutions);
        //Save profiles
        this.getAdminFacade().savePersonProfiles
                (this.getCurrentPerson(), profiles);
    }

    /**
     * Persiste la lista de instituciones asociadas y la lista de perfiles
     * asociados al currentDTO (utilizado en el edit perosn)
     */
    public void savePersonInstitutionsAndProfiles(PersonDTO dto){
        List<Long> institutions = new ArrayList<Long>();
        List<Long> profiles = new ArrayList<Long>();

        Long[] iaux = this.getArInstitutionesEdit().getSelectedOptions();

		int arrayLength = 0;

		if(iaux != null){
			arrayLength = iaux.length;
			for(int i = 0; i < arrayLength; i++){
				institutions.add(iaux[i]);
			}
		}

		Long[] paux = this.getArProfilesEdit().getSelectedOptions();
		if(paux != null){
			arrayLength = paux.length;
			for(int i = 0; i < arrayLength; i++){
				profiles.add(paux[i]);
			}
		}

		//Save institutions
        this.getAdminFacade().savePersonInstitutions(dto, institutions);
        //Save profiles
        this.getAdminFacade().savePersonProfiles(dto, profiles);
    }

    /**
     * Inicializar el data provider
     */
    public void initDataProvider() {
        
        this.setPagination(new PaginationControllerRemix(this.getAdminFacade().countPerson().intValue(), getQuantity(), this));
        this.getPagination().firstResults();
        
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
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<PersonDTO>();
        } else {
            return l;
        }
    }

    public List getResults(int firstResult, int maxResults) {

        List<PersonDTO> auxResult = new ArrayList<PersonDTO>();
        List<PersonDTO> aListDTO;

        if (isQueryModeSimple())
        { //En caso de que sea busqueda simple
            try
            {
                getPagination().setTotalResults(this.getAdminFacade().countPersonSimpleSearch(this.consultaSimple).intValue());
                aListDTO =  myReturn(getAdminFacade().
                        getPersonSimpleSearch(this.consultaSimple, firstResult, maxResults));
                return aListDTO;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
        else //Valores default
        {
            try {
                getPagination().setTotalResults(this.getAdminFacade().countPerson().intValue());
                return adminFacade.getAllPersonPaginated(firstResult, maxResults);
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
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
     * @return the inventoryFacade
     */
    public InventoryFacadeRemote getInventoryFacade() {
        return inventoryFacade;
    }

    /**
     * @param inventoryFacade the inventoryFacade to set
     */
    public void setInventoryFacade(InventoryFacadeRemote inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
    }

    /**
     * @return the currentPerson
     */
    public PersonDTO getCurrentPerson() {
        this.currentPerson.setUserName(this.getAraSessionBean().getGlobalUserName());
        return currentPerson;
    }

    /**
     * @param currentPerson the currentPerson to set
     */
    public void setCurrentPerson(PersonDTO currentPerson) {
        this.currentPerson = currentPerson;
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
     * @return the arProfilesNew
     */
    public AddRemoveList getArProfilesNew() {
        return arProfilesNew;
    }

    /**
     * @param arProfilesNew the arProfilesNew to set
     */
    public void setArProfilesNew(AddRemoveList arProfilesNew) {
        this.arProfilesNew = arProfilesNew;
    }

    /**
     * @return the arInstitutionesNew
     */
    public AddRemoveList getArInstitutionesNew() {
        return arInstitutionesNew;
    }

    /**
     * @param arInstitutionesNew the arInstitutionesNew to set
     */
    public void setArInstitutionesNew(AddRemoveList arInstitutionesNew) {
        this.arInstitutionesNew = arInstitutionesNew;
    }

    /**
     * @return the arProfilesEdit
     */
    public AddRemoveList getArProfilesEdit() {
        return arProfilesEdit;
    }

    /**
     * @param arProfilesEdit the arProfilesEdit to set
     */
    public void setArProfilesEdit(AddRemoveList arProfilesEdit) {
        this.arProfilesEdit = arProfilesEdit;
    }

    /**
     * @return the arInstitutionesEdit
     */
    public AddRemoveList getArInstitutionesEdit() {
        return arInstitutionesEdit;
    }

    /**
     * @param arInstitutionesEdit the arInstitutionesEdit to set
     */
    public void setArInstitutionesEdit(AddRemoveList arInstitutionesEdit) {
        this.arInstitutionesEdit = arInstitutionesEdit;
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
     * @return the advancedSearch
     */
    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * @return the queryModeSimple
     */
    public boolean isQueryModeSimple() {
        return queryModeSimple;
    }

    /**
     * @param queryModeSimple the queryModeSimple to set
     */
    public void setQueryModeSimple(boolean queryModeSimple) {
        this.queryModeSimple = queryModeSimple;
    }

    /**
     * @return the consultaSimple
     */
    public String getConsultaSimple() {
        return consultaSimple;
    }

    /**
     * @param consultaSimple the consultaSimple to set
     */
    public void setConsultaSimple(String consultaSimple) {
        this.consultaSimple = consultaSimple;
    }

    
}
