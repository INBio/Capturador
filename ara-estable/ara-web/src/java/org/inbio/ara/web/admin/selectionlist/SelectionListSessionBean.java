/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.admin.selectionlist;

import com.sun.data.provider.impl.ObjectListDataProvider;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.collection.ListTable;
import org.inbio.ara.persistence.selectionListEntity;
import javax.faces.FacesException;

/**
 *
 * Idealmente se intentará poner acá toda la funcionalidad que necesiten
 * los JSP's y que sea referente al manejo de listas de seleccion. Esta clase
 * sería el convertidor entre el mundo del modelo y el mundo de lo que necesiten los jsp's
 * para funcionar.
 *
 * @author jgutierrez
 */
public class SelectionListSessionBean extends AbstractSessionBean {

    /**
     * Managers
     */
    @EJB
    private SelectionListManagerRemote selectionListManager;

    @EJB
    private CollectionRemote colectionManager;

    /**
     * Variables
     */

    /** Fuentes de los datos de la tabla
     A la hora de inicializar esta variabe el constructor puede no recibir nada o recibir una Lista,
     entonces la idea es que se inicialice con un List<selectionListEntity> **/
    public ObjectListDataProvider selectionListValuesDataProvider = new ObjectListDataProvider();

    /** datos de los valores de la lista de seleccion **/
    private SingleSelectOptionsList selectionListValuesRadioButtonGroup = new SingleSelectOptionsList();

    /** Datos del DropDown **/
    private SingleSelectOptionsList selectionListDropDownData = new SingleSelectOptionsList();

    /** Datos del AddDeleteComponent **/
    private MultipleSelectOptionsList associatedCollections = new MultipleSelectOptionsList();

    /* Lista de Seleccion que se está mostrando*/
    private ListTable actualSelectionList = null;
    /* Valor de la lista de seleccion cuayas asociaciones estan siendo mostradas */
    private selectionListEntity actualSelectionListValue = null;
    /** determina si un valor de una lista de seleccion debe actualizarse o crearse nueva!**/
    private boolean newSelectionListValue;

    /**
     * <p>Construct a new session data bean instance.</p>admi
     */
    public SelectionListSessionBean() {
    }

 /**
     * <p>This method is called when this bean is initially added to
     * request scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * request scope.</p>
     *
     * <p>You may customize this method to allocate resources that are required
     * for the lifetime of the current request.</p>
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
     *
     * Este elemento deja todo listo para ser usado por la capa de JSF.
     * En el campo del value del Option, podra el ID de la fila y en el
     * texto que se despliega el nombre de la lista de seleccion.
     *
     * @param the Id(value) of the element to be set as selected, if null then
     * the selected will be automatic.
     *
     * @return
     */

    /**
     * Establece el valor de la variable
     *
     */
    public void setAllSelectionListsOptions() {
        //setSelectionListValuesDataProvider

        List<ListTable> selectionLists = selectionListManager.listAllSelectionLists();

        SingleSelectOptionsList ssol = new SingleSelectOptionsList();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        for(ListTable lt : selectionLists){
            option = new Option(lt.getId(), lt.getDescription());
            allOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        ssol.setOptions(allOptions.toArray(allOptionsInArray));

        //define el selected value por el valor de la variable de clase actualSelectionListId
        if(this.getActualSelectionList() == null){
            this.setActualSelectionList(selectionLists.get(0));
        }
        
        ssol.setSelectedValue(this.getActualSelectionList().getId());

        this.selectionListDropDownData = ssol;

    }


    /**
     * Este metodo busca los valores de una lista de selecccion y los devuelve
     * en formato  de dataProvider listos para ser empotrados en una tabla.
     *
     *
     * @return
     */
    public void setAllSelectionListValues(){

        List<selectionListEntity> selectionListValuesList = selectionListManager.getAllSelectionListValues(this.getActualSelectionList().getId());

        ArrayList<Option> allListValues = new ArrayList<Option>();
        Option[] listValuesInArray;
        Option option;

        for(selectionListEntity sle : selectionListValuesList){
            option = new Option(sle.getId(), sle.getName());
            allListValues.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        listValuesInArray = new Option[allListValues.size()];
        this.selectionListValuesRadioButtonGroup.setOptions(allListValues.toArray(listValuesInArray));

        //define el selected value por el valor de la variable de clase actualSelectionListId
        if(this.getActualSelectionListValue() == null){
            if(selectionListValuesList.size() > 0)
                this.setActualSelectionListValue(selectionListValuesList.get(0));
            else
                this.setActualSelectionListValue(this.selectionListManager.getEmptySelectionListValue(this.actualSelectionList.getId()));
        }
        if(this.getActualSelectionListValue().getId() != null){
            this.selectionListValuesRadioButtonGroup.setSelectedValue(getActualSelectionListValue().getId());
        }
    }

    /**
     * saves the actualSelectionListValue object in the database
     *
     * if newSelectionListValue is true means that the key value should be ignored,
     *  in other words is a new selection list value. False for a update operations!
     */
    public void saveSelectionListValue(){

        if(this.newSelectionListValue){
            this.actualSelectionListValue.setId(null);
            this.selectionListManager.createSelectionListValue(this.actualSelectionListValue);

        } else {
            this.selectionListManager.updateSelectionListValue(this.actualSelectionListValue);

        }
        
    }

    /**
     * Elmina la lista de seleccion actual
     */
    public void deleteSelectionListValue() throws IllegalArgumentException {
        try{
            this.selectionListManager.deleteSelectionListValue(this.actualSelectionList.getId(), this.actualSelectionListValue.getId());
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
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
    public void setCollectionsBySelectionListValue(){


        //Collections list objects
        List<Collection> allCollections = getColectionManager().listAllCollections();
        List<Collection> selectedCollections = selectionListManager.getCollectionsBySelectionListValue(this.getActualSelectionList().getId(), this.getActualSelectionListValue().getId());

        //GUI elements
        ArrayList<Option> availableCollectionsOptions = new ArrayList<Option>();

        ArrayList<Long> selectedCollectionsOptions = new ArrayList<Long>();
        Long[] selectedIds;
        Option[] optionsInArray;
        Option option;


        for(Collection c : allCollections){
            option = new Option(c.getId(), c.getName());
            availableCollectionsOptions.add(option);
            
            if(selectedCollections.contains(c))
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
     *
     */
    public void saveAssociatedCollections(){
        System.out.println("save associations");
        Object[] selectedIdsAsString = (Object[]) this.associatedCollections.getSelectedValue();

        List<Long> newAssociatedCollections = new ArrayList<Long>();

        for(Object o : selectedIdsAsString){
            newAssociatedCollections.add(Long.valueOf((String)o));
        }

        System.out.println("pre-updateCollectionsBySelectionListValue"+newAssociatedCollections.size());
        selectionListManager.updateCollectionsBySelectionListValue(this.getActualSelectionList().getId(), this.getActualSelectionListValue().getId(), newAssociatedCollections);
        
    }



    /**
     * 
     * @param selectionListId
     * @param selectionListValueId
     */
    void setEntitiesById(Long selectionListId, Long selectionListValueId) {

        //sets the Selection list
        if(selectionListId == null)
            this.actualSelectionList = null;
        else
            this.setActualSelectionList(selectionListManager.getSelectionListById(selectionListId));

        //sets the selection list value
        if(selectionListValueId == null)
            this.actualSelectionListValue = null;
        else
            this.setActualSelectionListValue(selectionListManager.getSelectionlistValueById(selectionListId, selectionListValueId));
    }

    /**
     *
     *
     */
    //public void setNewEmptySelectionListValue() {
    //    Long actualSelectionListId = this.actualSelectionList.getId();
    //    this.actualSelectionListValue = this.selectionListManager.getEmptySelectionListValue(actualSelectionListId);
    //}


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }


    /**
     * @return the selectionListValuesDataProvider
     */
    public ObjectListDataProvider getSelectionListValuesDataProvider() {
        return selectionListValuesDataProvider;
    }

    /**
     * @param selectionListValuesDataProvider the selectionListValuesDataProvider to set
     */
    public void setSelectionListValuesDataProvider(ObjectListDataProvider selectionListValuesDataProvider) {
        this.selectionListValuesDataProvider = selectionListValuesDataProvider;
    }


    /**
     * @return the selectionListDropDownData
     */
    public SingleSelectOptionsList getSelectionListDropDownData() {
        return selectionListDropDownData;
    }

    /**
     * @param selectionListDropDownData the selectionListDropDownData to set
     */
    public void setSelectionListDropDownData(SingleSelectOptionsList selectionListDropDownData) {
        this.selectionListDropDownData = selectionListDropDownData;
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
     * @return the selectionListValuesRadioButtonGroup
     */
    public SingleSelectOptionsList getSelectionListValuesRadioButtonGroup() {
        return selectionListValuesRadioButtonGroup;
    }

    /**
     * @param selectionListValuesRadioButtonGroup the selectionListValuesRadioButtonGroup to set
     */
    public void setSelectionListValuesRadioButtonGroup(SingleSelectOptionsList selectionListValuesRadioButtonGroup) {
        this.selectionListValuesRadioButtonGroup = selectionListValuesRadioButtonGroup;
    }

    /**
     * @return the actualSelectionList
     */
    public ListTable getActualSelectionList() {
        return actualSelectionList;
    }

    /**
     * @param actualSelectionList the actualSelectionList to set
     */
    public void setActualSelectionList(ListTable actualSelectionList) {
        this.actualSelectionList = actualSelectionList;
    }

    /**
     * @return the actualSelectionListValue
     */
    public selectionListEntity getActualSelectionListValue() {
        return actualSelectionListValue;
    }

    /**
     * @param actualSelectionListValue the actualSelectionListValue to set
     */
    public void setActualSelectionListValue(selectionListEntity actualSelectionListValue) {
        this.actualSelectionListValue = actualSelectionListValue;
    }

       /**
     * @return the newSelectionListValue
     */
    public boolean isNewSelectionListValue() {
        return newSelectionListValue;
    }

    /**
     * @param newSelectionListValue the newSelectionListValue to set
     */
    public void setNewSelectionListValue(boolean newSelectionListValue) {
        this.newSelectionListValue = newSelectionListValue;
    }

    /**
     * @return the selectionListManager
     */
    public SelectionListManagerRemote getSelectionListManager() {
        return selectionListManager;
    }

    /**
     * @param selectionListManager the selectionListManager2 to set
     */
    public void setSelectionListManager(SelectionListManagerRemote selectionListManager) {
        this.selectionListManager = selectionListManager;
    }

    /**
     * @return the colectionManager
     */
    public CollectionRemote getColectionManager() {
        return colectionManager;
    }

    /**
     * @param colectionManager the colectionManager to set
     */
    public void setColectionManager(CollectionRemote colectionManager) {
        this.colectionManager = colectionManager;
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
