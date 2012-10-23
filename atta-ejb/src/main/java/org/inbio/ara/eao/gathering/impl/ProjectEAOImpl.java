/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import java.util.List;
import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.Project;

/**
 *
 * @author esmata
 */
@Stateless
public class ProjectEAOImpl extends BaseEAOImpl<Project,Long> implements ProjectEAOLocal {

    /**
     * To get all the projets
     * @return
     */
    public List<Project> findAllProjects(){
        return this.findAll(Project.class);
    }
    
     public List<Long> findByDescription(String description){
         String lowerDescription = description.toLowerCase();
        String sql = "Select p.projectId ";
              sql += "from Project p ";
              sql += "where lower(p.description) like '%"+lowerDescription+"%'"+
                      " order by p.description";
        Query q = em.createQuery(sql);
	//q.setParameter("lowerDescription", lowerDescription);
        
        return (List<Long>)q.getResultList();
    }
     
    public List<Long> findByProjectManager(String name){
         String lowerName = name.toLowerCase();
        String sql = "Select p.projectId ";
              sql += "from Project p ";
              sql += "where lower(p.projectManagerName) like '%"+lowerName+"%'"+
                      " order by p.description";
        Query q = em.createQuery(sql);
	//q.setParameter("lowerName", lowerName);
        
        return (List<Long>)q.getResultList();
    }
    
       public List<Long> findByInitialDate(String date){
         List<Long> result = null;
      
         String sql = "select p.project_id from atta.project p where to_char(initial_date, 'DD-MM-YYYY') like '%"+date+"%'";
     
        
         //Connection connPostgis;
        try
        {
                          
            Query comparisonDateQuery = em.createNativeQuery(sql);
            result = (List<Long>)comparisonDateQuery.getResultList();            
            
        }
        catch(Exception e)
        {
            System.out.println("Error al crear la conexion;");
            e.printStackTrace();            
        }
        
        //return (List<Long>)q.getResultList();
        return result;
    }
       
        public List<Long> findByFinalDate(String date){
         
      
            List<Long> result = null;
       
         String sql = "select p.project_id from atta.project p where to_char(initial_date, 'DD-MM-YYYY') like '%"+date+"%'";
               
         //Connection connPostgis;
        try
        {
         
            Query comparisonDateQuery = em.createNativeQuery(sql);
            result = (List<Long>)comparisonDateQuery.getResultList();            
            
        }
        catch(Exception e)
        {
            System.out.println("Error al crear la conexion;");
            e.printStackTrace();            
        }
                
        return result;
    }
    
    

}
