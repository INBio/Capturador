/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.person.Profile;

/**
 *
 * @author esmata
 */
@Local
public interface ProfileEAOLocal extends BaseLocalEAO<Profile,Long>{

    public java.util.List<org.inbio.ara.persistence.person.Profile> getProfilesByPerson(java.lang.Long personId);
    
}
