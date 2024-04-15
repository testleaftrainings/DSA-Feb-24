package com.dsa.problems.p3_slidingwindow.homeworks;

public class P_67_BestTimeToBuyAndSellStock {

    // EASY
    /********************************************************************************************************************

     You are given an array prices where prices[i] is the price of a given stock on the ith day.
     You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

     Example 1:
     Input: prices = [7,1,5,3,6,4]
     Output: 5
     Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


     Example 2:
     Input: prices = [7,6,4,3,1]
     Output: 0
     Explanation: In this case, no transactions are done and the max profit = 0.


     *******************************************************************************************************************/



    // O(n)T
    // O(1)S

    public int maxProfit(int[] prices) {
        // ER
        if (prices.length == 0) {
            return 0 ;
        }

        int windowStart = 0; // CT
        int maxProfit = Integer.MIN_VALUE; // CT

        for (int windowEnd = 0; windowEnd < prices.length; windowEnd++) { // --> O(n)T

            if (prices[windowEnd] < prices[windowStart]) { // looking for a better buying point
                windowStart = windowEnd;
            } else { // Calculate profit & CT
                int profit = prices[windowEnd] - prices[windowStart];
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }

}
