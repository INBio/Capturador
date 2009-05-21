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

package org.inbio.ara.eao.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.eao.TaxonNomenclaturalGroupLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroupPK;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class TaxonNomenclaturalGroupEAOImpl implements TaxonNomenclaturalGroupLocalEAO{

    @PersistenceContext
    private EntityManager em;


    public void createTaxonNomenclaturalGroup(Long taxonId, Long nomenclaturalGroupId, String createdBy, String lastModificationBy) {
        
        TaxonNomenclaturalGroupPK tngPk = new TaxonNomenclaturalGroupPK(taxonId, nomenclaturalGroupId);
        TaxonNomenclaturalGroup tng = new TaxonNomenclaturalGroup(tngPk);
        tng.setSequence(taxonId+1L);
        tng.setTaxonomicalTimeStamp(new Date());
        tng.setCreatedBy(createdBy);
        tng.setLastModificationBy(lastModificationBy);

        em.persist(tng);
        em.flush();
    }


    public List<TaxonNomenclaturalGroup> getAllByNomenclaturalGroupId(Long nomenclaturalGroupId) {

        Query q = em .createQuery("select tng " +
                "from TaxonNomenclaturalGroup as tng " +
                "where tng.nomenclaturalGroup.id = :nomenclaturalGroupId");
        q.setParameter("nomenclaturalGroupId", nomenclaturalGroupId);

        return q.getResultList();
    }

    
    public void deleteTaxonNomenclaturalGroup(Long taxonId, Long nomenclaturalGroupId) {
        TaxonNomenclaturalGroupPK tngKey = new TaxonNomenclaturalGroupPK(taxonId, nomenclaturalGroupId);
        TaxonNomenclaturalGroup tng = (TaxonNomenclaturalGroup) em.find(TaxonNomenclaturalGroup.class, tngKey);

        em.remove(tng);
        em.flush();
    }



}
