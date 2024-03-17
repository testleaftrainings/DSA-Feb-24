package com.dsa.problems.p2_twopointers.classworks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_37_SubarraysWithProductLessThanTarget {

    // MEDIUM
    /********************************************************************************************************************

     Given an array with positive numbers and a positive target number,
     find all of its contiguous subarrays whose product is less than the target number.

     Example 1:

     Input: [2, 5, 3, 10], target=30
     Output: [2], [5], [2, 5], [3], [5, 3], [10]
     Explanation: There are six contiguous subarrays whose product is less than the target.


     Example 2:

     Input: [8, 2, 6, 5], target=50
     Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
     Explanation: There are seven contiguous subarrays whose product is less than the target.

     *******************************************************************************************************************/



    // O(n^3)T
    // O(n^3)S
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        // no need of sorting here
        List<List<Integer>> result = new ArrayList<>(); // --> O(n^3)S

        int windowProduct = 1;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) { // --> O(n^3)T
            windowProduct = windowProduct * arr[windowEnd];
            // shrink the window on the left if the product is greater than or equal to target
            while(windowStart <= windowEnd && windowProduct >= target) {
                windowProduct = windowProduct / arr[windowStart++];
            }
            // collate all possible subarrays of the window
            // WINDOW: [1,2,3,4,5]
            // [5]
            // [4,5]
            // [3,4,5]
            // [2,3,4,5]
            // [1,2,3,4,5]

            int left = windowStart;
            List<Integer> tempList = new LinkedList<>();
            for (int right = windowEnd; right >= left; right--) { // --> O(n)T
                tempList.addFirst(arr[right]); // --> O(1)T
                result.add(new ArrayList<>(tempList)); // --> O(n)T
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 6, 5};
        List<List<Integer>> res = findSubarrays(arr, 50);

        for(List<Integer> r: res) {
            System.out.println("*********");
            r.forEach(System.out::println);
        }
    }

}
