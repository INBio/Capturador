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

package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.taxonomy.LanguageDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.util.AddRemoveList;
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
 * @version SpeciesSessionBean.java
 * @version Created on 13/10/2009, 03:04:32 PM
 * @author esmata
 */

public class SpeciesSessionBean extends AbstractSessionBean 
implements Serializable, PaginationCoreInterface {
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
    private TaxonomyFacadeRemote taxonomyFacadeImpl;
    @EJB
    private AdminFacadeRemote adminFacadeImpl;

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;
    

    //Cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos

    //Current DTO para la pantalla de edicion
    private TaxonDescriptionDTO currentTaxDescripDTO = new TaxonDescriptionDTO();
    private Long selectedScientificName = null;
    private Long selectedLanguage = null;
    private Long selectedStatus = null;
    private Long selectedInstitution = null;
    //Usados para manipular el arbol de plinian core
    private Long currentTaxonDescriptionCategoryId;
    private boolean categoryRepeatable = false;
    public TaxonDescriptionRowDataProvider taxonDescriptionRowDataProvider;
    private Long selectedTaxonDescriptionRecordSequence;
    private Long[] selectedReference = new Long[]{};
    private boolean isDynamicFormPanelActive = false;

    //Objeto AddRemoveList para manejar los valores del tab de audiencias (ventana edit)
    private AddRemoveList arAudiences = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de autores (ventana edit)
    private AddRemoveList arAuthors = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de instituciones (ventana edit)
    private AddRemoveList arInstitutions = new AddRemoveList();

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
    public SpeciesSessionBean() {
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
            log("SpeciesSessionBean Initialization Failure", e);
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

    public TaxonDescriptionRowDataProvider getTaxonDescriptionRowDataProvider() {
        return this.taxonDescriptionRowDataProvider;
    }

    public TaxonDescriptionRowDataProvider getTaxonDescriptionRowDataProvider
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        this.setTaxonDescriptionRowDataProvider
                (new TaxonDescriptionRowDataProviderImpl(categoryId,taxonId, taxonDescriptionSequence));
        return this.getTaxonDescriptionRowDataProvider();
    }

    public void setTaxonDescriptionRowDataProvider
            (TaxonDescriptionRowDataProvider taxonDescriptionRowDataProvider) {
        this.taxonDescriptionRowDataProvider = taxonDescriptionRowDataProvider;
    }

    public void initTaxonDescriptionRowDataProvider
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        this.setTaxonDescriptionRowDataProvider
                (new TaxonDescriptionRowDataProviderImpl(categoryId,taxonId, taxonDescriptionSequence));
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public List<InstitutionDTO> SetInstitutionDropDownData(){
         return this.adminFacadeImpl.getAllInstitutions();
    }

    /**
     * Metodo que retorna la lista completa de audiencias sin paginar
     */
    public List<AudienceDTO> getAllAudiences(){
        return adminFacadeImpl.getAllAudiences();
    }

    /**
     * Obtener nombre de una especie especifica
     * @return
     */
    public String getSpeciesNameById(Long entityId){
        return taxonomyFacadeImpl.getSpeciesNameById(entityId);
    }

    /**
     * Retrive all people who have species record author profile
     */
    public List<PersonDTO> getAllSpeciesRecordAuthors() {
        return taxonomyFacadeImpl.getAllSpeciesRecordAuthors();
    }

    /**
     * Metodo que retorna la lista completa de instituciones
     */
    public List<InstitutionDTO> getAllInstitutions(){
        return adminFacadeImpl.getAllInstitutions();
    }

    /**
     * Metodo que retorna las categorias correspondientes para un ancestro dato
     * @return
     */
    public List<TaxonDescriptionCategoryDTO> getTaxonDescriptionsByAncestorId
            (Long ancestor){
        return this.getTaxonomyFacadeImpl().getTaxonDescriptionsByAncestorId(ancestor);
    }

    public List getTaxonDescriptionRowList
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        return getTaxonDescriptionCategoryRows
                (categoryId, taxonId, taxonDescriptionSequence);
    }

    public List getTaxonDescriptionCategoryRows
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        Long[] elements = new Long[]{};
        Long[] rows = new Long[]{};
        Long currentRow, currentElement;
        TaxonDescriptionRow newRow;
        List tList;
        String currentValue;

        // Id's de los elementos de la categoria seleccionada
        elements = this.getTaxonDescriptionElements(categoryId);
        // Obtener el arreglo con las secuencias de los elementos
        rows = this.getTaxonDescriptionRows
                (categoryId, taxonId, taxonDescriptionSequence);
        tList = new ArrayList();
        if (elements.length > 0) {
            if (rows.length > 0) {
                for (int i=0; i < rows.length; i++) {
                    currentRow = rows[i];
                    newRow = new TaxonDescriptionRow();
                    newRow.setRowId(currentRow);
                    for (int p = 0; p < elements.length; p++) {
                        currentElement = elements[p];
                        currentValue = getTaxonDescriptionRecordValue
                                (taxonId, taxonDescriptionSequence, currentElement, currentRow);
                        //FIXME: currentRow siempre va en 1
                        newRow = this.getTaxonDescriptionRow(p,currentValue,newRow);
                    }
                    tList.add(newRow);
                }
                return tList;
            } else {
                //No hay valores
                return null;
            }
        } else {
            //No hay elementos definidos para la categoria
            return null;
        }
    }

    private Long[] getTaxonDescriptionElements(Long categoryId) {
        Long[] elements = new Long[]{};
        List<TaxonDescriptionElementDTO> elementList;
        try {
            elementList = this.getTaxonomyFacadeImpl().
                    getTDElementsByCategoryId(categoryId);
            if (elementList.size() > 0) {
                elements = new Long[elementList.size()];
                int i = 0;
                for (TaxonDescriptionElementDTO element: elementList) {
                    elements[i] = element.getTaxonDescriptionElementId();
                    i++;
                }
            }
        } catch (NoResultException noResultEx) {
            //No se encontraron descripciones para los valores dados.
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            //La consulta produjo m�s de un resultado
            return null;
        } catch (IllegalStateException stateException) {
            //Se produjo un llamado a INSERT o UPDATE
            return null;
        }
        return elements;
    }

    private TaxonDescriptionRow getTaxonDescriptionRow
            (int elementIndex, String value, TaxonDescriptionRow refRow) {
        TaxonDescriptionRow newRow = refRow;
        switch ( elementIndex ) {
        case 0:
           newRow.setValue1(value);
           break;
        case 1:
           newRow.setValue2(value);
           break;
        case 2:
           newRow.setValue3(value);
           break;
        case 3:
           newRow.setValue4(value);
           break;
        case 4:
           newRow.setValue5(value);
           break;
        case 5:
           newRow.setValue6(value);
           break;
        case 6:
           newRow.setValue7(value);
           break;
        case 7:
           newRow.setValue8(value);
           break;
        case 8:
           newRow.setValue9(value);
           break;
        case 9:
           newRow.setValue10(value);
           break;
        case 10:
           newRow.setValue11(value);
           break;
        case 11:
           newRow.setValue12(value);
           break;
        case 12:
           newRow.setValue13(value);
           break;
        case 13:
           newRow.setValue14(value);
           break;
        case 14:
           newRow.setValue15(value);
           break;
        case 15:
           newRow.setValue16(value);
           break;
        case 16:
           newRow.setValue17(value);
           break;
        case 17:
           newRow.setValue18(value);
           break;
        case 18:
           newRow.setValue19(value);
           break;
        case 19:
           newRow.setValue20(value);
           break;
        }
        return newRow;
    }

    private Long[] getTaxonDescriptionRows
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        Long[] rows = new Long[]{};

        List<Long> recordList;
        try {
            recordList = this.getTaxonomyFacadeImpl().getTaxonDescriptionRows
                    (categoryId, taxonId, taxonDescriptionSequence);
            if (recordList.size() > 0) {
                rows = new Long[recordList.size()];
                int i = 0;

                for (Long record: recordList) {
                    //rows[i] = record.getSequence();
                    rows[i] = record;
                    i++;
                }
            }
        } catch (NoResultException noResultEx) {
            //No se encontraron descripciones para los valores dados.
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            //La consulta produjo más de un resultado
            return null;
        } catch (IllegalStateException stateException) {
            //Se produjo un llamado a INSERT o UPDATE
            return null;
        }
        return rows;
    }

    private String getTaxonDescriptionRecordValue
            (Long taxonId, Long taxonDescriptionSequence, Long elementId, Long sequence) {
        String value = "";
        TaxonDescriptionRecordDTO record =
                this.getTaxonomyFacadeImpl().getTaxonDescriptionRecord
                (taxonId, taxonDescriptionSequence, elementId, sequence);
        if (record != null) {
            if (record.getContentsText() != null) {
                if (!record.getContentsText().equals("")) {
                    value = record.getContentsText();
                    if (value.length() > 50) {
                        value = value.substring(0,46) + "...";
                    }
                    return value;
                }
            }
            /**
             * Para los valores numéricos, se obtienen directamente y luego se convierten a una hilera
             **/
            TaxonDescriptionElementDTO element = this.getTaxonomyFacadeImpl().getElementById
                    (record.getTaxonDescriptionElementId());
            String mainFieldName = null,keyField = null,tableName=null;
            if(element!=null){
                mainFieldName = element.getMainFieldName();
                keyField = element.getKeyField();
                tableName = element.getTableName();
            }

            if ((record.getContentsNumeric() != null) &&
                    (mainFieldName == null)) {
                value = record.getContentsNumeric().toString();
                return value;
            }

            if (tableName != null) {
                String tempValue = this.getTaxonomyFacadeImpl().
                        getTaxonDescriptionRecordValue(mainFieldName, tableName, keyField, record.getContentsNumeric().toString());
                value = tempValue;
                return value;
            }
        } else {
            value = "";
        }
        return value;
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
     * Obtener taxones de especies, subespecies, variedad y forma
     * @return
     */
    public List<TaxonDTO> getAllSpecies(){
        return this.getTaxonomyFacadeImpl().getAllSpecies();
    }

    /**
     * Obtener los distintos idiomas disponibles
     * @return
     */
    public List<LanguageDTO> getAllLanguages(){
        return this.taxonomyFacadeImpl.getAllLanguages();
    }

    /**
     * Obtener todos los estados posibles para la creacion de
     * nuevos registros de especies
     * @return
     */
    public List<TaxonDescriptionStageDTO> getAllTaxonDescriptionStages(){
        return this.taxonomyFacadeImpl.getAllTaxonDescriptionStages();
    }

    /**
     * Metodo para persistir un nuevo registro de especie
     */
    public void saveTaxonDescription(){
        this.taxonomyFacadeImpl.saveTaxonDescription
                (this.getCurrentTaxDescripDTO());
    }

    /**
     * Metodo para persistir los cambios realizados a un taxon description
     */
    public void updateTaxonDescription(){
        TaxonDescriptionDTO result = this.getTaxonomyFacadeImpl().updateTaxonDescription
                (this.getCurrentTaxDescripDTO(),
                this.getArAudiences().getSelectedOptions(),
                this.getArAuthors().getSelectedOptions(),
                this.getArInstitutions().getSelectedOptions());
        this.setCurrentTaxDescripDTO(result);
    }

    /**
     * Metodo para eliminar registros de especies por su id
     * @param Id
     */
    public void deleteTaxonDescription(Long taxonId,Long sequenceId){
        this.taxonomyFacadeImpl.deleteTaxonDescription(taxonId,sequenceId);
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
     * @return the taxonomyFacadeImpl
     */
    public TaxonomyFacadeRemote getTaxonomyFacadeImpl() {
        return taxonomyFacadeImpl;
    }

    /**
     * @param taxonomyFacadeImpl the taxonomyFacadeImpl to set
     */
    public void setTaxonomyFacadeImpl(TaxonomyFacadeRemote taxonomyFacadeImpl) {
        this.taxonomyFacadeImpl = taxonomyFacadeImpl;
    }

    /**
     * Inicializar el data provider
     */
    public void initDataProvider() {
        setPagination(new PaginationControllerRemix(this.getTaxonomyFacadeImpl().countTaxonDescriptions().intValue(), getQuantity(), this));
    }

    /**
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  " +
                "| "+totalResults+"  ";
    }

    /**
     * @return the currentTaxDescripDTO
     */
    public TaxonDescriptionDTO getCurrentTaxDescripDTO() {
        this.currentTaxDescripDTO.setUserName
                (this.getAraSessionBean().getGlobalUserName());
        return currentTaxDescripDTO;
    }

    /**
     * @param currentTaxDescripDTO the currentTaxDescripDTO to set
     */
    public void setCurrentTaxDescripDTO(TaxonDescriptionDTO currentTaxDescripDTO) {
        this.currentTaxDescripDTO = currentTaxDescripDTO;
    }

    /**
     * @return the selectedScientificName
     */
    public Long getSelectedScientificName() {
        return selectedScientificName;
    }

    /**
     * @param selectedScientificName the selectedScientificName to set
     */
    public void setSelectedScientificName(Long selectedScientificName) {
        this.selectedScientificName = selectedScientificName;
    }

    /**
     * @return the selectedLanguage
     */
    public Long getSelectedLanguage() {
        return selectedLanguage;
    }

    /**
     * @param selectedLanguage the selectedLanguage to set
     */
    public void setSelectedLanguage(Long selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    /**
     * @return the selectedStatus
     */
    public Long getSelectedStatus() {
        return selectedStatus;
    }

    /**
     * @param selectedStatus the selectedStatus to set
     */
    public void setSelectedStatus(Long selectedStatus) {
        this.selectedStatus = selectedStatus;
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
     * @return the arAudiences
     */
    public AddRemoveList getArAudiences() {
        return arAudiences;
    }

    /**
     * @param arAudiences the arAudiences to set
     */
    public void setArAudiences(AddRemoveList arAudiences) {
        this.arAudiences = arAudiences;
    }

    /**
     * @return the arAuthors
     */
    public AddRemoveList getArAuthors() {
        return arAuthors;
    }

    /**
     * @param arAuthors the arAuthors to set
     */
    public void setArAuthors(AddRemoveList arAuthors) {
        this.arAuthors = arAuthors;
    }

    /**
     * @return the arInstitutions
     */
    public AddRemoveList getArInstitutions() {
        return arInstitutions;
    }

    /**
     * @param arInstitutions the arInstitutions to set
     */
    public void setArInstitutions(AddRemoveList arInstitutions) {
        this.arInstitutions = arInstitutions;
    }

    /**
     * @return the currentTaxonDescriptionCategoryId
     */
    public Long getCurrentTaxonDescriptionCategoryId() {
        return currentTaxonDescriptionCategoryId;
    }

    /**
     * @param currentTaxonDescriptionCategoryId the currentTaxonDescriptionCategoryId to set
     */
    public void setCurrentTaxonDescriptionCategoryId(Long currentTaxonDescriptionCategoryId) {
        this.currentTaxonDescriptionCategoryId = currentTaxonDescriptionCategoryId;
    }

    /**
     * @return the categoryRepeatable
     */
    public boolean isCategoryRepeatable() {
        return categoryRepeatable;
    }

    /**
     * @param categoryRepeatable the categoryRepeatable to set
     */
    public void setCategoryRepeatable(boolean categoryRepeatable) {
        this.categoryRepeatable = categoryRepeatable;
    }

    /**
     * @return the selectedTaxonDescriptionRecordSequence
     */
    public Long getSelectedTaxonDescriptionRecordSequence() {
        return selectedTaxonDescriptionRecordSequence;
    }

    /**
     * @param selectedTaxonDescriptionRecordSequence the selectedTaxonDescriptionRecordSequence to set
     */
    public void setSelectedTaxonDescriptionRecordSequence(Long selectedTaxonDescriptionRecordSequence) {
        this.selectedTaxonDescriptionRecordSequence = selectedTaxonDescriptionRecordSequence;
    }

    public Long[] getSelectedReference() {
        return selectedReference;
    }

    public void setSelectedReference(Long[] selectedReference) {
        this.selectedReference = selectedReference;
    }

    public void getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId) {
        this.setSelectedReference(taxonomyFacadeImpl.
                getTaxonDescriptionRecordReference(taxonDescriptionRecordId));
    }

    public boolean isIsDynamicFormPanelActive() {
        return isDynamicFormPanelActive;
    }

    public void setIsDynamicFormPanelActive(boolean isDynamicFormPanelActive) {
        this.isDynamicFormPanelActive = isDynamicFormPanelActive;
    }

    public boolean deleteTaxonDescriptionRecordRow(Long rowId) {
        Long taxonDescriptionSequence = this.currentTaxDescripDTO.
                getTaxonDescriptionSequence();
        Long taxonId = this.currentTaxDescripDTO.getTaxonId();
        if (this.taxonomyFacadeImpl.
                deleteTaxonDescriptionRecordRow
                (taxonDescriptionSequence, taxonId, rowId)) {
            return true;
        } else {
            return false;
        }
    }

    public Long getNextSequence() {
        Long sequence = 0L;
        Long taxonId = this.currentTaxDescripDTO.getTaxonId();
        Long taxonDescriptionSequence = this.currentTaxDescripDTO.getTaxonDescriptionSequence();
        sequence = this.getTaxonomyFacadeImpl().
                getNextTaxonDescriptionRecordSequence
                (taxonDescriptionSequence, taxonId);
        return sequence;
    }

    /**
     * @return the selectedInstitution
     */
    public Long getSelectedInstitution() {
        return selectedInstitution;
    }

    /**
     * @param selectedInstitution the selectedInstitution to set
     */
    public void setSelectedInstitution(Long selectedInstitution) {
        this.selectedInstitution = selectedInstitution;
    }

    public List getResults(int firstResult, int maxResults) {
        return taxonomyFacadeImpl.getAllTaxonDescriptionPaginated(firstResult, maxResults);
    }

    private class TaxonDescriptionRowDataProviderImpl
            extends TaxonDescriptionRowDataProvider
            implements Serializable{

        public TaxonDescriptionRowDataProviderImpl() {
            super();
        }

        public TaxonDescriptionRowDataProviderImpl(Long categoryId, Long taxonId,
                Long taxonDescriptionSequence) {
            super(categoryId, taxonId, taxonDescriptionSequence);
        }

        @Override
        public void refreshDataList
                (Long categoryId, Long taxonId, Long taxonDescriptionSequenceId) {
            this.setList(getTaxonDescriptionRowList
                    (categoryId, taxonId, taxonDescriptionSequenceId));
        }
    }
    
}
