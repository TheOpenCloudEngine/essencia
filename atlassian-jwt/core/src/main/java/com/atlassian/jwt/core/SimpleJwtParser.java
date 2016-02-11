package com.atlassian.jwt.core;


import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.JwtParser;
import com.atlassian.jwt.exception.JwtParseException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jwt.JWTClaimsSet;

import java.text.ParseException;

import javax.annotation.Nonnull;

public class SimpleJwtParser implements JwtParser
{
    @Nonnull
    @Override
    public Jwt parse(String jwt) throws JwtParseException
    {
        JWSObject jwsObject = parseJWSObject(jwt);
        try
        {
            JWTClaimsSet claims = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());
            return new SimpleJwt(claims.getIssuer(), claims.getSubject(), jwsObject.getPayload().toString());
        }
        catch (ParseException e)
        {
            throw new JwtParseException(e);
        }
    }

    private JWSObject parseJWSObject(String jwt) throws JwtParseException
    {
        JWSObject jwsObject;

        try
        {
            jwsObject = JWSObject.parse(jwt);
        }
        catch (ParseException e)
        {
            throw new JwtParseException(e);
        }
        return jwsObject;
    }
}
