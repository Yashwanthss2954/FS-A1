/*Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.

For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }. The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.

Note:
     1. if more than one index is possible print the smallest index value
     2. if no replacement is possible then print -1

Example:
input=10
0 0 1 0 1 1 1 0 1 1
output=7

Example 2:
input=12
1 1 1 1 1 1 1 1 1 1 1 0
output=11

Example 3:
input=12
0 0 0 0 0 0 0 0 0 0 0 0
output=0

Example 4:
input=10
1 1 1 1 1 1 1 1 1 1
output=-1
 */

import java.util.*;
class indexofzero {
    static int func(int n, int a[]) {
        int l = 0;
        int r = 0;
        int k = -1;
        int m = -1;
        int z = 0;
        int c = 0;
        int u = -1;
        while (r < n) {
            if (a[r] == 0) {
                z++;
                if (z <= 1) {
                    k = r;
                } else {
                    l = k + 1;
                    r=k;
                    z = 0;
                }
            }
            c = r - l + 1;
            r++;
            if (c > m && z<=1) {
                m = c;
                u = k;
            }
        }
        return u;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(func(n, a));
    }
}
 