<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListGathering
    Created on : 02/07/2009, 05:14:40 PM
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
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbGatheringTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.gatherings_observations}"/>
                            <h:panelGrid id="gridpGathering_Main" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListGathering" infoClass="infoMessage"
                                    style="height: 24px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                    <h:inputText binding="#{inventory$ListGathering.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                        <f:validateLength maximum="100" minimum="0"/>
                                    </h:inputText>
                                    <h:commandButton action="#{inventory$ListGathering.btnGatheringSearch_action}" binding="#{inventory$ListGathering.btnSeach}"
                                        id="btnGatheringSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                    <h:commandButton action="#{inventory$ListGathering.btnAdvGatheringSearch_action}"
                                        binding="#{inventory$ListGathering.btnAdvSeach}" id="btnAdvGatheringSearch" style="height: 25px; width: 160px"
                                        styleClass="My_Button" value="#{resources.advanced_search}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{inventory$ListGathering.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                    style="height: 5px" styleClass="My_panel_blue" width="680">
                                    <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="670">
                                        <webuijsf:label for="initialDateCalendar" text="#{resources.initial_date}"/>
                                        <webuijsf:calendar binding="#{inventory$ListGathering.initial_date}" columns="15" dateFormatPattern="yyyy-MM-dd" id="initialDateCalendar"/>
                                        <webuijsf:label for="finalDateCalendar" text="#{resources.final_date}"/>
                                        <webuijsf:calendar binding="#{inventory$ListGathering.final_date}" columns="15" dateFormatPattern="yyyy-MM-dd" id="finalDateCalendar"/>
                                        <webuijsf:label for="txGatheringId" id="lbGatheringId" text="#{resources.gathering_observation_id}"/>
                                        <webuijsf:textField binding="#{inventory$ListGathering.txGatheringId}" id="txGatheringId" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                        <webuijsf:label for="txResponsible" id="lbResponsible" text="#{resources.person_in_charge}"/>
                                        <webuijsf:textField binding="#{inventory$ListGathering.txResponsible}" id="txResponsible" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="ddCountry" id="lbCountry" text="#{resources.country}"/>
                                        <webuijsf:dropDown actionExpression="#{inventory$ListGathering.setProvinces}"
                                            binding="#{inventory$ListGathering.ddCountry}" id="ddCountry" items="#{inventory$ListGathering.countryData.options}"
                                            selected="#{inventory$GatheringSessionBean.selectedCountry}" submitForm="true" width="154px"/>
                                        <webuijsf:label for="ddProvince" id="lbProvince" text="#{resources.state}"/>
                                        <webuijsf:dropDown binding="#{inventory$ListGathering.ddProvince}" id="ddProvince"
                                            items="#{inventory$ListGathering.provincesData.options}"
                                            selected="#{inventory$GatheringSessionBean.selectedProvince}" width="154px"/>
                                        <webuijsf:label for="txLocality" id="lblocality" text="#{resources.locality}"/>
                                        <webuijsf:textField binding="#{inventory$ListGathering.txLocality}" id="txLocality" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    </h:panelGrid>
                                    <h:panelGrid cellspacing="1" columns="2" id="panelpCoordinates" width="670">
                                        <h:panelGrid columns="7" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                            <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                            <webuijsf:textField binding="#{inventory$ListGathering.txLatitudeShort}" columns="10" id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange maximum="90.000000" minimum="-90.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                            <webuijsf:textField binding="#{inventory$ListGathering.txLongitudeShort}" columns="10" id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange maximum="180.000000" minimum="-180.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                            <webuijsf:textField binding="#{inventory$ListGathering.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                                <f:validateLongRange maximum="2147483647" minimum="0"/>
                                            </webuijsf:textField>
                                        </h:panelGrid>
                                        <h:commandButton action="#{inventory$ListGathering.btnAdvSearchGO_action}" id="btnAdvSearchGO" style="width: 160px"
                                            styleClass="My_Button" value="#{resources.button_proceed}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{inventory$ListGathering.quantityTotal}"/>
                                        </h:panelGrid>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <!-- Botones de acciones -->
                                            <h:commandButton action="#{inventory$ListGathering.btn_new_action}" id="btn_new" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.new}"/>
                                            <h:commandButton action="#{inventory$ListGathering.btnGatheringEdit}" id="btn_edit" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                            <h:commandButton action="#{inventory$ListGathering.btnGatheringDelete}" id="btn_delete" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                            <!-- Botones de paginacion -->
                                            <h:commandButton action="#{inventory$GatheringSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{inventory$GatheringSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{inventory$GatheringSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{inventory$GatheringSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{inventory$GatheringSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{inventory$GatheringSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{inventory$GatheringSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{inventory$GatheringSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{inventory$ListGathering.dataTableGathering}" cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                        rowClasses="list-row-even,list-row-odd" rows="#{inventory$GatheringSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{inventory$GatheringSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.gathering_observation_id}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['gatheringObservationId']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.country}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['countryName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.state}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['provinceName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.locality}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['localityDescription']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.coordinates}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['coordinates']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.person_in_charge}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['responsibleName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.initial_date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['initialDateTime']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.final_date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['finalDateTime']}"/>
                                        </h:column>
                                    </h:dataTable>
                                </h:panelGrid>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
