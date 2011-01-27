<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : About
    Created on : 22/09/2009, 04:14:27 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header_Select.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1" style="height: 600px">
                                <h:outputLabel id="lbTitle" style="left: 24px; top: 10px; position: relative;" styleClass="Page_title" value="#{resources.sponsors}"/>
                                <webuijsf:imageHyperlink alt="logo-INBio" id="inbio_logo" imageURL="/resources/images/inbio.png"
                                    style="left: 168px; top: 120px; position: absolute" target="_blank" url="http://www.inbio.ac.cr"/>
                                <webuijsf:imageHyperlink id="logo-fundecooperación" imageURL="/resources/images/fundecooperacion.gif"
                                    style="left: 624px; top: 96px; position: absolute" target="_blank"  url="http://www.fundecooperacion.org/"/>
                                <webuijsf:imageHyperlink id="logo-iabin" target="_blank"  imageURL="/resources/images/iabin.jpg"
                                    style="left: 264px; top: 264px; position: absolute" url="http://iabin.net"/>
                                <webuijsf:imageHyperlink id="logo-conicit" imageURL="/resources/images/conicit.png"
                                    style="left: 576px; top: 336px; position: absolute" target="_blank" url="http://www.conicit.go.cr/"/>
                            </webuijsf:form>
                        </webuijsf:panelLayout>
                        <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div>
                    <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
