package com.atlassian.jwt.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.Jwt;

/**
 * A {@link Jwt verified JWT} and the {@link ApplicationLink} that issued it.
 *
 * @since 1.0
 * @deprecated in 1.3
 */
@Deprecated
public interface ApplinkJwt
{
    /**
     * @return the {@link Jwt verified JWT}.
     */
    Jwt getJwt();

    /**
     * @return the {@link ApplicationLink} that issued the JWT.
     */
    ApplicationLink getPeer();
}
