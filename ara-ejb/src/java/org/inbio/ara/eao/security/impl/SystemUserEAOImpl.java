/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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


package org.inbio.ara.eao.security.impl;

import java.util.List;
import org.inbio.ara.eao.security.SystemUserEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.security.SystemUser;

/**
 *
 * @author esmata
 */
@Stateless
public class SystemUserEAOImpl extends BaseEAOImpl<SystemUser,Long> implements SystemUserEAOLocal {

    /**
     * Metodo para encontrar un usuario especifico, dado su nombre y contrasena
     * Retorna el usuario si lo encuentra, nulo en otro caso
     */
    public SystemUser getSystemUserByNameAndPass(String name,String pass){
        String query = "from SystemUser as su where " +
                       "su.username = :name and su.passwd = :pass";
        Query q = em.createQuery(query);
        q.setParameter("name", name);
        q.setParameter("pass", pass);
        try{
            SystemUser result = (SystemUser) q.getSingleResult();
            return result;
        }
        catch(Exception e){return null;}
    }

    /**
     * Solo los usuarios habilitados
     * @return
     */
    public List<SystemUser> getAllUserEnabledPaginated(int first, int totalResults){
        String query = "from SystemUser su where " +
                       "su.enabled = 1";
        Query q = em.createQuery(query);
        q.setFirstResult(first);
        q.setMaxResults(totalResults);
        return q.getResultList();
    }

    /**
     * Solo los usuarios habilitados
     * @return
     */
    public Long countUserEnabled(){
        String query = "select count(su) from SystemUser su where " +
                       "su.enabled = 1";
        Query q = em.createQuery(query);
        return (Long) q.getSingleResult();
    }
}
