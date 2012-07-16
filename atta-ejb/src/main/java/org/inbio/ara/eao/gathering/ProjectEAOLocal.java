/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import javax.ejb.Local;

/**
 *
 * @author esmata
 */
@Local
public interface ProjectEAOLocal {

    public java.util.List<org.inbio.ara.persistence.gathering.Project> findAllProjects();
    
}
