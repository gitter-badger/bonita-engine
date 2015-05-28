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
package org.bonitasoft.engine.queriablelogger.model.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.queriablelogger.model.SQueriableLog;
import org.bonitasoft.engine.queriablelogger.model.SQueriableLogSeverity;

/**
 * @author Elias Ricken de Medeiros
 * @author Celine Souchet
 * @author Matthieu Chaffotte
 */
public class SQueriableLogImpl implements SQueriableLog {

    private static final long serialVersionUID = -1680378231407104908L;

    private long tenantId;

    private long id;

    private long timeStamp;

    private int year;

    private int month;

    private int dayOfYear;

    private int weekOfYear;

    private String userId;

    private final long threadNumber;

    private String clusterNode;

    private String productVersion;

    private SQueriableLogSeverity severity;

    private String actionType;

    private String actionScope;

    private int actionStatus;

    private String rawMessage;

    private String callerClassName;

    private String callerMethodName;

    private long numericIndex1;

    private long numericIndex2;

    private long numericIndex3;

    private long numericIndex4;

    private long numericIndex5;

    public SQueriableLogImpl() {
        numericIndex1 = -1;
        numericIndex2 = -1;
        numericIndex3 = -1;
        numericIndex4 = -1;
        numericIndex5 = -1;

        threadNumber = Thread.currentThread().getId();
        severity = null;
        actionStatus = -1;

        final Date date = new Date();
        updateDateElements(date);
    }

    public long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getDiscriminator() {
        return SQueriableLog.class.getName();
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getDayOfYear() {
        return dayOfYear;
    }

    @Override
    public int getWeekOfYear() {
        return weekOfYear;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public long getThreadNumber() {
        return threadNumber;
    }

    @Override
    public String getClusterNode() {
        return clusterNode;
    }

    @Override
    public String getProductVersion() {
        return productVersion;
    }

    @Override
    public SQueriableLogSeverity getSeverity() {
        return severity;
    }

    @Override
    public String getActionType() {
        return actionType;
    }

    @Override
    public String getActionScope() {
        return actionScope;
    }

    @Override
    public int getActionStatus() {
        return actionStatus;
    }

    @Override
    public String getRawMessage() {
        return rawMessage;
    }

    @Override
    public String getCallerClassName() {
        return callerClassName;
    }

    @Override
    public String getCallerMethodName() {
        return callerMethodName;
    }

    @Override
    public long getNumericIndex(final int pos) {
        long result = -1;
        switch (pos) {
            case 0:
                result = numericIndex1;
                break;
            case 1:
                result = numericIndex2;
                break;
            case 2:
                result = numericIndex3;
                break;
            case 3:
                result = numericIndex4;
                break;
            case 4:
                result = numericIndex5;
                break;
            default:
                throw new IllegalStateException();
        }
        return result;
    }

    private void updateDateElements(final Date date) {
        timeStamp = date.getTime();

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1; // January is 0

        weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
    }

    public void setClusterNode(final String clusterNode) {
        this.clusterNode = clusterNode;
    }

    public void setProductVersion(final String productVersion) {
        this.productVersion = productVersion;
    }

    public void setSeverity(final SQueriableLogSeverity severity) {
        this.severity = severity;
    }

    public void setActionType(final String actionType) {
        this.actionType = actionType;
    }

    public void setActionScope(final String actionScope) {
        this.actionScope = actionScope;
    }

    public void setActionStatus(final int actionStatus) {
        this.actionStatus = actionStatus;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setRawMessage(final String rawMessage) {
        this.rawMessage = rawMessage;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    public void setNumericIndex(final int pos, final long value) {
        switch (pos) {
            case 0:
                numericIndex1 = value;
                break;
            case 1:
                numericIndex2 = value;
                break;
            case 2:
                numericIndex3 = value;
                break;
            case 3:
                numericIndex4 = value;
                break;
            case 4:
                numericIndex5 = value;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public void setCallerClassName(final String callerClassName) {
        this.callerClassName = callerClassName;
    }

    public void setCallerMethodName(final String callerMethodName) {
        this.callerMethodName = callerMethodName;
    }

    @Override
    public String toString() {
        return "SQueriableLogImpl [tenantId=" + tenantId + ", id=" + id + ", timeStamp=" + timeStamp + ", year=" + year + ", month=" + month + ", dayOfYear="
                + dayOfYear + ", weekOfYear=" + weekOfYear + ", userId=" + userId + ", threadNumber=" + threadNumber + ", clusterNode=" + clusterNode
                + ", productVersion=" + productVersion + ", severity=" + severity + ", actionType=" + actionType + ", actionScope=" + actionScope
                + ", actionStatus=" + actionStatus + ", rawMessage=" + rawMessage + ", callerClassName=" + callerClassName + ", callerMethodName="
                + callerMethodName + ", numericIndex1=" + numericIndex1 + ", numericIndex2=" + numericIndex2 + ", numericIndex3=" + numericIndex3
                + ", numericIndex4=" + numericIndex4 + ", numericIndex5=" + numericIndex5 + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQueriableLogImpl that = (SQueriableLogImpl) o;
        return Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(timeStamp, that.timeStamp) &&
                Objects.equals(year, that.year) &&
                Objects.equals(month, that.month) &&
                Objects.equals(dayOfYear, that.dayOfYear) &&
                Objects.equals(weekOfYear, that.weekOfYear) &&
                Objects.equals(threadNumber, that.threadNumber) &&
                Objects.equals(actionStatus, that.actionStatus) &&
                Objects.equals(numericIndex1, that.numericIndex1) &&
                Objects.equals(numericIndex2, that.numericIndex2) &&
                Objects.equals(numericIndex3, that.numericIndex3) &&
                Objects.equals(numericIndex4, that.numericIndex4) &&
                Objects.equals(numericIndex5, that.numericIndex5) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(clusterNode, that.clusterNode) &&
                Objects.equals(productVersion, that.productVersion) &&
                Objects.equals(severity, that.severity) &&
                Objects.equals(actionType, that.actionType) &&
                Objects.equals(actionScope, that.actionScope) &&
                Objects.equals(rawMessage, that.rawMessage) &&
                Objects.equals(callerClassName, that.callerClassName) &&
                Objects.equals(callerMethodName, that.callerMethodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, id, timeStamp, year, month, dayOfYear, weekOfYear, userId, threadNumber, clusterNode, productVersion, severity, actionType, actionScope, actionStatus, rawMessage, callerClassName, callerMethodName, numericIndex1, numericIndex2, numericIndex3, numericIndex4, numericIndex5);
    }
}
