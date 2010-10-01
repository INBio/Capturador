/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.eao.ara;

import javax.ejb.Local;

import org.inbio.commons.dublincore.dao.DublinCoreElementDAO;


/**
 *
 * @author gsulca
 */
@Local
//public interface DublinCoreElementEAOLocal{
public interface DublinCoreElementEAOLocal extends DublinCoreElementDAO {

    //public java.util.List<org.inbio.commons.dublincore.persistence.ara.DublinCoreElement> findAllByResourceId(int resourceId);

    public void deleteAllByResourceId(Long resourceId);
    
}
