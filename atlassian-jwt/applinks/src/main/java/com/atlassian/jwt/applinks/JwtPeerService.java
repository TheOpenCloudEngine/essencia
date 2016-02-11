package com.atlassian.jwt.applinks;

import javax.annotation.Nonnull;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.applinks.exception.JwtRegistrationFailedException;

/**
 * Manages registration and revocation of JWT relationships with remote applications linked to this server via
 * {@link ApplicationLink applinks}.
 *
 * @since 1.0
 */
public interface JwtPeerService
{
    /**
     * <p>Issues an id and shared secret to the specified {@link ApplicationLink} at the supplied path.</p>
     * <p>The credentials are issued as an HTTP POST with two application/x-www-form-urlencoded form parameters:</p>
     * <ul>
     * <li><strong>myId</strong> - an identifier that this application will pass in the 'iss' claim when generating
     *                             JWTs
*    * </li>
     * <li><strong>yourId</strong> - an identifier that the linked application MUST pass in the 'iss' claim when
     *                               generating JWTs
     * </li>
     * <li><strong>secret</strong> - a shared secret which should be used to generate HMAC SHA-256 signatures for JWTs</li>
     * </ul>
     * <p>If the linked application returns an HTTP code outside of the 2xx range the registration process is terminated.</p>
     *
     * @param applicationLink the {@link ApplicationLink linked application} to register an JWT relationship with.
     * @param path            the URI (relative to the {@link ApplicationLink}'s base URL) to POST the credentials to.
     * @throws com.atlassian.jwt.applinks.exception.JwtRegistrationFailedException if there was a problem executing the request, or the linked application responded
     *                               with an HTTP code not in the 2xx range.
     */
    void issueSharedSecret(@Nonnull ApplicationLink applicationLink, @Nonnull String path) throws JwtRegistrationFailedException;

    /**
     * <p>Delete the JWT credentials associated with the {@link ApplicationLink linked application}. The linked application
     * is not notified during this operation.</p>
     *
     * <p>This method does nothing if there are no JWT credentials stored for the specified {@link ApplicationLink}.</p>
     *
     * @param applicationLink the {@link ApplicationLink linked application} to delete the JWT credentials for.
     */
    void revokeSharedSecret(@Nonnull ApplicationLink applicationLink);
}
