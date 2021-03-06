/* Ara - capture species and specimen data
 *
 * Copyright © 2010 INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.eao.agent.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class PersonEAOImpl extends BaseEAOImpl<Person,Long> implements PersonEAOLocal  {
    /**
     * Input data is compared with the firstName, lastName and secondLastName
     * @param name to search
     * @return List of people whom matched
     */
    public List<Person> findByName(String name) {
        String lowerName = name.toLowerCase();
        /*
        Query q = em.createQuery("from Person as p where lower(p.firstName) " +
                "like '%" + lowerName +"%' " +
                "or lower(p.lastName) like '%" + lowerName + "%'" +
                "or lower(p.secondLastName) like '%" + lowerName + "%'");                
                */
          Query q = em.createQuery("from Person as p where ((case when p.firstName is null then '' else LOWER(p.firstName) end) "+
            " ||' '|| (case when p.lastName is null then '' else LOWER(p.lastName) end) "+
            " ||' '|| (case when p.secondLastName is null then '' else LOWER(p.secondLastName) end)) like '%" + lowerName + "%'");
        return q.getResultList();
    }

	public List<Person> findByProfile(Long profileId) {

        Query q = em.createQuery("Select p from Person as p, IN(p.profiles) prof " +
                " where prof.profileId = :profileId " +
                " order by p.firstName, p.lastName, p.secondLastName");
		q.setParameter("profileId", profileId );
        return q.getResultList();
	}

    public List<Person> findPersonByProfile(Long profileId, String personFilter) {

        
        /*
        Query q = em.createQuery("Select p from Person as p, IN(p.profiles) prof " +
            " where prof.profileId = :profileId " +
            " AND (LOWER(p.firstName) LIKE :personFilter "+
            " OR LOWER(p.lastName) LIKE :personFilter "+
            " OR LOWER(p.secondLastName) LIKE :personFilter) "+
            " order by p.firstName, p.lastName, p.secondLastName");
            
            */
        Query q = em.createQuery("Select p from Person as p, IN(p.profiles) prof " +
            " where prof.profileId = :profileId " +
            " AND ((case when p.firstName is null then '' else LOWER(p.firstName) end) "+
            " ||' '|| (case when p.lastName is null then '' else LOWER(p.lastName) end) "+
            " ||' '|| (case when p.secondLastName is null then '' else LOWER(p.secondLastName) end)) LIKE :personFilter) "+
            " order by p.firstName, p.lastName, p.secondLastName");
            
            q.setParameter("personFilter", "%"+personFilter.toLowerCase()+"%");
            q.setParameter("profileId", profileId );
            
        return q.getResultList();
    }

    public List<Person> getPersonsByTaxonDescription(Long taxonId,
            Long taxonDescriptionSequence){
        String sql = "Select p ";
              sql += "from Person p, TaxonDescriptionPersonProfile tdpp ";
              sql += "where p.personId = tdpp.taxonDescriptionPersonProfilePK.personId " +
                      "and tdpp.taxonDescriptionPersonProfilePK.taxonId = :taxonId "+
                      "and tdpp.taxonDescriptionPersonProfilePK.taxonDescriptionSequence = :taxonDescriptionSequence" +
                      " order by p.firstName, p.lastName, p.secondLastName";
        Query q = em.createQuery(sql);
		q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
        return (List<Person>)q.getResultList();
    }

    /**
     * Method that get a list of person for a given first and last Name
     * Is used by ImportSpecimenFacade
     * @param fisrtName
     * @param lastName
     * @return
     */
    public List<Person> findByFirstAndLastName(String firstName, String lastName){
        String lowerfirstName = firstName.toLowerCase();
        String lowerLastName = lastName.toLowerCase();
        Query q = em.createQuery("from Person p " +
                " where lower(p.firstName) = '"+ lowerfirstName + "' and" +
                " lower(p.lastName) = '"+  lowerLastName + "'" +
                " order by p.firstName, p.lastName, p.secondLastName");
        //q.setParameter("LastName", lowerLastName);
        return q.getResultList();
    }

    public List<Long> findByFirstName(String firstName) {
        String lowerfirstName = firstName.toLowerCase();
        Query q = em.createQuery("select p.personId" +
                " from Person p " +
                " where lower(p.firstName) = '"+ lowerfirstName + "'"+
                " order by p.personId");
        return q.getResultList();
    }

    public List<Long> findByLastName(String lastName) {
        String lowerlastName = lastName.toLowerCase();
        Query q = em.createQuery("select p.personId" +
                " from Person p " +
                " where lower(p.lastName) = '"+ lowerlastName + "'"+
                " order by p.personId");
        return q.getResultList();
    }

    public List<Long> findByCountry(String country) {
        String lowerCounry = country.toLowerCase();
        Query q = em.createQuery("select p.personId" +
                " from Person p " +
                " where lower(p.country) = '"+ lowerCounry + "'"+
                " order by p.personId");
        return q.getResultList();
    }

    public List<Long> findByEmail(String email) {
        String lowerEmail = email.toLowerCase();
        Query q = em.createQuery("select p.personId" +
                " from Person p " +
                " where lower(p.email) = '"+ lowerEmail + "'"+
                " order by p.personId");
        return q.getResultList();
    }


}
