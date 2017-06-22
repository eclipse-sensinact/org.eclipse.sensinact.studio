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
package org.eclipse.sensinact.studio.language.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sensinact.studio.language.scoping.AbstractSensinactScopeProvider;
import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;

/**
 * Filer elements to "stay" in the current file.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class SensinactScopeProvider extends AbstractSensinactScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _scope = super.getScope(context, reference);
    return new FilteringScope(_scope, new Predicate<IEObjectDescription>() {
      @Override
      public boolean apply(final IEObjectDescription input) {
        EObject _eObjectOrProxy = input.getEObjectOrProxy();
        DSL_SENSINACT curECA = SensinactScopeProvider.this.getEca(_eObjectOrProxy);
        DSL_SENSINACT contextEca = SensinactScopeProvider.this.getEca(context);
        return Objects.equal(curECA, contextEca);
      }
    });
  }
  
  public DSL_SENSINACT getEca(final EObject object) {
    boolean _equals = Objects.equal(object, null);
    if (_equals) {
      return null;
    }
    if ((object instanceof DSL_SENSINACT)) {
      return ((DSL_SENSINACT) object);
    }
    EObject _eContainer = object.eContainer();
    return this.getEca(_eContainer);
  }
}
