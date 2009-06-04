<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchSite
    Created on : 04/06/2009, 09:08:37 AM
    Author     : herson
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                    <webuijsf:script>
                        function toggleDisabled(Elemento) {
                            alert(Elemento);
                            var domNode = document.getElementById(Elemento); // Get menu
                            return domNode.setProps({disabled: !domNode.getProps().disabled}); // Toggle disabled state
                        }
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido1" style="position: relative; -rave-layout: grid">
                        <webuijsf:form id="form1">
                            <webuijsf:pageAlert binding="#{site$SearchSite.searchAlert}" id="searchAlert" rendered="false" style="height: 72px; left: 300px; top: 0px; position: absolute; width: 528px"/>
                            <webuijsf:label id="label" style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.searchLocation}"/>
                            <webuijsf:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px groove black; height: 236px; left: 48px; top: 72px; position: absolute; width: 428px; -rave-layout: grid">
                                <webuijsf:label id="label_identification" style="left: 24px; top: 24px; position: absolute" text="#{resources.identification}"/>
                                <webuijsf:textField binding="#{site$SearchSite.txt_identification}" id="txt_identification" style="left: 192px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:label id="label_description" style="left: 24px; top: 48px; position: absolute" text="#{resources.description}"/>
                                <webuijsf:textField binding="#{site$SearchSite.txt_description}" id="txt_description" style="left: 192px; top: 48px; position: absolute; width: 215px"/>
                                <webuijsf:label id="label_type" style="left: 24px; top: 72px; position: absolute" text="#{resources.type}"/>
                                <webuijsf:dropDown binding="#{site$SearchSite.dd_type}" disabled="true" id="dd_type"
                                    items="#{site$SiteSessionBean.featureTypeOption}" style="left: 192px; top: 72px; position: absolute" valueChangeListenerExpression="#{site$SearchSite.dd_type_processValueChange}"/>
                                <webuijsf:label id="label_baseProjection" style="left: 24px; top: 96px; position: absolute" text="#{resources.base_proyection}"/>
                                <webuijsf:dropDown binding="#{site$SearchSite.dd_baseProjection}" disabled="true" id="dd_baseProjection"
                                    items="#{site$SiteSessionBean.projectionOption}" style="left: 192px; top: 96px; position: absolute"/>
                                <webuijsf:label id="label_determinationMethod" style="left: 24px; top: 120px; position: absolute" text="#{resources.determination_method}"/>
                                <webuijsf:dropDown binding="#{site$SearchSite.dd_determinationMethod}" disabled="true" id="dd_determinationMethod"
                                    items="#{site$SiteSessionBean.siteCalculationMethod}" style="left: 192px; top: 120px; position: absolute"/>
                                <webuijsf:button actionExpression="#{site$SearchSite.searchButton_action}" id="searchButton"
                                    style="height: 24px; left: 167px; top: 192px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
