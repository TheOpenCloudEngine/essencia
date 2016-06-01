package org.uengine.jwt.writer;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Utility for generating JSON payloads for JWTs.
 *
 * @since 1.0
 */
public interface JwtJsonBuilder
{
    /**
     * Sets the 'aud' parameter.
     */
    @Nonnull
    JwtJsonBuilder audience(@Nonnull String aud);

    /**
     * Sets the 'exp' parameter.
     */
    @Nonnull
    JwtJsonBuilder expirationTime(long exp);

    /**
     * Sets the 'iat' parameter.
     */
    @Nonnull
    JwtJsonBuilder issuedAt(long iat);

    /**
     * Sets the 'iss' parameter.
     */
    @Nonnull
    JwtJsonBuilder issuer(@Nonnull String iss);

    /**
     * Sets the 'jti' parameter.
     */
    @Nonnull
    JwtJsonBuilder jwtId(@Nonnull String jti);

    /**
     * Sets the 'nbf' parameter.
     */
    @Nonnull
    JwtJsonBuilder notBefore(long nbf);

    /**
     * Sets the 'sub' parameter.
     */
    @Nonnull
    JwtJsonBuilder subject(@Nonnull String sub);

    /**
     * Sets the 'typ' parameter.
     */
    @Nonnull
    JwtJsonBuilder type(@Nonnull String typ);

    /**
     * Sets the 'qsh' parameter
     */
    @Nonnull
    JwtJsonBuilder queryHash(@Nonnull String qsh);

    /**
     * Adds an arbitrary claim.
     *
     * @param name the claim's name.
     * @param obj  the claim's value. Allowed types are:
     *             <ul>
     *             <li>{@link String}</li>
     *             <li>{@link Boolean}</li>
     *             <li>{@link Number}</li>
     *             <li>a {@link Map} of {@link String} to any of the above</li>
     *             <li>an array of any of the above</li>
     *             </ul>
     */
    @Nonnull
    JwtJsonBuilder claim(@Nonnull String name, @Nonnull Object obj);

    /**
     * @return the generated JSON.
     */
    @Nonnull
    String build();
}
