package com.dsa.problems.p2_twopointers.classworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_33_ThreeSum {

    // MEDIUM
    /********************************************************************************************************************

     Given an array of unsorted numbers, find all triplets in it that add up to target.

     Example 1:

     Input: [-3, 0, 1, 2, -1, -2, 0] target 0
     Output: [-3, 1, 2], [-2, 0, 2], [-1, 0, 1], [2, -2, 0], [1, -1, 0]
     Explanation: There are five triplets whose sum is equal to zero.



     First go ahead and solve the below problem on you own to understant this problem.
     Given an array of unsorted numbers, find all pais in it that add up to target.

     Example 1:

     Input: [-1, 0, 3, 0] target = 3
     Output: [0, 3] [0, 3]
     Explanation: There are two pairs whose sum is equal to 3.


     *******************************************************************************************************************/


    // O(n^2)T
    // O(n)S for result
    public static List<List<Integer>> searchTriplets(int[] arr, int targetSum) {
        // sort the array
        Arrays.sort(arr); // --> O(n log n)T
        // initialize the result
        List<List<Integer>> result = new ArrayList<>(); // --> O(n)S
        // loop through the array
        for (int i = 0; i < arr.length - 2; i++) { // --> O(n^2)T
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("******* LEVEL 1");

            // keep the firstnum constant & in the remaining array look for the balance with a two pointer
            int firstNum = arr[i];
            System.out.println("First pointer: "+i);
            System.out.println("First number: "+firstNum);
            int lookFor = targetSum - firstNum;

            // two sum from now on..
            int left = i+1;
            int right = arr.length - 1;

            System.out.println("left pointer: " + left);
            System.out.println("right pointer: " + right);

            while(left < right) { // --> O(n)T
                System.out.println("******* LEVEL 2");

                int sum =  arr[left] + arr[right];
                System.out.println("left number: " + arr[left]);
                System.out.println("right number: " + arr[right]);
                System.out.println("sum: " + sum);

                if(sum < lookFor) {
                    left++;
                } else if (sum > lookFor) {
                    right--;
                } else {
                    result.add(Arrays.asList(firstNum, arr[left], arr[right]));
                    System.out.println("found result : " + firstNum + "," + arr[left] + "," + arr[right]);

                    //  0  1    1  2
                    // if you want to look for forming 1 with two numbers
                    // you should ideally for two pairs 0, 1 & 0, 1 because you have two 0s

                    // these below steps are not to avoid the duplicate pairs
                    if (arr[left] == arr[left+1]) {
                        left++;
                        continue;
                    }

                    if (arr[right] == arr[right-1]) {
                        right--;
                        continue;
                    }

                    left++;
                    right--;
                }
            }
        }

        // return
        return result;
    }

    public static void main(String[] args) {
        int a[] = { -3, 0, 1, 2, -1, -2, 0};

        // -3 -2  -1 0  0    1  2



        // [-3, 1, 2], [-2, 0, 2], [-1, 0, 1], [2, -2, 0], [1, -1, 0]


        // Function call
        List<List<Integer>> results = searchTriplets(a, 0);

        for(List<Integer> triplet : results) {
            System.out.println("****");
            for(int t : triplet) {
                System.out.print(t + "->");
            }
            System.out.println("****");
        }
    }

}
