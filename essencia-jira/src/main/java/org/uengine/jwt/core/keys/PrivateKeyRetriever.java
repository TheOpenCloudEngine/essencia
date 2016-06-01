package org.uengine.jwt.core.keys;

import org.uengine.jwt.exception.JwtCannotRetrieveKeyException;

import javax.annotation.Nonnull;
import java.security.interfaces.RSAPrivateKey;

public interface PrivateKeyRetriever
{
    enum keyLocationType
    {
        FILE, CLASSPATH_RESOURCE
    }

    @Nonnull
    RSAPrivateKey getPrivateKey() throws JwtCannotRetrieveKeyException;
}