/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2010  INBio (Instituto Nacional de Biodiversidad).
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

package org.inbio.ara.eao.taxonomy.impl;

import java.util.List;
import org.inbio.ara.eao.taxonomy.TaxonNomenclaturalGroupEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroupPK;

/**
 *
 * @author herson
 */
@Stateless
public class TaxonNomenclaturalGroupEAOImpl extends
        BaseEAOImpl<TaxonNomenclaturalGroup, TaxonNomenclaturalGroupPK>
        implements TaxonNomenclaturalGroupEAOLocal {
    
    public List<TaxonNomenclaturalGroup> findByNomenclaturalGroupId(Long id) {
        String sql = "from TaxonNomenclaturalGroup as tng where tng." +
                "taxonNomenclaturalGroupPK.nomenclaturalGroupId = :id";
        Query q = em.createQuery(sql);
        q.setParameter("id", id);
        return q.getResultList();
    }

    /**
     * TaxonNomenclaturalGroup Table
     * ---------------------
     * |  NGId  |  TaxonId |
     * |-------------------|
     * |  6     |   29     |
     * |  6     |   30     |
     * |  6     |   31     |
     * ---------------------
     *
     * findTaxaByNomenclaturalGroupId(6L)
     * Returns <29, 30, 31>
     *
     * @param id
     * @return List of taxon Ids
     */
    public List<Long> findTaxaByNomenclaturalGroupId(Long id) {
        String sql = "select tng.taxonNomenclaturalGroupPK.taxonId from " +
                "TaxonNomenclaturalGroup as tng where tng." +
                "taxonNomenclaturalGroupPK.nomenclaturalGroupId = :id";
        Query q = em.createQuery(sql);
        q.setParameter("id", id);
        return q.getResultList();
    }

    public Long countByTaxonId(Long taxonId) {
        StringBuffer query = new StringBuffer();
        query.append("select count(tng.taxonNomenclaturalGroupPK.taxonId) from TaxonNomenclaturalGroup"+
                " as tng where tng.taxonNomenclaturalGroupPK.taxonId = :taxonId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        return (Long)q.getSingleResult();
    }
 
}
