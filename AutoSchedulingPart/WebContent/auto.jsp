<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auto Scheduling</title>
</head>
<body>
<f:view>
<h:form>
	<h:outputLabel value="Auto Scheduling" style="color:blue;font-family:Tahoma;font-style:bold;" />
	<br/>
	<br/>
	<table>
		<tr>
		<td>
			<h:outputLabel value="Department : " style="color:black;font-family:Tahoma;font-style:bold;font-size:small" />
		</td>
		<td>
		
		</td>
		<td>			
				<rich:comboBox id="departmentComboId" value="Choose Department">
					<f:selectItems value="#{departmentBean.selectItemList}"/>					
				</rich:comboBox>			
		</td>
		</tr>
	</table>
	<br/>
	<rich:tabPanel switchType="Client">
		<rich:tab label="Freshman">
            <rich:panel style=" height : 401px;">
            <table>
            	<tr>
            		<td>
            			 <rich:orderingList style=" width : 280px;">
	            	       	<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecture Name " style="width:30%" />
					            </f:facet> 
	                		<h:outputText value="Theory of Automata"></h:outputText>
	            			</rich:column>
	            			<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecturer Name "/>
					            </f:facet> 
	                			<h:outputText value="S�leyman SEVINC"></h:outputText>
	            			</rich:column>			   					   		
            	  		</rich:orderingList>
            		</td>
            		<td style=" width : 100px;">
            			
            		</td>
            		<td>
            			<rich:dataTable id="myDataTable" value="Department Schedule Table" style=" width : 700px;">
            				
	        				<f:facet name="header">
	                			<h:outputText value="Schedule Table" />
	        				</f:facet>
        				
	        				<rich:column style=" width : 180px;">
	        					<f:facet name="header">
	        						<h:outputText value="Hours/Days " />
	        					</f:facet>
	        					<f:facet name="footer"></f:facet>
	        					
	        				</rich:column>
                			
        				        				
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Monday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Tuesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Wednesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Thursday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 500px;">
                			<f:facet name="header">
                				<h:outputText value="Friday"/>
                			</f:facet>
        				 </rich:column>
      				
            			</rich:dataTable>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			<br/>
            	  <table>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Course Info :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="courseInfoTextField" disabled="true" style=" width : 251px;"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Lecturer :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="lecturerNameTextField" disabled="true"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Credits :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<table>
            	  				<tr>
            	  				<td>
            	  					<h:inputText id="theoricCreditTextField" disabled="true" style=" width : 60px;"></h:inputText>
            	  				</td>
            	  				<td>
            	  					<h:outputText value="+"></h:outputText>
            	  				</td>
            	  				<td>
            	  					<h:inputText id="practiceCreditTextField" disabled="true" style=" width : 58px;"></h:inputText>
            	  				</td>
            	  				</tr>
            	  			</table>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Room : "></h:outputText>
            	  		</td>
            	  		<td style=" width : 146px;">
            	  			<rich:comboBox  id="roomComboBox" value = "Choose Room" width="99"></rich:comboBox>
            	  		</td>
            	  		
            	  	</tr>           	  	
            	  </table>
            		</td>
            	</tr>
            </table>
        	  
	      </rich:panel>
        </rich:tab>
        <rich:tab label="Sophomore">
            <rich:panel style=" height : 401px;">
            	   <table>
            	<tr>
            		<td>
            			 <rich:orderingList style=" width : 280px;">
	            	       	<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecture Name " style="width:30%" />
					            </f:facet> 
	                		<h:outputText value="Theory of Automata"></h:outputText>
	            			</rich:column>
	            			<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecturer Name "/>
					            </f:facet> 
	                			<h:outputText value="S�leyman SEVINC"></h:outputText>
	            			</rich:column>			   					   		
            	  		</rich:orderingList>
            		</td>
            		<td style=" width : 100px;">
            			
            		</td>
            		<td>
            			<rich:dataTable id="myDataTableSomophore" value="Department Schedule Table" style=" width : 700px;">
            				
	        				<f:facet name="header">
	                			<h:outputText value="Schedule Table" />
	        				</f:facet>
        				
	        				<rich:column style=" width : 180px;">
	        					<f:facet name="header">
	        						<h:outputText value="Hours/Days " />
	        					</f:facet>
	        					<f:facet name="footer"></f:facet>
	        					
	        				</rich:column>
                			
        				        				
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Monday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Tuesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Wednesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Thursday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 500px;">
                			<f:facet name="header">
                				<h:outputText value="Friday"/>
                			</f:facet>
        				 </rich:column>
      				
            			</rich:dataTable>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			<br/>
            	  <table>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Course Info :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="courseInfoTextFieldSomophore" disabled="true" style=" width : 251px;"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Lecturer :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="lecturerNameTextFieldSomophore" disabled="true"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Credits :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<table>
            	  				<tr>
            	  				<td>
            	  					<h:inputText id="theoricCreditTextFieldSomophore" disabled="true" style=" width : 60px;"></h:inputText>
            	  				</td>
            	  				<td>
            	  					<h:outputText value="+"></h:outputText>
            	  				</td>
            	  				<td>
            	  					<h:inputText id="practiceCreditTextFieldSomophore" disabled="true" style=" width : 58px;"></h:inputText>
            	  				</td>
            	  				</tr>
            	  			</table>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Room : "></h:outputText>
            	  		</td>
            	  		<td style=" width : 146px;">
            	  			<rich:comboBox  id="roomComboBoxSomophore" value = "Choose Room" width="99"></rich:comboBox>
            	  		</td>
            	  		
            	  	</tr>           	  	
            	  </table>
            		</td>
            	</tr>
            </table>			    				   	
            </rich:panel>
        </rich:tab>
        <rich:tab label="Junior">
            <rich:panel style=" height : 401px;">
            	   <table>
            	<tr>
            		<td>
            			 <rich:orderingList style=" width : 280px;">
	            	       	<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecture Name " style="width:30%" />
					            </f:facet> 
	                		<h:outputText value="Theory of Automata"></h:outputText>
	            			</rich:column>
	            			<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecturer Name "/>
					            </f:facet> 
	                			<h:outputText value="S�leyman SEVINC"></h:outputText>
	            			</rich:column>			   					   		
            	  		</rich:orderingList>
            		</td>
            		<td style=" width : 100px;">
            			
            		</td>
            		<td>
            			<rich:dataTable id="myDataTableJunior" value="Department Schedule Table" style=" width : 700px;">
            				
	        				<f:facet name="header">
	                			<h:outputText value="Schedule Table" />
	        				</f:facet>
        				
	        				<rich:column style=" width : 180px;">
	        					<f:facet name="header">
	        						<h:outputText value="Hours/Days " />
	        					</f:facet>
	        					<f:facet name="footer"></f:facet>
	        					
	        				</rich:column>
                			
        				        				
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Monday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Tuesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Wednesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Thursday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 500px;">
                			<f:facet name="header">
                				<h:outputText value="Friday"/>
                			</f:facet>
        				 </rich:column>
      				
            			</rich:dataTable>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			<br/>
            	  <table>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Course Info :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="courseInfoTextFieldJunior" disabled="true" style=" width : 251px;"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Lecturer :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="lecturerNameTextFieldJunior" disabled="true"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Credits :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<table>
            	  				<tr>
            	  				<td>
            	  					<h:inputText id="theoricCreditTextFieldJunior" disabled="true" style=" width : 60px;"></h:inputText>
            	  				</td>
            	  				<td>
            	  					<h:outputText value="+"></h:outputText>
            	  				</td>
            	  				<td>
            	  					<h:inputText id="practiceCreditTextFieldJunior" disabled="true" style=" width : 58px;"></h:inputText>
            	  				</td>
            	  				</tr>
            	  			</table>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Room : "></h:outputText>
            	  		</td>
            	  		<td style=" width : 146px;">
            	  			<rich:comboBox  id="roomComboBoxJunior" value = "Choose Room" width="99"></rich:comboBox>
            	  		</td>
            	  		
            	  	</tr>           	  	
            	  </table>
            		</td>
            	</tr>
            </table>			    				   	
            </rich:panel>
        </rich:tab>
        <rich:tab label="Senior">
            <rich:panel style=" height : 401px;">
            	   <table>
            	<tr>
            		<td>
            			 <rich:orderingList style=" width : 280px;">
	            	       	<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecture Name " style="width:30%" />
					            </f:facet> 
	                		<h:outputText value="Theory of Automata"></h:outputText>
	            			</rich:column>
	            			<rich:column  width="300">
					            <f:facet name="header">
					                <h:outputText value="Lecturer Name "/>
					            </f:facet> 
	                			<h:outputText value="S�leyman SEVINC"></h:outputText>
	            			</rich:column>			   					   		
            	  		</rich:orderingList>
            		</td>
            		<td style=" width : 100px;">
            			
            		</td>
            		<td>
            			<rich:dataTable id="myDataTableSenior" value="Department Schedule Table" style=" width : 700px;">
            				
	        				<f:facet name="header">
	                			<h:outputText value="Schedule Table" />
	        				</f:facet>
        				
	        				<rich:column style=" width : 180px;">
	        					<f:facet name="header">
	        						<h:outputText value="Hours/Days " />
	        					</f:facet>
	        					<f:facet name="footer"></f:facet>
	        					
	        				</rich:column>
                			
        				        				
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Monday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Tuesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Wednesday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 250px;">
                			<f:facet name="header">
                				<h:outputText value="Thursday"/>
                			</f:facet>
        				 </rich:column>
        				 <rich:column style=" width : 500px;">
                			<f:facet name="header">
                				<h:outputText value="Friday"/>
                			</f:facet>
        				 </rich:column>
      				
            			</rich:dataTable>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			<br/>
            	  <table>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Course Info :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="courseInfoTextFieldSenior" disabled="true" style=" width : 251px;"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Lecturer :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<h:inputText id="lecturerNameTextFieldSenior" disabled="true"></h:inputText>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Credits :"></h:outputText>
            	  		</td>
            	  		<td>
            	  			<table>
            	  				<tr>
            	  				<td>
            	  					<h:inputText id="theoricCreditTextFieldSenior" disabled="true" style=" width : 60px;"></h:inputText>
            	  				</td>
            	  				<td>
            	  					<h:outputText value="+"></h:outputText>
            	  				</td>
            	  				<td>
            	  					<h:inputText id="practiceCreditTextFieldSenior" disabled="true" style=" width : 58px;"></h:inputText>
            	  				</td>
            	  				</tr>
            	  			</table>
            	  		</td>
            	  	</tr>
            	  	<tr>
            	  		<td>
            	  			<h:outputText value="Room : "></h:outputText>
            	  		</td>
            	  		<td style=" width : 146px;">
            	  			<rich:comboBox  id="roomComboBoxSenior" value = "Choose Room" width="99"></rich:comboBox>
            	  		</td>
            	  		
            	  	</tr>           	  	
            	  </table>
            		</td>
            	</tr>
            </table>			    				   	
            </rich:panel>
        </rich:tab>
		<rich:tab label="Dean Lectures">
			<rich:panel style=" height : 401px;">
				<table bgcolor="silver">
					<tr style=" height : 14px;">
					<td style=" width : 22px;">
					</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<h:outputText value="Course : "></h:outputText> 
						</td>
						<td>
							<rich:comboBox value="Choose Dean's Course">
								
							</rich:comboBox>
						</td>
						<td>
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
					<td>
						</td>
						<td>
							<h:outputText value="Lecturer : "></h:outputText>
						</td>
						<td>
							<h:inputText disabled="true" style=" width : 257px;"></h:inputText>
						</td>
						<td style=" width : 47px;">
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
					<td>
						</td>
						<td>
							<h:outputText value="Days : "></h:outputText> 
						</td>
						<td>
							<rich:comboBox value="Choose Course Day">
								
								<f:selectItem itemValue="Monday"/>
								<f:selectItem itemValue="Tuesday"/>
								<f:selectItem itemValue="Wednesday"/>
								<f:selectItem itemValue="Thursday"/>
								<f:selectItem itemValue="Friday"/>							
							</rich:comboBox>
						</td>
						<td>
						</td>
					</tr>
					<tr style=" height : 22px;">
					<td style=" width : 35px;">
					</td>
					</tr>
				</table>
			</rich:panel>
		</rich:tab>		
	</rich:tabPanel>
	</h:form>
</f:view>
</body>
</html>