/* There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

 

Example 1:

Input:
8
1 0 1 2 1 1 7 5
0 1 0 1 0 1 0 1
3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input:1
1
0
1
Output: 1
 

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.

6
3 1 4 6 8 2
0 0 1 1 0 1
4

7
2 3 1 5 6 3 8
0 1 0 1 0 1 0
2*/
import java.util.*;
public class bookstore{
    static int f(int n,int []a,int []b,int c){
        int res=0;
        int s=0;
        for(int i=0;i<c;i++){
            if(b[i]==0){
                res+=a[i];
            }
            else{
                s+=a[i];
            }
        }
        int sum=s;
        for(int i=c;i<n;i++){
            if(b[i-c]==1){
                sum+=a[i]-a[i-c];
            }
            else{
                res+=a[i];
            }
            s=Math.max(s,sum);
            
        }
        return res+s;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        int c=sc.nextInt();
        System.out.println(f(n,a,b,c));
    }
}