/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent.impl;

import java.util.List;
import org.inbio.ara.eao.agent.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.person.Profile;

/**
 *
 * @author esmata
 */
@Stateless
public class ProfileEAOImpl extends BaseEAOImpl<Profile,Long> implements ProfileEAOLocal {
    
    public List<Profile> getProfilesByPerson(Long personId){
        String sql = "Select p ";
              sql += "from Profile p, PersonProfile pp ";
              sql += "where p.profileId = pp.personProfilePK.profileId " +
                      "and pp.personProfilePK.personId = :personId";
        Query q = em.createQuery(sql);
		q.setParameter("personId", personId);
        return (List<Profile>)q.getResultList();
    }
 
}
