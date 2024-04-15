// Java Program Illustrating Naive Approach to
// Find if There is a Pair in A[0..N-1] with Given Sum  
/*
This program is to find the existence of pair of integers whose sum is equal to the given sum value or not.


input format : an integer (n->length of array)
			   n number of integers
			   an Integer (k -> sum value)
output format :either 1 or 0

example 1:
input=5
1 2 3 4 5
7
output=1

example 2:
input=6
1 2 3 4 5 6
25
output=0



*/




import java.io.*;
import java.util.*; 
class naiveApproach {
     //  To find Pairs in A[0..N-1] with given sum
    private static int isPairSum(int A[], int N, int X)
    {
        // Nested for loops for iterations
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // As equal i and j means same element
                if (i == j)  
                    // continue keyword skips the execution
                    // for following condition
                    continue;
                // Condition check if pair exists
                if (A[i] + A[j] == X)
                    return 1;
                // By now the array is sorted
                if (A[i] + A[j] > X)  
				{
                    break;
				}
            }
        }
          // No pair found with given sum.
        return 0;
    }
    // Main driver method
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);        
		int n=sc.nextInt();
		int arr[]=new int[n]; 
		for(int i=0;i<n;i++)  // array 
			arr[i]=sc.nextInt();     
		int val = sc.nextInt(); // given sum
		System.out.println(isPairSum(arr, arr.length, val));
    }  
}

/*
test cases
case=1
input=5
1 2 3 4 5
20
output=0

case=2
input=7
2 3 5 8 9 10 11
17
output=1

case=3
input=9
9 18 27 36 45 54 63 72 81
99
output=1

case=4
input=10
6 4 2 7 8 1 3 5 12 13
50
output=0
*/