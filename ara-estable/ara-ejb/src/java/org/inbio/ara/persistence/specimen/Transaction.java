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
 * Transaction.java
 *
 * Created on October 30, 2007, 3:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;


/**
 * Entity class Transaction
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "transaction")
@TableGenerator(name="transaction_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="transaction_id",allocationSize=1)
public class Transaction extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="transaction_gen")
    @Column(name = "transaction_id", nullable = false)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="transaction_date", nullable = false)
    private Date transactionDate;
    
    @Column(name="invoice_number")
    private String invoiceNumber;
    
    @Column(name="estimated_specimen_count")
    private Long estimatedSpecimenCount;
    
    @Column(name="description")
    private String description;
    
    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date", nullable = false)
    private Date expirationDate;
    
    @JoinColumn(name="sender_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person senderPerson;
    
    @JoinColumn(name="sender_institution_id", referencedColumnName="institution_id")
    @ManyToOne()
    private Institution senderInstitution;
    
    @JoinColumn(name="receiver_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person receiverPerson;
    
    @JoinColumn(name="receiver_institution_id", referencedColumnName="institution_id")
    @ManyToOne()
    private Institution receiverInstitution;    
    
    @JoinColumn(name="transaction_type_id", referencedColumnName="transaction_type_id")
    @ManyToOne()
    private TransactionType transactionType;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id")
    @ManyToOne()
    private Collection collection;
    
    
    /** Creates a new instance of Transaction */
    public Transaction() {
    }

    /**
     * Gets the id of this Transaction.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Transaction to the specified value.
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
     * Determines whether another object is equal to this Transaction.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Transaction object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction)object;
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
        return "org.inbio.ara.persistence.specimen.Transaction[id=" + id + "]";
    }

    /**
     * @return the collection
     */
    public Collection getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    
}
