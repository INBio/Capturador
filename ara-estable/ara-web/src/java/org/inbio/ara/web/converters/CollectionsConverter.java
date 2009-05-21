/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.converters;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * Esta clase no esta del todo bien debe ser re/pensada
 * pues se le esta recargando a funcionalidad a lo que deberia
 * ser *solo* un convertidor. Ahorita es un "vaya busqueme esto(collecciones),
 * y devuelvamelas en un objecto GUI friendly"
 *
 * @author jgutierrez
 */
public class CollectionsConverter extends AbstractPageBean {

    @EJB
    private CollectionRemote collectionManager;

    public Option[] getCollectionsInOptionArray(){
        List<Collection> collectionsList = collectionManager.listAllCollections();

        ArrayList<Option> allCollectionOptions = new ArrayList<Option>();
        Option[] collectionsInArray;
        Option option;

        for(Collection c : collectionsList){
            option = new Option(c.getId(), c.getName());
            allCollectionOptions.add(option);
        }

        //sets the elements in the SingleSelectedOptionList Object
        collectionsInArray = new Option[allCollectionOptions.size()];
        return allCollectionOptions.toArray(collectionsInArray);
    }
}
