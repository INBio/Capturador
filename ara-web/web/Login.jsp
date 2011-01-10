<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MyLogin
    Created on : 22/09/2009, 02:13:19 PM
    Author     : esmata
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">                
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header_Login.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage" warnClass="warnMessage"/>
                            <table align="center" style="padding-top: 50px;" width="60%">
                                <tbody>
                                    <tr>
                                        <td align="center">
                                            <h:outputLabel id="lb_title" styleClass="Page_title" value="#{resources.enter_system}"/>
                                            <webuijsf:form id="form1" style="border-style: solid; border-color: rgb(216, 241, 139); text-align: center; vertical-align: middle; width: 258px">
                                                <h:panelGrid columns="1" id="gridPanel1" width="261">
                                                    <webuijsf:label id="label1" text="#{resources.username}"/>
                                                    <webuijsf:textField binding="#{Login.user}" id="txt_userName" label="" maxLength="20" required="true"/>
                                                    <webuijsf:label id="label2" text="#{resources.password}"/>
                                                    <webuijsf:passwordField binding="#{Login.password}" id="txt_password" label="" required="true"/>
                                                    <h:commandButton action="#{Login.btn_login_action}" id="btn_login" style="" styleClass="My_Button_Login" value="#{resources.btnEnter}"/>
                                                </h:panelGrid>
                                            </webuijsf:form>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <img alt="inb-iabin" height="82" src="resources/images/inb-iabin.gif" width="350"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>                            
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                     </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
