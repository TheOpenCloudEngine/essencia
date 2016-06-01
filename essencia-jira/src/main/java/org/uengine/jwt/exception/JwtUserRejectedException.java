package org.uengine.jwt.exception;

public class JwtUserRejectedException extends Exception
{
    public JwtUserRejectedException(String reason)
    {
        super(reason);
    }
}
