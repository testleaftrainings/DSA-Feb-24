package com.dsa.problems.p1_arraysandhashing.classworks;

import java.sql.SQLOutput;
import java.util.*;

public class P_24_WordCountEngine {

    // MEDIUM
    /********************************************************************************************************************

     Implement a document scanning function wordCountEngine,
     which receives a string document and returns a list of all unique words in it and their number of occurrences,
     sorted by the number of occurrences in descending order.
     If two or more words have the same count, they should be sorted according to their order in the original sentence.
     Assume that all letters are in english alphabet. Your function should be case-insensitive,
     so for instance, the words “Perfect” and “perfect” should be considered the same word.

     The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

     Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial
     space complexity.

     Examples:
     input:  document = "Practice makes perfect. you'll only
     get Perfect by practice. just practice!"

     output: [ ["practice", "3"], ["perfect", "2"],
     ["makes", "1"], ["youll", "1"], ["only", "1"],
     ["get", "1"], ["by", "1"], ["just", "1"] ]


     Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3).
     We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create
     mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.).
     The expected output will simply be an array of string arrays.

     *******************************************************************************************************************/


    // O(n)T
    // O(n)S

    public static String[][] wordCountEngine(String document) {

        // convert to lower case
        document = document.toLowerCase(); // --> O(n)T

        // avoid other special chars
        document = document.replaceAll("[^a-z ]", ""); // --> O(n)T

        // convert input into string array
        String[] words = document.split(" "); // --> O(n)T & O(n)S


        // build word-freq map
        Map<String, Integer> wordFreqmap = new HashMap<>(); // --> O(n)S
        for (String word : words) { // --> O(n)T
            if (word.length() > 0) {
                wordFreqmap.merge(word, 1, Integer::sum);
            }
        }
        int resultSize = wordFreqmap.size(); // no of unique words in the input


        // build freq-wordsmap
        Map<Integer, List<String>> freqWordsMap = new HashMap<>(); // --> O(n)S
        for (int i = 0; i < words.length; i++) { // --> O(n)T
            String word = words[i];

            if(!wordFreqmap.containsKey(word)) continue;

            int freq = wordFreqmap.get(word);

            if(freqWordsMap.containsKey(freq)) {
                freqWordsMap.get(freq).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                freqWordsMap.put(freq, list);
            }

            // not forget
            wordFreqmap.remove(word);
        }

        // sort the keys of the freq-words map & then for the output
        List<Integer> allDiffFreq = new ArrayList<>(freqWordsMap.keySet()); // --> O(F)S
        Collections.sort(allDiffFreq, (a,b) -> b - a); // --> O(F log F)T

        String[][] result = new String[resultSize][2]; // -- O(n)S
        int i = 0;
        for(int freq : allDiffFreq) { //--> O(n)T
            List<String> allWords = freqWordsMap.get(freq);
            for (String word : allWords) {
                result[i++] = new String[]{word, freq+""};
            }
        }

        return result;
    }


    public static void main(String[] args) {

        String document = "Practice makes perfect. you'll only  get Perfect by practice. just practice!";
        String [][] result = wordCountEngine(document);

        for (String[] r : result) {
            System.out.println(Arrays.toString(r));
        }


    }
}
