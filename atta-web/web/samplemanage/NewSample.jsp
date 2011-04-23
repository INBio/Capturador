<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewSample
    Created on : 23/03/2011, 09:17:51 AM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>

    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1" webuiJsfx="true">

                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.new_sample}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="1" id="groupBotoneraSample" style="height: 24px" width="540">
                                    <h:commandButton id="saveSampleButton" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_sample}"/>
                                    
                                </h:panelGrid>
                                <h:panelGrid columns="2">
                                    <webuijsf:textField label="Cantidad de muestras iguales: " columns="10" id="textFieldSampleQuantity" style="width: 220px;"/>
                                    <h:commandButton id="clearForm" style="height: 24px; width: 175px" styleClass="My_Button" value="Limpiar Formulario"/>
                                </h:panelGrid>
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tabSite" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabSite" text="#{resources.general_information}">
                                        <h:panelGrid columns="1" style="position: relative" width="100%">
                                            <h:panelGrid columns="2" style="position: relative" width="550px">

                                                <webuijsf:label id="labelSite" style="width: 260px; height: 24px" text="#{resources.site}"/>
                                                <webuijsf:textField
                                                        autoComplete="true"
                                                        autoCompleteExpression = "#{gis$SiteAutoCompleteSessionBean.getOptions}"
                                                        text="#{gis$SiteAutoCompleteSessionBean.text}"
                                                        style="z-order: 1;"
                                                        id = "tfAutocomplete"
                                                        columns="25">
                                                </webuijsf:textField>



                                                <webuijsf:label id="labeltravel" style="width: 260px; height: 24px" text="#{resources.tour}"/>
                                                <webuijsf:textField columns="22" id="textFieldGira" style="width: 220px;" />

                                                <!--
                                                <webuijsf:textArea columns="24" id="textAreaNotes" style="width: 200px; height: 55px" text=""/>
                                                -->
                                            </h:panelGrid>
                                            <h:panelGrid>
                                                <!-- Add Remove body -->
                                                <webuijsf:label id="labelProjects" style="width: 260px; height: 24px" text="#{resources.projects}"/>
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
                                                        <h:commandButton action="#{inventory$GatheringSessionBean.arProjects.addSelectedOptions}"
                                                            id="btnAddOptions2" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
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
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabSampleData" text="Datos de la muestra">
                                        <h:panelGrid columns="2">
                                            <h:panelGrid columns="2">
                                                <webuijsf:label id="labelSampleId" style="width: 260px; height: 24px" text="#{resources.collectornumber}"/>
                                                <webuijsf:textField id="textFieldSampleId" columns="22" style="width: 220px;" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.witness}"/>

                                                <webuijsf:label id="labelSampleClass" style="width: 200px; height: 24px" text="#{resources.sle_sample_class}"/>
                                                <webuijsf:dropDown id="dropdownSampleClass" width="190px" items="#{samplemanage$NewSample.sampleClassData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.sampleClassId}"/>

                                                <webuijsf:label id="labelScientificName" style="width: 260px; height: 24px" text="#{resources.scientificname}"/>
                                                <webuijsf:textField
                                                        autoComplete="true"
                                                        autoCompleteExpression = "#{taxonomy$TaxonAutoCompleteBean.getOptions}"
                                                        text="#{taxonomy$TaxonAutoCompleteBean.text}"
                                                        style="z-order: 1;"
                                                        id = "tfAutocomplete"
                                                        columns="22">
                                                </webuijsf:textField>



                                                <webuijsf:label id="labeGatheringDatel" style="width: 260px; height: 24px" text="#{resources.gathering_date}"/>
                                                <webuijsf:calendar id="calendarGatheringDate" columns="17" dateFormatPattern="yyyy-MM-dd" />

                                                <webuijsf:label id="labelPermission" style="width: 260px; height: 24px" text="#{resources.sle_permission}"/>
                                                <webuijsf:dropDown id="dropdownPermission" width="190px" items="#{samplemanage$NewSample.permissionData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.permissionId}"/>
                                            </h:panelGrid>
                                                <h:panelGrid columns="2">
                                                    <webuijsf:label id="labelMicroSourceType" style="width: 260px; height: 24px" text="#{resources.sle_micro_source_type}"/>
                                                    <webuijsf:dropDown id="dropdownMicroSourceType" width="190px" items="#{samplemanage$NewSample.microSourceTypeData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.microSourceTypeId}"/>

                                                    <webuijsf:label id="labelMicroMethod" style="width: 260px; height: 24px" text="#{resources.sle_micro_method}"/>
                                                    <webuijsf:dropDown id="dropdownMicroMethod" width="190px" items="#{samplemanage$NewSample.microMethodData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.microMethodId}"/>

                                                    <webuijsf:label id="labelMicroFome" style="width: 260px; height: 24px" text="#{resources.sle_micro_fome}"/>
                                                    <webuijsf:dropDown id="dropdownMicroFome" width="190px" items="#{samplemanage$NewSample.microFomeData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.microFomeId}"/>

                                                    <webuijsf:label id="labelMicroQuality" style="width: 260px; height: 24px" text="#{resources.sle_micro_quality}"/>
                                                    <webuijsf:dropDown id="dropdownMicroQuality" width="190px" items="#{samplemanage$NewSample.microQualityData.options}" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.microQualityId}"/>

                                                    <webuijsf:label id="labelSampleAltitude" style="width: 260px; height: 24px" text="#{resources.sample_altitude}"/>
                                                    <webuijsf:textField id="textFieldSampleAltitude" columns="22" style="width: 220px;" binding="#{samplemanage$SampleManageSessionBean.sampleDTO.sampleAltitude}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>


                                    </webuijsf:tab>

                                    <webuijsf:tab id="tabEnviromentalData" text="Datos ambientales">
                                        <h:panelGrid columns="2">
                                            <h:panelGrid columns="2">
                                                <webuijsf:label id="labelElevation" style="width: 260px; height: 24px" text="#{resources.elevation}"/>
                                                <webuijsf:textField id="textFieldElevation" columns="22" style="width: 220px;" />

                                                <webuijsf:label id="labelDiametro" style="width: 260px; height: 24px" text="#{resources.diameter}"/>
                                                <webuijsf:textField id="textFieldDiametro" columns="22" style="width: 220px;"/>

                                                <webuijsf:label id="labelHost" style="width: 260px; height: 24px" text="#{resources.host}"/>
                                                <webuijsf:dropDown id="dropdownHost" width="190px" items="#{germplasm$NewSemental.breeds.options}"/>

                                                <webuijsf:label id="labelPH" style="width: 260px; height: 24px" text="#{resources.ph}"/>
                                                <webuijsf:textField id="textFieldPH" columns="22" style="width: 220px;"/>

                                                <webuijsf:label id="labelBrightness" style="width: 260px; height: 24px" text="#{resources.lightness}"/>
                                                <webuijsf:textField id="textFieldBrightness" columns="22" style="width: 220px;"/>

                                                <webuijsf:label id="labelTempeture" style="width: 260px; height: 24px" text="#{resources.tempeture}"/>
                                                <webuijsf:textField id="textFieldTempeture" columns="22" style="width: 220px;"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2">
                                                <webuijsf:label id="labelMoisture" style="width: 260px; height: 24px" text="#{resources.moisture}"/>
                                                <webuijsf:textField id="textFieldMoisture" columns="22" style="width: 220px;"/>

                                                <webuijsf:label id="labelForestType" style="width: 260px; height: 24px" text="#{resources.forest_type}"/>
                                                <webuijsf:dropDown id="dropdownForestType"  width="190px" items="#{samplemanage$NewSample.forestTypeData.options}"/>

                                                <webuijsf:label id="labelHabitat" style="width: 260px; height: 24px" text="#{resources.habitat}"/>
                                                <webuijsf:textField id="textFieldHabitat" columns="22" style="width: 220px;"/>

                                                <webuijsf:label id="labelVerticalStrata" style="width: 260px; height: 24px" text="#{resources.sle_vertical_strata}"/>
                                                <webuijsf:dropDown id="dropdownVerticalStrata"  width="190px" items="#{samplemanage$NewSample.verticalStrataData.options}"/>

                                                <webuijsf:label id="labelVegetationType" style="width: 260px; height: 24px" text="#{resources.sle_vegetation_type}"/>
                                                <webuijsf:dropDown id="dropdownVegetationType" width="190px" items="#{samplemanage$NewSample.vegetationTypeData.options}"/>

                                                <webuijsf:label id="labelSalinity" style="width: 260px; height: 24px" text="#{resources.salinity}"/>
                                                <webuijsf:textField id="textFieldSalinity" columns="22" style="width: 220px;"/>

                                            </h:panelGrid>

                                        </h:panelGrid>

                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabSpecimens" text="Especímenes Asociados">
                                        <h:panelGrid>
                                            <h:panelGrid columns="3">
                                                <webuijsf:label id="labelFieldNumber" style="width: 260px; height: 24px" text="Numero de Campo"/>
                                                <webuijsf:textField id="textFieldFieldNumber" columns="22" style="width: 220px;"/>
                                                <h:commandButton id="addSpecimen"
                                                style="height: 24px; width: 175px" styleClass="My_Button" value="Agregar Especimen"/>
                                                <h:commandButton id="removeSpecimen"
                                                style="height: 24px; width: 175px" styleClass="My_Button" value="Desligar Especimen"/>
                                            </h:panelGrid>
                                            <h:panelGrid>
                                                Aqui va una lista
                                            </h:panelGrid>

                                        </h:panelGrid>

                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabImages" text="Imagenes">

                                    </webuijsf:tab>
                                </webuijsf:tabSet>


                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/Footer.jspf"/>
                 </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>

