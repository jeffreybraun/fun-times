package org.fun;

import static java.util.Objects.nonNull;

/**
 * gnirtSesreveR - ReverseString
 * <p>
 * Fun reversing Strings. Nothing much beyond fun.
 */
public class gnirtSesreveR {

    /**
     * ReverseSimple - elpmiSesrever
     *
     * @param s String to be reversed.
     * @return The reverses version of s.
     */
    public static String elpmiSesrever(String s) {
        return nonNull(s)
                ? (new StringBuilder(s)).reverse().toString()
                : null;
    }

    /**
     * Homegrown String Reverse
     *
     * @param s String to be reversed.
     * @return The reverses version of s.
     */
    public static String esrever(String s) {
        String result = null;
        if (nonNull(s)) {
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            result = sb.toString();
        }
        return result;
    }

}
