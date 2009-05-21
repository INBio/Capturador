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
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */
@Local
public interface CollectionLocalEAO extends BaseLocalEAO {


   /**
     *Devuele todos objetos Collection que hay en la BD.
     *
     * @return
     */
    public List<Collection> listAll();

    /**
     * Get all the collection that are actually associated to the selection list
     * value of the params
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return the collections list
     */
    public List<Collection> getCollectionsBySelectionListValue(Long selectionListId, Long selectionListValueId);

	/**
     * @param collectionId
     * @return the SpecimenCount
     */
	public Long getSpecimensCountByCollectionId(Long collectionId);

		/**
     * @param collectionId
     * @return the SpecimenCount
     */
	public Long getSpeciesCountByCollectionId(Long collectionId);


}
