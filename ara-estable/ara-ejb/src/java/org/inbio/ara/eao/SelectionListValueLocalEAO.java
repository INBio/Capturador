/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.eao;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.selectionListEntity;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SelectionListValueLocalEAO {

   /**
     *
     * @param actualSelectionListValue
     */
    public void createSelectionListValue(selectionListEntity selectionListValue);

    /**
     *
     * @param selectionListValue
     */
    public void updateSelectionListValue(selectionListEntity selectionListValue);
    /**
     * 
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public selectionListEntity getSelectionlistValueById(Long selectionListId, Long selectionListValueId);

    /**
     * Get all the values associated with the given selection list Id. The Id
     * corresponds to an entity of the ListTable class.
     *
     * @param selectionListId the id of an ListTable entity
     * @return
     */
    public List<selectionListEntity> getAllSelectionListValues(Long selectionListId);


    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     */
    public void deleteSelectionListValue(Long selectionListId, Long selectionListValueId);

}
