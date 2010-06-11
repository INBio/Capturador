<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditPerson
    Created on : 07/10/2009, 03:05:16 PM
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.titlePeopleEdit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                    <h:commandButton action="#{admin$EditPerson.btnUpdatePerson_action}" id="btnUpdatePerson" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.update}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:tabSet id="tabSetMain" lite="true" selected="tabPersonalInfo" style="height: 284px; width: 650px" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabPersonalInfo" text="#{resources.personal_information}">
                                        <webuijsf:panelLayout id="lpPersonal" style="height: 264px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label for="txName" id="lbName"
                                                style="height: 24px; left: 24px; top: 48px; position: absolute; width: 192px" text="#{resources.name}"/>
                                            <webuijsf:label for="tx1lastName" id="lb1lastName"
                                                style="height: 24px; left: 24px; top: 72px; position: absolute; width: 192px" text="#{resources.last_name}"/>
                                            <webuijsf:label for="tx2lastName" id="lb2lastName"
                                                style="height: 24px; left: 24px; top: 96px; position: absolute; width: 192px" text="#{resources.second_last_name}"/>
                                            <webuijsf:label for="txInitials" id="lbInitials"
                                                style="height: 24px; left: 24px; top: 120px; position: absolute; width: 192px" text="#{resources.initials}"/>
                                            <webuijsf:label for="txBirthDate" id="lbBirthDate"
                                                style="height: 24px; left: 24px; top: 144px; position: absolute; width: 192px" text="#{resources.birth_date}"/>
                                            <webuijsf:label for="txDeathDate" id="lbDeathDate"
                                                style="height: 24px; left: 24px; top: 168px; position: absolute; width: 192px" text="#{resources.death_date}"/>
                                            <webuijsf:label for="txOcupation" id="lbOcupation"
                                                style="height: 24px; left: 24px; top: 192px; position: absolute; width: 192px" text="#{resources.occupation}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txName}" columns="25" id="txName" required="true" style="height: 24px; left: 216px; top: 48px; position: absolute; width: 192px"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.tx1lastName}" columns="25" id="tx1lastName" required="true"
                                                style="height: 24px; left: 216px; top: 72px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.tx2lastName}" columns="25" id="tx2lastName"
                                                style="height: 24px; left: 216px; top: 96px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txInitials}" columns="25" id="txInitials"
                                                style="height: 24px; left: 216px; top: 120px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txBirthDate}" columns="4" id="txBirthDate" maxLength="4"
                                                style="height: 24px; left: 216px; top: 144px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.year_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txDeathDate}" columns="4" id="txDeathDate" maxLength="4"
                                                style="height: 24px; left: 216px; top: 168px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.year_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txOcupation}" columns="25" id="txOcupation"
                                                style="height: 24px; left: 216px; top: 192px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabContactInfo" text="#{resources.contact_information}">
                                        <webuijsf:panelLayout id="lpContact" style="height: 264px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label for="txEmail" id="lbEmail"
                                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 192px" text="#{resources.mail}"/>
                                            <webuijsf:label for="txWebSite" id="lbWebSite"
                                                style="height: 24px; left: 24px; top: 48px; position: absolute; width: 192px" text="#{resources.web}"/>
                                            <webuijsf:label for="txPhoneNumber" id="lbPhoneNumber"
                                                style="height: 24px; left: 24px; top: 72px; position: absolute; width: 192px" text="#{resources.phone_number}"/>
                                            <webuijsf:label for="txFax" id="lbFax" style="height: 24px; left: 24px; top: 96px; position: absolute; width: 192px" text="#{resources.fax}"/>
                                            <webuijsf:label for="txaAddress" id="lbAddress"
                                                style="height: 24px; left: 24px; top: 192px; position: absolute; width: 192px" text="#{resources.address}"/>
                                            <webuijsf:label for="txCity" id="lbCity"
                                                style="height: 24px; left: 24px; top: 120px; position: absolute; width: 192px" text="#{resources.city}"/>
                                            <webuijsf:label for="txProvience" id="lbProvience"
                                                style="height: 24px; left: 24px; top: 144px; position: absolute; width: 192px" text="#{resources.state}"/>
                                            <webuijsf:label for="txCountry" id="lbCountry"
                                                style="height: 24px; left: 24px; top: 168px; position: absolute; width: 192px" text="#{resources.country}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txEmail}" columns="25" id="txEmail"
                                                style="height: 24px; left: 216px; top: 24px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.txt_email_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txWebSite}" columns="25" id="txWebSite"
                                                style="height: 24px; left: 216px; top: 48px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.url_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txPhoneNumber}" columns="25" id="txPhoneNumber"
                                                style="height: 24px; left: 216px; top: 72px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txFax}" columns="25" id="txFax"
                                                style="height: 24px; left: 216px; top: 96px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.telephone_validate}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txCity}" columns="25" id="txCity"
                                                style="height: 24px; left: 216px; top: 120px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txProvience}" columns="25" id="txProvience"
                                                style="height: 24px; left: 216px; top: 144px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textField binding="#{admin$EditPerson.txCountry}" columns="25" id="txCountry"
                                                style="height: 24px; left: 216px; top: 168px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                            <webuijsf:textArea binding="#{admin$EditPerson.txaAddress}" columns="23" id="txaAddress"
                                                style="height: 30px; left: 216px; top: 192px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabProfiles" text="#{resources.menuModuleProfiles}">
                                        <webuijsf:panelLayout id="lpProfiles" style="height: 262px; position: relative; width: 100%; -rave-layout: grid">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove"
                                                style="height: 192px; left: 48px; top: 24px; position: absolute" styleClass="My_table" width="528">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" value="#{admin$PersonSessionBean.arProfilesEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableProfilesOptions" styleClass="My_white_label" value="#{admin$PersonSessionBean.arProfilesEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="7" style="width:250px" value="#{admin$PersonSessionBean.arProfilesEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{admin$PersonSessionBean.arProfilesEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{admin$PersonSessionBean.arProfilesEdit.addSelectedOptions}" id="btnAddOptions"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{admin$PersonSessionBean.arProfilesEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedprofileOptions" styleClass="My_white_label" value="#{admin$PersonSessionBean.arProfilesEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="7" style="width:250px" value="#{admin$PersonSessionBean.arProfilesEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{admin$PersonSessionBean.arProfilesEdit.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabInstitutions" text="#{resources.menuModuleInstitutions}">
                                        <webuijsf:panelLayout id="lpInstitutions" style="height: 262px; position: relative; width: 100%; -rave-layout: grid">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove"
                                                style="height: 192px; left: 48px; top: 24px; position: absolute" styleClass="My_table" width="528">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" value="#{admin$PersonSessionBean.arInstitutionesEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableInstitutionsOptions" styleClass="My_white_label" value="#{admin$PersonSessionBean.arInstitutionesEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="7" style="width:250px" value="#{admin$PersonSessionBean.arInstitutionesEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{admin$PersonSessionBean.arInstitutionesEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{admin$PersonSessionBean.arInstitutionesEdit.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{admin$PersonSessionBean.arInstitutionesEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedInstitutionsOptions" styleClass="My_white_label" value="#{admin$PersonSessionBean.arInstitutionesEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="7" style="width:250px" value="#{admin$PersonSessionBean.arInstitutionesEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{admin$PersonSessionBean.arInstitutionesEdit.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
