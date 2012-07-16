/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

/**
 *
 * @author gsulca
 */


public enum ProjectionEntity {
    //El WGS_84 siempre debe existir en el entity, las demàs proyecciones pueden variar
    //dependiendo de la zona donde se trabaje.
    WGS_84(new Long(4326), "WGS 84"),
    CRTM05(new Long(97134), "CRTM05"),
    LAMBERT_NORTE(new Long(97135), "Lambert Norte"),
    LAMBERT_SUR(new Long(97136), "Lambert Sur");
  

    private Long id;
    private String name;

    private ProjectionEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }


    public static ProjectionEntity getById(Long id) {

        ProjectionEntity[] all = ProjectionEntity.values();
        for (ProjectionEntity tre : all) {
            System.out.println(tre.getId()+" = "+id);
            if (tre.getId().equals(id)) {
                System.out.println(tre.getName());
                return tre;
            }
        }
        return null;

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
     * @return the column
     */
    public String getName() {
        return name;
    }

    /**
     * @param column the column to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
 

