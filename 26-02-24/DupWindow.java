/* Given an integer array of nums and an integer window size, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Sample Input/output
------------------
input:
--------------
array size
array elements
X   
output:
-----------
true

Example 1:
Input: 4            
1 2 3 1  
3       
Output: false

case 2:
Input: 6
1 2 3 3 2 3
2
Output: true
*/

import java.util.*;
public class DupWindow{
    static boolean max(int n,int k,int []a){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++){
            if(!hm.containsKey(a[i])){
                hm.put(a[i],1);
            }
            else{
                return true;
            }
        }
        for(int i=k;i<n;i++){
            int f=a[i-k];
            if(hm.get(f)<=1){
                hm.remove(f);
            }
            if(!hm.containsKey(a[i])){
                hm.put(a[i],1);
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(max(n,k,a));
    }
}