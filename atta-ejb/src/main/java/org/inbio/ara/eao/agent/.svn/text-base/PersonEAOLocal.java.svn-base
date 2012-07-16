/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author jgutierrez
 */
@Local
public interface PersonEAOLocal  extends BaseLocalEAO<Person,Long> {

    public List<Person> findByName(String name);
	public List<Person> findByProfile(Long profileId);

    public java.util.List<org.inbio.ara.persistence.person.Person> getPersonsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public java.util.List<org.inbio.ara.persistence.person.Person> findByFirstAndLastName(java.lang.String firstName, java.lang.String LastName);

    public List<Long> findByFirstName(String firstName);

    public List<Long> findByLastName(String lastName);

    public List<Long> findByCountry(String country);

    public List<Long> findByEmail(String email);
}
