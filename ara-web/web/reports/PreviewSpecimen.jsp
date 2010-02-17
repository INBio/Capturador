<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PreviewSpecimen
    Created on : 12/11/2009, 10:54:52 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.specimens_report}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{reports$PreviewSpecimen.searchButton_action}" id="searchButton"
                                        style="font-weight: bold; height: 24px; width: 168px" styleClass="My_Button" value="#{resources.search}"/>
                                </webuijsf:panelGroup>
                                <h:panelGrid columns="1" id="gridPanel2" style="height: 144px" width="840">
                                    <h:panelGrid columns="2" id="gridPanel5" style="border-width: 1px; border-top-color: gray; border-top-style: solid; height: 100%; width: 100%">
                                        <webuijsf:label id="label2" style="font-size: 12px; font-style: normal; font-weight: normal; height: 24px; width: 700px" text="#{resources.reload_message}"/>
                                        <webuijsf:panelGroup id="groupPanel1" style="">
                                            <h:commandButton action="#{reports$PreviewSpecimen.reloadButton_action}" id="reloadButton"
                                                style="color: rgb(2, 28, 102); font-style: italic; font-weight: bold; height: 24px; width: 119px" value="#{resources.dwc_button_reload}"/>
                                        </webuijsf:panelGroup>
                                    </h:panelGrid>
                                    <h:panelGrid columns="1" id="gridPanel4" style="border-top: solid gray 1px; height: 120px; width: 100%">
                                        <webuijsf:label id="label3" style="font-size: 18px; height: 24px; width: 600px" text="#{resources.select_columns}"/>
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{reports$PreviewSpecimen.addRemoveList1}"
                                            id="addRemoveList1" items="#{reports$PreviewSpecimen.addRemoveList1DefaultOptions.options}" selectAll="true"
                                            selected="#{reports$ReportsSessionBean.dwcSelectedElements}" selectedItemsLabel="#{resources.selected}" style=""/>
                                    </h:panelGrid>
                                    <webuijsf:hyperlink actionExpression="#{reports$PreviewSpecimen.addButton_action}" id="addHL"
                                        style="font-weight: bold; height: 24px; width: 120px" text="#{resources.dwc_add_button}"/>
                                    <h:panelGrid binding="#{reports$PreviewSpecimen.filtersPanel}" columns="5" id="filtersPanel"
                                        style="border: 1px solid gray; height: 24px; text-align: center" width="647"/>
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
