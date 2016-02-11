package com.atlassian.jwt.core;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JwtUtilTest
{
    @Test
    public void percentEncodedStringsAreSortedByCodePoint() throws UnsupportedEncodingException
    {
        List<String> encodedStrings = Arrays.asList(JwtUtil.percentEncode("a"), JwtUtil.percentEncode("A"), JwtUtil.percentEncode("b"), JwtUtil.percentEncode("B"));
        Collections.sort(encodedStrings);
        assertThat(encodedStrings, is(Arrays.asList("A", "B", "a", "b")));
    }

    @Test
    public void computeSha256Hash() throws NoSuchAlgorithmException
    {
        // tested against:
        // * http://www.freeformatter.com/sha256-generator.html
        // * http://www.xorbin.com/tools/sha256-hash-calculator
        // * http://hash.online-convert.com/sha256-generator
        assertThat(JwtUtil.computeSha256Hash("foo"), is("2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void attemptToHashNullIsRejected() throws NoSuchAlgorithmException
    {
        JwtUtil.computeSha256Hash(null);
    }
}
