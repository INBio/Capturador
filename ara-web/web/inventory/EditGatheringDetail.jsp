<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditGatheringDetail
    Created on : 02/09/2009, 09:08:07 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                            <webuijsf:label id="lbDetailEditTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.edit_gath_detail}: #{inventory$GatheringDetailSessionBean.currentGathering.gatheringObservationId}"/>
                            <h:panelGrid id="gridpNewDetail" style="height: 24px; left: 24px; top: 48px; position: absolute" width="600">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgEditDetail" infoClass="infoMessage"
                                    style="height: 40px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridpBotonera" style="height: 24px" width="510">
                                    <h:commandButton action="#{inventory$EditGatheringDetail.btnDetailList_action}" id="btnDetailList"
                                        style="height: 25px; width: 167px" styleClass="My_Button" value="#{resources.see_list}"/>
                                    <h:commandButton action="#{inventory$EditGatheringDetail.btnUpdateDetail_action}" id="btnUpdateDetail"
                                        style="height: 25px; width: 167px" styleClass="My_Button" value="#{resources.update}"/>
                                    <h:commandButton action="#{inventory$EditGatheringDetail.btnSpecimens_action}" id="btnSpecimens"
                                        style="height: 25px; width: 167px" styleClass="My_Button" value="#{resources.specimens}"/>
                                </h:panelGrid>
                                <webuijsf:panelLayout id="layoutpMorphoDescription" style="height: 236px; position: relative; width: 510px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label for="ddResponsible" id="lbResponsible" requiredIndicator="true"
                                        style="height: 24px; left: 72px; top: 48px; position: absolute; width: 164px" text="#{resources.person_in_charge}"/>
                                    <webuijsf:dropDown id="ddResponsible" items="#{inventory$EditGatheringDetail.collectorsData.options}" required="true"
                                        selected="#{inventory$GatheringDetailSessionBean.currentDetail.gatheringObservationDetailPersonId}"
                                        style="left: 240px; top: 48px; position: absolute; width: 190px" width="192px"/>
                                    <webuijsf:label for="txGatheringNumber" id="lbGatheringNumber" requiredIndicator="true"
                                        style="height: 24px; left: 72px; top: 24px; position: absolute; width: 164px" text="#{resources.gathering_number}"/>
                                    <webuijsf:textField binding="#{inventory$EditGatheringDetail.txGathNumber}" columns="26" id="txGatheringNumber"
                                        required="true" style="left: 240px; top: 24px; position: absolute"/>
                                    <webuijsf:label id="lbmorphodes" style="height: 24px; left: 72px; top: 115px; position: absolute; width: 164px" text="#{resources.morphological_description}"/>
                                    <webuijsf:textArea binding="#{inventory$EditGatheringDetail.txaMorphoDesc}" columns="24" id="txaMorphoDesc" style="height: 32px; left: 240px; top: 115px; position: absolute; width: 192px"/>
                                    <webuijsf:label id="lbDescriptionDate" style="height: 24px; left: 72px; top: 168px; position: absolute; width: 164px" text="#{resources.description_date}"/>
                                    <webuijsf:calendar binding="#{inventory$EditGatheringDetail.descDate}" columns="22" id="calDescriptionDate" style="height: 24px; left: 230px; top: 168px; position: absolute; width: 182px"/>
                                    <webuijsf:label id="lbDescriptor" style="height: 24px; left: 72px; top: 192px; position: absolute; width: 164px" text="#{resources.descriptor}"/>
                                    <webuijsf:dropDown id="ddDescriptor" items="#{inventory$EditGatheringDetail.descriptorsData.options}"
                                        selected="#{inventory$GatheringDetailSessionBean.currentDetail.descriptorId}"
                                        style="height: 24px; left: 240px; top: 192px; position: absolute; width: 192px" width="192px"/>
                                    <webuijsf:pageSeparator id="pageSeparator1" style="height: 0px; left: 0px; top: 64px; position: absolute; width: 502px"/>
                                </webuijsf:panelLayout>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
