package org.uengine.jwt;

public interface SymmetricSigningInfo extends SigningInfo
{
    String getSharedSecret();
}
