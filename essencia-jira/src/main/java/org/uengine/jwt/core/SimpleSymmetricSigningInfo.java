package org.uengine.jwt.core;

import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.SymmetricSigningInfo;

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
