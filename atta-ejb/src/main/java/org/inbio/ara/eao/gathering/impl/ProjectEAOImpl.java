/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import java.util.List;
import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.Project;

/**
 *
 * @author esmata
 */
@Stateless
public class ProjectEAOImpl extends BaseEAOImpl<Project,Long> implements ProjectEAOLocal {

    /**
     * To get all the projets
     * @return
     */
    public List<Project> findAllProjects(){
        return this.findAll(Project.class);
    }
 
}
