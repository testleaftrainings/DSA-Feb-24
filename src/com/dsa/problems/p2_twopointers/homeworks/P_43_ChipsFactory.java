package com.dsa.problems.p2_twopointers.homeworks;

public class P_43_ChipsFactory {

    // EASY
    /********************************************************************************************************************

     A chips factory is packing chips in packets.
     The packets of chips are represented as an array A.
     Find the packet of chips which are empty (Ai = 0) and move them to the end of the array.
     Return the resultant array.

     Input Format
     Given an integer array A.


     Output Format
     Return an integer array.

     Example Input
     Input 1:
     A = [0, 1, 2, 3]
     Input 2:
     A = [1, 0, 0, 0]

     Example Output
     Output 1:
     [1, 2, 3, 0]
     Output 2:
     [1, 0, 0, 0]

     *******************************************************************************************************************/

    // O(n)T
    // O(1)S
    public int[] solve(int[] A) {
        int write = 0;
        int read = 0;

        while(read < A.length) { // --. O(n)T

            if(A[read] != 0) {
                swap(A, read, write);
                write++;
            }

            read++;
        }

        return A;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


}
