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
 * SpecimenAnnotation.java
 *
 * Created on October 30, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class SpecimenAnnotation
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="specimen_annotation")
public class SpecimenAnnotation extends genericEntity {

    @EmbeddedId
    private SpecimenAnnotationPK specimenAnnotationPK;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable = false, updatable=false)
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="annotation_id", referencedColumnName="annotation_id", insertable = false, updatable=false)
    @ManyToOne()
    private Annotation annotation;
    
    /** Creates a new instance of SpecimenAnnotation */
    public SpecimenAnnotation() {
    }
    
    public SpecimenAnnotation(SpecimenAnnotationPK specimenAnnotationPK) {
        this.setSpecimenAnnotationPK(specimenAnnotationPK);
    }
    
    public SpecimenAnnotation(Long specimenId, Long annotationId) {
        this.setSpecimenAnnotationPK(new SpecimenAnnotationPK(specimenId, annotationId));
    }

    public SpecimenAnnotationPK getSpecimenAnnotationPK() {
        return specimenAnnotationPK;
    }

    public void setSpecimenAnnotationPK(SpecimenAnnotationPK specimenAnnotationPK) {
        this.specimenAnnotationPK = specimenAnnotationPK;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.specimenAnnotationPK != null ? this.specimenAnnotationPK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecimenAnnotation)) {
            return false;
        }
        SpecimenAnnotation other = (SpecimenAnnotation)object;
        if (this.specimenAnnotationPK != other.specimenAnnotationPK && (this.specimenAnnotationPK == null || !this.specimenAnnotationPK.equals(other.specimenAnnotationPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenAnnotation[specimenAnnotationPK=" + specimenAnnotationPK + "]";
    } 
}
