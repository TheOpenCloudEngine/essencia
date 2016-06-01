package org.uengine.jwt.core.writer;

import org.uengine.jwt.writer.JwtJsonBuilder;
import org.uengine.jwt.writer.JwtJsonBuilderFactory;

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
