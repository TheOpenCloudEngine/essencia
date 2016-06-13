package org.uengine.jwt;

import org.uengine.jwt.exception.JwtParseException;

import javax.annotation.Nonnull;

/**
 * Parses a jwt token without attempting to verify it.
 *
 * @since 1.2.4
 */
public interface JwtParser
{
    /**
     * Parses the given jwt token and returns the decoded claims body
     *
     * @param jwt the jwt token to parse
     * @return a Jwt object representing the decoded claims body
     * @throws JwtParseException if there is a problem parsing the token
     */
    @Nonnull
    Jwt parse(String jwt) throws JwtParseException;
}
