package com.dsa.problems.p4_cyclicsort.homeworks;

import java.util.ArrayList;
import java.util.List;

public class P_70_FindAllDuplicateNumbers {

    // EASY
    /********************************************************************************************************************

     We are given an unsorted array containing n numbers taken from the range 1 to n.
     The array has some numbers appearing twice, find all these duplicate numbers using constant space.


     Example 1:

     Input: [3, 4, 4, 5, 5]
     Output: [4, 5]


     Example 2:

     Input: [5, 4, 7, 2, 3, 5, 3]
     Output: [3, 5]

     *******************************************************************************************************************/


    public static List<Integer> findNumbers(int[] nums) {
        // ---> O(n)S
        List<Integer> duplicateNumbers = new ArrayList<>();

        int i = 0;

        while (i < nums.length) { // ---> O(n)T

            int currNum = nums[i];
            int targetIdx = currNum - 1;

            if (nums[targetIdx] == currNum) i++;
            else swap(nums, i, targetIdx);
        }

        // find all the duplicate numbers
        for (int j = 0; j < nums.length; j++) { // ---> O(n)T
            int currNum = nums[j];
            int expectedNum = j+1;

            if(expectedNum != currNum)  {
                duplicateNumbers.add(currNum);
            }
        }

        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
