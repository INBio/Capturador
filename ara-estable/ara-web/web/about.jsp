<?xml version="1.0" encoding="UTF-8"?>
<!-- 
	Document   : about
	Created on : Mar 20, 2009, 2:23:50 PM
	Author     : jgutierrez
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page  id="page1">
			<webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body id="body1" style="-rave-layout: grid">

					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<!-- Acá inicia el headerr -->
						<f:facet name="header"/>
						<f:facet name="header"/>
						<f:facet name="header"/>

						<!-- Inicio del Título -->
						<webuijsf:label id="label1" style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px;" text="#{resources.titleAbout}"/>
						<!-- Panel con el texto sobre el about! -->
						<webuijsf:panelLayout style="left: 48px; top: 72px; right: 48px; position: absolute; align: center;">
							<p>
								<webuijsf:staticText escape="false" text="#{resources.gplResume}" />
							</p>
							<hr />
							<p>
								<webuijsf:staticText escape="false" text="#{resources.iconLicenseResume}" />
							</p>
						</webuijsf:panelLayout>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
