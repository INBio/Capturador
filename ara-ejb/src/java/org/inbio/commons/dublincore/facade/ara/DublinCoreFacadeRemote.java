/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.facade.ara;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;

import org.inbio.commons.dublincore.dto.ara.InterfaceDublinCoreDTO;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.manager.DublinCoreMetadataManager;

/**
 *
 * @author gsulca
 */
@Remote
public interface DublinCoreFacadeRemote extends DublinCoreMetadataManager {

    public Long countSimpleSearch(String query);
    public List<DublinCoreDTO> getReferenceSimpleSearch(String query, int firstResult, int maxResult);
    public Long countDublinCoreAdvancedSearch(DublinCoreDTO dublinCoreDTO);
    public Set<Integer> getDublinCoreByCriteria(DublinCoreDTO dublinCoreDTO);
    public List<DublinCoreDTO> getDublinCoreAdvancedSearch(DublinCoreDTO dublinCoreDTO, int firstResult, int maxResult);
    public List<ReferenceDTO> dublinCoreDTOsToReferenceDTOs (List<DublinCoreDTO> list);
    public ReferenceDTO dublinCoreDTOToReferenceDTO (DublinCoreDTO element);
    public Long countResourceByTypeId(int typeId);
    public List<DublinCoreDTO> getAllDublinCorePaginated(int firstResult, int maxResult);

    public void saveDublinCore(InterfaceDublinCoreDTO interfaceDublinCoreDTO);
    public void updateDublinCore(InterfaceDublinCoreDTO interfaceDublinCoreDTO);
    public InterfaceDublinCoreDTO findInterfaceDublincoreById(Long resourceId);

    public List<DublinCoreDTO> findAllDublinCorePaginated(int resourceTypeId, int firstResult, int maxResult);
    public List<ReferenceDTO> dublinCoreDTOsToFullReferenceDTOs (List<DublinCoreDTO> list);

}
