/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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
package org.inbio.ara.persistence.identification;

import org.inbio.ara.persistence.taxonomy.*;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "identification")
public class Identification extends LogGenericEntity {

    @EmbeddedId
    protected IdentificationPK identificationPK;

    @Basic(optional = false)
    @Column(name = "identification_date")
    @Temporal(TemporalType.DATE)
    private Calendar identificationDate;

    @Column(name = "data_entry_error")
    @Basic(optional = true)
    private String dataEntryError;

    @JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Specimen specimen;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Taxon taxon;

    @JoinColumn(name = "valuer_person_id", referencedColumnName = "person_id")
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Person valuerPerson;

    @JoinColumn(name = "identification_type_id", referencedColumnName = "identification_type_id")
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private IdentificationType identificationType;

    @JoinColumn(name = "identification_status_id", referencedColumnName = "identification_status_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private IdentificationStatus identificationStatus;

    @Transient
    private Long collectionId;

    @JoinColumns({
        @JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id", updatable = false, insertable = false),
        @JoinColumn(name = "identification_sequence", referencedColumnName = "identification_sequence", updatable = false, insertable = false),
        @JoinColumn(name = "initial_timestamp", referencedColumnName = "initial_timestamp", updatable = false, insertable = false)
    })
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Identifier> identifiers;


    /**
     * Method used to set the collectionId variable needed in
     * BaseEAO -> findAllPaginatedOrderBy(...)
     */
    @PostLoad
    private void onLoad() {
        if(specimen != null)
            this.collectionId = specimen.getCollectionId();
    }



    public Identification() {
    }

    public Identification(IdentificationPK identificationPK) {
        this.identificationPK = identificationPK;
    }

    public Identification(IdentificationPK identificationPK,
            Calendar identificationDate, String createdBy,
            Calendar creationDate, Calendar lastModificationDate,
            String lastModificationBy) {
        this.identificationPK = identificationPK;
        this.identificationDate = identificationDate;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationDate(lastModificationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public Identification(Long specimenId, Long identificationSequence, Calendar initialTimestamp) {
        this.identificationPK = new IdentificationPK(specimenId, identificationSequence, initialTimestamp);
    }

    public IdentificationPK getIdentificationPK() {
        return identificationPK;
    }

    public void setIdentificationPK(IdentificationPK identificationPK) {
        this.identificationPK = identificationPK;
    }

    public Calendar getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Calendar identificationDate) {
        this.identificationDate = identificationDate;
    }

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public IdentificationStatus getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(IdentificationStatus identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Person getValuerPerson() {
        return valuerPerson;
    }

    public void setValuerPerson(Person valuerPerson) {
        this.valuerPerson = valuerPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificationPK != null ? identificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identification)) {
            return false;
        }
        Identification other = (Identification) object;
        if ((this.identificationPK == null && other.identificationPK != null) || (this.identificationPK != null && !this.identificationPK.equals(other.identificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Identification[identificationPK=" + identificationPK + "]";
    }

    /**
     * @return the collectionId
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId the collectionId to set
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }
}
