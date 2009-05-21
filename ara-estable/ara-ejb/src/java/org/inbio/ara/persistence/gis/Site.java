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
 * Site.java
 *
 * Created on October 28, 2007, 12:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import org.inbio.ara.facade.gis.SiteRemote;
import org.inbio.ara.persistence.selectionListEntity;

/**
 * Entity class Site
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="site")
@TableGenerator(name="site_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="site_id",allocationSize=1)
public class Site extends selectionListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="site_id_gen")
    @Column(name = "site_id", nullable = false)
    private Long id;
    
    @Column(name="geodetic_datum", nullable = true)
    private Long geodeticDatum;
    
    @Column(name="precision", nullable = true)
    private Long precision;

    @JoinColumn(name="feature_type_id", referencedColumnName="feature_type_id")
    @ManyToOne()
    private FeatureType featureType;
    
    @JoinColumn(name="original_projection_id", referencedColumnName="projection_id")
    @ManyToOne()
    private Projection originalProjection;
    
    @JoinColumn(name="base_projection_id", referencedColumnName="projection_id")
    @ManyToOne()
    private Projection baseProjection;
    
    @JoinColumn(name="site_calculation_method_id", referencedColumnName="site_calculation_method_id")
    @ManyToOne()
    private SiteCalculationMethod siteCalculationMethod;    
    
    @Transient
    private String featureTypeName;
    
    @Transient
    private String baseProjectionName;
    
    @Transient
    private String siteCalculationMethodName;
    
    @Transient
    private String firstCoordinate;
    
    @OneToMany(mappedBy = "site", cascade = CascadeType.REMOVE)
    private List<SiteCoordinate> coordinateList;
    
    
    /** Creates a new instance of Site */
    public Site() {
    }

    /**
     * Gets the id of this Site.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Site to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Site.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Site object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.Site[id=" + id + "]";
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    public Projection getBaseProjection() {
        return baseProjection;
    }

    public void setBaseProjection(Projection baseProjection) {
        this.baseProjection = baseProjection;
    }

    public SiteCalculationMethod getSiteCalculationMethod() {
        return siteCalculationMethod;
    }

    public void setSiteCalculationMethod(SiteCalculationMethod siteCalculationMethod) {
        this.siteCalculationMethod = siteCalculationMethod;
    }

    public Long getGeodeticDatum() {
        return geodeticDatum;
    }

    public void setGeodeticDatum(Long geodeticDatum) {
        this.geodeticDatum = geodeticDatum;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public String getFeatureTypeName() {
        return featureTypeName;
    }

    public void setFeatureTypeName(String featureTypeName) {
        this.featureTypeName = featureTypeName;
    }

    public String getBaseProjectionName() {
        return baseProjectionName;
    }

    public void setBaseProjectionName(String baseProjectionName) {
        this.baseProjectionName = baseProjectionName;
    }

    public String getSiteCalculationMethodName() {
        return siteCalculationMethodName;
    }

    public void setSiteCalculationMethodName(String siteCalculationMethodName) {
        this.siteCalculationMethodName = siteCalculationMethodName;
    }

    public String getFirstCoordinate() {
        return firstCoordinate;
    }

    public void setFirstCoordinate(String firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }

    public List<SiteCoordinate> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<SiteCoordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public void setOriginalProjection(Projection projection) {
        this.originalProjection = projection;
    }
    
    public Projection getOriginalProjection() {
        return this.originalProjection;
    }
    
    @PostLoad
    public void postLoad(){
        this.setFeatureTypeName(this.getFeatureType().getName());
        this.setBaseProjectionName(this.getBaseProjection().getName());
        this.setSiteCalculationMethodName(this.getSiteCalculationMethod().getName());  
        try {
            if (coordinateList != null) {
                if (coordinateList.size() > 0) {
                    setFirstCoordinate(this.getCoordinateList().get(0).getLongitude() + ", " + this.getCoordinateList().get(0).getLatitude());
                } else {
                    setFirstCoordinate("Sin definir");
                }
            } else {
                setFirstCoordinate("Sin definir");
            }
        } catch (Exception ex1) {
            setFirstCoordinate("Sin definir");
        }
    }
    
    /*
    @PreUpdate
    public void preUpdate(){
        setAuditDateOnUpdate();
    }
     */
    
    private SiteRemote lookupSiteBean() {
        try {
            Context c = new InitialContext();
            return (SiteRemote) c.lookup("SiteBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}
