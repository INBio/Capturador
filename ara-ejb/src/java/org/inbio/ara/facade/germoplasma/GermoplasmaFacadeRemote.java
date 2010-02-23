/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.germoplasma;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.germoplasma.PassportDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;

/**
 *
 * @author dasolano
 */
@Remote
public interface GermoplasmaFacadeRemote {

    /**
     * Return all elements for a selection list id
     * @param selectionListId
     * @return
     */
    //cambiar <<---------------
    public List<SelectionListDTO>getElementsForSelectionList(long selectionListId);




    /**
     * Return a list of nomenclatural groups for a taxon id
     * @param taxonId
     * @return
     */
    public List<NomenclaturalGroupDTO> getNomenclaturalGroupsByTaxon(Long taxonId);


    /**
     * Save a Passport
     * @param passportDTO
     */
    public void savePassport(PassportDTO passportDTO, Long[] selectedNomenclaturalGroups);

    /**
     * Get all donor persons
     * @return
     */
    public List<PersonDTO> getDonorPersons();

    /**
     * Get All taxons for a collection id
     * @param collectionId
     * @return
     */
    public List<TaxonDTO> getAllTaxonsByCollectionIdAndTaxonomicalRangeId(Long collectionId, Long taxonomicalRangeId);

    /**
     * Get a passport list paginated
     * @param firstResult
     * @param lastResult
     * @return
     */
    public List<PassportDTO> getPassportListPaginated(int firstResult, int maxResults);

    /**
     * Return the quantity of passports
     * @return
     */
    public Long countPassport();

    /**
     * Update a passport
     * @param passportDTO
     */
    public void updatePassport(PassportDTO passportDTO, Long[] selectedNomenclaturalGroups);

    /**
     * Get the taxonomical level of a taxon
     * @param taxonId
     * @return
     */
    public Long getTaxonomicalLevelForTaxon(Long taxonId);

    /**
     * Get a passport list for a simple search with lot of elements
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<PassportDTO> getPassportSimpleSearch(String query, Long collectionId, int firstResult, int maxResult);

    /**
     * Get a list of passport for the advanced search
     * @param passportDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<PassportDTO> getPassportAdvancedSearch(PassportDTO passportDTO, Long collectionId, int firstResult, int maxResult);

    /**
     * Count the quantity of passports for the advanced search
     * @param passportDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countPassportAdvancedSearch(PassportDTO passportDTO, Long collectionId);

    /**
     * Coun the quantity of passports for a simple search
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countPassportSimpleSearch(String query, Long collectionId);
}