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
package org.bonitasoft.engine.actor.mapping.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.actor.mapping.model.SActor;

/**
 * @author Matthieu Chaffotte
 */
public class SActorImpl implements SActor {

    private static final long serialVersionUID = -6333033389852045788L;

    private long tenantId;

    private long id;

    private long scopeId;

    private String name;

    private String displayName;

    private String description;

    private boolean initiator;

    public SActorImpl() {
        super();
    }

    public SActorImpl(final String name, final long scopeId, final boolean initiator) {
        this.name = name;
        this.scopeId = scopeId;
        this.initiator = initiator;
    }

    public SActorImpl(final SActor actor) {
        this.name = actor.getName();
        this.scopeId = actor.getScopeId();
        this.description = actor.getDescription();
    }

    public long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public long getScopeId() {
        return scopeId;
    }

    public void setScopeId(final long scopeId) {
        this.scopeId = scopeId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String getDiscriminator() {
        return SActorImpl.class.getName();
    }

    @Override
    public boolean isInitiator() {
        return initiator;
    }

    public void setInitiator(final boolean initiator) {
        this.initiator = initiator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SActorImpl sActor = (SActorImpl) o;
        return Objects.equals(tenantId, sActor.tenantId) &&
                Objects.equals(id, sActor.id) &&
                Objects.equals(scopeId, sActor.scopeId) &&
                Objects.equals(initiator, sActor.initiator) &&
                Objects.equals(name, sActor.name) &&
                Objects.equals(displayName, sActor.displayName) &&
                Objects.equals(description, sActor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, id, scopeId, name, displayName, description, initiator);
    }
}
