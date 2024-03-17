package com.dsa.problems.p2_twopointers.classworks;

import java.sql.SQLOutput;

public class P_30_TwoSum {

    // EASY
    // LEETCODE 1
    /********************************************************************************************************************

     Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
     Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

     Example 1:

     Input: [1, 2, 3, 4, 6], target=6
     Output: [1, 3]
     Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6


     Example 2:

     Input: [2, 5, 9, 11], target=11
     Output: [0, 2]
     Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int[] search(int[] arr, int targetSum) {

        // these points to the indices and not the actual numbers
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // --> O(n)T
            int currSum = arr[left] + arr[right];
            if(currSum < targetSum) {
                left++;
            } else if (currSum > targetSum) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-6, 0, 1, 3, 4, 6};
        int target = 0;
        int[] result = search(arr, target);
        System.out.println("Index 1 : " + result[0]);
        System.out.println("Index 2 : " + result[1]);
        System.out.println("Numbers are.. ");
        System.out.println(arr[result[0]] + ", " + arr[result[1]]);
    }

}
