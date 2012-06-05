package com.maximgalushka;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
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
			DocumentLocalServiceUtil.addDocument(doc);
		}
		else{
			DocumentLocalServiceUtil.updateDocument(doc);
		}
		
		response.setRenderParameter("jspPage", "/html/documentsportlet/view.jsp");
	}
	
	
	public void deleteDocument(ActionRequest request, ActionResponse response) 
			throws SystemException{		
		
		// DO NOTHING for now		
		response.setRenderParameter("jspPage", "/html/documentsportlet/view.jsp");
	}
	
	
	
	
}
