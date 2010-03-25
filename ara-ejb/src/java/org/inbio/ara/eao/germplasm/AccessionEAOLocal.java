/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Accession;

/**
 *
 * @author dasolano
 */
@Local
public interface AccessionEAOLocal extends BaseLocalEAO<Accession,Long>
{

    public List<Long> findByAccessionNumber(String accessionNumber);

    public List<Long> findByPackages(Long packages);

    public List<Long> findByOriginalWeigth(Long originalWeigth);

    public List<Long> findByCurrentWeigth(Long currentWeigth);

    public List<Long> findByPassportId(Long passportId);

    public List<Long> findByResponsablePersonId(Long responsablePersonId);

    public List<Long> findByAccessionParentId(Long accessionParentId);

    public List<Long> findByGerminationMethodId(Long germinationMethodId);

    public List<Long> findByGerminationRate(Long germinationRate);
}
