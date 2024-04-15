package com.dsa.problems.p7_binarysearch.classworks;

import java.util.Arrays;

public class P_79_BinarySearch {

    // EASY
    /********************************************************************************************************************

     Write code for a binary search in a sorted array for a specific key. RETURN the index

     *******************************************************************************************************************/



    // Solution:


    // Category: Modified Binary Search

    // Time: O(log n) : because at each iteration we are covering 1/2 of the range
    //                : in fact that's the beauty of binary search, it doesnt need O(n) complexity.
    //                : but the input should be sorted for you to perform binary search
    // Space: O(1)







    // [1, 3, 5, 77, 80, 89, 212, 345, 1000] key = 345
    public static int binarySearch(int[] arr, int key) {
        int startIdx = 0;
        int endIdx = arr.length - 1;

        while(startIdx <= endIdx) {

            System.out.println("\n\nMy Array to Search : "+ Arrays.toString(Arrays.copyOfRange(arr, startIdx, endIdx+1)));

            int midIdx = startIdx + (endIdx - startIdx) / 2;
            // [5,6,7,8,9]
            // mixidx = 5 + 4 / 2 = 7

            System.out.println("Middle value : "+arr[midIdx]);

            if (arr[midIdx] < key) {
                System.out.println(key+" is to my(middle's) right");
                startIdx = midIdx + 1;
            } else if (arr[midIdx] > key) {
                System.out.println(key+" is to my(middle's) left");
                endIdx = midIdx - 1;
            } else {
                System.out.println("I found the value : "+key);
                return midIdx;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println("--> " + binarySearch(new int[]{1, 3, 5, 77, 80, 89, 212, 345, 1000}, 345));
    }


}
