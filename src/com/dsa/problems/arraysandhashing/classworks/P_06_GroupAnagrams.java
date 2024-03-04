package com.dsa.problems.arraysandhashing.classworks;

import java.util.*;

public class P_06_GroupAnagrams {

    // MEDIUM
    // LEETCODE 49
    /********************************************************************************************************************

     Given an array of strings strs, group the anagrams together. You can return the answer in any order.

     An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     typically using all the original letters exactly once.

     Example 1:
     Input: strs = ["eat","tea","tan","ate","nat","bat"]
     Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

     Example 2:
     Input: strs = [""]
     Output: [[""]]

     Example 3:
     Input: strs = ["a"]
     Output: [["a"]]

     Constraints:
     1 <= strs.length <= 104
     0 <= strs[i].length <= 100
     strs[i] consists of lowercase English letters.

     *******************************************************************************************************************/

    // List: [bat]
    // List: [nat, tan]
    // List: [ate, eat, tea]
    // List: 3 above lists


    // O(n*l)T where n is the number of words and l is the avg length of the words
    // O(input)S

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> freqWordsMap = new HashMap<>(); // O(input)S

        for (String str : strs) { // --> O(n*l)T
            String freq = getFrequency(str);

            if (!freqWordsMap.containsKey(freq)) {
                freqWordsMap.put(freq, new ArrayList<>());
            }
            freqWordsMap.get(freq).add(str);


            if (freqWordsMap.containsKey(freq)) {
                freqWordsMap.get(freq).add(str);
            } else {
                List<String> words = new ArrayList<>();
                words.add(str);
                freqWordsMap.put(freq, words);
            }

        }


        List<List<String>> result = new ArrayList<>(); // O(input)S
        for (List<String> value : freqWordsMap.values()) { // --> O(unique freq)T XXXXX
            result.add(value);
        }
        return result;

        // return new ArrayList<>(freqWordsMap.values());
    }


   //  [aba]
    // "[2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,]"

    private static String getFrequency(String str) {
        int[] freq = new int[26];

        for(char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        return Arrays.toString(freq);
    }


    public static List<List<String>> groupAnagrams_discussions(String[] strs) {

        Map<String, List<String>> freqWordsMap = new HashMap<>(); // O(input)S

        for (String str : strs) { // --> O(n*l)T
            String freq = getFrequency(str);


            /*


            building a map with count
            [1,2,6,7,2,3,7,9,100,2]
            map: key = number
            value = count

            check if this key is present in the map
            if present
                simply increment the value of the key
                map.put(key, map.get(key)+1)
            if not present
                map.put(key, 1);


            freqWordsMap
            key = freq "[2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,]"
            value = List of words having the same frequency


            loop through the list of words
            get the frequency

            if not present
                simply create the entry inside the map with a empty list
                freqWordsMap.put(freq, new List<>());

            freqWordsMap.get(freq).add(word);

             */


            // easy variant of the above code
            if (freqWordsMap.containsKey(freq)) {
                freqWordsMap.get(freq).add(str);
            } else {
                List<String> words = new ArrayList<>();
                words.add(str);
                freqWordsMap.put(freq, words);
            }

        }


        List<List<String>> result = new ArrayList<>(); // O(input)S
        for (List<String> value : freqWordsMap.values()) { // --> O(unique freq)T XXXXX
            result.add(value);
        }
        return result;

        // return new ArrayList<>(freqWordsMap.values());
    }

}
