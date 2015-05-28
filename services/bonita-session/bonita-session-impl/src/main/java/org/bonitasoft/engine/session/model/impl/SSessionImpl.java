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
package org.bonitasoft.engine.session.model.impl;

import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.session.model.SSession;

/**
 * @author Elias Ricken de Medeiros
 * @author Yanyan Liu
 * @author Matthieu Chaffotte
 */
public class SSessionImpl implements SSession {

    private static final long serialVersionUID = 1L;

    private long tenantId;

    private final long id;

    private Date creationDate;

    private long duration;

    private Date lastRenewDate;

    private String userName;

    private long userId;

    private String clientIP;

    private String clusterNode;

    private String applicationName;

    private String clientApplicationName;

    private boolean technicalUser;

    public SSessionImpl(final long id, final long tenantId, final String userName, final String applicationName, final long userId) {
        this.id = id;
        this.tenantId = tenantId;
        this.userName = userName;
        this.applicationName = applicationName;
        this.userId = userId;
    }

    public SSessionImpl(final SSession session) {
        id = session.getId();
        tenantId = session.getTenantId();
        creationDate = session.getCreationDate();
        duration = session.getDuration();
        lastRenewDate = session.getLastRenewDate();
        userName = session.getUserName();
        userId = session.getUserId();
        technicalUser = session.isTechnicalUser();
        clientIP = session.getClientIP();
        clusterNode = session.getClusterNode();
        applicationName = session.getApplicationName();
        clientApplicationName = session.getClientApplicationName();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getLastRenewDate() {
        return lastRenewDate;
    }

    public void setLastRenewDate(final Date lastRenewDate) {
        this.lastRenewDate = lastRenewDate;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    @Override
    public Date getExpirationDate() {
        return new Date(lastRenewDate.getTime() + duration);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(final String clientIP) {
        this.clientIP = clientIP;
    }

    @Override
    public String getClusterNode() {
        return clusterNode;
    }

    public void setClusterNode(final String clusterNode) {
        this.clusterNode = clusterNode;
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(final String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public String getClientApplicationName() {
        return clientApplicationName;
    }

    public void setClientApplicationName(final String clientApplicationName) {
        this.clientApplicationName = clientApplicationName;
    }

    @Override
    public boolean isValid() {
        return getExpirationDate().getTime() > System.currentTimeMillis();
    }

    @Override
    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    @Override
    public boolean isTechnicalUser() {
        return technicalUser;
    }

    public void setTechnicalUser(final boolean technicalUser) {
        this.technicalUser = technicalUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SSessionImpl sSession = (SSessionImpl) o;
        return Objects.equals(tenantId, sSession.tenantId) &&
                Objects.equals(id, sSession.id) &&
                Objects.equals(duration, sSession.duration) &&
                Objects.equals(userId, sSession.userId) &&
                Objects.equals(technicalUser, sSession.technicalUser) &&
                Objects.equals(creationDate, sSession.creationDate) &&
                Objects.equals(lastRenewDate, sSession.lastRenewDate) &&
                Objects.equals(userName, sSession.userName) &&
                Objects.equals(clientIP, sSession.clientIP) &&
                Objects.equals(clusterNode, sSession.clusterNode) &&
                Objects.equals(applicationName, sSession.applicationName) &&
                Objects.equals(clientApplicationName, sSession.clientApplicationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, id, creationDate, duration, lastRenewDate, userName, userId, clientIP, clusterNode, applicationName, clientApplicationName, technicalUser);
    }
}
