package com.atlassian.jwt.internal;

import com.atlassian.jwt.JwtIssuer;
import com.atlassian.jwt.JwtIssuerRegistry;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import com.atlassian.jwt.internal.PluginJwtRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PluginJwtRegistryTest
{
    private static final String ISSUER_NAME = "issuer-name";

    @Mock
    private BundleContext bundleContext;
    @Mock
    private JwtIssuerRegistry osgiRegistry1;
    @Mock
    private JwtIssuerRegistry osgiRegistry2;
    @Mock
    private JwtIssuer issuer;
    @Mock
    private ServiceReference serviceReference1;
    @Mock
    private ServiceReference serviceReference2;
    private PluginJwtRegistry registry;

    @Before
    public void beforeEachTest() throws InvalidSyntaxException
    {
        when(bundleContext.getServiceReferences(eq(JwtIssuerRegistry.class.getName()), anyString()))
                .thenReturn(new ServiceReference[]{serviceReference1, serviceReference2});
        when(bundleContext.getService(serviceReference1)).thenReturn(osgiRegistry1);
        when(bundleContext.getService(serviceReference2)).thenReturn(osgiRegistry2);
        when(osgiRegistry1.getIssuer(ISSUER_NAME)).thenReturn(issuer);

        registry = new PluginJwtRegistry(bundleContext);
    }

    @Test
    public void destroyClosesServiceTracker()
    {
        registry.destroy();

        verify(bundleContext).ungetService(serviceReference1);
        verify(bundleContext).ungetService(serviceReference2);
    }

    @Test
    public void getIssuerIteratesOverRegistries()
    {
        String notFoundIssuer = "no-such-issuer";
        // no match found
        assertThat(registry.getIssuer(notFoundIssuer), nullValue());

        verify(osgiRegistry1).getIssuer(notFoundIssuer);
        verify(osgiRegistry2).getIssuer(notFoundIssuer);
    }

    @Test
    public void getSharedSecret() throws JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException {
        when(issuer.getSharedSecret()).thenReturn("magic");

        assertThat(registry.getSharedSecret(ISSUER_NAME), is("magic"));
    }

    @Test(expected = JwtUnknownIssuerException.class)
    public void getSharedSecretUsingNonExistentIssuerResultsInException() throws JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException
    {
        registry.getSharedSecret("no-such-issuer");
    }

    @Test(expected = NullPointerException.class)
    public void getSharedSecretUsingNullIssuerIdResultsInException() throws JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException
    {
        registry.getSharedSecret(null);
    }

    @Test(expected = JwtIssuerLacksSharedSecretException.class)
    public void getSharedSecretUsingNoAuthAddOnIdResultsInException() throws JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException
    {
        registry.getSharedSecret(ISSUER_NAME);
    }

    @Test
    public void testIsValidReturnsFalseForNonExistentIssuers()
    {
        assertThat(registry.isValid("non-existent"), is(false));
    }

    @Test
    public void testIsValidReturnsFalseForNullIssuer()
    {
        assertThat(registry.isValid(null), is(false));
    }

    @Test
    public void testIsValidReturnsTrueForKnownIssuer()
    {
        assertThat(registry.isValid(ISSUER_NAME), is(true));
    }
}