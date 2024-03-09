package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_20_ZeroSumSubarray {

    // MEDIUM
    /********************************************************************************************************************

     You're given a list of integers nums. Write a function that
     returns a boolean representing whether there exists a zero-sum subarray of nums.

     A zero-sum subarray is any subarray where all of the values add up to zero.
     A subarray is any contiguous section of the array. For the purposes of this
     problem, a subarray can be as small as one element and as long as the
     original array.

     Sample Input:
     nums = [-5, -5, 2, 3, -2]

     output: true, Formed by [-5,2,3]

     *******************************************************************************************************************/


    // O(n)T
    // O(n)S


    public static boolean zeroSumSubarray(int[] nums) {
        // [1 2 3 4 5]
        // initiations
        Set<Integer> seenPrefixSum = new HashSet<>(); // ---> O(n)S
        seenPrefixSum.add(0);

        int runningPrefixSum = 0;

        // looping through the numbers
        for (int num : nums) { // --> O(n)T

            // edge
            if (num == 0) return true;

            runningPrefixSum += num;

            // look for same prefix sum already seen?
            if (seenPrefixSum.contains(runningPrefixSum)) return true;
            else seenPrefixSum.add(runningPrefixSum);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(zeroSumSubarray(new int[]{-5, -5, 2, 3, -2}));
    }

}
