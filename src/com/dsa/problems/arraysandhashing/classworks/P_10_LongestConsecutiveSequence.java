package com.dsa.problems.arraysandhashing.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_10_LongestConsecutiveSequence {

    // MEDIUM
    // LEETCODE 128
    /********************************************************************************************************************

     Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

     You must write an algorithm that runs in O(n) time.

     Example 1:
     Input: nums = [100,4,200,1,3,2]
     Output: 4
     Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


     Example 2:
     Input: nums = [0,3,7,2,5,8,4,6,0,1,99,100,98,101]
     Output: 9

     *******************************************************************************************************************/


    // O(n)T
    // O(n)S

    public int longestConsecutive(int[] nums) {

        // Set<Integer> startNumbersAlreadyChecked = new HashSet<>();
        Set<Integer> availableNumbers = new HashSet<>(); // --> O(n)S
        for (int num : nums) { // --> O(n)T
            availableNumbers.add(num);
        }

        int maxLength = 0; // CT

        for (int num : nums) { // --> O(n)T

            if (availableNumbers.contains(num-1)) continue;
            // if (startNumbersAlreadyChecked.contains(num)) continue;

            int currentLength = 1;

            while(availableNumbers.contains(num+currentLength)) {
                currentLength++;
            }

            maxLength = Math.max(maxLength, currentLength);
            // startNumbersAlreadyChecked.add(num);
        }

        return maxLength;

    }

    public static void main(String[] args) {

    }

}
