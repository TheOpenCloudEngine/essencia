package com.atlassian.jwt.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.applinks.api.ApplicationType;
import com.atlassian.applinks.api.TypeNotInstalledException;
import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.applinks.exception.NotAJwtPeerException;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtSigningException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import com.atlassian.jwt.exception.JwtVerificationException;
import com.atlassian.jwt.reader.JwtClaimVerifier;

import java.util.Map;

/**
 * Verifies incoming {@link Jwt JWTs} issued by {@link ApplicationLink linked applications} and generates
 * {@link Jwt JWTs} for use in outbound requests targeting {@link ApplicationLink linked applications}.
 *
 * @since 1.0
 * @deprecated in 1.3. Use {@link com.atlassian.jwt.JwtService} instead
 */
@Deprecated
public interface JwtService
{
    /**
     * Determine if this server has a JWT relationship with a {@link ApplicationLink linked application}.
     *
     * @param applicationLink a {@link ApplicationLink linked application}.
     * @return true iff this server has a JWT relationship with the {@link ApplicationLink linked application}.
     */
    boolean isJwtPeer(ApplicationLink applicationLink);

    /**
     * Verify a JWT issued by a {@link ApplicationLink linked application}.
     *
     * @param jwt a JWT extracted from an incoming request.
     * @param claimVerifiers {@link Map} of claim-name to {@link JwtClaimVerifier} that will test its correctness
     * @return the {@link ApplinkJwt verified JWT} if the verification was successful, or throw an exception if
     *         verification failed.
     * @throws NotAJwtPeerException      if this server does not have a JWT relationship with the
     *                                   {@link ApplicationLink linked application} indicated in the JWT. This will happen if the linked application's JWT
     *                                   credentials have been revoked, for example.
     * @throws JwtParseException         if the JWT is malformed
     * @throws JwtVerificationException  if the JWT is well formed but failed verification
     * @throws TypeNotInstalledException if the {@link ApplicationLink linked application's} {@link ApplicationType} is
     *                                   not installed.
     */
    ApplinkJwt verifyJwt(String jwt, Map<String, ? extends JwtClaimVerifier> claimVerifiers) throws NotAJwtPeerException, JwtParseException, JwtVerificationException, TypeNotInstalledException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException;

    /**
     * Generate a JWT for the supplied payload, suitable for authenticating with the specified
     * {@link ApplicationLink linked application}. Use {@link #isJwtPeer(ApplicationLink)} to check whether the
     * {@link ApplicationLink linked application} is a bona fide JWT peer before calling this method.
     *
     * @param jsonPayload     a JSON payload
     * @param applicationLink the {@link ApplicationLink} the JWT will be sent to
     * @return the JWT
     * @throws NotAJwtPeerException if this server does not have a JWT relationship with the
     *                              {@link ApplicationLink linked application} indicated in the JWT.
     * @throws JwtSigningException  if a problem was encountered while generating the JWT
     *
     * @deprecated migrate to {@link #issueJwt(String, String)}
     */
    @Deprecated
    String issueJwt(String jsonPayload, ApplicationLink applicationLink) throws NotAJwtPeerException, JwtSigningException;

    /**
     * Generate a JWT for the supplied payload, suitable for authenticating with the specified {@link String secret}.
     *
     * @param jsonPayload     a JSON payload
     * @param secret the shared-secret or private-key used to sign
     * @return the JWT
     * @throws JwtSigningException  if a problem was encountered while generating the JWT
     */
    String issueJwt(String jsonPayload, String secret) throws JwtSigningException;
}
