package com.dsa.problems.p2_twopointers.classworks;

import java.util.*;

public class P_39_QuadrupleSumToTarget {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of unsorted numbers and a target number,
     find all unique quadruplets in it, whose sum is equal to the target number.

     Example 1:

     Input: [4, 1, 2, -1, 1, -3], target=1
     Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
     Explanation: Both the quadruplets add up to the target.


     Example 2:

     Input: [2, 0, -1, 1, -2, 2], target=2
     Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
     Explanation: Both the quadruplets add up to the target.

     *******************************************************************************************************************/


    // [1,1,1,4,5,6,7,8,9]
    // fn = 1
    // sn = 1
    // left = 3
    // r = 9




    // O(n^3)T
    // O(n)S when you consider the sapce ofr arrays.sort and omit the space of result.,
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr); // --> O(n)S + O(n log n)T
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int firstNumIndex = 0; firstNumIndex < arr.length-3; firstNumIndex++) {

            // avoid duplicate check for first num
            if (firstNumIndex > 0 && arr[firstNumIndex] == arr[firstNumIndex-1]) { // turn back
                continue;
            }

            for (int secondNumIndex = firstNumIndex+1; secondNumIndex <arr.length - 2 ; secondNumIndex++) {

                // avoid duplicate check for second num
                if (secondNumIndex > firstNumIndex+1 && arr[secondNumIndex] == arr[secondNumIndex-1]) { // turn back
                    continue;
                }

                // two sum
                twoSum(arr, target, firstNumIndex, secondNumIndex, quadruplets);

            }

        }

        return quadruplets;

    }

    private static void twoSum(int[] arr, int target, int firstNumIdx, int secondNumIdx, List<List<Integer>> quadruplets) {

        int left = secondNumIdx+1;
        int right = arr.length-1;

        while (left < right) {

            // avoid duplicate check for left
            if (left > secondNumIdx + 1 && arr[left] == arr[left-1]) { // turn back
                continue;
            }

            // avoid duplicate check for right
            if (right < arr.length-1 && arr[right] == arr[right+1]) { // turn back
                continue;
            }

            int sum = arr[firstNumIdx] + arr[secondNumIdx] + arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                quadruplets.add(Arrays.asList(arr[firstNumIdx], arr[secondNumIdx], arr[left], arr[right]));
                left++;
                right--;
            }

        }

    }

}
