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

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.IdentificationStatusDTO;
import org.inbio.ara.dto.inventory.IdentificationTypeDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import org.inbio.ara.AraSessionBean;
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
 * @version IdentificationSessionBean.java
 * @version Created on 17/08/2009, 03:39:33 PM
 * @author asanabria
 */
public class IdentificationSessionBean extends AbstractSessionBean implements Serializable, PaginationCoreInterface {
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
    private SearchFacadeRemote searchFacade;

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Value binding para los drop downs
    private Long INVALID_VALUE_ID = new Long(-1);
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Bandera para saber si se activo el panel de reidentificacion
    private boolean reIdentify = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    
    private boolean resetReidentification = false;
    //Specimen DTO seleccionado por el usuario para editar
    private IdentificationDTO currentIdentificationDTO = new IdentificationDTO();
    //SpecimenDTO que sera convertido en entidad y sera persistido
    private IdentificationDTO queryIdentificationDTO = new IdentificationDTO();
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");
    //Objetos para los AddRemoveList
    private AddRemoveList arTaxonList = new AddRemoveList();
    //Variable para el addRemove de Taxones
    private AddRemoveList arIdentifierList = new AddRemoveList();

    // Elementos para soportar la lista de barcodes a agregar.
    private Long[] specimenBarcodeSelected = new Long[0];
    private Option[] specimenBarcodeList = new Option[0];
    private String specimenBarcode = new String("");

    private List<IdentificationDTO> selectedIdentifications = null;
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public IdentificationSessionBean() {
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
            log("IdentificationSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {

        long inicioT = System.currentTimeMillis();
        long finalT;

        //int cantidad = inventoryFacade.countIdentifications().intValue();
        //finalT = System.currentTimeMillis();
        //System.out.println("Tiempo de despues de inventoryFacade.countIdentifications().intValue() = "+(finalT-inicioT));
        //finalT=inicioT;
        //this.setPagination(new PaginationControllerRemix(inventoryFacade.countIdentifications(getAraSessionBean().getGlobalCollectionId()).intValue(), getQuantity(), this));
        this.setPagination(new PaginationControllerRemix(countAllIdentification().intValue(), getQuantity(), this));
        finalT = System.currentTimeMillis();
        //System.out.println("Tiempo de despues de this.setPagination) = "+(finalT-inicioT));
        finalT=inicioT;
        this.getPagination().firstResults();
        finalT = System.currentTimeMillis();
        //System.out.println("Tiempo de despues de getPagination().firstResults()) = "+(finalT-inicioT));
        finalT=inicioT;
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
     * La idea de este metodo es poder preguntar si determinado protocolo esta activado o no
     * para una determinada colleccion
     * @param collectionId
     * @param protocolAtributeId
     * @param value corresponde a alguno de los valores posibles para saber si el protocolo esta
     * "activado" o "desactivado"
     * @return
     */
    public boolean matchCollectionProtocol(Long collectionId, Long protocolAtributeId, String value) {
        return this.inventoryFacade.matchCollectionProtocol(collectionId, protocolAtributeId, value);
    }
    
    public InventoryFacadeRemote getInventoryFacade() {
        return inventoryFacade;
    }

    public void setInventoryFacade(InventoryFacadeRemote inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
    }

    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    public boolean isReIdentify() {
        return reIdentify;
    }

    public void setReIdentify(boolean reIdentify) {
        this.reIdentify = reIdentify;
    }

    public IdentificationDTO getCurrentIdentificationDTO() {
        return currentIdentificationDTO;
    }

    public void setCurrentIdentificationDTO(IdentificationDTO currentIdentificationDTO) {
        this.currentIdentificationDTO = currentIdentificationDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IdentificationDTO getQueryIdentificationDTO() {
        return queryIdentificationDTO;
    }

    public void setQueryIdentificationDTO(IdentificationDTO queryIdentificationDTO) {
        this.queryIdentificationDTO = queryIdentificationDTO;
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

    /**
     * @return the queryMode
     */
    public boolean isQueryMode() {
        return queryMode;
    }

    /**
     * @param queryMode the queryMode to set
     */
    public void setQueryMode(boolean queryMode) {
        this.queryMode = queryMode;
    }

    public SearchFacadeRemote getSearchFacade() {
        return searchFacade;
    }

    public void setSearchFacade(SearchFacadeRemote searchFacade) {
        this.searchFacade = searchFacade;
    }

    public AddRemoveList getArIdentifierList() {
        return arIdentifierList;
    }

    public void setArIdentifierList(AddRemoveList arIdentifierList) {
        this.arIdentifierList = arIdentifierList;
    }

    public AddRemoveList getArTaxonList() {
        return arTaxonList;
    }

    public void setArTaxonList(AddRemoveList arTaxonList) {
        this.arTaxonList = arTaxonList;
    }

    public List<IdentificationTypeDTO> getIdentificationTypeList() {
        return this.inventoryFacade.getAllIdentificationTypes();
    }

    public List<IdentificationStatusDTO> getIdentificationStatusList() {
        return this.inventoryFacade.getAllIdentificationStatus();
    }

    public List<TaxonomicalRangeDTO> getTaxonomicalRangeList() {
        return this.inventoryFacade.getAllTaxonomicalRage();
    }

    public List<PersonDTO> getIdentifiersList() {
        return this.inventoryFacade.getAllIdentifiers();
    }

    public List<PersonDTO> getValidatorsList() {
        return this.inventoryFacade.getAllValidators();
    }

    public List<TaxonDTO> getAllTaxonByTaxonomicalRange(Long taxonomicalRangeId) {
        return this.inventoryFacade.getAllTaxonByTaxononimcalRange(taxonomicalRangeId, this.getAraSessionBean().getGlobalCollectionId(),
                this.getAraSessionBean().getGlobalTaxonRangeCollection(), this.getAraSessionBean().getGlobalTaxonCollectionId());
    }

    public void reidentify(List<IdentificationDTO> selectedIdentifications) {
        this.inventoryFacade.reIdentify(selectedIdentifications);
    }

    /**
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  " + (actualPage + 1) + " - " + (actualPage + resultsPerPage) + "  | " + totalResults + "  ";
    }

    public Long countAllIdentification() {
        return this.getInventoryFacade().countIdentifications(getAraSessionBean().getGlobalCollectionId());
    }

    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<IdentificationDTO>();
        } else if (l.get(0) == null) {
            return new ArrayList<IdentificationDTO>();
        } else {
            return l;
        }
    }


    public List getResults(int firstResult, int maxResults) {

        
        long inicioT = System.currentTimeMillis();
        long finalT;

        Long collectionId = getAraSessionBean().getGlobalCollectionId();

        //System.out.println("collectionId = "+collectionId);

            List<IdentificationDTO> auxResult =
                    new ArrayList<IdentificationDTO>();

            if (isQueryMode()) { //En caso de que sea busqueda avanzada
                //System.out.println("*** ENTRA A BUSQUEDA AVANZADA ***");
                //Set the collectionId into the DTO
                //It is a mandatory filter
                IdentificationDTO idto = queryIdentificationDTO;
                idto.setCollectionId(collectionId);
                try {
                    
                    Set<Long> identificationResults = getSearchFacade().getIdentificationIds(idto);
                    
                    //Integer count = ;
                    //i.longValue();
                    getPagination().setTotalResults(identificationResults.size());
                    //getPagination().setTotalResults(getSearchFacade().countIdentificationByCriteria(idto).intValue());

                    //finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));

                    return myReturn(searchFacade.searchIdentificationByCriteria(idto,
                            firstResult, maxResults, identificationResults));
                } catch (Exception e) {

                    //finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));

                    return auxResult;
                }
            } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
                //System.out.println("*** ENTRA A BUSQUEDA SIMPLE ***");
                try {
                    getPagination().setTotalResults(getSearchFacade().countIdentificationByCriteria(consultaSimple).intValue());

                    //finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));
                    //inicioT = finalT;

                    return myReturn(searchFacade.searchIdentificationByCriteria(consultaSimple,
                            collectionId, firstResult, maxResults));
                } catch (Exception e) {

                    //finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));

                    return auxResult;
                }
            } else { //Valores default
                try {
                    //System.out.println("*** ENTRA A VALORES DEFAULT ***");
                   
                    getPagination().setTotalResults(inventoryFacade.countIdentifications(getAraSessionBean().getGlobalCollectionId()).intValue());
                   // finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));

                    return myReturn(inventoryFacade.getAllIdentificationPaginated(firstResult,
                            maxResults, collectionId));
                } catch (Exception e) {

                    //finalT= System.currentTimeMillis();
                    //System.out.println("Tiempo al finalizar getResult = "+(finalT-inicioT));

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

    public Option[] getSpecimenBarcodeList() {
        return specimenBarcodeList;
    }

    public void setSpecimenBarcodeList(Option[] specimenBarcodeList) {
        this.specimenBarcodeList = specimenBarcodeList;
    }

    public Long[] getSpecimenBarcodeSelected() {
        return specimenBarcodeSelected;
    }

    public void setSpecimenBarcodeSelected(Long[] specimenBarcodeSelected) {
        this.specimenBarcodeSelected = specimenBarcodeSelected;
    }

    public String getSpecimenBarcode() {
        return specimenBarcode;
    }

    public void setSpecimenBarcode(String specimenBarcode) {
        this.specimenBarcode = specimenBarcode;
    }

    /**
     * @return the selectedIdentifications
     */
    public List<IdentificationDTO> getSelectedIdentifications() {
        return selectedIdentifications;
    }

    /**
     * @param selectedIdentifications the selectedIdentifications to set
     */
    public void setSelectedIdentifications(List<IdentificationDTO> selectedIdentifications) {
        this.selectedIdentifications = selectedIdentifications;
    }

    /**
     * @return the resetReidentification
     */
    public boolean isResetReidentification() {
        return resetReidentification;
    }

    /**
     * @param resetReidentification the resetReidentification to set
     */
    public void setResetReidentification(boolean resetReidentification) {
        this.resetReidentification = resetReidentification;
    }
}
