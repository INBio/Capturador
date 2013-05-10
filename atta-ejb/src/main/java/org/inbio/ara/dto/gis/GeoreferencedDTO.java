/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.dto.gis;

import java.io.Serializable;

/**
 *
 * @author gsulca
 */
public class GeoreferencedDTO implements Serializable{
    
    private String layerName;
    private String value;
    
    
    public GeoreferencedDTO ()
    {
        
    }

    /**
     * @return the layerName
     */
    public String getLayerName() {
        return layerName;
    }

    /**
     * @param layerName the layerName to set
     */
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }        
    
}
