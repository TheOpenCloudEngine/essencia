package com.atlassian.jwt.core.keys;


import com.atlassian.jwt.exception.JwtCannotRetrieveKeyException;
import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.interfaces.RSAPrivateKey;

import javax.annotation.Nonnull;

public class PrivateKeyRetrieverImpl implements PrivateKeyRetriever
{
    private final keyLocationType type;
    private final String location;
    private final KeyUtils keyUtils;

    public PrivateKeyRetrieverImpl(keyLocationType type, String keyLocation)
    {
        this.type = type;
        this.location = keyLocation;
        this.keyUtils = new KeyUtils();
    }

    public PrivateKeyRetrieverImpl(keyLocationType type, String keyLocation, KeyUtils keyUtils)
    {
        this.type = type;
        this.location = keyLocation;
        this.keyUtils = keyUtils;
    }

    @Nonnull
    @Override
    public RSAPrivateKey getPrivateKey() throws JwtCannotRetrieveKeyException
    {
        if (type == keyLocationType.CLASSPATH_RESOURCE)
        {
            return getPrivateKeyFromClasspathResource();
        }
        else if (type == keyLocationType.FILE)
        {
            return getPrivateKeyFromFile();
        }
        else
        {
            throw new JwtCannotRetrieveKeyException("Unsupported key location type " + type);
        }
    }

    private RSAPrivateKey getPrivateKeyFromClasspathResource() throws JwtCannotRetrieveKeyException
    {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);

        if (in == null)
        {
            throw new JwtCannotRetrieveKeyException("Could not load classpath resource " + location);
        }

        return keyUtils.readRsaPrivateKeyFromPem(new InputStreamReader(in));
    }

    private RSAPrivateKey getPrivateKeyFromFile() throws JwtCannotRetrieveKeyException
    {
        FileReader reader = null;
        try
        {
            reader = new FileReader(location);
        } catch (IOException e)
        {
            throw new JwtCannotRetrieveKeyException("Private key file not found: " + location, e);
        }
        finally
        {
            IOUtils.closeQuietly(reader);
        }
        return keyUtils.readRsaPrivateKeyFromPem(reader);
    }

}
