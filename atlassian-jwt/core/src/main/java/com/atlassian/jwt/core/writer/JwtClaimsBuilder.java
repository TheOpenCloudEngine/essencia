package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.CanonicalHttpRequest;
import com.atlassian.jwt.core.HttpRequestCanonicalizer;
import com.atlassian.jwt.writer.JwtJsonBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class JwtClaimsBuilder
{
    /**
     * Convenience method for building and appending JWT claims related to a {@link com.atlassian.jwt.CanonicalHttpRequest}.
     * Encapsulates the knowledge of what claims we make regarding the request.
     * @param jsonBuilder {@link com.atlassian.jwt.writer.JwtJsonBuilder} that constructs the JWT payload
     * @param request {@link com.atlassian.jwt.CanonicalHttpRequest} representing the incoming or outgoing HTTP request
     * @throws UnsupportedEncodingException if {@link java.net.URLEncoder} cannot encode the request's characters
     * @throws NoSuchAlgorithmException if the hashing algorithm does not exist at runtime
     */
    public static void appendHttpRequestClaims(JwtJsonBuilder jsonBuilder, CanonicalHttpRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        jsonBuilder.queryHash(HttpRequestCanonicalizer.computeCanonicalRequestHash(request));
    }
}
