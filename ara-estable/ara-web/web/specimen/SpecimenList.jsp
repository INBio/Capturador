<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{specimen$SpecimenList.page1}" id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{specimen$SpecimenList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{specimen$SpecimenList.form1}" id="form1">
                            <webuijsf:label binding="#{specimen$SpecimenList.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.specimens}"/>
                            <webuijsf:table binding="#{specimen$SpecimenList.specimenTable}" clearSortButton="true" id="specimenTable"
                                sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute" title="Specimens" width="864">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:button actionExpression="#{specimen$SpecimenList.btn_edit_action}" binding="#{specimen$SpecimenList.btn_edit}"
                                            id="btn_edit" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{specimen$SpecimenList.btn_search_action}" id="btn_search" text="#{resources.btnSearch}"/>
                                        <!--<webuijsf:button actionExpression="#{specimen$SpecimenList.btn_reload_action}" id="btn_reload" text="#{resources.btnUpdate}"/>-->
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:100px;">
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.firstResults}" id="btnFirst"
                                                text="primeros" visible="#{specimen$SpecimenSessionBean.pagination.isVisiblePrevious}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.previousResults}" id="btnNext"
                                                text="anteriores" visible="#{specimen$SpecimenSessionBean.pagination.isVisiblePrevious}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.nextResults}" id="btnPrevious"
                                                text="siguientes" visible="#{specimen$SpecimenSessionBean.pagination.isVisibleNext}"/>
                                            <webuijsf:button actionExpression="#{specimen$SpecimenSessionBean.pagination.lastResults}" id="btnLast"
                                                text="ultimos" visible="#{specimen$SpecimenSessionBean.pagination.isVisibleNext}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup binding="#{specimen$SpecimenList.tableRowGroup1}" id="tableRowGroup1" rows="15"
                                    selected="#{currentRow.value['selected']}" sourceData="#{specimen$SpecimenSessionBean.pagination.dataProvider}" sourceVar="currentRow">
                                    <!-- sourceData="#{specimen$SpecimenSessionBean.specimenDataProvider}" -->
                                    <webuijsf:tableColumn id="tableColumn1" selectId="checkbox1" width="1419">
                                        <webuijsf:checkbox id="checkbox1" selected="#{currentRow.value['selected']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.CatalogNumber}" id="tableColumn3" sort="catalogNumber">
                                        <webuijsf:staticText id="staticText3" text="#{currentRow.value['catalogNumber']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.institutioncode}" id="tableColumn15" sort="institutionCode" width="200">
                                        <webuijsf:staticText id="staticText14" text="#{currentRow.value['institutionCode']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.collection}" id="tableColumn4">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['collectionName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.category}" id="tableColumn5">
                                        <webuijsf:staticText id="staticText4" text="#{currentRow.value['specimenCategoryName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.type}" id="tableColumn6">
                                        <webuijsf:staticText id="staticText5" text="#{currentRow.value['specimenTypeName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.num_fragments}" id="tableColumn7">
                                        <webuijsf:staticText id="staticText6" text="#{currentRow.value['numberFragments']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.num_whole}" id="tableColumn8">
                                        <webuijsf:staticText id="staticText7" text="#{currentRow.value['numberWhole']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.origin}" id="tableColumn9">
                                        <webuijsf:staticText id="staticText8" text="#{currentRow.value['originName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.preservation_medium}" id="tableColumn10">
                                        <webuijsf:staticText id="staticText9" text="#{currentRow.value['preservationMediumName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.substrate}" id="tableColumn11">
                                        <webuijsf:staticText id="staticText10" text="#{currentRow.value['substrateName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.storage}" id="tableColumn12">
                                        <webuijsf:staticText id="staticText11" text="#{currentRow.value['storageName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.extraction_method}" id="tableColumn13">
                                        <webuijsf:staticText id="staticText12" text="#{currentRow.value['extractionMethodName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.discarded}" id="tableColumn14">
                                        <webuijsf:staticText id="staticText13" text="#{currentRow.value['discarded']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:tableColumn id="tableColumn2"/>
                            <webuijsf:staticText id="staticText2"/>
                            <h:messages binding="#{specimen$SpecimenList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <f:facet name="header">
                                <webuijsf:hyperlink actionExpression="#{specimen$SpecimenList.hlink_showWelcome_action}"
                                    binding="#{specimen$SpecimenList.hlink_showWelcome1}" id="hlink_showWelcome1"
                                    style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; height: 24px; left: 48px; top: 96px; position: absolute; width: 48px" text="Volver"/>
                            </f:facet>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
