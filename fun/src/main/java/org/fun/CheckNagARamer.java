package org.fun;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import lombok.NonNull;

/**
 * CheckNagARamer - Anagram Checker
 */
public class CheckNagARamer {

    /**
     * Indicates if the two supplied strings are anagrams.
     * Note: Writespace, capitalization, and punctuation are ignored.
     *
     * @param a Source data
     * @param b Source data
     * @return true if they strings are anagrams, false if they are not.
     */
    public static boolean areAnagrams(@NonNull String a, @NonNull String b) {
        return (a.equals(b) || sumCharValues(a) == sumCharValues(b));
    }

    /**
     * Performs a summation of the ascii alpha character values in the supplied string.
     * This routine is case-insensitive.
     *
     * @param s Source data
     * @return The total count of the ascii values.
     */
    protected static int sumCharValues(String s) {
        String localString = s.toLowerCase().replaceAll("[^a-zA-Z]", "");
        AtomicInteger asciiCount = new AtomicInteger(0);
        IntStream.range(0, localString.length())
                .parallel()
                .forEach(i -> asciiCount.addAndGet(localString.charAt(i)));
        return asciiCount.get();
    }

}
