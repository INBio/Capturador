<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{identification$searchByGathering.page1}" id="page1">
            <webuijsf:html binding="#{identification$searchByGathering.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{identification$searchByGathering.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{identification$searchByGathering.form1}" id="form1">
							|
							<webuijsf:label
                                binding="#{identification$searchByGathering.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 430px" text="#{resources.re_identify}"/>
                            <h:messages binding="#{identification$searchByGathering.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 528px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{identification$searchByGathering.label2}" id="label2"
                                style="font-size: 14px; height: 24px; left: 48px; top: 48px; position: absolute; width: 430px" text="#{resources.search_specimens_by_gathering}"/>
                            <webuijsf:label binding="#{identification$searchByGathering.label3}" id="label3" style="left: 48px; top: 96px; position: absolute" text="#{resources.recolection_id}"/>
                            <webuijsf:textField binding="#{identification$searchByGathering.txt_gatheringId}" id="txt_gatheringId" style="left: 192px; top: 96px; position: absolute; width: 48px"/>
                            <webuijsf:button actionExpression="#{identification$searchByGathering.btn_search_action}"
                                binding="#{identification$searchByGathering.btn_search}" id="btn_search"
                                style="height: 24px; left: 71px; top: 288px; position: absolute; width: 71px" text="#{resources.btnSearch}"/>
                            <webuijsf:textField binding="#{identification$searchByGathering.txt_specimenCount1}" id="txt_specimenCount1"
                                label="#{resources.specimens_quantity_found}:" readOnly="true"
                                style="height: 22px; left: 48px; top: 144px; position: absolute; width: 310px" text="#{identification$IdentificationSearchSessionBean.specimenCount}"/>
                            <webuijsf:button actionExpression="#{identification$searchByGathering.btn_load_action}"
                                binding="#{identification$searchByGathering.btn_load1}" id="btn_load1"
                                style="height: 24px; left: 167px; top: 288px; position: absolute; width: 120px" text="#{resources.load_specimens}"/>
                            <webuijsf:label binding="#{identification$searchByGathering.label4}" id="label4" style="left: 48px; top: 216px; position: absolute" text="#{resources.colection}"/>
                            <webuijsf:staticText binding="#{identification$searchByGathering.txt_collectionName1}" id="txt_collectionName1" style="color: rgb(51, 153, 0); font-weight: bold; left: 192px; top: 216px; position: absolute"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
