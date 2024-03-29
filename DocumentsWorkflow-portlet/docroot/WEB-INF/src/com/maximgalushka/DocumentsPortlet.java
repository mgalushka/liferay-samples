package com.maximgalushka;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.service.DocumentLocalServiceUtil;
import com.maximgalushka.utils.Util;

/**
 * Portlet implementation class DocumentsPortlet
 */
public class DocumentsPortlet extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(DocumentsPortlet.class);
 
	public void editDocument(ActionRequest request, ActionResponse response){
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		//log.debug(String.format("Permissions: [%s]", arg1));
		
		// ParamUtil.getString(renderRequest, "query")
		String primaryKeyString = request.getParameter("resourcePrimKey");
		if(primaryKeyString != null){
			// to edit existing
			Long documentPrimaryKey = Long.parseLong(primaryKeyString);
			log.debug(String.format("Edited document ID: [%d]", documentPrimaryKey));
			if(documentPrimaryKey != null){
				try {
					request.setAttribute("document", DocumentLocalServiceUtil.getDocument(documentPrimaryKey));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		response.setRenderParameter("jspPage", "/html/documentsportlet/edit.jsp");
	}

	public void saveDocument(ActionRequest request, ActionResponse response) 
			throws SystemException{		
		
		Document doc = Util.documentFromRequest(request);
		if(Long.valueOf("0").equals(doc.getPrimaryKey())){
			try {
				ServiceContext serviceContext = ServiceContextFactory.
										getInstance(Document.class.getName(), request);
				
				DocumentLocalServiceUtil.addDocument(doc, serviceContext);
				
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		else{
			DocumentLocalServiceUtil.updateDocument(doc);
		}
		
		response.setRenderParameter("jspPage", "/html/documentsportlet/view.jsp");
	}
	
	
	public void deleteDocument(ActionRequest request, ActionResponse response) 
			throws SystemException{		
		
		
		String primaryKeyString = request.getParameter("resourcePrimKey");
		if(primaryKeyString != null){
			// to delete existing
			Long documentPrimaryKey = Long.parseLong(primaryKeyString);
			log.debug(String.format("Deleting document ID: [%d]", documentPrimaryKey));
			if(documentPrimaryKey != null){
				try {
					Document doc = DocumentLocalServiceUtil.getDocument(documentPrimaryKey);
					if(doc != null){
						DocumentLocalServiceUtil.deleteDocument(doc);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// DO NOTHING for now		
		response.setRenderParameter("jspPage", "/html/documentsportlet/view.jsp");
	}
	
	
	
	
}
