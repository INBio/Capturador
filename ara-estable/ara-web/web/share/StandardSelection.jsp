<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : StandardSelection
    Created on : 23/03/2009, 08:30:47 AM
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
                            <h:panelGrid columns="1" id="gridPanelSelection" style="height: 24px; left: 24px; top: 48px; position: absolute" width="888">
                                <webuijsf:label id="label1" style="font-size: 18px; height: 24px; width: 838px" text="#{resources.standard_selection}"/>
                                <webuijsf:radioButtonGroup binding="#{share$StandardSelection.radioButtonGroup1}" id="radioButtonGroup1"
                                    selected="#{share$SessionBeanShare.result_radio_group}" style="font-size: 14px; height: 48px; width: 408px"/>
                                <webuijsf:button actionExpression="#{share$StandardSelection.button1_action}" id="button1" style="height: 24px; width: 119px" text="#{resources.standar_button}"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
