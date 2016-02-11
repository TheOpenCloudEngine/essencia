package com.atlassian.jwt;

import javax.annotation.Nullable;

/**
 * A JSON Web Token.
 *
 * @since 1.0
 */
public interface Jwt
{
    /**
     * @return the value of the 'iss' claim. That is, the principal or application that issued the JWT.
     */
    @Nullable
    String getIssuer();

    /**
     * @return the value of the 'sub' claim. That is, the principal that a request is being executed on the behalf of.
     */
    @Nullable
    String getSubject();

    /**
     * @return a JSON representation of the claims contained in this JWT.
     */
    @Nullable
    String getJsonPayload();
}
