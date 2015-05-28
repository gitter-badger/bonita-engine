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
package org.bonitasoft.engine.bpm.connector.impl;

import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.bpm.connector.ArchivedConnectorInstance;
import org.bonitasoft.engine.bpm.connector.ConnectorEvent;
import org.bonitasoft.engine.bpm.connector.ConnectorState;
import org.bonitasoft.engine.bpm.internal.NamedElementImpl;

/**
 * @author Baptiste Mesta
 */
public class ArchivedConnectorInstanceImpl extends NamedElementImpl implements ArchivedConnectorInstance {

    private static final long serialVersionUID = 1740487116886845229L;

    private final Date archiveDate;

    private final long containerId;

    private final String containerType;

    private final String connectorId;

    private final String version;

    private final ConnectorEvent activationEvent;

    private final ConnectorState state;

    private final long sourceObjectId;

    public ArchivedConnectorInstanceImpl(final String name, final Date archiveDate, final long containerId, final String containerType,
            final String connectorId, final String version, final ConnectorEvent activationEvent, final ConnectorState state, final long sourceObjectId) {
        super(name);
        this.archiveDate = archiveDate;
        this.containerId = containerId;
        this.containerType = containerType;
        this.connectorId = connectorId;
        this.version = version;
        this.activationEvent = activationEvent;
        this.state = state;
        this.sourceObjectId = sourceObjectId;
    }

    /**
     * @return the archiveDate
     */
    @Override
    public Date getArchiveDate() {
        return archiveDate;
    }

    /**
     * @return the containerId
     */
    @Override
    public long getContainerId() {
        return containerId;
    }

    /**
     * @return the containerType
     */
    @Override
    public String getContainerType() {
        return containerType;
    }

    /**
     * @return the connectorId
     */
    @Override
    public String getConnectorId() {
        return connectorId;
    }

    /**
     * @return the version
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * @return the activationEvent
     */
    @Override
    public ConnectorEvent getActivationEvent() {
        return activationEvent;
    }

    /**
     * @return the state
     */
    @Override
    public ConnectorState getState() {
        return state;
    }

    @Override
    public long getSourceObjectId() {
        return sourceObjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArchivedConnectorInstanceImpl that = (ArchivedConnectorInstanceImpl) o;
        return Objects.equals(containerId, that.containerId) &&
                Objects.equals(sourceObjectId, that.sourceObjectId) &&
                Objects.equals(archiveDate, that.archiveDate) &&
                Objects.equals(containerType, that.containerType) &&
                Objects.equals(connectorId, that.connectorId) &&
                Objects.equals(version, that.version) &&
                Objects.equals(activationEvent, that.activationEvent) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), archiveDate, containerId, containerType, connectorId, version, activationEvent, state, sourceObjectId);
    }

    @Override
    public String toString() {
        return "ArchivedConnectorInstance [archiveDate=" + archiveDate + ", containerId=" + containerId + ", containerType=" + containerType + ", connectorId="
                + connectorId + ", version=" + version + ", activationEvent=" + activationEvent + ", state=" + state + ", sourceObjectId=" + sourceObjectId
                + ", name=" + getName() + "]";
    }

}
