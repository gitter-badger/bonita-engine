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
package org.bonitasoft.engine.identity.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.identity.model.SRole;

/**
 * @author Anthony Birembaut
 * @author Bole Zhang
 * @author Matthieu Chaffotte
 */
public class SRoleImpl extends SNamedElementImpl implements SRole {

    private static final long serialVersionUID = 1062675620062005462L;

    private String iconName;

    private String iconPath;

    private long createdBy;

    private long creationDate;

    private long lastUpdate;

    public SRoleImpl() {
        super();
    }

    @Override
    public String getDiscriminator() {
        return SRole.class.getName();
    }

    public void setIconName(final String iconName) {
        this.iconName = iconName;
    }

    public void setIconPath(final String iconPath) {
        this.iconPath = iconPath;
    }

    public void setCreatedBy(final long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationDate(final long creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdate(final long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String getIconName() {
        return iconName;
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }

    @Override
    public long getCreatedBy() {
        return createdBy;
    }

    @Override
    public long getCreationDate() {
        return creationDate;
    }

    @Override
    public long getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "SRoleImpl [getDescription()=" + getDescription() + ", getLabel()=" + getDisplayName() + ", getName()=" + getName() + ", getId()=" + getId()
                + ", getIconName()=" + getIconName() + ", getIconPath()=" + getIconPath() + ", getCreatedBy()=" + getCreatedBy() + ", getCreationDate()="
                + getCreationDate() + ", getLastUpdate()=" + getLastUpdate() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SRoleImpl sRole = (SRoleImpl) o;
        return Objects.equals(createdBy, sRole.createdBy) &&
                Objects.equals(creationDate, sRole.creationDate) &&
                Objects.equals(lastUpdate, sRole.lastUpdate) &&
                Objects.equals(iconName, sRole.iconName) &&
                Objects.equals(iconPath, sRole.iconPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iconName, iconPath, createdBy, creationDate, lastUpdate);
    }
}
