package com.dsa.problems.p6_stack.classworks;

import java.util.Stack;

public class P_75_NextSmallerElement {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a new array
     containing, at each index, the next element in the input array that's smaller
     than the element at that index in the input array.

     In other words, your function should return a new array where outputArray[i]
     is the next element in the input array that's
     smaller than inputArray[i]. If there's no such next smaller
     element for a particular index, the value at that index in the output array
     should be -1. For example, given array = [2, 1],
     your function should return [1, -1].

     Sample Input
     array = [2, 5, -3, -4, 6, 7, 2]

     Sample Output
     [-3, -3, -4, -1, 2, 2, -1]

     *******************************************************************************************************************/



    public static int[] nextSmallerElement(int[] array) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        for (int i = array.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        return result;
    }




    public static void main(String[] args) {
        int[] result = nextSmallerElement(new int[]{2, 5, -3, -4, 6, 7, 2});

        for(int r:result) {
            System.out.println(r+", ");
        }

    }

}
