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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HistoryService}.
 * </p>
 *
 * @author    mgalushka
 * @see       HistoryService
 * @generated
 */
public class HistoryServiceWrapper implements HistoryService,
	ServiceWrapper<HistoryService> {
	public HistoryServiceWrapper(HistoryService historyService) {
		_historyService = historyService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HistoryService getWrappedHistoryService() {
		return _historyService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHistoryService(HistoryService historyService) {
		_historyService = historyService;
	}

	public HistoryService getWrappedService() {
		return _historyService;
	}

	public void setWrappedService(HistoryService historyService) {
		_historyService = historyService;
	}

	private HistoryService _historyService;
}