/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.gathering.Project;

/**
 *
 * @author esmata
 */
public class ProjectDTOFactory extends BaseEntityOrDTOFactory<Project,ProjectDTO> {

    public ProjectDTO createDTO(Project entity) {
		if(entity == null)
			return null;

		ProjectDTO pDTO = new ProjectDTO();

        pDTO.setProjectId(entity.getProjectId());
        pDTO.setDescription(entity.getDescription());
        pDTO.setProjectManagerName(entity.getProjectManagerName());
        pDTO.setInitialDate(entity.getInitialDate());
        pDTO.setFinalDate(entity.getFinalDate());
        

		return pDTO;
    }

    @Override
    public Project getEntityWithPlainValues(ProjectDTO dto) {
        if(dto==null){
            return null;
        }
        Project p = new Project();

        p.setProjectId(dto.getProjectId());
        p.setDescription(dto.getDescription());
        p.setProjectManagerName(dto.getProjectManagerName());
        p.setInitialDate(dto.getInitialDate());
        p.setFinalDate(dto.getFinalDate());
        
        return p;
    }

    @Override
    public Project updateEntityWithPlainValues(ProjectDTO dto, Project e) {
         if(dto==null||e==null){
            return null;
        }
        else{
            e.setProjectId(dto.getProjectId());
            e.setDescription(dto.getDescription());
            e.setProjectManagerName(dto.getProjectManagerName());
            e.setInitialDate(dto.getInitialDate());
            e.setFinalDate(dto.getFinalDate());            
            return e;
         }
    }
}
