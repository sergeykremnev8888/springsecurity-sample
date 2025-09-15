/*
 * Copyright 2003-2025 OneVizion, Inc. All rights reserved.
 */

package my.samples.springsecurity.utils;

public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isBlank(CharSequence value) {
        return value == null || value.toString().trim().isEmpty();
    }

    public static boolean isNotBlank(CharSequence value) {
        return value != null && !value.toString().trim().isEmpty();
    }
}
