<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SpecimenReport
    Created on : 09/03/2009, 11:29:33 AM
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
                            <webuijsf:table augmentTitle="false" binding="#{specimen$SpecimenReport.table1}" id="table1" paginationControls="false"
                                style="height: 53px; left: 48px; top: 72px; position: absolute" title="#{resources.specimen_report}" width="600">
                                <webuijsf:tableRowGroup binding="#{specimen$SpecimenReport.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{specimen$SpecimenSessionBean.pagination.dataProvider}" sourceVar="currentRow"/>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:panelGroup separator=" " style="aling:center;">
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.firstResults}" id="btnFirst"
                                                text="#{resources.pagination_first}" visible="#{specimen$SpecimenSessionBean.pagination.isVisiblePrevious}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.previousResults}" id="btnNext"
                                                text="#{resources.pagination_previous}" visible="#{specimen$SpecimenSessionBean.pagination.isVisiblePrevious}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.nextResults}" id="btnPrevious"
                                                text="#{resources.pagination_next}" visible="#{specimen$SpecimenSessionBean.pagination.isVisibleNext}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.lastResults}" id="btnLast"
                                                text="#{resources.pagination_last}" visible="#{specimen$SpecimenSessionBean.pagination.isVisibleNext}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                        </webuijsf:form>
                        <webuijsf:label id="labelReportes" style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 454px" text="#{resources.specimen_report}"/>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
