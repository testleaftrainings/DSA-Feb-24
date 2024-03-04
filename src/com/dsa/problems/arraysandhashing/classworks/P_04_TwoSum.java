package com.dsa.problems.arraysandhashing.classworks;

import java.util.HashMap;
import java.util.Map;

public class P_04_TwoSum {

    // EASY
    // LEETCODE 1
    /********************************************************************************************************************

     Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     You can return the answer in any order.

     Example 1:
     Input: nums = [2,7,11,15], target = 9
     Output: [0,1]
     Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


     Example 2:
     Input: nums = [3,2,4], target = 6
     Output: [1,2]


     Example 3:
     Input: nums = [3,3], target = 6
     Output: [0,1]


     Constraints:
     2 <= nums.length <= 104
     -109 <= nums[i] <= 109
     -109 <= target <= 109
     Only one valid answer exists.

     *******************************************************************************************************************/



    // O(n)T
    // O(n)S

    public int[] twoSum(int[] nums, int targetSum) {

        // Edge
        if (nums.length <= 1) return new int[]{};

        Map<Integer, Integer> seen = new HashMap<>(); // --> O(n)S
        // key = number
        // value = corresponding index in input nums array

        for (int i = 0; i < nums.length; i++) { // --> O(n)T

            int x = nums[i];
            int y = targetSum - x;

            if (seen.containsKey(y)) {
                return new int[]{i, seen.get(y)};
            } else {
                seen.put(x, i);
            }
        }

        return new int[]{}; // DR

    }

}
