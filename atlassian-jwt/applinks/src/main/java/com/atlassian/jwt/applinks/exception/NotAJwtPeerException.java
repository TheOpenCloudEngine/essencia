package com.atlassian.jwt.applinks.exception;

import com.atlassian.applinks.api.ApplicationLink;

/**
 * Indicates that this server does not have a JWT relationship (e.g. shared secrets) with the specified
 * {@link ApplicationLink}.
 *
 * @since 1.0
 */
public class NotAJwtPeerException extends RuntimeException
{
    public NotAJwtPeerException(ApplicationLink applicationLink)
    {
        super(applicationLink + " is not a valid JWT peer.");
    }
}
