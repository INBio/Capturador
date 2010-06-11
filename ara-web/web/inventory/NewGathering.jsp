<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewGathering
    Created on : 20/08/2009, 04:46:02 PM
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
                            <webuijsf:label id="lbNewGatheringTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.title_gathering_observation_new}"/>
                            <h:panelGrid columns="1" id="gridpNewGatheringMain" style="height: 480px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglNewGathering" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotoneraNGath" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{inventory$NewGathering.btnSaveGathering_action}" id="btnSaveGathering"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="layoutpNewGathDetails" style="height: 212px; position: relative; width: 758px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label for="ddLocality" id="lblocality" requiredIndicator="true"
                                        style="height: 24px; left: 24px; top: 24px; position: absolute; width: 140px" text="#{resources.locality}"/>
                                    <webuijsf:label for="ddResponsible" id="lbResponsible"
                                        style="height: 24px; left: 384px; top: 24px; position: absolute; width: 140px" text="#{resources.person_in_charge}"/>
                                    <webuijsf:label for="calInitialDate" id="lbInitialDate" requiredIndicator=""
                                        style="height: 24px; left: 24px; top: 48px; position: absolute; width: 140px" text="#{resources.initial_date}"/>
                                    <webuijsf:label for="calFinalDate" id="lbFinalDate" requiredIndicator=""
                                        style="height: 24px; left: 384px; top: 48px; position: absolute; width: 140px" text="#{resources.final_date}"/>
                                    <webuijsf:dropDown binding="#{inventory$NewGathering.ddLocalities}" id="ddLocality"
                                        items="#{inventory$NewGathering.localitiesData.options}" required="true"
                                        selected="#{inventory$GatheringSessionBean.selectedLocality}"
                                        style="height: 24px; left: 175px; top: 24px; position: absolute" width="192px"/>
                                    <webuijsf:dropDown binding="#{inventory$NewGathering.ddResponsible}" id="ddResponsible"
                                        items="#{inventory$NewGathering.responsibleData.options}" required="true"
                                        selected="#{inventory$GatheringSessionBean.selectedResponsible}"
                                        style="height: 24px; left: 538px; top: 24px; position: absolute" width="192px"/>
                                    <webuijsf:calendar binding="#{inventory$NewGathering.initial_date}" columns="22" dateFormatPattern="yyyy-MM-dd"
                                        id="calInitialDate" required="true" style="height: 24px; left: 165px; top: 48px; position: absolute; width: 192px"/>
                                    <webuijsf:calendar binding="#{inventory$NewGathering.final_date}" columns="22" dateFormatPattern="yyyy-MM-dd"
                                        id="calFinalDate" required="true" style="height: 24px; left: 528px; top: 48px; position: absolute; width: 192px"/>
                                    <webuijsf:label for="txGradient" id="lbGradient"
                                        style="height: 24px; left: 24px; top: 72px; position: absolute; width: 140px" text="#{resources.gradient}"/>
                                    <webuijsf:label for="ddExposicion" id="lbExposicion"
                                        style="height: 24px; left: 384px; top: 72px; position: absolute; width: 140px" text="#{resources.exposition}"/>
                                    <webuijsf:dropDown binding="#{inventory$NewGathering.ddExposition}" id="ddExposicion"
                                        items="#{inventory$NewGathering.expositionData.options}" selected="#{inventory$GatheringSessionBean.selectedExposition}"
                                        style="height: 24px; left: 538px; top: 72px; position: absolute" width="192px"/>
                                    <webuijsf:textField binding="#{inventory$NewGathering.txGradient}" columns="25" id="txGradient"
                                        style="height: 24px; left: 175px; top: 72px; position: absolute; width: 180px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                    <webuijsf:label id="lbElevation" style="height: 24px; left: 24px; top: 96px; position: absolute; width: 140px" text="#{resources.elevation}"/>
                                    <webuijsf:label id="lbDepth" style="height: 24px; left: 384px; top: 96px; position: absolute; width: 140px" text="#{resources.depth}"/>
                                    <webuijsf:textField binding="#{inventory$NewGathering.txElevationMin}" columns="10" id="txElevationMin"
                                        style="height: 24px; left: 175px; top: 96px; position: absolute; width: 80px" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}"/>
                                    <webuijsf:label id="lbElevationMin" style="height: 24px; left: 264px; top: 96px; position: absolute; width: 96px" text="#{resources.minimum}"/>
                                    <webuijsf:textField binding="#{inventory$NewGathering.txElevationMax}" columns="10" id="txElevationMax"
                                        style="height: 24px; left: 175px; top: 120px; position: absolute; width: 80px" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}"/>
                                    <webuijsf:label id="lbElevationMax" style="height: 24px; left: 264px; top: 120px; position: absolute; width: 96px" text="#{resources.maximum}"/>
                                    <webuijsf:textField binding="#{inventory$NewGathering.txDepthMin}" columns="10" id="txDepthMin"
                                        style="height: 24px; left: 538px; top: 96px; position: absolute; width: 80px" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}"/>
                                    <webuijsf:label id="lbDepthMin" style="height: 24px; left: 624px; top: 96px; position: absolute; width: 96px" text="#{resources.minimum}"/>
                                    <webuijsf:textField binding="#{inventory$NewGathering.txDepthMax}" columns="10" id="txDepthMax"
                                        style="height: 24px; left: 538px; top: 120px; position: absolute; width: 80px" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}"/>
                                    <webuijsf:label id="lbDepthMax" style="height: 24px; left: 624px; top: 120px; position: absolute; width: 96px" text="#{resources.maximum}"/>
                                    <webuijsf:label for="txaSurrounding" id="lbSurrounding"
                                        style="height: 24px; left: 24px; top: 144px; position: absolute; width: 140px" text="#{resources.surroundings_description}"/>
                                    <webuijsf:textArea binding="#{inventory$NewGathering.txaSurrounding}" columns="23" id="txaSurrounding"
                                        style="height: 40px; left: 175px; top: 144px; position: absolute; width: 172px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:label id="lbSiteDescription" style="height: 24px; left: 384px; top: 144px; position: absolute; width: 140px" text="#{resources.site_description}"/>
                                    <webuijsf:textArea binding="#{inventory$NewGathering.txaSiteDescription}" columns="23" id="txaSiteDescription"
                                        style="height: 40px; left: 538px; top: 144px; position: absolute; width: 172px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:tabSet id="tabSetDetails" lite="true" selected="tabCollectors" style="height: 235px; width: 758px" styleClass="My_tab_border">
                                    <webuijsf:tab id="tabCollectors" text="#{resources.collectors}">
                                        <webuijsf:panelLayout id="layoutpCollectors" style="height: 215px; position: relative; width: 100%; -rave-layout: grid">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove"
                                                style="height: 168px; left: 100px; top: 10px; position: absolute" styleClass="My_table" width="528">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" value="#{inventory$GatheringSessionBean.arCollectors.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arCollectors.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arCollectors.leftSelected}">
																													<f:selectItems id="mlAvailableSelectItems" value="#{inventory$GatheringSessionBean.arCollectors.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arCollectors.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arCollectors.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arCollectors.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arCollectors.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{inventory$GatheringSessionBean.arCollectors.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabProjects" text="#{resources.projects}">
                                        <webuijsf:panelLayout id="layoutpProjects" style="height: 215px; width: 100%">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove2"
                                                style="height: 168px; left: 100px; top: 10px; position: absolute" styleClass="My_table" width="528">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle2" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle2" value="#{inventory$GatheringSessionBean.arProjects.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions2" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arProjects.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList2" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arProjects.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems2" value="#{inventory$GatheringSessionBean.arProjects.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arProjects.addSelectedOptions}" id="btnAddOptions2"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arProjects.removeSelectedOptions}"
                                                            id="btnRemoveOptions2" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions2" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arProjects.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList2" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arProjects.rightSelected}">
																													<f:selectItems id="mlSelectedSelectItems2" value="#{inventory$GatheringSessionBean.arProjects.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAsociatedColl" text="#{resources.associated_collections}">
                                        <webuijsf:panelLayout id="layoutpCollections" style="height: 215px; width: 100%">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove3"
                                                style="height: 168px; left: 100px; top: 10px; position: absolute" styleClass="My_table" width="528">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle3" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle3" value="#{inventory$GatheringSessionBean.arCollections.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions3" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arCollections.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList3" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arCollections.leftSelected}">
																													<f:selectItems id="mlAvailableSelectItems3" value="#{inventory$GatheringSessionBean.arCollections.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arCollections.addSelectedOptions}"
                                                            id="btnAddOptions3" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arCollections.removeSelectedOptions}"
                                                            id="btnRemoveOptions3" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions3" styleClass="My_white_label" value="#{inventory$GatheringSessionBean.arCollections.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList3" size="7" style="width:250px" value="#{inventory$GatheringSessionBean.arCollections.rightSelected}">
																													<f:selectItems id="mlSelectedSelectItems3" value="#{inventory$GatheringSessionBean.arCollections.rightOptions}"/>
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
