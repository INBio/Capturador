/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import java.util.Date;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class AccessionMovementDTO extends GenericDTO {

    private Long accessionId;

    private String accessionNumber;

    private Date accessionMovementDate;

    private Long weight;

    private Long responsablePersonId;

    private String responsablePerson;

    private Long accessionMovementTypeId;

    private String accessionMovementType;

    private String notes;

    private boolean selected;

    /**
     * @return the accessionId
     */
    public Long getAccessionId() {
        return accessionId;
    }

    /**
     * @param accessionId the accessionId to set
     */
    public void setAccessionId(Long accessionId) {
        this.accessionId = accessionId;
    }

    /**
     * @return the accessionMovementDate
     */
    public Date getAccessionMovementDate() {
        return accessionMovementDate;
    }

    /**
     * @param accessionMovementDate the accessionMovementDate to set
     */
    public void setAccessionMovementDate(Date accessionMovementDate) {
        this.accessionMovementDate = accessionMovementDate;
    }

    /**
     * @return the weight
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * @return the responsablePersonId
     */
    public Long getResponsablePersonId() {
        return responsablePersonId;
    }

    /**
     * @param responsablePersonId the responsablePersonId to set
     */
    public void setResponsablePersonId(Long responsablePersonId) {
        this.responsablePersonId = responsablePersonId;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
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
     * @return the accessionMovementTypeId
     */
    public Long getAccessionMovementTypeId() {
        return accessionMovementTypeId;
    }

    /**
     * @param accessionMovementTypeId the accessionMovementTypeId to set
     */
    public void setAccessionMovementTypeId(Long accessionMovementTypeId) {
        this.accessionMovementTypeId = accessionMovementTypeId;
    }

    /**
     * @return the accessionMovementType
     */
    public String getAccessionMovementType() {
        return accessionMovementType;
    }

    /**
     * @param accessionMovementType the accessionMovementType to set
     */
    public void setAccessionMovementType(String accessionMovementType) {
        this.accessionMovementType = accessionMovementType;
    }

    /**
     * @return the responsablePerson
     */
    public String getResponsablePerson() {
        return responsablePerson;
    }

    /**
     * @param responsablePerson the responsablePerson to set
     */
    public void setResponsablePerson(String responsablePerson) {
        this.responsablePerson = responsablePerson;
    }

    /**
     * @return the accessionNumber
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * @param accessionNumber the accessionNumber to set
     */
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

}
