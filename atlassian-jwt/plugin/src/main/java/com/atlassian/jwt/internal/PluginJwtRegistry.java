package com.atlassian.jwt.internal;

import com.atlassian.jwt.JwtIssuer;
import com.atlassian.jwt.JwtIssuerRegistry;
import com.atlassian.jwt.core.reader.JwtIssuerSharedSecretService;
import com.atlassian.jwt.core.reader.JwtIssuerValidator;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class PluginJwtRegistry implements JwtIssuerRegistry, JwtIssuerSharedSecretService, JwtIssuerValidator
{
    private final ServiceTracker serviceTracker;

    public PluginJwtRegistry(BundleContext bundleContext)
    {
        serviceTracker = new ServiceTracker(bundleContext, JwtIssuerRegistry.class.getName(), null);
        serviceTracker.open();
    }

    public void destroy()
    {
        serviceTracker.close();
    }

    @Override
    public JwtIssuer getIssuer(@Nonnull String issuerName) {
        checkNotNull(issuerName, "issuerName");

        for (JwtIssuerRegistry registry : getRegistries())
        {
            JwtIssuer issuer = registry.getIssuer(issuerName);
            if (issuer != null)
            {
                return issuer;
            }
        }
        return null;
    }

    @Override
    public String getSharedSecret(@Nonnull String issuerName) throws JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException
    {
        String secret = getIssuerOrFail(issuerName).getSharedSecret();
        if (null == secret)
        {
            throw new JwtIssuerLacksSharedSecretException(issuerName);
        }

        return secret;
    }

    @Override
    public boolean isValid(String issuerName)
    {
        return issuerName != null && getIssuer(issuerName) != null;
    }

    private JwtIssuer getIssuerOrFail(String issuerName) throws JwtUnknownIssuerException
    {
        JwtIssuer issuer = getIssuer(issuerName);
        if (issuer == null)
        {
            throw new JwtUnknownIssuerException(String.format("Issuer '%s' not found", issuerName));
        }
        return issuer;
    }

    private Iterable<JwtIssuerRegistry> getRegistries()
    {
        List<JwtIssuerRegistry> registries = new ArrayList<JwtIssuerRegistry>();
        Object[] services = serviceTracker.getServices();
        if (services != null)
        {
            for (Object service : services)
            {
                if (service instanceof JwtIssuerRegistry)
                {
                    registries.add((JwtIssuerRegistry) service);
                }
            }
        }

        return registries;
    }
}
