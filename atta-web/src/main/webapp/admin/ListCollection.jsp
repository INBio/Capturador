<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListCollection.jsp
    Created on : Sep 21, 2009, 8:24:26 AM
    Author     : jgutierrez
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
                                <h:outputLabel id="lbAdminCollectionTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.menuModuleAdminCollections}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative;width:95%">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                                style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtons" style="width:100%" styleClass="My_table">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" style="width:100%">
                                                <h:outputLabel id="labelQuantity" value="#{admin$ListCollection.quantityTotal}"/>
                                            </h:panelGrid>
                                            <h:commandButton action="#{admin$ListCollection.btn_new_action}" id="btn_new" style="margin: 2px; height: 22px"
                                                             styleClass="My_Button_table" value="#{resources.btnNew}"/>
                                            <h:commandButton action="#{admin$ListCollection.btn_edit_action}" id="btn_edit" style="margin: 2px; height: 22px"
                                                             styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                            <h:commandButton action="#{admin$ListCollection.btn_delete_action}" id="btn_del" style="margin: 2px; height: 22px"
                                                             styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                            <h:panelGrid binding="#{admin$ListCollection.gridEditOrNew}" columns="4" id="gridEditOrNew" rendered="false"
                                                         style="height: 5px" styleClass="My_subpanel_white" width="840">
                                                <h:panelGrid columns="2" id="input" style="height: 24px" width="820">
                                                    <webuijsf:label for="txName" id="lbName" text="#{resources.collection}"/>
                                                    <webuijsf:textField columns="40" id="txName" text="#{admin$CollectionSessionBean.actualCollectionDTO.collectionName}"/>
                                                    <webuijsf:label for="tfDescription" id="lbDescription" text="#{resources.description}"/>
                                                    <webuijsf:textArea columns="51" id="tfDescription" text="#{admin$CollectionSessionBean.actualCollectionDTO.collectionDescription}" />
                                                    <h:commandButton action="#{admin$ListCollection.btn_save_action}" id="btn_save"
                                                                     style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.btnSave}"/>
                                                    <h:commandButton action="#{admin$ListCollection.btn_cancel_action}" id="btn_cancel"
                                                                     style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.btnCancel}"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <h:commandButton action="#{admin$CollectionSessionBean.pagination.firstResults}" id="btnFirst"
                                                                 rendered="#{admin$CollectionSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{admin$CollectionSessionBean.pagination.previousResults}" id="btnPrevious"
                                                                 rendered="#{admin$CollectionSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{admin$CollectionSessionBean.pagination.nextResults}" id="btnNext"
                                                                 rendered="#{admin$CollectionSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{admin$CollectionSessionBean.pagination.lastResults}" id="btnLast"
                                                                 rendered="#{admin$CollectionSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{admin$CollectionSessionBean.dataTableCollections}" cellspacing="0" columnClasses="list-columns"
                                                     headerClass="list-header" id="dataTableCollections" rowClasses="list-row-even,list-row-odd"
                                                     rows="#{admin$CollectionSessionBean.pagination.resultsPerPage}"
                                                     style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;width:100%;"
                                                     value="#{admin$CollectionSessionBean.pagination.dataProvider.list}" var="currentRow">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.collection}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['collectionName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.description}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['collectionDescription']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
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
