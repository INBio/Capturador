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
 * Module.java
 *
 * Created on September 9, 2007, 12:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.inbio.ara.persistence.selectionListEntity;
import org.inbio.ara.persistence.security.OptionType;

/**
 *
 * @author roaguilar
 */

@Entity()
@Table(name = "system_option")
@TableGenerator(name="option_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="option_id",allocationSize=1)
public class SystemOption extends selectionListEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="option_id_gen")
    @Column(name="option_id", nullable = false)
    private Long id;
    
    @Column(name="navigation_rule", nullable=false)
    private String navigationRule;
    
    @JoinColumn(name = "module_id", referencedColumnName = "module_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Module module;
    
    @JoinColumn(name = "type_id", referencedColumnName = "system_option_type_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private OptionType optionType;
    
    /** Creates a new instance of Module */
    public SystemOption() {
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public OptionType getOptionType() {
        return this.optionType;
    }

    public void setOptionType(OptionType optionType) {
        this.optionType = optionType;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Module.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Module object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        SystemOption other = (SystemOption)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.security.SystemOption[id=" + getId() + "]";
    }
}
