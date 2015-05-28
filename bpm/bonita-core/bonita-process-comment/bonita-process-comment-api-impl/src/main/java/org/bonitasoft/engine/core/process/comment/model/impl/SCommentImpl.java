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
package org.bonitasoft.engine.core.process.comment.model.impl;

import java.util.Objects;

import org.bonitasoft.engine.core.process.comment.model.SComment;

/**
 * @author Elias Ricken de Medeiros
 * @author Baptiste Mesta
 * @author Matthieu Chaffotte
 */
public abstract class SCommentImpl implements SComment {

    private static final long serialVersionUID = -2037107708866616881L;

    private long id;

    private long tenantId;

    private Long userId;

    private long processInstanceId;

    private long postDate;

    private String content;

    private String kind;

    SCommentImpl() {
        super();
    }

    public SCommentImpl(final long processInstanceId, final String content) {
        super();
        this.processInstanceId = processInstanceId;
        this.content = content;
    }

    @Override
    public String getDiscriminator() {
        return SComment.class.getName();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(final long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    @Override
    public long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(final long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public long getPostDate() {
        return postDate;
    }

    public void setPostDate(final long postDate) {
        this.postDate = postDate;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public String getKind() {
        return kind;
    }

    public void setKind(final String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SCommentImpl sComment = (SCommentImpl) o;
        return Objects.equals(id, sComment.id) &&
                Objects.equals(tenantId, sComment.tenantId) &&
                Objects.equals(processInstanceId, sComment.processInstanceId) &&
                Objects.equals(postDate, sComment.postDate) &&
                Objects.equals(userId, sComment.userId) &&
                Objects.equals(content, sComment.content) &&
                Objects.equals(kind, sComment.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, userId, processInstanceId, postDate, content, kind);
    }

    @Override
    public String toString() {
        return "SCommentImpl [id=" + id + ", tenantId=" + tenantId + ", userId=" + userId + ", processInstanceId=" + processInstanceId + ", postDate="
                + postDate + ", content=" + content + ", kind=" + kind + "]";
    }

}
