/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format.impl;

import org.inbio.ara.eao.format.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.format.ReportLayoutElement;

/**
 *
 * @author pcorrales
 *
 */
@Stateless
public class ReportLayoutElementEAOImpl   extends BaseEAOImpl<ReportLayoutElement,Long>implements ReportLayoutElementEAOLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    public Long findByElementName(String elementName)
    {


        String query = "select e.reportLayoutElementId from ReportLayoutElement as e where " +
                "e.elementKeyword = :elementKeyword";
        Query q = em.createQuery(query);
        q.setParameter("elementKeyword", elementName);
        System.out.println(elementName);
         return (Long) q.getSingleResult();

    }
   
    /**
     *
     * @param query
     * @return
     */
    public String executeQuery(String query) {
         Query q = em.createQuery(query);
         return  q.getSingleResult().toString();
    }
 
}
