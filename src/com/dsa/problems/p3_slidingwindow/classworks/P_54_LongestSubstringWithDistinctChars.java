package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_54_LongestSubstringWithDistinctChars {

    // HARD
    /********************************************************************************************************************

     Given a string, find the length of the longest substring, which has all distinct characters.

     Example 1:

     Input: String="aabccbb"
     Output: 3
     Explanation: The longest substring with distinct characters is "abc".


     Example 2:

     Input: String="abbbb"
     Output: 2
     Explanation: The longest substring with distinct characters is "ab".


     Example 3:

     Input: String="abccde"
     Output: 3
     Explanation: Longest substrings with distinct characters are "abc" & "cde".


     *******************************************************************************************************************/


    // O(n)T
    // O(n)S

    public static int findLength(String s) {
        int maxLen = Integer.MIN_VALUE;
        Set<Character> windowChars = new HashSet<>(); // --> O(n)S
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) { //---> O(n)T
            char toAdd = s.charAt(windowEnd);

            if(windowChars.contains(toAdd)) {
                // I Keep shrinking on the left until the windowStart char becomes equal to the actual toAdd
                while(s.charAt(windowStart) != toAdd) {
                    windowChars.remove(s.charAt(windowStart++));
                }

                // This is actual removal of the duplicate chars
                windowChars.remove(s.charAt(windowStart++));
            }

            windowChars.add(toAdd);
            maxLen = Math.max(maxLen, windowEnd-windowStart+1);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("aaaaaaaaaaaaaabbbbbbbbbbbbbbbbcderffffffffffffffffff"));
        // abcderr
    }

}
