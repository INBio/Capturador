/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.agent;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntityDTO;

/**
 *
 * @author esmata
 */
@Remote
public interface AdminFacadeRemote {

    public void deleteSelectionListElement(SelectionListDTO actualSelectionListElementDTO);

    public List<CollectionDTO> getAllCollectionsAssociatedToSelectionListValue(Long selectedSelectionListEntityId, Long selectedSelectionListValueId);

    public List<org.inbio.ara.dto.agent.InstitutionDTO> getAllInstitutions();

    public List<org.inbio.ara.dto.agent.CollectionDTO> getAllCollections();

    public int saveOrUpdateCollection(CollectionDTO collectionDTO);

    public void deleteCollection(CollectionDTO actualCollectionDTO) throws IllegalArgumentException;

    public List<SelectionListEntityDTO> getAllSelectionListEntities();

	/**
	 * @param selectionListEntityId look for the Id of a element of the ENUM SelectionListEntity
	 * @return
	 * @see org.inbio.ara.dto.inventory.SelectionListEntity
	 */
	public List<SelectionListDTO> getAllSelectionListElementsPaginated(Long selectionListEntityId,int first, int totalResults);

    /**
	 * @param selectionListEntityId look for the Id of a element of the ENUM SelectionListEntity
	 * @return the total of value associated to that selectionListEntity
	 * @see org.inbio.ara.dto.inventory.SelectionListEntity
	 */
	public Long countAllSelectionListElements(Long selectionListEntityId);

    public List<org.inbio.ara.dto.inventory.TaxonDTO> getUserTaxonList(java.lang.Long userId);

    public void saveOrUpdateCollectionsBySelectionListValue(Long selectionListEntityId, Long selectionListValueId, List<Long> newAssociatedCollections);

    public int saveOrUpdateSelectionListElement(SelectionListDTO selectionListElementDTO);

    public java.util.List<org.inbio.ara.dto.agent.InstitutionDTO> getAllInstitutionsPaginated(int firstResult, int maxResults);

    public java.lang.Long countInstitutions();

    public void deleteInstitution(java.lang.Long insId);

    public int findSpecimensByInstitutionId(java.lang.Long insId);

    public void saveInstitution(org.inbio.ara.dto.agent.InstitutionDTO idto);

    public void updateInstitution(org.inbio.ara.dto.agent.InstitutionDTO idto);

    public java.lang.Long countAudiences();

    public java.util.List<org.inbio.ara.dto.agent.AudienceDTO> getAllAudiencesPaginated(int firstResult, int maxResults);

    public void deleteAudience(java.lang.Long Id);

    public void saveAudience(org.inbio.ara.dto.agent.AudienceDTO adto);

    public void updateAudience(org.inbio.ara.dto.agent.AudienceDTO dto);

    public java.util.List<org.inbio.ara.dto.agent.ProfileDTO> getAllProfilesPaginated(int firstResult, int maxResults);

    public java.lang.Long countProfiles();

    public void updateProfile(org.inbio.ara.dto.agent.ProfileDTO dto);

    public java.util.List<org.inbio.ara.dto.agent.ProfileDTO> getAllProfiles();

    public java.util.List<org.inbio.ara.dto.agent.AudienceDTO> getAllAudiences();
    
}
