package com.atlassian.jwt.core;

import com.atlassian.jwt.AsymmetricSigningInfo;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.SigningInfo;
import com.atlassian.jwt.SymmetricSigningInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.interfaces.RSAPrivateKey;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;


@RunWith(MockitoJUnitRunner.class)
public class SimpleSigningInfoTest
{
    @Mock
    RSAPrivateKey privateKey;

    @Test
    public void testCreationOfRs256SigningInfo()
    {
        AsymmetricSigningInfo signingInfo = new SimpleAsymmetricSigningInfo(SigningAlgorithm.RS256, privateKey);

        assertEquals(SigningAlgorithm.RS256, signingInfo.getSigningAlgorithm());
        assertEquals(privateKey, signingInfo.getPrivateKey());
    }

    @Test
    public void testCreationOfHs256SigningInfo()
    {
        SymmetricSigningInfo signingInfo = new SimpleSymmetricSigningInfo(SigningAlgorithm.HS256, "my shared secret");

        assertEquals(SigningAlgorithm.HS256, signingInfo.getSigningAlgorithm());
        assertEquals("my shared secret", signingInfo.getSharedSecret());
    }

}
