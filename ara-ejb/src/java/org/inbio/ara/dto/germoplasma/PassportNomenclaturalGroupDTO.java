/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germoplasma;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class PassportNomenclaturalGroupDTO extends GenericDTO {

    private Long passportId;

    private Long nomenclaturalGroupId;

    private String nomenclaturalGroupName;


    /**
     * @return the passportId
     */
    public Long getPassportId() {
        return passportId;
    }

    /**
     * @param passportId the passportId to set
     */
    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    /**
     * @return the nomenclaturalGroupId
     */
    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    /**
     * @param nomenclaturalGroupId the nomenclaturalGroupId to set
     */
    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    /**
     * @return the nomenclaturalGroupName
     */
    public String getNomenclaturalGroupName() {
        return nomenclaturalGroupName;
    }

    /**
     * @param nomenclaturalGroupName the nomenclaturalGroupName to set
     */
    public void setNomenclaturalGroupName(String nomenclaturalGroupName) {
        this.nomenclaturalGroupName = nomenclaturalGroupName;
    }

}