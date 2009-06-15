<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$gatheringList.page1}" id="page1">
            <webuijsf:html binding="#{gathering$gatheringList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$gatheringList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{gathering$gatheringList.form1}" id="form1">
                            <h:messages binding="#{gathering$gatheringList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                        infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{gathering$gatheringList.label1}" id="label1"
                                            style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.gatherings_observations}"/>
                            <webuijsf:table binding="#{gathering$gatheringList.gatheringTable}" clearSortButton="true" id="gatheringTable" paginateButton="false"
                                            paginationControls="false" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 856px"
                                            title="#{resources.gatherings_observations}" width="856">
                                <webuijsf:tableRowGroup binding="#{gathering$gatheringList.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                                sourceData="#{gathering$GatheringSessionBeanV2.pagination.dataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn2}" headerText="#{resources.site}" id="tableColumn2" sort="siteName">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText2}" id="staticText2" text="#{currentRow.value['siteName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn3}" headerText="#{resources.initial_date}"
                                                          id="tableColumn3" sort="initialDate">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText3}" id="staticText3" text="#{currentRow.value['initialDate']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn4}" headerText="#{resources.final_date}"
                                                          id="tableColumn4" sort="finalDate">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText4}" id="staticText4" text="#{currentRow.value['finalDate']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn5}" headerText="#{resources.responsible}"
                                                          id="tableColumn5" sort="responsibleName">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText5}" id="staticText5" text="#{currentRow.value['responsibleName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$gatheringList.tableColumn7}" headerText="#{resources.collection}"
                                                          id="tableColumn7" sort="collectionName">
                                        <webuijsf:staticText binding="#{gathering$gatheringList.staticText7}" id="staticText7" text="#{currentRow.value['collectionName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn style="width:110px" binding="#{gathering$gatheringList.tableColumn6}" headerText="#{resources.actions}" id="tableColumn6">
                                        <webuijsf:button actionExpression="#{gathering$gatheringList.btn_edit_action}"
                                                         binding="#{gathering$gatheringList.btn_edit}" id="btn_edit" style="height: 24px; width: 47px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{gathering$gatheringList.btn_remove_action}"
                                                         binding="#{gathering$gatheringList.btn_remove}" id="btn_remove" style="height: 24px; width: 47px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{gathering$gatheringList.btn_new_action}" id="btn_new" text="#{resources.btnNew}"/>
                                        <webuijsf:button actionExpression="#{gathering$gatheringList.btn_search_action}" id="btn_search" text="#{resources.btnSearch}"/>

                                         <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:100px;">
                                            <webuijsf:button actionExpression="#{gathering$GatheringSessionBeanV2.pagination.firstResults}" visible="#{gathering$GatheringSessionBeanV2.pagination.isVisiblePrevious}"
                                                             id="btnFirst" text="#{resources.pagination_first}" />
                                            <webuijsf:button actionExpression="#{gathering$GatheringSessionBeanV2.pagination.previousResults}" visible="#{gathering$GatheringSessionBeanV2.pagination.isVisiblePrevious}"
                                                             id="btnNext" text="#{resources.pagination_previous}" />
                                            <webuijsf:button actionExpression="#{gathering$GatheringSessionBeanV2.pagination.nextResults}" visible="#{gathering$GatheringSessionBeanV2.pagination.isVisibleNext}"
                                                             id="btnPrevious" text="#{resources.pagination_next}" />
                                            <webuijsf:button actionExpression="#{gathering$GatheringSessionBeanV2.pagination.lastResults}" visible="#{gathering$GatheringSessionBeanV2.pagination.isVisibleNext}"
                                                             id="btnLast" text="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>

                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
