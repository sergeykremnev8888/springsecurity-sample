/*
 * Copyright 2003-2025 OneVizion, Inc. All rights reserved.
 */

package my.samples.springsecurity.utils;

import java.util.Locale;

public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("Object of the UTILS class cannot be instantiated.");
    }

    public static boolean isBlank(CharSequence value) {
        return value == null || value.toString().trim().isEmpty();
    }

    public static boolean isNotBlank(CharSequence value) {
        return value != null && !value.toString().trim().isEmpty();
    }

    public static String toUpperCase(String string) {
        if (string == null) {
            return null;
        }
        return string.toUpperCase(Locale.ROOT);
    }

    public static boolean equalsIgnoreCase(String string1, String string2) {
        return string1 == null ? string2 == null : string1.equalsIgnoreCase(string2);
    }
}
