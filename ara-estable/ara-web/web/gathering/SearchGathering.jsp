<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchGathering
    Created on : 31/05/2009, 01:13:15 PM
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
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido1" style="position: relative; -rave-layout: grid">
                        <webuijsf:form id="form1">
                            <webuijsf:pageAlert binding="#{gathering$SearchGathering.searchAlert}" id="searchAlert" rendered="false" style="height: 72px; left: 300px; top: 0px; position: absolute; width: 528px"/>
                            <webuijsf:label id="label1" style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.searchGatherings}"/>
                            <webuijsf:panelLayout id="layoutPanel1" style="border: 2px groove black; height: 236px; left: 48px; top: 72px; position: absolute; width: 404px; -rave-layout: grid">
                                <webuijsf:label id="label_identification" style="left: 24px; top: 24px; position: absolute" text="#{resources.identification}"/>
                                <webuijsf:textField binding="#{gathering$SearchGathering.txt_identification}" id="txt_identification" style="left: 202px; top: 24px; position: absolute; width: 200px"/>
                                <webuijsf:label id="label_locality" style="left: 24px; top: 48px; position: absolute" text="#{resources.locality}"/>
                                <webuijsf:textField binding="#{gathering$SearchGathering.txt_locality}" id="txt_locality" style="left: 202px; top: 48px; position: absolute; width: 200px"/>
                                <webuijsf:label id="label_init_date" style="left: 24px; top: 72px; position: absolute" text="#{resources.initial_date}"/>
                                <webuijsf:calendar binding="#{gathering$SearchGathering.cal_init_date}" dateFormatPattern="dd/MM/yyyy" id="cal_init_date"
                                    maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" style="height: 24px; left: 192px; top: 72px; position: absolute; width: 144px"/>
                                <webuijsf:label id="label_final_date" style="left: 24px; top: 96px; position: absolute" text="#{resources.final_date}"/>
                                <webuijsf:calendar binding="#{gathering$SearchGathering.cal_final_date}" dateFormatPattern="dd/MM/yyyy" id="cal_final_date"
                                    maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" style="height: 24px; left: 192px; top: 96px; position: absolute; width: 168px"/>
                                <webuijsf:label id="label_responsible" style="left: 24px; top: 120px; position: absolute" text="#{resources.responsible}"/>
                                <webuijsf:textField binding="#{gathering$SearchGathering.txt_resposible}" id="txt_resposible" style="left: 202px; top: 120px; position: absolute; width: 200px"/>
                                <webuijsf:label id="label_collection" style="left: 24px; top: 144px; position: absolute" text="#{resources.collection}"/>
                                <webuijsf:textField binding="#{gathering$SearchGathering.txt_collection}" id="txt_collection" style="left: 202px; top: 144px; position: absolute; width: 200px"/>
                                <webuijsf:button actionExpression="#{gathering$SearchGathering.searchButton_action}" id="searchButton1"
                                    style="height: 24px; left: 201px; top: 192px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
