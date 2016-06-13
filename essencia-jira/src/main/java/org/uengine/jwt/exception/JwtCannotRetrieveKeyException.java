package org.uengine.jwt.exception;

public class JwtCannotRetrieveKeyException extends Exception
{
    public JwtCannotRetrieveKeyException(String reason)
    {
        super(reason);
    }

    public JwtCannotRetrieveKeyException(String message, Throwable cause)
    {
        super(message, cause);
    }


}
