<%-- 
    Document   : RegisterFrom
    Created on : 26/08/2013, 10:54:53 AM
    Author     : gsulca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <f:view>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styless.css" rel="stylesheet" type="text/css"/>        
        <title>Prueba del ciclo de JSF</title>
    </head>
    <body>
        <h:outputText value="Prueba"/>
        <p/>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="direccion"/>
                <h:inputText id="streetAddress" value="#{form1.streetAddress}" required="true"/>
                
                <h:outputText id="cityPrompt" value="ciudad"/>
                <h:inputText value="#{form1.city}"/>
                
                <h:outputText id="statePrompt" value="estado"/>
                <h:inputText value="#{form1.state}"/>
                
                <h:outputText  value="país"/>
                
                <h:selectOneMenu value="#{form1.country}"
                                 onchange="submit()"
                                 immediate="true"
                                 valueChangeListener="#{form1.countryChanged}">
                    <f:selectItems value = "#{form1.countryNames}"/>
                </h:selectOneMenu>            
            </h:panelGrid>
            <p/>
            <h:commandButton value="proceder"/>
        </h:form>
    </body>
    </f:view>
</html>
