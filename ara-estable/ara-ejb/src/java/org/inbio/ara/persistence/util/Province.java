/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.inbio.ara.persistence.genericEntity;

/**
 *
 * @author jgutierrez
 * Eso esta hecho a la carrera siguiendo como modelo base los mapeos de country... o  sea que los problemas de esos mapeos
 * estan reflejados acá tal cual.
 */
@Entity
@Table(name = "province")
@TableGenerator(name="province_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="province_id",allocationSize=1)
public class Province extends genericEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="province_id_gen")
    @Column(name="province_id", nullable = false)
    private Long id;

    @Column(name="value")
    private String name;

    
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private Country country;

    public Province() {
    }

    public Province(Long id) {
        this.id = id;
    }

    public Province(Long id, String name, String createdBy, String lastModificationBy) {
        this.id = id;
        this.name = name;
        //this.setObjVersion(objVersion);
        this.setCreatedBy(createdBy);
        //this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        //this.ssetLastModificationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.util.Province[id=" + id + "]";
    }

}
