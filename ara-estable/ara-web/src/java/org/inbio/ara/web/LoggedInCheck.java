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
 * LoggedInCheck.java
 *
 * Created on March 26, 2008, 8:42 PM
 */

package org.inbio.ara.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
 
public class LoggedInCheck implements PhaseListener {
 
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
 
    public void beforePhase(PhaseEvent event) {
    }
 
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
 
        if (fc != null) {
            // Check to see if they are on the login page.
            boolean loginPage = 
              fc.getViewRoot().getViewId().lastIndexOf("accessGranted") > -1 ? true : false;
            if (!loginPage && !loggedIn()) {
                NavigationHandler nh = fc.getApplication().getNavigationHandler();
                nh.handleNavigation(fc, null, "logout");
            }
        } else {
            System.out.println("Contexto nulo");
        }

    }
 
    private boolean loggedIn() {
        //return LoginController.loggedIn().booleanValue()c;
        return false;
    }
}
