package com.dsa.problems.p6_stack.homeworks;

public class P_87_PreviousGreaterElementCyclicArray {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a new array
     containing, at each index, the previous element in the input array that's greater
     than the element at that index in the input array. The input array is circular

     In other words, your function should return a new array where outputArray[i] is the previous element in the input array that's
     greater than inputArray[i]. If there's no such next greater
     element for a particular index, the value at that index in the output array
     should be -1. For example, given array = [5, 7],
     your function should return [7, -1].

     Sample Input
     array = [2, 67, 7, 4, 5]

     Sample Output
     [5, -1, 67, 7, 7]

     *******************************************************************************************************************/


    public static int[] previousGreaterElement_circular(int[] array) {
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] result = previousGreaterElement_circular(new int[]{2, 67, 7, 4, 5});

        for(int r:result) {
            System.out.println(r+", ");
        }
    }


}
