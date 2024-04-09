package com.dsa.problems.p4_cyclicsort.classworks;

import java.util.Arrays;

public class P_57_CyclicSort {

    // EASY
    /********************************************************************************************************************

     We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n
     based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.

     Write a function to sort the objects in-place on their creation sequence number in O(n)
     and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers,
     though each number is actually an object.

     Example 1:

     Input: [3, 1, 5, 4, 2]
     Output: [1, 2, 3, 4, 5]


     Example 2:

     Input: [2, 6, 4, 3, 1, 5]
     Output: [1, 2, 3, 4, 5, 6]


     Example 3:

     Input: [1, 5, 6, 4, 3, 2]
     Output: [1, 2, 3, 4, 5, 6]

     *******************************************************************************************************************/

    // O(n)T
    // O(1)S

    public static void sort(int[] nums) {

        int i = 0;
        while (i < nums.length) { // --> O(n)T

            System.out.println();
            System.out.println("**************** i = "+ i);
            System.out.println(">>>>>>>>>>>>>>>>>>>>> Array now: "+Arrays.toString(nums) + "<<<<<<<<<<<<<<<<<<<<<<<<<");


            int currNum = nums[i];
            int targetIdx = currNum - 1;

            if (nums[targetIdx] != currNum) {
                System.out.println("Current number : " + currNum + " is not at the correct index " + targetIdx + " & so swapping them");
                swapper(nums, targetIdx, i);
                // important: do not increment i when you swap - because you do not know who is currently in the ith index
                System.out.println("After swapping: "+Arrays.toString(nums));
            } else {
                System.out.println("Current number : " + currNum + " is at the correct index " + targetIdx + " & WE ARE HAPPY and NO SWAPPING");
                i++;
            }
        }

    }

    private static void swapper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,4,3};
        sort(input);
        //System.out.println(Arrays.toString(input));
    }

}
