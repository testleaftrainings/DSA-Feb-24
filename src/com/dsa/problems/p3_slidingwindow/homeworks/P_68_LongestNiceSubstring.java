package com.dsa.problems.p3_slidingwindow.homeworks;

import java.util.HashSet;
import java.util.Set;

public class P_68_LongestNiceSubstring {

    // EASY
    /********************************************************************************************************************

     A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

     Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.



     Example 1:
     Input: s = "YazaAay"
     Output: "aAa"
     Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
     "aAa" is the longest nice substring.

     Example 2:
     Input: s = "Bb"
     Output: "Bb"
     Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

     Example 3:
     Input: s = "c"
     Output: ""
     Explanation: There are no nice substrings.


     *******************************************************************************************************************/



    public String longestNiceSubstring(String s) {
        int maxLength = 0;
        String result = "";

        // Initialize the sliding window
        Set<Character> charSet = new HashSet<>();
        int windowStart = 0;

        // Iterate over the string
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);

            // Add the current character to the set
            charSet.add(c);

            // Shrink the window from the left until the substring becomes not nice
            while (!isNice(charSet)) {
                charSet.remove(s.charAt(windowStart++));
            }

            // Update the result if the current substring is longer
            if (charSet.size() == 26) {
                String substring = s.substring(windowStart, windowEnd + 1);
                if (substring.length() > maxLength) {
                    maxLength = substring.length();
                    result = substring;
                }
            }
        }

        return result;
    }

    // Helper method to check if a set contains all lowercase and uppercase letters
    private boolean isNice(Set<Character> charSet) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!charSet.contains(c) && !charSet.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }

}
