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
 * InstitutionBean.java
 *
 * Created on August 20, 2007, 5:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.facade.institution;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.institution.Institution;
import com.sun.data.provider.SortCriteria;

/**
 *
 * @author roaguilar
 */
@Stateless
public class InstitutionBean implements InstitutionRemote, InstitutionLocal {

	@PersistenceContext
	private EntityManager em;
	private String message;
	private Institution institution;
	private List institutionList;

	/** Creates a new instance of InstitutionBean */
	public InstitutionBean() {
		setMessage("");
	}

	public boolean create(Institution institution) {
		this.institution = institution;
		return persist();
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public boolean update(Institution institution) {
		boolean updated = false;
		if (!isInstitutionNull(institution)) {
			if (this.isInstitutionUnique(institution)) {
				try {
					this.institution = institution;
					em.merge(this.institution);
					updated = true;
				} catch (Exception ex) {
					this.setMessage("El registro No. " + this.institution.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
				}
			} else {
				setMessage("Ya existe otra institución almacenada en el sistema con el mismo nombre. El registro no fue modificado.");
			}
		} else {
			setMessage(getMessage() + " El registro no se modifico.");
		}
		return updated;
	}

	public List findAll() {
		Query q = em.createQuery("Select object(o) from Institution as o");
		this.institutionList = (List) q.getResultList();
		return this.institutionList;
	}

	public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
		String criteria;
		String hql;
		int index;
		hql = "Select object(o) from Institution as o";
		if (sortCriteria != null) {
			hql += " order by ";
			for (index = 0; index < sortCriteria.length; index++) {
				if (index > 0) {
					hql += ", ";
				}
				hql += "o." + sortCriteria[index];
			}
			if (!sortCriteria[0].isAscending()) {
				hql += " desc";
			}
		}
		Query q = em.createQuery(hql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResults);
		this.institutionList = (List) q.getResultList();
		return this.institutionList;
	}

	public boolean remove(Long id) {
		boolean removed = false;
		try {
			this.institution = em.find(org.inbio.ara.persistence.institution.Institution.class, id);
			if (this.canDeleteInstitution(this.institution)) {
				this.institution = em.merge(this.institution);
				em.remove(this.institution);
				removed = true;
			}

		} catch (Exception e) {
			this.setMessage(e.getMessage());
			removed = false;
		}
		return removed;
	}

	public String getMessage() {
		return this.message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public boolean persist() {
		if (!isInstitutionNull(this.institution)) {
			if (isInstitutionUnique(this.institution)) {
				try {
					em.persist(this.institution);
					return true;
				} catch (Exception e) {
					setMessage(e.getLocalizedMessage());
					return false;
				}
			} else {
				setMessage("Ya existe otra institución almacenada en el sistema con el mismo nombre. El registro no fue creado.");
				return false;
			}
		} else {
			setMessage(getMessage() + " El registro no se creó.");
			return false;
		}

	}

	private boolean isInstitutionUnique(Institution institution) {
		boolean isUnique = true;
		String tmpName, sql;
		Long tmpId;

		tmpName = institution.getName();
		sql = "SELECT o FROM Institution o ";
		sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName + "'))";
		if (institution.getId() != null) {
			sql = sql + " and id <> " + institution.getId();
		}
		if (em.createQuery(sql).getResultList().size() > 0) {
			isUnique = false;
		}
		return isUnique;
	}

	private boolean canDeleteInstitution(Institution institution) {
		boolean canDelete = true;
		String errorMessage = "";

		if (!institution.getPersonInstitutionSet().isEmpty()) {
			canDelete = false;
			errorMessage += "El registro No. " + this.institution.getId() + " está asociado al menos una persona.";
		}else if (countTaxaByInstitution(institution.getId()) > 0) {
			canDelete = false;
			errorMessage += "El registro No. " + this.institution.getId() + " está asociado al menos una Institución.";
		}

		if (!canDelete) {
			errorMessage += " No es posible borrarlo.";
		}
		this.setMessage(errorMessage);
		return canDelete;
	}

	private boolean isInstitutionNull(Institution institution) {
		boolean isNull = false;
		String msg = "";
		if ((institution.getName() == null) || (institution.getName().equals(""))) {
			isNull = true;
			msg = "El siguiente campo es obligatorio: Nombre.";
			setMessage(msg);
		}
		return isNull;
	}

	private int countTaxaByInstitution(Long institutionId) {
		Query q;
		q = em.createQuery("Select tdi from TaxonDescriptionInstitution as tdi where tdi.taxonDescriptionInstitutionPK.institutionId = " + institutionId.toString());
		List tList = q.getResultList();
		return tList.size();
	}
}
