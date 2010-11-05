/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.persistence.institution.Institution;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class InstitutionEAOImpl extends BaseEAOImpl<Institution,Long> implements InstitutionEAOLocal  {

    /**
     * @deprecated 
     */
    public List<InstitutionDTO> getAllInstitutions() {
        Query query = em.createQuery("select new org.inbio.ara.dto.agent.InstitutionDTO(i.institutionCode,i.institutionId) from Institution as i");
        return query.getResultList();
    }

    public List<Institution> getInstitutionsByPerson(Long personId){
        String sql = "Select i ";
              sql += "from Institution i, PersonInstitution pi ";
              sql += "where i.institutionId = pi.personInstitutionPK.institutionId " +
                      "and pi.personInstitutionPK.personId = :personId " +
                      " order by i.institutionCode";
        Query q = em.createQuery(sql);
		q.setParameter("personId", personId);
        return (List<Institution>)q.getResultList();
    }

    public List<Institution> getInstitutionsByTaxonDescription(Long taxonId,
            Long taxonDescriptionSequence){
        String sql = "Select i ";
              sql += "from Institution i, TaxonDescriptionInstitution tdi ";
              sql += "where i.institutionId = tdi.taxonDescriptionInstitutionPK.institutionId " +
                      "and tdi.taxonDescriptionInstitutionPK.taxonId = :taxonId "+
                      "and tdi.taxonDescriptionInstitutionPK.taxonDescriptionSequence = :taxonDescriptionSequence";
        Query q = em.createQuery(sql);
		q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
        return (List<Institution>)q.getResultList();
    }

    public List<Institution> getInstitutionsByInstitutionCode(String institutionCode){
        Query q = em.createQuery("from Institution i where i.institutionCode = '" + institutionCode + "'");//:institutionCode'");
        return (List<Institution>)q.getResultList();
    }
}
