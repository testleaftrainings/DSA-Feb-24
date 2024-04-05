package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_01_ContainsDuplicate {

    // EASY
    // LEETCODE 217
    /********************************************************************************************************************

     Given an integer array nums, return true if any value appears at least twice in the array,
     and return false if every element is distinct.

     Example 1:
     Input: nums = [1,2,3,1]
     Output: true

     Example 2:
     Input: nums = [1,2,3,4]
     Output: false

     Example 3:
     Input: nums = [1,1,1,3,3,4,3,2,4,2]
     Output: true


     *******************************************************************************************************************/


    // Time: O(n^2)
    // Space: O(1)


    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;

        // edge cases
        if (len <= 1) return false;

        for (int i = 0; i < len-1; i++) {
            int primaryNum = nums[i];
            for (int j = i+1; j < len; j++) {
                int secondaryNum = nums[j];
                if (primaryNum == secondaryNum) {
                    return true; // Early return(ER)
                }
            }
        }

        return false; // default return (DR)
    }



    // O(n)T
    // O(n)S
    public static boolean containsDuplicate_bestTime(int[] nums) {

        if (nums.length <= 1) return false; // edge cases

        Set<Integer> bag = new HashSet<>(); // ---> O(n)S

        for(int num : nums) { // --> O(n)T
            System.out.println("--> " + num);
            if(bag.contains(num)) return true;
            else bag.add(num);
        }

        return false; // DR
    }

    // O(n log n)T
    // O(1)S
    public static boolean containsDuplicate_bestSpace(int[] nums) {
        Arrays.sort(nums); // ---> O(n log n)T

        for (int i = 0; i < nums.length; i++) { // --- O(n)T
            if (i == 0) continue;
            if (nums[i] == nums[i-1]) return true;
        }

        return false; // DR
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate_bestSpace(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10}));
        // test comment
    }

}
