/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output:
--------------
75
86
80
Example 1:
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 2 7
Example 2:
input=16 1
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
1 0 15
output=136


Use this Java code segement to solve above problem.
import java.util.*;
class FenWickTree 
{
	int[] nums;
	int[] BIT;
	int n;

	// Function to construct fenwick tree from given array
	public FenWickTree(int[] nums) 
	{
		this.nums = nums;

		n = nums.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++)
		{
			init(i, nums[i]);
		}
	}


	public void init(int i, int val) 
	{
		i++;
		while (i <= n) 
		{
			BIT[i] += val;
			i += (i & -i);
		}
	}

	void update(int i, int val) 
	{
	    //WRITE YOUR CODE HERE
	}

	public int getSum(int i) 
	{
	    //WRITE YOUR CODE HERE
	}

	public int sumRange(int i, int j) 
	{
		return getSum(j) - getSum(i - 1);
	}
	
	public static void main(String args[] ) 
	{
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int q=scan.nextInt();      
		int[] nums=new int[n];
		for(int i=0; i<n; i++)
		{
			 nums[i] = scan.nextInt();
		}
		FenWickTree ft =new FenWickTree(nums);
		
		while(q-->0)
		{
			int opt=scan.nextInt();
			if(opt==1)
			{
				int s1 = scan.nextInt();
				int s2 = scan.nextInt();
				System.out.println(ft.sumRange(s1,s2));
			}
			else
			{
				int ind = scan.nextInt();
				int val= scan.nextInt();
				ft.update(ind,val);
			}
		}
	}
}

 */


 