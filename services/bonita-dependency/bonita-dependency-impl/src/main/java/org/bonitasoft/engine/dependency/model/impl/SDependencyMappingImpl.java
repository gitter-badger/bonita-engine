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
package org.bonitasoft.engine.dependency.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.dependency.model.SDependencyMapping;
import org.bonitasoft.engine.dependency.model.ScopeType;

public class SDependencyMappingImpl implements SDependencyMapping {

    private static final long serialVersionUID = 3669487911530579373L;

    private long id;

    private long artifactId;

    private ScopeType artifactType;

    private long dependencyId;

    private long tenantId;

    public SDependencyMappingImpl() {
        super();
    }

    public SDependencyMappingImpl(final long artifactId, final ScopeType artifactType, final long dependencyId) {
        super();
        this.artifactId = artifactId;
        this.artifactType = artifactType;
        this.dependencyId = dependencyId;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    public void setArtifactId(final long artifactId) {
        this.artifactId = artifactId;
    }

    public void setArtifactType(final ScopeType artifactType) {
        this.artifactType = artifactType;
    }

    public void setDependencyId(final long dependencyId) {
        this.dependencyId = dependencyId;
    }

    @Override
    public long getArtifactId() {
        return artifactId;
    }

    @Override
    public ScopeType getArtifactType() {
        return artifactType;
    }

    @Override
    public long getDependencyId() {
        return dependencyId;
    }

    @Override
    public String getDiscriminator() {
        return SDependencyMappingImpl.class.getName();
    }

    @Override
    public String toString() {
        return "SDependencyMappingImpl [id=" + id + ", artifactId=" + artifactId + ", artifactType=" + artifactType + ", dependencyId=" + dependencyId
                + ", tenantId=" + tenantId + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SDependencyMappingImpl that = (SDependencyMappingImpl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(artifactId, that.artifactId) &&
                Objects.equals(dependencyId, that.dependencyId) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(artifactType, that.artifactType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artifactId, artifactType, dependencyId, tenantId);
    }
}
