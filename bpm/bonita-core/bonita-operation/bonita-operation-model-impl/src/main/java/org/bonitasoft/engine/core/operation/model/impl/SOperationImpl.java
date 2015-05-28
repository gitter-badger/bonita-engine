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
package org.bonitasoft.engine.core.operation.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.core.operation.model.SLeftOperand;
import org.bonitasoft.engine.core.operation.model.SOperation;
import org.bonitasoft.engine.core.operation.model.SOperatorType;
import org.bonitasoft.engine.expression.model.SExpression;

/**
 * @author Elias Ricken de Medeiros
 * @author Baptiste Mesta
 */
public class SOperationImpl implements SOperation {

    private static final long serialVersionUID = 1L;

    private SLeftOperand leftOperand;

    private SOperatorType type;

    private String operator;

    private SExpression rightOperand;

    public void setLeftOperand(final SLeftOperand leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

    public void setType(final SOperatorType type) {
        this.type = type;
    }

    public void setRightOperand(final SExpression rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    public SLeftOperand getLeftOperand() {
        return leftOperand;
    }

    @Override
    public SOperatorType getType() {
        return type;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public SExpression getRightOperand() {
        return rightOperand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SOperationImpl that = (SOperationImpl) o;
        return Objects.equals(leftOperand, that.leftOperand) &&
                Objects.equals(type, that.type) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(rightOperand, that.rightOperand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftOperand, type, operator, rightOperand);
    }

    @Override
    public String toString() {
        return "SOperationImpl [leftOperand=" + leftOperand + ", type=" + type + ", operator=" + operator + ", rightOperand=" + rightOperand + "]";
    }

}
