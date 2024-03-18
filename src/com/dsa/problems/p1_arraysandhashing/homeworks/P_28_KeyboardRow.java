package com.dsa.problems.p1_arraysandhashing.homeworks;

import java.util.ArrayList;
import java.util.List;

public class P_28_KeyboardRow {

    // EASY
    // LEETCODE 500
    /********************************************************************************************************************

     Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

     In the American keyboard:

     the first row consists of the characters "qwertyuiop",
     the second row consists of the characters "asdfghjkl", and
     the third row consists of the characters "zxcvbnm".

     Example 1:

     Input: words = ["Hello","Alaska","Dad","Peace"]
     Output: ["Alaska","Dad"]
     Example 2:

     Input: words = ["omk"]
     Output: []
     Example 3:

     Input: words = ["adsdf","sfd"]
     Output: ["adsdf","sfd"]


     Constraints:

     1 <= words.length <= 20
     1 <= words[i].length <= 100
     words[i] consists of English letters (both lowercase and uppercase).

     *******************************************************************************************************************/

    //  O(n*m)T, where n is the number of words and m is the maximum length of a word.
    //  O(1)S (excluding the space used for input and output)

    public String[] findWords(String[] words) {
        // Define keyboard rows including both cases
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        List<String> result = new ArrayList<>();

        for (String word : words) {
            // Variables to track if word can be typed in each row
            boolean inRow1 = true;
            boolean inRow2 = true;
            boolean inRow3 = true;

            // Iterate through each character of the word
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                // Check if character is in row 1
                if (!row1.contains(String.valueOf(c))) {
                    inRow1 = false;
                }

                // Check if character is in row 2
                if (!row2.contains(String.valueOf(c))) {
                    inRow2 = false;
                }

                // Check if character is in row 3
                if (!row3.contains(String.valueOf(c))) {
                    inRow3 = false;
                }
            }

            // Add word to result if it can be typed in any row
            if (inRow1 || inRow2 || inRow3) {
                result.add(word);
            }
        }

        // Convert result list to array
        return result.toArray(new String[0]);
    }
}
