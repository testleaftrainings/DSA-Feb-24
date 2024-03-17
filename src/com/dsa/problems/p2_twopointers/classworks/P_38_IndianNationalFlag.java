package com.dsa.problems.p2_twopointers.classworks;

public class P_38_IndianNationalFlag {

    // MEDIUM
    /********************************************************************************************************************

     Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
     hence, we can’t count 0s, 1s, and 2s to recreate the array.

     The flag of the India consists of three colors: red, white and blue; and since our input array also consists of
     three different numbers that is why it is called Indian National Flag problem.

     Example 1:
     Input: [1, 0, 2, 1, 0]
     Output: [0, 0, 1, 1, 2]

     Example 2:
     Input: [2, 2, 0, 1, 2, 0]
     Output: [0, 0, 1, 2, 2, 2]

     *******************************************************************************************************************/




    // O(n)T
    // O(1)S
    public static void sort(int[] arr) {

        int write0 = 0;
        int read = 0;
        int write2 = arr.length - 1;

        while(read <= write2) { //--> O(n)T

            if(arr[read] == 0) {
                swapper(arr, read, write0);
                read++;
                write0++;
            } else if (arr[read] == 2) {
                swapper(arr, read, write2);
                write2--;
                // do not increment read here: you dont know what is coming in here
            } else {
                read++;
            }

        }
    }

    private static void swapper(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
