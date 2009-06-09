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
import javax.persistence.Query;
import org.inbio.ara.eao.SiteLocalEAO;
import org.inbio.ara.persistence.gis.Site;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SiteEAOImpl extends BaseEAOImpl implements SiteLocalEAO{

    @Override
    public List<Site> findAllPaginated(int firstResult, int maxResults) {
        Query q = em .createQuery("select s from Site as s order by s.id");
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResults);
        return q.getResultList();

    }

    @Override
    public Long totalSitesCount() {
        Query q = em .createQuery("select count(s.id) from Site as s");
        return (Long)q.getSingleResult();
    }


}
