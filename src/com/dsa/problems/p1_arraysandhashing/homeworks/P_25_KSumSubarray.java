package com.dsa.problems.p1_arraysandhashing.homeworks;

import java.util.HashSet;
import java.util.Set;

public class P_25_KSumSubarray {

    // MEDIUM
    /********************************************************************************************************************

     You're given a list of integers nums. Write a function that
     returns a boolean representing whether there exists a K-sum subarray of nums.

     A K-sum subarray is any subarray where all of the values add up to K.
     A subarray is any contiguous section of the array. For the purposes of this
     problem, a subarray can be as small as one element and as long as the
     original array.


     Sample Input:
     nums = [-5, -5, 2, 3, -2], K=5

     output: true, Formed by [2,3]

     *******************************************************************************************************************/

    // O(n)T
    // O(n)S

    public boolean kSumSubarray(int[] nums, int k) {
        int runningPrefixSum = 0;
        Set<Integer> seenPrefixSum = new HashSet<>(); // --> O(n)S
        seenPrefixSum.add(0); //

        for(int num : nums) { // --> O(n)T
            runningPrefixSum += num;
            if(seenPrefixSum.contains(runningPrefixSum - k)) return true;
            else seenPrefixSum.add(runningPrefixSum);
        }

        return false;
    }

}
