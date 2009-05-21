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
 * PredefinedValuesBean.java
 *
 * Created on July 26, 2007, 10:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.reference.Reference;
import org.inbio.ara.persistence.reference.ReferenceType;
import org.inbio.ara.persistence.species.GeographicCatalogue;
import org.inbio.ara.persistence.species.GeographicEntity;
import org.inbio.ara.persistence.species.InteractionType;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.util.Country;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class PredefinedValuesBean implements PredefinedValuesRemote, PredefinedValuesLocal{

    @EJB
    private SelectionListManagerRemote selectionListManagerBean;
    
    
    @PersistenceContext
    private EntityManager em;
    
    public List getListBoxValues(String className, String idValue, String showName){
        return em.createQuery("select obj."+idValue+", obj."+showName+" from "+className+" as obj").getResultList();
    }
    
    public List getListBoxValuesSQL(String tableName, String idValue, String showName){
        System.out.println("select "+tableName+"."+idValue+", "+tableName+"."+showName+" from "+tableName);
        return em.createNativeQuery("select "+tableName+"."+idValue+", "+tableName+"."+showName+" from "+tableName).getResultList();
        //return em.createQuery("select obj."+idValue+", obj."+showName+" from "+className+" as obj").getResultList();
    }
    /* Mi version del metodo anteriro.... muy parecido: No lo modifique porque
     * no se exactamente donde se usa (o si alguien lo usa)
     */
    
    /*
    public HashMap hashMapListBox(String tableName, String idValue, String showName){
        HashMap options = new HashMap();
        String hql;
        hql = "from Audience";
        //List lista = em.createNativeQuery("select "+tableName+"."+idValue+", "+tableName+"."+showName+" from "+tableName).getResultList();
        //List<SpeciesRecordStage> lista = em.createQuery(hql).getResultList();
        List<Audience> lista = em.createQuery(hql).getResultList();
        if(lista != null){
            System.out.println("*****************************");
            //for(SpeciesRecordStage o : lista){
            for(Audience o : lista){
                String value = o.getId().toString();
                String label = o.getName();
                System.out.println("--------------------------");
                options.put(label, value);
            }
            System.out.println("++++++++++++++++++++++++++++");
        }else{
            System.out.println("Lista nula");
        }
        
        return options;
    }*/
    
    /*
    public HashMap hashMapListBox(String className, String idValue, String showName){
        HashMap options = new HashMap();
        String hql;
        String entityName;
        int index;
        
        
        //hql = "select " + idValue + " as id, " + showName + " as name from " + className + " order by name";
        hql = "select id, name from InteractionType order by name";
        System.out.println(hql);
        try {
            
            /*Query q = em.createNativeQuery(hql, DummyEntity.class);
            item = (Item) q.getSingleResult(); //from a class columns names match the mapping*/
            
            //List<DummyEntity> lista = em.createQuery(hql).getResultList();
    /*
            List<DummyEntity> lista = em.createNativeQuery(hql,DummyEntity.class).getResultList();
            
            if (lista != null) {
                for (DummyEntity o: lista) {
                    String value = o.getId();
                    String label = o.getName();
                    options.put(label,value);
                }
            } else {
                System.out.println("Lista nula");
            }
            
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return options;
        }
        return options;
    }*/
            
    public HashMap hashMapListBox(String className, String idValue, String showName){
        HashMap options = new HashMap();
        String hql;
        
        if (className.equals("ReferenceType")) {
            hql = "from ReferenceType order by name";
            List<ReferenceType> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(ReferenceType o : lista){
                    String value = o.getId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        
        if (className.equals("Reference")) {
            hql = "from Reference order by title";
            List<Reference> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(Reference o : lista){
                    String value = o.getId().toString();
                    String label = o.getTitle();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        
        if (className.equals("InteractionType")) {
            hql = "from InteractionType order by name";
            List<InteractionType> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(InteractionType o : lista){
                    String value = o.getId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        
        if (className.equals("GeographicCatalogue")) {
            hql = "from GeographicCatalogue order by name";
            List<GeographicCatalogue> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(GeographicCatalogue o : lista){
                    String value = o.getId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        
        if (className.equals("GeographicEntity")) {
            hql = "from GeographicEntity order by name";
            List<GeographicEntity> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(GeographicEntity o : lista){
                    String value = o.getId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        
        if (className.equals("Country")) {
            hql = "from Country order by name";
            List<Country> lista = em.createQuery(hql).getResultList();
            if(lista != null){
                for(Country o : lista){
                    String value = o.getId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else{
                System.out.println("Lista nula");
            }
        }
        

        
        return options;
    }
    
   /*
    
    public HashMap getHashMapListBox(String listBox) {
        
    }
    
    private HashMap createHashMap(Class entityClass, String entityName) {
        
    }
    */
    public List getMainFields(String key, String tableName, String showName){
        return em.createNativeQuery("select "+tableName+"."+showName+" from "+tableName+" where "+tableName+"."+showName+" like '"+key+"%'").getResultList();
    }
    
    /**
     * Busca los elementos que pertenecen a una categoria seleccionada por el 
     * usuario en el arbol.
     * @param categoryId identificador de la categoria que se utilizara para
     * buscar los elementos que pertenecen a ella
     */
    public List<TaxonDescriptionElement> getElements(int categoryId){
        String hql;
        hql = "Select o from TaxonDescriptionElement o ";
        hql += "where o.taxonDescriptionCategory.id = " + categoryId;
        hql += "order by o.sequence";
        return em.createQuery(hql).getResultList();
        //return em.createNativeQuery("select * from TAXON_DESCRIPTION_ELEMENT as tde where tde.TAXON_DESCRIPTION_CATEGORY_ID = "+ categoryId + " order by tde.sequence").getResultList();
        //return em.createQuery("Select o from TaxonDescriptionElement o where o.tax");
    }
    
    public String getFieldContent(Long Id, String tableName, String keyField, 
                                        String tableField){
        String hql;
        List tmp;
        Vector tupla;
        hql = "Select o." + tableField + " from " + tableName + " o ";
        hql += "where o." + keyField + " = " + Id;
        
        tmp = em.createQuery(hql).getResultList();
        return (String) tmp.get(0);
        //tupla = (Vector)tmp.get(0);
        //return tupla.get(0).toString();
        //return em.createNativeQuery("select " + tableName+"."+tableField+" from "+tableName+" where "+tableName+"."+keyField+"="+Id).getResultList();
    }
    
    public int getContentNumber(Long taxonId, Long taxonDescriptionElementId){
        String hql;
        String temp;
        TaxonDescription td;
        
        hql = "Select o from TaxonDescription o ";
        hql += "where o.taxon.id = " + taxonId + " and ";
        hql += "o.taxonDescriptionElement.id = " + taxonDescriptionElementId;
        
        td = (TaxonDescription)em.createQuery(hql).getSingleResult();
        //temp = td.getContentsNumeric().toString();
        temp = "";
        
        return Integer.parseInt(temp);
        //List lista = em.createNativeQuery("select taxon_description.contents_numeric from taxon_description where taxon_description.taxon_id="+taxonId+" AND taxon_description.taxon_description_element_id="+taxonDescriptionElementId).getResultList();
        //Un unico registro debe ser recuperado, por lo tanto solo hay 1 vector
        //Vector vector = (Vector) lista.get(0);
        //return Integer.parseInt(vector.get(0).toString());
    }
    
    public String getContentText(Long taxonId, Long taxonDescriptionElementId){     
        String hql;
        String temp;
        TaxonDescription td;
        
        hql = "Select o from TaxonDescription o ";
        hql += "where o.taxon.id = " + taxonId + " and ";
        hql += "o.taxonDescriptionElement.id = " + taxonDescriptionElementId;
        
        td = (TaxonDescription)em.createQuery(hql).getSingleResult();
        
        //return td.getContentsText();
        return "";
        
        //List lista = em.createNativeQuery("select taxon_description.contents_text from taxon_description where taxon_id="+taxonId+" and taxon_description_element_id="+taxonDescriptionElementId).getResultList();
        //Un unico registro debe ser recuperado, por lo tanto solo hay 1 vector
        //Vector vector = (Vector) lista.get(0);
        //return vector.get(0).toString();
    }
}
