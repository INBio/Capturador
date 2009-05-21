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
 * SessionCheckFilter.java
 *
 * Created on March 26, 2008, 12:10 PM
 */

package org.inbio.ara.web;

import java.io.*;
import javax.faces.context.ExternalContext;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author  roaguilar
 * @version
 */

public class SessionCheckFilter implements Filter {
    private static int firstRequest = 0;
     public void doFilter(ServletRequest request, ServletResponse response,
                        FilterChain chain) throws IOException, ServletException {
          HttpServletRequest hreq = (HttpServletRequest)request;
          HttpServletResponse hres = (HttpServletResponse)response;
          HttpSession session = hreq.getSession();
          if (session.isNew()) {
              if(firstRequest == 0){
                   firstRequest++;
              } else {
                String path;
                path = "http://" + hreq.getServerName() + ":" + hreq.getServerPort() + hreq.getContextPath() + "/faces/login.jsp";
                hres.sendRedirect(path);
                return;
              }
          }
          try {
            chain.doFilter(request, response);
          } catch (NullPointerException e) {
				e.printStackTrace();
          }
          
      }
      public void init(FilterConfig filterConfig) throws ServletException {}
      public void destroy() {}
}
