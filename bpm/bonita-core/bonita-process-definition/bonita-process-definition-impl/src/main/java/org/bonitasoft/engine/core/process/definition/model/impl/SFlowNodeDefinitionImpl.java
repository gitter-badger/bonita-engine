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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bonitasoft.engine.bpm.connector.ConnectorDefinition;
import org.bonitasoft.engine.bpm.connector.ConnectorEvent;
import org.bonitasoft.engine.bpm.flownode.FlowNodeDefinition;
import org.bonitasoft.engine.bpm.flownode.TransitionDefinition;
import org.bonitasoft.engine.core.process.definition.model.SConnectorDefinition;
import org.bonitasoft.engine.core.process.definition.model.SFlowElementContainerDefinition;
import org.bonitasoft.engine.core.process.definition.model.SFlowNodeDefinition;
import org.bonitasoft.engine.core.process.definition.model.SFlowNodeType;
import org.bonitasoft.engine.core.process.definition.model.STransitionDefinition;
import org.bonitasoft.engine.core.process.definition.model.builder.ServerModelConvertor;
import org.bonitasoft.engine.expression.model.SExpression;

/**
 * @author Feng Hui
 * @author Elias Ricken de Medeiros
 * @author Matthieu Chaffotte
 * @author Celine Souchet
 */
public abstract class SFlowNodeDefinitionImpl extends SNamedElementImpl implements SFlowNodeDefinition {

    private static final long serialVersionUID = 7475429470423228259L;

    private final List<STransitionDefinition> incomings;

    private final List<STransitionDefinition> outgoings;

    private STransitionDefinition defaultTransition;

    private final List<SConnectorDefinition> connectors;

    private final Map<String, SConnectorDefinition> allConnectorsMap;

    private String description;

    private SExpression displayDescription;

    private SExpression displayDescriptionAfterCompletion;

    private SExpression displayName;

    private SFlowElementContainerDefinition parentContainer;

    private final Map<ConnectorEvent, List<SConnectorDefinition>> connectorsMap;

    public SFlowNodeDefinitionImpl(final FlowNodeDefinition flowNodeDefinition,
            final Map<String, STransitionDefinition> sTransitionsMap) {
        super(flowNodeDefinition.getName());
        incomings = buildIncomingTransitions(flowNodeDefinition, sTransitionsMap);
        outgoings = buildOutGoingTransitions(flowNodeDefinition, sTransitionsMap);
        if (flowNodeDefinition.getDefaultTransition() != null) {
            defaultTransition = sTransitionsMap.get(flowNodeDefinition.getDefaultTransition().getName());
        }
        final List<ConnectorDefinition> connectors2 = flowNodeDefinition.getConnectors();
        final ArrayList<SConnectorDefinition> mConnectors = new ArrayList<>(connectors2.size());
        connectorsMap = new HashMap<>(2);
        connectorsMap.put(ConnectorEvent.ON_ENTER, new ArrayList<SConnectorDefinition>());
        connectorsMap.put(ConnectorEvent.ON_FINISH, new ArrayList<SConnectorDefinition>());
        allConnectorsMap = new HashMap<>(2);
        for (final ConnectorDefinition connector : connectors2) {
            final SConnectorDefinitionImpl e = new SConnectorDefinitionImpl(connector);
            mConnectors.add(e);
            connectorsMap.get(e.getActivationEvent()).add(e);
            allConnectorsMap.put(e.getName(), e);
        }
        connectors = Collections.unmodifiableList(mConnectors);

        description = flowNodeDefinition.getDescription();
        displayDescription = ServerModelConvertor.convertExpression(flowNodeDefinition.getDisplayDescription());
        displayDescriptionAfterCompletion = ServerModelConvertor.convertExpression(flowNodeDefinition.getDisplayDescriptionAfterCompletion());
        displayName = ServerModelConvertor.convertExpression(flowNodeDefinition.getDisplayName());
        setId(flowNodeDefinition.getId());
    }

    public SFlowNodeDefinitionImpl(final long id, final String name) {
        super(name);
        setId(id);
        incomings = new ArrayList<>();
        outgoings = new ArrayList<>();
        connectors = new ArrayList<>();
        connectorsMap = new HashMap<>(2);
        connectorsMap.put(ConnectorEvent.ON_ENTER, new ArrayList<SConnectorDefinition>());
        connectorsMap.put(ConnectorEvent.ON_FINISH, new ArrayList<SConnectorDefinition>());
        allConnectorsMap = new HashMap<>(2);
    }

    @Override
    public SFlowElementContainerDefinition getParentContainer() {
        return parentContainer;
    }

    private List<STransitionDefinition> buildOutGoingTransitions(final FlowNodeDefinition nodeDefinition,
            final Map<String, STransitionDefinition> sTransitionsMap) {
        Iterator<TransitionDefinition> iterator;
        final List<TransitionDefinition> outgoingTransitions = nodeDefinition.getOutgoingTransitions();
        final List<STransitionDefinition> outgoings = new ArrayList<>();
        iterator = outgoingTransitions.iterator();
        while (iterator.hasNext()) {
            final TransitionDefinition sTransition = iterator.next();
            final STransitionDefinition outgoing = sTransitionsMap.get(sTransition.getName());
            outgoings.add(outgoing);
        }
        return outgoings;
    }

    private List<STransitionDefinition> buildIncomingTransitions(final FlowNodeDefinition nodeDefinition,
            final Map<String, STransitionDefinition> sTransitionsMap) {
        final List<STransitionDefinition> incomings = new ArrayList<>();
        for (TransitionDefinition sTransition : nodeDefinition.getIncomingTransitions()) {
            final STransitionDefinition incoming = sTransitionsMap.get(sTransition.getName());
            incomings.add(incoming);
        }
        return incomings;
    }

    @Override
    public List<STransitionDefinition> getOutgoingTransitions() {
        return Collections.unmodifiableList(outgoings);
    }

    @Override
    public List<STransitionDefinition> getIncomingTransitions() {
        return Collections.unmodifiableList(incomings);
    }

    @Override
    public List<SConnectorDefinition> getConnectors() {
        return Collections.unmodifiableList(connectors);
    }

    @Override
    public boolean hasConnectors() {
        return connectors.size() > 0;
    }

    @Override
    // public SConnectorDefinition getConnectorDefinition(final long id) { // FIXME: Uncomment when generate id
    public SConnectorDefinition getConnectorDefinition(final String name) {
        return allConnectorsMap.get(name);
    }

    @Override
    public STransitionDefinition getDefaultTransition() {
        return defaultTransition;
    }

    @Override
    public boolean hasIncomingTransitions() {
        return !incomings.isEmpty();
    }

    @Override
    public boolean hasOutgoingTransitions() {
        return !outgoings.isEmpty();
    }

    @Override
    public List<SConnectorDefinition> getConnectors(final ConnectorEvent connectorEvent) {
        return connectorsMap.get(connectorEvent);
    }

    public void addOutgoingTransition(final STransitionDefinition sTransition) {
        if (!outgoings.contains(sTransition)) {
            outgoings.add(sTransition);
        }
    }

    public void addIncomingTransition(final STransitionDefinition sTransition) {
        if (!incomings.contains(sTransition)) {
            incomings.add(sTransition);
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public SExpression getDisplayDescription() {
        return displayDescription;
    }

    public void setDisplayDescription(final SExpression displayDescription) {
        this.displayDescription = displayDescription;
    }

    @Override
    public SExpression getDisplayDescriptionAfterCompletion() {
        return displayDescriptionAfterCompletion;
    }

    @Override
    public SExpression getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final SExpression displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SFlowNodeDefinitionImpl that = (SFlowNodeDefinitionImpl) o;
        return Objects.equals(incomings, that.incomings) &&
                Objects.equals(outgoings, that.outgoings) &&
                Objects.equals(defaultTransition, that.defaultTransition) &&
                Objects.equals(connectors, that.connectors) &&
                Objects.equals(allConnectorsMap, that.allConnectorsMap) &&
                Objects.equals(description, that.description) &&
                Objects.equals(displayDescription, that.displayDescription) &&
                Objects.equals(displayDescriptionAfterCompletion, that.displayDescriptionAfterCompletion) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(parentContainer, that.parentContainer) &&
                Objects.equals(connectorsMap, that.connectorsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), incomings, outgoings, defaultTransition, connectors, allConnectorsMap, description, displayDescription, displayDescriptionAfterCompletion, displayName, parentContainer, connectorsMap);
    }

    @Override
    public int getTransitionIndex(final String transitionName) {
        int index = 1;
        boolean found = false;
        final Iterator<STransitionDefinition> iterator = incomings.iterator();
        while (!found && iterator.hasNext()) {
            final STransitionDefinition next = iterator.next();
            if (next.getName().equals(transitionName)) {
                found = true;
            } else {
                index++;
            }
        }
        return index;
    }

    @Override
    public boolean isStartable() {
        return !hasIncomingTransitions();
    }

    @Override
    public boolean isParalleleOrInclusive() {
        return false;
    }

    @Override
    public boolean isExclusive() {
        return false;
    }

    @Override
    public boolean isBoundaryEvent() {
        return SFlowNodeType.BOUNDARY_EVENT.equals(getType());
    }

    @Override
    public boolean isInterrupting() {
        return false;
    }

    @Override
    public boolean isEventSubProcess() {
        return false;
    }
}
