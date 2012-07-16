/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "person_profile")

public class PersonProfile extends GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PersonProfilePK personProfilePK;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "valid_from")
    private BigDecimal validFrom;

    @Column(name = "valid_to")
    private BigDecimal validTo;

    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile profile;

    public PersonProfile() {
    }

    public PersonProfile(PersonProfilePK personProfilePK) {
        this.personProfilePK = personProfilePK;
    }

    public PersonProfile(Long personId, Long profileId) {
        this.personProfilePK = new PersonProfilePK(personId, profileId);
    }

    public PersonProfilePK getPersonProfilePK() {
        return personProfilePK;
    }

    public void setPersonProfilePK(PersonProfilePK personProfilePK) {
        this.personProfilePK = personProfilePK;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BigDecimal getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(BigDecimal validFrom) {
        this.validFrom = validFrom;
    }

    public BigDecimal getValidTo() {
        return validTo;
    }

    public void setValidTo(BigDecimal validTo) {
        this.validTo = validTo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personProfilePK != null ? personProfilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonProfile)) {
            return false;
        }
        PersonProfile other = (PersonProfile) object;
        if ((this.personProfilePK == null && other.personProfilePK != null) || (this.personProfilePK != null && !this.personProfilePK.equals(other.personProfilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonProfile[personProfilePK=" + personProfilePK + "]";
    }

}
