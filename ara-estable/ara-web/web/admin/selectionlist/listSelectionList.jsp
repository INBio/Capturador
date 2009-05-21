<?xml version="1.0" encoding="UTF-8"?>
<!-- 
	Document   : listSelectionList
	Created on : Feb 24, 2009, 9:49:20 AM
	Author     : jgutierrez
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <!-- Acá inicia el headerr -->
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <!-- Fin del headerr -->
                            <!-- Inicio del Título -->
                            <webuijsf:label id="label1" style="font-size: 24px; height: 28px; left: 24px; top: 120px; position: absolute; width: 334px" text="#{resources.menuModuleSelectionLists}"/>
                            <!-- Fin del Título -->
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage"
                                style="left: 480px; top: 120px; position: absolute" warnClass="warnMessage"/>
                            <!--listas de seleccion-->
                            <webuijsf:label id="label2" style="font-size: 24px; height: 28px; left: 24px; top: 240px; position: absolute; width: 574px" text="#{resources.selection_list_value_subtitle}">
                                <f:param value="#{admin$selectionlist$SelectionListSessionBean.actualSelectionList.description}"/>
                            </webuijsf:label>
                                <webuijsf:dropDown id="selectionListDropDown"
                                    items="#{admin$selectionlist$SelectionListSessionBean.selectionListDropDownData.options}"
                                    selected="#{admin$selectionlist$SelectionListSessionBean.selectionListDropDownData.selectedValue}"
                                    style="left: 24px; top: 168px; position: absolute" valueChangeListenerExpression="#{admin$selectionlist$listSelectionList.selectionListDropDown_processValueChange}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.selectionListChangeHandler}"
                                    id="btn_updateSelectionListValues" style="left: 432px; top: 168px; position: absolute" text="#{resources.btnUpdate}"/>
                            <!-- valores de la lista de selecciones -->
                            <webuijsf:panelLayout id="selectionListValuesPanel" visible="#{admin$selectionlist$listSelectionList.showSelectionListValuePanel}">
                                <!-- valueChangeListenerExpression="#{admin$selectionlist$listSelectionList.radioButtonGroup1_processValueChange}"  -->
                                <!--required="#{admin$selectionlist$listSelectionList.requieredSelectedSelectionListValue}"-->
                                <webuijsf:radioButtonGroup id="radioButtonGroup1"
                                    items="#{admin$selectionlist$SelectionListSessionBean.selectionListValuesRadioButtonGroup.options}" required="false"
                                    selected="#{admin$selectionlist$SelectionListSessionBean.selectionListValuesRadioButtonGroup.selectedValue}" style="left: 24px; top: 312px; position: absolute"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.refreshValues}" id="btn_showCollections"
                                    style="left: 432px; top: 312px; position: absolute; width: 96px" text="#{resources.associate_collections}" visible="#{admin$selectionlist$listSelectionList.showCollectionsPanel}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.editActualSelectionListValue}"
                                    id="btn_editSelecionListValue" style="left: 432px; top: 360px; position: absolute; width: 96px" text="#{resources.btnEdit}" visible="#{admin$selectionlist$listSelectionList.showCollectionsPanel}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.newSelectionListValue}"
                                    id="btn_newSelectionListValue" style="left: 432px; top: 408px; position: absolute; width: 96px" text="#{resources.btnNew}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.deleteSelectionListValue}" id="btn_deleteValue"
                                    style="left: 432px; top: 456px; position: absolute; width: 95px" text="#{resources.btnDelete}" visible="#{admin$selectionlist$listSelectionList.showCollectionsPanel}"/>
                            </webuijsf:panelLayout>
                            <!-- edit SelectionListValue -->
                            <webuijsf:panelLayout id="editSelectionListValuePanel" visible="#{admin$selectionlist$listSelectionList.showEditSelectionListValuePanel}">
                                <webuijsf:textField id="textField1" style="left: 624px; top: 288px; position: absolute" text="#{admin$selectionlist$SelectionListSessionBean.actualSelectionListValue.name}"/>
                                <webuijsf:textArea id="textArea1" style="left: 624px; top: 336px; position: absolute" text="#{admin$selectionlist$SelectionListSessionBean.actualSelectionListValue.description}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.saveNewSelectionListValue}"
                                    id="btn_saveSelectionListValue" style="left: 623px; top: 408px; position: absolute" text="#{resources.btnSave}"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.cancelNewSelectionListValue}"
                                    id="brn_cancelEditSelectionListValue" style="left: 743px; top: 408px; position: absolute" text="#{resources.cancel}"/>
                            </webuijsf:panelLayout>
                            <!-- fin de edit SelectionListValue -->
                            <!-- Colecciones Asociadas-->
                            <webuijsf:panelLayout id="collectionsPanel" visible="#{admin$selectionlist$listSelectionList.showCollectionsPanel}">
                                <webuijsf:label id="labelColeccionesAsociadas"
                                    style="font-size: 24px; height: 46px; left: 24px; top: 504px; position: absolute; width: 574px" text="#{resources.associated_collections_subtitle}">
                                    <f:param value="#{admin$selectionlist$SelectionListSessionBean.actualSelectionListValue.name}"/>
                                </webuijsf:label>
                                <!-- add remove -->
                                <webuijsf:addRemove availableItemsLabel="#{resources.availables}" id="associationsBla"
                                    items="#{admin$selectionlist$SelectionListSessionBean.associatedCollections.options}"
                                    selected="#{admin$selectionlist$SelectionListSessionBean.associatedCollections.selectedValue}"
                                    selectedItemsLabel="#{resources.selected}" style="left: 24px; top: 576px; position: absolute"/>
                                <webuijsf:button actionExpression="#{admin$selectionlist$listSelectionList.saveAssociatedCollections}" id="btn_saveAssociations"
                                    style="left: 479px; top: 576px; position: absolute" text="#{resources.btnSave}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
