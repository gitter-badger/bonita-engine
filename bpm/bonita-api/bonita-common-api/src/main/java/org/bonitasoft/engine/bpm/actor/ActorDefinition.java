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
 */
package org.bonitasoft.engine.bpm.actor;

import java.util.Objects;

import org.bonitasoft.engine.bpm.DescriptionElement;

/**
 * It forms part of the {@link org.bonitasoft.engine.bpm.process.ProcessDefinition}. It is used to design an actor in the context of a process.
 *
 * @author Matthieu Chaffotte
 * @author Emmanuel Duchastenier
 * @author Celine Souchet
 * @see org.bonitasoft.engine.bpm.process.ProcessDefinition
 * @see "The BPMN specification"
 * @since 6.0.0
 * @version 6.4.1
 */
public class ActorDefinition extends DescriptionElement {

    private static final long serialVersionUID = 2L;

    private boolean initiator;

    /**
     * Create a actor definition with his name that is not initiator
     *
     * @param name
     */
    public ActorDefinition(final String name) {
        super(name);
        initiator = false;
    }

    /**
     * Can this actor start the process ?
     *
     * @return <code>true</code>} if this actor can start the process, <code>false</code> otherwise.
     */
    public boolean isInitiator() {
        return initiator;
    }

    public void setInitiator(final boolean initiator) {
        this.initiator = initiator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActorDefinition that = (ActorDefinition) o;
        return Objects.equals(initiator, that.initiator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), initiator);
    }
}
