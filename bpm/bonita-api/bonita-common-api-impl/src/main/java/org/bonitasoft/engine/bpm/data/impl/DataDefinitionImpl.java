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
package org.bonitasoft.engine.bpm.data.impl;

import java.util.Objects;

import org.bonitasoft.engine.bpm.data.DataDefinition;
import org.bonitasoft.engine.bpm.internal.NamedElementImpl;
import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;

/**
 * @author Feng Hui
 * @author Matthieu Chaffotte
 */
public class DataDefinitionImpl extends NamedElementImpl implements DataDefinition {

    private static final long serialVersionUID = -4126105713210029929L;

    private String description;

    private String type;

    private boolean transientData;

    private String className;

    private Expression defaultValueExpression;

    public DataDefinitionImpl(final String name, final Expression defaultValueExpression) {
        super(name);
        this.defaultValueExpression = defaultValueExpression;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getClassName() {
        return className;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public boolean isTransientData() {
        return transientData;
    }

    @Override
    public Expression getDefaultValueExpression() {
        return defaultValueExpression;
    }

    public void setTransientData(final boolean transientData) {
        this.transientData = transientData;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setDefaultValueExpression(final Expression defaultValueExpression) {
        this.defaultValueExpression = defaultValueExpression;
    }

    public void setClassName(final String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DataDefinitionImpl that = (DataDefinitionImpl) o;
        return Objects.equals(transientData, that.transientData) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type) &&
                Objects.equals(className, that.className) &&
                Objects.equals(defaultValueExpression, that.defaultValueExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, type, transientData, className, defaultValueExpression);
    }

    @Override
    public String toString() {
        return "DataDefinitionImpl [name=" + getName() + ", description=" + description + ", type=" + type + ", transientData=" + transientData + ", className=" + className + ", defaultValueExpression=" + defaultValueExpression + "]";
    }

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }
}
