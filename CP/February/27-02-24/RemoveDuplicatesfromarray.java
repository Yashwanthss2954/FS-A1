/*Mr Ram is working in a factory, that factory manufactures items which are 
having unique code printed on each item. and machine prints unique codes on items 
in non-decreasing order, some times because of timing problem machine prints 
same number on items.Job of Ram is to remove such duplicates from the stock.

And order of the items should not get distrubed after removal. 
Can you help ram to do this job easily with the help of a program. 

input format : an integer n
               n number of integer in non-decreasing order
output format : integers in non decreasing order without duplicates


Example 1:
input=10
0 0 1 1 2 2 3 3 4 5
output=0 1 2 3 4 5

Example 2:
input=8
1 2 3 4 5 6 7 8
output=1 2 3 4 5 6 7 8
*/

import java.util.*;
public class main{
    static void max(int n,int []a){
        int p1=0;
        int p2=1;
        while(p1!=n && p2!=n){
            if(a[p1]!=a[p2]){
                System.out.print(a[p1]+" ");
                p1 = p1 + 1;
                p2 = p2 + 1;
            }
            else if(a[p1]==a[p2]){
                p1 = p1 + 1;
                p2 = p2 + 1;
            }
        }
        System.out.print(a[n-1]);
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        max(n,a);
    }
}