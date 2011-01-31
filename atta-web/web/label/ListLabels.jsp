<?xml version="1.0" encoding="UTF-8"?>
<!--
	Document   : GenerationLabels
	Created on : 14/08/2009, 10:35:00 PM
	Author     : pcorrales
-->
<jsp:root version="2.1" xmlns:df="http:z//java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
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
                            <webuijsf:label id="lbSpecimenTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.titleLabel}"/>
                            <h:panelGrid id="gridpSpecimen" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListSpecimen" infoClass="infoMessage"
                                    style="height: 40px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="839">
                                    <h:inputText binding="#{label$ListLabels.txSearch}" id="txSpecimen" style="height: 18px; width: 408px">
                                        <f:validateLength maximum="100" minimum="0"/>
                                    </h:inputText>
                                    <h:commandButton action="#{label$ListLabels.btnSpecimenSearch_action}" binding="#{label$ListLabels.btnSeach}"
                                        id="btnSpecimenSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search_specimen}"/>
                                    <h:commandButton action="#{label$ListLabels.btnAdvSpecimenSearc_action}" binding="#{label$ListLabels.btnAdvSeach}"
                                        id="btnAdvSpecimenSearc" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search_specimen}"/>
                                </h:panelGrid>
                                
                                <h:panelGrid binding="#{label$ListLabels.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                    style="height: 264px" styleClass="My_panel_blue" width="839">
                                    <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="800">

                                                            
                                       <webuijsf:label for="ddTaxonomicLevel" id="lbTaxonomicLevel" text="#{resources.taxonomic_level}"/>
                                        <webuijsf:dropDown binding="#{label$ListLabels.ddTaxonomicalRange}"
                                            id="ddTaxonomicalRange"
                                            items="#{label$ListLabels.ddTaxonomicalRangeData.options}"
                                            selected="#{label$LabelSessionBean.selectedTaxonomicalRangeName}"
                                            submitForm="true" width="154px"/>

                                        <webuijsf:label for="txTaxon" id="lbTaxon" text="#{resources.name}"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txTaxonName}" id="txTaxon" validatorExpression="#{util$ValidatorBean.validateInputTaxon}"/>


                                        <webuijsf:label for="ddInstitution" id="lbInstitution" text="#{resources.institution}"/>
                                        <webuijsf:dropDown binding="#{label$ListLabels.ddInstitutionCode}" id="ddInstitution"
                                            items="#{label$ListLabels.institutionsData.options}" selected="#{label$LabelSessionBean.selectedInstitution}" width="154px"/>
                                   
                                        <webuijsf:label for="txLocality1" id="lblocality" text="#{resources.locality}"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txLocality}" id="txLocality1" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>

                                        <webuijsf:label for="ddCountry1" id="lbCountry1" text="#{resources.country}"/>
                                        <webuijsf:dropDown actionExpression="#{label$ListLabels.setProvinces}" binding="#{label$ListLabels.ddCountry}"
                                            id="ddCountry1" items="#{label$ListLabels.countriesData.options}"
                                            selected="#{label$LabelSessionBean.selectedCountry}" submitForm="true" width="154px"/>

                                        <webuijsf:label for="ddProvince1" id="lbProvince1" text="#{resources.state}"/>
                                        <webuijsf:dropDown binding="#{label$ListLabels.ddProvince}" id="ddProvince1"
                                            items="#{label$ListLabels.provincesData.options}" selected="#{label$LabelSessionBean.selectedProvince}" width="154px"/>

                                        <webuijsf:label for="initialDateCalendar" text="#{resources.initial_date}"/>
                                        <webuijsf:calendar binding="#{label$ListLabels.initial_date}" columns="15" dateFormatPattern="yyyy-MM-dd" id="initialDateCalendar"/>
                                        <webuijsf:label for="finalDateCalendar" text="#{resources.final_date}"/>
                                        <webuijsf:calendar binding="#{label$ListLabels.final_date}" columns="15" dateFormatPattern="yyyy-MM-dd" id="finalDateCalendar"/>

                                        <webuijsf:label   for="ddGatheringFirst" id="lbGatheringFirst" text=" Num.Recoleción inicial"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txGatheringObservationFirst}"  id="txGatheringfirst"/>
                                        <webuijsf:label for="ddGatheringEnd" id="lbGatheringEnd" text=" Num. Recolección final"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txGatheringObservationEnd}" id="txGatheringEnd"/>

                                        <webuijsf:label for="txCatalog" id="lbCatalog" text="Núm. Inicial Iden Specimen"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txCatalogNumberFirst}" id="txCatalog" />

                                        <webuijsf:label for="txCatalog1" id="lbCatalog1" text="Núm. Final Iden Specimen" />
                                        <webuijsf:textField  binding="#{label$ListLabels.txCatalogNumberEnd}"  id="txCatalog1" />


                                        <webuijsf:label for="ddResponsible" id="lbNameRecolector" text="Identificador"/>
                                        <webuijsf:dropDown binding="#{label$ListLabels.ddIdentificator}" id="ddResponsible"
                                        items="#{label$ListLabels.identificatorData.options}"
                                        selected="#{label$LabelSessionBean.selectedIdentificator}"  width="154px"/>

                                        <webuijsf:label for="ddResponsibleIdentification" id="lbNameIdentificator" text="Responsable Colecta"/>
                                        <webuijsf:dropDown binding="#{label$ListLabels.ddResponsible}" id="ddResponsibleIdentification"
                                        items="#{label$ListLabels.responsibleData.options}"  selected="#{label$LabelSessionBean.selectedResponsible}"    width="154px"/>
                                        
                                        <webuijsf:label for="ddGatheringDetailNumberFirst" id="lbGatheringDetailNumberFirst" text=" Num. Colecta inicial"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txGatheringDetailNumberFirst}" id="txGatheringDetailNumberFirst"/>
                                        <webuijsf:label for="ddGatheringDetailNumberEnd" id="lbGatheringDetailNumberEnd" text=" Num. Colecta final"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txGatheringDetailNumberEnd}" id="txGatheringDetailNumberEnd"/>

                                    </h:panelGrid>


                                    <h:panelGrid cellspacing="1" columns="6" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                        <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txLatitudeShort}" columns="10" id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                            <f:validateDoubleRange maximum="90.000000" minimum="-90.000000"/>
                                        </webuijsf:textField>
                                        <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txLongitudeShort}" columns="10" id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                            <f:validateDoubleRange maximum="180.000000" minimum="-180.000000"/>
                                        </webuijsf:textField>
                                        <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                        <webuijsf:textField binding="#{label$ListLabels.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                            <f:validateLongRange maximum="2147483647" minimum="0"/>
                                        </webuijsf:textField>
                                    </h:panelGrid>
                               
                                    <h:panelGrid cellspacing="1" columns="2" id="gridpanelCoor3" style="height: 24px" width="400">
                                        <h:commandButton action="#{label$ListLabels.btnSpecimenSearchAdv}" id="btnProced" style="height: 25px; width: 168px"
                                            styleClass="My_Button" value="#{resources.button_proceed}"/>

                                        <h:commandButton action="#{label$ListLabels.btnCleanForm}" id="btnClean" style="height: 25px; width: 168px"
                                                           styleClass="My_Button" value="#{resources.btnClear}"/>

                                    </h:panelGrid>
                                </h:panelGrid>

                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtons" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{label$ListLabels.quantityTotal}"/>
                                        </h:panelGrid>

                                        <h:commandButton action="#{label$ListLabels.btn_edit_action}" id="btn_edit" style="margin: 2px; height: 22px"
                                                         styleClass="My_Button_table" value="#{resources.editLabels}"/>
                                        <h:commandButton action="#{label$ListLabels.btn_generation_action}" id="btn_generationLabels" style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.generateLabels}"/>

                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <h:commandButton action="#{label$LabelSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{label$LabelSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{label$LabelSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{label$LabelSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{label$LabelSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{label$LabelSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{label$ListLabels.dataTableSpecimens}" cellspacing="0" columnClasses="list-columns"
                                        headerClass="list-header" id="dataTableSpecimens" rowClasses="list-row-even,list-row-odd"
                                        rows="#{label$LabelSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{label$LabelSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
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
