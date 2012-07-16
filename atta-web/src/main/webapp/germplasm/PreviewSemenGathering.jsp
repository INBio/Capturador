<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PreviewSemenGathering
    Created on : 07/10/2010, 01:23:53 PM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}"  id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{germplasm$PreviewSemenGathering.lbTitle}" id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.detail_informacion}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                 <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                    <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                <h:outputLabel id="labelQuantity" value="#{germplasm$ListSemenGathering.quantityTotal}"/>
                                    </h:panelGrid>
                                    <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                        
                                        <!-- Botones de paginacion -->
                                        <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.firstResults}" id="btnFirst"
                                            rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisiblePrevious}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                        <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.previousResults}"
                                            id="btnPrevious" rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisiblePrevious}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                        <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.nextResults}" id="btnNext"
                                            rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisibleNext}"
                                            style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                        <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.lastResults}" id="btnLast"
                                            rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisibleNext}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>                                        
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{germplasm$PreviewSemenGathering.dataTableSemenGathering}" cellspacing="0"
                                        columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                        rowClasses="list-row-even,list-row-odd" rows="#{germplasm$SemenGatheringSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{germplasm$SemenGatheringSessionBean.pagination.dataProvider.list}" var="currentRow" width="600">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['semenGatheringDate']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.time}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['semenGatheringTime']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.volume}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['volume']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.motility}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['motility']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.consistency}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['semenConsistency']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.concentration}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['concentration']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.sperm_concentration_per_straw}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['spermConcentrationPerStraw']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.total_sperm_concentration}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['totalSpermConcentration']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.straw_quantity}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['strawQuantity']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.straw_size}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['strawSize']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.straw_color}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['strawColor']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.dilution}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['dilution']}"/>
                                        </h:column>                                        
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.semen_color}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['semenColor']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.tank_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['tankNumber']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.canister_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['canisterNumber']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.goblet_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['gobletNumber']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.ph}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['ph']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.mass_motility}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['massMotility']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.semen_gathering_method}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['semenGatheringMethod']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.solvent}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['solvent']}"/>
                                        </h:column>                                        
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.post_thaw_motility}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['postThawMotility']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.active_doses}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['activeDoses']}"/>
                                        </h:column>
                                    </h:dataTable>
                                    </h:panelGrid>

                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
