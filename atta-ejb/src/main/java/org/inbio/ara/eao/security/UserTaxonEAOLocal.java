/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.security;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.UserTaxon;

/**
 *
 * @author esmata
 */
@Local
public interface UserTaxonEAOLocal extends BaseLocalEAO<UserTaxon,Long>{

    public java.util.List<org.inbio.ara.persistence.taxonomy.UserTaxon> getUserTaxonList(java.lang.Long userId);
    
}
