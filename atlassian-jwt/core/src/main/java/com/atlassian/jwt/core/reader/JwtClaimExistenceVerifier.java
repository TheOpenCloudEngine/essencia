package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.exception.JwtMissingClaimException;
import com.atlassian.jwt.reader.JwtClaimVerifier;

import javax.annotation.Nonnull;

public class JwtClaimExistenceVerifier implements JwtClaimVerifier
{
    private final String claimName;

    public JwtClaimExistenceVerifier(String claimName)
    {
        this.claimName = claimName;
    }

    @Override
    public void verify(@Nonnull Object claim) throws JwtMissingClaimException
    {
        //noinspection ConstantConditions
        if (null == claim)
        {
            throw new JwtMissingClaimException(String.format("Claim '%s' is missing.", claimName));
        }
    }
}
