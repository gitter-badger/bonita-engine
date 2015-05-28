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
package org.bonitasoft.engine.session.impl;

import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.session.Session;

/**
 * @author Elias Ricken de Medeiros
 * @author Matthieu Chaffotte
 */
public abstract class SessionImpl implements Session {

    private static final long serialVersionUID = 6052091753899175734L;

    private long id;

    private Date creationDate;

    private long duration;

    private String userName;

    private long userId;

    private boolean technicalUser = false;

    public SessionImpl(final long id, final Date creationDate, final long duration, final String userName, final long userId) {
        super();
        this.id = id;
        this.creationDate = creationDate;
        this.duration = duration;
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public boolean isTechnicalUser() {
        return technicalUser;
    }

    public void setTechnicalUser(final boolean technicalUser) {
        this.technicalUser = technicalUser;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionImpl session = (SessionImpl) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(duration, session.duration) &&
                Objects.equals(userId, session.userId) &&
                Objects.equals(technicalUser, session.technicalUser) &&
                Objects.equals(creationDate, session.creationDate) &&
                Objects.equals(userName, session.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, duration, userName, userId, technicalUser);
    }

    @Override
    public String toString() {
        return "SessionImpl [id=" + id + ", creationDate=" + creationDate + ", duration=" + duration + ", userName=" + userName + ", userId=" + userId + ", technicalUser=" + technicalUser + "]";
    }

}
