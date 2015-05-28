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
package org.bonitasoft.engine.bpm.connector.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bonitasoft.engine.bpm.connector.ConnectorDefinition;
import org.bonitasoft.engine.bpm.connector.ConnectorEvent;
import org.bonitasoft.engine.bpm.connector.FailAction;
import org.bonitasoft.engine.bpm.internal.NamedElementImpl;
import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;
import org.bonitasoft.engine.operation.Operation;

/**
 * @author Baptiste Mesta
 */
public class ConnectorDefinitionImpl extends NamedElementImpl implements ConnectorDefinition {

    private static final long serialVersionUID = 1892648036453422626L;

    private final String connectorId;

    private final Map<String, Expression> inputs = new HashMap<>();

    private final List<Operation> outputs = new ArrayList<>();

    private final ConnectorEvent actiationEvent;

    private final String version;

    private FailAction failAction = FailAction.FAIL;

    private String errorCode;

    public ConnectorDefinitionImpl(final String name, final String connectorId, final String version, final ConnectorEvent actiationEvent) {
        super(name);
        this.connectorId = connectorId;
        this.version = version;
        this.actiationEvent = actiationEvent;
    }

    @Override
    public String getConnectorId() {
        return connectorId;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Map<String, Expression> getInputs() {
        return inputs;
    }

    @Override
    public List<Operation> getOutputs() {
        return outputs;
    }

    public void addInput(final String name, final Expression expression) {
        inputs.put(name, expression);
    }

    public void addOutput(final Operation operation) {
        outputs.add(operation);
    }

    @Override
    public ConnectorEvent getActivationEvent() {
        return actiationEvent;
    }

    @Override
    public FailAction getFailAction() {
        return failAction;
    }

    public void setFailAction(final FailAction failAction) {
        this.failAction = failAction;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "ConnectorDefinitionImpl [connectorId=" + connectorId + ", inputs=" + inputs + ", outputs=" + outputs + ", actiationEvent=" + actiationEvent
                + ", version=" + version + ", failAction=" + failAction + ", errorCode=" + errorCode + ", getName()=" + getName() + ", getId()=" + getId()
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConnectorDefinitionImpl that = (ConnectorDefinitionImpl) o;
        return Objects.equals(connectorId, that.connectorId) &&
                Objects.equals(inputs, that.inputs) &&
                Objects.equals(outputs, that.outputs) &&
                Objects.equals(actiationEvent, that.actiationEvent) &&
                Objects.equals(version, that.version) &&
                Objects.equals(failAction, that.failAction) &&
                Objects.equals(errorCode, that.errorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), connectorId, inputs, outputs, actiationEvent, version, failAction, errorCode);
    }

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }
}
