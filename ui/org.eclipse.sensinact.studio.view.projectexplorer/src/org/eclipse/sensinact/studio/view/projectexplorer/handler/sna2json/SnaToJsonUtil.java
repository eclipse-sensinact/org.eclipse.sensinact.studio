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
package org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.view.projectexplorer.handler.SnaParsingResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_AFTER;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_AVG;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_BEFORE;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COINCIDE;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COUNT;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION_MIN;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_DURATION_SEC;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_MAX;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_MIN;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_STATEMENT;
import org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_SUM;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ECA_STATEMENT;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ElseDo;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ElseIfDo;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_And;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Diff;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Division;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Equal;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Larger;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Larger_Equal;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Minus;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Modulo;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Multiplication;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Negate;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Or;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Plus;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Smaller;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Expression_Smaller_Equal;
import org.eclipse.sensinact.studio.language.sensinact.DSL_IfDo;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Object_Boolean;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Object_Number;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Object_Ref;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Object_String;
import org.eclipse.sensinact.studio.language.sensinact.DSL_REF;
import org.eclipse.sensinact.studio.language.sensinact.DSL_REF_CONDITION;
import org.eclipse.sensinact.studio.language.sensinact.DSL_ResourceAction;
import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;

/**
 * Converts a SNA file into a JSON one packed into a SnaParsingResult object.
 * 
 * This class offers a single entry point : the static public method
 * parseSnaFile.
 * @author Etienne Gandrille
 */
public abstract class SnaToJsonUtil {

	/** The logger */
	private static final Logger logger = Logger.getLogger(SnaToJsonUtil.class);

	/**
	 * Converts a SNA file into a JSON one packed into a SnaParsingResult
	 * object.
	 * 
	 * @param fileModel
	 *            the file model
	 * @param fileName
	 *            the file name
	 * @return A JSON packed into a SnaParsingResult object
	 * @throws JSONException
	 */
	public static SnaParsingResult parseSnaFile(DSL_SENSINACT fileModel, String fileName) throws JSONException {

		JSONArray components = new JSONArray();
		JSONObject initialize = new JSONObject();
		JSONObject finalize = new JSONObject();
		
		ResourcesDeclarationManager resMgr = new ResourcesDeclarationManager(fileModel.getResources());
		
		// initialize : autostart
		setupInitializeOptions(fileModel, initialize);
		
		// set up file structure
		JSONObject root = initFileStructure(fileName, components, initialize, finalize);

		// CEP
		for (DSL_CEP_STATEMENT cep : fileModel.getCep()) {
			components.put(parseCepStatement(resMgr, cep));
		}

		// On
		List<DSL_REF> triggers = new ArrayList<>();
		for (DSL_REF_CONDITION triger : fileModel.getOn().getTriggers()) {
			triggers.add(triger.getRef());
		}

		// If ... do ... else if ... do ... else do ... endif
		DSL_ECA_STATEMENT eca = fileModel.getEca();
		parseEcaStatement(fileName, resMgr, eca, components, triggers);

		return new SnaParsingResult(root);
	}

	private static void setupInitializeOptions(DSL_SENSINACT fileModel, JSONObject initialize) throws JSONException {
		
		boolean autostart = true; // default value
		if (fileModel.getAutostart() != null)
			autostart = fileModel.getAutostart().isActivated();
		
		JSONObject object = new JSONObject();
		object.put("autostart", autostart);
		initialize.put("options", object);
	}

	/**
	 * Parse an ECA statement and updates the JSON component array.
	 * 
	 * @param eca
	 * @param components 
	 * @param triggers
	 * @throws JSONException
	 */
	private static void parseEcaStatement(String fileName, ResourcesDeclarationManager resMgr, DSL_ECA_STATEMENT eca, JSONArray components, List<DSL_REF> triggers) throws JSONException {
		
		VariableGenerator var = VariableGenerator.get(fileName, "condition");
		
		// if ...
		try {
			DSL_Expression expre = eca.getIfdo().getCondition();
			EventManager eventManager = new IfEventManager(resMgr, triggers);
			parseExpression(fileName, components, expre, triggers, eventManager, resMgr, var.newVariable());
		} catch (JSONException e) {
			logger.error("condition parsing error", e);
		}

		// do ...
		DSL_IfDo ifDo = eca.getIfdo();
		if (ifDo != null && ifDo.getActions() != null && ifDo.getActions().getActionList() != null) {
			EList<DSL_ResourceAction> actionsTrue = ifDo.getActions().getActionList();
			parseConditionalActions(fileName, resMgr, components, var.curVariable(), true, actionsTrue);
		}

		// else if ... do ...
		EList<DSL_ElseIfDo> elseIfDoList = eca.getElseIfdo();
		if (elseIfDoList != null) {
			
			for (DSL_ElseIfDo elseIfDo : elseIfDoList) {
		
				// else if ...
				try {
					DSL_Expression expre = elseIfDo.getCondition();
					EventManager eventManager = new BooleanVariableEventManager(var.curVariable(), false);
					parseExpression(fileName, components, expre, null, eventManager, resMgr, var.newVariable());
				} catch (JSONException e) {
					logger.error("condition parsing error", e);
				}

				// do ...
				if (elseIfDo.getActions() != null && elseIfDo.getActions().getActionList() != null) {
					EList<DSL_ResourceAction> actionsTrue = elseIfDo.getActions().getActionList();
					parseConditionalActions(fileName, resMgr, components, var.curVariable(), true, actionsTrue);
				}
			}
		}
		
		// else do ...
		DSL_ElseDo elseDo = eca.getElsedo();
		if (elseDo != null && elseDo.getActions() != null && elseDo.getActions().getActionList() != null) {
			EList<DSL_ResourceAction> actionsFalse = elseDo.getActions().getActionList();
			parseConditionalActions(fileName, resMgr, components, var.curVariable(), false, actionsFalse);
		}
	}

	/**
	 * Creates a JSON skeleton.
	 * 
	 * @param fileName
	 *            the file name
	 * @param components
	 *            a components array
	 * @param finalize
	 *            a finalize statement array
	 * @return the JSON skeleton
	 */
	private static JSONObject initFileStructure(String fileName, JSONArray components, JSONObject initialize, JSONObject finalize) {
		try {
			JSONObject root = new JSONObject();

			JSONArray parameters = new JSONArray();
			root.put("parameters", parameters);

			JSONObject info = JsonUtil.createNameTypeValue("name", String.class.getName(), fileName);
			parameters.put(info);

			JSONObject contentValue = new JSONObject();
			JSONObject content = JsonUtil.createNameTypeValue("content", JSONObject.class.getName(), contentValue);
			parameters.put(content);

			// initialize
			contentValue.put("initialize", initialize);

			// application
			contentValue.put("application", components);

			// finalize
			contentValue.put("finalize", finalize);

			return root;
		} catch (JSONException e) {
			logger.error("JSON init failed", e);
			throw new RuntimeException("JSON init failed", e);
		}
	}

	/**
	 * Creates a JSON component representing a CEP statement. This component is
	 * triggered by the function parameters and the output is the variable name.
	 * 
	 * @param statement
	 *            a cep statement
	 * @return a JSON component
	 */
	private static JSONObject parseCepStatement(ResourcesDeclarationManager resMgr, DSL_CEP_STATEMENT statement) {
		try {
			String variableName = statement.getName();
			EObject operation = statement.getOperation();

			if (operation instanceof DSL_CEP_AFTER) {
				DSL_CEP_AFTER after = (DSL_CEP_AFTER) operation;

				DSL_REF ref1 = after.getRef1().getRef();
				DSL_REF ref2 = after.getRef2().getRef();
				String start = buildDurationString(after.getStart());
				String end = buildDurationString(after.getEnd());

				ComponentBuilder cb = new ComponentBuilder("after", variableName, true, null, resMgr);
				cb.event(ref1).event(ref2);
				DSL_REF[] events = { ref1, ref2 };
				cb.parameterEvents(events).parameter(start).parameter(end);

				return cb.build();

			} else if (operation instanceof DSL_CEP_BEFORE) {
				DSL_CEP_BEFORE before = (DSL_CEP_BEFORE) operation;

				DSL_REF ref1 = before.getRef1().getRef();
				DSL_REF ref2 = before.getRef2().getRef();
				String start = buildDurationString(before.getStart());
				String end = buildDurationString(before.getEnd());

				ComponentBuilder cb = new ComponentBuilder("before", variableName, true, null, resMgr);
				cb.event(ref1).event(ref2);
				DSL_REF[] events = { ref1, ref2 };
				cb.parameterEvents(events).parameter(start).parameter(end);

				return cb.build();

			} else if (operation instanceof DSL_CEP_COINCIDE) {
				DSL_CEP_COINCIDE coincide = (DSL_CEP_COINCIDE) operation;

				DSL_REF ref1 = coincide.getRef1().getRef();
				DSL_REF ref2 = coincide.getRef2().getRef();
				String window = buildDurationString(coincide.getWindow());

				ComponentBuilder cb = new ComponentBuilder("coincides", variableName, true, null, resMgr);
				cb.event(ref1).event(ref2);
				DSL_REF[] events = { ref1, ref2 };
				cb.parameterEvents(events).parameter(window);

				return cb.build();

			} else if (operation instanceof DSL_CEP_MIN) {
				DSL_CEP_MIN min = (DSL_CEP_MIN) operation;

				DSL_REF ref = min.getRef().getRef();
				String window = buildDurationString(min.getWindow());

				ComponentBuilder cb = new ComponentBuilder("min", variableName, true, null, resMgr);
				cb.event(ref);
				cb.parameterEvent(ref).parameter(window);

				return cb.build();

			} else if (operation instanceof DSL_CEP_MAX) {
				DSL_CEP_MAX max = (DSL_CEP_MAX) operation;

				DSL_REF ref = max.getRef().getRef();
				String window = buildDurationString(max.getWindow());

				ComponentBuilder cb = new ComponentBuilder("max", variableName, true, null, resMgr);
				cb.event(ref);
				cb.parameterEvent(ref).parameter(window);

				return cb.build();

			} else if (operation instanceof DSL_CEP_AVG) {
				DSL_CEP_AVG avg = (DSL_CEP_AVG) operation;

				DSL_REF ref = avg.getRef().getRef();
				String window = buildDurationString(avg.getWindow());

				ComponentBuilder cb = new ComponentBuilder("avg", variableName, true, null, resMgr);
				cb.event(ref);
				cb.parameterEvent(ref).parameter(window);

				return cb.build();

			} else if (operation instanceof DSL_CEP_SUM) {
				DSL_CEP_SUM sum = (DSL_CEP_SUM) operation;

				DSL_REF ref = sum.getRef().getRef();
				String window = buildDurationString(sum.getWindow());

				ComponentBuilder cb = new ComponentBuilder("sum", variableName, true, null, resMgr);
				cb.event(ref);
				cb.parameterEvent(ref).parameter(window);

				return cb.build();

			} else if (operation instanceof DSL_CEP_COUNT) {
				DSL_CEP_COUNT count = (DSL_CEP_COUNT) operation;

				DSL_REF ref = count.getRef().getRef();
				String window = buildDurationString(count.getWindow());

				ComponentBuilder cb = new ComponentBuilder("count", variableName, true, null, resMgr);
				cb.event(ref);
				cb.parameterEvent(ref).parameter(window);

				return cb.build();

			} else {
				throw new RuntimeException("Unknown statement operation : should never happen");
			}
		} catch (JSONException e) {
			logger.error("DSL_CEP_STATEMENT parsing error", e);
			throw new RuntimeException("DSL_CEP_STATEMENT parsing error", e);
		}
	}

	/**
	 * Parse actions which are embedded into a conditional statement. Creates
	 * components accordingly.
	 * 
	 * @param actions
	 *            an action list
	 * @param components
	 *            the components array, to be populated
	 * @param triggerTrueFalse
	 *            the conditional statement part
	 * @throws JSONException
	 */
	private static void parseConditionalActions(String fileName, ResourcesDeclarationManager resMgr, JSONArray components, Variable triggerVariable, boolean triggerTrueFalse, EList<DSL_ResourceAction> actions) throws JSONException {
		for (DSL_ResourceAction action : actions) {
			parseConditionalAction(fileName, resMgr, components, triggerVariable, triggerTrueFalse, action);
		}
	}

	/**
	 * Parse an action which is embedded into a conditional statement. Creates
	 * components accordingly.
	 * 
	 * @param actions
	 *            an action
	 * @param components
	 *            the components array, to be populated
	 * @param triggerTrueFalse
	 *            the conditional statement part
	 * @throws JSONException
	 */
	private static void parseConditionalAction(String fileName, ResourcesDeclarationManager resMgr, JSONArray components, Variable triggerVariable, boolean triggerTrueFalse, DSL_ResourceAction action) throws JSONException {

		BooleanVariableEventManager eventManager = new BooleanVariableEventManager(triggerVariable, triggerTrueFalse);
		String identifier = action.getVariable();
		boolean register = identifier != null;
		ComponentBuilder cb = new ComponentBuilder(action.getActiontype(), identifier, register, eventManager, resMgr);

		// First parameter is the resource name on which the act is applied 
		cb.parameter(action.getRef());
		if (action.getListParam() != null && action.getListParam().getParam() != null)
		{
			for (DSL_Expression param : action.getListParam().getParam()) {
				addParameter(fileName, param, cb, components, null, eventManager, resMgr);
			}
		}
		components.put(cb.build());
	}

	/**
	 * Add component to handle an expression.
	 * 
	 * @param expr
	 *            The expression to be translated into components
	 * @param output
	 *            The expression output variable name
	 * @param components
	 *            The list of components, updated during the process
	 * @param triggers
	 * @param eventManager
	 * @throws JSONException
	 */
	private static void parseExpression(String fileName, JSONArray components, DSL_Expression expr, List<DSL_REF> triggers, EventManager eventManager, ResourcesDeclarationManager resMgr, Variable output)
			throws JSONException {

		// Or: left associative, priority 1
		if (expr instanceof DSL_Expression_Or) {
			DSL_Expression_Or or = (DSL_Expression_Or) expr;
			DSL_Expression left = or.getLeft();
			DSL_Expression right = or.getRight();
			parseExpressionInternal(fileName, resMgr, components, "or", triggers, eventManager, output, left, right);
		}

		// And: left associative, priority 2
		else if (expr instanceof DSL_Expression_And) {
			DSL_Expression_And and = (DSL_Expression_And) expr;
			DSL_Expression left = and.getLeft();
			DSL_Expression right = and.getRight();
			parseExpressionInternal(fileName, resMgr, components, "and", triggers, eventManager, output, left, right);
		}

		// different/equal: left associative, priority 3
		else if (expr instanceof DSL_Expression_Diff) {
			DSL_Expression_Diff diff = (DSL_Expression_Diff) expr;
			DSL_Expression left = diff.getLeft();
			DSL_Expression right = diff.getRight();
			parseExpressionInternal(fileName, resMgr, components, "diff", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Equal) {
			DSL_Expression_Equal equal = (DSL_Expression_Equal) expr;
			DSL_Expression left = equal.getLeft();
			DSL_Expression right = equal.getRight();
			parseExpressionInternal(fileName, resMgr, components, "equal", triggers, eventManager, output, left, right);
		}

		// Comparisons: left associative, priority 4
		else if (expr instanceof DSL_Expression_Larger) {
			DSL_Expression_Larger largerThan = (DSL_Expression_Larger) expr;
			DSL_Expression left = largerThan.getLeft();
			DSL_Expression right = largerThan.getRight();
			parseExpressionInternal(fileName, resMgr, components, "greaterThan", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Larger_Equal) {
			DSL_Expression_Larger_Equal largerEqual = (DSL_Expression_Larger_Equal) expr;
			DSL_Expression left = largerEqual.getLeft();
			DSL_Expression right = largerEqual.getRight();
			parseExpressionInternal(fileName, resMgr, components, "greaterEqual", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Smaller) {
			DSL_Expression_Smaller smallerThan = (DSL_Expression_Smaller) expr;
			DSL_Expression left = smallerThan.getLeft();
			DSL_Expression right = smallerThan.getRight();
			parseExpressionInternal(fileName, resMgr, components, "lesserThan", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Smaller_Equal) {
			DSL_Expression_Smaller_Equal smallerEqual = (DSL_Expression_Smaller_Equal) expr;
			DSL_Expression left = smallerEqual.getLeft();
			DSL_Expression right = smallerEqual.getRight();
			parseExpressionInternal(fileName, resMgr, components, "lesserEqual", triggers, eventManager, output, left, right);
		}

		// addition/subtraction: left associative, priority 5
		else if (expr instanceof DSL_Expression_Plus) {
			DSL_Expression_Plus plus = (DSL_Expression_Plus) expr;
			DSL_Expression left = plus.getLeft();
			DSL_Expression right = plus.getRight();
			parseExpressionInternal(fileName, resMgr, components, "add", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Minus) {
			DSL_Expression_Minus minus = (DSL_Expression_Minus) expr;
			DSL_Expression left = minus.getLeft();
			DSL_Expression right = minus.getRight();
			parseExpressionInternal(fileName, resMgr, components, "sub", triggers, eventManager, output, left, right);
		}

		// multiplication/division/modulo, left associative, priority 6
		else if (expr instanceof DSL_Expression_Multiplication) {
			DSL_Expression_Multiplication multiply = (DSL_Expression_Multiplication) expr;
			DSL_Expression left = multiply.getLeft();
			DSL_Expression right = multiply.getRight();
			parseExpressionInternal(fileName, resMgr, components, "times", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Division) {
			DSL_Expression_Division divide = (DSL_Expression_Division) expr;
			DSL_Expression left = divide.getLeft();
			DSL_Expression right = divide.getRight();
			parseExpressionInternal(fileName, resMgr, components, "div", triggers, eventManager, output, left, right);

		} else if (expr instanceof DSL_Expression_Modulo) {
			DSL_Expression_Modulo modulo = (DSL_Expression_Modulo) expr;
			DSL_Expression left = modulo.getLeft();
			DSL_Expression right = modulo.getRight();
			parseExpressionInternal(fileName, resMgr, components, "mod", triggers, eventManager, output, left, right);
		}

		// Unary operators: right associative, priority 7
		else if (expr instanceof DSL_Expression_Negate) {
			DSL_Expression_Negate negate = (DSL_Expression_Negate) expr;
			DSL_Expression exp = negate.getExp();
			parseExpressionInternal(fileName, resMgr, components, "not", triggers, eventManager, output, exp);
		}

		else
			throw new RuntimeException("Should never happend");
	}

	private static void parseExpressionInternal(String fileName, ResourcesDeclarationManager resMgr, JSONArray components, String function, List<DSL_REF> triggers, EventManager eventManager,
			Variable identifier, DSL_Expression... params) throws JSONException {
		ComponentBuilder cb = new ComponentBuilder(function, identifier.getShortName(), false, eventManager, resMgr);
		for (DSL_Expression param : params)
			addParameter(fileName, param, cb, components, triggers, eventManager, resMgr);

		components.put(cb.build());
	}

	private static void addParameter(String fileName, DSL_Expression expr, ComponentBuilder cb, JSONArray components, List<DSL_REF> triggers, EventManager eventManager, ResourcesDeclarationManager resMgr)
			throws JSONException {

		if (expr instanceof DSL_Object_Number) {
			DSL_Object_Number number = (DSL_Object_Number) expr;

			try {
				long value = number.getValue().longValueExact();
				cb.parameter(value);
			} catch (ArithmeticException e) {
				double value = number.getValue().doubleValue();
				cb.parameter(value);
			}

		} else if (expr instanceof DSL_Object_String) {
			DSL_Object_String str = (DSL_Object_String) expr;
			cb.parameter(str.getValue());

		} else if (expr instanceof DSL_Object_Boolean) {
			DSL_Object_Boolean bool = (DSL_Object_Boolean) expr;
			cb.parameter(bool.isValue());

		} else if (expr instanceof DSL_Object_Ref) {
			DSL_Object_Ref objRef = (DSL_Object_Ref) expr;
			DSL_REF ref = objRef.getValue();

			if (triggers != null && refInList(ref, triggers)) {
				cb.parameterEvent(ref);
				cb.event(ref);
			} else {
				cb.parameter(ref);
			}
		} else {
			Variable outputVariable = VariableGenerator.get(fileName, "var").newVariable();
			cb.parameterEvent(outputVariable.getFullName());
			cb.eventVariable(outputVariable.getFullName());
			parseExpression(fileName, components, expr, triggers, eventManager, resMgr, outputVariable);
		}
	}

	/**
	 * Checks if a reference is inside a list.
	 * 
	 * @param ref
	 *            a reference
	 * @param a
	 *            list of references
	 * @return true if the reference is inside the list, false otherwise.
	 */
	private static boolean refInList(DSL_REF ref, List<DSL_REF> list) {
		for (DSL_REF trigger : list)
			if (trigger.getName().equals(ref.getName()))
				return true;
		return false;
	}

	/**
	 * Converts a cep duration into a string.
	 * 
	 * @param duration
	 * @return a string
	 */
	private static String buildDurationString(DSL_CEP_DURATION duration) {
		StringBuilder sb = new StringBuilder();

		if (duration != null && duration.getUnits() != null) {
			for (EObject unit : duration.getUnits()) {
				if (unit instanceof DSL_CEP_DURATION_MIN) {
					DSL_CEP_DURATION_MIN min = (DSL_CEP_DURATION_MIN) unit;
					sb.append(min.getMin());
					sb.append(" min ");
				} else if (unit instanceof DSL_CEP_DURATION_SEC) {
					DSL_CEP_DURATION_SEC sec = (DSL_CEP_DURATION_SEC) unit;
					sb.append(sec.getSec());
					sb.append(" sec ");
				} else {
					throw new RuntimeException("Should never happen");
				}
			}
		} else {
			sb.append("0 sec");
		}

		return sb.toString().trim();
	}
}
