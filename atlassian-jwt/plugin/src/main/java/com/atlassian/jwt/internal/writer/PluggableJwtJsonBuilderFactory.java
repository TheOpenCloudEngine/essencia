package com.atlassian.jwt.internal.writer;

import com.atlassian.jwt.core.writer.JsonSmartJwtJsonBuilderFactory;
import com.atlassian.jwt.writer.JwtClaimWriter;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.atlassian.jwt.writer.JwtJsonBuilderFactory;
import com.atlassian.sal.api.lifecycle.LifecycleAware;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JwtJsonBuilderFactory implementation that injects claims from OSGI provided {@link JwtClaimWriter writers} just
 * before the JWT is built. The injection is done as late as possible to ensure that the token is built in the correct
 * security context - in case the writer uses the current security context to generate additional claims.
 *
 * @since 2.0
 */
public class PluggableJwtJsonBuilderFactory implements LifecycleAware, JwtJsonBuilderFactory
{
    private final ServiceTracker tracker;
    private JwtJsonBuilderFactory delegate = new JsonSmartJwtJsonBuilderFactory();

    public PluggableJwtJsonBuilderFactory(BundleContext bundleContext)
    {
        tracker = new ServiceTracker(bundleContext, JwtClaimWriter.class.getName(), null);
    }

    public void destroy()
    {
        tracker.close();
    }

    @Nonnull
    @Override
    public JwtJsonBuilder jsonBuilder()
    {
        return decorate(delegate.jsonBuilder());
    }

    @Override
    public void onStart()
    {
        tracker.open();
    }

    public void setDelegate(JwtJsonBuilderFactory delegate)
    {
        this.delegate = delegate;
    }

    private JwtJsonBuilder decorate(final JwtJsonBuilder builder)
    {
        return (JwtJsonBuilder) Proxy.newProxyInstance(JwtJsonBuilder.class.getClassLoader(),
                new Class[]{JwtJsonBuilder.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("build".equals(method.getName())) {
                            // apply the OSGI provided JwtClaimWriters just before building the token
                            writeClaims(builder);
                        }
                        Object result = method.invoke(builder, args);
                        // if the builder tries to return itself, return the decorator instead
                        return result == builder ? proxy : result;
                    }
                });
    }

    private void writeClaims(JwtJsonBuilder builder)
    {
        Object[] services = tracker.getServices();
        if (services != null)
        {
            for (Object service : services)
            {
                if (JwtClaimWriter.class.isAssignableFrom(service.getClass())) {
                    JwtClaimWriter.class.cast(service).write(builder);
                }
            }
        }
    }
}
