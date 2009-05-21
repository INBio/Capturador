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


package org.inbio.ara.eao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.dto.UserTypeEntity;
import org.inbio.ara.eao.GroupLocalEAO;
import org.inbio.ara.persistence.security.User;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class GroupEAOImpl extends BaseEAOImpl implements GroupLocalEAO {

    private static Long groupTypeId = new Long(UserTypeEntity.GROUP_TYPE.getId());

    public List<User> listAllGroups() {
        Query q = em .createQuery("select u" +
                " from User as u " +
                "where u.userType.id = :typeId");
        q.setParameter("typeId", groupTypeId);
        return q.getResultList();
    }


}
