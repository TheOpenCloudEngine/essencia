package com.atlassian.jwt.exception;

public class JwtUserRejectedException extends Exception
{
    public JwtUserRejectedException(String reason)
    {
        super(reason);
    }
}
