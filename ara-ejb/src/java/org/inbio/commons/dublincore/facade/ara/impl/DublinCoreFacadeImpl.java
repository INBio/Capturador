/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.facade.ara.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.inbio.commons.dublincore.dto.DublinCoreDTO;


import org.inbio.commons.dublincore.dto.ElementTypeDTO;
import org.inbio.commons.dublincore.dto.ReferenceDTO;
import org.inbio.commons.dublincore.eao.ara.DublinCoreDescriptionEAOLocal;
import org.inbio.commons.dublincore.eao.ara.DublinCoreElementEAOLocal;
import org.inbio.commons.dublincore.facade.ara.DublinCoreFacadeRemote;
import org.inbio.commons.dublincore.manager.impl.DublinCoreMetadataManagerImpl;
import org.inbio.commons.dublincore.model.DublinCoreDescription;
import org.inbio.commons.dublincore.model.DublinCoreElement;
import org.inbio.commons.dublincore.model.DublinCoreElementEnum;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;


/**
 *
 * @author gsulca
 */
@Stateless
public class DublinCoreFacadeImpl extends DublinCoreMetadataManagerImpl implements DublinCoreFacadeRemote{

  
        @EJB
	DublinCoreElementEAOLocal dublinCoreElementDAOImpl;

        @EJB
	DublinCoreDescriptionEAOLocal dublinCoreDescriptionDAOImpl;



	public DublinCoreDTO getMetadataByResourceKey(String key) {

		System.out.println("el Key es: "+key);

		DublinCoreDTO dcDTO= new DublinCoreDTO();
		String elementName;
                dcDTO.setResourceId(Integer.parseInt(key));
		//List<DublinCoreElement> dceList = dublinCoreElementDAOImpl.findAllByResourceId(Integer.valueOf(key).intValue());
		for(DublinCoreElement dce : dublinCoreElementDAOImpl.findAllByResourceId(Integer.valueOf(key).intValue())){
			//System.out.println("Dublin Core Element> "+dce.toString());
			elementName = DublinCoreElementEnum.getNameById(dce.getDublinCoreElementId());
			dcDTO.addElement(elementName, dce.getValue(), dce.getLanguage());
		}

		return dcDTO;
	}
    
     public Long countResourceByTypeId(int typeId) {
        return dublinCoreDescriptionDAOImpl.countResourceByTypeId(typeId);
    }



     public Long countSimpleSearch(String query) {
             Integer quantity = new Integer(unstructeredReferenceQuery(splitQuery(query)).size());
             return quantity.longValue();
        }

     /**
     * Use this method for semental simple search:
     * unstructuredSementalQuery: search by breed name, animal name, animal code,
     * veterinarian status,condition and animal description
     * @param parts
     * @return Set<Long>
     */
    private Set<Integer> unstructeredReferenceQuery(String[] parts)
    {
        Set<Integer> list = new HashSet();
        List<Integer> ids = null;



        for (int i = 0; i < parts.length; i++)
        {
            //try to cast it
            try
            {
                //find by title
                ids = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.TITLE.getId(),parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by creator
                ids = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.CREATOR.getId(),parts[i]);;
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by date
                ids = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.DATE.getId(),parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by animal code
                ids = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.IDENTIFIER.getId(),parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

            }
            catch(Exception e){}
        }
        return list;
    }


       public List<DublinCoreDTO> getReferenceSimpleSearch(String query, int firstResult, int maxResult) {

        Set<Integer> resourceIds = unstructeredReferenceQuery(splitQuery(query));
        //List<Semental> sementalList = getEntities(sementalIds, Semental.class, firstResult, maxResult);
        //return updateSementalDTOListValues(sementalDTOFactory.createDTOList(sementalList));
        List<DublinCoreDTO> result = new ArrayList();

        for(Integer resourceId: resourceIds)
        {
            result.add(this.getMetadataByResourceKey(resourceId.toString()));
        }
        return result;
    }


       public List<DublinCoreDTO> getAllDublinCorePaginated(int firstResult, int maxResult) {
        System.out.println("entro al getAllDublinCorePaginated del DublinCoreFacadeImpl ejb");
           //String[] parts = {"breedId","name","animalCode"};
        /*return updateSementalDTOListValues(sementalDTOFactory.createDTOList(
                sementalEAOLocal.findAllPaginatedFilterAndOrderBy(
                Semental.class, firstResult, maxResult, parts, null)));
         */
       List<DublinCoreDTO> result = new ArrayList();
       List<DublinCoreDescription> allReferences = new ArrayList();
       allReferences = dublinCoreDescriptionDAOImpl.findAllPaginated(ResourceTypeEnum.REFERENCE.getId(), firstResult, maxResult);
       //System.out.println(allReferences);
       System.out.println(/*" resourceId = "+allReferences.get(0).getResourceId()+*/" description = "+allReferences.get(0).getDescription());
       for(DublinCoreDescription referenceEntity: allReferences)
       {
           result.add(this.getMetadataByResourceKey(referenceEntity.getResourceId().toString()));
       }
       return result;
    }

     /**
     * Split the query
     * @param query
     * @return
     */
    private String[] splitQuery(String query)
    {
            if(query == null || query.length() == 0)
                return null;
            return query.split(" ");
    }



        /**
     * Get the entities for a list of Longs
     * @param ids
     * @param t
     * @param base
     * @param offset
     * @return
     */
   /*
    private List getEntities(Set<Long> ids, Class t, int base, int offset)
    {
        List entitiesList = new ArrayList();
        Object[] sortedIdentificationIds = ids.toArray();
        java.util.Arrays.sort(sortedIdentificationIds);
        int entitiesCounter = 0;
        int baseCounter = 0;
        if(sortedIdentificationIds.length > base)
        {
            for (Object id : sortedIdentificationIds)
            {
                if (baseCounter < base)
                {
                    baseCounter++;
                }
                else if(entitiesCounter < offset)
                {
                    if(t == Passport.class)
                    {
                        entitiesList.add(passportEAOLocal.
                            findById(Passport.class, (Long)id));
                    }
                    else
                    {
                        if(t == Accession.class)
                        {
                            entitiesList.add(accessionEAOLocal.
                                findById(Accession.class, (Long)id));
                        }
                        else
                        {
                            if(t == Breed.class)
                            {
                                entitiesList.add(breedEAOLocal.
                                    findById(Breed.class, (Long)id));
                            }
                            else
                            {
                                if(t == Semental.class)
                                {
                                    entitiesList.add(sementalEAOLocal.
                                        findById(Semental.class, (Long)id));
                                }
                                else
                                {
                                    if(t == SemenGathering.class)
                                    {
                                        entitiesList.add(semenGatheringEAOLocal.
                                            findById(SemenGathering.class, (Long)id));
                                    }
                                }
                            }
                        }
                    }

                    entitiesCounter++;
                }

            }
        }
        return entitiesList;
    }
*/
    public List<DublinCoreDTO> getDublinCoreAdvancedSearch(DublinCoreDTO dublinCoreDTO, int firstResult, int maxResult) {
        Set<Integer> resourceIds = getDublinCoreByCriteria(dublinCoreDTO);

        //Retrieve entities
        List<DublinCoreDTO> result = new ArrayList();

        for(Integer resourceId: resourceIds)
        {
            result.add(this.getMetadataByResourceKey(resourceId.toString()));
        }
        //return updateSementalDTOListValues(sementalDTOFactory.createDTOList(list));
        return result;

    }

    public Long countDublinCoreAdvancedSearch(DublinCoreDTO dublinCoreDTO) {
        Integer quantity = new Integer(getDublinCoreByCriteria(dublinCoreDTO).size());
        return quantity.longValue();
    }

    /**
     * Use this method for sementals advance search:
     * getElementsByCriteria: title, creator, identifier, date
     * @param dublinCoreDTO
     * @return  Set<Integer>
     */
    public Set<Integer> getDublinCoreByCriteria(DublinCoreDTO dublinCoreDTO)
    {
         Set<Integer> ids = new HashSet();
        boolean firstTime = true;

        List<Integer> query = new ArrayList<Integer>();

        //find by title
        if(dublinCoreDTO.getElementValues("title") != null)
        {
            query = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.TITLE.getId(),
                                                          dublinCoreDTO.getElementValues("title").get(0).getValue());
            if(query != null && !query.isEmpty())
            {
                ids.addAll(query);
                firstTime = false;
            }
        }

        //find by creator
        if(dublinCoreDTO.getElementValues("creator") != null)
        {
            query = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.CREATOR.getId(),
                                                          dublinCoreDTO.getElementValues("creator").get(0).getValue());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by identifier
        if(dublinCoreDTO.getElementValues("identifier") != null)
        {
            query = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.IDENTIFIER.getId(),
                                                          dublinCoreDTO.getElementValues("identifier").get(0).getValue());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by date
        if(dublinCoreDTO.getElementValues("date") != null)
        {
            query = dublinCoreElementDAOImpl.findByValue(DublinCoreElementEnum.DATE.getId(),
                                                          dublinCoreDTO.getElementValues("date").get(0).getValue());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        return ids;
    }


    public List<ReferenceDTO> dublinCoreDTOsToReferenceDTOs (List<DublinCoreDTO> list)
    {
        List<ReferenceDTO> result = new ArrayList();
        for(DublinCoreDTO element: list)
        {
            result.add(dublinCoreDTOToReferenceDTO(element));
        }
        return result;
    }

    public ReferenceDTO dublinCoreDTOToReferenceDTO (DublinCoreDTO element)
    {
        ReferenceDTO result = new ReferenceDTO();

        //System.out.println("*******************************\n"+element.toString()+"*******************************\n");

        /*Id can't be NULL*/
        result.setResourceId(element.getResourceId());
        //System.out.println("*** En la conversion del titulo: "+element.getElementValues("title").get(0).getValue());
        
        /*If title exist*/
        if(element.getElementValues("title") != null)
        {
            result.setTitle(element.getElementValues("title").get(0).getValue());
        }

        /*If creator exist*/
        if(element.getElementValues("creator") != null)
        {
            String creators = "";
          //  System.out.println(element.getElementValues("creator"));
            for(ElementTypeDTO creatorName: element.getElementValues("creator"))
            {
                creators += creatorName.getValue()+", ";
            }
            result.setCreator(creators);
           // System.out.println("Key = "+element.getResourceId()+"Creators = "+creators);
        }

        /*If date exist*/
        if(element.getElementValues("date") != null)
        {
            result.setDate(element.getElementValues("date").get(0).getValue());
        }

        /*If identifier exist*/        
        if(element.getElementValues("identifier") != null)
        {
            result.setIdentifier(element.getElementValues("identifier").get(0).getValue());
        }
        return result;
    }



}
