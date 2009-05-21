/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "dwc_element")
@NamedQueries({@NamedQuery(name = "DwcElement.findAll", query = "SELECT d FROM DwcElement d"), @NamedQuery(name = "DwcElement.findByElementId", query = "SELECT d FROM DwcElement d WHERE d.elementId = :elementId"), @NamedQuery(name = "DwcElement.findByElementName", query = "SELECT d FROM DwcElement d WHERE d.elementName = :elementName"), @NamedQuery(name = "DwcElement.findByElementKeyword", query = "SELECT d FROM DwcElement d WHERE d.elementKeyword = :elementKeyword")})
public class DwcElement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "element_id")
    private BigDecimal elementId;
    @Basic(optional = false)
    @Column(name = "element_name")
    private String elementName;
    @Basic(optional = false)
    @Column(name = "element_keyword")
    private String elementKeyword;
    @JoinColumn(name = "element_category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private DwcCategory elementCategoryId;

    public DwcElement() {
    }

    public DwcElement(BigDecimal elementId) {
        this.elementId = elementId;
    }

    public DwcElement(BigDecimal elementId, String elementName, String elementKeyword) {
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementKeyword = elementKeyword;
    }

    public BigDecimal getElementId() {
        return elementId;
    }

    public void setElementId(BigDecimal elementId) {
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
        return "org.inbio.ara.persistence.specimen.DwcElement[elementId=" + elementId + "]";
    }

}
