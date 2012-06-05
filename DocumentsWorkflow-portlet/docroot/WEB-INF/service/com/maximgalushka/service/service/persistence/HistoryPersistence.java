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

import com.liferay.portal.service.persistence.BasePersistence;

import com.maximgalushka.service.model.History;

/**
 * The persistence interface for the History service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see HistoryPersistenceImpl
 * @see HistoryUtil
 * @generated
 */
public interface HistoryPersistence extends BasePersistence<History> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoryUtil} to access the History persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the History in the entity cache if it is enabled.
	*
	* @param history the History
	*/
	public void cacheResult(com.maximgalushka.service.model.History history);

	/**
	* Caches the Histories in the entity cache if it is enabled.
	*
	* @param histories the Histories
	*/
	public void cacheResult(
		java.util.List<com.maximgalushka.service.model.History> histories);

	/**
	* Creates a new History with the primary key. Does not add the History to the database.
	*
	* @param logId the primary key for the new History
	* @return the new History
	*/
	public com.maximgalushka.service.model.History create(long logId);

	/**
	* Removes the History with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logId the primary key of the History
	* @return the History that was removed
	* @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.History remove(long logId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

	public com.maximgalushka.service.model.History updateImpl(
		com.maximgalushka.service.model.History history, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the History with the primary key or throws a {@link com.maximgalushka.service.NoSuchHistoryException} if it could not be found.
	*
	* @param logId the primary key of the History
	* @return the History
	* @throws com.maximgalushka.service.NoSuchHistoryException if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.History findByPrimaryKey(long logId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

	/**
	* Returns the History with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logId the primary key of the History
	* @return the History, or <code>null</code> if a History with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.History fetchByPrimaryKey(long logId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Histories where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the matching Histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> findBygetDocumentHistory(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.maximgalushka.service.model.History findBygetDocumentHistory_First(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

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
	public com.maximgalushka.service.model.History findBygetDocumentHistory_Last(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

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
	public com.maximgalushka.service.model.History[] findBygetDocumentHistory_PrevAndNext(
		long logId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

	/**
	* Returns all the Histories that the user has permission to view where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the matching Histories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> filterFindBygetDocumentHistory(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.maximgalushka.service.model.History[] filterFindBygetDocumentHistory_PrevAndNext(
		long logId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchHistoryException;

	/**
	* Returns all the Histories.
	*
	* @return the Histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.History> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.History> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Histories where documentId = &#63; from the database.
	*
	* @param documentId the document ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Histories where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the number of matching Histories
	* @throws SystemException if a system exception occurred
	*/
	public int countBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Histories that the user has permission to view where documentId = &#63;.
	*
	* @param documentId the document ID
	* @return the number of matching Histories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountBygetDocumentHistory(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Histories.
	*
	* @return the number of Histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}