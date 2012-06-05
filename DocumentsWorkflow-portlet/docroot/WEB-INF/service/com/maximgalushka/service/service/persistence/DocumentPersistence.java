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

import com.maximgalushka.service.model.Document;

/**
 * The persistence interface for the Document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see DocumentPersistenceImpl
 * @see DocumentUtil
 * @generated
 */
public interface DocumentPersistence extends BasePersistence<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUtil} to access the Document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Document in the entity cache if it is enabled.
	*
	* @param document the Document
	*/
	public void cacheResult(com.maximgalushka.service.model.Document document);

	/**
	* Caches the Documents in the entity cache if it is enabled.
	*
	* @param documents the Documents
	*/
	public void cacheResult(
		java.util.List<com.maximgalushka.service.model.Document> documents);

	/**
	* Creates a new Document with the primary key. Does not add the Document to the database.
	*
	* @param documentId the primary key for the new Document
	* @return the new Document
	*/
	public com.maximgalushka.service.model.Document create(long documentId);

	/**
	* Removes the Document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the Document
	* @return the Document that was removed
	* @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document remove(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

	public com.maximgalushka.service.model.Document updateImpl(
		com.maximgalushka.service.model.Document document, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Document with the primary key or throws a {@link com.maximgalushka.service.NoSuchDocumentException} if it could not be found.
	*
	* @param documentId the primary key of the Document
	* @return the Document
	* @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document findByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

	/**
	* Returns the Document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the Document
	* @return the Document, or <code>null</code> if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document fetchByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Documents where title = &#63;.
	*
	* @param title the title
	* @return the matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.maximgalushka.service.model.Document findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

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
	public com.maximgalushka.service.model.Document findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

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
	public com.maximgalushka.service.model.Document[] findBytitle_PrevAndNext(
		long documentId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

	/**
	* Returns all the Documents that the user has permission to view where title = &#63;.
	*
	* @param title the title
	* @return the matching Documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> filterFindBytitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Documents that the user has permission to view where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of Documents
	* @param end the upper bound of the range of Documents (not inclusive)
	* @return the range of matching Documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> filterFindBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Documents that the user has permissions to view where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of Documents
	* @param end the upper bound of the range of Documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> filterFindBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Documents before and after the current Document in the ordered set of Documents that the user has permission to view where title = &#63;.
	*
	* @param documentId the primary key of the current Document
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Document
	* @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.maximgalushka.service.model.Document[] filterFindBytitle_PrevAndNext(
		long documentId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException;

	/**
	* Returns all the Documents.
	*
	* @return the Documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.maximgalushka.service.model.Document> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.Document> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.maximgalushka.service.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Documents where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Documents where title = &#63;.
	*
	* @param title the title
	* @return the number of matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public int countBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Documents that the user has permission to view where title = &#63;.
	*
	* @param title the title
	* @return the number of matching Documents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Documents.
	*
	* @return the number of Documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}