/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable
public class PersonInstitutionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id")
    private Long personId;

    @Basic(optional = false)
    @Column(name = "institution_id")
    private Long institutionId;

    public PersonInstitutionPK() {
    }

    public PersonInstitutionPK(Long personId, Long institutionId) {
        this.personId = personId;
        this.institutionId = institutionId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        hash += (institutionId != null ? institutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonInstitutionPK)) {
            return false;
        }
        PersonInstitutionPK other = (PersonInstitutionPK) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        if ((this.institutionId == null && other.institutionId != null) || (this.institutionId != null && !this.institutionId.equals(other.institutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonInstitutionPK[personId=" + personId + ", institutionId=" + institutionId + "]";
    }

}
