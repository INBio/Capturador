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
import javax.persistence.NonUniqueResultException;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author jgutierrez
 */
@Local
public interface TaxonEAOLocal extends BaseLocalEAO<Taxon,Long> {

    public Taxon findBySpecimenId(Long specimenId) throws NonUniqueResultException;

    public List<Long> findByTaxonName(String name);
    public List<Taxon> findByTaxononimcalRange(Long taxonomicalRangeId);    

    public java.util.List<Taxon> getTaxonListByUser(java.lang.Long userId);

    public java.util.List<Taxon> getAllSpecies();

    public java.util.List<Taxon> findByAncestor(Long taxonId);

    public Long findByAncestorCount(Long taxonId);

    public java.util.List<org.inbio.ara.persistence.taxonomy.Taxon> getTaxonListByNomenclaturalGroup(java.lang.Long nomenclaturalId);

    public List<Taxon> getTaxonsByCollectionIdAndTaxonomicalRangeId(Long collectionId, Long taxonomicalRangeId);

    /**
     * This method search and retrieve all the taxons for an specify kingdom name and a
     * taxonomical Range Id. EXAMPLES: "PLANTAE", "ANIMALIA".
     * @param kingdomName String with the name of the kingdom
     * @param taxonomicalRangeId Long with the value of the taxonomical Range
     * @return List of Taxon
     */
    public List<Taxon> getTaxonsByKingdomNameAndTaxonomicalRangeId(String kingdomName, Long taxonomicalRangeId);

    public Taxon getTaxonRootByCollectionId(Long collectionId);

    public Long findTaxonomicalRangeIdByTaxonId(Long taxonId);

    public List<Taxon> findTaxonByName(String taxonName, Long kingdomId, Long categoryId , int base, int offset);


}
