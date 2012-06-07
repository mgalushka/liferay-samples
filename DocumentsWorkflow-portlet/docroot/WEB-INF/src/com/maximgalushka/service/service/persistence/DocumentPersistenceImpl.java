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

package com.maximgalushka.service.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import com.maximgalushka.service.NoSuchDocumentException;
import com.maximgalushka.service.model.Document;
import com.maximgalushka.service.model.impl.DocumentImpl;
import com.maximgalushka.service.model.impl.DocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see DocumentPersistence
 * @see DocumentUtil
 * @generated
 */
public class DocumentPersistenceImpl extends BasePersistenceImpl<Document>
	implements DocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentUtil} to access the Document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DocumentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DocumentModelImpl.UUID_COLUMN_BITMASK |
			DocumentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytitle",
			new String[] { String.class.getName() },
			DocumentModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Document in the entity cache if it is enabled.
	 *
	 * @param document the Document
	 */
	public void cacheResult(Document document) {
		EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { document.getUuid(), Long.valueOf(
					document.getGroupId()) }, document);

		document.resetOriginalValues();
	}

	/**
	 * Caches the Documents in the entity cache if it is enabled.
	 *
	 * @param documents the Documents
	 */
	public void cacheResult(List<Document> documents) {
		for (Document document : documents) {
			if (EntityCacheUtil.getResult(
						DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, document.getPrimaryKey()) == null) {
				cacheResult(document);
			}
			else {
				document.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Document document) {
		EntityCacheUtil.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(document);
	}

	@Override
	public void clearCache(List<Document> documents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Document document : documents) {
			EntityCacheUtil.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, document.getPrimaryKey());

			clearUniqueFindersCache(document);
		}
	}

	protected void clearUniqueFindersCache(Document document) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { document.getUuid(), Long.valueOf(
					document.getGroupId()) });
	}

	/**
	 * Creates a new Document with the primary key. Does not add the Document to the database.
	 *
	 * @param documentId the primary key for the new Document
	 * @return the new Document
	 */
	public Document create(long documentId) {
		Document document = new DocumentImpl();

		document.setNew(true);
		document.setPrimaryKey(documentId);

		String uuid = PortalUUIDUtil.generate();

		document.setUuid(uuid);

		return document;
	}

	/**
	 * Removes the Document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the Document
	 * @return the Document that was removed
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document remove(long documentId)
		throws NoSuchDocumentException, SystemException {
		return remove(Long.valueOf(documentId));
	}

	/**
	 * Removes the Document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Document
	 * @return the Document that was removed
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document remove(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Document document = (Document)session.get(DocumentImpl.class,
					primaryKey);

			if (document == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(document);
		}
		catch (NoSuchDocumentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Document removeImpl(Document document) throws SystemException {
		document = toUnwrappedModel(document);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, document);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(document);

		return document;
	}

	@Override
	public Document updateImpl(
		com.maximgalushka.service.model.Document document, boolean merge)
		throws SystemException {
		document = toUnwrappedModel(document);

		boolean isNew = document.isNew();

		DocumentModelImpl documentModelImpl = (DocumentModelImpl)document;

		if (Validator.isNull(document.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			document.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, document, merge);

			document.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((documentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { documentModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { documentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((documentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { documentModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}
		}

		EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					document.getUuid(), Long.valueOf(document.getGroupId())
				}, document);
		}
		else {
			if ((documentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentModelImpl.getOriginalUuid(),
						Long.valueOf(documentModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						document.getUuid(), Long.valueOf(document.getGroupId())
					}, document);
			}
		}

		return document;
	}

	protected Document toUnwrappedModel(Document document) {
		if (document instanceof DocumentImpl) {
			return document;
		}

		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setNew(document.isNew());
		documentImpl.setPrimaryKey(document.getPrimaryKey());

		documentImpl.setUuid(document.getUuid());
		documentImpl.setDocumentId(document.getDocumentId());
		documentImpl.setCompanyId(document.getCompanyId());
		documentImpl.setGroupId(document.getGroupId());
		documentImpl.setUserId(document.getUserId());
		documentImpl.setTitle(document.getTitle());
		documentImpl.setType(document.getType());
		documentImpl.setStatus(document.getStatus());

		return documentImpl;
	}

	/**
	 * Returns the Document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Document
	 * @return the Document
	 * @throws com.liferay.portal.NoSuchModelException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Document with the primary key or throws a {@link com.maximgalushka.service.NoSuchDocumentException} if it could not be found.
	 *
	 * @param documentId the primary key of the Document
	 * @return the Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findByPrimaryKey(long documentId)
		throws NoSuchDocumentException, SystemException {
		Document document = fetchByPrimaryKey(documentId);

		if (document == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + documentId);
			}

			throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				documentId);
		}

		return document;
	}

	/**
	 * Returns the Document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Document
	 * @return the Document, or <code>null</code> if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the Document
	 * @return the Document, or <code>null</code> if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document fetchByPrimaryKey(long documentId)
		throws SystemException {
		Document document = (Document)EntityCacheUtil.getResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, documentId);

		if (document == _nullDocument) {
			return null;
		}

		if (document == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				document = (Document)session.get(DocumentImpl.class,
						Long.valueOf(documentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (document != null) {
					cacheResult(document);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, documentId, _nullDocument);
				}

				closeSession(session);
			}
		}

		return document;
	}

	/**
	 * Returns all the Documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Documents
	 * @param end the upper bound of the range of Documents (not inclusive)
	 * @return the range of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of Documents
	 * @param end the upper bound of the range of Documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Document> list = (List<Document>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Document>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Document in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		List<Document> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDocumentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last Document in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		int count = countByUuid(uuid);

		List<Document> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDocumentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the Documents before and after the current Document in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the primary key of the current Document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document[] findByUuid_PrevAndNext(long documentId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, document, uuid,
					orderByComparator, true);

			array[1] = document;

			array[2] = getByUuid_PrevAndNext(session, document, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUuid_PrevAndNext(Session session,
		Document document, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENT_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(document);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Document> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the Document where uuid = &#63; and groupId = &#63; or throws a {@link com.maximgalushka.service.NoSuchDocumentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException, SystemException {
		Document document = fetchByUUID_G(uuid, groupId);

		if (document == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDocumentException(msg.toString());
		}

		return document;
	}

	/**
	 * Returns the Document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching Document, or <code>null</code> if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the Document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Document, or <code>null</code> if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOCUMENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(DocumentModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Document> list = q.list();

				result = list;

				Document document = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					document = list.get(0);

					cacheResult(document);

					if ((document.getUuid() == null) ||
							!document.getUuid().equals(uuid) ||
							(document.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, document);
					}
				}

				return document;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Document)result;
			}
		}
	}

	/**
	 * Returns all the Documents where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findBytitle(String title) throws SystemException {
		return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Documents where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of Documents
	 * @param end the upper bound of the range of Documents (not inclusive)
	 * @return the range of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findBytitle(String title, int start, int end)
		throws SystemException {
		return findBytitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Documents where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of Documents
	 * @param end the upper bound of the range of Documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findBytitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<Document> list = (List<Document>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<Document>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Document in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findBytitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		List<Document> list = findBytitle(title, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("title=");
			msg.append(title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDocumentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last Document in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a matching Document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document findBytitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		int count = countBytitle(title);

		List<Document> list = findBytitle(title, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("title=");
			msg.append(title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDocumentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the Documents before and after the current Document in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the primary key of the current Document
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Document
	 * @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Document[] findBytitle_PrevAndNext(long documentId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchDocumentException, SystemException {
		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getBytitle_PrevAndNext(session, document, title,
					orderByComparator, true);

			array[1] = document;

			array[2] = getBytitle_PrevAndNext(session, document, title,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getBytitle_PrevAndNext(Session session,
		Document document, String title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENT_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(document);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Document> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Documents.
	 *
	 * @return the Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Document> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Documents
	 * @param end the upper bound of the range of Documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Documents
	 * @throws SystemException if a system exception occurred
	 */
	public List<Document> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Document> list = (List<Document>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENT.concat(DocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Document document : findByUuid(uuid)) {
			remove(document);
		}
	}

	/**
	 * Removes the Document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException, SystemException {
		Document document = findByUUID_G(uuid, groupId);

		remove(document);
	}

	/**
	 * Removes all the Documents where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBytitle(String title) throws SystemException {
		for (Document document : findBytitle(title)) {
			remove(document);
		}
	}

	/**
	 * Removes all the Documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Document document : findAll()) {
			remove(document);
		}
	}

	/**
	 * Returns the number of Documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOCUMENT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Documents where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching Documents
	 * @throws SystemException if a system exception occurred
	 */
	public int countBytitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Documents.
	 *
	 * @return the number of Documents
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.maximgalushka.service.model.Document")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Document>> listenersList = new ArrayList<ModelListener<Document>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Document>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DocumentPersistence.class)
	protected DocumentPersistence documentPersistence;
	@BeanReference(type = HistoryPersistence.class)
	protected HistoryPersistence historyPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_DOCUMENT = "SELECT document FROM Document document";
	private static final String _SQL_SELECT_DOCUMENT_WHERE = "SELECT document FROM Document document WHERE ";
	private static final String _SQL_COUNT_DOCUMENT = "SELECT COUNT(document) FROM Document document";
	private static final String _SQL_COUNT_DOCUMENT_WHERE = "SELECT COUNT(document) FROM Document document WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "document.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "document.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(document.uuid IS NULL OR document.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "document.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "document.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(document.uuid IS NULL OR document.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "document.groupId = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "document.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "document.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(document.title IS NULL OR document.title = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "document.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Document exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Document exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocumentPersistenceImpl.class);
	private static Document _nullDocument = new DocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Document> toCacheModel() {
				return _nullDocumentCacheModel;
			}
		};

	private static CacheModel<Document> _nullDocumentCacheModel = new CacheModel<Document>() {
			public Document toEntityModel() {
				return _nullDocument;
			}
		};
}