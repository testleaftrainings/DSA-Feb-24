package com.dsa.problems.p5_sorting.classworks;

import java.util.Arrays;

public class P_66_MergeSort {



    // This is the basic logic for the merge sort
    // Though we don't use it, learn this first
    // IIt is a two pointer problem by itself ;-)
    public int[] mergeTwoSortedList(int[] input1, int[] input2) {

        int inputSize1 = input1.length;
        int inputSize2 = input2.length;

        int[] result = new int[inputSize1+inputSize2];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < inputSize1 && j < inputSize2) {
            if (input1[i] < input2[j]) {
                result[k++] = input1[i++];
            } else {
                result[k++] = input2[j++];
            }
        }

        // only one of the below loop will execute at the max

        // input1 is completely copied
        while(j < inputSize2) {
            result[k++] = input2[j++];
        }


        // input2 is completely copied
        while(i < inputSize1) {
            result[k++] = input1[i++];
        }

        return result;
    }











    // O(n log n)T
    // O(1)S
    public void mergeSort(int[] input) {
        int low = 0;
        int high = input.length - 1;
        recursiveMergeSort(input, low, high);
    }

    //[100, 2, 9, 3, 6]
    private void recursiveMergeSort(int[] input, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            recursiveMergeSort(input, low, mid); // left branching
            recursiveMergeSort(input, mid+1, high); // right branching
            mergeTwoSortedRangeOfArray(input, low, mid, high);
        }
    }



    // [-100, 2, 3, 99, 200, 202, 280, 670, 3030]
    // for this function the range from low to mid should be sorted
    // and mid+1 to high should also be sorted
    // [...........................................................................]
    private static void mergeTwoSortedRangeOfArray(int[] input, int low, int mid, int high) {

        int[] result = new int[high + 1];
        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j <= high) {
            if (input[i] < input[j]) {
                result[k++] = input[i++];
            } else {
                result[k++] = input[j++];
            }
        }

        while(i <= mid) {
            result[k++] = input[i++];
        }

        while(j <= high) {
            result[k++] = input[j++];
        }

        // copy the result back to the original array
        for (int x = low; x < result.length; x++) {
            input[x] = result[x];
        }

    }



    public static void print_iterative(int n) {
        while(n >= 0) {
            System.out.println(n);
            n--;
        }
    }



    public static void print_recursive(int n) {

        // base case for recursion
        if (n < 0) return;

        System.out.println(n);
        print_recursive(n-1);
    }



    public static void main(String[] args) {
        /* P_66_MergeSort ms = new P_66_MergeSort();
        int[] input = new int[]{2,44,99,34,76,0,108,96,7,5};
        ms.mergeSort(input);
        Arrays.stream(input).forEach(System.out::println);


         */
        print_recursive(10);

    }

}

