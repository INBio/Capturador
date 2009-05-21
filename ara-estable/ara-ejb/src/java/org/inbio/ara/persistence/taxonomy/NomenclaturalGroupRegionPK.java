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
 * NomenclaturalGroupRegionPK.java
 *
 * Created on June 29, 2008, 3:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class NomenclaturalGroupRegionPK implements Serializable {
    
    @Column(name="region_id",nullable=false)
    private Long regionId;
    
    @Column(name="nomenclatural_group_id",nullable=false)
    private Long nomenclaturalGroupId;
    
    /** Creates a new instance of NomenclaturalGroupRegionPK */
    public NomenclaturalGroupRegionPK() {
    }
    
    public NomenclaturalGroupRegionPK(Long regionId, Long nomenclaturalGroupId) {
        this.regionId = regionId;
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }
    
}
