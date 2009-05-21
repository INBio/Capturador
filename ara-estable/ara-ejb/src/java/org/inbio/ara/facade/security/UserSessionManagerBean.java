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
/*
 * UserSessionManagerBean.java
 *
 * Created on September 11, 2007, 9:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.security;

import javax.ejb.Stateful;
import org.inbio.ara.persistence.security.User;

/**
 *
 * @deprecated
 * @author roaguilar
 */
@Stateful
public class UserSessionManagerBean implements UserSessionManagerRemote, UserSessionManagerLocal {
    
    User user;
    
    /** Creates a new instance of UserSessionManagerBean */
    public UserSessionManagerBean() {
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser(){
        return this.user;
    }
}
