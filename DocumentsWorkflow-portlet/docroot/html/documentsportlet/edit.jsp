<%@include file="init.jsp" %>

Here you can edit your document.

<portlet:actionURL name="saveDocument" var="saveURL" />

<%
Document doc = (Document) request.getAttribute("document");
String primaryKey = "";
Boolean isForm = false;
if(doc == null){
	// defaulting
	doc = new DocumentImpl();
	doc.setTitle("");
	doc.setType("form");	
}
else{
	primaryKey = Long.toString(doc.getPrimaryKey());
	isForm = "form".equals(doc.getType());
}
%>

<aui:form action="<%= saveURL.toString() %>" method="post">

	<aui:fieldset>
	
		<aui:input name="resourcePrimKey"
				value="<%= primaryKey %>"
				type="hidden" />
	
		<aui:input name="title" 
				   size="45" 
				   value="<%= doc.getTitle() %>" />
				    
		<aui:select name="type" value="<%= doc.getType() %>">
			<aui:option value="form" selected='<%= isForm %>'>Form</aui:option>
			<aui:option value="spec" selected='<%= !isForm %>'>Spec</aui:option>
		</aui:select>
		
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>
    
</aui:form>

