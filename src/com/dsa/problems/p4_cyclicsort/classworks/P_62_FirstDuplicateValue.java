package com.dsa.problems.p4_cyclicsort.classworks;

import java.util.Arrays;

public class P_62_FirstDuplicateValue {


    // MEDIUM
    /********************************************************************************************************************

     Given an array of integers between 1 and n ,
     inclusive, where n is the length of the array, write a function
     that returns the first integer that appears more than once (when the array is
     read from left to right).

     In other words, out of all the integers that might occur more than once in the
     input array, your function should return the one whose first duplicate value
     has the minimum index.

     If no integer appears more than once, your function should return -1

     Note that you're allowed to mutate the input array.

     Sample Input #1
     array = [2, 1, 5, 2, 3, 3, 4]

     Sample Output #1
     2

     Sample Input #2
     array = [2, 1, 5, 3, 3, 2, 4]

     Sample Output #2
     3

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S
    public static int firstDuplicateValue(int[] array) {

        for (int i = 0; i < array.length; i++) { // --> O(n)T

            int currNum = Math.abs(array[i]);
            System.out.println("\n****** ITERATION ******");
            System.out.println("Before Iteration : " + Arrays.toString(array));
            System.out.println("currNum : "+currNum);
            int correspondingIdx = currNum - 1;


            if (array[correspondingIdx] < 0) {
                return currNum;
            }

            // turn into negative / marking my presence
            array[correspondingIdx] = -array[correspondingIdx];

            System.out.println("After Iteration : " + Arrays.toString(array));


        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println("--> "+ firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4}));
    }





}
