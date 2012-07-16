/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "reference")

public class Reference extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "reference_id")
    private Long referenceId;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Column(name = "identifier")
    private String identifier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reference", fetch = FetchType.LAZY)
    private List<TaxonDescriptionRecordReference> taxonDescriptionRecordReferenceCollection;

    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language languageId;

    @JoinColumn(name = "reference_type_id", referencedColumnName = "reference_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReferenceType referenceTypeId;

    public Reference() {
    }

    public Reference(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Reference(Long referenceId, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate, String title) {
        this.referenceId = referenceId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        this.title = title;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<TaxonDescriptionRecordReference> getTaxonDescriptionRecordReferenceCollection() {
        return taxonDescriptionRecordReferenceCollection;
    }

    public void setTaxonDescriptionRecordReferenceCollection(List<TaxonDescriptionRecordReference> taxonDescriptionRecordReferenceCollection) {
        this.taxonDescriptionRecordReferenceCollection = taxonDescriptionRecordReferenceCollection;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public ReferenceType getReferenceTypeId() {
        return referenceTypeId;
    }

    public void setReferenceTypeId(ReferenceType referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceId != null ? referenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.referenceId == null && other.referenceId != null) || (this.referenceId != null && !this.referenceId.equals(other.referenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Reference[referenceId=" + referenceId + "]";
    }

}
