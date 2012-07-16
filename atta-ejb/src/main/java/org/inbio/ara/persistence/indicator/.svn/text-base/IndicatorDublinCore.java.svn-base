/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.indicator;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "indicator_dublin_core")

public class IndicatorDublinCore extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IndicatorDublinCorePK indicatorDublinCorePK;

    /*
    @JoinColumn(name = "indicator_id", referencedColumnName = "indicator_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Indicator indicator;
*/
    public IndicatorDublinCore() {
    }

    public IndicatorDublinCore(IndicatorDublinCorePK indicatorDublinCorePK) {
        this.indicatorDublinCorePK = indicatorDublinCorePK;
    }

    public IndicatorDublinCore(IndicatorDublinCorePK indicatorDublinCorePK,String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.indicatorDublinCorePK = indicatorDublinCorePK;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public IndicatorDublinCore(Long dublinCoreId, Long indicatorId) {
        this.indicatorDublinCorePK = new IndicatorDublinCorePK(dublinCoreId, indicatorId);
    }

    public IndicatorDublinCorePK getIndicatorDublinCorePK() {
        return indicatorDublinCorePK;
    }

    public void setIndicatorDublinCorePK(IndicatorDublinCorePK indicatorDublinCorePK) {
        this.indicatorDublinCorePK = indicatorDublinCorePK;
    }

    /*
    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicatorDublinCorePK != null ? indicatorDublinCorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicatorDublinCore)) {
            return false;
        }
        IndicatorDublinCore other = (IndicatorDublinCore) object;
        if ((this.indicatorDublinCorePK == null && other.indicatorDublinCorePK != null) || (this.indicatorDublinCorePK != null && !this.indicatorDublinCorePK.equals(other.indicatorDublinCorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.IndicatorDublinCore[indicatorDublinCorePK=" + indicatorDublinCorePK + "]";
    }

}
