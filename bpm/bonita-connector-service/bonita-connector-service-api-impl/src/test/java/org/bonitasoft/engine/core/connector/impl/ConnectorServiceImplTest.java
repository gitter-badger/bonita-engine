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
package org.bonitasoft.engine.core.connector.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.engine.bar.BARResourceType;
import org.bonitasoft.engine.bar.ResourcesService;
import org.bonitasoft.engine.bar.SBARResource;
import org.bonitasoft.engine.cache.CacheService;
import org.bonitasoft.engine.cache.SCacheException;
import org.bonitasoft.engine.connector.ConnectorExecutor;
import org.bonitasoft.engine.core.connector.exception.SConnectorException;
import org.bonitasoft.engine.core.connector.exception.SInvalidConnectorImplementationException;
import org.bonitasoft.engine.core.connector.parser.JarDependencies;
import org.bonitasoft.engine.core.connector.parser.SConnectorImplementationDescriptor;
import org.bonitasoft.engine.core.expression.control.api.ExpressionResolverService;
import org.bonitasoft.engine.core.operation.OperationService;
import org.bonitasoft.engine.core.process.definition.model.SProcessDefinition;
import org.bonitasoft.engine.dependency.DependencyService;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.home.BonitaHomeServer;
import org.bonitasoft.engine.home.ProcessManager;
import org.bonitasoft.engine.io.IOUtil;
import org.bonitasoft.engine.log.technical.TechnicalLoggerService;
import org.bonitasoft.engine.persistence.OrderByType;
import org.bonitasoft.engine.sessionaccessor.ReadSessionAccessor;
import org.bonitasoft.engine.tracking.TimeTracker;
import org.bonitasoft.engine.xml.Parser;
import org.bonitasoft.engine.xml.ParserFactory;
import org.bonitasoft.engine.xml.SXMLParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Baptiste Mesta
 */
@SuppressWarnings("javadoc")
@RunWith(MockitoJUnitRunner.class)
public class ConnectorServiceImplTest {

    @Mock
    private BonitaHomeServer bonitaHomeServer;
    @Mock
    private Parser parser;
    @Mock
    private CacheService cacheService;
    @Mock
    private ParserFactory parserFactory;
    @Mock
    private DependencyService dependencyService;
    @Mock
    private ResourcesService resourcesService;
    @Mock
    private SConnectorImplementationDescriptor connectorImplDescriptorInCache;
    @Mock
    private ConnectorExecutor connectorExecutor;
    @Mock
    private ReadSessionAccessor sessionAccessor;
    @Mock
    private ExpressionResolverService expressionResolverService;
    @Mock
    private OperationService operationService;
    @Mock
    private TimeTracker timeTracker;
    @Mock
    private TechnicalLoggerService technicalLoggerService;
    @Mock
    private ProcessManager processManager;

    private ConnectorServiceImpl connectorService;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {
        doReturn(parser).when(parserFactory).createParser(anyList());
        when(bonitaHomeServer.getProcessManager()).thenReturn(processManager);
        connectorService = spy(new ConnectorServiceImpl(cacheService, connectorExecutor, parserFactory, sessionAccessor, expressionResolverService,
                operationService, dependencyService,
                technicalLoggerService, timeTracker, resourcesService));
        connectorService.setBonitaHomeServer(bonitaHomeServer);
    }

    @Test(expected = SInvalidConnectorImplementationException.class)
    public void checkConnectorImplementationIsValidWithCorruptFile() throws Exception {
        connectorService.checkConnectorImplementationIsValid(new byte[] { 1, 5, 6, 87, 9, 9, 36, 1, 6, 6, 5, 3, 5, 5, 5, 64, 6, 5, 5 }, "myConnector", "1.0.0");
    }

    @Test(expected = SInvalidConnectorImplementationException.class)
    public void checkConnectorImplementationIsValidWithZipHavingNoImpl() throws Exception {
        final byte[] zip = IOUtil.zip(Collections.singletonMap("connector.notImpl", "mocked".getBytes()));
        connectorService.checkConnectorImplementationIsValid(zip, "myConnector", "1.0.0");
    }

    @Test
    public void checkConnectorImplementationIsValidWithValidZip() throws Exception {
        when(parser.getObjectFromXML(eq("mocked".getBytes()))).thenReturn(
                new SConnectorImplementationDescriptor("org.Test", "myConnector", "1.0.0", "myConnector", "1.0.0", new JarDependencies(Collections
                        .<String> emptyList())));
        final byte[] zip = IOUtil.zip(Collections.singletonMap("connector.impl", "mocked".getBytes()));
        connectorService.checkConnectorImplementationIsValid(zip, "myConnector", "1.0.0");
    }

    @Test(expected = SInvalidConnectorImplementationException.class)
    public void checkConnectorImplementationIsValidWithValidFileButWrongImpl() throws Exception {
        when(parser.getObjectFromXML(eq("mocked".getBytes()))).thenReturn(
                new SConnectorImplementationDescriptor("org.Test", "myConnector", "1.0.0", "myConnectorWrong", "1.0.0", new JarDependencies(Collections
                        .<String> emptyList())));
        final byte[] zip = IOUtil.zip(Collections.singletonMap("connector.impl", "mocked".getBytes()));
        connectorService.checkConnectorImplementationIsValid(zip, "myConnector", "1.0.0");
    }

    @Test
    public void setNewConnectorImplemCleansOldDependencies() throws Exception {
        final long tenantId = 98774L;
        final long processDefId = 17L;

        final SProcessDefinition sProcessDef = mock(SProcessDefinition.class);
        when(sProcessDef.getId()).thenReturn(processDefId);
        final String connectorDefId = "org.bonitasoft.connector.BeerConnector";
        final String connectorDefVersion = "1.0.0";
        final String connectorImplId = "org.bonitasoft.connector.HoogardenConnector";
        final String connectorImplVersion = "1.0";
        final String implementationClassName = "org.bonitasoft.engine.connectors.HoogardenBeerConnector";
        final SConnectorImplementationDescriptor hoogardenConnectorDescriptor = new SConnectorImplementationDescriptor(implementationClassName,
                connectorImplId,
                connectorImplVersion, connectorDefId, connectorDefVersion, new JarDependencies(Arrays.asList("some1.jar", "HoogardenConnector.jar")));
        final SConnectorImplementationDescriptor oldConnectorDescriptor = new SConnectorImplementationDescriptor(implementationClassName, connectorImplId,
                connectorImplVersion, connectorDefId, connectorDefVersion, new JarDependencies(Arrays.asList("file.jar")));

        Map<String, byte[]> zipFileMap = new HashMap<>(3);
        final byte[] implBytes = "tototo".getBytes();
        zipFileMap.put("HoogardenBeerConnector.impl", implBytes);
        final byte[] dep1Bytes = { 12, 94, 14, 12 };
        zipFileMap.put("some1.jar", dep1Bytes);
        final byte[] hoogardenConnectorBytes = { 12, 94, 14, 9, 54, 65, 98, 54, 21, 32, 65 };
        zipFileMap.put("HoogardenConnector.jar", hoogardenConnectorBytes);
        final byte[] zip1 = IOUtil.zip(zipFileMap);
        final Map<String, byte[]> returnedMap = new HashMap<>();
        returnedMap.put("file.jar", new byte[] { 1 });
        returnedMap.put("file.impl", new byte[] { 2 });
        when(parser.getObjectFromXML(eq(new byte[] { 2 }))).thenReturn(oldConnectorDescriptor);
        when(parser.getObjectFromXML(eq(implBytes))).thenReturn(hoogardenConnectorDescriptor);

        doReturn(Collections.singletonList(new SBARResource("file.impl", BARResourceType.CONNECTOR, processDefId, new byte[] { 2 }))).when(resourcesService)
                .get(eq(processDefId), eq(BARResourceType.CONNECTOR), eq(0), anyInt());
        connectorService.setConnectorImplementation(sProcessDef, tenantId, connectorDefId, connectorDefVersion, zip1);
        verify(processManager, times(1)).storeClasspathFile(tenantId, processDefId, "HoogardenConnector.jar", hoogardenConnectorBytes);
        verify(processManager, times(1)).storeClasspathFile(tenantId, processDefId, "some1.jar", dep1Bytes);
        verify(processManager, times(1)).storeConnectorFile(tenantId, processDefId, "HoogardenBeerConnector.impl", implBytes);
        //verify(processManager, times(1)).deleteClasspathFiles(tenantId, processDefId, "file.jar");
        //verify(processManager, times(1)).deleteConnectorFile(tenantId, processDefId, "file.impl");
    }

    @Test
    public void setNewConnectorImplemShouldIgnoreSourceFiles() throws Exception {
        final long tenantId = 24L;
        final long processDefId = 1324565477444L;

        final SProcessDefinition sProcessDef = mock(SProcessDefinition.class);
        final String connectorDefId = "org.bonitasoft.connector.BeerConnector";
        final String connectorDefVersion = "1.0.0";
        Map<String, byte[]> zipFileMap = new HashMap<>(1);
        zipFileMap.put("src/net/company/MyImplem.java", "some Java source file content".getBytes());
        final byte[] zip = IOUtil.zip(zipFileMap);

        doNothing().when(connectorService).deleteOldImplementation(tenantId, processDefId, connectorDefId, connectorDefVersion);

        connectorService.unzipNewImplementation(sProcessDef, tenantId, zip, connectorDefId, connectorDefVersion);

        verify(processManager, times(0)).storeConnectorFile(eq(tenantId), eq(processDefId), anyString(), any(byte[].class));
    }

    @Test
    public void getConnectorImplementationShouldReadFileWhenCacheIsVoid() throws Exception {
        checkGetConnectorImplementationUsesCache(0, 1, true);
    }

    @Test
    public void getConnectorImplementationShouldReadFileWhenCacheIsNotEmpty() throws Exception {
        checkGetConnectorImplementationUsesCache(1, 0, true);
    }

    @Test
    public void getConnectorImplementationShouldReadFileWhenCacheDoesNotContainsConnector() throws Exception {
        checkGetConnectorImplementationUsesCache(1, 1, false);
    }

    @Test
    public void getConnectorImplementationShouldNoteReadFileWhenCacheContainsConnector() throws Exception {
        checkGetConnectorImplementationUsesCache(1, 0, true);
    }

    private void checkGetConnectorImplementationUsesCache(final int givenCacheSizeToBeReturned, final int expectedNumberOfCacheStoreInvocations,
            final boolean shouldCacheContainsConnectorImplementation)
                    throws BonitaHomeNotSetException, SXMLParseException,
                    IOException, SConnectorException, SInvalidConnectorImplementationException, SCacheException {

        final long tenantId = 98774L;
        final long processDefId = 17L;
        final SProcessDefinition sProcessDef;
        sProcessDef = mock(SProcessDefinition.class);

        when(sProcessDef.getId()).thenReturn(processDefId);
        final String connectorDefId = "org.bonitasoft.connector.BeerConnector";
        final String connectorDefVersion = "1.0.0";
        final String connectorImplId = "org.bonitasoft.connector.HoogardenConnector";
        final String connectorImplVersion = "1.0";
        final String implementationClassName = "org.bonitasoft.engine.connectors.HoogardenBeerConnector";
        final SConnectorImplementationDescriptor connectorImplDescriptor = new SConnectorImplementationDescriptor(implementationClassName, connectorImplId,
                connectorImplVersion, connectorDefId, connectorDefVersion, new JarDependencies(Arrays.asList("some1.jar", "HoogardenConnector.jar")));
        when(parser.getObjectFromXML(eq("tototo".getBytes()))).thenReturn(connectorImplDescriptor);

        final Map<String, byte[]> zipFileMap = new HashMap<>(3);

        zipFileMap.put("HoogardenBeerConnector.impl", "tototo".getBytes());
        zipFileMap.put("some1.jar", new byte[] { 12, 94, 14, 12 });
        zipFileMap.put("HoogardenConnector.jar", new byte[] { 12, 94, 14, 9, 54, 65, 98, 54, 21, 32, 65 });
        final byte[] zip1 = IOUtil.zip(zipFileMap);

        doReturn(Collections.singletonList(new SBARResource("HoogardenBeerConnector.impl", BARResourceType.CONNECTOR, processDefId, "tototo".getBytes())))
                .when(resourcesService).get(eq(processDefId), eq(BARResourceType.CONNECTOR), eq(0), anyInt());

        //setConnectorImplementation store to cache
        connectorService.setConnectorImplementation(sProcessDef, tenantId, connectorDefId, connectorDefVersion, zip1);

        //given
        doReturn(givenCacheSizeToBeReturned).when(cacheService).getCacheSize(ConnectorServiceImpl.CONNECTOR_CACHE_NAME);

        List<String> cacheContentKeys = Collections.emptyList();
        final String buildConnectorImplementationKey = connectorService
                .buildConnectorImplementationKey(processDefId, connectorImplId, connectorImplVersion);
        if (shouldCacheContainsConnectorImplementation) {
            cacheContentKeys = Collections.singletonList(buildConnectorImplementationKey);
        }
        doReturn(cacheContentKeys).when(cacheService).getKeys(ConnectorServiceImpl.CONNECTOR_CACHE_NAME);
        doReturn(connectorImplDescriptor).when(cacheService).get(ConnectorServiceImpl.CONNECTOR_CACHE_NAME, buildConnectorImplementationKey);

        //when
        connectorService.getConnectorImplementations(processDefId, 0,
                10, "", OrderByType.ASC);

        //then
        verify(cacheService, times(expectedNumberOfCacheStoreInvocations + 1)).store(anyString(), any(Serializable.class), any(Object.class));

    }

}
