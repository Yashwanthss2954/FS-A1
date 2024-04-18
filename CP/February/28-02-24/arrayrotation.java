/*Given an array, rotate the array to the right by k steps, where k is non-negative.

Example:
[1, 2, 3, 4, 5, 6, 7] and k is 4, then the output should be [4, 5, 6, 7, 1, 2, 3].

input format: an integer (n)
              n number of space seperated integers
			  an integer k
output format : list of elements

Sample test cases:
case =1
input=7
1 2 3 4 5 6 7
4
output=[4, 5, 6, 7, 1, 2, 3]

case =2
input=9
1 2 3 4 5 6 7 8 9
4
output=[6, 7, 8, 9, 1, 2, 3, 4, 5] */

// import java.util.*;
// public class arrayrotation{
//     static void fun(int n,int[]a,int k){
//         int l1=0;
//         while(k>0){
//             int temp=a[k-1];
//             a[k-1]=a[l1];
//             a[l1]=temp;
//             l1++;
//             k--;
//         }
//         for(int i=0;i<n;i++){
//             System.out.println(a[i]);
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int []a=new int[n];
//         for(int i=0;i<n;i++){
//             a[i]=sc.nextInt();
//         }
//         int k=sc.nextInt();
//         fun(n,a,k);
//         for(int i=0;i<n;i++){
//             System.out.println(a[i]);
//         }
//     }
// }
import java.util.*;
public class arrayrotation {
    static void fun(int s, int[] a, int e) {
        while (s < e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        k = k % n;
        fun(0, a, n - 1);
        fun(0, a, k - 1);
        fun(k, a, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
