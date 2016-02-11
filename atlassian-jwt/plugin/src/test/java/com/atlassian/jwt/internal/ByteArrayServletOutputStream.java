package com.atlassian.jwt.internal;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class ByteArrayServletOutputStream extends ServletOutputStream
{
    private final OutputStream os;

    public ByteArrayServletOutputStream(ByteArrayOutputStream os)
    {
        if (null == os)
        {
            throw new IllegalArgumentException("os cannot be null");
        }

        this.os = os;
    }

    @Override
    public void write(int b) throws IOException
    {
        os.write(b);
    }
}