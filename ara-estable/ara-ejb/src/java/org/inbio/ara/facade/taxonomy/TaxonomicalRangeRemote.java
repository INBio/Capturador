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

package org.inbio.ara.facade.taxonomy;

import javax.ejb.Remote;
import java.util.List;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;
import com.sun.data.provider.SortCriteria;

/**
 * This is the business interface for TaxonomicalRange enterprise bean.
 */
@Remote
public interface TaxonomicalRangeRemote {
    boolean create(TaxonomicalRange taxonomicalRange);

    TaxonomicalRange getTaxonomicalRange();

    boolean update(TaxonomicalRange taxonomicalRange);

    List findAll();

    boolean remove(Long id);

    String getMessage();

    java.util.List findAll(int firsResult, int maxResults, SortCriteria[] sortCriteria);

    org.inbio.ara.persistence.taxonomy.TaxonomicalRange findTaxonomicalRangeById(Object id);
}
