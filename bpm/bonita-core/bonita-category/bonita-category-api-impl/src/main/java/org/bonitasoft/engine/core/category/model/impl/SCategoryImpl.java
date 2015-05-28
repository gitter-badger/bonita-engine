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
package org.bonitasoft.engine.core.category.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.core.category.model.SCategory;

/**
 * @author Yanyan Liu
 * @author Matthieu Chaffotte
 * @author Celine Souchet
 */
public class SCategoryImpl implements SCategory {

    private static final long serialVersionUID = 1294608200299613682L;

    private long tenantId;

    private long id;

    private String name;

    private String description;

    private long creator;

    private long creationDate;

    private long lastUpdateDate;

    public SCategoryImpl() {
        super();
    }

    public SCategoryImpl(final String name) {
        this.name = name;
    }

    public SCategoryImpl(final SCategory category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.creator = category.getCreator();
        this.creationDate = category.getCreationDate();
        this.lastUpdateDate = category.getLastUpdateDate();
    }

    public long getTenantId() {
        return this.tenantId;
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

    public void setCreator(final long creator) {
        this.creator = creator;
    }

    public void setCreationDate(final long creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdateDate(final long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getDiscriminator() {
        return SCategoryImpl.class.getName();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public long getCreator() {
        return this.creator;
    }

    @Override
    public long getCreationDate() {
        return this.creationDate;
    }

    @Override
    public long getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    @Override
    public String toString() {
        return "SCategoryImpl [id=" + id + ", name=" + name + ", description=" + description + ", creator=" + creator + ", creationDate=" + creationDate
                + ", lastUpdateDate=" + lastUpdateDate + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SCategoryImpl sCategory = (SCategoryImpl) o;
        return Objects.equals(tenantId, sCategory.tenantId) &&
                Objects.equals(id, sCategory.id) &&
                Objects.equals(creator, sCategory.creator) &&
                Objects.equals(creationDate, sCategory.creationDate) &&
                Objects.equals(lastUpdateDate, sCategory.lastUpdateDate) &&
                Objects.equals(name, sCategory.name) &&
                Objects.equals(description, sCategory.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, id, name, description, creator, creationDate, lastUpdateDate);
    }
}
