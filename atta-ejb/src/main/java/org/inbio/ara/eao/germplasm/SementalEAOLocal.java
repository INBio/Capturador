/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.eao.germplasm;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Semental;

/**
 *
 * @author dasolano
 */
@Local
public interface SementalEAOLocal extends BaseLocalEAO<Semental,Long> {

    public List<Long> findByBreedId(Long breedId);

    public List<Long> findByBreedName(String breedName);

    public List<Long> findByAnimalName(String animalName);

    public List<Long> findByAnimalCode(String animalCode);

    public List<Long> findByBirthDate(Calendar birthDate);

    public List<Long> findByVeterinarianStatus(String veterinarianStatus);

    public List<Long> findByConditionId(Long conditionId);

    public List<Long> findByCondition(String condition);

    public List<Long> findByAnimalDescription(String animalDescription);

    public List<Long> findByLocalityId(Long localityId);

    public List<Long> findByFather(String father);

    public List<Long> findByMother(String mother);

    public List<Long> findByColor(String color);
    
}
