package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.Arrays;

public class P_07_ArrayOfProducts {

    // MEDIUM
    // LEETCODE 238
    /********************************************************************************************************************

     Also named as: Product of Array Except Self

     Write a function that takes in a non-empty array of integers and returns an
     array of the same length, where each element in the output array is equal to
     the product of every other number in the input array.

     In other words, the value at output[i] is equal to the product of
     every number in the input array other than input[i]

     Note that you're expected to solve this problem without using division.
     The output array should be the new array and you cannot modify the input array

     Sample Input
     array = [5, 1, 4, 2]

     Sample Output
     [8, 40, 10, 20]
     // 8 is equal to 1 x 4 x 2
     // 40 is equal to 5 x 4 x 2
     // 10 is equal to 5 x 1 x 2
     // 20 is equal to 5 x 1 x 4

     *******************************************************************************************************************/






    // NAIVE: Brute force:
    // Loop through the array and find product of rest of the numbers. It will run for time O(n^2) and space O(n)






    // **********************************************************************************************************************************************************************************************************************************************




    // O(3n)T = O(n)T
    // O(3n)S = O(n)S
    public static int[] arrayOfProducts(int[] array) {
        // create result array
        int length = array.length;
        int[] result = new int[length]; // --> O(n)S

        // create left & right product arrays
        int[] leftProductSoFar = new int[length]; // --> O(n)S
        int[] rightProductSoFar = new int[length]; // --> O(n)S

        // manipulate right & left product arrays
        int productSoFar = 1; // CT -> Continuous Tracking
        for (int i = 0; i < length; i++) { // --> O(n)T
            leftProductSoFar[i] = productSoFar;

            int currentNumber = array[i];
            productSoFar = productSoFar * currentNumber;
        }

        productSoFar = 1;
        for (int i = length-1; i >= 0; i--) { // --> O(n)T
            rightProductSoFar[i] = productSoFar;

            int currentNumber = array[i];
            productSoFar = productSoFar * currentNumber;
        }

        // generate the result
        for (int i = 0; i < length; i++) { // --> O(n)T
            result[i] = leftProductSoFar[i] * rightProductSoFar[i];
        }

        // return result
        return result;
    }





    public static int[] arrayOfProducts_better(int[] array) {

        int[] result = new int[array.length];

        int productSoFar = 1;

        for (int i = 0; i < array.length; i++) {
            result[i] = productSoFar;
            productSoFar *= array[i];
        }

        productSoFar = 1;
        for (int i = array.length-1; i >= 0 ; i--) {
            result[i] = result[i] * productSoFar;
            productSoFar *= array[i];
        }

        return result;
    }







    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 4, 2};
        int[] output = arrayOfProducts_better(input);
        System.out.println(Arrays.toString(output));


    }
}
