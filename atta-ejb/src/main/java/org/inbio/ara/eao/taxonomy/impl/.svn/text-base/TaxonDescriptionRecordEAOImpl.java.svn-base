/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.eao.taxonomy.impl;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionRecordEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord;

/**
 *
 * @author herson
 */
@Stateless
public class TaxonDescriptionRecordEAOImpl
        extends BaseEAOImpl<TaxonDescriptionRecord, Long>
        implements TaxonDescriptionRecordEAOLocal {
    
    public TaxonDescriptionRecord getTaxonDescriptionRecord
            (Long elementId, Long sequence) {
        Query q = em.createQuery
                ("from TaxonDescriptionRecord as tdr where tdr.taxonDescriptionElementId = :elementId "+
                 "and tdr.sequence = :sequence");
        q.setParameter("elementId", elementId);
        q.setParameter("sequence", sequence);
        return (TaxonDescriptionRecord)q.getSingleResult();
    }

    public TaxonDescriptionRecord getTaxonDescriptionRecord
            (Long taxonId, Long taxonDescriptionSequence,
            Long elementId, Long sequence) {
        String hql = "";
        hql = "from TaxonDescriptionRecord as tdr ";
        hql += "where tdr.taxonDescription.taxonDescriptionPK.taxonId = :taxonId and ";
        hql += "tdr.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence =  :taxonDescriptionSequence and ";
        hql += "tdr.taxonDescriptionElementId = :elementId and ";
        hql += "tdr.sequence = :sequence";
        Query q = em.createQuery(hql);
        q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
        q.setParameter("elementId", elementId);
        q.setParameter("sequence", sequence);
        return (TaxonDescriptionRecord)q.getSingleResult();
    }

    public List<Long> getTaxonDescriptionRows
            (Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        String hql = "Select distinct o.sequence from TaxonDescriptionRecord as o, TaxonDescriptionElement as tde ";
        hql += "where o.taxonDescriptionElementId = tde.taxonDescriptionElementId and ";
        hql += "tde.taxonDescriptionCategoryId = :categoryId and ";
        hql += "o.taxonDescription.taxonDescriptionPK.taxonId = :taxonId and ";
        hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence order by o.sequence";
        Query q = em.createQuery(hql);
        q.setParameter("categoryId", categoryId);
        q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
        return (List<Long>)q.getResultList();
    }

    /**
     * @deprecated
     */
    public String getTaxonDescriptionRecordValue
            (String mainFieldName,String tableName,String keyField,String contentsNumeric){
        try{
            Query q = em.createQuery("Select " + mainFieldName + " from " + tableName + " where " + keyField + "=" + contentsNumeric);
            String result = (String)q.getSingleResult();
            return result;
        }
        catch(Exception e){return null;}
    }

    /**
     * @deprecated
     */
    public List getFieldContent(Long Id, String tableName, String keyField,String tableField){
        try {
            String hql = "Select o." + tableField + " from " + tableName + " o ";
            hql += "where o." + keyField + " = " + Id;
            Query q = em.createQuery(hql);
            List result = (List) q.getResultList();
            return result;
        } catch (Exception e) {
            List result = new ArrayList();
            result.add("");
            return result;
        }
    }

    public TaxonDescriptionRecord getTaxonDescriptionRecordByRowId
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId) {

        try{
            String hql = "from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = :taxonId";
            hql += " and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence";
            hql += " and o.taxonDescriptionElementId = :taxonDescriptionElementId";
            hql += " and o.sequence = :rowId";
            Query q = em.createQuery(hql);
            q.setParameter("taxonId", taxonId);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            q.setParameter("taxonDescriptionElementId", taxonDescriptionElementId);
            q.setParameter("rowId", rowId);
            return (TaxonDescriptionRecord)q.getSingleResult();
        }
        catch(Exception e){return null;}
    }

    public TaxonDescriptionRecord getTaxonDescriptionRecordByTaxonDescription
            (Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId) {
        try{
            String hql = "from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = :taxonId";
            hql += " and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence";
            hql += " and o.taxonDescriptionElementId = :taxonDescriptionElementId";
            Query q = em.createQuery(hql);
            q.setParameter("taxonId", taxonId);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            q.setParameter("taxonDescriptionElementId", taxonDescriptionElementId);
            return (TaxonDescriptionRecord)q.getSingleResult();
        }
        catch(Exception e){return null;}
    }

    public int deleteTaxonDescriptionRecordRow
            (Long taxonDescriptionSequence, Long taxonId, Long sequence){
            String hql = "delete from TaxonDescriptionRecord ";
            hql += "where taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence and ";
            hql += "taxonDescription.taxonDescriptionPK.taxonId = :taxonId and ";
            hql += "sequence = :sequence";
            Query q = em.createQuery(hql);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            q.setParameter("taxonId", taxonId);
            q.setParameter("sequence", sequence);
            return q.executeUpdate(); //Retorna el # de entidades modificadas o barradas
    }

    public Long getNextTaxonDescriptionRecordSequence
            (Long taxonDescriptionSequence, Long taxonId) {
            String hql = "Select max(o.sequence) from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = :taxonId and ";
            hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence";
            Query q = em.createQuery(hql);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            q.setParameter("taxonId", taxonId);
            return (Long)q.getSingleResult();
    }

    public List<TaxonDescriptionRecord> getTaxonDescriptionRecordsByTaxonDescription(
            Long taxonId,Long taxonDescriptionSequence){
            try{
                String hql = "from TaxonDescriptionRecord as o ";
                hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = :taxonId and ";
                hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = :taxonDescriptionSequence order by o.taxonDescriptionRecordId";
                Query q = em.createQuery(hql);
                q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
                q.setParameter("taxonId", taxonId);
                return (List<TaxonDescriptionRecord>)q.getResultList();
            }
            catch(Exception e){return null;}
    }

}
