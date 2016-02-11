package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.core.JsonUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minidev.json.parser.ParseException;
import org.junit.Test;

public class JsonSmartJwtJsonBuilderTest
{
    private static final int EXP = 1300819380;
    public static final int NBF = EXP - 30 * 60;
    private static final int IAT = EXP - 60 * 60;
    private static final String ISS = "Atlassian Software";
    private static final String AUD = "world";
    private static final String SUB = "sports law";
    public static final String TYP = "type a";
    public static final String JTI = "abc123";
    public static final String CUSTOM_KEY = "custom";
    public static final String CUSTOM_VALUE = "motsuc";

    @Test
    public void claimGeneration() throws Exception
    {
        String json = new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .audience(AUD)
                .claim(CUSTOM_KEY, CUSTOM_VALUE)
                .expirationTime(EXP)
                .issuedAt(IAT)
                .issuer(ISS)
                .jwtId(JTI)
                .notBefore(NBF)
                .subject(SUB)
                .type(TYP)
                .build();

        JsonUtils.assertJsonContainsOnly(json,
                "aud", AUD,
                CUSTOM_KEY, CUSTOM_VALUE,
                "exp", EXP,
                "iat", IAT,
                "iss", ISS,
                "jti", JTI,
                "nbf", NBF,
                "sub", SUB,
                "typ", TYP
        );
    }

    @Test
    public void customClaimCanBeOverwrittenIfIdentical() throws ParseException
    {
        String json = new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .expirationTime(EXP)
                .issuedAt(IAT)
                .type(TYP)
                .claim(CUSTOM_KEY, "value")
                .claim(CUSTOM_KEY, "value") // should not trigger an exception
                .build();

        JsonUtils.assertJsonContainsOnly(json,
                "exp", EXP,
                "iat", IAT,
                CUSTOM_KEY, "value",
                "typ", TYP);
    }

    @Test(expected = IllegalStateException.class)
    public void customClaimCannotBeOverwritten() throws ParseException
    {
        new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .expirationTime(EXP)
                .issuedAt(IAT)
                .type(TYP)
                .claim(CUSTOM_KEY, "value")
                .claim(CUSTOM_KEY, "other-value")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void customClaimCannotBeOverwrittenRecursively() throws ParseException
    {
        new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .expirationTime(EXP)
                .issuedAt(IAT)
                .type(TYP)
                .claim(CUSTOM_KEY, ImmutableMap.of("key-1", "value-1"))
                .claim(CUSTOM_KEY, ImmutableMap.of("key-1", "value-2"))
                .build();
    }

    @Test
    public void listClaimIsMergedButNotDeduped() throws ParseException
    {
        String json = new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .expirationTime(EXP)
                .issuedAt(IAT)
                .type(TYP)
                .claim(CUSTOM_KEY, ImmutableList.of("value-1", "value-2", "value-3"))
                .claim(CUSTOM_KEY, ImmutableList.of("value-1", "value-4", "value-5"))
                .build();

        JsonUtils.assertJsonContainsOnly(json,
                "exp", EXP,
                "iat", IAT,
                CUSTOM_KEY, ImmutableList.of("value-1", "value-2", "value-3", "value-1", "value-4", "value-5"),
                "typ", TYP);
    }

    @Test
    public void mapClaimIsMergedRecursively() throws ParseException
    {
        String json = new JsonSmartJwtJsonBuilderFactory().jsonBuilder()
                .expirationTime(EXP)
                .issuedAt(IAT)
                .type(TYP)
                .claim(CUSTOM_KEY, ImmutableMap.of(
                        "key-1", "value-1",
                        "key-2", "value-2",
                        "context", ImmutableMap.of("user", ImmutableMap.of("name", "username", "key", "userKey"))))
                .claim(CUSTOM_KEY, ImmutableMap.of(
                        "key-3", "value-3",
                        "context", ImmutableMap.of("user", ImmutableMap.of("id", "aabbcc"))))
                .build();

        JsonUtils.assertJsonContainsOnly(json,
                "exp", EXP,
                "iat", IAT,
                CUSTOM_KEY, ImmutableMap.of(
                        "key-1", "value-1",
                        "key-2", "value-2",
                        "key-3", "value-3",
                        "context", ImmutableMap.of("user", ImmutableMap.of("name", "username", "key", "userKey", "id", "aabbcc"))),
                "typ", TYP);
    }
}
