package com.maximgalushka.renderer;


import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.service.DocumentLocalServiceUtil;

public class WorkflowDocumentRendererFactory extends BaseAssetRendererFactory  {

	@Override
	public AssetRenderer getAssetRenderer(long classPK) throws PortalException,
			SystemException {
		
		Document document = DocumentLocalServiceUtil.getDocument(classPK);		
		return new DocumentRenderer(document);
	}

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		
		Document document = DocumentLocalServiceUtil.getDocument(classPK);		
		return new DocumentRenderer(document);
	}

	@Override
	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
			throws PortalException, SystemException {
		return null;
	}

	@Override
	public String getClassName() {
		return Document.class.getName();
	}
	
	@Override
	public String getType() {
		return "WorkflowDocument";
	}

	@Override
	 public PortletURL getURLAdd(
	            LiferayPortletRequest liferayPortletRequest,
	            LiferayPortletResponse liferayPortletResponse)
	        throws PortalException, SystemException {

	        HttpServletRequest request =
	            liferayPortletRequest.getHttpServletRequest();

	        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
	            WebKeys.THEME_DISPLAY);
	        
	        PortletURL portletURL = PortletURLFactoryUtil.create(
			            request, themeDisplay.getPortletDisplay().getId(), 
			            getControlPanelPlid(themeDisplay),
			            PortletRequest.RENDER_PHASE);

	        //portletURL.setParameter("struts_action", "/blogs/edit_entry");

	        return portletURL;
	    }

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			long entryClassPK, String actionId) throws Exception {
		return true;
	}

	@Override
	public boolean isCategorizable() {
		return true;
	}

	@Override
	public boolean isLinkable() {
		return true;
	}

	@Override
	public boolean isSelectable() {
		return true;
	}
	
}
