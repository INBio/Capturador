/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.germplasm;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.germplasm.AccessionDTO;
import org.inbio.ara.dto.germplasm.AccessionMovementDTO;
import org.inbio.ara.dto.germplasm.BreedDTO;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.dto.germplasm.SemenGatheringDTO;
import org.inbio.ara.dto.germplasm.SementalDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;

/**
 *
 * @author dasolano
 */
@Remote
public interface GermplasmFacadeRemote {

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
     * Count the quantity of passports for a simple search
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countPassportSimpleSearch(String query, Long collectionId);



    /**
     * Count the quantity of accessions for the advanced search
     * @param passportDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countAccessionAdvancedSearch(AccessionDTO accessionDTO, Long collectionId);

    /**
     * Count the quantity of accessions for a simple search
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countAccessionSimpleSearch(String query, Long collectionId);



    /**
     * Get a accessions list paginated
     * @param firstResult
     * @param lastResult
     * @return
     */
    public List<AccessionDTO> getAccessionListPaginated(int firstResult, int maxResults);

    /**
     * Return the quantity of accessions
     * @return
     */
    public Long countAccessions();


    /**
     * Get a passport list for a simple search with lot of elements
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<AccessionDTO> getAccessionSimpleSearch(String query, Long collectionId, int firstResult, int maxResult);

    /**
     * Get a list of accession for the advanced search
     * @param accessionDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<AccessionDTO> getAccessionAdvancedSearch(AccessionDTO accessionDTO, Long collectionId, int firstResult, int maxResult);

    /**
     * Save an Accession
     * @param accessionDTO
     */
    public Long saveAccession(AccessionDTO accessionDTO)throws IllegalArgumentException;

    /**
     * Update an Accession
     * @param accessionDTO
     */
    public AccessionDTO updateAccession(AccessionDTO accessionDTO);


    public void deleteAccession(Long accessionId);



    /**
     * Get all donor persons
     * @return
     */
    public List<PersonDTO> getResponsablePersons();

    /**
     * Save an Accession Movement
     * @param accessionMovementDTO
     */
    public void saveAccessionMovement(AccessionMovementDTO accessionMovementDTO);

    /**
     * Update an Accession movement
     * @param accessionMovementDTO
     */
    public void updateAccessionMovement(AccessionMovementDTO accessionMovementDTO);

    /**
     * delete an Accession movement
     * @param accessionMovementDTO
     * @return
     */
    public AccessionDTO deleteAccessionMovement(AccessionMovementDTO accessionMovementDTO);

    /**
     * Obtain all the acession movements for an accession Id specified
     * @param accessionId
     * @param firstResult
     * @param maxResult
     * @return List<AccessionMovementDTO> list of accession movements
     */
    public List<AccessionMovementDTO> getAllAccessionMovementByAccesionIdPaginated(Long accessionId, int firstResult, int maxResult);

    /**
     * Count all the accession movements for an accession id specified
     * @param accessionId
     * @return Long
     */
    public Long countAccessionMovements(Long accessionId);

    public List<AccessionMovementDTO> getAccessionMovementsSimpleSearch(String query, Long collectionId, int firstResult, int maxResult);

    public List<AccessionMovementDTO> getAccessionMovementsAdvancedSearch(AccessionMovementDTO accessionMovement, Long collectionId, int firstResult, int maxResult);

    public Long countAccessionMovementsSimpleSearch(String query, Long collectionId);

    public Long countAccessionMovementsAdvancedSearch(AccessionMovementDTO accessionMovement, Long collectionId);

    /**
     * Return true if an Accession id has accession movements,
     * False if not
     * @param accessionId
     * @return
     */
    public boolean haveMovementsAndAccessions(Long accessionId);

    /**
     * Add to an Accession weight the given value
     * @param accessionDTO
     * @param weigth
     * @return
     */
    public AccessionDTO addToAccessionCurrentWeight(AccessionDTO accessionDTO, Long weigth);

    /**
     * Delete passport
     * @param PassportId
     */
    public void deletePassport(Long PassportId);

    /**
     * Return true if a Passport has accession associated to it, false if not
     * @param passportId
     * @return
     */
    public boolean haveAccessions(Long passportId);

    //** semen module **// 

    /**
     * Save breed
     * @param breedDTO
     */
    public void saveBreed(BreedDTO breedDTO);

    /**
     * Update breed
     * @param breedDTO
     */
    public void updateBreed(BreedDTO breedDTO);

    /**
     * Obtain a list of breeds paginated
     * @param firstResult
     * @param maxResult
     * @return  List<BreedDTO> 
     */
    public List<BreedDTO> getAllBreedPaginated(int firstResult, int maxResult);

    /**
     * Count all breeds
     * @return
     */
    public Long countAllBreed();

    /**
     * Get a list of breeds paginated for a simple search
     * @param query
     * @param firstResult
     * @param maxResult
     * @return List<BreedDTO>
     */
    public List<BreedDTO> getBreedSimpleSearch(String query, int firstResult, int maxResult);

    /**
     * Count all the breeds for a simple search
     * @param query
     * @return
     */
    public Long countBreedSimpleSearch(String query);

    /**
     * Save semental
     * @param sementalDTO
     * @return SementalDTO
     */
    public SementalDTO saveSemental(SementalDTO sementalDTO);

    /**
     * Update semental
     * @param sementalDTO
     */
    public void updateSemental(SementalDTO sementalDTO);

    /**
     * Obtain all sementals paginated
     * @param firstResult
     * @param maxResult
     * @return List<SementalDTO>
     */
    public List<SementalDTO> getAllSementalPaginated(int firstResult, int maxResult);

    /**
     * Count all sementals
     * @return
     */
    public Long countAllSemental();

    /**
     * Obtain a list of sementals for a simple search
     * @param query
     * @param firstResult
     * @param maxResult
     * @return List<SementalDTO>
     */
    public List<SementalDTO> getSementalSimpleSearch(String query, int firstResult, int maxResult);

    /**
     * Count all sementals for a simple search
     * @param query
     * @return Long
     */
    public Long countSementalSimpleSearch(String query);

    /**
     * Obtain a list of sementals for an advance search
     * @param sementalDTO
     * @param firstResult
     * @param maxResult
     * @return List<SementalDTO>
     */
    public List<SementalDTO> getSementalAdvancedSearch(SementalDTO sementalDTO, int firstResult, int maxResult);

    /**
     * Count all sementals for an advance search
     * @param sementalDTO
     * @return Long
     */
    public Long countSementalAdvancedSearch(SementalDTO sementalDTO);

    /**
     * Save semen gathering
     * @param semenGatheringDTO
     */
    public void saveSemenGathering(SemenGatheringDTO semenGatheringDTO);

    /**
     * update semen gathering
     * @param semenGatheringDTO
     */
    public void updateSemenGathering(SemenGatheringDTO semenGatheringDTO);

    /**
     * Obtain all the semen gathering paginated for a semental Id
     * @param sementalId
     * @param firstResult
     * @param maxResult
     * @return List<SemenGatheringDTO> 
     */
    public List<SemenGatheringDTO> getAllSemenGatheringPaginated(Long sementalId, int firstResult, int maxResult);

    /**
     * Count all semen gathering for a semental Id
     * @param sementalId
     * @return Long
     */
    public Long countAllSemenGathering(Long sementalId);

    /**
     * Obtain a list of semen gathering for a simple search
     * @param query
     * @param firstResult
     * @param maxResult
     * @return List<SemenGatheringDTO>
     */
    public List<SemenGatheringDTO> getSemenGatheringlSimpleSearch(String query, int firstResult, int maxResult);

    /**
     * Count all semen gathering for a simple search
     * @param query
     * @return Long
     */
    public Long countSemenGatheringSimpleSearch(String query);

    /**
     * Obtain a list of semen gathering for an advance search
     * @param semenGatheringDTO
     * @param firstResult
     * @param maxResult
     * @return List<SemenGatheringDTO>
     */
    public List<SemenGatheringDTO> getSemenGatheringAdvancedSearch(SemenGatheringDTO semenGatheringDTO, int firstResult, int maxResult);

    /**
     * Count all semen gathering for an advance search
     * @param semenGatheringDTO
     * @return Long
     */
    public Long countSemenGatheringAdvancedSearch(SemenGatheringDTO semenGatheringDTO);

    /**
     * get All breeds
     * @return  List<BreedDTO>
     */
    public List<BreedDTO> getAllBreeds();

    /**
     * Return true if a breed has sementals associated, false if not
     * @param breedId
     * @return boolean
     */
    public boolean haveSementals(Long breedId);

    /**
     * Return true if a semental has semen gatherins associated, false if not
     * @param sementalId
     * @return boolean
     */
    public boolean haveSemenGathering(Long sementalId);

    /**
     * Delete breed
     * @param breedId
     */
    public void deleteBreed(Long breedId);

    /**
     * Delete semental
     * @param sementalId
     */
    public void deleteSemental(Long sementalId);

    /**
     * Delete semen gathering
     * @param semenGatheringId
     */
    public void deleteSemenGathering(Long semenGatheringId);

    /**
     * Return a list of taxon in a specify Taxonomical Range Id for a the Plantae kingdom
     * @param taxonomicalRangeId
     * @return
     */
    public List<TaxonDTO> getAllTaxonsByPlantaeKingdomAndTaxonomicalRangeId(Long taxonomicalRangeId);

    /**
     * Return a list of taxon in a specify Taxonomical Range Id for a the Animalia kingdom
     * @param taxonomicalRangeId
     * @return
     */
    public List<TaxonDTO> getAllTaxonsByAnimaliaKingdomAndTaxonomicalRangeId(Long taxonomicalRangeId);
}