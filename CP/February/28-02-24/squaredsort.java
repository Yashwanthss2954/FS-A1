/*Master sathya is doing his mathematics home work, in that one problem statement is as follows,
there are list of non-decreasing temperatures values (only integers) are given he need to find the squares of each temperature and return that list in non-decreasing order. Can you help him with a program.

input format: an integer (n)
              n number of integers in sorted order
output format: List of n integers in sorted order

Example 1:

Input:5
-4 -1 0 3 10
Output: [0, 1, 9, 16, 100]

Example 2:
input=8
1 2 3 4 5 6 7 8
output =[1, 4, 9, 16, 25, 36, 49, 64]

 */
import java.util.*;
public class squaredsort{
    static ArrayList<Integer> fun(int n,int []a){
        ArrayList<Integer> ar=new ArrayList<>();
        int l1=0;
        int l2=n-1;
        while(l1<=l2){
            if(Math.abs(a[l1])>Math.abs(a[l2])){
                ar.add(a[l1]*a[l1]);
                l1++;
            }
            else{
                ar.add(a[l2]*a[l2]);
                l2--;
            }
        }
        Collections.reverse(ar);
        return ar;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(fun(n,a));
    }
}