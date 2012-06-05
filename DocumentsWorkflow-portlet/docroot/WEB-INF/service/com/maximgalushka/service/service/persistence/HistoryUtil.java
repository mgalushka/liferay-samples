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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.maximgalushka.service.model.History;

import java.util.List;

/**
 * The persistence utility for the History service. This utility wraps {@link HistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see HistoryPersistence
 * @see HistoryPersistenceImpl
 * @generated
 */
public class HistoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(History history) {
		getPersistence().clearCache(history);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<History> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<History> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<History> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static History update(History history, boolean merge)
		throws SystemException {
		return getPersistence().update(history, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static History update(History history, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(history, merge, serviceContext);
	}

	/**
	* Caches the History in the entity cache if it is enabled.
	*
	* @param history the History
	*/
	public static void cacheResult(
		com.maximgalushka.service.model.History history) {
		getPersistence().cacheResult(history);
	}

	/**
	* Caches the Histories in the entity cache if it is enabled.
	*
	* @param histories the Histories
	*/
	public static void cacheResult(
		java.util.List<com.maximgalushka.service.model.History> histories) {
		getPersistence().cacheResult(histories);
	}

	/**
	* Creates a new History with the primary key. Does not add the History to the database.
	*
	* @param logId the primary key for the new History
	* @return the new History
	*/
	public static com.maximgalushka.service.model.History create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	* Removes the History with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logId the primary key of the History
	* @return the History that was removed
	* @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.History remove(long logId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence().remove(logId);
	}

	public static com.maximgalushka.service.model.History updateImpl(
		com.maximgalushka.service.model.History history, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(history, merge);
	}

	/**
	* Returns the History with the primary key or throws a {@link com.maximgalushka.service.NoSuchHistoryException} if it could not be found.
	*
	* @param logId the primary key of the History
	* @return the History
	* @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.History findByPrimaryKey(
		long logId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	* Returns the History with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logId the primary key of the History
	* @return the History, or <code>null</code> if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.History fetchByPrimaryKey(
		long logId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	/**
	* Returns all the Histories where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the matching Histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygetDocumentHistory(documentId);
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
	public static java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygetDocumentHistory(documentId, start, end);
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
	public static java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygetDocumentHistory(documentId, start, end,
			orderByComparator);
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
	public static com.maximgalushka.service.model.History findBygetDocumentHistory_First(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence()
				   .findBygetDocumentHistory_First(documentId, orderByComparator);
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
	public static com.maximgalushka.service.model.History findBygetDocumentHistory_Last(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence()
				   .findBygetDocumentHistory_Last(documentId, orderByComparator);
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
	public static com.maximgalushka.service.model.History[] findBygetDocumentHistory_PrevAndNext(
		long logId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence()
				   .findBygetDocumentHistory_PrevAndNext(logId, documentId,
			orderByComparator);
	}

	/**
	* Returns all the Histories that the user has permission to view where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the matching Histories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBygetDocumentHistory(documentId);
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
	public static java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBygetDocumentHistory(documentId, start, end);
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
	public static java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBygetDocumentHistory(documentId, start, end,
			orderByComparator);
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
	public static com.maximgalushka.service.model.History[] filterFindBygetDocumentHistory_PrevAndNext(
		long logId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException {
		return getPersistence()
				   .filterFindBygetDocumentHistory_PrevAndNext(logId,
			documentId, orderByComparator);
	}

	/**
	* Returns all the Histories.
	*
	* @return the Histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.History> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.maximgalushka.service.model.History> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.maximgalushka.service.model.History> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Histories where documentId = &#63; from the database.
	*
	* @param documentId the document ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygetDocumentHistory(documentId);
	}

	/**
	* Removes all the Histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Histories where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the number of matching Histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygetDocumentHistory(documentId);
	}

	/**
	* Returns the number of Histories that the user has permission to view where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the number of matching Histories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBygetDocumentHistory(documentId);
	}

	/**
	* Returns the number of Histories.
	*
	* @return the number of Histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HistoryPersistence)PortletBeanLocatorUtil.locate(com.maximgalushka.service.service.ClpSerializer.getServletContextName(),
					HistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(HistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HistoryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HistoryUtil.class, "_persistence");
	}

	private static HistoryPersistence _persistence;
}