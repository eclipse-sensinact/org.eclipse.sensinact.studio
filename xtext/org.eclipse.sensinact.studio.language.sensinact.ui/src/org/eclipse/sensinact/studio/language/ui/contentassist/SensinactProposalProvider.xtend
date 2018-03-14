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
package org.eclipse.sensinact.studio.language.ui.contentassist

import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater

/**
 * @author Etienne Gandrille
 */
class SensinactProposalProvider extends AbstractSensinactProposalProvider {

	override complete_EXTENDED_ID(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {

		var rsrc = model as DSL_Resource;
		var gatewayID = rsrc.gatewayID;
		var deviceID = rsrc.deviceID;
		var serviceID = rsrc.serviceID;

		var container = ruleCall.eContainer as Assignment;
		var feature = container.feature;

		// gateway completion
		if ("gatewayID".equals(feature)) {
			var candidates = ModelEditor.getInstance().getGatewaysId;
			for (candidate : candidates) {
				acceptor.accept(createCompletionProposal(candidate + "/", context));
			}
		}

		// device completion
		if ("deviceID".equals(feature)) {
			var candidates = ModelEditor.getInstance().getDevicesId(gatewayID);
			for (candidate : candidates) {
				acceptor.accept(createCompletionProposal(candidate + "/", context));
			}
		} // service completion
		else if ("serviceID".equals(feature)) {
			// Ensure to fetch the info during the code completion
			ModelUpdater.getInstance().updateServices(gatewayID, deviceID, false);

			var candidates = ModelEditor.getInstance().getServicesId(gatewayID, deviceID);
			for (candidate : candidates) {
				acceptor.accept(createCompletionProposal(candidate + "/", context));
			}
		} // resource completion
		else if ("resourceID".equals(feature)) {
			ModelUpdater.getInstance().updateResources(gatewayID, deviceID, serviceID);
			var candidates = ModelEditor.getInstance().getResourcesId(gatewayID, deviceID, serviceID);
			for (candidate : candidates) {
				acceptor.accept(createCompletionProposal(candidate, context));
			}
		}
	}
}
