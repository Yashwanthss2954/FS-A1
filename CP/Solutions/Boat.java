/*
You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, 
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: 2
1 2
3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input:4
3 2 2 1
3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input:4
3 5 3 4
5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104




*/
import java.util.*;
class Solution 
{
    public int numRescueBoats(int[] people, int limit) 
	{
        Arrays.sort(people); 
        int count = 0;
        int n = people.length;
        int i =0, j = n-1;
        while(i<=j)
        {
            if(people[j]+people[i]<=limit) 
			{
                i++;
			}
            j--;
            count++;
        }
        return count;
    }
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		int m=sc.nextInt();
		System.out.println(new Solution().numRescueBoats(ar,m));
	}
}
/*
case =1
input=7
1 1 1 1 1 1 1
1
output=7
case=2
input=5
5 4 3 2 1
6
output=3
case=3
input=4
5 1 1 1
6
output=2
case =4
input=4
4 3 3 3
5
output=4
*/