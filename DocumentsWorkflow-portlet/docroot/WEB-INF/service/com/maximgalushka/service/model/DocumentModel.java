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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Document service. Represents a row in the &quot;docs_Document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.maximgalushka.service.model.impl.DocumentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.maximgalushka.service.model.impl.DocumentImpl}.
 * </p>
 *
 * @author mgalushka
 * @see Document
 * @see com.maximgalushka.service.model.impl.DocumentImpl
 * @see com.maximgalushka.service.model.impl.DocumentModelImpl
 * @generated
 */
public interface DocumentModel extends BaseModel<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a Document model instance should use the {@link Document} interface instead.
	 */

	/**
	 * Returns the primary key of this Document.
	 *
	 * @return the primary key of this Document
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this Document.
	 *
	 * @param primaryKey the primary key of this Document
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this Document.
	 *
	 * @return the uuid of this Document
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this Document.
	 *
	 * @param uuid the uuid of this Document
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the document ID of this Document.
	 *
	 * @return the document ID of this Document
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this Document.
	 *
	 * @param documentId the document ID of this Document
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the company ID of this Document.
	 *
	 * @return the company ID of this Document
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this Document.
	 *
	 * @param companyId the company ID of this Document
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this Document.
	 *
	 * @return the group ID of this Document
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this Document.
	 *
	 * @param groupId the group ID of this Document
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this Document.
	 *
	 * @return the user ID of this Document
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this Document.
	 *
	 * @param userId the user ID of this Document
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this Document.
	 *
	 * @return the user uuid of this Document
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this Document.
	 *
	 * @param userUuid the user uuid of this Document
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the title of this Document.
	 *
	 * @return the title of this Document
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this Document.
	 *
	 * @param title the title of this Document
	 */
	public void setTitle(String title);

	/**
	 * Returns the type of this Document.
	 *
	 * @return the type of this Document
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this Document.
	 *
	 * @param type the type of this Document
	 */
	public void setType(String type);

	/**
	 * Returns the status of this Document.
	 *
	 * @return the status of this Document
	 */
	public int getStatus();

	/**
	 * Sets the status of this Document.
	 *
	 * @param status the status of this Document
	 */
	public void setStatus(int status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Document document);

	public int hashCode();

	public CacheModel<Document> toCacheModel();

	public Document toEscapedModel();

	public String toString();

	public String toXmlString();
}