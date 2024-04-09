package com.dsa.problems.p5_sorting.classworks;

import java.util.Arrays;

public class P_65_SelectionSort {


    // O(n^2)T
    // O(1)S


    public void sort(int[] inputArray) {

        int n = inputArray.length;

        for (int currentPosition = 0; currentPosition < n-1; currentPosition++) { // passes

            System.out.println("\n Current index to be filled : "+currentPosition);
            System.out.println("Before pass: "+Arrays.toString(inputArray));

            // dynamic
            int runningPointer;
            int minIdxSoFar = currentPosition;

            // this for loop finds the minimum among all the available numbers and tracks it
            for (runningPointer=currentPosition+1; runningPointer < n; runningPointer++) {
                System.out.println("Inner loop execution");
                if(inputArray[runningPointer] < inputArray[minIdxSoFar]) {
                    minIdxSoFar = runningPointer;
                }
            }

            System.out.println("Swapping "+inputArray[minIdxSoFar]+ " with "+ inputArray[currentPosition]);


            // swap the min so far to the correct position
            int temp = inputArray[currentPosition];
            inputArray[currentPosition] = inputArray[minIdxSoFar];
            inputArray[minIdxSoFar] = temp;


            System.out.println("After pass: "+Arrays.toString(inputArray));


        }

    }

    public static void main(String[] args) {
        P_65_SelectionSort ss = new P_65_SelectionSort();
        int[] input = new int[]{1,2,3,4,5};
        ss.sort(input);
        //Arrays.stream(input).forEach(System.out::println);
    }

}
