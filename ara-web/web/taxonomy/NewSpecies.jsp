<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewSpecies
    Created on : 13/10/2009, 03:07:49 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.new_species_record}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 40px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{taxonomy$NewSpecies.btnNewTaxonDescription_action}" id="btnNewTaxonDescription"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="lnTitle" style="height: 124px; position: relative; width: 770px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label for="ddScientificName" id="lbScientificName"
                                        style="height: 24px; left: 24px; top: 24px; position: absolute; width: 140px" text="#{resources.taxon_name}"/>
                                    <webuijsf:label for="txSequence" id="lbSequence"
                                        style="height: 24px; left: 24px; top: 48px; position: absolute; width: 140px" text="#{resources.sequence}"/>
                                    <webuijsf:label for="txTitle" id="label3" style="height: 24px; left: 24px; top: 72px; position: absolute; width: 140px" text="#{resources.title}"/>
                                    <webuijsf:label for="ddLanguage" id="lbLanguage"
                                        style="height: 24px; left: 408px; top: 24px; position: absolute; width: 140px" text="#{resources.language}"/>
                                    <webuijsf:label for="ddStatus" id="lbStatus" style="height: 24px; left: 408px; top: 48px; position: absolute; width: 140px" text="#{resources.status}"/>
                                    <webuijsf:label for="ddInstitutions" id="labelInstitutions" requiredIndicator="true"
                                        style="position: absolute; left: 408px; top: 72px; width: 144px; height: 24px" text="#{resources.institution}"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewSpecies.ddScientificName}" id="ddScientificName"
                                        items="#{taxonomy$NewSpecies.scientificNameData.options}" required="true"
                                        selected="#{taxonomy$SpeciesSessionBean.selectedScientificName}"
                                        style="height: 24px; left: 168px; top: 24px; position: absolute" width="192px"/>
                                    <webuijsf:textField binding="#{taxonomy$NewSpecies.txSequence}" columns="26" id="txSequence" required="true"
                                        style="height: 24px; left: 168px; top: 48px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                    <webuijsf:textField binding="#{taxonomy$NewSpecies.txTitle}" columns="26" id="txTitle"
                                        style="height: 24px; left: 168px; top: 72px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewSpecies.ddLanguage}" id="ddLanguage"
                                        items="#{taxonomy$NewSpecies.languageData.options}" selected="#{taxonomy$SpeciesSessionBean.selectedLanguage}"
                                        style="height: 24px; left: 552px; top: 24px; position: absolute" width="192px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewSpecies.ddStatus}" id="ddStatus" items="#{taxonomy$NewSpecies.statusData.options}"
                                        required="true" selected="#{taxonomy$SpeciesSessionBean.selectedStatus}"
                                        style="height: 24px; left: 552px; top: 48px; position: absolute" width="192px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewSpecies.ddInstitutions}" id="ddInstitutions"
                                        items="#{taxonomy$NewSpecies.institutionsData.options}" required="true"
                                        selected="#{taxonomy$SpeciesSessionBean.selectedInstitution}"
                                        style="height: 24px; left: 552px; top: 72px; position: absolute" width="192px"/>
                                </webuijsf:panelLayout>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
