<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$institution$listInstitution.page1}" id="page1">
            <webuijsf:html binding="#{admin$institution$listInstitution.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$institution$listInstitution.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$institution$listInstitution.form1}" id="form1">
                            <f:facet name="header"/>
                            <webuijsf:table binding="#{admin$institution$listInstitution.institutionTable}" clearSortButton="true" id="institutionTable"
                                paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                style="left: 48px; top: 72px; position: absolute; width: 507px" title="#{resources.institutions}" width="507">
                                <webuijsf:tableRowGroup binding="#{admin$institution$listInstitution.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{admin$institution$InstitutionSessionBean.institutionDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{admin$institution$listInstitution.tableColumn1}" headerText="#{resources.id}"
                                        id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{admin$institution$listInstitution.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$institution$listInstitution.tableColumn2}" headerText="#{resources.acronym}"
                                        id="tableColumn2" sort="acronym">
                                        <webuijsf:staticText binding="#{admin$institution$listInstitution.staticText2}" id="staticText2" text="#{currentRow.value['acronym']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$institution$listInstitution.tableColumn3}" headerText="#{resources.name}"
                                        id="tableColumn3" sort="name">
                                        <webuijsf:staticText binding="#{admin$institution$listInstitution.staticText3}" id="staticText3" text="#{currentRow.value['name']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$institution$listInstitution.tableColumn4}" headerText="#{resources.actions}"
                                        id="tableColumn4" width="200">
                                        <webuijsf:button actionExpression="#{admin$institution$listInstitution.btn_edit_action}"
                                            binding="#{admin$institution$listInstitution.btn_edit}" id="btn_edit" style="width: 59px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{admin$institution$listInstitution.btn_cancel_action}"
                                            binding="#{admin$institution$listInstitution.btn_cancel}" id="btn_cancel" style="width: 59px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{admin$institution$listInstitution.btn_new_action}"
                                            binding="#{admin$institution$listInstitution.btn_new}" id="btn_new" text="#{resources.btnNew}"/>
                                        <webuijsf:button actionExpression="#{admin$institution$listInstitution.btn_search_action}"
                                            binding="#{admin$institution$listInstitution.btn_search}" id="btn_search" text="#{resources.btnSearch}"/>
                                        <webuijsf:button actionExpression="#{admin$institution$listInstitution.btn_showAll_action}"
                                            binding="#{admin$institution$listInstitution.btn_showAll}" id="btn_reload" text="#{resources.btnUpdate}"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                            <webuijsf:label binding="#{admin$institution$listInstitution.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.institutions}"/>
                            <h:messages binding="#{admin$institution$listInstitution.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
