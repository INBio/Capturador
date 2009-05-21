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
 * Identification.java
 *
 * Created on October 29, 2007, 11:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 * Entity class Identification
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="identification")
public class Identification extends genericEntity {

    @EmbeddedId
    private IdentificationPK identificationPK;
    
    @Temporal(TemporalType.DATE)
    @Column(name="identification_date", nullable = false)
    private Date identificationDate;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable = false, updatable=false)
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
    
    @JoinColumn(name="valuer_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person valuerPerson;
    
    //@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "identification")
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "identification")
    private List<Identifier> identifierList;
    
    @Column(name="data_entry_error")
    private String dataEntryError;
    
    @Transient
    private String specimenId;
    
    @Transient
    private String taxonName;
    
    @Transient
    private String identificationStatusName;
    
    @Transient
    private String identificationTypeName;
    
    @Transient
    private String valuerPersonName;
    
    @Transient
    private String identifierPersonName;
    
    @Transient
    private String identificationSequence;
    /** Creates a new instance of Identification */
    public Identification() {
    }
    
    public Identification(IdentificationPK identificationPK) {
        this.setIdentificationPK(identificationPK);
    }
    
    public Identification(Long specimenId, Long identificationSequence, Date initialTimeStamp) {
        this.setIdentificationPK(new IdentificationPK(specimenId, identificationSequence, initialTimeStamp));
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getIdentificationPK() != null ? this.getIdentificationPK().hashCode() : 0);
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
        if (!(object instanceof Identification)) {
            return false;
        }
        Identification other = (Identification)object;
        if (this.getIdentificationPK() != other.getIdentificationPK() && (this.getIdentificationPK() == null || !this.getIdentificationPK().equals(other.getIdentificationPK()))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Identification[identificationPK=" + getIdentificationPK() + "]";
    }         

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Date identificationDate) {
        this.identificationDate = identificationDate;
    }

    public Specimen getSpecimen() {
        return specimen;
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

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }

    public IdentificationStatus getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(IdentificationStatus identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public IdentificationPK getIdentificationPK() {
        return identificationPK;
    }

    public void setIdentificationPK(IdentificationPK identificationPK) {
        this.identificationPK = identificationPK;
    }

    public String getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(String specimenId) {
        this.specimenId = specimenId;
    }

    public String getTaxonName() {
        return taxonName;
    }

    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }

    public String getIdentificationStatusName() {
        return identificationStatusName;
    }

    public void setIdentificationStatusName(String identificationStatusName) {
        this.identificationStatusName = identificationStatusName;
    }

    public String getIdentificationTypeName() {
        return identificationTypeName;
    }

    public void setIdentificationTypeName(String identificationTypeName) {
        this.identificationTypeName = identificationTypeName;
    }

    public String getValuerPersonName() {
        return valuerPersonName;
    }

    public void setValuerPersonName(String valuerPersonName) {
        this.valuerPersonName = valuerPersonName;
    }

    public String getIdentifierPersonName() {
        return identifierPersonName;
    }

    public void setIdentifierPersonName(String identifierPersonName) {
        this.identifierPersonName = identifierPersonName;
    }
    
    @PostLoad
    public void postLoad(){
        this.setSpecimenId(specimen.getId().toString());
        this.setTaxonName(taxon.getDefaultName());
        this.setIdentificationStatusName(identificationStatus.getName());
        this.setIdentificationSequence(this.getIdentificationPK().getIdentificationSequence().toString());
        if (identificationType != null) {
            setIdentificationTypeName(identificationType.getName());
        }
        if (valuerPerson != null) {
            setValuerPersonName(valuerPerson.getFormalFullName());
        }
        if (identifierList != null) {
            if (identifierList.size() > 0) {
                setIdentifierPersonName(this.getIdentifierList().get(0).getPerson().getFormalFullName());
            } else {
                setIdentifierPersonName("Sin definir");
            }
        } else {
            setIdentifierPersonName("Sin definir");
        }
    }

    public List<Identifier> getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(List<Identifier> identifierList) {
        this.identifierList = identifierList;
    }

    public String getIdentificationSequence() {
        return identificationSequence;
    }

    public void setIdentificationSequence(String identificationSequence) {
        this.identificationSequence = identificationSequence;
    }
}
