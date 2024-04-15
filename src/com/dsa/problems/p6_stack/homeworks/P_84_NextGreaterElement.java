package com.dsa.problems.p6_stack.homeworks;

public class P_84_NextGreaterElement {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a new array
     containing, at each index, the next element in the input array that's greater
     than the element at that index in the input array.

     In other words, your function should return a new array where outputArray[i] is the next element in the input array that's
     greater than inputArray[i]. If there's no such next greater
     element for a particular index, the value at that index in the output array
     should be -1. For example, given array = [1, 2],
     your function should return [2, -1].

     Sample Input
     array = [2, 5, -3, -4, 6, 7, 2]

     Sample Output
     [5, 6, 6, 6, 7, -1, -1]

     *******************************************************************************************************************/




    public static int[] nextGreaterElement(int[] array) {
        return new int[]{};
    }





    public static void main(String[] args) {
        int[] result = nextGreaterElement(new int[]{2, 5, -3, -4, 6, 7, 2});

        for(int r:result) {
            System.out.println(r+", ");
        }

    }



}
