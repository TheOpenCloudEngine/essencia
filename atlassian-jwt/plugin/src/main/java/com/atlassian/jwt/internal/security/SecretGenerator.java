package com.atlassian.jwt.internal.security;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.security.random.DefaultSecureRandomService;
import org.apache.commons.codec.binary.Base64;

public class SecretGenerator
{
    /**
     * @param alg the {@link SigningAlgorithm} that will use the generated secret
     * @return a url-safe (that is, suitable for placing in a URL or form body) shared secret.
     */
    public static String generateUrlSafeSharedSecret(SigningAlgorithm alg)
    {
        // key length must equal length of HMAC output (http://tools.ietf.org/html/rfc4868#section-2.1.1)
        int length;
        switch (alg)
        {
            case HS256:
                length = 32;
                break;
            default:
                throw new IllegalArgumentException("Unrecognised " + SigningAlgorithm.class.getSimpleName() + ": " + alg);
        }

        byte[] bytes = new byte[length];
        DefaultSecureRandomService.getInstance().nextBytes(bytes);
        return Base64.encodeBase64URLSafeString(bytes);
    }

}
