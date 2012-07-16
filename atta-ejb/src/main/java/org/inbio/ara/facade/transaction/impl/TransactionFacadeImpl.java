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

package org.inbio.ara.facade.transaction.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.facade.transaction.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.agent.InstitutionDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTOFactory;
import org.inbio.ara.dto.transaction.TransactionDTO;
import org.inbio.ara.dto.transaction.TransactionDTOFactory;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.eao.transaction.TransactedSpecimenEAOLocal;
import org.inbio.ara.eao.transaction.TransactedSpecimenStatusEAOLocal;
import org.inbio.ara.eao.transaction.TransactionEAOLocal;
import org.inbio.ara.eao.transaction.TransactionTypeEAOLocal;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
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

    /*@EJB
    private SelectionListValueLocalEAO selectionListValueEAOImpl;*/

    @EJB
    private IdentificationEAOLocal identificationEAOImpl;

    private TransactionDTOFactory transactionDTOFactory = 
            new TransactionDTOFactory();

    private TransactedSpecimenDTOFactory transactedSpecimenDTOFactory =
            new TransactedSpecimenDTOFactory();

    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();

    private InstitutionDTOFactory institutionDTOFactory = new InstitutionDTOFactory();

    /*private SelectionListDTOFactory selecionListDTOFactory =
    new SelectionListDTOFactory();*/

    /**
     * Cuenta las transacciones asociadas a una colección
     * @param collectionId
     * @return
     */
    public Long countTransaction(Long collectionId) {
        return this.transactionEAOImpl.countTransactionByCollecionId(collectionId);
    }

    /**
     * Cuenta los especímenes transados asociados a una transacción
     * @param transactionId
     * @return
     */
    public Long countTransactedSpecimen(Long transactionId) {
        return this.transactedSpecimenEAOImpl.countTransactedSpecimenByTransactionId(transactionId);
    }

    /**
     * Retrive all transactions paginated
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
    }

    /**
     * Retrive all transacted specimens paginated
     * @return
     */
    public List<TransactedSpecimenDTO> getAllTransactedSpecimenPaginated(int firstResult, int maxResults, Long transactionId) {
        List<TransactedSpecimenDTO> result = transactedSpecimenDTOFactory.createDTOList(transactedSpecimenEAOImpl.
        getTransactedSpecimenByTransactionIdPaginated(firstResult, maxResults, transactionId));
        if (result == null) {
            return null;
        }
        return getReadOnlyFields(result);
    }

    /**
     * Función que llena los campos read-only para cada espécimen transado
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
     * Función que trae el nombre del taxón asociado a un SpecimenId
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
     * Función que trae el CatalogNumber asociado a un SpecimenId
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
     * Función que trae el nombre asociado a un id de TransactedSpecimenStatus
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
     * Método para eliminar una lista de especímenes transados
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
     * Método para editar una lista de especímenes transados.
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
            tDTO.setCrationDateAndTime(tsDTO.getCrationDateAndTime());
            tDTO.setWaitingForReturn(tsDTO.getWaitingForReturn());
            TransactedSpecimen transactedSpecimenEntity = this.transactedSpecimenEAOImpl.getTransactedSpecimenById(transactionId, specimenId).get(0);
            transactedSpecimenEntity =  this.transactedSpecimenDTOFactory.updateEntityWithPlainValues(tDTO, transactedSpecimenEntity);
            this.transactedSpecimenEAOImpl.update(transactedSpecimenEntity);
        }
    }

    /**
     * Método para la devolución de un espécimen
     * @param catalogNumber
     * @param receivingDate
     * @param transactedSpecimenStatusId
     */
    public void returnTransactedSpecimen (String catalogNumber, Calendar receivingDate, Long transactedSpecimenStatusId) {
        Long specimenId = getSpecimenIdByCatalogNumber(catalogNumber);

        // traer el id de la última transacción que registró el espécimen a devolver
        TransactedSpecimen transactedSpecimenEntity = this.transactedSpecimenEAOImpl.getWaitingForReturnTransactionId(specimenId);

        TransactedSpecimenDTO tsDTO = this.transactedSpecimenDTOFactory.createDTO(transactedSpecimenEntity);
        tsDTO.setReceivingDate(receivingDate);
        tsDTO.setTransactedSpecimenStatusId(transactedSpecimenStatusId);
        tsDTO.setWaitingForReturn(false);
        transactedSpecimenEntity = this.transactedSpecimenDTOFactory.updateEntityWithPlainValues(tsDTO, transactedSpecimenEntity);
        this.transactedSpecimenEAOImpl.update(transactedSpecimenEntity);
    }

    /**
     * Método que setea campos read-only de una transacción
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

    /**
     * Método que recorre lista de transacciones para setear campos read-only
     * @param tDTOList
     * @return
     */
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
        //En caso de "Institución no Asociada"
        if(tDTO.getSenderInstitutionId() != null &&
           tDTO.getSenderInstitutionId() == -1)
            tDTO.setSenderInstitutionId(null);
        //En caso de "Institución no Asociada"
        if(tDTO.getReceiverInstitutionId() != null &&
           tDTO.getReceiverInstitutionId() == -1)
            tDTO.setReceiverInstitutionId(null);

        Transaction transactionEntity = this.transactionEAOImpl.findById(Transaction.class, tDTO.
                getTransactionId());
        transactionEntity = this.transactionDTOFactory.updatePlainEntity(tDTO, transactionEntity);
        this.transactionEAOImpl.update(transactionEntity);
    }

    /**
     * Método para crear una transacción
     * @param transactionDTO
     * @return
     */
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

    /**
     * Método
     * @param transactionDTO
     * @param transactedSpecimenDTO
     * @return
     */
    public TransactedSpecimenDTO
            saveTransactedSpecimen(TransactionDTO transactionDTO, TransactedSpecimenDTO transactedSpecimenDTO) {
        Long specimenId = getSpecimenIdByCatalogNumber(transactedSpecimenDTO.getCatalogNumber());
        TransactedSpecimen transactedSpecimenEntity = this.transactedSpecimenEAOImpl.getWaitingForReturnTransactionId(specimenId);
        if (transactedSpecimenEntity == null) {
            transactedSpecimenDTO.setTransactedSpecimenPK(new TransactedSpecimenPK(specimenId, transactionDTO.getTransactionId()));
            transactedSpecimenDTO.setTransactionTypeId(transactionDTO.getTransactionTypeId());
            Calendar currentDateAndTime = Calendar.getInstance();
            transactedSpecimenDTO.setCrationDateAndTime(currentDateAndTime);
            TransactedSpecimen entity = this.transactedSpecimenDTOFactory.createPlainEntity(transactedSpecimenDTO);
            this.transactedSpecimenEAOImpl.create(entity);
            return this.transactedSpecimenDTOFactory.createDTO(entity);
        }
        else {
            return null;
        }
    }

    /**
     * Método que obtiene la lista de personas asociadas a una institución
     * @param institutionId
     * @return
     */
    public List<PersonDTO> getPersonsByInstitutionId(Long institutionId) {
        if (institutionId == null || institutionId != -1)
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

    /**
     * Trae la lista de personas sin institución asociada
     * @return
     */
    public List<PersonDTO> getPersonsWithoutInstitution() {
        return personDTOFactory.createDTOList(transactionEAOImpl.
                getPersonsWithoutInstitution());
    }

    /**
     * Método que obtiene el specimenId asociado a un número de catálogo
     * @param catalogNumber
     * @return
     */
    public Long getSpecimenIdByCatalogNumber (String catalogNumber) {
        return specimenEAOImpl.findByCatalogNumber(catalogNumber);
    }
 
}
