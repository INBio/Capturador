/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.facade.ara;

import javax.ejb.Remote;
import org.inbio.commons.dublincore.manager.DublinCoreMetadataManager;

/**
 *
 * @author gsulca
 */
@Remote
public interface DublinCoreFacadeRemote extends DublinCoreMetadataManager {
    
}
