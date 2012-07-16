<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : autocomplete
    Created on : Jan 21, 2011, 9:38:29 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <!-- Added to achive autocomplete functionality -->
                <webuijsf:head binding="#{Header_Login.head1}" debug="true" id="head1" webuiAll="true" webuiJsfx="true">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbSiteTitle" style="width: 600px;height: 24px; left: 10px; position: relative;" styleClass="Page_title" value="#{resources.localities}"/>
                                <h:panelGrid id="gridpAutocomplete" style=" width:600px" styleClass="AutocompletePanel">
                                    <!-- Added to achive autocomplete functionality -->
                                    <webuijsf:textField
                                        autoComplete="true"
                                        autoCompleteExpression = "#{AutoCompleteBean.getOptions}"
                                        id = "tfAutocomplete"
                                        columns="30"
                                        style="height: 24px; position: relative; width: 840px"
                                        label = "#{resources.localities}: ">
                                    </webuijsf:textField>
                                </h:panelGrid>
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
