package com.maximgalushka.renderer;

import java.util.Locale;

import javax.portlet.ActionResponse;
import javax.portlet.BaseURL;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.maximgalushka.service.model.Document;

public class DocumentRenderer extends BaseAssetRenderer  {

	private Document document;

	public DocumentRenderer(Document document) {
		super();
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public long getUserId() {
		return document.getUserId();
	}

	@Override
	public String getUuid() {
		return document.getUuid();
	}

	@Override
	public String render(RenderRequest request, RenderResponse response,
			String template) throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT)
				|| template.equals(TEMPLATE_FULL_CONTENT)) {

			request.setAttribute("document", document);

			return "/html/documentsportlet/asset/" + template + ".jsp";
		} else {
			return null;
		}
	}

	@Override
	public long getClassPK() {
		return document.getPrimaryKey();
	}

	@Override
	public String getDiscussionPath() {
		return "";
	}

	@Override
	public long getGroupId() {
		return document.getGroupId();
	}

	@Override
	public String getIconPath(PortletRequest portletRequest) {
		return "";
	}

	@Override
	public String getSummary(Locale locale) {
		return document.getTitle();
	}

	@Override
	public String getTitle(Locale locale) {
		return "Workflow Document entity";
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {

//		ThemeDisplay themeDisplay = (ThemeDisplay)
//							liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//		PortletURL portletURL = liferayPortletResponse.createActionURL();
//		
//		portletURL.setParameter("struts_action", "editDocument");
//		liferayPortletRequest.setAttribute("document", document);
//		liferayPortletRequest.setAttribute("documentId", Long.toString(document.getPrimaryKey()));
		
//		return portletURL;
		return null;
	}


	@Override
	public String getUrlTitle() {
		return "";
	}

	@Override
	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect) throws Exception {

        ThemeDisplay themeDisplay =
            (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        return themeDisplay.getPortalURL() + themeDisplay.getPathMain() +
            "/html/documentsportlet/view.jsp?noSuchEntryRedirect=" +
                HttpUtil.encodeURL(noSuchEntryRedirect) + "&documentId=" +
                    document.getDocumentId();
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
			throws PortalException, SystemException {
		return true;
	}

	@Override
	public boolean isConvertible() {
		return true;
	}

	@Override
	public boolean isDisplayable() {
		return true;
	}

	@Override
	public boolean isLocalizable() {
		return false;
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

}
