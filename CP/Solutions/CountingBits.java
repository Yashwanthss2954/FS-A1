/*
Mr. Athreya is a beginner in computer programming.
He is given an integer D, a decimal value. 
Your task is to count the 1's in the BCD form of each integer N and store 
the count in an array of size D+1, where N is in the range of  0<= N <= D.
 
Example of BCD :
Given an integer I=10 , The BCD of I is '1010', and 1's count is 2.
 
NOTE: Can you solve it in O(D) time?
 
Input Format:
-------------
An integer D, the decimal value.
 
Output Format:
--------------
Print the array of D+1 integers.
 
 
Sample Input-1:
---------------
3
 
Sample Output-1:
----------------
0 1 1 2


Sample Input-2:
---------------
6
 
Sample Output-2:
----------------
0 1 1 2 1 2 2
*/

import java.util.*;

class Test2{

	 public int[] countBits(int num) {
	        int[] ans = new int[num + 1];
	        for (int x = 1; x <= num; ++x) {
	            ans[x] = ans[x & (x - 1)] + 1;
	        }
	        return ans;
	    }

	 
    public static void main(String[] args)
    {
   	 Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int[] ar;
      ar=new Test2().countBits(n);
      	for(int a : ar)
      		System.out.print(a+" ");          
      }
}
/*

=== testcases ===
case =1
input =3
output =0 1 1 2 
 
case =2
input =6
output =0  1  1  2  1  2  2 
 
case =3
input =15
output =0  1  1  2  1  2  2  3  1  2  2  3  2  3  3  4 
 
case =4
input =25
output =0  1  1  2  1  2  2  3  1  2  2  3  2  3  3  4  1  2  2  3  2  3  3  4  2  3 
 
case =5
input =35
output =0  1  1  2  1  2  2  3  1  2  2  3  2  3  3  4  1  2  2  3  2  3  3  4  2  3  3  4  3  4  4  5  1  2  2  3 

case =6
input =100
output =0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4 1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5 1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5 2 3 3 4 3 4 4 5 3 4 4 5 4 5 5 6 1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5 2 3 3 4 3 4 4 5 3 4 4 5 4 5 5 6 2 3 3 4 3 
 
case =7
input =22
output =0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4 1 2 2 3 2 3 3

case =8
input =12
output =0 1 1 2 1 2 2 3 1 2 2 3 2 
  
*/
             