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

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.eao.NomenclaturalGroupRegionLocalEAO;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegion;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegionPK;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class NomenclaturalGroupRegionEAOImpl implements NomenclaturalGroupRegionLocalEAO {

    @PersistenceContext
    private EntityManager em;

    public void createNomenclaturalGroupRegion(Long regionId, Long nomenclaturalGroupId, String createdBy, String lastModificationBy) {
        NomenclaturalGroupRegionPK ngrPk = new NomenclaturalGroupRegionPK(regionId, nomenclaturalGroupId);
        NomenclaturalGroupRegion ngr = new NomenclaturalGroupRegion(ngrPk);

        ngr.setSequence(regionId+1L);
        ngr.setCreatedBy(createdBy);
        ngr.setLastModificationBy(lastModificationBy);

        em.persist(ngr);
        em.flush();
    }

    public List<NomenclaturalGroupRegion> getAllByNomenclaturalGroupId(Long nomenclaturalGroupId) {
        Query q = em .createQuery("select ngr " +
                "from NomenclaturalGroupRegion as ngr " +
                "where ngr.nomenclaturalGroup.id = :nomenclaturalGroupId");
        q.setParameter("nomenclaturalGroupId", nomenclaturalGroupId);

        return q.getResultList();
    }

    public void deleteNomenclaturalGroupRegion(Long regionId, Long nomenclaturalGroupId) {
        NomenclaturalGroupRegionPK ngrKey = new NomenclaturalGroupRegionPK(regionId, nomenclaturalGroupId);
        NomenclaturalGroupRegion ngr = (NomenclaturalGroupRegion) em.find(NomenclaturalGroupRegion.class, ngrKey);

        em.remove(ngr);
        em.flush();
    }
    

}
