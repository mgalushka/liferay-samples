/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.maximgalushka.service.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.service.base.DocumentLocalServiceBaseImpl;

/**
 * The implementation of the Document local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.maximgalushka.service.service.DocumentLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author mgalushka
 * @see com.maximgalushka.service.service.base.DocumentLocalServiceBaseImpl
 * @see com.maximgalushka.service.service.DocumentLocalServiceUtil
 */
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.maximgalushka.service.service.DocumentLocalServiceUtil} to access the
	 * Document local service.
	 */

	public Document addDocument(Document document, ServiceContext serviceContext)
			throws SystemException {

		Document newInstance = documentPersistence.create(counterLocalService
				.increment(Document.class.getName()));
		newInstance.setStatus(WorkflowConstants.STATUS_DRAFT);
		newInstance.setTitle(document.getTitle());
		newInstance.setUserId(document.getUserId());
		newInstance.setCompanyId(document.getCompanyId());
		newInstance.setGroupId(document.getGroupId());
		newInstance.setType(document.getType());

		documentPersistence.update(newInstance, false);

		try {
			resourceLocalService.addResources(newInstance.getCompanyId(),
					newInstance.getGroupId(), newInstance.getUserId(),
					Document.class.getName(), newInstance.getPrimaryKey(), false,
					true, true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// assetEntryLocalService.addAssetEntry();
//			assetEntryLocalService.createAssetEntry(entryId)
			assetEntryLocalService.updateEntry(newInstance.getUserId(),
					newInstance.getGroupId(), Document.class.getName(),
					newInstance.getPrimaryKey(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
		} catch (PortalException e1) {
			e1.printStackTrace();
		}

		try {
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					newInstance.getCompanyId(), newInstance.getUserId(),
					Document.class.getName(), newInstance.getPrimaryKey(),
					newInstance, serviceContext);

		} catch (PortalException e) {
			e.printStackTrace();
		}

		return document;
	}

	public Document updateStatus(long userId, 
						 long resourcePrimKey, int status,
						 ServiceContext serviceContext) 
								 throws SystemException, PortalException {

		// TODO: to attach user who moves the workflow status
		User user = userLocalService.getUser(userId);
		Document document = getDocument(resourcePrimKey);
		document.setStatus(status);
		documentPersistence.update(document, false);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Document.class.getName(),
					resourcePrimKey, true);
		} else {
			assetEntryLocalService.updateVisible(Document.class.getName(),
					resourcePrimKey, false);
		}
		return document;
	}

	public void deleteDocument(Document document) throws SystemException {
		super.deleteDocument(document);

		try {
			resourceLocalService.deleteResource(document.getCompanyId(),
					Document.class.getName(), 4,
					Long.toString(document.getPrimaryKey()));

			assetEntryLocalService.deleteEntry(Document.class.getName(),
					document.getPrimaryKey());

		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
}