/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;

/**
 *
 * @author asanabria
 */
@Local
public interface TaxonomicalRangeEAOLocal  extends BaseLocalEAO<TaxonomicalRange,Long>  {
    
}
