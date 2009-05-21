<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{group$GroupList.page1}" id="page1">
            <webuijsf:html binding="#{group$GroupList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{group$GroupList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{group$GroupList.form1}" id="form1">
                            <webuijsf:table binding="#{group$GroupList.groupTable1}" cellPadding="0" cellSpacing="0" clearSortButton="true" id="groupTable1"
                                paginateButton="true" paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute"
                                title="#{resources.systems_groups}" width="648">11
								<webuijsf:tableRowGroup binding="#{group$GroupList.tableRowGroup1}"
                                    id="tableRowGroup1" rows="10" sourceData="#{group$GroupSessionBean.groupDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{group$GroupList.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{group$GroupList.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{group$GroupList.tableColumn2}" headerText="#{resource.group_name}" id="tableColumn2" sort="userName">
                                        <webuijsf:staticText binding="#{group$GroupList.staticText2}" id="staticText2" text="#{currentRow.value['userName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{group$GroupList.tableColumn3}" headerText="#{resources.description}" id="tableColumn3" sort="fullName">
                                        <webuijsf:staticText binding="#{group$GroupList.staticText3}" id="staticText3" text="#{currentRow.value['fullName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="center" binding="#{group$GroupList.tableColumn4}" headerText="#{resources.action}"
                                        id="tableColumn4" width="200">
                                        <webuijsf:button actionExpression="#{group$GroupList.btn_Edit1_action}" binding="#{group$GroupList.btn_Edit1}"
                                            id="btn_Edit1" style="width: 59px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{group$GroupList.btn_disable1_action}" binding="#{group$GroupList.btn_disable1}"
                                            id="btn_disable1" onClick="return confirm (&quot;#{resources.delete_confirm_warn}&quot;);" style="width: 59px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <f:subview id="actionsTop">
                                        <webuijsf:button actionExpression="#{group$GroupList.btn_new_action}" binding="#{group$GroupList.btn_new1}"
                                            id="btn_new1" style="height: 20px; left: 380px; top: 5px; position: inherit" text="#{resources.btnNew}"/>
                                    </f:subview>
                                </f:facet>
                            </webuijsf:table>
                            <webuijsf:label binding="#{group$GroupList.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.users_groups}"/>
                            <h:messages binding="#{group$GroupList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
