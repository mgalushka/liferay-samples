<%@include file="init.jsp" %>

<portlet:actionURL name="editDocument" var="editURL" />

<form action="${editURL}" id="<portlet:namespace/>EditForm" method="post">
    <input type="submit" value="Add new document" name="AddButton" />
</form>

<br/>

Available documents list: <br/>

  <liferay-ui:search-container
      emptyResultsMessage="there-are-no-products"
      delta="50">

    <liferay-ui:search-container-results>
    <%
    List<Document> tempResults = Util.getDocuments(renderRequest);
    total = tempResults.size();
    results = ListUtil.subList(
    		tempResults, searchContainer.getStart(),
    		searchContainer.getEnd());
    
    pageContext.setAttribute("results", results);
    pageContext.setAttribute("total", total);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.maximgalushka.service.model.Document"
        keyProperty="documentId"
        modelVar="document">

      <liferay-ui:search-container-column-text
          name="title"
          property="title" />
      <liferay-ui:search-container-column-text
          name="type"
          property="type" />
       
      <liferay-ui:search-container-column-jsp
          path="/html/documentsportlet/admin_actions.jsp"
          align="right" />
       

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

  </liferay-ui:search-container>
  <br/>
  <br/>
