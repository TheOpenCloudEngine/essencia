package com.atlassian.jwt.core;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.SymmetricSigningInfo;

import javax.annotation.Nonnull;

public class SimpleSymmetricSigningInfo implements SymmetricSigningInfo
{
    private final SigningAlgorithm signingAlgorithm;
    private final String sharedSecret;

    public SimpleSymmetricSigningInfo(SigningAlgorithm signingAlgorithm, @Nonnull String sharedSecret)
    {
        this.signingAlgorithm = signingAlgorithm;
        this.sharedSecret = sharedSecret;
    }

    @Override
    public SigningAlgorithm getSigningAlgorithm()
    {
        return signingAlgorithm;
    }

    @Override
    public String getSharedSecret() { return sharedSecret; }
}
