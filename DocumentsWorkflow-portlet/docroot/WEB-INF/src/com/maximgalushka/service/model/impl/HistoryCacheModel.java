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

package com.maximgalushka.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.maximgalushka.service.model.History;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing History in entity cache.
 *
 * @author mgalushka
 * @see History
 * @generated
 */
public class HistoryCacheModel implements CacheModel<History>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{logId=");
		sb.append(logId);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	public History toEntityModel() {
		HistoryImpl historyImpl = new HistoryImpl();

		historyImpl.setLogId(logId);
		historyImpl.setDocumentId(documentId);
		historyImpl.setUserId(userId);

		if (status == null) {
			historyImpl.setStatus(StringPool.BLANK);
		}
		else {
			historyImpl.setStatus(status);
		}

		if (updatedDate == Long.MIN_VALUE) {
			historyImpl.setUpdatedDate(null);
		}
		else {
			historyImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (comment == null) {
			historyImpl.setComment(StringPool.BLANK);
		}
		else {
			historyImpl.setComment(comment);
		}

		historyImpl.resetOriginalValues();

		return historyImpl;
	}

	public long logId;
	public long documentId;
	public long userId;
	public String status;
	public long updatedDate;
	public String comment;
}