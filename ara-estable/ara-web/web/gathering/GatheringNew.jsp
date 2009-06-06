<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$GatheringNew.page1}" id="page1">
            <webuijsf:html binding="#{gathering$GatheringNew.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$GatheringNew.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{gathering$GatheringNew.form1}" id="form1">
                            <webuijsf:staticText binding="#{gathering$GatheringNew.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.new_gathering_observation}"/>
                            <h:messages binding="#{gathering$GatheringNew.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute; width: 240px" warnClass="warnMessage"/>
                            <webuijsf:panelLayout binding="#{gathering$GatheringNew.layoutPanel1}" id="layoutPanel1" style="border: 1px solid gray; height: 262px; left: 48px; top: 72px; position: absolute; width: 838px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$GatheringNew.label1}" id="label1" requiredIndicator="true"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.site}"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label2}" id="label2" requiredIndicator="true"
                                    style="left: 24px; top: 48px; position: absolute" text="#{resources.initial_date}"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label3}" id="label3" requiredIndicator="true"
                                    style="left: 360px; top: 48px; position: absolute" text="#{resources.final_date}"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label4}" id="label4" style="left: 24px; top: 96px; position: absolute" text="#{resources.responsible}"/>
                                <webuijsf:dropDown binding="#{gathering$GatheringNew.dd_site}" id="dd_site" items="#{gathering$GatheringSessionBeanV2.sites}"
                                    selected="#{gathering$GatheringSessionBeanV2.selectedSite}" style="left: 144px; top: 24px; position: absolute; width: 200px" width="200px"/>
                                <webuijsf:calendar binding="#{gathering$GatheringNew.cal_initialDate}" dateFormatPattern="dd/MM/yyyy"
                                    dateFormatPatternHelp="dd/mm/yyyy" id="cal_initialDate" style="left: 134px; top: 48px; position: absolute"/>
                                <webuijsf:calendar binding="#{gathering$GatheringNew.cal_finalDate}" dateFormatPattern="dd/MM/yyyy"
                                    dateFormatPatternHelp="dd/mm/yyyy" id="cal_finalDate" style="left: 436px; top: 48px; position: absolute"/>
                                <webuijsf:dropDown binding="#{gathering$GatheringNew.dd_responsiblePerson}" id="dd_responsiblePerson"
                                    items="#{gathering$GatheringSessionBeanV2.responsiblePersons}"
                                    selected="#{gathering$GatheringSessionBeanV2.selectedResponsiblePerson}"
                                    style="left: 144px; top: 96px; position: absolute; width: 200px" width="200px"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label7}" id="label7" style="left: 24px; top: 120px; position: absolute" text="#{resources.elevation}"/>
                                <webuijsf:textField binding="#{gathering$GatheringNew.txt_maxElevation}" columns="4" id="txt_maxElevation" style="left: 144px; top: 144px; position: absolute; width: 47px"/>
                                <webuijsf:staticText binding="#{gathering$GatheringNew.staticText2}" id="staticText2"
                                    style="left: 216px; top: 120px; position: absolute; width: 45px" text="#{resources.minimum}"/>
                                <webuijsf:staticText binding="#{gathering$GatheringNew.staticText3}" id="staticText3"
                                    style="left: 216px; top: 144px; position: absolute; width: 45px" text="#{resources.maximum}"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label8}" id="label8"
                                    style="left: 336px; top: 120px; position: absolute; width: 69px" text="#{resources.depth}"/>
                                <webuijsf:staticText binding="#{gathering$GatheringNew.staticText4}" id="staticText4"
                                    style="left: 504px; top: 144px; position: absolute; width: 45px" text="#{resources.maximum}"/>
                                <webuijsf:textField binding="#{gathering$GatheringNew.txt_minDepth}" columns="4" id="txt_minDepth" style="left: 432px; top: 120px; position: absolute; width: 47px"/>
                                <webuijsf:staticText binding="#{gathering$GatheringNew.staticText5}" id="staticText5"
                                    style="left: 504px; top: 120px; position: absolute; width: 45px" text="#{resources.minimum}"/>
                                <webuijsf:textField binding="#{gathering$GatheringNew.txt_maxDept}" columns="4" id="txt_maxDept" style="left: 432px; top: 144px; position: absolute; width: 47px"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label9}" id="label9"
                                    style="left: 600px; top: 120px; position: absolute; width: 93px" text="#{resources.gradient}"/>
                                <webuijsf:textField binding="#{gathering$GatheringNew.txt_Gradient}" columns="6" id="txt_Gradient" style="left: 696px; top: 120px; position: absolute; width: 47px"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label10}" id="label10"
                                    style="left: 600px; top: 144px; position: absolute; width: 93px" text="#{resources.exposition}"/>
                                <webuijsf:dropDown binding="#{gathering$GatheringNew.dd_Exposition}" id="dd_Exposition"
                                    items="#{gathering$GatheringSessionBeanV2.expositions}" selected="#{gathering$GatheringSessionBeanV2.selectedExposition}"
                                    style="left: 696px; top: 144px; position: absolute; width: 50px" width="50px"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label11}" id="label11" style="left: 144px; top: 168px; position: absolute" text="#{resources.surroundings_description}"/>
                                <webuijsf:label binding="#{gathering$GatheringNew.label12}" id="label12" style="left: 432px; top: 168px; position: absolute" text="#{resources.site_description}"/>
                                <webuijsf:textArea binding="#{gathering$GatheringNew.txt_surroundings}" id="txt_surroundings" style="height: 60px; left: 144px; top: 192px; position: absolute; width: 263px"/>
                                <webuijsf:textArea binding="#{gathering$GatheringNew.txt_siteDesc}" id="txt_siteDesc" style="height: 60px; left: 432px; top: 192px; position: absolute; width: 288px"/>
                                <webuijsf:textField binding="#{gathering$GatheringNew.txt_minElevation}" columns="4" id="txt_minElevation" style="left: 144px; top: 120px; position: absolute; width: 47px"/>
                            </webuijsf:panelLayout>
                            <webuijsf:tabSet binding="#{gathering$GatheringNew.tabSet_gathering}" id="tabSet_gathering" selected="tab_Collectors" style="border: 1px solid gray; height: 334px; left: 48px; top: 360px; position: absolute; width: 838px">
                                <webuijsf:tab binding="#{gathering$GatheringNew.tab_Collectors}" id="tab_Collectors" text="#{resources.collectors}">
                                    <webuijsf:panelLayout binding="#{gathering$GatheringNew.layoutPanel3}" id="layoutPanel3" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$GatheringNew.ar_Collectors}"
                                            id="ar_Collectors" items="#{gathering$GatheringSessionBeanV2.collectors}" moveButtons="true" selectAll="true"
                                            selected="#{gathering$GatheringSessionBeanV2.selectedCollectors}" selectedItemsLabel="#{resources.selected}" style="height: 262px; left: 24px; top: 24px; position: absolute; width: 334px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{gathering$GatheringNew.tab_Proyectos_action}"
                                    binding="#{gathering$GatheringNew.tab_Proyectos}" id="tab_Proyectos" text="#{resources.projects}">
                                    <webuijsf:panelLayout binding="#{gathering$GatheringNew.layoutPanel4}" id="layoutPanel4" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$GatheringNew.ar_Projects}"
                                            id="ar_Projects" items="#{gathering$GatheringSessionBeanV2.projects}" selectAll="true"
                                            selected="#{gathering$GatheringSessionBeanV2.selectedProjects}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 24px; top: 24px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{gathering$GatheringNew.tab_Collections}" id="tab_Collections" text="#{resources.associate_collections}">
                                    <webuijsf:panelLayout binding="#{gathering$GatheringNew.layoutPanel5}" id="layoutPanel5" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$GatheringNew.ar_Collections}"
                                            id="ar_Collections" items="#{gathering$GatheringSessionBeanV2.collections}" selectAll="true"
                                            selected="#{gathering$GatheringSessionBeanV2.selectedCollections}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 24px; top: 24px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:button actionExpression="#{gathering$GatheringNew.btn_save_action}" binding="#{gathering$GatheringNew.btn_save}"
                                id="btn_save" style="height: 24px; left: 695px; top: 24px; position: absolute; width: 96px" text="#{resources.btnSave}"/>
                            <webuijsf:button actionExpression="#{gathering$GatheringNew.btn_cancel_action}" binding="#{gathering$GatheringNew.btn_cancel}"
                                id="btn_cancel" style="height: 24px; left: 47px; top: 720px; position: absolute; width: 72px" text="#{resources.btnBack}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
