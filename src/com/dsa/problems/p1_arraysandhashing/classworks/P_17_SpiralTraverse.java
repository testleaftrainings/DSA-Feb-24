package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.ArrayList;
import java.util.List;

public class P_17_SpiralTraverse {

    // MEDIUM
    // Leetcode 54
    /********************************************************************************************************************

     Write a function that takes in an n x m two-dimensional array (that can be
     square-shaped when n == m) and returns a one-dimensional array of all the
     array's elements in spiral order.

     Spiral order starts at the top left corner of the two-dimensional array, goes
     to the right, and proceeds in a spiral pattern all the way until every element
     has been visited.

     Sample Input
     array = [
     [1,   2,  3, 4],
     [12, 13, 14, 5],
     [11, 16, 15, 6],
     [10,  9,  8, 7],
     ]

     Sample Output
     [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

     *******************************************************************************************************************/


    // O(rxc)T
    // O(rxc)S

    public static List<Integer> spiralTraverse(int[][] array) {

        // [[1,   2,  3, 4]]

        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while(startRow <= endRow && startCol <= endCol) { // -->

            for (int i = startCol; i <= endCol; i++) {
                result.add(array[startRow][i]);
            }

            for (int i = startRow+1; i <= endRow; i++) {
                result.add(array[i][endCol]);
            }

            if (startRow != endRow) {
                for (int i = endCol-1; i >= startCol ; i--) {
                    result.add(array[endRow][i]);
                }
            }

            if (startCol != endCol) {
                for (int i = endRow-1; i >= startRow+1 ; i--) {
                    result.add(array[i][startCol]);
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return result;

    }





    public static void main(String[] args) {
        List<Integer> result = spiralTraverse(new int[][] {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7},
            });

        result.forEach(System.out::println);
    }



}
