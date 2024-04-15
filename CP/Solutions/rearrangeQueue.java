/*
//https://leetcode.com/problems/queue-reconstruction-by-height/description/
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

 input format : an integer n
                n number of pairs
output format : list of n pairs

Example 1:

Input: 6
7 0
4 4
7 1
5 0
6 1
5 2
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

Example 2:
Input: 6
6 0 
5 0 
4 0
3 2
2 2
1 4
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 

Constraints:

1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
It is guaranteed that the queue can be reconstructed.
*/
/*
Approach:
1.	Sort the input by the height ascendingly to ensure the current person is		higher than or equal to the previous added people.
2.	To handle the data like [5, 0] and [5, 2], sort them by the second index		descendingly to ensure that we treat them as equal height.
3.	Use binary indexed tree to calculate the allocated seats within range [0...i]		and the remaining seats are reserved for the people who are higher than the		current person
4.	Based on the above, we can use binary search to find out the correct position		for the current person.
*/
import java.util.*;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = people.length;
        int[][] res = new int[n][2];
        int[] bit = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2, used = get(bit, mid + 1);
                if (mid + 1 - used <= people[i][1])
					lo = mid + 1;
                else 
					hi = mid;
            }
            res[lo] = people[i];
            add(bit, lo + 1);
			
        }
        return res;
    }
    private int get(int[] bit, int i) {
        int res = 0;
        for (; 0 < i; i -= i & -i) 
			res += bit[i];
        return res;
    }
    private void add(int[] bit, int i) {
        for (; i < bit.length; i += i & -i)
			bit[i]++;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[][] ar=new int[n][2];
		for(int i=0;i<n;i++)
			for(int j=0;j<2;j++)
				ar[i][j]=sc.nextInt();
		System.out.println(Arrays.deepToString(new Solution().reconstructQueue(ar)));
	}
	
}
/*
Test cases
case =1
input=6
6 0 
5 0 
4 0
3 2
2 2
1 4
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
case =2
input=6
7 0
4 4
7 1
5 0
6 1
5 2
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
case =3
input=5
7 0
4 4
7 1
5 0
6 1
output=[[5, 0], [7, 0], [6, 1], [7, 1], [4, 4]]
case =4
input=0
output=[]
case =5
input=1
1 0
output=[[1, 0]]
case =6
input=4
5 3
5 0
5 1
5 2
output=[[5, 0], [5, 1], [5, 2], [5, 3]]*/ 