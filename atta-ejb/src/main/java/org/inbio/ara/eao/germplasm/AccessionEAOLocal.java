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

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Accession;

/**
 *
 * @author dasolano
 */
@Local
public interface AccessionEAOLocal extends BaseLocalEAO<Accession,Long>
{

    public List<Long> findByAccessionNumber(String accessionNumber);

    public List<Long> findByPackages(Long packages);

    public List<Long> findByOriginalWeigth(Long originalWeigth);

    public List<Long> findByCurrentWeigth(Long currentWeigth);

    public List<Long> findByPassportId(Long passportId);

    public List<Long> findByResponsablePersonId(Long responsablePersonId);

    public List<Long> findByAccessionParentId(Long accessionParentId);

    public List<Long> findByGerminationMethodId(Long germinationMethodId);

    public List<Long> findByGerminationRate(Long germinationRate);
}
