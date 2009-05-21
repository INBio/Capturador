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

package org.inbio.ara.taxon.service;

import com.sun.data.provider.SortCriteria;
import javax.ejb.Remote;
import org.inbio.ara.persistence.taxonomy.Taxon;


/**
 * This is the business interface for TaxonService enterprise bean.
 */
@Remote
public interface TaxonServiceRemote {
    java.util.List getTaxa(int startPosition, int maxResult, SortCriteria[] sc);
    java.util.List getSpecies(int startPosition, int maxResult);

    java.util.List getAllTaxa();

    int getCount();

    org.inbio.ara.persistence.taxonomy.Taxon findTaxonById(Object id);
    public boolean create(Taxon taxon);

    java.util.List getSpeciesIds(int startPosition, int maxResult);

    java.util.List getTaxaNames(int startPosition, int maxResult);

    java.util.List getSons(long taxonId);

    java.util.List getTheTopTaxon(long taxonId);

    java.util.List getTheSons(long taxonId);

    boolean remove(Long id);

    java.util.List getTaxonHierarchy(Long taxonId);

    int getChildCount(long taxonId);

    java.util.List getSpeciesData();

    java.util.List getAllSpecies();
    
}
