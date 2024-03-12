package com.dsa.problems.p1_arraysandhashing.homeworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_15_PairsWithSpecificDifference {

    // MEDIUM
    /********************************************************************************************************************

     Given an array arr of distinct integers and a non negative integer k,
     write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr,
     such that x - y = k. If no such pairs exist, return an empty array.

     Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

     Examples:

     input:  arr = [0, -1, -2, 2, 1], k = 1
     output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

     input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
     output: []

     *******************************************************************************************************************/

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        List<int[]> result = new ArrayList<>();

        // load the map
        Set<Integer> existingNums = new HashSet<>(); // ---> O(n)S
        for(int i=0; i < arr.length; i++) { // ---> O(n)T
            existingNums.add(arr[i]);
        }


        for(int i=0; i < arr.length; i++) { // ---> O(n)T
            int y = arr[i];
            // x - y = k
            int x = k + y;

            if(existingNums.contains(x)) {
                result.add(new int[]{x, y});
            }
        }

        // convert list to array
        int[][] res = new int[result.size()][2]; // ---> O(n)S

        for(int i=0; i < result.size(); i++) { // ---> O(n)T
            res[i] = result.get(i);
        }

        return res;
    }

}
