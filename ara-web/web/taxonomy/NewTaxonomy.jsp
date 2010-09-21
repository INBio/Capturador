<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewTaxonomy
    Created on : 21/07/2010, 06:19:12 PM
    Author     : gsulca
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <!--
    <jsp:directive.page import="org.inbio.ara.taxonomy.TaxonTreeController"/>
    -->
    <jsp:directive.page import="org.inbio.ara.indicator.TreeController"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link3" url="http://yui.yahooapis.com/2.8.0r4/build/fonts/fonts-min.css"/>
                    <webuijsf:link id="link4" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/assets/skins/sam/treeview.css"/>
                    <webuijsf:script id="script2" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/yahoo-dom-event/yahoo-dom-event.js"/>
                    <webuijsf:script id="script3" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/treeview-min.js"/>
                    <webuijsf:script id="script7" type="text/JavaScript" url="/resources/js/inbio/Tree/TreeIndicatorEvent.js"/>
                    <webuijsf:script id="script5" type="text/JavaScript" url="/resources/js/inbio/SOAP/SOAPClient.js"/>
                    <webuijsf:script id="script8" type="text/JavaScript" url="/resources/js/inbio/Tree/ClickIndicatorEvent.js"/>
                    <jsp:scriptlet>
                        TreeController treeController = new TreeController();
                        String treeScript = treeController.getTreeScript();
                        out.write(treeScript);
                    </jsp:scriptlet>
                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="initIndicators()" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_taxon_new}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="1" id="grouppBotoneraIndicator" style="height: 24px" width="540">
                                    <h:commandButton action="#{taxonomy$NewTaxonomy.btnSaveTaxon_action}" id="btnSaveTaxon" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.btnSave}"/>
                                    <webuijsf:label for="txFatherName" id="lbFatherName" text="#{taxonomy$TaxonSessionBean.taxonNodeName}"/>
                                </h:panelGrid>
                                <webuijsf:tabSet id="tabSet1" binding="#{taxonomy$NewTaxonomy.taxonTabs}" lite="true" selected="#{taxonomy$TaxonSessionBean.taxonTabSelected}" styleClass="My_panel_blue">
                                    <!-- Tab para ingresar los datos de los taxones -->
                                    <webuijsf:tab id="tabNewTaxonomy" text="#{resources.dataTaxon}">
                                        <h:panelGrid binding="#{taxonomy$NewTaxonomy.gridTaxonomy}" columns="2" id="gridTaxonomy" style="height: 24px" width="540">
                                            <h:panelGrid binding="#{taxonomy$NewTaxonomy.taxonomy}" columns="1" id="indicator">
                                                <h:panelGrid columns="2" id="rangePanel" style="position: relative; -rave-layout: grid">
                                                    <webuijsf:label for="txRange" id="lbRange" text="#{resources.range}"/>
                                                    <h:selectOneMenu id="ddRange" value="#{taxonomy$TaxonSessionBean.taxonomicalRangeSelected}">
                                                        <f:selectItems id="dropdown1SelectItems" value="#{taxonomy$NewTaxonomy.ddRangeItems}"/>
                                                    </h:selectOneMenu>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" id="nomenclatural"
                                                    style="height: 124px; position: relative; width: 400px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                                    <webuijsf:label for="txTaxonName" id="lbTaxonName" text="#{resources.taxon_name}"/>
                                                    <webuijsf:textField columns="25" id="txTaxonName" required="true" text="#{taxonomy$TaxonSessionBean.taxonName}"/>
                                                    <webuijsf:label for="txBasionymName" id="lbBasionymName" text="#{resources.basionym_Name}"/>
                                                    <webuijsf:textField columns="25" id="txBasionymName" text="#{taxonomy$TaxonSessionBean.basionymName}"/>
                                                    <webuijsf:label for="txCategory" id="lbCategory" text="#{resources.category}"/>
                                                    <h:selectOneMenu id="ddCategory" value="#{taxonomy$TaxonSessionBean.taxonomicalCategorySelected}">
                                                        <f:selectItems id="dropdown2SelectItems" value="#{taxonomy$NewTaxonomy.ddCategoryItems}"/>
                                                    </h:selectOneMenu>
                                                    <h:panelGrid columns="2" id="selectionPanel" style="position: relative; -rave-layout: grid">
                                                        <h:selectBooleanCheckbox id="checkParentheses" value="#{taxonomy$TaxonSessionBean.checkedParentheses}"/>
                                                        <webuijsf:label for="checkParentheses" id="lbParentheses" text="#{resources.author_parentheses}"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <h:panelGrid columns="4" id="description" style="position: relative; width: 400px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                                    <webuijsf:label for="ddMonth" id="lbMonth" text="#{resources.month}"/>
                                                    <h:selectOneMenu id="ddMonth" value="#{taxonomy$TaxonSessionBean.monthSelected}">
                                                        <f:selectItems id="dropdown3SelectItems" value="#{taxonomy$NewTaxonomy.ddMonthItems}"/>
                                                    </h:selectOneMenu>
                                                    <webuijsf:label for="txYear" id="lbYear" text="#{resources.year}"/>
                                                    <webuijsf:textField columns="25" id="txYear" text="#{taxonomy$TaxonSessionBean.year}"/>
                                                </h:panelGrid>
                                            </h:panelGrid>

                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <!-- Tab para relación entre taxon - indicador -->
                                    <webuijsf:tab id="tabTaxonIndicatorReferences" rendered="true" text="#{resources.relations_taxon_indicator}">
                                        <h:panelGrid columns="3" id="taxonIndicator">
                                            <div id="tree" style="width:200px; float:left; " title="Taxonomy Tree "></div>
                                            <h:panelGrid columns="1" id="panelAddRemoveAction">
                                                <h:commandButton id="btnAddElement"  action="#{taxonomy$NewTaxonomy.btnAddTaxonIndicator_action}" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.add}"/>
                                                <h:commandButton id="btnRemoveElement" action="#{taxonomy$NewTaxonomy.btnRemoveTaxonIndicator_action}" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.remove}"/>
                                            </h:panelGrid>
                                            <webuijsf:listbox id="listbox1" items="#{taxonomy$NewTaxonomy.indicatorRelations}" selected="#{taxonomy$TaxonSessionBean.elementSelected}" />
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabTaxonIndicatorCountry" rendered="true" text="#{resources.taxon_indicator_country}">
                                        <h:panelGrid columns="1" id="gridTaxonIndicatorCountries" style="height: 24px" width="580">
                                            <h:panelGrid columns="2" id="gridCountries" style="height: 24px">
                                                <webuijsf:panelGroup id="groupAttributes" style="height: 24px">
                                                    <webuijsf:label for="ddIndicators" id="lbIndicators" text="#{resources.relations_taxon_indicator}"/>
                                                    <webuijsf:dropDown binding="#{taxonomy$NewTaxonomy.ddIndicators}"  id="ddIndicators"
                                                        items="#{taxonomy$TaxonSessionBean.indicatorRelations}"
                                                        selected="#{taxonomy$TaxonSessionBean.ddIndicatorSelected}"/>

                                                </webuijsf:panelGroup>
                                                <h:commandButton action="#{taxonomy$NewTaxonomy.btnAssociateCountries_action}" id="btnAssociateCountries"
                                                                 style="width: 160px" styleClass="My_Button" value="#{resources.button_associate}"/>
                                           </h:panelGrid>
                                        <!-- AddRemove Component -->
                                        <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" style="height: 24px" styleClass="My_table">
                                            <!-- Title -->
                                            <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                <h:outputLabel id="lbArTitle" value="#{taxonomy$TaxonSessionBean.arContries.lbTitle}"/>
                                            </h:panelGrid>
                                            <!-- Add Remove body -->
                                            <h:panelGrid cellspacing="1" columns="3">
                                                <!-- Available List -->
                                                <h:panelGrid cellspacing="1" columns="1">
																									
                                                    <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$TaxonSessionBean.arContries.lbAvailable}"/>
                                                    <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px" value="#{taxonomy$TaxonSessionBean.arContries.leftSelected}" >															
                                                        <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$TaxonSessionBean.arContries.leftOptions}"/>
                                                    </h:selectManyListbox>
                                                </h:panelGrid>
                                                <!-- Buttons Panel -->
                                                <h:panelGrid cellspacing="1" columns="1">
                                                    <!-- boton Agregar -->
                                                    <h:commandButton action="#{taxonomy$TaxonSessionBean.arContries.addSelectedOptions}"
                                                    id="btnAddOptions"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                    <!-- boton Remover -->
                                                    <h:commandButton action="#{taxonomy$TaxonSessionBean.arContries.removeSelectedOptions}"
                                                    id="btnRemoveOptions"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                </h:panelGrid>
                                                <!-- Selected List -->
                                                <h:panelGrid cellspacing="1" columns="1">
                                                    <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$TaxonSessionBean.arContries.lbSelected}"/>
                                                    <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px" value="#{taxonomy$TaxonSessionBean.arContries.rightSelected}">																				
                                                        <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$TaxonSessionBean.arContries.rightOptions}"/>
                                                    </h:selectManyListbox>
                                                </h:panelGrid>



                                            </h:panelGrid>
                                        </h:panelGrid>
                                        <!-- End AddRemove Component -->
                                       
                                    </h:panelGrid>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <!-- Elementos Hidden para compartir entre jsp y javascript la información del nodo seleccionado en el árbol -->
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenTaxonNodeId}" id="hiddenTaxonNodeId"/>
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenPathTaxonNode}" id="hiddenPathTaxonNode"/>
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenCollecNomenclGroupId}" id="hiddenCollecNomenclGroupId"/>
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenTypeGroup}" id="hiddenTypeGroup"/>
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenNodeId}" id="hiddenNodeId"/>
                                <h:inputHidden binding="#{taxonomy$NewTaxonomy.hiddenPathNode}" id="hiddenPathNode"/>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
