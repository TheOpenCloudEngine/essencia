package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.applinks.JwtApplinkFinder;
import com.atlassian.jwt.applinks.JwtService;
import com.atlassian.jwt.reader.JwtReaderFactory;
import com.atlassian.jwt.writer.JwtWriter;
import com.atlassian.jwt.writer.JwtWriterFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.atlassian.jwt.JwtConstants.AppLinks.SHARED_SECRET_PROPERTY_NAME;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplinksJwtServiceTest
{
    private JwtService jwtService;
    @Mock static JwtReaderFactory jwtReaderFactory;
    @Mock static JwtWriterFactory jwtWriterFactory;
    @Mock static JwtApplinkFinder jwtApplinkFinder;
    @Mock static ApplicationLink applicationLink;
    @Mock static JwtWriter jwtWriter;

    @Test
    public void issueJwtMethodsAreEquivalent()
    {
        assertThat(jwtService.issueJwt("{}", "secret"), both(is(jwtService.issueJwt("{}", applicationLink))).and(is("YAY JWT!")));
    }

    @Test
    public void jwtWriterFactoryIsInvokedCorrectly()
    {
        jwtService.issueJwt("{}", "secret");
        verify(jwtWriterFactory).macSigningWriter(SigningAlgorithm.HS256, "secret");
    }

    @Test
    public void jwtWriterIsInvokedCorrectly()
    {
        jwtService.issueJwt("{}", "secret");
        verify(jwtWriter).jsonToJwt("{}");
    }

    @Before
    public void beforeTests()
    {
        jwtService = new ApplinksJwtService(jwtReaderFactory, jwtWriterFactory, jwtApplinkFinder);
        when(applicationLink.getProperty(SHARED_SECRET_PROPERTY_NAME)).thenReturn("secret");
        when(jwtWriterFactory.macSigningWriter(SigningAlgorithm.HS256, "secret")).thenReturn(jwtWriter);
        when(jwtWriter.jsonToJwt("{}")).thenReturn("YAY JWT!");
    }
}
