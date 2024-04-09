package com.dsa.problems.p4_cyclicsort.classworks;

public class P_58_FindTheMissingNumber {

    // EASY
    /********************************************************************************************************************

     We are given an array containing n distinct numbers taken from the range 0 to n.
     Since the array has only n numbers out of the total n+1 numbers, find the missing number.


     Example 1:

     Input: [4, 0, 3, 1]
     Output: 2


     Example 2:

     Input: [8, 3, 5, 2, 4, 6, 0, 1]
     Output: 7

     *******************************************************************************************************************/

    // O(n)T
    // O(1)S

    public static int findMissingNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int currNum = nums[i];
            int targetIdx = currNum;

            // important to check if the current number may be fit into out of bounds
            if (currNum < nums.length && nums[targetIdx] != currNum) {
                swapper(nums, i, targetIdx);
            } else {
                i++;
            }
        }

        // by end of this while loop your array will be sorted
        // but one of the elemenet may be missing

        for (int j = 0; j < nums.length; j++) {
            int currNum = nums[j];
            int expectedNumber = j;

            if (expectedNumber != currNum) {
                return expectedNumber;
            }
        }

        // default return
        return nums.length;
    }

    private static void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static int findMissingNumber_best(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n+1)) / 2;

        int currSum = 0;
        for(int nu : nums) {
            currSum += nu;
        }

        return expectedSum - currSum;
    }


    public static void main(String[] args) {
        System.out.println(findMissingNumber_best(new int[]{0,1,2,3,5}));
    }


}
