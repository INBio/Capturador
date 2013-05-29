/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.identification.Identifier;
import org.inbio.ara.persistence.identification.IdentifierPK;

/**
 *
 * @author asanabria
 */
public class IdentifierDTOFactory extends BaseEntityOrDTOFactory<Identifier, IdentifierDTO> {

    
               
	    public IdentifierDTO createDTO(Identifier i) {

		    IdentifierDTO iDTO = new IdentifierDTO();

		    if(i.getIdentifierPK() != null && i.getIdentifierPK().getIdentifierPerson() != null){
			    iDTO.setIdentifierKey(i.getIdentifierPK().getIdentifierPerson().getPersonId());
			    iDTO.setIdentifierName(i.getIdentifierPK().getIdentifierPerson().getNaturalFullName());
			    iDTO.setInitialTimeStamp(i.getIdentifierPK().getInitialTimestamp());
		    }

		    return iDTO;
	    }

    @Override
    public Identifier getEntityWithPlainValues(IdentifierDTO dto) {
        
         Identifier i = new Identifier();
         
         IdentifierPK iPK = new IdentifierPK();
         
         iPK.setInitialTimestamp(dto.getInitialTimeStamp());

         //IdentifierPerson e IdentifierName es de tipo Person, se asigna desde el Facade         
         i.setIdentifierPK(iPK);       
         return i;
        
    }

    @Override
    public Identifier updateEntityWithPlainValues(IdentifierDTO dto, Identifier e) {
            
           
         
         IdentifierPK iPK = new IdentifierPK();
         
         iPK.setInitialTimestamp(dto.getInitialTimeStamp());

         //IdentifierPerson e IdentifierName es de tipo Person, se asigna desde el Facade         
         e.setIdentifierPK(iPK);     
         
         return e;
    }
}
