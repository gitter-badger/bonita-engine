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
package org.bonitasoft.engine.data.instance.model.impl;

import java.io.Serializable;
import java.util.Objects;

import org.bonitasoft.engine.data.definition.model.SDataDefinition;
import org.bonitasoft.engine.data.instance.model.SDataInstance;
import org.bonitasoft.engine.data.instance.model.exceptions.SDataInstanceNotWellFormedException;

/**
 * @author Zhao Na
 * @author Frederic Bouquet
 * @author Matthieu Chaffotte
 */
public abstract class SDataInstanceImpl implements SDataInstance {

    private static final long serialVersionUID = -3752347909196691889L;

    private long tenantId;

    private long id;

    private String name;

    private String description;

    private boolean transientData;

    private String className;

    private long containerId;

    private String containerType;

    public SDataInstanceImpl() {
        super();
    }

    public SDataInstanceImpl(final SDataDefinition dataDefinition) {
        name = dataDefinition.getName();
        description = dataDefinition.getDescription();
        transientData = dataDefinition.isTransientData();
        className = dataDefinition.getClassName();
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setTransientData(final boolean transientData) {
        this.transientData = transientData;
    }

    public void setClassName(final String className) {
        this.className = className;
    }

    public void setContainerId(final long containerId) {
        this.containerId = containerId;
    }

    public void setContainerType(final String containerType) {
        this.containerType = containerType;
    }

    public void setDataTypeClassName(final String className) {
        this.className = className;
    }

    public long getTenantId() {
        return tenantId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public abstract void setValue(Serializable value);

    @Override
    public Boolean isTransientData() {
        return transientData;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public long getContainerId() {
        return containerId;
    }

    @Override
    public String getContainerType() {
        return containerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SDataInstanceImpl that = (SDataInstanceImpl) o;
        return Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(transientData, that.transientData) &&
                Objects.equals(containerId, that.containerId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(className, that.className) &&
                Objects.equals(containerType, that.containerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, id, name, description, transientData, className, containerId, containerType);
    }

    /**
     * Check if the data is well formed
     *
     * @throws org.bonitasoft.engine.data.instance.model.exceptions.SDataInstanceNotWellFormedException
     *         thrown if the data is not well formed
     */
    public void validate() throws SDataInstanceNotWellFormedException {
    }

}
