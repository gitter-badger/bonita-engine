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
package org.bonitasoft.engine.core.process.comment.model.archive.impl;

import java.util.Objects;

import org.bonitasoft.engine.core.process.comment.model.SComment;
import org.bonitasoft.engine.core.process.comment.model.archive.SAComment;
import org.bonitasoft.engine.persistence.PersistentObject;

/**
 * @author Zhang Bole
 * @author Matthieu Chaffotte
 */
public class SACommentImpl implements SAComment {

    private static final long serialVersionUID = -1321200639098435989L;

    private long id;

    private long tenantId;

    private Long userId;

    private long processInstanceId;

    private long sourceObjectId;

    private long postDate;

    private long archiveDate;

    private String content;

    public SACommentImpl() {
        super();
    }

    public SACommentImpl(final SComment sComment) {
        tenantId = sComment.getTenantId();
        content = sComment.getContent();
        postDate = sComment.getPostDate();
        sourceObjectId = sComment.getId();
        processInstanceId = sComment.getProcessInstanceId();
        userId = sComment.getUserId();
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
    public long getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(final long archiveDate) {
        this.archiveDate = archiveDate;
    }

    @Override
    public long getSourceObjectId() {
        return sourceObjectId;
    }

    public void setSourceObjectId(final long sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SACommentImpl saComment = (SACommentImpl) o;
        return Objects.equals(id, saComment.id) &&
                Objects.equals(tenantId, saComment.tenantId) &&
                Objects.equals(processInstanceId, saComment.processInstanceId) &&
                Objects.equals(sourceObjectId, saComment.sourceObjectId) &&
                Objects.equals(postDate, saComment.postDate) &&
                Objects.equals(archiveDate, saComment.archiveDate) &&
                Objects.equals(userId, saComment.userId) &&
                Objects.equals(content, saComment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenantId, userId, processInstanceId, sourceObjectId, postDate, archiveDate, content);
    }

    @Override
    public String toString() {
        return "SACommentImpl [id=" + id + ", tenantId=" + tenantId + ", userId=" + userId + ", processInstanceId=" + processInstanceId + ", sourceObjectId="
                + sourceObjectId + ", postDate=" + postDate + ", archiveDate=" + archiveDate + ", content=" + content + "]";
    }

    @Override
    public Class<? extends PersistentObject> getPersistentObjectInterface() {
        return SComment.class;
    }

}
