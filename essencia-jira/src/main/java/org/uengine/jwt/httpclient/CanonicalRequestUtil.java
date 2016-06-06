package org.uengine.jwt.httpclient;

import org.uengine.jwt.CanonicalHttpRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class CanonicalRequestUtil
{
    // So we can share between different impls.
    // Likely too large to be a useful toString
    public static String toVerboseString(CanonicalHttpRequest request)
    {
        return new ToStringBuilder(request, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("method", request.getMethod())
                .append("relativePath", request.getRelativePath())
                .append("parameterMap", mapToString(request.getParameterMap()))
                .toString();
    }

    private static String mapToString(Map<String, String[]> parameterMap)
    {
        StringBuilder sb = new StringBuilder()
                .append('[');

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet())
        {
            sb.append(entry.getKey()).append(" -> ");
            String[] value = entry.getValue();
            if (value != null)
            {
                sb.append("(");
                appendTo(sb, Arrays.asList(value), ",");
                sb.append(")");
            }
            sb.append(','); // I know being lazy
        }

        return sb.append(']')
                .toString();
    }

    // borrowed from guava Join so can avoid guava dependency and OSGI fun
    private static StringBuilder appendTo(StringBuilder appendable, Iterable<?> parts, CharSequence separator)
    {
        Iterator<?> iterator = parts.iterator();
        if (iterator.hasNext()) {
            appendable.append(toString(iterator.next()));
            while (iterator.hasNext()) {
                appendable.append(separator);
                appendable.append(toString(iterator.next()));
            }
        }
        return appendable;
    }

    private static CharSequence toString(Object part) {
        return (part instanceof CharSequence) ? (CharSequence) part : part.toString();
    }


}
