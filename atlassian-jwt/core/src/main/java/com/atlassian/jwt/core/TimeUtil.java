package com.atlassian.jwt.core;

public class TimeUtil
{
    public static long currentTimeSeconds()
    {
        return System.currentTimeMillis() / 1000;
    }

    public static long currentTimePlusNSeconds(long n)
    {
        return currentTimeSeconds() + n;
    }
}
