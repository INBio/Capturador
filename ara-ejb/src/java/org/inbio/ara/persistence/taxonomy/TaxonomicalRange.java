/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author asanabria
 */
@Entity
@Table(name = "taxonomical_range")
public class TaxonomicalRange extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "taxonomical_range_id")
	private	Long taxonomicalRangeId;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Column(name = "prefix")
	private String prefix;

	@Basic(optional = false)
	@Column(name = "parenthesis")
	private short parenthesis;

	@Basic(optional = false)
	@Column(name = "taxonomical_range_category")
	private String taxonomicalRangeCategory;

	@Column(name = "field_name")
	private String fieldName;

	@Column(name = "taxonomical_hierarchy_level")
	private Long taxonomicalHierarchyLevel;

	@Basic(optional = false)
	@Column(name = "mandatory_level")
	private short mandatoryLevel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonomicalRangeId", fetch = FetchType.LAZY)
	private Set<Taxon> taxonCollection;

	public TaxonomicalRange() {
	}

	public TaxonomicalRange(Long taxonomicalRangeId) {
		this.taxonomicalRangeId = taxonomicalRangeId;
	}

	public TaxonomicalRange(Long taxonomicalRangeId, String name, short parenthesis, String taxonomicalRangeCategory, short mandatoryLevel, Long objVersion) {
		this.taxonomicalRangeId = taxonomicalRangeId;
		this.name = name;
		this.parenthesis = parenthesis;
		this.taxonomicalRangeCategory = taxonomicalRangeCategory;
		this.mandatoryLevel = mandatoryLevel;
	}

	public Long getTaxonomicalRangeId() {
		return taxonomicalRangeId;
	}

	public void setTaxonomicalRangeId(Long taxonomicalRangeId) {
		this.taxonomicalRangeId = taxonomicalRangeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public short getParenthesis() {
		return parenthesis;
	}

	public void setParenthesis(short parenthesis) {
		this.parenthesis = parenthesis;
	}

	public String getTaxonomicalRangeCategory() {
		return taxonomicalRangeCategory;
	}

	public void setTaxonomicalRangeCategory(String taxonomicalRangeCategory) {
		this.taxonomicalRangeCategory = taxonomicalRangeCategory;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getTaxonomicalHierarchyLevel() {
		return taxonomicalHierarchyLevel;
	}

	public void setTaxonomicalHierarchyLevel(Long taxonomicalHierarchyLevel) {
		this.taxonomicalHierarchyLevel = taxonomicalHierarchyLevel;
	}

	public short getMandatoryLevel() {
		return mandatoryLevel;
	}

	public void setMandatoryLevel(short mandatoryLevel) {
		this.mandatoryLevel = mandatoryLevel;
	}


	public Set<Taxon> getTaxonCollection() {
		return taxonCollection;
	}

	public void setTaxonCollection(Set<Taxon> taxonCollection) {
		this.taxonCollection = taxonCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taxonomicalRangeId != null ? taxonomicalRangeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TaxonomicalRange)) {
			return false;
		}
		TaxonomicalRange other = (TaxonomicalRange) object;
		if ((this.taxonomicalRangeId == null && other.taxonomicalRangeId != null) || (this.taxonomicalRangeId != null && !this.taxonomicalRangeId.equals(other.taxonomicalRangeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.taxonomy.TaxonomicalRange[taxonomicalRangeId=" + taxonomicalRangeId + "]";
	}

}
