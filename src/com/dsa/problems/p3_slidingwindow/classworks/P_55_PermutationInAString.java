package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.HashMap;
import java.util.Map;

public class P_55_PermutationInAString {

    //
    /********************************************************************************************************************

     Given a string and a pattern, find out if the string contains any permutation of the pattern.

     Permutation is defined as the re-arranging of the characters of the string.
     For example, “abc” has the following six permutations:

     1) abc
     2) acb
     3) bac
     4) bca
     5) cab
     6) cba

     If a string has ‘n’ distinct characters, it will have n! permutations.

     Example 1:
     Input: String="oidbcaf", Pattern="abc"
     Output: true
     Explanation: The string contains "bca" which is a permutation of the given pattern.

     Example 2:
     Input: String="odicf", Pattern="dc"
     Output: false
     Explanation: No permutation of the pattern is present in the given string as a substring.

     Example 3:
     Input: String="bcdxabcdy", Pattern="bcdyabcdx"
     Output: true
     Explanation: Both the string and the pattern are a permutation of each other.


     Example 4:
     Input: String="aaacb", Pattern="abc"
     Output: true
     Explanation: The string contains "acb" which is a permutation of the given pattern.
     *******************************************************************************************************************/

    // O(n+K)T
    // O(K)S

    public static boolean findPermutation(String str, String pattern) {

        // Static variables - Not changing
        Map<Character, Integer> patternFreq = new HashMap<>(); // --> O(K)S
        for(char ch: pattern.toCharArray()) { // --> O(K)T
            patternFreq.merge(ch, 1, Integer::sum);
        }
        int noOfCharsToAchieve = patternFreq.size();


        // Dynamic Variables
        Map<Character, Integer> windowFreq = new HashMap<>();
        int noOfCharsWeHave = 0;


        // String="oidaccccccbcaf", Pattern="abca"
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) { // --> O(n)T

            char toAdd = str.charAt(windowEnd);
            System.out.println("toAdd : " + toAdd);

            // pre-check for an invalid char
            if(!patternFreq.containsKey(toAdd)) {
                windowStart = windowEnd + 1;
                windowFreq.clear();
                noOfCharsWeHave = 0;
                System.out.println("Clearing everything and resetting the window");
                continue;
            }

            // valid char
            System.out.println("Adding the current char into the window..");
            System.out.println();
            windowFreq.merge(toAdd, 1, Integer::sum);
            System.out.println("Current window freq map is here....");
            for(Map.Entry<Character, Integer> entry: windowFreq.entrySet()) {
                System.out.println(entry.getKey() + "-->" + entry.getValue());
            }


            // check if your count matches
            // Important: we only check if the count exctly matches
            // we do not worry if the window count of the char is more than the required count
            if (windowFreq.get(toAdd).intValue() == patternFreq.get(toAdd).intValue()) {
                noOfCharsWeHave++;
                System.out.println("We have achieved the required count for " + toAdd);
            }

            while (noOfCharsWeHave == noOfCharsToAchieve) {
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("noOfCharsWeHave == noOfCharsToAchieve");
                System.out.println("Current pattern : "+ pattern+ ", current window : "+str.substring(windowStart, windowEnd+1));
                int windowLen = windowEnd - windowStart + 1;


                // this check helps to validate the count of the chars
                if (windowLen == pattern.length()) {
                    System.out.println("ALL GOOD");
                    return true;
                }

                // shrink on the left side
                char removedChar = str.charAt(windowStart++);
                System.out.println("Shrinking on left and removing : "+removedChar);
                windowFreq.put(removedChar, windowFreq.get(removedChar) - 1);
                System.out.println("After shrinking my window freq map is here....");
                for(Map.Entry<Character, Integer> entry: windowFreq.entrySet()) {
                    System.out.println(entry.getKey() + "-->" + entry.getValue());
                }

                // we need to worry if the actual count goes less than the required count
                if (windowFreq.get(removedChar) < patternFreq.get(removedChar)) {
                    noOfCharsWeHave--;
                    System.out.println("Oh no, my target for the char "+removedChar+" in Parretn is : "+patternFreq.get(removedChar)+" but my current freq for the same in my window is : "+windowFreq.get(removedChar));
                }


            }

        }

        // default return if nothing matches
        return false;


    }

    // abccdcccccccccce          dec




    public static void main(String[] args) {
        /*System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
        System.out.println("Permutation exist: " + findPermutation("thirumalaiprabu", "aal"));
        System.out.println("Permutation exist: " + findPermutation("aathiran", "ata"));
        System.out.println("Permutation exist: " + findPermutation("avvaishanmugi", "guia"));*/
        System.out.println("Permutation exist: " + findPermutation("oidccccccbcaaf", "abca"));


    }



}
