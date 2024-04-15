/*Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1

---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13
*/

import java.util.*;
public class closestpair{
    static void fun(int n1,int[]a1,int n2,int[]a2, int t){
        int l=0;
        int r=n2-1;
        int rl=0;
        int rr=0;
        int m=Integer.MAX_VALUE;
        while(l<n1 && r>=0){
            if(Math.abs((a1[l]+a2[r])-t)<m){
                rl=l;
                rr=r;
                m=Math.abs((a1[l]+a2[r])-t);
            }
            else if(a1[l]+a2[r]>t){
                r--;
            }
            else{
                l++;
            }
        }
        System.out.print(a1[rl]+","+a2[rr]);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int []a1=new int[n1];
        for(int i=0;i<n1;i++){
            a1[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int []a2=new int[n1];
        for(int i=0;i<n2;i++){
            a2[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        fun(n1,a1,n2,a2,t);
    }
}
