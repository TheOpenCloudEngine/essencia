package com.atlassian.jwt.core.writer;


import com.atlassian.jwt.AsymmetricSigningInfo;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.SymmetricSigningInfo;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.interfaces.RSAPrivateKey;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NimbusJwtWriterFactoryTest
{
    @Mock
    NimbusJwtWriterFactory.NimbusJwtWriterFactoryHelper mockFactoryHelper;

    @Mock
    RSAPrivateKey privateKey;

    @Mock
    SymmetricSigningInfo symmetricSigningInfo;

    @Mock
    AsymmetricSigningInfo asymmetricSigningInfo;

    @Test
    public void verifyCorrectCreationOfRsJwtWriter()
    {
        when(asymmetricSigningInfo.getSigningAlgorithm()).thenReturn(SigningAlgorithm.RS256);
        when(asymmetricSigningInfo.getPrivateKey()).thenReturn(privateKey);

        NimbusJwtWriterFactory factory = new NimbusJwtWriterFactory(mockFactoryHelper);

        factory.signingWriter(asymmetricSigningInfo);

        verify(mockFactoryHelper).makeRsJwtWriter(eq(SigningAlgorithm.RS256), any(RSASSASigner.class));
        verify(mockFactoryHelper, never()).makeMacJwtWriter(any(SigningAlgorithm.class), any(MACSigner.class));
    }

    @Test
    public void verifyCorrectCreationOfMacJwtWriter()
    {
        when(symmetricSigningInfo.getSigningAlgorithm()).thenReturn(SigningAlgorithm.HS256);
        when(symmetricSigningInfo.getSharedSecret()).thenReturn("shared secret");


        NimbusJwtWriterFactory factory = new NimbusJwtWriterFactory(mockFactoryHelper);

        factory.signingWriter(symmetricSigningInfo);

        verify(mockFactoryHelper).makeMacJwtWriter(eq(SigningAlgorithm.HS256), any(MACSigner.class));
        verify(mockFactoryHelper, never()).makeRsJwtWriter(any(SigningAlgorithm.class), any(RSASSASigner.class));
    }
}
