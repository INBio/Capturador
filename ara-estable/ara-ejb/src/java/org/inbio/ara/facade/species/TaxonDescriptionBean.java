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
 * TaxonDescriptionBean.java
 *
 * Created on November 1, 2007, 10:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.PersonProfile;
import org.inbio.ara.persistence.species.Audience;
import org.inbio.ara.persistence.species.TaxonDescriptionAudience;
import org.inbio.ara.persistence.species.TaxonDescriptionAudiencePK;
import org.inbio.ara.persistence.species.TaxonDescriptionInstitution;
import org.inbio.ara.persistence.species.TaxonDescriptionPersonProfile;
import org.inbio.ara.persistence.species.TaxonDescriptionPersonProfilePK;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;
import org.inbio.ara.persistence.util.Language;

/**
 *
 * @author roaguilar
 */
@Stateless
public class TaxonDescriptionBean implements TaxonDescriptionRemote, TaxonDescriptionLocal {

    @PersistenceContext
    private EntityManager em;
    private TaxonDescription taxonDescription;
    private List taxonDescriptionList;
    private List taxonDescriptionRecordList;
    private String message = "No hay mensaje definido";
    
    /**
     * Creates a new instance of TaxonDescriptionBean
     */
    public TaxonDescriptionBean() {
    }

    public boolean persist(TaxonDescription taxonDescription) {
        try {        
            try {
                taxonDescription.setLanguage(em.find(Language.class,taxonDescription.getLanguage().getLanguageId()));
                taxonDescription.setTaxonDescriptionStage(em.find(TaxonDescriptionStage.class,taxonDescription.getTaxonDescriptionStage().getId()));
                em.persist(taxonDescription);
                this.taxonDescription = em.merge(taxonDescription);
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
            /*} catch (TransactionRequiredException e4) {
                this.setMessage(e4.getMessage());
                return false;*/
            } catch (NullPointerException e5) {
                this.setMessage(e5.getMessage());
                return false;
            }
        } catch (IllegalStateException e) {
            setMessage(e.getLocalizedMessage());
            return false;
        } catch (IllegalArgumentException ex) {
            setMessage(ex.getMessage());
            return false;
        } catch (NullPointerException ex2) {
            setMessage(ex2.getMessage());
            return false;
        }
    }

    public TaxonDescription getTaxonDescription() {
        return taxonDescription;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    private void setMessage(String message) {
        this.message = message;
    }
    

    public List getTaxonDescriptionList() {
        return taxonDescriptionList;
    }

    public void setTaxonDescriptionList(List taxonDescriptionList) {
        this.taxonDescriptionList = taxonDescriptionList;
    }

    public List getTaxonDescriptionRecordList() {
        return taxonDescriptionRecordList;
    }

    public void setTaxonDescriptionRecordList(List taxonDescriptionRecordList) {
        this.taxonDescriptionRecordList = taxonDescriptionRecordList;
    }

    public void setTaxonDescription(TaxonDescription taxonDescription) {
        this.taxonDescription = taxonDescription;
    }

    public boolean create(TaxonDescription taxonDescription) {
        if (!this.isTaxonDescriptionNull(taxonDescription)) {
            this.setTaxonDescription(taxonDescription);
            if (this.isTaxonDescriptionUnique()) {
                return this.persist(taxonDescription);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean update(TaxonDescription taxonDescription) {
        boolean updated = true;
        try {
            this.setTaxonDescription(taxonDescription);
            taxonDescription.setLanguage(em.find(Language.class,taxonDescription.getLanguage().getLanguageId()));
            taxonDescription.setTaxonDescriptionStage(em.find(TaxonDescriptionStage.class,taxonDescription.getTaxonDescriptionStage().getId()));
            this.taxonDescription = em.merge(this.getTaxonDescription());
            updated = true;
        } catch (Exception e) {
            //this.setMessage("El registro No. " + getTaxonDescription().getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
            this.setMessage("");
        }
        return updated;
    }
    
    public boolean update(TaxonDescription taxonDescription, Long[] audienceArray, Long[] authorArray, Long[] institutionArray) {
        if (update(taxonDescription)) {
            if (this.clearList()) {
                this.updateAudienceList(audienceArray);
                this.updateAuthorList(authorArray);
                this.updateInstitutionList(institutionArray);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Long taxonId, Long sequence) {
        /*TaxonDescriptionPK pk = new TaxonDescriptionPK();
        pk.setTaxonId(taxonId);
        pk.setTaxonDescriptionSequence(sequence);
        this.taxonDescription = em.find(TaxonDescription.class, pk);
        this.taxonDescription = em.merge(this.taxonDescription);
        em.remove(this.taxonDescription);
        return true;*/
        //if (this.deleteTaxonDescriptionRecordReference(taxonId, sequence)) {
            if (this.deleteTaxonDescriptionRecord(taxonId, sequence)) {
                if (this.deleteStageTransitionDate(taxonId, sequence)) {
                    if (this.deleteTaxonDescriptionAudience(taxonId, sequence)) {
                        if (this.deleteTaxonDescriptionInstitution(taxonId, sequence)) {
                            if (this.deleteTaxonDescriptionPersonProfile(taxonId, sequence)) {
                                /*TaxonDescriptionPK pk = new TaxonDescriptionPK();
                                pk.setTaxonId(taxonId);
                                pk.setTaxonDescriptionSequence(sequence);
                                this.taxonDescription = em.find(TaxonDescription.class, pk);
                                this.taxonDescription = em.merge(this.taxonDescription);
                                em.remove(this.taxonDescription);*/
                                return true;
                            } else {
                                setMessage("Error al eliminar autores");
                                return false;
                            }
                        } else {
                            setMessage("Error al eliminar instituciones asociadas");
                            return false;
                        }
                    } else {
                        setMessage("Error al eliminar audiencias asociadas");
                        return false;
                    }
                } else {
                    setMessage("Error al eliminar históricos de transiciones.");
                    return false;
                }
            } else {
                setMessage("Error al eliminar descripciones asociadas");
                return false;
            }
        /*} else {
            setMessage("Error al eliminar referencias asociadas");
            return false;
        }*/
    }
    
    private boolean deleteTaxonDescriptionRecordReference(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from TaxonDescriptionRecordReference ";
        hql += "where TaxonDescriptionRecordReference.taxonDescriptionRecord.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and TaxonDescriptionRecordReference.taxonDescriptionRecord.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + sequence;        
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }
    
    private boolean deleteTaxonDescriptionRecord(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from TaxonDescriptionRecord ";
        hql += "where TaxonDescriptionRecord.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and TaxonDescriptionRecordReference.taxonDescriptionRecord.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + sequence;        
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }
    
    private boolean deleteStageTransitionDate(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from StageTransitionDate ";
        hql += "where StageTransitionDate.stageTransitionPK.taxonId = " + taxonId + " and StageTransitionDate.stageTransitionPK.taxonDescriptionSequence = " + sequence;
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }
    
    private boolean deleteTaxonDescriptionAudience(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from TaxonDescriptionAudience ";
        hql += "where TaxonDescriptionAudience.taxonDescriptionAudiencePK.taxonId = " + taxonId + " and TaxonDescriptionAudience.taxonDescriptionAudiencePK.taxonDescriptionSequence = " + sequence;
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }
    
    private boolean deleteTaxonDescriptionInstitution(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from TaxonDescriptionInstitution ";
        hql += "where TaxonDescriptionInstitution.taxonDescriptionInstitutionPK.taxonId = " + taxonId + " and TaxonDescriptionInstitution.taxonDescriptionInstitutionPK.taxonDescriptionSequence = " + sequence;
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }
    
    private boolean deleteTaxonDescriptionPersonProfile(Long taxonId, Long sequence) {
        String hql;
        hql = "delete from TaxonDescriptionPersonProfile ";
        hql += "where TaxonDescriptionPersonProfile.taxonDescriptionPersonProfilePK.taxonId = " + taxonId + " and TaxonDescriptionPersonProfile.taxonDescriptionPersonProfilePK.taxonDescriptionSequence = " + sequence;
        Query q = em.createQuery(hql);
        int rows = q.executeUpdate();
        return true;
    }

    public TaxonDescription getTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        TaxonDescription tTaxonDescription;
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescription as o where o.taxonDescriptionPK.taxonId = " + taxonId + " and o.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence); 
            try {
                tTaxonDescription = (TaxonDescription)q.getSingleResult();
                this.setTaxonDescription(tTaxonDescription);
            } catch (NoResultException noResultEx) {
                this.setMessage("No se encontraron descripciones para los valores dados.");
                return null;
            } catch (NonUniqueResultException noUniqueResultEx) {
                this.setMessage("La consulta produjo más de un resultado");
                return null;
            } catch (IllegalStateException stateException) {
                this.setMessage("Se produjo un llamado a INSERT o UPDATE");
                return null;
            } finally {
                
            }
        } catch (IllegalStateException stateEx) {
            this.setMessage("Se perdio la comunicacion con la base de datos.");
            return null;
        } catch (IllegalArgumentException argumentEx) {
            this.setMessage("Consulta invalida");
        }        
        //this.setTaxonDescriptionRecordList(this.getTaxonDescriptionRecord());
        return this.getTaxonDescription();
    }
    

    public List getTaxonDescriptions(Long taxonId) {
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescription as o where o.taxonDescriptionPk.taxonId = " + taxonId); 
            try {
                this.setTaxonDescriptionList(q.getResultList());
            } catch (NoResultException noResultEx) {
                this.setMessage("No se encontraron descripciones para los valores dados.");
                return null;
            } catch (NonUniqueResultException noUniqueResultEx) {
                this.setMessage("La consulta produjo m�s de un resultado");
                return null;
            } catch (IllegalStateException stateException) {
                this.setMessage("Se produjo un llamado a INSERT o UPDATE");
                return null;
            } finally {
                
            }
        } catch (IllegalStateException stateEx) {
            this.setMessage("Se perdio la comunicacion con la base de datos.");
            return null;
        } catch (IllegalArgumentException argumentEx) {
            this.setMessage("Consulta invalida");
        }
        return this.getTaxonDescriptionList();
    }
    
    private List getTaxonDescriptionRecord() {
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescriptionRecord as o where o.taxonId = " + this.getTaxonDescription().getTaxonDescriptionPK().getTaxonId() + " and o.taxonDescriptionSequence = " + this.getTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence()); 
            try {
                this.setTaxonDescriptionRecordList(q.getResultList());
            } catch (NoResultException noResultEx) {
                this.setMessage("No se encontraron descripciones para los valores dados.");
                return null;
            } catch (NonUniqueResultException noUniqueResultEx) {
                this.setMessage("La consulta produjo m�s de un resultado");
                return null;
            } catch (IllegalStateException stateException) {
                this.setMessage("Se produjo un llamado a INSERT o UPDATE");
                return null;
            } finally {
                
            }
        } catch (IllegalStateException stateEx) {
            this.setMessage("Se perdio la comunicacion con la base de datos.");
            return null;
        } catch (IllegalArgumentException argumentEx) {
            this.setMessage("Consulta invalida");
        }
        return this.getTaxonDescriptionList();
    }
    
    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonDescription as o");
        this.taxonDescriptionList = (List)q.getResultList();
        return this.taxonDescriptionList;
    }
    
    public TaxonDescription find(Long taxonId, Long taxonDescriptionSequence){
        String queryString = "SELECT o from TaxonDescription as o " +
                "where o.taxonDescriptionPK.taxonId = " + taxonId + 
                " and o.taxonDescriptionPK.taxonDescriptionSequence = " +
                taxonDescriptionSequence;
        Query q = em.createQuery(queryString);
        try {
            this.setTaxonDescription((TaxonDescription) q.getSingleResult());
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron registros para el Id dado");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo mas de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return this.getTaxonDescription();
    }
    
    private boolean isTaxonDescriptionUnique() {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        sql = "SELECT o FROM TaxonDescription as o ";
        sql += "where o.taxonDescriptionPK.taxonId = " + this.getTaxonDescription().getTaxonDescriptionPK().getTaxonId();
        sql += " and o.taxonDescriptionPK.taxonDescriptionSequence = " + this.getTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence();
        if (em.createQuery(sql).getResultList().size() > 0) {
            this.setMessage("Ya existe un registro para esta especie con el mismo número de registro / edición");
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean canDeleteTaxonDescription() {
        return true;
    }
    
    private boolean isTaxonDescriptionNull(TaxonDescription taxonDescription) {
        boolean isNull = false;
        String msg = "";
        if (taxonDescription.getTaxonDescriptionPK() == null){
            isNull = true;
            msg = "Los siguientes campos no pueden ser nulos: Taxon y version.";
            setMessage(msg);
        }
        return isNull;
    }
    
    private boolean isTaxonDescriptionUnique(TaxonDescription taxonDescription) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        //tmpName = profile.getName();
        sql = "SELECT object(o) FROM TaxonDescription as o ";
        sql = sql + "where o.taxonDescriptionPK.taxonId = " + taxonDescription.getTaxonDescriptionPK().getTaxonId() + " and ";
        sql = sql + "o.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();

        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    public Long[] getSelectedAudience(TaxonDescriptionPK pk) {
        Long[] selectedArray = new Long[]{};
        String hql;
        
        hql = "Select object(o) from TaxonDescriptionAudience as o ";
        hql += "where o.taxonDescriptionAudiencePK.taxonId = " + pk.getTaxonId() + "and ";
        hql += "o.taxonDescriptionAudiencePK.taxonDescriptionSequence = " + pk.getTaxonDescriptionSequence();
        List<TaxonDescriptionAudience> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionAudience tmp: tList) {
                selectedArray[i] = tmp.getTaxonDescriptionAudiencePK().getAudienceId();
                i++;
            }
        }
        return selectedArray;
    }
    
    private List query(String hql) {
        Query q;
        q = em.createQuery(hql);
        List tList = q.getResultList();
        return tList;
    }
    
    private void updateAudienceList(Long[] audienceArray) {
        TaxonDescriptionAudience taxonDescriptionAudience;
        Audience audience;
        
        System.out.println("Procediendo a crear audiencias");
        
        if (audienceArray.length > 0) {
            for (Long audienceId: audienceArray) {
                audience = (Audience)em.find(Audience.class,audienceId);
                TaxonDescriptionAudiencePK pk = new TaxonDescriptionAudiencePK();
                
                pk.setTaxonId(taxonDescription.getTaxonDescriptionPK().getTaxonId());
                pk.setTaxonDescriptionSequence(taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence());
                pk.setAudienceId(audience.getId());
                
                taxonDescriptionAudience = new TaxonDescriptionAudience();
                
                taxonDescriptionAudience.setTaxonDescriptionAudiencePK(pk);                
                taxonDescriptionAudience.setCreatedBy(this.taxonDescription.getCreatedBy());
                taxonDescriptionAudience.setLastModificationBy(this.taxonDescription.getLastModificationBy());
                System.out.println(taxonDescriptionAudience.getTaxonDescriptionAudiencePK().getAudienceId() + " " + taxonDescriptionAudience.getTaxonDescriptionAudiencePK().getTaxonDescriptionSequence()+ " " + taxonDescriptionAudience.getTaxonDescriptionAudiencePK().getTaxonId() + " " + taxonDescriptionAudience.getCreatedBy() + " " + taxonDescriptionAudience.getLastModificationBy());
                try {
                    em.persist(taxonDescriptionAudience);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexión con la base de datos fue cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad válida.");
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
                }                        
            }
        }
    }
    
    private void updateAuthorList(Long[] authorArray) {
        TaxonDescriptionPersonProfile taxonDescriptionPersonProfile;
        PersonProfile personProfile;
        Long i = 1L;
        
        System.out.println("Procediendo a crear autores");
        
        if (authorArray.length > 0) {
            for (Long authorId: authorArray) {
                
                TaxonDescriptionPersonProfilePK pk2 = new TaxonDescriptionPersonProfilePK();
                pk2.setAuthorPersonId(authorId);
                pk2.setAuthorProfileId(14L);
                pk2.setTaxonDescriptionSequence(this.taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence());
                pk2.setTaxonId(this.taxonDescription.getTaxonDescriptionPK().getTaxonId());
                
                taxonDescriptionPersonProfile = new TaxonDescriptionPersonProfile();
                taxonDescriptionPersonProfile.setTaxonDescriptionPersonProfilePK(pk2);
                taxonDescriptionPersonProfile.setSequence(i);
                taxonDescriptionPersonProfile.setCreatedBy(this.taxonDescription.getCreatedBy());
                taxonDescriptionPersonProfile.setLastModificationBy(this.taxonDescription.getLastModificationBy());
                
                System.out.println(
                        "Secuencia: " + taxonDescriptionPersonProfile.getSequence() + " " +
                        "PersonId: " + taxonDescriptionPersonProfile.getTaxonDescriptionPersonProfilePK().getAuthorPersonId() + " " +
                        "PerfilId: " + taxonDescriptionPersonProfile.getTaxonDescriptionPersonProfilePK().getAuthorProfileId() + " " +
                        "TaxonDescriptionSequence: " + taxonDescriptionPersonProfile.getTaxonDescriptionPersonProfilePK().getTaxonDescriptionSequence() + " " +
                        "TaxonId: " + taxonDescriptionPersonProfile.getTaxonDescriptionPersonProfilePK().getTaxonId() + " " +
                        "CreatedBy: " + taxonDescriptionPersonProfile.getCreatedBy() + " " +
                        "LastModificationBy: " + taxonDescriptionPersonProfile.getLastModificationBy());
                
                i++;
                try {
                    em.persist(taxonDescriptionPersonProfile);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexión con la base de datos fue cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad válida.");
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
                }                        
            }
        }
    }
    
    private void updateInstitutionList(Long[] institutionArray) {
        TaxonDescriptionInstitution taxonDescriptionInstitution;
        Institution institution;
        Long i = 1L;
        if (institutionArray.length > 0) {
            for (Long institutionId: institutionArray) {
                institution = (Institution)em.find(Institution.class,institutionId);
                taxonDescriptionInstitution = 
                        new TaxonDescriptionInstitution(
                        taxonDescription.getTaxonDescriptionPK().getTaxonId(),
                        taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(),
                        institution.getId(),
                        i);
                taxonDescriptionInstitution.setCreatedBy(this.taxonDescription.getCreatedBy());
                taxonDescriptionInstitution.setLastModificationBy(this.taxonDescription.getLastModificationBy());
                i++;
                try {
                    em.persist(taxonDescriptionInstitution);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexión con la base de datos fue cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad válida.");
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
                }                        
            }
        }
    }
    
    private boolean clearList() {
        deleteAudienceList();
        deleteAuthorList();
        deleteInstitutionList();
        return true;
    }
    
    private void deleteAudienceList() {
        Query q;
        q = em.createQuery("delete from TaxonDescriptionAudience where taxonDescriptionAudiencePK.taxonId = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonId() + " and taxonDescriptionAudiencePK.taxonDescriptionSequence = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence());
        q.executeUpdate();
    }
    
    private void deleteAuthorList() {
        Query q;
        q = em.createQuery("delete from TaxonDescriptionPersonProfile where taxonDescriptionPersonProfilePK.taxonId = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonId() + " and taxonDescriptionPersonProfilePK.taxonDescriptionSequence = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence());
        q.executeUpdate();
    }    
    
    private void deleteInstitutionList() {
        Query q;
        q = em.createQuery("delete from TaxonDescriptionInstitution where taxonDescriptionInstitutionPK.taxonId = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonId() + " and taxonDescriptionInstitutionPK.taxonDescriptionSequence = " + this.taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence());
        q.executeUpdate();
    }
}
