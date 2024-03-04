package com.dsa.problems.arraysandhashing.homeworks;

public class P_12_MonotonicArray {

    // MEDIUM
    // Leetcode 896
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a boolean
     representing whether the array is monotonic.

     An array is said to be monotonic if its elements, from left to right, are
     entirely non-increasing or entirely non-decreasing.

     Non-increasing elements aren't necessarily exclusively decreasing; they simply
     don't increase. Similarly, non-decreasing elements aren't necessarily
     exclusively increasing; they simply don't decrease.

     Note that empty arrays and arrays of one element are monotonic.

     Sample Input
     array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]

     Sample Output: true

     *******************************************************************************************************************/



    public static boolean isMonotonic(int[] array) {
       return false;
    }

    public static void main(String[] args) {
        System.out.print(isMonotonic(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }

}
