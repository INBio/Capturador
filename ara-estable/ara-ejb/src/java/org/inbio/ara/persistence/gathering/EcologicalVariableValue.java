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
 * EcologicalVariableValue.java
 *
 * Created on April 23, 2008, 10:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author roaguilar
 */

@Entity()
@Table(name = "ecological_variable_value")
@TableGenerator(name="ecological_variable_value_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="ecological_variable_value_id",allocationSize=1)
public class EcologicalVariableValue {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="ecological_variable_value_gen")
    @Column(name = "ecological_variable_value_id", nullable = false)
    private Long id;
    
    @JoinColumn(name="ecological_variable_id", referencedColumnName="ecological_variable_id")
    @ManyToOne()
    private EcologicalVariable ecologicalVariable;
    
    /** Creates a new instance of EcologicalVariableValue */
    public EcologicalVariableValue() {
    }
    
    public Long getId() {
        return id;
    }

    public EcologicalVariable getEcologicalVariable() {
        return ecologicalVariable;
    }

    public void setEcologicalVariable(EcologicalVariable ecologicalVariable) {
        this.ecologicalVariable = ecologicalVariable;
    }
}
