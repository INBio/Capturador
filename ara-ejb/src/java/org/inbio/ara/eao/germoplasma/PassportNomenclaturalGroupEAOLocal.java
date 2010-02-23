/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germoplasma;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germoplasma.PassportNomenclaturalGroup;

/**
 *
 * @author dasolano
 */
@Local
public interface PassportNomenclaturalGroupEAOLocal extends BaseLocalEAO<PassportNomenclaturalGroup,Long>{

    /**
     * Get all passportNomenclaturalGroups  by passportId
     * @param passportId
     * @return
     */
    public List<PassportNomenclaturalGroup> getAllByPassportId(Long passportId);

    /**
     * Delete all NomenclaturalGroups associated to a passport
     * @param passportId
     */
    public void deleteByPassportId(Long passportId);
}