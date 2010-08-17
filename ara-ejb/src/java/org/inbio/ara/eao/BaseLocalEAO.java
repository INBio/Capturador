/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio - Instituto Nacional de Biodiversidad, Costa Rica
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

/**
 *
 * @author jgutierrez
 */
@Local
public interface BaseLocalEAO<E extends Object,I extends Object> {
  
  /**
     *
     * @param entity
     */
    public void create(E entity);


    /**
     *
     * @param entity
     */
    public void delete(E entity);

    /**
     *
     * @param entity
     */
    public void update(E entity);

    /**
     *
     * @param entityClass
     * @param entityId
     * @return
     */
    public E findById(Class<E> entityClass, I entityId);


    /**
     * This method is used generally at drop downs
     * @deprecated 
     * @param entityClass
     * @return
     */
    public List<E> findAll(Class<E> entityClass);


    /**
     * 
     * @param entityClass
     * @return
     */
    public Long count(Class<E> entityClass);


    /**
     *
     * This method does 3 things:
     * 1. Paginate the output
     * 2. Filter by collection (optional)
     * 3. Order the results using one o more fields. (optional)
     *
     *
     * @param entityClass Type of returned elements
     * @param base First result of the returned list of elements
     * @param offset Maximum number of results to be returned in the list.
     * @param orderByFields The criteria for the "order by" of the results. This
     * will be an array of String, each one value containing the name of the field
     * in the *entity*. ei: String[] orderByFields = {specimenId}.
     * @param collectionId CollectionId to be used as filter. If null then the
     * returned list wont be filtered.
     * @return List of paginated, Filterd by collection and freely order by elements
     * @exception if the orderByFields array contains values that doesn't exist in 
     * the returned Entity Class. Double check the values of the array for prevent
     * misspelled values.
     *
     */
    public List<E> findAllPaginatedFilterAndOrderBy(Class<E> entityClass, int base,
            int offset, String[] orderByFields, Long collectionId);

    /**
     *
     * This method does 2 things:
     * 1. Get All the results for an Entity
     * 2. Order the results using one o more fields.
     * This method is used generally at drop downs
     * @param entityClass Type of returned elements
     * @param orderByFields The criteria for the "order by" of the results. This
     * will be an array of String, each one value containing the name of the field
     * @return List of , freely order by elements
     */
    public List<E> findAllAndOrderBy(Class<E> entityClass, String[] orderByFields);
}
