package com.atlassian.jwt.internal.servlet;

import com.atlassian.jwt.JwtConstants;
import com.atlassian.sal.api.ApplicationProperties;
import com.atlassian.sal.api.auth.AuthenticationController;
import com.atlassian.sal.api.auth.AuthenticationListener;
import com.atlassian.sal.api.auth.Authenticator;
import com.atlassian.sal.api.message.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Vector;

import static com.atlassian.jwt.JwtConstants.HttpRequests.AUTHORIZATION_HEADER;
import static com.atlassian.jwt.JwtConstants.HttpRequests.JWT_AUTH_HEADER_PREFIX;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JwtAuthFilterTest
{
    private static final String MOCK_JWT = "a.b.c";
    private static final String WWW_AUTHENTICATE = "WWW-Authenticate";

    private Filter filter;

    @Mock private Authenticator authenticator;
    @Mock private AuthenticationListener authenticationListener;
    @Mock private AuthenticationController authenticationController;
    @Mock private ApplicationProperties applicationProperties;
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private FilterChain chain;

    @Before
    public void setUp()
    {
        filter = new JwtAuthFilter(authenticationListener, authenticator, authenticationController);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://host/service"));
        when(request.getRequestURI()).thenReturn("/service");
        when(request.getMethod()).thenReturn("GET");
        when(request.getContextPath()).thenReturn("");
        when(authenticationController.shouldAttemptAuthentication(request)).thenReturn(true);
    }

    @Test
    public void authenticationControllerIsNotifiedWhenAuthenticationIsSuccessfulAndJwtQueryStringParameterIsValid() throws Exception
    {
        Authenticator.Result.Success success = successResponse();
        setUpSuccessWithJwtQueryStringParameter(success);
        filter.doFilter(request, response, chain);

        verify(authenticationListener).authenticationNotAttempted(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void filterChainContinuesWhenAuthenticationIsSuccessfulAndJwtQueryStringParameterIsValid() throws Exception
    {
        doSuccessfulFilter();
        verify(chain).doFilter(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    }

    @Test
    public void noWwwAuthenticateHeaderIsAttachedWhenAuthenticationIsSuccessful() throws IOException, ServletException
    {
        doSuccessfulFilter();
        verify(response, never()).addHeader(eq(WWW_AUTHENTICATE), any(String.class)); // because the OAuth filter adds this header but it's unnecessary for JWT
    }

    @Test
    public void authenticationControllerIsNotifiedWhenAuthenticationIsSuccessfulAndJwtAuthHeaderIsValid() throws IOException, ServletException
    {
        when(request.getHeaders(AUTHORIZATION_HEADER)).thenReturn(validJwtAuthHeaders());
        Authenticator.Result.Success success = successResponse();
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(success);
        filter.doFilter(request, response, chain);

        verify(authenticationListener).authenticationNotAttempted(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void filterChainContinuesWhenAuthenticationIsSuccessfulAndJwtAuthHeaderIsValid() throws IOException, ServletException
    {
        when(request.getHeaders(AUTHORIZATION_HEADER)).thenReturn(validJwtAuthHeaders());
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(successResponse());
        filter.doFilter(request, response, chain);

        verify(chain).doFilter(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    }

    @Test
    public void weStopTheFilterChainIfAuthenticationFails() throws Exception
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(failureResponse());
        filter.doFilter(request, response, chain);

        verifyZeroInteractions(chain);
    }

    @Test
    public void weReportFailureIfAuthenticationFails() throws Exception
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        Authenticator.Result.Failure failure = failureResponse();
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(failure);
        filter.doFilter(request, response, chain);

        verify(authenticationListener).authenticationFailure(eq(failure), isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void noWwwAuthenticateHeaderIsAttachedWhenAuthenticationFails() throws IOException, ServletException
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        Authenticator.Result.Failure failure = failureResponse();
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(failure);
        filter.doFilter(request, response, chain);

        verify(response, never()).addHeader(eq(WWW_AUTHENTICATE), any(String.class)); // because the OAuth filter adds this header but it's unnecessary for JWT
    }

    @Test
    public void weStopTheFilterChainIfThereIsAnErrorDuringAuthentication() throws Exception
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(errorResponse());
        filter.doFilter(request, response, chain);

        verifyZeroInteractions(chain);
    }

    @Test
    public void weReportFailureIfThereIsAnErrorDuringAuthentication() throws Exception
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        Authenticator.Result.Error error = errorResponse();
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(error);
        filter.doFilter(request, response, chain);

        verify(authenticationListener).authenticationError(eq(error), isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void noWwwAuthenticateHeaderIsAttachedIfThereIsAnErrorDuringAuthentication() throws IOException, ServletException
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        Authenticator.Result.Error error = errorResponse();
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(error);
        filter.doFilter(request, response, chain);

        verify(response, never()).addHeader(eq(WWW_AUTHENTICATE), any(String.class)); // because the OAuth filter adds this header but it's unnecessary for JWT
    }

    @Test
    public void whenJwtParametersAreNotPresentTheRequestPassesThroughTheFilterChain() throws Exception
    {
        filter.doFilter(request, response, chain);
        verify(chain).doFilter(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    }

    @Test
    public void whenJwtParametersAreNotPresentAuthenticationIsNotAttempted() throws Exception
    {
        filter.doFilter(request, response, chain);
        verifyZeroInteractions(authenticator);
    }

    @Test
    public void whenJwtParametersAreNotPresentTheAuthenticationListenerIsToldThatAuthenticationWasNotAttempted() throws Exception
    {
        filter.doFilter(request, response, chain);
        verify(authenticationListener).authenticationNotAttempted(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void whenWeShouldNotAttemptAuthenticationTheAuthenticatorIsNotInvoked() throws IOException, ServletException
    {
        when(authenticationController.shouldAttemptAuthentication(request)).thenReturn(false);
        filter.doFilter(request, response, chain);
        verifyZeroInteractions(authenticator);
    }

    @Test
    public void whenWeShouldNotAttemptAuthenticationTheRequestPassesThroughTheFilterChain() throws IOException, ServletException
    {
        when(authenticationController.shouldAttemptAuthentication(request)).thenReturn(false);
        filter.doFilter(request, response, chain);
        verify(chain).doFilter(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    }

    @Test
    public void whenWeShouldNotAttemptAuthenticationTheAuthenticationControllerIsNotifiedThatThereWasNoAttempt() throws IOException, ServletException
    {
        when(authenticationController.shouldAttemptAuthentication(request)).thenReturn(false);
        filter.doFilter(request, response, chain);
        verify(authenticationListener).authenticationNotAttempted(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticationListener);
    }

    @Test
    public void weShouldNotAttemptAuthenticationForOptionsRequests() throws Exception
    {
        when(request.getMethod()).thenReturn("options");
        filter.doFilter(request, response, chain);
        verify(authenticationListener).authenticationNotAttempted(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
        verifyNoMoreInteractions(authenticator);
    }

    private void doSuccessfulFilter() throws IOException, ServletException
    {
        setUpSuccessWithJwtQueryStringParameter(successResponse());
        filter.doFilter(request, response, chain);
    }

    private void setUpSuccessThoughJwtAuthHeader()
    {
        when(request.getHeaders(AUTHORIZATION_HEADER)).thenReturn(validJwtAuthHeaders());
        setUpSuccessWithoutJwt();
    }

    private Enumeration<String> validJwtAuthHeaders()
    {
        Vector<String> authHeaders = new Vector<String>();
        authHeaders.add(JWT_AUTH_HEADER_PREFIX + MOCK_JWT);
        return authHeaders.elements();
    }

    private void setUpSuccessWithoutJwt()
    {
        setUpSuccessfulAuthResponse(successResponse());
    }

    private void setUpSuccessWithJwtQueryStringParameter(Authenticator.Result.Success success)
    {
        when(request.getParameter(JwtConstants.JWT_PARAM_NAME)).thenReturn(MOCK_JWT);
        setUpSuccessfulAuthResponse(success);
    }

    private void setUpSuccessfulAuthResponse(Authenticator.Result.Success success)
    {
        when(authenticator.authenticate(isA(HttpServletRequest.class), isA(HttpServletResponse.class))).thenReturn(success);
    }

    private Authenticator.Result.Failure failureResponse()
    {
        return new Authenticator.Result.Failure(createMessage("failure"));
    }

    private Authenticator.Result.Error errorResponse()
    {
        return new Authenticator.Result.Error(createMessage("error"));
    }

    private Authenticator.Result.Success successResponse()
    {
        return new Authenticator.Result.Success(createMessage("success"), new Principal()
        {
            @Override
            public String getName()
            {
                return "username";
            }
        });
    }

    private static Message createMessage(final String message)
    {
        return new Message()
        {
            @Override
            public String getKey()
            {
                return message;
            }

            @Override
            public Serializable[] getArguments()
            {
                return null;
            }
        };
    }
}
