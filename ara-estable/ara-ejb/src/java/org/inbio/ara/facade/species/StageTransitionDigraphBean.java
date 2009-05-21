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
 * StageTransitionDigraphBean.java
 *
 * Created on 1 de abril de 2008, 02:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.species.StageTransitionDigraph;
import org.inbio.ara.persistence.species.StageTransitionDigraphPK;

/**
 *
 * @author herson
 */
@Stateless
public class StageTransitionDigraphBean implements StageTransitionDigraphLocal, StageTransitionDigraphRemote {
    
    @PersistenceContext
    private EntityManager em;
    private StageTransitionDigraph stageTransitionDigraph;
    private List stageTransitionDigraphList;
    private String message;
    
    /** Creates a new instance of StageTransitionDigraphBean */
    public StageTransitionDigraphBean() {
        setMessage("");
    }
    
    private boolean create(StageTransitionDigraph stageTransitionDigraph) {
        this.stageTransitionDigraph = stageTransitionDigraph;
        return persist();
    }
    
    private boolean persist() {
        try {
            em.persist(this.stageTransitionDigraph);
            return true;
        } catch (Exception e) {
            setMessage(e.getLocalizedMessage());
            setMessage(getMessage() + " El registro no se creo.");
        }
        return false;
    }
    
    /**
     *
     * @param long id del stage del cual se desea buscar las relaciones
     * @return List<StageTransitionDigraph> de todas aquellas relaciones que
     *  tiene el stage en el digrafo DESDE EL.
     */
    private List findAllAbout(long id){
        String jpql = "from StageTransitionDigraph as o where " +
                "o.stageTransitionDigraphPK.speciesRecordStageFromId = " + id;
        return em.createQuery(jpql).getResultList();
    }
    /*
    private boolean exist(StageTransitionDigraphPK STDPK){
        String jpql = "from StageTransitionDigraph as o where " +
                "o.stageTransitionDigraphPK.speciesRecordStageFromId = " +
                STDPK.getSpeciesRecordStageFromId() +
                " and " + "o.stageTransitionDigraphPK.speciesRecordStageToId = " +
                STDPK.getSpeciesRecordStageToId();
        if(em.createQuery(jpql).getSingleResult() != null)
            return true;
        return false;
    }*/
    
    /**
     * @param id Estado
     * @return List Estados desde (from) los que puedo ir a "Estado"
     */
    public List getFromList(Long id){
        String jpql = "from StageTransitionDigraph as o where " +
                      "o.stageTransitionDigraphPK.speciesRecordStageToId = " +
                      id;
        this.stageTransitionDigraphList = em.createQuery(jpql).getResultList();
        return this.stageTransitionDigraphList;
    }
    
    /**
     * @param id Estado
     * @return List Estados a los que puedo ir (to) desde "Estado"
     */
    public List getToList(Long id){
        String jpql = "from StageTransitionDigraph as o where " +
                      "o.stageTransitionDigraphPK.speciesRecordStageFromId = " +
                      id;
        this.stageTransitionDigraphList = em.createQuery(jpql).getResultList();
        return this.stageTransitionDigraphList;
    }
    
    private boolean remove(StageTransitionDigraph STD){
        try {
            stageTransitionDigraph = STD;
            em.remove(stageTransitionDigraph);
            return true;
        } catch(Exception e) {
            setMessage(e.getMessage());
            setMessage(getMessage() + " El registro no se borro.");
        }
        return false;
    }
    
    public void save(List<StageTransitionDigraph> newList, long selected){
        ArrayList oldList = new ArrayList();
        oldList = (ArrayList) findAllAbout(selected);
        System.out.println("Entro al save con " + oldList.size() + " " +newList.size());
        mergeLists(oldList, newList);
        for (StageTransitionDigraph elem : newList) {
            this.create(elem);
        }
        for (Object elem : oldList) {
            StageTransitionDigraph std = (StageTransitionDigraph)elem;
            this.remove(std);
        }
        System.out.println("Salio del save con " + oldList.size() + " " +newList.size());
    }
    
    private void mergeLists(ArrayList oldList, List<StageTransitionDigraph> newList){
        System.out.println("Entro al merge con " + oldList.size() + " " +newList.size());
        if(oldList.isEmpty() || newList.isEmpty())
            return;
        else {
            for (int i = 0; i < oldList.size(); i++) {
                System.out.println("i="+i);
                StageTransitionDigraph STD = (StageTransitionDigraph)oldList.get(i);

                for (int j = 0; j < newList.size(); j++) {
                    System.out.println("j="+j);
                    StageTransitionDigraph std = (StageTransitionDigraph) newList.get(j);
                    //Long fromSTD = STD.getStageTransitionDigraphPK().getSpeciesRecordStageFromId();
                    Long toSTD = STD.getStageTransitionDigraphPK().getSpeciesRecordStageToId();
                    //Long fromstd = std.getStageTransitionDigraphPK().getSpeciesRecordStageFromId();
                    Long tostd = std.getStageTransitionDigraphPK().getSpeciesRecordStageToId();
                    //System.out.println("fromSTD="+fromSTD+" fromstd="+fromstd);
                    System.out.println("toSTD="+toSTD+" tostd="+tostd);
                    //if(fromSTD.intValue() == fromstd.intValue() && 
                    if (toSTD.intValue() == tostd.intValue()) {
                        System.out.println("Coincidencia");
                        if(oldList.remove(STD)){
                            System.out.println("1Si borre");
                            i--;
                        }
                        else
                            System.out.println("1NO borre :(");
                        if(newList.remove(std)){
                            System.out.println("2Si borre");
                            j--;
                        }
                        else
                            System.out.println("2NO borre :(");
                    }
                }
            }            
            System.out.println("Salio del merge con " + oldList.size() + " " +newList.size());
        }
    }
    
    public String getMessage() {
        return message;
    }
    
    private void setMessage(String message) {
        this.message = message;
    }
}
