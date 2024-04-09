package com.dsa.problems.p5_sorting.classworks;

import java.util.Arrays;

public class P_63_BubbleSort {


    // worst case
    // O(n^2)T
    // O(1)S

    // best case
    // O(n)T
    // O(1)S


    // [1,2,3,4,5,6,7,8,9]
    public void sort(int[] inputArray) {

        int n = inputArray.length;
        for (int i = 0; i < n-1; i++) { // passes
            System.out.println("\nPASS : " + (i+1));
            System.out.println("Array before pass: "+ Arrays.toString(inputArray));


            boolean isSwapped = false; // changing the sorting algorithm as adaptive
            for (int j = 0; j < n-1-i; j++) { // this for loop is for entire pass
                if(inputArray[j] > inputArray[j+1]) {
                    // swap
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;

                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
            System.out.println("Array after pass: "+ Arrays.toString(inputArray));
        }



    }

    public static void main(String[] args) {
        P_63_BubbleSort bs = new P_63_BubbleSort();
        int[] input = new int[]{1,2,30,4,5,6,7,8,9};
        bs.sort(input);
        // Arrays.stream(input).forEach(System.out::println);

    }

}
