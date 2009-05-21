/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "dwc_category")
@NamedQueries({@NamedQuery(name = "DwcCategory.findAll", query = "SELECT d FROM DwcCategory d"), @NamedQuery(name = "DwcCategory.findByCategoryId", query = "SELECT d FROM DwcCategory d WHERE d.categoryId = :categoryId"), @NamedQuery(name = "DwcCategory.findByCategoryName", query = "SELECT d FROM DwcCategory d WHERE d.categoryName = :categoryName"), @NamedQuery(name = "DwcCategory.findByCategoryKeyword", query = "SELECT d FROM DwcCategory d WHERE d.categoryKeyword = :categoryKeyword")})
public class DwcCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "category_id")
    private BigDecimal categoryId;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "category_keyword")
    private String categoryKeyword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementCategoryId")
    private Collection<DwcElement> dwcElementsCollection;

    public DwcCategory() {
    }

    public DwcCategory(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public DwcCategory(BigDecimal categoryId, String categoryName, String categoryKeyword) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryKeyword = categoryKeyword;
    }

    public BigDecimal getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryKeyword() {
        return categoryKeyword;
    }

    public void setCategoryKeyword(String categoryKeyword) {
        this.categoryKeyword = categoryKeyword;
    }

    public Collection<DwcElement> getDwcElementsCollection() {
        return dwcElementsCollection;
    }

    public void setDwcElementsCollection(Collection<DwcElement> dwcElementsCollection) {
        this.dwcElementsCollection = dwcElementsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwcCategory)) {
            return false;
        }
        DwcCategory other = (DwcCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.DwcCategory[categoryId=" + categoryId + "]";
    }

}
