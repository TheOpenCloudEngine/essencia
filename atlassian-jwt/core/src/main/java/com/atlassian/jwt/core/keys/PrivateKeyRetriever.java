package com.atlassian.jwt.core.keys;

import com.atlassian.jwt.exception.JwtCannotRetrieveKeyException;

import java.security.interfaces.RSAPrivateKey;

import javax.annotation.Nonnull;

public interface PrivateKeyRetriever
{
    enum keyLocationType
    {
        FILE, CLASSPATH_RESOURCE
    }

    @Nonnull
    RSAPrivateKey getPrivateKey() throws JwtCannotRetrieveKeyException;
}