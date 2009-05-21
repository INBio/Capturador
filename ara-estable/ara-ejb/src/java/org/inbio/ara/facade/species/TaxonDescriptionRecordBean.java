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
 * TaxonDescriptionRecordBean.java
 *
 * Created on November 1, 2007, 8:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.reference.Reference;
import org.inbio.ara.persistence.reference.TaxonDescriptionRecordReference;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.species.TaxonDescriptionRow;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;
import org.inbio.ara.persistence.util.Language;

/**
 *
 * @author roaguilar
 */
@Stateless
public class TaxonDescriptionRecordBean implements TaxonDescriptionRecordRemote, TaxonDescriptionRecordLocal {
    
    @PersistenceContext
    private EntityManager em;
    private String message;
    private TaxonDescriptionRecord taxonDescriptionRecord;
    private List taxonDescriptionRecordList;
    private List taxonDescriptionRecordAuthorList;
    
    /** Creates a new instance of TaxonDescriptionRecordBean */
    public TaxonDescriptionRecordBean() {
        this.message = "";
    }
    
    public boolean persist(TaxonDescriptionRecord taxonDescriptionRecord, Long[] referenceArray) {
        try {
            Language L = em.find(Language.class,1L);
            TaxonDescription td = em.find(TaxonDescription.class,this.taxonDescriptionRecord.getTaxonDescription().getTaxonDescriptionPK());
            TaxonDescriptionElement tde = em.find(TaxonDescriptionElement.class,this.getTaxonDescriptionRecord().getTaxonDescriptionElement().getId());
            try {
                this.taxonDescriptionRecord.setTaxonDescription(td);
                this.taxonDescriptionRecord.setTaxonDescriptionElement(tde);
                
                // Update TaxonDescriptionRecordReference
                TaxonDescriptionRecordReference taxonDescriptionRecordReference;
                Reference reference;
                Set referenceSet = new HashSet();
                if (referenceArray.length > 0) {
                    for (Long referenceId: referenceArray) {
                        reference = (Reference)em.find(Reference.class,referenceId);
                        taxonDescriptionRecordReference = new TaxonDescriptionRecordReference(reference.getId(),this.taxonDescriptionRecord.getId());
                        taxonDescriptionRecordReference.setCreatedBy(this.taxonDescriptionRecord.getCreatedBy());
                        taxonDescriptionRecordReference.setLastModificationBy(this.taxonDescriptionRecord.getLastModificationBy());
                        referenceSet.add(taxonDescriptionRecordReference);
                    }
                    //this.taxonDescriptionRecord.setTaxonDescriptionRecordReferenceSet(referenceSet);
                }
                
                em.persist(this.taxonDescriptionRecord);
                return true;
            } catch (EntityExistsException e1) {
                this.setMessage(e1.getMessage());
                return false;
            } catch (IllegalStateException e2) {
                this.setMessage(e2.getMessage());
                return false;
            } catch (IllegalArgumentException e3) {
                this.setMessage(e3.getMessage());
                return false;
            /*} catch (TransactionRequiredException e4) {
                this.setMessage(e4.getMessage());
                return false;*/
            } catch (NullPointerException e5) {
                this.setMessage(e5.getMessage());
                return false;
            }
        } catch (IllegalStateException e) {
            setMessage(e.getLocalizedMessage());
            return false;
        } catch (IllegalArgumentException ex) {
            setMessage(ex.getMessage());
            return false;
        } catch (NullPointerException ex2) {
            setMessage(ex2.getMessage());
            return false;
        }
    }
    
    public boolean persist(TaxonDescriptionRecord taxonDescriptionRecord) {
        if (this.isTaxonDescriptionUnique(taxonDescriptionRecord)) {
            try {
                TaxonDescription td = em.find(TaxonDescription.class,this.taxonDescriptionRecord.getTaxonDescription().getTaxonDescriptionPK());
                TaxonDescriptionElement tde = em.find(TaxonDescriptionElement.class,this.getTaxonDescriptionRecord().getTaxonDescriptionElement().getId());

                System.out.println("- TaxonDescriptionRecord construido -");
                System.out.println(taxonDescriptionRecord.getContentsNumeric());
                System.out.println(taxonDescriptionRecord.getContentsText());
                System.out.println(taxonDescriptionRecord.getCreatedBy());
                System.out.println(taxonDescriptionRecord.getCreationDate());
                System.out.println(taxonDescriptionRecord.getId());
                System.out.println(taxonDescriptionRecord.getLastModificationBy());
                System.out.println(taxonDescriptionRecord.getLastModificationDate());
                System.out.println(taxonDescriptionRecord.getSequence());
                System.out.println(taxonDescriptionRecord.getTaxonDescription().getTaxonDescriptionPK().toString());
                System.out.println(taxonDescriptionRecord.getTaxonDescriptionElement().getId());
                System.out.println(taxonDescriptionRecord.getTaxonomicalTimestamp());
                System.out.println(taxonDescriptionRecord.getVersion());


                try {
                    this.taxonDescriptionRecord.setTaxonDescription(td);
                    this.taxonDescriptionRecord.setTaxonDescriptionElement(tde);
                    em.persist(this.taxonDescriptionRecord);
                    return true;
                } catch (EntityExistsException e1) {
                    this.setMessage(e1.getMessage());
                    return false;
                } catch (IllegalStateException e2) {
                    this.setMessage(e2.getMessage());
                    return false;
                } catch (IllegalArgumentException e3) {
                    this.setMessage(e3.getMessage());
                    return false;
                /*} catch (TransactionRequiredException e4) {
                    this.setMessage(e4.getMessage());
                    return false;*/
                } catch (NullPointerException e5) {
                    this.setMessage(e5.getMessage());
                    return false;
                }
            } catch (IllegalStateException e) {
                setMessage(e.getLocalizedMessage());
                return false;
            } catch (IllegalArgumentException ex) {
                setMessage(ex.getMessage());
                return false;
            } catch (NullPointerException ex2) {
                setMessage(ex2.getMessage());
                return false;
            }
        } else {
            setMessage("Ya existe otra descripci�n almacenada en el sistema con la misma informaci�n. El registro no fu� creado.");
            return false;
        }
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public TaxonDescriptionRecord getTaxonDescriptionRecord() {
        return taxonDescriptionRecord;
    }
    
    public void setTaxonDescriptionRecord(TaxonDescriptionRecord taxonDescriptionRecord) {
        this.taxonDescriptionRecord = taxonDescriptionRecord;
    }
    
    public boolean create(TaxonDescriptionRecord taxonDescriptionRecord) {
        this.setTaxonDescriptionRecord(taxonDescriptionRecord);
        return this.persist(taxonDescriptionRecord);
    }
    
    public boolean create(TaxonDescriptionRecord taxonDescriptionRecord, Long[] referencesArray) {
        this.setTaxonDescriptionRecord(taxonDescriptionRecord);
        this.updateReferenceList(referencesArray);
        return this.persist(taxonDescriptionRecord, referencesArray);
    }
    
    public boolean update(TaxonDescriptionRecord taxonDescriptionRecord) {
        boolean updated = true;
        try {
            this.setTaxonDescriptionRecord(taxonDescriptionRecord);
            em.merge(this.getTaxonDescriptionRecord());
            updated = true;
        } catch (Exception e) {
            //this.setMessage("El registro No. " + getTaxonDescription().getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
            this.setMessage("");
        }
        return updated;
    }
    
    public boolean update(TaxonDescriptionRecord taxonDescriptionRecord, Long[] referenceArray) {
        boolean updated = false;
        if (this.deleteAssociatedInformation(taxonDescriptionRecord)) {
            updated = this.update(taxonDescriptionRecord);
            if (updated) {
                if ((referenceArray.length > 0 ) | (referenceArray != null)) {
                    updateReferenceList(referenceArray);
                }
            }
        }
        return updated;
    }
    
    
    private boolean deleteAssociatedInformation(TaxonDescriptionRecord taxonDescriptionRecord) {
        try {
            Query q;
            int count;
            q = em.createQuery("delete from TaxonDescriptionRecordReference where taxonDescriptionRecordReferencePK.taxonDescriptionRecordId = " + taxonDescriptionRecord.getId());
            count = q.executeUpdate();
            return true;
        } catch (IllegalStateException ex1) {
            System.out.println(ex1.getMessage());
            return false;
        } catch (IllegalArgumentException ex2) {
            System.out.println(ex2.getMessage());
            return false;
        }
    }
    
    private void updateReferenceList(Long[] referenceArray) {
        TaxonDescriptionRecordReference taxonDescriptionRecordReference;
        Reference reference;
        
        if (referenceArray.length > 0) {
            for (Long referenceId: referenceArray) {
                reference = (Reference)em.find(Reference.class,referenceId);
                taxonDescriptionRecordReference = new TaxonDescriptionRecordReference(reference.getId(),this.taxonDescriptionRecord.getId());
                taxonDescriptionRecordReference.setCreatedBy(this.taxonDescriptionRecord.getCreatedBy());
                taxonDescriptionRecordReference.setLastModificationBy(this.taxonDescriptionRecord.getLastModificationBy());
                //profileSet.add(personProfile);
                try {
                    em.persist(taxonDescriptionRecordReference);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexi�n con la base de datos fu� cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad v�lida.");
                } /*catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                }*/
            }
        }
    }
    
    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonDescriptionRecord as o");
        setTaxonDescriptionRecordList(q.getResultList());
        return getTaxonDescriptionRecordList();
    }
    
    public List getTaxonDescriptionRecordList() {
        return taxonDescriptionRecordList;
    }
    
    public void setTaxonDescriptionRecordList(List taxonDescriptionRecordList) {
        this.taxonDescriptionRecordList = taxonDescriptionRecordList;
    }
    
    public TaxonDescriptionRecord getTaxonDescriptionRecordByRowId(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId) {
        TaxonDescriptionRecord tTaxonDescriptionRecord;
        String hql = "";
        try {
            hql = "Select object(o) from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId;
            hql += " and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence;
            hql += " and o.taxonDescriptionElement.id = " + taxonDescriptionElementId;
            hql += " and o.sequence = " + rowId; System.out.println(hql);
            Query q = em.createQuery(hql);
            try {
                tTaxonDescriptionRecord = (TaxonDescriptionRecord)q.getSingleResult();
                this.setTaxonDescriptionRecord(tTaxonDescriptionRecord);
            } catch (NoResultException noResultEx) {
                this.setMessage("No se encontraron descripciones para los valores dados.");
                return null;
            } catch (NonUniqueResultException noUniqueResultEx) {
                this.setMessage("La consulta produjo m�s de un resultado");
                return null;
            } catch (IllegalStateException stateException) {
                this.setMessage("Se produjo un llamado a INSERT o UPDATE");
                return null;
            } finally {
                
            }
        } catch (IllegalStateException stateEx) {
            this.setMessage("Se perdi� la comunicaci�n con la base de datos.");
            return null;
        } catch (IllegalArgumentException argumentEx) {
            System.out.println(argumentEx.getMessage());
            this.setMessage("Consulta inv�lida. " + argumentEx.getMessage());
        }
        //this.setTaxonDescriptionRecordAuthorList(em.createQuery("Select o from TaxonDescriptionPersonProfile as o where o.taxonDescriptionPersonProfilePK.taxonDescriptionRecordId = " + this.taxonDescriptionRecord.getId() + " order by o.sequence").getResultList());
        return this.getTaxonDescriptionRecord();
    }
    
    public TaxonDescriptionRecord getTaxonDescriptionRecordByTaxonDescription(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId) {
        TaxonDescriptionRecord tTaxonDescriptionRecord;
        String hql = "";
        try {
            hql = "Select object(o) from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId;
            hql += " and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence;
            hql += " and o.taxonDescriptionElement.id = " + taxonDescriptionElementId;
            Query q = em.createQuery(hql);
            try {
                tTaxonDescriptionRecord = (TaxonDescriptionRecord)q.getSingleResult();
                this.setTaxonDescriptionRecord(tTaxonDescriptionRecord);
            } catch (NoResultException noResultEx) {
                this.setMessage("No se encontraron descripciones para los valores dados.");
                return null;
            } catch (NonUniqueResultException noUniqueResultEx) {
                this.setMessage("La consulta produjo m�s de un resultado");
                return null;
            } catch (IllegalStateException stateException) {
                this.setMessage("Se produjo un llamado a INSERT o UPDATE");
                return null;
            } finally {
                
            }
        } catch (IllegalStateException stateEx) {
            this.setMessage("Se perdi� la comunicaci�n con la base de datos.");
            return null;
        } catch (IllegalArgumentException argumentEx) {
            System.out.println(argumentEx.getMessage());
            this.setMessage("Consulta inv�lida. " + argumentEx.getMessage());
        }
        //this.setTaxonDescriptionRecordAuthorList(em.createQuery("Select o from TaxonDescriptionPersonProfile as o where o.taxonDescriptionPersonProfilePK.taxonDescriptionRecordId = " + this.taxonDescriptionRecord.getId() + " order by o.sequence").getResultList());
        return this.getTaxonDescriptionRecord();
    }
    
    
    public List getTaxonDescriptionRecordAuthorList() {
        return taxonDescriptionRecordAuthorList;
    }
    
    public void setTaxonDescriptionRecordAuthorList(List taxonDescriptionRecordAuthorList) {
        this.taxonDescriptionRecordAuthorList = taxonDescriptionRecordAuthorList;
    }
    
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.taxonDescriptionRecord = em.find(this.taxonDescriptionRecord.getClass(),id);
            this.taxonDescriptionRecord = em.merge(this.taxonDescriptionRecord);
            em.remove(this.taxonDescriptionRecord);
            removed = true;
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;
    }
    
    public TaxonDescriptionRecord find(Long taxonDescriptionRecordId){
        //System.out.println("Find " + taxonDescriptionRecordId);
        Query q = em.createQuery("Select object(o) from TaxonDescriptionRecord as o where o.id = " + taxonDescriptionRecordId);
        try {
            this.setTaxonDescriptionRecord((TaxonDescriptionRecord) q.getSingleResult());
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo m�s de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        //System.out.println("find " + taxonDescriptionRecord.getId());
        return this.taxonDescriptionRecord;
    }
    
    /**
     * Para el preview (reporte) de la informacion existente sobre un registro
     * de especies se utiliza este metodo.
     * @param TDpk: TaxonDescriptionPK que incluye el taxonId y el sequence
     * @return List<TaxonDescriptionRecord> sorted by sequence
     */
    public List<TaxonDescriptionRecord> find(TaxonDescriptionPK TDpk){
        StringBuffer query = new StringBuffer();
        query.append("from TaxonDescriptionRecord o where o.taxonDescription.taxonDescriptionPK.taxonId = ");
        query.append(TDpk.getTaxonId());
        query.append(" and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = ");
        query.append(TDpk.getTaxonDescriptionSequence());        
        query.append(" order by o.sequence");
        Query q = em.createQuery(query.toString());
        try {
            this.setTaxonDescriptionRecordList(q.getResultList());
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo mas de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return this.taxonDescriptionRecordList;
    }
    
    private Long[] getTaxonDescriptionElements(Long categoryId) {
        Long[] elements = new Long[]{};
        List<TaxonDescriptionElement> elementList;        
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescriptionElement as o where o.taxonDescriptionCategory.id = " + categoryId + " order by o.sequence");
            elementList = q.getResultList();
            if (elementList.size() > 0) {
                elements = new Long[elementList.size()];
                int i = 0;
                for (TaxonDescriptionElement element: elementList) {
                    elements[i] = element.getId();
                    i++;
                }
            }
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo m�s de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return elements;
    }
    
    private Long[] getTaxonDescriptionRows(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        Long[] rows = new Long[]{};
        //List<TaxonDescriptionRecord> recordList;        
        List<Long> recordList;
        try {
            String hql = "Select distinct o.sequence from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescriptionElement.taxonDescriptionCategory.id = " + categoryId + " and ";
            hql += "o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and ";
            hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence + " order by o.sequence";
            //Query q = em.createQuery("Select distinct o.sequence from TaxonDescriptionRecord as o where o.taxonDescriptionElement.taxonDescriptionCategory.id = " + categoryId + " order by o.sequence");
            Query q = em.createQuery(hql);
            recordList = q.getResultList();
            if (recordList.size() > 0) {
                rows = new Long[recordList.size()];
                int i = 0;
                //for (TaxonDescriptionRecord record: recordList) {
                for (Long record: recordList) {
                    //rows[i] = record.getSequence();
                    rows[i] = record;
                    i++;
                }
            }
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo más de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return rows;
    }
    
    private TaxonDescriptionRecord getTaxonDescriptionRecord(Long elementId, Long sequence) {
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescriptionRecord as o where o.taxonDescriptionElement.id = " + elementId + " and o.sequence = " + sequence);
            this.setTaxonDescriptionRecord((TaxonDescriptionRecord) q.getSingleResult());
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo más de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        //System.out.println("find " + taxonDescriptionRecord.getId());
        return this.taxonDescriptionRecord;
    }
    
    private TaxonDescriptionRecord getTaxonDescriptionRecord(Long taxonId, Long taxonDescriptionSequence, Long elementId, Long sequence) {
        try {
            String hql = "";
            hql = "Select object(o) from TaxonDescriptionRecord as o ";
            hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and ";
            hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence =  " + taxonDescriptionSequence + " and ";
            hql += "o.taxonDescriptionElement.id = " + elementId + " and ";
            hql += "o.sequence = " + sequence;
            //Query q = em.createQuery("Select object(o) from TaxonDescriptionRecord as o where o.taxonDescriptionElement.id = " + elementId + " and o.sequence = " + sequence);
            Query q = em.createQuery(hql);
            this.setTaxonDescriptionRecord((TaxonDescriptionRecord) q.getSingleResult());
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron descripciones para los valores dados.");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo más de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        //System.out.println("find " + taxonDescriptionRecord.getId());
        return this.taxonDescriptionRecord;
    }
    
    //private String getTaxonDescriptionRecordValue(Long elementId, Long sequence) {
    private String getTaxonDescriptionRecordValue(Long taxonId, Long taxonDescriptionSequence, Long elementId, Long sequence) {
        String value = "";
        TaxonDescriptionRecord record = this.getTaxonDescriptionRecord(taxonId, taxonDescriptionSequence, elementId, sequence);
        if (record != null) {
            /* Obtener el valor para el elemento dado.
             * Para los valores que ya est�n almacenados como hileras, simplemente se obtienen directamente del registo;
             **/
            /*
            if ((record.getContentsText() != null) || (!record.getContentsText().equals(""))) {
                value = record.getContentsText();
                return value;
            }
             */
            if (record.getContentsText() != null) {
                if (!record.getContentsText().equals("")) {
                    value = record.getContentsText();
                    if (value.length() > 50) {
                        value = value.substring(0,46) + "...";
                    }
                    return value;
                }
            }

            /* TO-DO Para los valores numéricos hay que verificar si el valor proviene de una lista de selecci�n,
             * dado el caso, se realiza la consulta del valor textual asociado a dicho id.
            **/
            
            /*
             * Para los valores num�ricos, se obtienen directamente y luego se convierten a una hilera
             **/
            if ((record.getContentsNumeric() != null) && (record.getTaxonDescriptionElement().getMainFieldName() == null)) {
                value = record.getContentsNumeric().toString();
                return value;
            }
            
            if (record.getTaxonDescriptionElement().getTableName() != null) {
                String tableName = record.getTaxonDescriptionElement().getTableName();
                String keyField = record.getTaxonDescriptionElement().getKeyField();
                String fieldName = record.getTaxonDescriptionElement().getMainFieldName();
                
                Query q = em.createQuery("Select " + fieldName + " from " + tableName + " where " + keyField + "=" + record.getContentsNumeric().toString());
                String tempValue = (String)q.getSingleResult();
                value = tempValue;
                return value;
            }
        } else {
            value = "";
        }
        return value;
    }
    
    private String[][] createTaxonDescriptionRecordMatrix(Long categoryId,Long taxonId, Long taxonDescriptionSequence) {
        Long[] columns = new Long[]{};
        Long[] rows = new Long[]{};
        String[][] dataMatrix = new String[][]{};
        Long currentRow, currentColumn;
        
        // Obtener el arreglo con los id de los elementos (columnas) de la categor�a seleccionada
        columns = this.getTaxonDescriptionElements(categoryId);
        // Obtener el arreglo con las secuencias de los elementos
        rows = this.getTaxonDescriptionRows(categoryId, taxonId, taxonDescriptionSequence);
        
        // Verificar si hay datos para construir la matriz
        if ((columns.length > 0) & (rows.length > 0)) {
            // 
            dataMatrix = new String[rows.length][columns.length];
            for (int i=0; i < rows.length; i++) {
                currentRow = rows[i];
                for (int p = 0; p < columns.length; p++) {
                    currentColumn = columns[p];
                    //dataMatrix[i][p] =  getTaxonDescriptionRecordValue(currentColumn, currentRow);
                }
            }
        } 
        
        return dataMatrix;
    }
    
    private TaxonDescriptionRow getTaxonDescriptionRow(int elementIndex, String value, TaxonDescriptionRow refRow) {
        //TaxonDescriptionRow newRow = new TaxonDescriptionRow();
        TaxonDescriptionRow newRow = refRow;
        switch ( elementIndex ) {
        case 0:
           newRow.setValue1(value);
           break;
        case 1:
           newRow.setValue2(value);
           break;
        case 2:
           newRow.setValue3(value);
           break;
        case 3:
           newRow.setValue4(value);
           break;
        case 4:
           newRow.setValue5(value);
           break;
        case 5:
           newRow.setValue6(value);
           break;
        case 6:
           newRow.setValue7(value);
           break;
        case 7:
           newRow.setValue8(value);
           break;
        case 8:
           newRow.setValue9(value);
           break;
        case 9:
           newRow.setValue10(value);
           break;
        case 10:
           newRow.setValue11(value);
           break;
        case 11:
           newRow.setValue12(value);
           break;
        case 12:
           newRow.setValue13(value);
           break;
        case 13:
           newRow.setValue14(value);
           break;
        case 14:
           newRow.setValue15(value);
           break;
        case 15:
           newRow.setValue16(value);
           break;
        case 16:
           newRow.setValue17(value);
           break;
        case 17:
           newRow.setValue18(value);
           break;
        case 18:
           newRow.setValue19(value);
           break;
        case 19:
           newRow.setValue20(value);
           break;
        }
        return newRow;
    }
    
    private List getTaxonDescriptionCategoryRows(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        Long[] elements = new Long[]{};
        Long[] rows = new Long[]{};
        Long currentRow, currentElement;
        TaxonDescriptionRow newRow;
        List tList;
        String currentValue;
        
        // Obtener el arreglo con los id de los elementos (columnas) de la categor�a seleccionada
        elements = this.getTaxonDescriptionElements(categoryId);        
        // Obtener el arreglo con las secuencias de los elementos
        rows = this.getTaxonDescriptionRows(categoryId, taxonId, taxonDescriptionSequence);
        tList = new ArrayList();
        if (elements.length > 0) {
            if (rows.length > 0) {
                for (int i=0; i < rows.length; i++) {
                    currentRow = rows[i];
                    newRow = new TaxonDescriptionRow();
                    newRow.setRowId(currentRow);
                    for (int p = 0; p < elements.length; p++) {
                        currentElement = elements[p];
                        //currentValue = getTaxonDescriptionRecordValue(currentElement, currentRow);
                        currentValue = getTaxonDescriptionRecordValue(taxonId, taxonDescriptionSequence, currentElement, currentRow);
                        newRow = this.getTaxonDescriptionRow(p,currentValue,newRow);
                    }
                    /*
                    System.out.println("RowId: " + newRow.getRowId());
                    System.out.println("Value1: " + newRow.getValue1());
                    System.out.println("Value2: " + newRow.getValue2());
                    System.out.println("Value3: " + newRow.getValue3());
                    System.out.println("Value4: " + newRow.getValue4());
                    System.out.println("Value5: " + newRow.getValue5());
                    System.out.println("Value6: " + newRow.getValue6());
                    System.out.println("Value7: " + newRow.getValue7());
                    System.out.println("Value8: " + newRow.getValue8());
                    System.out.println("Value9: " + newRow.getValue9());
                    System.out.println("Value10: " + newRow.getValue10());
                    System.out.println("Value11: " + newRow.getValue11());
                    System.out.println("Value12: " + newRow.getValue12());
                    System.out.println("Value13: " + newRow.getValue13());
                    System.out.println("Value14: " + newRow.getValue14());
                    System.out.println("Value15: " + newRow.getValue15());
                    System.out.println("Value16: " + newRow.getValue16());
                    System.out.println("Value17: " + newRow.getValue17());
                    System.out.println("Value18: " + newRow.getValue18());
                    System.out.println("Value19: " + newRow.getValue19());
                    System.out.println("Value20: " + newRow.getValue20());
                     */
                    tList.add(newRow);
                }
                return tList;
            } else {
                this.setMessage("No hay valores");
                return null;
            }
        } else {
            this.setMessage("No hay elementos definidos para la categor�a.");
            return null;
        }
    }
    
    public List getTaxonDescriptionRowList(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        return getTaxonDescriptionCategoryRows(categoryId, taxonId, taxonDescriptionSequence);
    }
    
    private boolean isTaxonDescriptionUnique(TaxonDescriptionRecord taxonDescriptionRecord) {
        boolean isUnique = true;
        String tmpName, hql;
        Long tmpId;
        
        hql = "Select object(o) from TaxonDescriptionRecord as o ";
        hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonDescriptionRecord.getTaxonDescription().getTaxonDescriptionPK().getTaxonId();
        hql += " and o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionRecord.getTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence();
        hql += " and o.taxonDescriptionElement.id = " + taxonDescriptionRecord.getTaxonDescriptionElement().getId();
        hql += " and o.sequence = " + taxonDescriptionRecord.getSequence();
        if (taxonDescriptionRecord.getId()!=null) {
            hql += " and o.id <> " + taxonDescriptionRecord.getId();
        }        
        if (em.createQuery(hql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    public Long getNextTaxonDescriptionRecordSequence(Long taxonDescriptionSequence, Long taxonId) {
        String hql = "";
        Long nextSequence = 0L;
        Query q;
        
        hql = "Select max(o.sequence) from TaxonDescriptionRecord as o ";
        hql += "where o.taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and ";
        hql += "o.taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence;
        q = em.createQuery(hql);
        nextSequence = (Long)q.getSingleResult();
        if (nextSequence == null) {
            nextSequence = 1L;
        } else {
            nextSequence = nextSequence +1;
        }
        return nextSequence;
    }
    
    public boolean deleteTaxonDescriptionRecordRow(Long taxonDescriptionSequence, Long taxonId, Long sequence) {
        try {
            Query q;
            int count;
            String hql;
            
            hql = "delete from TaxonDescriptionRecord ";
            hql += "where taxonDescription.taxonDescriptionPK.taxonDescriptionSequence = " + taxonDescriptionSequence + " and ";
            hql += "taxonDescription.taxonDescriptionPK.taxonId = " + taxonId + " and ";
            hql += "sequence = " + sequence;
            System.out.println(hql);
            q = em.createQuery(hql);
            //q = em.createNativeQuery(hql);
            q.executeUpdate();
            return true;
        } catch (IllegalStateException ex1) {
            System.out.println(ex1.getMessage());
            return false;
        } catch (IllegalArgumentException ex2) {
            System.out.println(ex2.getMessage());
            return false;
        }
    }
}
