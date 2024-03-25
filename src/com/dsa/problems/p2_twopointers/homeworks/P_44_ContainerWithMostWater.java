package com.dsa.problems.p2_twopointers.homeworks;

public class P_44_ContainerWithMostWater {

    // MEDIUM :
    // Leet code 11
    /********************************************************************************************************************

     You are given an integer array height of length n.
     There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

     Find two lines that together with the x-axis form a container, such that the container contains the most water.

     Return the maximum amount of water a container can store.

     Notice that you may not slant the container.

     Example 1:
     Input: height = [1,8,6,2,5,4,8,3,7]
     Output: 49
     Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     In this case, the max area of water (blue section) the container can contain is 49.

     Example 2:
     Input: height = [1,1]
     Output: 1

     *********************************************************************************************************************/




    // O(n)T
    // O(1)S

    public int maxContainer(int[] height) {
        int left = 0;
        int right = height.length - 1;

        // CT
        int maxArea = Integer.MIN_VALUE;

        // Move pointers
        while(left < right) { // ---> O(n)T
            int length = Math.min(height[left], height[right]);
            int breadth = right-left;
            int area = length * breadth;

            // CT
            maxArea = Math.max(maxArea, area);

            // Move pointer of the shorter line in the HOPE of increasing the area
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


}
