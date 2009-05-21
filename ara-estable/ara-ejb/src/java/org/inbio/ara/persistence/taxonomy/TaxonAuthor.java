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
 * TaxonAuthor.java
 *
 * Created on June 22, 2007, 2:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.PersonProfile;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class TaxonAuthor
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxon_author")
public class TaxonAuthor extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected TaxonAuthorPK taxonAuthorPK;

    @JoinColumns(value =  {
            @JoinColumn(name = "taxon_author_person_id", referencedColumnName = "person_id", insertable = false, updatable = false),
            @JoinColumn(name = "taxon_author_person_profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
        })
    @ManyToOne()
    private PersonProfile personProfile;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false)
    @ManyToOne()
    private Taxon taxon;

    @JoinColumn(name = "taxon_author_connector_id", referencedColumnName = "taxon_author_connector_id")
    @ManyToOne()
    private TaxonAuthorConnector taxonAuthorConnectorId;
    
    /** Creates a new instance of TaxonAuthor */
    public TaxonAuthor() {
    }

    /**
     * Creates a new instance of TaxonAuthor with the specified values.
     * @param taxonAuthorPK the taxonAuthorPK of the TaxonAuthor
     */
    public TaxonAuthor(TaxonAuthorPK taxonAuthorPK) {
        this.taxonAuthorPK = taxonAuthorPK;
    }

    /**
     * Creates a new instance of TaxonAuthorPK with the specified values.
     * @param taxonAuthorSequence the taxonAuthorSequence of the TaxonAuthorPK
     * @param category the category of the TaxonAuthorPK
     * @param taxonId the taxonId of the TaxonAuthorPK
     */
    public TaxonAuthor(Long taxonAuthorSequence, String category, Long taxonId) {
        this.taxonAuthorPK = new TaxonAuthorPK(taxonAuthorSequence, category, taxonId);
    }

    /**
     * Gets the taxonAuthorPK of this TaxonAuthor.
     * @return the taxonAuthorPK
     */
    public TaxonAuthorPK getTaxonAuthorPK() {
        return this.taxonAuthorPK;
    }

    /**
     * Sets the taxonAuthorPK of this TaxonAuthor to the specified value.
     * @param taxonAuthorPK the new taxonAuthorPK
     */
    public void setTaxonAuthorPK(TaxonAuthorPK taxonAuthorPK) {
        this.taxonAuthorPK = taxonAuthorPK;
    }
    
    /**
     * Gets the taxonAuthorPersonId of this TaxonAuthor.
     * @return the taxonAuthorPersonId
     */
    public PersonProfile getPersonProfile() {
        return this.personProfile;
    }

    /**
     * Sets the taxonAuthorPersonId of this TaxonAuthor to the specified value.
     * @param taxonAuthorPersonId the new taxonAuthorPersonId
     */
    public void setTaxonAuthorPersonId(PersonProfile personProfile) {
        this.personProfile = personProfile;
    }

    /**
     * Gets the taxon of this TaxonAuthor.
     * @return the taxon
     */
    public Taxon getTaxon() {
        return this.taxon;
    }

    /**
     * Sets the taxon of this TaxonAuthor to the specified value.
     * @param taxon the new taxon
     */
    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    /**
     * Gets the taxonAuthorConnectorId of this TaxonAuthor.
     * @return the taxonAuthorConnectorId
     */
    public TaxonAuthorConnector getTaxonAuthorConnectorId() {
        return this.taxonAuthorConnectorId;
    }

    /**
     * Sets the taxonAuthorConnectorId of this TaxonAuthor to the specified value.
     * @param taxonAuthorConnectorId the new taxonAuthorConnectorId
     */
    public void setTaxonAuthorConnectorId(TaxonAuthorConnector taxonAuthorConnectorId) {
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonAuthorPK != null ? this.taxonAuthorPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonAuthor.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonAuthor object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonAuthor)) {
            return false;
        }
        TaxonAuthor other = (TaxonAuthor)object;
        if (this.taxonAuthorPK != other.taxonAuthorPK && (this.taxonAuthorPK == null || !this.taxonAuthorPK.equals(other.taxonAuthorPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonAuthor[taxonAuthorPK=" + taxonAuthorPK + "]";
    }
    
}
