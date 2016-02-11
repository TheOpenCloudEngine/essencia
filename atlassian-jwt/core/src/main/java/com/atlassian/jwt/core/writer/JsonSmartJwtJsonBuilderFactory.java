package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.atlassian.jwt.writer.JwtJsonBuilderFactory;

import javax.annotation.Nonnull;

public class JsonSmartJwtJsonBuilderFactory implements JwtJsonBuilderFactory
{
    @Nonnull
    @Override
    public JwtJsonBuilder jsonBuilder()
    {
        return new JsonSmartJwtJsonBuilder();
    }
}
