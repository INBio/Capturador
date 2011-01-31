/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.reports;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "dwc_category")

public class DwcCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "category_id")
    private Long categoryId;

    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;

    @Basic(optional = false)
    @Column(name = "category_keyword")
    private String categoryKeyword;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementCategoryId", fetch = FetchType.LAZY)
    private List<DwcElement> dwcElementCollection;

    public DwcCategory() {
    }

    public DwcCategory(Long categoryId) {
        this.categoryId = categoryId;
    }

    public DwcCategory(Long categoryId, String categoryName, String categoryKeyword) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryKeyword = categoryKeyword;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
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

    public List<DwcElement> getDwcElementCollection() {
        return dwcElementCollection;
    }

    public void setDwcElementCollection(List<DwcElement> dwcElementCollection) {
        this.dwcElementCollection = dwcElementCollection;
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
        return "org.inbio.ara.persistence.reports.DwcCategory[categoryId=" + categoryId + "]";
    }

}
