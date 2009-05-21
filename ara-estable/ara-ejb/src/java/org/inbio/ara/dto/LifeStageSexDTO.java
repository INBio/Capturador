/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.dto;

import java.io.Serializable;


/**
 *
 * @author jgutierrez
 */
public class LifeStageSexDTO implements Serializable {

    /** The Life Stage key */
    private Long lifeStageKey;
    /** The Sex key */
    private Long sexKey;

    private String lifeStageName;
    private String sexName;

    private String quantity;


    /**
     * 
     */
    public LifeStageSexDTO(){

    }

    /**
     *
     * @param lifeStageKey
     * @param sexKey
     * @param lifeStageName
     * @param sexName
     * @param quantity
     */
    public LifeStageSexDTO(Long lifeStageKey, Long sexKey, String lifeStageName, String sexName, String quantity) {
        this.lifeStageKey = lifeStageKey;
        this.sexKey = sexKey;
        this.lifeStageName = lifeStageName;
        this.sexName = sexName;
        this.quantity = quantity;
    }



    /**
     * @return the lifeStageKey
     */
    public Long getLifeStageKey() {
        return lifeStageKey;
    }

    /**
     * @param lifeStageKey the lifeStageKey to set
     */
    public void setLifeStageKey(Long lifeStageKey) {
        this.lifeStageKey = lifeStageKey;
    }

    /**
     * @return the sexKey
     */
    public Long getSexKey() {
        return sexKey;
    }

    /**
     * @param sexKey the sexKey to set
     */
    public void setSexKey(Long sexKey) {
        this.sexKey = sexKey;
    }

    /**
     * @return the lifeStageName
     */
    public String getLifeStageName() {
        return lifeStageName;
    }

    /**
     * @param lifeStageName the lifeStageName to set
     */
    public void setLifeStageName(String lifeStageName) {
        this.lifeStageName = lifeStageName;
    }

    /**
     * @return the sexName
     */
    public String getSexName() {
        return sexName;
    }

    /**
     * @param sexName the sexName to set
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
