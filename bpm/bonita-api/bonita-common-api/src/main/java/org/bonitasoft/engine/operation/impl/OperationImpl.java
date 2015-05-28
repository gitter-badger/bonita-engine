/**
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
package org.bonitasoft.engine.operation.impl;

import java.util.Objects;

import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;
import org.bonitasoft.engine.operation.LeftOperand;
import org.bonitasoft.engine.operation.Operation;
import org.bonitasoft.engine.operation.OperatorType;

/**
 * @author Zhang Bole
 * @author Matthieu Chaffotte
 * @author Emmanuel Duchastenier
 */
public class OperationImpl implements Operation {

    private static final long serialVersionUID = -7255854432856258651L;

    private LeftOperand leftOperand;

    private OperatorType type;

    private String operator;

    private Expression rightOperand;

    public void setLeftOperand(final LeftOperand leftOperand) {
        this.leftOperand = leftOperand;
    }

    /**
     * @deprecated As of 6.0 replaced by {@link #setLeftOperand(LeftOperand)}
     */
    @Deprecated
    public void setVariableToSet(final LeftOperand variableToSet) {
        leftOperand = variableToSet;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

    public void setOperatorInputType(final String operatorInputType) {
        if (null != operatorInputType) {
            if (operator == null) {
                throw new IllegalArgumentException("Please set 'operator' before setting 'operator input type'");
            }
            operator = operator + ":" + operatorInputType;
        }
    }

    public void setType(final OperatorType type) {
        this.type = type;
    }

    public void setRightOperand(final Expression rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    public LeftOperand getLeftOperand() {
        return leftOperand;
    }

    /**
     * @deprecated As of 6.0 replaced by {@link #getLeftOperand()}
     */
    @Deprecated
    @Override
    public LeftOperand getVariableToSet() {
        return leftOperand;
    }

    @Override
    public OperatorType getType() {
        return type;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public Expression getRightOperand() {
        return rightOperand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationImpl operation = (OperationImpl) o;
        return Objects.equals(leftOperand, operation.leftOperand) &&
                Objects.equals(type, operation.type) &&
                Objects.equals(operator, operation.operator) &&
                Objects.equals(rightOperand, operation.rightOperand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftOperand, type, operator, rightOperand);
    }

    @Override
    public String toString() {
        return "Operation [ set " + leftOperand + " using " + type + " " + operator + " with" + rightOperand + "]";
    }

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }

}
