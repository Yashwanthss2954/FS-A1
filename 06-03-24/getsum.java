/*Given two integers a and b, return the sum of the two integers without using the operators +.
Example 1:
Input=1  2
Output=3 

Example 2:
Input=2 3
Output=5 */

import java.util.*;
public class getsum{
    static int fun(int a,int b){
        int carry=0;
        while(b>0){
            carry=(a&b);
            a=(a^b);
            b=carry<<1;
        }
        return a;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(fun(a,b));
    }
}