/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.systemstatistics;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.SystemStatisticsDTO;

/**
 *
 * @author asanabria
 */
@Remote
public interface SystemStatisticsManagerRemote {

	public List<SystemStatisticsDTO> getSpecimenCountByCollection();

	List<SystemStatisticsDTO> getSpeciesCountByCollection();
    
}
