package com.atlassian.jwt.reader;

import com.atlassian.jwt.exception.*;

import javax.annotation.Nonnull;
import java.security.interfaces.RSAPublicKey;

/**
 * Factory for {@link JwtReader}.
 *
 * @since 1.0
 */
public interface JwtReaderFactory
{
    /**
     * Returns a jwt reader to be used for verifying tokens signed using a symmetric algorithm.
     *
     * @param jwt encoded JWT message
     * @return an appropriate {@link JwtReader} for reading this JWT message
     * @throws JwsUnsupportedAlgorithmException if the JWT message's stated algorithm is not implemented
     * @throws JwtParseException if the JWT message appears to be mangled
     * @throws JwtUnknownIssuerException if the JWT message's "iss" claim value is not recognized
     * @throws JwtIssuerLacksSharedSecretException if the JWT message's algorithm requires a shared secret but the claimed issuer does not have one associated
     */
    @Nonnull
    JwtReader getReader(@Nonnull String jwt) throws JwsUnsupportedAlgorithmException, JwtUnknownIssuerException, JwtParseException, JwtIssuerLacksSharedSecretException;


    /**
     * Returns a jwt reader that should be used for verifying tokens signed using an asymmetric algorithm.
     * In this case, a public key needs to be provided as an argument because we don't want this library to constrain or specify where the public keys will
     * be stored and how they will be retrieved.
     *
     * It will be the client's responsibility to retrieve the appropriate public key and pass it into this factory method.
     *
     * Sample usage may look be as follows:
     *
     * <pre>
     * {@code
     * JwtParser jwtParser = new SimpleJwtParser(); // in practice, you may inject this rather than instantiating it like this
     * String issuer = jwtParser.parse(jwt).getIssuer();
     * RSAPublicKey publicKey = <retrieve public key for this issuer>
     * JwtReader jwtReader = jwtReaderFactory.getReader(jwt, publicKey);
     * return jwtReader.readAndVerify(jwt, Collections.<String, JwtClaimVerifier>emptyMap());
     * }
     * </pre>
     *
     * @param jwt encoded JWT message
     * @param publicKey public key to use to verify jwt's signature
     * @return an appropriate {@link JwtReader} for reading this JWT message
     * @throws JwsUnsupportedAlgorithmException if the JWT message's stated algorithm is not implemented
     * @throws JwtParseException if the JWT message appears to be mangled
     */
    @Nonnull
    JwtReader getReader(@Nonnull String jwt, RSAPublicKey publicKey) throws JwsUnsupportedAlgorithmException, JwtParseException;
}
