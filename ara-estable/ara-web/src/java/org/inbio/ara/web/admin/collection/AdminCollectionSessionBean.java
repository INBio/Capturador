/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.admin.collection;

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
import javax.faces.FacesException;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.converters.CollectionsConverter;
import org.inbio.ara.web.util.MessageBean;

/**
 *
 * Idealmente se intentará poner acá toda la funcionalidad que necesiten
 * los JSP's y que sea referente al manejo de administracion de collecciones. Esta clase
 * sería el convertidor entre el mundo del modelo y el mundo de lo que necesiten los jsp's
 * para funcionar.
 *
 * @author jgutierrez
 */
public class AdminCollectionSessionBean extends AbstractSessionBean {

    /**
     * Managers
     */
    @EJB
    private SelectionListManagerRemote selectionListManager;

    @EJB
    private CollectionRemote collectionManager;

    //SelectionListManagerRemote selectionListManager = lookupSelectionListManagerImpl();
    //CollectionRemote collectionManager = lookupColectionManagerImpl();

    /**
     * Variables
     */

    /** Fuentes de los datos de la tabla
     A la hora de inicializar esta variabe el constructor puede no recibir nada o recibir una Lista,
     entonces la idea es que se inicialice con un List<selectionListEntity> **/
    public ObjectListDataProvider selectionListValuesDataProvider = new ObjectListDataProvider();

    /** datos de los valores de la lista de seleccion **/
    private SingleSelectOptionsList collectionsRadioButtonGroup = new SingleSelectOptionsList();

    /** Datos del DropDown **/
    private SingleSelectOptionsList selectionListDropDownData = new SingleSelectOptionsList();

    /** Datos del AddDeleteComponent **/
    private MultipleSelectOptionsList associatedCollections = new MultipleSelectOptionsList();

    /* Colleccion seleccionada */
    private Collection actualCollection = null;
    /** determina si una colleccion debe actualizarse o crearse nueva!**/
    private boolean newCollection;

    /**
     * <p>Construct a new session data bean instance.</p>admi
     */
    public AdminCollectionSessionBean() {
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
     * Este metodo busca las colleciones las devuelve en formato de dataProvider
     * listos para ser empotrados en algun elemento de la GUI.
     *
     * @return
     */
    public void setAllCollections(){


        Option[] optionCollectionList = this.getCollectionConverter().getCollectionsInOptionArray();
        this.getCollectionsRadioButtonGroup().setOptions(optionCollectionList);

        List<Collection> collectionsList = collectionManager.listAllCollections();
/*
        List<Collection> collectionsList = collectionManager.listAllCollections();

        ArrayList<Option> allCollectionOptions = new ArrayList<Option>();
        Option[] collectionsInArray;
        Option option;

        for(Collection c : collectionsList){
            option = new Option(c.getId(), c.getName());
            allCollectionOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        collectionsInArray = new Option[allCollectionOptions.size()];
        this.getCollectionsRadioButtonGroup().setOptions(allCollectionOptions.toArray(collectionsInArray));
*/
        //define la coleccion que esta como seleccionada
        if(this.actualCollection  == null){
            this.setActualCollection(collectionsList.get(0));

        }
        this.getCollectionsRadioButtonGroup().setSelectedValue(this.actualCollection.getId());
    }

    /**
     * saves the collection object in the database
     *
     * if newCollection is true means that the key value should be ignored,
     *  in other words is a new collection. False for a update operations!
     */
    public void saveCollection(){

        if(this.newCollection){
            this.actualCollection.setId(null);
            //TODO: revisar como funciona este create...
            this.collectionManager.create(this.actualCollection);
        } else {
            //TODO: revisar como funciona este update...
            this.collectionManager.update(actualCollection);
            //this.selectionListManager.updateSelectionListValue(this.actualSelectionListValue);
        }
        
    }

    /**
     * Elmina la lista de seleccion actual
     */
    public void deleteCollection() throws IllegalArgumentException {
        try{
            //TODO: revisar como funciona este delete...
            this.collectionManager.deleteCollection(this.actualCollection.getId());
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 
     * @param selectionListId
     * @param selectionListValueId
     */
    void setEntitiesById(Long selectionListId, Long selectionListValueId) {

        //sets the Selection list
        //if(selectionListId == null)
        //    this.setActualSelectionList(null);
        //else
        //    this.setActualSelectionList(selectionListManager.getSelectionListById(selectionListId));

        //sets the selection list value
        //if(selectionListValueId == null)
        //    this.setActualSelectionListValue(null);
        //else
        //    this.setActualSelectionListValue(selectionListManager.getSelectionlistValueById(selectionListId, selectionListValueId));
    }


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
     * @return the newCollection
     */
    public boolean isNewCollection() {
        return newCollection;
    }

    /**
     * @param newCollection the newCollection to set
     */
    public void setNewCollection(boolean newCollection) {
        this.newCollection = newCollection;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionsConverter getCollectionConverter() {
        return (CollectionsConverter) getBean("CollectionsConverterBean");
    }

    /**
     * @return the collectionsRadioButtonGroup
     */
    public SingleSelectOptionsList getCollectionsRadioButtonGroup() {
        return collectionsRadioButtonGroup;
    }

    /**
     * @param collectionsRadioButtonGroup the collectionsRadioButtonGroup to set
     */
    public void setCollectionsRadioButtonGroup(SingleSelectOptionsList collectionsRadioButtonGroup) {
        this.collectionsRadioButtonGroup = collectionsRadioButtonGroup;
    }

    /**
     * @return the actualCollection
     */
    public Collection getActualCollection() {
        return actualCollection;
    }

    /**
     * @param actualCollection the actualCollection to set
     */
    public void setActualCollection(Collection actualCollection) {
        this.actualCollection = actualCollection;
    }

    public void setActualCollectionById(Long actualCollectionId){
        this.actualCollection = collectionManager.getCollection(actualCollectionId);
    }

    /**
     * @return the selectionListManager
     */
    public SelectionListManagerRemote getSelectionListManager() {
        return selectionListManager;
    }

    /**
     * @param selectionListManager the selectionListManager to set
     */
    public void setSelectionListManager(SelectionListManagerRemote selectionListManager) {
        this.selectionListManager = selectionListManager;
    }

    /**
     * @return the colectionManager
     */
    public CollectionRemote getColectionManager() {
        return collectionManager;
    }

    /**
     * @param colectionManager the colectionManager to set
     */
    public void setColectionManager(CollectionRemote colectionManager) {
        this.collectionManager = colectionManager;
    }

}
