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
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.dto.inventory.SelectionListEntityDTO;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.CollectionDTO;

/**
 *
 * @author jgutierrez
 */
public class SelectionListSessionBean extends AbstractSessionBean
        implements PaginationCoreInterface {

    //Injections
    @EJB
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;

    //
    private FacesContext context;
    private Locale myLocale;

    //Data table binding para la tabla que muetra las listas de selección
    private HtmlDataTable dataTableSelectionListValues = new HtmlDataTable();

    //En esta variable se setearan los datos del drop down de listas de seleccion y sus valores
    private SingleSelectOptionsList selectionListData = new SingleSelectOptionsList();
    private SingleSelectOptionsList selectionListValueData = new SingleSelectOptionsList();
    /** Datos del AddDeleteComponent **/
    private MultipleSelectOptionsList associatedCollections = new MultipleSelectOptionsList();
    
    //Value binding para los drop downs
    private Long selectedSelectionListEntityId = null;
    private Long selectedSelectionListValueId = null;

    //Actual SelectionListDTO should be being edited or created.
    private SelectionListDTO actualSelectionListElementDTO = new SelectionListDTO();

    //Objeto que controla la paginacion de la informacion de especimenes
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();


    /**
     * 
     */
    public void initDataProvider() {
        this.setPagination(new PaginationControllerRemix(this.adminFacade.countAllSelectionListElements(getSelectedSelectionListEntityId()).intValue(), quantity, this));
        this.getPagination().firstResults();
    }

    /**
     * Method declared in the PaginationCoreInterface!
     *
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List getResults(int firstResult, int maxResults) {
        getPagination().setTotalResults(this.adminFacade.countAllSelectionListElements(getSelectedSelectionListEntityId()).intValue());
        return getAdminFacade().getAllSelectionListElementsPaginated(getSelectedSelectionListEntityId(), firstResult, maxResults);
    }

    /**
     * Obtener los datos del drop down de las listas de seleccion
     */
    public void setSelectionListDropDownData(){

        List<SelectionListEntityDTO> sleDTOList = this.getAdminFacade().getAllSelectionListEntities();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        String selectionListName;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SelectionListEntityDTO sleDTO : sleDTOList){
            selectionListName = BundleHelper.getDefaultBundleValue(sleDTO.getCodeName(), getMyLocale());
            option = new Option(sleDTO.getSelectionListEntityId(), selectionListName);
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getSelectionListData().setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     *
     * @return
     */
    public List<SelectionListDTO> getSelectedValues() {
        int n = this.getDataTableSelectionListValues().getRowCount();
        List<SelectionListDTO> selectedSelectionListValues = new ArrayList<SelectionListDTO>();

        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSelectionListValues().setRowIndex(i);
            SelectionListDTO thisSLV = (SelectionListDTO) this.getDataTableSelectionListValues().getRowData();
            if (thisSLV.isSelected()) {
                selectedSelectionListValues.add(thisSLV);
                System.out.println(thisSLV.toString());
            }
        }

        return selectedSelectionListValues;
    }

    /**
     * Busca todas las colecciones y las que estén asociadas al valor de la lista de seleccion
     * indicado en los parametros. Luego con esa informacion devuelve un dataprovider que adentro
     * lleva una lista de objetos GenericSelectionListDTO. Ese objeto mediante su propiedad selected
     * indica si la lista de coleccion esta asociada con el valor de la lista de seleccion o no.
     *
     * GenericSelectionListDTO
     *
     */
    public void setCollectionsBySelectionListValue() {
        //Collections list objects
        List<CollectionDTO> allCollections = getAdminFacade().getAllCollections();
        List<CollectionDTO> selectedCollections = getAdminFacade().getAllCollectionsAssociatedToSelectionListValue(this.selectedSelectionListEntityId,this.selectedSelectionListValueId);

        //GUI elements
        ArrayList<Option> availableCollectionsOptions = new ArrayList<Option>();

        ArrayList<Long> selectedCollectionsOptions = new ArrayList<Long>();
        Long[] selectedIds;
        Option[] optionsInArray;
        Option option;


        for(CollectionDTO cDTO : allCollections){
            option = new Option(cDTO.getCollectionId(), cDTO.getCollectionName());
            availableCollectionsOptions.add(option);

            if(selectedCollections.contains(cDTO))
                selectedCollectionsOptions.add((Long)option.getValue());
        }

        //sets the avaible options
        optionsInArray = new Option[availableCollectionsOptions.size()];
        this.associatedCollections.setOptions(availableCollectionsOptions.toArray(optionsInArray));

        //sets the selected options
        selectedIds = new Long[selectedCollectionsOptions.size()];
        this.associatedCollections.setSelectedValue(selectedCollectionsOptions.toArray(selectedIds));

    }


    /**
     * @return the dataTableSelectionListValues
     */
    public HtmlDataTable getDataTableSelectionListValues() {
        return dataTableSelectionListValues;
    }

    /**
     * @param dataTableSelectionListValues the dataTableSelectionListValues to set
     */
    public void setDataTableSelectionListValues(HtmlDataTable dataTableSelectionListValues) {
        this.dataTableSelectionListValues = dataTableSelectionListValues;
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
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }

    /**
     * @return the selectedSelectionListEntityId
     */
    public Long getSelectedSelectionListEntityId() {
        return selectedSelectionListEntityId;
    }

    /**
     * @param selectedSelectionListEntityId the selectedSelectionListEntityId to set
     */
    public void setSelectedSelectionListEntityId(Long selectedSelectionListEntityId) {
        this.selectedSelectionListEntityId = selectedSelectionListEntityId;
    }

    /**
     * @return the actualSelectionListElementDTO
     */
    public SelectionListDTO getActualSelectionListElementDTO() {
        return actualSelectionListElementDTO;
    }

    /**
     * @param actualSelectionListElementDTO the actualSelectionListElementDTO to set
     */
    public void setActualSelectionListElementDTO(SelectionListDTO actualSelectionListElementDTO) {
        this.actualSelectionListElementDTO = actualSelectionListElementDTO;
    }

    /**
     * @return the selectionListData
     */
    public SingleSelectOptionsList getSelectionListData() {
        return selectionListData;
    }

    /**
     * @param selectionListData the selectionListData to set
     */
    public void setSelectionListData(SingleSelectOptionsList selectionListData) {
        this.selectionListData = selectionListData;
    }

    /**
     * @return the selectionListValueData
     */
    public SingleSelectOptionsList getSelectionListValueData() {
        return selectionListValueData;
    }

    /**
     * @param selectionListValueData the selectionListValueData to set
     */
    public void setSelectionListValueData(SingleSelectOptionsList selectionListValueData) {
        this.selectionListValueData = selectionListValueData;
    }

    /**
     * @return the selectedSelectionListValueId
     */
    public Long getSelectedSelectionListValueId() {
        return selectedSelectionListValueId;
    }

    /**
     * @param selectedSelectionListValueId the selectedSelectionListValueId to set
     */
    public void setSelectedSelectionListValueId(Long selectedSelectionListValueId) {
        this.selectedSelectionListValueId = selectedSelectionListValueId;
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the associatedCollections
     */
    public MultipleSelectOptionsList getAssociatedCollections() {
        return associatedCollections;
    }

    /**
     * @param associatedCollections the associatedCollections to set
     */
    public void setAssociatedCollections(MultipleSelectOptionsList associatedCollections) {
        this.associatedCollections = associatedCollections;
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

}
