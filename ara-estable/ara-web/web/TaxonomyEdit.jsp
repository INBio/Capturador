<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{TaxonomyEdit.page1}" id="page1">
			<webuijsf:html binding="#{TaxonomyEdit.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{TaxonomyEdit.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{TaxonomyEdit.form1}" id="form1">
							<webuijsf:tree binding="#{TaxonomyEdit.displayTree}" clientSide="true" id="displayTree" immediate="true"
                                style="height: 118px; left: 48px; top: 72px; position: absolute; visibility: visible; width: 502px" text="#{resources.taxonomy}"/>
                            <webuijsf:button actionExpression="#{TaxonomyEdit.button1_action}" binding="#{TaxonomyEdit.button1}" disabled="true" id="button1"
                                style="height: 20px; left: 767px; top: 72px; position: absolute; visibility: visible; width: 120px" text="#{resources.btnNew}"/>
                            <webuijsf:textField binding="#{TaxonomyEdit.textField1}" id="textField1" style="left: 600px; top: 72px; position: absolute"/>
                            <!-- items="#{ admin$selectionlist$SelectionListSessionBean.selectionListDropDownData.options}" -->
                            <!-- selected="#{admin$selectionlist$SelectionListSessionBean.selectionListDropDownData.selectedValue}" -->
                            <webuijsf:dropDown id="collectionsListDropDown" binding="#{TaxonomyEdit.collectionsListDropDown}" disabled="true"
                                items="#{TaxonomyEdit.collectionsListDropDownData.options}" selected="#{TaxonomyEdit.collectionsListDropDownData.selectedValue}"
                                style="left: 600px; top: 96px; position: absolute"/>
                            <webuijsf:button actionExpression="#{TaxonomyEdit.button2_action}" binding="#{TaxonomyEdit.button2}" disabled="true" id="button2"
                                style="height: 20px; left: 767px; top: 96px; position: absolute; width: 120px" text="#{resources.btnDelete}"/>
							<webuijsf:label binding="#{TaxonomyEdit.label1}" id="label1"
                                style="font-size: 18px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.taxonomy_module}"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
