<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$editGathering.page1}" id="page1">
            <webuijsf:html binding="#{gathering$editGathering.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$editGathering.body1}" id="body1" style="-rave-layout: grid">
                <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{gathering$editGathering.form1}" id="form1">
                            <webuijsf:button actionExpression="#{gathering$editGathering.btn_save_action}" binding="#{gathering$editGathering.btn_save}"
                                             id="btn_save" style="height: 24px; left: 815px; top: 24px; position: absolute; width: 96px" text="#{resources.btnUpdate}"/>
                            <h:messages binding="#{gathering$editGathering.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                        infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute; width: 214px" warnClass="warnMessage"/>
                            <webuijsf:panelLayout binding="#{gathering$editGathering.layoutPanel1}" id="layoutPanel1" style="height: 334px; left: 48px; top: 96px; position: absolute; width: 742px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$editGathering.label1}" id="label1" requiredIndicator="true"
                                                style="left: 24px; top: 48px; position: absolute" text="#{resources.site}"/>
                                <webuijsf:label binding="#{gathering$editGathering.label2}" id="label2" requiredIndicator="true"
                                                style="left: 24px; top: 72px; position: absolute" text="#{resources.initial_date}"/>
                                <webuijsf:label binding="#{gathering$editGathering.label3}" id="label3" requiredIndicator="true"
                                                style="left: 360px; top: 72px; position: absolute" text="#{resources.final_date}"/>
                                <webuijsf:label binding="#{gathering$editGathering.label4}" id="label4" style="left: 24px; top: 120px; position: absolute" text="#{resources.responsible}"/>
                                <webuijsf:dropDown binding="#{gathering$editGathering.dd_site}" converter="#{gathering$GatheringNew.longConverter1}"
                                                   id="dd_site" items="#{gathering$GatheringSessionBeanV2.sites}" selected="#{gathering$GatheringSessionBeanV2.selectedSite}" style="left: 144px; top: 48px; position: absolute; width: 479px"/>
                                <webuijsf:calendar binding="#{gathering$editGathering.cal_initialDate}" dateFormatPattern="dd/MM/yyyy"
                                                   dateFormatPatternHelp="dd/mm/yyyy" id="cal_initialDate" style="left: 144px; top: 72px; position: absolute"/>
                                <webuijsf:calendar binding="#{gathering$editGathering.cal_finalDate}" dateFormatPattern="dd/MM/yyyy"
                                                   dateFormatPatternHelp="dd/mm/yyyy" id="cal_finalDate" style="left: 432px; top: 72px; position: absolute"/>
                                <webuijsf:dropDown binding="#{gathering$editGathering.dd_responsiblePerson}"
                                                   converter="#{gathering$GatheringNew.longConverter1}" id="dd_responsiblePerson"
                                                   items="#{gathering$GatheringSessionBeanV2.responsiblePersons}"
                                                   selected="#{gathering$GatheringSessionBeanV2.selectedResponsiblePerson}" style="left: 144px; top: 120px; position: absolute; width: 287px"/>
                                <webuijsf:label binding="#{gathering$editGathering.label6}" id="label6" style="left: 24px; top: 144px; position: absolute" text="#{resources.elevation}"/>
                                <webuijsf:textField binding="#{gathering$editGathering.txt_minElevation}" columns="4"
                                                    converter="#{gathering$editGathering.longConverter1}" id="txt_minElevation" style="left: 144px; top: 144px; position: absolute; width: 20px"/>
                                <webuijsf:textField binding="#{gathering$editGathering.txt_maxElevation}" columns="4"
                                                    converter="#{gathering$editGathering.longConverter1}" id="txt_maxElevation" style="left: 144px; top: 168px; position: absolute; width: 47px"/>
                                <webuijsf:staticText binding="#{gathering$editGathering.staticText1}" id="staticText1"
                                                     style="left: 192px; top: 144px; position: absolute; width: 45px" text="#{resources.minimum}"/>
                                <webuijsf:staticText binding="#{gathering$editGathering.staticText2}" id="staticText2"
                                                     style="left: 192px; top: 168px; position: absolute; width: 45px" text="#{resources.maximum}"/>
                                <webuijsf:label binding="#{gathering$editGathering.label7}" id="label7"
                                                style="left: 264px; top: 144px; position: absolute; width: 69px" text="#{resources.depth}"/>
                                <webuijsf:staticText binding="#{gathering$editGathering.staticText3}" id="staticText3"
                                                     style="left: 408px; top: 168px; position: absolute; width: 45px" text="#{resources.maximum}"/>
                                <webuijsf:textField binding="#{gathering$editGathering.txt_minDepth}" columns="4"
                                                    converter="#{gathering$editGathering.longConverter1}" id="txt_minDepth" style="left: 360px; top: 144px; position: absolute; width: 47px"/>
                                <webuijsf:staticText binding="#{gathering$editGathering.staticText4}" id="staticText4"
                                                     style="left: 408px; top: 144px; position: absolute; width: 45px" text="#{resources.minimum}"/>
                                <webuijsf:textField binding="#{gathering$editGathering.txt_maxDept}" columns="4"
                                                    converter="#{gathering$editGathering.longConverter1}" id="txt_maxDept" style="left: 360px; top: 168px; position: absolute; width: 47px"/>
                                <webuijsf:label binding="#{gathering$editGathering.label8}" id="label8"
                                                style="left: 480px; top: 144px; position: absolute; width: 93px" text="#{resources.gradient}"/>
                                <webuijsf:textField binding="#{gathering$editGathering.txt_Gradient}" columns="6"
                                                    converter="#{gathering$editGathering.longConverter1}" id="txt_Gradient" style="left: 576px; top: 144px; position: absolute; width: 47px"/>
                                <webuijsf:label binding="#{gathering$editGathering.label9}" id="label9"
                                                style="left: 480px; top: 168px; position: absolute; width: 93px" text="#{resources.exposition}"/>
                                <webuijsf:dropDown binding="#{gathering$editGathering.dd_Exposition}" converter="#{gathering$GatheringNew.longConverter1}"
                                                   id="dd_Exposition" items="#{gathering$GatheringSessionBeanV2.expositions}"
                                                   selected="#{gathering$GatheringSessionBeanV2.selectedExposition}" style="left: 576px; top: 168px; position: absolute; width: 95px"/>
                                <webuijsf:label binding="#{gathering$editGathering.label10}" id="label10" style="left: 24px; top: 192px; position: absolute" text="#{resources.surroundings_description}"/>
                                <webuijsf:label binding="#{gathering$editGathering.label11}" id="label11" style="left: 336px; top: 192px; position: absolute" text="#{resources.site_description}"/>
                                <webuijsf:textArea binding="#{gathering$editGathering.txt_surroundings}" id="txt_surroundings" style="height: 119px; left: 24px; top: 216px; position: absolute; width: 263px"/>
                                <webuijsf:textArea binding="#{gathering$editGathering.txt_siteDesc}" id="txt_siteDesc" style="height: 119px; left: 336px; top: 216px; position: absolute; width: 288px"/>
                                <webuijsf:label binding="#{gathering$editGathering.label12}" id="label12" style="left: 24px; top: 24px; position: absolute" text="#{resources.id}"/>
                                <webuijsf:staticText binding="#{gathering$editGathering.st_id}" id="st_id" style="left: 144px; top: 24px; position: absolute"/>
                            </webuijsf:panelLayout>
                            <webuijsf:tabSet binding="#{gathering$editGathering.tabSet_gathering}" id="tabSet_gathering" selected="tab_Collectors" style="border: 1px solid gray; height: 382px; left: 48px; top: 432px; position: absolute; width: 742px">
                                <webuijsf:tab binding="#{gathering$editGathering.tab_Collectors}" id="tab_Collectors" text="#{resources.collectors}">
                                    <webuijsf:panelLayout binding="#{gathering$editGathering.layoutPanel2}" id="layoutPanel2" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$editGathering.ar_Collectors}"
                                                            converter="#{gathering$GatheringNew.longConverter1}" id="ar_Collectors"
                                                            items="#{gathering$GatheringSessionBeanV2.collectors}" moveButtons="true" selectAll="true"
                                                            selected="#{gathering$GatheringSessionBeanV2.selectedCollectors}" selectedItemsLabel="#{resources.selected}" style="height: 262px; left: 24px; top: 24px; position: absolute; width: 334px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{gathering$editGathering.tab_Proyectos}" id="tab_Proyectos" text="#{resources.projects}">
                                    <webuijsf:panelLayout binding="#{gathering$editGathering.layoutPanel3}" id="layoutPanel3" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$editGathering.ar_Projects}"
                                                            converter="#{gathering$GatheringNew.longConverter1}" id="ar_Projects"
                                                            items="#{gathering$GatheringSessionBeanV2.projects}" selectAll="true"
                                                            selected="#{gathering$GatheringSessionBeanV2.selectedProjects}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 24px; top: 24px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{gathering$editGathering.tab_Collections}" id="tab_Collections" text="#{resources.associate_collections}">
                                    <webuijsf:panelLayout binding="#{gathering$editGathering.layoutPanel4}" id="layoutPanel4" style="height: 296px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.available}" binding="#{gathering$editGathering.ar_Collections}"
                                                            converter="#{gathering$GatheringNew.longConverter1}" id="ar_Collections"
                                                            items="#{gathering$GatheringSessionBeanV2.collections}" selectAll="true"
                                                            selected="#{gathering$GatheringSessionBeanV2.selectedCollections}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 24px; top: 24px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{gathering$editGathering.tab_GatheringDetails}" id="tab_GatheringDetails" text="#{resources.collect_details}">
                                    <webuijsf:panelLayout binding="#{gathering$editGathering.layoutPanel5}" id="layoutPanel5" style="height: 346px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:table binding="#{gathering$editGathering.t_gatheringDetail}" id="t_gatheringDetail" paginateButton="true"
                                                        paginationControls="true" style="height: 48px; left: 24px; top: 24px; position: absolute; width: 642px"
                                                        title="#{resources.details}" width="642">
                                            <webuijsf:tableRowGroup binding="#{gathering$editGathering.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                                                    sourceData="#{gathering$GatheringSessionBeanV2.gatherinDetailDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn binding="#{gathering$editGathering.tableColumn1}" headerText="#{resources.id}"
                                                                      id="tableColumn1" width="0">
                                                    <webuijsf:staticText binding="#{gathering$editGathering.staticText6}" id="staticText6" text="#{currentRow.value['id']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn binding="#{gathering$editGathering.tableColumn2}" headerText="#{resources.responsible}"
                                                                      id="tableColumn2" width="186">
                                                    <webuijsf:staticText binding="#{gathering$editGathering.staticText7}" id="staticText7" text="#{currentRow.value['responsiblePersonName']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn binding="#{gathering$editGathering.tableColumn3}"
                                                                      headerText="#{resources.gathering_number}" id="tableColumn3">
                                                    <webuijsf:staticText binding="#{gathering$editGathering.staticText8}" id="staticText8" text="#{currentRow.value['gatheringObservationDetailNumber']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn binding="#{gathering$editGathering.tableColumn4}" headerText="#{resources.collection}" id="tableColumn4">
                                                    <webuijsf:staticText binding="#{gathering$editGathering.staticText9}" id="staticText9" text="#{currentRow.value['collectionName']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn align="center" binding="#{gathering$editGathering.tableColumn5}"
                                                                      headerText="#{resources.actions}" id="tableColumn5">
                                                    <webuijsf:button actionExpression="#{gathering$editGathering.btn_edit_action}"
                                                                     binding="#{gathering$editGathering.btn_edit}" id="btn_edit" text="#{resources.btnEdit}"/>
                                                    <webuijsf:button actionExpression="#{gathering$editGathering.btn_remove_action}"
                                                                     binding="#{gathering$editGathering.btn_remove}" id="btn_remove" text="#{resources.btnDelete}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                            <f:facet name="actionsTop">
                                                <webuijsf:button actionExpression="#{gathering$editGathering.btn_newDetail_action}"
                                                                 binding="#{gathering$editGathering.btn_newDetail}" id="btn_newDetail" text="#{resources.new_gathering_observation}"/>
                                            </f:facet>
                                        </webuijsf:table>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:staticText binding="#{gathering$editGathering.staticText5}" id="staticText5"
                                                 style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.edit_gathering_observation}"/>
                            <webuijsf:button actionExpression="#{gathering$editGathering.btn_specimenGeneration_action}"
                                             binding="#{gathering$editGathering.btn_specimenGeneration1}" id="btn_specimenGeneration1"
                                             style="height: 24px; left: 695px; top: 24px; position: absolute; width: 96px" text="#{resources.specimens}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
