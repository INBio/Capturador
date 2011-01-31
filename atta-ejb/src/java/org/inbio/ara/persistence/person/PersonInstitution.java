/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.institution.Institution;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "person_institution")

public class PersonInstitution extends GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PersonInstitutionPK personInstitutionPK;

    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Institution institution;

    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;

    public PersonInstitution() {
    }

    public PersonInstitution(PersonInstitutionPK personInstitutionPK) {
        this.personInstitutionPK = personInstitutionPK;
    }

    public PersonInstitution(Long personId, Long institutionId) {
        this.personInstitutionPK = new PersonInstitutionPK(personId, institutionId);
    }

    public PersonInstitutionPK getPersonInstitutionPK() {
        return personInstitutionPK;
    }

    public void setPersonInstitutionPK(PersonInstitutionPK personInstitutionPK) {
        this.personInstitutionPK = personInstitutionPK;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personInstitutionPK != null ? personInstitutionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonInstitution)) {
            return false;
        }
        PersonInstitution other = (PersonInstitution) object;
        if ((this.personInstitutionPK == null && other.personInstitutionPK != null) || (this.personInstitutionPK != null && !this.personInstitutionPK.equals(other.personInstitutionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonInstitution[personInstitutionPK=" + personInstitutionPK + "]";
    }

}
