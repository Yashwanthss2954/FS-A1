/*Return the maximum subarray sum of all the height subarrays that meet the 
conditions. If no heights subarray meets the conditions, return 0.

- A subarray is a contiguous non-empty sequence of elements within an array.

Input Format:
-------------
Line-1: Two space separated integers, N and L
Line-2: N space separated integers, height[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 3
7 7 7 1 5 4 2

Sample Output-1:
----------------
13

Explanation: 
------------
The subarrays of length 3 of height array are:
    - [7,7,7] this subarray does not meet the requirement because the 7 is repeated.
    - [7,7,1] this subarray does not meet the requirement because the 7 is repeated.
    - [7,1,5] this subarray meets the requirements and its sum is 13.
    - [1,5,4] this subarray meets the requirements and its sum is 10.
    - [5,4,2] this subarray meets the requirements and its sum is 11. 

Return 13 because it is the maximum subarray sum of all the subarrays 
that meet the conditions


Sample Input-2:
---------------
3 3
7 7 7

Sample Output-2:
----------------
0

Explanation:
------------
The subarrays of length 3 of height array are:
- [7,7,7] which does not meet the requirements because the element 7 is repeated.

Return 0 because no subarrays meet the conditions.
*/



import java.util.*;
public class MaxSubArraySum{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int s=0,m=0;
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<k;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            s+=arr[i];
        }
        if(hm.size()==k){
            m=s;
        }
        for(int i=k;i<n;i++){
            s+=arr[i]-arr[i-k];
            int r=arr[i-k];
            if(hm.get(r)<=1){
                hm.remove(r);
            }
            else{
                hm.put(r,hm.get(r)-1);
            }
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            if(hm.size()==k){
                m=Math.max(s,m);
            }
        }
        System.out.println(m);
    }
}
