/*
Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.

For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }. The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.

Note:
     1. if more than one index is possible print the smallest index value
     2. if no replacement is possible then print -1

Example:
input=10
0 0 1 0 1 1 1 0 1 1
output=7

Example 2:
input=12
1 1 1 1 1 1 1 1 1 1 1 0
output=11

Example 3:
input=12
0 0 0 0 0 0 0 0 0 0 0 0
output=0

Example 4:
input=10
1 1 1 1 1 1 1 1 1 1
output=-1


*/
import java.util.*;
class Main
{
	// Find the index of 0 to replace with 1 to get the maximum sequence
	// of continuous 1's using the sliding window technique
	public static int findIndexofZero(int[] A)
	{
		int left = 0;   	// represents the window's starting index
		int count = 0;  	// stores the total number of zeros in the current window
		int max_count = 0;  // stores the maximum number of 1's (including 0)

		int max_index = -1; 		// stores the index of 0 to be replaced
		int prev_zero_index = -1;   // stores the index of previous zero

		// maintain a window `[left…i]` containing at most one zero
		for (int i = 0; i < A.length; i++)
		{
			// if the current element is 0, update `prev_zero_index` and
			// increase zeros count in the current window by 1
			if (A[i] == 0)
			{
				prev_zero_index = i;
				count++;
			}

			// the window becomes unstable if the total number of zeros in it becomes 2
			if (count == 2)
			{
				// remove elements from the window's left side till
				// we found a zero
				while (A[left] != 0) {
					left++;
				}

				// remove the leftmost 0 so that window becomes stable again
				left++;

				// decrement count as 0 is removed
				count = 1;
			}

			// when we reach here, window `[left…i]` contains only
			// at most one zero; update the maximum count and index of 0
			// to be replaced if required

			if (i - left + 1 > max_count)
			{
				max_count = i - left + 1;
				max_index = prev_zero_index;
			}
		}

		// return index of 0 to be replaced or -1 if the array contains all 1's
		return max_index;
	}

	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] A=new int[n];
		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();

		//[] A = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };

		int index = findIndexofZero(A);

		if (index != -1) {
			System.out.print("Index to be replaced is " + index);
		}
		else {
			System.out.print("-1");
		}
	}
}
/*
test cases
case =1
input=10
1 1 1 1 1 1 1 1 1 1
output=-1
case=2
input=12
0 0 0 0 0 0 0 0 0 0 0 0
output=0
case=3
input=12
1 1 1 1 1 1 1 1 1 1 1 0
output=11
case=4
input=10
0 0 1 0 1 1 1 0 1 1
output=7
case=5
input=10
1 0 0 1 1 0 0 1 0 1
output=2
case=6
input=10
0 1 0 1 0 1 0 1 0 1
output=2


*/