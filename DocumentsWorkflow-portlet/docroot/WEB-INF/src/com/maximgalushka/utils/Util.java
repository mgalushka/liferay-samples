package com.maximgalushka.utils;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.model.impl.DocumentImpl;
import com.maximgalushka.service.service.DocumentLocalServiceUtil;

public class Util {

	private static Logger log = Logger.getLogger(Util.class);
	
	public static Document documentFromRequest (PortletRequest request) {
		
	    Document document = new DocumentImpl();
	    
	    document.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
	    document.setTitle(ParamUtil.getString(request, "title"));
	    document.setType(ParamUtil.getString(request, "type"));
	    
	    ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    document.setCompanyId(theme.getCompanyId());
	    document.setUserId(theme.getUserId());
	    
	    return document;
	}
	
	public static List<Document> getDocuments (PortletRequest request){
		try{
			return DocumentLocalServiceUtil.getDocuments(0, 50);
		}
		catch(SystemException se){
			log.error(String.format("Error retrieving list of all documents: ", se));
			return Collections.emptyList();
		}
	}
}
