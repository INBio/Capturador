<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditSpecies
    Created on : 13/10/2009, 03:07:12 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script type="text/javascript" url="/resources/tinymce/jscripts/tiny_mce/tiny_mce.js"/>
                    <webuijsf:script type="text/javascript">
                        tinyMCE.init({
                        mode : "textareas",
                        theme : "advanced",
                        plugins : "table",
                        // Theme options
                        theme_advanced_buttons1 : "bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,|,formatselect,fontsizeselect,|,undo,redo",
                        theme_advanced_buttons2 : "bullist,numlist, |,tablecontrols",
                        theme_advanced_buttons3 : "",
                        theme_advanced_buttons4 : "",
                        theme_advanced_toolbar_location : "top",
                        theme_advanced_toolbar_align : "center"
                        });
                        </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{taxonomy$EditSpecies.form1}" id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.edit_record}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{taxonomy$EditSpecies.btnEditSpeciesRecord_action}" id="btnEditSpeciesRecord"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="lnTitle" style="height: 96px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                    <webuijsf:label id="lbScientificName" style="height: 24px; left: 48px; top: 14px; position: absolute; width: 140px" text="#{resources.taxon_name}"/>
                                    <webuijsf:label for="txSequence" id="lbSequence"
                                        style="height: 24px; left: 48px; top: 38px; position: absolute; width: 140px" text="#{resources.sequence}"/>
                                    <webuijsf:label for="txTitle" id="label3" style="height: 24px; left: 48px; top: 62px; position: absolute; width: 140px" text="#{resources.title}"/>
                                    <webuijsf:label for="ddLanguage" id="lbLanguage"
                                        style="height: 24px; left: 504px; top: 38px; position: absolute; width: 118px" text="#{resources.language}"/>
                                    <webuijsf:label for="ddStatus" id="lbStatus" style="height: 24px; left: 504px; top: 62px; position: absolute; width: 118px" text="#{resources.status}"/>
                                    <webuijsf:label for="ddInstitutions" id="labelInstitutions"
                                        style="height: 24px; left: 504px; top: 14px; position: absolute; width: 120px" text="#{resources.institution}"/>
                                    <webuijsf:textField binding="#{taxonomy$EditSpecies.txSequence}" columns="26" disabled="true" id="txSequence"
                                        required="true" style="height: 24px; left: 192px; top: 38px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                    <webuijsf:textField binding="#{taxonomy$EditSpecies.txTitle}" columns="26" id="txTitle"
                                        style="height: 24px; left: 192px; top: 62px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditSpecies.ddLanguage}" id="ddLanguage"
                                        items="#{taxonomy$EditSpecies.languageData.options}"
                                        selected="#{taxonomy$SpeciesSessionBean.currentTaxDescripDTO.languageId}"
                                        style="height: 24px; left: 624px; top: 38px; position: absolute" width="192px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditSpecies.ddStatus}" id="ddStatus"
                                        items="#{taxonomy$EditSpecies.statusData.options}" required="true"
                                        selected="#{taxonomy$SpeciesSessionBean.currentTaxDescripDTO.taxonDescriptionStageId}"
                                        style="height: 24px; left: 624px; top: 62px; position: absolute" width="192px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditSpecies.ddInstitutions}" id="ddInstitutions"
                                        items="#{taxonomy$EditSpecies.institutionsData.options}" required="true"
                                        selected="#{taxonomy$SpeciesSessionBean.currentTaxDescripDTO.institutionId}"
                                        style="height: 24px; left: 624px; top: 14px; position: absolute" width="192px"/>
                                    <webuijsf:label id="lbShowScientificName"
                                        style="color: green; font-size: 14px; height: 24px; left: 192px; top: 14px; position: absolute; width: 308px" text="#{taxonomy$SpeciesSessionBean.currentTaxDescripDTO.taxonDefaultName}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:tabSet id="tabSetSpeciesRecord" lite="true" selected="tabTaxonomyHierarchy" style="width: 840px" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabDescription" text="#{resources.description}">
                                        <h:panelGrid columns="2" id="layoutpDescription">
                                            <webuijsf:tree binding="#{taxonomy$EditSpecies.descriptionTree}" clientSide="true" id="descriptionTree"
                                                immediate="true" style="border: 1px solid rgb(68, 103, 125); width: 265px" text="#{resources.categories}"/>
                                            <webuijsf:panelLayout id="panelInputDescription" style="position: relative; width: 479px; -rave-layout: grid">
                                                <h:commandButton action="#{taxonomy$EditSpecies.saveRecordData_action}"
                                                    binding="#{taxonomy$EditSpecies.saveRecordDataButton}" id="saveRecordDataButton"
                                                    style="height: 24px; width: 145px" styleClass="My_Button_record" value="#{resources.btnSave}"/>
                                                <webuijsf:staticText binding="#{taxonomy$EditSpecies.stCategoryName}" id="st_CategoryName"
                                                    style="font-size: 12px; font-weight: bold; width: 310px" styleClass="My_record_title"/>
                                                <h:panelGrid binding="#{taxonomy$EditSpecies.dynamicPanelForm}" id="dynamicPanelForm" style="height: 184px" width="552"/>
                                            </webuijsf:panelLayout>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAudiences" text="#{resources.menuModuleAudiences}">
                                        <h:panelGrid columns="1" id="layoutpAudiences">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$SpeciesSessionBean.arAudiences.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arAudiences.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arAudiences.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$SpeciesSessionBean.arAudiences.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arAudiences.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arAudiences.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arAudiences.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arAudiences.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$SpeciesSessionBean.arAudiences.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAuthors" text="#{resources.authors}">
                                        <h:panelGrid id="layoutpAuthors">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$SpeciesSessionBean.arAuthors.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arAuthors.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arAuthors.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$SpeciesSessionBean.arAuthors.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arAuthors.addSelectedOptions}" id="btnAddOptions"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arAuthors.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arAuthors.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arAuthors.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$SpeciesSessionBean.arAuthors.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabInstitutions" text="#{resources.menuModuleInstitutions}">
                                        <h:panelGrid id="layoutpInstitutions">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$SpeciesSessionBean.arInstitutions.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arInstitutions.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arInstitutions.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$SpeciesSessionBean.arInstitutions.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arInstitutions.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$SpeciesSessionBean.arInstitutions.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$SpeciesSessionBean.arInstitutions.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$SpeciesSessionBean.arInstitutions.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$SpeciesSessionBean.arInstitutions.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <!--<webuijsf:tab id="tabTaxonomyHierarchy" text="#{resources.taxonomy_hierarchy}">
                                        <h:panelGrid id="layoutpTaxonomyHierarchy"/>
                                    </webuijsf:tab>-->
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
