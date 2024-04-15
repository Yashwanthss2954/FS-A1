/*
Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110


=== testcases ===
case =1
input =24
output ="1001"

case =2
input =45
output ="01110"

case =3
input =234
output ="1101011"

case =4
input =3445
output ="10101110110"

case =5
input =2445
output ="00110001110"

case =6
input =24523
output ="01111111001100"

case =7
input =536245
output ="0000010111010110110"

case =8
input =45675463
output ="0101110001111001111001000"

case =9
input =287536245
output ="0001001000110111010001110110"

case =10
input =1345675463
output ="010000001101010110000011001000"


*/
import java.util.*;

class EncodeNumber {
    public String encode(int num) 
	{
        StringBuilder sb = new StringBuilder();

        double cur = Math.log(num + 1) / Math.log(2);
		System.out.println(Math.log(num + 1) + " " + Math.log(2) + " " + cur);

        int bits = (int)(Math.floor(cur));
		System.out.println("bits " + bits);

        int offset = num + 1 - (int)(Math.pow(2, bits));

		System.out.println("offset " + offset);

        while (offset > 0) 
		{
            sb.append(offset % 2);
            offset /= 2;
        }
		System.out.println("sb1 " + sb.toString());
        int len = sb.length();
        for (int i = len; i < bits; i++) {
            sb.append("0");
        }
		System.out.println("sb2 " + sb.toString());

        return sb.reverse().toString();
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		System.out.println(new EncodeNumber().encode(s));
	}
}