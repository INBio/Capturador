/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.security.UserOption;

/**
 *
 * @author asanabria
 */
@Local
public interface UserOptionLocalEAO extends BaseLocalEAO  {

	public List<UserOption> findAllByGroupId(Long groupId);

	public List<UserOption> findAllByUserId(Long userId);

	public void deleteAllByUserId(Long userId);
    
}
