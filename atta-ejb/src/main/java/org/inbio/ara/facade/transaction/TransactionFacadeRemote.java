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

package org.inbio.ara.facade.transaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
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
            org.inbio.ara.dto.transaction.TransactedSpecimenDTO transactedSpecimenDTO);

    public void deleteTransaction(java.lang.Long transactionId);

    public void deleteTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens);

    public void editTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens, TransactedSpecimenDTO ts);

    public void returnTransactedSpecimen (String catalogNumber, Calendar receivingDate, Long transactedSpecimenStatusId);

    public TransactionDTO updateNames(org.inbio.ara.dto.transaction.TransactionDTO dto);

    public List<TransactionDTO> updateNames(List<org.inbio.ara.dto.transaction.TransactionDTO> dto);

    public void updateTransaction(org.inbio.ara.dto.transaction.TransactionDTO tDTO);

    public List<PersonDTO> getPersonsByInstitutionId(Long institutionId);

    public List<InstitutionDTO> getAllInstitutions();

}
