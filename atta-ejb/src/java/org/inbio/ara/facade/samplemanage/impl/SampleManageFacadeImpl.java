/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.facade.samplemanage.impl;

import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.dto.samplemanage.SampleDTO;
import org.inbio.ara.facade.samplemanage.SampleManageFacadeRemote;
import javax.ejb.Stateless;
import org.inbio.ara.dto.samplemanage.EnviromentalDataDTO;
import org.inbio.ara.dto.samplemanage.EnviromentalDataDTOFactory;
import org.inbio.ara.dto.samplemanage.HostInformationDTO;
import org.inbio.ara.dto.samplemanage.HostInformationDTOFactory;
import org.inbio.ara.dto.samplemanage.SampleDTOFactory;
import org.inbio.ara.eao.samplemanage.EnviromentalDataEAOLocal;
import org.inbio.ara.eao.samplemanage.HostInformationEAOLocal;
import org.inbio.ara.eao.samplemanage.SampleEAOLocal;
import org.inbio.ara.persistence.samplemanage.Sample;

/**
 *
 * @author dasolano
 */
@Stateless
public class SampleManageFacadeImpl implements SampleManageFacadeRemote
{

    @EJB
    private SampleEAOLocal sampleEAOLocal;

    @EJB
    private EnviromentalDataEAOLocal enviromentalDataEAOLocal;

    @EJB
    private HostInformationEAOLocal hostInformationEAOLocal;


    private SampleDTOFactory sampleDTOFactory = new SampleDTOFactory();

    private EnviromentalDataDTOFactory enviromentalDataDTOFactory = new EnviromentalDataDTOFactory();

    private HostInformationDTOFactory hostInformationDTOFactory = new HostInformationDTOFactory();

    public void saveSample(SampleDTO sampleDTO) {

        Sample s = sampleDTOFactory.createPlainEntity(sampleDTO);
        sampleEAOLocal.create(s);
        List<EnviromentalDataDTO> elist = sampleDTO.getEnviromentalDataDTOList();
        for (EnviromentalDataDTO enviromentalDataDTO : elist)
        {
            enviromentalDataDTO.setSampleId(s.getSampleId());
            enviromentalDataDTO.setUserName(sampleDTO.getUserName());
            enviromentalDataEAOLocal.create(enviromentalDataDTOFactory.createPlainEntity(enviromentalDataDTO));
        }

        List<HostInformationDTO> hlist = sampleDTO.getHostInformationDTOList();
        for (HostInformationDTO hostInformationDTO : hlist)
        {
            hostInformationDTO.setSampleId(s.getSampleId());
            hostInformationDTO.setUserName(sampleDTO.getUserName());
            hostInformationEAOLocal.create(hostInformationDTOFactory.createPlainEntity(hostInformationDTO));
        }

    }

    public List<SampleDTO> getAllSamplePaginated(int firstResult, int maxResult) {
        String[] fields = {"witness"};
        List<Sample> s = sampleEAOLocal.findAllPaginatedFilterAndOrderBy(Sample.class, firstResult, maxResult, fields, null);
        return sampleDTOFactory.createDTOList(s
            );
        
    }

    public Long countAllSample() {
        return sampleEAOLocal.count(Sample.class);
    }
    
 
}
