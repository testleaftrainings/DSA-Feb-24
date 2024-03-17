package com.dsa.problems.p2_twopointers.classworks;

public class P_31_RemoveDuplicates {

    // EASY
    // LEETCODE 26
    /********************************************************************************************************************

     Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

     Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

     Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
     The remaining elements of nums are not important as well as the size of nums.
     Return k.

     Example 1:
     Input: [2, 3, 3, 3, 6, 9, 9]
     Output: 4
     Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

     Example 2:
     Input: [2, 2, 2, 11]
     Output: 2
     Explanation: The first two elements after removing the duplicates will be [2, 11].

     *******************************************************************************************************************/


    public static int remove(int[] nums) {

        // [2, 3, 3, 3, 6, 9, 9]

        int write = 1;

        for (int read = 1; read < nums.length; read++) {
            int currentNum = nums[read];
            int previousNum = nums[read-1];

            //System.out.println("currentNum : "+ currentNum);
            //System.out.println("previousNum : "+ previousNum);
            //System.out.println("Write index: "+write);

            if (currentNum != previousNum) {
                nums[write++] = currentNum;
                //System.out.println("New Write index: "+write);
            }


        }

        return write;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println("No of unique elements in the array: " + remove(nums));
        //for (int num: nums) {
            //System.out.println(num);
        //}

    }
}
