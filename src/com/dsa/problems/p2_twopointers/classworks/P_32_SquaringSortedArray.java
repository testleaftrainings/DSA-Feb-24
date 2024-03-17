package com.dsa.problems.p2_twopointers.classworks;

import java.util.Arrays;

public class P_32_SquaringSortedArray {

    // EASY
    // LEETCODE 977
    /********************************************************************************************************************

     Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

     Example 0:

     Input: [1, 2, 3, 4, 5]
     Output: [1, 4, 9, 16, 25]


     Example 1:

     Input: [-2, -1, 0, 2, 3]
     Output: [0, 1, 4, 4, 9]


     Example 2:

     Input: [-3, -1, 0, 1, 2]
     Output: [0, 1, 1, 4, 9]

     *******************************************************************************************************************/

    // [-3, -1, 0, 1, 2, 3]

    // O(n)T
    // O(n)S
    public static int[] makeSquares(int[] arr) {

        // result array initiation
        int[] squares = new int[arr.length]; // --> O(n)S

        int left = 0;
        int right = arr.length-1;

        // loop from right to left of the result
        for (int i = arr.length-1; i >= 0; i--) { //---> O(n)T

            // find the mod or abs value of the left & right
            // who ever is bigger, square & add them to the result position
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                squares[i] = arr[left] * arr[left];
                left++;
            } else {
                squares[i] = arr[right] * arr[right];
                right--;
            }
        }

        return squares;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-100, -50, 2, 3, 25};
        System.out.println(Arrays.toString(makeSquares(arr)));
    }


}
