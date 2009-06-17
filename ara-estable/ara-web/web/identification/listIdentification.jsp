<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{identification$listIdentification.page1}" id="page1">
            <webuijsf:html binding="#{identification$listIdentification.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{identification$listIdentification.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{identification$listIdentification.form1}" id="form1">
                            <h:messages binding="#{identification$listIdentification.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{identification$listIdentification.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.identifications}"/>
                            <webuijsf:table binding="#{identification$listIdentification.table1}" clearSortButton="true" id="table1" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 835px"
                                title="#{resources.identifications}" width="835">
                                <webuijsf:tableRowGroup binding="#{identification$listIdentification.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{identification$IdentificationSessionBean.pagination.dataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn1}" headerText="#{resources.specimen_id}"
                                        id="tableColumn1" sort="specimenId">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText1}" id="staticText1" text="#{currentRow.value['specimenId']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn2}" headerText="#{resources.taxon}"
                                        id="tableColumn2" sort="taxonName">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText2}" id="staticText2" text="#{currentRow.value['taxonName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn3}" headerText="#{resources.sequence}"
                                        id="tableColumn3" sort="identificationSequence">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText3}" id="staticText3" text="#{currentRow.value['identificationSequence']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn4}"
                                        headerText="#{resources.identification_date}" id="tableColumn4" sort="identificationDate">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText4}" id="staticText4" text="#{currentRow.value['identificationDate']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn5}" headerText="#{resources.identifier}"
                                        id="tableColumn5" sort="identifierPersonName">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText5}" id="staticText5" text="#{currentRow.value['identifierPersonName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn6}" headerText="#{resources.status}"
                                        id="tableColumn6" sort="identificationStatusName">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText6}" id="staticText6" text="#{currentRow.value['identificationStatusName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{identification$listIdentification.tableColumn7}" headerText="#{resources.type}"
                                        id="tableColumn7" sort="identificationTypeName">
                                        <webuijsf:staticText binding="#{identification$listIdentification.staticText7}" id="staticText7" text="#{currentRow.value['identificationTypeName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="center" binding="#{identification$listIdentification.tableColumn8}"
                                        headerText="#{resources.actions}" id="tableColumn8">
                                        <webuijsf:button actionExpression="#{identification$listIdentification.btn_remove_action}"
                                            binding="#{identification$listIdentification.btn_remove}" id="btn_remove" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{identification$listIdentification.btn_reIdentify_action}" id="btn_reIdentify" text="#{resources.re_identify}"/>
                                        <webuijsf:button actionExpression="#{identification$listIdentification.btn_search_action}" id="btn_search" text="#{resources.btnSearch}"/>

                                        <webuijsf:panelGroup separator=" " style="margin-left:100px;">
                                            <webuijsf:button actionExpression="#{identification$IdentificationSessionBean.pagination.firstResults}" visible="#{identification$IdentificationSessionBean.pagination.isVisiblePrevious}"
                                                             id="btnFirst" text="#{resources.pagination_first}" />
                                            <webuijsf:button actionExpression="#{identification$IdentificationSessionBean.pagination.previousResults}" visible="#{identification$IdentificationSessionBean.pagination.isVisiblePrevious}"
                                                             id="btnNext" text="#{resources.pagination_previous}" />
                                            <webuijsf:button actionExpression="#{identification$IdentificationSessionBean.pagination.nextResults}" visible="#{identification$IdentificationSessionBean.pagination.isVisibleNext}"
                                                             id="btnPrevious" text="#{resources.pagination_next}" />
                                            <webuijsf:button actionExpression="#{identification$IdentificationSessionBean.pagination.lastResults}" visible="#{identification$IdentificationSessionBean.pagination.isVisibleNext}"
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
