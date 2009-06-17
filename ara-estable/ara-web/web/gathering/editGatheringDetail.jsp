<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$editGatheringDetail.page1}" id="page1">
            <webuijsf:html binding="#{gathering$editGatheringDetail.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$editGatheringDetail.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{gathering$editGatheringDetail.form1}" id="form1">
                            <h:messages binding="#{gathering$editGatheringDetail.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:button actionExpression="#{gathering$editGatheringDetail.btn_save_action}"
                                binding="#{gathering$editGatheringDetail.btn_save}" id="btn_save"
                                style="height: 24px; left: 359px; top: 72px; position: absolute; width: 72px" text="#{resources.btnUpdate}"/>
                            <webuijsf:staticText binding="#{gathering$editGatheringDetail.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.edit_gathering_detail}"/>
                            <webuijsf:panelLayout binding="#{gathering$editGatheringDetail.layoutPanel1}" id="layoutPanel1" style="height: 118px; left: 48px; top: 120px; position: absolute; width: 334px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label7}" id="label7" style="position: absolute; left: 0px; top: 0px" text="#{resources.id}"/>
                                <webuijsf:staticText binding="#{gathering$editGatheringDetail.st_gatheringDetailId}" id="st_gatheringDetailId" style="left: 168px; top: 0px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label1}" id="label1" requiredIndicator="true"
                                    style="left: 0px; top: 24px; position: absolute" text="#{resources.responsible}"/>
                                <webuijsf:dropDown binding="#{gathering$editGatheringDetail.dd_collector}" id="dd_collector"
                                    items="#{gathering$GatheringDetailSessionBean.collectors}"
                                    selected="#{gathering$GatheringDetailSessionBean.selectedCollector}" style="left: 168px; top: 24px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label2}" id="label2" style="left: 0px; top: 48px; position: absolute" text="#{resources.gathering_number}"/>
                                <webuijsf:textField binding="#{gathering$editGatheringDetail.txt_gatheringNumber}" id="txt_gatheringNumber" style="left: 168px; top: 48px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label3}" id="label3" style="left: 0px; top: 72px; position: absolute" text="#{resources.collection}"/>
                                <webuijsf:staticText binding="#{gathering$editGatheringDetail.txt_collectionName1}" id="txt_collectionName1" style="color: rgb(51, 153, 0); font-weight: bold; left: 168px; top: 72px; position: absolute"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{gathering$editGatheringDetail.layoutPanel2}" id="layoutPanel2" style="height: 238px; left: 408px; top: 120px; position: absolute; width: 598px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label4}" id="label4" text="#{resources.morphological_description}"/>
                                <webuijsf:textArea binding="#{gathering$editGatheringDetail.txt_morphologicalDescription}" id="txt_morphologicalDescription" style="height: 167px; left: 168px; top: 0px; position: absolute; width: 431px"/>
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label5}" id="label5" style="left: 0px; top: 120px; position: absolute" text="#{resources.description_date}"/>
                                <webuijsf:calendar binding="#{gathering$editGatheringDetail.cal_descDate}" id="cal_descDate" style="left: 168px; top: 120px; position: absolute" maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" />
                                <webuijsf:label binding="#{gathering$editGatheringDetail.label6}" id="label6" style="left: 0px; top: 168px; position: absolute" text="#{resources.descriptor}"/>
                                <webuijsf:dropDown binding="#{gathering$editGatheringDetail.dd_descriptor}" id="dd_descriptor"
                                    items="#{gathering$GatheringDetailSessionBean.descriptors}"
                                    selected="#{gathering$GatheringDetailSessionBean.selectedDescriptor}" style="left: 168px; top: 168px; position: absolute"/>
                            </webuijsf:panelLayout>
                            <webuijsf:button actionExpression="#{gathering$editGatheringDetail.btn_specimenGeneration_action}"
                                binding="#{gathering$editGatheringDetail.btn_specimenGeneration}" id="btn_specimenGeneration"
                                style="height: 24px; left: 455px; top: 72px; position: absolute; width: 71px" text="#{resources.generate}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
