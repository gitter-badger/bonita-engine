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
package org.bonitasoft.engine.bpm.flownode.impl.internal;

import java.util.Objects;

import org.bonitasoft.engine.bpm.flownode.StandardLoopCharacteristics;
import org.bonitasoft.engine.bpm.process.ModelFinderVisitor;
import org.bonitasoft.engine.expression.Expression;

/**
 * @author Matthieu Chaffotte
 * @author Celine Souchet
 */
public class StandardLoopCharacteristicsImpl implements StandardLoopCharacteristics {

    private static final long serialVersionUID = -8405419721405699090L;

    private final Expression loopCondition;

    private final boolean testBefore;

    private final Expression loopMax;

    public StandardLoopCharacteristicsImpl(final Expression loopCondition, final boolean testBefore) {
        super();
        this.loopCondition = loopCondition;
        this.testBefore = testBefore;
        loopMax = null;
    }

    public StandardLoopCharacteristicsImpl(final Expression loopCondition, final boolean testBefore, final Expression loopMax) {
        super();
        this.loopCondition = loopCondition;
        this.testBefore = testBefore;
        this.loopMax = loopMax;
    }

    public Expression getLoopCondition() {
        return loopCondition;
    }

    public boolean isTestBefore() {
        return testBefore;
    }

    public Expression getLoopMax() {
        return loopMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardLoopCharacteristicsImpl that = (StandardLoopCharacteristicsImpl) o;
        return Objects.equals(testBefore, that.testBefore) &&
                Objects.equals(loopCondition, that.loopCondition) &&
                Objects.equals(loopMax, that.loopMax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loopCondition, testBefore, loopMax);
    }

    @Override
    public void accept(ModelFinderVisitor visitor, long modelId) {
        visitor.find(this, modelId);
    }

}
