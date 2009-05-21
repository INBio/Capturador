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
 * TaxonNomenclaturalGroup.java
 *
 * Created on June 29, 2008, 3:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

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

/**
 *
 * @author roaguilar
 */
@Entity()
@Table(name="taxon_nomenclatural_group")
public class TaxonNomenclaturalGroup extends genericEntity{
    
    @EmbeddedId
    private TaxonNomenclaturalGroupPK taxonNomenclaturalGroupPK;
    
    @Temporal(TemporalType.DATE)
    @Column(name="taxonomical_timestamp", nullable = false)
    private Date taxonomicalTimeStamp;
    
    @Column(name="sequence",nullable=false)
    private Long sequence;
    
    @JoinColumn(name="taxon_id", referencedColumnName="taxon_id", insertable = false, updatable=false)
    @ManyToOne()
    private Taxon taxon;
    
    @JoinColumn(name="nomenclatural_group_id", referencedColumnName="nomenclatural_group_id", insertable = false, updatable=false)
    @ManyToOne()
    private NomenclaturalGroup nomenclaturalGroup;
    
    /** Creates a new instance of TaxonNomenclaturalGroup */
    public TaxonNomenclaturalGroup() {
    }
    
    public TaxonNomenclaturalGroup(TaxonNomenclaturalGroupPK pk) {
        this.setTaxonNomenclaturalGroupPK(pk);
    }

    public TaxonNomenclaturalGroupPK getTaxonNomenclaturalGroupPK() {
        return taxonNomenclaturalGroupPK;
    }

    public void setTaxonNomenclaturalGroupPK(TaxonNomenclaturalGroupPK taxonNomenclaturalGroupPK) {
        this.taxonNomenclaturalGroupPK = taxonNomenclaturalGroupPK;
    }

    public Date getTaxonomicalTimeStamp() {
        return taxonomicalTimeStamp;
    }

    public void setTaxonomicalTimeStamp(Date taxonomicalTimeStamp) {
        this.taxonomicalTimeStamp = taxonomicalTimeStamp;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public NomenclaturalGroup getNomenclaturalGroup() {
        return nomenclaturalGroup;
    }

    public void setNomenclaturalGroup(NomenclaturalGroup nomenclaturalGroup) {
        this.nomenclaturalGroup = nomenclaturalGroup;
    }
}
