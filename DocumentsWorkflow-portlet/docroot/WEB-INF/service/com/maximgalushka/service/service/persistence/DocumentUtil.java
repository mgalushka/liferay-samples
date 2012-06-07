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

import com.maximgalushka.service.model.Document;

import java.util.List;

/**
 * The persistence utility for the Document service. This utility wraps {@link DocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mgalushka
 * @see DocumentPersistence
 * @see DocumentPersistenceImpl
 * @generated
 */
public class DocumentUtil {
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
	public static void clearCache(Document document) {
		getPersistence().clearCache(document);
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
	public static List<Document> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Document update(Document document, boolean merge)
		throws SystemException {
		return getPersistence().update(document, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Document update(Document document, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(document, merge, serviceContext);
	}

	/**
	* Caches the Document in the entity cache if it is enabled.
	*
	* @param document the Document
	*/
	public static void cacheResult(
		com.maximgalushka.service.model.Document document) {
		getPersistence().cacheResult(document);
	}

	/**
	* Caches the Documents in the entity cache if it is enabled.
	*
	* @param documents the Documents
	*/
	public static void cacheResult(
		java.util.List<com.maximgalushka.service.model.Document> documents) {
		getPersistence().cacheResult(documents);
	}

	/**
	* Creates a new Document with the primary key. Does not add the Document to the database.
	*
	* @param documentId the primary key for the new Document
	* @return the new Document
	*/
	public static com.maximgalushka.service.model.Document create(
		long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	* Removes the Document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the Document
	* @return the Document that was removed
	* @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.Document remove(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().remove(documentId);
	}

	public static com.maximgalushka.service.model.Document updateImpl(
		com.maximgalushka.service.model.Document document, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(document, merge);
	}

	/**
	* Returns the Document with the primary key or throws a {@link com.maximgalushka.service.NoSuchDocumentException} if it could not be found.
	*
	* @param documentId the primary key of the Document
	* @return the Document
	* @throws com.maximgalushka.service.NoSuchDocumentException if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.Document findByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	* Returns the Document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the Document
	* @return the Document, or <code>null</code> if a Document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.Document fetchByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	* Returns all the Documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.Document> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
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
	public static java.util.List<com.maximgalushka.service.model.Document> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static java.util.List<com.maximgalushka.service.model.Document> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static com.maximgalushka.service.model.Document findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
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
	public static com.maximgalushka.service.model.Document findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
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
	public static com.maximgalushka.service.model.Document[] findByUuid_PrevAndNext(
		long documentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(documentId, uuid, orderByComparator);
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
	public static com.maximgalushka.service.model.Document findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the Document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Document, or <code>null</code> if a matching Document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.maximgalushka.service.model.Document fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
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
	public static com.maximgalushka.service.model.Document fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns all the Documents where title = &#63;.
	*
	* @param title the title
	* @return the matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title);
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
	public static java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title, start, end);
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
	public static java.util.List<com.maximgalushka.service.model.Document> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title, start, end, orderByComparator);
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
	public static com.maximgalushka.service.model.Document findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findBytitle_First(title, orderByComparator);
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
	public static com.maximgalushka.service.model.Document findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence().findBytitle_Last(title, orderByComparator);
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
	public static com.maximgalushka.service.model.Document[] findBytitle_PrevAndNext(
		long documentId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		return getPersistence()
				   .findBytitle_PrevAndNext(documentId, title, orderByComparator);
	}

	/**
	* Returns all the Documents.
	*
	* @return the Documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.maximgalushka.service.model.Document> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.maximgalushka.service.model.Document> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.maximgalushka.service.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Documents where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the Document where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.maximgalushka.service.NoSuchDocumentException {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the Documents where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytitle(title);
	}

	/**
	* Removes all the Documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of Documents where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of Documents where title = &#63;.
	*
	* @param title the title
	* @return the number of matching Documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytitle(title);
	}

	/**
	* Returns the number of Documents.
	*
	* @return the number of Documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DocumentPersistence)PortletBeanLocatorUtil.locate(com.maximgalushka.service.service.ClpSerializer.getServletContextName(),
					DocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(DocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DocumentPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DocumentUtil.class, "_persistence");
	}

	private static DocumentPersistence _persistence;
}