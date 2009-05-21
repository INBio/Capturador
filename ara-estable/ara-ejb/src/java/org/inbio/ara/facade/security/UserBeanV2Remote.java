/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.facade.security;

import com.sun.data.provider.SortCriteria;
import javax.ejb.Remote;
import org.inbio.ara.persistence.security.User;


/**
 * This is the business interface for UserBeanV2 enterprise bean.
 */
@Remote
public interface UserBeanV2Remote {
    java.lang.String getUserName();

    boolean create(User user, Long groupId);

    boolean create(User user, Long[] systemOptionArray);

    boolean remove(Long id);

    boolean update(User user, Long[] systemOptionArray);

    boolean updatePassword(User user);

    boolean updatePrivilegies(Long[] systemOptionArray);

    void deleteAllPrivilegies(Long userId);

    org.inbio.ara.persistence.security.User getUser(String userName, String password);

    /**
     * @deprecated
     * @return
     */
    java.util.List findAll();

    java.util.List findAll(int StartPosition, int maxResults, SortCriteria[] sortCriteria);

    java.util.List getUserOptions(Long userId);

    org.inbio.ara.persistence.security.User getUser();

    java.lang.String getMessage();

    void setMessage(String message);

    boolean changeUserPassword(long userId, String oldPassword, String newPassword);

    org.inbio.ara.persistence.security.UserType getUserType();

    org.inbio.ara.persistence.security.User getUser(Long userId);

    java.util.List getGroupSubsystems(Long groupId);

    java.util.List getSubsystemModules(Long subSystemId, Long groupId);

    java.lang.String canDelete(Long userId, Long moduleId);

    java.lang.String canModify(Long userId, Long moduleId);

    java.lang.String canAdd(Long userId, Long moduleId);

    boolean update(User user, Long[] systemOptionArray, Long[] taxonArray, Long[] groupArray);
}
