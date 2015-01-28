/*******************************************************************************
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 ******************************************************************************/

package org.bonitasoft.engine.business.application.importer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.net.URL;

import javax.xml.bind.JAXBException;

import org.bonitasoft.engine.business.application.xml.ApplicationNodeContainer;
import org.bonitasoft.engine.commons.io.IOUtil;
import org.bonitasoft.engine.exception.ImportException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtil.class)
public class ApplicationContainerImporterTest {

    private ApplicationContainerImporter importer;

    @Before
    public void setUp() throws Exception {
        importer = new ApplicationContainerImporter();

    }

    @Test
    public void importXML_should_return_result_of_unmarshall() throws Exception {
        //given
        mockStatic(IOUtil.class);
        final ApplicationNodeContainer container = mock(ApplicationNodeContainer.class);
        given(IOUtil.unmarshallXMLtoObject(any(byte[].class), eq(ApplicationNodeContainer.class), any(URL.class))).willReturn(container);

        //when
        final ApplicationNodeContainer importedContainer = importer.importXML("<applications/>".getBytes());

        //then
        assertThat(importedContainer).isEqualTo(container);
    }

    @Test(expected = ImportException.class)
    public void importXML_should_throw_ExecutionException_when_unmarshall_throws_exception() throws Exception {
        //given
        mockStatic(IOUtil.class);
        given(IOUtil.unmarshallXMLtoObject(any(byte[].class), eq(ApplicationNodeContainer.class), any(URL.class))).willThrow(new JAXBException(""));

        //when
        importer.importXML("<applications/>".getBytes());

        //then exception
    }

}