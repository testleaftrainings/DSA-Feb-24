package com.dsa.problems.p1_arraysandhashing.homeworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_29_ConvertArrayTo2D {

    // MEDIUM
    // LEETCODE 2610
    /********************************************************************************************************************

     You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

     The 2D array should contain only the elements of the array nums.
     Each row in the 2D array contains distinct integers.
     The number of rows in the 2D array should be minimal.
     Return the resulting array. If there are multiple answers, return any of them.

     Note that the 2D array can have a different number of elements on each row.



     Example 1:

     Input: nums = [1,3,4,1,2,3,1]
     Output: [[1,3,4,2],[1,3],[1]]
     Explanation: We can create a 2D array that contains the following rows:
     - 1,3,4,2
     - 1,3
     - 1
     All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
     It can be shown that we cannot have less than 3 rows in a valid array.


     Example 2:

     Input: nums = [1,2,3,4]
     Output: [[4,3,2,1]]
     Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D

     *******************************************************************************************************************/

    // O(n*m)T
    // O(n)S

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        int rowsRequired = 0;

        // Group numbers by their value
        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                numMap.put(num, new ArrayList<>());
            }
            numMap.get(num).add(num);
            rowsRequired = Math.max(rowsRequired, numMap.get(num).size());
        }


        // Construct the matrix
        for (int i = 0; i < rowsRequired; i++) {
            List<Integer> row = new ArrayList<>();
            for (List<Integer> list : numMap.values()) {
                if (list.size() > i) {
                    row.add(list.get(i));
                }
            }
            result.add(row);
        }

        return result;
    }
}
