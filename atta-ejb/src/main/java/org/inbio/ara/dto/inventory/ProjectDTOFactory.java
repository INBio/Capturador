/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.gathering.Project;

/**
 *
 * @author esmata
 */
public class ProjectDTOFactory extends BaseDTOFactory<Project, ProjectDTO> {

    public ProjectDTO createDTO(Project entity) {
		if(entity == null)
			return null;

		ProjectDTO pDTO = new ProjectDTO();

        pDTO.setProjectId(entity.getProjectId());
        pDTO.setDescription(entity.getDescription());
        pDTO.setProjectManagerName(entity.getProjectManagerName());

		return pDTO;
    }
}
