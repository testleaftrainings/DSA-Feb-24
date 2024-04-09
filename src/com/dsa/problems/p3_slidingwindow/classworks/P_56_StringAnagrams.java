package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_56_StringAnagrams {

    // HARD
    /********************************************************************************************************************

     Given a string and a pattern, find all anagrams of the pattern in the given string.

     Every anagram is a permutation of a string.
     As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!
     permutations (or anagrams) of a string having N characters.

     For example, here are the six anagrams of the string “abc”:

     1) abc
     2) acb
     3) bac
     4) bca
     5) cab
     6) cba

     Write a function to return a list of starting indices of the anagrams of the pattern in the given string.


     Example 1:

     Input: String="ppqp", Pattern="pq"
     Output: [1, 2]
     Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".


     Example 2:

     Input: String="abbcabc", Pattern="abc"
     Output: [2, 3, 4]
     Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".


     *******************************************************************************************************************/


    public static List<Integer> findStringAnagrams(String str, String pattern) {

        List<Integer> result = new ArrayList<>();

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
            //System.out.println("toAdd : " + toAdd);

            // pre-check for an invalid char
            if(!patternFreq.containsKey(toAdd)) {
                windowStart = windowEnd + 1;
                windowFreq.clear();
                noOfCharsWeHave = 0;
                //System.out.println("Clearing everything and resetting the window");
                continue;
            }

            // valid char
            //System.out.println("Adding the current char into the window..");
            //System.out.println();
            windowFreq.merge(toAdd, 1, Integer::sum);
            //System.out.println("Current window freq map is here....");
            for(Map.Entry<Character, Integer> entry: windowFreq.entrySet()) {
                //System.out.println(entry.getKey() + "-->" + entry.getValue());
            }


            // check if your count matches
            // Important: we only check if the count exctly matches
            // we do not worry if the window count of the char is more than the required count
            if (windowFreq.get(toAdd).intValue() == patternFreq.get(toAdd).intValue()) {
                noOfCharsWeHave++;
                //System.out.println("We have achieved the required count for " + toAdd);
            }

            while (noOfCharsWeHave == noOfCharsToAchieve) {
                //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                //System.out.println("noOfCharsWeHave == noOfCharsToAchieve");
                //System.out.println("Current pattern : "+ pattern+ ", current window : "+str.substring(windowStart, windowEnd+1));
                int windowLen = windowEnd - windowStart + 1;


                // this check helps to validate the count of the chars
                if (windowLen == pattern.length()) {
                    //System.out.println("ALL GOOD");
                    result.add(windowStart);
                }

                // shrink on the left side
                char removedChar = str.charAt(windowStart++);
                //System.out.println("Shrinking on left and removing : "+removedChar);
                windowFreq.put(removedChar, windowFreq.get(removedChar) - 1);
                //System.out.println("After shrinking my window freq map is here....");
                for(Map.Entry<Character, Integer> entry: windowFreq.entrySet()) {
                    //System.out.println(entry.getKey() + "-->" + entry.getValue());
                }

                // we need to worry if the actual count goes less than the required count
                if (windowFreq.get(removedChar) < patternFreq.get(removedChar)) {
                    noOfCharsWeHave--;
                    //System.out.println("Oh no, my target for the char "+removedChar+" in Parretn is : "+patternFreq.get(removedChar)+" but my current freq for the same in my window is : "+windowFreq.get(removedChar));
                }


            }

        }

        // default return if nothing matches
        return result;

    }


    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
        System.out.println(findStringAnagrams("vanakkam", "knak"));
    }

}
