package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_19_LargestRange {

    // HARD
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns an array of
     length 2 representing the largest range of integers contained in that array.

     The first number in the output array should be the first number in the range,
     while the second number should be the last number in the range.

     A range of numbers is defined as a set of numbers that come right after each
     other in the set of real integers. For instance, the output array [2, 6]
     represents the range {2, 3, 4, 5, 6} , which
     is a range of length 5. Note that numbers don't need to be sorted or adjacent
     in the input array in order to form a range.

     You can assume that there will only be one largest range.

     Sample Input
     array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]

     Sample Output: [0, 7]

     *******************************************************************************************************************/


    // O(n)T
    // O(n)S
    public static int[] largestRange(int[] nums) {

        // initiators
        int longestLength = 0;
        int[] result = new int[2];

        // load the numbers into bag
        Set<Integer> availableNums = new HashSet<>(); // ---> O(n)S
        for(int num : nums) { // --> O(n)T
            availableNums.add(num);
        }

        // loop through the input nums & process only for the start of the range nums
        for (int num : nums) { // --> O(n)T
            // look for the availability of the continuous range in the bag
            if (availableNums.contains(num-1)) {
                continue;
            }

            int currentLength = 1;
            int start = num;
            int currNum = num;

            // also track the length
            while (availableNums.contains(currNum+1)) {
                currNum++;
                currentLength++;
            }

            // CT result
            if (currentLength > longestLength) {
                longestLength = currentLength;
                result[0] = start;
                result[1] = currNum;
            }
        }

        return result;
    }




    public static void main(String[] args) {
        int[] op = largestRange(new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
        System.out.println(op[0]+","+op[1]);
    }

}
