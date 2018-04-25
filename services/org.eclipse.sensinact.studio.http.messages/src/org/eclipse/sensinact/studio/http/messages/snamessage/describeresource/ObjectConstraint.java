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
package org.eclipse.sensinact.studio.http.messages.snamessage.describeresource;

/**
 * @author Etienne Gandrille
 */
public class ObjectConstraint {
	
	private String type;
	private boolean complement;
	private String operator;
	private int operand;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isComplement() {
		return complement;
	}
	
	public void setComplement(boolean complement) {
		this.complement = complement;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public int getOperand() {
		return operand;
	}
	
	public void setOperand(int operand) {
		this.operand = operand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (complement ? 1231 : 1237);
		result = prime * result + operand;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectConstraint other = (ObjectConstraint) obj;
		if (complement != other.complement)
			return false;
		if (operand != other.operand)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectConstraint [type=" + type + ", complement=" + complement + ", operator=" + operator + ", operand="
				+ operand + "]";
	}
}
