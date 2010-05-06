/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.Semental;

/**
 *
 * @author dasolano
 */
@Stateless
public class SementalEAOImpl extends BaseEAOImpl<Semental, Long> implements SementalEAOLocal {

    public List<Long> findByBreedId(Long breedId) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where s.breedId = :breedId "
               );
        q.setParameter("breedId", breedId);
        return  q.getResultList();
    }

    public List<Long> findByBreedName(String breedName) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental s, Breed b " +
                " where b.breedId = s.breedId and" +
                " lower(b.name) like '%"+ breedName.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByAnimalName(String animalName) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.name) like '%"+ animalName.toLowerCase() + "%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByAnimalCode(String animalCode) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.animalCode) like '%" +animalCode.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByBirthDate(Calendar birthDate) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where s.birthDate = :birthDate "
               );
        q.setParameter("birthDate", birthDate);
        return  q.getResultList();
    }

    public List<Long> findByVeterinarianStatus(String veterinarianStatus) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.veterinarianStatus) like '%"+ veterinarianStatus.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByConditionId(Long conditionId) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental s"+
                " where s.conditionId = :conditionId"
               );
        q.setParameter("conditionId", conditionId);
        return  q.getResultList();
    }

    public List<Long> findByCondition(String condition) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental s, Condition c"+
                " where s.conditionId = c.conditionId and " +
                " lower(c.name) like '%" + condition.toLowerCase() + "%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByAnimalDescription(String animalDescription) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.animalDescription) like '%" + animalDescription.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByLocalityId(Long localityId) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental s"+
                " where s.siteId = :localityId"
               );
        q.setParameter("localityId", localityId);
        return  q.getResultList();
    }

    public List<Long> findByFather(String father) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.father) like '%" + father.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByMother(String mother) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.mother) like '%" + mother.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByColor(String color) {
        Query q = em.createQuery(
                " Select s.sementalId " +
                " from Semental as s " +
                " where lower(s.color) like '%" + color.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }
    
    
}
