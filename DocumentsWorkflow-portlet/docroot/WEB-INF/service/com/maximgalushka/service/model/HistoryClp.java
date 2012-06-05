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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author mgalushka
 */
public class HistoryClp extends BaseModelImpl<History> implements History {
	public HistoryClp() {
	}

	public Class<?> getModelClass() {
		return History.class;
	}

	public String getModelClassName() {
		return History.class.getName();
	}

	public long getPrimaryKey() {
		return _logId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_logId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getLogId() {
		return _logId;
	}

	public void setLogId(long logId) {
		_logId = logId;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	@Override
	public History toEscapedModel() {
		return (History)Proxy.newProxyInstance(History.class.getClassLoader(),
			new Class[] { History.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HistoryClp clone = new HistoryClp();

		clone.setLogId(getLogId());
		clone.setDocumentId(getDocumentId());
		clone.setUserId(getUserId());
		clone.setStatus(getStatus());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setComment(getComment());

		return clone;
	}

	public int compareTo(History history) {
		int value = 0;

		if (getLogId() < history.getLogId()) {
			value = -1;
		}
		else if (getLogId() > history.getLogId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HistoryClp history = null;

		try {
			history = (HistoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = history.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{logId=");
		sb.append(getLogId());
		sb.append(", documentId=");
		sb.append(getDocumentId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.maximgalushka.service.model.History");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>logId</column-name><column-value><![CDATA[");
		sb.append(getLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _logId;
	private long _documentId;
	private long _userId;
	private String _userUuid;
	private String _status;
	private Date _updatedDate;
	private String _comment;
}