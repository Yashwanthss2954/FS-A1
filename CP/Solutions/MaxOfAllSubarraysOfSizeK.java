/*
Mr.Ram is a sales manager of Dmart, for his analysis he has to monitor 
sales of Dmart every day. He need to send report of maximum sales 
of every K consecutive days from given N number of days sales.
Write a java program to do his task easy.

Input Format:
-------------
Line-1: Two space separated integers, N and K
Line-2: N space separated integers, sales[].

Output Format:
--------------
Print maximum sales of every K consecutive days


Sample Input 1:
---------------
9 3
1 2 3 1 4 5 2 3 6

Sample output 1:
----------------
3 3 4 5 5 5 6

Explanation: 
Maximum of subarray {1, 2, 3} is 3
Maximum of subarray {2, 3, 1} is 3
Maximum of subarray {3, 1, 4} is 4
Maximum of subarray {1, 4, 5} is 5
Maximum of subarray {4, 5, 2} is 5
Maximum of subarray {5, 2, 3} is 5
Maximum of subarray {2, 3, 6} is 6
*/

import java.util.*;
public class MaxOfAllSubarraysOfSizeK 
{
    private static int[] maxofAllSubarray(int[] a, int k) {
        int n = a.length;
        int[] maxOfSubarrays = new int[n-k+1];
        ArrayList<Integer> q = new ArrayList<>();
        int idx=0;
        for(int i = 0; i < k-1; i++)
            q.add(a[i]);

        for(int windowEnd = k-1; windowEnd < n; windowEnd++)
        {
            q.add(a[windowEnd]);
            maxOfSubarrays[idx++] = Collections.max(q);
            q.remove(0);
        }
        return maxOfSubarrays;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) 
            a[i] = sc.nextInt();

        int[] result = maxofAllSubarray(a, k);
        for(int i = 0; i < result.length; i++) 
        {
            System.out.print(result[i] + " ");
        }    
        System.out.println();
    }
}


/*
Test cases
case=1
input=9 3
1 2 3 1 4 5 2 3 6
output=
3 3 4 5 5 5 6

case=2
input=8 3
1 3 -1 -3 5 3 6 7
Output=
3 3 5 5 6 7

case=3
input=10 4                                                                                      
7 3 1 5 3 6 8 2 3 6                                                                       
output=
7 5 6 8 8 8 8

case=4
input=15 4                                                                                      
6 3 1 8 9 3 4 0 2 5 7 4 6 9 8                                                             
output=
8 9 9 9 9 4 5 7 7 7 9 9                                                                   


*/