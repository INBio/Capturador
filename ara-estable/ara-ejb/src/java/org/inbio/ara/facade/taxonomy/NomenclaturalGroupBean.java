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
 * NomenclaturalGroupBean.java
 *
 * Created on June 28, 2008, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import org.inbio.ara.eao.NomenclaturalGroupRegionLocalEAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.eao.TaxonNomenclaturalGroupLocalEAO;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegion;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegionPK;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroupPK;

/**
 *
 * @author roaguilar
 */
@Stateless
public class NomenclaturalGroupBean implements NomenclaturalGroupRemote, NomenclaturalGroupLocal {


    @EJB
    private TaxonNomenclaturalGroupLocalEAO taxonNomenclaturalGroupEAO;

    @EJB
    private NomenclaturalGroupRegionLocalEAO nomenclaturalGroupRegionEAO;

    @PersistenceContext
    private EntityManager em;
    private String message;
    
    /** Creates a new instance of NomenclaturalGroupBean */
    public NomenclaturalGroupBean() {
    }

    public List getNomenclaturalGroup() {
        Query q;
        try {
            q = em.createQuery("Select object(o) from NomenclaturalGroup as o order by o.name desc");
            return q.getResultList();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean persist(NomenclaturalGroup nomenclaturalGroup, Long[] taxonArray, Long[] regionArray) {
        boolean persisted = false;
        if (!isNull(nomenclaturalGroup)){
            if (this.isUnique(nomenclaturalGroup)) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transaccion
                    // Primero las obligatorias
                    nomenclaturalGroup.setCollection(em.find(Collection.class, nomenclaturalGroup.getCollection().getId()));
					if(nomenclaturalGroup.getPerson() != null){
						nomenclaturalGroup.setPerson(em.find(Person.class,nomenclaturalGroup.getPerson().getId()));
					}else{
						nomenclaturalGroup.setPerson(null);
					}

                    em.persist(nomenclaturalGroup);
                                        
                    // Asociar taxones
                    if (taxonArray!= null) {
                        if (taxonArray.length > 0 ) {
                            for (int i =0; i< taxonArray.length; i++) {
                                TaxonNomenclaturalGroupPK pk = new TaxonNomenclaturalGroupPK();
                                pk.setNomenclaturalGroupId(nomenclaturalGroup.getId());
                                pk.setTaxon_id(taxonArray[i]);
                                
                                TaxonNomenclaturalGroup obj = new TaxonNomenclaturalGroup();
                                obj.setTaxonNomenclaturalGroupPK(pk);
                                obj.setSequence(i+1L);
                                obj.setTaxonomicalTimeStamp(new Date());
                                obj.setCreatedBy(nomenclaturalGroup.getCreatedBy());
                                obj.setLastModificationBy(nomenclaturalGroup.getLastModificationBy());
                                
                                em.persist(obj);
                            }
                        }                            
                    }
                    
                    // Asociar regiones
                    if (regionArray!= null) {
                        if (regionArray.length > 0 ) {
                            for (int i =0; i< regionArray.length; i++) {
                                NomenclaturalGroupRegionPK pk = new NomenclaturalGroupRegionPK();
                                pk.setNomenclaturalGroupId(nomenclaturalGroup.getId());
                                pk.setRegionId(regionArray[i]);
                                
                                NomenclaturalGroupRegion obj = new NomenclaturalGroupRegion();
                                obj.setnomenclaturalGroupRegionPK(pk);
                                obj.setSequence(i+1L);
                                obj.setCreatedBy(nomenclaturalGroup.getCreatedBy());
                                obj.setLastModificationBy(nomenclaturalGroup.getLastModificationBy());
                                
                                em.persist(obj);
                            }
                        }                            
                    }
                    persisted = true;
                } catch(EntityExistsException ex0) {
                    this.setMessage(ex0.getMessage());
                    return false;
                } catch(IllegalStateException ex1) {
                    this.setMessage(ex1.getMessage());
                    return false;
                } catch (IllegalArgumentException ex2) {
                    this.setMessage(ex2.getMessage());
                    return false;
                } catch (TransactionRequiredException ex3) {
                    this.setMessage(ex3.getMessage());
                    return false;
                }
            } else {
                setMessage("La recoleccion ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return persisted;
    }
    
    public Long[] getTaxonArray(Long id) {
        Long[] taxonArray = new Long[]{};
        String sql;
        Query q;
        
        sql = "select taxon_id from ara.taxon_nomenclatural_group where nomenclatural_group_id = " + id;
        
        q = em.createNativeQuery(sql);
        List taxonList = q.getResultList();

        if (taxonList.size() > 0) {
            taxonArray = new Long[taxonList.size()];
            for (int i = 0; i < taxonList.size(); i++) {
                String tmp = taxonList.get(i).toString();
                taxonArray[i] = Long.parseLong(tmp);
            }

        }
        return taxonArray;
    }
    
    public Long[] getRegionArray(Long id) {
        Long[] regionArray = new Long[]{};
        String sql;
        Query q;
        
        sql = "select region_id from ara.nomenclatural_group_region where nomenclatural_group_id = " + id;
        
        q = em.createNativeQuery(sql);
        List regionList = q.getResultList();

        if (regionList.size() > 0) {
            regionArray = new Long[regionList.size()];
            for (int i = 0; i < regionList.size(); i++) {
                String tmp = regionList.get(i).toString();
                regionArray[i] = Long.parseLong(tmp);
            }

        }
        return regionArray;
    }
    
    public boolean create (NomenclaturalGroup nomenclaturalGroup, Long[] taxonArray, Long[] regionArray) {
        return this.persist(nomenclaturalGroup,taxonArray,regionArray);
    }
    
    public boolean update(NomenclaturalGroup nomenclaturalGroup, Long[] taxonArray, Long[] regionArray) {
        boolean updated = false;
       if (!isNull(nomenclaturalGroup)){
            try {
                // Incorporar las entidades auxiliares al contexto de la transaccion
                // Primero las obligatorias
                nomenclaturalGroup.setCollection(em.find(Collection.class, nomenclaturalGroup.getCollection().getId()));
				if (nomenclaturalGroup.getPerson() != null){
					nomenclaturalGroup.setPerson(em.find(Person.class,nomenclaturalGroup.getPerson().getId()));
				}else{
					nomenclaturalGroup.setPerson(null);
				}
                
                em.merge(nomenclaturalGroup);
                updated = true;
                
                /* Eliminar los taxones asociados */
                //em.createNativeQuery("delete from ara.taxon_nomenclatural_group where nomenclatural_group_id = " + nomenclaturalGroup.getId()).executeUpdate();

                updateTaxonsByNomenclaturalGroup(nomenclaturalGroup.getId(), taxonArray, nomenclaturalGroup.getCreatedBy(), nomenclaturalGroup.getLastModificationBy());

                // Asociar los taxones
                /*
                if (taxonArray!= null) {
                    if (taxonArray.length > 0 ) {
                        for (int i =0; i< taxonArray.length; i++) {
                            TaxonNomenclaturalGroupPK pk = new TaxonNomenclaturalGroupPK();
                            pk.setNomenclaturalGroupId(nomenclaturalGroup.getId());
                            pk.setTaxon_id(taxonArray[i]);

                            TaxonNomenclaturalGroup obj = new TaxonNomenclaturalGroup();
                            obj.setTaxonNomenclaturalGroupPK(pk);
                            obj.setSequence(i+1L);
                            obj.setTaxonomicalTimeStamp(new Date());
                            obj.setCreatedBy(nomenclaturalGroup.getCreatedBy());
                            obj.setLastModificationBy(nomenclaturalGroup.getLastModificationBy());

                            em.persist(obj);
                        }
                    }                            
                }
                */

                /* Eliminar las regiones asociadas */
                //em.createNativeQuery("delete from ara.nomenclatural_group_region where nomenclatural_group_id = " + nomenclaturalGroup.getId()).executeUpdate();

                updateRegionsByNomenclaturalGroup(nomenclaturalGroup.getId(), regionArray, nomenclaturalGroup.getCreatedBy(), nomenclaturalGroup.getLastModificationBy());

                // Asociar regiones
                /*
                if (regionArray!= null) {
                    if (regionArray.length > 0 ) {
                        for (int i =0; i< regionArray.length; i++) {
                            NomenclaturalGroupRegionPK pk = new NomenclaturalGroupRegionPK();
                            pk.setNomenclaturalGroupId(nomenclaturalGroup.getId());
                            pk.setRegionId(regionArray[i]);

                            NomenclaturalGroupRegion obj = new NomenclaturalGroupRegion();
                            obj.setnomenclaturalGroupRegionPK(pk);
                            obj.setSequence(i+1L);
                            obj.setCreatedBy(nomenclaturalGroup.getCreatedBy());
                            obj.setLastModificationBy(nomenclaturalGroup.getLastModificationBy());

                            em.persist(obj);
                        }
                    }                            
                }
                */
            } catch(EntityExistsException ex0) {
                this.setMessage(ex0.getMessage());
                return false;
            } catch(IllegalStateException ex1) {
                this.setMessage(ex1.getMessage());
                return false;
            } catch (IllegalArgumentException ex2) {
                this.setMessage(ex2.getMessage());
                return false;
            } catch (TransactionRequiredException ex3) {
                this.setMessage(ex3.getMessage());
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }


    /**
     * Este metodo debe estar en la interfaz local
     *
     * @param nomenclaturalGroupId
     * @param taxonArray -> luego debe pasarse a un List<Long> para ser concordante con el resto de metodos
     */
    private void updateTaxonsByNomenclaturalGroup(Long nomenclaturalGroupId, Long[] taxonArray, String createdBy, String lastModificationBy){

        List<TaxonNomenclaturalGroup> oldTaxonNomenclaturalGroup = this.taxonNomenclaturalGroupEAO.getAllByNomenclaturalGroupId(nomenclaturalGroupId);
        List<Long> taxonIdsToBeDeleted = new ArrayList<Long>();
        List<Long> taxonIdsToBeAdded = new ArrayList<Long>();
        for(Long i : taxonArray){
            taxonIdsToBeAdded.add(i);
        }

        //elimina de la lista los que ya estan asociados
        for(TaxonNomenclaturalGroup old : oldTaxonNomenclaturalGroup){
            if(taxonIdsToBeAdded.contains(old.getTaxon().getTaxonId())){
                taxonIdsToBeAdded.remove(old.getTaxon().getTaxonId());
            } else {
                taxonIdsToBeDeleted.add(old.getTaxon().getTaxonId());
            }
        }

        //borrar los taxones antiguamente asociados y que ya no.
        for(Long taxonId : taxonIdsToBeDeleted){
            this.taxonNomenclaturalGroupEAO.deleteTaxonNomenclaturalGroup(taxonId, nomenclaturalGroupId);
        }

        //Inserta los nuevos taxones asociados
        for(Long taxonId : taxonIdsToBeAdded){
            this.taxonNomenclaturalGroupEAO.createTaxonNomenclaturalGroup(taxonId, nomenclaturalGroupId,createdBy, lastModificationBy);
        }
    }

   /**
     * Este metodo debe estar en la interfaz local
     *
     * @param nomenclaturalGroupId
     * @param regionArray -> luego debe pasarse a un List<Long> para ser concordante con el resto de metodos
     */
    private void updateRegionsByNomenclaturalGroup(Long nomenclaturalGroupId, Long[] regionArray, String createdBy, String lastModificationBy){

        List<NomenclaturalGroupRegion> oldNomenclaturalGroupRegion = this.nomenclaturalGroupRegionEAO.getAllByNomenclaturalGroupId(nomenclaturalGroupId);
        List<Long> regionsIdsToBeDeleted = new ArrayList<Long>();
        List<Long> regionsToBeAdded = new ArrayList<Long>();
        for(Long i : regionArray){
            regionsToBeAdded.add(i);
        }

        //elimina de la lista los que ya estan asociados
        for(NomenclaturalGroupRegion old : oldNomenclaturalGroupRegion){
            if(regionsIdsToBeDeleted.contains(old.getRegion().getId())){
                regionsToBeAdded.remove(old.getRegion().getId());
            } else {
                regionsIdsToBeDeleted.add(old.getRegion().getId());
            }
        }

        //borrar los taxones antiguamente asociados y que ya no.
        for(Long regionId : regionsIdsToBeDeleted){
            this.nomenclaturalGroupRegionEAO.deleteNomenclaturalGroupRegion(regionId, nomenclaturalGroupId);
        }

        //Inserta los nuevos taxones asociados
        for(Long regionId : regionsToBeAdded){
            this.nomenclaturalGroupRegionEAO.createNomenclaturalGroupRegion(regionId, nomenclaturalGroupId, createdBy, lastModificationBy);
        }
    }


    public boolean delete(Long nomenclaturalGroupId) {
        if (this.canDelete(nomenclaturalGroupId)) {
            try {
                NomenclaturalGroup nomenclaturalGroup = em.find(NomenclaturalGroup.class,nomenclaturalGroupId);
                if (nomenclaturalGroup != null) {
                    em.remove(nomenclaturalGroup);
                    return true;
                } else {
                    this.setMessage("Id de Grupo Nomenclatural inv�lido");
                    return false;
                }
            } catch (IllegalStateException ex1) {
                this.setMessage(ex1.getMessage());
                return false;
            } catch (IllegalArgumentException ex2) {
                this.setMessage(ex2.getMessage());
                return false;
            }
        } else {
            this.setMessage("El registro no puede ser borrado pues est� asociado al menos a un usuario del sistema.");
            return false;
        }
    }

    private boolean canDelete(Long nomenclaturalGroupId) {
        int count = Integer.parseInt(em.createNativeQuery("select count(nomenclatural_group_id) from ara.user_nomenclatural_group where nomenclatural_group_id = " + nomenclaturalGroupId).getSingleResult().toString());
        if (count > 0) {
            return false;
        }
        return true;
    }
    
    private boolean isNull(NomenclaturalGroup nomenclaturalGroup) {
        if (nomenclaturalGroup.getName()==null) {
            this.setMessage("Falta el nombre");
            return true;
        }
        if (nomenclaturalGroup.getCommonName() == null) {
            this.setMessage("Falta indicar si es un nombre com�n");
            return true;
        }
		/*
        if (nomenclaturalGroup.getPerson()==null) {
            this.setMessage("Falta el certificador del grupo nomenclatural");
            return true;
        }
		 */
        return false;
    }
    
    private boolean isUnique(NomenclaturalGroup nomenclaturalGroup) {
        if (nomenclaturalGroup.getId() == null) {
            int count = em.createQuery("Select object(o) from NomenclaturalGroup as o where o.name ='" + nomenclaturalGroup.getName() + "'").getResultList().size();
            if (count > 0) {
                this.setMessage("Ya existe un grupo nomenclatural con el mismo nombre.");
                return false;
            } else {
                return true;
            }
        } else {
            int count = em.createQuery("Select object(o) from NomenclaturalGroup as o where o.name ='" + nomenclaturalGroup.getName() + "'").getResultList().size();
            if (count > 0) {
                this.setMessage("Ya existe un grupo nomenclatural con el mismo nombre.");
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * @return the taxonNomenclaturalGroupEAO
     */
    public TaxonNomenclaturalGroupLocalEAO getTaxonNomenclaturalGroupEAO() {
        return taxonNomenclaturalGroupEAO;
    }

    /**
     * @param taxonNomenclaturalGroupEAO the taxonNomenclaturalGroupEAO to set
     */
    public void setTaxonNomenclaturalGroupEAO(TaxonNomenclaturalGroupLocalEAO taxonNomenclaturalGroupEAO) {
        this.taxonNomenclaturalGroupEAO = taxonNomenclaturalGroupEAO;
    }
}
