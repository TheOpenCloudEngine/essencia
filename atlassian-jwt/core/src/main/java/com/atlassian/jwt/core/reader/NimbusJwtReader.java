package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.JwtConstants;
import com.atlassian.jwt.core.Clock;
import com.atlassian.jwt.core.SimpleJwt;
import com.atlassian.jwt.exception.*;
import com.atlassian.jwt.reader.JwtClaimVerifier;
import com.atlassian.jwt.reader.JwtReader;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import net.minidev.json.JSONObject;

import javax.annotation.Nonnull;
import java.text.ParseException;
import java.util.*;

import static java.util.Arrays.asList;

public class NimbusJwtReader implements JwtReader
{
    private static final String UNEXPECTED_TYPE_MESSAGE_PREFIX = "Unexpected type of JSON object member with key ";
    private static final Set<String> NUMERIC_CLAIM_NAMES = new HashSet<String>(asList("exp", "iat", "nbf"));
    private final JWSVerifier verifier;
    private final Clock clock;

    public NimbusJwtReader(JWSVerifier verifier, Clock clock)
    {
        this.verifier = verifier;
        this.clock = clock;
    }

    @Override
    @Nonnull
    public Jwt readUnverified(@Nonnull final String jwt) throws JwtParseException, JwtVerificationException
    {
        return read(jwt, null, false);
    }

    @Override
    @Nonnull
    public Jwt readAndVerify(@Nonnull final String jwt, @Nonnull final Map<String, ? extends JwtClaimVerifier> requiredClaims) throws JwtParseException, JwtVerificationException
    {
        return read(jwt, requiredClaims, true);
    }

    @Deprecated
    @Nonnull
    @Override
    public Jwt read(@Nonnull final String jwt, @Nonnull final Map<String, ? extends JwtClaimVerifier> requiredClaims) throws JwtParseException, JwtVerificationException
    {
        return read(jwt, requiredClaims, true);
    }

    private Jwt read(@Nonnull final String jwt, final Map<String, ? extends JwtClaimVerifier> requiredClaims, final boolean verify) throws JwtParseException, JwtVerificationException
    {
        JWSObject jwsObject;

        if (verify)
        {
            jwsObject = verify(jwt);
        }
        else
        {
            try
            {
                jwsObject = JWSObject.parse(jwt);
            }
            catch (ParseException e)
            {
                throw new JwtParseException(e);
            }
        }

        JSONObject jsonPayload = jwsObject.getPayload().toJSONObject();
        JWTClaimsSet claims;

        try
        {
            claims = JWTClaimsSet.parse(jsonPayload);
        }
        catch (ParseException e)
        {
            // if possible, provide a hint to the add-on developer
            if (e.getMessage().startsWith(UNEXPECTED_TYPE_MESSAGE_PREFIX))
            {
                String claimName = e.getMessage().replace(UNEXPECTED_TYPE_MESSAGE_PREFIX, "").replaceAll("\"", "");

                if (NUMERIC_CLAIM_NAMES.contains(claimName))
                {
                    throw new JwtInvalidClaimException(String.format("Expecting claim '%s' to be numeric but it is a string", claimName), e);
                }

                throw new JwtParseException("Perhaps a claim is of the wrong type (e.g. expecting integer but found string): " + e.getMessage(), e);
            }

            throw new JwtParseException(e);
        }

        if (claims.getIssueTime() == null || claims.getExpirationTime() == null)
        {
            throw new JwtInvalidClaimException("'exp' and 'iat' are required claims. Atlassian JWT does not allow JWTs with " +
                    "unlimited lifetimes.");
        }

        Date now = clock.now();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.SECOND, -JwtConstants.TIME_CLAIM_LEEWAY_SECONDS);
        Date nowMinusLeeway = calendar.getTime();
        calendar.setTime(now);
        calendar.add(Calendar.SECOND, JwtConstants.TIME_CLAIM_LEEWAY_SECONDS);
        Date nowPlusLeeway = calendar.getTime();

        if (null != claims.getNotBeforeTime())
        {
            // sanity check: if the token is invalid before, on and after a given time then it is always invalid and the issuer has made a mistake
            if (!claims.getExpirationTime().after(claims.getNotBeforeTime()))
            {
                throw new JwtInvalidClaimException(String.format("The expiration time must be after the not-before time but exp=%s and nbf=%s", claims.getExpirationTime(), claims.getNotBeforeTime()));
            }

            if (claims.getNotBeforeTime().after(nowPlusLeeway))
            {
                throw new JwtTooEarlyException(claims.getNotBeforeTime(), now, JwtConstants.TIME_CLAIM_LEEWAY_SECONDS);
            }
        }

        if (claims.getExpirationTime().before(nowMinusLeeway))
        {
            throw new JwtExpiredException(claims.getExpirationTime(), now, JwtConstants.TIME_CLAIM_LEEWAY_SECONDS);
        }

        if (requiredClaims != null)
        {
            for (Map.Entry<String, ? extends JwtClaimVerifier> requiredClaim : requiredClaims.entrySet())
            {
                requiredClaim.getValue().verify(claims.getClaim(requiredClaim.getKey()));
            }
        }

        return new SimpleJwt(claims.getIssuer(), claims.getSubject(), jsonPayload.toString());
    }

    private JWSObject verify(@Nonnull final String jwt) throws JwtParseException, JwtVerificationException {
        try
        {
            final JWSObject jwsObject = JWSObject.parse(jwt);

            if (!jwsObject.verify(verifier)) {
                throw new JwtSignatureMismatchException(jwt);
            }

            return jwsObject;
        }
        catch (ParseException e)
        {
            throw new JwtParseException(e);
        }
        catch (JOSEException e)
        {
            throw new JwtSignatureMismatchException(e);
        }
    }
}
