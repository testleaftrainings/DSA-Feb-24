package com.dsa.problems.p1_arraysandhashing.homeworks;

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



    // O(n)T
    // O(1)S

    public static boolean isMonotonic(int[] array) {
        // monotonic = either NonIncreasing or NonDecreasing
        return isNonDecreasing(array) || isNonIncreasing(array);
    }

    private static boolean isNonDecreasing(int[] array) {

        for (int i = 1; i < array.length; i++) { // --> O(n)T
            if(array[i-1] > array[i]) return false;
        }
        return true;
    }

    private static boolean isNonIncreasing(int[] array) {

        for (int i = 1; i < array.length; i++) { // --> O(n)T
            if(array[i-1] < array[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(isMonotonic(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }

}
