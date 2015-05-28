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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.bonitasoft.engine.bpm.connector.ConnectorDefinition;
import org.bonitasoft.engine.bpm.flownode.FlowNodeDefinition;
import org.bonitasoft.engine.bpm.flownode.TransitionDefinition;
import org.bonitasoft.engine.bpm.internal.NamedElementImpl;
import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;

/**
 * @author Zhao Na
 * @author Matthieu Chaffotte
 * @author Celine Souchet
 */
public abstract class FlowNodeDefinitionImpl extends NamedElementImpl implements FlowNodeDefinition {

    private static final long serialVersionUID = 429640943678358154L;

    private final List<TransitionDefinition> incomings;

    private final List<TransitionDefinition> outgoings;

    private final List<ConnectorDefinition> connectors;

    private String description;

    private Expression displayDescription;

    private Expression displayName;

    private Expression displayDescriptionAfterCompletion;

    private TransitionDefinition defaultTransition;

    public FlowNodeDefinitionImpl(final long id, final String name) {
        super(name);
        incomings = new ArrayList<>();
        outgoings = new ArrayList<>();
        connectors = new ArrayList<>();
        setId(id);
    }

    public FlowNodeDefinitionImpl(final String name) {
        this(Math.abs(UUID.randomUUID().getLeastSignificantBits()), name);
    }

    @Override
    public TransitionDefinition getDefaultTransition() {
        return defaultTransition;
    }

    public void setDefaultTransition(final TransitionDefinition defaultTransition) {
        this.defaultTransition = defaultTransition;
    }

    @Override
    public List<TransitionDefinition> getOutgoingTransitions() {
        return Collections.unmodifiableList(outgoings);
    }

    @Override
    public List<TransitionDefinition> getIncomingTransitions() {
        return Collections.unmodifiableList(incomings);
    }

    @Override
    public List<ConnectorDefinition> getConnectors() {
        return Collections.unmodifiableList(connectors);
    }

    public void addIncomingTransition(final TransitionDefinition transition) {
        if (!incomings.contains(transition)) {
            incomings.add(transition);
        }
    }

    public void addIncomingTransition(int index, TransitionDefinition transition) {
        if (!incomings.contains(transition)) {
            incomings.add(index, transition);
        }
    }

    public void removeIncomingTransition(final TransitionDefinition transition) {
        incomings.remove(transition);
    }

    public void addOutgoingTransition(final TransitionDefinition transition) {
        if (!outgoings.contains(transition)) {
            outgoings.add(transition);
        }
    }

    public void addOutgoingTransition(final int index, final TransitionDefinition transition) {
        if (!outgoings.contains(transition)) {
            outgoings.add(index, transition);
        }
    }

    public void removeOutgoingTransition(final TransitionDefinition transition) {
        outgoings.remove(transition);
    }

    @Override
    public void addConnector(final ConnectorDefinition connectorDefinition) {
        connectors.add(connectorDefinition);
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setDisplayDescription(final Expression displayDescription) {
        this.displayDescription = displayDescription;
    }

    public void setDisplayName(final Expression displayName) {
        this.displayName = displayName;
    }

    public void setDisplayDescriptionAfterCompletion(final Expression displayDescriptionAfterCompletion) {
        this.displayDescriptionAfterCompletion = displayDescriptionAfterCompletion;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Expression getDisplayDescription() {
        return displayDescription;
    }

    @Override
    public Expression getDisplayName() {
        return displayName;
    }

    @Override
    public Expression getDisplayDescriptionAfterCompletion() {
        return displayDescriptionAfterCompletion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlowNodeDefinitionImpl that = (FlowNodeDefinitionImpl) o;
        return Objects.equals(incomings, that.incomings) &&
                Objects.equals(outgoings, that.outgoings) &&
                Objects.equals(connectors, that.connectors) &&
                Objects.equals(description, that.description) &&
                Objects.equals(displayDescription, that.displayDescription) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(displayDescriptionAfterCompletion, that.displayDescriptionAfterCompletion) &&
                Objects.equals(defaultTransition, that.defaultTransition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), incomings, outgoings, connectors, description, displayDescription, displayName, displayDescriptionAfterCompletion, defaultTransition);
    }

    @Override
    public String toString() {
        final int maxLen = 5;
        final StringBuilder builder = new StringBuilder();
        builder.append("FlowNodeDefinitionImpl [incomings=");
        builder.append(incomings != null ? incomings.subList(0, Math.min(incomings.size(), maxLen)) : null);
        builder.append(", outgoings=");
        builder.append(outgoings != null ? outgoings.subList(0, Math.min(outgoings.size(), maxLen)) : null);
        builder.append(", connectors=");
        builder.append(connectors != null ? connectors.subList(0, Math.min(connectors.size(), maxLen)) : null);
        builder.append(", description=");
        builder.append(description);
        builder.append(", displayDescription=");
        builder.append(displayDescription);
        builder.append(", displayName=");
        builder.append(displayName);
        builder.append(", displayDescriptionAfterCompletion=");
        builder.append(displayDescriptionAfterCompletion);
        builder.append(", defaultTransition=");
        builder.append(defaultTransition);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }
}
