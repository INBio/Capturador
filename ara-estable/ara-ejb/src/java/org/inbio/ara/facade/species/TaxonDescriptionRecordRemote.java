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

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;


/**
 * This is the business interface for TaxonDescriptionRecord enterprise bean.
 */
@Remote
public interface TaxonDescriptionRecordRemote {
    boolean create(TaxonDescriptionRecord taxonDescriptionRecord);

    java.lang.String getMessage();

    org.inbio.ara.persistence.species.TaxonDescriptionRecord getTaxonDescriptionRecord();

    void setTaxonDescriptionRecord(TaxonDescriptionRecord taxonDescriptionRecord);

    boolean update(TaxonDescriptionRecord taxonDescriptionRecord);

    java.util.List getTaxonDescriptionRecordList();

    void setTaxonDescriptionRecordList(List taxonDescriptionRecordList);

    java.util.List getTaxonDescriptionRecordAuthorList();

    void setTaxonDescriptionRecordAuthorList(List taxonDescriptionRecordAuthorList);

    org.inbio.ara.persistence.species.TaxonDescriptionRecord getTaxonDescriptionRecordByTaxonDescription(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId);

    boolean remove(Long id);

    boolean persist(TaxonDescriptionRecord taxonDescriptionRecord, Long[] referenceArray);

    org.inbio.ara.persistence.species.TaxonDescriptionRecord find(Long taxonDescriptionRecordId);

    java.lang.Long getNextTaxonDescriptionRecordSequence(Long taxonDescriptionSequence, Long taxonId);

    boolean deleteTaxonDescriptionRecordRow(Long taxonDescriptionSequence, Long taxonId, Long sequence);

    java.util.List getTaxonDescriptionRowList(Long categoryId, Long taxonId, Long taxonDescriptionSequence);

    /**
     * Para el preview (reporte) de la informacion existente sobre un registro
     * de especies se utiliza este metodo.
     * 
     * @param TDpk: TaxonDescriptionPK que incluye el taxonId y el sequence
     * @return List<TaxonDescriptionRecord>
     */
    java.util.List<org.inbio.ara.persistence.species.TaxonDescriptionRecord> find(TaxonDescriptionPK TDpk);

    org.inbio.ara.persistence.species.TaxonDescriptionRecord getTaxonDescriptionRecordByRowId(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId);

    boolean create(TaxonDescriptionRecord taxonDescriptionRecord, Long[] referencesArray);
    
}
