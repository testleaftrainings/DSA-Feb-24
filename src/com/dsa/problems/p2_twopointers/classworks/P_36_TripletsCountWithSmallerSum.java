package com.dsa.problems.p2_twopointers.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_36_TripletsCountWithSmallerSum {

    // MEDIUM
    /********************************************************************************************************************

     Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
     arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
     Write a function to return the count of such triplets.

     Example 1:

     Input: [-1, 0, 2, 3], target=3
     Output: 2
     Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]


     Example 2:

     Input: [-1, 4, 2, 1, 3], target=5
     Output: 4
     Explanation: There are four triplets whose sum is less than the target:
     [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]


     *******************************************************************************************************************/

    // O(n^2)T
    // O(1)S

    public static int getTripletCounts(int[] arr, int target) {
        // sort the array
        Arrays.sort(arr); // --> O(n log n)T
        // initialize the result

        int count = 0;

        // loop through the array
        for (int i = 0; i < arr.length - 2; i++) { // --> O(n^2)T

            // keep the firstnum constant & in the remaining array look for the balance with a two pointer
            int firstNum = arr[i];

            int lookFor = target - firstNum;

            // two sum from now on..
            int left = i+1;
            int right = arr.length - 1;

            // [1,2,3,4,5,6,7,8,9,10] & tar = 100
            while(left < right) { // --> O(n)T
                int sum =  arr[left] + arr[right];

                if (sum < lookFor) {
                    count = count + (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }

        // return
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 4, 2, 1, 3};
        System.out.println(getTripletCounts(arr, 5));
    }

}
