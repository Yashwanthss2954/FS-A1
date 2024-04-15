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
public class NaiveApproach{
    public static int Max(int [] arr,int n,int k){
        int maxs=0;
        for(int i=0;i<n-k+1;i++){
            int sum=0;
            for(int j=0;j<k;j++){
                sum+=arr[i+j];
                maxs=Math.max(sum,maxs);
            }
        }
        return maxs;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(NaiveApproach.Max(arr,n,k));
    }
}