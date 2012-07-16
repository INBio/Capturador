/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.security;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.security.SystemUser;

/**
 *
 * @author esmata
 */
@Local
public interface SystemUserEAOLocal extends BaseLocalEAO<SystemUser,Long>{

    public org.inbio.ara.persistence.security.SystemUser getSystemUserByNameAndPass(java.lang.String name, java.lang.String pass);

    public java.lang.Long countUserEnabled();

    public java.util.List<org.inbio.ara.persistence.security.SystemUser> getAllUserEnabledPaginated(int first, int totalResults);

    public java.lang.Long getUserGroupIDbyUserId(java.lang.Long userId);
    
}
