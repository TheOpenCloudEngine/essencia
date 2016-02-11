package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.core.Clock;
import com.atlassian.jwt.core.SystemClock;
import com.nimbusds.jose.crypto.MACVerifier;

public class NimbusMacJwtReader extends NimbusJwtReader
{
    public NimbusMacJwtReader(String sharedSecret)
    {
        this(sharedSecret, SystemClock.getInstance());
    }

    public NimbusMacJwtReader(String sharedSecret, Clock clock)
    {
        super(new MACVerifier(sharedSecret), clock);
    }
}
