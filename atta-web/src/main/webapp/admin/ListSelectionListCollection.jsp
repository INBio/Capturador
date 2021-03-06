<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListSelectionList.jsp
    Created on : Sep 22, 2009, 11:24:26 AM
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
                                <h:outputLabel id="lbMainTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.menuModuleSelectionLists}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 30px; width: 840px" warnClass="warnMessage"/>

                                    <h:panelGrid columns="1" id="selectionListValue"
                                    style="left: 24px; position: relative" width="850">
                                        <webuijsf:label id="selectionList" style="height: 24px; left: 24px; position: relative; width: 850px"
                                            text="#{resources.subtitle_admin_selection_list}"/>
                                        <webuijsf:dropDown actionExpression="#{admin$ListSelectionListCollection.onSelectionListChange}" id="ddSelectionList"
                                            items="#{admin$SelectionListSessionBean.selectionListData.options}"
                                            selected="#{admin$SelectionListSessionBean.selectedSelectionListEntityId}" style="position: relative"
                                            submitForm="true" width="400px"/>
                                    </h:panelGrid>

                                    <h:panelGrid binding="#{admin$ListSelectionListCollection.selectionListValuePanel}" columns="1" id="selectionListValuePanel"
                                    style="left: 24px; position: relative" width="850">
                                        <webuijsf:label id="SelectionListValue" style="height: 24px; left: 24px; position: relative; width: 850px"
                                            text="#{resources.subtitle_admin_selection_list_value}"/>
                                        <webuijsf:dropDown actionExpression="#{admin$ListSelectionListCollection.onSelectionListValueChange}" id="ddSelectionListValue"
                                            items="#{admin$SelectionListSessionBean.selectionListValueData.options}"
                                            selected="#{admin$SelectionListSessionBean.selectedSelectionListValueId}" style="position: relativa"
                                            submitForm="true" width="400px"/>
                                    </h:panelGrid>

                                    <h:panelGrid binding="#{admin$ListSelectionListCollection.actionTable}" cellspacing="1" columns="1" id="actionTable"
                                    style="left: 24px; position: relative" width="840">

                                        <!-- Colecciones Asociadas-->
                                        <webuijsf:label id="labelColeccionesAsociadas" style="font-size: 24px; height: 46px; left: 24px; width: 574px" text="#{resources.associated_collections}"/>
                                        <h:panelGrid cellspacing="1" columns="2" id="valuesTableButtons" rendered="true" style="height: 24px; left: 24px;" width="840">
                                            <h:commandButton action="#{admin$ListSelectionListCollection.btn_save_action}" id="btn_new"
                                            style="margin: 2px; height: 22px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                        </h:panelGrid>
                                        <!-- add remove -->
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" id="associationsBla"
                                            items="#{admin$SelectionListSessionBean.associatedCollections.options}"
                                            selected="#{admin$SelectionListSessionBean.associatedCollections.selectedValue}" selectedItemsLabel="#{resources.selected}" style="left: 24px; position: relative"/>
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
