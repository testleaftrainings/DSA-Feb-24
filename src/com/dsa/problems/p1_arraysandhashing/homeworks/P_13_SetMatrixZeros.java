package com.dsa.problems.p1_arraysandhashing.homeworks;

public class P_13_SetMatrixZeros {

    // MEDIUM
    // Leet code : 73
    /********************************************************************************************************************

     Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.

     You must do it in place.


     Input: matrix = [
         [1,1,1],
         [1,0,1],
         [1,1,1]
     ]

     Output: [
         [1,0,1],
         [0,0,0],
         [1,0,1]
     ]


     Input: matrix = [
         [0,1,2,0],
         [3,4,5,2],
         [1,3,1,5]
     ]

     Output: [
         [0,0,0,0],
         [0,4,5,0],
         [0,3,1,0]
     ]

     *********************************************************************************************************************/


    // O(n)T
    // O(1)S

    public void setZeroes(int[][] matrix) {
        // edge case - always handle negative edge cases first
        // ER
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        // Two extra special indicators for first row & first column
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // SPECIAL INDICATION: FIRST ROW INDICATION
        for (int i = 0; i < colCount; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break; // early break
            }
        }

        // SPECIAL INDICATION: FIRST COLUMN INDICATION
        for (int i = 0; i < rowCount; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break; // early break
            }
        }

        // INDICATION - except first row & first column
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }


        // SET OTHERS 0
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        // SET FIRST ROW 0
        if (firstRowZero) {
            for (int i = 0; i < colCount; i++) {
                matrix[0][i] = 0;
            }
        }

        // SET FIRST COLUMN 0
        if (firstColZero) {
            for (int i = 0; i < rowCount; i++) {
                matrix[i][0] = 0;
            }
        }

        // Dont need to return anything as array is an object
    }

}
