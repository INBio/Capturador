<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : StandardSelection
    Created on : 05/11/2009, 11:16:48 AM
    Author     : esmata
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
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.standard_selection}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="650">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 20px; width: 650px" warnClass="warnMessage"/>

                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                        <h:commandButton action="#{reports$StandardSelection.btnProcced_action}" id="btnProcced" style="height: 24px; width: 160px"
                                            styleClass="My_Button" value="#{resources.button_proceed}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:radioButtonGroup binding="#{reports$StandardSelection.radioButtonGroup}" id="radioButtonGroup" items="#{reports$StandardSelection.radioData.options}"
                                        selected="#{reports$SnapshotSessionBean.resultRadioGroup}" style="font-size: 14px; height: 48px; width: 408px"/>

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
