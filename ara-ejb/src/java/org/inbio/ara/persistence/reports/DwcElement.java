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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "dwc_element")

public class DwcElement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "element_id")
    private Long elementId;

    @Basic(optional = false)
    @Column(name = "element_name")
    private String elementName;

    @Basic(optional = false)
    @Column(name = "element_keyword")
    private String elementKeyword;

    @Basic(optional = false)
    @Column(name = "element_required")
    private String elementRequired;

    @JoinColumn(name = "element_category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DwcCategory elementCategoryId;

    public DwcElement() {
    }

    public DwcElement(Long elementId) {
        this.elementId = elementId;
    }

    public DwcElement(Long elementId, String elementName, String elementKeyword, String elementRequired) {
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementKeyword = elementKeyword;
        this.elementRequired = elementRequired;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementKeyword() {
        return elementKeyword;
    }

    public void setElementKeyword(String elementKeyword) {
        this.elementKeyword = elementKeyword;
    }

    public String getElementRequired() {
        return elementRequired;
    }

    public void setElementRequired(String elementRequired) {
        this.elementRequired = elementRequired;
    }

    public DwcCategory getElementCategoryId() {
        return elementCategoryId;
    }

    public void setElementCategoryId(DwcCategory elementCategoryId) {
        this.elementCategoryId = elementCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementId != null ? elementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwcElement)) {
            return false;
        }
        DwcElement other = (DwcElement) object;
        if ((this.elementId == null && other.elementId != null) || (this.elementId != null && !this.elementId.equals(other.elementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reports.DwcElement[elementId=" + elementId + "]";
    }

}
