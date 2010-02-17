/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.security;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;

/**
 *
 * @author esmata
 */
@Local
public interface NomenclaturalGroupEAOLocal extends BaseLocalEAO<NomenclaturalGroup,Long>{

    public java.util.List<org.inbio.ara.persistence.taxonomy.NomenclaturalGroup> getNomenclaturalGroupList(java.lang.Long userId);
    
}
