/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent.impl;

import org.inbio.ara.eao.agent.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.person.PersonProfile;

/**
 *
 * @author esmata
 */
@Stateless
public class PersonProfileEAOImpl extends BaseEAOImpl<PersonProfile,Long> implements PersonProfileEAOLocal {
    
    public void deleteByPerson(Long personId) {
        Query q = em.createQuery("delete from PersonProfile pp " +
                "where pp.personProfilePK.personId = :personId");
        q.setParameter("personId", personId);
        q.executeUpdate();
        em.flush();
    }
 
}
