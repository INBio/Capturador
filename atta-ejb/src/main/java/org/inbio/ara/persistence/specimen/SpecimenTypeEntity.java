/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

/**
 * Este enum es para poder manejar de una forma menos "alambrada" los tipos de especimenes,
 * ya que antes se usaban los valores de la tabla directamente desde la GUI
 *
 * @author esmata
 */
public enum SpecimenTypeEntity {
    ORGANISMO(new Long(1)),
    MULTIPLES_INDIVIDUOS(new Long(2));

    private Long id;

    private SpecimenTypeEntity(Long id){
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
