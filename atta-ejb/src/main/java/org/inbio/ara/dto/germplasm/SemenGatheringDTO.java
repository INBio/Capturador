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

package org.inbio.ara.dto.germplasm;

import java.util.Calendar;
import java.util.Date;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class SemenGatheringDTO extends GenericDTO {

    /* For Graphical Inteface purposes */
    private boolean selected;

    private Long semenGatheringId;

    private Long sementalId;

    private Calendar semenGatheringDate;

    private Calendar finalSemenGatheringDate;//just for search purpose

    private String semenGatheringTime;

    private Double volume;

    private Long motility;

    private Long concentration;

    private Long strawQuantity;

    private Long currentStrawQuantity;

    private String dilution;

    private Long tankNumber;

    private Long canisterNumber;

    private Long gobletNumber;

    private String strawColor;

    private Long postThawMotility;

    private Long activeDoses;

    private Double strawSize;

    private Long semenConsistencyId;

    private String semenConsistency;

    private String semenColor;

    private Long ph;

    private Long massMotility;

    private Long semenGatheringMethodId;

    private String semenGatheringMethod;

    private Long solventId;

    private String solvent;

    
    private Long totalSpermConcentration;

    private Long spermConcentrationPerStraw;

    public void imprimir()
    {
        System.out.println(

      "  \n sgId: " + semenGatheringId

     + "  \n smentalId: " + sementalId

     + "  \n semenGatheringDate: " +  semenGatheringDate

     + "  \n finalSemenGatheringDate: " +  finalSemenGatheringDate//just for search purpose

     + "  \n semenGatheringTime: " +  semenGatheringTime

     + "  \n volume: " + volume

     + "  \n motility: " + motility

     + "  \n concentration: " + concentration

     + "  \n strawQuantity: " + strawQuantity

     + "  \n currentStrawQuantity: " + currentStrawQuantity

     + "  \n dilution: " +  dilution

     + "  \n tankNumber: " + tankNumber

     + "  \n canisterNumber: " + canisterNumber

     + "  \n gobletNumber: " + gobletNumber

     + "  \n strawColor: " +  strawColor

     + "  \n postThawMotility: " + postThawMotility

     + "  \n activeDoses: " + activeDoses

     + "  \n strawSize: " + strawSize

     + "  \n consistency: " +  getSemenConsistencyId()

     + "  \n consistency: " +  getSemenConsistency()

     + "  \n semenColor: " +  semenColor

     + "  \n ph: " + ph

     + "  \n massMotility: " + massMotility

     + "  \n semenGatheringMethodId: " + semenGatheringMethodId

     + "  \n semenGatheringMethod: " +  semenGatheringMethod

     + "  \n solventId: " + solventId

     + "  \n solvent: " +  solvent);
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
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
     * @return the semenGatheringDate
     */
    public Calendar getSemenGatheringDate() {
        return semenGatheringDate;
    }

    /**
     * @param semenGatheringDate the semenGatheringDate to set
     */
    public void setSemenGatheringDate(Calendar semenGatheringDate) {
        this.semenGatheringDate = semenGatheringDate;
    }


    /**
     * @return the volume
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * @return the motility
     */
    public Long getMotility() {
        return motility;
    }

    /**
     * @param motility the motility to set
     */
    public void setMotility(Long motility) {
        this.motility = motility;
    }

    /**
     * @return the concentration
     */
    public Long getConcentration() {
        return concentration;
    }

    /**
     * @param concentration the concentration to set
     */
    public void setConcentration(Long concentration) {
        this.concentration = concentration;
    }

    /**
     * @return the strawQuantity
     */
    public Long getStrawQuantity() {
        return strawQuantity;
    }

    /**
     * @param strawQuantity the strawQuantity to set
     */
    public void setStrawQuantity(Long strawQuantity) {
        this.strawQuantity = strawQuantity;
    }

    /**
     * @return the dilution
     */
    public String getDilution() {
        return dilution;
    }

    /**
     * @param dilution the dilution to set
     */
    public void setDilution(String dilution) {
        this.dilution = dilution;
    }

    /**
     * @return the tankNumber
     */
    public Long getTankNumber() {
        return tankNumber;
    }

    /**
     * @param tankNumber the tankNumber to set
     */
    public void setTankNumber(Long tankNumber) {
        this.tankNumber = tankNumber;
    }

    /**
     * @return the canisterNumber
     */
    public Long getCanisterNumber() {
        return canisterNumber;
    }

    /**
     * @param canisterNumber the canisterNumber to set
     */
    public void setCanisterNumber(Long canisterNumber) {
        this.canisterNumber = canisterNumber;
    }

    /**
     * @return the gobletNumber
     */
    public Long getGobletNumber() {
        return gobletNumber;
    }

    /**
     * @param gobletNumber the gobletNumber to set
     */
    public void setGobletNumber(Long gobletNumber) {
        this.gobletNumber = gobletNumber;
    }

    /**
     * @return the strawColor
     */
    public String getStrawColor() {
        return strawColor;
    }

    /**
     * @param strawColor the strawColor to set
     */
    public void setStrawColor(String strawColor) {
        this.strawColor = strawColor;
    }

    /**
     * @return the postThawMotility
     */
    public Long getPostThawMotility() {
        return postThawMotility;
    }

    /**
     * @param postThawMotility the postThawMotility to set
     */
    public void setPostThawMotility(Long postThawMotility) {
        this.postThawMotility = postThawMotility;
    }

    /**
     * @return the activeDoses
     */
    public Long getActiveDoses() {
        return activeDoses;
    }

    /**
     * @param activeDoses the activeDoses to set
     */
    public void setActiveDoses(Long activeDoses) {
        this.activeDoses = activeDoses;
    }

    /**
     * @return the strawSize
     */
    public Double getStrawSize() {
        return strawSize;
    }

    /**
     * @param strawSize the strawSize to set
     */
    public void setStrawSize(Double strawSize) {
        this.strawSize = strawSize;
    }

    /**
     * @return the semenColor
     */
    public String getSemenColor() {
        return semenColor;
    }

    /**
     * @param semenColor the semenColor to set
     */
    public void setSemenColor(String semenColor) {
        this.semenColor = semenColor;
    }

    /**
     * @return the ph
     */
    public Long getPh() {
        return ph;
    }

    /**
     * @param ph the ph to set
     */
    public void setPh(Long ph) {
        this.ph = ph;
    }

    /**
     * @return the massMotility
     */
    public Long getMassMotility() {
        return massMotility;
    }

    /**
     * @param massMotility the massMotility to set
     */
    public void setMassMotility(Long massMotility) {
        this.massMotility = massMotility;
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
     * @return the semenGatheringMethod
     */
    public String getSemenGatheringMethod() {
        return semenGatheringMethod;
    }

    /**
     * @param semenGatheringMethod the semenGatheringMethod to set
     */
    public void setSemenGatheringMethod(String semenGatheringMethod) {
        this.semenGatheringMethod = semenGatheringMethod;
    }

    /**
     * @return the solvent
     */
    public String getSolvent() {
        return solvent;
    }

    /**
     * @param solvent the solvent to set
     */
    public void setSolvent(String solvent) {
        this.solvent = solvent;
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
     * @return the finalSemenGatheringDate
     */
    public Calendar getFinalSemenGatheringDate() {
        return finalSemenGatheringDate;
    }

    /**
     * @param finalSemenGatheringDate the finalSemenGatheringDate to set
     */
    public void setFinalSemenGatheringDate(Calendar finalSemenGatheringDate) {
        this.finalSemenGatheringDate = finalSemenGatheringDate;
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
     * @return the semenConsistency
     */
    public String getSemenConsistency() {
        return semenConsistency;
    }

    /**
     * @param semenConsistency the semenConsistency to set
     */
    public void setSemenConsistency(String semenConsistency) {
        this.semenConsistency = semenConsistency;
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
