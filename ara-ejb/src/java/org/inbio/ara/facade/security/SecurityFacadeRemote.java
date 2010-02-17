/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.security;

import javax.ejb.Remote;

/**
 *
 * @author esmata
 */
@Remote
public interface SecurityFacadeRemote {

    public org.inbio.ara.dto.security.SystemUserDTO getSystemUserByNameAndPass(java.lang.String name, java.lang.String pass);

    public java.util.List<org.inbio.ara.dto.security.NomenclaturalGroupDTO> getNomenclaturalGroupList(java.lang.Long userId);

    public java.lang.Long countUsers();

    public java.util.List<org.inbio.ara.dto.security.SystemUserDTO> getAllUsersPaginated(int first, int totalResults);

    public org.inbio.ara.dto.security.SystemUserDTO saveNewSystemUser(org.inbio.ara.dto.security.SystemUserDTO uDTO);

    public void updateSystemUser(org.inbio.ara.dto.security.SystemUserDTO dto);

    public void deleteSystemUser(org.inbio.ara.dto.security.SystemUserDTO dto);

    public java.util.List<org.inbio.ara.dto.security.NomenclaturalGroupDTO> getAllNomenclaturalGroup();

    public void deleteUserTaxonsByUser(java.lang.Long userId);

    public void deleteNomenclaturalGroupsByUser(java.lang.Long userId);

    public void saveUserTaxon(java.lang.Long taxonId, java.lang.Long userId, java.lang.Long secuence);

    public void saveUserNomenclaturalGroup(java.lang.Long groupId, java.lang.Long userId, java.lang.Long secuence);
    
}
