<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListSample
    Created on : 02/05/2011, 03:55:58 PM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.samples}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                    <!-- Tabla que posee la lista de breeds -->
                                    <h:panelGrid binding="#{samplemanage$ListSample.mainPanel}" id="gridpGathering_Main" style="position: relative" width="850">
                                        <!-- panel de busquedas -->
                                        <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                            <h:inputText id="txSimpleSearch" style="height: 18px; width: 408px">
                                                <f:validateLength maximum="100" minimum="0"/>
                                            </h:inputText>
                                            <h:commandButton  id="btnSimpleSearch" style="height: 25px; width: 160px"
                                                styleClass="My_Button" value="#{resources.search}"/>
                                        </h:panelGrid>
                                        <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                            <webuijsf:panelGroup id="grouppButtons">
                                                <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                    <h:outputLabel id="labelQuantity" value="#{samplemanage$ListSample.quantityTotal}"/>
                                                </h:panelGrid>
                                                <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                    <!-- Botones de acciones -->
                                                    <h:commandButton action="#{samplemanage$ListSample.btn_new_action}" id="btn_new"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                    <h:commandButton action="#{samplemanage$ListSample.btn_edit_action}" id="btn_edit"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                    <h:commandButton action="#{samplemanage$ListSample.btn_delete_action}" id="btn_delete"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                    <h:commandButton action="#{samplemanage$ListSample.btn_new_partition_action}" id="btn_new_partition"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new_partition_sample}"/>
                                                    <h:commandButton action="#{samplemanage$ListSample.btn_deliver_action}" id="btn_new_partition"
                                                                     style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.deliver}"/>
                                                    <!-- Botones de paginacion -->
                                                    <h:commandButton action="#{samplemanage$SampleManageSessionBean.pagination.firstResults}" id="btnFirst"
                                                        rendered="#{samplemanage$SampleManageSessionBean.pagination.isVisiblePrevious}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                    <h:commandButton action="#{samplemanage$SampleManageSessionBean.pagination.previousResults}"
                                                        id="btnPrevious" rendered="#{samplemanage$SampleManageSessionBean.pagination.isVisiblePrevious}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                    <h:commandButton action="#{samplemanage$SampleManageSessionBean.pagination.nextResults}" id="btnNext"
                                                        rendered="#{samplemanage$SampleManageSessionBean.pagination.isVisibleNext}"
                                                        style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                    <h:commandButton action="#{samplemanage$SampleManageSessionBean.pagination.lastResults}" id="btnLast"
                                                        rendered="#{samplemanage$SampleManageSessionBean.pagination.isVisibleNext}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                </webuijsf:panelGroup>
                                            </webuijsf:panelGroup>
                                                    <h:dataTable binding="#{samplemanage$ListSample.dataTableSamples}" cellspacing="0"
                                                columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                                rowClasses="list-row-even,list-row-odd" rows="#{samplemanage$SampleManageSessionBean.pagination.resultsPerPage}"
                                                style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                value="#{samplemanage$SampleManageSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                                <h:column>
                                                    <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.collectornumber}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['witness']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.taxon_name}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['taxonName']}"/>
                                                </h:column>
                                            </h:dataTable>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN Tabla que posee la lista de breeds -->
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
