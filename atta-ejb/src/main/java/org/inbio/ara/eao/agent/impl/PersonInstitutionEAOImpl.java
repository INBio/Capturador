/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent.impl;

import org.inbio.ara.eao.agent.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.person.PersonInstitution;

/**
 *
 * @author esmata
 */
@Stateless
public class PersonInstitutionEAOImpl extends BaseEAOImpl<PersonInstitution,Long> implements PersonInstitutionEAOLocal {

    public void deleteByPerson(Long personId) {
        Query q = em.createQuery("delete from PersonInstitution pi " +
                "where pi.personInstitutionPK.personId = :personId");
        q.setParameter("personId", personId);
        q.executeUpdate();
        em.flush();
    }

}
