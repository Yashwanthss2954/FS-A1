/*

perform left shift operation on giveninteger
Example 1:
input=1
output=2
4
8
16

Example 2:
input=5
output=10
20
40
80



*/
import java.util.*;
class LeftShift 
{
    private static int helper(int number, int i)
   {
        return number << i;// multiplies `number` with 2^i times.
    }
    public static void main(String[] args) 
   {
		Scanner sc=new Scanner(System.in);
		int number = sc.nextInt();
        System.out.println(number + " shifted 1 position left, yields to " + helper(number, 1));
        System.out.println(number + " shifted 2 positions left, yields to " + helper(number, 2));
        System.out.println(number + " shifted 3 positions left, yields to " + helper(number, 3));
        System.out.println(number + " shifted 4 positions left, yields to " + helper(number, 4));
    }
}
