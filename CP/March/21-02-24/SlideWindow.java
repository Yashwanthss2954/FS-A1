/*
Input 'n', an array of length ‘n’ and a number ‘k’. 
Find the maximum sum of ‘k’ consecutive elements inside the array.

Sample Test Cases:

Test Case-1
input=4
2 3 4 5
2
output=9

Test Case-2
input=9
1 4 2 10 2 3 1 0 20
4
output=24

*/

import java.util.*;
public class SlideWindow{
    public static int Max(int []arr,int n,int k){
        if(k>n){
            return -1;
        }
        int msum=0;
        for(int i=0;i<k;i++){
            msum+=arr[i];
        }
        int sum=msum;
        for(int i=k;i<n;i++){
            sum+=arr[i]-arr[i-k];
            msum=Math.max(sum,msum);
        }
        return msum;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(SlideWindow.Max(arr,n,k));
    }
}