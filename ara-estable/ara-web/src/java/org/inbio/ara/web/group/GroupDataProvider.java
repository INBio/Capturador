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
 * GroupDataProvider.java
 *
 * Created on October 17, 2007, 10:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.web.group;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.security.GroupBeanV2Remote;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.web.SessionManager;

/**
 *
 * @author roaguilar
 */
public class GroupDataProvider extends ObjectListDataProvider {

	/** Creates a new instance of GroupDataProvider */
	public GroupDataProvider() {
		this.setObjectType(User.class);
		refreshDataList();
	}

	public void refreshDataList() {
		this.setList(lookupGroupBean().findAll());	
	}

	private GroupBeanV2Remote lookupGroupBean() {
		try {
			Context c = new InitialContext();
			return (GroupBeanV2Remote) c.lookup("GroupBean");
		} catch (NamingException ne) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
			throw new RuntimeException(ne);
		}
	}

	private SessionManager lookupSessionManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		SessionManager sm = (SessionManager) fc.getApplication().getVariableResolver().resolveVariable(fc, "SessionManager");
		return sm;

	}
}
