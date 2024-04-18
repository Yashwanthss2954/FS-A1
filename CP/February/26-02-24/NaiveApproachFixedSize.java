/*
Java code O(n*k) solution for finding maximum sum of
a subarray of size k

input format : number of elements (n)
              n number of integers
              size of the ranges  (k (i.e size of subarray))
output format : integer sum

Example 1:
input = 9
1 2 3 4 5 6 7 8 9
2
output=17

Example 2:
input=9
9 1 2 8 7 4 5 6 3
2
output=15
*/
import java.util.*;
public class main{
    static int max(int n,int k,int []arr){
        int m=Integer.MIN_VALUE,s=0;
        for(int i=0;i<n-k+1;i++){
            s=0;
            for(int j=0;j<k;j++){
                s+=arr[i+j];
                m=Math.max(s,m);
            }
        }
        return m;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(max(n,k,arr));
    }
}





