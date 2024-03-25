package com.dsa.problems.p2_twopointers.homeworks;

import java.util.Arrays;

public class P_41_SmallestDifference {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in two non-empty arrays of integers, finds the
     pair of numbers (one from each array) whose absolute difference is closest to
     zero, and returns an array containing these two numbers, with the number from
     the first array in the first position.

     Note that the absolute difference of two integers is the distance between
     them on the real number line. For example, the absolute difference of -5 and 5
     is 10, and the absolute difference of -5 and -4 is 1.

     You can assume that there will only be one pair of numbers with the smallest
     difference.

     Sample Input
     arrayOne = [-1, 5, 10, 20, 28, 3]
     arrayTwo = [26, 134, 135, 15, 17]

     Sample Output
     [28, 26]

     *******************************************************************************************************************/


    // O(m log m + n log n)T
    // O(1)S

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne); // --> O(m log m)T
        Arrays.sort(arrayTwo); // --> O(n log n)T

        int i = 0;
        int j = 0;

        // CT
        int smallestDiff = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        // loop until any of the pointers runs through fully
        while(i < arrayOne.length && j < arrayTwo.length) { // --> O(min(m, n))T

            // fetch first and second number from both the arrays
            int firstNum = arrayOne[i];
            int secondNum = arrayTwo[j];
            int currentDiff = 0;

            // traverse till you find 0 difference
            if(firstNum < secondNum) {
                currentDiff = secondNum - firstNum;
                i++; // traverse on first array
            } else if(secondNum < firstNum) {
                currentDiff = firstNum - secondNum;
                j++; // traverse on second array
            } else { // 0 difference found
                smallestPair[0] = firstNum;
                smallestPair[1] = secondNum;
                return smallestPair;
            }

            // CT
            if(currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestPair[0] = firstNum;
                smallestPair[1] = secondNum;
            }
        }

        return smallestPair;
    }




    public static void main(String[] args) {
        int[] res = smallestDifference(new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17});
        System.out.print(res[0] + "," + res[1]);
    }

}
