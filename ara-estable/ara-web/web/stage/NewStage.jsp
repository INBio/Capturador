<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{stage$NewStage.page1}" id="page1">
			<webuijsf:html binding="#{stage$NewStage.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{stage$NewStage.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{stage$NewStage.form1}" id="form1">
							<webuijsf:label binding="#{stage$NewStage.label1}" id="label1"
											style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.new_stage}"/>
							<webuijsf:tabSet binding="#{stage$NewStage.tabSet1}" id="tabSet1" selected="tab1" style="border: 1px solid gray; height: 358px; left: 48px; top: 72px; position: absolute; width: 742px">
								<webuijsf:tab binding="#{stage$NewStage.tab1}" id="tab1" text="#{resources.basic_information}">
									<webuijsf:panelLayout binding="#{stage$NewStage.layoutPanel1}" id="layoutPanel1" style="height: 297px; position: relative; width: 100%; -rave-layout: grid">
										<webuijsf:label binding="#{stage$NewStage.label2}" id="label2"
														style="height: 24px; left: 24px; top: 24px; position: absolute; width: 118px" text="#{resources.name}"/>
										<webuijsf:textField binding="#{stage$NewStage.name_field}" id="name_field" label=" " required="true" style="height: 24px; left: 168px; top: 24px; position: absolute; width: 264px"/>
										<webuijsf:label binding="#{stage$NewStage.label3}" id="label3"
														style="height: 24px; left: 24px; top: 72px; position: absolute; width: 118px" text="#{resources.description}"/>
										<webuijsf:textArea binding="#{stage$NewStage.description_area}" id="description_area" style="height: 144px; left: 168px; top: 72px; position: absolute; width: 264px"/>
									</webuijsf:panelLayout>
								</webuijsf:tab>
							</webuijsf:tabSet>
							<webuijsf:button actionExpression="#{stage$NewStage.btn_save_action}" binding="#{stage$NewStage.btn_save}" id="btn_save"
											 style="height: 24px; left: 191px; top: 456px; position: absolute; width: 72px" text="#{resources.btnSave}"/>
							<h:messages binding="#{stage$NewStage.messageList}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList"
										infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
