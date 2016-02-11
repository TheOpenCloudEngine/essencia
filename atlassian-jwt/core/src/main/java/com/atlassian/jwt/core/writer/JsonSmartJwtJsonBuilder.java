package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.core.TimeUtil;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.google.common.base.*;
import net.minidev.json.JSONObject;

import javax.annotation.Nonnull;
import java.util.*;

public class JsonSmartJwtJsonBuilder implements JwtJsonBuilder
{
    private final JSONObject json = new JSONObject();

    public JsonSmartJwtJsonBuilder()
    {
        issuedAt(TimeUtil.currentTimeSeconds());
        expirationTime(TimeUtil.currentTimePlusNSeconds(180)); // default JWT lifetime is 3 minutes
    }

    @Nonnull
    @Override
    public JwtJsonBuilder audience(@Nonnull String aud)
    {
        json.put("aud", aud);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder expirationTime(long exp)
    {
        json.put("exp", exp);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder issuedAt(long iat)
    {
        json.put("iat", iat);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder issuer(@Nonnull String iss)
    {
        json.put("iss", iss);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder jwtId(@Nonnull String jti)
    {
        json.put("jti", jti);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder notBefore(long nbf)
    {
        json.put("nbf", nbf);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder subject(@Nonnull String sub)
    {
        json.put("sub", sub);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder type(@Nonnull String typ)
    {
        json.put("typ", typ);
        return this;
    }

    @Nonnull
    @Override
    public JwtJsonBuilder queryHash(@Nonnull String qsh)
    {
        json.put("qsh", qsh);
        return this;
    }


    @SuppressWarnings("unchecked")
    @Nonnull
    @Override
    public JwtJsonBuilder claim(@Nonnull String name, @Nonnull Object obj)
    {
        Object current = json.get(name);
        json.put(name, merge(name, current, obj));
        return this;
    }

    @Nonnull
    @Override
    public String build()
    {
        return json.toString();
    }

    @Override
    public String toString()
    {
        return json.toString();
    }

    @SuppressWarnings("unchecked")
    private Object merge(String name, Object first, Object second)
    {
        if (first instanceof List && second instanceof List)
        {
            List merged = new ArrayList((List) first);
            merged.addAll((List) second);
            return merged;
        }
        else if (first instanceof Map && second instanceof Map)
        {
            Map merged = new HashMap((Map) first);
            // merge each of the entries in second recursively
            Set<Map.Entry> entries = ((Map) second).entrySet();
            for (Map.Entry entry : entries)
            {
                merged.put(entry.getKey(), merge(name + "." + entry.getKey(), merged.get(entry.getKey()), entry.getValue()));
            }
            return merged;
        }

        if (first != null && second != null && !com.google.common.base.Objects.equal(first, second))
        {
            throw new IllegalStateException("Cannot set claim '" + name + "' to '" + second +
                    "'; it's already set as '" + first + "'");
        }

        return second == null ? first : second;
    }
}
