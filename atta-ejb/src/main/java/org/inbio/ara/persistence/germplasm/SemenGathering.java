/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "semen_gathering")
public class SemenGathering  extends LogGenericEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="semen_gathering")
    @SequenceGenerator(name="semen_gathering", sequenceName="semen_gathering_seq")
    @Basic(optional = false)
    @Column(name = "semen_gathering_id")
    private Long semenGatheringId;
    @Basic(optional = false)
    @Column(name = "semental_id")
    private Long sementalId;


    @Basic(optional = false)
    @Column(name = "semen_gathering_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar semenGatheringDate;

    @Column(name = "semen_gathering_time")
    //@Temporal(TemporalType.TIME)
    private String semenGatheringTime;

    @Basic(optional = false)
    @Column(name = "volume")
    private Double volume;

    @Basic(optional = false)
    @Column(name = "motility")
    private Long motility;

    
    @Column(name = "concentration")
    private Long concentration;

    
    @Column(name = "straw_quantity")
    private Long strawQuantity;

    @Column(name = "current_straw_quantity")
    private Long currentStrawQuantity;

    
    @Column(name = "dilution")
    private String dilution;

    
    @Column(name = "tank_number")
    private Long tankNumber;

    
    @Column(name = "canister_number")
    private Long canisterNumber;

    
    @Column(name = "goblet_number")
    private Long gobletNumber;

    
    @Column(name = "straw_color")
    private String strawColor;

    
    @Column(name = "post_thaw_motility")
    private Long postThawMotility;

    
    @Column(name = "active_doses")
    private Long activeDoses;

    
    @Column(name = "straw_size")
    private Double strawSize;

    
    @Column(name = "semen_consistency_id")
    private Long semenConsistencyId;

    
    @Column(name = "semen_color")
    private String semenColor;

    
    @Column(name = "ph")
    private Long ph;

    
    @Column(name = "mass_motility")
    private Long massMotility;
    
    
    @Column(name = "semen_gathering_method_id")
    private Long semenGatheringMethodId;

    
    @Column(name = "solvent_id")
    private Long solventId;


    @Column(name = "total_sperm_concentration")
    private Long totalSpermConcentration;

    @Column(name = "sperm_concentration_per_straw")
    private Long spermConcentrationPerStraw;

    public SemenGathering() {
    }

    public SemenGathering(Long semenGatheringId) {
        this.semenGatheringId = semenGatheringId;
    }

    public SemenGathering(Long semenGatheringId, Long sementalId, Calendar semenGatheringDate, String semenGatheringTime, Double volume, Long motility, Long concentration, Long strawQuantity, Long currentStrawQuantity, String dilution, Long tankNumber, Long canisterNumber, Long gobletNumber, String strawColor, Long postThawMotility, Long activeDoses, Double strawSize, Long semenConsistencyId, String semenColor, Long ph, Long massMotility, Long totalSpermConcentration, Long spermConcentrationPerStraw, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        
        this.semenGatheringId = semenGatheringId;
        this.sementalId = sementalId;
        this.semenGatheringDate = semenGatheringDate;
        this.semenGatheringTime = semenGatheringTime;
        this.volume = volume;
        this.motility = motility;
        this.concentration = concentration;
        this.strawQuantity = strawQuantity;
        this.currentStrawQuantity = currentStrawQuantity;
        this.dilution = dilution;
        this.tankNumber = tankNumber;
        this.canisterNumber = canisterNumber;
        this.gobletNumber = gobletNumber;
        this.strawColor = strawColor;
        this.postThawMotility = postThawMotility;
        this.activeDoses = activeDoses;
        this.strawSize = strawSize;
        this.semenConsistencyId = semenConsistencyId;
        this.semenColor = semenColor;
        this.ph = ph;
        this.massMotility = massMotility;
        this.totalSpermConcentration = totalSpermConcentration;
        this.spermConcentrationPerStraw = spermConcentrationPerStraw;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }


    public Calendar getSemenGatheringDate() {
        return semenGatheringDate;
    }

    public void setSemenGatheringDate(Calendar semenGatheringDate) {
        this.semenGatheringDate = semenGatheringDate;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Long getMotility() {
        return motility;
    }

    public void setMotility(Long motility) {
        this.motility = motility;
    }

    public Long getConcentration() {
        return concentration;
    }

    public void setConcentration(Long concentration) {
        this.concentration = concentration;
    }

    public Long getStrawQuantity() {
        return strawQuantity;
    }

    public void setStrawQuantity(Long strawQuantity) {
        this.strawQuantity = strawQuantity;
    }

    public String getDilution() {
        return dilution;
    }

    public void setDilution(String dilution) {
        this.dilution = dilution;
    }

    public Long getTankNumber() {
        return tankNumber;
    }

    public void setTankNumber(Long tankNumber) {
        this.tankNumber = tankNumber;
    }

    public Long getCanisterNumber() {
        return canisterNumber;
    }

    public void setCanisterNumber(Long canisterNumber) {
        this.canisterNumber = canisterNumber;
    }

    public Long getGobletNumber() {
        return gobletNumber;
    }

    public void setGobletNumber(Long gobletNumber) {
        this.gobletNumber = gobletNumber;
    }

    public String getStrawColor() {
        return strawColor;
    }

    public void setStrawColor(String strawColor) {
        this.strawColor = strawColor;
    }

    public Long getPostThawMotility() {
        return postThawMotility;
    }

    public void setPostThawMotility(Long postThawMotility) {
        this.postThawMotility = postThawMotility;
    }

    public Long getActiveDoses() {
        return activeDoses;
    }

    public void setActiveDoses(Long activeDoses) {
        this.activeDoses = activeDoses;
    }

    public Double getStrawSize() {
        return strawSize;
    }

    public void setStrawSize(Double strawSize) {
        this.strawSize = strawSize;
    }

    public String getSemenColor() {
        return semenColor;
    }

    public void setSemenColor(String semenColor) {
        this.semenColor = semenColor;
    }

    public Long getPh() {
        return ph;
    }

    public void setPh(Long ph) {
        this.ph = ph;
    }

    public Long getMassMotility() {
        return massMotility;
    }

    public void setMassMotility(Long massMotility) {
        this.massMotility = massMotility;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semenGatheringId != null ? semenGatheringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemenGathering)) {
            return false;
        }
        SemenGathering other = (SemenGathering) object;
        if ((this.semenGatheringId == null && other.semenGatheringId != null) || (this.semenGatheringId != null && !this.semenGatheringId.equals(other.semenGatheringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.SemenGathering[semenGatheringPK=" + semenGatheringId + "]";
    }

    /**
     * @return the semenGatheringMethodId
     */
    public Long getSemenGatheringMethodId() {
        return semenGatheringMethodId;
    }

    /**
     * @param semenGatheringMethodId the semenGatheringMethodId to set
     */
    public void setSemenGatheringMethodId(Long semenGatheringMethodId) {
        this.semenGatheringMethodId = semenGatheringMethodId;
    }

    /**
     * @return the solventId
     */
    public Long getSolventId() {
        return solventId;
    }

    /**
     * @param solventId the solventId to set
     */
    public void setSolventId(Long solventId) {
        this.solventId = solventId;
    }

    /**
     * @return the semenGatheringId
     */
    public Long getSemenGatheringId() {
        return semenGatheringId;
    }

    /**
     * @param semenGatheringId the semenGatheringId to set
     */
    public void setSemenGatheringId(Long semenGatheringId) {
        this.semenGatheringId = semenGatheringId;
    }

    /**
     * @return the sementalId
     */
    public Long getSementalId() {
        return sementalId;
    }

    /**
     * @param sementalId the sementalId to set
     */
    public void setSementalId(Long sementalId) {
        this.sementalId = sementalId;
    }

    /**
     * @return the semenGatheringTime
     */
    public String getSemenGatheringTime() {
        return semenGatheringTime;
    }

    /**
     * @param semenGatheringTime the semenGatheringTime to set
     */
    public void setSemenGatheringTime(String semenGatheringTime) {
        this.semenGatheringTime = semenGatheringTime;
    }

    /**
     * @return the currentStrawQuantity
     */
    public Long getCurrentStrawQuantity() {
        return currentStrawQuantity;
    }

    /**
     * @param currentStrawQuantity the currentStrawQuantity to set
     */
    public void setCurrentStrawQuantity(Long currentStrawQuantity) {
        this.currentStrawQuantity = currentStrawQuantity;
    }

    /**
     * @return the semenConsistencyId
     */
    public Long getSemenConsistencyId() {
        return semenConsistencyId;
    }

    /**
     * @param semenConsistencyId the semenConsistencyId to set
     */
    public void setSemenConsistencyId(Long semenConsistencyId) {
        this.semenConsistencyId = semenConsistencyId;
    }


    /**
     * @return the totalSpermConcentration
     */
    public Long getTotalSpermConcentration() {
        return totalSpermConcentration;
    }

    /**
     * @param totalSpermConcentration the totalSpermConcentration to set
     */
    public void setTotalSpermConcentration(Long totalSpermConcentration) {
        this.totalSpermConcentration = totalSpermConcentration;
    }

    /**
     * @return the spermConcentrationPerStraw
     */
    public Long getSpermConcentrationPerStraw() {
        return spermConcentrationPerStraw;
    }

    /**
     * @param spermConcentrationPerStraw the spermConcentrationPerStraw to set
     */
    public void setSpermConcentrationPerStraw(Long spermConcentrationPerStraw) {
        this.spermConcentrationPerStraw = spermConcentrationPerStraw;
    }

}
