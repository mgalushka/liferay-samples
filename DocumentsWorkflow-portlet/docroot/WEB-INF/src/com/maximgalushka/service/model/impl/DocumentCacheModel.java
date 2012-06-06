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

import com.maximgalushka.service.model.Document;

import java.io.Serializable;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author mgalushka
 * @see Document
 * @generated
 */
public class DocumentCacheModel implements CacheModel<Document>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(documentId);
		documentImpl.setCompanyId(companyId);
		documentImpl.setUserId(userId);

		if (title == null) {
			documentImpl.setTitle(StringPool.BLANK);
		}
		else {
			documentImpl.setTitle(title);
		}

		if (type == null) {
			documentImpl.setType(StringPool.BLANK);
		}
		else {
			documentImpl.setType(type);
		}

		documentImpl.setStatus(status);

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	public long documentId;
	public long companyId;
	public long userId;
	public String title;
	public String type;
	public int status;
}