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

package com.maximgalushka.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DocumentLocalService}.
 * </p>
 *
 * @author    mgalushka
 * @see       DocumentLocalService
 * @generated
 */
public class DocumentLocalServiceWrapper implements DocumentLocalService,
	ServiceWrapper<DocumentLocalService> {
	public DocumentLocalServiceWrapper(
		DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	/**
	* Adds the Document to the database. Also notifies the appropriate model listeners.
	*
	* @param document the Document
	* @return the Document that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document addDocument(
		com.maximgalushka.service.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.addDocument(document);
	}

	/**
	* Creates a new Document with the primary key. Does not add the Document to the database.
	*
	* @param documentId the primary key for the new Document
	* @return the new Document
	*/
	public com.maximgalushka.service.model.Document createDocument(
		long documentId) {
		return _documentLocalService.createDocument(documentId);
	}

	/**
	* Deletes the Document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the Document
	* @throws PortalException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_documentLocalService.deleteDocument(documentId);
	}

	/**
	* Deletes the Document from the database. Also notifies the appropriate model listeners.
	*
	* @param document the Document
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDocument(
		com.maximgalushka.service.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		_documentLocalService.deleteDocument(document);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.maximgalushka.service.model.Document fetchDocument(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.fetchDocument(documentId);
	}

	/**
	* Returns the Document with the primary key.
	*
	* @param documentId the primary key of the Document
	* @return the Document
	* @throws PortalException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document getDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocument(documentId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the Document with the UUID in the group.
	*
	* @param uuid the UUID of Document
	* @param groupId the group id of the Document
	* @return the Document
	* @throws PortalException if a Document with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document getDocumentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocumentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the Documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Documents
	* @param end the upper bound of the range of Documents (not inclusive)
	* @return the range of Documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> getDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocuments(start, end);
	}

	/**
	* Returns the number of Documents.
	*
	* @return the number of Documents
	* @throws SystemException if a system exception occurred
	*/
	public int getDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocumentsCount();
	}

	/**
	* Updates the Document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param document the Document
	* @return the Document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document updateDocument(
		com.maximgalushka.service.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.updateDocument(document);
	}

	/**
	* Updates the Document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param document the Document
	* @param merge whether to merge the Document with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document updateDocument(
		com.maximgalushka.service.model.Document document, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.updateDocument(document, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _documentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_documentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.maximgalushka.service.model.Document addDocument(
		com.maximgalushka.service.model.Document document,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.addDocument(document, serviceContext);
	}

	public com.maximgalushka.service.model.Document updateStatus(long userId,
		long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.updateStatus(userId, resourcePrimKey,
			status, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DocumentLocalService getWrappedDocumentLocalService() {
		return _documentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDocumentLocalService(
		DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	public DocumentLocalService getWrappedService() {
		return _documentLocalService;
	}

	public void setWrappedService(DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	private DocumentLocalService _documentLocalService;
}