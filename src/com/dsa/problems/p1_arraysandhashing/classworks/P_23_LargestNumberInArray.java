package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.Arrays;
import java.util.Comparator;

public class P_23_LargestNumberInArray {

    // MEDIUM
    /********************************************************************************************************************

     Given a list of non negative integers, arrange them such that they form the largest number.

     Example 1:
     Input: nums = [10,2]
     Output: "210"

     Example 2:
     Input: nums = [3,30,34,5,9]
     Output: "9534330"

     Note: The result may be very large, so you need to return a string instead of an integer.

     *******************************************************************************************************************/


    // O(n log n)T
    // O(n)S

    public static String largestNumber(final int[] array) {

        if (array.length == 0) return "";

        // convert input into string array
        int n = array.length;
        String[] stringArray = new String[n]; // --> O(n)S

        // convert the int nums into string & load
        for (int i = 0; i < n; i++) { // --> O(n)T
            stringArray[i] = array[i] + "";
        }

        /*
        // creator comparator
        Comparator<String> concatenateLargest = (s1, s2) -> {
            // s1 = 10
            // s2 = 2
            String comb1 = s1 + s2; // 102
            String comb2 = s2 + s1; // 210

            long comb1Long = Long.parseLong(comb1);
            long comb2Long = Long.parseLong(comb2);

            if (comb1Long > comb2Long) {
                return -1;
            } else if (comb1Long < comb2Long) {
                return 1;
            } else {
                return 0;
            }
        };

        */

        Comparator<String> concatenateLargest = new ConcatenateLargestComparator();

        // sort using the comparator
        Arrays.sort(stringArray, concatenateLargest); // --> O(n log n)T

        // edge case
        if (stringArray[0].equals("0")) return "0";

        // build the result
        StringBuilder result = new StringBuilder();
        for (String str : stringArray) { // --> O(n)S
            result.append(str);
        }

        return result.toString();

    }


    static class ConcatenateLargestComparator implements Comparator<String> {

        // compare method can return 3 values
        // -1 : s1 -> s2
        // 1 : s2 -> s1
        // 0 : s1 -> s2 (or) s2 -> s1

        @Override
        public int compare(String s1, String s2) { // 10, 2
            String comb1 = s1 + s2; // 102
            String comb2 = s2 + s1; // 210

            long comb1Long = Long.parseLong(comb1); // 102
            long comb2Long = Long.parseLong(comb2); // 210

            if (comb1Long > comb2Long) {
                return -1;
            } else if (comb1Long < comb2Long) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        int[] input = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(input));

    }



}
