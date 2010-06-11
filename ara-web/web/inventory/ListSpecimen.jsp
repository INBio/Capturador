<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListSpecimen
    Created on : 02/07/2009, 05:14:40 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http:z//java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
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
                            <webuijsf:label id="lbSpecimenTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.titleSpecimenList}"/>
                            <h:panelGrid id="gridpSpecimen" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListSpecimen" infoClass="infoMessage"
                                    style="height: 40px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                    <h:inputText binding="#{inventory$ListSpecimen.txSearch}" id="txSpecimen" style="height: 18px; width: 408px">
                                        <f:validateLength minimum="0" maximum="100"/>
                                    </h:inputText>
                                    <h:commandButton action="#{inventory$ListSpecimen.btnSpecimenSearch_action}" binding="#{inventory$ListSpecimen.btnSeach}"
                                        id="btnSpecimenSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search_specimen}"/>
                                    <h:commandButton action="#{inventory$ListSpecimen.btnAdvSpecimenSearc_action}"
                                        binding="#{inventory$ListSpecimen.btnAdvSeach}" id="btnAdvSpecimenSearc" style="height: 25px; width: 160px"
                                        styleClass="My_Button" value="#{resources.advanced_search_specimen}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{inventory$ListSpecimen.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                    style="height: 5px" styleClass="My_panel_blue" width="745">
                                    <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="745">
                                        <webuijsf:label for="txCatalog" id="lbCatalog" text="#{resources.catalognumber}"/>
                                        <webuijsf:textField binding="#{inventory$ListSpecimen.txCatalogNumber}" id="txCatalog" validatorExpression="#{util$ValidatorBean.validateInputCatalog}"/>
                                        <webuijsf:label for="ddInstitution" id="lbInstitution" text="#{resources.institution}"/>
                                        <webuijsf:dropDown binding="#{inventory$ListSpecimen.ddInstitutionCode}" id="ddInstitution"
                                            items="#{inventory$ListSpecimen.institutionsData.options}"
                                            selected="#{inventory$SpecimenSessionBean.selectedInstitution}" width="154px"/>
                                        <webuijsf:label for="txTaxon" id="lbTaxon" text="#{resources.taxon_name}"/>
                                        <webuijsf:textField binding="#{inventory$ListSpecimen.txTaxonName}" id="txTaxon" validatorExpression="#{util$ValidatorBean.validateInputTaxon}"/>
                                        <webuijsf:label for="txLocality1" id="lblocality" text="#{resources.locality}"/>
                                        <webuijsf:textField binding="#{inventory$ListSpecimen.txLocality}" id="txLocality1" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="txResponsible" id="lbResponsible" text="#{resources.person_in_charge}"/>
                                        <webuijsf:textField binding="#{inventory$ListSpecimen.txResponsible}" id="txResponsible" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="ddCountry1" id="lbCountry1" text="#{resources.country}"/>
                                        <webuijsf:dropDown actionExpression="#{inventory$ListSpecimen.setProvinces}"
                                            binding="#{inventory$ListSpecimen.ddCountry}" id="ddCountry1"
                                            items="#{inventory$ListSpecimen.countriesData.options}" selected="#{inventory$SpecimenSessionBean.selectedCountry}"
                                            submitForm="true" width="154px"/>
                                        <webuijsf:label for="ddProvince1" id="lbProvince1" text="#{resources.state}"/>
                                        <webuijsf:dropDown binding="#{inventory$ListSpecimen.ddProvince}" id="ddProvince1"
                                            items="#{inventory$ListSpecimen.provincesData.options}" selected="#{inventory$SpecimenSessionBean.selectedProvince}" width="154px"/>
                                    </h:panelGrid>
                                    <h:panelGrid cellspacing="1" columns="2" id="panelpCoordinates" width="706">
                                        <h:panelGrid columns="7" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                            <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                            <webuijsf:textField binding="#{inventory$ListSpecimen.txLatitudeShort}" columns="10" id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange minimum="-90.000000" maximum="90.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                            <webuijsf:textField binding="#{inventory$ListSpecimen.txLongitudeShort}" columns="10" id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange minimum="-180.000000" maximum="180.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                            <webuijsf:textField binding="#{inventory$ListSpecimen.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                                <f:validateLongRange minimum="0" maximum="2147483647"/>
                                            </webuijsf:textField>
                                        </h:panelGrid>
                                        <h:commandButton action="#{inventory$ListSpecimen.btnBuscar_action}" id="btnAdvSearchGO1" style="width: 160px"
                                            styleClass="My_Button" value="#{resources.button_proceed}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtons" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{inventory$ListSpecimen.quantityTotal}"/>
                                        </h:panelGrid>
                                        <h:commandButton action="#{inventory$ListSpecimen.btn_edit_action}" id="btn_edit" style="margin: 2px; height: 22px"
                                            styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <h:commandButton action="#{inventory$SpecimenSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{inventory$SpecimenSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{inventory$SpecimenSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{inventory$SpecimenSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{inventory$SpecimenSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{inventory$SpecimenSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{inventory$SpecimenSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{inventory$SpecimenSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{inventory$ListSpecimen.dataTableSpecimens}" cellspacing="0" columnClasses="list-columns"
                                        headerClass="list-header" id="dataTableSpecimens" rowClasses="list-row-even,list-row-odd"
                                        rows="#{inventory$SpecimenSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{inventory$SpecimenSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:commandLink id="menuSubsystemInventory" styleClass="My_search_icon" value="#{resources.catalognumber}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['catalogNumber']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.institution}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['institutionCode']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.collection}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['collectionName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.taxon_name}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['taxonName']}"/>
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
                                                <h:outputText value="#{resources.person_in_charge}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['responsibleName']}"/>
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
