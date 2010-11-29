/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;


import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "funcionality_type")
public class FuncionalityType  extends LogGenericEntity  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "funcionality_type_id")
    private Long funcionalityTypeId;
    @Basic(optional = false)
    @Column(name = "funcionality_type_keyword")
    private String funcionalityTypeKeyword;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @OneToMany(mappedBy = "funcionalityTypeId", fetch = FetchType.LAZY)
    private List<ReportLayout> reportLayoutList;

    public FuncionalityType() {
    }

    public FuncionalityType(Long funcionalityTypeId) {
        this.funcionalityTypeId = funcionalityTypeId;
    }

    public FuncionalityType(Long funcionalityTypeId, String funcionalityTypeKeyword, String description, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.funcionalityTypeId = funcionalityTypeId;
        this.funcionalityTypeKeyword= funcionalityTypeKeyword;
        this.description = description;
    }

    public Long getFuncionalityTypeId() {
        return funcionalityTypeId;
    }

    public void setFuncionalityTypeId(Long funcionalityTypeId) {
        this.funcionalityTypeId = funcionalityTypeId;
    }

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReportLayout> getReportLayoutList() {
        return reportLayoutList;
    }

    public void setReportLayoutList(List<ReportLayout> reportLayoutList) {
        this.reportLayoutList = reportLayoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionalityTypeId != null ? funcionalityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalityType)) {
            return false;
        }
        FuncionalityType other = (FuncionalityType) object;
        if ((this.funcionalityTypeId == null && other.funcionalityTypeId != null) || (this.funcionalityTypeId != null && !this.funcionalityTypeId.equals(other.funcionalityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.formats.FuncionalityType[funcionalityTypeId=" + funcionalityTypeId + "]";
    }

    /**
     * @return the funcionalityTypeKeyword
     */
    public String getFuncionalityTypeKeyword() {
        return funcionalityTypeKeyword;
    }

    /**
     * @param funcionalityTypeKeyword the funcionalityTypeKeyword to set
     */
    public void setFuncionalityTypeKeyword(String funcionalityTypeKeyword) {
        this.funcionalityTypeKeyword = funcionalityTypeKeyword;
    }

}
