package com.dsa.problems.p1_arraysandhashing.homeworks;

public class P_14_PickFromBothTheSides {

    // EASY
    /********************************************************************************************************************

     Given an integer array A of size N.

     You can pick B elements from either left or right end of the array A to get maximum sum.

     Find and return this maximum possible sum.

     NOTE: Suppose B = 4 and array A contains 10 elements then

     You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc .
     you need to return the maximum possible sum of elements you can pick.

     Input Format
     First argument is an integer array A.
     Second argument is an integer B.

     Output Format
     Return an integer denoting the maximum possible sum of elements you picked.

     Example Input
     Input 1:
     A = [5, -2, 3 , 1, 2]
     B = 3
     Input 2:
     A = [1, 2]
     B = 1

     Example Output
     Output 1:
     8
     Output 2:
     2

     Example Explanation
     Explanation 1:
     Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
     Explanation 2:
     Pick element 2 from end as this is the maximum we can get

     *******************************************************************************************************************/

    // O(B)T where B is the total no of elements you can use for summing
    // O(1)S

    public int solve(int[] A, int B) {
        int n = A.length;
        int result = 0;

        // initially calculate the result by considering the first B elements of the array A
        // Loop for B counts
        // Note: You have to do this in a separate for loop - only then you can one by one remove elements(from left) and add(from right) in the next for loop
        for (int i = 0; i < B; i++) { // --> O(B)T
            result += A[i];
        }

        // take backup as sum - which will keep changing from now
        // result will be used for CT
        int sum = result;

        // Loop for B counts
        for (int i = 0; i < B; i++) { // --> O(B)T
            sum -= A[(B - 1) - i]; // Subtract the element added from the front(starts from right corner)
            sum += A[(n - 1) - i]; // Add the element from the back(starts from right corner)

            // CT
            result = Math.max(result, sum);
        }

        return result;
    }

}
