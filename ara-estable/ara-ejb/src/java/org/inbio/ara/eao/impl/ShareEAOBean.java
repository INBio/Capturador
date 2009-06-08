/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.inbio.ara.eao.ShareEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import org.inbio.ara.persistence.share.PliElement;
import org.inbio.ara.persistence.specimen.DarwinCore14;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;

/**
 *
 * @author esmata
 */
@Stateless 
public class ShareEAOBean extends BaseEAOImpl implements ShareEAOLocal{
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    /**
     * Method to retrive information from darwin core table to create Dwc snapshot
     * @param q is the specific query to execute
     * @return List of DarwinCore14 objects (depending on query "q")
     * @deprecated 
     */
    @Override
    public List<DarwinCore14> retriveInformationDcw(String q){
        em.setFlushMode(FlushModeType.COMMIT);
		Query query = em.createQuery(q);
		List result = (List)query.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
        return result;
    }
    /**
     * Method to retrive all information from darwin core table to create Dwc snapshot
     * @deprecated (Se trae la memoria la suelo)
     * @return List of DarwinCore14 objects (All)
     */
    @Override
    public List<DarwinCore14> retriveInformationDcwAll(){
        em.setFlushMode(FlushModeType.COMMIT);
		Query query = em.createQuery("from DarwinCore14");
		List result = (List)query.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
        return result;
    }

    //Method to get a especific darwin core element
    @Override
	public DwcElement getDwCElementById(BigDecimal id) {
		return em.find(DwcElement.class, id);
	}

    //Method to get a especific darwin core element
    @Override
	public PliElement getPliElementById(BigDecimal id) {
		return em.find(PliElement.class, id);
	}

    //Method to get a list of darwin core elements
    @Override
	public List<DwcElement> getDwCElements() {
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from DwcElement");
		List elements = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
	}

    //Method to get a list of darwin core categories
    @Override
	public List<DwcCategory> getDwCCategories() {
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from DwcCategory");
        List elements = (List)q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
	}

    //Method to get a list of darwin core elements
    @Override
	public List<PliElement> getPliElements() {
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from PliElement");
		List elements = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
	}

    //Method to delete all entries on darwin core snapshot table
    //Return the number of entities deleted
    @Override
    public int deleteAllDwcSnapshot(){
        Query q = em.createQuery("delete from DwcSnapshot s");
        int result = q.executeUpdate();
        return result;
    }
    @Override
    public void truncateDwcSnapshot(){
        Query q = em.createNativeQuery("truncate ara.dwc_snapshot;");
        q.executeUpdate();
    }

    //Method to dellete all entries from darwin core 14 table
    @Override
    public int deleteAllDwcTable(){
        Query q = em.createQuery("delete from DarwinCore14 dwc");
        int result = q.executeUpdate();
        return result;
    }

    /**
     * Methot to get a list of Taxon Author by taxonId ordered by secuense
     * @param tId  taxon id
     * @param taCategory Taxon Author category. "o" = Original,"m" = Modificator
     */
    @Override
    public List<TaxonAuthor> getTaxonAuthorList(Long tId, String taCategory){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from TaxonAuthor as ta where ta.taxon.id = :taxonId and ta.taxonAuthorPK.category = :category order by ta.taxonAuthorPK.taxonAuthorSequence desc");
        q.setParameter("taxonId", (Long) tId);
        q.setParameter("category", (String) taCategory);
		List elements = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
    }

    //Method to get a list of specimen identifiers (individuals and observations)
    @Override
    public List<Long> getSpecimenIdList(){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("select s.id from Specimen as s where s.specimenCategory.id = 1 or s.specimenCategory.id = 2");
		List specimens = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return specimens;
    }

    //Method to get a list of specimen identifiers (Agrupados unitaxon)
    @Override
    public List<Long> getSpecimenIdListAU(){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("select s.id from Specimen as s where s.specimenCategory.id = 3");
		List specimens = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return specimens;
    }

    //Method to get a list of specimen identifiers (Agrupados multitaxon)
    @Override
    public List<Long> getSpecimenIdListAM(){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("select s.id from Specimen as s where s.specimenCategory.id = 4");
		List specimens = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return specimens;
    }

    //Method to find a specific specimen
    @Override
    public Specimen findSpecimen(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("from Specimen as s where s.id = :specimenId");
            q.setParameter("specimenId", (Long) sId);
            em.setFlushMode(FlushModeType.AUTO);
            return (Specimen)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /* Method to get the specimen identification date by specimen id*/
    @Override
    public Date getIdentificationDate(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select i.identificationDate from Identification as i where i.specimen.id = :specimenId and i.identificationPK.identificationSequence = 1");
            q.setParameter("specimenId", (Long)sId);
            em.setFlushMode(FlushModeType.AUTO);
            return (Date)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /** Method to get the name who made the specimen identification
     * @param sId specimen identifier
     */
    @Override
    public String getIdentifiedBy(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select i.person.lastName,i.person.firstName from Identifier as i where i.identification.specimen.id = :specimenId and i.identification.identificationPK.identificationSequence = 1");
            q.setParameter("specimenId", (Long)sId);
            Object[] result = (Object[])q.getSingleResult();
            em.setFlushMode(FlushModeType.AUTO);
            return result[0]+", "+result[1];
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /* Method to get the identification qualifier by especific specimen identification */
    @Override
    public String getIdentificationqualifier(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select i.identificationType.name from Identification as i where i.specimen.id = :specimenId and i.identificationPK.identificationSequence = 1");
            q.setParameter("specimenId", (Long)sId);
            em.setFlushMode(FlushModeType.AUTO);
            return (String)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /** Method to get  list of SpecimenLifeStageSex asocieted of a specific specimen
     * @param sId specimen identifier
     * @return list of SpecimenLifeStageSex
     */
    @Override
    public List<SpecimenLifeStageSex> getSLsSListBySpecimen(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from SpecimenLifeStageSex as slss where slss.specimen.id = :specimenId");
        q.setParameter("specimenId", (Long) sId);
		List elements = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
    }

    /** Methot to get a lis of identifications related with a specific
     * grouped multitaxon specimen id
     * @param sId specimen id
     * @return a list of speciemn identifications
     */
    @Override
    public List<Identification> getIdentificationList(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
		Query q = em.createQuery("from Identification as i where i.specimen.id = :specimenId");
        q.setParameter("specimenId", (Long) sId);
		List elements = (List) q.getResultList();
        em.setFlushMode(FlushModeType.AUTO);
		return elements;
    }

    /** Method to get the taxon asociated to specific Identification
     * @param sId espedimen Id
     * @return Long taxon id
     */
    @Override
    public Long getTaxonIdentificationId(Long sId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select i.taxon.id from Identification as i where i.specimen.id = :specimenId and i.identificationPK.identificationSequence = 1");
            q.setParameter("specimenId", (Long)sId);
            em.setFlushMode(FlushModeType.AUTO);
            return (Long)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /** Method to get the taxon asociated to specific Identification
     * @param sId espedimen Id
     * @param iSequence identification sequence
     * @return Long taxon id
     */
    @Override
    public Long getTaxonIdentificationIdAM(Long sId, Long iSequence){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select i.taxon.id from Identification as i where i.specimen.id = :specimenId and i.identificationPK.identificationSequence = :sequence");
            q.setParameter("specimenId", (Long)sId);
            q.setParameter("sequence", (Long)iSequence);
            em.setFlushMode(FlushModeType.AUTO);
            return (Long)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /** To get escription year from existing taxon
     * @param taxonId taxon identifier
     * @return the description year for this taxon
     */
    @Override
    public Long getTaxonDescriptionYear(Long taxonId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select t.descriptionYear from Taxon as t where t.id = :tId");
            q.setParameter("tId", (Long)taxonId);
            em.setFlushMode(FlushModeType.AUTO);
            return (Long)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return new Long(0);}
    }

    /* Returns the format parentesis (0,1) from existing taxon */
    @Override
    public Long getTaxonAuthorFormatParenthesis(Long taxonId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select t.authorFormatParenthesis from Taxon as t where t.id = :tId");
            q.setParameter("tId", (Long)taxonId);
            em.setFlushMode(FlushModeType.AUTO);
            return (Long)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return new Long(0);}
    }

    /* Returns the format parentesis (0,1) from existing taxon */
    @Override
    public String getTaxonDefaultName(Long taxonId){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            Query q = em.createQuery("select t.defaultName from Taxon as t where t.id = :tId");
            q.setParameter("tId", (Long)taxonId);
            em.setFlushMode(FlushModeType.AUTO);
            return (String)q.getSingleResult();
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

    /** Truncate ara.DARWIN_CORE_1_4 table by native query
     * truncate was included on sql ansi, 2008
     */
    @Override
    public void truncateDwcTable(){
        Query q = em.createNativeQuery("truncate ara.darwin_core_1_4;");
        q.executeUpdate();
    }

    /** @param tId identifier taxon
     * @param t type of taxon
     * @return if t = a > kingdomTaxon
     * if t = b > phylumDivisionTaxon
     * if t = c > classTaxon
     * if t = d > orderTaxon
     * if t = e > familyTaxon
     * if t = f > genusTaxon
     * if t = g > speciesTaxon
     * if t = h > subspeciesTaxon
     */
    @Override
    public Object[] getTaxomonyIds(Long tId,char t){
        em.setFlushMode(FlushModeType.COMMIT);
        try{
            switch(t){
                case 'a':{
                    Query q = em.createQuery("select t.kingdomTaxon.id,t.kingdomTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'b':{
                    Query q = em.createQuery("select t.phylumDivisionTaxon.id,t.phylumDivisionTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'c':{
                    Query q = em.createQuery("select t.classTaxon.id,t.classTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'd':{
                    Query q = em.createQuery("select t.orderTaxon.id,t.orderTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'e':{
                    Query q = em.createQuery("select t.familyTaxon.id,t.familyTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'f':{
                    Query q = em.createQuery("select t.genusTaxon.id,t.genusTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'g':{
                    Query q = em.createQuery("select t.speciesTaxon.id,t.speciesTaxon.defaultName from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                case 'h':{
                    Query q = em.createQuery("select t.subspeciesTaxon.id from Taxon as t where t.id = :taxonId");
                    q.setParameter("taxonId", (Long)tId);
                    return (Object[]) q.getSingleResult();
                }
                default:{
                    em.setFlushMode(FlushModeType.AUTO);
                    return null;
                }
            }
        }
        catch(Exception e){em.setFlushMode(FlushModeType.AUTO);return null;}
    }

}
