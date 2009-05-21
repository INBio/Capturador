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
 * SpecimenVariable.java
 *
 * Created on April 22, 2008, 5:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.inbio.ara.persistence.genericEntityVariable;

/**
 *
 * @author roaguilar
 */
@Entity()
@Table(name = "specimen_variable")
@TableGenerator(name="specimen_variable_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="specimen_variable_id",allocationSize=1)
public class SpecimenVariable extends genericEntityVariable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="specimen_variable_gen")
    @Column(name = "specimen_variable_id", nullable = false)
    private Long id;
    
    /** Creates a new instance of SpecimenVariable */
    public SpecimenVariable() {
    }

	@Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
