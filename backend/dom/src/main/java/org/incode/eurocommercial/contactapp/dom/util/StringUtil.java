package org.incode.eurocommercial.contactapp.dom.util;

import com.google.common.base.Strings;

public class StringUtil {
    private StringUtil() {
    }

    public static String firstNonEmpty(final String... str) {
        for (String s : str) {
            if (!Strings.isNullOrEmpty(s)) {
                return s;
            }
        }
        return null;
    }
}
