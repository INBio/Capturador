<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$newGatheringDetail.page1}" id="page1">
            <webuijsf:html binding="#{gathering$newGatheringDetail.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$newGatheringDetail.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{gathering$newGatheringDetail.form1}" id="form1">
                            <h:messages binding="#{gathering$newGatheringDetail.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 360px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:staticText binding="#{gathering$newGatheringDetail.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 238px" text="#{resources.new_gath_detail}"/>
                            <webuijsf:button actionExpression="#{gathering$newGatheringDetail.btn_save_action}"
                                binding="#{gathering$newGatheringDetail.btn_save}" id="btn_save"
                                style="height: 24px; left: 359px; top: 72px; position: absolute; width: 72px" text="#{resources.btnSave}"/>
                            <webuijsf:panelLayout binding="#{gathering$newGatheringDetail.layoutPanel1}" id="layoutPanel1" style="height: 118px; left: 24px; top: 120px; position: absolute; width: 334px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label1}" id="label1" requiredIndicator="true"
                                    style="left: 0px; top: 24px; position: absolute" text="#{resources.responsible}"/>
                                <webuijsf:dropDown binding="#{gathering$newGatheringDetail.dd_collector}" id="dd_collector"
                                    items="#{gathering$GatheringDetailSessionBean.collectors}"
                                    selected="#{gathering$GatheringDetailSessionBean.selectedCollector}" style="left: 168px; top: 24px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label2}" id="label2" style="left: 0px; top: 48px; position: absolute" text="#{resources.gathering_number}"/>
                                <webuijsf:textField binding="#{gathering$newGatheringDetail.txt_gatheringNumber}" id="txt_gatheringNumber" style="left: 168px; top: 48px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label3}" id="label3" style="left: 0px; top: 72px; position: absolute" text="#{resources.collection}"/>
                                <webuijsf:staticText binding="#{gathering$newGatheringDetail.txt_collectionName}" id="txt_collectionName" style="color: rgb(51, 153, 0); font-weight: bold; left: 168px; top: 72px; position: absolute"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{gathering$newGatheringDetail.layoutPanel2}" id="layoutPanel2" style="height: 262px; left: 384px; top: 120px; position: absolute; width: 598px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label4}" id="label4" style="left: 0px; top: 24px; position: absolute" text="#{resources.morphological_description}"/>
                                <webuijsf:textArea binding="#{gathering$newGatheringDetail.txt_morphologicalDescription}" id="txt_morphologicalDescription" style="height: 143px; left: 168px; top: 24px; position: absolute; width: 431px"/>
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label5}" id="label5" style="left: 0px; top: 120px; position: absolute" text="#{resources.description_date}"/>
                                <webuijsf:calendar binding="#{gathering$newGatheringDetail.cal_descDate}" dateFormatPattern="dd-MM-yyyy"
                                    maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" dateFormatPatternHelp="dd-MM-aaaa&#xa;" id="cal_descDate" style="left: 168px; top: 120px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$newGatheringDetail.label6}" id="label6" style="left: 0px; top: 168px; position: absolute" text="Descriptor"/>
                                <webuijsf:dropDown binding="#{gathering$newGatheringDetail.dd_descriptor}" id="dd_descriptor"
                                    items="#{gathering$GatheringDetailSessionBean.descriptors}"
                                    selected="#{gathering$GatheringDetailSessionBean.selectedDescriptor}" style="left: 168px; top: 168px; position: absolute"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
