<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditUser
    Created on : 23/09/2009, 05:24:10 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbEditTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.edit_user}"/>
                            <h:panelGrid columns="1" id="gridpGenerationMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglEdit" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{security$EditUser.btnSaveUser_action}" id="btnSaveUser" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="layoutPanelDetail" style="height: 92px; position: relative; width: 403px; -rave-layout: grid">
                                    <webuijsf:label for="txFullName" id="lbFullName"
                                        style="height: 24px; left: 24px; top: 24px; position: absolute; width: 168px" text="#{resources.full_name}"/>
                                    <webuijsf:textField binding="#{security$EditUser.txFullname}" columns="24" id="txFullName" required="true"
                                        style="height: 24px; left: 192px; top: 24px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:label for="txUserName" id="lbUserName"
                                        style="height: 24px; left: 24px; top: 48px; position: absolute; width: 168px" text="#{resources.username}"/>
                                    <webuijsf:textField binding="#{security$EditUser.txUsename}" columns="24" id="txUserName" required="true"
                                        style="height: 24px; left: 192px; top: 48px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                </webuijsf:panelLayout>

                                <webuijsf:tabSet id="tabSetEditUser" lite="true" selected="tabTaxons" style="height: 250px; width: 840px" styleClass="My_tab_border">
                                    <webuijsf:tab id="tabTaxons" text="#{resources.taxons_and_nomenclatural_groups}">
                                        <webuijsf:panelLayout id="layoutPanelTaxons" style="height: 225px; position: relative; width: 100%; -rave-layout: grid">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveT"
                                                style="height: 182px; left: 48px; top: 10px; position: absolute" styleClass="My_table" width="350">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" value="#{security$SystemUserSessionBean.arTaxonsEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{security$SystemUserSessionBean.arTaxonsEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="8" style="width:150px" value="#{security$SystemUserSessionBean.arTaxonsEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{security$SystemUserSessionBean.arTaxonsEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{security$SystemUserSessionBean.arTaxonsEdit.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{security$SystemUserSessionBean.arTaxonsEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{security$SystemUserSessionBean.arTaxonsEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="8" style="width:150px" value="#{security$SystemUserSessionBean.arTaxonsEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{security$SystemUserSessionBean.arTaxonsEdit.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveN"
                                                style="height: 182px; left: 456px; top: 10px; position: absolute" styleClass="My_table" width="350">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitleN" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitleN" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableNomenclaturalOptions" styleClass="My_white_label" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleListN" size="8" style="width:150px" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItemsN" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{security$SystemUserSessionBean.arNomenclaturalsEdit.addSelectedOptions}"
                                                            id="btnAddOptionsN" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{security$SystemUserSessionBean.arNomenclaturalsEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptionsN" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedNomenclaturalOptions" styleClass="My_white_label" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedListN" size="8" style="width:150px" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItemsN" value="#{security$SystemUserSessionBean.arNomenclaturalsEdit.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>

                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
