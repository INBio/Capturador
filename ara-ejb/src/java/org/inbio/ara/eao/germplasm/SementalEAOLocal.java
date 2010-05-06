/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Semental;

/**
 *
 * @author dasolano
 */
@Local
public interface SementalEAOLocal extends BaseLocalEAO<Semental,Long> {

    public List<Long> findByBreedId(Long breedId);

    public List<Long> findByBreedName(String breedName);

    public List<Long> findByAnimalName(String animalName);

    public List<Long> findByAnimalCode(String animalCode);

    public List<Long> findByBirthDate(Calendar birthDate);

    public List<Long> findByVeterinarianStatus(String veterinarianStatus);

    public List<Long> findByConditionId(Long conditionId);

    public List<Long> findByCondition(String condition);

    public List<Long> findByAnimalDescription(String animalDescription);

    public List<Long> findByLocalityId(Long localityId);

    public List<Long> findByFather(String father);

    public List<Long> findByMother(String mother);

    public List<Long> findByColor(String color);
    
}
