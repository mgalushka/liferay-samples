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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.maximgalushka.service.NoSuchHistoryException;
import com.maximgalushka.service.model.History;
import com.maximgalushka.service.model.impl.HistoryImpl;
import com.maximgalushka.service.model.impl.HistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the History service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see HistoryPersistence
 * @see HistoryUtil
 * @generated
 */
public class HistoryPersistenceImpl extends BasePersistenceImpl<History>
	implements HistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistoryUtil} to access the History persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETDOCUMENTHISTORY =
		new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetDocumentHistory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETDOCUMENTHISTORY =
		new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygetDocumentHistory", new String[] { Long.class.getName() },
			HistoryModelImpl.DOCUMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETDOCUMENTHISTORY = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetDocumentHistory", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the History in the entity cache if it is enabled.
	 *
	 * @param history the History
	 */
	public void cacheResult(History history) {
		EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey(), history);

		history.resetOriginalValues();
	}

	/**
	 * Caches the Histories in the entity cache if it is enabled.
	 *
	 * @param histories the Histories
	 */
	public void cacheResult(List<History> histories) {
		for (History history : histories) {
			if (EntityCacheUtil.getResult(
						HistoryModelImpl.ENTITY_CACHE_ENABLED,
						HistoryImpl.class, history.getPrimaryKey()) == null) {
				cacheResult(history);
			}
			else {
				history.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the History.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(History history) {
		EntityCacheUtil.removeResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<History> histories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (History history : histories) {
			EntityCacheUtil.removeResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
				HistoryImpl.class, history.getPrimaryKey());
		}
	}

	/**
	 * Creates a new History with the primary key. Does not add the History to the database.
	 *
	 * @param logId the primary key for the new History
	 * @return the new History
	 */
	public History create(long logId) {
		History history = new HistoryImpl();

		history.setNew(true);
		history.setPrimaryKey(logId);

		return history;
	}

	/**
	 * Removes the History with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the History
	 * @return the History that was removed
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History remove(long logId)
		throws NoSuchHistoryException, SystemException {
		return remove(Long.valueOf(logId));
	}

	/**
	 * Removes the History with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the History
	 * @return the History that was removed
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History remove(Serializable primaryKey)
		throws NoSuchHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			History history = (History)session.get(HistoryImpl.class, primaryKey);

			if (history == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(history);
		}
		catch (NoSuchHistoryException nsee) {
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
	protected History removeImpl(History history) throws SystemException {
		history = toUnwrappedModel(history);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, history);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(history);

		return history;
	}

	@Override
	public History updateImpl(com.maximgalushka.service.model.History history,
		boolean merge) throws SystemException {
		history = toUnwrappedModel(history);

		boolean isNew = history.isNew();

		HistoryModelImpl historyModelImpl = (HistoryModelImpl)history;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, history, merge);

			history.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((historyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETDOCUMENTHISTORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(historyModelImpl.getOriginalDocumentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETDOCUMENTHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETDOCUMENTHISTORY,
					args);

				args = new Object[] {
						Long.valueOf(historyModelImpl.getDocumentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETDOCUMENTHISTORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETDOCUMENTHISTORY,
					args);
			}
		}

		EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
			HistoryImpl.class, history.getPrimaryKey(), history);

		return history;
	}

	protected History toUnwrappedModel(History history) {
		if (history instanceof HistoryImpl) {
			return history;
		}

		HistoryImpl historyImpl = new HistoryImpl();

		historyImpl.setNew(history.isNew());
		historyImpl.setPrimaryKey(history.getPrimaryKey());

		historyImpl.setLogId(history.getLogId());
		historyImpl.setDocumentId(history.getDocumentId());
		historyImpl.setUserId(history.getUserId());
		historyImpl.setStatus(history.getStatus());
		historyImpl.setUpdatedDate(history.getUpdatedDate());
		historyImpl.setComment(history.getComment());

		return historyImpl;
	}

	/**
	 * Returns the History with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the History
	 * @return the History
	 * @throws com.liferay.portal.NoSuchModelException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the History with the primary key or throws a {@link com.maximgalushka.service.NoSuchHistoryException} if it could not be found.
	 *
	 * @param logId the primary key of the History
	 * @return the History
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History findByPrimaryKey(long logId)
		throws NoSuchHistoryException, SystemException {
		History history = fetchByPrimaryKey(logId);

		if (history == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + logId);
			}

			throw new NoSuchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				logId);
		}

		return history;
	}

	/**
	 * Returns the History with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the History
	 * @return the History, or <code>null</code> if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the History with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the History
	 * @return the History, or <code>null</code> if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History fetchByPrimaryKey(long logId) throws SystemException {
		History history = (History)EntityCacheUtil.getResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
				HistoryImpl.class, logId);

		if (history == _nullHistory) {
			return null;
		}

		if (history == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				history = (History)session.get(HistoryImpl.class,
						Long.valueOf(logId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (history != null) {
					cacheResult(history);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HistoryModelImpl.ENTITY_CACHE_ENABLED,
						HistoryImpl.class, logId, _nullHistory);
				}

				closeSession(session);
			}
		}

		return history;
	}

	/**
	 * Returns all the Histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findBygetDocumentHistory(long documentId)
		throws SystemException {
		return findBygetDocumentHistory(documentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Histories where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @return the range of matching Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findBygetDocumentHistory(long documentId, int start,
		int end) throws SystemException {
		return findBygetDocumentHistory(documentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Histories where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findBygetDocumentHistory(long documentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETDOCUMENTHISTORY;
			finderArgs = new Object[] { documentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETDOCUMENTHISTORY;
			finderArgs = new Object[] { documentId, start, end, orderByComparator };
		}

		List<History> list = (List<History>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_HISTORY_WHERE);

			query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentId);

				list = (List<History>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first History in the ordered set where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching History
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a matching History could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History findBygetDocumentHistory_First(long documentId,
		OrderByComparator orderByComparator)
		throws NoSuchHistoryException, SystemException {
		List<History> list = findBygetDocumentHistory(documentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentId=");
			msg.append(documentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHistoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last History in the ordered set where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching History
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a matching History could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History findBygetDocumentHistory_Last(long documentId,
		OrderByComparator orderByComparator)
		throws NoSuchHistoryException, SystemException {
		int count = countBygetDocumentHistory(documentId);

		List<History> list = findBygetDocumentHistory(documentId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentId=");
			msg.append(documentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHistoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the Histories before and after the current History in the ordered set where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param logId the primary key of the current History
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next History
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History[] findBygetDocumentHistory_PrevAndNext(long logId,
		long documentId, OrderByComparator orderByComparator)
		throws NoSuchHistoryException, SystemException {
		History history = findByPrimaryKey(logId);

		Session session = null;

		try {
			session = openSession();

			History[] array = new HistoryImpl[3];

			array[0] = getBygetDocumentHistory_PrevAndNext(session, history,
					documentId, orderByComparator, true);

			array[1] = history;

			array[2] = getBygetDocumentHistory_PrevAndNext(session, history,
					documentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected History getBygetDocumentHistory_PrevAndNext(Session session,
		History history, long documentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HISTORY_WHERE);

		query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

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
			query.append(HistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(history);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Histories that the user has permission to view where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching Histories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> filterFindBygetDocumentHistory(long documentId)
		throws SystemException {
		return filterFindBygetDocumentHistory(documentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Histories that the user has permission to view where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @return the range of matching Histories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> filterFindBygetDocumentHistory(long documentId,
		int start, int end) throws SystemException {
		return filterFindBygetDocumentHistory(documentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Histories that the user has permissions to view where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Histories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> filterFindBygetDocumentHistory(long documentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBygetDocumentHistory(documentId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_HISTORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(HistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(HistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				History.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, HistoryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, HistoryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(documentId);

			return (List<History>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the Histories before and after the current History in the ordered set of Histories that the user has permission to view where documentId = &#63;.
	 *
	 * @param logId the primary key of the current History
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next History
	 * @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public History[] filterFindBygetDocumentHistory_PrevAndNext(long logId,
		long documentId, OrderByComparator orderByComparator)
		throws NoSuchHistoryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBygetDocumentHistory_PrevAndNext(logId, documentId,
				orderByComparator);
		}

		History history = findByPrimaryKey(logId);

		Session session = null;

		try {
			session = openSession();

			History[] array = new HistoryImpl[3];

			array[0] = filterGetBygetDocumentHistory_PrevAndNext(session,
					history, documentId, orderByComparator, true);

			array[1] = history;

			array[2] = filterGetBygetDocumentHistory_PrevAndNext(session,
					history, documentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected History filterGetBygetDocumentHistory_PrevAndNext(
		Session session, History history, long documentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_HISTORY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(HistoryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(HistoryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				History.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, HistoryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, HistoryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(history);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Histories.
	 *
	 * @return the Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @return the range of Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Histories
	 * @param end the upper bound of the range of Histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<History> findAll(int start, int end,
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

		List<History> list = (List<History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORY.concat(HistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<History>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<History>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Histories where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBygetDocumentHistory(long documentId)
		throws SystemException {
		for (History history : findBygetDocumentHistory(documentId)) {
			remove(history);
		}
	}

	/**
	 * Removes all the Histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (History history : findAll()) {
			remove(history);
		}
	}

	/**
	 * Returns the number of Histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching Histories
	 * @throws SystemException if a system exception occurred
	 */
	public int countBygetDocumentHistory(long documentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { documentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GETDOCUMENTHISTORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HISTORY_WHERE);

			query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GETDOCUMENTHISTORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Histories that the user has permission to view where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching Histories that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountBygetDocumentHistory(long documentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countBygetDocumentHistory(documentId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_HISTORY_WHERE);

		query.append(_FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				History.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(documentId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of Histories.
	 *
	 * @return the number of Histories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HISTORY);

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
	 * Initializes the History persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.maximgalushka.service.model.History")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<History>> listenersList = new ArrayList<ModelListener<History>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<History>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistoryImpl.class.getName());
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
	private static final String _SQL_SELECT_HISTORY = "SELECT history FROM History history";
	private static final String _SQL_SELECT_HISTORY_WHERE = "SELECT history FROM History history WHERE ";
	private static final String _SQL_COUNT_HISTORY = "SELECT COUNT(history) FROM History history";
	private static final String _SQL_COUNT_HISTORY_WHERE = "SELECT COUNT(history) FROM History history WHERE ";
	private static final String _FINDER_COLUMN_GETDOCUMENTHISTORY_DOCUMENTID_2 = "history.documentId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "history.logId";
	private static final String _FILTER_SQL_SELECT_HISTORY_WHERE = "SELECT DISTINCT {history.*} FROM docs_History history WHERE ";
	private static final String _FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {docs_History.*} FROM (SELECT DISTINCT history.logId FROM docs_History history WHERE ";
	private static final String _FILTER_SQL_SELECT_HISTORY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN docs_History ON TEMP_TABLE.logId = docs_History.logId";
	private static final String _FILTER_SQL_COUNT_HISTORY_WHERE = "SELECT COUNT(DISTINCT history.logId) AS COUNT_VALUE FROM docs_History history WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "history";
	private static final String _FILTER_ENTITY_TABLE = "docs_History";
	private static final String _ORDER_BY_ENTITY_ALIAS = "history.";
	private static final String _ORDER_BY_ENTITY_TABLE = "docs_History.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No History exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No History exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistoryPersistenceImpl.class);
	private static History _nullHistory = new HistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<History> toCacheModel() {
				return _nullHistoryCacheModel;
			}
		};

	private static CacheModel<History> _nullHistoryCacheModel = new CacheModel<History>() {
			public History toEntityModel() {
				return _nullHistory;
			}
		};
}