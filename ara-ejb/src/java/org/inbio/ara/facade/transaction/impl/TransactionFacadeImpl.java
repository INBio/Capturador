/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.transaction.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.facade.transaction.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.agent.InstitutionDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTOFactory;
import org.inbio.ara.dto.transaction.TransactionDTO;
import org.inbio.ara.dto.transaction.TransactionDTOFactory;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.eao.identification.impl.IdentificationEAOImpl;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.eao.transaction.TransactedSpecimenEAOLocal;
import org.inbio.ara.eao.transaction.TransactedSpecimenStatusEAOLocal;
import org.inbio.ara.eao.transaction.TransactionEAOLocal;
import org.inbio.ara.eao.transaction.TransactionTypeEAOLocal;
import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonInstitutionPK;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.transaction.TransactedSpecimen;
import org.inbio.ara.persistence.transaction.TransactedSpecimenPK;
import org.inbio.ara.persistence.transaction.TransactedSpecimenStatus;
import org.inbio.ara.persistence.transaction.Transaction;
import org.inbio.ara.persistence.transaction.TransactionType;

/**
 *
 * @author echinchilla
 */
@Stateless
public class TransactionFacadeImpl implements TransactionFacadeRemote {

    @EJB
    private TransactionEAOLocal transactionEAOImpl;

    @EJB
    private TransactedSpecimenEAOLocal transactedSpecimenEAOImpl;

    @EJB
    private PersonEAOLocal personEAOImpl;

    @EJB
    private InstitutionEAOLocal insitutionEAOImpl;

    @EJB
    private CollectionEAOLocal collectionEAOImpl;

    @EJB
    private TransactionTypeEAOLocal transactionTypeEAOImpl;

    @EJB
    private TransactedSpecimenStatusEAOLocal transactedSpecimenStatusEAOImpl;

    @EJB
    private SpecimenEAOLocal specimenEAOImpl;

    @EJB
    private SelectionListValueLocalEAO selectionListValueEAOImpl;

    @EJB
    private IdentificationEAOLocal identificationEAOImpl;

    private TransactionDTOFactory transactionDTOFactory = 
            new TransactionDTOFactory();

    private TransactedSpecimenDTOFactory transactedSpecimenDTOFactory =
            new TransactedSpecimenDTOFactory();

    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();

    private InstitutionDTOFactory institutionDTOFactory = new InstitutionDTOFactory();

    private SelectionListDTOFactory selecionListDTOFactory =
            new SelectionListDTOFactory();

    public Long countTransaction(Long collectionId) {
        return this.transactionEAOImpl.countTransactionByCollecionId(collectionId);
    }

    public Long countTransactedSpecimen(Long transactionId) {
        return this.transactedSpecimenEAOImpl.countTransactedSpecimenByTransactionId(transactionId);
    }

    /**
     * Retrive all people paginated
     * @return
     */
    public List<TransactionDTO> getAllTransactionPaginated(int firstResult, int maxResults, Long collectionId) {
        String[] orderByFields = {"transactionId"};
        List<TransactionDTO> result = transactionDTOFactory.createDTOList(transactionEAOImpl.
                findAllPaginatedFilterAndOrderBy(Transaction.class, firstResult, maxResults, orderByFields,collectionId));
        if (result == null) {
            return null;
        }
        List<TransactionDTO> update = updateNames(result);
        return update;
        //return transactionDTOFactory.createDTOList(transactionEAOImpl.
          //      findAllPaginated(Transaction.class, firstResult, maxResults));
    }

    /**
     * Retrive all people paginated
     * @return
     */
    public List<TransactedSpecimenDTO> getAllTransactedSpecimenPaginated(int firstResult, int maxResults, Long transactionId) {
        List<TransactedSpecimenDTO> result = transactedSpecimenDTOFactory.createDTOList(transactedSpecimenEAOImpl.
        getTransactedSpecimenByTransactionIdPaginated(firstResult, maxResults, transactionId));
        if (result == null) {
            return null;
        }

        return getReadOnlyFields(result);
        //return getSpecimenTaxon(update);
        //return transactionDTOFactory.createDTOList(transactionEAOImpl.
        //      findAllPaginated(Transaction.class, firstResult, maxResults));
    }

    /**
     *
     * Función que llena los campos read-only para cada espécimen transado
     *
     * @param tsDTOList
     * @return
     */
    public List<TransactedSpecimenDTO>
            getReadOnlyFields(List<TransactedSpecimenDTO> tsDTOList) {

        List<TransactedSpecimenDTO> resultTransactedSpecimenDTOList = new ArrayList<TransactedSpecimenDTO>();
        TransactedSpecimenDTO auxDTO;
        for (TransactedSpecimenDTO tsDTO : tsDTOList) {
            auxDTO = getCatalogNumber(tsDTO);
            auxDTO = getSpecimenTaxon(auxDTO);
            auxDTO = getTransactedSpecimenStatus(auxDTO);
            resultTransactedSpecimenDTOList.add(auxDTO);
        }
        return resultTransactedSpecimenDTOList;
    }

    /**
     * To update the scientificName
     * @param list
     * @return
     */
    public List<TransactedSpecimenDTO> getSpecimenTaxon(List<TransactedSpecimenDTO> list) {
        List<TransactedSpecimenDTO> result = new ArrayList<TransactedSpecimenDTO>();
        for (TransactedSpecimenDTO dto : list) {
            String taxones = "";

            List<Identification> identificaciones = this.identificationEAOImpl.
            findBySpecimenId(dto.getTransactedSpecimenPK().getSpecimenId());
            for (int i = 1; i <= identificaciones.size(); i++) {
                Identification aux = identificaciones.get(i - 1);
                if (i == identificaciones.size()) {
                    taxones += aux.getTaxon().getDefaultName();
                }
                else {
                    taxones += aux.getTaxon().getDefaultName() + " , ";
                }
            }
            dto.setTaxonName(taxones);
            result.add(dto);
        }
        return result;
    }

    /**
     *
     * Función que trae el nombre del taxón asociado a un SpecimenId
     *
     * @param tsDTO
     * @return
     */
    public TransactedSpecimenDTO getSpecimenTaxon(TransactedSpecimenDTO tsDTO) {
        String taxones = "";

        List<Identification> identificaciones = this.identificationEAOImpl.
        findBySpecimenId(tsDTO.getTransactedSpecimenPK().getSpecimenId());
        for (int i = 1; i <= identificaciones.size(); i++) {
            Identification aux = identificaciones.get(i - 1);
            if (i == identificaciones.size()) {
                taxones += aux.getTaxon().getDefaultName();
            }
            else {
                taxones += aux.getTaxon().getDefaultName() + " , ";
            }
        }
        tsDTO.setTaxonName(taxones);
        return tsDTO;
    }

    /**
     *
     * Función que trae el CatalogNumber asociado a un SpecimenId
     *
     * @param transactedSpecimenDTO
     * @return
     */
    public TransactedSpecimenDTO getCatalogNumber(TransactedSpecimenDTO transactedSpecimenDTO) {

        Specimen specimen;
        specimen = this.specimenEAOImpl.findById(Specimen.class, transactedSpecimenDTO.getTransactedSpecimenPK().getSpecimenId());
        transactedSpecimenDTO.setCatalogNumber(specimen.getCatalogNumber());
        return transactedSpecimenDTO;
    }

    /**
     *
     * Función que trae el nombre asociado a un id de TransactedSpecimenStatus
     * 
     * @param transactedSpecimenDTO
     * @return
     */
    public TransactedSpecimenDTO getTransactedSpecimenStatus(TransactedSpecimenDTO transactedSpecimenDTO) {

        TransactedSpecimenStatus transactedSpecimenStatus;
        transactedSpecimenStatus = this.transactedSpecimenStatusEAOImpl.findById(TransactedSpecimenStatus.class,
                transactedSpecimenDTO.getTransactedSpecimenStatusId());
        transactedSpecimenDTO.setTransactedSpecimenStatus(transactedSpecimenStatus.getName());
        return transactedSpecimenDTO;
    }

    /**
     * Metodo para eliminar Transacciones por su id
     * @param Id
     */
    public void deleteTransaction(Long transactionId) {
        Transaction aux = this.transactionEAOImpl.findById(Transaction.class, transactionId);
        if (aux != null) {
            this.transactionEAOImpl.delete(aux);
        }
    }

    /**
     * 
     * Método para eliminar una lista de especímenes transados
     * 
     * @param selectedTransactedSpecimens
     */
    public void deleteTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens) {
        Long transactionId;
        Long specimenId;
        for (TransactedSpecimenDTO tsDTO: selectedTransactedSpecimens) {
            transactionId = tsDTO.getTransactedSpecimenPK().getTransactionId();
            specimenId = tsDTO.getTransactedSpecimenPK().getSpecimenId();
            this.transactedSpecimenEAOImpl.deleteTransactedSpecimen(transactionId, specimenId);
        }
    }

    /**
     *
     * Método para editar una lista de especímenes transados.
     *
     * @param selectedTransactedSpecimens
     * @param tDTO
     */
    public void editTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens, TransactedSpecimenDTO tDTO) {
        Long transactionId;
        Long specimenId;
        for (TransactedSpecimenDTO tsDTO: selectedTransactedSpecimens) {
            transactionId = tsDTO.getTransactedSpecimenPK().getTransactionId();
            specimenId = tsDTO.getTransactedSpecimenPK().getSpecimenId();
            tDTO.setTransactedSpecimenPK(new TransactedSpecimenPK(specimenId, transactionId));
            TransactedSpecimen transactedSpecimenEntity = this.transactedSpecimenEAOImpl.getTransactedSpecimenById(transactionId, specimenId).get(0);
            transactedSpecimenEntity =  this.transactedSpecimenDTOFactory.updateEntityWithPlainValues(tDTO, transactedSpecimenEntity);
            this.transactedSpecimenEAOImpl.update(transactedSpecimenEntity);
        }

    }

    /**
     *
     * @param transactionDTO
     * @return
     */
    public TransactionDTO updateNames(TransactionDTO transactionDTO) {
        Person senderPerson, receiverPerson;
        Institution senderInstitution, receiverInstitution;
        Collection collection;
        TransactionType transactionType;

        senderPerson = this.personEAOImpl.findById(Person.class, transactionDTO.getSenderPersonId());
        transactionDTO.setSenderPersonName(senderPerson.getNaturalLongName());

        if (transactionDTO.getReceiverPersonId() != null) {
            receiverPerson = this.personEAOImpl.findById(Person.class, transactionDTO.getReceiverPersonId());
            transactionDTO.setReceiverPersonName(receiverPerson.getNaturalLongName());
        }
        if (transactionDTO.getSenderInstitutionId() != null) {
            senderInstitution = this.insitutionEAOImpl.
                    findById(Institution.class, transactionDTO.getSenderInstitutionId());
            transactionDTO.setSenderInstitutionName(senderInstitution.getInstitutionCode());
        }
        else { // PARA EL CASO DE 'SIN INSTITUCION ASOCIADA'
            transactionDTO.setSenderInstitutionId(new Long(-1));
        }
        if (transactionDTO.getReceiverInstitutionId() != null) {
            receiverInstitution = this.insitutionEAOImpl.
                    findById(Institution.class, transactionDTO.getReceiverInstitutionId());
            transactionDTO.setReceiverInstitutionName(receiverInstitution.getInstitutionCode());
        }
        else {
            if (transactionDTO.getReceiverPersonId() != null) { // PARA EL CASO DE 'SIN INSTITUCION ASOCIADA'
                transactionDTO.setReceiverInstitutionId(new Long(-1));
            }
                
        }



        collection = this.collectionEAOImpl.findById(Collection.class, transactionDTO.getCollectionId());
        transactionDTO.setCollectionName(collection.getName());
        
        transactionType = this.transactionTypeEAOImpl.
                findById(TransactionType.class, transactionDTO.getTransactionTypeId());
        transactionDTO.setTransactionType(transactionType.getName());
        return transactionDTO;
    }

    public List<TransactionDTO>
            updateNames(List<TransactionDTO> tDTOList) {

        List<TransactionDTO> resultTransactionDTOList = new ArrayList<TransactionDTO>();

        for (TransactionDTO tDTO : tDTOList) {
            resultTransactionDTOList.add(updateNames(tDTO));
        }
        return resultTransactionDTOList;
    }

    /**
     * Metodo para auctualizar una transaccion
     * @param tDTO
     * @return
     */
    public void updateTransaction(TransactionDTO tDTO) {
        if(tDTO.getSenderInstitutionId() != null &&
           tDTO.getSenderInstitutionId() == -1)
            tDTO.setSenderInstitutionId(null);
        if(tDTO.getReceiverInstitutionId() != null &&
           tDTO.getReceiverInstitutionId() == -1)
            tDTO.setReceiverInstitutionId(null);

        Transaction transactionEntity = this.transactionEAOImpl.findById(Transaction.class, tDTO.
                getTransactionId());
        transactionEntity = this.transactionDTOFactory.updatePlainEntity(tDTO, transactionEntity);
        this.transactionEAOImpl.update(transactionEntity);
    }

    /**
     * @param selectionListEntityId
     * @param collectionId
     * @return
     */
    /*public List<SelectionListDTO>
    getAllSelectionListElementsByCollection(Long selectionListEntityId,
    Long collectionId) {
    List<SelectionListGenericEntity> slgeList = selectionListValueEAOImpl.
    findAllByCollectionId(selectionListEntityId, collectionId);
    return this.selecionListDTOFactory.createDTOList(slgeList);
    }*/

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        if(transactionDTO.getSenderInstitutionId() != null &&
           transactionDTO.getSenderInstitutionId() == -1)
            transactionDTO.setSenderInstitutionId(null);
        if(transactionDTO.getReceiverInstitutionId() != null &&
           transactionDTO.getReceiverInstitutionId() == -1)
            transactionDTO.setReceiverInstitutionId(null);

        Transaction entity = this.transactionDTOFactory.createPlainEntity(transactionDTO);
        this.transactionEAOImpl.create(entity);
        TransactionDTO aux = this.transactionDTOFactory.createDTO(entity);
        
        // PARA EL CASO DE 'SIN INSTITUCION ASOCIADA'
        if(aux.getSenderInstitutionId() == null)
            aux.setSenderInstitutionId(new Long(-1));
        if(aux.getReceiverInstitutionId() == null && aux.getReceiverPersonId() != null)
            aux.setReceiverInstitutionId(new Long(-1));
        return aux;
    }

    public TransactedSpecimenDTO
            saveTransactedSpecimen(TransactionDTO transactionDTO, TransactedSpecimenDTO transactedSpecimenDTO, String createdBy) {
        Long specimenId = getSpecimenIdByCatalogNumber(transactedSpecimenDTO.getCatalogNumber());
        
        transactedSpecimenDTO.setTransactedSpecimenPK(new TransactedSpecimenPK(specimenId, transactionDTO.getTransactionId()));
        transactedSpecimenDTO.setUserName(createdBy);
        transactedSpecimenDTO.setTransactionTypeId(transactionDTO.getTransactionTypeId());

        TransactedSpecimen entity = this.transactedSpecimenDTOFactory.createPlainEntity(transactedSpecimenDTO);
        this.transactedSpecimenEAOImpl.create(entity);
        return this.transactedSpecimenDTOFactory.createDTO(entity);
    }

    public List<PersonDTO> getPersonsByInstitutionId(Long institutionId) {
        if (institutionId == null || institutionId != -1)
        //if (institutionId != -1)
            return personDTOFactory.createDTOList(transactionEAOImpl.
                getPersonsByInstitution(institutionId));
        else
            return personDTOFactory.createDTOList(transactionEAOImpl.
                getPersonsWithoutInstitution());
    }

    /**
     *
     * @return Lista de todas las instituciones registradas en el sistema
     */
    public List<InstitutionDTO> getAllInstitutions() {
        return institutionDTOFactory.createDTOList(transactionEAOImpl.getAllInstitutions());
    }

    public List<PersonDTO> getPersonsWithoutInstitution() {
        return personDTOFactory.createDTOList(transactionEAOImpl.
                getPersonsWithoutInstitution());
    }

    public Long getSpecimenIdByCatalogNumber (String catalogNumber) {
        return specimenEAOImpl.findByCatalogNumber(catalogNumber);
    }
 
}
