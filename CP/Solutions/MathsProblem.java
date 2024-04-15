/*
Mr. Uday, a mathematics teacher, has assigned a task to his students. 
The challenge is to determine the shortest length of a contiguous subset 
within an array of positive integers. This subset must have a sum exceeding 
a specified value, denoted as "k". Students should find length of the subset,
if no such subset exists, the program should output 0.
With your programming skills write a program to solve this.

input format: an integer n
             n number of integers
			 an integer (k)
output format: an integer( length of subset)

For example,
Example 1:
Input=8
1 2 3 4 5 6 7 8
20
Output=3
Explanation: The smallest subarray with sum > 20 is {6, 7, 8}  

Example 2:
Input=8
1 2 3 4 5 6 7 8
7
Output= 1
Explanation: The smallest subarray with sum > 7 is {8}

Example 3:
Input=8
1 2 3 4 5 6 7 8
21
Output= 4
Explanation: The smallest subarray with sum > 21 is {4, 5, 6, 7}

Example 4:
Input=8
1 2 3 4 5 6 7 8
40
Output=0
*/
import java.util.*;
class Main
{
	public static int findSmallestSubarrayLen(int[] A, int k)
	{
		int windowSum = 0;
		int len = Integer.MAX_VALUE;
		int left = 0;
		for (int right = 0; right < A.length; right++)
		{
			windowSum += A[right];
			System.out.println("windowSum " + windowSum + " right " + right);
			while (windowSum > k && left <= right)
			{
				len = Integer.min(len, right - left + 1);
				windowSum -= A[left];
				left++;

				System.out.println("len " + len + " windowSum " + windowSum + " left " + left + " right " + right);
			}
		}
		if (len == Integer.MAX_VALUE) 
			return 0;
		return len;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i=0;i<n ;i++ )
		{
			A[i]=sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println( new Main().findSmallestSubarrayLen(A, k));
		
			
	}
}
/*
case =1 
input =8
1 8 2 7 3 6 4 5
15
output=3

case =2
input=12
20 2 1 30 4 5 40 50 60 5  6 7
175
output=6

case =3
input=15
1 15 2 14 3 13 4 12 5 11 6 10 7 9 8
45
output=5

case =4
input=8
1 2 3 4 5 6 7 8
21
output=4
case =5
input=8
1 2 3 4 5 6 7 8
40
output=0
*/