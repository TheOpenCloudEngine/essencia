package com.atlassian.jwt.core;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 */
public class JsonUtils
{
    public static void assertJsonContainsOnly(String payload, Object... claims) throws ParseException
    {
        assertJsonContains(payload, true, claims);
    }

    public static void assertJsonContains(String payload, boolean onlyThese, Object... claims) throws ParseException
    {
        JSONObject obj = (JSONObject) new JSONParser(JSONParser.MODE_RFC4627).parse(payload);
        for (int i = 0; i < claims.length; i += 2)
        {
            String claim = (String) claims[i];
            Object expected = claims[i + 1];
            Object val = obj.get(claim);
            assertThat("Unexpected parameter for claim '" + claim + "'", val, is(expected));
        }
        if (onlyThese)
        {
            assertThat("Incorrect number of payload values", obj.keySet().size(), is(claims.length / 2));
        }
    }
}
