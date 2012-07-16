/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.security;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.security.SystemUser;

/**
 *
 * @author esmata
 */
public class SystemUserDTOFactory extends BaseDTOFactory<SystemUser, SystemUserDTO>{

    public SystemUserDTO createDTO(SystemUser entity) {
        if(entity==null){
            return null;
        }

        SystemUserDTO result = new SystemUserDTO();

        result.setUserId(entity.getUserId());
        result.setUsername(entity.getUsername());
        result.setEnabled(entity.getEnabled());
        result.setFullname(entity.getFullname());
        result.setPasswd(entity.getPasswd());
        result.setUserTypeId(entity.getUserTypeId());
        result.setUserGroupId(entity.getUserGroupId());
        //seleted is used in the Graphical Interface, should be set in false
        result.setSelected(false);

        return result;
    }

    public SystemUser createEntity(SystemUserDTO dto){
        if(dto==null){
            return null;
        }

        SystemUser result = new SystemUser();

        result.setUserId(dto.getUserId());
        result.setUsername(dto.getUsername());
        result.setEnabled(dto.getEnabled());
        result.setFullname(dto.getFullname());
        result.setPasswd(dto.getPasswd());
        result.setUserTypeId(dto.getUserTypeId());
        result.setUserGroupId(dto.getUserGroupId());

        return result;
    }

}
