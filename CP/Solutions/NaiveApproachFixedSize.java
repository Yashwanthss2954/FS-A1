// Java code O(n*k) solution for finding maximum sum of
// a subarray of size k
/*

input format : number of elements (n)
               n number of integers
			   size of the ranges  (k (i.e size of subarray))
output format : integer sum

Example 1:
input = 9
1 2 3 4 5 6 7 8 9
2
output=17

Example 2:
input=9
9 1 2 8 7 4 5 6 3
2
output=15




*/
import java.util.*;
class NaiveApproach {
    // Returns maximum sum in
    // a subarray of size k.
    static int maxSum(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = Integer.MIN_VALUE;
        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + arr[i + j];
            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }
         return max_sum;
    }
    // Driver code
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n]; 
        for(int i=0;i<n;i++)
         arr[i]=sc.nextInt();   
        int k = sc.nextInt();       
        System.out.println(maxSum(arr, n, k));
    }
}

/*
Test cases
==========
cas=1
input=4
2 3 4 5
2
output=9

case=2
input=9
1 4 2 10 2 3 1 0 20
4
output=24
*/