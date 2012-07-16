/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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


package org.inbio.ara.dto.agent;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author esmata
 */
public class CollectionDTO extends  GenericDTO {

    /* For Graphical Inteface purposes */
    public boolean selected;

    //Estados del objeto
    private Long collectionId;
    private String collectionName;
    public String collectionDescription;

    //Constructores de la clase
    public CollectionDTO(){
    }
    
    public CollectionDTO(String name,Long id, String description){
        this.collectionId = id;
        this.collectionName = name;
        this.collectionDescription = description;
        this.selected =false;
    }

    /**
     * @return the collectionId
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId the collectionId to set
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return the collectionName
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @param collectionName the collectionName to set
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
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
     * @return the collectionDescription
     */
    public String getCollectionDescription() {
        return collectionDescription;
    }

    /**
     * @param collectionDescription the collectionDescription to set
     */
    public void setCollectionDescription(String collectionDescription) {
        this.collectionDescription = collectionDescription;
    }


    /**
    *
    * @param cDTO
    * @return
    */
    @Override
    public boolean equals(Object obj){

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        CollectionDTO cDTO = (CollectionDTO) obj;

        if(this.hashCode() != cDTO.hashCode())
            return false;
        /*
        if (! this.collectionId.equals(cDTO.getCollectionId() )  )
            return false;
        if(! this.collectionName.equals(cDTO.getCollectionName() )  )
            return false;
        if(! this.collectionDescription.equals(cDTO.getCollectionDescription() )  )
            return false;
        */
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.collectionId != null ? this.collectionId.hashCode() : 0);
        hash = 73 * hash + (this.collectionName != null ? this.collectionName.hashCode() : 0);
        hash = 73 * hash + (this.collectionDescription != null ? this.collectionDescription.hashCode() : 0);
        return hash;
    }
}
