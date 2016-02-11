package com.atlassian.jwt.core.keys;

import com.atlassian.jwt.exception.JwtCannotRetrieveKeyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStreamReader;
import java.security.interfaces.RSAPrivateKey;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrivateKeyRetrieverTest
{
    @Mock
    private KeyUtils keyUtils;
    @Mock
    private RSAPrivateKey privateKey;

    @Test
    public void shouldBeAbleToReadKeyFromClasspathResource() throws Exception
    {
        PrivateKeyRetriever keyRetriever = new PrivateKeyRetrieverImpl(PrivateKeyRetriever.keyLocationType.CLASSPATH_RESOURCE,
                "private.pem", keyUtils);
        when(keyUtils.readRsaPrivateKeyFromPem(any(InputStreamReader.class))).thenReturn(privateKey);
        RSAPrivateKey result = keyRetriever.getPrivateKey();

        assertEquals(privateKey, result);
    }

    @Test(expected = JwtCannotRetrieveKeyException.class)
    public void shouldGetErrorWhenKeyReadingFromClasspathResourceFails() throws Exception
    {
        PrivateKeyRetriever keyRetriever = new PrivateKeyRetrieverImpl(PrivateKeyRetriever.keyLocationType.CLASSPATH_RESOURCE,
                "private.pem", keyUtils);

        when(keyUtils.readRsaPrivateKeyFromPem(any(InputStreamReader.class))).thenThrow(new JwtCannotRetrieveKeyException("Random error"));
        keyRetriever.getPrivateKey();
    }

    @Test(expected = JwtCannotRetrieveKeyException.class)
    public void shouldGetErrorWhenClasspathResourceDoesNotExist() throws Exception
    {
        PrivateKeyRetriever keyRetriever = new PrivateKeyRetrieverImpl(PrivateKeyRetriever.keyLocationType.CLASSPATH_RESOURCE,
                "non-existent-private.pem", keyUtils);

        keyRetriever.getPrivateKey();
    }

    @Test
    public void shouldBeAbleToReadKeyFromFile() throws Exception
    {
        PrivateKeyRetriever keyRetriever = new PrivateKeyRetrieverImpl(PrivateKeyRetriever.keyLocationType.FILE,
                "target/test-classes/private.pem", keyUtils);

        when(keyUtils.readRsaPrivateKeyFromPem(any(InputStreamReader.class))).thenReturn(privateKey);
        RSAPrivateKey result = keyRetriever.getPrivateKey();

        assertEquals(privateKey, result);

    }

    @Test(expected = JwtCannotRetrieveKeyException.class)
    public void shouldGetErrorWhenReadingKeyFromNonExistentFile() throws Exception
    {
        PrivateKeyRetriever keyRetriever = new PrivateKeyRetrieverImpl(PrivateKeyRetriever.keyLocationType.FILE,
                "non-existent-file", keyUtils);

        keyRetriever.getPrivateKey();
    }

}
