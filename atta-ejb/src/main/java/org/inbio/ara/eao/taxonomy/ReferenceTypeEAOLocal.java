/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.ReferenceType;

/**
 *
 * @author esmata
 */
@Local
public interface ReferenceTypeEAOLocal 
        extends BaseLocalEAO<ReferenceType, Long>{

    public java.util.List<org.inbio.ara.persistence.taxonomy.ReferenceType> allReferenceTypeOrderByName();
    
}
