<?xml version="1.0" encoding="UTF-8"?>
<!--
	Document   : PreviewSpecimen
	Created on : 24/02/2009, 04:40:15 PM
	Author     : herson
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <!--
                            <webuijsf:pageAlert binding="#{specimen$PreviewSpecimen.pageAlert1}" id="pageAlert1" rendered="false" style="height: 46px; left: 216px; top: 120px; position: absolute; width: 382px"/>
                            -->
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage"
                                style="left: 320px; top: 120px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label id="label1" style="font-size: 24px; height: 70px; left: 72px; top: 96px; position: absolute; width: 238px" text="#{resources.preview_label}"/>
                            <h:panelGrid columns="1" id="gridPanel2"
                                style="border-width: 1px; border-style: solid; height: 144px; left: 72px; top: 240px; position: absolute" width="528">
                                <h:panelGrid columns="2" id="gridPanel3" style="border-width: 1px; border-style: solid; height: 100%; text-align: center; width: 100%">
                                    <webuijsf:panelGroup id="groupPanel2">
                                        <webuijsf:button actionExpression="#{specimen$PreviewSpecimen.addButton_action}" id="addButton"
                                            style="height: 24px; width: 72px" text="#{resources.add}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelGroup id="groupPanel3">
                                        <webuijsf:button actionExpression="#{specimen$PreviewSpecimen.searchButton_action}" id="searchButton"
                                            style="height: 24px; width: 75px" text="#{resources.search}"/>
                                    </webuijsf:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid bgcolor="#cccccc" binding="#{specimen$PreviewSpecimen.filtersPanel}" columns="5" id="filtersPanel"
                                    style="height: 24px; text-align: center" width="527"/>
                                <h:panelGrid columns="1" id="gridPanel4" style="height: 120px; width: 100%">
                                    <webuijsf:label id="label3" text="#{resources.select_columns}"/>
                                    <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{specimen$PreviewSpecimen.addRemoveList1}"
                                        id="addRemoveList1" items="#{specimen$PreviewSpecimen.addRemoveList1DefaultOptions.options}" selectAll="true"
                                        selected="#{specimen$SpecimenSessionBean.dwcSelectedElements}" selectedItemsLabel="#{resources.selected}"/>
                                </h:panelGrid>
                                <h:panelGrid columns="2" id="gridPanel5" style="border-width: 1px; border-style: solid; height: 100%; width: 100%">
                                    <webuijsf:label id="label2" text="#{resources.reload_message}"/>
                                    <webuijsf:panelGroup id="groupPanel1" style="">
                                        <webuijsf:button actionExpression="#{specimen$PreviewSpecimen.reloadButton_action}" id="reloadButton"
                                            style="height: 24px; width: 72px" text="#{resources.reload}"/>
                                    </webuijsf:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
