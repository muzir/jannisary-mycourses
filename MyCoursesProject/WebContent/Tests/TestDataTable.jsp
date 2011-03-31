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
        <rich:contextMenu attached="false" id="menu" submitMode="ajax" oncollapse="row.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:menuItem value="Edit Record" ajaxSingle="true"
                oncomplete="#{rich:component('editPanel')}.show()"
                actionListener="#{dataTableScrollerBean.fetchCurrentRow}">
                <a4j:actionparam name="vin" value="{carVin}" />
                <a4j:actionparam name="row" value="{currentRow}" />
            </rich:menuItem>
            <rich:menuItem value="Remove Record" ajaxSingle="true"
                oncomplete="#{rich:component('deletePanel')}.show()"
                actionListener="#{dataTableScrollerBean.fetchCurrentRow}">
                <a4j:actionparam name="vin" value="{carVin}" />
                <a4j:actionparam name="row" value="{currentRow}" />
            </rich:menuItem>
        </rich:contextMenu>
        <a4j:region>
            <rich:dataTable value="#{dataTableScrollerBean.allCars}"
                var="category" rows="20" rowKeyVar="row"
                ajaxKeys="#{dataTableScrollerBean.keys}" id="table"
                onRowContextMenu="if (row) row.style.backgroundColor='#{a4jSkin.tableBackgroundColor}';
                this.style.backgroundColor='#F1F1F1'; row=this;
                #{rich:component('menu')}.show(event,{carVin:'#{category.vin}', currentRow:'#{row}'});
                return false;">
                <f:facet name="header">
                    <h:outputText value="Cars Store" />
                </f:facet>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Make" />
                    </f:facet>
                    <h:outputText value="#{category.make}" id="make" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Model" />
                    </f:facet>
                    <h:outputText value="#{category.model}" id="model" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Price" />
                    </f:facet>
                    <h:outputText value="#{category.price}" id="price" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Mileage" />
                    </f:facet>
                    <h:outputText value="#{category.mileage}" />
                </rich:column>
                <rich:column width="200px">
                    <f:facet name="header">
                        <h:outputText value="VIN" />
                    </f:facet>
                    <h:outputText value="#{category.vin}" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        <h:outputText value="Stock" />
                    </f:facet>
                    <h:outputText value="#{category.stock}" />
                </rich:column>
                <rich:column>
                    <f:facet name="header">
                        Actions
                    </f:facet>
                    <a4j:commandLink ajaxSingle="true" id="editlink"
                        oncomplete="#{rich:component('editPanel')}.show()">
                        <h:graphicImage value="../images/icons/edit.ico" style="border:0" />
                        <f:setPropertyActionListener value="#{category}"
                            target="#{dataTableScrollerBean.currentItem}" />
                        <f:setPropertyActionListener value="#{row}"
                            target="#{dataTableScrollerBean.currentRow}" />
                    </a4j:commandLink>
                    <rich:toolTip for="editlink" value="Edit" />
                    <a4j:commandLink ajaxSingle="true" id="deletelink"
                        oncomplete="#{rich:component('deletePanel')}.show()">
                        <h:graphicImage value="../images/icons/delete.ico" style="border:0" />
                        <f:setPropertyActionListener value="#{row}"
                            target="#{dataTableScrollerBean.currentRow}" />
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
            <h:outputText value="Edit Current Car" />
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
                        <h:outputText value="Make" />
                        <h:inputText value="#{dataTableScrollerBean.currentItem.make}" />
                        <h:outputText value="Model" />
                        <h:inputText value="#{dataTableScrollerBean.currentItem.model}" />
                        <h:outputText value="Price" />
                        <h:inputText value="#{dataTableScrollerBean.currentItem.price}"
                            label="Price" immediate="true" />
                    </h:panelGrid>
                    <rich:message showSummary="true" showDetail="false" for="price" />
                </a4j:outputPanel>
                <a4j:commandButton value="Store"
                    action="#{dataTableScrollerBean.store}"
                    reRender="make, model, price"
                    oncomplete="if (#{facesContext.maximumSeverity==null}) #{rich:component('editPanel')}.hide();" />
            </h:panelGrid>
        </h:form>
    </rich:modalPanel>
    <rich:modalPanel id="deletePanel" autosized="true" width="200">
        <f:facet name="header">
            <h:outputText value="Delete this car from list?"
                style="padding-right:15px;" />
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/modal/close.png"
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
                            ajaxSingle="true" action="#{dataTableScrollerBean.delete}"
                            oncomplete="#{rich:component('deletePanel')}.hide();"
                            reRender="table" /></td>
                        <td align="center" width="50%"><a4j:commandButton
                            value="Cancel"
                            onclick="#{rich:component('deletePanel')}.hide();return false;" />
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
    <rich:messages>
    
    </rich:messages>

</f:view>
</body>
</html>