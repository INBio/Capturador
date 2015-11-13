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

package org.inbio.ara.facade.reports.impl;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.reports.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.reports.DwcCategoryDTO;
import org.inbio.ara.dto.reports.DwcCategoryDTOFactory;
import org.inbio.ara.dto.reports.DwcElementDTO;
import org.inbio.ara.dto.reports.DwcElementDTOFactory;
import org.inbio.ara.dto.reports.PlicElementDTO;
import org.inbio.ara.dto.reports.PlicElementDTOFactory;
import org.inbio.ara.eao.reports.DarwinCore14EAOLocal;
import org.inbio.ara.eao.reports.DwcCategoryEAOLocal;
import org.inbio.ara.eao.reports.DwcElementEAOLocal;
import org.inbio.ara.eao.reports.DwcSnapshotEAOJDBCLocal;
import org.inbio.ara.eao.reports.DwcSnapshotEAOLocal;
import org.inbio.ara.eao.reports.PlicElementEAOLocal;
import org.inbio.ara.eao.reports.PlicSnapshotEAOJDBCLocal;
import org.inbio.ara.eao.reports.PlicSnapshotEAOLocal;
import org.inbio.ara.eao.reports.PlinianCoreFlatEAOLocal;
import org.inbio.ara.persistence.reports.DwcCategory;
import org.inbio.ara.persistence.reports.DwcElement;
import org.inbio.ara.persistence.reports.PlicElement;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author esmata
 */
@Stateless
public class ReportsFacadeImpl implements ReportsFacadeRemote {

    //Injections
    @EJB
    private DwcElementEAOLocal dwcElementEAOImpl;
    @EJB
    private DwcCategoryEAOLocal dwcCategoryEAOImpl;
    @EJB
    private DarwinCore14EAOLocal darwinCore14EAOImpl;

    @EJB
    private PlinianCoreFlatEAOLocal plinianCoreFlatEAOImpl;

    @EJB
    private DwcSnapshotEAOLocal dwcSnapshotEAOImpl;

    @EJB
    private PlicSnapshotEAOLocal plicSnapshotEAOImpl;

    @EJB
    private DwcSnapshotEAOJDBCLocal dwcSnapshotEAOJDBCImpl;// = new DwcSnapshotEAOJDBCImpl();

    @EJB
    private PlicSnapshotEAOJDBCLocal plicSnapshotEAOJDBCImpl;

    @EJB
    private PlicElementEAOLocal plicElementEAOLocal;

    //DTO's factories
    DwcElementDTOFactory dwcElementDTOFactory = new DwcElementDTOFactory();
    DwcCategoryDTOFactory dwcCategoryDTOFactory = new DwcCategoryDTOFactory();
    PlicElementDTOFactory plicElementDTOFactory = new PlicElementDTOFactory();


    //Method to retrive the elements of darwin core
    public List<DwcElementDTO> findDwCElements() {
        return dwcElementDTOFactory.createDTOList
                (dwcElementEAOImpl.findAll(DwcElement.class));
    }

    //Method to retrive the elements of darwin core
    public List<PlicElementDTO> findPlicElements() {
        return plicElementDTOFactory.createDTOList
                (plicElementEAOLocal.findAll(PlicElement.class));
    }

    public DwcCategoryDTO findDwcCategoryById(Long id){
        return dwcCategoryDTOFactory.createDTO
                (dwcCategoryEAOImpl.findById(DwcCategory.class, id));
    }

    public DwcElementDTO findDwcElementById(Long id){
        return dwcElementDTOFactory.createDTO
                (dwcElementEAOImpl.findById(DwcElement.class, id));
    }

    /**
     * Metodo que realiza el snapshot darwin core primario, el cual será
     * utilizado para los reportes y para crear snapshots personalizados
     */
    public boolean reloadDarwinCoreTable(String dbSchema){
        return darwinCore14EAOImpl.reloadDarwinCoreTable(dbSchema);
    }

    /**
     * Metodo que realiza el snapshot plinian core primario, el cual será
     * utilizado para los reportes y para crear snapshots personalizados
     */
    public boolean reloadPlinianCoreTable(String dbSchema){
        return plinianCoreFlatEAOImpl.reloadPlinianCoreTable(dbSchema);
    }

    /**
     * Metodo encargado de generar el snapshot Darwin Core con la información
     * indicada del sistema
     * @param user usuario para la conexion jdbc con postgres
     * @param pass contraseña para el usuario para la conexion jdbc
     * @return "success" = everything ok, "fail" = something wrong
     */
    public boolean makeDcwSnapshotNative(LinkedList<QueryNode>
            qnlist,LinkedList<String> elist, String dbSchema){
        try{
            //Delete all snapshot entries
            dwcSnapshotEAOImpl.truncateDwcSnapshot(dbSchema);
        }
        catch(Exception e){return false;}

        //Generate the query string
        String q = makeQueryStringPostgres(qnlist,elist, dbSchema);

        //Generate snapshot with the query
        boolean result = dwcSnapshotEAOImpl.DcwSnapshotAllPostgresql(q);
        if (result)
            return true;
        else
            return false;
    }

    /**
     * Metodo encargado de generar el snapshot Plinian Core con la información
     * indicada del sistema
     * @param user usuario para la conexion jdbc con postgres
     * @param pass contraseña para el usuario para la conexion jdbc
     * @return "success" = everything ok, "fail" = something wrong
     */
    public boolean makePlicSnapshotNative(LinkedList<QueryNode>
            qnlist,LinkedList<String> elist, String dbSchema){
        try{
            //Delete all snapshot entries
            plicSnapshotEAOImpl.truncatePlicSnapshot(dbSchema);
        }
        catch(Exception e){return false;}

        //Generate the query string
        String q = makeQueryStringPostgresPlic(qnlist,elist, dbSchema);

        //Generate snapshot with the query
        boolean result = plicSnapshotEAOImpl.PlicSnapshotAllPostgresql(q);
        if (result)
            return true;
        else
            return false;
    }
    
    /**
     * Metodo que exporta el contenido de la tabla dwc_snapshot en un archivo
     * destino
     * @param file = archivo destino
     * @return
     */
    public boolean export(File f, String dataSource, String dbSchema) {
        if (f == null) {
            return false;
        } else {
            return this.dwcSnapshotEAOJDBCImpl.writeDwcSnapshotToFile(f,dataSource, dbSchema);
        }
    }

    /**
     * Metodo que exporta el contenido de la tabla dwc_snapshot en un archivo
     * destino
     * @param file = archivo destino
     * @return
     */
    //TODO
    public boolean exportToPlic(File f, String dbSchema, String dataSource) {
        if (f == null) {
            return false;
        } else {
            return this.plicSnapshotEAOJDBCImpl.writePlicSnapshotToFile(f, dbSchema, dataSource);
        }
    }

    /**
     * Get all dwc elements as String in lower case
     * @return
     */
    public LinkedList<String> getAllElementsDwc(){
        System.out.println("Entra al getAllElementsDwc");
        List<DwcElementDTO> elements = findDwCElements();
        LinkedList<String> result = new LinkedList();
        //String encabezados ="";
        
        for(DwcElementDTO element:elements){
        //    encabezados += element;
            System.out.println(element.getElementName());
            String e = element.getElementName().toLowerCase();
            result.add(e);
        }
        //System.out.println(encabezados);
        return result;
    }

    /**
     * Get all dwc elements as String in lower case
     * @return
     */
    public LinkedList<String> getAllElementsPlic(){
        List<PlicElementDTO> elements = findPlicElements();
        LinkedList<String> result = new LinkedList();
        for(PlicElementDTO element:elements){
            String e = element.getElementName().toLowerCase();
            result.add(e);
        }
        return result;
    }

    /**
     * Generate the PostgreSQL select String for darwin core snapshot
     * @param llqn lista de nodos para la consulta
     * @param lls lista de elementos darwin core
     * @return la consulta en postgres notation
     */
	private String makeQueryStringPostgres(LinkedList<QueryNode> llqn,
            LinkedList<String> lls, String dbSchema) {
        //Construyecto el insert
        String jpqlQuery = "insert into "+dbSchema+".dwc_snapshot (";
        int llsSize = lls.size();
        for(int i = 0;i<llsSize;i++){
            String element = lls.get(i).toLowerCase();
            if(element.equals("order")){element="orders";}
            else if(element.equals("class")||element.equals("class1")){element="\"class\"";}
            else if(element.equals("family")){element="\"family\"";}
            if(i==(llsSize-1)) //Si es el ultimo, no debe llevar coma (,)
                jpqlQuery+=element+") ";
            else
            jpqlQuery+=element+",";
        }
        //Construyendo el select
        jpqlQuery+="select ";
        for(int i = 0;i<llsSize;i++){
            String element = lls.get(i).toLowerCase();
            String eAux = lls.get(i).toLowerCase();
            if(eAux.equals("order")){eAux="orders";element="orders";}
            else if(eAux.equals("class")){eAux="\"class\"";}
            else if(eAux.equals("class1")){eAux="\"class\"";element="class";}
            else if(eAux.equals("family")){eAux="\"family\"";}
            if(i==(llsSize-1)) //Si es el ultimo, no debe llevar coma (,)
                jpqlQuery+="dwc."+element+" as "+eAux+" ";
            else
                jpqlQuery+="dwc."+element+" as "+eAux+",";
        }
        //Construyecto el from
        jpqlQuery+="from "+dbSchema+".darwin_core_1_4 dwc ";
        if (llqn.isEmpty()){ //si no hay criterio de búsqueda
            return jpqlQuery+" order by dwc.globaluniqueidentifier;";
        }
        else{
            //Construyecto el where
            jpqlQuery+="where ";
            QueryNode qn = llqn.getFirst();
            jpqlQuery += "lower(dwc." + qn.getDwcElement() + ")";
            jpqlQuery += " " + qn.getComparator() + " ";
            if (qn.getComparator().equals("like")) {
                jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
            } else {
                jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
            }
            for (int i = 1; i < llqn.size(); i++) {
                qn = llqn.get(i);
                jpqlQuery += " " + qn.getLogicalOperator() + " ";
                jpqlQuery += "lower(dwc." + qn.getDwcElement() + ")";
                jpqlQuery += " " + qn.getComparator() + " ";
                if (qn.getComparator().equals("like")) {
                    jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
                } else {
                    jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
                }
            }
            return jpqlQuery+" order by dwc.globaluniqueidentifier;";
        }
	}

    /**
     * Generate the PostgreSQL select String for plinian core snapshot
     * @param llqn lista de nodos para la consulta
     * @param lls lista de elementos plinian core
     * @return la consulta en postgres notation
     */
	private String makeQueryStringPostgresPlic(LinkedList<QueryNode> llqn,
            LinkedList<String> lls, String dbSchema) {
        //Construyecto el insert
        String jpqlQuery = "insert into "+dbSchema+".plic_snapshot (";
        int llsSize = lls.size();
        for(int i = 0;i<llsSize;i++){
            String element = lls.get(i).toLowerCase();
            if(i==(llsSize-1)) //Si es el ultimo, no debe llevar coma (,)
                jpqlQuery+=element+") ";
            else
            jpqlQuery+=element+",";
        }
        //Construyendo el select
        jpqlQuery+="select ";
        for(int i = 0;i<llsSize;i++){
            String element = lls.get(i).toLowerCase();
            String eAux = lls.get(i).toLowerCase();
            if(i==(llsSize-1)) //Si es el ultimo, no debe llevar coma (,)
                jpqlQuery+="plic."+element+" as "+eAux+" ";
            else
                jpqlQuery+="plic."+element+" as "+eAux+",";
        }
        //Construyecto el from
        jpqlQuery+="from "+dbSchema+".plinian_core_flat plic ";
        if (llqn.isEmpty()){ //si no hay criterio de búsqueda
            //System.out.println(jpqlQuery+" order by plic.globaluniqueidentifier;");
            return jpqlQuery+" order by plic.globaluniqueidentifier;";
        }
        else{
            //Construyecto el where
            jpqlQuery+="where ";
            QueryNode qn = llqn.getFirst();
            jpqlQuery += "lower(plic." + qn.getDwcElement() + ")";
            jpqlQuery += " " + qn.getComparator() + " ";
            if (qn.getComparator().equals("like")) {
                jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
            } else {
                jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
            }
            for (int i = 1; i < llqn.size(); i++) {
                qn = llqn.get(i);
                jpqlQuery += " " + qn.getLogicalOperator() + " ";
                jpqlQuery += "lower(plic." + qn.getDwcElement() + ")";
                jpqlQuery += " " + qn.getComparator() + " ";
                if (qn.getComparator().equals("like")) {
                    jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
                } else {
                    jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
                }
            }
            //System.out.println(jpqlQuery+" order by plic.globaluniqueidentifier;");
            return jpqlQuery+" order by plic.globaluniqueidentifier;";
        }
	}
 
}
