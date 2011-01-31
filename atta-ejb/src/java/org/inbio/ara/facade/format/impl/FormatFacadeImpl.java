/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.facade.format.impl;

import java.util.ArrayList;
import javax.ejb.EJB;
import org.inbio.ara.facade.format.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.dto.format.ReportLayoutDTOFactory;
import org.inbio.ara.eao.format.FuncionalityTypeEAOLocal;
import org.inbio.ara.eao.format.ReportLayoutEAOLocal;
import org.inbio.ara.persistence.format.ReportLayout;
import java.util.Iterator;
import java.util.List;
import org.inbio.ara.dto.format.ReportLayoutElementDTO;
import org.inbio.ara.dto.format.ReportLayoutElementDTOFactory;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.eao.format.ReportLayoutElementEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.persistence.format.ReportLayoutElement;
import org.inbio.ara.util.ElementLabelXml;
import org.inbio.ara.util.ParserXML;


/**
 * @author pcorrales
 */
@Stateless
public class FormatFacadeImpl implements FormatFacadeRemote {
    
  


    @EJB  //inyectar interfaces local -remote
    private ReportLayoutEAOLocal ReportLayoutEAOImpl;

    @EJB  //inyectar interfaces local -remote
    private FuncionalityTypeEAOLocal FuncionalityTypeEAOImpl;

    @EJB  //inyectar interfaces local -remote
    private ReportLayoutElementEAOLocal ReportLayoutElementEAOImpl;


    @EJB  //inyectar interfaces local -remote
    private SpecimenEAOLocal SpecimenEAOImpl;


    //reportLayoutDto
 
    private ReportLayoutDTOFactory reportLayoutDTOFactory = new ReportLayoutDTOFactory();
    private ReportLayoutElementDTOFactory reportLayoutElementDTOFactory = new ReportLayoutElementDTOFactory();


    //specimen DTO use in this moment
    private SpecimenDTO currentSpecimenDTO = new SpecimenDTO();

    private String  labelInformation;

    
    /**
     * @return the ReportLayoutEAOImpl
     */
    public ReportLayoutEAOLocal getReportLayoutEAOImpl() {
        return ReportLayoutEAOImpl;
    }

    /**
     * @param ReportLayoutEAOImpl the ReportLayoutEAOImpl to set
     */
    public void setReportLayoutEAOImpl(ReportLayoutEAOLocal ReportLayoutEAOImpl) {
        this.ReportLayoutEAOImpl = ReportLayoutEAOImpl;
    }

    /**
     * @return the FuncionalityTypeEAOImpl
     */
    public FuncionalityTypeEAOLocal getFuncionalityTypeEAOImpl() {
        return FuncionalityTypeEAOImpl;
    }

    /**
     * @param FuncionalityTypeEAOImpl the FuncionalityTypeEAOImpl to set
     */
    public void setFuncionalityTypeEAOImpl(FuncionalityTypeEAOLocal FuncionalityTypeEAOImpl) {
        this.FuncionalityTypeEAOImpl = FuncionalityTypeEAOImpl;
    }
   
    


    /**
     * @return the reportLayoutDTOFactory
     */
    public ReportLayoutDTOFactory getReportLayoutDTOFactory() {
        return reportLayoutDTOFactory;
    }

    /**
     * @param reportLayoutDTOFactory the reportLayoutDTOFactory to set
     */
    public void setReportLayoutDTOFactory(ReportLayoutDTOFactory reportLayoutDTOFactory) {
        this.reportLayoutDTOFactory = reportLayoutDTOFactory;
    }

    /**
     *   get all reporter filter  by fincionality
     */
    public List<ReportLayoutDTO> getAllReportLayout(Long FuncionalityTypeId){

        return this.getReportLayoutEAOImpl().getAllReportLayoutByFuncionality(FuncionalityTypeId);
    }


    /**
     * Get the DTO with the information of Report
     * @param reportLayoutId
     * @return
     */
    public ReportLayoutDTO getReportLayoutById(Long reportLayoutId) {
        
        ReportLayout reportEntity = this.getReportLayoutEAOImpl().findById(ReportLayout.class, reportLayoutId);
        ReportLayoutDTO  result = this.getReportLayoutDTOFactory().createDTO(reportEntity);
        return  result;
    }


    /**
     * Generates the list  of elementXML to be processed by class Page
     * @param reportLayoutId
     * @return
     */
    public List generatedListElements(Long reportLayoutId)
    {    
         
          //generate the xml with the contents of format
          ReportLayoutDTO report = this.getReportLayoutById(reportLayoutId);
          String contents = report.getContents() ;

          // parser the document and generate the label
          ParserXML dpe = new  ParserXML();

          //create a file or set currentfile
          dpe.createXLMFile(contents);
          List format = dpe.parserFormat();

         
         return format;
    }

    
    /***
     * proccess the  report and return  tha contents of label in the selected format
     * @param reportLayoutId
     * @param specimenDTO
     * @return
     */
    public String  processReportLayout(Long reportLayoutId,SpecimenDTO specimenDTO){

        //set the  actual specimen DTO
        this.setCurrentSpecimenDTO(specimenDTO);

        //proccess the node and search the value
        List listElements  = this.processNodes(this.generatedListElements(reportLayoutId));

        //
        String resp = this.generatedLabelContentsHtml(listElements);

        return resp;
    }

    

    /**
     * process al the selected specimen and generated the list of elements of the select  format
     * @param reportLayoutId
     * @param list
     * @return
     */
    public List processReportLayout(Long reportLayoutId,ArrayList<SpecimenDTO> list)
    {

        List elements = this.generatedListElements(reportLayoutId);
        List newElements =  new ArrayList();

        for(int x = 0 ; x < list.size(); x++)
        {
             List xd =   new ArrayList();
             System.out.println(list.get(x).getCatalogNumber());
             this.setCurrentSpecimenDTO(list.get(x));
             System.out.println(this.getCurrentSpecimenDTO().getCatalogNumber());
             xd = this.processNodes(elements);
             newElements.add(xd);
        }

       return newElements;
    }



    /**
     * generated the contents of the label
     * @param doc
     * @return
     */
    public String  generatedLabelContentsHtml(List doc)
    {
        String contentsLabel = "";
        Iterator it = doc.iterator();


        while(it.hasNext())
        {
             ElementLabelXml  elem=  (ElementLabelXml) it.next();
             contentsLabel += elem.toString();
        }

       return  contentsLabel;
    }

    /**
     * get the list of elements and each invokes elements function to get the value of the database
     *@param doc
     */
   
    public  List processNodes(List doc) {

        
        List format =   new ArrayList();

        Iterator it = doc.iterator();

        while(it.hasNext())
        {
                     String respuesta =  "";
                     ElementLabelXml  elem=  (ElementLabelXml) it.next();

                     /**if a element name is barcode, get the catalog Number and set this value*/
                     if(elem.getElementName().equals("Barcode"))
                     {
                          respuesta +=  this.getCurrentSpecimenDTO().getCatalogNumber() ;
                     }
                     else
                     {
                        ReportLayoutElementDTO ele =  this.getReportLayoutElemen(elem.getElementName().trim());
                        respuesta +=  this.processReportLayoutElement(ele) ;
                     }

                     elem.setValue(respuesta);
                     format.add(elem);
        }
     
       return  format;
    }

  

    /*
     * get the item that matches the format element
     * @param elementName
     * @return
     */

   public ReportLayoutElementDTO getReportLayoutElemen(String elementName)
   {
        Long entity =  this.getReportLayoutElementEAOImpl().findByElementName(elementName);
        ReportLayoutElement reportLayoutElementEntity =   this.getReportLayoutElementEAOImpl().findById(ReportLayoutElement.class, entity);
        ReportLayoutElementDTO ElementDTO = this.getReportLayoutElementDTOFactory().createDTO(reportLayoutElementEntity);
       
        return ElementDTO;
   }
  

   /**
    * This method is responsible for making the query data base
    * the ReportLayoutElementDTO  contains  the name of the entity, the primary key and the key elemen
    * @param reportLayoutElementDTO
    * @return
    */
   public String  processReportLayoutElement(ReportLayoutElementDTO reportLayoutElementDTO)
   {
       //name of selected entity
       String entityName =  reportLayoutElementDTO.getEntity();

       // key asociated with selected entity
       String keyFieldName = reportLayoutElementDTO.getEntityKeyField();

       //element to find
       String mainFieldName = reportLayoutElementDTO.getEntityMainField();

       String result =  mainFieldName + " : ";
       

       String query = "select "  +"sp"+ "." + mainFieldName + " from "  +  entityName  + "  as sp where " + "sp" + "." +  keyFieldName + " =  " +  this.currentSpecimenDTO.getCatalogNumber();
       
       result +=  this.getReportLayoutElementEAOImpl().executeQuery(query);

       return  result;
   }

 
    /**
     * @return the ReportLayoutElementEAOImpl
     */
    public ReportLayoutElementEAOLocal getReportLayoutElementEAOImpl() {
        return ReportLayoutElementEAOImpl;
    }

    /**
     * @param ReportLayoutElementEAOImpl the ReportLayoutElementEAOImpl to set
     */
    public void setReportLayoutElementEAOImpl(ReportLayoutElementEAOLocal ReportLayoutElementEAOImpl) {
        this.ReportLayoutElementEAOImpl = ReportLayoutElementEAOImpl;
    }

  

    /**
     * @return the reportLayoutElementDTOFactory
     */
    public ReportLayoutElementDTOFactory getReportLayoutElementDTOFactory() {
        return reportLayoutElementDTOFactory;
    }

    /**
     * @param reportLayoutElementDTOFactory the reportLayoutElementDTOFactory to set
     */
    public void setReportLayoutElementDTOFactory(ReportLayoutElementDTOFactory reportLayoutElementDTOFactory) {
        this.reportLayoutElementDTOFactory = reportLayoutElementDTOFactory;
    }

    /**
     * @return the SpecimenEAOImpl
     */
    public SpecimenEAOLocal getSpecimenEAOImpl() {
        return SpecimenEAOImpl;
    }

    /**
     * @param SpecimenEAOImpl the SpecimenEAOImpl to set
     */
    public void setSpecimenEAOImpl(SpecimenEAOLocal SpecimenEAOImpl) {
        this.SpecimenEAOImpl = SpecimenEAOImpl;
    }

    /**
     * @return the currentSpecimenDTO
     */
    public SpecimenDTO getCurrentSpecimenDTO() {
        return currentSpecimenDTO;
    }

    /**
     * @param currentSpecimenDTO the currentSpecimenDTO to set
     */
    public void setCurrentSpecimenDTO(SpecimenDTO currentSpecimenDTO) {
        this.currentSpecimenDTO = currentSpecimenDTO;
    }

    /**
     * @return the labelInformation
     */
    public String getLabelInformation() {
        return labelInformation;
    }

    /**
     * @param labelInformation the labelInformation to set
     */
    public void setLabelInformation(String labelInformation) {
        this.labelInformation = labelInformation;
    }
    

    /***
     * return the contents of the ReportLayout
     * @param reportLayoutId
     * @return
     */
    public String  getReportLayoutContents(Long  reportLayoutId)
    {

          ReportLayoutDTO report = this.getReportLayoutById(reportLayoutId);
          return  report.getContents();
    }
 
}
