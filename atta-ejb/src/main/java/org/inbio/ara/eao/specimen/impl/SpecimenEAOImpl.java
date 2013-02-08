/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.specimen.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SpecimenEAOImpl extends BaseEAOImpl<Specimen,Long>
        implements SpecimenEAOLocal {
    /**
     * Ej.
     * select specimen_id from ara.specimen where
     *   specimen.gathering_observation_id = 3;
     * @param gathObsId
     * @return specimen ids that belongs to a Gathering/Observation
     */
    public List<Long> findByGathObsId(Long gathObsId) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.gatheringObservation.gatheringObservationId = :gathObsId";
        Query q = em.createQuery(query);
        q.setParameter("gathObsId", gathObsId);
        return q.getResultList();
    }

    public List<Long> findByGathObsDetailId(Long gathObsDetailId) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.gatheringObservationDetailId = :gathObsDetailId";
        Query q = em.createQuery(query);
        q.setParameter("gathObsDetailId", gathObsDetailId);
        return q.getResultList();
    }

     /**
     * Ej.
     * select specimen_id from ara.specimen where
     *   specimen.gathering_observation_id = 3;
     * @param gathObsId
     * @return specimen ids that belongs to a Gathering/Observation
     */
    public List<Long> findByGathObsId(Long initialGathObs, Long finalGathObs) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.gatheringObservation.gatheringObservationId between " +
                ":initialGathObs  and :finalGathObs ";
        Query q = em.createQuery(query);
        q.setParameter("initialGathObs", initialGathObs);
        q.setParameter("finalGathObs", finalGathObs);
        return q.getResultList();
    }

    
    public List<Long> findByCollectionName(String collectionName) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "lower(sp.collection.name) like '%"+ 
                collectionName.toLowerCase() +"%'";
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    public List<Long> findByCollectionId(Long collectionId) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.collection.collectionId = :collectionId ";
        Query q = em.createQuery(query);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByInstitutionId(Long institutionId) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.institution.institutionId = :institutionId";
        Query q = em.createQuery(query);
        q.setParameter("institutionId", institutionId);
        return q.getResultList();
    }

    /**
     *
     * @param taxonName
     * @return
     * @deprecated Use IdentificationEAO.findSpecimenByTaxonName instead.
     */
    public List<Long> findByTaxonName(String taxonName) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "lower(sp.taxon.defaultName) like " +
                "'%"+taxonName.toLowerCase()+"%'";
        Query q = em.createQuery(query);
        return (List<Long>) q.getResultList();
    }

    /**
     * FIXME: este try catch creo q no deberia ir aqui para darle paso al
     * interceptor.
     * @param catalogNumber
     * @return
     */
    public Long findByCatalogNumber(String catalogNumber) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.catalogNumber = '"+catalogNumber+"'";
        try {
            Query q = em.createQuery(query);
            return (Long) q.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
    
    
     public Specimen findSpecimenByCatalogNumber(String catalogNumber) {
        String query = "select sp from Specimen as sp where " +
                "sp.catalogNumber = '"+catalogNumber+"'";
        try {
            Query q = em.createQuery(query);
            return (Specimen) q.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    public List<Long> findByCatalogNumber(String catalogNumberFirst, String catalogNumberEnd) {
        String query = "select sp.specimenId from Specimen as sp where " +
                "sp.catalogNumber  between   :catalogNumberFirst   and  :catalogNumberEnd order by catalogNumber";
        try {

            Query q = em.createQuery(query);
            System.out.println(query);
            q.setParameter("catalogNumberFirst", catalogNumberFirst);
            q.setParameter("catalogNumberEnd", catalogNumberEnd);
             return (List<Long>) q.getResultList();
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param maxResults
     * @return
     * @deprecated Use instead the method below:
     * public List<Specimen> getAllSpecimenIdentificatedPaginated(int first,
     *      int maxResults, <b>int collectionId</b>)
     */
    public List<Specimen> getAllSpecimenIdentificatedPaginated(int first,
            int maxResults) {
        Query q = em.createQuery("select distinct sp from Specimen as sp "+
            "where sp.identificationList is not empty ");
        q.setFirstResult(first);
        q.setMaxResults(maxResults);

        return q.getResultList();
    }

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param maxResults
     * @return List of Specimens
     */
    public List<Specimen> getAllSpecimenIdentificatedPaginated(int first,
            int maxResults, Long collectionId) {
        /*
        Query q = em.createQuery("select distinct sp from Specimen as sp "+
            "where sp.identificationList is not empty and sp.collectionId = " +
            ":collectionId");
         */
        
        Query q = em.createQuery("select sp from Specimen as sp "+
            "where sp.identificationList is not empty and sp.collectionId = " +
            ":collectionId");
        
        q.setParameter("collectionId", collectionId);
        q.setFirstResult(first);
        q.setMaxResults(maxResults);
        System.out.println("SON "+q.getResultList().size()+ " especimenes");

        return q.getResultList();
    }

    public Long count(Long collectionId)
    {
        Query q = em.createQuery("select count(sp) from Specimen as sp "+
            "where sp.collectionId = " +
            ":collectionId");
        
        q.setParameter("collectionId", collectionId);      
        

        return (Long)q.getSingleResult();
    }
    /**
     *
     * @return the specimen with the greater Id
     */
    public Specimen getLastSpecimen() {
        Query q = em.createQuery("from Specimen as sp "+
            "order by sp.specimenId desc");
        q.setFirstResult(0);
        q.setMaxResults(1);
        List<Specimen> list = q.getResultList();
        if(list != null && list.size() > 0)
            return list.get(0);
        return null;
    }
}
