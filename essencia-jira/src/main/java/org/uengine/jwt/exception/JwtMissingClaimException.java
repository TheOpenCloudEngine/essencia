package org.uengine.jwt.exception;

public class JwtMissingClaimException extends JwtParseException
{
    public JwtMissingClaimException(String reason)
    {
        super(reason);
    }
}
