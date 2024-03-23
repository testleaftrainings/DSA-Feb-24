package com.dsa.problems.p2_twopointers.classworks;

import java.util.Arrays;

public class P_48_FlipImage {

    // EASY
    /********************************************************************************************************************

     Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

     To flip an image horizontally means that each row of the image is reversed.

     For example, flipping [1,1,0] horizontally results in [0,1,1].
     To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

     For example, inverting [0,1,1] results in [1,0,0].


     Example 1:

     Input: image = [[1,1,0],
                     [1,0,1],
                     [0,0,0]]
     Output: [[1,0,0],
              [0,1,0],
              [1,1,1]]
     Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]


     Example 2:

     Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]


     Constraints:

     n == image.length
     n == image[i].length
     1 <= n <= 20
     images[i][j] is either 0 or 1.

     *******************************************************************************************************************/

    // O(n^2)T
    // O(1)S

    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) { //O(n^2)T  O(1)S
            int[] row = image[i];

            //flip horizontally
            int left = 0;
            int right = row.length - 1;
            System.out.println( "Input Row --> " +Arrays.toString(row));

            while (left < right) {
                int tmp = row[left];
                row[left]=row[right];
                row[right]=tmp;
                left++;
                right--;
            }
            System.out.println( "Flipped Row --> " + Arrays.toString(row));

            //invert the flipped elements
            for (int j = 0; j < row.length; j++) {
                row[j] = row[j] == 0 ? 1 : 0;
            }
            System.out.println( "Inverted Row --> " +Arrays.toString(row));

        }

        return image;
    }

}
