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
package org.bonitasoft.engine.bpm.flownode.impl.internal;

import java.util.Objects;

import org.bonitasoft.engine.bpm.flownode.MultiInstanceLoopCharacteristics;
import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;

/**
 * @author Baptiste Mesta
 */
public class MultiInstanceLoopCharacteristicsImpl implements MultiInstanceLoopCharacteristics {

    private static final long serialVersionUID = 22281767220832906L;

    private boolean isSequential;

    private Expression loopCardinality;

    private Expression completionCondition;

    private String loopDataInputRef;

    private String loopDataOutputRef;

    private String dataInputItemRef;

    private String dataOutputItemRef;

    public MultiInstanceLoopCharacteristicsImpl(final boolean isSequential, final Expression loopCardinality) {
        this.isSequential = isSequential;
        this.loopCardinality = loopCardinality;
    }

    public MultiInstanceLoopCharacteristicsImpl(final boolean isSequential, final String loopDataInputRef) {
        this.isSequential = isSequential;
        this.loopDataInputRef = loopDataInputRef;
    }

    public boolean isSequential() {
        return isSequential;
    }

    public void setSequential(final boolean isSequential) {
        this.isSequential = isSequential;
    }

    public Expression getLoopCardinality() {
        return loopCardinality;
    }

    public void setLoopCardinality(final Expression loopCardinality) {
        this.loopCardinality = loopCardinality;
    }

    public Expression getCompletionCondition() {
        return completionCondition;
    }

    public void setCompletionCondition(final Expression completionCondition) {
        this.completionCondition = completionCondition;
    }

    public String getLoopDataInputRef() {
        return loopDataInputRef;
    }

    public void setLoopDataInputRef(final String loopDataInputRef) {
        this.loopDataInputRef = loopDataInputRef;
    }

    public String getLoopDataOutputRef() {
        return loopDataOutputRef;
    }

    public void setLoopDataOutputRef(final String loopDataOutputRef) {
        this.loopDataOutputRef = loopDataOutputRef;
    }

    public String getDataInputItemRef() {
        return dataInputItemRef;
    }

    public void setDataInputItemRef(final String dataInputItemRef) {
        this.dataInputItemRef = dataInputItemRef;
    }

    public String getDataOutputItemRef() {
        return dataOutputItemRef;
    }

    public void setDataOutputItemRef(final String dataOutputItemRef) {
        this.dataOutputItemRef = dataOutputItemRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiInstanceLoopCharacteristicsImpl that = (MultiInstanceLoopCharacteristicsImpl) o;
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
        builder.append("MultiInstanceLoopCharacteristics [isSequential=");
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

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }

}
