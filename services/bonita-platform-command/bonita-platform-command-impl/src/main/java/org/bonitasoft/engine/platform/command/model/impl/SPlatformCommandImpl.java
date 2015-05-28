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
package org.bonitasoft.engine.platform.command.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.platform.command.model.SPlatformCommand;

/**
 * @author Zhang Bole
 */
public class SPlatformCommandImpl implements SPlatformCommand {

    private static final long serialVersionUID = 4257969847115435401L;

    private long id;

    private long tenantId;

    private String name;

    private String description;

    private String implementation;

    public SPlatformCommandImpl() {
        super();
    }

    public SPlatformCommandImpl(final String name, final String description, final String implementation) {
        super();
        this.name = name;
        this.description = description;
        this.implementation = implementation;
    }

    public SPlatformCommandImpl(final SPlatformCommand platformCommand) {
        super();
        this.id = platformCommand.getId();
        this.name = platformCommand.getName();
        this.description = platformCommand.getDescription();
        this.implementation = platformCommand.getImplementation();
    }

    @Override
    public String getDiscriminator() {
        return SPlatformCommandImpl.class.getName();
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

    @Override
    public String getImplementation() {
        return implementation;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setTenantId(final long id) {
        this.tenantId = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SPlatformCommandImpl that = (SPlatformCommandImpl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(implementation, that.implementation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, name, description, implementation);
    }
}
