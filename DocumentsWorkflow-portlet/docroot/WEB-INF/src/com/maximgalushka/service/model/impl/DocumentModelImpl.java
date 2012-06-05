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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.model.DocumentModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the Document service. Represents a row in the &quot;docs_Document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.maximgalushka.service.model.DocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentImpl}.
 * </p>
 *
 * @author mgalushka
 * @see DocumentImpl
 * @see com.maximgalushka.service.model.Document
 * @see com.maximgalushka.service.model.DocumentModel
 * @generated
 */
public class DocumentModelImpl extends BaseModelImpl<Document>
	implements DocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Document model instance should use the {@link com.maximgalushka.service.model.Document} interface instead.
	 */
	public static final String TABLE_NAME = "docs_Document";
	public static final Object[][] TABLE_COLUMNS = {
			{ "documentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "type_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table docs_Document (documentId LONG not null primary key,companyId LONG,userId LONG,title VARCHAR(75) null,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table docs_Document";
	public static final String ORDER_BY_JPQL = " ORDER BY document.documentId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY docs_Document.documentId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.maximgalushka.service.model.Document"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.maximgalushka.service.model.Document"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.maximgalushka.service.model.Document"),
			true);
	public static long TITLE_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.maximgalushka.service.model.Document"));

	public DocumentModelImpl() {
	}

	public long getPrimaryKey() {
		return _documentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDocumentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_documentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Document.class;
	}

	public String getModelClassName() {
		return Document.class.getName();
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_columnBitmask = -1L;

		_documentId = documentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_type = type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Document toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Document)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Document.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(getDocumentId());
		documentImpl.setCompanyId(getCompanyId());
		documentImpl.setUserId(getUserId());
		documentImpl.setTitle(getTitle());
		documentImpl.setType(getType());

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	public int compareTo(Document document) {
		int value = 0;

		if (getDocumentId() < document.getDocumentId()) {
			value = -1;
		}
		else if (getDocumentId() > document.getDocumentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		Document document = null;

		try {
			document = (Document)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = document.getPrimaryKey();

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
	public void resetOriginalValues() {
		DocumentModelImpl documentModelImpl = this;

		documentModelImpl._originalTitle = documentModelImpl._title;

		documentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Document> toCacheModel() {
		DocumentCacheModel documentCacheModel = new DocumentCacheModel();

		documentCacheModel.documentId = getDocumentId();

		documentCacheModel.companyId = getCompanyId();

		documentCacheModel.userId = getUserId();

		documentCacheModel.title = getTitle();

		String title = documentCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			documentCacheModel.title = null;
		}

		documentCacheModel.type = getType();

		String type = documentCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			documentCacheModel.type = null;
		}

		return documentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{documentId=");
		sb.append(getDocumentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.maximgalushka.service.model.Document");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Document.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Document.class
		};
	private long _documentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _title;
	private String _originalTitle;
	private String _type;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Document _escapedModelProxy;
}