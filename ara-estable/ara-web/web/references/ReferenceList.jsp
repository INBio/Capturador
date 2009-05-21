<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{references$ReferenceList.page1}" id="page1">
            <webuijsf:html binding="#{references$ReferenceList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{references$ReferenceList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{references$ReferenceList.form1}" id="form1">
                            <webuijsf:table binding="#{references$ReferenceList.table1}" clearSortButton="true" id="table1" paginateButton="true"
                                paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute"
                                title="#{resources.biblicografic_references}" width="864">
                                <webuijsf:tableRowGroup binding="#{references$ReferenceList.tableRowGroup1}" id="tableRowGroup1" rows="20"
                                    sourceData="#{references$ReferenceSessionBean.referenceDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn2}" headerText="#{resources.title}" id="tableColumn2" sort="title">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText5}" id="staticText5" text="#{currentRow.value['title']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn5}" headerText="#{resources.publication_date}"
                                        id="tableColumn5" sort="publicationDate" width="100">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText2}" id="staticText2" text="#{currentRow.value['publicationDate']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn3}" headerText="#{resources.isbn_issn_uri}"
                                        id="tableColumn3" sort="identifier">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText3}" id="staticText3" text="#{currentRow.value['identifier']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn4}" headerText="#{resources.language}"
                                        id="tableColumn4" sort="languageName" width="200">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText6}" id="staticText6" text="#{currentRow.value['languageName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn6}" headerText="#{resources.type}" id="tableColumn6" sort="referenceTypeName">
                                        <webuijsf:staticText binding="#{references$ReferenceList.staticText4}" id="staticText4" text="#{currentRow.value['referenceTypeName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{references$ReferenceList.tableColumn7}" headerText="#{resources.actions}" id="tableColumn7">
                                        <webuijsf:button actionExpression="#{references$ReferenceList.btn_edit_action}"
                                            binding="#{references$ReferenceList.btn_edit}" id="btn_edit" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{references$ReferenceList.btn_remove_action}"
                                            binding="#{references$ReferenceList.btn_remove}" id="btn_remove" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <f:subview id="actionsTop">
                                        <webuijsf:button actionExpression="#{references$ReferenceList.btn_new_action}"
                                            binding="#{references$ReferenceList.btn_new}" id="btn_new" text="#{resources.btnNew}"/>
                                        <webuijsf:button actionExpression="#{references$ReferenceList.btn_search_action}"
                                            binding="#{references$ReferenceList.btn_search}" id="btn_search" text="#{resources.btnSearch}"/>
                                        <webuijsf:button actionExpression="#{references$ReferenceList.btn_showAll_action}"
                                            binding="#{references$ReferenceList.btn_showAll}" id="btn_reload" text="#{resources.btnUpdate}"/>
                                    </f:subview>
                                </f:facet>
                            </webuijsf:table>
                            <webuijsf:label binding="#{references$ReferenceList.label1}" id="label1"
                                style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.references}"/>
                            <h:messages binding="#{references$ReferenceList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="height: 24px; left: 384px; top: 24px; position: absolute; width: 262px" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
