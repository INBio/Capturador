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

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord;

/**
 *
 * @author herson
 */
@Local
public interface TaxonDescriptionRecordEAOLocal
        extends BaseLocalEAO<TaxonDescriptionRecord, Long>{

    public org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord getTaxonDescriptionRecord(java.lang.Long elementId, java.lang.Long sequence);

    public org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord getTaxonDescriptionRecord(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence, java.lang.Long elementId, java.lang.Long sequence);

    public List<Long> getTaxonDescriptionRows(Long categoryId, Long taxonId, Long taxonDescriptionSequence);

    public String getTaxonDescriptionRecordValue(String mainFieldName,String tableName,String keyField,String contentsNumeric);

    public List getFieldContent(Long Id, String tableName, String keyField,String tableField);

    public TaxonDescriptionRecord getTaxonDescriptionRecordByRowId
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId);

    public TaxonDescriptionRecord getTaxonDescriptionRecordByTaxonDescription
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId);

    public int deleteTaxonDescriptionRecordRow
            (Long taxonDescriptionSequence, Long taxonId, Long sequence);

    public Long getNextTaxonDescriptionRecordSequence
            (Long taxonDescriptionSequence, Long taxonId);

    List<TaxonDescriptionRecord> getTaxonDescriptionRecordsByTaxonDescription(
            Long taxonId,Long taxonDescriptionSequence);
    
}
