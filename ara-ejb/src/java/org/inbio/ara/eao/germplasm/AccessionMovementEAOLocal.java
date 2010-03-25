/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.AccessionMovement;

/**
 *
 * @author dasolano
 */
@Local
public interface AccessionMovementEAOLocal extends BaseLocalEAO<AccessionMovement,Long>{

    public List<AccessionMovement> findAllPaginatedByAccessionId(Long accessionId);

    public Long countAllByAccessionId(Long accessionId);

    public AccessionMovement findByAccessionIdAndDateTime(Long accessionId, Date datetimeAux);

    
    
}
