package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_05_FirstMissingPositiveInteger {

    // MEDIUM
    /********************************************************************************************************************

     Given an unsorted integer array nums, return the smallest missing positive integer.

     You must implement an algorithm that runs in O(n) time O(n) space.

     Example 1:
     Input: nums = [1,2,0]
     Output: 3

     Example 2:
     Input: nums = [3,4,-1,1]
     Output: 2

     Example 3:
     Input: nums = [7,8,9,11,12]
     Output: 1

     *******************************************************************************************************************/





    // O(n)T
    // O(n)S

    // [2,3,1,4]

    public static int firstMissingPositive(int[] nums) {

        Set<Integer> bag = new HashSet<>(); // ---> O(n)S
        for(int num : nums) { // --> O(n)T
            bag.add(num);
        }

        int length = nums.length;
        for (int i = 1; i <= length; i++) { // ---> O(n)T
            if (!bag.contains(i)) return i; // early return
        }

        return length + 1; // DR
    }


    public static void main(String[] args) {
        System.out.println("---> " + firstMissingPositive(new int[]{2,3,1,99,-1,77,4,7}));
    }

}
