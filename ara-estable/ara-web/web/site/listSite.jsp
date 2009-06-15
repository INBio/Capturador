<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{site$listSite.page1}" id="page1">
            <webuijsf:html binding="#{site$listSite.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{site$listSite.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{site$listSite.form1}" id="form1">
                            <h:messages binding="#{site$listSite.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                        infoClass="infoMessage" style="left: 456px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{site$listSite.label1}" id="label1"
                                            style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.sites}"/>



                            <webuijsf:table binding="#{site$listSite.table1}" 
                            clearSortButton="true"
                            id="table1"
                            paginateButton="true"
                            paginationControls="true"
                            sortPanelToggleButton="true" style="left: 48px; top: 100px; position: absolute" title="#{resources.locations}" width="864">
                                <webuijsf:tableRowGroup binding="#{site$listSite.tableRowGroup1}" id="tableRowGroup1" rows="#{site$SiteSessionBean.pagination.resultsPerPage}"
                                                        sourceData="#{site$SiteSessionBean.pagination.dataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{site$listSite.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn2}" headerText="#{resources.coordinates}" id="tableColumn2" sort="firstSiteCoordinate">
                                        <webuijsf:staticText binding="#{site$listSite.staticText2}" id="staticText2" text="#{currentRow.value['firstCoordinate']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn3}" headerText="#{resources.description}" id="tableColumn3" sort="description">
                                        <webuijsf:staticText binding="#{site$listSite.staticText3}" id="staticText3" text="#{currentRow.value['description']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn4}" headerText="#{resources.type}" id="tableColumn4">
                                        <webuijsf:staticText binding="#{site$listSite.staticText4}" id="staticText4" text="#{currentRow.value['featureTypeName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn5}" headerText="#{resources.base_proyection}" id="tableColumn5">
                                        <webuijsf:staticText binding="#{site$listSite.staticText5}" id="staticText5" text="#{currentRow.value['baseProjectionName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{site$listSite.tableColumn6}" headerText="#{resources.definition_method}" id="tableColumn6">
                                        <webuijsf:staticText binding="#{site$listSite.staticText6}" id="staticText6" text="#{currentRow.value['siteCalculationMethodName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn  style="width:110px" align="center" binding="#{site$listSite.tableColumn7}" headerText="#{resources.actions}" id="tableColumn7">
                                        <webuijsf:button actionExpression="#{site$listSite.btn_edit_action}" binding="#{site$listSite.btn_edit}" id="btn_edit"
                                                         style="height: 24px; width: 47px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{site$listSite.btn_remove_action}" binding="#{site$listSite.btn_remove}"
                                                         id="btn_remove" style="height: 24px; width: 47px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{site$listSite.btn_new_action}" id="btn_new" text="#{resources.btnNew}"/>
                                        <webuijsf:button actionExpression="#{site$listSite.btn_search_action}" id="btn_search" text="#{resources.btnSearch}"/>

                                        <webuijsf:panelGroup separator=" " style="margin-left:100px;">
                                            <webuijsf:button actionExpression="#{site$SiteSessionBean.pagination.firstResults}" visible="#{site$SiteSessionBean.pagination.isVisiblePrevious}"
                                                             id="btnFirst" text="#{resources.pagination_first}" />
                                            <webuijsf:button actionExpression="#{site$SiteSessionBean.pagination.previousResults}" visible="#{site$SiteSessionBean.pagination.isVisiblePrevious}"
                                                             id="btnNext" text="#{resources.pagination_previous}" />
                                            <webuijsf:button actionExpression="#{site$SiteSessionBean.pagination.nextResults}" visible="#{site$SiteSessionBean.pagination.isVisibleNext}"
                                                             id="btnPrevious" text="#{resources.pagination_next}" />
                                            <webuijsf:button actionExpression="#{site$SiteSessionBean.pagination.lastResults}" visible="#{site$SiteSessionBean.pagination.isVisibleNext}"
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
