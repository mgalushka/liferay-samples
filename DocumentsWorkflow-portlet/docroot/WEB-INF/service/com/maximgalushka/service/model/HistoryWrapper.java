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
 * This class is a wrapper for {@link History}.
 * </p>
 *
 * @author    mgalushka
 * @see       History
 * @generated
 */
public class HistoryWrapper implements History, ModelWrapper<History> {
	public HistoryWrapper(History history) {
		_history = history;
	}

	public Class<?> getModelClass() {
		return History.class;
	}

	public String getModelClassName() {
		return History.class.getName();
	}

	/**
	* Returns the primary key of this History.
	*
	* @return the primary key of this History
	*/
	public long getPrimaryKey() {
		return _history.getPrimaryKey();
	}

	/**
	* Sets the primary key of this History.
	*
	* @param primaryKey the primary key of this History
	*/
	public void setPrimaryKey(long primaryKey) {
		_history.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the log ID of this History.
	*
	* @return the log ID of this History
	*/
	public long getLogId() {
		return _history.getLogId();
	}

	/**
	* Sets the log ID of this History.
	*
	* @param logId the log ID of this History
	*/
	public void setLogId(long logId) {
		_history.setLogId(logId);
	}

	/**
	* Returns the document ID of this History.
	*
	* @return the document ID of this History
	*/
	public long getDocumentId() {
		return _history.getDocumentId();
	}

	/**
	* Sets the document ID of this History.
	*
	* @param documentId the document ID of this History
	*/
	public void setDocumentId(long documentId) {
		_history.setDocumentId(documentId);
	}

	/**
	* Returns the user ID of this History.
	*
	* @return the user ID of this History
	*/
	public long getUserId() {
		return _history.getUserId();
	}

	/**
	* Sets the user ID of this History.
	*
	* @param userId the user ID of this History
	*/
	public void setUserId(long userId) {
		_history.setUserId(userId);
	}

	/**
	* Returns the user uuid of this History.
	*
	* @return the user uuid of this History
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _history.getUserUuid();
	}

	/**
	* Sets the user uuid of this History.
	*
	* @param userUuid the user uuid of this History
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_history.setUserUuid(userUuid);
	}

	/**
	* Returns the status of this History.
	*
	* @return the status of this History
	*/
	public java.lang.String getStatus() {
		return _history.getStatus();
	}

	/**
	* Sets the status of this History.
	*
	* @param status the status of this History
	*/
	public void setStatus(java.lang.String status) {
		_history.setStatus(status);
	}

	/**
	* Returns the updated date of this History.
	*
	* @return the updated date of this History
	*/
	public java.util.Date getUpdatedDate() {
		return _history.getUpdatedDate();
	}

	/**
	* Sets the updated date of this History.
	*
	* @param updatedDate the updated date of this History
	*/
	public void setUpdatedDate(java.util.Date updatedDate) {
		_history.setUpdatedDate(updatedDate);
	}

	/**
	* Returns the comment of this History.
	*
	* @return the comment of this History
	*/
	public java.lang.String getComment() {
		return _history.getComment();
	}

	/**
	* Sets the comment of this History.
	*
	* @param comment the comment of this History
	*/
	public void setComment(java.lang.String comment) {
		_history.setComment(comment);
	}

	public boolean isNew() {
		return _history.isNew();
	}

	public void setNew(boolean n) {
		_history.setNew(n);
	}

	public boolean isCachedModel() {
		return _history.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_history.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _history.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _history.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_history.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _history.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_history.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryWrapper((History)_history.clone());
	}

	public int compareTo(com.maximgalushka.service.model.History history) {
		return _history.compareTo(history);
	}

	@Override
	public int hashCode() {
		return _history.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.maximgalushka.service.model.History> toCacheModel() {
		return _history.toCacheModel();
	}

	public com.maximgalushka.service.model.History toEscapedModel() {
		return new HistoryWrapper(_history.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _history.toString();
	}

	public java.lang.String toXmlString() {
		return _history.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public History getWrappedHistory() {
		return _history;
	}

	public History getWrappedModel() {
		return _history;
	}

	public void resetOriginalValues() {
		_history.resetOriginalValues();
	}

	private History _history;
}