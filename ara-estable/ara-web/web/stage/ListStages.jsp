<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{stage$ListStages.page1}" id="page1">
            <webuijsf:html binding="#{stage$ListStages.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{stage$ListStages.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{stage$ListStages.form1}" id="form1">
                            <webuijsf:table binding="#{stage$ListStages.stagesTable}" id="stagesTable" paginateButton="true" paginationControls="true"
                                sortPanelToggleButton="true" style="height: 46px; left: 48px; top: 72px; position: absolute"
                                title="#{resources.species_record_stages}" width="840">
                                <webuijsf:tableRowGroup binding="#{stage$ListStages.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{AraApplicationBean.stagesDP}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{stage$ListStages.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{stage$ListStages.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{stage$ListStages.tableColumn2}" headerText="#{resources.name}" id="tableColumn2" sort="name">
                                        <webuijsf:staticText binding="#{stage$ListStages.staticText2}" id="staticText2" text="#{currentRow.value['name']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{stage$ListStages.tableColumn3}" headerText="#{resources.description}" id="tableColumn3" sort="description">
                                        <webuijsf:staticText binding="#{stage$ListStages.staticText3}" id="staticText3" text="#{currentRow.value['description']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{stage$ListStages.tableColumn4}" headerText="#{resources.actions}" id="tableColumn4" width="200">
                                        <webuijsf:button actionExpression="#{stage$ListStages.btn_edit_action}" binding="#{stage$ListStages.btn_edit}"
                                            id="btn_edit" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{stage$ListStages.btn_delete_action}" binding="#{stage$ListStages.btn_delete}"
                                            id="btn_delete" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{stage$ListStages.btn_newStage_action}" binding="#{stage$ListStages.btn_newStage}"
                                            id="btn_newStage" style="width: 79px" text="#{resources.btnNew}"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                            <f:facet name="header">
                                <h:outputText binding="#{stage$ListStages.outputText1}" id="outputText1"
                                    style="background-color: rgb(153, 153, 0); color: rgb(255, 255, 255); left: 48px; top: 120px; position: absolute"
                                    title="#{resources.modules}" value="#{resources.modules}"/>
                            </f:facet>
                            <webuijsf:label binding="#{stage$ListStages.stages}" id="stages"
                                style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 382px" text="#{resources.stages}"/>
                            <h:messages binding="#{stage$ListStages.messageList}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList"
                                infoClass="infoMessage" style="left: 456px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
