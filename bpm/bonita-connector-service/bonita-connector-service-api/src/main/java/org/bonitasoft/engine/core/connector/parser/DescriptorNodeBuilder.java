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
package org.bonitasoft.engine.core.connector.parser;

import java.util.List;

import org.bonitasoft.engine.xml.XMLNode;

/**
 * @author Yanyan Liu
 */
public class DescriptorNodeBuilder {

    public static XMLNode getDocument(final SConnectorImplementationDescriptor descriptor) {
        final XMLNode connector = new XMLNode(XMLDescriptor.CONNECTOR_IMPLEMENTATION);
        connector.addChild(XMLDescriptor.IMPLEMENTATION_ID, descriptor.getId());
        connector.addChild(XMLDescriptor.IMPLEMENTATION_VERSION, descriptor.getVersion());
        connector.addChild(XMLDescriptor.DEFINITION_ID, descriptor.getDefinitionId());
        connector.addChild(XMLDescriptor.DEFINITION_VERSION, descriptor.getDefinitionVersion());
        connector.addChild(XMLDescriptor.IMPLEMENTATION_CLASSNAME, descriptor.getImplementationClassName());
        final JarDependencies jarDependencies = descriptor.getJarDependencies();
        if (jarDependencies != null) {
            final XMLNode jarDependenciesNodes = getJarDependencies(jarDependencies);
            connector.addChild(jarDependenciesNodes);
        }
        return connector;
    }

    private static XMLNode getJarDependencies(final JarDependencies jarDependencies) {
        final XMLNode jarDependenciesNode = new XMLNode(XMLDescriptor.JAR_DEPENDENCIES);
        final List<String> dependencies = jarDependencies.getDependencies();
        for (final String dependency : dependencies) {
            final XMLNode dependencyNode = new XMLNode(XMLDescriptor.JAR_DEPENDENCY);
            dependencyNode.setContent(dependency);
            jarDependenciesNode.addChild(dependencyNode);
        }
        return jarDependenciesNode;
    }

}
