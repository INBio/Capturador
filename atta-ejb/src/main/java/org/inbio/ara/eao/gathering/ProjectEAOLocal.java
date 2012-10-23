/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.Project;


/**
 *
 * @author esmata
 */
@Local
public interface ProjectEAOLocal extends BaseLocalEAO<Project,Long> {

    public java.util.List<org.inbio.ara.persistence.gathering.Project> findAllProjects();

    public java.util.List<java.lang.Long> findByDescription(java.lang.String description);

    public java.util.List<java.lang.Long> findByProjectManager(java.lang.String name);

    public java.util.List<java.lang.Long> findByInitialDate(java.lang.String date);

    public java.util.List<java.lang.Long> findByFinalDate(java.lang.String date);
    
}
