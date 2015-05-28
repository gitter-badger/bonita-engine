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

import org.bonitasoft.engine.identity.model.SGroup;

/**
 * @author Anthony Birembaut
 * @author Baptiste Mesta
 * @author Matthieu Chaffotte
 */
public class SGroupImpl extends SNamedElementImpl implements SGroup {

    private static final long serialVersionUID = -3998305885633448998L;

    private String parentPath;

    private String iconName;

    private String iconPath;

    private long createdBy;

    private long creationDate;

    private long lastUpdate;

    public SGroupImpl() {
        super();
    }

    @Override
    public String getDiscriminator() {
        return SGroup.class.getName();
    }

    @Override
    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(final String parentPath) {
        this.parentPath = parentPath;
    }

    @Override
    public String getIconName() {
        return iconName;
    }

    public void setIconName(final String iconName) {
        this.iconName = iconName;
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(final String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final long creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String getPath() {
        if (parentPath == null) {
            return "/" + getName();
        }
        return parentPath + "/" + getName();
    }

    @Override
    public String toString() {
        return "SGroupImpl [path=" + getPath() + ", getDescription()=" + getDescription() + ", getDisplayName()=" + getDisplayName() + ", getId()=" + getId()
                + ", getIconName()=" + getIconName() + ", getIconPath()=" + getIconPath() + ", getCreatedBy()=" + getCreatedBy() + ", getCreationDate()="
                + getCreationDate() + ", getLastUpdate()=" + getLastUpdate() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SGroupImpl sGroup = (SGroupImpl) o;
        return Objects.equals(createdBy, sGroup.createdBy) &&
                Objects.equals(creationDate, sGroup.creationDate) &&
                Objects.equals(lastUpdate, sGroup.lastUpdate) &&
                Objects.equals(parentPath, sGroup.parentPath) &&
                Objects.equals(iconName, sGroup.iconName) &&
                Objects.equals(iconPath, sGroup.iconPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parentPath, iconName, iconPath, createdBy, creationDate, lastUpdate);
    }
}
