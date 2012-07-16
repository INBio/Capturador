/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "user_taxon")

public class UserTaxon extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected UserTaxonPK userTaxonPK;

    /*@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SystemUser systemUser;*/

    /*@JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Taxon taxon;*/

    public UserTaxon() {
    }

    public UserTaxon(UserTaxonPK userTaxonPK) {
        this.userTaxonPK = userTaxonPK;
    }

    public UserTaxon(UserTaxonPK userTaxonPK, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.userTaxonPK = userTaxonPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationDate(lastModificationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public UserTaxon(Long taxonId, Long userId, Long sequence) {
        this.userTaxonPK = new UserTaxonPK(taxonId, userId, sequence);
    }

    public UserTaxonPK getUserTaxonPK() {
        return userTaxonPK;
    }

    public void setUserTaxonPK(UserTaxonPK userTaxonPK) {
        this.userTaxonPK = userTaxonPK;
    }

    /*public Long getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(Long systemUser) {
        this.systemUser = systemUser;
    }

    public Long getTaxon() {
        return taxon;
    }

    public void setTaxon(Long taxon) {
        this.taxon = taxon;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTaxonPK != null ? userTaxonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTaxon)) {
            return false;
        }
        UserTaxon other = (UserTaxon) object;
        if ((this.userTaxonPK == null && other.userTaxonPK != null) || (this.userTaxonPK != null && !this.userTaxonPK.equals(other.userTaxonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.UserTaxon[userTaxonPK=" + userTaxonPK + "]";
    }

}
