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
package org.bonitasoft.engine.business.application.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Elias Ricken de Medeiros
 */
public class MenuIndexValidator {


    public List<String> validate(MenuIndex oldIndex, MenuIndex newIndex) {
        final List<String> problems = new ArrayList<>(1);
        int lastValidIndex = getLastValidIndex(oldIndex, newIndex);
        if (newIndex.getValue() < 1 || newIndex.getValue() > lastValidIndex) {
            problems.add("Invalid menu index: " + newIndex.getValue() + ". It must be between 1 and the number of menu in your application having the same parent. The last valid index for parent " + newIndex.getParentId() + " is " + lastValidIndex);
        }
        return problems;
    }

    private int getLastValidIndex(MenuIndex oldIndex, MenuIndex newIndex) {
        int lastValidIndex = newIndex.getLastUsedIndex();
        if(!Objects.equals(oldIndex.getParentId(), newIndex.getParentId())) {
            // a new element will be added in this parent
            lastValidIndex = newIndex.getLastUsedIndex() + 1;
        }
        return lastValidIndex;
    }

}
