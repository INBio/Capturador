<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewSemenGathering
    Created on : 08/04/2010, 09:51:47 AM
    Author     : dasolano
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.new_semen_gathering}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:panelGrid id="contenterrorMessage" columns="1" style="position:absoulte">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                </h:panelGrid>

                                <!-- save button -->
                                <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                    <h:commandButton  id="saveSemenGatheringButton"
                                                      action="#{germplasm$NewSemenGathering.saveSemenGathering}"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_semen_gathering}"/>
                                </webuijsf:panelGroup>

                                <h:panelGrid id="content" columns="2" style="position:relative; width:840px">

                                    <h:panelGrid id="content1" columns="2" style="position:relative;">
                                        <webuijsf:label id="labelGatheringDate" style="width: 168px; height: 24px" text="#{resources.semen_gathering_date}"/>
                                        <webuijsf:calendar binding="#{germplasm$NewSemenGathering.gatheringDate}"
                                            id="calendarGatheringDate" style="width: 50px" required="true"/>

                                        <webuijsf:label id="labelVolume" style="width: 168px; height: 24px" text="#{resources.volume}"/>
                                        <webuijsf:textField columns="25" id="textFieldVolume" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.volume}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelMotility" style="width: 168px; height: 24px" text="#{resources.motility}"/>
                                        <webuijsf:textField columns="25"  id="textFieldMotility" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.motility}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelMassMotility" style="width: 168px; height: 24px" text="#{resources.mass_motility}"/>
                                        <webuijsf:textField columns="25" id="textFieldMassMotility" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.massMotility}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelConcentration" style="width: 168px; height: 24px" text="#{resources.concentration}"/>
                                        <webuijsf:textField columns="25" id="textFieldConcentration" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.concentration}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelConsistency" style="width: 168px; height: 24px" text="#{resources.consistency}"/>
                                        <webuijsf:textField columns="25" id="textFieldConsistency" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.consistency}"/>

                                        <webuijsf:label id="labelSemenColor" style="width: 168px; height: 24px" text="#{resources.semen_color}"/>
                                        <webuijsf:textField columns="25" id="textFieldSemenColor" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.semenColor}"/>

                                        <webuijsf:label id="labelPH" style="width: 168px; height: 24px" text="#{resources.ph}"/>
                                        <webuijsf:textField columns="25" id="textFieldPH" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.ph}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelDilution" style="width: 168px; height: 24px" text="#{resources.dilution}"/>
                                        <webuijsf:textField columns="25" id="textFieldDilution" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.dilution}"/>

                                        <webuijsf:label id="labelPTM" style="width: 168px; height: 24px" text="#{resources.post_thaw_motility}"/>
                                        <webuijsf:textField columns="25" id="textFieldPTM" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.postThawMotility}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                    </h:panelGrid>

                                    <h:panelGrid id="content2" columns="2" style="position:relative;">
                                        <webuijsf:label id="labelGatheringTime" style="width: 168px; height: 24px" text="#{resources.semen_gathering_time}"/>
                                        <h:panelGrid id="panelTime" columns="3">

                                            <webuijsf:dropDown id="dropdownhh"  width="43px" required="true"
                                                           items="#{germplasm$NewSemenGathering.hourDropDown.options}"
                                                           selected="#{germplasm$SemenGatheringSessionBean.selectedHour}"/>
                                            <webuijsf:label id="labelDP" text=":"/>
                                            <webuijsf:dropDown id="dropdownmm"  width="43px" required="true"
                                                           items="#{germplasm$NewSemenGathering.minutesDropDown.options}"
                                                           selected="#{germplasm$SemenGatheringSessionBean.selectedMinutes}"/>

                                        </h:panelGrid>

                                        <webuijsf:label id="labelStrawQuantity" style="width: 168px; height: 24px" text="#{resources.straw_quantity}"/>
                                        <webuijsf:textField columns="25" id="textFieldStrawQuantity" style="width: 200px;" required="true"
                                                        text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.strawQuantity}">
                                        <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelCurrentStrawQuantity" style="width: 168px; height: 24px" text="#{resources.current_straw_quantity}"/>
                                        <webuijsf:textField columns="25" id="textFieldCurrentStrawQuantity" style="width: 200px;"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.currentStrawQuantity}">
                                        <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                        <webuijsf:label id="labelStrawSize" style="width: 168px; height: 24px" text="#{resources.straw_size}"/>
                                        <webuijsf:textField columns="25" id="textFieldStrawSize" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.strawSize}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>



                                        <webuijsf:label id="labelStrawColor" style="width: 168px; height: 24px" text="#{resources.straw_color}"/>
                                        <webuijsf:textField columns="25" id="textFieldStrawColor" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.strawColor}"/>



                                        <webuijsf:label id="labelTankNumber" style="width: 168px; height: 24px" text="#{resources.tank_number}"/>
                                        <webuijsf:textField columns="25" id="textFieldTankNumber" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.tankNumber}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>



                                        <webuijsf:label id="labelCanisterNumber" style="width: 168px; height: 24px" text="#{resources.canister_number}"/>
                                        <webuijsf:textField columns="25" id="textFieldCanisterNumber" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.canisterNumber}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>



                                        <webuijsf:label id="labelGobletNumber" style="width: 168px; height: 24px" text="#{resources.goblet_number}"/>
                                        <webuijsf:textField columns="25" id="textFieldGobletNumber" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.gobletNumber}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>



                                        <webuijsf:label id="labelSemenGatheringMethod" style="width: 168px; height: 24px" text="#{resources.semen_gathering_method}"/>
                                        <webuijsf:dropDown id="dropdownSemenGatheringMethod"  width="190px" required="true"
                                                           items="#{germplasm$NewSemenGathering.semenGatheringMethod.options}"
                                                           selected="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.semenGatheringMethodId}"/>




                                        <webuijsf:label id="labelSolvent" style="width: 168px; height: 24px" text="#{resources.solvent}"/>
                                        <webuijsf:dropDown id="dropdownSolvent"  width="190px"
                                                           items="#{germplasm$NewSemenGathering.solvent.options}" required="true"
                                                           selected="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.solventId}"/>



                                        <webuijsf:label id="labelActiveDoses" style="width: 168px; height: 24px" text="#{resources.active_doses}"/>
                                        <webuijsf:textField columns="25" id="textFieldActiveDoses" style="width: 200px;" required="true"
                                                            text="#{germplasm$SemenGatheringSessionBean.semenGatheringDTO.activeDoses}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>

                                    </h:panelGrid>

                                    

                                    

                                    

                                    

                                    

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
