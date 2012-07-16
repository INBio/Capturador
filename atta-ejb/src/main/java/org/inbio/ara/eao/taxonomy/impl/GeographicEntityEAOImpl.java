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
import org.inbio.ara.persistence.taxonomy.GeographicEntity;

/**
 *
 * @author esmata
 */
@Stateless
public class GeographicEntityEAOImpl 
        extends BaseEAOImpl<GeographicEntity, Long>
        implements GeographicEntityEAOLocal {
    
    public List<GeographicEntity> allGeographicEntityOrderByName(){
        Query q = em.createQuery("from GeographicEntity order by name");
        return (List<GeographicEntity>)q.getResultList();
    }
 
}
