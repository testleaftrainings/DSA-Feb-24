package com.dsa.problems.p2_twopointers.homeworks;

public class P_42_ValidateSubsequence {


    // EASY
    /********************************************************************************************************************

     Given two non-empty arrays of integers, write a function that determines
     whether the second array is a subsequence of the first one.

     A subsequence of an array is a set of numbers that aren't necessarily adjacent
     in the array but that are in the same order as they appear in the array. For
     instance, the numbers
     [1, 3, 4] form a subsequence of the array [1, 2, 3, 4] , and so do the numbers [2, 4].

     Note that a single number in an array and the array itself are both valid
     subsequences of the array.

     Sample Input:
     array =  = [5, 1, 22, 25, 6, -1, 8, 10]
     sequence = [1, 6, -1, 10]

     Sample Output: True

     *******************************************************************************************************************/

    // O(n)T
    // O(1)S

    public static boolean validateSubSequence(int[] array, int[] sequence) {
        int j = 0;

        for (int i = 0; i < array.length && j < sequence.length; i++) { // ---> O(n)T
            if(array[i] == sequence[j]) j++; // only if there is a match, move forward in the sequence
        }

        return (j == sequence.length);
    }


    public static void main(String[] args) {
        int[] array = new int[]{5,1,22,25,6,-1,8,10,11,7};
        int[] sequence = new int[]{1,6,-1,10};
        System.out.println(validateSubSequence(array, sequence));
    }


}
