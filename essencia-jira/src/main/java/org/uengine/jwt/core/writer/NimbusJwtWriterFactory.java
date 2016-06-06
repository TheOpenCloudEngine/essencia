package org.uengine.jwt.core.writer;

import org.uengine.jwt.AsymmetricSigningInfo;
import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.SymmetricSigningInfo;
import org.uengine.jwt.writer.JwtWriter;
import org.uengine.jwt.writer.JwtWriterFactory;
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
