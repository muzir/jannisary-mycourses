<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.active-row {
    background-color: #FFEBDA;
}
</style>

</head>
<body>
<f:view>


    <h:form>
        <script type="text/javascript">
            var row;
        </script>
        
        <a4j:region>
            <rich:dataTable value="#{departmentBean.allDepartments}"
                var="category" rows="20" rowKeyVar="row"
                ajaxKeys="#{departmentBean.keys}" id="table"
                onRowContextMenu="if (row) row.style.backgroundColor='#{a4jSkin.tableBackgroundColor}';
                this.style.backgroundColor='#F1F1F1'; row=this;
                return false;" style="height : 142px; width : 634px;">
                <f:facet name="header">
                    <h:outputText value="Department Operation" />
                </f:facet>
                
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Department Code" />
                    </f:facet>
                    <h:outputText value="#{category.deptCode}" id="deptCode" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Dept Description" />
                    </f:facet>
                    <h:outputText value="#{category.deptDescription}" id="deptDescription" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        Actions
                    </f:facet>
                    <a4j:commandLink ajaxSingle="true" id="editlink"
                        oncomplete="#{rich:component('editPanel')}.show()">
                        <h:graphicImage value="../images/icons/edit.ico" style="border:0" />
                        <f:setPropertyActionListener value="#{category}"
                            target="#{departmentBean.currentItem}" />
                        <f:setPropertyActionListener value="#{row}"
                            target="#{departmentBean.currentRow}" />
                    </a4j:commandLink>
                    <rich:toolTip for="editlink" value="Edit" />
                    <a4j:commandLink ajaxSingle="true" id="deletelink"
                        oncomplete="#{rich:component('deletePanel')}.show()">
                        <h:graphicImage value="../images/icons/delete.ico" style="border:0" />
                        <f:setPropertyActionListener value="#{row}"
                            target="#{departmentBean.currentRow}" />
                    </a4j:commandLink>
                    <rich:toolTip for="deletelink" value="Delete" />
                </rich:column>
                <f:facet name="footer">
                    <rich:datascroller renderIfSinglePage="false" maxPages="5" />
                </f:facet>
            </rich:dataTable>
        </a4j:region>
    </h:form>

    <rich:modalPanel id="editPanel" autosized="true" width="450">
        <f:facet name="header">
            <h:outputText value="Edit Current Department" />
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="../images/modal/close.ico" id="hidelink"
                    styleClass="hidelink" />
                <rich:componentControl for="editPanel" attachTo="hidelink"
                    operation="hide" event="onclick" />
            </h:panelGroup>
        </f:facet>
        <h:form>
            <rich:messages style="color:red;"></rich:messages>
            <h:panelGrid columns="1">
                <a4j:outputPanel ajaxRendered="true">
                    <h:panelGrid columns="2">
                        <h:outputText value="Department Description" />
                        <h:inputText value="#{departmentBean.currentItem.deptDescription}" />
                        <h:outputText value="Department Code" />
                        <h:inputText value="#{departmentBean.currentItem.deptCode}" />
                    </h:panelGrid>
                    <rich:message showSummary="true" showDetail="false" for="price" />
                </a4j:outputPanel>
                <a4j:commandButton value="Store"
                    action="#{departmentBean.store}"
                    reRender="table"
                    oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editPanel')}.hide();" />
            </h:panelGrid>
        </h:form>
    </rich:modalPanel>
    <rich:modalPanel id="deletePanel" autosized="true" width="200">
        <f:facet name="header">
            <h:outputText value="Delete this Department from list?"
                style="padding-right:15px;" />
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="../images/modal/close.ico"
                    styleClass="hidelink" id="hidelink2" />
                <rich:componentControl for="deletePanel" attachTo="hidelink2"
                    operation="hide" event="onclick" />
            </h:panelGroup>
        </f:facet>
        <h:form>
            <table width="100%">
                <tbody>
                    <tr>
                        <td align="center" width="50%"><a4j:commandButton value="Yes"
                            ajaxSingle="true" action="#{departmentBean.delete}"
                            oncomplete="#{rich:component('deletePanel')}.hide();"
                            reRender="table" />
                        </td>
                        <td align="center" width="50%"><a4j:commandButton
                            value="Cancel"
                            onclick ="#{rich:component('deletePanel')}.hide();return false;" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </h:form>
    </rich:modalPanel>
    <a4j:status onstart="#{rich:component('wait')}.show()"
        onstop="#{rich:component('wait')}.hide()" />
    <rich:modalPanel id="wait" autosized="true" width="200" height="120"
        moveable="false" resizeable="false">
        <f:facet name="header">
            <h:outputText value="Processing" />
        </f:facet>
        <h:outputText value="Wait Please..." />
    </rich:modalPanel>
    
    <h:form>
    
    <h:panelGrid id="departmentPanelGrid" columns="1">
    
    	<h:inputText  value="#{departmentBean.currentItem.deptCode}">
	    		<f:validateLength minimum="1" maximum="10"/>
	   	</h:inputText>
	   	
	   	<h:inputText value="#{departmentBean.currentItem.deptDescription}">
	    		<f:validateLength minimum="1" maximum="100"/>
	    	</h:inputText>
    
    	<h:commandButton value="Add Department" action="#{departmentBean.addDepartment}" style=" width : 110px; height : 20px;">
				<a4j:support event="onclick" reRender="table"/>
			</h:commandButton>
    
    </h:panelGrid>
    </h:form>
        
</f:view>
</body>
</html>