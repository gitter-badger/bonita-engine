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
package org.bonitasoft.engine.persistence;

import java.util.Objects;

/**
 * @author Elias Ricken de Medeiros
 * @author Matthieu Chaffotte
 */
public abstract class SAPersistenceObjectImpl implements ArchivedPersistentObject {

    private static final long serialVersionUID = 1963528483109540503L;

    protected long id;

    protected long tenantId;

    protected long archiveDate;

    protected long sourceObjectId;

    public SAPersistenceObjectImpl(final long sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    public SAPersistenceObjectImpl() {
    }

    public long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public long getArchiveDate() {
        return archiveDate;
    }

    @Override
    public long getSourceObjectId() {
        return sourceObjectId;
    }

    public void setArchiveDate(final long archiveDate) {
        this.archiveDate = archiveDate;
    }

    public void setSourceObjectId(final long sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SAPersistenceObjectImpl that = (SAPersistenceObjectImpl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(archiveDate, that.archiveDate) &&
                Objects.equals(sourceObjectId, that.sourceObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, archiveDate, sourceObjectId);
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + "[id=") + id + ", tenantId=" + tenantId + ", archiveDate=" + archiveDate + ", sourceObjectId=" + sourceObjectId + "]";
    }

}
