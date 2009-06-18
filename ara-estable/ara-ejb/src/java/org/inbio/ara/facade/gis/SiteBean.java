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
 * SiteBean.java
 *
 * Created on June 25, 2008, 11:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gis;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.manager.SiteManagerRemote;
import org.inbio.ara.persistence.gis.FeatureType;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;
import org.inbio.ara.persistence.gis.Projection;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.gis.SiteCoordinate;


/**
 *
 * @author roaguilar
 */
@Stateless
public class SiteBean implements SiteRemote, SiteLocal {
    
    @PersistenceContext
    private EntityManager em;
    private String message;

    /**
     * Managers
     */
    @EJB
    private SiteManagerRemote siteManager;
    
    /** Creates a new instance of SiteBean */
    public SiteBean() {
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public List getSite() {
        Query q;
        try {
            q = em.createQuery("Select object(o) from Site as o order by o.creationDate desc");
            return q.getResultList();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public boolean create(Site site, List<SiteCoordinate> coordinateList) {
        return persist(site, coordinateList);
    }

    public boolean create(Site site, List<SiteCoordinate> coordinateList,List<GeoreferencedSitePK> georeferencedSitesPKs){
        return persist(site, coordinateList,georeferencedSitesPKs);
    }
    
    @Override
    public boolean delete(Long siteId) {
        //TODO: drop cascade de identificaciones al borrar sitios
        if (this.canDeleteSite(siteId)) {
            try {
                Site site = em.find(Site.class,siteId);
                if (site != null) {
                    //borra lo que haya en georeferencedSite
                    siteManager.deleteForSite(site.getId());
                    em.remove(site);
                    return true;
                } else {
                    this.setMessage("Id de sitio inválido");
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
            this.setMessage("El sitio no puede ser borrado pues está siendo referenciado en " + this.getGatheringObservationCountBySite(siteId) + " recolecciones/observaciones.");
            return false;
        }
    }
   
    private boolean persist(Site site, List<SiteCoordinate> coordinateList) {
        boolean persisted = false;
        if (!isSiteNull(site)){
            if (this.isSiteUnique(site)) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transaccion
                    // Primero las obligatorias
                    site.setBaseProjection(em.find(Projection.class,site.getBaseProjection().getId()));
                    site.setFeatureType(em.find(FeatureType.class,site.getFeatureType().getId()));
                    site.setSiteCalculationMethod(em.find(SiteCalculationMethod.class,site.getSiteCalculationMethod().getId()));
                    site.setOriginalProjection(em.find(Projection.class,site.getOriginalProjection().getId()));
                    em.persist(site);

                    // Crear las coordenadas
                    if (coordinateList != null) {
                        if (coordinateList.size() > 0) {
                            for (int i=0; i<coordinateList.size(); i++) {
                                coordinateList.get(i).setSite(site);
                                coordinateList.get(i).setSequence(i+1);
                                coordinateList.get(i).setCreatedBy(site.getCreatedBy());
                                coordinateList.get(i).setLastModificationBy(site.getLastModificationBy());
                                em.persist(coordinateList.get(i));
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

        private boolean persist(Site site, List<SiteCoordinate> coordinateList,List<GeoreferencedSitePK> georeferencedSitesPKs) {
        boolean persisted = false;
        if (!isSiteNull(site)){
            if (this.isSiteUnique(site)) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transaccion
                    // Primero las obligatorias
                    site.setBaseProjection(em.find(Projection.class,site.getBaseProjection().getId()));
                    site.setFeatureType(em.find(FeatureType.class,site.getFeatureType().getId()));
                    site.setSiteCalculationMethod(em.find(SiteCalculationMethod.class,site.getSiteCalculationMethod().getId()));
                    site.setOriginalProjection(em.find(Projection.class,site.getOriginalProjection().getId()));
                    em.persist(site);

                    // Crear las coordenadas
                    if (coordinateList != null) {
                        if (coordinateList.size() > 0) {
                            for (int i=0; i<coordinateList.size(); i++) {
                                coordinateList.get(i).setSite(site);
                                coordinateList.get(i).setSequence(i+1);
                                coordinateList.get(i).setCreatedBy(site.getCreatedBy());
                                coordinateList.get(i).setLastModificationBy(site.getLastModificationBy());
                                em.persist(coordinateList.get(i));
                            }
                        }
                    }
                    System.out.println("en el SiteBean.java> siteId="+site.getId());
                    if(georeferencedSitesPKs!=null){
                    	System.out.println("georeferencedSitesPKs!=null");
                        for(GeoreferencedSitePK gsPK : georeferencedSitesPKs){
                        	System.out.println(gsPK.toString());
                            siteManager.saveOrUpdateGeoreferenceForSite(site.getId(), gsPK.getGeographicLayerId(), gsPK.getGeographicSiteId());
                        //saveOrUpdateGeoreferenceForSite()
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
    
    public boolean update(Site site, List<SiteCoordinate> coordinateList) {
        boolean updated = false;
        if (!isSiteNull(site)){
            try {
                /* Eliminar las coordenadas actuales */
                em.createNativeQuery("delete from ara.site_coordinate where site_id = " + site.getId()).executeUpdate();
                // Crear las coordenadas
                if (coordinateList != null) {
                    if (coordinateList.size() > 0) {
                        for (int i=0; i<coordinateList.size(); i++) {
                            SiteCoordinate coord = new SiteCoordinate();
                            coord.setLongitude(coordinateList.get(i).getLongitude());
                            coord.setLatitude(coordinateList.get(i).getLatitude());
                            coord.setSite(em.find(Site.class,site.getId()));
                            coord.setSequence(i+1);
                            coord.setCreatedBy(site.getCreatedBy());
                            coord.setLastModificationBy(site.getLastModificationBy());
                            em.persist(coord);
                        }
                    }
                }
                
                // Incorporar las entidades auxiliares al contexto de la transaccion
                // Primero las obligatorias
                Site currentSite = em.find(Site.class,site.getId());
                currentSite.setBaseProjection(em.find(Projection.class,site.getBaseProjection().getId()));
                currentSite.setFeatureType(em.find(FeatureType.class,site.getFeatureType().getId()));
                currentSite.setSiteCalculationMethod(em.find(SiteCalculationMethod.class,site.getSiteCalculationMethod().getId()));
                currentSite.setOriginalProjection(em.find(Projection.class,site.getOriginalProjection().getId()));
                currentSite.setDescription(site.getDescription());
                currentSite.setPrecision(site.getPrecision());
                currentSite.setGeodeticDatum(site.getGeodeticDatum());
                em.merge(currentSite);
                updated = true;
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
    
    private boolean isSiteNull(Site site) {
        if (site.getDescription() == null) {
            this.setMessage("Falta la descripci�n");
            return true;
        }
        
        if (site.getDescription().equals("")) {
            this.setMessage("Falta la descripci�n");
            return true;
        }
        
        if (site.getBaseProjection() == null) {
            this.setMessage("Falta la proyecci�n");
            return true;
        }
        
        if (site.getFeatureType() == null) {
            this.setMessage("Falta el tipo");
            return true;
        }
        
        if (site.getOriginalProjection()==null) {
            this.setMessage("Falta la proyecci�n original");
            return true;
        }        
        return false;
    }
    
    private boolean isSiteUnique(Site site) {
        if (site == null) {
            this.setMessage("Entidad Sitio no v�lida (nula).");
            return false;
        } else {
            if (site.getId() == null) {
                return true;
            } else {
                if (em.find(Site.class,site.getId()) == null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
    private boolean canDeleteSite(Long id) {
        if (getGatheringObservationCountBySite(id) > 0) {
            return false;
        }
        return true;
    }
    
    private int getGatheringObservationCountBySite(Long siteId) {
        Query q;
        String sql;
        
        sql = "select count(gathering_observation_id) from ara.gathering_observation where site_id = " + siteId;
        q = em.createNativeQuery(sql);
        
        Object obj = q.getSingleResult();        
        int count = Integer.parseInt(obj.toString());
        return count;
    }
}
