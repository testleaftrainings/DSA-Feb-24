package com.dsa.problems.p4_cyclicsort.homeworks;

import java.util.ArrayList;
import java.util.List;

public class P_69_FindAllMissingNumbers {

    // EASY
    /********************************************************************************************************************

     We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
     The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.


     Example 1:

     Input: [2, 3, 1, 8, 2, 3, 5, 1]
     Output: 4, 6, 7
     Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

     Example 2:

     Input: [2, 4, 1, 2]
     Output: 3

     Example 3:

     Input: [2, 3, 2, 1]
     Output: 4

     *******************************************************************************************************************/


    public static List<Integer> findNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // cycle sort
        int i = 0;

        while(i < nums.length) { // --------> O(n)T

            int currNum = nums[i];
            int targetIndex = currNum - 1;

            if(nums[targetIndex] == currNum) i++;
            else swap(nums, i, targetIndex);
        }

        for (int j = 0; j < nums.length; j++) { // -----> O(n)T
            int expectedNum = j+1;
            int currNum = nums[j];

            if(currNum != expectedNum) {
                result.add(expectedNum);
            }
        }

        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] input = new int[]{5, 3, 1, 3, 4};
        List<Integer> res = findNumbers(input);
        for (Integer re : res) {
            System.out.println("----> " + re);
        }
    }
}
