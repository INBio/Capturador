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
 * IdentificationTest.java
 *
 * Created on June 23, 2008, 6:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author roaguilar
 */
@Entity()
@Table(name="identification_test")
public class IdentificationTest extends genericEntity{
    
    @EmbeddedId
    private IdentificationPK identificationPK;
    
    @Temporal(TemporalType.DATE)
    @Column(name="identification_date", nullable = false)
    private Date identificationDate;
    
    @JoinColumn(name="identification_type_id", referencedColumnName="identification_type_id")
    @ManyToOne()
    private IdentificationType identificationType;
    
    @JoinColumn(name="identification_status_id", referencedColumnName="identification_status_id")
    @ManyToOne()
    private IdentificationStatus identificationStatus;
    
    @JoinColumn(name="taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon taxon;
    
    @JoinColumn(name="valuer_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person valuerPerson;
    
    @Column(name="data_entry_error")
    private String dataEntryError;
    
    /** Creates a new instance of IdentificationTest */
    public IdentificationTest() {
    }

    public IdentificationPK getIdentificationPK() {
        return identificationPK;
    }

    public void setIdentificationPK(IdentificationPK identificationPK) {
        this.identificationPK = identificationPK;
    }

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Date identificationDate) {
        this.identificationDate = identificationDate;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public IdentificationStatus getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(IdentificationStatus identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Person getValuerPerson() {
        return valuerPerson;
    }

    public void setValuerPerson(Person valuerPerson) {
        this.valuerPerson = valuerPerson;
    }

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }
}
