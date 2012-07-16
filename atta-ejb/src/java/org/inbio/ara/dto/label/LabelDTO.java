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

package org.inbio.ara.dto.label;

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author pcorrales
 */
public class LabelDTO   extends GenericDTO{


   //for GUI (List) proposity
    private boolean selected;
 

    /*LabelID is read only */
    private Long labelId;

    /*Contens is read only */
    private String contents;

    /*Calendar is read only */
    private Calendar initialTimestand;

    private Calendar finalTimestand;

    private Long labelTypeId;

    private Long ancestorLabelId;

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
     * @return the contents
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * @return the initialTimestand
     */
    public Calendar getInitialTimestand() {
        return initialTimestand;
    }

    /**
     * @param initialTimestand the initialTimestand to set
     */
    public void setInitialTimestand(Calendar initialTimestand) {
        this.initialTimestand = initialTimestand;
    }

    @Override
    public String toString() {

      return "LabelDTO" +
                    "\n\tLabel id= " + labelId.toString() +
                    "\n\tContents= " + contents +
                    "\n\tInitialTimestand = " + initialTimestand +
                    "\n\tTypeLabelID = " + labelTypeId;

    }

    /**
     * @return the labelID
     */
    public Long getLabelId() {
        return labelId;
    }

    /**
     * @param labelID the labelID to set
     */
    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    /**
     * @return the labelTypeID
     */
    public Long getLabelTypeId() {
        return labelTypeId;
    }

    /**
     * @param labelTypeID the labelTypeID to set
     */
    public void setLabelTypeId(Long labelTypeID) {
        this.labelTypeId = labelTypeID;
    }

    /**
     * @return the finalTimestand
     */
    public Calendar getFinalTimestand() {
        return finalTimestand;
    }

    /**
     * @param finalTimestand the finalTimestand to set
     */
    public void setFinalTimestand(Calendar finalTimestand) {
        this.finalTimestand = finalTimestand;
    }

    /**
     * @return the ancestorLabelId
     */
    public Long getAncestorLabelId() {
        return ancestorLabelId;
    }

    /**
     * @param ancestorLabelId the ancestorLabelId to set
     */
    public void setAncestorLabelId(Long ancestorLabelId) {
        this.ancestorLabelId = ancestorLabelId;
    }

}