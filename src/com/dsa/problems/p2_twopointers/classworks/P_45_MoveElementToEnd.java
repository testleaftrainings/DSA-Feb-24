package com.dsa.problems.p2_twopointers.classworks;

import java.util.Arrays;
import java.util.List;

public class P_45_MoveElementToEnd {


    // MEDIUM
    /********************************************************************************************************************

     You're given an array of integers and an integer. Write a function that moves
     all instances of that integer in the array to the end of the array and returns
     the array.

     The function should perform this in place (i.e., it should mutate the input
     array) and doesn't need to maintain the order of the other integers.

     Sample Input
     array = [2, 1, 2, 2, 2, 3, 4, 2]

     toMove = 2

     Sample Output: [1, 3, 4, 2, 2, 2, 2, 2]  the numbers 1, 3, and 4 could be ordered differently

     *******************************************************************************************************************/


    // O(n)T
    // O(1)S

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int left = 0;
        int right = array.size() - 1;


        while(left < right) { // --> O(n)T

            // keep your right at a place where it is eligible to swap
            while(left < right && array.get(right) == toMove) {
                right--;
            }

            if(array.get(left) == toMove) {
                swap(array, left, right);
            }

            // do this in either case if left is pointing to toMove or even not
            left++;
        }

        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    //

    public static void main(String[] args) {
        List<Integer> result = moveElementToEnd(Arrays.asList(2,211,32, 9100,2, 1, 2, 2, 2, 3, 4, 2), 2);
        // [2,2,2,2,2,2,2,2]
        for(int i : result) {
            System.out.print(i + ",");
        }
    }



}
