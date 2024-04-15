package com.dsa.problems.p6_stack.classworks;

import java.util.Stack;

public class P_74_PreviousGreaterElement {

    // MEDIUM
    /********************************************************************************************************************

     Write a function that takes in an array of integers and returns a new array
     containing, at each index, the previous element in the input array that's greater
     than the element at that index in the input array.

     In other words, your function should return a new array where outputArray[i] is the
     previous element in the input array that's
     greater than inputArray[i]. If there's no such next greater
     element for a particular index, the value at that index in the output array
     should be -1. For example, given array = [5, 2],
     your function should return [-1, 5].

     Sample Input
     array = [2, 67, 7, 4, 5]

     Sample Output
     [-1, -1, 67, 7, 7]

     *******************************************************************************************************************/



    // O(n)T
    // O(n)S

    public static int[] previousGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>(); // --> O(n)S
        int[] result = new int[array.length];  // --> O(n)S

        for (int i = 0; i < array.length; i++) {  // --> O(n)T

            // keep popping from stack till you find a greater element
            while(!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(array[i]); // must do in all cases
        }

        return result;
    }


    public static void main(String[] args) {
        int[] result = previousGreaterElement(new int[]{2, 67, 7, 4, 5});

        for(int r:result) {
            System.out.println(r+", ");
        }

    }








}
