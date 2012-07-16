<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PreviewSpecies
    Created on : 02/11/2009, 04:04:32 PM
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
                    <webuijsf:script type="text/javascript" url="/resources/tinymce/jscripts/tiny_mce/tiny_mce.js"/>
                    <webuijsf:script type="text/javascript">
                        tinyMCE.init({
                        mode : "textareas",
                        theme : "advanced",
                        plugins : "table",
                        // Theme options
                        theme_advanced_buttons1 : "",
                        theme_advanced_buttons2 : "",
                        theme_advanced_buttons3 : "",
                        theme_advanced_buttons4 : "",
                        theme_advanced_toolbar_location : "top",
                        theme_advanced_toolbar_align : "center"
                        });
                        </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{taxonomy$SpeciesSessionBean.currentTaxDescripDTO.taxonDefaultName}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 360px;width: 100%; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                    <h:panelGrid cellspacing="20" columns="1" id="gridPanelPreview" style="height: 336px; text-align: left;width: 100%; padding:0px 24px 0px 24px;" width="792">
                                        <h:inputTextarea binding="#{taxonomy$PreviewSpecies.abstractText}" style="width: 100%;"  id="abstractText"/>
                                        <webuijsf:label binding="#{taxonomy$PreviewSpecies.descriptionsLabel}" id="descriptionsLabel" labelLevel="1"
                                            style="height: 22px; width: 118px" text="#{resources.descriptions}"/>
                                        <h:panelGrid binding="#{taxonomy$PreviewSpecies.descriptionsDynamicPanel}" id="descriptionsDynamicPanel"
                                            style="width: 100%"/>
                                        <webuijsf:label binding="#{taxonomy$PreviewSpecies.audiencesLabel}" id="audiencesLabel" labelLevel="1"
                                            style="height: 22px; width: 118px" text="#{resources.audience}"/>
                                        <h:panelGrid binding="#{taxonomy$PreviewSpecies.audiencesDynamicPanel}" id="audiencesDynamicPanel" style="width: 100%;"/>
                                        <webuijsf:label binding="#{taxonomy$PreviewSpecies.authorsLabel}" id="authorsLabel" labelLevel="1"
                                            style="height: 22px; width: 118px" text="#{resources.authors}"/>
                                        <h:panelGrid binding="#{taxonomy$PreviewSpecies.authorDynamicPanel}" id="authorDynamicPanel" style="width: 100%;"/>
                                        <webuijsf:label binding="#{taxonomy$PreviewSpecies.institutionsLabel}" id="institutionsLabel" labelLevel="1"
                                            style="height: 22px; width: 118px" text="#{resources.institutions}"/>
                                        <h:panelGrid binding="#{taxonomy$PreviewSpecies.institutionsDynamicPanel}" id="institutionsDynamicPanel"
                                            style="width: 100%;"/>
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
