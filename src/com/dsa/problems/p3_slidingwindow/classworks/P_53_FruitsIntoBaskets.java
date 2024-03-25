package com.dsa.problems.p3_slidingwindow.classworks;

import java.util.HashMap;
import java.util.Map;

public class P_53_FruitsIntoBaskets {

    // MEDIUM
    /********************************************************************************************************************

     You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets,
     and your goal is to pick as many fruits as possible to be placed in the given baskets.

     You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:

     > Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
     > You can start with any tree, but you can’t skip a tree once you have started.
     > You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

     Write a function to return the maximum number of fruits in both baskets.



     Example 1:
     Input: Fruit=['A', 'B', 'C', 'A', 'C']
     Output: 3
     Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']


     Example 2:
     Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
     Output: 5
     Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
     This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']


     This is exactly similar to the problem:
     Longest Substring with at most 2 distinct characters

     *******************************************************************************************************************/





    public static int findLength(char[] arr) {
        int maxFruits = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> fruitsFreq = new HashMap<>(); // --> O(K)S

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) { // --> O(n)T

            char c = arr[windowEnd];
            fruitsFreq.merge(c, 1, Integer::sum);

            // shrink
            while(fruitsFreq.size() > 2) {
                char leftFruit = arr[windowStart++];
                int leftFruitFreq = fruitsFreq.get(leftFruit);
                if (leftFruitFreq == 1) {
                    fruitsFreq.remove(leftFruit);
                } else {
                    fruitsFreq.put(leftFruit, fruitsFreq.get(leftFruit) - 1);
                }
            }

            // CT
            int windLen = windowEnd - windowStart + 1;
            maxFruits = Math.max(maxFruits, windLen);
        }

        return maxFruits;
    }




    public static void main(String[] args) {
        //System.out.println("Maximum number of fruits: " +
                           //findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                           findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

}
