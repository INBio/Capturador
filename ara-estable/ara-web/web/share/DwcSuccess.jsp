<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DwcSuccess
    Created on : 20/04/2009, 04:37:09 PM
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
                        <webuijsf:form id="form1"/>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglistDwcsuccess" infoClass="infoMessage"
                        style="border: 2px solid gray; background-color: rgb(243, 255, 242); font-family: 'Georgia','Times New Roman','times',serif; font-size: 24px; font-style: normal; font-weight: bold; height: 70px; left: 24px; top: 216px; position: absolute; width: 812px" warnClass="warnMessage"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
