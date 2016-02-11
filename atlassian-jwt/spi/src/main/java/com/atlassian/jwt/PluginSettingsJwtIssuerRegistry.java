package com.atlassian.jwt;

import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple implementation that persists JwtIssuer information in {@link PluginSettings}
 *
 * @since 1.3
 */
public class PluginSettingsJwtIssuerRegistry implements MutableJwtRegistry
{
    static final String DEFAULT_PREFIX = "jwt";
    static final String PROP_NAME = "name";
    static final String PROP_SECRET = "secret";

    private final PluginSettings pluginSettings;
    private final String settingPrefix;

    public PluginSettingsJwtIssuerRegistry(PluginSettingsFactory factory)
    {
        this(factory, DEFAULT_PREFIX);
    }

    public PluginSettingsJwtIssuerRegistry(PluginSettingsFactory factory, String prefix)
    {
        pluginSettings = factory.createGlobalSettings();
        settingPrefix = prefix;
    }

    @Nonnull
    @Override
    public JwtIssuer addIssuer(@Nonnull String issuerName, @Nonnull String sharedSecret)
    {
        SimpleJwtIssuer existing = getPluginSettingsIssuer(issuerName);
        if (existing != null && sharedSecret.equals(existing.getSharedSecret()))
        {
            return existing;
        }
        if (existing != null)
        {
            throw new IllegalStateException("The JWT issuer " + issuerName + " already exists");
        }

        Map<String, String> properties = new HashMap<String, String>();
        properties.put(PROP_NAME, issuerName);
        properties.put(PROP_SECRET, sharedSecret);
        String settingsKey = settingsKey(issuerName);
        pluginSettings.put(settingsKey, properties);

        return new SimpleJwtIssuer(issuerName, sharedSecret);
    }

    @Override
    public JwtIssuer getIssuer(@Nonnull String issuer)
    {
        return getPluginSettingsIssuer(issuer);
    }

    @Override
    public boolean removeIssuer(@Nonnull String issuerName)
    {
        return pluginSettings.remove(settingsKey(issuerName)) != null;
    }

    private SimpleJwtIssuer getPluginSettingsIssuer(String issuerName)
    {
        String settingsKey = settingsKey(issuerName);
        Object value = pluginSettings.get(settingsKey);
        if (value instanceof Map)
        {
            //noinspection unchecked
            Map<String, String> properties = (Map<String, String>) value;
            return new SimpleJwtIssuer(properties.get(PROP_NAME), properties.get(PROP_SECRET));
        }

        return null;
    }

    private String settingsKey(String issuerName)
    {
        return settingPrefix + "." + "issuers" + "." + issuerName;
    }

    private static class SimpleJwtIssuer implements JwtIssuer
    {
        private final String name;
        private final String secret;

        private SimpleJwtIssuer(String name, String secret)
        {
            this.name = name;
            this.secret = secret;
        }

        @Nonnull
        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String getSharedSecret()
        {
            return secret;
        }
    }
}
