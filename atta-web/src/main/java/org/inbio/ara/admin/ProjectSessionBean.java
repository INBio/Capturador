/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;

/**
 *
 * @author gsulca
 */
public class ProjectSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
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
    private ProjectDTO currentProject = new ProjectDTO();
    
    
    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;

    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");
    
    private boolean firstTime = true;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public ProjectSessionBean() {
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
    
    public AdminFacadeRemote getAdminFacade() {
        return adminFacade;
    }
    
    /**
     * Inicializar el data provider
     */
    public void initDataProvider() {
        System.out.println("Cantidad de proyectos"+this.getAdminFacade().countProject().intValue());
        
        this.setPagination(new PaginationControllerRemix(this.getAdminFacade().countProject().intValue(), getQuantity(), this));
        this.getPagination().firstResults();
        
        System.out.println(this.getPagination().getDataProvider().getRowCount());
    }

    /**
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        /*
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  | "+totalResults+"  ";
        * 
        */
        return null;
    }

    
    @Override
    public List getResults(int firstResult, int maxResults) {
        List<ProjectDTO> auxResult = new ArrayList<ProjectDTO>();
        List<ProjectDTO> aListDTO;

        if (isQueryModeSimple())
        {
            System.out.println("Entra a Modo simple");
            System.out.println("First results = "+firstResult);
            System.out.println("Max results = "+maxResults);
            //En caso de que sea busqueda simple
            
            try
            {
                getPagination().setTotalResults(this.getAdminFacade().countProjectSimpleSearch(this.getConsultaSimple()).intValue());
                aListDTO =  myReturn(getAdminFacade().
                        getProjectSimpleSearch(this.getConsultaSimple(), firstResult, maxResults));
                System.out.println("la busqueda retorna = "+aListDTO.size());
                return aListDTO;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }                
         
        }
        else //Valores default
        {
            try {
                System.out.println("Entra a valores default");
                getPagination().setTotalResults(this.getAdminFacade().countProject().intValue());
                return adminFacade.getAllProjectPaginated(firstResult, maxResults);
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
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
     * @return the currentProject
     */
    public ProjectDTO getCurrentProject() {
        return currentProject;
    }

    /**
     * @param currentProject the currentProject to set
     */
    public void setCurrentProject(ProjectDTO currentProject) {
        this.currentProject = currentProject;
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
    
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<PersonDTO>();
        } else {
            return l;
        }
    }
    
    /**
     * Persiste una nuevo proyecto
     */
    public ProjectDTO saveProjectDTO(){
        return this.adminFacade.saveProject(this.getCurrentProject());
    }

        /**
     * Persiste una nuevo proyecto
     */
    public void updateProjectDTO(){
        this.adminFacade.updateProject(this.getCurrentProject());
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
    
}
