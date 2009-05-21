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
 * TypeSpecimen.java
 *
 * Created on October 30, 2007, 4:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 * Entity class TypeSpecimen
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "type_specimen")
@TableGenerator(name="type_specimen_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="type_specimen_id",allocationSize=1)
public class TypeSpecimen extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="type_specimen_gen")
    @Column(name = "type_specimen_id", nullable = false)
    private Long id;
    
    @Column(name="identification_sequence")
    private Long identificationSequence;
    
    @Temporal(TemporalType.DATE)
    @Column(name="taxonomical_timestamp", nullable = false)
    private Date taxonomicalTimeStamp;
    
    @Temporal(TemporalType.DATE)
    @Column(name="initial_timestamp", nullable = false)
    private Date initialTimeStamp;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id")
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon taxon;
    
    @JoinColumn(name="institution_id", referencedColumnName="institution_id")
    @ManyToOne()
    private Institution institution;
    
    @JoinColumn(name="type_specimen_type_id", referencedColumnName="type_specimen_type_id")
    @ManyToOne()
    private TypeSpecimenType typeSpecimenType;
    
    /** Creates a new instance of TypeSpecimen */
    public TypeSpecimen() {
    }

    /**
     * Gets the id of this TypeSpecimen.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this TypeSpecimen to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TypeSpecimen.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TypeSpecimen object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeSpecimen)) {
            return false;
        }
        TypeSpecimen other = (TypeSpecimen)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.TypeSpecimen[id=" + id + "]";
    }

    public Long getIdentificationSequence() {
        return identificationSequence;
    }

    public void setIdentificationSequence(Long identificationSequence) {
        this.identificationSequence = identificationSequence;
    }

    public Date getTaxonomicalTimeStamp() {
        return taxonomicalTimeStamp;
    }

    public void setTaxonomicalTimeStamp(Date taxonomicalTimeStamp) {
        this.taxonomicalTimeStamp = taxonomicalTimeStamp;
    }

    public Date getInitialTimeStamp() {
        return initialTimeStamp;
    }

    public void setInitialTimeStamp(Date initialTimeStamp) {
        this.initialTimeStamp = initialTimeStamp;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public TypeSpecimenType getTypeSpecimenType() {
        return typeSpecimenType;
    }

    public void setTypeSpecimenType(TypeSpecimenType typeSpecimenType) {
        this.typeSpecimenType = typeSpecimenType;
    }
    
}
