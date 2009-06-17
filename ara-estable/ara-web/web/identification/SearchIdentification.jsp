<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SearchIdentification
    Created on : 15/06/2009, 11:01:43 AM
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
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage"
                                style="height: 72px; left: 300px; top: 0px; position: absolute; width: 528px" warnClass="warnMessage"/>
                            <webuijsf:label id="label" style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.searchIdentifications}"/>
                            <webuijsf:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px groove black; height: 260px; left: 48px; top: 72px; position: absolute; width: 428px; -rave-layout: grid">
                                <webuijsf:label id="label_specimenId" style="left: 24px; top: 24px; position: absolute" text="#{resources.specimen_id}"/>
                                <webuijsf:textField binding="#{identification$SearchIdentification.txt_specimenId}" id="txt_specimenId"
                                    style="left: 192px; top: 24px; position: absolute; width: 215px" validatorExpression="#{identification$SearchIdentification.validatorHelper.validateTextFieldInputId}"/>
                                <webuijsf:label id="label_taxon" style="left: 24px; top: 48px; position: absolute" text="#{resources.taxon}"/>
                                <webuijsf:textField binding="#{identification$SearchIdentification.txt_taxon}" id="txt_taxon"
                                    style="left: 192px; top: 48px; position: absolute; width: 215px" validatorExpression="#{identification$SearchIdentification.validatorHelper.validateTextFieldInputTaxon}"/>
                                <webuijsf:label id="label_sequence" style="left: 24px; top: 72px; position: absolute" text="#{resources.sequence}"/>
                                <webuijsf:textField binding="#{identification$SearchIdentification.txt_sequence}" id="txt_sequence"
                                    style="left: 192px; top: 72px; position: absolute; width: 215px" validatorExpression="#{identification$SearchIdentification.validatorHelper.validateTextFieldInputSequence}"/>
                                <webuijsf:label id="label_identificationDate" style="left: 24px; top: 96px; position: absolute" text="#{resources.identification_date}"/>
                                <webuijsf:calendar binding="#{identification$SearchIdentification.cal_identificationDate}" id="cal_identificationDate"
                                    maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" style="position: absolute; left: 183px; top: 96px; width: 144px; height: 24px"/>
                                <webuijsf:label id="label_identifier" style="left: 24px; top: 120px; position: absolute" text="#{resources.identifier}"/>
                                <webuijsf:textField binding="#{identification$SearchIdentification.txt_identifier}" id="txt_identifier"
                                    style="left: 192px; top: 120px; position: absolute; width: 215px" validatorExpression="#{identification$SearchIdentification.validatorHelper.validateTextFieldInputIdentifier}"/>
                                <webuijsf:label id="label_type" style="left: 24px; top: 144px; position: absolute" text="#{resources.type}"/>
                                <webuijsf:textField binding="#{identification$SearchIdentification.txt_type}" id="txt_type"
                                    style="left: 192px; top: 144px; position: absolute; width: 215px" validatorExpression="#{identification$SearchIdentification.validatorHelper.validateTextFieldInputTaxon}"/>
                                <webuijsf:button actionExpression="#{identification$SearchIdentification.searchButton_action}" id="searchButton1"
                                    style="height: 24px; left: 167px; top: 216px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
