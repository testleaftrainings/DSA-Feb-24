package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.HashMap;
import java.util.Map;

public class P_52_LongestSubstrWithMaxKDistinctChars {

    // MEDIUM
    /********************************************************************************************************************

     Given a string, find the length of the longest substring in it with no more than K distinct characters.


     Example 1:
     Input: String="araaci", K=2
     Output: 4
     Explanation: The longest substring with no more than '2' distinct characters is "araa".


     Example 2:
     Input: String="araaci", K=1
     Output: 2
     Explanation: The longest substring with no more than '1' distinct characters is "aa".


     Example 3:
     Input: String="cbbeii", K=3
     Output: 5
     Explanation: The longest substrings with no more than '3' distinct characters is "bbeii".


     Example 4:
     Input: String="cbbebi", K=10
     Output: 6
     Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".

     *******************************************************************************************************************/


    // O(n)T
    // O(K)S

    public static int findLength(String str, int K) {

        int longestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>(); // --> O(K)S

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) { // --> O(n)T

            char c = str.charAt(windowEnd);
            charFreqMap.merge(c, 1, Integer::sum);
            System.out.println("************ GROWING ON THE RIGHT **************");
            System.out.println("Current SubString : " + str.substring(windowStart, windowEnd+1));

            // shrink
            while(charFreqMap.size() > K) {
                System.out.println("***** SHRINKING ON THE LEFT ");
                char leftChar = str.charAt(windowStart++);
                System.out.println("Current SubString : " + str.substring(windowStart, windowEnd+1));
                int leftCharFreq = charFreqMap.get(leftChar);
                if (leftCharFreq == 1) {
                    charFreqMap.remove(leftChar);
                } else {
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                }
            }

            // CT
            int windLen = windowEnd - windowStart + 1;
            longestLength = Math.max(longestLength, windLen);
        }

        return longestLength;
    }







    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        //System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        //System.out.println("Length of the longest substring: " + findLength("cbbeii", 3));
    }


}
