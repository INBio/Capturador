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

package org.inbio.ara.eao.selectionlist;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SelectionListValueLocalEAO {

    public Long count(Long selectionListEntityId);

   /**
     *
     * @param actualSelectionListValue
     */
    public void create(SelectionListGenericEntity selectionListGenericEntity);

    /**
     *
     * @param selectionListValue
     */
    public void update(SelectionListGenericEntity selectionListGenericEntity);
    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public SelectionListGenericEntity findById(Long selectionListEntityId, Long selectionListValueId);

    /**
     * Get all the values associated with the given selection list Id. The Id
     * corresponds to an entity of the ListTable class.
     *
     * @param selectionListId the id of an ListTable entity
     * @return
     */
    public List<SelectionListGenericEntity> findAll(Long selectionListEntityId);

    /**
     * 
     * @param selectionListEntityId
     * @param first
     * @param maxResults
     * @return
     */
    public List<SelectionListGenericEntity> findAllPaginated(Long selectionListEntityId, int first, int maxResults);

    /**
     * Get all the values associated with the given selection list Id. The Id
     * corresponds to an entity of the ListTable class.
     *
     * @param selectionListId the id of an ListTable entity
     * @param CollectionId
     * @return
     */
    public List<SelectionListGenericEntity> findAllByCollectionId(Long selectionListEntityId, Long collectionId);


    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     */
    public void delete(Long selectionListEntityId, Long selectionListValueId);

}