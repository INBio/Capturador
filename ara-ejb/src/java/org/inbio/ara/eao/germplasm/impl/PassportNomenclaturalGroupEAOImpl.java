/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm.impl;

import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroup;
import javax.persistence.Query;

/**
 *
 * @author dasolano
 */
@Stateless
public class PassportNomenclaturalGroupEAOImpl
        extends BaseEAOImpl<PassportNomenclaturalGroup, Long>
        implements PassportNomenclaturalGroupEAOLocal {


    /**
     * Get all passportNomenclaturalGroups  by passportId
     * @param passportId
     * @return
     */
    public List<PassportNomenclaturalGroup> getAllByPassportId(Long passportId)
    {
        Query q = em.createQuery(
                " from PassportNomenclaturalGroup as png " +
                " where png.passportNomenclaturalGroupPK.passportId = :passportId");
        q.setParameter("passportId", passportId);
        return q.getResultList();
    }


    /**
     * Delete all NomenclaturalGroups associated to a passport
     * @param passportId
     */
    public void deleteByPassportId(Long passportId)
    {
        Query q = em.createQuery(
                " delete from PassportNomenclaturalGroup png " +
                " where png.passportNomenclaturalGroupPK.passportId = :passportId");
        q.setParameter("passportId", passportId);
        q.executeUpdate();
        em.flush();
    }



}