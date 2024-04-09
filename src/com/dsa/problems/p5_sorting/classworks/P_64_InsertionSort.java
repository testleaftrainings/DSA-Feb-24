package com.dsa.problems.p5_sorting.classworks;

import java.util.Arrays;

public class P_64_InsertionSort {

    // O(n^2)T Worst
    // O(n)T Best
    // O(1)S

    public void sort(int[] inputArray) {
        int n = inputArray.length;

        // [1,2,3,4,5]
        for (int i = 1; i < n; i++) { // number of passes

            System.out.println("\n Pass : "+i);
            System.out.println("Array before pass: "+Arrays.toString(inputArray));

            // always keep the toBeInserted as the new element to be inserted
            int toBeInserted = inputArray[i];

            int j = i-1; // we always start comparing toBeInserted with the immediate left(last element of previously sorted)
            while(j >= 0 && inputArray[j] > toBeInserted) {
                System.out.println("Inner loop execution");
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = toBeInserted;

            System.out.println("Array after pass: "+Arrays.toString(inputArray));


        }
    }

    public static void main(String[] args) {
        P_64_InsertionSort is = new P_64_InsertionSort();
        int[] input = new int[]{1,2,3,4,5,6,7,8,9,100};
        is.sort(input);
        Arrays.stream(input).forEach(System.out::println);
    }

}
