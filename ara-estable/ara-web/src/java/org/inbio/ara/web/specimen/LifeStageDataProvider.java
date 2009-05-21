/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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
/*
 * LifeStageSimpleDataProvider.java
 *
 * Created on June 16, 2008, 5:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.web.specimen;

import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.LifeStageSexSimple;
import org.inbio.ara.facade.specimen.SpecimenRemote;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;

/**
 *
 * @author roaguilar
 */
public class LifeStageDataProvider extends ObjectListDataProvider {

	/** Creates a new instance of LifeStageSimpleDataProvider */
	public LifeStageDataProvider() {
		this.setObjectType(LifeStageSexSimple.class);
	}

	private void refreshDataList(List list) {
		this.setList(list);
	}

	public boolean addElement(LifeStageSexSimple object) {
		List tList;
		tList = this.getList();
		if (objectExists(object) == false) {
			tList.add(object);
			this.refreshDataList(tList);
			return true;
		} else {
			return false;
		}
	}

	public void refreshList(Long specimenId) {

		List specimenList = lookupSpecimenBean().getSpecimenLifeStageSex(specimenId);

		LifeStageSexSimple lsss = null;
		this.setList(new ArrayList());

		for (SpecimenLifeStageSex slss : (List<SpecimenLifeStageSex>) specimenList) {

			lsss = new LifeStageSexSimple();

			lsss.setLifeStage(slss.getLifeStage());
			lsss.setLifeStageName(slss.getLifeStageName());
			lsss.setQuantity(slss.getQuantity());
			lsss.setSex(slss.getSex());
			lsss.setSexName(slss.getSexName());

			this.getList().add(lsss);
		}
	}

	private SpecimenRemote lookupSpecimenBean() {
		try {
			Context c = new InitialContext();
			return (SpecimenRemote) c.lookup("SpecimenBean");
		} catch (NamingException ne) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
			throw new RuntimeException(ne);
		}
	}

	public void removeElement(RowKey rowkey) {
		LifeStageSexSimple object = (LifeStageSexSimple) this.getObject(rowkey);
		List tList = this.getList();
		tList.remove(object);
		this.refreshDataList(tList);
	}

	private boolean objectExists(LifeStageSexSimple object) {
		List<LifeStageSexSimple> tList = this.getList();
		Long newLifeStageId = object.getLifeStage().getId();
		Long newSexId = object.getSex().getId();
		Long actualLifeStageId;
		Long actualSexId;
		for (LifeStageSexSimple tObject : tList) {
			actualLifeStageId = tObject.getLifeStage().getId();
			actualSexId = tObject.getSex().getId();
			System.out.println("--");
			System.out.println(actualLifeStageId + "==" + newLifeStageId + ": " + actualLifeStageId.compareTo(newLifeStageId));
			System.out.println(actualSexId + "==" + newSexId + ": " + actualSexId.compareTo(newSexId));
			if (actualLifeStageId.compareTo(newLifeStageId) == 0) {
				if (actualSexId.compareTo(newSexId) == 0) {
					System.out.println("No agregar el elemento");
					return true;
				}
			}
		}
		return false;
	}
}
