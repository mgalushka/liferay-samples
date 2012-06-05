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

package com.maximgalushka.service.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author    mgalushka
 * @see       Document
 * @generated
 */
public class DocumentWrapper implements Document, ModelWrapper<Document> {
	public DocumentWrapper(Document document) {
		_document = document;
	}

	public Class<?> getModelClass() {
		return Document.class;
	}

	public String getModelClassName() {
		return Document.class.getName();
	}

	/**
	* Returns the primary key of this Document.
	*
	* @return the primary key of this Document
	*/
	public long getPrimaryKey() {
		return _document.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Document.
	*
	* @param primaryKey the primary key of this Document
	*/
	public void setPrimaryKey(long primaryKey) {
		_document.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document ID of this Document.
	*
	* @return the document ID of this Document
	*/
	public long getDocumentId() {
		return _document.getDocumentId();
	}

	/**
	* Sets the document ID of this Document.
	*
	* @param documentId the document ID of this Document
	*/
	public void setDocumentId(long documentId) {
		_document.setDocumentId(documentId);
	}

	/**
	* Returns the company ID of this Document.
	*
	* @return the company ID of this Document
	*/
	public long getCompanyId() {
		return _document.getCompanyId();
	}

	/**
	* Sets the company ID of this Document.
	*
	* @param companyId the company ID of this Document
	*/
	public void setCompanyId(long companyId) {
		_document.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Document.
	*
	* @return the user ID of this Document
	*/
	public long getUserId() {
		return _document.getUserId();
	}

	/**
	* Sets the user ID of this Document.
	*
	* @param userId the user ID of this Document
	*/
	public void setUserId(long userId) {
		_document.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Document.
	*
	* @return the user uuid of this Document
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document.getUserUuid();
	}

	/**
	* Sets the user uuid of this Document.
	*
	* @param userUuid the user uuid of this Document
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_document.setUserUuid(userUuid);
	}

	/**
	* Returns the title of this Document.
	*
	* @return the title of this Document
	*/
	public java.lang.String getTitle() {
		return _document.getTitle();
	}

	/**
	* Sets the title of this Document.
	*
	* @param title the title of this Document
	*/
	public void setTitle(java.lang.String title) {
		_document.setTitle(title);
	}

	/**
	* Returns the type of this Document.
	*
	* @return the type of this Document
	*/
	public java.lang.String getType() {
		return _document.getType();
	}

	/**
	* Sets the type of this Document.
	*
	* @param type the type of this Document
	*/
	public void setType(java.lang.String type) {
		_document.setType(type);
	}

	public boolean isNew() {
		return _document.isNew();
	}

	public void setNew(boolean n) {
		_document.setNew(n);
	}

	public boolean isCachedModel() {
		return _document.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_document.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _document.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _document.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_document.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _document.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_document.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentWrapper((Document)_document.clone());
	}

	public int compareTo(com.maximgalushka.service.model.Document document) {
		return _document.compareTo(document);
	}

	@Override
	public int hashCode() {
		return _document.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.maximgalushka.service.model.Document> toCacheModel() {
		return _document.toCacheModel();
	}

	public com.maximgalushka.service.model.Document toEscapedModel() {
		return new DocumentWrapper(_document.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _document.toString();
	}

	public java.lang.String toXmlString() {
		return _document.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_document.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Document getWrappedDocument() {
		return _document;
	}

	public Document getWrappedModel() {
		return _document;
	}

	public void resetOriginalValues() {
		_document.resetOriginalValues();
	}

	private Document _document;
}