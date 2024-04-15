/*Input a number N.
Check whether its binary equivalent is Palindrome or not.

for Example
If N is 9
its binary equivalent is 1001 which is palindrome.

Return true if it is palindrome, false otherwise.

Test Cases
case=1
input=9
output=true

case=2
input=6
output=false
 */

 import java.util.*;
class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(BinPal(n));
    }

    public static boolean BinPal(int n) {
        int reversed = 0;
        int original = n;
        
        while (n > 0) {
            reversed = (reversed << 1) | (n & 1);
            n = n >> 1;
        }

        return original == reversed;
    }
}