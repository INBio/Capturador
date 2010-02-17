<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : StandardPlinian
    Created on : 05/11/2009, 11:19:12 AM
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
                            <webuijsf:bubble id="bubble1" style="left: 888px; top: 48px; position: absolute" title="#{resources.standard_bubble_title}">
                                <webuijsf:staticText text="#{resources.plic_bubble_text}"/>
                            </webuijsf:bubble>
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_share_plinian}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 144px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{reports$StandardPlinian.bshareAll_action}" id="bshareAll" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.button_crear_snapshot_todo}"/>
                                </webuijsf:panelGroup>
                                <h:panelGrid columns="1" id="gridpSubMain" style="height: 100px" width="840">
                                    <h:panelGrid columns="3" id="gridPanelReload" style="border: 1px dotted gray; height: 24px" width="840">
                                        <webuijsf:label id="labelReload"
                                            style="font-size: 12px; font-style: normal; font-weight: normal; height: 24px; width: 620px" text="#{resources.plic_reload_message}"/>
                                        <h:commandButton action="#{reports$StandardPlinian.buttonReload_action}" id="buttonReload"
                                            style="color: rgb(2, 28, 102); font-style: italic; font-weight: bold; height: 24px; width: 119px" value="#{resources.dwc_button_reload}"/>
                                        <webuijsf:hyperlink id="hyperlink1" onClick="return false;"
                                            onMouseDown="document.getElementById('contenido:form1:bubble1').open(event);"
                                            onMouseOut="document.getElementById('contenido:form1:bubble1').close();"
                                            onMouseOver="document.getElementById('contenido:form1:bubble1').open(event);" style="height: 24px; width: 96px" text="#{resources.standard_bubble_title}"/>
                                    </h:panelGrid>
                                    <!-- More code here -->
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
