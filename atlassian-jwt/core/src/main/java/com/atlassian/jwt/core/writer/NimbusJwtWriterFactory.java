package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.AsymmetricSigningInfo;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.SymmetricSigningInfo;
import com.atlassian.jwt.writer.JwtWriter;
import com.atlassian.jwt.writer.JwtWriterFactory;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;

import javax.annotation.Nonnull;

/**
 * Factory for {@link JwtWriter} implementations that use the "Nimbus JOSE+JWT" library.
 */
public class NimbusJwtWriterFactory implements JwtWriterFactory
{
    private NimbusJwtWriterFactoryHelper factoryHelper;

    static class NimbusJwtWriterFactoryHelper
    {
        NimbusJwtWriter makeMacJwtWriter(SigningAlgorithm algorithm, MACSigner macSigner)
        {
            return new NimbusJwtWriter(algorithm, macSigner);
        }

        NimbusJwtWriter makeRsJwtWriter(SigningAlgorithm algorithm, RSASSASigner rsaSigner)
        {
            return new NimbusJwtWriter(algorithm, rsaSigner);
        }
    }

    public NimbusJwtWriterFactory()
    {
        this(new NimbusJwtWriterFactoryHelper());
    }

    public NimbusJwtWriterFactory(NimbusJwtWriterFactoryHelper factoryHelper)
    {
        this.factoryHelper = factoryHelper;
    }

    @Nonnull
    @Override
    public JwtWriter macSigningWriter(@Nonnull SigningAlgorithm algorithm, @Nonnull String sharedSecret)
    {
        return new NimbusJwtWriter(algorithm, new MACSigner(sharedSecret));
    }

    @Nonnull
    @Override
    public JwtWriter signingWriter(@Nonnull SymmetricSigningInfo signingInfo)
    {
        return factoryHelper.makeMacJwtWriter(signingInfo.getSigningAlgorithm(), new MACSigner(signingInfo.getSharedSecret()));
    }

    @Nonnull
    @Override
    public JwtWriter signingWriter(@Nonnull AsymmetricSigningInfo signingInfo)
    {
        return factoryHelper.makeRsJwtWriter(signingInfo.getSigningAlgorithm(), new RSASSASigner(signingInfo.getPrivateKey()));
    }
}
