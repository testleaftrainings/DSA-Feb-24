package com.dsa.problems.p2_twopointers.classworks;

import java.util.Arrays;

public class P_35_TripletSumCloseToTarget {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of unsorted numbers and a target number, find a triplet in the array whose
     sum is as close to the target number as possible, return the sum of the triplet.
     If there are more than one such triplet, return the sum of the triplet with the smallest sum.


     Example 1:

     Input: [-2, 0, 1, 2], target=2
     Output: 1
     Explanation: The triplet [-2, 1, 2] has the closest sum to the target.


     Example 2:

     Input: [-3, -1, 1, 2], target=1
     Output: 0
     Explanation: The triplet [-3, 1, 2] has the closest sum to the target.


     Example 3:

     Input: [1, 0, 1, 1], target=100
     Output: 3
     Explanation: The triplet [1, 1, 1] has the closest sum to the target.


     [-2, 0, 1,1, 100, 200, 300], target=1
     2


     *******************************************************************************************************************/


    // O(n^2)T
    // O(1)S

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);

        // CT variables
        int bestTripletSum = 0;
        int bestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) { // --> O(n^2)T
            int firstNum = arr[i];
            int left = i+1;
            int right = arr.length-1;

            while(left < right) { // --> O(n)T

                int sum = firstNum + arr[left] + arr[right];

                // CT
                int currDiff = Math.abs(targetSum - sum);
                if (currDiff < bestDifference) {
                    bestDifference = currDiff;
                    bestTripletSum = sum;
                }
                if (currDiff == bestDifference) {
                    bestTripletSum = Math.min(bestTripletSum, sum);
                }


                if (sum < targetSum) {
                    left++;
                } else if (sum > targetSum) {
                    right--;
                } else {
                    return sum;
                }

            }

        }

        return bestTripletSum;
    }


}
