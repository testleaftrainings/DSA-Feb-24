package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_09_EncodeAndDecodeStrings {

    // MEDIUM
    // LINTCODE 659
    /********************************************************************************************************************

     Design an algorithm to encode a list of strings to a string.
     The encoded string is then sent over the network and is decoded back to the original list of strings.

     Please implement encode and decode


     Example1
     Input: ["lint","code","love","you"]
     Output: ["lint","code","love","you"]
     Explanation:
     One possible encode method is: "lint:;code:;love:;you"


     Example2
     Input: ["we", "say", ":", "yes"]
     Output: ["we", "say", ":", "yes"]
     Explanation:
     One possible encode method is: "we:;say:;:::;yes"

     *******************************************************************************************************************/



    // O(n)T where n is the number of strings
    // O(n)S

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (String s : strs) { // O(n)T
            encodedString.append(s.length()).append('/').append(s);
        }

        return encodedString.toString(); // O(n)S
    }

    // Decodes a single string to a list of strings.

    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>(); // O(n)S
        int i = 0;

        // 4/lint4/code4/love3/you
        while (i < s.length()) { // O(n)T
            int slashIndex = s.indexOf('/', i);

            // Hello
            // 01234
            //substring(1,3) -> el

            int size = Integer.parseInt(s.substring(i, slashIndex));
            String word = s.substring(slashIndex+1, slashIndex+size+1);
            result.add(word);

            i = slashIndex + size + 1;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println("--> " + encode(Arrays.asList("Lint", "code", "love", "you")));
        decode(encode(Arrays.asList("Lint", "code", "love", "you"))).forEach(System.out::println);
    }

}
