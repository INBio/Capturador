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

package org.inbio.ara.facade.search;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.transaction.TransactionDTO;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author herson
 */
@Remote
public interface SearchFacadeRemote {

    public List<SpecimenDTO> test();

    /***************************************************************************
     *********************** ========SITE======== ******************************
     **************************************************************************/
    public List<SiteDTO> searchSiteByCriteria(String query, int base, int offset);

    public List<SiteDTO> searchSiteByCriteria(SiteDTO inputDTO, int base, int offset);

    public Long countSitesByCriteria(String query);

    public Long countSitesByCriteria(SiteDTO inputDTO);

    /***************************************************************************
     ************************* ===SPECIMEN=== **********************************
     **************************************************************************/
    /**
     * @param query String unstructured query
     * @param base
     * @param offset
     * @return List<SpecimenDTO>
     * @deprecated Use instead searchSpecimenByCriteria(String query,
     * Long collectionId, int base, int offset)
     */
    public List<SpecimenDTO> searchSpecimenByCriteria(String query, int base,
            int offset);
    /**
     *
     * @param query String unstructured query
     * @param collectionId
     * @param base
     * @param offset
     * @return List<SpecimenDTO>
     */
    public List<SpecimenDTO> searchSpecimenByCriteria(String query,
            Long collectionId, int base, int offset);

    public List<SpecimenDTO> searchSpecimenByCriteria(SpecimenDTO inputDTO,
            int base, int offset);

    /**
     *
     * @param query
     * @return Count about how many results will be returned in a simple query
     * @deprecated Use instead: countSpecimensByCriteria(String query,
     *      <b>Long collectionId</b>)
     */
    public Long countSpecimensByCriteria(String query);
    /**
     *
     * @param query
     * @param collectionId
     * @return Count about how many results will be returned in a simple query,
     * filtered by collection
     */
    public Long countSpecimensByCriteria(String query, Long collectionId);

    public Long countSpecimensByCriteria(SpecimenDTO inputDTO);

    /***************************************************************************
     *********************** ===IDENTIFICATION=== ******************************
     **************************************************************************/
    public List<IdentificationDTO> searchIdentificationByCriteria(
            IdentificationDTO inputDTO, int base, int offset);
    /**
     *
     * @param query String unstructured query
     * @param base
     * @param offset
     * @return
     * @deprecated Use instead: searchIdentificationByCriteria(String query,
     *       <b>Long collectionId</b>, int base, int offset)
     */
    public List<IdentificationDTO> searchIdentificationByCriteria(String query,
            int base, int offset);
    public List<IdentificationDTO> searchIdentificationByCriteria(String query,
            Long collectionId, int base, int offset);

    /**
     *
     * @param query
     * @return
     * @deprecated Use instead: countIdentificationByCriteria(String query,
     * <b>Long collectionId</b>)
     */
    public Long countIdentificationByCriteria(String query);
    public Long countIdentificationByCriteria(String query, Long collectionId);

    public Long countIdentificationByCriteria(IdentificationDTO inputDTO);

    /***************************************************************************
     ************************ ===GATHERING=== **********************************
     **************************************************************************/
    /**
     * @param query String unstructured query
     * @param base
     * @param offset
     * @return
     * @deprecated
     */
    public List<GatheringObservationDTO> searchGathObsByCriteria(String query,
            int base, int offset);
    public List<GatheringObservationDTO> searchGathObsByCriteria(String query,
            Long collectionId, int base, int offset);

    /**
     *
     * @param query
     * @return
     * @deprecated
     */
    public Long countGathObsByCriteria(String query);
    public Long countGathObsByCriteria(String query, Long collectionId);

    public List<GatheringObservationDTO>
            searchGathObsByCriteria(GatheringObservationDTO inputDTO,
            int base, int offset);

    public Long countGathObsByCriteria(GatheringObservationDTO inputDTO);

    public Long countQueryElements(LinkedList<QueryNode> sll);

    public List findAllDwCPaginated(int first, int amount);

    public List makePaginatedQuery
            (LinkedList<QueryNode> sll, int first, int amount);

    public Long countAllDwC();


    /***************************************************************************
     ********************** === TRANSACTION === ********************************
     **************************************************************************/
    public List<TransactionDTO> searchTransactionsByCriteria(
            TransactionDTO inputDTO, int base, int offset);
    
    public List<TransactionDTO> searchTransactionsByCriteria(String query,
            Long collectionId, int base, int offset);

    public Long countTransactionsByCriteria(TransactionDTO inputDTO);

    public Long countTransactionsByCriteria(String query, Long collectionId);

}
