package com.atlassian.jwt.core;

import com.atlassian.jwt.core.http.JavaxJwtRequestExtractor;
import com.atlassian.jwt.core.http.JwtRequestExtractor;
import org.apache.commons.codec.binary.Hex;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JwtUtil
{
    /**
     * The encoding used to represent characters as bytes.
     */
    private static final String ENCODING = "UTF-8";
    /**
     * As appears between "value1" and "param2" in the URL "http://server/path?param1=value1&amp;param2=value2".
     */
    public static final char QUERY_PARAMS_SEPARATOR = '&';

    private static JwtRequestExtractor<HttpServletRequest> jwtRequestExtractor = new JavaxJwtRequestExtractor();

    public static boolean requestContainsJwt(HttpServletRequest request)
    {
        return extractJwt(request) != null;
    }

    public static String extractJwt(HttpServletRequest request)
    {
        return  jwtRequestExtractor.extractJwt(request);
    }

    /**
     * {@link URLEncoder}#encode() but encode some characters differently to URLEncoder, to match OAuth1 and VisualVault.
     * @param str {@link String} to be percent-encoded
     * @return encoded {@link String}
     * @throws UnsupportedEncodingException if {@link URLEncoder} does not support {@link JwtUtil#ENCODING}
     */
    public static String percentEncode(String str) throws UnsupportedEncodingException
    {
        if (str == null)
        {
            return "";
        }

        return URLEncoder.encode(str, ENCODING)
                .replace("+", "%20")
                .replace("*", "%2A")
                .replace("%7E", "~");
    }

    /**
     * Compute the SHA-256 hash of hashInput.
     * E.g. The SHA-256 has of "foo" is "2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae".
     * @param hashInput {@link String} to be hashed.
     * @return {@link String} hash
     * @throws NoSuchAlgorithmException if the hashing algorithm does not exist at runtime
     */
    public static String computeSha256Hash(String hashInput) throws NoSuchAlgorithmException
    {
        if (null == hashInput)
        {
            throw new IllegalArgumentException("hashInput cannot be null");
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashInputBytes = hashInput.getBytes();
        digest.update(hashInputBytes, 0, hashInputBytes.length);
        return new String(Hex.encodeHex(digest.digest()));
    }
}
