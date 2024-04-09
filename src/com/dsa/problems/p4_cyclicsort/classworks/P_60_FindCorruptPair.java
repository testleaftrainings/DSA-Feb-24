package com.dsa.problems.p4_cyclicsort.classworks;

public class P_60_FindCorruptPair {

    // EASY
    /********************************************************************************************************************

     We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
     The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
     one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

     Example 1:

     Input: [3, 1, 2, 5, 2]
     Output: [2, 4]
     Explanation: '2' is duplicated and '4' is missing.


     Example 2:

     Input: [3, 1, 2, 3, 6, 4]
     Output: [3, 5]
     Explanation: '3' is duplicated and '5' is missing.

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int[] findNumbers(int[] nums) {


        int i =0;

        while (i < nums.length) {

            int currNum = nums[i];
            int targetIdx = currNum - 1;

            if (nums[targetIdx] != currNum) {
                swapper(nums, i, targetIdx);
            } else {
                i++;
            }

        }

        for (int j = 0; j < nums.length; j++) {
            int actualNumber = nums[j];
            int expectedNumber = j-1;

            if (actualNumber != expectedNumber) {
                return new int[]{actualNumber, expectedNumber};
            }
        }

        return new int[]{-1,-1};


    }

    private static void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
