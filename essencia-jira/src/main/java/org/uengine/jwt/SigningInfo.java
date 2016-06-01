package org.uengine.jwt;

/**
 * Encapsulates the algorithm and key/secret to be used for signing and verifying jwt tokens
 */
public interface SigningInfo
{
    SigningAlgorithm getSigningAlgorithm();
}
