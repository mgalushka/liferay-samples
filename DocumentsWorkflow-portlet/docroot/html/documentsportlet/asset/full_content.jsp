<%@include file="../init.jsp" %>

<%
Document document = (Document) request.getAttribute("document");
%>

<b>Title</b><br/>
<%= document.getTitle() %><br/>

<b>type</b><br/>
<%= document.getType() %><br/>
<br/>

<liferay-ui:custom-attributes-available className="<%= Document.class.getName() %>">
    <liferay-ui:custom-attribute-list
        className="<%= Document.class.getName() %>"
        classPK="<%= (document != null) ? document.getDocumentId() : 0 %>"
        editable="<%= false %>"
        label="<%= true %>"
    />
</liferay-ui:custom-attributes-available>