<%@include file="init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Document doc = (Document) row.getObject();
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long groupId = themeDisplay.getLayout().getGroupId();
	PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
	
	String name = Document.class.getName();
	String primKey = String.valueOf(doc.getPrimaryKey());
%>

<liferay-ui:icon-menu>

	<c:if test="<%=permissionChecker.hasPermission(0, name, primKey, ActionKeys.UPDATE)%>">
		<portlet:actionURL name="editDocument" var="editURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
		</portlet:actionURL>
		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	 </c:if> 
	
	<c:if test="<%=permissionChecker.hasPermission(0, name, primKey, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteDocument" var="deleteURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey%>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if> 
	
	<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%=Document.class.getName()%>"
			modelResourceDescription="<%=doc.getTitle()%>"
			resourcePrimKey="<%=primKey%>" var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%=permissionsURL.toString()%>" />
	</c:if>
	
</liferay-ui:icon-menu>
