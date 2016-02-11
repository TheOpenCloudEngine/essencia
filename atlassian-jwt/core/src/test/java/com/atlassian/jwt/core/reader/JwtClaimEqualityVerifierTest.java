package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.exception.JwtInvalidClaimException;
import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtVerificationException;
import com.atlassian.jwt.reader.JwtClaimVerifier;
import org.junit.Test;

public class JwtClaimEqualityVerifierTest
{
    private final JwtClaimVerifier claimVerifier = new JwtClaimEqualityVerifier("some name", "correct");

    @Test
    public void correctClaimWorks() throws JwtParseException, JwtVerificationException
    {
        claimVerifier.verify("correct");
    }

    @Test(expected = JwtVerificationException.class)
    public void incorrectClaimResultsInException() throws JwtParseException, JwtVerificationException
    {
        claimVerifier.verify("wrong");
    }
}
