package com.dsa.problems.p6_stack.homeworks;

public class P_85_PreviousSmallerElement {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a new array
     containing, at each index, the previous element in the input array that's smaller
     than the element at that index in the input array.

     In other words, your function should return a new array where outputArray[i] is the previous element in the input array that's
     smaller than inputArray[i]. If there's no such next smaller
     element for a particular index, the value at that index in the output array
     should be -1. For example, given array = [5, 2],
     your function should return [-1, -1].

     Sample Input
     array = [2, 67, 7, 4, 5]

     Sample Output
     [-1, 2, 2, 2, 4]

     *******************************************************************************************************************/


    public static int[] previousSmallerElement(int[] array) {
        return new int[]{};
    }





    public static void main(String[] args) {
        int[] result = previousSmallerElement(new int[]{2, 67, 7, 4, 5});

        for(int r:result) {
            System.out.println(r+", ");
        }

    }

}
