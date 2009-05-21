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
 * IdentificationHistory.java
 *
 * Created on October 29, 2007, 11:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
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
import javax.persistence.Version;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 * Entity class IdentificationHistory
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "identification_history")
@TableGenerator(name="identification_history_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="identification_history_id",allocationSize=1)
public class IdentificationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="identification_history_id_gen")
    @Column(name = "identification_history_id", nullable = false)
    private Long id;
    
    @Column(name="identification_sequence")
    private Long identificationSequence;
    
    @Temporal(TemporalType.DATE)
    @Column(name="identification_history_date", nullable = false)
    private Date identificationHistoryDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="initial_timestamp", nullable = false)
    private Date initialTimeStamp;
    
    @Temporal(TemporalType.DATE)
    @Column(name="final_timestamp", nullable = false)
    private Date finalTimeStamp;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id")
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="identification_type_id", referencedColumnName="identification_type_id")
    @ManyToOne()
    private IdentificationType identificationType;
    
    @JoinColumn(name="identification_status_id", referencedColumnName="identification_status_id")
    @ManyToOne()
    private IdentificationStatus identificationStatus;
    
    @JoinColumn(name="taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon taxon;
    
    @Column(name="data_entry_error")
    private String dataEntryError;
    
    @JoinColumn(name="valuer_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person valuerPerson;    
    
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", nullable = false)
    private Date creationDate;
    
    @Column(name="created_by", nullable = false)
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name="last_modification_date", nullable = false)
    private Date lastModificationDate;
    
    @Column(name="last_modification_by", nullable = false)
    private String lastModificationBy;
    
    @Version
    @Column(name="obj_version")
    private Long version;
    
    /** Creates a new instance of IdentificationHistory */
    public IdentificationHistory() {
    }

    /**
     * Gets the id of this IdentificationHistory.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this IdentificationHistory to the specified value.
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
     * Determines whether another object is equal to this IdentificationHistory.  The result is 
     * <code>true</code> if and only if the argument is not null and is a IdentificationHistory object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationHistory)) {
            return false;
        }
        IdentificationHistory other = (IdentificationHistory)object;
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
        return "org.inbio.ara.persistence.specimen.IdentificationHistory[id=" + id + "]";
    }

    public Long getIdentificationSequence() {
        return identificationSequence;
    }

    public void setIdentificationSequence(Long identificationSequence) {
        this.identificationSequence = identificationSequence;
    }

    public Date getIdentificationHistoryDate() {
        return identificationHistoryDate;
    }

    public void setIdentificationHistoryDate(Date identificationHistoryDate) {
        this.identificationHistoryDate = identificationHistoryDate;
    }

    public Date getInitialTimeStamp() {
        return initialTimeStamp;
    }

    public void setInitialTimeStamp(Date initialTimeStamp) {
        this.initialTimeStamp = initialTimeStamp;
    }

    public Date getFinalTimeStamp() {
        return finalTimeStamp;
    }

    public void setFinalTimeStamp(Date finalTimeStamp) {
        this.finalTimeStamp = finalTimeStamp;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Person getValuerPerson() {
        return valuerPerson;
    }

    public void setValuerPerson(Person valuerPerson) {
        this.valuerPerson = valuerPerson;
    }

    public IdentificationStatus getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(IdentificationStatus identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getLastModificationBy() {
        return lastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
