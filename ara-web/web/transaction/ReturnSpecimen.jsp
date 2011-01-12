<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewTransaction
    Created on : Feb 18, 2010, 4:53:29 PM
    Author     : echinchilla

    NOTA: VERSION DE RESPALDO DE NewTransacion.jsp, NO ES TRANSACTEDSPECIMENS...
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="scriptX" type="text/javascript">

                        /**
                         *
                         * variable del HiddenField que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar esta variable cada vez que la estructura de este JSP varíe.
                         */
                        var btnReturnTransactedSpecimenId = 'contenido:form1:btnReturnTransactedSpecimen';
                        var txReturnTransactedSpecimenId = 'contenido:form1:txReturnTransactedSpecimen';

                        /**
                         *
                         * Función que permite realizar trim() a un string
                         */
                        String.prototype.trim = function () {
                            return this.replace(/^\s*/, "").replace(/\s*$/, "");
                        }

                        /**
                         *
                         * Función que revisa si la tecla oprimida fue ENTER (KeyCode = 13)
                         */
                        function isEnter(e) {
                            var key = e.keyCode;
                            if (key == 13) {
                                var text = new String(document.getElementById(txReturnTransactedSpecimenId).value);
                                text = text.trim()
                                if(text != "")
                                    document.getElementById(btnReturnTransactedSpecimenId).click();
                                else
                                    return false;
                            }
                            return true;
                        }

                        /**
                         *
                         * Función que pone el foco en el textField de CatalogNumber
                         */
                        function setFocusTxReturnTransactedSpecimen() {
                            var textField = document.getElementById(txReturnTransactedSpecimenId);
                            textField.focus();
                        }

                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="setFocusTxReturnTransactedSpecimen();" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.title_return_specimen}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                    <h:panelGrid columns="1" id="pgReturnTransactedSpecimen" style="height: 24px" styleClass="My_panel_blue" width="800">
                                        <h:panelGrid columns="3" id="pgReturnTransactedSpecimen2" style="height: 24px; margin-top: 20px; margin-left: 20px" width="700">
                                            <webuijsf:label for="txReturnTransactedSpecimen" id="lbReturnTransactedSpecimen" style="height: 24px; width: 192px" text="#{resources.catalognumber}"/>
                                            <h:inputText binding="#{transaction$ReturnSpecimen.txReturnTransactedSpecimen}" id="txReturnTransactedSpecimen"
                                                onkeypress="return isEnter(event)" size="25" style="width: 192px"/>
                                            <h:commandButton action="#{transaction$ReturnSpecimen.btnReturnTransactedSpecimen_action}"
                                                id="btnReturnTransactedSpecimen" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.return_specimen}"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="4" id="pgDescription" style="height: 24px; margin-top: 10px; margin-left: 20px" width="700">
                                            <webuijsf:label for="clReceivingDate" id="lbReceivingDate"
                                                style="height: 24px; width: 192px" text="#{resources.receiving_date} *"/>
                                            <webuijsf:calendar columns="22" binding="#{transaction$ReturnSpecimen.clReceivingDate}"
                                                dateFormatPattern="#{resources.date_format}" id="clReceivingDate" style="height: 24px; width: 192px"/>
                                            <webuijsf:label for="ddTransactedSpecimenStatus" id="lbTransactedSpecimenStatus"
                                                style="height: 24px; width: 192px" text="#{resources.transacted_specimen_status} *"/>
                                            <webuijsf:dropDown id="ddTransactedSpecimenStatus" items="#{transaction$ReturnSpecimen.transactedSpecimenStatusData.options}"
                                                selected="#{transaction$TransactionSessionBean.transactedSpecimenStatusId}"
                                                style="height: 24px" width="192px"/>
                                        </h:panelGrid>
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
