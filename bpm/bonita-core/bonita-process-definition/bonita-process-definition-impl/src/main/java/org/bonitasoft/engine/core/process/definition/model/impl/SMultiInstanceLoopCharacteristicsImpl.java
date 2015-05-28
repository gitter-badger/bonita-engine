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
package org.bonitasoft.engine.core.process.definition.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.bpm.flownode.MultiInstanceLoopCharacteristics;
import org.bonitasoft.engine.core.process.definition.model.SMultiInstanceLoopCharacteristics;
import org.bonitasoft.engine.core.process.definition.model.builder.ServerModelConvertor;
import org.bonitasoft.engine.expression.model.SExpression;

/**
 * @author Baptiste Mesta
 */
public class SMultiInstanceLoopCharacteristicsImpl implements SMultiInstanceLoopCharacteristics {

    private static final long serialVersionUID = 5900494662430961903L;

    private boolean isSequential;

    private SExpression loopCardinality;

    private SExpression completionCondition;

    private String loopDataInputRef;

    private String loopDataOutputRef;

    private String dataInputItemRef;

    private String dataOutputItemRef;

    public SMultiInstanceLoopCharacteristicsImpl(final MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics) {
        isSequential = multiInstanceLoopCharacteristics.isSequential();
        loopDataInputRef = multiInstanceLoopCharacteristics.getLoopDataInputRef();
        loopDataOutputRef = multiInstanceLoopCharacteristics.getLoopDataOutputRef();
        dataInputItemRef = multiInstanceLoopCharacteristics.getDataInputItemRef();
        dataOutputItemRef = multiInstanceLoopCharacteristics.getDataOutputItemRef();
        loopCardinality = ServerModelConvertor.convertExpression(multiInstanceLoopCharacteristics.getLoopCardinality());
        completionCondition = ServerModelConvertor.convertExpression(multiInstanceLoopCharacteristics.getCompletionCondition());
    }

    @Override
    public boolean isSequential() {
        return isSequential;
    }

    @Override
    public SExpression getLoopCardinality() {
        return loopCardinality;
    }

    @Override
    public SExpression getCompletionCondition() {
        return completionCondition;
    }

    @Override
    public String getLoopDataInputRef() {
        return loopDataInputRef;
    }

    @Override
    public String getLoopDataOutputRef() {
        return loopDataOutputRef;
    }

    @Override
    public String getDataInputItemRef() {
        return dataInputItemRef;
    }

    @Override
    public String getDataOutputItemRef() {
        return dataOutputItemRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SMultiInstanceLoopCharacteristicsImpl that = (SMultiInstanceLoopCharacteristicsImpl) o;
        return Objects.equals(isSequential, that.isSequential) &&
                Objects.equals(loopCardinality, that.loopCardinality) &&
                Objects.equals(completionCondition, that.completionCondition) &&
                Objects.equals(loopDataInputRef, that.loopDataInputRef) &&
                Objects.equals(loopDataOutputRef, that.loopDataOutputRef) &&
                Objects.equals(dataInputItemRef, that.dataInputItemRef) &&
                Objects.equals(dataOutputItemRef, that.dataOutputItemRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSequential, loopCardinality, completionCondition, loopDataInputRef, loopDataOutputRef, dataInputItemRef, dataOutputItemRef);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SMultiInstanceLoopCharacteristicsImpl [isSequential=");
        builder.append(isSequential);
        builder.append(", loopCardinality=");
        builder.append(loopCardinality);
        builder.append(", completionCondition=");
        builder.append(completionCondition);
        builder.append(", loopDataInputRef=");
        builder.append(loopDataInputRef);
        builder.append(", loopDataOutputRef=");
        builder.append(loopDataOutputRef);
        builder.append(", dataInputItemRef=");
        builder.append(dataInputItemRef);
        builder.append(", dataOutputItemRef=");
        builder.append(dataOutputItemRef);
        builder.append("]");
        return builder.toString();
    }

}
