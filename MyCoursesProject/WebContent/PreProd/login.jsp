<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome jAnissary Course Scheduling System</title>
</head>
<body>
<f:view>
	<h:panelGrid columns="1">
		<h:form>
		<h:panelGrid columns="2" style="background-color:#3BB9FF;">
			<table>
				<tr style=" height : 65px;">
				<td style="width:37px">
					<h:graphicImage value="../images/logo.png"/>
				</td>
				<td style=" width : 990px;">
										
				</td>
				</tr>
			</table>
			<h:panelGrid columns="3" >
				
					<h:outputLabel value="Username" style="color:white; FONT-SIZE: small; FONT-FAMILY: 'Verdana';"/>
					<h:outputLabel value="Password" style="color:white; FONT-SIZE: small; FONT-FAMILY: 'Verdana';"/>
					<h:outputLabel value=""/>
				
					<h:inputText id="loginUsername" value="#{loginBean.userName}" />
					<h:inputSecret id="loginPassword" value="#{loginBean.password}" />
					<h:commandButton value="Login" action="#{loginBean.checkLogin}" style="width : 70px; height : 25px;">
							
					</h:commandButton>
					
					<rich:message for="loginUsername" style="color:red; FONT-SIZE: small; FONT-FAMILY: 'Verdana';"></rich:message>		
					<rich:message for="loginPassword" style="color:red; FONT-SIZE: small; FONT-FAMILY: 'Verdana';"></rich:message>
					
			</h:panelGrid>
		</h:panelGrid>
		
		<table>
			<tr style=" height : 400px;">
				<td style=" width : 990px;">
				</td>		
			</tr>
		</table>
		</h:form>
	</h:panelGrid>
</f:view>
</body>
</html>