/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author asanabria
 */
@Entity
@Table(name = "taxonomical_hierarchy")
public class TaxonomicalHierarchy implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected TaxonomicalHierarchyPK taxonomicalHierarchyPK;

	@JoinColumn(name = "ancestor_taxonomical_id", referencedColumnName = "taxonomical_range_id", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TaxonomicalRange taxonomicalRangeAncestor;

	@JoinColumn(name = "taxonomical_range_id", referencedColumnName = "taxonomical_range_id", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TaxonomicalRange taxonomicalRange;

	public TaxonomicalHierarchy() {
	}

	public TaxonomicalRange getTaxonomicalRange() {
		return taxonomicalRange;
	}

	public void setTaxonomicalRange(TaxonomicalRange taxonomicalRange) {
		this.taxonomicalRange = taxonomicalRange;
	}

	public TaxonomicalRange getTaxonomicalRangeAncestor() {
		return taxonomicalRangeAncestor;
	}

	public void setTaxonomicalRangeAncestor(TaxonomicalRange taxonomicalRangeAncestor) {
		this.taxonomicalRangeAncestor = taxonomicalRangeAncestor;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taxonomicalHierarchyPK != null ? taxonomicalHierarchyPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TaxonomicalHierarchy)) {
			return false;
		}
		TaxonomicalHierarchy other = (TaxonomicalHierarchy) object;
		if ((this.taxonomicalHierarchyPK == null && other.taxonomicalHierarchyPK != null) || (this.taxonomicalHierarchyPK != null && !this.taxonomicalHierarchyPK.equals(other.taxonomicalHierarchyPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchy[taxonomicalHierarchyPK=" + taxonomicalHierarchyPK + "]";
	}

}
