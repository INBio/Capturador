/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.eao;

import javax.ejb.Local;

/**
 *
 * @author esmata
 */
@Local
public interface ShareLocalEAO extends BaseLocalEAO {

    public org.inbio.ara.persistence.specimen.DwcElement getDwCElementById(java.math.BigDecimal id);

    public java.util.List<org.inbio.ara.persistence.specimen.DwcElement> getDwCElements();

    public java.util.List<org.inbio.ara.persistence.specimen.DwcCategory> getDwCCategories();

    public java.util.List<org.inbio.ara.persistence.specimen.DarwinCore14> retriveInformationDcw(java.lang.String q);

    public int deleteAllDwcSnapshot();

    public java.util.List<org.inbio.ara.persistence.specimen.DarwinCore14> retriveInformationDcwAll();

    public java.util.List<org.inbio.ara.persistence.share.PliElement> getPliElements();

    public org.inbio.ara.persistence.share.PliElement getPliElementById(java.math.BigDecimal id);

    public int deleteAllDwcTable();

    public java.util.List<org.inbio.ara.persistence.taxonomy.TaxonAuthor> getTaxonAuthorList(java.lang.Long tId, java.lang.String taCategory);

    public java.util.List<org.inbio.ara.persistence.specimen.SpecimenLifeStageSex> getSLsSListBySpecimen(java.lang.Long sId);

    public java.lang.Long getTaxonIdentificationId(java.lang.Long sId);

    public java.util.Date getIdentificationDate(java.lang.Long sId);

    public java.lang.String getIdentifiedBy(java.lang.Long sId);

    public java.util.List<java.lang.Long> getSpecimenIdList();

    public java.lang.String getIdentificationqualifier(java.lang.Long sId);

    public org.inbio.ara.persistence.specimen.Specimen findSpecimen(java.lang.Long sId);

    public java.lang.Long getTaxonDescriptionYear(java.lang.Long taxonId);

    public java.lang.Long getTaxonAuthorFormatParenthesis(java.lang.Long taxonId);

    public java.lang.String getTaxonDefaultName(java.lang.Long taxonId);

    public void truncateDwcTable();

    public java.lang.Object[] getTaxomonyIds(java.lang.Long tId, char t);

    public java.util.List<java.lang.Long> getSpecimenIdListAU();

    public java.util.List<org.inbio.ara.persistence.specimen.Identification> getIdentificationList(java.lang.Long sId);

    public java.util.List<java.lang.Long> getSpecimenIdListAM();

    public java.lang.Long getTaxonIdentificationIdAM(java.lang.Long sId, java.lang.Long iSequence);

    public void truncateDwcSnapshot();

    public java.util.List<org.inbio.ara.persistence.specimen.DarwinCore14> retriveInformationDcwPaginated(int firstResult, int maxResults);

    public java.lang.Long findTotalDwc();

    public java.util.List<org.inbio.ara.persistence.specimen.DarwinCore14> retriveInformationDcwPaginatedQ(int firstResult, int maxResults, java.lang.String query);

    public Long countQueryElements(String query);

    public boolean DcwSnapshotAllPostgresql(java.lang.String query);
}
