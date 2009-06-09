/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.util;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.List;
import org.inbio.ara.web.site.SiteSessionBean;

/**
 *Esta clase esta pensada para controlar la botonera que se encarga de la paginacion en las tablas, como
 * no hemos encontrado como hacerlo con el objeto "Table" pues entonces la alternativa sería hacerlo poniendo
 * 4 botones aparte y manejandolos por aparte. Para que la lógica de la paginación quedara centralizada se crea
 * esta clase.
 *
 * La idea es que en el (session)bean donde se tenga que controlar una tabla con paginacion, se utilice
 * una instacia de este controlador implementando los metodos abstractos que permiten hacer la paginacion
 * en el caso particular de cada tabla (según que datos se debe llamar algún manager particular).
 * Para hacer la vida del programador más sencilla se deben "bindear" (binding) desde el jsp con algunas propiedades:
 * En la webuijsf:tableRowGroup:
 *  sourceData="#{$SessionBean$.paginationController.dataProvider}
 *  rows="#{$SessionBean$.paginationController.resultsPerPage}"
 * Luego en los webuijsf:button, se hara solo para el boton de ver siguientes resultados,
 * pero es igual para los 4:
 *  visible="#{$SessionBean$.paginationController.isVisibleNext}"
 *  actionExpression="#{$SessionBean$.paginationController.nextResults}"
 *
 *
 * El metodo "public List getResults(int firstResult, int maxResults) "
 * DEBE SER SOBRE ESCRITO, POR INUTILIDAD MI (james) NO LO PUDE HACER FUNCIONAR
 * COMO ABSTRACT, ENTONCES DEBE SER SOBREESCRITO!.
 * @see SiteSessionBean
 *
 *
 *
 * @author jgutierrez
 */
public class PaginationController {

    //table data provider
    private ObjectListDataProvider dataProvider = new ObjectListDataProvider();

    //main values for this controller
    private int totalResults = -1;
    private int actualPage = -1;       //pagina =0 es la primera
    private int resultsPerPage = -1;

    //propiedades de visibilidad de los botones
    private boolean isVisiblePrevious;
    private boolean isVisibleNext;

    public PaginationController(int totalResults, int resultsPerPage) {
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;

        firstResults();
    }

    public void nextResults() {
        actualPage = actualPage + resultsPerPage;
        System.out.println("Actual Page: " + actualPage);
        System.out.println("Total Results: " + totalResults);
        setButtonsVisibility();
        this.dataProvider.setList(getResults(actualPage, resultsPerPage));
    }

    public void firstResults() {
        actualPage = 0;
        System.out.println("Actual Page: " + actualPage);
        setButtonsVisibility();
        this.dataProvider.setList(getResults(actualPage, resultsPerPage));
    }

    public void previousResults() {
        if (actualPage > 0) {
            actualPage = actualPage - resultsPerPage;
            System.out.println("Actual Page: " + actualPage);
            setButtonsVisibility();
            this.dataProvider.setList(getResults(actualPage, resultsPerPage));
        }
    }

    public void lastResults() {

        actualPage = totalResults - resultsPerPage;
        
        if (actualPage + resultsPerPage < totalResults) {
            actualPage = actualPage + resultsPerPage;
        }

        System.out.println("Actual Page: " + actualPage);
        setButtonsVisibility();
        this.dataProvider.setList(getResults(actualPage, resultsPerPage));
    }

    /**
     * 
     */
    private void setButtonsVisibility() {

        if (actualPage != 0) {
            isVisiblePrevious = true;
        } else {
            isVisiblePrevious = false;
        }

        if (totalResults > actualPage + resultsPerPage) {
            isVisibleNext = true;
        } else {
            isVisibleNext = false;
        }

    }

    /**
     * Estos metodos debe ser generado por la clase que implementa el PaginationController
     * DEBE SER SOBRE ESCRITO, POR INUTILIDAD MI (james) NO LO PUDE HACER FUNCIONAR
     * COMO ABSTRACT, ENTONCES DEBE SER SOBREESCRITO!.
     * @see SiteSessionBean
     */
    public List getResults(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the isVisiblePrevious
     */
    public boolean isIsVisiblePrevious() {
        return isVisiblePrevious;
    }

    /**
     * @param isVisiblePrevious the isVisiblePrevious to set
     */
    public void setIsVisiblePrevious(boolean isVisiblePrevious) {
        this.isVisiblePrevious = isVisiblePrevious;
    }

    /**
     * @return the isVisibleNext
     */
    public boolean isIsVisibleNext() {
        return isVisibleNext;
    }

    /**
     * @param isVisibleNext the isVisibleNext to set
     */
    public void setIsVisibleNext(boolean isVisibleNext) {
        this.isVisibleNext = isVisibleNext;
    }

    /**
     * @return the dataProvider
     */
    public ObjectListDataProvider getDataProvider() {
        return dataProvider;
    }

    /**
     * @param dataProvider the dataProvider to set
     */
    public void setDataProvider(ObjectListDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * @return the resultsPerPage
     */
    public int getResultsPerPage() {
        return resultsPerPage;
    }

    /**
     * @param resultsPerPage the resultsPerPage to set
     */
    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
