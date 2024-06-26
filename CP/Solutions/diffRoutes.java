/*
A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3


*/
import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

	public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
		int[][] grid=new int[m][n];
		for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
			grid[i][j]=sc.nextInt();
		System.out.println(new Solution().uniquePathsWithObstacles(grid));
    }

}
/*


==== testcases ====
case =1
input =5 8
0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0
0 1 0 0 0 1 0 0
0 0 1 0 0 0 0 0
0 0 0 0 1 0 0 0
output =34

case =2
input =6 8
0 0 0 0 0 0 0 0
0 1 0 0 0 1 0 0
0 0 0 1 0 0 0 0
0 0 0 0 0 1 0 0
0 1 0 0 0 0 0 0
0 0 0 0 1 0 0 0
output =63

case =3
input =7 10
0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 1
0 1 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 1 0
0 0 0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
output =889

case =4
input =7 10
0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 1
0 1 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 1 0
0 0 0 1 0 0 0 1 0 0
0 1 0 0 0 0 0 0 0 0
output =286

case =5
input =9 11
0 0 0 0 0 0 0 0 0 1 0
0 0 0 0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0
0 1 0 0 0 0 1 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 1 0 0 0 1
0 1 0 0 0 0 0 0 0 0 0
0 0 0 0 0 1 0 0 0 0 0
output =5664

case =6
input =10 10
0 0 0 0 1 0 0 0 0 0
1 0 0 0 0 0 0 1 0 0
0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0 1
0 0 0 0 1 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 1
0 1 0 0 1 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0
output =2163

case =7
input =10 15
0 0 0 0 0 0 0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 0 1 0 0 1
0 0 0 0 0 0 1 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 0 1 0 0
0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 1 0 0 0 0
output =42934

case =8
input =10 15
0 0 0 0 0 0 0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 0 0 0 1 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1 0 0 1 0 0 1
0 0 0 0 0 0 1 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0 1 0 0 1 0 0
0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 1 0 0 0 0
output =11832
*/