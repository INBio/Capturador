<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$profile$listProfile.page1}" id="page1">
            <webuijsf:html binding="#{admin$profile$listProfile.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$profile$listProfile.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$profile$listProfile.form1}" id="form1">
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <webuijsf:alert binding="#{admin$profile$listProfile.profileAlert}" id="profileAlert"
                                style="height: 45px; left: 168px; top: 96px; position: absolute; width: 597px" visible="false"/>
                            <webuijsf:table binding="#{admin$profile$listProfile.profileTable}" clearSortButton="true" id="profileTable" paginateButton="true"
                                paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 507px"
                                title="#{resources.profiles}" width="507">
                                <webuijsf:tableRowGroup binding="#{admin$profile$listProfile.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{admin$profile$ProfileSessionBean.profileDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{admin$profile$listProfile.tableColumn1}" headerText="Id" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{admin$profile$listProfile.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$profile$listProfile.tableColumn2}" headerText="#{resources.name}" id="tableColumn2" sort="name">
                                        <webuijsf:staticText binding="#{admin$profile$listProfile.staticText2}" id="staticText2" text="#{currentRow.value['name']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$profile$listProfile.tableColumn3}" headerText="#{resources.description}"
                                        id="tableColumn3" sort="description">
                                        <webuijsf:staticText binding="#{admin$profile$listProfile.staticText3}" id="staticText3" text="#{currentRow.value['description']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{admin$profile$listProfile.tableColumn4}" headerText="#{resources.actions}"
                                        id="tableColumn4" width="200">
                                        <webuijsf:button actionExpression="#{admin$profile$listProfile.btn_edit_action}"
                                            binding="#{admin$profile$listProfile.btn_edit}" id="btn_edit" style="width: 59px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{admin$profile$listProfile.btn_remove_action}"
                                            binding="#{admin$profile$listProfile.btn_remove}" id="btn_remove" style="width: 59px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{admin$profile$listProfile.btn_newProfile_action}"
                                            binding="#{admin$profile$listProfile.btn_newProfile}" id="btn_newProfile" style="width: 79px" text="#{resources.btnNew}"/>
                                        <webuijsf:button actionExpression="#{admin$profile$listProfile.btn_searchProfile_action}"
                                            binding="#{admin$profile$listProfile.btn_searchProfile}" id="btn_searchProfile" style="width: 79px" text="#{resources.btnSearch}"/>
                                        <webuijsf:button actionExpression="#{admin$profile$listProfile.btn_showAll_action}"
                                            binding="#{admin$profile$listProfile.btn_showAll}" id="btn_reload" text="#{resources.btnUpdate}"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                            <h:messages binding="#{admin$profile$listProfile.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{admin$profile$listProfile.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.users_profiles}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
