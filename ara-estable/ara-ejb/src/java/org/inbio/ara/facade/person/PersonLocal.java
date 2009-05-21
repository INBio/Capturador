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

package org.inbio.ara.facade.person;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.person.*;
import com.sun.data.provider.SortCriteria;


/**
 * This is the business interface for Person enterprise bean.
 */
@Local
public interface PersonLocal {
    boolean create(Person person);

    Person getPerson();

    boolean update(Person person);

    List findAll();

    boolean remove(Long id);

    String getMessage();

    List finAll(int StartPosition, int maxResults, SortCriteria[] sortCriteria);

    List getTaxonDescriptionAuthorList();

    boolean create(Person person, Long[] profileArray, Long[] institutionArray);

    List getSelectedProfiles(Long personId);

    List getSelectedInstitutions(Long personId);

    boolean update(Person tPerson, Long[] profileArray, Long[] institutionArray);

    void deleteInstitutions(Long id);

    void deleteProfiles(Long id);
    
}
