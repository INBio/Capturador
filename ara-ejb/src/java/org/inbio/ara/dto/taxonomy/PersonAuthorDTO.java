/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;


/**
 *
 * @author gsulca
 */
public class PersonAuthorDTO{

    private Long personId;
    private String name;


    public PersonAuthorDTO()
    {

    }
    
    public PersonAuthorDTO(Long personId, String name)
    {
        this.personId = personId;
        this.name = name;
    }


    /**
     * @return the personId
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }



}
