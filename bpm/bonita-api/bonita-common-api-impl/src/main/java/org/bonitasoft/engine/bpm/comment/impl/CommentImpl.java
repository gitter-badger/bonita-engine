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
package org.bonitasoft.engine.bpm.comment.impl;

import java.util.Objects;

import org.bonitasoft.engine.bpm.comment.Comment;

/**
 * @author Hongwen Zang
 * @author Matthieu Chaffotte
 */
public class CommentImpl implements Comment {

    private static final long serialVersionUID = 2599025748483260550L;

    private long id;

    private long tenantId;

    private Long userId;

    private long processInstanceId;

    private long postDate;

    private String content;

    public CommentImpl() {
        super();
    }

    /**
     * @deprecated As of 6.1 use {@link #CommentImpl()} and the setters
     */
    @Deprecated
    public CommentImpl(final long id, final long tenantId, final long userId, final long processInstanceId, final long postDate, final String content) {
        super();
        this.id = id;
        this.tenantId = tenantId;
        this.userId = userId;
        this.processInstanceId = processInstanceId;
        this.postDate = postDate;
        this.content = content;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public long getProcessInstanceId() {
        return processInstanceId;
    }

    @Override
    public long getPostDate() {
        return postDate;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setProcessInstanceId(final long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setPostDate(final long postDate) {
        this.postDate = postDate;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    @Override
    @Deprecated
    public long getTenantId() {
        return tenantId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Deprecated
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentImpl comment = (CommentImpl) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(tenantId, comment.tenantId) &&
                Objects.equals(processInstanceId, comment.processInstanceId) &&
                Objects.equals(postDate, comment.postDate) &&
                Objects.equals(userId, comment.userId) &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, userId, processInstanceId, postDate, content);
    }

    @Override
    public String toString() {
        return "CommentImpl [id=" + id + ", tenantId=" + tenantId + ", userId=" + userId + ", processInstanceId=" + processInstanceId + ", postDate="
                + postDate + ", content=" + content + "]";
    }

}
