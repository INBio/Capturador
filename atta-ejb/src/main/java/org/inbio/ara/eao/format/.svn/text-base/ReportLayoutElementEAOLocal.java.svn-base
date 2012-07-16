/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format;


import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.format.ReportLayoutElement;

/**
 *
 * @author pcorrales
 */
@Local
public interface ReportLayoutElementEAOLocal extends BaseLocalEAO<ReportLayoutElement,Long>{


    /**search the element format with match  the name */
    public Long findByElementName(String elementName);

    /**run the query created with the data element report */
    public String executeQuery(String query);
    
}
