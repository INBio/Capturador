/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.dto.inventory;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author esmata
 */
public class LifeStageSexDTO implements Serializable {

    private SelectionListDTO lifeStageDTO;
    private SelectionListDTO sexDTO;
    private Long quantity;


    /**
     * Constructor vacio de la clase
     */
    public LifeStageSexDTO(){

    }

    public LifeStageSexDTO(SelectionListDTO lifeStageDTO, SelectionListDTO sexDTO, Long quantity) {
        this.lifeStageDTO = lifeStageDTO;
        this.sexDTO = sexDTO;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LifeStageSexDTO" +
                "\n\tlife Stage  id = " + lifeStageDTO.getValueId() +
                "\n\tsex id = " + sexDTO.getValueId() +
                "\n\tQuantity = " + quantity;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.lifeStageDTO != null ? this.lifeStageDTO.hashCode() : 0);
        hash = 53 * hash + (this.sexDTO != null ? this.sexDTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LifeStageSexDTO other = (LifeStageSexDTO) obj;

        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        
        return true;
    }

    /**
     * Determina si este LifeStageDTO es parte de una lista.
     *
     * @param lssDTOList
     * @return
     */
    public boolean isPartOf(List<LifeStageSexDTO> lssDTOList) {
        for(LifeStageSexDTO lssDTO : lssDTOList){
            if(this.equals(lssDTO))
                return true;
        }        
        return false;
    }

    /**
     * Returns the index of the first occurrence of the item in the list or -1 if is not in the list
     *
     * @param lssDTOList
     * @return
     * @throws java.lang.IndexOutOfBoundsException
     */
    public int getIndexInList(List<LifeStageSexDTO> lssDTOList)
            throws IndexOutOfBoundsException {
        for(int i=0; i< lssDTOList.size();i++){
            if(this.equals(lssDTOList.get(i)))
                return i;
        }
        return -1;
    }

    /**
     * @return the lifeStageDTO
     */
    public SelectionListDTO getLifeStageDTO() {
        return lifeStageDTO;
    }

    /**
     * @param lifeStageDTO the lifeStageDTO to set
     */
    public void setLifeStageDTO(SelectionListDTO lifeStageDTO) {
        this.lifeStageDTO = lifeStageDTO;
    }

    /**
     * @return the sexDTO
     */
    public SelectionListDTO getSexDTO() {
        return sexDTO;
    }

    /**
     * @param sexDTO the sexDTO to set
     */
    public void setSexDTO(SelectionListDTO sexDTO) {
        this.sexDTO = sexDTO;
    }

    /**
     * @return the quantity
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

