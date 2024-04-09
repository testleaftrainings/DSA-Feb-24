package com.dsa.problems.p4_cyclicsort.classworks;

public class P_59_FindTheDuplicateNumber {

    // EASY
    /********************************************************************************************************************

     We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
     The array has only one duplicate but it can be repeated multiple times.
     Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.


     Example 1:

     Input: [1, 4, 4, 3, 2]
     Output: 4


     Example 2:

     Input: [2, 1, 3, 3, 5, 4]
     Output: 3


     Example 3:

     Input: [2, 4, 1, 4, 4]
            [1, 2, 4, 4, 4]
     Output: 4

     *******************************************************************************************************************/

    // O(n)T

    public static int findNumber(int[] nums) {

        int i = 0;

        // [1, 4, 4, 3, 2]
        while (i < nums.length) {

            int currNum = nums[i];
            int targetIdx = currNum - 1;

            // do: check if the number at the terget index is the current number, if not swap
            // dont: check what is the target index for the current number & see if the current idx is the target index
            // (i == targetIdx) XXXXXXXXXXXXXXXXXXXXXXXXXXX WRONG DONT DO IT
            // you will fall into infinite loop - especially because we have duplicates here
            if (nums[targetIdx] != currNum) {
                swapper(nums, i, targetIdx);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            int actualNum = nums[j];
            int expectedNum = j + 1; // crucial
            if (expectedNum != actualNum) return actualNum;
        }


        return -1;

    }

    private static void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
