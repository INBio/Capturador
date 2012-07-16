/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

/**
 *
 * @author jgutierrez
 */
public enum GeographicLayerEntity {



    COUNTRY(new Long(1)),
    PROVINCE(new Long(2));

    private Long id;

    private GeographicLayerEntity(Long id) {
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

    /**
     *
     * @return
     *
     */
    public boolean equals(Long id){
        if(this.getId().longValue() == id.longValue())
            return true;
        else
            return false;
    }



}
