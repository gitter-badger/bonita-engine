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
package org.bonitasoft.engine.bpm.process.impl.internal;

import java.util.Objects;

import org.bonitasoft.engine.bpm.process.Problem;

/**
 * @author Matthieu Chaffotte
 * @author Celine Souchet
 */
public class ProblemImpl implements Problem {

    private static final long serialVersionUID = 267956968537265036L;

    private final Level level;

    private final String resourceId;

    private final String resource;

    private final String description;

    public ProblemImpl(final Level level, final String resourceId, final String resource, final String description) {
        super();
        this.level = level;
        this.resourceId = resourceId;
        this.resource = resource;
        this.description = description;
    }

    public ProblemImpl(final Level level, final long resourceId, final String resource, final String description) {
        super();
        this.level = level;
        this.resourceId = String.valueOf(resourceId);
        this.resource = resource;
        this.description = description;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public String getResource() {
        return resource;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemImpl problem = (ProblemImpl) o;
        return Objects.equals(level, problem.level) &&
                Objects.equals(resourceId, problem.resourceId) &&
                Objects.equals(resource, problem.resource) &&
                Objects.equals(description, problem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, resourceId, resource, description);
    }

    @Override
    public String toString() {
        return "ProblemImpl [level=" + level + ", resourceId=" + resourceId + ", resource=" + resource + ", description=" + description + "]";
    }

}
