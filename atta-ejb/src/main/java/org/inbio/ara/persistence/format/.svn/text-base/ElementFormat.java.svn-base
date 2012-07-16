/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;


import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "element_format")

public class ElementFormat extends LogGenericEntity  {

    @Id
    @Basic(optional = false)
    @Column(name = "element_format_id")
    private Long elementFormatId;
    @Basic(optional = false)
    @Column(name = "element_format_keyword")
    private String elementFormatKeyword;
    

    public ElementFormat() {
    }

    public ElementFormat(Long elementFormatId) {
        this.elementFormatId = elementFormatId;
    }

    public ElementFormat(Long elementFormatId, String elementFormatKeyword, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.elementFormatId = elementFormatId;
        this.elementFormatKeyword = elementFormatKeyword;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getElementFormatId() {
        return elementFormatId;
    }

    public void setElementFormatId(Long elementFormatId) {
        this.elementFormatId = elementFormatId;
    }

    public String getElementFormatKeyword() {
        return elementFormatKeyword;
    }

    public void setElementFormatKeyword(String elementFormatKeyword) {
        this.elementFormatKeyword = elementFormatKeyword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementFormatId != null ? elementFormatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementFormat)) {
            return false;
        }
        ElementFormat other = (ElementFormat) object;
        if ((this.elementFormatId == null && other.elementFormatId != null) || (this.elementFormatId != null && !this.elementFormatId.equals(other.elementFormatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ElementFormat[elementFormatId=" + elementFormatId + "]";
    }

}
