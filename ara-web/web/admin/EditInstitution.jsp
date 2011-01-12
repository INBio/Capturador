<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : EditInstitution
    Created on : 28/09/2009, 10:09:03 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.title_institutions_edit}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 55px; width: 840px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                        <h:commandButton action="#{admin$EditInstitution.btnEditInstitution_action}" id="btnSaveInstitution"
                                            style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelLayout id="layoutpDetails" style="height: 192px; width: 840px; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="txName" id="lbName" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 140px" text="#{resources.name}"/>
                                        <webuijsf:label for="txPhone" id="lbPhone" style="height: 24px; left: 24px; top: 48px; position: absolute; width: 140px" text="#{resources.phone}"/>
                                        <webuijsf:label for="txFax" id="lbFax" style="height: 24px; left: 24px; top: 72px; position: absolute; width: 140px" text="#{resources.fax}"/>
                                        <webuijsf:label for="txCountry" id="lbCountry"
                                            style="height: 24px; left: 24px; top: 96px; position: absolute; width: 140px" text="#{resources.country}"/>
                                        <webuijsf:label for="txProvince" id="lbProvince"
                                            style="height: 24px; left: 24px; top: 120px; position: absolute; width: 140px" text="#{resources.state}"/>
                                        <webuijsf:label for="txCity" id="lbCity" style="height: 24px; left: 432px; top: 24px; position: absolute; width: 168px" text="#{resources.city}"/>
                                        <webuijsf:label for="txAdreess" id="lbAdreess"
                                            style="height: 24px; left: 432px; top: 48px; position: absolute; width: 168px" text="#{resources.address}"/>
                                        <webuijsf:label for="txInstitutionCode" id="lbInstitutionCode"
                                            style="height: 24px; left: 432px; top: 72px; position: absolute; width: 168px" text="#{resources.institution_code}"/>
                                        <webuijsf:label for="txAcronym" id="lbAcronym"
                                            style="height: 24px; left: 432px; top: 96px; position: absolute; width: 168px" text="#{resources.acronym}"/>
                                        <webuijsf:label id="lbURL" style="height: 24px; left: 432px; top: 120px; position: absolute; width: 168px" text="#{resources.web_site}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txName}" columns="25" id="txName" required="true"
                                            style="height: 24px; left: 168px; top: 24px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txPhone}" columns="25" id="txPhone"
                                            style="height: 24px; left: 168px; top: 48px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txFax}" columns="25" id="txFax"
                                            style="height: 24px; left: 168px; top: 72px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txCountry}" columns="25" id="txCountry"
                                            style="height: 24px; left: 168px; top: 96px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txProvince}" columns="25" id="txProvince"
                                            style="height: 24px; left: 168px; top: 120px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txCity}" columns="25" id="txCity"
                                            style="height: 24px; left: 600px; top: 24px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txAdreess}" columns="25" id="txAdreess"
                                            style="height: 24px; left: 600px; top: 48px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txInstitutionCode}" columns="25" id="txInstitutionCode"
                                            required="true" style="height: 24px; left: 600px; top: 72px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textField binding="#{admin$EditInstitution.txAcronym}" columns="25" id="txAcronym"
                                            style="height: 24px; left: 600px; top: 96px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textArea binding="#{admin$EditInstitution.taURL}" columns="24" id="taURL"
                                            style="height: 48px; left: 600px; top: 120px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.url_validate}"/>
                                    </webuijsf:panelLayout>
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
