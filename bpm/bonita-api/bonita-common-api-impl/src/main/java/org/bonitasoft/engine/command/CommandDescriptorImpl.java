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
package org.bonitasoft.engine.command;


import java.util.Objects;

/**
 * @author Zhang Bole
 * @author Matthieu Chaffotte
 */
public class CommandDescriptorImpl implements CommandDescriptor {

    private static final long serialVersionUID = -8798112164975720185L;

    private long id;

    private String name;

    private String description;

    private String implementation;

    private boolean system;

    public CommandDescriptorImpl() {
        super();
    }

    public CommandDescriptorImpl(final String name, final String description, final String implementation) {
        this.name = name;
        this.description = description;
        this.implementation = implementation;
    }

    CommandDescriptorImpl(final CommandDescriptor command) {
        name = command.getName();
        description = command.getDescription();
        implementation = command.getImplementation();
        system = command.isSystemCommand();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getImplementation() {
        return implementation;
    }

    @Override
    public boolean isSystemCommand() {
        return system;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setImplementation(final String implementation) {
        this.implementation = implementation;
    }

    public void setSystem(final boolean system) {
        this.system = system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandDescriptorImpl that = (CommandDescriptorImpl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(system, that.system) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(implementation, that.implementation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, implementation, system);
    }
}
