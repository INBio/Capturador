<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListSemenGathering
    Created on : 08/04/2010, 09:51:29 AM
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.semen_gathering}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                <!-- Tabla que posee la lista de semen gatherings -->
                                <h:panelGrid binding="#{germplasm$ListSemenGathering.mainPanel}" id="gridpGathering_Main" style="position: relative" width="850">

                                    <!-- panel de busquedas -->
                                    <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                        <h:inputText binding="#{germplasm$ListSemenGathering.txSimpleSearch}" id="txSimpleSearch" style="height: 18px; width: 408px">
                                            <f:validateLength maximum="100" minimum="0"/>
                                        </h:inputText>
                                        <h:commandButton action="#{germplasm$ListSemenGathering.btnSimpleSearch_action}"
                                                         binding="#{germplasm$ListSemenGathering.btnSimpleSearch}" id="btnSimpleSearch" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.search}"/>
                                        <h:commandButton action="#{germplasm$ListSemenGathering.btnAdvSearch_action}"
                                                         binding="#{germplasm$ListSemenGathering.btnAdvSearch}" id="btnAdvSearch"
                                            style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{germplasm$ListSemenGathering.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                        rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                        <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">
                                            <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">

                                                <webuijsf:label id="labelGatheringDate" style="width: 168px; height: 24px" text="#{resources.birth_date}"/>
                                                <webuijsf:calendar  binding="#{germplasm$ListSemenGathering.gatheringDate}"
                                                    id="calendaratheringDate" style="width: 200px"/>

                                                <webuijsf:label id="labelGatheringTime" style="width: 168px; height: 24px" text="#{resources.semen_gathering_time}"/>
                                                <h:panelGrid id="panelTime" columns="3">

                                                    <webuijsf:dropDown id="dropdownhh"  width="43px"
                                                                   items="#{germplasm$ListSemenGathering.hourDropDown.options}"
                                                                   selected="#{germplasm$SemenGatheringSessionBean.selectedHour}"/>
                                                    <webuijsf:label id="labelDP" text=":"/>
                                                    <webuijsf:dropDown id="dropdownmm"  width="43px"
                                                                   items="#{germplasm$ListSemenGathering.minutesDropDown.options}"
                                                                   selected="#{germplasm$SemenGatheringSessionBean.selectedMinutes}"/>

                                                </h:panelGrid>

                                                
                                                <webuijsf:label id="labelVolume" style="width: 168px; height: 24px" text="#{resources.volume}"/>
                                                <webuijsf:textField id="textFieldVolume" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.volume}"/>

                                                <webuijsf:label id="labelMotility" style="width: 168px; height: 24px" text="#{resources.motility}"/>
                                                <webuijsf:textField id="textFieldMotility" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.motility}"/>

                                                <webuijsf:label id="labelConcentration" style="width: 168px; height: 24px" text="#{resources.concentration}"/>
                                                <webuijsf:textField id="textFieldConcentration" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.concentration}"/>

                                                <webuijsf:label id="labelStrawSize" style="width: 168px; height: 24px" text="#{resources.straw_size}"/>
                                                <webuijsf:textField id="textFieldStrawSize" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.strawSize}"/>

                                                <webuijsf:label id="labelDilution" style="width: 168px; height: 24px" text="#{resources.dilution}"/>
                                                <webuijsf:textField id="textFieldDilution" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.dilution}"/>

                                                <webuijsf:label id="labelTankNumber" style="width: 168px; height: 24px" text="#{resources.tank_number}"/>
                                                <webuijsf:textField id="textFieldTankNumber" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.tankNumber}"/>

                                                <webuijsf:label id="labelCanisterNumber" style="width: 168px; height: 24px" text="#{resources.canister_number}"/>
                                                <webuijsf:textField id="textFieldCanisterNumber" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.canisterNumber}"/>

                                                <webuijsf:label id="labelGobletNumber" style="width: 168px; height: 24px" text="#{resources.goblet_number}"/>
                                                <webuijsf:textField id="textFieldGobletNumer" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.gobletNumber}"/>

                                                <webuijsf:label id="labelStrawColor" style="width: 168px; height: 24px" text="#{resources.straw_color}"/>
                                                <webuijsf:textField id="textFieldStrawColor" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.strawColor}"/>

                                                <webuijsf:label id="labelPTM" style="width: 168px; height: 24px" text="#{resources.post_thaw_motility}"/>
                                                <webuijsf:textField id="textFieldPTM" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.postThawMotility}"/>

                                                <webuijsf:label id="labelActiveDoses" style="width: 168px; height: 24px" text="#{resources.active_doses}"/>
                                                <webuijsf:textField id="textFieldActiveDoses" style="width: 200px;" text="#{germplasm$SemenGatheringSessionBean.querySemenGatheringDTO.activeDoses}"/>

                                                

                                                

                                             
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                <h:commandButton action="#{germplasm$ListSemenGathering.btnAdvSearchSemenGathering_action}" id="btnAdvSearchGO"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>

                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                <h:outputLabel id="labelQuantity" value="#{germplasm$ListSemenGathering.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{germplasm$ListSemenGathering.btn_new_action}" id="btn_new"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                <h:commandButton action="#{germplasm$ListSemenGathering.btn_edit_action}" id="btn_edit"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton action="#{germplasm$ListSemenGathering.btn_delete_action}" id="btn_delete"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.previousResults}"
                                                    id="btnPrevious" rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisibleNext}"
                                                    style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{germplasm$SemenGatheringSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{germplasm$SemenGatheringSessionBean.pagination.isVisibleNext}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                                <h:dataTable binding="#{germplasm$ListSemenGathering.dataTableSemenGathering}" cellspacing="0"
                                            columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                            rowClasses="list-row-even,list-row-odd" rows="#{germplasm$SemenGatheringSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{germplasm$SemenGatheringSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['semenGatheringDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.time}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['semenGatheringTime']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.volume}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['volume']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.motility}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['motility']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.concentration}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['concentration']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.straw_quantity}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['strawQuantity']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.straw_size}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['strawSize']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.dilution}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['dilution']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.tank_number}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['tankNumber']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.canister_number}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['canisterNumber']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.goblet_number}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['gobletNumber']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.post_thaw_motility}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['postThawMotility']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.active_doses}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['activeDoses']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <!-- FIN Tabla que posee la lista de accessiones -->

                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
