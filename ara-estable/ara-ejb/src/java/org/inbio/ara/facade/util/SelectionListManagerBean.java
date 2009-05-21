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
 * SelectionListManagerBean.java
 *
 * Created on January 21, 2008, 3:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.util;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.sun.webui.jsf.model.Option;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Table;
import org.inbio.ara.dto.SelectionListEntity;
import org.inbio.ara.eao.CollectionLocalEAO;
import org.inbio.ara.eao.SelectionListLocalEAO;
import org.inbio.ara.eao.SelectionListValueCollectionLocalEAO;
import org.inbio.ara.eao.SelectionListValueLocalEAO;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.collection.ListTable;
import org.inbio.ara.persistence.collection.ListTableCollection;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.gathering.Exposition;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;
import org.inbio.ara.persistence.gathering.Project;
import org.inbio.ara.persistence.gis.FeatureType;
import org.inbio.ara.persistence.gis.Projection;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.reference.ReferenceType;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonInstitution;
import org.inbio.ara.persistence.person.PersonProfile;
import org.inbio.ara.persistence.person.Profile;
import org.inbio.ara.persistence.reference.Reference;
import org.inbio.ara.persistence.reference.TaxonDescriptionRecordReference;
import org.inbio.ara.persistence.security.UserNomenclaturalGroup;
import org.inbio.ara.persistence.security.UserTaxon;
import org.inbio.ara.persistence.selectionListEntity;
import org.inbio.ara.persistence.species.Audience;
import org.inbio.ara.persistence.species.StageTransitionDate;
import org.inbio.ara.persistence.species.TaxonDescriptionAudience;
import org.inbio.ara.persistence.species.TaxonDescriptionInstitution;
import org.inbio.ara.persistence.species.TaxonDescriptionPersonProfile;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.IdentificationStatus;
import org.inbio.ara.persistence.specimen.IdentificationType;
import org.inbio.ara.persistence.specimen.LifeForm;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;
import org.inbio.ara.persistence.specimen.TypeSpecimenType;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Region;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;
import org.inbio.ara.persistence.util.Language;
import org.inbio.ara.taxon.service.TaxonServiceRemote;


/**
 *
 * @author roaguilar
 */
@Stateless
public class SelectionListManagerBean implements SelectionListManagerRemote, SelectionListManagerLocal {


    //SelectionListEAO selectionListDAO = new SelectionListEAOImpl();
    //SelectionListValueEAO selectionListValueDAO = new SelectionListValueEAOImpl();

    @EJB
    private TaxonServiceRemote taxonServiceBean;

    @EJB
    private SelectionListLocalEAO selectionListEAO;

    @EJB
    private SelectionListValueLocalEAO selectionListValueEAO;

    @EJB
    private CollectionLocalEAO collectionEAO;

    @EJB
    private SelectionListValueCollectionLocalEAO selectionListValueCollectionEAO;

    @PersistenceContext
    private EntityManager em;

    private String message;

    /** Creates a new instance of SelectionListManagerBean */
    public SelectionListManagerBean() {
    }

    /**********/
    /**
     * Ejemplo de uso: getOptions(Substrate.class)
     * Author: hesquivel
     *
     * @params clazz Objeto de tipo java.lang.Class
     * @return Option[] Objetos option de jsf para llenar los dropDown
     *         null si no encuentra nada.
     */
    public <T extends selectionListEntity> Option[] getOptions(Class<T> clazz) {
        List<T> resultList = query("from " + clazz.getName() +" as o order by o.name");
        if (resultList.size() > 0) {
            Option[] optionArray = new Option[resultList.size()];
            int i = 0;
            for (T tmp : resultList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
            return optionArray;
        }
        return null;
    }
    /**********/


    public Option[] getSites() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Site as o order by o.name";
        List<Site> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Site tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getDescription());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getCollections() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Collection as o order by o.name";
        List<Collection> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Collection tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getGatheringResponsible() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 9 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getExposition() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Exposition as o order by o.name";
        List<Exposition> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Exposition tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getRegion() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Region as o order by o.name";
        List<Region> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Region tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getCollectors() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 13 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getNomenclaturalGroupCertificator() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 18 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getCollectorsByGatheringObservation(Long gatheringObservationId) {
        Option[] optionArray = new Option[]{};
        //String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 13 order by o.lastName, o.firstName";
        String query = "Select object(o) from Person as o, CollectorObserver as p where o.id = p.collectorPK.personId and p.collectorPK.gatheringObservationId = " + gatheringObservationId + " order by o.lastName, o.firstName";
        List<Person> tList = query(query);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getDescriptors() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 15 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getProjects() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Project as o order by o.description";
        List<Project> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Project tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getDescription());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getProjection() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Projection as o order by o.name";
        List<Projection> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Projection tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getSiteCalculationMethod() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from SiteCalculationMethod as o order by o.name";
        List<SiteCalculationMethod> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (SiteCalculationMethod tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getInstitution() {
        Option[] optionArray = new Option[]{};
        List<Institution> tList = query("Select object(o) from Institution as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            // optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 0;
            for (Institution tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getProfile() {
        Option[] optionArray = new Option[]{};
        List<Profile> tList = query("Select object(o) from Profile as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Profile tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getFeatureType() {
        Option[] optionArray = new Option[]{};
        List<FeatureType> tList = query("Select object(o) from FeatureType as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (FeatureType tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getAllGatheringObservationMethod() {
        Option[] optionArray = new Option[]{};
        List<FeatureType> tList = query("Select object(o) from GatheringObservationMethod as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (FeatureType tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getAudience() {
        Option[] optionArray = new Option[]{};
        List<Audience> tList = query("Select object(o) from Audience as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Audience tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getTypeSpecimenType() {
        Option[] optionArray = new Option[]{};
        List<TypeSpecimenType> tList = query("Select object(o) from TypeSpecimenType as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (TypeSpecimenType tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getIdentificationStatus() {
        Option[] optionArray = new Option[]{};
        List<IdentificationStatus> tList = query("Select object(o) from IdentificationStatus as o order by o.name");
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (IdentificationStatus tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public IdentificationStatus getIdentificationStatus(Long identificationStatusId) {
        return em.find(IdentificationStatus.class,identificationStatusId);
    }

    public IdentificationType getIdentificationTypeById(Long identificationTypeId) {
        return em.find(IdentificationType.class,identificationTypeId);
    }

    public Long[] getSelectedCollectors(Long gatheringObservationId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from CollectorObserver as o where o.collectorPK.gatheringObservationId=" + gatheringObservationId;
        List<CollectorObserver> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (CollectorObserver tmp: tList) {
                selectedArray[i] = tmp.getCollectorPK().getPersonId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSelectedCollections(Long gatheringObservationId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from GatheringObservationCollection as o where o.gatheringObservationCollectionPK.gatheringObservationId=" + gatheringObservationId;
        List<GatheringObservationCollection> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (GatheringObservationCollection tmp: tList) {
                selectedArray[i] = tmp.getGatheringObservationCollectionPK().getCollectionId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSelectedProjects(Long gatheringObservationId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from GatheringObservationProject as o where o.gatheringObservationProjectPK.gatheringObservationId=" + gatheringObservationId;
        List<GatheringObservationProject> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (GatheringObservationProject tmp: tList) {
                selectedArray[i] = tmp.getGatheringObservationProjectPK().getProjectId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSelectedAudience(TaxonDescriptionPK pk) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from TaxonDescriptionAudience as o ";
        hql += "where o.taxonDescriptionAudiencePK.taxonId = " + pk.getTaxonId() + "and ";
        hql += "o.taxonDescriptionAudiencePK.taxonDescriptionSequence = " + pk.getTaxonDescriptionSequence();
        List<TaxonDescriptionAudience> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionAudience tmp: tList) {
                selectedArray[i] = tmp.getTaxonDescriptionAudiencePK().getAudienceId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSelectedUserTaxon(Long userId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from UserTaxon as o ";
        hql += "where o.userTaxonPK.userId = " + userId;
        List<UserTaxon> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (UserTaxon tmp: tList) {
                selectedArray[i] = tmp.getUserTaxonPK().getTaxonId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSelectedUserNomenclaturalGroup(Long userId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from UserNomenclaturalGroup as o ";
        hql += "where o.userNomenclaturalGroupPK.userId = " + userId;
        List<UserNomenclaturalGroup> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (UserNomenclaturalGroup tmp: tList) {
                selectedArray[i] = tmp.getUserNomenclaturalGroupPK().getNomenclaturalGroupId();
                i++;
            }
        }
        return selectedArray;
    }

    public Option[] getSpeciesAuthor() {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from Person as o, PersonProfile as p ";
        hql +="where o.id = p.personProfilePK.personId and ";
        hql +="p.personProfilePK.profileId = " + 14;
        hql += " order by o.lastName, o.secondLastName, o.firstName";
        List<Person> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalFullName());
                i++;
            }
        }
        return optionArray;
    }

    public Long[] getPersonProfile(Long personId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from PersonProfile as o ";
        hql += "where o.personProfilePK.personId= " + personId;
        List<PersonProfile> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (PersonProfile tmp: tList) {
                selectedArray[i] = tmp.getPersonProfilePK().getProfileId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getPersonInstitution(Long personId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from PersonInstitution as o ";
        hql += "where o.personInstitutionPK.personId= " + personId;
        List<PersonInstitution> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (PersonInstitution tmp: tList) {
                selectedArray[i] = tmp.getPersonProfilePK().getInstitutionId();
                i++;
            }
        }
        return selectedArray;
    }

    public Long[] getSpeciesAuthor(TaxonDescriptionPK pk) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from TaxonDescriptionPersonProfile as o ";
        hql += "where o.taxonDescriptionPersonProfilePK.taxonId = " + pk.getTaxonId() + " and ";
        hql += "o.taxonDescriptionPersonProfilePK.taxonDescriptionSequence = " + pk.getTaxonDescriptionSequence();
        List<TaxonDescriptionPersonProfile> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionPersonProfile tmp: tList) {
                selectedArray[i] = tmp.getTaxonDescriptionPersonProfilePK().getAuthorPersonId();
                i++;
            }
        }
        return selectedArray;
    }

    public Option[] getSpeciesInstitution() {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from Institution as o";
        hql += " order by o.name";
        List<Institution> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Institution tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName() + " (" + tmp.getAcronym() + ")");
                i++;
            }
        }
        return optionArray;
    }

    public Long[] getSpeciesInstitution(TaxonDescriptionPK pk) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from TaxonDescriptionInstitution as o ";
        hql += "where o.taxonDescriptionInstitutionPK.taxonId = " + pk.getTaxonId() + " and ";
        hql += "o.taxonDescriptionInstitutionPK.taxonDescriptionSequence = " + pk.getTaxonDescriptionSequence();
        List<TaxonDescriptionInstitution> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionInstitution tmp: tList) {
                selectedArray[i] = tmp.getSpeciesRecordInstitutionPK().getInstitutionId();
                i++;
            }
        }
        return selectedArray;
    }

    public Option[] getSpeciesStages(TaxonDescriptionPK pk) {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from StageTransitionDate as o ";
        hql += "where o.stageTransitionDatePK.taxonId = " + pk.getTaxonId() + " and ";
        hql += "o.stageTransitionDatePK.taxonDescriptionSequence = " + pk.getTaxonDescriptionSequence();
        hql += " order by o.stageTransitionDatePK.transitionDate";
        List<StageTransitionDate> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (StageTransitionDate tmp: tList) {
                optionArray[i] = new Option(tmp.getStage().getId(), tmp.getStageName() + " en " + tmp.getStageTransitionDatePK().getTransitionDate());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getAvailableStages(Long stageId) {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from TaxonDescriptionStage as o, StageTransitionDigraph as p ";
        hql += "where o.id = p.stageTransitionDigraphPK.speciesRecordStageToId and ";
        hql += "p.stageTransitionDigraphPK.speciesRecordStageFromId = " + stageId;
        hql += " order by o.name";
        List<TaxonDescriptionStage> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L,"Seleccione un valor");
            int i = 1;
            for (TaxonDescriptionStage tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-2L,"No hay estados disponibles");
        }
        return optionArray;
    }

    public Option[] getLanguage() {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from Language as o";
        List<Language> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L,"Seleccione un valor");
            int i = 1;
            for (Language tmp: tList) {
                optionArray[i] = new Option(tmp.getLanguageId(), tmp.getLanguageName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getReference() {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from Reference as o";
        List<Reference> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Reference tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getTitle());
                i++;
            }
        }
        return optionArray;
    }

    public Long[] getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        hql = "Select object(o) from TaxonDescriptionRecordReference as o ";
        hql += "where o.taxonDescriptionReferencePK.taxonDescriptionRecordId= " + taxonDescriptionRecordId;
        List<TaxonDescriptionRecordReference> tList = query(hql);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionRecordReference tmp: tList) {
                selectedArray[i] = tmp.getTaxonDescriptionReferencePK().getReferenceId();
                i++;
            }
        }
        return selectedArray;
    }

    public Option[] getReferenceType() {
        Option[] optionArray = new Option[]{};
        String hql;

        hql = "Select object(o) from ReferenceType as o order by o.name";
        List<ReferenceType> tList = query(hql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            int i = 1;
            optionArray[0] = new Option("0", "Seleccione un valor");
            for (ReferenceType tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getTaxonHierarchy(Long taxonId) {
        Option[] optionArray = new Option[]{};
        String hql;

        List<Taxon> tList = this.taxonServiceBean.getTaxonHierarchy(taxonId);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Taxon tmp: tList) {
                optionArray[i] = new Option(tmp.getTaxonId(), tmp.getDefaultName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getSpecies() {
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;
        //SQLQuery q;

        sql = "select taxon_id, default_name from ara.taxon where (taxonomical_range_id >=18 and taxonomical_range_id <=22) and taxon_category_id = 1 order by default_name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                System.out.println(tmpId + " " + taxonId + " " + defaultName);
                optionArray[i] = new Option(taxonId, defaultName);
            }

        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay datos que mostrar");
        }
        return optionArray;
    }

    public Option[] getTaxons() {
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;
        //SQLQuery q;

        sql = "select taxon_id, default_name from ara.taxon where taxon_category_id = 1 order by default_name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                optionArray[i] = new Option(taxonId, defaultName);
            }

        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay datos que mostrar");
        }
        return optionArray;
    }

    public Option[] getTaxonsByCollection(Long collectionId) {
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;
        //SQLQuery q;

        sql = "select taxon_id, default_name from ara.taxon where collection_id = " + collectionId + " order by default_name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                optionArray[i] = new Option(taxonId, defaultName);
            }

        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay datos que mostrar");
        }
        return optionArray;
    }

    public Option[] getNomenclaturalGroups() {
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;
        //SQLQuery q;

        sql = "select nomenclatural_group_id, name from ara.nomenclatural_group order by name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                optionArray[i] = new Option(taxonId, defaultName);
            }

        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay datos que mostrar");
        }
        return optionArray;
    }

    public Option[] getUserTaxonList(Long userId){
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;

        sql = "select t.taxon_id, t.default_name ";
        sql += "from ara.taxon as t, ara.user_taxon as ut ";
        sql += "where t.taxon_id = ut.taxon_id and ut.user_id = " + userId;
        sql += " order by t.default_name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                optionArray[i] = new Option(taxonId, defaultName);
            }
        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay taxones asignados.");
        }
        return optionArray;
    }

    public Option[] getNomenclaturalGroupList(Long userId){
        Option[] optionArray = new Option[]{};
        String sql;
        Query q;

        sql = "select t.nomenclatural_group_id, t.name ";
        sql += "from ara.nomenclatural_group as t, ara.user_nomenclatural_group as ut ";
        sql += "where t.nomenclatural_group_id = ut.nomenclatural_group_id and ut.user_id = " + userId;
        sql += " order by t.name";

        q = em.createNativeQuery(sql);
        List speciesList = q.getResultList();

        if (speciesList.size() > 0) {
            optionArray = new Option[speciesList.size()];
            for (int i = 0; i < speciesList.size(); i++) {
                Object[] o = (Object[]) (speciesList.get(i));
                String tmpId = o[0].toString();
                Long taxonId = Long.parseLong(tmpId);
                String defaultName = (String)o[1];
                optionArray[i] = new Option(taxonId, defaultName);
            }
        } else {
            optionArray = new Option[1];
            optionArray[0] = new Option(-1L, "No hay grupos asignados.");
        }
        return optionArray;
    }

    public Collection getCollectionByTaxonId(Long taxonId) {
        Query q;
        try {
            q = em.createQuery("select object(o) from Taxon as o where o.id = " + taxonId);
            Taxon t = (Taxon)q.getSingleResult();
            return t.getCollection();
        } catch (IllegalStateException ex1) {
            this.setMessage("IllegalStateException: " + ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage("IllegalArgumentException: " + ex2.getMessage());
            return null;
        }
    }

    public Collection getCollectionByNomenclaturalGroupId(Long nomenclaturalGroupId) {
        Query q;
        try {
            q = em.createQuery("select object(o) from NomenclaturalGroup as o where o.id = " + nomenclaturalGroupId);
            NomenclaturalGroup t = (NomenclaturalGroup)q.getSingleResult();
            return t.getCollection();
        } catch (IllegalStateException ex1) {
            this.setMessage("IllegalStateException: " + ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage("IllegalArgumentException: " + ex2.getMessage());
            return null;
        }
    }

    /*
     * Listas de Selección filtradas por colección
     *
     */

    /**
     * hesquivel
     * Retorna un arreglo que contiene solamente las opciones que se deben
     * mostrar segun el <b>protocolo de coleccion.</b>
     * Ej. de uso: getOptionsByCollection(SpecimenType.class, 1L)
     *
     * @param clazz Clase (java.lang.Class) de objetos de los cuales se desea
     *        obtener las opciones disponibles.
     * @param collectionId Numero que identifica la coleccion sobre la cual se
     *        esta trabajando
     * @return Object[] Opciones que se le pasan a los
     *         componentes graficos de JSF para que los muestre (comunmente
     *         DropDowns).
     */
    public <T extends selectionListEntity> Option[]
                    getOptionsByCollection(Class<T> clazz, Long collectionId) {
        Option[] optionArray;
        ArrayList<Option> dynamicOptionArray = new ArrayList<Option>();

        String generalQuery = "from ListTableCollection as o where o.collection.id = " +
                                collectionId + " and listTable.id = " +
                                this.getListTableId(clazz);
        List<ListTableCollection> listTableCollections = query(generalQuery);
        if(listTableCollections.isEmpty()){
            dynamicOptionArray.add(new Option(-1L, "no_data"));
            optionArray = new Option[1];
            return dynamicOptionArray.toArray(optionArray);
        }
        dynamicOptionArray.add(new Option(0L, ""));

        for(int i = 0; i < listTableCollections.size(); i++) {
            ListTableCollection LTC = listTableCollections.get(i);
            String specificQuery = "from " + clazz.getName() +" as o where " +
                    "o.id = " + LTC.getListTableCollectionPK().getvalueId();
            Query q;
            try{
                q = em.createQuery(specificQuery);
                Object object = q.getSingleResult();
                if(object != null){
                    T entityObject = (T)object;
                    dynamicOptionArray.add(new Option(entityObject.getId(),
                                                entityObject.getName()));
                }
            } catch (IllegalStateException e) {
                //System.err.println(e);
            } catch (NoResultException e1){
                System.err.println("No se encontro tabla.");
                System.err.println(specificQuery);
            } catch (NonUniqueResultException e2) {
                //System.err.println(e2);
            }
        }
        optionArray = new Option[dynamicOptionArray.size()];
        return dynamicOptionArray.toArray(optionArray);
    }

    /**
     * hesquivel
     * Este metodo retorna el id asignado a una tabla segun otra tabla llamada
     * list_table, como parte del protocolo de coleccion.
     * Ej. de uso: getListTableId(SpecimenType.class) retorna 1
     * |                            list_table                               |
     * |  list_table_id            |           name                          |
     * |         1                 |       specimen_type                     |
     * |         2                 |       preservation_medium               |
     * |        ...                |       ...                               |
     *
     * @param clazz clase (java.lang.Class) entity de la cual se desea obtener
     *        el id
     * @return long Id de la clase consultada.
     *         -1 si no la encontro.
     */
    private <T extends selectionListEntity> Long getListTableId(Class<T> clazz){
        Table t;
        t = clazz.getAnnotation(Table.class);
        if(t != null) {
            String entityName = t.name();
            String jpql = "from ListTable as o where o.name = '" +
                                                            entityName+"'";
            Query q;
            try{
                q = em.createQuery(jpql);
                ListTable listTable = (ListTable)q.getSingleResult();
                return listTable.getId();
            } catch (IllegalStateException e) {
                System.out.println(jpql);
                System.err.println(e);
            } catch (NoResultException e1){
                System.out.println(jpql);
                System.err.println(e1);
            } catch (NonUniqueResultException e2) {
                System.out.println(jpql);
                System.err.println(e2);
            }
        }
        return -1L;
    }



    public Option[] getLifeForm(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "life_form",false);
    }

    public Option[] getPreservationMedium(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "preservation_medium",true);
    }

    public Option[] getSpecimenType(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "specimen_type",true);
    }

    public Option[] getSubstrate(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "substrate",true);
    }

    public Option[] getOrigin(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "origin",true);
    }

    public Option[] getStorageType(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "storage_type",true);
    }

    public Option[] getGatheringObservationMethod(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "gathering_observation_method",true);
    }

    public Option[] getLifeStage(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "life_stage",true);
    }

    public Option[] getTypeSpecimenType(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "type_specimen_type",true);
    }

    public Option[] getExtractionType(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "extraction_type",true);
    }

    public Option[] getSex(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "sex",true);
    }

    public Option[] getCultureMedium(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "culture_medium",true);
    }

    public Option[] getSpecimenCategory(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "specimen_category",true);
    }

    public Option[] getComponentPart(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "component_part",true);
    }

    public Option[] getPreparationMethod(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "preparation_method",true);
    }

    public Option[] getTaxonAuthorConnector(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "taxon_author_connector",true);
    }

    public Option[] getSamplingType(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "sampling_type",true);
    }

    public Option[] getCultureStorageMedium(Long collectionId){
        return this.getSelectionListOptionArray(collectionId, "culture_storage_medium",true);
    }

    public FeatureType getFeatureTypeById(Long id){
        return em.find(FeatureType.class,id);
    }

    public Option[] getTaxonomicalRange() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from TaxonomicalRange as o order by o.taxonomicalHierarchyLevel";
        List<TaxonomicalRange> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (TaxonomicalRange tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getTaxonCategory() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from TaxonCategory as o order by o.name";
        List<TaxonCategory> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (TaxonCategory tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }

    /*
    public Option[] getIdentificationStatus() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from IdentificationStatus as o order by o.name";
        List<IdentificationStatus> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (IdentificationStatus tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getName());
                i++;
            }
        }
        return optionArray;
    }*/

    public Option[] getIdentificationType(Long collectionId) {
        return this.getSelectionListOptionArray(collectionId, "identification_type",true);
    }

    public Option[] getIdentificationValidator() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 16 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()+1];
            optionArray[0] = new Option(-1L, "Seleccione un valor");
            int i = 1;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    public Option[] getIdentifiers() {
        Option[] optionArray = new Option[]{};
        String jpql = "Select object(o) from Person as o, PersonProfile as p where o.id = p.personProfilePK.personId and p.personProfilePK.profileId = 17 order by o.lastName, o.firstName";
        List<Person> tList = query(jpql);
        if (tList.size() > 0) {
            optionArray = new Option[tList.size()];
            int i = 0;
            for (Person tmp: tList) {
                optionArray[i] = new Option(tmp.getId(), tmp.getFormalLongName());
                i++;
            }
        }
        return optionArray;
    }

    private Option[] getSelectionListOptionArray(Long collectionId, String tableName, boolean addEmptyElement) {
        Option[] optionArray = new Option[]{};

        Object[] parms = this.getListTableInfo(tableName);
        if (parms != null) {
            //Long listTableId = (Long)parms[0];
            BigDecimal listTableId = (BigDecimal)parms[0];
            String keyFieldName = (String)parms[1];

            List tList = this.getSelectionList(listTableId, tableName, keyFieldName, collectionId);
            if (tList.size() > 0) {
                int size, pos;
                if (addEmptyElement) {
                    size = tList.size()+1;
                } else {
                    size = tList.size();
                }
                optionArray = new Option[size];
                optionArray[0] = new Option(-1L, "Seleccione un valor");
                for (int i = 0; i < tList.size(); i++) {
                    Object[] o = (Object[]) (tList.get(i));
                    String tmpId = o[0].toString();
                    Long id = Long.parseLong(tmpId);
                    String name = (String)o[1];
                    if (addEmptyElement) {
                        pos = i + 1;
                    } else {
                        pos = i;
                    }
                    optionArray[pos] = new Option(id, name);
                }
            } else {
                optionArray = new Option[1];
                optionArray[0] = new Option(-1L, "No hay datos.");
            }
        }
        return optionArray;
    }

    private List getSelectionList(BigDecimal listTableId, String tableName, String keyFieldName, Long collectionId) {
        String sql;
        Query q;

        sql = "select t." + keyFieldName + ", t.name from ara." + tableName + " as t, ara.list_table_collection as t2 ";
        sql += "where t2.list_table_id = " + listTableId + " and ";
        sql += "t2.collection_id = " + collectionId + " and ";
        sql += "t2.value_id = t." + keyFieldName;
        sql += " order by t.name";
        q = em.createNativeQuery(sql);
        return q.getResultList();
    }

    private Object[] getListTableInfo(String tableName) {
        String sql;
        Query q;

        sql = "select t.list_table_id, t.key_field_name from ara.list_table as t where t.name = '" + tableName + "'";
        q = em.createNativeQuery(sql);
        try {
            return (Object[])q.getSingleResult();
        } catch (NoResultException ex1) {
            this.setMessage("No se encontr� ning�n registro coincidente: " + tableName);
            return null;
        } catch (NonUniqueResultException ex2) {
            this.setMessage("La consulta retornó más de un resultado.");
            return null;
        } catch (IllegalStateException ex3) {
            this.setMessage(ex3.getMessage());
            return null;
        }
    }

    private List query(String hql) {
        Query q;
        q = em.createQuery(hql);
        List tList = q.getResultList();
        return tList;
    }

    public Language getLanguage(Long id) {
        return (Language)this.getEntityById("Language","id",id);
    }

    public TaxonDescriptionStage getTaxonDescriptionStage(Long id) {
        return (TaxonDescriptionStage)this.getEntityById("TaxonDescriptionStage","id",id);
    }

    public ReferenceType getReferenceType(Long id) {
        return (ReferenceType)this.getEntityById("ReferenceType","id",id);
    }

    public Audience getAudience(Long id) {
        return (Audience)this.getEntityById("Audience","id",id);
    }

    public Person getPerson(Long id) {
        return (Person)this.getEntityById("Person","id",id);
    }
    public Institution getInstitution(Long id) {
        return (Institution)this.getEntityById("Institution","id",id);
    }

    public Taxon getTaxon(Long id) {
        return (Taxon)this.getEntityById("Taxon","id",id);
    }

    public Site getSite(Long id) {
        return (Site)this.getEntityById("Site","id",id);
    }

    public GatheringObservationMethod getGatheringObservationMethodbyId(Long id) {
        return (GatheringObservationMethod)this.getEntityById("GatheringObservationMethod","id",id);
    }

    public Exposition getExpositionById(Long id) {
        return (Exposition)this.getEntityById("Exposition","id",id);
    }

    public Projection getProjectionId(Long id) {
        return (Projection)this.getEntityById("Projection","id",id);
    }

    public SiteCalculationMethod getSiteCalculationMethodById(Long id) {
        return (SiteCalculationMethod)this.getEntityById("SiteCalculationMethod","id",id);
    }

    public ExtractionType getExtractionById(Long id) {
        return (ExtractionType)this.getEntityById("ExtractionType","id",id);
    }

    public Collection getCollection(Long id) {
        return (Collection)this.getEntityById("Collection","id",id);
    }

    public Project getProject(Long id) {
        return (Project)this.getEntityById("Project","id",id);
    }

    public LifeStage getLifeStageById(Long id) {
        return (LifeStage)this.getEntityById("LifeStage","id",id);
    }

    public Sex getSexById(Long id) {
        return (Sex)this.getEntityById("Sex","id",id);
    }

    public SpecimenCategory getSpecimenCategoryById(Long id) {
        return (SpecimenCategory)this.getEntityById("SpecimenCategory","id",id);
    }

    public SpecimenType getSpecimenTypeById(Long id) {
        return (SpecimenType)this.getEntityById("SpecimenType","id",id);
    }

    public StorageType getStorageTypeById(Long id) {
        return (StorageType)this.getEntityById("StorageType","id",id);
    }

    public TypeSpecimenType getTypeSpecimenTypeId(Long id) {
        return (TypeSpecimenType)this.getEntityById("TypeSpecimenType","id",id);
    }

    public Substrate getSubstrateById(Long id) {
        return (Substrate)this.getEntityById("Substrate","id",id);
    }

    public Origin getOriginById(Long id) {
        return (Origin)this.getEntityById("Origin","id",id);
    }

    public PreservationMedium getPreservationMediumById(Long id) {
        return (PreservationMedium)this.getEntityById("PreservationMedium","id",id);
    }

    public LifeForm getLifeFormById(Long id) {
        return (LifeForm)this.getEntityById("LifeForm","id",id);
    }

    public NomenclaturalGroup getNomenclaturalGroupById(Long id) {
        return (NomenclaturalGroup)this.getEntityById("NomenclaturalGroup","id",id);
    }

    private Object getEntityById(String entityName, String pkName, Long id) {
        Query q;
        try {
            q = em.createQuery("select object(o) from " + entityName + " as o where o." + pkName + "=" + id);
            return q.getSingleResult();
        } catch (IllegalStateException ex1) {
            this.setMessage("IllegalStateException: " + ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage("IllegalArgumentException: " + ex2.getMessage());
            return null;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.flush();
        System.out.println(message);
    }

    private String getTaxonomicalRangeFieldName(Long taxonomicalRangeId) {
        String sql;
        Query q;
        List tList;
        String fieldName;

        sql = "select field_name from ara.taxonomical_range where taxonomical_range_id = " + taxonomicalRangeId;
        q = em.createNativeQuery(sql);
        tList = q.getResultList();
        if (tList.size() > 0) {
            fieldName = (String)tList.get(0);
            return fieldName;
        } else {
            this.setMessage("No se encontr� nivel taxon�mico " + taxonomicalRangeId);
            return null;
        }
    }

    public Option[] getFilteredTaxonList(Long taxonomicalRangeId, Long taxonCategoryId, Long ancestorId, Long ancestorTaxonomicalRangeId) {
        String fieldName;
        String sql;
        Option[] optionArray = new Option[]{};

        fieldName = this.getTaxonomicalRangeFieldName(ancestorTaxonomicalRangeId);
        if (fieldName != null) {
            if (ancestorTaxonomicalRangeId.equals(taxonomicalRangeId)) {
                sql = "select taxon_id, default_name from ara.taxon where taxon_id = " + ancestorId;
            } else {
                sql = "select taxon_id, default_name from ara.taxon ";
                sql += "where taxonomical_range_id = " + taxonomicalRangeId + " and ";
                sql += "taxon_category_id = " + taxonCategoryId + " and ";
                sql += fieldName + "_taxon_id =" + ancestorId + " ";
                sql += "order by default_name";
            }
            List tList = em.createNativeQuery(sql).getResultList();
            if (tList.size() > 0) {
                optionArray = new Option[tList.size()];
                for (int i = 0; i < tList.size(); i++) {
                    Object[] o = (Object[]) (tList.get(i));
                    String tmpId = o[0].toString();
                    Long id = Long.parseLong(tmpId);
                    String name = (String)o[1];
                    optionArray[i] = new Option(id, name);
                }
            } else {
                optionArray = new Option[1];
                optionArray[0] = new Option(-1L, "No hay taxones.");
            }
        }
        return optionArray;
    }




    /**
     * listo
     *
     * Get all the selection lists available in the system
     *
     * @return
     */
    public List<ListTable> listAllSelectionLists(){

        return this.selectionListEAO.getAllSelectionLists();


    }


   /**
     * listo
     *
     * @param selectionListId the id of an ListTable entity
     * @return
     */
    public List<selectionListEntity> getAllSelectionListValues(Long selectionListId){
        return this.selectionListValueEAO.getAllSelectionListValues(selectionListId);
    }

    
    /**
     *
     * listo!
     * 
     * @param selectionListId
     * @param selectionListValueId
     * @param collectionsId
     */
    public void updateCollectionsBySelectionListValue(Long selectionListId, Long selectionListValueId, List<Long> collectionsId){

        /*Toma la lista de de las colecciones que *actualmente* estan asociadas (oldAssociatedCollections) y la lista de las que
         * deben estar asociadas (collectionsId). Primero elimina de ambas listas las que esten incluidas en ambas. Luego
         * elimina de la BD las que esten en 'oldAssociatedCollections' porque ya no son asociaciones y por último inserta las
         * nuevas asociaciones (collectionsId)
         */
        List<Collection> oldAssociatedCollections = this.collectionEAO.getCollectionsBySelectionListValue(selectionListId, selectionListValueId);
        List<Collection> tobeDeleted = new ArrayList<Collection>();


        //elimina de la lista los que ya estan asociados
        for(Collection old : oldAssociatedCollections){
            if(collectionsId.contains(old.getId())){
                collectionsId.remove(old.getId());
            } else {
                tobeDeleted.add(old);
            }
        }
        
        //borrar las antiguas colecciones asociadas.
        for(Collection c : tobeDeleted){
           //System.out.println("\tPor borrar es: nombre:"+c.getName()+" id:"+c.getId());
           //deleteListTableCollection(selectionListId, selectionListValueId, c.getId());
           this.selectionListValueCollectionEAO.deleteSelectionListValueCollection(selectionListId, selectionListValueId, c.getId());

        }

        //volver a insertar las colecciones que se acaban de seleccionar.
        for(Long collectionId : collectionsId){
           //System.out.println("\tingresando: collectionId:"+collectionId);
           //createListTableCollection(selectionListId, selectionListValueId, collectionId);
           this.selectionListValueCollectionEAO.createSelectionListValueCollection(selectionListId, selectionListValueId, collectionId);
        }
    }

    /**
     * listo
     *
     * @param selectionListId
     * @param selectionListValueId
     * @param CollectionId
     */
    public void createListTableCollection(Long selectionListId, Long selectionListValueId, Long collectionId) {
        this.selectionListValueCollectionEAO.createSelectionListValueCollection(selectionListId,selectionListValueId,collectionId);
    }

    /**
     * listo
     *
     * @param selectionListId
     * @param selectionListValueId
     * @param CollectionId
     */
    public void deleteListTableCollection(Long selectionListId, Long selectionListValueId, Long collectionId) {
        this.selectionListValueCollectionEAO.deleteSelectionListValueCollection(selectionListId, collectionId, selectionListValueId);
    }

   /**
     * Listo correjido.
     *
     * @param selectionListId
     * @return
     */

    public ListTable getSelectionListById(Long selectionListId){
        return selectionListEAO.getSelectionListById(selectionListId);

    }



    /**
     *Listo pa la foto!
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public selectionListEntity getSelectionlistValueById(Long selectionListId, Long selectionListValueId){
        return this.selectionListValueEAO.getSelectionlistValueById(selectionListId, selectionListValueId);

    }

    /**
     * listo
     * 
     * @param actualSelectionListValue
     */
    public void createSelectionListValue(selectionListEntity selectionListValue){

        //chequea que el selectionListEntity este pura vida, en lo que es bitácora.
        if(selectionListValue.getCreatedBy() == null)
            selectionListValue.setCreatedBy("jgutierrez");
        if(selectionListValue.getLastModificationBy() == null)
            selectionListValue.setLastModificationBy("jgutierrez");
        if(selectionListValue.getCreationDate() == null)
            new Date();
        if(selectionListValue.getCreationDate() == null)
            new Date();

        this.selectionListValueEAO.createSelectionListValue(selectionListValue);
    }

    /**
     * listo
     * 
     * @param selectionListValue
     */
    public void updateSelectionListValue(selectionListEntity selectionListValue) {
        this.selectionListValueEAO.updateSelectionListValue(selectionListValue);
    }


    /**
     * listo
     * 
     * @param selectionListId
     * @param selectionListValueId
     * @throws java.lang.IllegalArgumentException
     */
    public void deleteSelectionListValue(Long selectionListId, Long selectionListValueId) throws IllegalArgumentException {

        if (this.collectionEAO.getCollectionsBySelectionListValue(selectionListId, selectionListValueId).size() != 0){
            throw new IllegalArgumentException("El valor de la lista de Selección tiene Colecciones Asociadas");
        }

        this.selectionListValueEAO.deleteSelectionListValue(selectionListId, selectionListValueId);
    }

    /**
     * listo
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public List<Collection> getCollectionsBySelectionListValue(Long selectionListId, Long selectionListValueId){
        return this.collectionEAO.getCollectionsBySelectionListValue(selectionListId, selectionListValueId);
    }


    /**
     * @return the selectionListEAO
     */
    public SelectionListLocalEAO getSelectionListEAO() {
        return selectionListEAO;
    }

    /**
     * @param selectionListEAO the selectionListEAO to set
     */
    public void setSelectionListEAO(SelectionListLocalEAO selectionListEAO) {
        this.selectionListEAO = selectionListEAO;
    }

    /**
     * @return the collectionEAO
     */
    public CollectionLocalEAO getCollectionEAO() {
        return collectionEAO;
    }

    /**
     * @param collectionEAO the collectionEAO to set
     */
    public void setCollectionEAO(CollectionLocalEAO collectionEAO) {
        this.collectionEAO = collectionEAO;
    }

    /**
     * @return the selectionListValueEAO
     */
    public SelectionListValueLocalEAO getSelectionListValueEAO() {
        return selectionListValueEAO;
    }

    /**
     * @param selectionListValueEAO the selectionListValueEAO to set
     */
    public void setSelectionListValueEAO(SelectionListValueLocalEAO selectionListValueEAO) {
        this.selectionListValueEAO = selectionListValueEAO;
    }

    /**
     * @return the selectionListValueCollectionEAO
     */
    public SelectionListValueCollectionLocalEAO getSelectionListValueCollectionEAO() {
        return selectionListValueCollectionEAO;
    }

    /**
     * @param selectionListValueCollectionEAO the selectionListValueCollectionEAO to set
     */
    public void setSelectionListValueCollectionEAO(SelectionListValueCollectionLocalEAO selectionListValueCollectionEAO) {
        this.selectionListValueCollectionEAO = selectionListValueCollectionEAO;
    }

    /**
     * 
     * @param selectionListId
     * @return
     */
    public selectionListEntity getEmptySelectionListValue(Long selectionListId) {
        SelectionListEntity sle = SelectionListEntity.getById(selectionListId.intValue());
        return sle.getImplementation();
    }

}
