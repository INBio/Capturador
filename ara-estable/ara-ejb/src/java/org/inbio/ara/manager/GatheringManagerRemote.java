/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.manager;

import javax.ejb.Remote;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author asanabria
 */
@Remote
public interface GatheringManagerRemote {

    
    public java.lang.Long countQueryElements(java.util.LinkedList<QueryNode> sll);
    public java.lang.Long countAllDwC();
   
}
