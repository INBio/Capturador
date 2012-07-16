/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;

import java.util.List;
import org.inbio.ara.eao.taxonomy.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.ReferenceType;

/**
 *
 * @author esmata
 */
@Stateless
public class ReferenceTypeEAOImpl 
        extends BaseEAOImpl<ReferenceType, Long>
        implements ReferenceTypeEAOLocal {

    public List<ReferenceType> allReferenceTypeOrderByName(){
        Query q = em.createQuery("from ReferenceType order by name");
        return (List<ReferenceType>)q.getResultList();
    }
 
}
