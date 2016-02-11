package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.core.Clock;
import com.atlassian.jwt.core.SystemClock;
import com.nimbusds.jose.crypto.RSASSAVerifier;

import java.security.interfaces.RSAPublicKey;

public class NimbusRsJwtReader extends NimbusJwtReader
{
    public NimbusRsJwtReader(RSAPublicKey publicKey)
    {
        this(publicKey, SystemClock.getInstance());
    }

    public NimbusRsJwtReader(RSAPublicKey publicKey, Clock clock)
    {
        super(new RSASSAVerifier(publicKey), clock);
    }
}
