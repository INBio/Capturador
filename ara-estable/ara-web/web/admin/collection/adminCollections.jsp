<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : AdminCollections
    Created on : Mar 16, 2009, 11:14:22 AM
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
                    <!-- Acá inicia el headerr -->
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">

                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                        <!-- Fin del headerr -->
                        <!-- Inicio del Título -->
                        <webuijsf:label id="label1" style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 100%;" text="#{resources.menuModuleAdminCollections}"/>
                        <!-- Fin del Título -->
                        <h:messages errorClass="errorMessage" fatalClass="fatalMessage"
                            id="messageList1" infoClass="infoMessage" style="left: 480px; top: 60px; position: absolute" warnClass="warnMessage"/>
                        <!-- Lista de Collecciones -->
                        <webuijsf:radioButtonGroup id="radioButtonGroup1" style="left: 24px; top: 120px; position: absolute"
                            items="#{admin$collection$AdminCollectionSessionBean.collectionsRadioButtonGroup.options}" required="true"
                            selected="#{admin$collection$AdminCollectionSessionBean.collectionsRadioButtonGroup.selectedValue}"
                            valueChangeListenerExpression="#{admin$collection$adminCollections.radioButtonGroup1_processValueChange}"/>
                        <!-- botones -->
                        <webuijsf:button actionExpression="#{admin$collection$adminCollections.editActualCollection}" id="btn_editCollection"
                            style="left: 287px; top: 120px; position: absolute; width: 96px" text="#{resources.btnEdit}"/>
                        <webuijsf:button actionExpression="#{admin$collection$adminCollections.newCollection}" id="btn_newCollection"
                            style="left: 287px; top: 168px; position: absolute; width: 96px" text="#{resources.btnNew}"/>
                        <webuijsf:button actionExpression="#{admin$collection$adminCollections.deleteCollection}" id="btn_deleteCollection"
                            style="left: 287px; top: 216px; position: absolute; width: 95px" text="#{resources.btnDelete}"/>
                        <!-- fin de lista de colecciones -->
                        <!-- edit Colleccion -->
                        <webuijsf:panelLayout binding="#{admin$collection$adminCollections.editCollectionPanel}" id="editCollectionPanel" 
                            visible="false" >
                            <webuijsf:textField id="textField1" style="left: 528px; top: 96px; position: absolute" text="#{admin$collection$AdminCollectionSessionBean.actualCollection.name}"/>
                            <webuijsf:textArea id="textArea1" style="left: 528px; top: 144px; position: absolute" text="#{admin$collection$AdminCollectionSessionBean.actualCollection.description}"/>
                            <webuijsf:button actionExpression="#{admin$collection$adminCollections.saveCollection}" id="btn_saveCollection"
                                style="left: 527px; top: 216px; position: absolute" text="#{resources.btnSave}"/>
                            <webuijsf:button actionExpression="#{admin$collection$adminCollections.cancelEdtiCollection}" id="btn_cancelEditCollection"
                                style="left: 647px; top: 216px; position: absolute" text="#{resources.cancel}"/>
                        </webuijsf:panelLayout>
                        <!-- fin de edit SelectionListValue -->
                    </webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
