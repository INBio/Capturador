<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{collectionSelect.page1}" id="page1">
            <webuijsf:html binding="#{collectionSelect.html1}" id="html1">
	<webuijsf:head binding="#{Header_Login.head1}" id="head1">
		<webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
		<webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
	</webuijsf:head>
                <webuijsf:body binding="#{collectionSelect.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header_Login.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{collectionSelect.form1}" id="form1">
                            <webuijsf:label binding="#{collectionSelect.lb_title1}" id="lb_title1"
                                style="font-size: 18px; height: 22px; left: 48px; top: 24px; position: absolute; width: 646px" text="#{resources.select_taxon_or_group}"/>
                            <h:messages binding="#{collectionSelect.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 600px; top: 96px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:listbox binding="#{collectionSelect.lb_taxon}" id="lb_taxon" items="#{collectionSelect.taxonOptions}"
                                onClick="var tForm = document.forms[0];&#xa;var tElement = tForm.elements[1];&#xa;tElement.selectedIndex=-1;"
                                selected="#{collectionSelect.selectedTaxon}" style="left: 48px; top: 96px; position: absolute; width: 192px" valueChangeListenerExpression="#{collectionSelect.lb_taxon_processValueChange}"/>
                            <webuijsf:listbox binding="#{collectionSelect.lb_group}" id="lb_group" items="#{collectionSelect.groupOptions}"
                                onClick="var tForm = document.forms[0];&#xa;var tElement = tForm.elements[0];&#xa;tElement.selectedIndex=-1;"
                                selected="#{collectionSelect.selectedGroup}" style="left: 312px; top: 96px; position: absolute; width: 192px" valueChangeListenerExpression="#{collectionSelect.lb_group_processValueChange}"/>
                            <webuijsf:staticText binding="#{collectionSelect.staticText1}" id="staticText1"
                                style="font-weight: bold; left: 48px; top: 72px; position: absolute" text="#{resources.available_taxons}"/>
                            <webuijsf:staticText binding="#{collectionSelect.staticText2}" id="staticText2"
                                style="font-weight: bold; left: 312px; top: 72px; position: absolute" text="#{resources.available_groups}"/>
                            <webuijsf:button actionExpression="#{collectionSelect.btn_continue_action}" binding="#{collectionSelect.btn_continue}"
                                id="btn_continue" style="height: 24px; left: 239px; top: 312px; position: absolute; width: 71px" text="#{resources.continue}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
