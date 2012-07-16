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

package org.inbio.ara.dto.inventory;

import java.io.Serializable;

/**
 *
 * @author jgutierrez
 */
public class SelectionListDTO implements Serializable {

    /* For Graphical Inteface purposes */
    private boolean selected;

    /** Id of the selection list on the SelectionListEntity ENUM */
    private Long selectionListEntityId;
    /** Id of the selection list value on the particular selecion list */
    private Long valueId;
    /** Name of the selection list value on the particular selecion list */
    private String valueName;
    /** Description of the selection list value on the particular selecion list */
    private String valueDescription;

    /**
     * 
     * @param selectionListEntityId
     * @param valueId
     * @param valueName
     * @param valueDescription
     */
    public SelectionListDTO(Long selectionListEntityId, Long valueId, String valueName, String valueDescription) {
        this.selectionListEntityId = selectionListEntityId;
        this.valueId = valueId;
        this.valueName = valueName;
        this.valueDescription = valueDescription;
        this.selected =false;
    }

    public SelectionListDTO(){        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SelectionListDTO other = (SelectionListDTO) obj;
        if (this.selectionListEntityId != other.selectionListEntityId && (this.selectionListEntityId == null || !this.selectionListEntityId.equals(other.selectionListEntityId))) {
            return false;
        }
        if (this.valueId != other.valueId && (this.valueId == null || !this.valueId.equals(other.valueId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.selectionListEntityId != null ? this.selectionListEntityId.hashCode() : 0);
        hash = 97 * hash + (this.valueId != null ? this.valueId.hashCode() : 0);
        return hash;
    }

	@Override
	public String toString(){
		return "The Selection List Elementhas:" +
		"\n\tSelection List Entity Id: " + this.getSelectionListEntityId() +
		"\n\tValue Id: " + this.getValueId() +
		"\n\tValue Name: "+ this.getValueName()+
        "\n\tValue Description: "+ this.getValueDescription();
	}

    /**
     * @return the selectionListEntityId
     */
    public Long getSelectionListEntityId() {
        return selectionListEntityId;
    }

    /**
     * @param selectionListEntityId the selectionListEntityId to set
     */
    public void setSelectionListEntityId(Long selectionListEntityId) {
        this.selectionListEntityId = selectionListEntityId;
    }

    /**
     * @return the valueId
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * @param valueId the valueId to set
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * @return the valueName
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * @param valueName the valueName to set
     */
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    /**
     * @return the valueDescription
     */
    public String getValueDescription() {
        return valueDescription;
    }

    /**
     * @param valueDescription the valueDescription to set
     */
    public void setValueDescription(String valueDescription) {
        this.valueDescription = valueDescription;
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
}
