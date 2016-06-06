package org.uengine.jwt;

import org.uengine.jwt.exception.JwtIssuerLacksSharedSecretException;
import org.uengine.jwt.exception.JwtParseException;
import org.uengine.jwt.exception.JwtUnknownIssuerException;
import org.uengine.jwt.exception.JwtVerificationException;
import org.uengine.jwt.reader.JwtClaimVerifier;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Verifies incoming {@link Jwt JWTs} issued by linked applications and generates {@link Jwt JWTs} for use in outbound
 * requests targeting linked applications.
 *
 * @since 1.3
 */
public interface JwtService {
    /**
     * Generate a JWT for the supplied payload, suitable for authenticating with the specified {@code secret}. This
     * uses {@link SigningAlgorithm#HS256} as the default signing algorithm. Use
     * {@link #issueJwt(String, String, SigningAlgorithm)} to create a JWT with a different algorithm
     *
     * @param jsonPayload     a JSON payload
     * @param secret the shared-secret or private-key used to sign
     * @return the JWT string
     * @throws org.uengine.jwt.exception.JwtSigningException  if a problem was encountered while generating the JWT
     */
    @Nonnull
    String issueJwt(@Nonnull String jsonPayload, @Nonnull String secret);

    /**
     * Generate a JWT for the supplied payload, suitable for authenticating with the specified {@code secret}.
     *
     * @param jsonPayload     a JSON payload
     * @param secret the shared-secret or private-key used to sign
     * @param algorithm the algorithm used to sign the JWT
     * @return the JWT string
     * @throws org.uengine.jwt.exception.JwtSigningException  if a problem was encountered while generating the JWT
     */
    @Nonnull
    String issueJwt(@Nonnull String jsonPayload, @Nonnull String secret, SigningAlgorithm algorithm);

    /**
     * Verify an incoming JWT.
     *
     * @param jwt a JWT extracted from an incoming request.
     * @param claimVerifiers {@link Map} of claim-name to {@link JwtClaimVerifier} that will test its correctness
     *
     * @return the verified JWT if the verification was successful
     * @throws JwtIssuerLacksSharedSecretException if the JWT issuer is known, but does not have a shared secret
     *                                             registered for it
     * @throws JwtParseException         if the JWT is malformed
     * @throws JwtVerificationException  if the JWT is well formed but failed verification
     * @throws JwtUnknownIssuerException if this server does not have a JWT relationship with the issuer indicated in
     *                                   the JWT. This will happen if the linked application's JWT credentials have
     *                                   been revoked, for example.
     */
    @Nonnull
    Jwt verifyJwt(@Nonnull String jwt, @Nonnull Map<String, ? extends JwtClaimVerifier> claimVerifiers) throws
            JwtIssuerLacksSharedSecretException, JwtParseException, JwtUnknownIssuerException, JwtVerificationException;
}
