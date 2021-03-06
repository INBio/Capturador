<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListNomenclaturalGroup
    Created on : 23/11/2009, 03:54:21 PM
    Author     : asanabria
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="dataForm">
                                <h:outputLabel  id="lbTitle"
                                                style="height: 24px; left: 24px; position: relative; width: 850px"
                                                styleClass="Page_title"
                                                value="#{resources.menuModuleNomenclaturalGroups}"/>
                                <h:panelGrid columns="1"
                                             id="gridpMain"
                                             style="left: 24px; position: relative;width:95%;">
                                    <h:messages id="msglMessages"
                                                fatalClass="fatalMessage"
                                                errorClass="errorMessage"
                                                warnClass="warnMessage"
                                                infoClass="infoMessage"
                                                style="height: 30px; width: 840px" />

                                   <h:panelGrid id="gridpTableMain"
                                                cellspacing="1"
                                                columns="1"
                                                style="height: 24px;width:100%"
                                                styleClass="My_table">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1"
                                                         id="gridpquantity"
                                                         styleClass="My_table_top"
                                                         style="width:100%">
                                                <h:outputLabel id="labelQuantity"
                                                value="#{taxonomy$ListNomenclaturalGroup.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion"
                                                                 separator=" "
                                                                 style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton id="newButton"
                                                                 value="#{resources.btnNew}"
                                                                 action="#{taxonomy$ListNomenclaturalGroup.btnNewAction}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_table"/>
                                                <h:commandButton id="editButton"
                                                                 value="#{resources.btnEdit}"
                                                                 action="#{taxonomy$ListNomenclaturalGroup.btnEditAction}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_table"/>
                                                <h:commandButton id="deleteButton"
                                                                 value="#{resources.btnDelete}"
                                                                 action="#{taxonomy$ListNomenclaturalGroup.btnDeleteAction}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_table"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.pagination.firstResults}"
                                                                 id="btnFirst"
                                                                 rendered="#{taxonomy$NomenclaturalGroupSessionBean.pagination.isVisiblePrevious}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_first"
                                                                 value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.pagination.previousResults}"
                                                                 id="btnPrevious"
                                                                 rendered="#{taxonomy$NomenclaturalGroupSessionBean.pagination.isVisiblePrevious}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_previous"
                                                                 value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.pagination.nextResults}"
                                                                 id="btnNext"
                                                                 rendered="#{taxonomy$NomenclaturalGroupSessionBean.pagination.isVisibleNext}"
                                                                 style="margin: 2px; height: 22px"
                                                                 styleClass="My_Button_next"
                                                                 value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.pagination.lastResults}"
                                                                 id="btnLast"
                                                                 rendered="#{taxonomy$NomenclaturalGroupSessionBean.pagination.isVisibleNext}"
                                                                 style="margin: 2px;height: 22px"
                                                                 styleClass="My_Button_last"
                                                                 value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{taxonomy$ListNomenclaturalGroup.dataTable}"
                                                     cellspacing="0"
                                                     columnClasses="list-columns"
                                                     headerClass="list-header"
                                                     id="dataTablegathering"
                                                     rowClasses="list-row-even,list-row-odd"
                                                     rows="#{taxonomy$NomenclaturalGroupSessionBean.pagination.resultsPerPage}"
                                                     style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;width:100%;"
                                                     value="#{taxonomy$NomenclaturalGroupSessionBean.pagination.dataProvider.list}"
                                                     var="currentRow">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.identification}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['nomenclaturalGroupId']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['name']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.temporal}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['temporality']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.certifier}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['certificatorPerson']}"/>
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

