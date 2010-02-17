/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author asanabria
 */
@Embeddable
public class TaxonomicalHierarchyPK implements Serializable {
	@Basic(optional = false)
	@Column(name = "taxonomical_range_id")
	private Long taxonomicalRangeId;
	@Basic(optional = false)
	@Column(name = "ancestor_taxonomical_id")
	private Long ancestorTaxonomicalId;

	public Long getTaxonomicalRangeId() {
		return taxonomicalRangeId;
	}

	public void setTaxonomicalRangeId(Long taxonomicalRangeId) {
		this.taxonomicalRangeId = taxonomicalRangeId;
	}

	public Long getAncestorTaxonomicalId() {
		return ancestorTaxonomicalId;
	}

	public void setAncestorTaxonomicalId(Long ancestorTaxonomicalId) {
		this.ancestorTaxonomicalId = ancestorTaxonomicalId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taxonomicalRangeId != null ? taxonomicalRangeId.hashCode() : 0);
		hash += (ancestorTaxonomicalId != null ? ancestorTaxonomicalId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TaxonomicalHierarchyPK)) {
			return false;
		}
		TaxonomicalHierarchyPK other = (TaxonomicalHierarchyPK) object;
		if ((this.taxonomicalRangeId == null && other.taxonomicalRangeId != null) || (this.taxonomicalRangeId != null && !this.taxonomicalRangeId.equals(other.taxonomicalRangeId))) {
			return false;
		}
		if ((this.ancestorTaxonomicalId == null && other.ancestorTaxonomicalId != null) || (this.ancestorTaxonomicalId != null && !this.ancestorTaxonomicalId.equals(other.ancestorTaxonomicalId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchyPK[taxonomicalRangeId=" + taxonomicalRangeId + ", ancestorTaxonomicalId=" + ancestorTaxonomicalId + "]";
	}
}
