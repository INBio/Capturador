/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.share;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "pli_element")
@NamedQueries({@NamedQuery(name = "PliElement.findAll", query = "SELECT p FROM PliElement p"), @NamedQuery(name = "PliElement.findByElementId", query = "SELECT p FROM PliElement p WHERE p.elementId = :elementId"), @NamedQuery(name = "PliElement.findByElementName", query = "SELECT p FROM PliElement p WHERE p.elementName = :elementName"), @NamedQuery(name = "PliElement.findByElementKeyword", query = "SELECT p FROM PliElement p WHERE p.elementKeyword = :elementKeyword"), @NamedQuery(name = "PliElement.findByElementRequired", query = "SELECT p FROM PliElement p WHERE p.elementRequired = :elementRequired")})
public class PliElement implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "element_required")
    private String elementRequired;

    public PliElement() {
    }

    public PliElement(BigDecimal elementId) {
        this.elementId = elementId;
    }

    public PliElement(BigDecimal elementId, String elementName, String elementKeyword, String elementRequired) {
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementKeyword = elementKeyword;
        this.elementRequired = elementRequired;
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

    public String getElementRequired() {
        return elementRequired;
    }

    public void setElementRequired(String elementRequired) {
        this.elementRequired = elementRequired;
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
        if (!(object instanceof PliElement)) {
            return false;
        }
        PliElement other = (PliElement) object;
        if ((this.elementId == null && other.elementId != null) || (this.elementId != null && !this.elementId.equals(other.elementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.share.PliElement[elementId=" + elementId + "]";
    }

}
