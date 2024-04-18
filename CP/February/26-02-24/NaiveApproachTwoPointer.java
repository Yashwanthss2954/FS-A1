/*Java Program Illustrating Naive Approach to
Find if There is a Pair in A[0..N-1] with Given Sum  

This program is to find the existence of pair of integers whose sum is equal to the given sum value or not.


input format : an integer (n->length of array)
              n number of integers
              an Integer (k -> sum value)
output format :either 1 or 0

example 1:
input=5
1 2 3 4 5
7
output=1

example 2:
input=6
1 2 3 4 5 6
25
output=0

*/

import java.util.*;
public class main{
    static int max(int n,int k,int []a){
        int l=0,r=a.length-1,s=0;
        // while(l<r){
        //     s=a[l]+a[r];
        //     if(s==k){
        //         return 1;
        //     }
        //     else if(s>k){
        //         r--;
        //     }
        //     else{
        //         l++;
        //     }
        // }
        // return 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]+a[j]==k){
                    return 1;
                }
            }
        }
        return 0;
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
