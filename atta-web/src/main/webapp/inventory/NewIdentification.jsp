<?xml version="1.0" encoding="UTF-8"?>
<!--
	Document   : ListIdentification
	Created on : 13/12/2012, 2:38:00 PM
	Author     : gsulca
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:script id="scriptX" type="text/javascript">
                        /**
                         *
                         * variables globales para accesar el textField de CatalogNumber que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar estas variables cada vez que la estructura de este JSP varíe.
                         */

                        var tfBarcode = 'contenido:form1:tfBarcode';
                        var btnAddBarcode = 'contenido:form1:btnAddBarcode';
                        var deleteConfirmationText = 'contenido:form1:deleteConfirmationText';
                        

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
                                var text = new String(document.getElementById(tfBarcode).value);
                                text = text.trim()
                                if(text != "")
                                    document.getElementById(btnAddBarcode).click();
                                else
                                    return false;
                            }
                            return true;
                        }

                        /**
                         *
                         * Función que pone el foco en el textField de CatalogNumber
                         */
                        function setFocusTfBarcode() {
                            var textField = document.getElementById(tfBarcode);
                            textField.focus();
                        }


                        /**
                         * Muestra un cuadro de dialogo para confirmación de eliminación
                         */
                         function deleteConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationText).value;
                            return confirm(confirmationText);
                        }

            </webuijsf:script>
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>

                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="setFocusTfBarcode();" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbIdentificationTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                    styleClass="Page_title" value="#{resources.titleIdentificationList}"/>
                                                               
                                    <h:panelGrid binding="#{inventory$NewIdentification.gridpReIdentify}" columns="1" id="gridpReidentify"
                                        style="height: 5px" styleClass="My_panel_blue" width="100%">
                                        <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListIdentification" infoClass="infoMessage"
                                        style="height: 24px; width: 574px" warnClass="warnMessage"/>
                                        <h:panelGrid columns="3" id="gridpReidentifyForm" style="height: 24px" width="100%">
                                            <!-- Column 1 -->
                                            <h:panelGrid cellspacing="1" columns="1" style="height: 24px" >

                                                <!-- Type -->
                                                <h:panelGrid cellspacing="1" columns="2" id="gridpIdentificationType">
                                                    <webuijsf:label for="ddTypeNameReidentify" id="lbTaxonReidentify" text="#{resources.type}"/>
                                                    <webuijsf:dropDown binding="#{inventory$NewIdentification.ddType}" id="ddTypeNameReidentify"
                                                                       items="#{inventory$NewIdentification.ddTypeData.options}"
                                                                       selected="#{inventory$NewIdentification.ddTypeSelected}"
                                                                       width="200px"/>
                                                </h:panelGrid>

                                                <!-- Taxonomical level -->
                                                <webuijsf:panelGroup id="grouppTaxaLevel" style="height: 24px; width: 384px">
                                                    <webuijsf:label for="ddTaxonomicLevel" id="lbTaxonomicLevel" text="#{resources.taxonomic_level}"/>
                                                    <webuijsf:dropDown binding="#{inventory$NewIdentification.ddTaxonomicalRange}"
                                                                                                  id="ddTaxonomicalRange"
                                                        items="#{inventory$NewIdentification.ddTaxonomicalRangeData.options}"
                                                        selected="#{inventory$NewIdentification.ddTaxonomicalRangeSelected}"
                                                                                                    actionExpression="#{inventory$NewIdentification.updateTaxonListAction}"
                                                                                                    submitForm="true"
                                                                                                    width="154px"/>
                                                </webuijsf:panelGroup>
                                            
                                                <!-- AddRemove Component (Taxon list) -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" style="height: 24px" styleClass="My_table">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArTitle" value="#{inventory$IdentificationSessionBean.arTaxonList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arTaxonList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arTaxonList.leftSelected}" >
                                                                <f:selectItems id="mlAvailableSelectItems" value="#{inventory$IdentificationSessionBean.arTaxonList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arTaxonList.addSelectedOptions}"
                                                            id="btnAddOptions"
                                                                             style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arTaxonList.removeSelectedOptions}"
                                                            id="btnRemoveOptions"
                                                                             style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arTaxonList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arTaxonList.rightSelected}">
                                                                <f:selectItems id="mlSelectedSelectItems" value="#{inventory$IdentificationSessionBean.arTaxonList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>


                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component (Taxon list)-->
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" style="height: 24px" >
                                                <!-- Validator -->
                                                <h:panelGrid cellspacing="1" columns="2" id="gridpValidator">
                                                    <webuijsf:label for="ddValidatorReidentify" id="lbValidatorReidentify" text="#{resources.validator}"/>
                                                    <webuijsf:dropDown id="ddValidatorReidentify"  binding="#{inventory$NewIdentification.ddValidatorsData}"
                                                                       items="#{inventory$NewIdentification.validatorsData.options}"
                                                                       selected="#{inventory$NewIdentification.ddValidatorSelected}"
                                                                       width="200px"/>
                                                </h:panelGrid>
                                                <!-- Status -->
                                                <h:panelGrid  cellspacing="1" columns="2" id="gridpStatus">
                                                    <webuijsf:label for="ddStatusNameReidentify" id="lbStatusNameReidentify" 
                                                                    requiredIndicator="true" text="#{resources.status}"
                                                                    />
                                                    <webuijsf:dropDown binding="#{inventory$NewIdentification.ddStatus}" id="ddStatusNameReidentify"
                                                                       items="#{inventory$NewIdentification.ddStatusData.options}"
                                                                       selected="#{inventory$NewIdentification.ddStatusSelected}"
                                                                       required="true"
                                                                       width="200px"/>
                                                </h:panelGrid>
                                                <!-- AddRemove Component (Identificador) -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveIdentifier" style="height: 24px" styleClass="My_table">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArIdentifierTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArIdentifierTitle" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableIdentifierOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleIdentifierList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arIdentifierList.leftSelected}">
                                                                                                                    <f:selectItems id="mlAvailableIdentifierSelectItems" value="#{inventory$IdentificationSessionBean.arIdentifierList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arIdentifierList.addSelectedOptions}"
                                                                id="btnAddIdentifierOptions"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arIdentifierList.removeSelectedOptions}"
                                                                                                                                                 id="btnRemoveIdentifierOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedIdentifierOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedIdentifierList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arIdentifierList.rightSelected}">
                                                               <f:selectItems id="mlSelectedIdentifierSelectItems" value="#{inventory$IdentificationSessionBean.arIdentifierList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component (Identificador)-->
                                                </h:panelGrid>
                                                <!-- Agrupados por códigos de barras -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpBarcodeList" style="height: 24px" >
                                                    <webuijsf:label for="tfBarcode" text="#{resources.barCode}" />
                                                    <h:inputText id="tfBarcode" onkeypress="return isEnter(event)" value="#{inventory$IdentificationSessionBean.specimenBarcode}" />

                                                    <h:commandButton id="btnAddBarcode"
                                                                  style="width: 160px"
                                                                  styleClass="My_Button"
                                                                  value="#{resources.add}"
                                                                  action="#{inventory$NewIdentification.btnAddBarcodeAction}"  />
                                                    <h:commandButton id="btnDelBarcode"
                                                                  style="width: 160px"
                                                                  styleClass="My_Button"
                                                                  value="#{resources.delete}"
                                                                  action="#{inventory$NewIdentification.btnDeleteBarcodeAction}"  />
                                                    <h:commandButton id="btnDelAllBarcode"
                                                                  style="width: 160px"
                                                                  styleClass="My_Button"
                                                                  value="#{resources.delete_all}"
                                                                  action="#{inventory$NewIdentification.btnDeleteAllBarcodeAction}"  />

                                                    <webuijsf:label for="mlSelectedBarcodeList" text="#{resources.barCodeList}"/>

                                                    <h:selectManyListbox id="mlSelectedBarcodeList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.specimenBarcodeSelected}" >
                                                     <f:selectItems id="mlSelectedBarcodeListItems" value ="#{inventory$IdentificationSessionBean.specimenBarcodeList}"/>
                                                    </h:selectManyListbox>
                                                </h:panelGrid>
                                                <!-- Proceed button -->
                                                <h:commandButton action="#{inventory$NewIdentification.btnProceedReIdentifyAction}" id="btnAdvSearchGO2"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"  onclick="return deleteConfirmation();"  />
                                            </h:panelGrid>
                                        <h:inputHidden id="deleteConfirmationText" binding="#{inventory$NewIdentification.deleteConfirmationText}"/>
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
