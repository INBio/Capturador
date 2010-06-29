/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.facade.indicator;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.indicator.IndicatorDTO;

/**
 *
 * @author gsulca
 */
@Remote
public interface IndicatorFacadeRemote {

    public List<IndicatorDTO> getChildrenByIndicatorId(Long indicatorId);

    public IndicatorDTO getIndicatorByIndicatorId(Long indicatorId);

    public IndicatorDTO saveNewIndicator(IndicatorDTO iDTO);

    public IndicatorDTO updateIndicator(IndicatorDTO iDTO);

    public Long countChildrenByIndicatorId(Long indicatorId);

    public void deleteIndicator(Long IndicatorId);

    public void saveIndicatorDublinCores(Long indicatorId, List<String> dublinCoreIds, String userName);

    public Long countDublinCoreByIndicator(Long indicatorId);

    public List<Long> getDublinCoreIdsByIndicator(Long indicatorId);

    public void deleteIndicatorDublinCoreByIndicator(Long indicatorId);
    
}
