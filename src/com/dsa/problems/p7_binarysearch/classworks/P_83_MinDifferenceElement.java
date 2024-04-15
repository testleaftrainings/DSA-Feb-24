package com.dsa.problems.p7_binarysearch.classworks;

public class P_83_MinDifferenceElement {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.


     Example 1:
     Input: [4, 6, 10], key = 7
     Output: 6
     Explanation: The difference between the key '7' and '6' is minimum than any other number in the array

     Example 2:
     Input: [4, 6, 10], key = 4
     Output: 4

     Example 3:
     Input: [1, 3, 8, 10, 15], key = 12
     Output: 10


     Example 4:
     Input: [4, 6, 10], key = 17
     Output: 10

     *******************************************************************************************************************/





    public static int searchMinDiffElement(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;

        // [3, 4, 7, 9], key=11
        if(key > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        // [3, 4, 7, 9], key=1
        if (key < arr[0]) {
            return arr[0];
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // start will point to the ceil of the key
        // end will point to the floor of the key
        if((arr[start] - key) < (key - arr[end])) {
            return arr[start];
        } else {
            return arr[end];
        }
    }

    public static void main(String[] args) {
        System.out.println("----> "+searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, -19));
    }

}
