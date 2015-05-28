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
 * @author Charles Souillard
 * @author Matthieu Chaffotte
 */
public abstract class AbstractSelectDescriptor<T> {

    private final String queryName;

    private final Class<? extends PersistentObject> entityType;

    private final Class<T> returnType;

    public AbstractSelectDescriptor(final String queryName, final Class<? extends PersistentObject> entityType, final Class<T> returnType) {
        this.entityType = entityType;
        this.queryName = queryName;
        this.returnType = returnType;
    }

    public String getQueryName() {
        return queryName;
    }

    public Class<? extends PersistentObject> getEntityType() {
        return entityType;
    }

    public Class<T> getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "AbstractSelectDescriptor [entityType=" + entityType + ", queryName=" + queryName + ", returnType=" + returnType + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSelectDescriptor<?> that = (AbstractSelectDescriptor<?>) o;
        return Objects.equals(queryName, that.queryName) &&
                Objects.equals(entityType, that.entityType) &&
                Objects.equals(returnType, that.returnType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryName, entityType, returnType);
    }
}
