/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.person.PersonProfile;

/**
 *
 * @author esmata
 */
@Local
public interface PersonProfileEAOLocal extends BaseLocalEAO<PersonProfile,Long>{

    public void deleteByPerson(java.lang.Long personId);

    public String findPersonByPersonProfileId(Long personId, Long profileId);

    public List<PersonProfile> findPersonsByProfileId(Long profileId);
    
}
