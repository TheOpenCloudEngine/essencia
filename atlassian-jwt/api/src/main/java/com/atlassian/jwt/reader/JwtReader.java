package com.atlassian.jwt.reader;

import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtVerificationException;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Parses and verifies {@link Jwt}s attached to incoming requests.
 *
 * @since 1.0
 */
public interface JwtReader
{
    /**
     * Parses the encoded JWT message from {@link String} and on success returns the decoded {@link Jwt}.
     * Does not attempt signature verification. (Useful if e.g. you need to know something from the JWT in order to determine the key.)
     *
     * @param jwt            a JSON Web Token, (see <a href="http://tools.ietf.org/html/draft-jones-json-web-token-10#section-3.1">example</a>)
     * @return a verified {@link Jwt}
     * @throws JwtParseException        if the JWT string was malformed
     */
    @Nonnull
    Jwt readUnverified(@Nonnull String jwt) throws JwtParseException, JwtVerificationException;

    /**
     * Parses the encoded JWT message from {@link String}, verifies its signature (if there is one) and on success returns the decoded {@link Jwt}.
     *
     * @param jwt            a JSON Web Token, (see <a href="http://tools.ietf.org/html/draft-jones-json-web-token-10#section-3.1">example</a>)
     * @param requiredClaims claims that must be present, the specified values
     * @return a verified {@link Jwt}
     * @throws JwtParseException        if the JWT string was malformed
     * @throws JwtVerificationException if the JWT string was well-formed but failed verification
     */
    @Nonnull
    Jwt readAndVerify(@Nonnull String jwt, @Nonnull Map<String, ? extends JwtClaimVerifier> requiredClaims) throws JwtParseException, JwtVerificationException;

    /**
     *
     * Parses the encoded JWT message from {@link String}, verifies its signature (if there is one) and on success returns the decoded {@link Jwt}.
     * Deprecated because verification is not actually required in order to read the contents of a JWT.
     * Use {@link #readAndVerify(String, Map)} or {@link #readUnverified(String)} instead.
     *
     * @param jwt            a JSON Web Token, (see <a href="http://tools.ietf.org/html/draft-jones-json-web-token-10#section-3.1">example</a>)
     * @param requiredClaims claims that must be present, the specified values
     * @return a verified {@link Jwt}
     * @throws JwtParseException        if the JWT string was malformed
     * @throws JwtVerificationException if the JWT string was well-formed but failed verification
     */
    @Deprecated
    @Nonnull
    Jwt read(@Nonnull String jwt, @Nonnull Map<String, ? extends JwtClaimVerifier> requiredClaims) throws JwtParseException, JwtVerificationException;
}
