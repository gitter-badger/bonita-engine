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
package org.bonitasoft.engine.bpm.document.impl;

import java.util.Date;
import java.util.Objects;

import org.bonitasoft.engine.bpm.document.Document;

/**
 * @author Nicolas Chabanoles
 */
public class DocumentImpl implements Document {

    private static final long serialVersionUID = 1956686423434166830L;

    private long id;

    private long processInstanceId;

    private String name;

    private long author;

    private Date creationDate;

    private boolean hasContent;

    private String fileName;

    private String contentMimeType;

    private String contentStorageId;

    private String url;

    private String description;

    private String version;
    private int index;

    public DocumentImpl() {
        super();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(final long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public boolean hasContent() {
        return hasContent;
    }

    public void setHasContent(final boolean hasContent) {
        this.hasContent = hasContent;
    }

    public void setContentMimeType(final String contentMimeType) {
        this.contentMimeType = contentMimeType;
    }

    @Override
    public String getContentMimeType() {
        return contentMimeType;
    }

    @Override
    public long getAuthor() {
        return author;
    }

    @Override
    public String getContentFileName() {
        return fileName;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setAuthor(final long author) {
        this.author = author;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getContentStorageId() {
        return contentStorageId;
    }

    public void setContentStorageId(final String contentStorageId) {
        this.contentStorageId = contentStorageId;

    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentImpl document = (DocumentImpl) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(processInstanceId, document.processInstanceId) &&
                Objects.equals(author, document.author) &&
                Objects.equals(hasContent, document.hasContent) &&
                Objects.equals(index, document.index) &&
                Objects.equals(name, document.name) &&
                Objects.equals(creationDate, document.creationDate) &&
                Objects.equals(fileName, document.fileName) &&
                Objects.equals(contentMimeType, document.contentMimeType) &&
                Objects.equals(contentStorageId, document.contentStorageId) &&
                Objects.equals(url, document.url) &&
                Objects.equals(description, document.description) &&
                Objects.equals(version, document.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, processInstanceId, name, author, creationDate, hasContent, fileName, contentMimeType, contentStorageId, url, description, version, index);
    }

    @Override
    public String toString() {
        return "DocumentImpl{" +
                "id=" + id +
                ", processInstanceId=" + processInstanceId +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", creationDate=" + creationDate +
                ", hasContent=" + hasContent +
                ", fileName='" + fileName + '\'' +
                ", contentMimeType='" + contentMimeType + '\'' +
                ", contentStorageId='" + contentStorageId + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", index=" + index +
                '}';
    }
}
