/*
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
You are given an integer array customers of length n where customers[i] is the number of the customer
that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1
if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, 
otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, 
but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

 

Example 1:

Input:8
1 0 1 2 1 1 7 5
0 1 0 1 0 1 0 1
3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input:1
1
0
1
Output: 1
 

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.
*/
import java.util.*;
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int satisfied = 0;
		//total satisfied customers
		for(int i = 0; i < customers.length; i++){
			if(grumpy[i] == 0) satisfied += customers[i];
		}

		System.out.println("satisfied " + satisfied);

		int left = 0, bonus =0;
		//first window of unsatisfied customers turned into satisfied
		for(int i = 0; i< minutes ; i++){
			if(grumpy[i] == 1) 
				bonus+= customers[i]; 
		}

		System.out.println("bonus " + bonus);

		int curBonus = bonus;
		//get the maximum new satisfactions in "minutes" length window 
		for(int right = minutes; right < customers.length; right++)
		{
			System.out.println("left " + left + " right " + right);
			if(grumpy[left] == 1) 
				curBonus -= customers[left];
			left++;
			if(grumpy[right] == 1) 
				curBonus+= customers[right];
			System.out.println("bonus " + bonus + " curBonus " + curBonus);

			bonus = Math.max(bonus,curBonus); 
		}
		return satisfied+bonus;
    }
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		int[] c=new int[n];
		int[] g=new int[n];
		for(int i=0;i<n;i++)
			c[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			g[i]=sc.nextInt();
		int m=sc.nextInt();
		System.out.println(new Solution().maxSatisfied(c,g,m));
	}
}
/*
test cases
case =1
input=6
3 1 4 6 8 2
0 0 1 1 0 1
4
output=24
case=2
input=5
1 2 3 4 5
0 0 0 0 0
2
output=15
case =3
input=8
1 0 1 2 1 1 7 5
0 1 0 1 0 1 0 1
3
Output=16
case =4
input=7
2 3 1 5 6 3 8
0 1 0 1 0 1 0
2
output=22
*/