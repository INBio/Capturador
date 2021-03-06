/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.util;

import com.sun.data.provider.impl.ObjectListDataProvider;

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
 * En la h:dataTable
 *  value="#{inventory$SpecimenSessionBean.pagination.dataProvider.list}"
 *  rows="#{$SessionBean$.pagination.resultsPerPage}"
 * Luego en los webuijsf:button, se hara solo para el boton de ver siguientes resultados,
 * pero es igual para los 4:
 *  visible="#{$SessionBean$.paginationController.isVisibleNext}"
 *  actionExpression="#{$SessionBean$.paginationController.nextResults}"
 *
 * El metodo "public List getResults(int firstResult, int maxResults) "
 * DEBE SER SOBRE ESCRITO, POR INUTILIDAD MI (james) NO LO PUDE HACER FUNCIONAR
 * COMO ABSTRACT, ENTONCES DEBE SER SOBREESCRITO!.
 * @see SiteSessionBean
 *
 * @author jgutierrez
 */
public class PaginationControllerRemix {

    //Table data provider
    private ObjectListDataProvider dataProvider = new ObjectListDataProvider();

    private PaginationCoreInterface paginationCore;

    //Main values for this controller
    private int totalResults = -1;
    private int actualPage = -1;       //pagina =0 es la primera
    private int resultsPerPage = -1;

    //Propiedades de visibilidad de los botones
    private boolean isVisiblePrevious;
    private boolean isVisibleNext;
    
    private boolean reloadVariables = false;

    /**
     * Class constructor
     *
     * @param totalResults
     * @param resultsPerPage
     */
    public PaginationControllerRemix(int totalResults, int resultsPerPage ,PaginationCoreInterface paginationCore) {
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
        this.paginationCore = paginationCore;
    }

    /**
     * Incrementa en una unidad la cantidad total de resultados
     * Debe utilizarse al crear un nuevo elemento en la tabla
     * @deprecated Afecta la concurrencia en el sistema
     */
    public void addItem(){
        this.totalResults++;
    }

     /**
     * Decrementa en una unidad la cantidad total de resultados
     * Debe utilizarse al eliminar un elemento en la tabla
     * @deprecated Afecta la concurrencia en el sistema
     */
    public void deleteItem(){
        this.totalResults--;
    }

    public void refreshList(){
        //System.out.println("Refrescando la lista");
                setButtonsVisibility();
        this.dataProvider.setList(paginationCore.getResults(getActualPage(),resultsPerPage));
        setReloadVariables(false);
    }

    public void nextResults() {
        actualPage = getActualPage() + resultsPerPage;
        //System.out.println("Actual Page: " + getActualPage());
        //System.out.println("Total Results: " + getTotalResults());
        setButtonsVisibility();
        this.dataProvider.setList(paginationCore.getResults(getActualPage(),resultsPerPage));
        setReloadVariables(false);
    }

    public void firstResults() {
        actualPage = 0;
        //System.out.println("Actual Page: " + getActualPage());
        setButtonsVisibility();
        this.dataProvider.setList(paginationCore.getResults(getActualPage(),resultsPerPage));
        setReloadVariables(false);
    }

    public void previousResults() {
        if (getActualPage() > 0) {
            actualPage = getActualPage() - resultsPerPage;
            //System.out.println("Actual Page: " + getActualPage());
            setButtonsVisibility();
            this.dataProvider.setList(paginationCore.getResults(getActualPage(),resultsPerPage));
            setReloadVariables(false);
        }
    }

    public void lastResults() {
        long timeI = System.currentTimeMillis();
        long finalT = 0;
        
        int lastRecords = getTotalResults()%resultsPerPage;
        finalT = System.currentTimeMillis();
        System.out.println("Duracion 1 = "+(finalT-timeI));
        timeI = finalT;
        if (lastRecords != 0) { 
            actualPage = getTotalResults() - (getTotalResults()%resultsPerPage);
            finalT = System.currentTimeMillis();
            System.out.println("Duracion 2 = "+(finalT-timeI));
            timeI = finalT;
        } else {
            actualPage = getTotalResults() - resultsPerPage;
            finalT = System.currentTimeMillis();
            System.out.println("Duracion 3 = "+(finalT-timeI));
            timeI = finalT;
        }
        if (getActualPage() + resultsPerPage < getTotalResults()) {
            actualPage = getActualPage() + resultsPerPage;
            finalT = System.currentTimeMillis();
            System.out.println("Duracion 4 = "+(finalT-timeI));
            timeI = finalT;
        }
        //System.out.println("Actual Page: " + getActualPage());
        setButtonsVisibility();
        this.dataProvider.setList(paginationCore.getResults(getActualPage(),resultsPerPage));
        finalT = System.currentTimeMillis();
        System.out.println("Duracion 5 = "+(finalT-timeI));
        System.out.println("actualPage = "+getActualPage());
        timeI = finalT;
        
        setReloadVariables(false);
    }

    private void setButtonsVisibility() {
        if (getActualPage() != 0) {
            isVisiblePrevious = true;
        } else {
            isVisiblePrevious = false;
        }

        if (getTotalResults() > getActualPage() + resultsPerPage) {
            isVisibleNext = true;
        } else {
            isVisibleNext = false;
        }
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

    /**
     * @param totalResults the totalResults to set
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * @return the actualPage
     */
    public int getActualPage() {
        return actualPage;
    }

    /**
     * @return the totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * @return the reloadVariables
     */
    public boolean isReloadVariables() {
        return reloadVariables;
    }

    /**
     * @param reloadVariables the reloadVariables to set
     */
    public void setReloadVariables(boolean reloadVariables) {
        this.reloadVariables = reloadVariables;
    }
}
