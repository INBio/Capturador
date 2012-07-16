/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.format.ElementFormat;

/**
 *
 * @author pcorrales
 */
@Local
public interface ElementFormatEAOLocal extends BaseLocalEAO<ElementFormat,Long>{
    
}
