/**
 * Copyright (c) 2018 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.model.manager.listener.modelset;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;

/**
 * @author Yazid Benazzouz
 */
public class ResourceModelSetListenerInternal implements ResourceSetListener {

	@Override
	public NotificationFilter getFilter() {
		return null;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return null;
	}

	@Override
	public void resourceSetChanged(final ResourceSetChangeEvent event) {
		ResourceModelSetManager.getInstance().notifyListeners(event);
	}

	@Override
	public boolean isAggregatePrecommitListener() {
		return false;
	}

	@Override
	public boolean isPrecommitOnly() {
		return false;
	}

	@Override
	public boolean isPostcommitOnly() {
		return false;
	}
}
