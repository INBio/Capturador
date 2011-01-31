/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.person.PersonInstitution;

/**
 *
 * @author esmata
 */
@Local
public interface PersonInstitutionEAOLocal extends BaseLocalEAO<PersonInstitution,Long>{

    public void deleteByPerson(java.lang.Long personId);
    
}
