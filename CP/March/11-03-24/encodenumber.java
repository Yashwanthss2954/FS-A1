/*Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.

Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000

Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110 */

import java.util.*;
public class encodenumber{
    static String fun(int n){
        String s=Integer.toBinaryString(n+1);
        int l=s.length()-1;
        int c=1;
        for(int i=0;i<l;i++){
            c=c*2;
        }
        int res=(n+1)-c;
        String r=Integer.toBinaryString(res);
        return r;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fun(n));
    }
}