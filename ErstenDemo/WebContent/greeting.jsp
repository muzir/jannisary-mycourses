<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<f:loadBundle basename="jsfks.bundle.messages" var="msg"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>greeting page</title>
</head>
<body>
<f:view>
	<h3>
 	 <h:outputText value="#{msg.greeting_text}" />,
 	 <h:outputText value="#{personBean.personName}" />
 	
         <h:outputText value="#{msg.sign}" />
    	</h3>
</f:view>
</body>
</html>