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
package org.bonitasoft.engine.platform.session.model.impl;

import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.platform.session.model.SPlatformSession;

/**
 * @author Elias Ricken de Medeiros
 * @author Matthieu Chaffotte
 */
public class SPlatformSessionImpl implements SPlatformSession {

    private static final long serialVersionUID = 1L;

    private final long id;

    private Date creationDate;

    private long duration;

    private Date lastRenewDate;

    private final String userName;

    private long userId;

    public SPlatformSessionImpl(final long id, final String username) {
        this.id = id;
        this.userName = username;
    }

    public SPlatformSessionImpl(final SPlatformSession session) {
        id = session.getId();
        creationDate = session.getCreationDate();
        duration = session.getDuration();
        lastRenewDate = session.getLastRenewDate();
        userName = session.getUserName();
        userId = session.getUserId();
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
    public Date getLastRenewDate() {
        return lastRenewDate;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public Date getExpirationDate() {
        return new Date(this.lastRenewDate.getTime() + duration);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    public void setLastRenewDate(final Date lastRenewDate) {
        this.lastRenewDate = lastRenewDate;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SPlatformSessionImpl that = (SPlatformSessionImpl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(lastRenewDate, that.lastRenewDate) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, duration, lastRenewDate, userName, userId);
    }
}
