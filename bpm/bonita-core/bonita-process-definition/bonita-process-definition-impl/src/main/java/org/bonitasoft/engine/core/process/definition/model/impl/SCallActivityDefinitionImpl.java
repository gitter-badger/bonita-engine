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
 */
package org.bonitasoft.engine.core.process.definition.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bonitasoft.engine.bpm.flownode.CallActivityDefinition;
import org.bonitasoft.engine.core.operation.model.SOperation;
import org.bonitasoft.engine.core.process.definition.model.SCallActivityDefinition;
import org.bonitasoft.engine.core.process.definition.model.SCallableElementType;
import org.bonitasoft.engine.core.process.definition.model.SFlowNodeType;
import org.bonitasoft.engine.core.process.definition.model.STransitionDefinition;
import org.bonitasoft.engine.core.process.definition.model.builder.ServerModelConvertor;
import org.bonitasoft.engine.expression.model.SExpression;

/**
 * @author Elias Ricken de Medeiros
 * @author Celine Souchet
 */
public class SCallActivityDefinitionImpl extends SActivityDefinitionImpl implements SCallActivityDefinition {

    private static final long serialVersionUID = -5347512435504138388L;

    private SExpression callableElement;

    private SExpression callableElementVersion;

    private final List<SOperation> dataInputOperations;

    private final Map<String, SExpression> contractInputs;

    private final List<SOperation> dataOutputOperations;

    private SCallableElementType callableElementType;

    public SCallActivityDefinitionImpl(final long id, final String name) {
        super(id, name);
        dataInputOperations = new ArrayList<>(3);
        contractInputs = new HashMap<>();
        dataOutputOperations = new ArrayList<>(3);
    }

    public SCallActivityDefinitionImpl(final CallActivityDefinition activityDefinition, final Map<String, STransitionDefinition> transitionsMap) {
        super(activityDefinition, transitionsMap);
        callableElement = ServerModelConvertor.convertExpression(activityDefinition.getCallableElement());
        callableElementVersion = ServerModelConvertor.convertExpression(activityDefinition.getCallableElementVersion());
        dataInputOperations = ServerModelConvertor.convertOperations(activityDefinition.getDataInputOperations());
        contractInputs = ServerModelConvertor.convertContractInputs(activityDefinition.getProcessStartContractInputs());
        dataOutputOperations = ServerModelConvertor.convertOperations(activityDefinition.getDataOutputOperations());
        callableElementType = SCallableElementType.valueOf(activityDefinition.getCallableElementType().name());
    }

    @Override
    public SExpression getCallableElement() {
        return callableElement;
    }

    @Override
    public SExpression getCallableElementVersion() {
        return callableElementVersion;
    }


    @Override
    public List<SOperation> getDataInputOperations() {
        return Collections.unmodifiableList(dataInputOperations);
    }


    @Override
    public List<SOperation> getDataOutputOperations() {
        return Collections.unmodifiableList(dataOutputOperations);
    }


    @Override
    public SCallableElementType getCallableElementType() {
        return callableElementType;
    }


    @Override
    public SFlowNodeType getType() {
        return SFlowNodeType.CALL_ACTIVITY;
    }


    @Override
    public Map<String, SExpression> getProcessStartContractInputs() {
        return contractInputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SCallActivityDefinitionImpl that = (SCallActivityDefinitionImpl) o;
        return Objects.equals(callableElement, that.callableElement) &&
                Objects.equals(callableElementVersion, that.callableElementVersion) &&
                Objects.equals(dataInputOperations, that.dataInputOperations) &&
                Objects.equals(contractInputs, that.contractInputs) &&
                Objects.equals(dataOutputOperations, that.dataOutputOperations) &&
                Objects.equals(callableElementType, that.callableElementType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), callableElement, callableElementVersion, dataInputOperations, contractInputs, dataOutputOperations, callableElementType);
    }
}
