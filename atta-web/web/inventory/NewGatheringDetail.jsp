<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewGatheringDetail
    Created on : 07/09/2009, 09:44:07 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbDetailNewTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                    styleClass="Page_title" value="#{resources.new_gath_detail}: #{inventory$GatheringDetailSessionBean.currentGathering.gatheringObservationId}"/>
                                <h:panelGrid id="gridpNewDetail" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgNewDetail" infoClass="infoMessage"
                                        style="height: 40px; width: 574px" warnClass="warnMessage"/>
                                    <h:panelGrid columns="1" id="gridpBotonera" style="height: 24px" width="500">
                                        <h:commandButton action="#{inventory$NewGatheringDetail.btnSaveDetail_action}" id="btnSaveDetail"
                                            style="height: 25px; width: 250px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                    </h:panelGrid>
                                    <webuijsf:panelLayout id="layoutpMorphoDescription" style="height: 236px; position: relative; width: 510px; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="ddResponsible" id="lbResponsible" requiredIndicator="true"
                                            style="height: 24px; left: 72px; top: 48px; position: absolute; width: 164px" text="#{resources.person_in_charge}"/>
                                        <webuijsf:dropDown id="ddResponsible" items="#{inventory$NewGatheringDetail.collectorsData.options}" required="true"
                                            selected="#{inventory$GatheringDetailSessionBean.selectedCollector}"
                                            style="left: 240px; top: 48px; position: absolute; width: 190px" width="192px"/>
                                        <webuijsf:label for="txGatheringNumber" id="lbGatheringNumber" requiredIndicator="true"
                                            style="height: 24px; left: 72px; top: 24px; position: absolute; width: 164px" text="#{resources.gathering_number}"/>
                                        <webuijsf:textField binding="#{inventory$NewGatheringDetail.txGathNumber}" columns="26" id="txGatheringNumber"
                                            required="true" style="left: 240px; top: 24px; position: absolute"/>
                                        <webuijsf:label id="lbmorphodes" style="height: 24px; left: 72px; top: 115px; position: absolute; width: 164px" text="#{resources.morphological_description}"/>
                                        <webuijsf:textArea binding="#{inventory$NewGatheringDetail.txaMorphoDesc}" columns="24" id="txaMorphoDesc" style="height: 32px; left: 240px; top: 115px; position: absolute; width: 192px"/>
                                        <webuijsf:label id="lbDescriptionDate" style="height: 24px; left: 72px; top: 168px; position: absolute; width: 164px" text="#{resources.description_date}"/>
                                        <webuijsf:calendar binding="#{inventory$NewGatheringDetail.descDate}" columns="22" id="calDescriptionDate" style="height: 24px; left: 230px; top: 168px; position: absolute; width: 182px"/>
                                        <webuijsf:label id="lbDescriptor" style="height: 24px; left: 72px; top: 192px; position: absolute; width: 164px" text="#{resources.descriptor}"/>
                                        <webuijsf:dropDown id="ddDescriptor" items="#{inventory$NewGatheringDetail.descriptorsData.options}"
                                            selected="#{inventory$GatheringDetailSessionBean.selectedDescriptor}"
                                            style="height: 24px; left: 240px; top: 192px; position: absolute; width: 192px" width="192px"/>
                                        <webuijsf:pageSeparator id="pageSeparator1" style="height: 0px; left: 0px; top: 64px; position: absolute; width: 502px"/>
                                    </webuijsf:panelLayout>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
