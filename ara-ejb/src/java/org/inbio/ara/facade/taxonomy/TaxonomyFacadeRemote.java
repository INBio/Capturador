/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.taxonomy.RegionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO;

/**
 *
 * @author esmata
 */
@Remote
public interface TaxonomyFacadeRemote {

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO> getAllTaxonDescriptionPaginated(int first, int totalResults);

    public java.lang.Long countTaxonDescriptions();

    public java.util.List<org.inbio.ara.dto.inventory.TaxonDTO> getAllSpecies();

    public java.util.List<org.inbio.ara.dto.taxonomy.LanguageDTO> getAllLanguages();

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTO> getAllTaxonDescriptionStages();

    public void saveTaxonDescription(org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO dto);

    public void deleteTaxonDescription(java.lang.Long taxonId, java.lang.Long sequenceId);

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getAllSpeciesRecordAuthors();

    public java.util.List<org.inbio.ara.dto.agent.InstitutionDTO> getInstitutionsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public java.util.List<org.inbio.ara.dto.agent.AudienceDTO> getAudiencesByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getPersonsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public java.lang.String getSpeciesNameById(java.lang.Long entityId);

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO> getTaxonDescriptionsByAncestorId(java.lang.Long ancestor);

    public org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO getTaxonDescriptionCategoryByid(java.lang.Long id);

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO> getTDElementsByCategoryId(java.lang.Long categoryId);

    public org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO getTaxonDescriptionRecord(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence, java.lang.Long elementId, java.lang.Long sequence);

    public org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO getTaxonDescriptionRecord(java.lang.Long elementId, java.lang.Long sequence);

    public List<Long> getTaxonDescriptionRows(Long categoryId, Long taxonId, Long taxonDescriptionSequence);

    public TaxonDescriptionElementDTO getElementById(Long elementId);

    public TaxonDescriptionCategoryDTO getCategoryById(Long categoryId);

    public String getTaxonDescriptionRecordValue
            (String mainFieldName, String tableName,String keyField,String contentsNumeric);

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordByRowId
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId);

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordByTaxonDescription
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId);

    public Long[] getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId) ;

    public HashMap hashMapListBox(String className, String idValue, String showName);

    public java.util.List<java.lang.String> getDefaultNameByGathObsId(java.lang.Long gathObsId);

    public boolean deleteTaxonDescriptionRecordRow
            (Long taxonDescriptionSequence, Long taxonId, Long sequence);

    public void saveTaxonDescriptionRecord(TaxonDescriptionRecordDTO tdrDTO,
            TaxonDescriptionDTO tdDTO);

    public Long getNextTaxonDescriptionRecordSequence(Long taxonDescriptionSequence, Long taxonId);

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordById(Long tdrId);

    public void updateTaxonDescriptionRecord(TaxonDescriptionRecordDTO tdrDTO);

    public org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO updateTaxonDescription(org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO dto, java.lang.Long[] audiences, java.lang.Long[] authors, java.lang.Long[] institutions);

    public List<TaxonDescriptionRecordDTO> getTaxonDescriptionRecordsByTaxonDescription(
            Long taxonId,Long taxonDescriptionSequence);

    public String getFieldContent(Long Id, String tableName, String keyField,String tableField);

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionAudienceDTO> getTDAudiencesByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public org.inbio.ara.dto.agent.AudienceDTO getAudienceById(java.lang.Long aId);

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionPersonProfileDTO> getAuthorsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public org.inbio.ara.dto.inventory.PersonDTO getPersonById(java.lang.Long pId);

    public java.util.List<org.inbio.ara.dto.taxonomy.TaxonDescriptionInstitutionDTO> getTDInstitutionsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public org.inbio.ara.dto.agent.InstitutionDTO getInstitutionById(java.lang.Long iId);

    public boolean existTaxonDescription(Long taxonId,Long sequenceId);

    public List<CollectionDTO> getAllCollections();

    public List<PersonDTO> getAllCertifiers();

    public List<RegionDTO> getAllRegions();

    public List<TaxonDTO> getAllTaxonByRange(Long rangeId);

    public List<TaxonDTO> getTaxonChildren(Long taxonId);

    public Long getTaxonChildrenCount(Long taxonId);

    public Long getAssociatedSpecimenCount(Long taxonId);

    public TaxonDTO getTaxon(Long taxonId);

    public TaxonomicalRangeDTO getTaxonRangeName(Long taxonId);

	public Long getNextMandatoryTaxonomicalLevel(Long ancestorTaxonomicalLevel);

	public void saveTaxon(TaxonDTO taxonDTO);

	public void deleteTaxon(Long taxonId);

    public List<NomenclaturalGroupDTO> getAllNomenclaturalGroupsPaginated(int firstResult, int maxResults, Long collectionEntity);
    public Long countAllNomenclaturalGroups();

    /**
     * Deletes a NomenclaturalGroup if it is not used.
     * @param id
     */
    public void deleteNomenclaturalGroup(Long id);
    
    /**
     * Updates general information about de NomenclaturalGroup as well as the
     * information related in taxonomy and regions.
     * @param dto
     * @param regionIds
     * @param taxonIds
     */
    public void updateNomenclaturalGroup(NomenclaturalGroupDTO dto,
            Long[] regionIds, Long[] taxonIds);
            
    /**
     * Creates a new NomenclaturalGroup with all the information related.
     * @param dto
     * @param regionIds
     * @param taxonIds
     */
    public void createNomenclaturalGroup(NomenclaturalGroupDTO dto,
            Long[] regionIds, Long[] taxonIds);

    public java.util.List<org.inbio.ara.dto.inventory.TaxonDTO> getAllTaxon();

    public java.util.List<org.inbio.ara.dto.inventory.TaxonDTO> getTaxonsByNomenclaturalGroup(java.lang.Long ngId);

    public java.util.List<org.inbio.ara.dto.taxonomy.RegionDTO> getRegionsByNomenclaturalGroup(java.lang.Long ngId);

    public java.lang.Long getAssociatedNumenclaturalG(java.lang.Long taxonId);

    /**
     * Execute the simple search for taxon description
     * @param query
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<TaxonDescriptionDTO> getTaxonDescriptionSimpleSearch(String query, int firstResult, int maxResult);

    /**
     * Count the simple search results for taxon description
     * @param query
     * @return
     */
    public Long countTaxonDescriptionSimpleSearch(String query);
}
