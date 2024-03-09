package com.dsa.problems.p1_arraysandhashing.classworks;

import java.util.HashSet;
import java.util.Set;

public class P_08_ValidSudoku {

    // MEDIUM
    // LEETCODE 36
    /********************************************************************************************************************

     Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

     Each row must contain the digits 1-9 without repetition.
     Each column must contain the digits 1-9 without repetition.
     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     Note:

     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     Only the filled cells need to be validated according to the mentioned rules.

     Example 1:
     Input: board =
     [["5","3",".",".","7",".",".",".","."]
     ,["6",".",".","1","9","5",".",".","."]
     ,[".","9","8",".",".",".",".","6","."]
     ,["8",".",".",".","6",".",".",".","3"]
     ,["4",".",".","8",".","3",".",".","1"]
     ,["7",".",".",".","2",".",".",".","6"]
     ,[".","6",".",".",".",".","2","8","."]
     ,[".",".",".","4","1","9",".",".","5"]
     ,[".",".",".",".","8",".",".","7","9"]]
     Output: true


     Example 2:
     Input: board =
     [["8","3",".",".","7",".",".",".","."]
     ,["6",".",".","1","9","5",".",".","."]
     ,[".","9","8",".",".",".",".","6","."]
     ,["8",".",".",".","6",".",".",".","3"]
     ,["4",".",".","8",".","3",".",".","1"]
     ,["7",".",".",".","2",".",".",".","6"]
     ,[".","6",".",".",".",".","2","8","."]
     ,[".",".",".","4","1","9",".",".","5"]
     ,[".",".",".",".","8",".",".","7","9"]]
     Output: false
     Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

     *******************************************************************************************************************/

    // O(1)T
    // O(1)T

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                String rowKey = "row:" + row + "->" + c;
                String colKey = "col:" + col + "->" + c;
                String gridKey = "grid:" + (row/3) + ":" + (col/3) + "->" + c;

                //System.out.println("row: "+row);
                //System.out.println("col: "+col);
                System.out.println(rowKey+", "+colKey+", "+gridKey);



                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(gridKey)) {
                    System.out.println("FAILED");
                    return false;
                } else {
                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(gridKey);
                }
            }
        }

        return true; // DR
    }


    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'8','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};

        System.out.println(isValidSudoku(board));



    }

}
