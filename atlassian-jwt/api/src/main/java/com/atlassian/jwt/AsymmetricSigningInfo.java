package com.atlassian.jwt;

import java.security.interfaces.RSAPrivateKey;

public interface AsymmetricSigningInfo extends SigningInfo
{
    RSAPrivateKey getPrivateKey();
}
