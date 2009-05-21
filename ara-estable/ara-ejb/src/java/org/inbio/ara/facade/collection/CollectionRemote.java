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

package org.inbio.ara.facade.collection;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.collection.Collection;


/**
 * This is the business interface for Collection enterprise bean.
 */
@Remote
public interface CollectionRemote {
    java.util.List getCollectionProtocols(Long collectionId);

    java.util.List getCollectionProtocols();

    org.inbio.ara.persistence.collection.Collection getCollection(Long collectionId);

    java.util.List getCollections();

    boolean update(Collection collection);


    java.lang.String getMessage();

    /**
     * 
     * @return
     */
    java.util.List getCollectionList();

    org.inbio.ara.persistence.collection.Collection getCollection();

    org.inbio.ara.persistence.collection.Collection find(Long id);

    /**
     *Devuele todos objetos Collection que hay en la BD.
     *
     * @return
     */
    public List<Collection> listAllCollections();

        /**
     * reparado
     *
     * @param collectionId
     * @throws java.lang.IllegalArgumentException
     */
    public void deleteCollection(Long collectionId) throws IllegalArgumentException;

        /**
     *
     * @param collection
     */
    public void create(Collection collection);

}
