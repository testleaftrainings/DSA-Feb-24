package com.dsa.problems.arraysandhashing.classworks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_03_ValidAnagram {

    // EASY
    // LEETCODE 242
    /********************************************************************************************************************

     Given two strings s1 and s2, return true if s2 is an anagram of s1, and false otherwise.

     An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     typically using all the original letters exactly once.

     Example 1:
     Input: s1 = "anagram", s2 = "nagaram"
     Output: true


     Example 2:
     Input: s1 = "rat", s2 = "car"
     Output: false

     Constraints:
     1 <= s.length, t.length <= 5 * 104
     s1 and s2 consist of lowercase English letters. // 26 letters

     *******************************************************************************************************************/



    // O(n1 + n2)T
    // O(1)S
    public static boolean isAnagram(String s1, String s2) {

        // edge cases
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0 && s2.length() == 0) return true;

        Map<Character, Integer> freq1 = new HashMap<>(); // --> O(26)S -> O(1)S
        Map<Character, Integer> freq2 = new HashMap<>(); // --> O(26)S -> O(1)S

        // a-> 3
        // c -> 5
        // m -> 45

        for (char c : s1.toCharArray()) { // -->  O(n1)T
            if (freq1.containsKey(c)) {
                freq1.put(c, freq1.get(c) + 1);
            } else {
                freq1.put(c, 1);
            }
        }
        for (char c : s2.toCharArray()) { // -->  O(n2)T
            if (freq2.containsKey(c)) {
                freq2.put(c, freq2.get(c) + 1);
            } else {
                freq2.put(c, 1);
            }
        }

        if (freq1.keySet().size() != freq2.keySet().size()) return false;

        for(char key : freq1.keySet()) { // --> O(no of unique chars in s1)T

            if (!freq2.containsKey(key)) {
                return false;
            }

            if (freq2.get(key).intValue() != freq1.get(key).intValue()) {
                return false;
            }
        }

        return true; // DR
    }


    // O(n)T
    // O(1)S
    public static boolean isAnagram_(String s1, String s2) {
        int[] s1Freq = new int[26]; // "[2, 0, 5, 0, 0, 10......100]"
        int[] s2Freq = new int[26];

        // a n a g r a m
        // a - a = 65 - 65 = 0
        // e - a = 70 - 65 = 5



        /*


        s1Freq = [3,-,-,-,-,..111.1..-]
                 [a,b,c,d,e,f,g.n....z]

         */

        // a n a g r a m
        //
        for(char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for(char c : s2.toCharArray()) {
            s2Freq[c - 'a']++;
        }


        return Arrays.toString(s1Freq).equals(Arrays.toString(s2Freq));
    }


    public static void main(String[] args) {
        System.out.println("---> " + isAnagram_("anagram", "nagaram"));
    }


}
