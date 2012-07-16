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

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author pcorrales
 */
public class OriginalLabelDTO extends GenericDTO{


   //for GUI (List) proposity
    private boolean selected;

    /*LabelID is read only */
    private Long OriginalLabelID;

    /*Contens is read only */
    private String contents;


    private String urlImage;

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
     * @return the OriginalLabelID
     */
    public Long getOriginalLabelID() {
        return OriginalLabelID;
    }

    /**
     * @param OriginalLabelID the OriginalLabelID to set
     */
    public void setOriginalLabelID(Long OriginalLabelID) {
        this.OriginalLabelID = OriginalLabelID;
    }

     @Override
    public String toString() {

      return "LabelDTO" +
                    "\n\tLabel id= " + OriginalLabelID.toString() +
                    "\n\tContents= " + contents ;
    }

    /**
     * @return the urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @param urlImage the urlImage to set
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}