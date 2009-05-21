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
 * TaxonDescriptionStageBean.java
 *
 * Created on March 12, 2008, 5:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;
import javax.persistence.EntityExistsException;
import org.inbio.ara.persistence.species.SpeciesRecordStageProfile;
import org.inbio.ara.persistence.species.StageTransitionDigraph;

/**
 *
 * @author mvargas
 */
@Stateless
public class TaxonDescriptionStageBean implements TaxonDescriptionStageRemote, TaxonDescriptionStageLocal {

	@PersistenceContext
	private EntityManager em;
	private TaxonDescriptionStage taxonDescriptionStage;
	private List taxonDescriptionStageList;
	private String message;

	/** Creates a new instance of TaxonDescriptionStageBean */
	public TaxonDescriptionStageBean() {
		message = "";
	}

	public boolean create(TaxonDescriptionStage taxonDescriptionStage) {
		System.out.println(taxonDescriptionStage.getName());
		System.out.println(taxonDescriptionStage.getDescription());
		System.out.println(taxonDescriptionStage.getCreatedBy());
		System.out.println(taxonDescriptionStage.getLastModificationBy());
		System.out.println(taxonDescriptionStage.getId());
		this.taxonDescriptionStage = taxonDescriptionStage;
		return persist();
	}

	public TaxonDescriptionStage getStage() {
		return this.taxonDescriptionStage;
	}

	public boolean update(TaxonDescriptionStage taxonDescriptionStage) {
		boolean updated = false;
		if (!isStageNull(taxonDescriptionStage)) {
			if (this.isStageUnique(taxonDescriptionStage)) {
				try {
					this.taxonDescriptionStage = taxonDescriptionStage;
					em.merge(this.taxonDescriptionStage);
					updated = true;
				} catch (Exception ex) {
					this.setMessage("El registro No. " + this.taxonDescriptionStage.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
				}
			} else {
				setMessage("Ya existe otra etapa almacenada en el sistema con el mismo nombre. El registro no fue modificado.");
			}
		} else {
			this.setMessage(this.getMessage() + " El registro no se modifico.");
		}
		return updated;
	}

	public List findAll() {
		Query q = em.createQuery("Select object(o) from TaxonDescriptionStage as o");
		this.taxonDescriptionStageList = (List) q.getResultList();
		return this.taxonDescriptionStageList;
	}

	public TaxonDescriptionStage find(Long id) {
		String jpql = "from TaxonDescriptionStage as o ";
		jpql += "where o.id = " + id;
		Query q = em.createQuery(jpql);
		return (TaxonDescriptionStage) q.getSingleResult();
	}

	public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
		String hql;
		int index;
		Query q;

		//hql = "Select object(o) from SpeciesRecordStage as o";
		hql = "Select object(o) from TaxonDescriptionStage as o";
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
		q = em.createQuery(hql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResults);
		return q.getResultList();
	}

	public boolean remove(Long id) {
		boolean removed = false;
		try {
			this.taxonDescriptionStage = em.find(org.inbio.ara.persistence.species.TaxonDescriptionStage.class, id);
			if (this.canDeleteStage(this.taxonDescriptionStage)) {
				//Si se usa en el digrafo si se puede borrar.
				removeUsagesInSTD(id);
				removeUsagesInSRSP(id);





				this.taxonDescriptionStage = em.merge(this.taxonDescriptionStage);
				em.remove(this.taxonDescriptionStage);
				removed = true;
			}
		} catch (Exception e) {
			this.setMessage(e.getMessage());
			removed = false;
		}
		return removed;
	}

	private boolean canDeleteStage(TaxonDescriptionStage stage) {
		boolean canDelete = true;
		String errorMessage = "";
		//******************
		//if (!stage.getSpeciesRecordSet().isEmpty()) {
		if (isStageUsedInTDR(stage.getId())) {
			canDelete = false;
			errorMessage = "El registro No. " + stage.getId() + " está asociado al menos a un registro de especie.";
		}
		//if (!stage.getSpeciesRecordSet().isEmpty()) {
		/*
		if (isStageUsedInSRSP(stage.getId())) {
		canDelete = false;
		errorMessage = "El registro No. " + stage.getId() +  " está asociado al menos a un perfil.";
		}
		 */
		//
		if (isStageUsedInSTD(stage.getId())) {
			canDelete = false;
			errorMessage = "El registro No. " + stage.getId() + " está asociado al menos a stage transition date.";
		}
		if (!canDelete) {
			errorMessage += " No es posible borrarlo.";
		}
		this.setMessage(errorMessage);
		//******************
		return canDelete;
	}

	/**
	 * isStageUsedInTaxonDescriptionRecord
	 * @param stageId
	 * @return boolean
	 */
	private boolean isStageUsedInTDR(long stageId) {
		String jpql = "from TaxonDescription as o where " +
				"o.taxonDescriptionStage.id = " + stageId;
		try {
			if (em.createQuery(jpql).getResultList().size() > 0) {
				return true;
			}
		} catch (EntityExistsException e1) {
			this.setMessage(e1.getMessage());
			return false;
		} catch (IllegalStateException e2) {
			this.setMessage(e2.getMessage());
			return false;
		} catch (IllegalArgumentException e3) {
			this.setMessage(e3.getMessage());
			return false;
		} catch (NullPointerException e5) {
			this.setMessage(e5.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * isStageUsedInSpeciesRecordStageProfile
	 * @param stageId
	 * @return boolean
	 */
	private boolean isStageUsedInSRSP(long stageId) {
		String jpql = "from SpeciesRecordStageProfile as o where " +
				"o.speciesRecordStageProfilePK.speciesRecordStageId = " + stageId;
		try {
			if (em.createQuery(jpql).getResultList().size() > 0) {
				return true;
			}
		} catch (EntityExistsException e1) {
			this.setMessage(e1.getMessage());
			return false;
		} catch (IllegalStateException e2) {
			this.setMessage(e2.getMessage());
			return false;
		} catch (IllegalArgumentException e3) {
			this.setMessage(e3.getMessage());
			return false;
		} catch (NullPointerException e5) {
			this.setMessage(e5.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * isStageUsedInStageTransitionDate
	 * @param stageId
	 * @return boolean
	 */
	private boolean isStageUsedInSTD(long stageId) {
		String jpql = "from StageTransitionDate as o where " +
				"o.stage.id = " + stageId;
		try {
			if (em.createQuery(jpql).getResultList().size() > 0) {
				return true;
			}
		} catch (EntityExistsException e1) {
			this.setMessage(e1.getMessage());
			return false;
		} catch (IllegalStateException e2) {
			this.setMessage(e2.getMessage());
			return false;
		} catch (IllegalArgumentException e3) {
			this.setMessage(e3.getMessage());
			return false;
		} catch (NullPointerException e5) {
			this.setMessage(e5.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * removeUsagesInStageTransitionDigraph
	 * @param stageId
	 * @return void
	 */
	private void removeUsagesInSTD(long stageId) {
		String jpql = "from StageTransitionDigraph as o where " +
				"o.stageTransitionDigraphPK.speciesRecordStageToId = " +
				stageId + " or " +
				"o.stageTransitionDigraphPK.speciesRecordStageFromId = " +
				stageId;
		try {
			List<StageTransitionDigraph> list =
					em.createQuery(jpql).getResultList();
			if (list.size() > 0) {
				for (StageTransitionDigraph STD : list) {
					em.remove(STD);
				}
			}
		} catch (EntityExistsException e1) {
			this.setMessage(e1.getMessage());
		} catch (IllegalStateException e2) {
			this.setMessage(e2.getMessage());
		} catch (IllegalArgumentException e3) {
			this.setMessage(e3.getMessage());
		} catch (NullPointerException e5) {
			this.setMessage(e5.getMessage());
		}
	}

	private void removeUsagesInSRSP(long stageId) {

		String jpql = "from SpeciesRecordStageProfile as o where " +
				"o.speciesRecordStageProfilePK.speciesRecordStageId = " + stageId;
		try {
			List<SpeciesRecordStageProfile> list = em.createQuery(jpql).getResultList();

			if (list.size() > 0) {
				for (SpeciesRecordStageProfile STD : list) {
					em.remove(STD);
				}
			}
		} catch (EntityExistsException e1) {
			this.setMessage(e1.getMessage());
		} catch (IllegalStateException e2) {
			this.setMessage(e2.getMessage());
		} catch (IllegalArgumentException e3) {
			this.setMessage(e3.getMessage());
		} catch (NullPointerException e5) {
			this.setMessage(e5.getMessage());
		}
	}

	private boolean isStageNull(TaxonDescriptionStage taxonDescriptionStage) {
		boolean isNull = false;
		String msg = "";
		if ((taxonDescriptionStage.getName() == null) || (taxonDescriptionStage.getName().equals(""))) {
			isNull = true;
			msg = "El siguiente campo es obligatorio: Nombre";
			setMessage(msg);
		}
		return isNull;
	}

	private boolean isStageUnique(TaxonDescriptionStage taxonDescriptionStage) {
		boolean isUnique = true;
		String tmpName, sql;
		Long tmpId;

		tmpName = taxonDescriptionStage.getName();
		sql = "SELECT o FROM TaxonDescriptionStage o ";
		sql += "where trim(lower(name)) = trim(lower('" + tmpName + "')) ";
		if (taxonDescriptionStage.getId() != null) {
			sql = sql + " and id <> " + taxonDescriptionStage.getId();
		}
		if (em.createQuery(sql).getResultList().size() > 0) {
			isUnique = false;
		}
		return isUnique;
	}

	private boolean persist() {
		if (!isStageNull(this.taxonDescriptionStage)) {
			if (isStageUnique(this.taxonDescriptionStage)) {
				try {
					em.persist(this.taxonDescriptionStage);
					return true;
				} catch (EntityExistsException e1) {
					this.setMessage(e1.getMessage());
					return false;
				} catch (IllegalStateException e2) {
					this.setMessage(e2.getMessage());
					return false;
				} catch (IllegalArgumentException e3) {
					this.setMessage(e3.getMessage());
					return false;
				} catch (NullPointerException e5) {
					this.setMessage(e5.getMessage());
					return false;
				}
			}
		}
		return false;
	}

	public String getMessage() {
		return this.message;
	}

	private void setMessage(String message) {
		this.message = message;
	}
}
