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
package org.eclipse.sensinact.studio.language.validation;

import com.google.common.base.Objects;
import java.math.BigDecimal;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_AFTER;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_BEFORE;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION_MIN;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION_SEC;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_STATEMENT;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ListParam;
import org.eclipse.sensinact.studio.language.sensinact.DSL_REF;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ResourceAction;
import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;
import org.eclipse.sensinact.studio.language.sensinact.SensinactPackage;
import org.eclipse.sensinact.studio.language.sensinact.impl.DSL_REFImpl;
import org.eclipse.sensinact.studio.language.validation.AbstractSensinactValidator;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class SensinactValidator extends AbstractSensinactValidator {
  public boolean isConnected() {
    try {
      ModelEditor _instance = ModelEditor.getInstance();
      List<String> _gatewaysId = _instance.getGatewaysId();
      int _length = ((Object[])Conversions.unwrapArray(_gatewaysId, Object.class)).length;
      return (_length != 0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Check
  public void checkGatewayIsConnected(final DSL_SENSINACT eca) {
    boolean _isConnected = this.isConnected();
    boolean _not = (!_isConnected);
    if (_not) {
      this.warning("Please connect the studio to your gateway", SensinactPackage.Literals.DSL_SENSINACT__RESOURCES);
    }
  }
  
  @Check
  public void refNameIsUnique(final DSL_REF ref) {
    int nameOccurences = 0;
    String name = ref.getName();
    EObject _eContainer = ref.eContainer();
    DSL_SENSINACT superEntity = ((DSL_SENSINACT) _eContainer);
    boolean _notEquals = (!Objects.equal(superEntity, null));
    if (_notEquals) {
      EList<DSL_Resource> _resources = superEntity.getResources();
      for (final DSL_Resource other : _resources) {
        String _name = other.getName();
        boolean _equals = name.equals(_name);
        if (_equals) {
          nameOccurences++;
        }
      }
      EList<DSL_CEP_STATEMENT> _cep = superEntity.getCep();
      for (final DSL_CEP_STATEMENT other_1 : _cep) {
        String _name_1 = other_1.getName();
        boolean _equals_1 = name.equals(_name_1);
        if (_equals_1) {
          nameOccurences++;
        }
      }
      if ((nameOccurences > 1)) {
        String _name_2 = ref.getName();
        this.error("Reference names names have to be unique", SensinactPackage.Literals.DSL_REF__NAME, _name_2);
      }
    }
  }
  
  @Check
  public void checkResourceExists(final DSL_Resource dslResource) {
    try {
      boolean _isConnected = this.isConnected();
      if (_isConnected) {
        String gatewayID = dslResource.getGatewayID();
        String deviceID = dslResource.getDeviceID();
        String serviceID = dslResource.getServiceID();
        String resourceID = dslResource.getResourceID();
        ModelEditor _instance = ModelEditor.getInstance();
        boolean _existsGateway = _instance.existsGateway(gatewayID);
        boolean _not = (!_existsGateway);
        if (_not) {
          this.warning((("The gateway " + gatewayID) + " does not exist"), 
            SensinactPackage.Literals.DSL_RESOURCE__GATEWAY_ID, "INVALID_NAME");
        } else {
          ModelEditor _instance_1 = ModelEditor.getInstance();
          boolean _existsDevice = _instance_1.existsDevice(gatewayID, deviceID);
          boolean _not_1 = (!_existsDevice);
          if (_not_1) {
            this.warning(((("The device " + deviceID) + " does not exist in gateway ") + gatewayID), 
              SensinactPackage.Literals.DSL_RESOURCE__DEVICE_ID, "INVALID_NAME");
          } else {
            ModelEditor _instance_2 = ModelEditor.getInstance();
            boolean _existsService = _instance_2.existsService(gatewayID, deviceID, serviceID);
            boolean _not_2 = (!_existsService);
            if (_not_2) {
              this.warning(((("The service " + serviceID) + " does not exist in gateway ") + gatewayID), 
                SensinactPackage.Literals.DSL_RESOURCE__SERVICE_ID, "INVALID_NAME");
            } else {
              ModelEditor _instance_3 = ModelEditor.getInstance();
              boolean _existsResource = _instance_3.existsResource(gatewayID, deviceID, serviceID, resourceID);
              boolean _not_3 = (!_existsResource);
              if (_not_3) {
                this.warning(((("The resource " + resourceID) + " does not exist in gateway ") + gatewayID), 
                  SensinactPackage.Literals.DSL_RESOURCE__RESOURCE_ID, "INVALID_NAME");
              }
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Check
  public Object checkActionAccessMethod(final DSL_ResourceAction resourceAction) {
    Object _xifexpression = null;
    boolean _isConnected = this.isConnected();
    if (_isConnected) {
      Object _xblockexpression = null;
      {
        DSL_REF ref = resourceAction.getRef();
        String _actiontype = resourceAction.getActiontype();
        AccessMethodType actionType = AccessMethodType.getByName(_actiontype);
        DSL_ListParam _listParam = resourceAction.getListParam();
        int nbParams = this.getNbParams(_listParam);
        _xblockexpression = this.checkParameters(ref, actionType, nbParams, SensinactPackage.Literals.DSL_RESOURCE_ACTION__ACTIONTYPE);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public int getNbParams(final DSL_ListParam params) {
    boolean _equals = Objects.equal(params, null);
    if (_equals) {
      return 0;
    }
    EList<DSL_Expression> _param = params.getParam();
    boolean _equals_1 = Objects.equal(_param, null);
    if (_equals_1) {
      return 0;
    }
    EList<DSL_Expression> _param_1 = params.getParam();
    return _param_1.size();
  }
  
  public Object checkParameters(final DSL_REF ref, final AccessMethodType actionType, final int nbParams, final EStructuralFeature feature) {
    try {
      Object _xifexpression = null;
      if ((ref instanceof DSL_Resource)) {
        DSL_Resource dslResource = ((DSL_Resource) ref);
        String gatewayID = dslResource.getGatewayID();
        String deviceID = dslResource.getDeviceID();
        String serviceID = dslResource.getServiceID();
        String resourceID = dslResource.getResourceID();
        ResourceDescriptor descriptor = new ResourceDescriptor(gatewayID, deviceID, serviceID, resourceID);
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(descriptor, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _notEquals_1 = (!Objects.equal(actionType, null));
          _and = _notEquals_1;
        }
        if (_and) {
          ModelEditor _instance = ModelEditor.getInstance();
          AccessMethod method = _instance.getAccessMethodWithTypeNbParams(descriptor, actionType, nbParams);
          boolean _equals = Objects.equal(method, null);
          if (_equals) {
            String msg = null;
            if ((nbParams == 0)) {
              msg = "This action type without parameters is not available for this resource";
            } else {
              if ((nbParams == 1)) {
                msg = "This action type with one parameter is not available for this resource";
              } else {
                if ((nbParams == 0)) {
                  msg = (("This action type with " + Integer.valueOf(nbParams)) + " parameters is not available for this resource");
                }
              }
            }
            this.error(msg, feature);
          }
        }
      } else {
        Object _xifexpression_1 = null;
        if ((ref instanceof DSL_CEP_STATEMENT)) {
          _xifexpression_1 = null;
        } else {
          Object _xifexpression_2 = null;
          Class<? extends DSL_REF> _class = ref.getClass();
          boolean _equals_1 = _class.equals(DSL_REFImpl.class);
          if (_equals_1) {
            _xifexpression_2 = null;
          } else {
            throw new RuntimeException("Should never happen");
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Check
  public void checkCepAfter(final DSL_CEP_AFTER operation) {
    DSL_CEP_DURATION _start = operation.getStart();
    BigDecimal start = this.timestamp(_start);
    DSL_CEP_DURATION _end = operation.getEnd();
    BigDecimal end = this.timestamp(_end);
    int _compareTo = start.compareTo(end);
    boolean _greaterEqualsThan = (_compareTo >= 0);
    if (_greaterEqualsThan) {
      String msg = "end must be after start";
      this.error(msg, SensinactPackage.Literals.DSL_CEP_AFTER__END);
    }
  }
  
  @Check
  public void checkCepBefore(final DSL_CEP_BEFORE operation) {
    DSL_CEP_DURATION _start = operation.getStart();
    BigDecimal start = this.timestamp(_start);
    DSL_CEP_DURATION _end = operation.getEnd();
    BigDecimal end = this.timestamp(_end);
    int _compareTo = start.compareTo(end);
    boolean _greaterEqualsThan = (_compareTo >= 0);
    if (_greaterEqualsThan) {
      String msg = "end must be after start";
      this.error(msg, SensinactPackage.Literals.DSL_CEP_BEFORE__END);
    }
  }
  
  public BigDecimal timestamp(final DSL_CEP_DURATION duration) {
    BigDecimal retval = BigDecimal.ZERO;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(duration, null));
    if (!_notEquals) {
      _and = false;
    } else {
      EList<EObject> _units = duration.getUnits();
      boolean _notEquals_1 = (!Objects.equal(_units, null));
      _and = _notEquals_1;
    }
    if (_and) {
      EList<EObject> _units_1 = duration.getUnits();
      for (final EObject unit : _units_1) {
        if ((unit instanceof DSL_CEP_DURATION_MIN)) {
          DSL_CEP_DURATION_MIN min = ((DSL_CEP_DURATION_MIN) unit);
          BigDecimal _min = min.getMin();
          BigDecimal _bigDecimal = new BigDecimal("60");
          BigDecimal _multiply = _min.multiply(_bigDecimal);
          BigDecimal _add = retval.add(_multiply);
          retval = _add;
        } else {
          if ((unit instanceof DSL_CEP_DURATION_SEC)) {
            DSL_CEP_DURATION_SEC sec = ((DSL_CEP_DURATION_SEC) unit);
            BigDecimal _sec = sec.getSec();
            BigDecimal _add_1 = retval.add(_sec);
            retval = _add_1;
          }
        }
      }
    }
    return retval;
  }
}
