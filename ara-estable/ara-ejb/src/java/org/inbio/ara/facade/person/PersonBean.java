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
 * PersonBean.java
 *
 * Created on August 5, 2007, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.person;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.person.Person;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.PersonInstitution;
import org.inbio.ara.persistence.person.PersonProfile;
import org.inbio.ara.persistence.person.Profile;

/**
 *
 * @author roaguilar
 */
@Stateless
public class PersonBean implements PersonRemote, PersonLocal {

    @PersistenceContext
    private EntityManager em;
    private String message;    
    private Person person;    
    private List personList;
    
    /** Creates a new instance of PersonBean */
    public PersonBean() {
        this.person = null;
        this.message = "";
    }

    public boolean persist() {
        if (!isPersonNull(this.person)){
            if (isPersonUnique(this.person)) {
                try {
                    //this.person.setCreatedBy(userSessionManagerBean.getUser().getUserName());
                    //this.person.setCreatedBy(userSessionManagerBean.getUser().getUserName());
                    em.persist(this.person);
                    //this.person = em.find(Person.class, person);
                    this.person = em.merge(this.person);
                    return true;                
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                    return false;
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexión con la base de datos fue cerrada.");
                    return false;
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad valida.");
                    return false;
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
                    return false;
                }
            } else {
                //setMessage("Ya existe otra persona almacenada en el sistema con el mismo nombre y apellido. El registro no fu� creado.");
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
            return false;
        }
    }
    
    public boolean persist(Long[] profileArray, Long[] institutionArray) {
        if (!isPersonNull(this.person)){
            if (isPersonUnique(this.person)) {
                try {
                    
                    // Update PersonProfile
                    PersonProfile personProfile;
                    Profile profile;
                    Set profileSet = new HashSet();
                    if (profileArray.length > 0) {
                        for (Long profileId: profileArray) {
                            profile = (Profile)em.find(Profile.class,profileId);
                            personProfile = new PersonProfile(profile.getId(),this.person.getId());
                            personProfile.setCreatedBy(this.person.getCreatedBy());
                            personProfile.setLastModificationBy(this.person.getLastModificationBy());
                            profileSet.add(personProfile);
                        }
                        this.person.setPersonProfileSet(profileSet);            
                    }
                    
                    // Update PersonInstitution
                    PersonInstitution personInstitution;
                    Institution institution;
                    Set institutionSet = new HashSet();
                    if (institutionArray.length > 0 ) {
                        for (Long institutionId: institutionArray) {
                            institution = (Institution)em.find(Institution.class,institutionId);
                            personInstitution = new PersonInstitution(institution.getId(),this.person.getId());
                            institutionSet.add(personInstitution);
                        }
                        this.person.setPersonInstitutionSet(institutionSet);            
                    }
                    
                    // Save changes
                    em.persist(this.person);
                    return true;                
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                    return false;
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexi�n con la base de datos fu� cerrada.");
                    return false;
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad v�lida.");
                    return false;
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                    return false;
                }
            } else {
                //setMessage("Ya existe otra persona almacenada en el sistema con el mismo nombre y apellido. El registro no fu� creado.");
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fu� creado.");
            return false;
        }        
    }

    public boolean create(Person person) {
        this.person = person;
        return persist();
    }

    public boolean create(Person person, Long[] profileArray, Long[] institutionArray) {
        boolean persisted = false;
        this.person = person;
        persisted = persist();
        updateProfileList(profileArray);
        updateInstitutionList(institutionArray);
        return persisted;
    }
    
    private void updateProfileList(Long[] profileArray) {
        PersonProfile personProfile;
        Profile profile;
        //Set profileSet = new HashSet();
        if (profileArray.length > 0) {
            for (Long profileId: profileArray) {
                profile = (Profile)em.find(Profile.class,profileId);
                personProfile = new PersonProfile(profile.getId(),this.person.getId());
                personProfile.setCreatedBy(this.person.getCreatedBy());
                personProfile.setLastModificationBy(this.person.getLastModificationBy());
                //profileSet.add(personProfile);
                try {
                    em.persist(personProfile);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexi�n con la base de datos fu� cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad v�lida.");
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                }                        
            }
        }
    }
    
    private void updateInstitutionList(Long[] institutionArray) {
        PersonInstitution personInstitution;
        Institution institution;
        //Set institutionSet = new HashSet();
        if (institutionArray.length > 0 ) {
            for (Long institutionId: institutionArray) {
                institution = (Institution)em.find(Institution.class,institutionId);
                personInstitution = new PersonInstitution(institution.getId(),this.person.getId());
                personInstitution.setCreatedBy(this.person.getCreatedBy());
                personInstitution.setLastModificationBy(this.person.getLastModificationBy());
                try {
                    em.persist(personInstitution);
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexi�n con la base de datos fu� cerrada.");
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad v�lida.");
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                }   
            }        
        }
    }
    
    public Person getPerson() {
        return this.person;
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.person = em.find(Person.class,id);
            if (this.canDeletePerson(this.person)) {
                this.person = em.merge(this.person);
                em.remove(this.person);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }

    public boolean update(Person tPerson) {
        boolean updated = false;
        if (!isPersonNull(tPerson)){
            if (this.isPersonUnique(tPerson)) {
                try {
                    this.person = tPerson;
                    this.person = em.merge(this.person);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.person.getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
                    updated = false;
                }
            } else {
                //setMessage("Ya existe otra persona almacenada en el sistema con el mismo nombre y apellido. El registro no fu� modificado.");
                updated = false;
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no fu� creado.");
        }
        return updated;     
    }

    public boolean update(Person tPerson, Long[] profileArray, Long[] institutionArray) {
        boolean updated = false;
        updated = this.update(tPerson);
        if (updated) {
            if ((profileArray.length > 0 ) | (profileArray != null)) {
                updateProfileList(profileArray);
            }
            if ((institutionArray.length > 0 ) | (institutionArray != null)) {
                updateInstitutionList(institutionArray);
            }            
        }
        return updated;
    }

    public void deleteInstitutions(Long id) {
        PersonInstitution institution;
        Query q;
        List<PersonInstitution> list;
        q = em.createQuery("Select Object(o) from PersonInstitution as o where o.personInstitutionPK.personId = " + id);
        list = q.getResultList();
        
        for (PersonInstitution personInstitution: list) {
            try {
                institution = em.find(PersonInstitution.class,personInstitution.getPersonProfilePK());
                institution = em.merge(personInstitution);
                em.remove(personInstitution);
            } catch (Exception e) {
                this.setMessage(e.getLocalizedMessage());
                System.out.println(this.toString() + ":deleteInstitutions. Error: " + this.getMessage());
            } catch (Throwable ex) {
                this.setMessage(this.toString() + ":deleteInstitutions. Error: " + ex.getLocalizedMessage());
                System.out.println(this.getMessage());
            }
        }
    }
    
    public void deleteProfiles(Long id) {
        PersonProfile profile;
        Query q;
        List<PersonProfile> list;
        q = em.createQuery("Select Object(o) from PersonProfile as o where o.personProfilePK.personId = " + id);
        list = q.getResultList();
        
        for (PersonProfile personProfile: list) {
            try {
                profile = em.find(PersonProfile.class,personProfile.getPersonProfilePK());
                profile = em.merge(personProfile);
                em.remove(profile);
            } catch (Exception e) {
                this.setMessage(e.getLocalizedMessage());
                System.out.println(this.toString() + ":deleteProfiles. Error: " + this.getMessage());
            } catch (Throwable ex) {
                this.setMessage(this.toString() + ":deleteProfiles. Error: " + ex.getLocalizedMessage());
                System.out.println(this.getMessage());
            }
        }        
    }
    
    public List findAll() {
        Query q = em.createQuery("Select object(o) from Person as o");
        this.personList = (List)q.getResultList();
        return this.personList;
    }
    
    public List finAll(int StartPosition, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from Person as o";
        if (sortCriteria!=null) {
            hql += " order by ";
            for (index =0; index < sortCriteria.length; index++) {
                if (index > 0) {
                    hql += ", ";
                }
                hql += "o." + sortCriteria[index];
            }
            if(!sortCriteria[0].isAscending()){
                hql += " desc";
            }
        }
        q = em.createQuery(hql);
        q.setMaxResults(maxResults);
        q.setFirstResult(StartPosition);
        return q.getResultList();
    }
    
    public List getTaxonDescriptionAuthorList() {
        String hql;
        int index;
        Query q;
        
        hql = "Select o.id, o.name from Person as o where o.personProfile.personProfilePk.profileId = 14 order by o.name";
        q = em.createQuery(hql);
        return q.getResultList();
    }
    
    /**
     * This method verifies if the new/modified person record is unique. 
     * A person record is unique if their first name and last name is not previously 
     * registred in the database.
     * @return TRUE if the new/modified person is not previously registred, otherwise 
     * return FALSE.
     */
    private boolean isPersonUnique(Person tPerson) {
        boolean isUnique = true;
        String tmpFirstName, tmpLastName, sql;
        Long tmpId;
        
        tmpFirstName = tPerson.getFirstName();
        tmpLastName = tPerson.getLastName();
        sql = "SELECT object(o) FROM Person as o ";
        sql = sql + "where trim(lower(o.firstName)) = trim(lower('" + tmpFirstName +"')) and trim(lower(o.lastName)) = trim(lower('" + tmpLastName + "')) ";
        if (tPerson.getId()!=null) {
            sql = sql + " and o.id <> " + tPerson.getId();
        }
        System.out.println(sql);
        
        if (em.createQuery(sql).getResultList().size() > 0) {
            Person duplicate = (Person)em.createQuery(sql).getSingleResult();
            setMessage("Ya existe otra persona almacenada en el sistema con el mismo nombre y apellido (id=" + duplicate.getId() + "). El registro no fu� creado.");
            isUnique = false;
        }
        return isUnique;
    }
    
    
    /**
     * Checks if the current person record can be safely deleted.
     * A person record can only be deleted if its not referenced by the following 
     * entities:<BR>
     * <<B>PersonProfile</B>,<BR>
     * <B>PersonInstitution</B>,<BR>
     * <B>TaxonAuthor</B>,<BR>
     * <B>TaxonDescriptionPerson</B>,<BR>
     * <B>SpeciesRecordPerson</B>.<BR>
     * @return TRUE if the record can be safely deleted, otherwise return FALSE.
     */
    private boolean canDeletePerson(Person tPerson) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!tPerson.getPersonProfileSet().isEmpty()) {
            canDelete = false;
             //errorMessage = "El registro No. " + this.person.getId() +  " tiene perfiles asociados.";
            errorMessage = "perfiles";
        }
        
        if (!tPerson.getPersonInstitutionSet().isEmpty()) {
            canDelete = false;
            //errorMessage += "El registro No. " + this.person.getId() +  " est� asociado al menos a una instituci�n.";                            
            if (errorMessage.equals("")) {
                errorMessage = "instituciones";
            } else {
                errorMessage += ", instituciones";
            }
        }
        
        if (this.personHasTaxonDescription(person)) {
            canDelete = false;
            if (errorMessage.equals("")) {
                errorMessage = "registros de especies";
            } else {
                errorMessage += ", registros de especies";
            }
        }
        
        
        if (!canDelete) errorMessage = "El registro no fu� borrado pues est� asociado a las siguientes entidades: " + errorMessage + ".";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    private boolean personHasTaxonDescription(Person tPerson) {
        try {
            Query q = em.createQuery("Select object(o) from TaxonDescriptionPersonProfile as o where o.taxonDescriptionPersonProfilePK.authorPersonId  = " + tPerson.getId());
            if (q.getResultList().size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            return true;
        } catch (Throwable ex) {
            this.setMessage(ex.getLocalizedMessage());
            return true;
        }
    }
    
    private boolean isPersonNull(Person person){
        boolean isNull = false;
        String msg = "";
        if ((person.getFirstName() == null) || (person.getFirstName().equals(""))){
            isNull = true;
            msg = "Nombre";
        }
        if ((person.getLastName() == null) || (person.getLastName().equals(""))){
            isNull = true;
            if (msg.equals("")) {
                msg = "Primer Apellido";
            } else {
                msg += ", Primer Apellido";
            }
        }
        if (isNull) {
            msg = "Los siguientes campos son obligatorios: " + msg + ".";
            this.setMessage(msg);
        }
        return isNull;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println(message);
        this.message = message;
    }

    public List getSelectedProfiles(Long personId) {
        try {
            Query q = em.createQuery("Select object(o) from Profile as o, PersonProfile as u where o.id = u.personProfilePK.profileId and u.personProfilePK.personId = " + personId);
            return q.getResultList();            
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            System.out.println(e.getMessage());
            return null;
        } catch (Throwable ex) {
            this.setMessage(ex.getLocalizedMessage());
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List getSelectedInstitutions(Long personId) {
        try {
            Query q = em.createQuery("Select object(o) from Institution as o, PersonInstitution u where o.id = u.personInstitutionPK.institutionId and u.personInstitutionPK.personId = " + personId);
            return q.getResultList();            
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            return null;
        } catch (Throwable ex) {
            this.setMessage(ex.getLocalizedMessage());
            return null;
        }
    }
}
