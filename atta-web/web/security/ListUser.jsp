<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListUser
    Created on : 23/09/2009, 04:03:15 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="scriptX" type="text/javascript">
                        /**
                         *
                         * variable del HiddenField que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar esta variable cada vez que la estructura de este JSP varíe.
                         */
                        var deleteConfirmationTextId = 'contenido:form1:grouppButtons:panelPaginacion:deleteConfirmationText';

                        /**
                         *
                         * Función que pide confirmación de borrado al usuario
                         */
                        function deleteConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationTextId).value;
                            return confirm(confirmationText);
                        }
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbSpecimenUserTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                    styleClass="Page_title" value="#{resources.menuModuleUsers}"/>
                                <h:panelGrid columns="1" id="gridpUserMain" style="height: 24px; left: 24px; position: relative" width="720">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglUser" infoClass="infoMessage"
                                        style="height: 30px; width: 700px" warnClass="warnMessage"/>
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="743">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="743">
                                                <h:outputLabel id="labelQuantity" value="#{security$ListUser.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{security$ListUser.btnUserNew}" id="btn_new" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.new}"/>
                                                <h:commandButton action="#{security$ListUser.btnUserEdit}" id="btn_edit" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton onclick="return deleteConfirmation();" action="#{security$ListUser.btnUserDelete}" id="btn_delete" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                <h:inputHidden binding="#{security$ListUser.deleteConfirmationText}" id="deleteConfirmationText"/>
                                                <h:commandButton action="#{security$ListUser.btnUserChangePassword}" id="btn_change_pass"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.menuModuleChangePassword}"/>
                                                <!-- Botones de la paginacion -->
                                                <h:commandButton action="#{security$SystemUserSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{security$SystemUserSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{security$SystemUserSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{security$SystemUserSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{security$SystemUserSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{security$SystemUserSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{security$SystemUserSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{security$SystemUserSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{security$ListUser.dataTableUser}" cellspacing="0" columnClasses="list-columns"
                                            headerClass="list-header" id="dataTablegathering" rowClasses="list-row-even,list-row-odd"
                                            rows="#{security$SystemUserSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{security$SystemUserSessionBean.pagination.dataProvider.list}" var="currentRow" width="743">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.username}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['username']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.full_name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['fullname']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
