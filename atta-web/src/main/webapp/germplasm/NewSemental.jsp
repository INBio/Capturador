<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewSemental
    Created on : 08/04/2010, 09:47:34 AM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.new_semental}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                    <!-- save button -->
                                    <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                        <h:commandButton  id="saveSementalButton"
                                                          action="#{germplasm$NewSemental.saveSemental}"
                                            style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_semental}"/>
                                    </webuijsf:panelGroup>
                                    <h:panelGrid id="content" columns="2" style="position:absoulte">
                                        <webuijsf:label id="labelName" style="width: 168px; height: 24px" text="#{resources.name}"/>
                                        <webuijsf:textField columns="27" id="textFieldName" style="width: 200px;"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.name}"/>

                                        <webuijsf:label id="labelAnimalCode" style="width: 168px; height: 24px" text="#{resources.animal_code}"/>
                                        <webuijsf:textField columns="27"  id="textFieldAnimalCode" style="width: 200px;"
                                                            required="true"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.animalCode}"/>

                                        <webuijsf:label id="labelBreed" style="width: 168px; height: 24px" text="#{resources.breed}"/>
                                        <webuijsf:dropDown id="dropdownBreed"  width="200px" required="true"
                                                           items="#{germplasm$NewSemental.breeds.options}"
                                                           selected="#{germplasm$SementalSessionBean.sementalDTO.breedId}"/>

                                        <webuijsf:label id="labelBirthDate" style="width: 168px; height: 24px" text="#{resources.birth_date}"/>
                                        <webuijsf:calendar  binding="#{germplasm$NewSemental.birthDate}"
                                            id="calendarBirthDate" style="width: 200px"/>

                                        <webuijsf:label id="labelColor" style="width: 168px; height: 24px" text="#{resources.color}"/>
                                        <webuijsf:textField columns="27"  id="textFieldColor" style="width: 200px;"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.color}"/>

                                        <webuijsf:label id="labelSiteId" style="width: 168px; height: 24px" text="#{resources.place_of_origin}"/>
                                        <webuijsf:dropDown id="dropdownSiteId"  width="200px"
                                                           items="#{germplasm$NewSemental.localities.options}"
                                                           selected="#{germplasm$SementalSessionBean.sementalDTO.siteId}"/>

                                        <webuijsf:label id="labelVeterinarianStatus" style="width: 168px; height: 24px" text="#{resources.veterinarian_status}"/>
                                        <webuijsf:textField columns="27" id="textFieldVeterinarianStatus" style="width: 200px;"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.veterinarianStatus}"/>

                                        <webuijsf:label id="labelConditionId" style="width: 168px; height: 24px" text="#{resources.condition}"/>
                                        <webuijsf:dropDown id="dropdownConditionId"  width="200px"
                                                           items="#{germplasm$NewSemental.condition.options}"
                                                           selected="#{germplasm$SementalSessionBean.sementalDTO.conditionId}"/>

                                        <webuijsf:label id="labelAnimalDescription" style="width: 168px; height: 24px" text="#{resources.animal_description}"/>
                                        <webuijsf:textArea columns="24" id="textFieldAnimalDescription" style="width: 200px;"
                                                           text="#{germplasm$SementalSessionBean.sementalDTO.animalDescription}"/>

                                        <webuijsf:label id="labelFather" style="width: 168px; height: 24px" text="#{resources.father}"/>
                                        <webuijsf:textField columns="27" id="textFieldFather" style="width: 200px;"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.father}"/>

                                        <webuijsf:label id="labelMother" style="width: 168px; height: 24px" text="#{resources.mother}"/>
                                        <webuijsf:textField columns="27" id="textFieldMother" style="width: 200px;"
                                                            text="#{germplasm$SementalSessionBean.sementalDTO.mother}"/>
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


