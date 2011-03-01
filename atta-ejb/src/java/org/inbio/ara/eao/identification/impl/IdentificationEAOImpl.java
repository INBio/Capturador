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

package org.inbio.ara.eao.identification.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.identification.IdentificationPK;


/**
 *
 * @author herson
 */
@Stateless
public class IdentificationEAOImpl
        extends BaseEAOImpl<Identification,IdentificationPK>
        implements IdentificationEAOLocal {
    
    public List<Long> findSpecimenByTaxonId(Long taxonId) {
        StringBuffer query = new StringBuffer();
        query.append("select i.identificationPK.specimenId from Identification"+
                " as i where i.taxon.taxonId = :taxonId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        return q.getResultList();
    }

    public List<Long> findSpecimenByTaxonName(String taxonName) {
        StringBuffer query = new StringBuffer();
        query.append("select i.identificationPK.specimenId from Identification"+
                " as i where lower(i.taxon.defaultName) like " +
                "'%"+taxonName.toLowerCase()+"%'");
        Query q = em.createQuery(query.toString());
        return q.getResultList();
    }



   /* public List<Long> findSpecimenByTaxonNameAndTaxonomicalLevel(Long taxonRange,String taxonName) {
        StringBuffer query = new StringBuffer();
        query.append( "select i.identificationPK.specimenId " +
                       "from Identification i " +
                       "join  fetch Taxon t on t.taxonId = i.taxon " +
                       "join  fetch Taxon r on r.taxonId = t.kingdomTaxonId " +
                       "where lower(r.defaultName) like " +
                       "'%"+ taxonName.toLowerCase() +"%'");
        Query q = em.createQuery(query.toString());
        return q.getResultList();
    }*/


     public List<Long> findSpecimenByTaxonNameAndTaxonomicalLevel(String taxonRange,String taxonName) {
        StringBuffer query = new StringBuffer();
        query.append("select i.identificationPK.specimenId from Identification"+
                " as i,Taxon as t, Taxon as t1 where  t.taxonId =  i.taxon  and " + taxonRange + "= t1.taxonId and  lower(t1.defaultName) like " +
                "'%"+ taxonName.trim().toLowerCase() +"%'");
        Query q = em.createQuery(query.toString());
        return q.getResultList();
    }
     

    public List<Long> findSpecimenByValuerPersonId(Long id) {

       Query q = em.createQuery("select i.identificationPK.specimenId from Identification"+
                " as i where i.valuerPerson.personId = :valuerId ");
        q.setParameter("valuerId", id);
        return q.getResultList();
        
    }

    /**
     * Tested
     * @param specimenId
     * @return
     */
    public List<Identification> findBySpecimenId(Long specimenId) {
        StringBuffer query = new StringBuffer();
        query.append("from Identification as i where " +
                "i.identificationPK.specimenId = :specimenId " +
                "order by i.identificationPK.specimenId");
        Query q = em.createQuery(query.toString());
        q.setParameter("specimenId", specimenId);
        return q.getResultList();
    }

    public List<Long> findSpecimenByStatusId(Long statusId) {
        StringBuffer query = new StringBuffer();
        query.append("select i.identificationPK.specimenId from Identification"+
                " as i where i.identificationStatus.identificationStatusId = :statusId order by " +
                "i.identificationPK.specimenId");
        Query q = em.createQuery(query.toString());
        q.setParameter("statusId", statusId);
        return q.getResultList();
    }

    public List<Long> findSpecimenByTypeId(Long typeId) {
        StringBuffer query = new StringBuffer();
        query.append("select i.identificationPK.specimenId from Identification"+
                " as i where i.identificationType.identificationTypeId = :typeId order by " +
                "i.identificationPK.specimenId");
        Query q = em.createQuery(query.toString());
        q.setParameter("typeId", typeId);
        return q.getResultList();
    }

	public Long count() {
		Query q = em.createQuery("select count (distinct i.identificationPK.specimenId) from Identification as i");
        Long result = (Long)q.getSingleResult();
        return result;
	}

    /**
     * Return the quantity of idenfications exist related to an especific Taxon.
     * @param taxonId
     * @return
     */
    public Long countSpecimenByTaxonId(Long taxonId) {
        StringBuffer query = new StringBuffer();
        query.append("select count(i.identificationPK.specimenId) from Identification"+
                " as i where i.taxon.taxonId = :taxonId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        return (Long)q.getSingleResult();
    }

    public List<Identification> findByCatalogNumber(String catalogNumber){

        StringBuffer query = new StringBuffer();
        query.append("from Identification as i where i.specimen.catalogNumber = :catalogNumber");
        Query q = em.createQuery(query.toString());
        q.setParameter("catalogNumber", catalogNumber);
        return q.getResultList();
    }
}
