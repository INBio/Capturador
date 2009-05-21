<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{welcome.page1}" id="page1">
			<webuijsf:html binding="#{welcome.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{welcome.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
						<webuijsf:form binding="#{welcome.form1}" id="form1">
							<webuijsf:staticText
								binding="#{welcome.staticText1}" id="staticText1" style="font-weight: bold; left: 120px; top: 192px; position: absolute; width: 430px"/>
							<h:dataTable binding="#{welcome.dataTable1}" id="dataTable1" rowClasses="list-row-even,list-row-odd" style="border: 1px solid olive; background-color: rgb(153, 153, 0); color: rgb(204, 102, 0); font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 24px; top: 144px; position: absolute">
								<h:column binding="#{welcome.column1}" id="column1">
									<f:facet name="header">
										<h:outputText binding="#{welcome.outputText1}" id="outputText1"
													  style="background-color: rgb(153, 153, 0); color: rgb(255, 255, 255); left: 100px" title="#{resources.modules}" value="#{resources.modules}"/>
									</f:facet>
								</h:column>
							</h:dataTable>
							<h:dataTable binding="#{welcome.dataTable2}" id="dataTable2" rowClasses="list-row-even,list-row-odd"
										 style="border: 1px solid olive; background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 96px; top: 144px; position: absolute" width="672">
								<h:column binding="#{welcome.column2}" id="column2">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_showWelcome_action}" binding="#{welcome.hlink_showWelcome}"
															id="hlink_showWelcome"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resouces.audiences}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column3}" id="column3">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_species_action}" binding="#{welcome.hlink_especies}"
															id="hlink_especies"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold" text="#{resouces.species}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column14}" id="column14">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_stages_action}" binding="#{welcome.hlink_estados}"
															id="hlink_estados"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold" text="#{resources.stages}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column4}" id="column4">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_person_action}" binding="#{welcome.hlink_person1}"
															id="hlink_person1"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resources.peoble}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column5}" id="column5">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_profile_action}" binding="#{welcome.hlink_profile1}"
															id="hlink_profile1"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resources.profiles}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column6}" id="column6">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_institution_action}" binding="#{welcome.hlink_institution1}"
															id="hlink_institution1"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resources.institution}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column7}" id="column7">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_user_action}" binding="#{welcome.hlink_user1}" id="hlink_user1"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resouces.users}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column8}" id="column8">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_groups_action}" binding="#{welcome.hlink_groups}"
															id="hlink_groups"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resouces.groups}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column11}" id="column11">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_changePwd_action}" binding="#{welcome.hlink_changePwd1}"
															id="hlink_changePwd1"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resouces.change_password}"/>
									</f:facet>
								</h:column>
								<h:column binding="#{welcome.column13}" id="column13">
									<f:facet name="header">
										<webuijsf:hyperlink actionExpression="#{welcome.hlink_taxonomy_action}" binding="#{welcome.hlink_taxonomy}"
															id="hlink_taxonomy"
															style="background-color: rgb(255, 255, 153); color: rgb(204, 102, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: normal; font-weight: bold;" text="#{resouces.taxonomy}"/>
									</f:facet>
								</h:column>
							</h:dataTable>
							<h:column binding="#{welcome.column12}" id="column12"/>
							<webuijsf:staticText binding="#{welcome.staticText2}" id="staticText2" style="left: 120px; top: 216px; position: absolute; width: 432px"/>
							<webuijsf:staticText binding="#{welcome.staticText3}" id="staticText3" style="left: 120px; top: 240px; position: absolute" text="#{resouces.use_details}"/>
							<webuijsf:staticText binding="#{welcome.st_1}" id="st_1" style="left: 480px; top: 240px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.staticText4}" id="staticText4" style="left: 120px; top: 264px; position: absolute" text="#{resources.default_proyection}"/>
							<webuijsf:staticText binding="#{welcome.staticText5}" id="staticText5" style="left: 120px; top: 288px; position: absolute" text="#{resources.default_recolection_method}"/>
							<webuijsf:staticText binding="#{welcome.staticText6}" id="staticText6" style="left: 120px; top: 312px; position: absolute" text="#{resources.allow_sinonim_identification}"/>
							<webuijsf:staticText binding="#{welcome.staticText7}" id="staticText7" style="left: 120px; top: 336px; position: absolute" text="#{resources.use_form_lifes}"/>
							<webuijsf:staticText binding="#{welcome.staticText8}" id="staticText8" style="left: 120px; top: 360px; position: absolute" text="#{resources.morphological_asosiated_module}"/>
							<webuijsf:staticText binding="#{welcome.staticText9}" id="staticText9" style="left: 120px; top: 384px; position: absolute" text="#{resources.reindent_specimens}"/>
							<webuijsf:staticText binding="#{welcome.staticText10}" id="staticText10" style="left: 120px; top: 408px; position: absolute" text="#{resources.use_crops}"/>
							<webuijsf:staticText binding="#{welcome.staticText11}" id="staticText11" style="left: 120px; top: 432px; position: absolute" text="#{resouces.share_recolection_sequential}"/>
							<webuijsf:staticText binding="#{welcome.st_2}" id="st_2" style="left: 480px; top: 264px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_3}" id="st_3" style="left: 480px; top: 288px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_4}" id="st_4" style="left: 480px; top: 312px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_5}" id="st_5" style="left: 480px; top: 336px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_6}" id="st_6" style="left: 480px; top: 360px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_7}" id="st_7" style="left: 480px; top: 384px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_8}" id="st_8" style="left: 480px; top: 408px; position: absolute"/>
							<webuijsf:staticText binding="#{welcome.st_9}" id="st_9" style="left: 480px; top: 432px; position: absolute"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
