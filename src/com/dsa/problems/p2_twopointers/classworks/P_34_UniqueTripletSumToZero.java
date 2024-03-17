package com.dsa.problems.p2_twopointers.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_34_UniqueTripletSumToZero {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

     Example 1:
     Input: [-3, 0, 1, 2, -1, 1, -2]
     Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
     Explanation: There are four unique triplets whose sum is equal to zero.


     Example 2:
     Input: [-5, 2, -1, -2, 3]
     Output: [[-5, 2, 3], [-2, -1, 3]]
     Explanation: There are two unique triplets whose sum is equal to zero.

     Example 3:
     Input: [-1,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
     Output: [-1,0,1] [0,0,0]


     *******************************************************************************************************************/


    // O(n^2)T
    // O(n)S for result

    public static List<List<Integer>> searchUniqueTriplets(int[] arr) {

        Arrays.sort(arr); // don't forget

        List<List<Integer>> result = new ArrayList<>(); // --> O(n)S

        for (int i = 0; i < arr.length-2; i++) { // --> O(n^2)T
            int firstNum = arr[i]; //1, 2

            // this will avoid considering the same number as firstNum again
            if (i > 0 && firstNum == arr[i-1]) { // look back
                continue;
            }

            int left = i+1;
            int right = arr.length-1;

            while(left < right) { // --> O(n)T

                // this will avoid considering the same number as left again
                if(left > i+1 && arr[left] == arr[left-1]) { // turn back
                    left++;
                    continue;
                }

                // this will avoid considering the same number as right again
                if(right < arr.length - 1 && arr[right] == arr[right+1]) { // turn back
                    right--;
                    continue;
                }

                int sum = firstNum + arr[left] + arr[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(firstNum, arr[left], arr[right]));
                    left++;
                    right--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int a[] = {-1,0,0,0,0,0,0,1,1,1,1,1,1,1,1};


        // Function call
        List<List<Integer>> results = searchUniqueTriplets(a);

        for(List<Integer> triplet : results) {
            System.out.println("****");
            for(int t : triplet) {
                System.out.print(t + "->");
            }
            System.out.println("****");
        }
    }

}
