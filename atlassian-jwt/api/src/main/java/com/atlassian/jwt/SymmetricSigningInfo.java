package com.atlassian.jwt;

public interface SymmetricSigningInfo extends SigningInfo
{
    String getSharedSecret();
}
