<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListSemental
    Created on : 08/04/2010, 09:41:03 AM
    Author     : dasolano
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
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.sementals}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                <h:panelGrid rendered="false" columns="1" id="panelAlert" binding="#{germplasm$ListSemental.alertMessage}" >
                                    <webuijsf:label text="#{resources.have_semental}" style="color: red" />
                                    <h:panelGrid columns="2" id="butonsAlert" >
                                        <h:commandButton action="#{germplasm$ListSemental.btn_confirm_delete_action}"
                                            style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.acept}"/>
                                        <h:commandButton action="#{germplasm$ListSemental.btn_cancel_delete_action}"
                                            style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.cancel}"/>
                                    </h:panelGrid>
                                </h:panelGrid>

                                <!-- Tabla que posee la lista de sementals -->
                                <h:panelGrid binding="#{germplasm$ListSemental.mainPanel}" id="gridpGathering_Main" style="position: relative" width="850">
                                    
                                    <!-- panel de busquedas -->
                                    <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                        <h:inputText binding="#{germplasm$ListSemental.txSimpleSearch}" id="txSimpleSearch" style="height: 18px; width: 408px">
                                            <f:validateLength maximum="100" minimum="0"/>
                                        </h:inputText>
                                        <h:commandButton action="#{germplasm$ListSemental.btnSimpleSearch_action}"
                                                         binding="#{germplasm$ListSemental.btnSimpleSearch}" id="btnSimpleSearch" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.search}"/>
                                        <h:commandButton action="#{germplasm$ListSemental.btnAdvSearch_action}"
                                                         binding="#{germplasm$ListSemental.btnAdvSearch}" id="btnAdvSearch"
                                            style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{germplasm$ListSemental.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                        rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                        <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">
                                            <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">

                                                <webuijsf:label id="labelName" style="width: 168px; height: 24px" text="#{resources.name}"/>
                                                <webuijsf:textField id="textFieldName" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.name}"/>

                                                <webuijsf:label id="labelBirthDate" style="width: 150px; height: 24px" text="#{resources.birth_date}"/>
                                                <webuijsf:calendar  binding="#{germplasm$ListSemental.birthDate}"
                                                    id="calendarBirthDate" style="width: 50px"/>

                                                <webuijsf:label id="labelAnimalCode" style="width: 168px; height: 24px" text="#{resources.animal_code}"/>
                                                <webuijsf:textField id="textFieldAnimalCode" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.animalCode}"/>

                                                <webuijsf:label id="labelColor" style="width: 168px; height: 24px" text="#{resources.color}"/>
                                                <webuijsf:textField id="textFieldColor" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.color}"/>

                                                <webuijsf:label id="labelBreed" style="width: 168px; height: 24px" text="#{resources.breed}"/>
                                                <webuijsf:dropDown id="dropdownBreed" items="#{germplasm$ListSemental.breeds.options}"
                                                                   selected="#{germplasm$SementalSessionBean.querySementalDTO.breedId}" width="160px"/>

                                                <webuijsf:label id="labelSite" style="width: 168px; height: 24px" text="#{resources.place_of_origin}"/>
                                                <webuijsf:dropDown id="dropdownSite" items="#{germplasm$ListSemental.sites.options}"
                                                                   selected="#{germplasm$SementalSessionBean.querySementalDTO.siteId}" width="160px"/>

                                                <webuijsf:label id="labelCondition" style="width: 168px; height: 24px" text="#{resources.condition}"/>
                                                <webuijsf:dropDown id="dropdownCondition" items="#{germplasm$ListSemental.conditions.options}"
                                                                   selected="#{germplasm$SementalSessionBean.querySementalDTO.conditionId}" width="160px"/>

                                                <webuijsf:label id="labelFather" style="width: 168px; height: 24px" text="#{resources.father}"/>
                                                <webuijsf:textField id="textFieldFather" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.father}"/>


                                                <webuijsf:label id="labelVeterinarianStatus" style="width: 168px; height: 24px" text="#{resources.veterinarian_status}"/>
                                                <webuijsf:textField id="textFieldVeterinarianStatus" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.veterinarianStatus}"/>
                                                
                                                <webuijsf:label id="labelMother" style="width: 168px; height: 24px" text="#{resources.mother}"/>
                                                <webuijsf:textField id="textFieldMother" style="width: 200px;" text="#{germplasm$SementalSessionBean.querySementalDTO.mother}"/>
                                                
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                <h:commandButton action="#{germplasm$ListSemental.btnAdvSearchSemental_action}" id="btnAdvSearchGO"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>

                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                <h:outputLabel id="labelQuantity" value="#{germplasm$ListSemental.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{germplasm$ListSemental.btn_new_action}" id="btn_new"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                <h:commandButton action="#{germplasm$ListSemental.btn_edit_action}" id="btn_edit"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton action="#{germplasm$ListSemental.btn_delete_action}" id="btn_delete"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{germplasm$SementalSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{germplasm$SementalSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{germplasm$SementalSessionBean.pagination.previousResults}"
                                                    id="btnPrevious" rendered="#{germplasm$SementalSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{germplasm$SementalSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{germplasm$SementalSessionBean.pagination.isVisibleNext}"
                                                    style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{germplasm$SementalSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{germplasm$SementalSessionBean.pagination.isVisibleNext}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                                <h:dataTable binding="#{germplasm$ListSemental.dataTableSemental}" cellspacing="0"
                                            columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                            rowClasses="list-row-even,list-row-odd" rows="#{germplasm$SementalSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{germplasm$SementalSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.breed}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['breed']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['name']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.animal_code}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['animalCode']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.birth_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['birthDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.veterinarian_status}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['veterinarianStatus']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.condition}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['condition']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.animal_description}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['animalDescription']}"/>
                                            </h:column>

                                        </h:dataTable>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <!-- FIN Tabla que posee la lista de breeds -->



                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
