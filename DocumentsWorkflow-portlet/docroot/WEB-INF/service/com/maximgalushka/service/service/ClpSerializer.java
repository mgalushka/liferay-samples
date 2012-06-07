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

package com.maximgalushka.service.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.maximgalushka.service.model.DocumentClp;
import com.maximgalushka.service.model.HistoryClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"DocumentsWorkflow-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"DocumentsWorkflow-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "DocumentsWorkflow-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DocumentClp.class.getName())) {
			return translateInputDocument(oldModel);
		}

		if (oldModelClassName.equals(HistoryClp.class.getName())) {
			return translateInputHistory(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDocument(BaseModel<?> oldModel) {
		DocumentClp oldCplModel = (DocumentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.maximgalushka.service.model.impl.DocumentImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setDocumentId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getDocumentId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getCompanyId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getGroupId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value5 = oldCplModel.getTitle();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setType",
						new Class[] { String.class });

				String value6 = oldCplModel.getType();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getStatus());

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputHistory(BaseModel<?> oldModel) {
		HistoryClp oldCplModel = (HistoryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.maximgalushka.service.model.impl.HistoryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLogId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getLogId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setDocumentId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getDocumentId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setStatus",
						new Class[] { String.class });

				String value3 = oldCplModel.getStatus();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUpdatedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getUpdatedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setComment",
						new Class[] { String.class });

				String value5 = oldCplModel.getComment();

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.maximgalushka.service.model.impl.DocumentImpl")) {
			return translateOutputDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.maximgalushka.service.model.impl.HistoryImpl")) {
			return translateOutputHistory(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputDocument(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DocumentClp newModel = new DocumentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getDocumentId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setDocumentId(value1);

				Method method2 = oldModelClass.getMethod("getCompanyId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value2);

				Method method3 = oldModelClass.getMethod("getGroupId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getTitle");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTitle(value5);

				Method method6 = oldModelClass.getMethod("getType");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setType(value6);

				Method method7 = oldModelClass.getMethod("getStatus");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputHistory(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				HistoryClp newModel = new HistoryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLogId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setLogId(value0);

				Method method1 = oldModelClass.getMethod("getDocumentId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setDocumentId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getStatus");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setStatus(value3);

				Method method4 = oldModelClass.getMethod("getUpdatedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setUpdatedDate(value4);

				Method method5 = oldModelClass.getMethod("getComment");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setComment(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}