package com.atlassian.jwt.core;

import java.util.Date;

public class StaticClock implements Clock
{
    private final Date now;

    public StaticClock(long nowMs)
    {
        this.now = new Date(nowMs);
    }

    @Override
    public Date now()
    {
        return now;
    }
}
