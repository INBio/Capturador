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
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_institutions_edit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 55px; width: 840px" warnClass="warnMessage"/>

                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{admin$EditInstitution.btnEditInstitution_action}" id="btnSaveInstitution" style="height: 24px; width: 175px"
                                    styleClass="My_Button" value="#{resources.update}"/>
                                </webuijsf:panelGroup>

                                <webuijsf:panelLayout id="layoutpDetails" style="height: 192px; width: 840px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label for="txName" id="lbName" style="position: absolute; left: 24px; top: 24px; width: 168px; height: 24px" text="#{resources.name}"/>
                                    <webuijsf:label for="txPhone" id="lbPhone" style="position: absolute; left: 24px; top: 48px; width: 168px; height: 24px" text="#{resources.phone}"/>
                                    <webuijsf:label for="txFax" id="lbFax" style="position: absolute; left: 24px; top: 72px; width: 168px; height: 24px" text="#{resources.fax}"/>
                                    <webuijsf:label for="txCountry" id="lbCountry" style="position: absolute; left: 24px; top: 96px; width: 168px; height: 24px" text="#{resources.country}"/>
                                    <webuijsf:label for="txProvince" id="lbProvince"
                                        style="position: absolute; left: 24px; top: 120px; width: 168px; height: 24px" text="#{resources.state}"/>
                                    <webuijsf:label for="txCity" id="lbCity" style="position: absolute; left: 456px; top: 24px; width: 168px; height: 24px" text="#{resources.city}"/>
                                    <webuijsf:label for="txAdreess" id="lbAdreess"
                                        style="position: absolute; left: 456px; top: 48px; width: 168px; height: 24px" text="#{resources.address}"/>
                                    <webuijsf:label for="txInstitutionCode" id="lbInstitutionCode"
                                        style="position: absolute; left: 456px; top: 72px; width: 168px; height: 24px" text="#{resources.institution_code}"/>
                                    <webuijsf:label for="txAcronym" id="lbAcronym"
                                        style="position: absolute; left: 456px; top: 96px; width: 168px; height: 24px" text="#{resources.acronym}"/>
                                    <webuijsf:label id="lbURL" style="position: absolute; left: 456px; top: 120px; width: 168px; height: 24px" text="#{resources.web_site}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txName}" columns="25" id="txName" required="true" style="position: absolute; left: 192px; top: 24px; width: 120px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txPhone}" columns="25" id="txPhone" style="position: absolute; left: 192px; top: 48px; width: 144px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txFax}" columns="25" id="txFax" style="position: absolute; left: 192px; top: 72px; width: 120px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txCountry}" columns="25" id="txCountry" style="position: absolute; left: 192px; top: 96px; width: 120px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txProvince}" columns="25" id="txProvince" style="height: 24px; left: 192px; top: 120px; position: absolute; width: 120px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txCity}" columns="25" id="txCity" style="position: absolute; left: 624px; top: 24px; width: 144px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txAdreess}" columns="25" id="txAdreess" style="position: absolute; left: 624px; top: 48px; width: 144px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txInstitutionCode}" columns="25" id="txInstitutionCode" required="true" style="position: absolute; left: 624px; top: 72px; width: 144px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textField binding="#{admin$EditInstitution.txAcronym}" columns="25" id="txAcronym" style="position: absolute; left: 624px; top: 96px; width: 144px; height: 24px"
                                    validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textArea binding="#{admin$EditInstitution.taURL}" columns="24" id="taURL" style="position: absolute; left: 624px; top: 120px; width: 192px; height: 48px"
                                    validatorExpression="#{util$ValidatorBean.url_validate}"/>
                                </webuijsf:panelLayout>                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
