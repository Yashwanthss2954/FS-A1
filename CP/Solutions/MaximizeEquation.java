/*

Given an array A, maximize value of expression (A[s] - A[r] + A[q] - A[p]), where p, q, r, and s are indices of the array and s > r > q > p.

input format : an integer n
               n number of integers
output format : an integer

Example:
Input=6
3 9 10 1 30 40
Output=46 
Explanation: The expression (40 – 1 + 10 – 3) will result in the maximum value

Example 2:
input=8
1 2 3 4 5 6 7 8
output=6
*/
import java.util.*;
class Main
{
	// Function to find the maximum value of the expression
	// (A[l] - A[k] + A[j] - A[i]), where l > k > j > i
	public static int maximizeExpression(int[] A)
	{
		// input should have at least 4 elements
		if (A.length < 4) {
			System.exit(-1);
		}
		// create 4 lookup tables and initialize them to `Integer.MIN_VALUE`
		int[] first = new int[A.length + 1];
		Arrays.fill(first, Integer.MIN_VALUE);
		int[] second = new int[A.length];
		Arrays.fill(second, Integer.MIN_VALUE);
		int[] third = new int[A.length - 1];
		Arrays.fill(third, Integer.MIN_VALUE);
		int[] fourth = new int[A.length - 2];
		Arrays.fill(fourth, Integer.MIN_VALUE);
		// `first[]` stores the maximum value of `A[l]`
		for (int i = A.length - 1; i >= 0; i--) {
			first[i] = Integer.max(first[i + 1], A[i]);
		}
		System.out.println(Arrays.toString(first));
		// `second[]` stores the maximum value of `A[l] - A[k]`
		for (int i = A.length - 2; i >= 0; i--) {
			second[i] = Integer.max(second[i + 1], first[i + 1] - A[i]);
		}
		System.out.println(Arrays.toString(second));

		// `third[]` stores the maximum value of `A[l] - A[k] + A[j]`
		for (int i = A.length - 3; i >= 0; i--) {
			third[i] = Integer.max(third[i + 1], second[i + 1] + A[i]);
		}
		System.out.println(Arrays.toString(third));

		// `fourth[]` stores the maximum value of `A[l] - A[k] + A[j] - A[i]`
		for (int i = A.length - 4; i >= 0; i--) {
			fourth[i] = Integer.max(fourth[i + 1], third[i + 1] - A[i]);
		}
		System.out.println(Arrays.toString(fourth));

		// maximum value would be present at `fourth[0]`
		return fourth[0];
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for (int i=0;i<n ;i++ )
			ar[i]= sc.nextInt();
		System.out.println(maximizeExpression(ar));
	}
}
/*
case =1
input = 8
1 2 3 4 5 6 7 8
output=6
case =2
input=8
-5 10 20 -20 30 40 -50 20
output =130
case =3
input=6
5 10 15 12 13 20
output=18
case=4
input=8
1 8 2 7 3 6 4 5
output=12
*/