/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.eao.identification;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.identification.IdentificationPK;

/**
 *
 * @author herson
 */
@Local
public interface IdentificationEAOLocal 
	extends BaseLocalEAO <Identification,IdentificationPK> {

    public List<Long> findSpecimenByTaxonId(Long taxonId);

    public List<Long> findSpecimenByValuerPersonId(Long id);

    public List<Identification> findBySpecimenId(Long specimenId);

    public List<java.lang.Long> findSpecimenByStatusId(Long statusId);

    public List<java.lang.Long> findSpecimenByTypeId(Long typeId);
	
    public Long count();
    public List<Long> findSpecimenByTaxonName(String taxonName);

    public java.lang.Long countSpecimenByTaxonId(java.lang.Long taxonId);

    public List<Long> findSpecimenByTaxonNameAndTaxonomicalLevel(String  taxonRange,String taxonName);

}
