/*
You are participating in a game, you will be given an integer number n which represents n number of chests, 
your task is to find the longest distance between any two adjacent treasure chests with gold. 
The treasure chests are represented in binary format, where '1' denotes the presence of a chest 
with gold and '0' represents an empty chest. If there are no two adjacent treasure chests, 
return 0 as the longest distance.

(That means if n is 6 then it will represented as 0 0 0 1 1 0 here  6 is converted to binary 
and bits which are having 1 represent a chest with gold and 0 represent an empty chest.)

Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.

input : an integer
output: an integer

Example 1:

Input:22
Output: 2
Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.

Note that pair of 1's at position '0' and position '3' of "10110" is not a valid pair since there is a 1 separating the two 1's.

Example 2:
Input:8
Output: 0

Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.

Example 3:
Input: 5
Output: 2

Explanation: 5 in binary is "101".
Constraints:

1 <= n <= 10^9
*/
import java.util.*;
class Solution 
{
    public int binaryGap(int n) 
	{
        int max = 0;
        int dist = 0;
        while(n>0)
		{
            if((n&1) == 1)
			{
                max=Math.max(dist, max);
                dist=1;
            }
            else
			{
                if(dist > 0)
					dist++;
            }
            n>>=1;
        }
        return max;
    }

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(new Solution().binaryGap(n));
	}
}
/*
test cases
case =1
input=1025
output=10
case=2
input=1024
output=0
case=3
input=2049
output=11
case=4
input=1048577
output=20
case =5
input=43690
output=2
case =6
input=32763
output=2
*/