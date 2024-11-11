package org.fun;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Just having fun doing parentheses matching.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalancingJoy {

    static Map<Character, Character> matches = Map.of('(', ')', '{', '}', '[', ']');

    /**
     * Given a string containing characters such as '(', ')', '{', '}', '[' and ']',
     * this routine determines if the input string characters are properly balanced.
     *
     * @param s Input string
     * @return true if parentheses are properly balanced, false if not.
     */
    public static boolean isValid(@NonNull String s) {
        Deque<Character> parentheses = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (matches.containsKey(c)) {
                parentheses.push(c);
            } else if (!doesMatch(c, parentheses)) {
                return false;
            }
        }
        return parentheses.isEmpty();
    }

    /**
     * Checks to see if the supplied c fits the matching conditions.
     * If the supplied c is a closing parentheses character, then it is compared to the previous open parentheses
     * in the parentheses deque. If they match, true is returned; if not false is returned.
     * If c is not a closing parentheses, then true is returned.
     *
     * @param c           Character to examine
     * @param parentheses Deque with previous starting parentheses
     * @return true or false, see conditions above.
     */
    protected static boolean doesMatch(char c, Deque<Character> parentheses) {
        try {
            return !matches.containsValue(c) || matches.get(parentheses.pop()).equals(c);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}