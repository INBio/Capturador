/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.systemstatistics;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.dto.SystemStatisticsDTO;

/**
 *
 * @author asanabria
 */
@Local
public interface SystemStatisticsManagerLocal {

	public List<SystemStatisticsDTO> getSpecimenCountByCollection();

	List<SystemStatisticsDTO> getSpeciesCountByCollection();


    
}
