package com.dsa.problems.p4_cyclicsort.classworks;

public class P_61_FindSmallestPositiveMissingNumber {

    // MEDIUM
    /********************************************************************************************************************

     Given an unsorted array containing numbers, find the smallest missing positive number in it.

     Note: Positive numbers start from ‘1’.

     Example 1:

     Input: [-3, 1, 5, 4, 2]
            [1, -3, 5, 4, 2]
     Output: 3
     Explanation: The smallest missing positive number is '3'

     Example 2:

     Input: [3, -2, 0, 1, 2]
     Output: 4


     Example 3:

     Input: [3, 2, 5, 1]
     Output: 4

     *******************************************************************************************************************/

    public static int findNumber(int[] nums) {
        int i =0;

        while (i < nums.length) {
            int currNum = nums[i];
            int targetIdx = currNum - 1;

            if (currNum > 0 && targetIdx < nums.length && nums[targetIdx] != currNum) {
                swapper(nums, i, targetIdx);
            } else {
                i++;
            }

        }

        for (int j = 0; j < nums.length; j++) {
            int actualNumber = nums[j];
            int expectedNumber = j+1;

            if (actualNumber != expectedNumber) {
                return expectedNumber;
            }
        }

        return nums.length;

    }

    private static void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
