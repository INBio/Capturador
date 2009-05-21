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
 * SpeciesRecordStageProfile.java
 *
 * Created on October 21, 2007, 10:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
/**
 * Entity class SpeciesRecordStageProfile
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="species_record_stage_profile")
public class SpeciesRecordStageProfile extends genericEntity {

    @EmbeddedId
    private SpeciesRecordStageProfilePK speciesRecordStageProfilePK;
    
    @Column(name="editable")
    private int editable;
    
    @Column(name="erasable")
    private int erasable;
    
    @Column(name="visible")
    private int visible;
    
    /** Creates a new instance of SpeciesRecordStageProfile */
    public SpeciesRecordStageProfile() {
    }
    
    public SpeciesRecordStageProfile(SpeciesRecordStageProfilePK speciesRecordStageProfilePK) {
        this.setSpeciesRecordStageProfilePK(speciesRecordStageProfilePK);
    }
    
    public SpeciesRecordStageProfile(Long profileId, Long speciesRecordStageId) {
        this.setSpeciesRecordStageProfilePK(new SpeciesRecordStageProfilePK(profileId, speciesRecordStageId));
    }

    public SpeciesRecordStageProfilePK getSpeciesRecordStageProfilePK() {
        return speciesRecordStageProfilePK;
    }

    public void setSpeciesRecordStageProfilePK(SpeciesRecordStageProfilePK speciesRecordStageProfilePK) {
        this.speciesRecordStageProfilePK = speciesRecordStageProfilePK;
    }

    public int getEditable() {
        return editable;
    }

    public void setEditable(int editable) {
        this.editable = editable;
    }

    public int getErasable() {
        return erasable;
    }

    public void setErasable(int erasable) {
        this.erasable = erasable;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
