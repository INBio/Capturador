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

package org.inbio.ara.dto.indicator;

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.indicator.Indicator;

/**
 *
 * @author gsulca
 */
public class IndicatorDTOFactory extends BaseEntityOrDTOFactory<Indicator ,IndicatorDTO>{

   
    /**
     * Este método genéra una entidad Indicator con los valores de un IndicatorDTO,
     * se utiliza para actualizar los valores de un Indicator que ya existe en la base de datos
     * @param IndicatorDTO dto que contiene los nuevos datos
     * @param Indicator e donde se almacenaran los nuevos datos
     * @return Indicator generado con los datos del dto
     */
    @Override
    public Indicator updateEntityWithPlainValues(IndicatorDTO dto, Indicator e) {
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setAppliesToParts(dto.getAppliesToParts());
        e.setIndicatorAncestorId(dto.getIndicatorAncestorId());

        e.setLastModificationBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());


        return e;
    }

    /**
     * Se crea un nuevo DTO a partir de los valores obtenidos de la entidad Indicator.
     * @param Indicator e que contiene los datos
     * @return IndicatorDTO nuevo dto con los datos obtenidos de Indicator
     */
    public IndicatorDTO createDTO(Indicator entity) {
        IndicatorDTO indicatorDTO = new IndicatorDTO();
        indicatorDTO.setIndicatorId(entity.getIndicatorId());
        indicatorDTO.setName(entity.getName());
        indicatorDTO.setDescription(entity.getDescription());
        indicatorDTO.setAppliesToParts(entity.getAppliesToParts());
        Long indicatorAncestor = entity.getIndicatorAncestorId();
        if(indicatorAncestor != null)
        {
            indicatorDTO.setIndicatorAncestorId(indicatorAncestor);
        }
        return indicatorDTO;
    }


     /**
     * Crea una nueva entidad Indicator con los valores de IndicatorDTO
     * @param IndicatorDTO dto que contiene los nuevos datos
     * @param Indicator e donde se almacenaran los nuevos datos
     * @return Indicator generado con los datos del dto
     */
    @Override
    public Indicator getEntityWithPlainValues(IndicatorDTO dto) {
        if(dto==null){
            return null;
        }
        Indicator indicator = new Indicator();

        indicator.setName(dto.getName());
        indicator.setDescription(dto.getDescription());
        indicator.setAppliesToParts(dto.getAppliesToParts());
        indicator.setIndicatorAncestorId(dto.getIndicatorAncestorId());
        return indicator;
    }



}
