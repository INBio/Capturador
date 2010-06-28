/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.transaction;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.dto.transaction.TransactionDTO;

/**
 *
 * @author echinchilla
 */
@Remote
public interface TransactionFacadeRemote {

    public java.lang.Long countTransaction(java.lang.Long collectionId);

    public java.lang.Long countTransactedSpecimen(java.lang.Long transactionId);

    public List getAllTransactionPaginated(int firstResult, int maxResults, java.lang.Long collectionId);

    public List getAllTransactedSpecimenPaginated(int firstResult, int maxResults, Long transactionId);

    public TransactionDTO saveTransaction(org.inbio.ara.dto.transaction.TransactionDTO transactionDTO);

    public TransactedSpecimenDTO saveTransactedSpecimen(org.inbio.ara.dto.transaction.TransactionDTO transactionDTO,
            org.inbio.ara.dto.transaction.TransactedSpecimenDTO transactedSpecimenDTO, String createdBy);

    public void deleteTransaction(java.lang.Long transactionId);

    public void deleteTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens);

    public void editTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens, TransactedSpecimenDTO ts);

    public TransactionDTO updateNames(org.inbio.ara.dto.transaction.TransactionDTO dto);

    public List<TransactionDTO> updateNames(List<org.inbio.ara.dto.transaction.TransactionDTO> dto);

    public void updateTransaction(org.inbio.ara.dto.transaction.TransactionDTO tDTO);

    /**
     * @param selectionListEntityId look for the Id of a element of the ENUM SelectionListEntity
     * @param collectionId corresponds to the Id of the current collection
     * @return
     * @see org.inbio.ara.dto.inventory.SelectionListEntity
     */
//    public List<SelectionListDTO> getAllSelectionListElementsByCollection(Long selectionListEntityId, Long collectionId);

    /**
     * 
     * @param institutionId institutionId por el cual se va a filtrar la lista de personas
     * @return lista de personas asociadas a dicho institutionId
     */
    public List<PersonDTO> getPersonsByInstitutionId(Long institutionId);

    /**
     *
     * @return Lista de todas las instituciones registradas en el sistema
     */
    public List<InstitutionDTO> getAllInstitutions();

}
