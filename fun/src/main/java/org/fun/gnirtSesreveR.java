package org.fun;

import static java.util.Objects.nonNull;

import java.util.stream.IntStream;

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
     * @return The reversed version of s.
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
     * @return The reversesd version of s.
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

    /**
     * Reverses a string via parallel activities.
     *
     * @param s String to be reversed.
     * @return The reversed version of s.
     */
    public static String lellaraPesrever(String s) {
        String result = null;
        if (nonNull(s)) {
            char[] chars = new char[s.length()];
            IntStream.range(0, s.length())
                    .parallel()
                    .forEach(i -> chars[(s.length()-1) - i] = s.charAt(i));
            result = new String(chars);
        }
        return result;
    }

}
