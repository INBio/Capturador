<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$generatedSpecimenList.page1}" id="page1">
            <webuijsf:html binding="#{gathering$generatedSpecimenList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$generatedSpecimenList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{gathering$generatedSpecimenList.form1}" id="form1">
                            <webuijsf:label binding="#{gathering$generatedSpecimenList.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 646px" text="Listado de especímenes generados"/>
                            <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn1}" id="tableColumn1"/>
                            <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn2}" id="tableColumn2"/>
                            <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn3}" id="tableColumn3"/>
                            <webuijsf:table binding="#{gathering$generatedSpecimenList.table1}" id="table1"
                                style="left: 48px; top: 216px; position: absolute; width: 750px" title="Table" width="750">
                                <webuijsf:tableRowGroup binding="#{gathering$generatedSpecimenList.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{gathering$SpecimenGenerationSessionBean.generatedSpecimenDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn4}" headerText="Id." id="tableColumn4" width="113">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn5}" headerText="Categoría" id="tableColumn5" width="117">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText2}" id="staticText2" text="#{currentRow.value['specimenCategoryName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn6}" headerText="Tipo" id="tableColumn6">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText3}" id="staticText3" text="#{currentRow.value['specimenTypeName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn7}" headerText="Método de colecta"
                                        id="tableColumn7" width="127">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText5}" id="staticText5" text="#{currentRow.value['gatheringObservationMethodName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn8}" headerText="Origen" id="tableColumn8">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText6}" id="staticText6" text="#{currentRow.value['originName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{gathering$generatedSpecimenList.tableColumn9}" headerText="Medio preserv."
                                        id="tableColumn9" width="122">
                                        <webuijsf:staticText binding="#{gathering$generatedSpecimenList.staticText7}" id="staticText7" text="#{currentRow.value['preservationMediumName']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:label binding="#{gathering$generatedSpecimenList.label2}" id="label2" style="left: 48px; top: 120px; position: absolute" text="Recolección"/>
                            <webuijsf:staticText binding="#{gathering$generatedSpecimenList.st_gatheringDesc}" id="st_gatheringDesc" style="height: 70px; left: 144px; top: 120px; position: absolute; width: 262px"/>
                            <webuijsf:label binding="#{gathering$generatedSpecimenList.label4}" id="label4" style="left: 48px; top: 96px; position: absolute" text="Colección"/>
                            <webuijsf:staticText binding="#{gathering$generatedSpecimenList.st_collectionName}" id="st_collectionName" style="color: rgb(0, 153, 51); font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 144px; top: 96px; position: absolute"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <!--<jsp:directive.include file="/footer.jspf"/>-->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
