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
/*
 * LifeStageSexSimple.java
 *
 * Created on June 16, 2008, 3:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.specimen;

import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Sex;

/**
 *
 * @depcated esta clase era algo que se comportaba como un DTO pero estaba dando
 * problemas en la edicion de especimenes.  Además si es algo que se comporta como
 * un DTO lo mejor es ponerlo en un paquete para que sea reutilizable
 * @use org.inbio.ara.dto.LifeStageSexDTO
 *
 * @author roaguilar
 */
public class LifeStageSexSimple {
    
    private LifeStage lifeStage;
    private Sex sex;
    private String lifeStageName;
    private String sexName;
    private Long quantity;
    
    /** Creates a new instance of LifeStageSexSimple */
    public LifeStageSexSimple() {
    }

    public LifeStage getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
        this.setLifeStageName(this.lifeStage.getName());
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
        this.setSexName(this.sex.getName());
    }

    public String getLifeStageName() {
        return lifeStageName;
    }

    public void setLifeStageName(String lifeStageName) {
        this.lifeStageName = lifeStageName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
}
