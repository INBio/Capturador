/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

/**
 *
 * @author esmata
 */
public enum SpecimenCategoryEntity {
    OBSERVACION(new Long(1)),
    INDIVIDUAL(new Long(2)),
    AGRUPADO_UNITAXON(new Long(3)),
    AGRUPADO_MULTITAXON(new Long(4));

    private Long id;

    private SpecimenCategoryEntity(Long id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
