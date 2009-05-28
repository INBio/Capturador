<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : StandardDarwin
    Created on : 23/03/2009, 08:31:40 AM
    Author     : esmata
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
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form id="form1">
                            <webuijsf:bubble id="bubble1" style="left: 888px; top: 48px; position: absolute" title="#{resources.standard_bubble_title}">
                                <webuijsf:staticText text="#{resources.standard_bubble_text}"/>
                            </webuijsf:bubble>
                            <webuijsf:label id="lbDarwinSanapshot"
                                style="font-size: 25px; height: 24px; left: 24px; top: 48px; position: absolute; width: 862px" text="#{resources.title_share_darwin}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="border: 1px solid gray; height: 168px; left: 24px; top: 96px; position: absolute" width="864">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageListDarwin" infoClass="infoMessage"
                                    style="height: 24px; width: 360px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridPanelReload" style="height: 24px" width="840">
                                    <webuijsf:label id="labelReload"
                                        style="font-size: 12px; font-style: normal; font-weight: normal; height: 24px; width: 685px" text="#{resources.dwc_reload_message}"/>
                                    <webuijsf:button actionExpression="#{share$StandardDarwin.buttonReload_action}" id="buttonReload"
                                        style="color: rgb(2, 28, 102); font-style: italic; font-weight: bold; height: 24px; width: 119px" text="#{resources.dwc_button_reload}"/>
                                    <webuijsf:hyperlink id="hyperlink1" onClick="return false;"
                                        onMouseDown="document.getElementById('contenido:form1:bubble1').open(event);"
                                        onMouseOut="document.getElementById('contenido:form1:bubble1').close();"
                                        onMouseOver="document.getElementById('contenido:form1:bubble1').open(event);" style="height: 24px; width: 96px" text="#{resources.standard_bubble_title}"/>
                                </h:panelGrid>
                                <webuijsf:pageSeparator id="pageSeparator3" style="height: 0px; width: 840px"/>
                                <webuijsf:label id="linstructionsElements" style="font-size: 18px; height: 24px; width: 450px" text="#{resources.darwin_insatructions}"/>
                                <h:panelGrid binding="#{share$StandardDarwin.elementsPanel}" columns="4" id="elementsPanel"
                                    style="border: 1px solid gray; height: 24px" width="839"/>
                                <webuijsf:pageSeparator id="pageSeparator1" style="height: 0px; width: 840px"/>
                                <webuijsf:label id="linstructionsInfo" style="font-size: 18px; height: 24px; width: 336px" text="#{resources.darwin_insatructions2}"/>
                                <webuijsf:hyperlink actionExpression="#{share$StandardDarwin.hyperlinkAdd_action}" id="hyperlinkAdd"
                                    style="height: 22px; width: 120px" text="#{resources.dwc_add_button}"/>
                                <h:panelGrid binding="#{share$StandardDarwin.filtersPanel}" columns="5" id="filtersPanel"
                                    style="border: 1px solid gray; height: 24px" width="647"/>
                                <h:panelGrid columns="2" id="gridPanelButtons" style="height: 24px" width="263">
                                    <webuijsf:button actionExpression="#{share$StandardDarwin.bshareAll_action}" id="bshareAll"
                                        style="font-weight: bold; height: 24px; width: 120px" text="#{resources.button_crear_snapshot_todo}"/>
                                    <webuijsf:button actionExpression="#{share$StandardDarwin.bshare_action}" id="bshare"
                                        style="font-weight: bold; height: 24px; width: 120px" text="#{resources.button_crear_snapshot}"/>
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
