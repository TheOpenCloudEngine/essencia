package com.atlassian.jwt.core;

import java.util.Date;

/**
 * Abstraction to allow us to manipulate the current system time in unit tests.
 *
 * @since 1.0
 */
public interface Clock
{
    /**
     * @return the time right now.
     */
    Date now();
}
