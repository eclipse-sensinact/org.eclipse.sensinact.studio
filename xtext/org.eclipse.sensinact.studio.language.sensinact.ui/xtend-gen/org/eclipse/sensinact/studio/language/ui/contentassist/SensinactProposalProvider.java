/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.language.ui.contentassist;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource;
import org.eclipse.sensinact.studio.language.ui.contentassist.AbstractSensinactProposalProvider;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Etienne Gandrille
 */
@SuppressWarnings("all")
public class SensinactProposalProvider extends AbstractSensinactProposalProvider {
  @Override
  public void complete_EXTENDED_ID(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    try {
      DSL_Resource rsrc = ((DSL_Resource) model);
      String gatewayID = rsrc.getGatewayID();
      String deviceID = rsrc.getDeviceID();
      String serviceID = rsrc.getServiceID();
      EObject _eContainer = ruleCall.eContainer();
      Assignment container = ((Assignment) _eContainer);
      String feature = container.getFeature();
      boolean _equals = "gatewayID".equals(feature);
      if (_equals) {
        ModelEditor _instance = ModelEditor.getInstance();
        List<String> candidates = _instance.getGatewaysId();
        for (final String candidate : candidates) {
          ICompletionProposal _createCompletionProposal = this.createCompletionProposal((candidate + "/"), context);
          acceptor.accept(_createCompletionProposal);
        }
      }
      boolean _equals_1 = "deviceID".equals(feature);
      if (_equals_1) {
        ModelEditor _instance_1 = ModelEditor.getInstance();
        List<String> candidates_1 = _instance_1.getDevicesId(gatewayID);
        for (final String candidate_1 : candidates_1) {
          ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal((candidate_1 + "/"), context);
          acceptor.accept(_createCompletionProposal_1);
        }
      } else {
        boolean _equals_2 = "serviceID".equals(feature);
        if (_equals_2) {
          ModelUpdater _instance_2 = ModelUpdater.getInstance();
          _instance_2.updateServices(gatewayID, deviceID);
          ModelEditor _instance_3 = ModelEditor.getInstance();
          List<String> candidates_2 = _instance_3.getServicesId(gatewayID, deviceID);
          for (final String candidate_2 : candidates_2) {
            ICompletionProposal _createCompletionProposal_2 = this.createCompletionProposal((candidate_2 + "/"), context);
            acceptor.accept(_createCompletionProposal_2);
          }
        } else {
          boolean _equals_3 = "resourceID".equals(feature);
          if (_equals_3) {
            ModelUpdater _instance_4 = ModelUpdater.getInstance();
            _instance_4.updateResources(gatewayID, deviceID, serviceID);
            ModelEditor _instance_5 = ModelEditor.getInstance();
            List<String> candidates_3 = _instance_5.getResourcesId(gatewayID, deviceID, serviceID);
            for (final String candidate_3 : candidates_3) {
              ICompletionProposal _createCompletionProposal_3 = this.createCompletionProposal(candidate_3, context);
              acceptor.accept(_createCompletionProposal_3);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
