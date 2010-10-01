<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewDublinCore
    Created on : 03/09/2010, 11:32:21 AM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head  binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.new_dublin_core}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                <!-- save button -->
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton  id="savemetadata" action="#{dublincore$NewDublinCore.saveDublinCore}"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_metadata}"/>
                                </webuijsf:panelGroup>

                                <h:panelGrid columns="2" >
                                    <webuijsf:label id="labelResourceType" style="width: 168px; height: 24px" text="#{resources.resource_type}"/>
                                    <webuijsf:dropDown id="dropdownResourceType"  width="250px" required="true" items="#{dublincore$NewDublinCore.resourceType.options}"
                                                       selected="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.resourceTypeId}"/>

                                    <webuijsf:label id="labelResourceDescription" style="width: 168px; height: 24px" text="#{resources.resource_description}"/>
                                    <webuijsf:textArea id="resourceTypeDesciption" required="true" columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.resourceTypeDescription}"/>

                                </h:panelGrid>

                                <h:panelGrid columns="4" styleClass="My_panel_blue">

                                    <webuijsf:label id="labelTitle" style="width: 168px; height: 24px" text="#{resources.title}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.title}"/>

                                    <webuijsf:label id="labelCreator" style="width: 168px; height: 24px" text="#{resources.creator}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.creator}"/>

                                    <webuijsf:label id="labelSubject" style="width: 168px; height: 24px" text="#{resources.subject}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.subject}"/>

                                    <webuijsf:label id="labelDescription" style="width: 168px; height: 24px" text="#{resources.description}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.description}"/>

                                    <webuijsf:label id="labelPublisher" style="width: 168px; height: 24px" text="#{resources.publisher}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.publisher}"/>

                                    <webuijsf:label id="labelContributor" style="width: 168px; height: 24px" text="#{resources.contributor}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.contributor}"/>

                                    <webuijsf:label id="labelDate" style="width: 168px; height: 24px" text="#{resources.date}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.date}"/>

                                    <webuijsf:label id="labelType" style="width: 168px; height: 24px" text="#{resources.type}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.type}"/>

                                    <webuijsf:label id="labelFormat" style="width: 168px; height: 24px" text="#{resources.format}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.format}"/>

                                    <webuijsf:label id="labelIdentifier" style="width: 168px; height: 24px" text="#{resources.identifier}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.identifier}"/>

                                    <webuijsf:label id="labelSource" style="width: 168px; height: 24px" text="#{resources.source}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.source}"/>

                                    <webuijsf:label id="labelLanguage" style="width: 168px; height: 24px" text="#{resources.language}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.language}"/>

                                    <webuijsf:label id="labelRelation" style="width: 168px; height: 24px" text="#{resources.relation}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.relation}"/>

                                    <webuijsf:label id="labelCoverage" style="width: 168px; height: 24px" text="#{resources.coverage}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.coverage}"/>

                                    <webuijsf:label id="labelRights" style="width: 168px; height: 24px" text="#{resources.rights}"/>
                                    <webuijsf:textArea columns="27" style="width: 200px;" text="#{dublincore$DublinCoreSessionBean.dublinCoreDTO.rights}"/>

                                </h:panelGrid>
                                

                                

                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
