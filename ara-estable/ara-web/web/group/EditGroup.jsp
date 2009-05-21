<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{group$EditGroup.page1}" id="page1">
            <webuijsf:html binding="#{group$EditGroup.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{group$EditGroup.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{group$EditGroup.form1}" id="form1">
                            <webuijsf:staticText binding="#{group$EditGroup.staticText1}" id="staticText1"
                                style="color: rgb(0, 51, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.edit_group}"/>
                            <webuijsf:staticText binding="#{group$EditGroup.staticText2}" id="staticText2"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-style: normal; font-weight: bold; left: 48px; top: 72px; position: absolute; width: 94px" text="#{resources.name}"/>
                            <webuijsf:staticText binding="#{group$EditGroup.staticText3}" id="staticText3"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-style: normal; font-weight: bold; left: 48px; top: 120px; position: absolute; width: 94px" text="#{resources.description}"/>
                            <webuijsf:textField binding="#{group$EditGroup.userName1}" id="userName1"
                                style="left: 168px; top: 72px; position: absolute; width: 176px" tabIndex="0"/>
                            <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" binding="#{group$EditGroup.addRemoveList1}"
                             id="addRemoveList1" items="#{group$EditGroup.userOptionList}" moveButtons="true"
                                selectAll="true" selected="#{group$EditGroup.selectedOptions}" selectedItemsLabel="#{resources.selected}:"
                                style="left: 48px; top: 168px; position: absolute" valueChangeListenerExpression="#{group$EditGroup.addRemoveList1_processValueChange}"/>
                            <webuijsf:button actionExpression="#{group$EditGroup.save_action}" binding="#{group$EditGroup.save1}" id="save1"
                                style="height: 24px; left: 95px; top: 408px; position: absolute; width: 70px" tabIndex="3" text="#{resources.btnSave}"/>
                            <webuijsf:textField binding="#{group$EditGroup.fullName1}" id="fullName1"
                                style="left: 168px; top: 120px; position: absolute; width: 176px" tabIndex="1"/>
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage"
                                style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
