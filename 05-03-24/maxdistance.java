/*You are participating in a game, you will be given an integer number n which 
represents n number of chests, your task is to find the longest distance between 
any two adjacent treasure chests with gold. The treasure chests are represented 
in binary format, where '1' denotes the presence of a chest with gold and '0' 
represents an empty chest. If there are no two adjacent treasure chests, 
return 0 as the longest distance.

(That means if n is 6 then it will represented as 0 0 0 1 1 0 here  
6 is converted to binary and bits which are having 1 represent a chest with gold 
and 0 represent and empty chest.)



Two 1's are adjacent if there are only 0's separating them (possibly no 0's). 
The distance between two 1's is the absolute difference between their bit positions.
For example, the two 1's in "1001" have a distance of 3.

input : an integer
output: an integer

Example 1:
Input:22
Output: 2
Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" is not a valid pair since there is a 1 separating the two 1's 
underlined.

Example 2:
Input:8
Output: 0
Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, 
so we return 0.

Example 3:
Input: 5
Output: 2
Explanation: 5 in binary is "101".
 
Constraints:
1 <= n <= 10^9 */

import java.util.*;
public class maxdistance{
    static int fun(int n){
        int m=0;
        int oc=0;
        int c=0;
        while(n!=0){
            if((n&1)==0){
                if(oc==1){
                    c++;
                }
                else if(oc>1){
                    c=1;
                    oc=1;
                }
                else{
                    c=0;
                    oc=0;
                }
            }
            else if((n&1)==1){
                if(oc<=2){
                    c++;
                    oc++;
                    m=Math.max(m,c);
                }
                else{
                    oc=1;
                    c=1;
                }
            }
            n=n>>1;
        }
        return m-1;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fun(n));
    }
}