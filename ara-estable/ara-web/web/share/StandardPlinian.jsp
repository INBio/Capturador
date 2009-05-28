<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : StandardPlinian
    Created on : 23/03/2009, 08:32:42 AM
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
                            <webuijsf:label id="lbPlinianSnapshot"
                                style="font-size: 25px; height: 24px; left: 24px; top: 48px; position: absolute; width: 862px" text="#{resources.title_share_plinian}"/>
                            <h:panelGrid columns="1" id="gridpMainPli" style="border: 1px solid gray; height: 24px; left: 24px; top: 96px; position: absolute" width="864">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageListPli" infoClass="infoMessage"
                                    style="height: 24px; width: 694px" warnClass="warnMessage"/>
                                <h:panelGrid columns="2" id="grippReload" style="height: 24px" width="864">
                                    <webuijsf:label id="lbReload" style="font-size: 12px; font-style: normal; font-weight: normal; height: 24px; width: 670px" text="#{resources.dwc_reload_message}"/>
                                    <webuijsf:button actionExpression="#{share$StandardPlinian.btnReload_action}" id="btnReload"
                                        style="color: #021c66; font-style: italic; font-weight: bold; height: 24px; width: 119px" text="#{resources.dwc_button_reload}"/>
                                </h:panelGrid>
                                <webuijsf:pageSeparator id="pageSeparatorPli2" style="height: 0px; width: 839px"/>
                                <webuijsf:label id="lbInstructionsElements" style="font-size: 18px; height: 24px; width: 862px" text="#{resources.plinian_instructions}"/>
                                <h:panelGrid binding="#{share$StandardPlinian.elementsPanel}" columns="4" id="elementsPanel"
                                    style="border: 1px solid gray; height: 24px" width="839"/>
                                <webuijsf:pageSeparator id="pageSeparatorPli" style="height: 0px; width: 839px"/>
                                <webuijsf:label id="lbInstructionPli2" style="font-size: 18px; height: 24px; width: 862px" text="#{resources.plinian_instructions2}"/>
                                <webuijsf:hyperlink actionExpression="#{share$StandardPlinian.hyperlink1_action}" id="hyperlink1"
                                    style="height: 24px; width: 144px" text="#{resources.dwc_add_button}"/>
                                <h:panelGrid binding="#{share$StandardPlinian.filtersPanel}" columns="5" id="filtersPanel"
                                    style="border: 1px solid gray; height: 24px" width="648"/>
                                <h:panelGrid columns="2" id="gridpButtons" style="height: 24px" width="287">
                                    <webuijsf:button id="buPlinianShareAll" style="font-weight: bold; height: 24px; width: 144px" text="#{resources.button_crear_snapshot_todo}"/>
                                    <webuijsf:button actionExpression="#{share$StandardPlinian.buPlinianShare_action}" id="buPlinianShare"
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
