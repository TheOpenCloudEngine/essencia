package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.applinks.ApplinkJwt;

public class SimpleApplinkJwt implements ApplinkJwt
{
    private final Jwt jwt;
    private final ApplicationLink peer;

    public SimpleApplinkJwt(Jwt jwt, ApplicationLink peer)
    {
        this.jwt = jwt;
        this.peer = peer;
    }

    @Override
    public Jwt getJwt()
    {
        return jwt;
    }

    @Override
    public ApplicationLink getPeer()
    {
        return peer;
    }
}
