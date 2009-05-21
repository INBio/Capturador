<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$Preview.page1}" id="page1">
            <webuijsf:html binding="#{species$Preview.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$Preview.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{species$Preview.form1}" id="form1">
                            <webuijsf:staticText binding="#{species$Preview.defaultName}" id="defaultName"
                                style="font-size: 18px; font-style: normal; font-weight: bolder; height: 24px; left: 48px; top: 24px; position: absolute; width: 646px" text="#{species$SpeciesSessionBean.currentTaxon.defaultName}"/>
                            <webuijsf:panelLayout binding="#{species$Preview.layoutPanel1}" id="layoutPanel1" panelLayout="flow" style="height: 572px; left: 48px; top: 72px; position: absolute; text-align: center; width: 862px">
                                <h:panelGrid binding="#{species$Preview.gridPanel1}" cellspacing="25" columns="1" id="gridPanel1"
                                    style="height: 527px; text-align: left" width="792">
                                    <webuijsf:staticText binding="#{species$Preview.abstractText}" id="abstractText" style="font-size: 12px; font-style: italic"/>
                                    <webuijsf:label binding="#{species$Preview.descriptionsLabel}" id="descriptionsLabel" labelLevel="1"
                                        style="height: 22px; width: 118px" text="#{resources.descriptions}"/>
                                    <h:panelGrid binding="#{species$Preview.descriptionsDynamicPanel}" id="descriptionsDynamicPanel" style="height: 31px" width="791"/>
                                    <webuijsf:label binding="#{species$Preview.audiencesLabel}" id="audiencesLabel" labelLevel="1"
                                        style="height: 22px; width: 118px" text="#{resources.audience}"/>
                                    <h:panelGrid binding="#{species$Preview.audiencesDynamicPanel}" id="audiencesDynamicPanel" style="height: 42px" width="791"/>
                                    <webuijsf:label binding="#{species$Preview.authorsLabel}" id="authorsLabel" labelLevel="1"
                                        style="height: 22px; width: 118px" text="#{resources.authors}"/>
                                    <h:panelGrid binding="#{species$Preview.authorDynamicPanel}" id="authorDynamicPanel" style="height: 37px" width="791"/>
                                    <webuijsf:label binding="#{species$Preview.institutionsLabel}" id="institutionsLabel" labelLevel="1"
                                        style="height: 22px; width: 118px" text="#{resources.institutions}"/>
                                    <h:panelGrid binding="#{species$Preview.institutionsDynamicPanel}" id="institutionsDynamicPanel" style="height: 49px" width="791"/>
                                </h:panelGrid>
                                <webuijsf:hyperlink binding="#{species$Preview.hyperlink1}" id="hyperlink1" onClick="javascript:history.back(1)"
                                    style="text-align: center" text="#{resources.back}" type="text/html" url="javascript:history.back(1)"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
