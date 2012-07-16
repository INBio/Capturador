/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.specimen;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SpecimenEAOLocal extends BaseLocalEAO<Specimen,Long>{

    public List<Long> findByGathObsId(Long gathObsId);

    public List<Long> findByGathObsId(Long initialGathObs, Long finalGathObs);


    public List<Long> findByCollectionName(String collectionName);

    public Long findByCatalogNumber(String catalogNumber);

    public List<Long> findByCatalogNumber(String catalogNumberFirst, String catalogNumberEnd);

    public java.util.List<java.lang.Long> findByInstitutionId(java.lang.Long institutionId);

    public java.util.List<java.lang.Long> findByCollectionId(java.lang.Long collectionId);

    public java.util.List<java.lang.Long> findByTaxonName(java.lang.String taxonName);

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param maxResults
     * @return
     * @deprecated Use instead the method below:
     * public List<Specimen> getAllSpecimenIdentificatedPaginated(int first,
     *      int maxResults, <b>int collectionId</b>)
     */
    public List<Specimen> getAllSpecimenIdentificatedPaginated(int first, int maxResults);

    public org.inbio.ara.persistence.specimen.Specimen getLastSpecimen();

    public java.util.List<java.lang.Long> findByGathObsDetailId(java.lang.Long gathObsDetailId);

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param maxResults
     * @return List of Specimens
     */
    public List<Specimen> getAllSpecimenIdentificatedPaginated(int first,
            int maxResults, Long collectionId);

}
