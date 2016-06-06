package org.uengine.jwt;

import org.uengine.jwt.exception.JwsUnsupportedAlgorithmException;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * An enumeration of supported JWS algorithms. Values must match the names used in the JWT 'alg' header. Valid values
 * are specified by <a href="http://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-14">JSON Web Algorithms</a>.
 *
 * @since 1.0
 */
public enum SigningAlgorithm
{
    HS256, RS256; // HMAC SHA-256, RSASSA-PKCS-v1_5

    public static SigningAlgorithm forName(String alg) throws JwsUnsupportedAlgorithmException
    {
        try
        {
            return SigningAlgorithm.valueOf(alg.toUpperCase());
        }
        catch (IllegalArgumentException e)
        {
            throw new JwsUnsupportedAlgorithmException(alg + " is not a supported JWS algorithm. Please try one of: [" +
                    StringUtils.join(Arrays.asList(SigningAlgorithm.values()), ",") + "]");
        }
    }

    public boolean requiresSharedSecret()
    {
        return equals(HS256);
    }

    public boolean requiresKeyPair()
    {
        return equals(RS256);
    }
}
