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

package org.inbio.ara.facade.util;

import javax.ejb.Remote;
import java.util.List;
import org.inbio.ara.persistence.util.Country;
import com.sun.data.provider.SortCriteria;
/**
 * This is the business interface for Country enterprise bean.
 */
@Remote
public interface CountryRemote {
    boolean create(Country country);

    Country getCountry();

    boolean update(Country country);

    List findAll();

    boolean remove(Long id);

    java.lang.String getMessage();

    java.util.List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria);
}
