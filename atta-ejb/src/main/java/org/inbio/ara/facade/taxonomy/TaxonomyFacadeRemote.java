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
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.taxonomy.PersonAuthorDTO;
import org.inbio.ara.dto.taxonomy.RegionDTO;
import org.inbio.ara.dto.taxonomy.SynonymDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorProfileDTO;
import org.inbio.ara.dto.taxonomy.TaxonCountryDTO;
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

	public TaxonDTO saveTaxon(TaxonDTO taxonDTO);

	public void deleteTaxon(Long taxonId);

    public void updateTaxon(TaxonDTO taxonDTO);

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

    public TaxonDTO getTaxonRootByCollectionId(Long collectionId);

    public List<TaxonCategoryDTO> getAllTaxonCategory();

    public List<TaxonomicalRangeDTO> getNextLevelsByTaxonId(Long taxonId);

    public Long getTaxonomicalRangeIdByTaxonId(Long taxonId);

    public void saveTaxonIndicators(Long taxonId, List<String> indicatorIds, String userName);

    public void deleteTaxonIndicatorByIds(Long taxonId, List<String> indicatorIds);
    
    public void deleteTaxonIndicatorById(Long taxonId, String indicatorId);

    public List<Long> getIndicatorIdsByTaxon(Long taxonId);

    public void saveTaxonIndicator(Long taxonId, String indicatorId, String userName);

    public void saveTaxonIndicatorCountries(Long taxonId, Long indicatorId ,List<Long> countryIds, String userName);
    
    public void saveTaxonIndicatorCountry(Long taxonId, Long indicatorId ,Long countryId, String userName);

    public List<Long> getCountriesByTaxonIndicatorIds(Long taxon, Long indicator);

    public void deleteTaxonIndicatorCountryByIds(Long taxonId, Long indicatorId, List<Long> countryIds);

    public void saveTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId ,List<String> dublinCoreIds, String userName);

    public List<Long> getDublinCoreByTaxonIndicatorIds(Long taxonId, Long indicatorId);

    public void deleteTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId, List<String> dublinCoreIds);

    public void deleteTaxonIndicatorByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorCountryByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorDublinCoreByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorCountryByTaxonIndicator(Long taxonId, Long indicatorId);

    public void deleteTaxonIndicatorDublinCoreByTaxonIndicator(Long taxonId, Long indicatorId);

    public List<Long> getComponentPartByTaxonIndicatorIds(Long taxon, Long indicator);

    public void saveTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId ,List<Long> componentPartIds, String userName);

    public void deleteTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId, List<Long> componentPartIds);

    public void deleteTaxonIndicatorComponentPartByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorComponentPartByTaxonIndicator(Long taxonId, Long indicatorId);

    public List<TaxonAuthorProfileDTO> getAllTaxonAuthorProfile();

    public String getAuthorName(Long personId,Long profileId, short formatId, boolean orientation);

    public List<PersonAuthorDTO> getAllPersonsByProfileId(Long profileId, Short formatId, boolean orientation);

    public void saveTaxonAuthors(Long taxonId, List<TaxonAuthorDTO> taxonAuthors, String userName);

    public void deleteTaxonAuthorByTaxonId(Long taxonId);
    public List<TaxonAuthorDTO> getTaxonAuthorsByTaxonCategory(Long taxonId, String category);
    public void updateTaxonAuthor(TaxonAuthorDTO taxonAuthorDTO);
    public void deleteTaxonAuthorByTaxonAuthorIds(List<TaxonAuthorDTO> elements);

    //public List<TaxonDTO> getTaxonByName(String taxonName, Long kingdomId, Long categoryId , int base, int offset);
    public List<TaxonDTO> getTaxonByName(String taxonName, Long taxonomicalRange, Long kingdomId, Long categoryId , int base, int offset);
    public String getTaxonNameByTaxonId(Long taxonId);

    public List<SynonymDTO> getSynonymsByTaxonId(Long taxonId);
    public List<SynonymDTO> getTaxonSynonymByName(String taxonName, Long kingdomId, Long categoryId , int base, int offset);

    public void saveTaxonCountries(Long taxonId, List<TaxonCountryDTO> taxonCountryDtos, String userName);
    public void saveTaxonCountry(Long taxonId,Long countryId, String description, String userName);
    public void deleteTaxonCountryByTaxonId(Long taxonId);
    public List<TaxonCountryDTO> getCountriesByTaxonId(Long taxon);
    public void deleteTaxonCountryByIds(Long taxonId, List<Long> countryIds);
    public void deleteTaxonCountryByTaxonCountryIds(List<TaxonCountryDTO> elements);
    public void updateTaxonCountry(TaxonCountryDTO taxonCountryDTO);
    public void saveSynonyms(Long taxonId, List<Long> synonyms, String user);
    public void deleteSynonyms(Long taxonId, List<Long> synonyms, String user);

    public TaxonDTO getTaxonByCollection(Long collectionId);

    public String getTaxonPath(Long taxonId, Long initialPath);

}
