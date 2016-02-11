package com.atlassian.jwt.core;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.exception.JwtParseException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jwt.JWTClaimsSet;

public class NimbusUtil
{
    public static String getStringClaimValue(JWTClaimsSet claims, String claimName) throws JwtParseException
    {
        try
        {
            return (String) claims.getClaim(claimName);
        }
        catch (ClassCastException e)
        {
            throw new JwtParseException("'" + claimName + "' claim parameter should be a string", e);
        }
    }

    public static JWSAlgorithm asNimbusJWSAlgorithm(SigningAlgorithm algorithm)
    {
        switch (algorithm)
        {
            case HS256:
                return JWSAlgorithm.HS256;
            case RS256:
                return JWSAlgorithm.RS256;
            default:
                throw new IllegalArgumentException("Unrecognised " + SigningAlgorithm.class.getSimpleName() + ": " + algorithm);
        }
    }
}
