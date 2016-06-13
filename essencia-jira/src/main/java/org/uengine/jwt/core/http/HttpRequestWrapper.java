package org.uengine.jwt.core.http;

import org.uengine.jwt.CanonicalHttpRequest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A small abstraction over Http requests that allows reuse in non javax.servlet frameworks like Play
 */
public interface HttpRequestWrapper
{
    @Nullable
    String getParameter(String parameterName);

    @Nonnull
    Iterable<String> getHeaderValues(String headerName);

    @Nonnull
    CanonicalHttpRequest getCanonicalHttpRequest();
}
